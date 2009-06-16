// WorldModelCreator.java
package org.eclipse.stem.tests.util;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.tests.util.CountryDirectoryUtilities.CountryCode;
import org.eclipse.stem.tests.util.CountryModelCreator.CountryModelRecord;
import org.eclipse.stem.tests.util.CountryModelCreator.ModelRecord;

/**
 * This class creates models of the world at various resolutions.
 */
public class WorldModelCreator {

	/**
	 * The name of the directory that contains "model" sub-directories
	 */
	private static final String WORLD_DIR = "world";

	/**
	 * This is the format string for the identifier of a country graph or model
	 * file
	 */
	public static final String IDENTIFIER_FORMAT = "{0}/" + WORLD_DIR
			+ "/{1}/{2}";

	/**
	 * This is the path to the country models directory
	 */
	public static final String WORLD_MODEL_PATH = CountryGraphCreator.ROOT_OUTPUT_DIR
			+ File.separator
			+ CountryModelCreator.MODEL_OUTPUT_DIR
			+ File.separator + WORLD_DIR;

	private static final String WORLD = "World";

	/**
	 * The identifier used in world model record instances. It is like a
	 * {@link CountryCode} , but for the entire world.
	 */
	private static final String WORLD_ID = "WORLD";

	/**
	 * This is the id of the extension point extended by "world" models that are
	 * plugged into STEM
	 */
	public static final String ID_MODEL_WORLD_CATEGORY = CountryModelCreator.ID_MODEL_POLITICAL_CATEGORY
			+ "." + WORLD.toLowerCase();

	/**
	 * @param args
	 *            none
	 */
	public static void main(final String[] args) {

		final CountryModelCreator cmc = new CountryModelCreator();

		final List<List<CountryModelRecord>> modelsByAdminLevel = cmc
				.createCountryModels2();

		final WorldModelCreator wmc = new WorldModelCreator();

		// Create the world models by each administration level
		final List<WorldModelRecord> worldModelRecords = wmc
				.createWorldModels(modelsByAdminLevel);
		try {
			wmc.serializeWorldModels(worldModelRecords, WORLD_MODEL_PATH);

			final File worldModelExtensionFile = new File(WORLD_MODEL_PATH
					+ CountryGraphCreator.GRAPH_EXTENSION_POINT_FILE_NAME);
			final File worldModelPluginPropertiesFile = new File(
					WORLD_MODEL_PATH
							+ CountryGraphCreator.GRAPH_PLUGIN_PROPERTIES_POINT_FILE_NAME);

			final BufferedWriter worldModelOut = new BufferedWriter(
					new FileWriter(worldModelExtensionFile));

			final BufferedWriter pluginOut = new BufferedWriter(new FileWriter(
					worldModelPluginPropertiesFile));

			// Create a snippet of xml that can be included in a plugin.xml file
			// to plug into STEM the models we just serialized.
			wmc.generateModelExtensionPointXML(worldModelRecords,
					worldModelOut, pluginOut);
		} // try
		catch (final IOException e) {
			e.printStackTrace();
		}
	} // main

	/**
	 * Given a collection of country models grouped by administration level,
	 * create a higher world model for each level that contains all of the
	 * country models for that level.
	 * 
	 * @param modelsByAdminLevel
	 *            a list ordered by administration level of lists of model
	 *            records for each administration level
	 * @return a list of world model records, one for each administration level.
	 */
	@SuppressWarnings("unchecked")
	public List<WorldModelRecord> createWorldModels(
			final List<List<CountryModelRecord>> modelsByAdminLevel) {
		final List<WorldModelRecord> retValue = new ArrayList<WorldModelRecord>();

		for (int adminLevel = 0; adminLevel < modelsByAdminLevel.size(); adminLevel++) {

			final Model worldModel = ModelFactory.eINSTANCE.createModel();
			final DublinCore dc = worldModel.getDublinCore();
			dc.populate();
			dc.setTitle("World Model (Level " + adminLevel + ", "
					+ modelsByAdminLevel.get(adminLevel).size() + " models)");

			for (final CountryModelRecord modelRecord : modelsByAdminLevel
					.get(adminLevel)) {
				worldModel.getModels().add(modelRecord.getModel());
			} // foreach ModelRecord at adminLevel

			final WorldModelRecord worldModelRecord = new WorldModelRecord(
					worldModel, WORLD_ID, adminLevel);
			worldModel.setURI(URI.createURI(MessageFormat.format(
					IDENTIFIER_FORMAT,
					CountryGraphCreator.GEOGRAPHY_FILE_URI_PREFIX, WORLD_ID,
					worldModelRecord.getSerializationFileName())));

			retValue.add(worldModelRecord);
		} // for adminLevel

		final WorldModelRecord multiLevelWorldModel = createMultiLevelWorld(retValue);
		retValue.add(multiLevelWorldModel);
		return retValue;
	} // createWorldModels

