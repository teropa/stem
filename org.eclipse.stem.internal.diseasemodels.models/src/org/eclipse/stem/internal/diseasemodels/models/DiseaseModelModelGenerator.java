// DiseaseModelModelGenerator.java
package org.eclipse.stem.internal.diseasemodels.models;

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
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.internal.data.ModelGenerator;
import org.eclipse.stem.internal.data.PluginFileGenerator;
import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.generatedplugin.Extension;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginFactory;
import org.eclipse.stem.internal.data.generatedplugin.Plugin;
import org.eclipse.stem.internal.data.generatedplugin.StemCategory;
import org.eclipse.stem.internal.data.geography.models.GeographyModelGenerator;
import org.eclipse.stem.internal.data.geography.specifications.AdminLevelSet;
import org.eclipse.stem.internal.data.geography.specifications.CountryGraphPropertyFileSpecification;
import org.eclipse.stem.internal.data.specifications.DiseaseModelModelSpecification;
import org.eclipse.stem.internal.data.specifications.IdentifiableSpecification;
import org.eclipse.stem.internal.data.specifications.ModelSpecification;

/**
 * This class processes the generated population model files to create Disease
 * model models.
 */
public class DiseaseModelModelGenerator extends GeographyModelGenerator {

	@SuppressWarnings("unused")
	private final StandardPackage standardPackage = StandardPackage.eINSTANCE;
	@SuppressWarnings("unused")
	private final ModelPackage modelPackage = ModelPackage.eINSTANCE;

	static {
		// This sets up the mapping between the "platform" URI's and the
		// projects in the file system.

		// CWD is the current working directory
		final String CWD = System.getProperty("user.dir"); //$NON-NLS-1$
		// WORKSPACE is the directory of the parent workspace
		final String WORKSPACE = CWD.substring(0, CWD
				.lastIndexOf(File.separator));

		// The path to the generated population data project
		final String HUMAN_POPULATION_MODELS_PROJECT_ROOT = WORKSPACE
				+ File.separator
				+ org.eclipse.stem.data.geography.population.human.models.Activator.PLUGIN_ID
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
						org.eclipse.stem.data.geography.population.human.models.Activator.PLUGIN_ID,
						URI.createFileURI(HUMAN_POPULATION_MODELS_PROJECT_ROOT));

