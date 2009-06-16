package org.eclipse.stem.internal.data.geography;

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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.internal.data.PluginFileGenerator;
import org.eclipse.stem.internal.data.geography.specifications.CountryGraphPropertyFileSpecification;
import org.eclipse.stem.internal.data.geography.specifications.GeographicRelationshipPropertyFileSpecification;
import org.eclipse.stem.internal.data.specifications.IdentifiablePropertyFileSpecification;

/**
 * This class is responsible for generating the plug.xml and plugin.properties
 * files for the org.eclipse.stem.geography plugin.
 */
public class GeographyPluginFileGenerator extends PluginFileGenerator {

	/**
	 * The id of the Geography category
	 */
	public static final String ID_GRAPH_GEOGRAPHY_CATEGORY = ID_GRAPH_CATEGORY
			+ ".geography"; //$NON-NLS-1$

	/**
	 * The id of the Political category
	 */
	public static final String ID_GRAPH_GEOGRAPHY_POLITICAL_CATEGORY = ID_GRAPH_GEOGRAPHY_CATEGORY
			+ ".political"; //$NON-NLS-1$

	/**
	 * The id of the Countries category
	 */
	public static final String ID_GRAPH_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY = ID_GRAPH_GEOGRAPHY_POLITICAL_CATEGORY
			+ ".countries"; //$NON-NLS-1$

	/**
	 * The NLS key for the geography category name
	 */
	public static final String UI_GEOGRAPHY_CATEGORY_NAME = "_UI_Geography_category"; //$NON-NLS-1$

	/**
	 * The NLS key for the political category name
	 */
	public static final String UI_POLITICAL_CATEGORY_NAME = "_UI_Poltical_category"; //$NON-NLS-1$

	/**
	 * The NLS key for the countries category name
	 */
	public static final String UI_COUNTRIES_CATEGORY_NAME = "_UI_Countries_category"; //$NON-NLS-1$


	/**
	 * This is the name of the Geography category
	 */
	public static final String GEOGRAPHY_CATEGORY_NAME = "Geography"; //$NON-NLS-1$

	/**
	 * This is the name of the Political category
	 */
	public static final String POLITITCAL_CATEGORY_NAME = "Political"; //$NON-NLS-1$

	/**
	 * This is the name of the Countries category
	 */
	public static final String COUNTRIES_CATEGORY_NAME = "Country"; //$NON-NLS-1$

	/**
	 * @param propertyFileSpecifications
	 *            the {@link IdentifiablePropertyFileSpecification}s
	 * @param rootSerializationDirectory
	 *            the root of the directory where the generated files are to be
	 *            placed.
	 */
	public void generatePluginFiles(
			final List<IdentifiablePropertyFileSpecification> propertyFileSpecifications,
			final String rootSerializationDirectory, boolean toDeclareCategories) {
		System.out.println("rootserial = " + rootSerializationDirectory); //$NON-NLS-1$
		final File pluginFile = new File(rootSerializationDirectory
				+ File.separator + PLUGIN_XML_FILE_NAME);
		final File propertiesFile = new File(rootSerializationDirectory
				+ File.separator + PLUGIN_PROPERTIES_FILE_NAME);

		System.out.println(pluginFile.getAbsolutePath());
		String temp = System.getProperty("user.dir"); //$NON-NLS-1$
		System.out.println("CWD = " + temp); //$NON-NLS-1$

		try {
			final PrintWriter pluginWriter = new PrintWriter(
					new BufferedWriter(new FileWriter(pluginFile)));

			final PrintWriter propertiesWriter = new PrintWriter(
					new BufferedWriter(new FileWriter(propertiesFile)));

			// Output the headers for the two files
			outputPluginHeader(pluginWriter);
			outputPluginPropertiesHeader(propertiesWriter);

			propertiesWriter.println(PluginFileGenerator.UI_STEM_CATEGORY_NAME
					+ " = " + PluginFileGenerator.STEM_CATEGORY_NAME); //$NON-NLS-1$

			// **** Graphs ****
			generateGraphExtensions(propertyFileSpecifications, pluginWriter,
					propertiesWriter, toDeclareCategories);

			pluginWriter.println();

			// Output the footers
			outputPluginFooter(pluginWriter);
			// outputPluginPropertiesFooter(propertiesWriter);

			pluginWriter.flush();
			pluginWriter.close();

			propertiesWriter.flush();
			propertiesWriter.close();
		} catch (final IOException e) {
			System.err.println("Trouble creating \"" + PLUGIN_XML_FILE_NAME //$NON-NLS-1$
					+ "\" " + e.getMessage()); //$NON-NLS-1$
			e.printStackTrace();
		}
	} // generatePluginFiles

