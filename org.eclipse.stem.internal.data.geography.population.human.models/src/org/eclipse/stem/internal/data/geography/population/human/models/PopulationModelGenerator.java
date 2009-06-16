// PopulationModelGenerator.java
package org.eclipse.stem.internal.data.geography.population.human.models;

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
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.internal.data.ModelGenerator;
import org.eclipse.stem.internal.data.PluginFileGenerator;
import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.generatedplugin.Extension;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginFactory;
import org.eclipse.stem.internal.data.generatedplugin.Plugin;
import org.eclipse.stem.internal.data.generatedplugin.StemCategory;
import org.eclipse.stem.internal.data.geography.models.GeographyModelGenerator;
import org.eclipse.stem.internal.data.geography.specifications.AdminLevel;
import org.eclipse.stem.internal.data.geography.specifications.AdminLevelSet;
import org.eclipse.stem.internal.data.geography.specifications.CountryGraphPropertyFileSpecification;
import org.eclipse.stem.internal.data.specifications.ModelSpecification;

/**
 * This class is responsible for generating population models.
 */
public class PopulationModelGenerator extends GeographyModelGenerator {
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
			final String sourceGeographicModelProjecName = args[1];
			final String sourcePopulationProjectName = args[2];

			final String GENERATED_MODELS_PATH = GENERATED_FILES_PATH
					+ File.separator + "resources" + File.separator + "data"; //$NON-NLS-1$ //$NON-NLS-2$

			final File geographicModelPluginfile = new File(
					".."	+ File.separator + sourceGeographicModelProjecName + File.separator + PluginFileGenerator.PLUGIN_XML_FILE_NAME); //$NON-NLS-1$
			final URI geographicModelPluginFileURI = URI
					.createFileURI(geographicModelPluginfile.getAbsolutePath());

			final File populationPluginfile = new File(
					".."	+ File.separator + sourcePopulationProjectName + File.separator + PluginFileGenerator.PLUGIN_XML_FILE_NAME); //$NON-NLS-1$
			final URI populationPluginFileURI = URI
					.createFileURI(populationPluginfile.getAbsolutePath());

			final PopulationModelGenerator pmg = new PopulationModelGenerator();
			final Map<ISOKey, List<PopulationModelSpecification>> modelSpecifications = pmg
					.processFiles(geographicModelPluginFileURI,
							populationPluginFileURI);

