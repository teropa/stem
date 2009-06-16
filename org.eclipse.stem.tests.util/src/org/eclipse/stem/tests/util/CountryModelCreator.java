// CountryModelCreator.java
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
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.tests.util.CountryDirectoryUtilities.CountryCode;
import org.eclipse.stem.tests.util.CountryGraphCreator.DataType;
import org.eclipse.stem.tests.util.CountryGraphCreator.GraphRecord;
import org.eclipse.stem.tests.util.CountryGraphCreator.Record;

/**
 * This class is used to auotmate the generation of models in STEM.
 */
public class CountryModelCreator {

	/**
	 * This is the name of the directory under the
	 * {@link CountryGraphCreator#ROOT_OUTPUT_DIR} that contains the directories
	 * that contain the models that define the geographies and features of
	 * countries.
	 */
	public static final String MODEL_OUTPUT_DIR = "models";

	/**
	 * This is the path to the country models directory
	 */
	public static final String COUNTRY_MODEL_PATH = CountryGraphCreator.ROOT_OUTPUT_DIR
			+ File.separator
			+ MODEL_OUTPUT_DIR
			+ File.separator
			+ CountryGraphCreator.COUNTRY_DIR;

	/**
	 * This is the id of the extension point extended by graphs that are plugged
	 * into STEM
	 */
	// public static final String ID_MODEL_EXTENSION_POINT = Constants.ID_ROOT
	// + ".core.model";
	/**
	 * This is the id of the top-level STEM category for graphs
	 */
	public static final String ID_STEM_MODEL_CATEGORY = Constants.ID_ROOT
			+ ".core.model";

	/**
	 * This is the id of the extension point extended by models with geographic
	 * information that are plugged into STEM
	 */
	public static final String ID_MODEL_GEOGRAPHY_CATEGORY = ID_STEM_MODEL_CATEGORY
			+ "." + CountryGraphCreator.GEOGRAPHY.toLowerCase();

	/**
	 * This is the id of the extension point extended by models with geographic
	 * political information that are plugged into STEM
	 */
	public static final String ID_MODEL_POLITICAL_CATEGORY = ID_MODEL_GEOGRAPHY_CATEGORY
			+ "." + CountryGraphCreator.POLITICAL.toLowerCase();

	/**
	 * This is the id of the extension point extended by models with geographic
	 * political information that are plugged into STEM
	 */
	public static final String ID_MODEL_COUNTRIES_CATEGORY = ID_MODEL_POLITICAL_CATEGORY
			+ "." + CountryGraphCreator.COUNTRIES.toLowerCase();

	/**
	 * This is the format of the generated NLS keys for categories
	 */
	public static final String NLS_CATEGORY_KEY_FORMAT = "_UI_{0}_model_category";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Now create the graphs
		final List<CountryCode> countryCodes = CountryDirectoryUtilities
				.getAllCountryCodes();
		Collections.sort(countryCodes);

