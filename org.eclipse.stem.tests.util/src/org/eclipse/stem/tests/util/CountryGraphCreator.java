// CountryGraphCreator.java
package org.eclipse.stem.tests.util;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapter;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.impl.AreaLabelImpl;
import org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl;
import org.eclipse.stem.definitions.nodes.NodesFactory;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.definitions.nodes.impl.RegionImpl;
import org.eclipse.stem.tests.util.CountryDirectoryUtilities.CountryCode;

/**
 * This class generates the plugged in Graph files for STEM from the basic
 * properties files.
 */
public class CountryGraphCreator {

	/**
	 * The directory in the plugin that is the root of all resources (i.e.
	 * files, data, etc.)
	 */
	public static final String RESOURCES_DIR = "resources";

	/**
	 * This is the name of the root directory containing data for the
	 * definitions of graphs.
	 */
	public static final String DATA_DIR = "data";

	/**
	 * The name of the directory under {@link #DATA_DIR} that contains "country"
	 * sub-directories named by their ISO30166-1 alpha3 codes. The country
	 * directories contain the property files that define the details for each
	 * country.
	 */
	public static final String COUNTRY_DIR = "country";

	/**
	 * The root directory for generated files.
	 */
	public static final String ROOT_OUTPUT_DIR = "temp";

	/**
	 * This is the name of the directory under the {@link #ROOT_OUTPUT_DIR} that
	 * contains the directories that contain the graphs that define the
	 * geographies and features of countries.
	 */
	public static final String GRAPH_OUTPUT_DIR = "graphs";

	/**
	 * This is the path to the country graphs directory
	 */
	public static final String COUNTRY_GRAPH_PATH = ROOT_OUTPUT_DIR
			+ File.separator + GRAPH_OUTPUT_DIR + File.separator + COUNTRY_DIR;

	/**
	 * The name of the STEM category
	 */
	public static final String STEM = "STEM";

	/**
	 * 
	 */
	public static final String GEOGRAPHY = "Geography";

	/**
	 * 
	 */
	public static final String POLITICAL = "Political";

	/**
	 * 
	 */
	public static final String COUNTRIES = "Countries";

	/**
	 * 
	 */
	public static final String LEVEL = "Level";

	private static final String ID_GEOGRAPHY_PLUGIN = "org.eclipse.stem."
			+ GEOGRAPHY.toLowerCase();

	/**
	 * This is the prefix of the platform URI for geography graphs and models
	 */
	public static final String GEOGRAPHY_FILE_URI_PREFIX = "platform:/plugin/"
			+ ID_GEOGRAPHY_PLUGIN + "/resources/data";

	/**
	 * This is the format string for the identifier of a country graph or model
	 * file
	 */
	public static final String IDENTIFIER_FORMAT = "{0}/" + COUNTRY_DIR
			+ "/{1}/{2}.{3}";

	/**
	 * This is the id of the top-level STEM category for graphs
	 */
	private static final String ID_STEM_GRAPH_CATEGORY = Constants.ID_ROOT
			+ ".core.graph";

	/**
	 * This is the id of the extension point extended by graphs that are plugged
	 * into STEM
	 */
	// private static final String ID_GRAPH_EXTENSION_POINT = Constants.ID_ROOT
	// + ".core.graph";
	/**
	 * This is the id of the extension point extended by graphs with geographic
	 * information that are plugged into STEM
	 */
	private static final String ID_GRAPH_GEOGRAPHY_CATEGORY = ID_STEM_GRAPH_CATEGORY
			+ "." + GEOGRAPHY.toLowerCase();

	/**
	 * This is the id of the extension point extended by graphs with geographic
	 * political information that are plugged into STEM
	 */
	private static final String ID_GRAPH_POLITICAL_CATEGORY = ID_GRAPH_GEOGRAPHY_CATEGORY
			+ "." + POLITICAL.toLowerCase();

	/**
	 * This is the id of the extension point extended by graphs with geographic
	 * political information that are plugged into STEM
	 */
	private static final String ID_GRAPH_COUNTRIES_CATEGORY = ID_GRAPH_POLITICAL_CATEGORY
			+ "." + COUNTRIES.toLowerCase();

	/**
	 * The name of the file that the generated extension points are written to
	 */
	public static final String GRAPH_EXTENSION_POINT_FILE_NAME = "extension.xml";

	/**
	 * The name of the file that the generated properties are written to
	 */
	public static final String GRAPH_PLUGIN_PROPERTIES_POINT_FILE_NAME = "plugin.properties";

	/**
	 * This is the opening xml element for a graph extension point in a
	 * plugin.xml file
	 */
	public static final String XML_EXTENSION_POINT_OPEN = "<extension point=\"{0}\">";

	/**
	 * This is the closing xml element for a graph extension point in a
	 * plugin.xml file
	 */
	public static final String XML_EXTENSION_POINT_CLOSE = "</extension>";

	/**
	 * This is the opening xml element for a category in a plugin.xml file
	 */
	public static final String XML_CATEGORY_ELEMENT_OPEN = "<category id=\"{0}\" name=\"{1}\" parent_id=\"{2}\"/>";

	/**
	 * This is the opening xml element for a category in a plugin.xml file
	 */
	private static final String XML_DUBLIN_CORE_ELEMENT_OPEN = "<dublin_core category_id=\"{0}\" ";

	private static final String NLS_DELIMITER = "_";

	/**
	 * This is the format of the generated NLS keys for categories
	 */
	private static final String NLS_CATEGORY_KEY_FORMAT = "_UI_{0}_graph_category";

	private static final String NLS_DC_FEATURE_KEY_FORMAT = "_UI"
			+ NLS_DELIMITER + "{0}" + NLS_DELIMITER + "{1}" + NLS_DELIMITER
			+ "{2}" + NLS_DELIMITER + "{3}" + NLS_DELIMITER + "{4}";

	private static final EList dcFeatures = CommonPackage.Literals.DUBLIN_CORE
			.getEStructuralFeatures();

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		// Now create the graphs
		final List<CountryCode> countryCodes = CountryDirectoryUtilities
				.getAllCountryCodes();
		Collections.sort(countryCodes);

		final CountryGraphCreator cgc = new CountryGraphCreator();

		final Map<CountryCode, List<GraphRecord>> nodeGraphs = cgc
				.createGraphRecords(GEOGRAPHY_FILE_URI_PREFIX, countryCodes,
						DataType.node);

		final Map<CountryCode, List<GraphRecord>> populationGraphs = cgc
				.createGraphRecords(GEOGRAPHY_FILE_URI_PREFIX, countryCodes,
						DataType.population);