	// /**
	// * @param dataSetRecords
	// * the values created directly from the properties files
	// * @param modelRecords
	// * the generated models
	// * @param diseaseScenarios
	// * the generated scenarios
	// * @param rootSerializationDirectory
	// * the root of the directory where the generated files are to be
	// * placed.
	// */
	// public static void generatePluginFiles(
	// final DataSetRecordHolder dataSetRecords,
	// final ModelRecordHolder modelRecords,
	// final List<ScenarioRecord> diseaseScenarios,
	// final String rootSerializationDirectory) {
	// final File pluginFile = new File(rootSerializationDirectory
	// + File.separator + PLUGIN_XML_FILE_NAME);
	// final File propertiesFile = new File(rootSerializationDirectory
	// + File.separator + PLUGIN_PROPERTIES_FILE_NAME);
	//
	// try {
	// final PrintWriter pluginWriter = new PrintWriter(
	// new BufferedWriter(new FileWriter(pluginFile)));
	//
	// final PrintWriter propertiesWriter = new PrintWriter(
	// new BufferedWriter(new FileWriter(propertiesFile)));
	//
	// // Output the headers for the two files
	// outputPluginHeader(pluginWriter);
	// outputPluginPropertiesHeader(propertiesWriter);
	//
	// // **** Graphs ****
	// generateGraphExtensions(dataSetRecords, pluginWriter,
	// propertiesWriter);
	//
	// pluginWriter.println();
	//
	// // **** Models ****
	// generateModelExtensions(modelRecords, pluginWriter,
	// propertiesWriter);
	//
	// pluginWriter.println();
	//
	// // **** Scenarios ****
	// generateScenarioExtensions(diseaseScenarios, pluginWriter,
	// propertiesWriter);
	//
	// // Output the footers
	// outputPluginFooter(pluginWriter);
	// // outputPluginPropertiesFooter(propertiesWriter);
	//
	// pluginWriter.flush();
	// pluginWriter.close();
	//
	// propertiesWriter.flush();
	// propertiesWriter.close();
	// } catch (final IOException e) {
	// System.err.println("Trouble creating \"" + PLUGIN_XML_FILE_NAME
	// + "\" " + e.getMessage());
	// e.printStackTrace();
	// }
	// } // generatePluginFiles

