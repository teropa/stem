// DiseaseScenarioGenerator.java
package org.eclipse.stem.internal.diseasemodels.scenarios;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.internal.data.ModelGenerator;
import org.eclipse.stem.internal.data.PluginFileGenerator;
import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.generatedplugin.Extension;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginFactory;
import org.eclipse.stem.internal.data.generatedplugin.Plugin;
import org.eclipse.stem.internal.data.generatedplugin.StemCategory;
import org.eclipse.stem.internal.data.geography.GeographyPluginFileGenerator;
import org.eclipse.stem.internal.data.geography.models.GeographyModelGenerator;
import org.eclipse.stem.internal.data.geography.specifications.AdminLevelSet;
import org.eclipse.stem.internal.data.geography.specifications.CountryGraphPropertyFileSpecification;
import org.eclipse.stem.internal.data.specifications.DiseaseModelScenarioSpecification;
import org.eclipse.stem.internal.data.specifications.IdentifiableSpecification;

/**
 * This class processes the generated disease model model files to create
 * Disease model scenarios.
 */
public class DiseaseModelScenarioGenerator extends GeographyModelGenerator {

	@SuppressWarnings("unused")
	private final ModelPackage modelPackage = ModelPackage.eINSTANCE;
	@SuppressWarnings("unused")
	private final StandardPackage standardPackage = StandardPackage.eINSTANCE;

	/**
	 * The id of the Geography category
	 */
	public static final String ID_SCENARIO_GEOGRAPHY_CATEGORY = PluginFileGenerator.ID_SCENARIO_CATEGORY
			+ ".geography"; //$NON-NLS-1$

	/**
	 * The id of the Political category
	 */
	public static final String ID_SCENARIO_GEOGRAPHY_POLITICAL_CATEGORY = ID_SCENARIO_GEOGRAPHY_CATEGORY
			+ ".political"; //$NON-NLS-1$

	/**
	 * The id of the Countries category
	 */
	public static final String ID_SCENARIO_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY = ID_SCENARIO_GEOGRAPHY_POLITICAL_CATEGORY
			+ ".countries"; //$NON-NLS-1$

	
	static {
		// This sets up the mapping between the "platform" URI's and the
		// projects in the file system.

		// CWD is the current working directory
		final String CWD = System.getProperty("user.dir"); //$NON-NLS-1$
		// WORKSPACE is the directory of the parent workspace
		final String WORKSPACE = CWD.substring(0, CWD
				.lastIndexOf(File.separator));

		// The path to the diseases project
		final String DISEASES_MODELS_MODELS_PROJECT_ROOT = WORKSPACE
				+ File.separator
				+ org.eclipse.stem.data.diseasemodels.models.Activator.PLUGIN_ID
				+ File.separator;

		// The path to the diseases project
		final String DISEASES_PROJECT_ROOT = WORKSPACE + File.separator
				+ org.eclipse.stem.diseases.Activator.PLUGIN_ID
				+ File.separator;

		final Map<String, URI> platformResourceMap = EcorePlugin
				.getPlatformResourceMap();

		// Register the mapping between the project id and the absolute path to
		// the project in the file system. This will be found later when
		// deserializing when the platform URI is mapped.

		platformResourceMap
				.put(
						org.eclipse.stem.data.diseasemodels.models.Activator.PLUGIN_ID,
						URI.createFileURI(DISEASES_MODELS_MODELS_PROJECT_ROOT));

		platformResourceMap.put(
				org.eclipse.stem.diseases.Activator.PLUGIN_ID, URI
						.createFileURI(DISEASES_PROJECT_ROOT));
	} // static

