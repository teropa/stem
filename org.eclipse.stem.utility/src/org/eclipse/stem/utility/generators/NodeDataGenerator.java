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
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/**
 * STEM II Data Migration/Generation Utilities -- This is a utility class that
 * generates the node.properties files for all countries.
 * 
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/NodeDataGenerator.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\NodeDataGenerator.config)
 * 
 * SET VMARGS TO : -Xms1024m -Xmx1024m
 * 
 */

public class NodeDataGenerator {

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
	 * Hash set for storing the source URLs relevant to area data.
	 */
	Set<String> urlSet = null;

	/**
	 * Hash map to keep track of which sources will be shown commented out and
	 * which will appear active.
	 */
	HashMap<String, Boolean> urlStatus = null;

	/**
	 * Constructor *
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param iso3166_2 -
	 *            file with the ISO3166-2 data used for generating the IDs.
	 * @param fixFile -
	 *            file containing missing ISO3166-2 codes
	 * @param targetFile -
	 *            data file where we find a list of countries for generation of
	 *            their corresponding area.properties files.
	 * @param lexDir
	 *            folder containing lexicographically sorted files
	 * @param outputDir -
	 *            the output directory for the files generated.
	 */
	// public NodeDataGenerator(String iso3166_1, String iso3166_2,
	// String fixFile, String targetFile, String lexDir, String outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.iso3166_2 = iso3166_2;
	// this.fixFile = fixFile;
	// this.targetFile = targetFile;
	// this.lexDir = lexDir;
	// this.outputDir = outputDir;
	// targetList = null;
	// // Set the URL IDs that are relevant for area data.
	// initNodeDataURLSet();
	// // Set which URLs are active and which ones should be commented out.
	// setURLStatus();
	//	}

	/**
	 * @param configFile
	 */
	public NodeDataGenerator(String configFile) {

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
			targetFile = path + GenConstants.COUNTRIES_LIST;
		}
		if (lexDir == null) {
			lexDir = path + GenConstants.LEX_DIR;
		}
		if (outputDir == null) {
			outputDir = workspace + GenConstants.PROPERTIES_OUTPUT_DIR;
		}

