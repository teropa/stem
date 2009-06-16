/**
 * 
 */
package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
 * STEM II Data Migration/Generation Utilities : Instances of this class sort
 * all level 1 ISO3166-2 descriptors. To do so, first it extracts all the
 * ISO3166-2 descriptors we have distributed in the following two files:
 * ISO3166_2_list.txt and ISO_LEVEL1_FIX.txt. The output is written into a
 * semicolon separated format of the form:
 * 
 * COUNTRY:ALPHA2:XX-YY:NAME:INDEX
 * 
 * This output will be used during generation of the level 2 descriptors and
 * during generation of the relationship files.
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/Admin2LexSorter.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\Admin2LexSorter.config)
 * 
 * 
 */
public class Admin2LexSorter {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */
	private String iso3166_1 = null;

	private String targetFile = null;

	private String outputDir = null;

	private String workspace = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */

	List targetList = null;

	List codeList = null;

	/**
	 * Hash map for dealing with
	 */
	HashMap<String, List<String>> adminData = null;

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param targetFile -
	 *            data file where we find a list of countries for generation of
	 *            their corresponding area.properties files.
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	// public Admin2LexSorter(String iso3166_1, String targetFile, String
	// outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.targetFile = targetFile;
	// this.outputDir = outputDir;
	// targetList = null;
	// adminData = new HashMap<String, List<String>>();
	// }

	/**
	 * @param configFile
	 */
	public Admin2LexSorter(String configFile) {

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
		if (iso3166_1 == null) {
			iso3166_1 = path + GenConstants.ISO3166_1_FILE;
		}
		if (targetFile == null) {
			targetFile = path + GenConstants.COUNTRIES_LIST;
		}
		if (outputDir == null) {
			outputDir = path + GenConstants.LEX_DIR;
		}

		targetList = null;
		adminData = new HashMap<String, List<String>>();

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

		// Collect all level 2 data, sort it and store the result.
		process();

		// Now, print the result.
		printSortedSequences();

	}

	/**
	 * Collect all level 2 administration data and its containment relationship
	 * to level 1 data. Sort the collections lexicographically and store the
	 * result for each country.
	 * 
	 */
	protected void process() {

		// A writer for the new file we are creating.
		PrintWriter lexFile = null;

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

		// Name of the new properties file.
		String fileName = null;

		int size = targetList.size();

		// For every country
		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = ((String) targetList.get(i)).trim();

			// Get the level 2 data we need :
			String admin1 = null;
			String admin2 = null;

			// An index for unknwon or n.a. entries
			int unkCounter = 1;

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);
			System.out
					.println("\t\t<<<< Processing country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$
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

					List<String> entryList = null;

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						String[] items = GenUtils
								.extract(buffer.length() < BUFFER_MAX ? buffer
										: buffer.substring(BUFFER_MIN,
												BUFFER_MAX));

						// Get the ISO3166-1 info for this country
						if (isoCode == null) {
							isoCode = GenUtils.getISOCode(
									items[ISOData.COUNTRY_NAME], codeList);
						}

						// Get the level of the data we are processing.
						level = GenUtils.getDataLevel(items);

						// If the directory does not exist for this country,
						// create it using ISO alpha3 code.
						File countryDir = new File(outputDir
								+ isoCode.getAlpha3());

						if (countryDir != null && countryDir.exists() == false) {
							// Directory does not exist. Create it.
							countryDir.mkdir();
						}

						// Create and open the new file.
						if (lexFile == null) {
							// Create the file name
							fileName = countryDir + "\\" + isoCode.getAlpha3() //$NON-NLS-1$
									+ "_ADMIN2_LEX.txt"; //$NON-NLS-1$
							// Create tne new file
							lexFile = GenUtils.openWriter(fileName);
						}

						// This variable indicates a transition in our data
						// processing
						boolean transition = (level != oldlevel) ? true : false;

						// We have switched to a different data level (i,e,
						// admin 0 to admin 1)
						if (transition == true) {
							oldlevel = level;
							// Reset our repeated history
							// repeatedEntries = new String();
							entryList = new ArrayList<String>();
						}

						// Ignore all data that is not level 2.
						if (level == DataTypes.LEVEL_0
								|| level == DataTypes.LEVEL_1) {
							continue;
						}

						// Get the level 2 data we need :
						admin1 = items[ISOData.ADMIN1_NAME];
						admin2 = items[ISOData.ADMIN2_NAME];

						// If entity is UNKOWN or N.A. handle it properly.
						if (admin2.equals("UNKNOWN") || admin2.equals("N.A.")) { //$NON-NLS-1$ //$NON-NLS-2$
							admin2 = isoCode.getAlpha3() + ".L2." //$NON-NLS-1$
									+ String.valueOf(unkCounter++);
						}

						// Make sure this is not a repeated entry.
						if (GenUtils.isRepeated(admin1 + admin2, entryList) == true) {
							continue;
						}

						// Remember this entity to avoid duplicates.
						entryList.add(admin1 + admin2);

						if (adminData.get(admin1) == null) {
							// Create a new ArrayList of administration 2
							// objects for every level 1 location.
							List<String> admin2List = new ArrayList<String>();
							admin2List.add(admin2);
							adminData.put(admin1, admin2List);
						} else {
							List<String> admin2List = adminData.get(admin1);
							if (admin2List == null) {
								admin2List = new ArrayList<String>();
							}
							admin2List.add(admin2);
							adminData.put(admin1, admin2List);
						}

					}// while