		final Map<CountryCode, List<GraphRecord>> areaGraphs = cgc
				.createGraphRecords(GEOGRAPHY_FILE_URI_PREFIX, countryCodes,
						DataType.area);
		try {
			cgc.serializeCountryGraphs(nodeGraphs, COUNTRY_GRAPH_PATH);

			cgc.serializeCountryGraphs(populationGraphs, COUNTRY_GRAPH_PATH);

			cgc.serializeCountryGraphs(areaGraphs, COUNTRY_GRAPH_PATH);

			final List<Map<CountryCode, List<GraphRecord>>> graphRecords = new ArrayList<Map<CountryCode, List<GraphRecord>>>();
			graphRecords.add(nodeGraphs);
			graphRecords.add(populationGraphs);
			graphRecords.add(areaGraphs);

			int maxAdminLevel = 0;
			maxAdminLevel = Math.max(maxAdminLevel,
					getMaxAdminLevel(nodeGraphs));
			maxAdminLevel = Math.max(maxAdminLevel,
					getMaxAdminLevel(populationGraphs));
			maxAdminLevel = Math.max(maxAdminLevel,
					getMaxAdminLevel(areaGraphs));

			final File graphExtensionFile = new File(COUNTRY_GRAPH_PATH
					+ GRAPH_EXTENSION_POINT_FILE_NAME);
			final File graphPluginPropertiesFile = new File(COUNTRY_GRAPH_PATH
					+ GRAPH_PLUGIN_PROPERTIES_POINT_FILE_NAME);

			final BufferedWriter graphOut = new BufferedWriter(new FileWriter(
					graphExtensionFile));

			final BufferedWriter pluginOut = new BufferedWriter(new FileWriter(
					graphPluginPropertiesFile));

			// Create a snippet of xml that can be included in a plugin.xml file
			// to plug into STEM the graphs we just serialized.
			cgc.generateGraphExtensionPointXML(graphRecords, countryCodes,
					maxAdminLevel, graphOut, pluginOut);
		} // try
		catch (final IOException e) {
			e.printStackTrace();
		}