	/**
	 * @param dataSetRecords
	 * @param pluginWriter
	 * @param propertiesWriter
	 */
	private void generateGraphExtensions(
			final List<IdentifiablePropertyFileSpecification> propertyFileSpecifications,
			final PrintWriter pluginWriter, final PrintWriter propertiesWriter, boolean toDeclareCategories) {

		final Map<ISOKey, List<CountryGraphPropertyFileSpecification>> countries = extractCountryGraphISOKeyMap(propertyFileSpecifications);
		final Map<ISOKey, List<GeographicRelationshipPropertyFileSpecification>> countryEdges = extractGeographicRelationshipISOKeyMap(propertyFileSpecifications);

		final Set<ISOKey> allKeys = new HashSet<ISOKey>();
		allKeys.addAll(countries.keySet());
		allKeys.addAll(countryEdges.keySet());

		// Get a sorted super set of all of the keys in the data set records
		final List<ISOKey> sortedISOKeys = new ArrayList<ISOKey>(allKeys);
		Collections.sort(sortedISOKeys);

		outputGraphExtensionsHeader(pluginWriter, propertiesWriter, toDeclareCategories);

		for (final ISOKey isoKey : sortedISOKeys) {
			final String isoCatagoryID = createISOCategoryID(
					ID_GRAPH_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY, isoKey);
			pluginWriter.println("\n<!-- " + isoKey + " -->"); //$NON-NLS-1$ //$NON-NLS-2$
			pluginWriter.println("<stem_category id=\"" + isoCatagoryID //$NON-NLS-1$
					+ "\" name=\"" + isoKey.toString() + "\" parent_id=\""  //$NON-NLS-1$//$NON-NLS-2$
					+ ID_GRAPH_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY + "\"/>"); //$NON-NLS-1$

			// ********** Nodes **********
			
			final List<CountryGraphPropertyFileSpecification> country = countries.get(isoKey);

			// Anything for this ISOkey?
			if (country != null) {
				// Yes
				pluginWriter.println("\t<!-- Nodes and Labels -->"); //$NON-NLS-1$
				for (final CountryGraphPropertyFileSpecification cgr : country) {
					outputDublinCore(cgr, isoCatagoryID, pluginWriter);
					pluginWriter.flush();
				} // for
			} // if any nodes for isoKey

			
			final List<GeographicRelationshipPropertyFileSpecification> countryEdge = countryEdges.get(isoKey);

			// Anything for this ISOkey?
			if (countryEdge != null) {
				// Yes
				pluginWriter.println("\t<!-- Edges -->"); //$NON-NLS-1$
				for (final GeographicRelationshipPropertyFileSpecification cgr : countryEdge) {
					outputDublinCore(cgr, isoCatagoryID, pluginWriter);
					pluginWriter.flush();
				} // for
			} // if any edges for isoKey
			
//			// ********** Labels **********
//			pluginWriter.println("\t<!-- Labels -->");
//			final Map<String, Map<ISOKey, Map<Record.AdminLevel, CountryGraphRecord.CountryLabelGraphRecord>>> labelMap = dataSetRecords
//					.getLabelGraphRecords();
//
//			for (final Map.Entry<String, Map<ISOKey, Map<Record.AdminLevel, CountryGraphRecord.CountryLabelGraphRecord>>> labelMapEntry : labelMap
//					.entrySet()) {
//				final Map<Record.AdminLevel, CountryGraphRecord.CountryLabelGraphRecord> labelLevelMap = labelMapEntry
//						.getValue().get(isoKey);
//
//				// Anything for this ISOKey?
//				if (labelLevelMap != null) {
//					// Yes
//					// This is where we would put out a level category
//					for (final CountryGraphRecord cgr : labelLevelMap.values()) {
//						outputDublinCore(cgr, countryId, pluginWriter);
//						pluginWriter.flush();
//					} // for
//				} // if any nodes for isoKey
//			} // for label map entry

			// ********** Edges **********
//			pluginWriter.println("\t<!-- Edges -->");
//			final Map<String, Map<ISOKey, Map<AdminLevel, Map<ISOKey, Map<AdminLevel, RelationshipGraphRecord>>>>> edgeMap = dataSetRecords
//					.getEdgeGraphRecords();
//			for (final Map.Entry<String, Map<ISOKey, Map<AdminLevel, Map<ISOKey, Map<AdminLevel, RelationshipGraphRecord>>>>> edgeMapEntry : edgeMap
//					.entrySet()) {
//				final Map<AdminLevel, Map<ISOKey, Map<AdminLevel, RelationshipGraphRecord>>> edgeLevelMap = edgeMapEntry
//						.getValue().get(isoKey);
//
//				// Anything for this ISOkey?
//				if (edgeLevelMap != null) {
//					// Yes
//					for (final Map.Entry<AdminLevel, Map<ISOKey, Map<AdminLevel, RelationshipGraphRecord>>> mapentry : edgeLevelMap
//							.entrySet()) {
//						for (final Map.Entry<ISOKey, Map<AdminLevel, RelationshipGraphRecord>> mapentry2 : mapentry
//								.getValue().entrySet()) {
//							for (final Map.Entry<AdminLevel, RelationshipGraphRecord> mapentry3 : mapentry2
//									.getValue().entrySet()) {
//								outputDublinCore(mapentry3.getValue(),
//										isoCatagoryID, pluginWriter);
//								pluginWriter.flush();
//							} // for
//						} // for
//					} // for admin level
//				} // if there's an edgeLevelMap
//			} // for each edge map entry
		} // for each ISO key

		outputGraphExtensionsFooter(pluginWriter);
	} // generateGraphExtensions