		targetList = null;
		// Set the URL IDs that are relevant for area data.
		initNodeDataURLSet();
		// Set which URLs are active and which ones should be commented out.
		setURLStatus();

	}

	/**
	 * Sets the URL IDs relevant for area data. We are only interested in URLs
	 * with ID = DIVA. This can be different for different types of data. For
	 * example, for population data, we are interested on ID = CIA
	 */
	protected void initNodeDataURLSet() {
		urlSet = new HashSet<String>();
		urlSet.add(new String("CIA")); //$NON-NLS-1$
		urlSet.add(new String("ISO3166_1")); //$NON-NLS-1$
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
		urlStatus.put("CIA", new Boolean(false)); //$NON-NLS-1$
		urlStatus.put("ISO3166_1", new Boolean(false)); //$NON-NLS-1$
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

		// Now, process each item in the target list.
		process();

	}

	/**
	 * Process our global list of target countries. For each country in list,
	 * generate its node.properties file.
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

		// Iterate for every country and create its nodedata.properties file.
		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = ((String) targetList.get(i)).trim();

			// An index for unknwon or n.a. entries
			int unkCounter = 1;

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);
			System.out
					.println("\t\t<<<< NODE DATA GENERATOR -- Processing country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$
			try {

				if (reader != null) {

					String buffer = null;
					// Describes level
					// of data we
					// are now processing : LEVEL0, LEVEL1, or LEVEL2.
					int level = -1;
					// Record the previous level.
					int oldlevel = level - 1;
					// We take a chunk of the data [BUFFER_MIN,BUFFER_MAX] to
					// make processing more
					// efficient, we dont need all of it.
					int BUFFER_MIN = 0;
					int BUFFER_MAX = 120;
					// String used to ignore repeated entries.
					List<String> entryList = null;

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						// Use only part of the buffer, not all of it for
						// efficiency.
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

						// Get the levelof the data we are processing.
						level = GenUtils.getDataLevel(items);

						if (level != 0 && iso2List != null) {
							// Load the ISO 3166-2 objects for this country
							iso2List = GenUtils.loadISO2(iso3166_2);
						}

						// This variable indicates a transition in our data
						// processing
						boolean transition = (level != oldlevel) ? true : false;

						// Variable used to hold the formatted output data.
						String data = null;

						// The current entity we are dealing with.
						// Based on its admin level it can be a country, a
						// county, etc;
						String current = null;

						// Descriptor for current entry.
						String descriptor = null;

						// We have switched to a different data level (i,e,
						// admin 0 to admin 1)
						if (transition == true) {
							// Keep track of previous level in order to detect
							// transitions.
							oldlevel = level;
							// Reset our repeated history
							if (entryList != null) {
								entryList.clear();
							}
							entryList = new ArrayList<String>();

							// Reset counter of UNKNOWN and N.A. entries.
							unkCounter = 1;
							if (propertiesFile != null) {
								System.out.println("\t\tGenerated : " //$NON-NLS-1$
										+ fileName);
								propertiesFile.close();
								propertiesFile = null;
								fileName = null;
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
									+ "_" + level + "_node.properties"; //$NON-NLS-1$ //$NON-NLS-2$
							// Create tne new population file for this country.
							propertiesFile = GenUtils.openWriter(fileName);
						}

						if (transition == true) {
							// Just add the header
							data = getHeader(isoCode, level);
							GenUtils.addData(propertiesFile, data);
							// Forget the data we just wrote.
							data = null;
						}

						switch (level) {

						case DataTypes.LEVEL_0:

							// Handle data level 0 different that the other
							// admin levels.
							if (transition == true) {
								data = isoCode.getAlpha3() + " = " //$NON-NLS-1$
										+ isoCode.getName() + ", " //$NON-NLS-1$
										+ isoCode.getNumeric() + ", " //$NON-NLS-1$
										+ isoCode.getAlpha2();
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

						// Load the lex lists.
						if (lex1DataSet == null && lex2DataSet == null) {

							// Compose the file names for the lex files for
							// this
							// country.
							lexAdmin1File = lexDir + isoCode.getAlpha3() + "\\" //$NON-NLS-1$
									+ isoCode.getAlpha3();
							lexAdmin2File = lexAdmin1File;
							lexAdmin1File += "_ADMIN1_LEX.txt"; //$NON-NLS-1$
							lexAdmin2File += "_ADMIN2_LEX.txt"; //$NON-NLS-1$

							// Load the lex1 and lex2 files for this
							// country.
							lex1DataSet = GenUtils.populateList(lexAdmin1File);
							lex2DataSet = GenUtils.populateList(lexAdmin2File);

							// Create a method to search for an item on a
							// list
							// of lex data objects.
							lex1List = GenUtils.createLex1List(lex1DataSet);
							lex2List = GenUtils.createLex2List(lex2DataSet);

						}

						// Compose the level2 descriptor using the lex data:

						// We get the descriptor for administration entities
						// differently based on its level.

						if (level == 2) {

							// STEP 1: Do a look up in the lex 2 lists.

							// Get the lex 2 object for the current entry.
							Lex2Obj lex2Current = GenUtils.lex2Lookup(lex2List,
									items[ISOData.ADMIN1_NAME], current);

							// Get the lex 1 object to which lex2Current belongs
							// to.
							Lex1Obj lex1Current = GenUtils.lex1Lookup(lex1List,
									lex2Current.getAdmin1());

							// STEP 2: piece together the ID using the
							// proper lex objects : the USA is a special case
							if (lex1Current.getDescriptor().contains("US-")) { //$NON-NLS-1$

								descriptor = lex1Current.getDescriptor()
										+ "-" //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndexUSA();

								current = current
										+ ", " //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndexUSA()
										+ ", " //$NON-NLS-1$
										+ GenUtils.extractAlpha2(lex1Current
												.getDescriptor());

							} else {
								descriptor = lex1Current.getDescriptor()
										+ "-G" //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndex();

								// Add some commens to allow reverse engineering
								// or
								// backtracking the origin of this generated key
								// as
								// much as possible.
								data = "# Generated key details : " //$NON-NLS-1$
										+ " Level 1 ( " //$NON-NLS-1$
										+ lex1Current.getDescriptor()
										+ " = " //$NON-NLS-1$
										+ lex1Current.getAdmin1()
										+ " ). " //$NON-NLS-1$
										+ "Level 2 ( " //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndex()
										+ " = " + lex2Current.getAdmin2() //$NON-NLS-1$
										+ " ). \n"; //$NON-NLS-1$

								if (current.contains(".L2.")) { //$NON-NLS-1$
									current = descriptor
											+ ", " + "G" //$NON-NLS-1$ //$NON-NLS-2$
											+ lex1Current.getFormattedIndex()
											+ lex2Current.getFormattedIndex()
											+ ", " + lex1Current.getID(); //$NON-NLS-1$
								}

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

							// Handle the USA as a special case
							if (descriptor.contains("US-")) { //$NON-NLS-1$
								data = "#" + current + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
							}

							// Get the lex 1 object to which lex2Current belongs
							// to.
							Lex1Obj lex1Current = GenUtils.lex1Lookup(lex1List,
									current);

							if (lex1Current == null) {
								System.out
										.println("\t\tFound problem : " + current //$NON-NLS-1$
												+ " " + descriptor + " " //$NON-NLS-1$ //$NON-NLS-2$
												+ items[ISOData.COUNTRY_NAME]);
							} else {
								current = current
										+ ", " //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ ", " //$NON-NLS-1$
										+ lex1Current.getID();
							}

						}

						// System.out.println("Composed : " + descriptor + " = "
						// + current);

						if (data != null) {
							data += descriptor + " = " + current + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
						} else {
							data = descriptor + " = " + current + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
						}

						GenUtils.addData(propertiesFile, data);
						data = null;

					} // while loop

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

					if (propertiesFile != null) {
						propertiesFile.close();
						propertiesFile = null;
						System.out.println("\t\tGenerated : " + fileName); //$NON-NLS-1$
						fileName = null;
					}

					// Run garbage collection
					//System.gc();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Generate the header comment for this file.
	 * 
	 * @param code
	 *            ISO 3166-1 Code
	 * @param level
	 *            the admin level
	 * 
	 * @return a header comment for the new file.
	 */
	protected String getHeader(ISOCode1 code, int level) {

		final int DATA_DESCRIPTOR = 0;
		final int URL = 1;

		// Create the file name for the URL file.
		String urlFile = workspace + GenConstants.PARAMS_DIR
				+ GenConstants.URLS_DIR;
		urlFile += code.getName() + ".txt"; //$NON-NLS-1$

		String header = "# " + code.getAlpha3() + "_" + level //$NON-NLS-1$ //$NON-NLS-2$
				+ "_node.properties " //$NON-NLS-1$
				+ "\n"; //$NON-NLS-1$

		// Add the copyright statement.
		header += GenUtils.getCopyright();

		// Add an explanation of the key format in our data files.
		header += GenUtils.getKeyFormatExplanation();

		header += "# This is the name of the class that will interpret the rest of the file's contents\n"; //$NON-NLS-1$
		header += "RECORD_CLASSNAME = org.eclipse.stem.internal.data.CountryGraphRecord$CountryNodeGraphRecord\n\n"; //$NON-NLS-1$

		header += "# The ISO-3166-1 alpha3 code for the country\n"; //$NON-NLS-1$
		header += "ISOKEY = " + code.getAlpha3() + "\n\n"; //$NON-NLS-1$ //$NON-NLS-2$

		header += "# The administration level of the node data\n"; //$NON-NLS-1$
		header += "ADMIN_LEVEL = " + level + "\n\n"; //$NON-NLS-1$ //$NON-NLS-2$

		header += "# This is the date range for which the area values in this file are valid \n"; //$NON-NLS-1$
		header += "# See http://purl.org/dc/terms/1.1/valid\n"; //$NON-NLS-1$
		header += "VALID = start=1900-01-01;\n\n"; //$NON-NLS-1$

		// The United Nations data policy applies only to Europe :
		// header += GenUtils.getUNPolicy();

		header += "# This is the source of the data\n"; //$NON-NLS-1$

		urlFile += code.getName() + ".txt"; //$NON-NLS-1$

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

					if (GenUtils.isSourceURL(urlSet, tokens[DATA_DESCRIPTOR]) == true) {

						// try {
						// Is this data descriptor one of our active data
						// sources ?
						if (GenUtils.isActiveURL(urlStatus,
								tokens[DATA_DESCRIPTOR]) == false) {
							// No, it is not one an active URL, so comment
							// it
							// out.
							// header += "# " + "SOURCE = " +
							// URLEncoder.encode(tokens[URL], "UTF-8") + "\n";
							header += "# " + "SOURCE = " + tokens[URL] + "\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						} else {
							// header += "SOURCE = " +
							// URLEncoder.encode(tokens[URL], "UTF-8") + "\n";
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

		header += "# The file that contains the latitude/longitude data for the node \n"; //$NON-NLS-1$
		header += "SPATIAL_URI = "; //$NON-NLS-1$
		header += "platform:/plugin/org.eclipse.stem.geography/resources/data/geo/country/"; //$NON-NLS-1$
		header += code.getAlpha3() + "/" + code.getAlpha3() + "_" + level //$NON-NLS-1$ //$NON-NLS-2$
				+ "_MAP.xml\n\n"; //$NON-NLS-1$

		return header;
	}

	/**
	 * Execution entry point
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
		// //$NON-NLS-1$$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }
		//
		// NodeDataGenerator gen = new NodeDataGenerator(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[TARGET_LIST],
		// args[LEX_DIR], args[OUTPUT_DIR]);
		// gen.run();

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("\t\t--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\t\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		NodeDataGenerator gen = new NodeDataGenerator(args[CONFIG_FILE]);
		gen.run();

	}

}