		final CountryModelCreator cmc = new CountryModelCreator();
		final Map<CountryCode, List<CountryModelRecord>> countryModels = cmc
				.createCountryModels();
		try {
			cmc.serializeCountryModels(countryModels, COUNTRY_MODEL_PATH);

			List<Map<CountryCode, List<CountryModelRecord>>> modelRecords = new ArrayList<Map<CountryCode, List<CountryModelRecord>>>();
			modelRecords.add(countryModels);

			int maxAdminLevel = 0;
			maxAdminLevel = Math.max(maxAdminLevel,
					getMaxAdminLevel(countryModels));

			final File modelExtensionFile = new File(COUNTRY_MODEL_PATH
					+ CountryGraphCreator.GRAPH_EXTENSION_POINT_FILE_NAME);
			final File modelPluginPropertiesFile = new File(
					COUNTRY_MODEL_PATH
							+ CountryGraphCreator.GRAPH_PLUGIN_PROPERTIES_POINT_FILE_NAME);

			final BufferedWriter modelOut = new BufferedWriter(new FileWriter(
					modelExtensionFile));

			final BufferedWriter pluginOut = new BufferedWriter(new FileWriter(
					modelPluginPropertiesFile));

			// Create a snippet of xml that can be included in a plugin.xml file
			// to plug into STEM the graphs we just serialized.
			cmc.generateModelExtensionPointXML(modelRecords, countryCodes,
					maxAdminLevel, modelOut, pluginOut);
		} // try
		catch (IOException e) {
			e.printStackTrace();
		}
	} // main

	/**
	 * @param models
	 *            a map between country code and list of model records for the
	 *            country
	 * @param uriPathString
	 *            the path to the root of the folder to serialize the models to
	 * @throws IOException
	 */
	private void serializeCountryModels(
			final Map<CountryCode, List<CountryModelRecord>> models,
			final String uriPathString) throws IOException {

		for (CountryCode countryCode : models.keySet()) {
			for (CountryModelRecord modelRecord : models.get(countryCode)) {
				modelRecord.serialize(uriPathString);
			} // for each model record for each country
		} // for each country code

		//		
		// for (CountryCode countryCode : graphs.keySet()) {
		// for (GraphRecord graphRecord : graphs.get(countryCode)) {
		// graphRecord.serialize(uriPathString);
		// } // for each graph record for each country
		// } // for each country code

	} // serializeCountryModels

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
			final List<Map<CountryCode, List<CountryModelRecord>>> modelRecords,
			List<CountryCode> countryCodes, final int maxAdminLevel,
			final Writer modelOut, final Writer pluginOut) {

		// The dublin core instances of the models likely share common
		// attributes, we can avoid duplicate entries in the files we generate
		// by finding the duplicate entries and only generating a single key for
		// the generated plugins file content.
		final Map<String, String> dcValueKeyMap = new HashMap<String, String>();

		// We also don't want to generate duplicate country categories
		final Map<String, String> countryCategories = new HashMap<String, String>();

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

			// Output the categories that make up the hierarchy for the graph
			// plugins (all except for the country categories which we output
			// below)
			final String[] levelCategoryId = outputCategories(
					maxAdminLevel + 1, modelOut, pluginOut);

			for (CountryCode countryCode : countryCodes) {
				for (Map<CountryCode, List<CountryModelRecord>> modelRecordMap : modelRecords) {
					List<CountryModelRecord> foo = modelRecordMap
							.get(countryCode);
					// Anything in the list?
					if (foo != null) {
						// Yes
						for (CountryModelRecord modelRecord : modelRecordMap
								.get(countryCode)) {
							outputModelRecord(modelRecord, dcValueKeyMap,
									countryCategories, levelCategoryId,
									modelOut, pluginOut);
						}
					}

				} // for each type of graph Record
			} // for each country code

			modelOut.write(CountryGraphCreator.XML_EXTENSION_POINT_CLOSE);
			modelOut.close();
			pluginOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// generateModelExtensionPointXML

	/**
	 * @param numLevels
	 *            the number of administration levels to generate categories for
	 * @param modelOut
	 *            the output writer for the plugin.xml file contents
	 * @param pluginOut
	 *            the output writer for the plugin.properties file contents
	 * @return an array indexed by administration level of the category ideas of
	 *         the different administration levels
	 * @throws IOException
	 *             if there is a problem writing to the output writers
	 */
	private String[] outputCategories(final int numLevels,
			final Writer modelOut, final Writer pluginOut) throws IOException {
		// The categories
		// STEM
		CountryGraphCreator.outputCategory(ID_STEM_MODEL_CATEGORY,
				CountryGraphCreator.STEM, "/", NLS_CATEGORY_KEY_FORMAT,
				modelOut, pluginOut);

		// Geography
		CountryGraphCreator.outputCategory(ID_MODEL_GEOGRAPHY_CATEGORY,
				CountryGraphCreator.GEOGRAPHY, ID_STEM_MODEL_CATEGORY,
				NLS_CATEGORY_KEY_FORMAT, modelOut, pluginOut);

		// Political
		CountryGraphCreator.outputCategory(ID_MODEL_POLITICAL_CATEGORY,
				CountryGraphCreator.POLITICAL, ID_MODEL_GEOGRAPHY_CATEGORY,
				NLS_CATEGORY_KEY_FORMAT, modelOut, pluginOut);

		// Country
		CountryGraphCreator.outputCategory(ID_MODEL_COUNTRIES_CATEGORY,
				CountryGraphCreator.COUNTRIES, ID_MODEL_POLITICAL_CATEGORY,
				NLS_CATEGORY_KEY_FORMAT, modelOut, pluginOut);

		final String[] levelCategoryId = new String[numLevels];

		// Level
		for (int adminLevel = 0; adminLevel < numLevels; adminLevel++) {
			// Level category
			levelCategoryId[adminLevel] = ID_MODEL_COUNTRIES_CATEGORY + "."
					+ CountryGraphCreator.LEVEL.toLowerCase() + adminLevel;

			CountryGraphCreator.outputCategory(levelCategoryId[adminLevel],
					CountryGraphCreator.LEVEL + adminLevel,
					ID_MODEL_COUNTRIES_CATEGORY, NLS_CATEGORY_KEY_FORMAT,
					modelOut, pluginOut);
		} // for adminLevel

		modelOut.write("\n");
		pluginOut.write("\n");
		return levelCategoryId;
	} // outputCategories

	/**
	 * @param modelRecord
	 * @param dcValueKeyMap
	 * @param countryCategories
	 * @param levelCategoryId
	 * @param modelOut
	 * @param pluginOut
	 * @throws IOException
	 */
	private void outputModelRecord(ModelRecord modelRecord,
			Map<String, String> dcValueKeyMap,
			Map<String, String> countryCategories, String[] levelCategoryId,
			Writer modelOut, Writer pluginOut) throws IOException {
		// Make everything come out in alphabetical order

		final String countryCodeString = modelRecord.getId().toLowerCase();
		final String countryCategoryId = levelCategoryId[modelRecord
				.getMaxAdminLevel()]
				+ "." + countryCodeString;

		// Have we seen this country category id before?
		if (countryCategories.get(countryCategoryId) == null) {
			// No
			// Create a category for the country
			modelOut.write(MessageFormat.format(
					CountryGraphCreator.XML_CATEGORY_ELEMENT_OPEN,
					new Object[] { countryCategoryId, modelRecord.getId(),
							levelCategoryId[modelRecord.getMaxAdminLevel()] }));
			modelOut.write("\n");
			// ...and remember we did so we don't do it again
			countryCategories.put(countryCategoryId, countryCategoryId);
		} // if we haven't seen this category id before

		// pluginOut.write("# Dublin Core for "
		// + graphRecord.getCountryCode().toString() + "\n");
		// // We don't NLS the ISO30166 alpha-3 codes

		CountryGraphCreator.outputDublinCore(modelRecord, countryCategoryId,
				dcValueKeyMap, modelOut, pluginOut);

	} // outputModelRecord

	/**
	 * @return a mapping between country code and a list of the models for the
	 *         country. The models are of mixed administration levels.
	 */
	public Map<CountryCode, List<CountryModelRecord>> createCountryModels() {
		final Map<CountryCode, List<CountryModelRecord>> retValue = new HashMap<CountryCode, List<CountryModelRecord>>();

		final List<CountryCode> countryCodes = CountryDirectoryUtilities
				.getAllCountryCodes();
		Collections.sort(countryCodes);

		final CountryGraphCreator cgc = new CountryGraphCreator();

		Map<CountryCode, List<GraphRecord>> nodeGraphs = cgc
				.createGraphRecords(countryCodes, DataType.node);

		Map<CountryCode, List<GraphRecord>> areaGraphs = cgc
				.createGraphRecords(countryCodes, DataType.area);

		for (CountryCode countryCode : countryCodes) {
			List<GraphRecord> nodeGraphRecords = nodeGraphs.get(countryCode);
			List<GraphRecord> areaGraphRecords = areaGraphs.get(countryCode);

			// Find the maximum adminstration level we're working with
			final int maxNodeAdminLevel = nodeGraphRecords != null ? CountryGraphCreator
					.getMaxAdminLevel(nodeGraphRecords)
					: -1;
			final int maxAreaAdminLevel = areaGraphRecords != null ? CountryGraphCreator
					.getMaxAdminLevel(areaGraphRecords)
					: -1;
			int maxAdminLevel = Math.max(maxAreaAdminLevel, maxNodeAdminLevel);

			// Create one country model for each administration level
			final List<CountryModelRecord> countryModels = new ArrayList<CountryModelRecord>();
			for (int adminLevel = 0; adminLevel < maxAdminLevel + 1; adminLevel++) {

				// Did we get nodes?
				if (nodeGraphRecords == null) {
					// No
					System.out.println("Skipping country \""
							+ countryCode.toString() + "\" at level \""
							+ adminLevel + "\" because there are no nodes");
					continue;
				}
				// Did we get area labels?
				if (areaGraphRecords == null) {
					// No
					System.out.println("Skipping country \""
							+ countryCode.toString() + "\" at level \""
							+ adminLevel
							+ "\" because there are no area labels");
					continue;
				}

				final List<GraphRecord> modelRecords = new ArrayList<GraphRecord>();
				final GraphRecord nodeGraph = getByAdminLevel(adminLevel,
						nodeGraphRecords);
				final GraphRecord areaGraph = getByAdminLevel(adminLevel,
						areaGraphRecords);
				modelRecords.add(nodeGraph);
				modelRecords.add(areaGraph);
				countryModels.add(new CountryModelRecord(createModel(
						countryCode, adminLevel, modelRecords,
						CountryGraphCreator.GEOGRAPHY_FILE_URI_PREFIX),
						countryCode, adminLevel));
			} // for adminLevel

			// Any country models created?
			if (countryModels.size() > 0) {
				// Yes
				retValue.put(countryCode, countryModels);
			}

		} // for each country code

		return retValue;
	} // createCountryModels

	/**
	 * Create the country models, but organize them by administration level
	 * 
	 * @return a list of lists of ModelRecord's, the 0'th element of the list
	 *         contains a list of models at administration level 0
	 */
	public List<List<CountryModelRecord>> createCountryModels2() {
		final Map<CountryCode, List<CountryModelRecord>> countryModels = createCountryModels();

		// Reorganize the models by administration level
		final int maxAdminLevel = getMaxAdminLevel(countryModels);
		List<List<CountryModelRecord>> retValue = new ArrayList<List<CountryModelRecord>>();
		for (int adminLevel = 0; adminLevel < maxAdminLevel + 1; adminLevel++) {
			retValue.add(new ArrayList<CountryModelRecord>());
		} // for adminLevel

		for (Entry<CountryCode, List<CountryModelRecord>> entry : countryModels
				.entrySet()) {
			for (CountryModelRecord modelRecord : entry.getValue()) {
				retValue.get(modelRecord.getMaxAdminLevel()).add(modelRecord);
			} // foreach ModelRecord
		} // foreach countryModels.entrySet

		return retValue;
	} // createCountryModels2

	/**
	 * @param countryCode
	 * @param adminLevel
	 * @param graphRecords
	 * @param dataFileURIPrefix
	 * @return a model with all of the graphs added
	 */
	@SuppressWarnings("unchecked")
	private Model createModel(final CountryCode countryCode,
			final int adminLevel, final List<GraphRecord> graphRecords,
			final String dataFileURIPrefix) {
		final Model retValue = ModelFactory.eINSTANCE.createModel();
		final DublinCore dc = retValue.getDublinCore();
		dc.populate();
		dc.setTitle(CountryDirectoryUtilities.getCountryName(countryCode)
				+ " Model (Level " + adminLevel + ", " + graphRecords.size()
				+ " graphs)");
		// dc.setSource(nonDataProperties.get(SOURCE_PROPERTY));

		retValue.setURI(URI.createURI(MessageFormat.format(
				CountryGraphCreator.IDENTIFIER_FORMAT, dataFileURIPrefix,
				countryCode, countryCode.toString() + "_"
						+ Integer.toString(adminLevel), "model")));

		for (GraphRecord modelRecord : graphRecords) {
			// A null value?
			if (modelRecord != null) {
				// No
				retValue.getGraphs().add(modelRecord.getGraph());
			}
		} // for each node data

		return retValue;
	} // createModel

	/**
	 * @param graphRecords
	 *            a list of GraphRecords to search
	 * @return the first GraphRecord that matches the administration level or
	 *         null if not found
	 */
	private GraphRecord getByAdminLevel(final int adminLevel,
			List<GraphRecord> nodeGraphRecords) {
		GraphRecord retValue = null;
		for (GraphRecord record : nodeGraphRecords) {
			// Is this at the right admin level?
			if (record.getAdminLevel() == adminLevel) {
				// Yes
				retValue = record;
			}
		}
		return retValue;
	} // getByAdminLevel

	/**
	 * @param models
	 * @return the maximum administration level found
	 */
	public static int getMaxAdminLevel(
			Map<CountryCode, List<CountryModelRecord>> models) {
		int maxAdminLevel = 0;
		for (List<CountryModelRecord> list : models.values()) {
			maxAdminLevel = Math.max(maxAdminLevel, getMaxAdminLevel(list));
		} // for
		return maxAdminLevel;
	} // getMaxAdminLevel

	/**
	 * @param modelRecords
	 * @return the maximum administration level found in all of the model
	 *         records
	 */
	public static int getMaxAdminLevel(List<CountryModelRecord> modelRecords) {
		int maxAdminLevel = 0;
		for (CountryModelRecord modelRecord : modelRecords) {
			maxAdminLevel = Math.max(maxAdminLevel, modelRecord
					.getMaxAdminLevel());
		}
		return maxAdminLevel;
	} // getMaxAdminLevel

	/**
	 * This class represents a model.
	 */
	abstract public static class ModelRecord extends Record {

		/**
		 * @param model
		 *            the model
		 * @param id
		 *            the id of the the model
		 * @param adminLevel
		 *            the administration level of the contents of the model
		 */
		public ModelRecord(final Model model, final String id,
				final int adminLevel) {
			this(model, id, Collections.singletonList(Integer
					.valueOf(adminLevel)));
		} // ModelRecord

		/**
		 * @param model
		 *            the model
		 * @param id
		 *            the id of the the model
		 * @param adminLevels
		 *            the administration level of the contents of the model
		 */
		public ModelRecord(final Model model, final String id,
				final List<Integer> adminLevels) {
			super(model, id, adminLevels);
		} // ModelRecord

		/**
		 * @return the model
		 */
		public final Model getModel() {
			return (Model) identifiable;
		} // getModel

		/**
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.Record#getOutputType()
		 */
		@Override
		public String getOutputType() {
			return "model";
		}
	} // ModelRecord

	/**
	 * This class represents a model of a country and its details.
	 */
	public static class CountryModelRecord extends ModelRecord {

		/**
		 * @param model
		 *            the model
		 * @param countryCode
		 *            the code of the country the model represents
		 * @param adminLevel
		 *            the administration level of the contents of the model
		 */
		public CountryModelRecord(final Model model,
				final CountryCode countryCode, final int adminLevel) {
			super(model, countryCode.toString(), adminLevel);
		} // CountryModelRecord

		/**
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.Record#getType()
		 */
		@Override
		public String getType() {
			return "country";
		}

	} // CountryModelRecord

} // CountryModelCreator