	private Map<ISOKey, List<CountryGraphPropertyFileSpecification>> extractCountryGraphISOKeyMap(
			List<IdentifiablePropertyFileSpecification> propertyFileSpecifications) {
		final Map<ISOKey, List<CountryGraphPropertyFileSpecification>> retValue = new HashMap<ISOKey, List<CountryGraphPropertyFileSpecification>>();

		for (IdentifiablePropertyFileSpecification identifiablePropertyFileSpecification : propertyFileSpecifications) {
			if (identifiablePropertyFileSpecification instanceof CountryGraphPropertyFileSpecification) {
				final CountryGraphPropertyFileSpecification countryGraph = (CountryGraphPropertyFileSpecification) identifiablePropertyFileSpecification;
				// add it to the Map
				List<CountryGraphPropertyFileSpecification> isoKeyList = retValue
						.get(countryGraph.getISOKey());
				// Already a list for this key?
				if (isoKeyList == null) {
					// No
					isoKeyList = new ArrayList<CountryGraphPropertyFileSpecification>();
					retValue.put(countryGraph.getISOKey(), isoKeyList);
				} // if
				isoKeyList.add(countryGraph);
			} // if instanceof CountryGraphPropertyFileSpecification
		} // for each

		return retValue;
	} // extractCountryGraphISOKeyMap

	private Map<ISOKey, List<GeographicRelationshipPropertyFileSpecification>> extractGeographicRelationshipISOKeyMap(
			List<IdentifiablePropertyFileSpecification> propertyFileSpecifications) {
		final Map<ISOKey, List<GeographicRelationshipPropertyFileSpecification>> retValue = new HashMap<ISOKey, List<GeographicRelationshipPropertyFileSpecification>>();

		for (IdentifiablePropertyFileSpecification identifiablePropertyFileSpecification : propertyFileSpecifications) {
			if (identifiablePropertyFileSpecification instanceof GeographicRelationshipPropertyFileSpecification) {
				final GeographicRelationshipPropertyFileSpecification geographicRelationship = (GeographicRelationshipPropertyFileSpecification) identifiablePropertyFileSpecification;
				// add it to the Map
				List<GeographicRelationshipPropertyFileSpecification> isoKeyList = retValue
						.get(geographicRelationship.getIsoKeyA());
				// Already a list for this key?
				if (isoKeyList == null) {
					// No
					isoKeyList = new ArrayList<GeographicRelationshipPropertyFileSpecification>();
					retValue.put(geographicRelationship.getIsoKeyA(),
							isoKeyList);
				} // if
				isoKeyList.add(geographicRelationship);
			} // if instanceof CountryGraphPropertyFileSpecification
		} // for each

		return retValue;
	} // extractGeographicRelationshipISOKeyMap