			for (final ISOKey isoKey : sortISOKeys(modelSpecifications)) {
				// Now serialize the Identifiables
				for (final ModelSpecification gms : modelSpecifications
						.get(isoKey)) {
					try {
						gms.serialize(GENERATED_MODELS_PATH);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				} // for
			} // for isoKey

			// Create the instance of plugin.xml that we'll serialize later
			final Plugin pluginxml = GeneratedpluginFactory.eINSTANCE
					.createPlugin();
			final Extension extension = GeneratedpluginFactory.eINSTANCE
					.createExtension();

			// Add the "model" extension point
			extension.setPoint(Constants.ID_MODEL_EXTENSION_POINT);

			// Add the categories to the extension
//			addCatagoriesToExtension(extension);

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
//				extension.getCategories().add(countryCategory);
				for (final ModelSpecification gms : modelSpecifications
						.get(isoKey)) {
					final DublinCore dc = GeneratedpluginFactory.eINSTANCE
							.createDublinCore();
					dc.setCategoryId(COUNTRY_CATAGORY_STRING);
					extension.getDublinCores().add(
							populateGeneratedDC(dc, gms.getDublinCore()));
				} // for 
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

	protected Map<ISOKey, List<PopulationModelSpecification>> processFiles(
			URI geographicModelPluginFileUri, URI populationPluginFileUri) {
		final Map<ISOKey, List<PopulationModelSpecification>> retValue = new HashMap<ISOKey, List<PopulationModelSpecification>>();

		// Get the contents of the geography model plug.xml file
		final Plugin geographyModelsPlugin = getPluginxml(geographicModelPluginFileUri);

		final Plugin populationGraphsPlugin = getPluginxml(populationPluginFileUri);

		final HashMap<ISOKey, Map<AdminLevelSet, DublinCore>> modelMap = new HashMap<ISOKey, Map<AdminLevelSet, DublinCore>>();
		final Map<ISOKey, Map<AdminLevel, DublinCore>> populationMap = new HashMap<ISOKey, Map<AdminLevel, DublinCore>>();

		for (Extension extension : geographyModelsPlugin.getExtensionelement()) {
			for (DublinCore dc : extension.getDublinCores()) {
				final Map<ISOKey, AdminLevelSet> isoKeyAdminLevelSetMap = CountryGraphPropertyFileSpecification
						.parseDublinCoreCoverageString(dc.getCoverage());
				final AdminLevelSet adminLevelSet = (AdminLevelSet) isoKeyAdminLevelSetMap
						.values().toArray()[0];
				final ISOKey isoKey = (ISOKey) isoKeyAdminLevelSetMap.keySet()
						.toArray()[0];

				Map<AdminLevelSet, DublinCore> temp = modelMap.get(isoKey);
				if (temp == null) {
					temp = new HashMap<AdminLevelSet, DublinCore>();
					modelMap.put(isoKey, temp);
				}
				temp.put(adminLevelSet, dc);
			} // for
		} // for Geography Models

		// for (ISOKey isoKey : sortISOKeys(modelMap)) {
		// for (AdminLevel adminLevel : modelMap.get(isoKey).keySet() ) {
		// System.out.println( isoKey + " " + adminLevel + " " +
		// modelMap.get(isoKey).get(adminLevel).getIdentifier());
		// }
		// }

		for (Extension extension : populationGraphsPlugin.getExtensionelement()) {
			for (DublinCore dc : extension.getDublinCores()) {
				final Map<ISOKey, AdminLevelSet> isoKeyAdminLevelSetMap = CountryGraphPropertyFileSpecification
						.parseDublinCoreCoverageString(dc.getCoverage());
				final AdminLevelSet adminLevelSet = (AdminLevelSet) isoKeyAdminLevelSetMap
						.values().toArray()[0];
				final AdminLevel maxAdminLevel = adminLevelSet
						.getMaxAdminLevel();
				final ISOKey isoKey = (ISOKey) isoKeyAdminLevelSetMap.keySet()
						.toArray()[0];

				Map<AdminLevel, DublinCore> temp = populationMap.get(isoKey);
				if (temp == null) {
					temp = new HashMap<AdminLevel, DublinCore>();
					populationMap.put(isoKey, temp);
				}
				temp.put(maxAdminLevel, dc);
			}
		} // for Population Graphs

		// for (ISOKey isoKey : sortISOKeys(populuationMap)) {
		// for (AdminLevel adminLevel : populuationMap.get(isoKey).keySet() ) {
		// System.out.println( isoKey + " " + adminLevel + " " +
		// populuationMap.get(isoKey).get(adminLevel).getIdentifier());
		// }
		// }

		for (ISOKey isoKey : sortISOKeys(modelMap)) {
			final List<PopulationModelSpecification> gmsList = new ArrayList<PopulationModelSpecification>();

			final Map<AdminLevelSet, DublinCore> adminSetDCMap = modelMap
					.get(isoKey);
			for (AdminLevelSet adminLevelSet : adminSetDCMap.keySet()) {
				final AdminLevel maxAdminLevel = adminLevelSet
						.getMaxAdminLevel();

				final DublinCore countryGeographicModelDC = adminSetDCMap
						.get(adminLevelSet);

				final Map<AdminLevel, DublinCore> adminDCMap = populationMap
						.get(isoKey);
				DublinCore populationGraphDC = adminDCMap.get(maxAdminLevel);
				final PopulationModelSpecification temp = new PopulationModelSpecification(
						isoKey, adminLevelSet, countryGeographicModelDC,
						populationGraphDC);

				gmsList.add(temp);
			} // for adminLevel
			retValue.put(isoKey, gmsList);
		} // for each isoKey

		return retValue;
	} // processFiles

} // PopulationModelGenerator