		platformResourceMap.put(
				org.eclipse.stem.diseases.Activator.PLUGIN_ID, URI
						.createFileURI(DISEASES_PROJECT_ROOT));
	} // static

	/**
	 * The id of the Disease Model category
	 */
	public static final String ID_MODEL_DISEASE_CATEGORY = PluginFileGenerator.ID_MODEL_CATEGORY
			+ ".disease"; //$NON-NLS-1$

	/**
	 * @param args
	 *            [0] the URI of the generated population model plugin.xml file
	 *            [1] the name of the project with the population models [2] the
	 *            name of the project with the disease models
	 */
	public static void main(final String[] args) {
		// Is the plugin file specified?
		if (args.length == 0) {
			// Yes
			System.err.println("Missing specification of the plugin file"); //$NON-NLS-1$
		} // if
		else {

			final String GENERATED_FILES_PATH = args[0];

			final String populationModelProjectName = args[1];
			final String diseaseModelProjectName = args[2];

			final String GENERATED_MODELS_PATH = GENERATED_FILES_PATH
					+ File.separator + "resources" + File.separator + "data"; //$NON-NLS-1$ //$NON-NLS-2$

			final File populationModelPluginFile = new File(
					".."	+ File.separator + populationModelProjectName + File.separator + PluginFileGenerator.PLUGIN_XML_FILE_NAME); //$NON-NLS-1$
			final URI populationModelPluginFileURI = URI
					.createFileURI(populationModelPluginFile.getAbsolutePath());

			final File diseaseModelPluginFile = new File(
					".."	+ File.separator + diseaseModelProjectName + File.separator + PluginFileGenerator.PLUGIN_XML_FILE_NAME); //$NON-NLS-1$
			final URI diseaseModelPluginFileURI = URI
					.createFileURI(diseaseModelPluginFile.getAbsolutePath());

			final DiseaseModelModelGenerator dmmg = new DiseaseModelModelGenerator();
			final Map<ISOKey, List<DiseaseModelModelSpecification>> modelSpecifications = dmmg
					.processFiles2(populationModelPluginFileURI,
							diseaseModelPluginFileURI);

			for (final ISOKey isoKey : sortISOKeys(modelSpecifications)) {
				// Now serialize the Identifiables
				for (final ModelSpecification gms : modelSpecifications
						.get(isoKey)) {
					try {
						gms.serialize(GENERATED_MODELS_PATH);
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

			// Add the "model" extension point
			extension.setPoint(Constants.ID_MODEL_EXTENSION_POINT);

			pluginxml.getExtensionelement().add(extension);

			// Now add the dublin core entries to the plugin.xml file for
			// each of the models
			for (final ISOKey isoKey : sortISOKeys(modelSpecifications)) {
				final StemCategory countryCategory = GeneratedpluginFactory.eINSTANCE
						.createStemCategory();
				final String COUNTRY_CATAGORY_STRING = ID_MODEL_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY
						+ "." + isoKey.toString().toLowerCase(); //$NON-NLS-1$
				countryCategory.setId(COUNTRY_CATAGORY_STRING);
				countryCategory.setName(isoKey.toString());
				countryCategory
						.setParentId(ID_MODEL_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY);
				for (final ModelSpecification gms : modelSpecifications
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

	protected Map<ISOKey, List<DiseaseModelModelSpecification>> processFiles2(
			final URI populationModelPluginFileURI,
			final URI diseaseModelPluginFileURI) {
		final HashMap<ISOKey, List<DiseaseModelModelSpecification>> retValue = new HashMap<ISOKey, List<DiseaseModelModelSpecification>>();

		// Get the contents of the population plug.xml file
		final Plugin populationPluginXML = getPluginxml(populationModelPluginFileURI);
		final Plugin diseaseModelPluginXML = getPluginxml(diseaseModelPluginFileURI);

		// Populate the map of population models by ISOKey and Administration
		// level
		final Map<ISOKey, Map<AdminLevelSet, DublinCore>> populationModelMap = new HashMap<ISOKey, Map<AdminLevelSet, DublinCore>>();

		for (Extension extension : populationPluginXML.getExtensionelement()) {
			for (DublinCore dc : extension.getDublinCores()) {
				final Map<ISOKey, AdminLevelSet> isoKeyAdminLevelSetMap = CountryGraphPropertyFileSpecification
						.parseDublinCoreCoverageString(dc.getCoverage());
				final AdminLevelSet adminLevelSet = (AdminLevelSet) isoKeyAdminLevelSetMap
						.values().toArray()[0];
				final ISOKey isoKey = (ISOKey) isoKeyAdminLevelSetMap.keySet()
						.toArray()[0];

				Map<AdminLevelSet, DublinCore> temp = populationModelMap
						.get(isoKey);
				if (temp == null) {
					temp = new HashMap<AdminLevelSet, DublinCore>();
					populationModelMap.put(isoKey, temp);
				}
				temp.put(adminLevelSet, dc);
			} // for dc
		} // for extension

		final Map<DublinCore, DiseaseModel> dcDiseaseModelMap = new HashMap<DublinCore, DiseaseModel>();
		// Populate the collection of disease models
		for (Extension extension : diseaseModelPluginXML.getExtensionelement()) {
			for (DublinCore diseaseModelDC : extension.getDublinCores()) {
				final Identifiable dm = Utility
						.getIdentifiable(IdentifiableSpecification
								.getIdentifiableProjectURI(diseaseModelDC));
				// Is this a standard, non-aggregating disease model?
				if ((dm instanceof DiseaseModel)
						&& !(dm instanceof AggregatingSIDiseaseModel)) {
					dcDiseaseModelMap.put(diseaseModelDC, (DiseaseModel) dm);
				}

			} // for dc
		} // for extension

		// Create the disease model models
		for (ISOKey isoKey : sortISOKeys(populationModelMap)) {
			final List<DiseaseModelModelSpecification> gmsList = new ArrayList<DiseaseModelModelSpecification>();

			final Map<AdminLevelSet, DublinCore> adminSetDCMap = populationModelMap
					.get(isoKey);
			for (AdminLevelSet adminLevelSet : adminSetDCMap.keySet()) {
				final DublinCore populationModelDC = adminSetDCMap
						.get(adminLevelSet);

				// Iterate through each of the disease models and create one
				// model for each for the current ISOKey
				for (DublinCore diseaseModelDC : dcDiseaseModelMap.keySet()) {
					final DiseaseModelModelSpecification temp = new DiseaseModelModelSpecification(
							isoKey, adminLevelSet, populationModelDC,
							diseaseModelDC, dcDiseaseModelMap
									.get(diseaseModelDC));

					gmsList.add(temp);
				} // for diseaseDCs
			} // for adminLevel
			retValue.put(isoKey, gmsList);
		} // for each isoKey
		return retValue;
	} // processFiles

} // DiseaseModelModelGenerator