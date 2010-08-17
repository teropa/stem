/**
 * 
 */
package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/**
 * 
 * STEM II Data Migration/Generation Utilities : Instances of this utility class
 * convert data from an alternative format into Diva format. It was used for a
 * very specific purpose to help bring the data for the USA into the same format
 * as the rest of the files in the Diva set.
 * 
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/USA2DivaFormatConverter.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\USA2DivaFormatConverter.config)
 * 
 * To run, add the following parameters to the run configuration:
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\USA_L1_Data\USA_L1.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\formatList.txt
 * C:\diva\NorthAmerica\USA\
 * 
 */

public class USA2DivaFormatConverter {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */
	// private String iso3166_1 = null;
	private String usaL1File = null;

	private String targetFile = null;

	private String outputDir = null;

	private String workspace = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */

	List targetList = null;

	// List codeList = null;

	List dataList = null;

	/**
	 * Constructor
	 * 
	 * @param usaL1File -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param targetFile -
	 *            data file where we find a list of countries for generation of
	 *            their corresponding area.properties files.
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	// public USA2DivaFormatConverter(/* String iso3166_1, */String usaL1File,
	// String targetFile, String outputDir) {
	// // Set values of global variables.
	// // this.iso3166_1 = iso3166_1;
	// this.usaL1File = usaL1File;
	// this.targetFile = targetFile;
	// this.outputDir = outputDir;
	// targetList = null;
	// }
	/**
	 * @param configFile
	 */
	public USA2DivaFormatConverter(String configFile) {

		// Load all configuration variables
		HashMap<String, String> vars = GenUtils.loadConfigFile(configFile);

		Set<String> keys = vars.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String var = (String) it.next();

			// Assign values to configuration variables :
			if (var.equals("WORKSPACE")) { //$NON-NLS-1$
				workspace = vars.get(var);
			} else if (var.equals("NAMES_LIST")) { //$NON-NLS-1$
				usaL1File = vars.get(var);
			} else if (var.equals("TARGET_LIST")) { //$NON-NLS-1$
				targetFile = vars.get(var);
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
		if (usaL1File == null) {
			usaL1File = path + GenConstants.USA_L1_DATA;
		}
		if (targetFile == null) {
			targetFile = path + GenConstants.FORMAT_LIST;
		}
		if (outputDir == null) {
			outputDir = GenConstants.DUMMY_DIR;
		}

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
		// codeList = GenUtils.populateList(iso3166_1);

		// Read level 1 data for the USA
		dataList = GenUtils.populateList(usaL1File);

		// Run the converter: US Census format -> Diva set format
		process();

	}

	/**
	 * Convert a data file that comes into the format from the US Census :
	 * http://www.census.gov/geo/www/cob/co2000.html into the Diva format that
	 * the generators can handle. Both formats, the US Census the Diva format
	 * are fixed, well-defined formats. This wont format any arbitrary format
	 * into Diva format. Converts : US Census format -> Diva format
	 * 
	 */
	protected void process() {

		// A writer for the new file we are creating.
		PrintWriter divaFile = null;

		// Object holding ISO3166-1 related data.
		// ISOCode1 isoCode = null;

		// Name of the new properties file.
		String fileName = null;

		int size = targetList.size();

		// For every country
		for (int i = 0; i < size; i++) {

			// Get the next file in the list.
			String file = ((String) targetList.get(i)).trim();

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);
			System.out
					.println("\t\t<<<< USA TO DIVA FORMAT CONVERTER -- Processing Country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$ 
			try {

				if (reader != null) {

					String buffer = null;

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						String[] items = buffer.split(","); //$NON-NLS-1$

						// If the directory does not exist for this country,
						// create it using ISO alpha3 code.
						File countryDir = new File(outputDir + "USA"); //$NON-NLS-1$

						if (countryDir != null && countryDir.exists() == false) {
							// Directory does not exist. Create it.
							countryDir.mkdir();
						}

						// Create and open the new output file.
						if (divaFile == null) {
							// Create the file name
							fileName = countryDir + "\\USA.txt"; //$NON-NLS-1$

							// Create tne new file
							divaFile = GenUtils.openWriter(fileName);
						}

						// Apply the formatting to the current buffer : US
						// Census format -> Diva format
						String divaLine = convert2Diva(items);

						// Write the converted line
						// System.out.println("Diva string = " + divaLine);
						GenUtils.addData(divaFile, divaLine);

					}// while

					// This is an ugly hack since the editors are not powerful
					// enough and cant handle copy paste operations of 20MEGS
					// appendData(divaFile);

					// Close the target file.
					divaFile.close();

					// Close all open resources.
					reader.close();

					// Run garbage collection
					//System.gc();

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} // for

	}

	/**
	 * Convert the buffer given in US Census format into Diva format
	 * 
	 * @param data
	 *            a buffer with data on US Census format
	 * 
	 * @return converted string
	 * 
	 */
	public String convert2Diva(String[] data) {

		// Useful symbolic constants
		final int STATE_ID = 4;
		final int L1_ADMIN = 5;
		final int L2_ADMIN = 6;
		final int L2_ADMIN_TYPE = 8; // VALID TYPES = BOROUGH, PARISH,COUNTY,
		// CITY. INVALID = CENSUS AREA

		// Level of the data we are processing
		int level = -1;

		// State ID
		String state_id = null;

		// The formatted prefix string
		String divaString = "USA,United States"; //$NON-NLS-1$

		// Get the level of the data we are processing.
		level = GenUtils.isNumeric(data[L1_ADMIN]) == false ? 1 : 2;

		// Get the state ID
		state_id = data[STATE_ID];

		// Get rid of blanks
		state_id = state_id.trim();

		// * IF LEVEL == 1, then we can ignore columns 6,7,8, and 9
		//
		// ** Level 1 data should be in the format:
		//
		// USA, United States, Level1 Admin, <POLYGON DATA>
		//
		//
		// * IF LEVEL == 2, then we can ignore columns 6,8, and 9
		//
		// ** Level 2 data should be in the format:
		//
		// USA, United States, Level1 Admin, Level 2 Admin, <POLYGON DATA>
		//
		// To find the level 1 container, iterate over the list with data for
		// the USA. If during iteration we match state_id, then that is the
		// container.

		// Get the number of items in the buffer
		int length = data.length;

		// Process each element in the buffer -- ignore the first five items.
		for (int i = 5; i < length; i++) {

			// Ignore irrelevant data items that occur at both levels
			if (i == 7 || i == 8) {
				continue;
			}

			// Ignore irrelevant data that only occurs at level 1
			if (level == 1) {
				if (i == 6 || i == 9) {
					continue;
				}
			}

			// Ignore irrelevant data that only occurs at level 2
			// If level is 2, then find the container for this entity
			if (level == 2) {

				// Irrelevant data, ignore.
				if (i == 5) {
					continue;
				}

				// Find the container of the level 2 administration.
				if (i == 6) {
					divaString += "," + findContainer(state_id, dataList); //$NON-NLS-1$

					if (data[L2_ADMIN_TYPE].contains("Census Area") == false) { //$NON-NLS-1$
						// Add the type to the name of the administration :
						// (i.e. for Fairfax = admin and city = type, get
						// Fairfax city)
						divaString += "," + data[L2_ADMIN] + " " //$NON-NLS-1$ //$NON-NLS-2$
								+ data[L2_ADMIN_TYPE];
						continue;
					}

				}

			}

			divaString += "," + data[i]; //$NON-NLS-1$

		} // for

		// Finally add a new line to the string.
		divaString += "\n"; //$NON-NLS-1$

		return divaString;
	}

	/**
	 * Find the level 1 container for the current level 2 administration
	 * 
	 * @param state -
	 *            the id of the container (state)
	 * 
	 * @param dataList -
	 *            a list of level 1 data for the USA
	 * 
	 * @return - the name of the level 1 container
	 * 
	 */
	public String findContainer(String state, List dataList) {

		// Format in data list is :
		// US : USA : US-AL : Alabama : 1

		// Useful symbolic constants
		final int CONTAINER = 3;
		final int STATE_ID = 4;

		String stateStr = state.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

		Iterator it = dataList.iterator();

		while (it.hasNext()) {

			String entry = ((String) it.next()).toUpperCase().trim();

			entry = entry.replaceAll("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

			String entries[] = entry.split(":"); //$NON-NLS-1$

			String current_id = entries[STATE_ID];

			if (Integer.parseInt(stateStr) == Integer.parseInt(current_id)) {
				return entries[CONTAINER].toUpperCase();
			}

		}

		return "NOT FOUND"; //$NON-NLS-1$
	}

	/**
	 * Main execution entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// final int ISO_3166_1 = 0;
		// final int USA_L1_DATA = 0;
		// final int TARGET_LIST = 1;
		// final int OUTPUT_DIR = 2;
		// final int PARAMS = 3;
		//
		// if (args.length < PARAMS) {
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t USA level 1 data file"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }

		// USADivaConverter converter = new USADivaConverter(/*
		// args[ISO_3166_1], */
		// args[USA_L1_DATA], args[TARGET_LIST], args[OUTPUT_DIR]);
		// converter.run();

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("\t\t--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\t\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		USA2DivaFormatConverter converter = new USA2DivaFormatConverter(
				args[CONFIG_FILE]);

		converter.run();
	}

}
