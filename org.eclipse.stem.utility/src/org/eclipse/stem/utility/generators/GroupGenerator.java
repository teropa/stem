package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
 * STEM II Data Migration/Generation Utilities : Instances of this class are
 * used to group all data according to administration name. For example, if data
 * for California is scattered all over the data file, this program will group
 * all data for California consecutively. The benefit is that this way we will
 * have a single polygon for California instead of having multiple polygons if
 * the data is scattered or non-consecutive.
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/GroupGenerator.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\GroupGenerator.config)
 * 
 * 
 * SET VMARGS TO : -Xms1024m -Xmx1024m
 * 
 * 
 */

public class GroupGenerator {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */

	private String iso3166_1 = null;

	private String iso3166_2 = null;

	private String fixFile = null;

	private String targetFile = null;

	private String lexDir = null;

	private String outputDir = null;

	private String workspace = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */

	List targetList = null;

	List codeList = null;

	List codefixList = null;

	/**
	 * Hash maps to keep track of each entry.
	 */
	HashMap<String, String> level0Map = null;

	HashMap<String, String> level1Map = null;

	HashMap<String, String> level2Map = null;

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param iso3166_2 -
	 *            data file with the ISO3166-2 codes.
	 * @param fixFile -
	 *            file containing missing ISO3166-2 codes
	 * @param targetFile
	 *            the list of countries for which we will generate GML files
	 * @param lexDir
	 *            folder containing lexicographically sorted files
	 * @param outputDir
	 *            the output directory for the GML files we generate
	 */
	// public GroupGenerator(String iso3166_1, String iso3166_2, String fixFile,
	// String targetFile, String lexDir, String outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.iso3166_2 = iso3166_2;
	// this.fixFile = fixFile;
	// this.targetFile = targetFile;
	// this.lexDir = lexDir;
	// this.outputDir = outputDir;
	// level0Map = null;
	// level1Map = null;
	// level2Map = null;
	// targetList = null;
	//	}

	/**
	 * @param configFile
	 */
	public GroupGenerator(String configFile) {	

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
			} else if (var.equals("LEX_DIR")) { //$NON-NLS-1$
				lexDir = vars.get(var);
			} else if (var.equals("OUTPUT")) { //$NON-NLS-1$
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
			targetFile = path + GenConstants.COUNTRIES_LIST;
		}
		if (lexDir == null) {
			lexDir = path + GenConstants.LEX_DIR;
		}

		if (GenUtils.verifyOutputDirectory(vars) == false) {
			System.out
					.println("\t\tBad configuration file -- OUTPUT variable not found. Please specify output directory using format VAR = VALUE (i.e. OUTPUT = C:\\diva\\grouped\\ "); //$NON-NLS-1$
			System.exit(1);
		}

		level0Map = null;
		level1Map = null;
		level2Map = null;
		targetList = null;

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