	/**
	 * @param args
	 *            the URI of the generated geography plugin.xml file
	 */
	public static void main(final String[] args) {
		// Is the plugin file specified?
		if (args.length == 0) {
			// Yes
			System.err.println("Missing specification of the plugin file"); //$NON-NLS-1$
		} // if
		else {

			final String GENERATED_FILES_PATH = args[0];
			final String diseaseModelModelProjecName = args[1];

			final String GENERATED_SCENARIOS_PATH = GENERATED_FILES_PATH
					+ File.separator + "resources" + File.separator + "data"; //$NON-NLS-1$ //$NON-NLS-2$

			final File diseaseModelModelPluginFile = new File(
					".."	+ File.separator + diseaseModelModelProjecName + File.separator + PluginFileGenerator.PLUGIN_XML_FILE_NAME); //$NON-NLS-1$
			final URI diseaseModelModelPluginFileURI = URI
					.createFileURI(diseaseModelModelPluginFile
							.getAbsolutePath());

			DiseaseModelScenarioGenerator dmsg = new DiseaseModelScenarioGenerator();

			final Map<ISOKey, List<DiseaseModelScenarioSpecification>> scenarioSpecifications = dmsg
					.processFiles2(diseaseModelModelPluginFileURI);

			for (final ISOKey isoKey : sortISOKeys(scenarioSpecifications)) {
				// Now serialize the Identifiables
				for (final IdentifiableSpecification gms : scenarioSpecifications
						.get(isoKey)) {
					try {
						gms.serialize(GENERATED_SCENARIOS_PATH);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				} // for gms
			} // for isoKey

			// Create the instance of plugin.xml that we'll serialize later
			final Plugin pluginxml = GeneratedpluginFactory.eINSTANCE
					.createPlugin();
			final Extension extension = GeneratedpluginFactory.eINSTANCE
					.createExtension();

			// Add the "scenario" extension point
			extension.setPoint(Constants.ID_SCENARIO_EXTENSION_POINT);

			// Add the categories to the extension
			addCatagoriesToExtension(extension);
			
			pluginxml.getExtensionelement().add(extension);

			// Now add the dublin core entries to the plugin.xml file for
			// each of the models
			for (final ISOKey isoKey : sortISOKeys(scenarioSpecifications)) {
				final StemCategory countryCategory = GeneratedpluginFactory.eINSTANCE
						.createStemCategory();
				final String COUNTRY_CATAGORY_STRING = ID_SCENARIO_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY
						+ "." + isoKey.toString().toLowerCase(); //$NON-NLS-1$
				countryCategory.setId(COUNTRY_CATAGORY_STRING);
				countryCategory.setName(isoKey.toString());
				countryCategory
						.setParentId(ID_SCENARIO_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY);
				extension.getCategories().add(countryCategory);
				for (final IdentifiableSpecification gms : scenarioSpecifications
						.get(isoKey)) {
					final DublinCore dc = GeneratedpluginFactory.eINSTANCE
							.createDublinCore();
					dc.setCategoryId(COUNTRY_CATAGORY_STRING);
					extension.getDublinCores().add(
							populateGeneratedDC(dc, gms.getDublinCore()));
				} // for gms
			} // for isoKey

			final URI TEMP_PLUGINXML_URI = URI
					.createFileURI(GENERATED_FILES_PATH + File.separator
							+ PluginFileGenerator.PLUGIN_XML_FILE_NAME);

			// Serialize the plugin.xml file.
			ModelGenerator.writePluginxml(pluginxml, TEMP_PLUGINXML_URI);

			// Create the plugin.properties file
			createPluginPropertties(GENERATED_FILES_PATH);
		} // else
	} // main

	private Map<ISOKey, List<DiseaseModelScenarioSpecification>> processFiles2(
			URI diseaseModelModelPluginFileURI) {

		final Map<ISOKey, List<DiseaseModelScenarioSpecification>> retValue = new HashMap<ISOKey, List<DiseaseModelScenarioSpecification>>();

		// Get the contents of the disease model model plug.xml file
		final Plugin diseaseModelPluginXML = getPluginxml(diseaseModelModelPluginFileURI);

		for (Extension extension : diseaseModelPluginXML.getExtensionelement()) {
			for (DublinCore dc : extension.getDublinCores()) {
				final Map<ISOKey, AdminLevelSet> isoKeyAdminLevelSetMap = CountryGraphPropertyFileSpecification
						.parseDublinCoreCoverageString(dc.getCoverage());
				final AdminLevelSet adminLevelSet = (AdminLevelSet) isoKeyAdminLevelSetMap
						.values().toArray()[0];
				final ISOKey isoKey = (ISOKey) isoKeyAdminLevelSetMap.keySet()
						.toArray()[0];

				List<DiseaseModelScenarioSpecification> temp = retValue
						.get(isoKey);
				if (temp == null) {
					temp = new ArrayList<DiseaseModelScenarioSpecification>();
					retValue.put(isoKey, temp);
				}
				temp.add(new DiseaseModelScenarioSpecification(isoKey,
						adminLevelSet, dc));
			} // for dc
		} // for Disease Models

		return retValue;
	} // processFiles2
	
	private static void addCatagoriesToExtension(final Extension extension) {

		final StemCategory scenarioCatagory = GeneratedpluginFactory.eINSTANCE
				.createStemCategory();
		scenarioCatagory.setId(PluginFileGenerator.ID_SCENARIO_CATEGORY);
		scenarioCatagory.setName("%" + PluginFileGenerator.UI_STEM_CATEGORY_NAME); //$NON-NLS-1$
		scenarioCatagory.setParentId("/"); //$NON-NLS-1$
		extension.getCategories().add(scenarioCatagory);

		final StemCategory geographyCatagory = GeneratedpluginFactory.eINSTANCE
				.createStemCategory();
		geographyCatagory.setId(ID_SCENARIO_GEOGRAPHY_CATEGORY);
		geographyCatagory
				.setName("%" + GeographyPluginFileGenerator.UI_GEOGRAPHY_CATEGORY_NAME); //$NON-NLS-1$
		geographyCatagory.setParentId(PluginFileGenerator.ID_SCENARIO_CATEGORY);
		extension.getCategories().add(geographyCatagory);

		final StemCategory politicalCatagory = GeneratedpluginFactory.eINSTANCE
				.createStemCategory();
		politicalCatagory.setId(ID_SCENARIO_GEOGRAPHY_POLITICAL_CATEGORY);
		politicalCatagory
				.setName("%" + GeographyPluginFileGenerator.UI_POLITICAL_CATEGORY_NAME); //$NON-NLS-1$
		politicalCatagory.setParentId(ID_SCENARIO_GEOGRAPHY_CATEGORY);
		extension.getCategories().add(politicalCatagory);

		final StemCategory countriesCatagory = GeneratedpluginFactory.eINSTANCE
				.createStemCategory();
		countriesCatagory
				.setId(ID_SCENARIO_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY);
		countriesCatagory
				.setName("%" + GeographyPluginFileGenerator.UI_COUNTRIES_CATEGORY_NAME); //$NON-NLS-1$
		countriesCatagory.setParentId(ID_SCENARIO_GEOGRAPHY_POLITICAL_CATEGORY);
		extension.getCategories().add(countriesCatagory);
	} // addCatagoriesToExtension
} // DiseaseModelScenarioGenerator