/**
 * 
 */
package org.eclipse.stem.utility.generators;

import java.io.File;
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
 * org.eclipse.stem.utility/configuration/Admin1LexSorter.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\Admin1LexSorter.config)
 * 
 * 
 */
public class Admin1LexSorter {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */
	private String iso3166_1 = null;

	private String iso3166_2 = null;

	private String fixFile = null;

	private String targetFile = null;

	private String outputDir = null;

	private String workspace = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */

	List targetList = null;

	List codeList = null;

	List codefixList = null;

	/**
	 * Constructor
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
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	// public Admin1LexSorter(String iso3166_1, String iso3166_2, String
	// fixFile,
	// String targetFile, String outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.iso3166_2 = iso3166_2;
	// this.fixFile = fixFile;
	// this.targetFile = targetFile;
	// this.outputDir = outputDir;
	// targetList = null;
	//	}

	/**
	 * @param configFile
	 */
	public Admin1LexSorter(String configFile) {
	
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
			targetFile = path + GenConstants.COUNTRY_NAMES;
		}
		if (outputDir == null) {
			outputDir = path + GenConstants.LEX_DIR;
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
		codeList = GenUtils.populateList(iso3166_1);

		// Read and keep in memory a list of the missing ISO3166-2 codes
		codefixList = GenUtils.populateList(fixFile);

		// Now, process each item in the target list.
		process();

	}

	/**
	 * Process our global list of target countries.
	 */
	protected void process() {

		// A writer for the new file we are creating.
		PrintWriter lexFile = null;

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

		// Name of the new properties file.
		String fileName = null;

		// A list for ISO 3166-2 objects
		List<ISOCode2> iso2List = new ArrayList<ISOCode2>();

		int size = targetList.size();

		// Iterate for every country
		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String country = ((String) targetList.get(i)).trim();

			System.out
					.println("\t\t<<<< Processing country : " + country + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$

			// Get the ISO3166-1 info for this country
			if (isoCode == null) {
				isoCode = GenUtils.getISOCode(country, codeList);
			}

			if (iso2List != null) {
				// Load the ISO 3166-2 objects
				iso2List = GenUtils.loadISO2(iso3166_2, isoCode.getAlpha2());
			}

			// If the directory does not exist for this country,
			// create it using ISO alpha3 code.
			File countryDir = new File(outputDir + isoCode.getAlpha3());

			if (countryDir != null && countryDir.exists() == false) {
				// Directory does not exist. Create it.
				countryDir.mkdir();
			}

			// Create and open the output file.
			if (lexFile == null) {
				// Create the file name
				fileName = countryDir + "\\" + isoCode.getAlpha3() //$NON-NLS-1$
						+ "_ADMIN1_LEX.txt"; //$NON-NLS-1$
				// Create tne new file
				lexFile = GenUtils.openWriter(fileName);
			}

			// Extract descriptors from ISO_LEVEL1_FIX, convert them into
			// ISOCode2 format,
			// and put them into a list.
			List<ISOCode2> isoFixList = GenUtils.extractDescriptors(
					codefixList, isoCode);

			// Now find all the unique descriptors in isoFixDescriptors and
			// iso2List. Order of parameters makes a difference here. Always
			// pass first the isoFixList
			List<String> descriptorList = getUniqueDescriptors(isoFixList,
					iso2List);

			// Now, run the lexicographic sorter on the set of unique
			// descriptors.
			Collections.sort(descriptorList);

			// Now, create a unified list of ISO3166-2 objects based on the
			// sorted descriptors
			// System.out.println("Descriptors by lexicographic ordering : ");

			int index = 1;
			Iterator it = descriptorList.iterator();
			while (it.hasNext()) {
				String desc = (String) it.next();
				// Do a lookup corresponding to the descriptor.
				ISOCode2 current = GenUtils.getISO2Object(iso2List, desc);

				if (current == null) {
					// Code not found in regular list, look in fix list.
					current = GenUtils.getISO2Object(isoFixList, desc);
				}

				GenUtils.addData(lexFile, String.valueOf(index) + ":" //$NON-NLS-1$
						+ current.getId() + ":" + current.getAlpha2() + ":" //$NON-NLS-1$ //$NON-NLS-2$
						+ current.getName() + "\n"); //$NON-NLS-1$
				index++;
			}

			// // We dont need the ISO code object for this country
			// // anymore, we are done processing it.
			isoCode = null;

			if (lexFile != null) {
				lexFile.close();
				lexFile = null;
				System.out.println("\t\tGenerated : " + fileName); //$NON-NLS-1$
				fileName = null;
			}

			// Run garbage collection
			System.gc();

		} // for

	}

	/**
	 * Find all unique descriptors in the two lists.
	 * 
	 * @param list1
	 *            a list with ISO 3166-2 codes
	 * @param list2
	 *            a different list with ISO 3166-2 codes
	 * 
	 * @return a list with unique descriptors.
	 * 
	 */
	protected List<String> getUniqueDescriptors(List<ISOCode2> list1,
			List<ISOCode2> list2) {

		List<String> descriptorSet = new ArrayList<String>();
		List<String> nameSet = new ArrayList<String>();

		Iterator it1 = list1.iterator();
		while (it1.hasNext()) {
			ISOCode2 code = (ISOCode2) it1.next();
			if (descriptorSet.contains(code.getId()) == false) {
				descriptorSet.add(code.getId());
				nameSet.add(code.getName());
			}
		}

		Iterator it2 = list2.iterator();
		while (it2.hasNext()) {
			ISOCode2 code = (ISOCode2) it2.next();
			if (descriptorSet.contains(code.getId()) == false) {
				descriptorSet.add(code.getId());
				nameSet.add(code.getName());
			}
		}

		return nameSet;
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
		// final int TARGET_LIST = 3;
		// final int OUTPUT_DIR = 4;
		// final int PARAMS = 5;
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
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }
		//
		// Admin1LexSorter sorter = new Admin1LexSorter(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[TARGET_LIST],
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

		Admin1LexSorter sorter = new Admin1LexSorter(args[CONFIG_FILE]);

		sorter.run();
	}

}