		// Now, process each item in the target list.
		process();

	}

	/**
	 * Process our global list of target countries. For each country in list,
	 * generate its GML file.
	 * 
	 */
	protected void process() {

		// A writer for the new file we are creating.
		PrintWriter groupFile = null;

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

		// Name of the new properties file.
		String fileName = null;

		// A list for ISO 3166-2 objects
		List iso2List = new ArrayList();

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

		// Iterate for every country and create its GML data file.
		for (int i = 0; i < size; i++) {

			// Create the hash maps :
			level0Map = new HashMap<String, String>();
			level1Map = new HashMap<String, String>();
			level2Map = new HashMap<String, String>();

			// Get the next country in the list.
			String file = ((String) targetList.get(i)).trim();

			// An index for unknown or n.a. entries
			int unkCounter = 1;

			// We use this list to keep track of duplicated polygons.
			List<STEMPolygon> polygons = null;

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);

			System.out
					.println("\t\t<<<< GROUP GENERATOR -- Processing country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$
			try {

				if (reader != null) {

					String buffer = null;
					// Describes the level of data
					// being processing : LEVEL0, LEVEL1, or LEVEL2.
					int level = -1;

					// Record the previous type.
					int oldlevel = level - 1;

					// The data we want to write to the new GML file.
					String output = " "; //$NON-NLS-1$

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						// We take a chunk of the data [BUFFER_MIN,BUFFER_MAX]
						// to make processsing more
						// efficient, we dont need all of it.
						int BUFFER_MIN = 0;
						int BUFFER_MAX = 125;

						String[] items = GenUtils
								.extract(buffer.length() < BUFFER_MAX ? buffer
										: buffer.substring(BUFFER_MIN,
												BUFFER_MAX));

						// Get the country name
						String country = items[ISOData.COUNTRY_NAME];

						// Get the ISO3166-1 info for this country
						if (isoCode == null) {
							isoCode = GenUtils.getISOCode(country, codeList);
						}

						// Get the type of the data we are processing.
						level = GenUtils.getLevel(items);

						if (level != 0 && iso2List != null) {
							// Load the ISO 3166-2 objects for this country
							iso2List = GenUtils.loadISO2(iso3166_2);
						}

						// This variable indicates a transition in our data
						// processing
						boolean transition = (level != oldlevel) ? true : false;

						// The current entity we are dealing with.
						// Based on its admin level it can be a country, a
						// county, etc;
						String current = null;

						// Descriptor for current entry.
						String descriptor = null;

						if (transition == true) {
							// Keep track of previous level in order to detect
							// transitions.
							oldlevel = level;

							// Reset counter of UNKNOWN and N.A. entries.
							unkCounter = 1;

							// Clear the list of unique polygons
							if (polygons != null) {
								polygons.clear();
							}

							// Get a new, empty polygon list
							polygons = new ArrayList<STEMPolygon>();

							// If the directory does not exist for this country,
							// create it using ISO alpha3 code.
							File countryDir = new File(outputDir
									+ isoCode.getAlpha3());

							if (countryDir != null
									&& countryDir.exists() == false) {
								// Directory does not exist. Create it.
								countryDir.mkdir();
							}

							// Create the file name for the new file
							fileName = countryDir + "\\" + isoCode.getAlpha3() //$NON-NLS-1$
									+ "_GROUPED.txt"; //$NON-NLS-1$

							// Open the writer for the new file
							groupFile = GenUtils.openWriter(fileName);

						} // if( transition == true )

						switch (level) {

						case DataTypes.LEVEL_0:
							current = isoCode.getAlpha3();
							break;

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

						// We get the descriptor for administration entities
						// differently based on its level.

						if (level == 2) {

							if (lex1DataSet == null && lex2DataSet == null) {

								// Compose the file names for the lex files for
								// this
								// country.
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
								// list of lex data objects.
								lex1List = GenUtils.createLex1List(lex1DataSet);
								lex2List = GenUtils.createLex2List(lex2DataSet);

							}

							// Compose the level2 descriptor using the lex data:

							// STEP 1: Do a look up in the lex 2 lists.

							// Get the lex 2 object for the current entry.
							Lex2Obj lex2Current = GenUtils.lex2Lookup(lex2List,
									items[ISOData.ADMIN1_NAME], current);

							// Get the lex1Object to which lex2Current belongs
							Lex1Obj lex1Current = GenUtils.lex1Lookup(lex1List,
									lex2Current.getAdmin1());

							if (lex1Current.getDescriptor().contains("US-")) { //$NON-NLS-1$
								// STEP 2: piece together the ID using the
								// proper lex objects : the USA is a special
								// case
								descriptor = lex1Current.getDescriptor()
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndexUSA();
							} else {
								// STEP 2: piece together the ID using the
								// proper lex objects.
								descriptor = lex1Current.getDescriptor()
										+ "-G" //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndex();
							}

							if (current.contains(".L2.")) { //$NON-NLS-1$
								current = descriptor;
							}

						} else {
							// Compose descriptor for l 1 and l 0 data
							// Get the descriptor for this entity.
							descriptor = GenUtils.getISO2Descriptor(iso2List,
									current, isoCode.getAlpha2());

							// If we cant find the descriptor, then look in the
							// fix list.
							if (descriptor.equals(current) == true) {
								// Look for a descriptor in the fix file
								descriptor = GenUtils.getFixCode(codefixList,
										current, items[ISOData.COUNTRY_NAME]);
							}

						}

						String key = null;
						HashMap<String, String> map = null;

						// Store the data in the hash map
						switch (level) {

						case DataTypes.LEVEL_0:
							key = items[ISOData.COUNTRY_NAME];
							map = level0Map;
							break;

						case DataTypes.LEVEL_1:
							key = items[ISOData.ADMIN1_NAME];
							map = level1Map;
							break;

						case DataTypes.LEVEL_2:
							key = items[ISOData.ADMIN1_NAME] + ":" //$NON-NLS-1$
									+ items[ISOData.ADMIN2_NAME];
							map = level2Map;
							break;
						}

						if (map.containsKey(key)) {
							// Concatenate to current value
							String value = map.get(key);
							value += buffer + "\n"; //$NON-NLS-1$
							map.put(key, value);
						} else {
							map.put(key, buffer + "\n"); //$NON-NLS-1$
						}

						// Run garbage collection
						//System.gc();

					} // while loop

					// Now write the entries in the hash maps to the file :

					output = consolidateData(level0Map);
					if (output != null) {
						GenUtils.addData(groupFile, output);
					}

					output = consolidateData(level1Map);
					if (output != null) {
						GenUtils.addData(groupFile, output);
					}

					output = consolidateData(level2Map);
					if (output != null) {
						GenUtils.addData(groupFile, output);
					}

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

					// Close all open resources.
					reader.close();

					// Clear the hash maps
					if (level0Map != null) {
						level0Map.clear();
						level0Map = null;
					}

					if (level1Map != null) {
						level1Map.clear();
						level1Map = null;
					}

					if (level2Map != null) {
						level2Map.clear();
						level2Map = null;
					}

					if (groupFile != null) {
						groupFile.close();
						groupFile = null;
						System.out.println("\t\tGenerated : " + fileName); //$NON-NLS-1$
						fileName = null;
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * 
	 * Get all the values in the map.
	 * 
	 * @param map
	 *            a map of locations
	 * 
	 * @return String a string will all locations grouped secuentialy.
	 * 
	 */
	String consolidateData(HashMap<String, String> map) {

		String value = null;

		if (map.isEmpty()) {
			return null;
		}

		Set<String> keys = map.keySet();

		Iterator it = keys.iterator();

		while (it.hasNext()) {

			String key = (String) it.next();

			if (value == null) {
				value = map.get(key);
			} else {
				value += map.get(key);
			}

		}

		return value;
	}

	/**
	 * The execution entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// final int ISO_3166_1 = 0;
		// final int ISO_3166_2 = 1;
		// final int FIX_FILE = 2;
		// final int TARGET_LIST = 3;
		// final int LEX_DIR = 4;
		// final int OUTPUT_DIR = 5;
		// final int PARAMS = 6;
		//
		// if (args.length < PARAMS) {
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-2 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO fix file"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Lexicographic sorting directory");
		// //$NON-NLS-1$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }
		//
		// GroupGenerator groupGen = new GroupGenerator(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[TARGET_LIST],
		// args[LEX_DIR], args[OUTPUT_DIR]);
		// groupGen.run();

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("\t\t--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\t\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		GroupGenerator gen = new GroupGenerator(args[CONFIG_FILE]);

		gen.run();

	}

}