		/*
		 * 
		 * Map<String, List<Map<String, Graph>>> countryGraphs = new
		 * HashMap<String, List<Map<String, Graph>>>(); List<String> graphTypes
		 * = new ArrayList<String>();
		 * 
		 * final CountryGraphCreator cgc = new CountryGraphCreator();
		 * 
		 * final List<Map<String, Graph>> countryNodeGraph = cgc
		 * .createCountryNodeGraphs(MIN_ADMIN_LEVEL, MAX_ADMIN_LEVEL,
		 * GEOGRAPHY_FILE_URI_PREFIX + "/graphs", countryCodes); final
		 * List<Map<String, GraphRecord>> countryAreaGraphRecord = cgc
		 * .createCountryAreaGraphs(MIN_ADMIN_LEVEL, MAX_ADMIN_LEVEL,
		 * GEOGRAPHY_FILE_URI_PREFIX + "/graphs", countryCodes);
		 * 
		 * final Map<String, List<Map<String, GraphRecord>>>
		 * countryPopulationGraphs = cgc
		 * .createCountryPopulationGraphs(MIN_ADMIN_LEVEL, MAX_ADMIN_LEVEL,
		 * GEOGRAPHY_FILE_URI_PREFIX + "/graphs", countryCodes);
		 * 
		 * cgc.serializeCountryGraphs(countryNodeGraph, COUNTRY_GRAPH_PATH,
		 * COUNTRY_NODE_GRAPH);
		 * 
		 * cgc.serializeCountryGraphs(countryAreaGraphRecord,
		 * COUNTRY_GRAPH_PATH, COUNTRY_AREA_GRAPH);
		 * 
		 * for (String populationIdentifer : countryPopulationGraphs.keySet()) {
		 * final List<Map<String, GraphRecord>> populationGraphRecord =
		 * countryPopulationGraphs .get(populationIdentifer);
		 * cgc.serializeCountryGraphs(populationGraphRecord, COUNTRY_GRAPH_PATH,
		 * COUNTRY_POPULATION_GRAPH); } // for each population
		 * 
		 * countryGraphs.put(COUNTRY_NODE_GRAPH, countryNodeGraph);
		 * graphTypes.add(COUNTRY_NODE_GRAPH);
		 * 
		 * countryGraphs.put(COUNTRY_AREA_GRAPH, countryAreaGraphRecord);
		 * graphTypes.add(COUNTRY_AREA_GRAPH);
		 * 
		 * try { final File graphExtensionFile = new File(COUNTRY_GRAPH_PATH +
		 * GRAPH_EXTENSION_POINT_FILE_NAME); final File
		 * graphPluginPropertiesFile = new File(COUNTRY_GRAPH_PATH +
		 * GRAPH_PLUGIN_PROPERTIES_POINT_FILE_NAME);
		 * 
		 * final BufferedWriter graphOut = new BufferedWriter(new FileWriter(
		 * graphExtensionFile));
		 * 
		 * final BufferedWriter pluginOut = new BufferedWriter(new FileWriter(
		 * graphPluginPropertiesFile)); // Create a snippet of xml that can be
		 * included in a plugin.xml file // to plug the graphs we just
		 * serialized into STEM.
		 * cgc.generateGraphExtensionPointXML(countryGraphs, graphTypes,
		 * graphOut, pluginOut); } // try catch (IOException e) {
		 * e.printStackTrace(); }
		 */
	} // main

	/**
	 * @param nodeGraphs *
	 * @return the maximum administration level found
	 */
	public static int getMaxAdminLevel(
			final Map<CountryCode, List<GraphRecord>> nodeGraphs) {
		int maxAdminLevel = 0;
		for (final List<GraphRecord> list : nodeGraphs.values()) {
			maxAdminLevel = Math.max(maxAdminLevel, getMaxAdminLevel(list));
		} // for
		return maxAdminLevel;
	} // getMaxAdminLevel

	/**
	 * @param graphRecords
	 * @return the maximum administration level found
	 */
	public static int getMaxAdminLevel(final List<GraphRecord> graphRecords) {
		int maxAdminLevel = 0;
		for (final GraphRecord graphRecord : graphRecords) {
			maxAdminLevel = Math
					.max(maxAdminLevel, graphRecord.getAdminLevel());
		}
		return maxAdminLevel;
	} // getMaxAdminLevel

	/**
	 * @param uriPathString
	 *            the path to the root directory to serialize the graphs in
	 * @param countryGraphs
	 *            a map of lists of the graph records keyed by country code
	 * @param graphDataType
	 *            the type of data in the graphs contained in the graph records
	 * @throws IOException
	 */
	private void serializeCountryGraphs(
			final Map<CountryCode, List<GraphRecord>> graphs,
			final String uriPathString) throws IOException {

		for (final CountryCode countryCode : graphs.keySet()) {
			for (final GraphRecord graphRecord : graphs.get(countryCode)) {
				graphRecord.serialize(uriPathString);
			} // for each graph record for each country
		} // for each country code

		// for (List<GraphRecord> records: graphs.values()) {
		// Record.serializeRecords((List<Record>)records, uriPathString);
		// }
	} // serializeCountryGraphs

	/**
	 * @param countryNodeGraphs
	 *            a list of maps of graphs of nodes for countries for each
	 *            adminstration level
	 * @param graphOut
	 *            the output writer for the plugin.xml file contents
	 * @param pluginOut
	 *            the output writer for the plugin.properties file contents
	 */
	private void generateGraphExtensionPointXML(
			final List<Map<CountryCode, List<GraphRecord>>> graphRecords,
			final List<CountryCode> countryCodes, final int maxAdminLevel,
			final Writer graphOut, final Writer pluginOut) {

		// The dublin core instances of the graphs likely share common
		// attributes, we can avoid duplicate entries in the files we generate
		// by finding the duplicate entries and only generating a single key for
		// the generated plugins file content.
		final Map<String, String> dcValueKeyMap = new HashMap<String, String>();

		// We also don't want to generate duplicate country categories
		final Map<String, String> countryCategories = new HashMap<String, String>();

		try {
			graphOut.write("<!-- Generated content.  Do not modify -->\n");

			graphOut.write(MessageFormat.format(XML_EXTENSION_POINT_OPEN,
					new Object[] { Constants.ID_GRAPH_EXTENSION_POINT }));
			graphOut.write("\n");

			pluginOut
					.write("#Graph NLS Keys.  Automatically generated, do not modify. "
							+ Calendar.getInstance().getTime()
							+ " "
							+ System.getProperty("user.name") + "\n");

			// Output the categories that make up the hierarchy for the graph
			// plugins (all except for the country categories which we output
			// below)
			final String[] levelCategoryId = outputCategories(
					maxAdminLevel + 1, graphOut, pluginOut);

			for (final CountryCode countryCode : countryCodes) {
				for (final Map<CountryCode, List<GraphRecord>> graphRecordMap : graphRecords) {
					for (final GraphRecord graphRecord : graphRecordMap
							.get(countryCode)) {
						// 
						outputGraphRecord(graphRecord, dcValueKeyMap,
								countryCategories, levelCategoryId, graphOut,
								pluginOut);
					}
				} // for each type of graph Record
			} // for each country code

			graphOut.write(XML_EXTENSION_POINT_CLOSE);
			graphOut.close();
			pluginOut.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}// generateGraphExtensionPointXML

	/**
	 * @param graphRecord
	 * @param dcValueKeyMap
	 * @param countryCategories
	 * @param levelCategoryId
	 * @param graphOut
	 * @param pluginOut
	 * @throws IOException
	 */
	private void outputGraphRecord(final GraphRecord graphRecord,
			final Map<String, String> dcValueKeyMap,
			final Map<String, String> countryCategories,
			final String[] levelCategoryId, final Writer graphOut,
			final Writer pluginOut) throws IOException {
		// Make everything come out in alphabetical order

		final String countryCodeString = graphRecord.getId().toLowerCase();
		final String countryCategoryId = levelCategoryId[graphRecord
				.getAdminLevel()]
				+ "." + countryCodeString;

		// Have we seen this country category id before?
		if (countryCategories.get(countryCategoryId) == null) {
			// No
			// Create a category for the country
			graphOut.write(MessageFormat.format(XML_CATEGORY_ELEMENT_OPEN,
					new Object[] { countryCategoryId, graphRecord.getId(),
							levelCategoryId[graphRecord.getAdminLevel()] }));
			graphOut.write("\n");
			// ...and remember we did so we don't do it again
			countryCategories.put(countryCategoryId, countryCategoryId);
		} // if we haven't seen this category id before

		// pluginOut.write("# Dublin Core for "
		// + graphRecord.getCountryCode().toString() + "\n");
		// // We don't NLS the ISO30166 alpha-3 codes

		outputDublinCore(graphRecord, countryCategoryId, dcValueKeyMap,
				graphOut, pluginOut);

	} // outputGraphRecord

	/**
	 * @param record
	 * @param countryCategoryId
	 * @param dcValueKeyMap
	 * @param graphOut
	 * @param pluginOut
	 * @throws IOException
	 * 
	 */
	public static void outputDublinCore(final Record record,
			final String countryCategoryId,
			final Map<String, String> dcValueKeyMap, final Writer graphOut,
			final Writer pluginOut) throws IOException {

		final DublinCore dc = record.getDublinCore();
		final StringBuilder sb = new StringBuilder(MessageFormat.format(
				XML_DUBLIN_CORE_ELEMENT_OPEN,
				new Object[] { countryCategoryId }));

		for (final Iterator featuresIter = dcFeatures.iterator(); featuresIter
				.hasNext();) {
			final EStructuralFeature dcFeature = (EStructuralFeature) featuresIter
					.next();
			// Is it set?
			if (dc.eIsSet(dcFeature)) {
				// Yes
				final String featureValue = (String) dc.eGet(dcFeature);
				sb.append(dcFeature.getName());
				sb.append("=\"");
				// Should the dublin core attribute be NLS's or not?
				if (isDublinCoreNLSFeature(dcFeature)) {
					// Yes
					// Have we output this feature value before?
					String dcFeatureKey = dcValueKeyMap.get(featureValue);
					if (dcFeatureKey == null) {
						// No
						dcFeatureKey = MessageFormat
								.format(
										NLS_DC_FEATURE_KEY_FORMAT,
										new Object[] {
												record.getId(),
												record
														.getAdminLevelsAsString(NLS_DELIMITER),
												record.getType(),
												record.getOutputType(),
												dcFeature.getName() });
						// Now we have
						dcValueKeyMap.put(featureValue, dcFeatureKey);

						sb.append("%");
						sb.append(dcFeatureKey);
						// Write the key and value out to the plugins file
						pluginOut.write(dcFeatureKey + " = " + featureValue
								+ "\n");
					} // if not output this value before
					else {
						// Yes
						// So we just use the key again because it's already in
						// properties file
						sb.append(dcFeatureKey);
					}
				} else {
					// No
					// No NLS, just use the value inline in the Dublin Core
					// element
					sb.append(featureValue);
				}
				sb.append("\" ");
			} // if feature set
		} // for features

		sb.append("/>\n");
		final String result = sb.toString();

		graphOut.write(result);
		graphOut.write("\n");
	} // outputDublinCore

	/**
	 * @param dcFeature
	 *            a {@link DublinCore} feature
	 * @return true if the feature should be NLS's
	 */
	private static boolean isDublinCoreNLSFeature(
			final EStructuralFeature dcFeature) {
		boolean retValue = false;

		switch (dcFeature.getFeatureID()) {
		case CommonPackage.DUBLIN_CORE__CONTRIBUTOR:
		case CommonPackage.DUBLIN_CORE__COVERAGE:
		case CommonPackage.DUBLIN_CORE__CREATOR:
		case CommonPackage.DUBLIN_CORE__DESCRIPTION:
		case CommonPackage.DUBLIN_CORE__LICENSE:
		case CommonPackage.DUBLIN_CORE__PUBLISHER:
		case CommonPackage.DUBLIN_CORE__RELATION:
		case CommonPackage.DUBLIN_CORE__REQUIRED:
		case CommonPackage.DUBLIN_CORE__RIGHTS:
			// case CommonPackage.DUBLIN_CORE__SOURCE:
		case CommonPackage.DUBLIN_CORE__SUBJECT:
		case CommonPackage.DUBLIN_CORE__TITLE:

			retValue = true;

			break;

		default:
			retValue = false;
			break;
		} // switch
		return retValue;
	} // isDublinCoreNLSFeature

	/**
	 * @param numLevels
	 *            the number of administration levels to generate categories for
	 * @param graphOut
	 *            the output writer for the plugin.xml file contents
	 * @param pluginOut
	 *            the output writer for the plugin.properties file contents
	 * @return an array indexed by administration level of the category ideas of
	 *         the different administration levels
	 * @throws IOException
	 *             if there is a problem writing to the output writers
	 */
	private String[] outputCategories(final int numLevels,
			final Writer graphOut, final Writer pluginOut) throws IOException {
		// The categories
		// STEM
		outputCategory(ID_STEM_GRAPH_CATEGORY, STEM, "/",
				NLS_CATEGORY_KEY_FORMAT, graphOut, pluginOut);

		// Geography
		outputCategory(ID_GRAPH_GEOGRAPHY_CATEGORY, GEOGRAPHY,
				ID_STEM_GRAPH_CATEGORY, NLS_CATEGORY_KEY_FORMAT, graphOut,
				pluginOut);

		// Political
		outputCategory(ID_GRAPH_POLITICAL_CATEGORY, POLITICAL,
				ID_GRAPH_GEOGRAPHY_CATEGORY, NLS_CATEGORY_KEY_FORMAT, graphOut,
				pluginOut);

		// Country
		outputCategory(ID_GRAPH_COUNTRIES_CATEGORY, COUNTRIES,
				ID_GRAPH_POLITICAL_CATEGORY, NLS_CATEGORY_KEY_FORMAT, graphOut,
				pluginOut);

		final String[] levelCategoryId = new String[numLevels];

		// Level
		for (int adminLevel = 0; adminLevel < numLevels; adminLevel++) {
			// Level category
			levelCategoryId[adminLevel] = ID_GRAPH_COUNTRIES_CATEGORY + "."
					+ LEVEL.toLowerCase() + adminLevel;

			outputCategory(levelCategoryId[adminLevel], LEVEL + adminLevel,
					ID_GRAPH_COUNTRIES_CATEGORY, NLS_CATEGORY_KEY_FORMAT,
					graphOut, pluginOut);
		} // for adminLevel

		graphOut.write("\n");
		pluginOut.write("\n");
		return levelCategoryId;
	} // outputcategories

	/**
	 * @param extensionPointId
	 * @param categoryId
	 * @param parentCategoryId
	 * @param nlsKeyFormat
	 * @param graphOut
	 * @param pluginOut
	 * @throws IOException
	 */
	public static void outputCategory(final String extensionPointId,
			final String categoryId, final String parentCategoryId,
			final String nlsKeyFormat, final Writer graphOut,
			final Writer pluginOut) throws IOException {
		final String nlsKey = createCategoryNLSKey(categoryId, nlsKeyFormat);
		graphOut.write(MessageFormat
				.format(XML_CATEGORY_ELEMENT_OPEN, new Object[] {
						extensionPointId, "%" + nlsKey, parentCategoryId }));
		graphOut.write("\n");

		// Hack alert!
		// For "levels", the categoryId looks like this "Level0", we want it to
		// look like this "Level 0" when we put it in the plugin.properites file
		// because this is what people will see in the application
		final String temp = categoryId.startsWith(LEVEL) ? LEVEL + " "
				+ categoryId.substring(LEVEL.length()) : categoryId;

		pluginOut.write(nlsKey + " = " + temp + "\n");
	} // outputCategory

	/**
	 * @param key
	 * @param nlsKeyFormat
	 * @return a NLS key for categories in the plugin.properites file
	 */
	public static String createCategoryNLSKey(final String key,
			final String nlsKeyFormat) {
		return MessageFormat.format(nlsKeyFormat, new Object[] { key });
	} // createCategoryNLSKey

	/**
	 * Process all of the data that defines the graph of the population labels
	 * for countries and create graphs of just population labels for a specified
	 * range of administration levels.
	 * 
	 * @param countryCodes
	 *            the ISO3166-1 alpha-3 codes of the countries to generate
	 *            graphs for
	 * @param dataType
	 *            the type of graph to creates
	 * @return stuff
	 */
	public Map<CountryCode, List<GraphRecord>> createGraphRecords(
			final List<CountryCode> countryCodes, final DataType dataType) {
		return createGraphRecords(GEOGRAPHY_FILE_URI_PREFIX, countryCodes,
				dataType);
	} // createGraphRecords

	/**
	 * Process all of the data that defines the graph of the population labels
	 * for countries and create graphs of just population labels for a specified
	 * range of administration levels.
	 * 
	 * @param dataFileURIPrefix
	 *            the URI prefix for the country graphs being created
	 * @param countryCodes
	 *            the ISO3166-1 alpha-3 codes of the countries to generate
	 *            graphs for
	 */
	private Map<CountryCode, List<GraphRecord>> createGraphRecords(
			final String dataFileURIPrefix,
			final List<CountryCode> countryCodes, final DataType dataType) {
		final Map<CountryCode, List<GraphRecord>> retValue = new HashMap<CountryCode, List<GraphRecord>>();

		// Iterate through each country
		for (final CountryCode countryCode : countryCodes) {
			// Get all of the data files for the country
			final List<File> dataFiles = CountryDirectoryUtilities
					.getDataFiles(countryCode, dataType.toString());
			for (final File file : dataFiles) {
				// Get the graph record for the file
				final GraphRecord graphRecord = RecordFactory.INSTANCE
						.createGraphRecord(dataType, countryCode,
								dataFileURIPrefix, file);

				// Did we have trouble creating the graph?
				if (graphRecord.getGraph() != null) {
					// No

					// Have we processed this country code before?
					List<GraphRecord> countryList = retValue.get(countryCode);
					if (countryList == null) {
						// No
						countryList = new ArrayList<GraphRecord>();
						retValue.put(countryCode, countryList);
					}
					countryList.add(graphRecord);
				} // if no problem creating the graph
			} // for file
		} // for each country code
		return retValue;
	} // createGraphRecords

	/**
	 * This class represents all of the different types of data files that can
	 * be defined for a country
	 */
	public enum DataType {
		/**
		 * 
		 */
		node,
		/**
		 * 
		 */
		area,
		/**
		 * 
		 */
		population;

	} // DataType

	/**
	 */
	protected static class CountryData {
		// Nothing
	} // CountryData

	/**
	 * This class contains the data that defines node in a country graph.
	 */
	private static class NodeData extends CountryData {
		/**
		 * The name of the node.
		 */
		String name = null;

		/**
		 * The identifier for the node.
		 */
		String identifier = null;

		/**
		 * @param name
		 *            name of the node.
		 * @param identifier
		 *            identifier for the node.
		 */
		public NodeData(final String identifier, final String name) {
			this.name = name;
			this.identifier = identifier;

		} // NodeData

		/**
		 * @return the code
		 */
		public final String getIdentifier() {
			return identifier;
		}

		/**
		 * @param identifier
		 *            the identifier to set
		 */
		public final void setIdentifier(final String identifier) {
			this.identifier = identifier;
		}

		/**
		 * @return the name
		 */
		public final String getName() {
			return name;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder(name);
			sb.append(" (");
			sb.append(identifier);
			return sb.toString();
		}

	} // NodeData

	/**
	 * This class represents the area in square kilometers for a specific node
	 * in a specific adminstration level
	 */
	private static class AreaData extends CountryData {

		// ISO-3166-1, ISO-3166-2, or ISO-3166-2 alpha's
		// The identifier of the node
		String identifier = "";

		// Square Km's
		String area = "";

		/**
		 * @param identifier
		 *            The identifier of the node
		 * @param area
		 *            the area of the node in square kilometers
		 */
		public AreaData(final String identifier, final String area) {
			this.identifier = identifier;
			this.area = area;
		} // AreaData

		/**
		 * @return the area of the node in square kilometers
		 */
		public final String getArea() {
			return area;
		}

		/**
		 * @return the identifier of the node
		 */
		public final String getIdentifier() {
			return identifier;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return identifier + " = " + area;
		} // toString

	} // AreaData

	/**
	 * This class represents the number of population members of a particular
	 * type who occupy a specific node. It also, includes an optional
	 * specification of the area that the population lives in. This is intended
	 * to provide better population density values when a population lives in a
	 * small area (e.g., a city) compared to the total area of the node.
	 */
	private static class PopulationData extends CountryData {

		// ISO-3166-1, ISO-3166-2, or ?
		String nodeCode = "";

		// Individuals
		String count = "";

		// Optional area occupied by population
		String area = null;

		/**
		 * @param nodeCode
		 *            the unique identifier of the node
		 * @param dataString
		 *            the string that contains the population count and optional
		 *            area extent
		 */
		public PopulationData(final String nodeCode, final String dataString) {
			super();

			this.nodeCode = nodeCode;

			// The data string contains the population count and an optional
			// specifiation of the area in square kilometers that the population
			// is distributed over. The optional area specification is used to
			// facillitate more accurate computation of the population density
			// for cases where the area of a region being labeled by the
			// population is much larger than the area where most of the
			// population exists. For instance, the case of a single city in an
			// otherwise large unoccupied region. The format of the string is
			// either a single integer for the population count, or an integer
			// followed by a comma followed by an double for the area. e.g.
			// "123" or "123, 45.6"

			final StringTokenizer st = new StringTokenizer(dataString, ", ");
			count = st.nextToken();
			area = st.hasMoreTokens() ? st.nextToken() : null;
		} // PopulationData

		/**
		 * @return the count
		 */
		public final String getCount() {
			return count;
		}

		/**
		 * @return the nodeCode
		 */
		public final String getNodeCode() {
			return nodeCode;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder(nodeCode);
			sb.append(" (");
			sb.append(count);
			sb.append(area != null ? "/" + area + "km^2" : "");
			sb.append(")");
			return sb.toString();
		} // toString

	} // PopulationData

	/**
	 * This class is a factory for GraphRecords
	 */
	public static class RecordFactory {
		/**
		 * The singleton instance of the factory
		 */
		public static final RecordFactory INSTANCE = new RecordFactory();

		/**
		 * @param dataType
		 * @param countryCode
		 * @param dataFileURIPrefix
		 * @param file
		 * @return the graph record extracted from the data file
		 */
		public GraphRecord createGraphRecord(final DataType dataType,
				final CountryCode countryCode, final String dataFileURIPrefix,
				final File file) {
			GraphRecord retValue = null;

			switch (dataType) {
			case node:
				retValue = new NodeGraphRecord();
				break;
			case area:
				retValue = new AreaGraphRecord();
				break;
			case population:
				retValue = new PopulationGraphRecord();
				break;

			default:
				throw new UnsupportedOperationException(dataType.toString()
						+ " not a recognized data type");
			} // switch

			retValue.initialize(countryCode, dataFileURIPrefix, file);
			return retValue;
		} // createGraphRecord

	} // RecordFactory

	/**
	 * This class contains metadata for a graph, model or scenario
	 */
	abstract public static class Record {

		protected static final URIConverter converter = new URIConverterImpl();

		/**
		 * This is an identifier for the graph/model/scenario being created.
		 * e.g., CountryCode
		 */
		protected String id = "";

		protected Identifiable identifiable = null;

		protected List<Integer> adminLevels = new ArrayList<Integer>();

		/**
		 * The maximum administration level in the graph/model
		 */
		protected int maxAdminLevel = -1;

		/**
		 * Default Constructor
		 */
		public Record() {
			// nothing
		} // Record

		/**
		 * @param identifiable
		 *            the identifiable (graph/model/scenario) that the metadata
		 *            describes
		 * @param id
		 *            a short identifier of the identifiable (e.g., country
		 *            code)
		 * @param adminLevel
		 *            the administration level of the contents of the
		 *            identifiable
		 */
		public Record(final Identifiable identifiable, final String id,
				final int adminLevel) {
			this(identifiable, id, Collections.singletonList(Integer
					.valueOf(adminLevel)));
		} // Record

		/**
		 * @param identifiable
		 *            the identifiable (graph/model/scenario) that the metadata
		 *            describes
		 * @param id
		 *            a short identifier of the identifiable (e.g., country
		 *            code)
		 * @param adminLevels
		 *            the administration levels of the contents of the
		 *            identifiable
		 */
		public Record(final Identifiable identifiable, final String id,
				final List<Integer> adminLevels) {
			this.identifiable = identifiable;
			this.id = id;
			addAdminLevels(adminLevels);
		} // Record

		/**
		 * @return the dublin core instance of the contained Identifiable
		 */
		public DublinCore getDublinCore() {
			return identifiable.getDublinCore();
		} // getDublinCore

		/**
		 * @return e.g., "graph", "model", "scenario"
		 */
		abstract public String getOutputType();

		/**
		 * @return the id
		 */
		public final String getId() {
			return id;
		} // getId

		/**
		 * @param adminLevel
		 *            the administration level to add to the record
		 */
		public void addAdminLevel(final int adminLevel) {
			addAdminLevel(Integer.valueOf(adminLevel));
		} // addAdminLevel

		/**
		 * @param adminLevel
		 *            the administration level to add to the record
		 */
		public void addAdminLevel(final Integer adminLevel) {
			// Is the admin level already in our collection?
			if (!adminLevels.contains(adminLevel)) {
				// No
				adminLevels.add(adminLevel);
				maxAdminLevel = Math.max(maxAdminLevel, adminLevel.intValue());
				Collections.sort(adminLevels);
			}
		} // addAdminLevel

		/**
		 * Add a list of administration levels to the colleciton of
		 * administration levels
		 * 
		 * @param adminLevels
		 *            a list of administration levels
		 */
		public void addAdminLevels(final List<Integer> adminLevels) {
			for (final Integer adminLevel : adminLevels) {
				addAdminLevel(adminLevel);
			}
		} // addAdminLevels

		/**
		 * @return the administration levels
		 */
		public final List<Integer> getAdminLevels() {
			return adminLevels;
		} // getAdminLevels

		/**
		 * @return the number of administration levels represented in the
		 *         identifiable.
		 */
		public int getNumAdminLevels() {
			return adminLevels.size();
		} // getNumAdminLevels

		/**
		 * @return the maximum administration level in teh data
		 */
		public final int getMaxAdminLevel() {
			return maxAdminLevel;
		}

		/**
		 * Serialize a list of records.
		 * 
		 * @param records
		 *            a list of Records to be serialized
		 * @param uriPathString
		 *            the path to the root directory to serialize the graphs in
		 * @throws IOException
		 */
		public static void serializeRecords(final List<Record> records,
				final String uriPathString) throws IOException {
			for (final Record record : records) {
				record.serialize(uriPathString);
			} // for each graph record for each country
		} // serializeRecords

		/**
		 * @param uriPathString
		 *            the path to the root serialization directory
		 * @throws IOException
		 */
		public void serialize(final String uriPathString) throws IOException {
			Utility.serializeIdentifiable(identifiable, converter.normalize(URI
					.createFileURI(uriPathString + File.separator + id
							+ File.separator + getSerializationFileName())));
		} // serialize

		/**
		 * @param delmiter
		 *            the string to place between the administration level
		 *            integers
		 * @return the administration level integers concatenated together with
		 *         a "_" as a delimiter
		 */
		public Object getAdminLevelsAsString(final String delmiter) {
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i < adminLevels.size(); i++) {
				// Is this the first one?
				if (i != 0) {
					// No
					sb.append(delmiter);
				}
				sb.append(adminLevels.get(i));
			}
			return sb.toString();
		} // getAdminLevelsAsString

		/**
		 * @return a string that specifies the type of Record (e.g., "node",
		 *         "model")
		 */
		abstract public String getType();

		/**
		 * @return the serialization file name
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.Record#getSerializationFileName()
		 */
		public String getSerializationFileName() {
			final StringBuilder sb = new StringBuilder(getId());
			sb.append("_");
			sb.append(getAdminLevelsAsString("_"));
			sb.append(".");
			sb.append(getOutputType());
			return sb.toString();
		} // getSerializationFileName
	} // Record

	/**
	 * This class represents
	 */
	abstract public static class GraphRecord extends Record {

		/**
		 * This is the property in a data file that specifies the date range
		 * that the data is valid for.
		 */
		public static final String VALID_PROPERTY = "VALID";

		/**
		 * This is the property in a data file that specifies the administration
		 * level the data applies to.
		 */
		public static final String ADMIN_LEVEL_PROPERTY = "ADMIN_LEVEL";

		/**
		 * This is the property in a data file that specifies the source of the
		 * data.
		 */
		public static final String SOURCE_PROPERTY = "SOURCE";

		protected Map<String, String> nonDataProperties = new HashMap<String, String>();

		/**
		 * The file name of the properties file (?)
		 */
		protected String fileName = null;

		/**
		 * The dublin core source of the data that created the graph
		 */
		protected String source = null;

		protected int year = -1;

		protected GraphRecord() {
			// nothing
		} // GraphRecord

		/**
		 * @param graph
		 * @param adminLevel
		 * @param year
		 */
		protected GraphRecord(final CountryCode countryCode,
				final String fileName, final Graph graph, final String source,
				final int adminLevel, final int year) {
			super(graph, countryCode.toString(), adminLevel);
			this.fileName = fileName;
			this.source = source;
			this.year = year;
		} // GraphRecord

		/**
		 * @return the file name
		 */
		public final String getFileName() {
			return fileName;
		}

		/**
		 * @return the graph
		 */
		public final Graph getGraph() {
			return (Graph) identifiable;
		} // getGraph

		/**
		 * @return the year
		 */
		public final int getYear() {
			return year;
		}

		protected void initialize(final CountryCode countryCode,
				final String dataFileURIPrefix, final File dataFile) {

			this.id = countryCode.toString();

			fileName = dataFile.getName().substring(0,
					dataFile.getName().indexOf(".properties"));

			if (dataFile.isFile() && dataFile.canRead()) {
				final Properties dataProperties = new Properties();
				try {
					final FileInputStream dataFileInputStream = new FileInputStream(
							dataFile);
					dataProperties.load(dataFileInputStream);

					collectNonDataProperties(dataProperties);

					// Are all of the required properties in the file?
					if (allNonDataPropertiesCollected()) {
						// Yes
						setFieldsFromNonDataProperties();

						final List<CountryData> dataSet = new ArrayList<CountryData>();

						for (final Entry<Object, Object> entry : dataProperties
								.entrySet()) {
							final String dataPropertyKey = (String) entry
									.getKey();

							// Is this a data property?
							if (isDataProperty(dataPropertyKey)) {
								// Yes
								final CountryData data = createData(
										dataPropertyKey, ((String) entry
												.getValue()).trim());
								dataSet.add(data);
							} // if data property

						} // for
						identifiable = createGraph(countryCode, dataSet);
						identifiable.setURI(URI.createURI(MessageFormat.format(
								IDENTIFIER_FORMAT, dataFileURIPrefix,
								countryCode, fileName, "graph")));
						identifiable.getDublinCore().setTitle(getFileName());
						// identifiable.getDublinCore().setIdentifier(
						// MessageFormat.format(IDENTIFIER_FORMAT,
						// dataFileURIPrefix, countryCode,
						// fileName, "graph"));

					} // if all properties are present
					else {
						// No
						System.err.println("The file \"" + dataFile.getName()
								+ "\" is missing the following properites: "
								+ getMissingNonDataProperties());
					} // else
					dataFileInputStream.close();
				} catch (final FileNotFoundException e) {
					System.err.println(e.getMessage());
				} catch (final IOException e) {
					System.err.println(e.getMessage());
				}
			} else {
				System.err.println("Trouble reading \"" + dataFile + "\"");
			}
		}// initialize

		/**
		 * @param dataPropertyKey
		 * @param dataProperty
		 */
		abstract protected CountryData createData(String dataPropertyKey,
				String dataProperty);

		/**
		 * @param countryCode2
		 * @param dataSet
		 */
		abstract protected Graph createGraph(CountryCode countryCode2,
				List<CountryData> dataSet);

		/**
		 * @param dataProperties
		 */
		protected void collectNonDataProperties(final Properties dataProperties) {
			// Get the source
			final String source = dataProperties.getProperty(SOURCE_PROPERTY);
			if (source != null) {
				nonDataProperties.put(SOURCE_PROPERTY, source);
			}

			// Get the valid date range
			final String valid = dataProperties.getProperty(VALID_PROPERTY);
			if (valid != null) {
				nonDataProperties.put(VALID_PROPERTY, valid);
			}

			// Get the admin level
			final String adminLevel = dataProperties
					.getProperty(ADMIN_LEVEL_PROPERTY);
			if (adminLevel != null) {
				nonDataProperties.put(ADMIN_LEVEL_PROPERTY, adminLevel);
			}

		} // collectNonDataProperties

		/**
		 * @return true if the property is a data property
		 */
		protected boolean isDataProperty(final String property) {
			return !(property.equals(VALID_PROPERTY)
					|| property.equals(ADMIN_LEVEL_PROPERTY) || property
					.equals(SOURCE_PROPERTY));
		} // isDataProperty

		/**
		 * @return true if all of the non-data properties have been collected
		 */
		protected boolean allNonDataPropertiesCollected() {
			return nonDataProperties.get(SOURCE_PROPERTY) != null
					&& nonDataProperties.get(ADMIN_LEVEL_PROPERTY) != null
					&& nonDataProperties.get(VALID_PROPERTY) != null;
		} // allDataPropertiesCollected

		/**
		 * @return a string with the names of the properties missing from the
		 *         non data properties
		 */
		protected CharSequence getMissingNonDataProperties() {
			final StringBuilder sb = new StringBuilder();

			sb
					.append(nonDataProperties.get(SOURCE_PROPERTY) == null ? (SOURCE_PROPERTY + " ")
							: "");
			sb
					.append(nonDataProperties.get(ADMIN_LEVEL_PROPERTY) == null ? (ADMIN_LEVEL_PROPERTY + " ")
							: "");
			sb
					.append(nonDataProperties.get(VALID_PROPERTY) == null ? (VALID_PROPERTY + " ")
							: "");
			return sb.toString();
		} // getMissingNonDataProperties

		/**
		 * 
		 */
		protected void setFieldsFromNonDataProperties() {
			source = nonDataProperties.get(SOURCE_PROPERTY);
			addAdminLevel(Integer.parseInt(nonDataProperties
					.get(ADMIN_LEVEL_PROPERTY)));
			year = extractYear(nonDataProperties.get(VALID_PROPERTY));
		} // setFieldsFromNonDataProperties

		/**
		 * @param validString
		 * @return the year of the start date
		 */
		private int extractYear(final String validString) {
			// String is of format start=2006-.... we want the 2006
			return Integer.parseInt(validString.substring(6, 10));
		} // extractYear

		/**
		 * @return the administration level of the graph
		 */
		public int getAdminLevel() {
			assert adminLevels.size() == 1;
			return adminLevels.get(0).intValue();
		} // getAdminLevel

		/**
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.Record#getSerializationFileName()
		 */
		@Override
		public String getSerializationFileName() {
			final StringBuilder sb = new StringBuilder(fileName);
			sb.append(".");
			sb.append(getOutputType());
			return sb.toString();
		} // getSerializationFileName

		/**
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.Record#getType()
		 */
		@Override
		public String getType() {
			return getGraphType();
		}

		/**
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.Record#getOutputType()
		 */
		@Override
		public String getOutputType() {
			return "graph";
		}

		/**
		 * @return a string that is the name of the graph type
		 */
		public abstract String getGraphType();

	} // GraphRecord

	/**
	 * This class bundles a graph of geographic nodes.
	 */
	private static class NodeGraphRecord extends GraphRecord {

		/**
		 * This is the property in a spatial (GML) data file that specifies the
		 * file that contains the latitude/longitude data for the nodes.
		 */
		public static final String SPATIAL_PROPERTY = "SPATIAL_URI";

		protected String spatialURI = null;

		/**
		 * 
		 */
		public NodeGraphRecord() {
			super();
		} // NodeGraphRecord

		/**
		 * @see org.eclipse.stem.utility.geography.graph.CountryGraphCreator2.GraphRecord#createData(java.lang.String,
		 *      java.lang.String)
		 */
		@Override
		protected CountryData createData(final String dataPropertyKey,
				final String dataProperty) {
			return new NodeData(dataPropertyKey, dataProperty);
		} // createData

		/**
		 * @param dataProperties
		 */
		@Override
		protected void collectNonDataProperties(final Properties dataProperties) {
			super.collectNonDataProperties(dataProperties);

			// Get the population level dates
			spatialURI = dataProperties.getProperty(SPATIAL_PROPERTY);
			if (spatialURI != null) {
				nonDataProperties.put(SPATIAL_PROPERTY, spatialURI);
			}
		} // collectNonDataProperties

		/**
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.GraphRecord#isDataProperty(java.lang.String)
		 */
		@Override
		protected boolean isDataProperty(final String property) {
			return (!property.equals(SPATIAL_PROPERTY))
					&& super.isDataProperty(property);
		} // isDataProperty

		@Override
		protected boolean allNonDataPropertiesCollected() {
			// return nonDataProperties.get(SPATIAL_PROPERTY) != null
			// && super.allNonDataPropertiesCollected();
			return super.allNonDataPropertiesCollected();
		} // allDataPropertiesCollected

		/**
		 */
		@Override
		protected String getMissingNonDataProperties() {
			final StringBuilder sb = new StringBuilder(super
					.getMissingNonDataProperties());
			sb
					.append(nonDataProperties.get(SPATIAL_PROPERTY) == null ? (SPATIAL_PROPERTY + " ")
							: "");
			return sb.toString();
		} // getMissingNonDataProperties

		/**
		 * @see org.eclipse.stem.utility.geography.graph.CountryGraphCreator2.GraphRecord#createGraph(org.eclipse.stem.data.geography.graph.CountryDirectoryUtilities.CountryCode,
		 *      java.util.List)
		 */
		@Override
		protected Graph createGraph(final CountryCode countryCode,
				final List<CountryData> dataSet) {
			Graph retValue = null;

			// Was there any data for this country at this administration level?
			if (dataSet.size() > 0) {
				// Yes
				final String adminLevel = nonDataProperties
						.get(ADMIN_LEVEL_PROPERTY);

				retValue = GraphFactory.eINSTANCE.createGraph();
				final DublinCore dc = retValue.getDublinCore();
				dc.populate();
				dc.setTitle(CountryDirectoryUtilities
						.getCountryName(countryCode)
						+ " Nodes (Level "
						+ adminLevel
						+ ", "
						+ nonDataProperties.get(VALID_PROPERTY)
						+ ", "
						+ dataSet.size()
						+ (dataSet.size() == 1 ? " node)" : " nodes)"));
				dc.setSource(nonDataProperties.get(SOURCE_PROPERTY));
				dc.setValid(nonDataProperties.get(VALID_PROPERTY));

				for (final CountryData nodeData : dataSet) {
					retValue.putNode(createNode(Integer.parseInt(adminLevel),
							countryCode, spatialURI, nodeData));
				} // for each node data

			} // if any data
			return retValue;
		} // createGraph

		/**
		 * @return a node that represents a geographic place within the context
		 *         of a specified country at a specified administration level
		 */
		private static Node createNode(final int adminLevel,
				final CountryCode countryCode, final String spatialFileURI,
				final CountryData countryData) {
			final NodeData nodeData = (NodeData) countryData;
			final Region retValue = NodesFactory.eINSTANCE.createRegion();
			retValue.setURI(RegionImpl.createRegionNodeURI(nodeData
					.getIdentifier()));
			retValue.getDublinCore().setTitle(
					nodeData.getName() + " " + nodeData.getIdentifier());

			final String dcSpatial = (spatialFileURI == null ? null
					: SpatialProviderAdapter.STEM_SPATIAL_SCHEME_PREFIX
							+ spatialFileURI + "#" + nodeData.getIdentifier());

			retValue.getDublinCore().setSpatial(dcSpatial);

			return retValue;
		} // createNode

		/**
		 * @return "node"
		 */
		@Override
		public String getGraphType() {
			return "node";
		} // getGraphType

	} // NodeGraphRecord

	/**
	 * This class bundles a graph of area labels together with the details of
	 * the labels.
	 */
	private static class AreaGraphRecord extends GraphRecord {

		/**
		 * 
		 */
		public AreaGraphRecord() {
			super();
		}

		/**
		 * @param countryCode
		 * @param fileName
		 * @param graph
		 * @param source
		 * @param adminLevel
		 * @param year
		 */
		public AreaGraphRecord(final CountryCode countryCode,
				final String fileName, final Graph graph, final String source,
				final int adminLevel, final int year) {
			super(countryCode, fileName, graph, source, adminLevel, year);
		}

		/**
		 * @see org.eclipse.stem.utility.geography.graph.CountryGraphCreator2.GraphRecord#createData(java.lang.String,
		 *      java.lang.String)
		 */
		@Override
		protected CountryData createData(final String dataPropertyKey,
				final String dataProperty) {
			return new AreaData(dataPropertyKey, dataProperty);
		} // createData

		/**
		 * @see org.eclipse.stem.utility.geography.graph.CountryGraphCreator2.GraphRecord#createGraph(org.eclipse.stem.data.geography.graph.CountryDirectoryUtilities.CountryCode,
		 *      java.util.List)
		 */
		@Override
		protected Graph createGraph(final CountryCode countryCode,
				final List<CountryData> dataSet) {
			Graph retValue = null;

			// Was there any data for this country at this administration level?
			if (dataSet.size() > 0) {
				// Yes
				final String adminLevel = nonDataProperties
						.get(ADMIN_LEVEL_PROPERTY);

				retValue = GraphFactory.eINSTANCE.createGraph();
				final DublinCore dc = retValue.getDublinCore();
				dc.populate();
				dc.setTitle(CountryDirectoryUtilities
						.getCountryName(countryCode)
						+ " Area (Level "
						+ adminLevel
						+ ", "
						+ nonDataProperties.get(VALID_PROPERTY)
						+ ", "
						+ dataSet.size()
						+ (dataSet.size() == 1 ? " label)" : " labels)"));
				dc.setSource(nonDataProperties.get(SOURCE_PROPERTY));
				dc.setValid(nonDataProperties.get(VALID_PROPERTY));
				for (final CountryData dataInstance : dataSet) {
					retValue.putNodeLabel(createAreaLabel(Integer
							.parseInt(adminLevel), countryCode, dataInstance));
				} // for each node data

			} // if any data
			return retValue;
		} // createGraph

		/**
		 * @param adminLevel
		 *            the level of the country node the area label labels
		 * @param countryCode
		 *            the identifier of the country to which the labeled node
		 *            belongs
		 * @param areaData
		 *            the area data
		 * @return an Area label
		 */
		protected AreaLabel createAreaLabel(final int adminLevel,
				final CountryCode countryCode, final CountryData countryData) {
			final AreaData areaData = (AreaData) countryData;
			final AreaLabel retValue = LabelsFactory.eINSTANCE
					.createAreaLabel();
			retValue.setURI(AreaLabelImpl.createAreaLabelURI(adminLevel,
					countryCode.toString(), areaData.getIdentifier()));
			retValue.setURIOfIdentifiableToBeLabeled(RegionImpl
					.createRegionNodeURI(areaData.getIdentifier()));
			retValue.getCurrentAreaValue().setArea(
					Double.parseDouble(areaData.getArea()));

			return retValue;
		} // createAreaLabel

		/**
		 * @return "area"
		 */
		@Override
		public String getGraphType() {
			return "area";
		} // getGraphType
	} // AreaGraphRecord

	/**
	 * This class bundles a graph of population labels together with the details
	 * of the labels. For instance, the year of the data, the administration
	 * level and the population identifier.
	 */
	private static class PopulationGraphRecord extends GraphRecord {

		/**
		 * This is the property in a population data file that specifies the
		 * population identifier.
		 */
		public static final String POPULATION_PROPERTY = "POPULATION";

		private String populationIdentifier = null;

		protected PopulationGraphRecord() {
			super();
		}

		/**
		 * @param populationGraph
		 * @param adminLevel
		 * @param year
		 * @param populationIdentifier
		 */
		protected PopulationGraphRecord(final CountryCode countryCode,
				final String fileName, final Graph populationGraph,
				final String source, final int adminLevel, final int year,
				final String populationIdentifier) {
			super(countryCode, fileName, populationGraph, source, adminLevel,
					year);
			this.populationIdentifier = populationIdentifier;
		}

		/**
		 * 
		 */
		@Override
		protected void setFieldsFromNonDataProperties() {
			super.setFieldsFromNonDataProperties();
			populationIdentifier = nonDataProperties.get(POPULATION_PROPERTY);
		} // setFieldsFromNonDataProperties

		/**
		 * @param countryCode
		 * @param dataSet
		 */
		@Override
		protected Graph createGraph(final CountryCode countryCode,
				final List<CountryData> dataSet) {
			Graph retValue = null;

			// Was there any data for this country at this administration level?
			if (dataSet.size() > 0) {
				// Yes
				final String adminLevel = nonDataProperties
						.get(ADMIN_LEVEL_PROPERTY);

				retValue = GraphFactory.eINSTANCE.createGraph();
				final DublinCore dc = retValue.getDublinCore();
				dc.populate();
				dc.setTitle(CountryDirectoryUtilities
						.getCountryName(countryCode)
						+ " Population (Level "
						+ adminLevel
						+ ", "
						+ nonDataProperties.get(POPULATION_PROPERTY)
						+ ", "
						+ nonDataProperties.get(VALID_PROPERTY)
						+ ", "
						+ dataSet.size()
						+ (dataSet.size() == 1 ? " label)" : " labels)"));
				dc.setSource(nonDataProperties.get(SOURCE_PROPERTY));
				dc.setValid(nonDataProperties.get(VALID_PROPERTY));

				for (final CountryData populationData : dataSet) {
					retValue.putNodeLabel(createPopulationLabel(Integer
							.parseInt(adminLevel), countryCode,
							nonDataProperties.get(POPULATION_PROPERTY),
							populationData));
				} // for each node data

			} // if any data
			return retValue;
		} // createGraph

		/**
		 * @param adminLevel
		 *            the level of the country node the area label labels
		 * @param countryCode
		 *            the identifier of the country to which the labeled node
		 *            belongs
		 * @param populationIdentifier
		 *            the identifier of the population
		 * @param populationData
		 *            the data to use to initialize the population label
		 * @return a population label
		 */
		private static PopulationLabel createPopulationLabel(
				final int adminLevel, final CountryCode countryCode,
				final String populationIdentifier, final CountryData dataSet) {
			final PopulationData populationData = (PopulationData) dataSet;
			final PopulationLabel retValue = LabelsFactory.eINSTANCE
					.createPopulationLabel();
			retValue.setURI(PopulationLabelImpl.createPopulationLabelURI(
					adminLevel, countryCode.toString(), populationIdentifier,
					"2006", populationData.getNodeCode()));
			retValue.setURIOfIdentifiableToBeLabeled(RegionImpl
					.createRegionNodeURI(populationData.getNodeCode()));
			retValue.setPopulationIdentifier(populationIdentifier);
			retValue.getCurrentPopulationValue().setCount(
					Long.parseLong(populationData.getCount()));

			// Was an area specified for the population?
			if (populationData.area != null) {
				// Yes
				retValue.setPopulatedArea(Double
						.parseDouble(populationData.area));
			}

			return retValue;
		} // createPopulationLabel

		/**
		 * @param dataPropertyKey
		 * @param dataProperty
		 */
		@Override
		protected CountryData createData(final String dataPropertyKey,
				final String dataProperty) {
			return new PopulationData(dataPropertyKey, dataProperty);
		} // createData

		/**
		 * @param dataProperties
		 */
		@Override
		protected void collectNonDataProperties(final Properties dataProperties) {
			super.collectNonDataProperties(dataProperties);

			// Get the population level dates
			final String populationIdentifier = dataProperties
					.getProperty(POPULATION_PROPERTY);
			if (populationIdentifier != null) {
				nonDataProperties
						.put(POPULATION_PROPERTY, populationIdentifier);
			}
		} // collectNonDataProperties

		protected final String getPopulationIdentifier() {
			return populationIdentifier;
		}

		@Override
		protected boolean isDataProperty(final String property) {
			return (!property.equals(POPULATION_PROPERTY))
					&& super.isDataProperty(property);
		}

		@Override
		protected boolean allNonDataPropertiesCollected() {
			return nonDataProperties.get(POPULATION_PROPERTY) != null
					&& super.allNonDataPropertiesCollected();
		} // allDataPropertiesCollected

		/**
		 */
		@Override
		protected String getMissingNonDataProperties() {
			final StringBuilder sb = new StringBuilder(super
					.getMissingNonDataProperties());

			sb
					.append(nonDataProperties.get(POPULATION_PROPERTY) == null ? (POPULATION_PROPERTY + " ")
							: "");
			return sb.toString();
		} // getMissingNonDataProperties

		/**
		 * @return "population"
		 */
		@Override
		public String getGraphType() {
			return "population";
		} // getGraphType
	} // PopulationGraphRecord

} // CountryGraphCreator2