	/**
	 * @param modelRecords
	 * @param pluginWriter
	 * @param propertiesWriter
	 */
	// private static void generateModelExtensions(
	// final ModelRecordHolder modelRecords,
	// final PrintWriter pluginWriter, final PrintWriter propertiesWriter) {
	// // Get a sorted super set of all of the keys in the model records
	// final List<ISOKey> sortedISOKeys = getISOKeys(modelRecords);
	//
	// outputModelExtensionsHeader(pluginWriter, propertiesWriter);
	//
	// outputGeneralModelCategories(modelRecords, pluginWriter,
	// propertiesWriter);
	//
	// for (final ISOKey isoKey : sortedISOKeys) {
	// final String categoryId = createISOCategoryID(
	// ID_MODEL_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY, isoKey);
	// pluginWriter.println("\n<!-- " + isoKey + " -->");
	// pluginWriter.println("<stem_category id=\"" + categoryId
	// + "\" name=\"" + isoKey.toString() + "\" parent_id=\""
	// + ID_MODEL_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY + "\"/>");
	//
	// // **** Country Model Records ****
	// // This is slow and dumb, but it works for now
	// for (final CountryModelRecord cmr : modelRecords
	// .getCountryModelRecords()) {
	// // Is this model record for the current ISO key?
	// if (cmr.getIsoKey().equals(isoKey)) {
	// // Yes
	// outputDublinCore(cmr, categoryId, pluginWriter);
	// }
	// } // for each country model record
	//
	// // **** Geographic Country Model Records ****
	// for (final GeographicCountryModelRecord gcmr : modelRecords
	// .getGeographicCountryModelRecords()) {
	// // Is this model record for the current ISO key?
	// if (gcmr.getIsoKey().equals(isoKey)) {
	// // Yes
	// outputDublinCore(gcmr, categoryId, pluginWriter);
	// }
	// } // for each geographic country model record
	//
	// // **** Full Country Model Records ****
	// for (final FullCountryModelRecord fcmr : modelRecords
	// .getFullCountryModelRecords()) {
	// // Is this model record for the current ISO key?
	// if (fcmr.getIsoKey().equals(isoKey)) {
	// // Yes
	// outputDublinCore(fcmr, categoryId, pluginWriter);
	// }
	// } // for each full country model record
	//
	// // **** Full Country Disease Model Records ****
	// for (final FullCountryModelRecord fcdmr : modelRecords
	// .getFullCountryDiseaseModelRecords()) {
	// // Is this model record for the current ISO key?
	// if (fcdmr.getIsoKey().equals(isoKey)) {
	// // Yes
	// outputDublinCore(fcdmr, categoryId, pluginWriter);
	// }
	// } // for each full country disease model record
	//
	// // **** Full Country Aggregating Disease Model Records ****
	// for (final FullCountryDiseaseModelRecord fcadmr : modelRecords
	// .getFullCountryAggregatingDiseaseModelRecords()) {
	// // Is this model record for the current ISO key?
	// if (fcadmr.getIsoKey().equals(isoKey)) {
	// // Yes
	// outputDublinCore(fcadmr, categoryId, pluginWriter);
	// }
	// } // for each Full Country Aggregating Disease Model Record
	//
	// // **** Earth ****
	// if (modelRecords.getEarthModel().getIsoKey().equals(isoKey)) {
	// outputDublinCore(modelRecords.getEarthModel(), categoryId,
	// pluginWriter);
	//
	// for (final FullCountryModelRecord efcmr : modelRecords
	// .getFullEarthModels()) {
	// outputDublinCore(efcmr, categoryId, pluginWriter);
	// } // for each Earth full country model
	// } // if Earth
	//
	// } // for each ISO key
	//
	// // General models
	//
	// for (final GeneralModelRecord generalModelRecord : modelRecords
	// .getGeneralModels()) {
	// outputDublinCore(generalModelRecord, generalModelRecord
	// .getCategory(), pluginWriter);
	// } // for each ModelRecord
	// outputModelExtensionsFooter(pluginWriter);
	// } // generateModelExtensions
	/**
	 * @param diseaseScenarios
	 * @param pluginWriter
	 * @param propertiesWriter
	 */
	// private static void generateScenarioExtensions(
	// final List<ScenarioRecord> diseaseScenarios,
	// final PrintWriter pluginWriter, final PrintWriter propertiesWriter) {
	// outputScenarioExtensionsHeader(pluginWriter, propertiesWriter);
	//
	// outputScenarioCategories(diseaseScenarios, pluginWriter,
	// propertiesWriter);
	//
	// for (final ScenarioRecord scenarioRecord : diseaseScenarios) {
	// outputDublinCore(scenarioRecord, scenarioRecord.getCategory(),
	// pluginWriter);
	// } // for each scenario
	//
	// outputScenarioExtensionsFooter(pluginWriter, propertiesWriter);
	// } // generateScenarioExtensions
	// /**
	// * @param modelRecords
	// * @param pluginWriter
	// * @param propertiesWriter
	// */
	// private static void outputGeneralModelCategories(
	// final ModelRecordHolder modelRecords,
	// final PrintWriter pluginWriter, final PrintWriter propertiesWriter) {
	//
	// final Set<String> generalModelCategories =
	// extractGeneralModelCategories(modelRecords);
	//
	// final Map<String, String> allCategories = generateAllCategories(
	// ID_MODEL_GEOGRAPHY_CATEGORY, generalModelCategories);
	//
	// for (final Entry<String, String> categoryEntry : allCategories
	// .entrySet()) {
	// pluginWriter.println(categoryEntry.getValue());
	// } // for each categoryEntry
	//
	// } // outputGeneralModelCategories
	// /**
	// * @param modelRecords
	// * @return
	// */
	// private static Set<String> extractGeneralModelCategories(
	// final ModelRecordHolder modelRecords) {
	// final Set<String> retValue = new TreeSet<String>();
	// for (final GeneralModelRecord generalRecord : modelRecords
	// .getGeneralModels()) {
	// final String category = generalRecord.getCategory();
	// // Is this a category unique to general records?
	// if (!category
	// .startsWith(ID_MODEL_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY)) {
	// // Yes
	// retValue.add(category);
	// } // if
	// } // for each GeneralModelRecord
	//
	// return retValue;
	// } // extractGeneralModelCategories
	// /**
	// * @param diseaseScenarios
	// * @param pluginWriter
	// * @param propertiesWriter
	// */
	// private static void outputScenarioCategories(
	// final List<ScenarioRecord> diseaseScenarios,
	// final PrintWriter pluginWriter, final PrintWriter propertiesWriter) {
	// final Set<String> scenarioCategories =
	// extractScenarioCategories(diseaseScenarios);
	//
	// final Map<String, String> allCategories = generateAllCategories(
	// ID_SCENARIO_CATEGORY, scenarioCategories);
	//
	// for (final Entry<String, String> categoryEntry : allCategories
	// .entrySet()) {
	// pluginWriter.println(categoryEntry.getValue());
	// } // for each categoryEntry
	// } // outputScenarioCategories
	// /**
	// * @param categoryPrefix
	// * the prefix for all generated categories
	// * @param scenarioCategories
	// * @return
	// */
	// private static Map<String, String> generateAllCategories(
	// final String categoryPrefix, final Set<String> scenarioCategories) {
	// final Map<String, String> retValue = new TreeMap<String, String>();
	//
	// for (String category : scenarioCategories) {
	// // Skip it?
	// if (!category.equals(categoryPrefix)) {
	// // No
	// category = category.substring(categoryPrefix.length() + 1);
	// // We need to break down a category of "foo.bar.boo" into two
	// // strings "foo" and "foo.bar"
	// final StringTokenizer st = new StringTokenizer(category, ".");
	// String parentCategory = categoryPrefix;
	// String tempCategory = categoryPrefix;
	// while (st.hasMoreTokens()) {
	// final String temp = st.nextToken();
	// tempCategory = tempCategory + "." + temp;
	// final String key = temp.length() == 3 ? temp.toUpperCase()
	// : temp.substring(0, 1).toUpperCase()
	// + temp.substring(1);
	//
	// final StringBuilder sb = new StringBuilder(
	// "<stem_category id=\"");
	// sb.append(tempCategory);
	// sb.append("\" name=\"");
	// sb.append(key);
	// sb.append("\" parent_id=\"");
	// sb.append(parentCategory);
	// sb.append("\" />");
	//
	// retValue.put(key, sb.toString());
	// parentCategory = tempCategory;
	// } // while st.hasMoreTokens()
	//
	// } // if standard category
	// } // for each category
	// return retValue;
	// } // generateAllCategories
	// /**
	// * @param scenarios
	// * @return the {@link Set} of {@link Scenario} categories.
	// */
	// private static Set<String> extractScenarioCategories(
	// final List<ScenarioRecord> scenarios) {
	// final Set<String> retValue = new TreeSet<String>();
	// for (final ScenarioRecord scenarioRecord : scenarios) {
	// retValue.add(scenarioRecord.getCategory());
	// } // for each ScenarioRecord
	//
	// return retValue;
	// } // extractScenarioCategories
	// /**
	// * @param dataSetRecords
	// * @return a sorted list of the {@link ISOKey}s found in the
	// * {@link DataSetRecord}s
	// */
	// private static List<ISOKey> getISOKeys(
	// final DataSetRecordHolder dataSetRecords) {
	// final List<ISOKey> retValue = new ArrayList<ISOKey>();
	//
	// final Set<ISOKey> keySet = new HashSet<ISOKey>();
	//
	// // Nodes
	// keySet.addAll(dataSetRecords.getNodeGraphRecords().keySet());
	//
	// // Labels
	// final Map<String, Map<ISOKey, Map<Record.AdminLevel,
	// CountryGraphRecord.CountryLabelGraphRecord>>> labelMap = dataSetRecords
	// .getLabelGraphRecords();
	//
	// for (final Map.Entry<String, Map<ISOKey, Map<Record.AdminLevel,
	// CountryGraphRecord.CountryLabelGraphRecord>>> labelMapEntry : labelMap
	// .entrySet()) {
	// keySet.addAll(labelMapEntry.getValue().keySet());
	// } // for
	//
	// // Edges
	// final Map<String, Map<ISOKey, Map<AdminLevel, Map<ISOKey, Map<AdminLevel,
	// RelationshipGraphRecord>>>>> edgeMap = dataSetRecords
	// .getEdgeGraphRecords();
	// for (final Map.Entry<String, Map<ISOKey, Map<AdminLevel, Map<ISOKey,
	// Map<AdminLevel, RelationshipGraphRecord>>>>> edgeMapEntry : edgeMap
	// .entrySet()) {
	// keySet.addAll(edgeMapEntry.getValue().keySet());
	// } // for each edge map entry
	//
	// retValue.addAll(keySet);
	// Collections.sort(retValue);
	// return retValue;
	// } // getISOKeys
	// /**
	// * @param modelRecords
	// * @return a sorted list of the {@link ISOKey}s found in the
	// * {@link ModelRecord}
	// */
	// private static List<ISOKey> getISOKeys(final ModelRecordHolder
	// modelRecords) {
	// final List<ISOKey> retValue = new ArrayList<ISOKey>();
	//
	// final Set<ISOKey> keySet = new HashSet<ISOKey>();
	//
	// // **** Country Models ****
	// for (final CountryModelRecord cmr : modelRecords
	// .getCountryModelRecords()) {
	// keySet.add(cmr.getIsoKey());
	// } // for each country model record
	//
	// // **** Full Country Model Records ****
	// for (final FullCountryModelRecord fcmr : modelRecords
	// .getFullCountryModelRecords()) {
	// keySet.add(fcmr.getIsoKey());
	// } // for each full country model record
	//
	// // **** Full Country disease Model Records ****
	// for (final FullCountryModelRecord fcdmr : modelRecords
	// .getFullCountryDiseaseModelRecords()) {
	// keySet.add(fcdmr.getIsoKey());
	// } // for each full country disease model record
	//
	// // **** Geographic Country Models ****
	// for (final GeographicCountryModelRecord gcmr : modelRecords
	// .getGeographicCountryModelRecords()) {
	// keySet.add(gcmr.getIsoKey());
	// } // for each geographic country model record
	//
	// // **** Earth ****
	// keySet.add(modelRecords.getEarthModel().getIsoKey());
	//
	// retValue.addAll(keySet);
	// Collections.sort(retValue);
	//
	// return retValue;
	// } // getISOKeys
	/**
	 * @param categoryId
	 * @param key
	 */
	private String createISOCategoryID(final String categoryId, final ISOKey key) {
		final StringBuilder sb = new StringBuilder(categoryId);
		sb.append("."); //$NON-NLS-1$
		sb.append(key.getKey().toLowerCase());
		return sb.toString();
	} // createISOCategoryID

