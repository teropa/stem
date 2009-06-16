package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

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

/**
 * STEM II Data Migration/Generation Utilities : Instances of this utility class
 * generate the area.properties files for all countries.
 * 
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/AreaGenerator.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\AreaGenerator.config)
 * 
 * 
 * SET VMARGS TO : -Xms1024m -Xmx1024m
 * 
 */

public class AreaGenerator {

	private String iso3166_1 = null;

	private String iso3166_2 = null;

	private String fixFile = null;

	private String targetFile = null;

	private String areaData = null;

	private String polygonAreaData = null;

	private String lexDir = null;

	private String outputDir = null;

	private String workspace = null;

	/**
	 * Lists for ISO 3166-1 codes, target countries, and population data.
	 */

	List targetList = null;

	List codeList = null;

	List codefixList = null;

	List areaList = null;

	List level1PolygonAreaList = null;

	List level2PolygonAreaList = null;

	List usaLevel2List = null;

	/**
	 * Hash set for storing the source URLs relevant to area data.
	 */
	Set<String> urlSet = null;

	/**
	 * Hash map to keep track of which sources will be shown commented out and
	 * which will appear active.
	 */
	HashMap<String, Boolean> urlStatus = null;

	/**
	 * String used to indicate default value for unknown areas.
	 */
	String DEFAULT = "0"; //$NON-NLS-1$	

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param iso3166_2 -
	 *            file with the ISO3166-2 data used for generating the IDs.
	 * @param fixFile -
	 *            file containing missing ISO3166-2 codes
	 * @param areaData -
	 *            directory conaining aread data for each country in data set.
	 * @param targetFile -
	 *            data file where we find a list of countries for generation of
	 *            their corresponding area.properties files.
	 * @param polygonAreaData -
	 *            the path to area data in polygon units
	 * @param lexDir
	 *            folder containing lexicographically sorted files
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	// public AreaGenerator(String iso3166_1, String iso3166_2, String fixFile,
	// String areaData, String targetFile, String polygonAreaData,
	// String lexDir, String outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.iso3166_2 = iso3166_2;
	// this.fixFile = fixFile;
	// this.targetFile = targetFile;
	// this.areaData = areaData;
	// this.polygonAreaData = polygonAreaData;
	// this.lexDir = lexDir;
	// this.outputDir = outputDir;
	// targetList = null;
	// // Set the URL IDs that are relevant for area data.
	// initAreaURLSet();
	// // Set which URLs are active and which ones should be commented out.
	// setURLStatus();
	//
	// }
	/**
	 * @param configFile
	 */
	public AreaGenerator(String configFile) {

		// Load all configuration variables
		HashMap<String, String> vars = GenUtils.loadConfigFile(configFile);

		Set<String> keys = vars.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String var = (String) it.next();

			// Assign values to configuration variables :
			if (var.equals("WORKSPACE")) { //$NON-NLS-1$
				workspace = vars.get(var);
			} else if (var.equals("ISO3166_1")) { //$NON-NLS-1$
				iso3166_1 = vars.get(var);
			} else if (var.equals("ISO3166_2")) { //$NON-NLS-1$
				iso3166_2 = vars.get(var);
			} else if (var.equals("ISO_FIX")) { //$NON-NLS-1$
				fixFile = vars.get(var);
			} else if (var.equals("TARGET_LIST")) { //$NON-NLS-1$
				targetFile = vars.get(var);
			} else if (var.equals("POLYGON_AREAS")) { //$NON-NLS-1$
				polygonAreaData = vars.get(var);
			} else if (var.equals("AREA_POP")) { //$NON-NLS-1$
				areaData = vars.get(var);
			} else if (var.equals("LEX_DIR")) { //$NON-NLS-1$
				lexDir = vars.get(var);
			} else if (var.equals("PROPERTIES_OUTPUT")) { //$NON-NLS-1$
				outputDir = vars.get(var);
			}

		} // while

		// The workspace variable should end with a slash character
		if (workspace.endsWith("\\") == false) { //$NON-NLS-1$
			workspace += "\\"; //$NON-NLS-1$
		}

		String path = workspace + GenConstants.PARAMS_DIR;

		// Set remaining config vars using WORKSPACE (workspace relative)
		if (iso3166_1 == null) {
			iso3166_1 = path + GenConstants.ISO3166_1_FILE;
		}
		if (iso3166_2 == null) {
			iso3166_2 = path + GenConstants.ISO3166_2_FILE;
		}
		if (fixFile == null) {
			fixFile = path + GenConstants.ISOFIX_FILE;
		}
		if (targetFile == null) {
			targetFile = path + GenConstants.GROUPED_COUNTRIES;
		}
		if (polygonAreaData == null) {
			polygonAreaData = path + GenConstants.POLYGON_AREAS_DIR;
		}
		if (areaData == null) {
			areaData = path + GenConstants.AREA_POPULATION_DIR;
		}
		if (lexDir == null) {
			lexDir = path + GenConstants.LEX_DIR;
		}
		if (outputDir == null) {
			outputDir = workspace + GenConstants.PROPERTIES_OUTPUT_DIR;
		}