	/**
	 * Create one world model composed of the models of the world at each
	 * administration level
	 * 
	 * @param worldModels
	 *            list of models ordered by administration level
	 * @return a model composed of the sub-models for the world at each level
	 */
	@SuppressWarnings("unchecked")
	public WorldModelRecord createMultiLevelWorld(
			final List<WorldModelRecord> worldModels) {

		final Model worldModel = ModelFactory.eINSTANCE.createModel();

		final WorldModelRecord retValue = new WorldModelRecord(worldModel,
				WORLD_ID, 0);

		for (final WorldModelRecord modelRecord : worldModels) {
			worldModel.getModels().add(
					(Model) EcoreUtil.copy(modelRecord.getModel()));
			retValue.addAdminLevels(modelRecord.getAdminLevels());
		}

		final DublinCore dc = worldModel.getDublinCore();
		dc.populate();
		dc.setTitle("World Model (Levels "
				+ retValue.getAdminLevelsAsString(", ") + ")");
		final String uriString = MessageFormat.format(IDENTIFIER_FORMAT,
				CountryGraphCreator.GEOGRAPHY_FILE_URI_PREFIX, WORLD_ID,
				retValue.getSerializationFileName());
		dc.setIdentifier(uriString);
		worldModel.setURI(URI.createURI(uriString));

		return retValue;
	} // createMultiLevelWorld

	/**
	 * @param worldModels
	 * @param uriPathString
	 *            the path to the root of the folder to serialize the models to
	 * @throws IOException
	 */
	private void serializeWorldModels(final List<WorldModelRecord> worldModels,
			final String uriPathString) throws IOException {
		for (final WorldModelRecord modelRecord : worldModels) {
			modelRecord.serialize(uriPathString);
		} // for each model record
	} // serializeWorldModels

	/**
	 * @param countryNodeGraphs
	 *            a list of maps of models of nodes for countries for each
	 *            adminstration level
	 * @param modelOut
	 *            the output writer for the plugin.xml file contents
	 * @param pluginOut
	 *            the output writer for the plugin.properties file contents
	 */
	private void generateModelExtensionPointXML(
			final List<WorldModelRecord> worldModelRecords,
			final Writer modelOut, final Writer pluginOut) {

		// The dublin core instances of the models likely share common
		// attributes, we can avoid duplicate entries in the files we generate
		// by finding the duplicate entries and only generating a single key for
		// the generated plugins file content.
		final Map<String, String> dcValueKeyMap = new HashMap<String, String>();

		try {
			modelOut.write("<!-- Generated content.  Do not modify -->\n");

			modelOut.write(MessageFormat.format(
					CountryGraphCreator.XML_EXTENSION_POINT_OPEN,
					new Object[] { Constants.ID_MODEL_EXTENSION_POINT }));
			modelOut.write("\n");

			pluginOut
					.write("#Model NLS Keys.  Automatically generated, do not modify. "
							+ Calendar.getInstance().getTime()
							+ " "
							+ System.getProperty("user.name") + "\n");

			// World Model
			CountryGraphCreator.outputCategory(ID_MODEL_WORLD_CATEGORY, WORLD,
					CountryModelCreator.ID_MODEL_POLITICAL_CATEGORY,
					CountryModelCreator.NLS_CATEGORY_KEY_FORMAT, modelOut,
					pluginOut);

			for (final WorldModelRecord worldModelRecord : worldModelRecords) {
				CountryGraphCreator.outputDublinCore(worldModelRecord,
						ID_MODEL_WORLD_CATEGORY, dcValueKeyMap, modelOut,
						pluginOut);
			} // for each world model record

			modelOut.write(CountryGraphCreator.XML_EXTENSION_POINT_CLOSE);
			modelOut.close();
			pluginOut.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}

	} // generateModelExtensionPointXML

	/**
	 * This class contains a world model and its metadata.
	 */
	public static class WorldModelRecord extends ModelRecord {

		/**
		 * @param model
		 *            the world model
		 * @param id
		 *            the identifier of the model
		 * @param adminLevel
		 *            the administration levels contained in the model
		 */
		public WorldModelRecord(final Model model, final String id,
				final int adminLevel) {
			this(model, id, Collections.singletonList(Integer
					.valueOf(adminLevel)));
		} // WorldModelRecord

		/**
		 * @param model
		 *            the world model
		 * @param id
		 *            the identifier of the model
		 * @param adminLevels
		 *            the administration levels contained in the model
		 */
		public WorldModelRecord(final Model model, final String id,
				final List<Integer> adminLevels) {
			super(model, id, adminLevels);
		} // WorldModelRecord

		/**
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.Record#getType()
		 */
		@Override
		public String getType() {
			return "world";
		} // getType

	} // WorldModelRecord
} // WorldModelCreator