					if (adminData == null) {
						continue;
					}

					Set<String> keys = adminData.keySet();
					Iterator it = keys.iterator();

					// Sort every list.
					while (it.hasNext()) {
						List<String> admin2List = adminData.get(it.next());
						Collections.sort(admin2List);
					}

					System.out
							.println("\t\tDescriptors by lexicographic ordering : "); //$NON-NLS-1$

					Set<String> keyset = adminData.keySet();
					Iterator it1 = keyset.iterator();

					while (it1.hasNext()) {

						admin1 = (String) it1.next();

						// admin1 is the key in our HashMap.
						List<String> admin2List = adminData.get(admin1);

						Iterator it2 = admin2List.iterator();

						int index = 1;

						System.out.println("\t\tAdmin 1 = " + admin1); //$NON-NLS-1$

						while (it2.hasNext()) {

							admin2 = (String) it2.next();
							System.out.println("\t\tAt : " + index //$NON-NLS-1$
									+ " -- admin2 is : " + admin2); //$NON-NLS-1$

							GenUtils.addData(lexFile, String.valueOf(index)
									+ ":" + isoCode.getAlpha2() + ":" //$NON-NLS-1$ //$NON-NLS-2$
									+ isoCode.getAlpha3() + ":" //$NON-NLS-1$
									+ isoCode.getName() + ":" + admin1 + ":" //$NON-NLS-1$ //$NON-NLS-2$
									+ admin2 + "\n"); //$NON-NLS-1$
							index++;

						}

					}

					adminData.clear();

					// We dont need the ISO code object for this country
					// anymore, we are done processing it.
					isoCode = null;

					// Close all open resources.
					reader.close();

					if (lexFile != null) {
						lexFile.close();
						lexFile = null;
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
	 * Collect all level 2 administration data, sort it lexicographically and
	 * store the result.
	 */
	protected void printSortedSequences() {

		System.out.println("\t\tDescriptors by lexicographic ordering : "); //$NON-NLS-1$

		if (adminData == null) {
			return;
		}
		Set<String> keys = adminData.keySet();
		Iterator it1 = keys.iterator();

		while (it1.hasNext()) {

			String admin1 = (String) it1.next();

			List<String> admin2List = adminData.get(admin1);

			Iterator it2 = admin2List.iterator();

			int index = 1;

			System.out.println("\t\tAdmin 1 = " + admin1); //$NON-NLS-1$

			while (it2.hasNext()) {
				System.out.println("\t\tAt : " + index++ + " -- admin2 is : " //$NON-NLS-1$ //$NON-NLS-2$
						+ it2.next());
			}

		}

	}

	/**
	 * Find an entry in the lexicographically sorted list and get its index.
	 * 
	 * @param list
	 *            a list of strings.
	 * @param entry
	 *            the entry we want to find in the list.
	 * 
	 * @return the index of the entry in the sorted list (if found).
	 */
	protected int indexLookup(List<String> list, String entry) {

		int index = 1;
		Iterator it = list.iterator();

		while (it.hasNext()) {
			String current = (String) it.next();
			if (current.toUpperCase().equals(entry.toUpperCase())) {
				return index;
			}
			index++;
		}
		// Not found.
		System.out.println("\t\tindexLookup : entry not found for " + entry); //$NON-NLS-1$
		return -1;
	}

	/**
	 * Main execution entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// final int ISO_3166_1 = 0;
		// final int TARGET_LIST = 1;
		// final int OUTPUT_DIR = 2;
		// final int PARAMS = 3;
		//
		// if (args.length < PARAMS) {
		//
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }
		//
		// Admin2LexSorter sorter = new Admin2LexSorter(args[ISO_3166_1],
		// args[TARGET_LIST], args[OUTPUT_DIR]);
		// sorter.run();

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("\t\t--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\t\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		Admin2LexSorter sorter = new Admin2LexSorter(args[CONFIG_FILE]);

		sorter.run();

	}

}