		targetList = null;
		// Set the URL IDs that are relevant for area data.
		initAreaURLSet();
		// Set which URLs are active and which ones should be commented out.
		setURLStatus();

	}

	/**
	 * Sets the URL IDs relevant for area data. We are only interested in URLs
	 * with ID = DIVA. This can be different for different types of data. For
	 * example, for population data, we are interested on ID = CIA
	 */
	protected void initAreaURLSet() {
		urlSet = new HashSet<String>();
		urlSet.add(new String("CIA")); //$NON-NLS-1$
		urlSet.add(new String("USCENSUSAREA")); //$NON-NLS-1$
		urlSet.add(new String("USCENSUSBOUNDS")); //$NON-NLS-1$
		urlSet.add(new String("USCENSUSPUERTORICO")); //$NON-NLS-1$
		urlSet.add(new String("CITYPOPULATION")); //$NON-NLS-1$
		urlSet.add(new String("UNITEDNATIONS")); //$NON-NLS-1$
	}

	/**
	 * Set which URL appears as uncommented or ACTIVE and which ones appear as
	 * commented out or SECONDARY. Only URL should be active. All others should
	 * appear commented.
	 * 
	 */
	protected void setURLStatus() {
		urlStatus = new HashMap<String, Boolean>();
		// This will be the active URL.
		urlStatus.put("CIA", new Boolean(true)); //$NON-NLS-1$
		// All other URLs appear as commented out, secondary.
		urlStatus.put("USCENSUSAREA", new Boolean(false)); //$NON-NLS-1$
		urlStatus.put("USCENSUSBOUNDS", new Boolean(false)); //$NON-NLS-1$
		urlStatus.put("USCENSUSPUERTORICO", new Boolean(false)); //$NON-NLS-1$
		urlStatus.put("CIA", new Boolean(false)); //$NON-NLS-1$
		urlStatus.put("CITYPOPULATION", new Boolean(false)); //$NON-NLS-1$
		urlStatus.put("UNITEDNATIONS", new Boolean(true)); //$NON-NLS-1$
	}

	/**
	 * This method sets up and runs this generator.
	 * 
	 */
	public void run() {

		// Read and keep in memory a list of the countries we want.
		targetList = GenUtils.populateList(targetFile);

		// Read and keep in memory a list of the ISO3166-1 ALPHA2, ALPHA3, and
		// numeric codes.
		codeList = GenUtils.populateList(iso3166_1);

		// Read and keep in memory a list of the missing ISO3166-2 codes
		codefixList = GenUtils.populateList(fixFile);

		// THIS IS AN SPECIAL CASE.
		// FOR THE USA ONLY, WE HAVE THE LEVEL 2 DATA FOR ALL COUNTIES.
		usaLevel2List = GenUtils.populateList(GenConstants.USA_LEVEL_2_AREA);

		// Now, process each item in the target list.
		process();
	}

	/**
	 * Process our global list of target countries. For each country in list,
	 * generate its area.properties file.
	 * 
	 */
	protected void process() {

		final int LEVEL_1 = 1;
		final int LEVEL_2 = 2;

		// A writer for the new file we are creating.
		PrintWriter propertiesFile = null;

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

		// Name of the new properties file.
		String fileName = null;

		// A list for ISO 3166-2 objects
		List iso2List = new ArrayList();

		// Level 0 area in square kilometers
		String level0AreaSqKm = null;

		// Aggregate polygon area for level 1
		String aggregateLevel1PolygonArea = null;

		// Value used as default to compute the
		// approximate area of an unknown location
		String defaultAreaSqKm = DEFAULT;
		String defaultPolygonArea = DEFAULT;

		// Filenames for lex1 and lex2 files for a given country.
		String lexAdmin1File = null;
		String lexAdmin2File = null;

		// Lists holding the lex1 and lex2 values.
		// NOTE: lex values are the lexicographically sorted values for
		// administration levels.
		List<String> lex1DataSet = null;
		List<String> lex2DataSet = null;

		// Lists for holding lex1 and lex2 objects for a given country.
		List<Lex1Obj> lex1List = null;
		List<Lex2Obj> lex2List = null;

		int size = targetList.size();

		// Iterate for every country and create its names.properties file.
		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = ((String) targetList.get(i)).trim();

			// An index for unknwon or n.a. entries
			int unkCounter = 1;

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);

			System.out
					.println("\t\t<<<< AREA GENERATOR -- Processing country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$
			try {

				if (reader != null) {

					String buffer = null;
					// Describes level
					// of data we
					// are now processing : LEVEL0, LEVEL1, or LEVEL2.
					int level = -1;

					// Record the previous level.
					int oldLevel = level - 1;

					// We take a chunk of the data [BUFFER_MIN,BUFFER_MAX] to
					// make processing more
					// efficient, we dont need all of it.
					int BUFFER_MIN = 0;
					int BUFFER_MAX = 120;

					List<String> entryList = null;

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						// Use only part of the buffer, not all of it for
						// efficieny.
						String[] items = GenUtils
								.extract(buffer.length() < BUFFER_MAX ? buffer
										: buffer.substring(BUFFER_MIN,
												BUFFER_MAX));

						// Get the ISO3166-1 info for this country
						if (isoCode == null) {
							isoCode = GenUtils.getISOCode(
									items[ISOData.COUNTRY_NAME], codeList);
						}

						// Read and keep in memory a list of the area data
						// for this country.
						if (areaList == null) {
							String name = areaData + isoCode.getName()
									+ "_AREA.txt"; //$NON-NLS-1$
							areaList = GenUtils.populateList(name);
						}

						// Get the level of the data we are processing.
						level = GenUtils.getDataLevel(items);

						if (level != 0 && iso2List != null) {
							// Load the ISO 3166-2 objects for this country
							iso2List = GenUtils.loadISO2(iso3166_2);
						}

						// This variable indicates a transition in our data
						// processing
						boolean transition = (level != oldLevel) ? true : false;

						// Variable used to hold the formatted output data.
						String data = null;

						// The current entity we are dealing with.
						// Based on its admin level it can be a country, a
						// county, etc;
						String current = null;

						// Descriptor for current entry.
						String descriptor = null;

						if (transition == true) {
							// Keep track of previous level in order to detect
							// transitions.
							oldLevel = level;
							// Reset our repeated history
							if (entryList != null) {
								entryList.clear();
							}
							entryList = new ArrayList<String>();

							// Reset counter of UNKNOWN and N.A. entries.
							unkCounter = 1;
							// Close previous file if it is still open.
							if (propertiesFile != null) {
								System.out.println("\t\t<<Generated : " //$NON-NLS-1$
										+ fileName + ">>"); //$NON-NLS-1$
								propertiesFile.close();
								propertiesFile = null;
								fileName = null;
							}

							// Read and keep in memory a list of the level 1
							// area data
							// in polygon units for this country.
							if (level1PolygonAreaList == null && level == 1) {

								// Load the polygon area data for level 1.
								String name = polygonAreaData
										+ isoCode.getAlpha3()
										+ "\\" //$NON-NLS-1$
										+ isoCode.getAlpha3()
										+ "_1_POLYAREA.txt"; //$NON-NLS-1$

								// Load level 1 polygon area list
								level1PolygonAreaList = GenUtils
										.populateList(name);

								// Find the level 0 area in square kilometers
								level0AreaSqKm = getArea(
										items[ISOData.COUNTRY_NAME],
										items[ISOData.COUNTRY_NAME], areaList,
										0);

								// Find the aggregate polygon area for level 1
								aggregateLevel1PolygonArea = getAggregateArea(level1PolygonAreaList);
							}

							// Read and keep in memory a list of the level 2
							// area data
							// in polygon units for this country.
							if (level2PolygonAreaList == null && level == 2) {

								// Load the polygon area data for level 2.
								String name = polygonAreaData
										+ isoCode.getAlpha3()
										+ "\\" + isoCode.getAlpha3() //$NON-NLS-1$
										+ "_2_POLYAREA.txt"; //$NON-NLS-1$

								level2PolygonAreaList = GenUtils
										.populateList(name);

							}

						}

						// If the directory does not exist for this country,
						// create it using ISO alpha3 code.
						File countryDir = new File(outputDir
								+ isoCode.getAlpha3());

						if (countryDir != null && countryDir.exists() == false) {
							// Directory does not exist. Create it.
							countryDir.mkdir();
						}

						// Create and open the new file.
						if (propertiesFile == null) {
							// Create the file name for the new properties.file.
							fileName = countryDir + "\\" + isoCode.getAlpha3() //$NON-NLS-1$
									+ "_" + level + "_" + "area.properties"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							// Create tne new properties.file for this country.
							propertiesFile = GenUtils.openWriter(fileName);
						}

						// If we have switched to a different data level (i,e,
						// admin 0 to admin 1)
						if (transition == true) {
							// Just add the header.
							data = getHeader(isoCode, level);
							GenUtils.addData(propertiesFile, data);
							// Forget the data we just wrote.
							data = null;
						}

						switch (level) {

						case DataTypes.LEVEL_0:

							if (transition == true) {
								data = "# Country\n"; //$NON-NLS-1$
								data += isoCode.getAlpha3()
										+ " = " //$NON-NLS-1$
										+ getArea(items[ISOData.COUNTRY_NAME],
												level) + "\n"; //$NON-NLS-1$
								// Write formatted output
								GenUtils.addData(propertiesFile, data);
							}
							continue;

						case DataTypes.LEVEL_1:

							current = items[ISOData.ADMIN1_NAME].toUpperCase();
							break;

						case DataTypes.LEVEL_2:

							current = items[ISOData.ADMIN2_NAME].toUpperCase();
							break;

						} // switch

						// Handle UNKNOWN and N.A. entries differently.
						if (current.equals("UNKNOWN") || current.equals("N.A.")) { //$NON-NLS-1$ //$NON-NLS-2$

							if (level == 1) {
								current = isoCode.getAlpha2() + "-UNK-" //$NON-NLS-1$
										+ String.valueOf(unkCounter++);
							} else {
								// Level 2 data.
								current = isoCode.getAlpha3() + ".L2." //$NON-NLS-1$
										+ String.valueOf(unkCounter++);
							}
						}

						// Verify for repeated entries -- avoid duplcates
						switch (level) {

						case LEVEL_1:
							if (GenUtils.isRepeated(current, entryList) == true) {
								// Duplicated, ignore.
								continue;
							}
							// Remember this entity to avoid duplicates.
							entryList.add(current);
							break;

						case LEVEL_2:
							if (GenUtils.isRepeated(items[ISOData.ADMIN1_NAME]
									+ current, entryList) == true) {
								// Duplicated, ignore.
								continue;
							}
							// Remember this entity to avoid duplicates.
							entryList.add(items[ISOData.ADMIN1_NAME] + current);
							break;

						}

						// We get the descriptor for administration entities
						// differently based on its level.
						if (level == 2) {

							if (lex1DataSet == null && lex2DataSet == null) {

								// Compose the file names for the lex files for
								// this country
								lexAdmin1File = lexDir + isoCode.getAlpha3()
										+ "\\" + isoCode.getAlpha3(); //$NON-NLS-1$
								lexAdmin2File = lexAdmin1File;
								lexAdmin1File += "_ADMIN1_LEX.txt"; //$NON-NLS-1$
								lexAdmin2File += "_ADMIN2_LEX.txt"; //$NON-NLS-1$

								// Load the lex1 and lex2 files for this
								// country.
								lex1DataSet = GenUtils
										.populateList(lexAdmin1File);
								lex2DataSet = GenUtils
										.populateList(lexAdmin2File);

								// Create a method to search for an item on a
								// list
								// of lex data objects.
								lex1List = GenUtils.createLex1List(lex1DataSet);
								lex2List = GenUtils.createLex2List(lex2DataSet);

							}

							// Compose the level2 descriptor using the lex data:

							// STEP 1: Do a look up in the lex 2 lists.

							// Get the lex 2 object for the current entry.
							Lex2Obj lex2Current = GenUtils.lex2Lookup(lex2List,
									items[ISOData.ADMIN1_NAME], current);

							// Get the lex 1 object to which lex2Current belongs
							// to.
							Lex1Obj lex1Current = GenUtils.lex1Lookup(lex1List,
									lex2Current.getAdmin1());

							// STEP 2: piece together the ID using the
							// proper lex objects : the USA is a special
							// case
							if (lex1Current.getDescriptor().contains("US-")) { //$NON-NLS-1$
								descriptor = lex1Current.getDescriptor()
										+ "-" //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndexUSA();
							} else {
								descriptor = lex1Current.getDescriptor()
										+ "-G" //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndex();
								// Add some commens to allow reverse engineering
								// or backtracking the origin of this generated
								// key as much as possible.
								data = "# Generated key details : " //$NON-NLS-1$
										+ " Level 1 ( " //$NON-NLS-1$
										+ lex1Current.getDescriptor()
										+ " = " //$NON-NLS-1$
										+ lex1Current.getAdmin1()
										+ "). " //$NON-NLS-1$
										+ "Level 2" //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndex()
										+ " = " + lex2Current.getAdmin2() //$NON-NLS-1$
										+ "). \n"; //$NON-NLS-1$
							}

						} else { // Compose descriptor for level 1 and level
							// 0 data.
							// Get the descriptor for this entity.
							descriptor = GenUtils.getISO2Descriptor(iso2List,
									current, isoCode.getAlpha2());

							// If we cant find the descriptor, then look in the
							// fix list.
							if (descriptor.equals(current) == true) {
								// Look for a descriptor in the fix file
								descriptor = GenUtils.getFixCode(codefixList,
										current, items[ISOData.COUNTRY_NAME]);

								// If there is no descriptor still, generate
								// one!
								if (descriptor.equals(current) == true) {
									descriptor = isoCode.getAlpha2() + "-" //$NON-NLS-1$
											+ current;
								}
							}

							data = "#" + current + "\n"; //$NON-NLS-1$ //$NON-NLS-2$

						}

						String area = DEFAULT;
						String level1AreaSqKm = DEFAULT;

						switch (level) {

						case 1:

							if (descriptor.contains("UNK") == false) { //$NON-NLS-1$
								area = getArea(current,
										items[ISOData.COUNTRY_NAME], areaList,
										level);
							} else {
								// Use the following formula to compute
								// approximate area :
								// [POLYGON_AREA1/POLYGON_AREA0] * AREA0_SQKM

								area = getApproximateL1Area(current,
										items[ISOData.COUNTRY_NAME],
										aggregateLevel1PolygonArea,
										level0AreaSqKm);

							}

							break;

						case 2:

							// Treat the USA as a special case :
							// for the USA we have a list of level 2 data.
							if (descriptor.contains("US-")) { //$NON-NLS-1$

								// Firt, find the ISOCode2 for this USA admin.
								ISOCode2 code = GenUtils.getISO2Object(
										iso2List, items[ISOData.ADMIN1_NAME],
										isoCode.getAlpha2());

								// Second, find the area for this USA admin.
								area = getUSAL2Area(items[ISOData.ADMIN2_NAME],
										code.getIndex(), usaLevel2List);
								break;
							}

							if (descriptor.contains("UNK") == false) { //$NON-NLS-1$

								// First, get the area in SQ KM for the level 1
								// container of the current level 2 adminstratin
								level1AreaSqKm = getArea(
										items[ISOData.ADMIN1_NAME],
										items[ISOData.COUNTRY_NAME], areaList,
										level - 1);

								// Now get the approximate area in SQ KM for the
								// level 2 administration
								area = getApproximateL2Area(descriptor,
										items[ISOData.ADMIN1_NAME],
										items[ISOData.COUNTRY_NAME],
										level1AreaSqKm);
							} else {
								// Use the following formula to compute
								// approximate area :
								// [POLYGON_AREA2 / POLYGON_AREA1] * AREA1_SQKM

								String level2PolygonArea = getPolygonArea(
										descriptor, items[ISOData.ADMIN1_NAME],
										level2PolygonAreaList, 2);

								double ratio = 0.0;
								double approxArea = 0.0;

								if (Double.parseDouble(defaultPolygonArea) != 0) {
									ratio = Double
											.parseDouble(level2PolygonArea)
											* Double
													.parseDouble(defaultPolygonArea);
									approxArea = Double
											.parseDouble(defaultAreaSqKm)
											* ratio;
								}

								area = Double.toString(approxArea);

								System.out.println("UNKNOWN : " //$NON-NLS-1$
										+ items[ISOData.ADMIN2_NAME]
										+ "," + descriptor //$NON-NLS-1$
										+ "," + area); //$NON-NLS-1$

							}

							if (defaultAreaSqKm == DEFAULT) {
								defaultAreaSqKm = level1AreaSqKm;
								defaultPolygonArea = getPolygonArea(
										items[ISOData.ADMIN1_NAME],
										items[ISOData.COUNTRY_NAME],
										level1PolygonAreaList, 1);
							}

							break;

						}

						if (data != null) {
							data += descriptor + " = " + GenUtils.format(area) //$NON-NLS-1$
									+ "\n"; //$NON-NLS-1$
						} else {
							data = descriptor + " = " + GenUtils.format(area) //$NON-NLS-1$
									+ "\n"; //$NON-NLS-1$
						}

						// If area is not known (desfault value), then comment
						// it
						// if (area.equals(DEFAULT)) {
						// System.out
						// .println("VUK : " + descriptor + " , " + current
						// //$NON-NLS-1$ //$NON-NLS-2$
						// + " , " + level); //$NON-NLS-1$
						// }

						// Write the formatted output
						GenUtils.addData(propertiesFile, data);
						data = null;

					} // while

					// Reset our location used to compute approximate area for
					// unknown locations.
					defaultAreaSqKm = DEFAULT;
					defaultPolygonArea = DEFAULT;

					// Reset all lex-related items
					if (lex1DataSet != null) {
						lex1DataSet.clear();
						lex1DataSet = null;
					}
					if (lex2DataSet != null) {
						lex2DataSet.clear();
						lex2DataSet = null;
					}
					if (lex1List != null) {
						lex1List.clear();
						lex1List = null;
					}
					if (lex2List != null) {
						lex2List.clear();
						lex2List = null;
					}

					lexAdmin1File = null;
					lexAdmin2File = null;

					// We dont need the ISO code object for this country
					// anymore, we are done processing it.
					isoCode = null;

					// Get rid of the lists of polyon area data.
					if (level1PolygonAreaList != null) {
						level1PolygonAreaList.clear();
						level1PolygonAreaList = null;
					}

					if (level2PolygonAreaList != null) {
						level2PolygonAreaList.clear();
						level2PolygonAreaList = null;
					}

					// Reset the area list
					if (areaList != null) {
						areaList.clear();
						areaList = null;
					}

					// Close all open resources.
					reader.close();

					if (propertiesFile != null) {
						propertiesFile.close();
						propertiesFile = null;
						System.out.println("\t\tGenerated : " + fileName); //$NON-NLS-1$
						fileName = null;
					}
					// Run garbage collection
					System.gc();

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} // for
	}

	/**
	 * Generate the header comment for this file -- it varies for different
	 * admin levels.
	 * 
	 * @param code
	 *            ISO 3166-1 code
	 * @param level
	 *            administrative level
	 * 
	 * @return the header for the new file.
	 * 
	 */
	protected String getHeader(ISOCode1 code, int level) {

		final int DATA_DESCRIPTOR = 0;
		final int URL = 1;

		// Create the file name for the URL file.
		String urlFile = workspace + GenConstants.PARAMS_DIR
				+ GenConstants.URLS_DIR;
		urlFile += code.getName() + ".txt"; //$NON-NLS-1$

		String header = null;

		header = "# " + code.getAlpha3() + "_" + level + "_area.properties\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		header += "# This file contains area values for " + code.getName() //$NON-NLS-1$
				+ "\n"; //$NON-NLS-1$
		// header += Calendar.getInstance().getTime() + "\n";

		// Add the copyright statement.
		header += GenUtils.getCopyright();

		// Add an explanation of the key format in our data files.
		header += GenUtils.getKeyFormatExplanation();

		header += "# This is the name of the class that will interpret the rest of the file's contents\n"; //$NON-NLS-1$
		header += "RECORD_CLASSNAME = org.eclipse.stem.internal.data.CountryGraphRecord$CountryAreaLabelGraphRecord\n\n"; //$NON-NLS-1$

		header += "# The ISO-3166-1 alpha3 code for the country\n"; //$NON-NLS-1$
		header += "ISOKEY = " + code.getAlpha3() + "\n\n"; //$NON-NLS-1$ //$NON-NLS-2$

		header += "# The administration level of the area data\n"; //$NON-NLS-1$
		header += "ADMIN_LEVEL = " + level + "\n\n"; //$NON-NLS-1$ //$NON-NLS-2$

		header += "# This is the date range for which the area values in this file are valid \n"; //$NON-NLS-1$
		header += "# See http://purl.org/dc/terms/1.1/valid\n"; //$NON-NLS-1$
		header += "VALID = start=1900-01-01;\n\n"; //$NON-NLS-1$

		// The United Nations data policy applies only to Europe :
		// header += GenUtils.getUNPolicy();

		header += "# This is the source of the data\n"; //$NON-NLS-1$

		// Open the URL file for this country.
		// System.out.println("url file = " + urlFile);
		BufferedReader urlReader = GenUtils.openReader(urlFile);

		try {
			// Add all the source URLs for this country.
			if (urlReader != null) {
				String buffer = null;
				while (GenUtils.EOF(buffer = urlReader.readLine()) != true) {

					// System.out.println("Buffer = " + buffer);

					// Tokenize
					StringTokenizer tokenizer = new StringTokenizer(buffer, "*"); //$NON-NLS-1$

					// We know that we expect only two tokens. Get them. Order
					// matters here.
					String[] tokens = new String[2];
					tokens[DATA_DESCRIPTOR] = tokenizer.nextToken();
					tokens[URL] = tokenizer.nextToken();

					// URL sourceURL = null;

					// Is this data descriptor one of our data sources (source
					// URL) ?
					if (GenUtils.isSourceURL(urlSet, tokens[DATA_DESCRIPTOR]) == true) {

						// try {
						// Is this data descriptor one of our active data
						// sources ?

						if (GenUtils.isActiveURL(urlStatus,
								tokens[DATA_DESCRIPTOR]) == false) {
							// No, it is not one an active URL, so comment
							// it
							// out.
							// sourceURL = new URL(tokens[URL]);

							// header += "# "
							// + "SOURCE = "
							// + URLEncoder.encode(sourceURL
							// .toString(), "UTF-8") + "\n";
							header += "# " + "SOURCE = " + tokens[URL] + "\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						} else {
							// header += "SOURCE = "
							// + URLEncoder.encode(sourceURL.toString(),
							// "UTF-8") + "\n";
							//$NON-NLS-3$
							header += "SOURCE = " + tokens[URL] + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
						}

						// } catch (java.io.UnsupportedEncodingException e) {
						// System.out.println("Error:" + e.getMessage());
						// //$NON-NLS-1$
						// }

					}

				} // while

				// To make it look better, add an extra new line.
				header += "\n"; //$NON-NLS-1$

			}

		} catch (IOException e) {
			//
		}

		if (level == DataTypes.LEVEL_1) {
			header += "\n# State/Province\n\n"; //$NON-NLS-1$
		} else if (level == DataTypes.LEVEL_2) {
			header += "# Level 1 (admin 1 = e.g., state)\n"; //$NON-NLS-1$
			header += "# Level 2 (admin 2 = e.g., county)\n\n"; //$NON-NLS-1$
		}

		return header;
	}

	/**
	 * Find the area value for a given entity.
	 * 
	 * @param entity
	 *            the entity for which we want to find the area
	 * @param level
	 *            the admin level
	 * 
	 * @return the area value
	 */
	protected String getArea(String entity, int level) {

		final int ENTITY = 0;

		final int LEVEL = 1;

		final int AREA = 2;

		Iterator it = areaList.iterator();

		String entityStr = entity.toUpperCase();

		while (it.hasNext()) {

			String[] areaData = ((String) it.next()).split(":"); //$NON-NLS-1$

			// Round up area value to 1
			// if (Double.parseDouble(areaData[AREA]) < 1.0) {
			// // 1 SQKM is the minimum area value we return.
			// areaData[AREA] = "1.0";
			// }

			if (areaData[ENTITY].trim().toUpperCase().equals(entityStr)) {

				// We got a name match, now check both entities belong to same
				// admin level
				// (i.e. both are cities or both are counties, etc)
				// Otherwise it is ambigous because we can have cities and
				// counties with the same name
				// Check both entities belong to same level
				if (String.valueOf(level).equals(areaData[LEVEL].trim()) == false) {
					// Ignore : same name , but different level
					continue;
				}

				return areaData[AREA].trim();
			}
		}
		return DEFAULT;
	}

	/**
	 * Find the area of a polygon (in polygon units)
	 * 
	 * @param descriptor
	 * @param container
	 * @param polygonAreaList
	 * @param level
	 * 
	 * @return a polygon area
	 */
	protected String getPolygonArea(String descriptor, String container,
			List polygonAreaList, int level) {

		final int CONTAINER = 0;

		final int ADMINISTRATION = 1;

		final int DESCRIPTOR = 2;

		final int POLYGON_AREA = 3;

		Iterator it = polygonAreaList.iterator();

		String descriptorStr = descriptor.toUpperCase().trim();

		String containerStr = container.toUpperCase().trim();

		while (it.hasNext()) {

			String match = null;

			String[] areaData = ((String) it.next()).split(":"); //$NON-NLS-1$

			match = areaData[ADMINISTRATION].toUpperCase().trim();

			switch (level) {

			case DataTypes.LEVEL_1:
				// We match based on the administration name.
				match = areaData[ADMINISTRATION].toUpperCase().trim();
				break;

			case DataTypes.LEVEL_2:
				// We match based on the descriptor of the level 2 admin.
				match = areaData[DESCRIPTOR].toUpperCase().trim();
				// int endIndex = match.lastIndexOf("-");
				// match = match.substring(0, endIndex);
				break;

			}

			// System.out.println("Match = " + match);

			String areaContainer = areaData[CONTAINER].toUpperCase().trim();

			if (match.equals(descriptorStr)
					&& areaContainer.equals(containerStr)) {
				return areaData[POLYGON_AREA].trim();
			}

		}
		return DEFAULT;
	}

	/**
	 * Find the area value for a given entity.
	 * 
	 * @param entity
	 *            the entity for which we want to find the area
	 * 
	 * @param entityContainer
	 * 
	 * @param areaList
	 * 
	 * @param level
	 *            the admin level
	 * 
	 * @return the area value
	 */
	protected String getArea(String entity, String entityContainer,
			List areaList, int level) {

		final int ENTITY = 0;

		final int LEVEL = 1;

		final int AREA = 2;

		String[] areaData = null;

		Iterator it = areaList.iterator();

		String entityStr = entity.toUpperCase().trim();

		entityStr = entityStr.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

		String entityContainerStr = entityContainer.toUpperCase().trim();

		while (it.hasNext()) {

			areaData = ((String) it.next()).split(":"); //$NON-NLS-1$

			// Round up area value to 1
			// if (Double.parseDouble(areaData[AREA]) < 1.0) {
			// // 1 SQKM is the minimum area value we return.
			// areaData[AREA] = "1.0";
			// }

			String[] compare = null;

			// Get the entity name and remove blanks
			String location = areaData[ENTITY].toUpperCase().trim();

			location = location.toUpperCase().trim();

			// Handle Aliases -- complex stuff :$
			if (location.contains("[")) { //$NON-NLS-1$

				location = location.replace("]", ""); //$NON-NLS-1$ //$NON-NLS-2$

				// Tokenize
				StringTokenizer tokens = new StringTokenizer(location, "["); //$NON-NLS-1$

				// Get tokens
				compare = new String[tokens.countTokens()];
				int i = 0;
				while (tokens.hasMoreTokens()) {
					compare[i++] = tokens.nextToken().toUpperCase().trim();
				}
			}

			if (compare != null) {
				for (int i = 0; i < compare.length; i++) {
					if (entityStr.replace("-", " ").equals( //$NON-NLS-1$ //$NON-NLS-2$
							compare[i].replace("-", " ")) //$NON-NLS-1$ //$NON-NLS-2$
							|| compare[i].equals(entityStr + "-1") //$NON-NLS-1$
							|| compare[i].equals(entityContainerStr)) {

						// Check both entities belong to same level
						if (String.valueOf(level)
								.equals(areaData[LEVEL].trim()) == false) {
							// Ignore : same name , but different level
							continue;
						}
						return areaData[AREA].trim();
					}
				} // for
			} else if (entityStr.equals(location)
					|| entityStr.replace("-", " ").equals(location) //$NON-NLS-1$ //$NON-NLS-2$
					|| location.equals(entityStr + "-1")) { //$NON-NLS-1$

				// Check both entities belong to same level
				if (String.valueOf(level).equals(areaData[LEVEL].trim()) == false) {
					// Ignore : same name , but different level
					continue;
				}
				return areaData[AREA].trim();
			}

		} // while

		return DEFAULT;
	}

	/**
	 * Find the area value for a given county (level 2 admin) within the USA
	 * 
	 * @param entity
	 *            the entity for which we want to find the area
	 * 
	 * @param state
	 * 
	 * @param areaList
	 * 
	 * @return the area value
	 */
	protected String getUSAL2Area(String entity, String state, List areaList) {

		final int ENTITY = 0;

		final int STATE_ID = 1;

		final int AREA = 2;

		String[] areaData = null;

		Iterator it = areaList.iterator();

		String entityStr = entity.toUpperCase().trim();

		entityStr = entityStr.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

		String stateStr = state.toUpperCase().trim();

		while (it.hasNext()) {

			areaData = ((String) it.next()).split(":"); //$NON-NLS-1$

			// Get the entity name and remove blanks
			String location = areaData[ENTITY].toUpperCase().trim();

			location = location.toUpperCase().trim();

			if (entityStr.equals(location)) {

				// Check both entities belong to same state
				if (stateStr.equals(areaData[STATE_ID].trim()) == false) {
					// Ignore : same name , but different level
					continue;
				}
				return areaData[AREA].trim();
			}

		} // while

		return DEFAULT;
	}

	/**
	 * Find the approximate area value for a known location.
	 * 
	 * @param level2Container
	 * @param level1Container
	 * @param level0Container
	 * @param level1AreaSqKm
	 * 
	 * @return the approximate area value
	 */
	protected String getApproximateL2Area(String level2Container,
			String level1Container, String level0Container,
			String level1AreaSqKm) {

		// Find the area in polygon units of the level 1 container
		String level1PolygonArea = getPolygonArea(level1Container,
				level0Container, level1PolygonAreaList, 1);

		// Find the area in polygon units of the level 2 administration
		String level2PolygonArea = getPolygonArea(level2Container,
				level1Container, level2PolygonAreaList, 2);

		// Compute the approximate area, but check division by zero first.
		if (Double.parseDouble(level2PolygonArea) <= 0) {
			return DEFAULT;
		}

		double ratio = Double.parseDouble(level2PolygonArea)
				/ Double.parseDouble(level1PolygonArea);

		String area = String
				.valueOf(ratio * Double.parseDouble(level1AreaSqKm));

		return area;
	}

	/**
	 * Find the approximate area value for a known location.
	 * 
	 * @param level1Container
	 * @param level0Container
	 * @param aggreateLevel1PolygonArea
	 * @param level1AreaSqKm
	 * 
	 * @return the approximate area value
	 */
	protected String getApproximateL1Area(String level1Container,
			String level0Container, String aggregateLevel1PolygonArea,
			String level0AreaSqKm) {

		// Find the area in polygon units of the level 1 container
		String level1PolygonArea = getPolygonArea(level1Container,
				level0Container, level1PolygonAreaList, 1);

		// Compute the approximate area, but check division by zero first.
		if (Double.parseDouble(level1PolygonArea) <= 0) {
			return DEFAULT;
		}

		double ratio = Double.parseDouble(level1PolygonArea)
				/ Double.parseDouble(aggregateLevel1PolygonArea);

		String area = String
				.valueOf(ratio * Double.parseDouble(level0AreaSqKm));

		return area;
	}

	/**
	 * 
	 * @return sum of all level K areas either in polygon units
	 * 
	 */
	protected String getAggregateArea(List areaList) {

		final int AREA = 3;
		Double aggregate = new Double(0.0);

		if (areaList == null)
			return "1.0"; //$NON-NLS-1$
		Iterator it = areaList.iterator();
		while (it.hasNext()) {
			String[] areaData = ((String) it.next()).split(":"); //$NON-NLS-1$
			aggregate += Double.parseDouble(areaData[AREA].trim());
		}

		return Double.toString(aggregate);
	}

	/**
	 * Main execution entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// final int ISO_3166_1 = 0;
		// final int ISO_3166_2 = 1;
		// final int FIX_FILE = 2;
		// final int AREA_DATA = 3;
		// final int TARGET_LIST = 4;
		// final int POLYGON_AREAS = 5;
		// final int LEX_DIR = 6;
		// final int OUTPUT_DIR = 7;
		// final int PARAMS = 8;
		//
		// if (args.length < PARAMS) {
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-2 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO fix file"); //$NON-NLS-1$
		// System.out.println("\t\t Area file"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Polygon areas"); //$NON-NLS-1$
		// System.out.println("\t\t Lexicographic sorting directory");
		// //$NON-NLS-1$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }

		// AreaGenerator gen = new AreaGenerator(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[AREA_DATA],
		// args[TARGET_LIST], args[POLYGON_AREAS], args[LEX_DIR],
		// args[OUTPUT_DIR]);

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("\t\t--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\t\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		AreaGenerator gen = new AreaGenerator(args[CONFIG_FILE]);
		gen.run();
	}

}
