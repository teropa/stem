// PopulationModelGenerator.java
package org.eclipse.stem.internal.data.geography.earthscience.models;

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
public class EarthScienceModelGenerator extends GeographyModelGenerator {
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
			final String sourceGeographyDataProjectName = args[2];

			final String GENERATED_MODELS_PATH = GENERATED_FILES_PATH
					+ File.separator + "resources" + File.separator + "data"; //$NON-NLS-1$ //$NON-NLS-2$

			final File geographicModelPluginfile = new File(
					".."	+ File.separator + sourceGeographicModelProjecName + File.separator + PluginFileGenerator.PLUGIN_XML_FILE_NAME); //$NON-NLS-1$
			final URI geographicModelPluginFileURI = URI
					.createFileURI(geographicModelPluginfile.getAbsolutePath());

			
			final File file = new File(
					".."	+ File.separator + sourceGeographyDataProjectName + File.separator + PluginFileGenerator.PLUGIN_XML_FILE_NAME); //$NON-NLS-1$
			final URI geographyPluginfile = URI.createFileURI(file.getAbsolutePath());
			

			final EarthScienceModelGenerator pmg = new EarthScienceModelGenerator();
			final Map<ISOKey, List<EarthScienceModelSpecification>> modelSpecifications = pmg
					.processFiles(geographicModelPluginFileURI, geographyPluginfile);

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

	protected Map<ISOKey, List<EarthScienceModelSpecification>> processFiles(
			URI geographicModelPluginFileUri, URI geographyPluginFileUri) {
		final Map<ISOKey, List<EarthScienceModelSpecification>> retValue = new HashMap<ISOKey, List<EarthScienceModelSpecification>>();

		// Get the contents of the geography model plug.xml file
		final Plugin geographyModelsPlugin = getPluginxml(geographicModelPluginFileUri);

		final Plugin geographyDataPlugin = getPluginxml(geographyPluginFileUri);

		final HashMap<ISOKey, Map<AdminLevelSet, DublinCore>> modelMap = new HashMap<ISOKey, Map<AdminLevelSet, DublinCore>>();
		final Map<ISOKey, Map<AdminLevel, List<DublinCore>>> earthScienceMap = new HashMap<ISOKey, Map<AdminLevel, List<DublinCore>>>();

		for (Extension extension : geographyDataPlugin.getExtensionelement()) {
			for (DublinCore dc : extension.getDublinCores()) {
				final Map<ISOKey, AdminLevelSet> isoKeyAdminLevelSetMap = CountryGraphPropertyFileSpecification
				.parseDublinCoreCoverageString(dc.getCoverage());
				final AdminLevelSet adminLevelSet = (AdminLevelSet) isoKeyAdminLevelSetMap
						.values().toArray()[0];
				final AdminLevel maxAdminLevel = adminLevelSet.getMaxAdminLevel();
				final ISOKey isoKey = (ISOKey) isoKeyAdminLevelSetMap.keySet()
						.toArray()[0];
				
				Map<AdminLevel, List<DublinCore>> temp = earthScienceMap.get(isoKey);
				if (temp == null) {
					temp = new HashMap<AdminLevel, List<DublinCore>>();
					earthScienceMap.put(isoKey, temp);
				}
				List<DublinCore> dcList = temp.get(maxAdminLevel);
				if (dcList == null) {
					dcList = new ArrayList<DublinCore>();
					temp.put(maxAdminLevel, dcList);
				}
				dcList.add(dc);
			}
		}

		
//		for (Entry<ISOKey, Map<AdminLevel, List<DublinCore>>> entry : earthScienceMap.entrySet()) {
//			System.out.println("ISO Key: "+ entry.getKey());
//			for (Entry<AdminLevel, List<DublinCore>> entry2 : entry.getValue().entrySet()) {
//				System.out.println("Admin Level: "+ entry2.getKey() + " / "+ entry2.getValue());
//			}
//		}
		
		
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

//		for (Extension extension : populationGraphsPlugin.getExtensionelement()) {
//			for (DublinCore dc : extension.getDublinCores()) {
//				final Map<ISOKey, AdminLevelSet> isoKeyAdminLevelSetMap = CountryGraphPropertyFileSpecification
//						.parseDublinCoreCoverageString(dc.getCoverage());
//				final AdminLevelSet adminLevelSet = (AdminLevelSet) isoKeyAdminLevelSetMap
//						.values().toArray()[0];
//				final AdminLevel maxAdminLevel = adminLevelSet
//						.getMaxAdminLevel();
//				final ISOKey isoKey = (ISOKey) isoKeyAdminLevelSetMap.keySet()
//						.toArray()[0];
//
//				Map<AdminLevel, DublinCore> temp = populationMap.get(isoKey);
//				if (temp == null) {
//					temp = new HashMap<AdminLevel, DublinCore>();
//					populationMap.put(isoKey, temp);
//				}
//				temp.put(maxAdminLevel, dc);
//			}
//		} // for Population Graphs

		// for (ISOKey isoKey : sortISOKeys(populuationMap)) {
		// for (AdminLevel adminLevel : populuationMap.get(isoKey).keySet() ) {
		// System.out.println( isoKey + " " + adminLevel + " " +
		// populuationMap.get(isoKey).get(adminLevel).getIdentifier());
		// }
		// }

		for (ISOKey isoKey : sortISOKeys(modelMap)) {
			final List<EarthScienceModelSpecification> gmsList = new ArrayList<EarthScienceModelSpecification>();

			final Map<AdminLevelSet, DublinCore> adminSetDCMap = modelMap
					.get(isoKey);
			for (AdminLevelSet adminLevelSet : adminSetDCMap.keySet()) {
				final AdminLevel maxAdminLevel = adminLevelSet
						.getMaxAdminLevel();

				final DublinCore countryGeographicModelDC = adminSetDCMap
						.get(adminLevelSet);

				if (countryGeographicModelDC == null)  {
					System.err.println("model null for "+ isoKey.getKey());
				}
				
				final Map<AdminLevel, List<DublinCore>> adminDCMap = earthScienceMap.get(isoKey);
				if (adminDCMap != null) {
					List<DublinCore> earthScienceGraphsDC = adminDCMap.get(maxAdminLevel);
					final EarthScienceModelSpecification temp = new EarthScienceModelSpecification(
							isoKey, adminLevelSet, countryGeographicModelDC,
							earthScienceGraphsDC);
					gmsList.add(temp);
				}
			} // for adminLevel
			retValue.put(isoKey, gmsList);
		} // for each isoKey

		return retValue;
	} // processFiles

} // PopulationModelGenerator