	/**
	 * @param propertiesWriter
	 */
	private void outputPluginPropertiesHeader(final PrintWriter propertiesWriter) {
		propertiesWriter.println("# Generated Content. Do not edit."); //$NON-NLS-1$
		propertiesWriter
				.println("# Generated: " + createGeneratedDateComment()); //$NON-NLS-1$
		propertiesWriter
				.println("pluginName = STEM Geographic Definitions (Incubation)"); //$NON-NLS-1$
		propertiesWriter.println("providerName = " + PROVIDER_NAME); //$NON-NLS-1$
	} // outputPluginPropertiesHeader

	/**
	 * @param pluginWriter
	 * @param propertiesWriter
	 */
	private void outputGraphExtensionsHeader(final PrintWriter pluginWriter,
			final PrintWriter propertiesWriter, boolean toDeclareCategories) {
		pluginWriter.println("<!-- *********** Graphs *********** -->"); //$NON-NLS-1$
		pluginWriter.println("<extension point=\"" + GRAPH_EXTENSION_POINT_ID //$NON-NLS-1$
				+ "\">"); //$NON-NLS-1$

		if (toDeclareCategories) {
			pluginWriter.println("<stem_category id=\"" + ID_GRAPH_CATEGORY //$NON-NLS-1$
					+ "\" name=\"%" + UI_STEM_CATEGORY_NAME //$NON-NLS-1$
					+ "\" parent_id=\"/\"/>"); //$NON-NLS-1$
	
			pluginWriter.println("<stem_category id=\"" //$NON-NLS-1$
					+ ID_GRAPH_GEOGRAPHY_CATEGORY + "\" name=\"%" //$NON-NLS-1$
					+ UI_GEOGRAPHY_CATEGORY_NAME + "\" parent_id=\"" //$NON-NLS-1$
					+ ID_GRAPH_CATEGORY + "\"/>"); //$NON-NLS-1$
			pluginWriter.println("<stem_category id=\"" //$NON-NLS-1$
					+ ID_GRAPH_GEOGRAPHY_POLITICAL_CATEGORY + "\" name=\"%" //$NON-NLS-1$
					+ UI_POLITICAL_CATEGORY_NAME + "\" parent_id=\"" //$NON-NLS-1$
					+ ID_GRAPH_GEOGRAPHY_CATEGORY + "\"/>"); //$NON-NLS-1$
			pluginWriter.println("<stem_category id=\"" //$NON-NLS-1$
					+ ID_GRAPH_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY
					+ "\" name=\"%" + UI_COUNTRIES_CATEGORY_NAME //$NON-NLS-1$
					+ "\" parent_id=\"" + ID_GRAPH_GEOGRAPHY_POLITICAL_CATEGORY //$NON-NLS-1$
					+ "\"/>"); //$NON-NLS-1$
		}

		propertiesWriter.println("# *********** Graphs ***********"); //$NON-NLS-1$
		propertiesWriter.println(UI_GEOGRAPHY_CATEGORY_NAME + " = " //$NON-NLS-1$
				+ GEOGRAPHY_CATEGORY_NAME);
		propertiesWriter.println(UI_POLITICAL_CATEGORY_NAME + " = " //$NON-NLS-1$
				+ POLITITCAL_CATEGORY_NAME);
		propertiesWriter.println(UI_COUNTRIES_CATEGORY_NAME + " = " //$NON-NLS-1$
				+ COUNTRIES_CATEGORY_NAME);

	} // outputGraphExtensionsHeader

	/**
	 * @param pluginWriter
	 */
	private void outputGraphExtensionsFooter(
			final PrintWriter pluginWriter) {
		pluginWriter.println("</extension>"); //$NON-NLS-1$
	} // outputGraphExtensionsFooter

	// /**
	// * @param pluginWriter
	// * @param propertiesWriter
	// */
	// private static void outputModelExtensionsHeader(
	// final PrintWriter pluginWriter, final PrintWriter propertiesWriter) {
	//
	// pluginWriter.println("<!-- *********** Models *********** -->");
	// pluginWriter.println("<extension point=\"" + MODEL_EXTENSION_POINT_ID
	// + "\">");
	//
	// pluginWriter.println("<stem_category id=\"" + ID_MODEL_CATEGORY
	// + "\" name=\"%" + UI_STEM_CATEGORY_NAME
	// + "\" parent_id=\"/\"/>");
	//
	// pluginWriter.println("<stem_category id=\""
	// + ID_MODEL_GEOGRAPHY_CATEGORY + "\" name=\"%"
	// + UI_GEOGRAPHY_CATEGORY_NAME + "\" parent_id=\""
	// + ID_MODEL_CATEGORY + "\"/>");
	// pluginWriter.println("<stem_category id=\""
	// + ID_MODEL_GEOGRAPHY_POLITICAL_CATEGORY + "\" name=\"%"
	// + UI_POLITICAL_CATEGORY_NAME + "\" parent_id=\""
	// + ID_MODEL_GEOGRAPHY_CATEGORY + "\"/>");
	// pluginWriter.println("<stem_category id=\""
	// + ID_MODEL_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY
	// + "\" name=\"%" + UI_COUNTRIES_CATEGORY_NAME
	// + "\" parent_id=\"" + ID_MODEL_GEOGRAPHY_POLITICAL_CATEGORY
	// + "\"/>");
	//
	// } // outputModelExtensionsHeader
	//
	// /**
	// * @param pluginWriter
	// */
	// private static void outputModelExtensionsFooter(
	// final PrintWriter pluginWriter) {
	// pluginWriter.println("</extension>");
	// } // outputModelExtensionsFooter

	/**
	 * @param pluginWriter
	 * @param propertiesWriter
	 */
//	private void outputScenarioExtensionsHeader(final PrintWriter pluginWriter,
//			final PrintWriter propertiesWriter) {
//		pluginWriter.println("<!-- *********** Scenarios *********** -->");
//		pluginWriter.println("<extension point=\""
//				+ SCENARIO_EXTENSION_POINT_ID + "\">");
//
//		pluginWriter.println("<stem_category id=\"" + ID_SCENARIO_CATEGORY
//				+ "\" name=\"%" + UI_STEM_CATEGORY_NAME
//				+ "\" parent_id=\"/\"/>");
//
//		propertiesWriter.println("# *********** Scenarios ***********");
//		propertiesWriter.println(UI_STEM_CATEGORY_NAME + " = "
//				+ STEM_CATEGORY_NAME);
//	} // outputScenarioExtensionsHeader
//
//	/**
//	 * @param pluginWriter
//	 * @param propertiesWriter
//	 */
//	private void outputScenarioExtensionsFooter(final PrintWriter pluginWriter,
//			final PrintWriter propertiesWriter) {
//		pluginWriter.println("</extension>");
//	} // outputScenarioExtensionsFooter

} // GeographyPluginFileGenerator
