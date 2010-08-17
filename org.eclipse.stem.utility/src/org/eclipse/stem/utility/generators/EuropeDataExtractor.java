package org.eclipse.stem.utility.generators;

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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class will extract area and population data from the European data
 * source file (EuropeSorted.txt). For each country, it will generate both and
 * AREA and a POPULATION files under
 * org.eclipse.stem.utility\dataMigration\input\AreaPopulationData.
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/EuropeDataExtractor.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\EuropeDataExtractor.config)
 * 
 * 
 * Add the following values to the run configuration:
 * 
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISO3166-1\ISO3166_1_en.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\EuropeNames.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\EuropeCountries.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\AreaPopulationData\
 * 
 * Overview of the data generation process for the Europe data set.
 * 
 * 1) Data Cleaning : start by running EuropeDataCleaner. This program will
 * remove all unnecesary data (i.e. columns) in the original source file. In
 * addition, this program will group the data based on its ID (i.e. NO,IT,FR,UK,
 * etc). The result will be a file named EuropeSorted.txt with cleaned data.
 * 
 * In other words : Europe.txt --> ||EuropeDataCleaner|| --> EuropeSorted.txt
 * 
 * NOTE: EuropeSorted.txt will be used as the input for the remaining part of
 * the process.
 * 
 * 2) Data Formatting : run EuropeDataFormatter to break down the data source
 * (EuropeSorted.txt) into multiple data files, one for each country as
 * indicated by the ID (i.e. NO,IT,FR,UK, etc). The result will be multiple data
 * files (i.e. italy.txt, spain.txt, etc). Each file will be found under a
 * folder with same name as the country (i.e. ITALY\italy.txt, SPAIN\spain.txt,
 * etc).
 * 
 * 3) Data Converter : run EuropeDataConverter to convert file in cleaned format
 * into Diva format.
 * 
 * 
 * 4) Area and Population Data Extraction : run EuropeDataExtractor to extract
 * all area and population data.
 * 
 * 
 */

public class EuropeDataExtractor {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */
	private String iso3166_1 = null;

	private String namesFile = null;

	private String targetFile = null;

	private String outputDir = null;

	private String workspace = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */

	List targetList = null;

	List codeList = null;

	List dataList = null;

	List namesList = null;

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param namesFile -
	 *            files with all Europe level 1 names.
	 * @param targetFile -
	 *            data file where we find a list of countries for generation of
	 *            their corresponding area.properties files.
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	// public EuropeDataExtractor(String iso3166_1, String namesFile,
	// String targetFile, String outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.namesFile = namesFile;
	// this.targetFile = targetFile;
	// this.outputDir = outputDir;
	// targetList = null;
	// }
	/**
	 * @param configFile
	 */
	public EuropeDataExtractor(String configFile) {

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
			} else if (var.equals("NAMES_FILE")) { //$NON-NLS-1$
				namesFile = vars.get(var);
			} else if (var.equals("TARGET_LIST")) { //$NON-NLS-1$
				targetFile = vars.get(var);
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
		if (namesFile == null) {
			namesFile = path + GenConstants.EUROPE_NAMES;
		}
		if (targetFile == null) {
			targetFile = path + GenConstants.EUROPE_COUNTRIES;
		}
		if (outputDir == null) {
			outputDir = GenConstants.AREA_POPULATION_DIR;
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

		// Load all level 1 names for Europe.
		namesList = GenUtils.populateList(namesFile);

		// Run the converter: UN Europe -> Diva set format
		process();
	}

	/**
	 * 
	 * Generate area and population files from data extracted from
	 * EuropeSorted.txt The area and population files will be used by the
	 * generators to produce the property files.
	 * 
	 */
	protected void process() {

		ArrayList<String> repeated = new ArrayList<String>();

		// A writer for the new file we are creating.
		PrintWriter areaFile = null;
		PrintWriter popFile = null;

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

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
					.println("\t\t<<<< EUROPE DATA EXTRACTOR -- Processing Country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$

			try {

				if (reader != null) {

					String buffer = null;

					// We take a chunk of the data [BUFFER_MIN,BUFFER_MAX] to
					// make processing more
					// efficient, we dont need all of it.
					int BUFFER_MIN = 0;
					int BUFFER_MAX = 200;

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						// Use only part of the buffer, not all of it for
						// efficiency.
						int max = (buffer.length() > BUFFER_MAX) ? BUFFER_MAX
								: buffer.length();
						String[] items = buffer.substring(BUFFER_MIN, max)
								.split(","); //$NON-NLS-1$

						// Get the ISO3166-1 info for this country
						if (isoCode == null) {
							String country = GenUtils.getCountryName(
									items[EuropeDataFormattingHeader.STRID]
											.substring(0, 2), codeList);
							isoCode = GenUtils.getISOCode(country, codeList);
						}

						// If the directory does not exist for this country,
						// create it using ISO alpha3 code.
						File countryDir = new File(outputDir);

						if (countryDir != null && countryDir.exists() == false) {
							// Directory does not exist. Create it.
							countryDir.mkdir();
						}

						// Create and open a new area file.
						if (areaFile == null) {
							// Create the file name
							fileName = countryDir + "\\" + isoCode.getName() //$NON-NLS-1$
									+ "_AREA.txt"; //$NON-NLS-1$

							// Create tne new file
							areaFile = GenUtils.openWriter(fileName);
						}

						// Similarly, create and open a new population file.
						if (popFile == null) {
							// Create the file name
							fileName = countryDir + "\\" + isoCode.getName() //$NON-NLS-1$
									+ "_POPULATION.txt"; //$NON-NLS-1$

							// Create tne new file
							popFile = GenUtils.openWriter(fileName);
						}

						// Extract area value
						String area = items[EuropeDataFormattingHeader.AREA];

						// Extract population value
						String pop1 = items[EuropeDataFormattingHeader.POP1];
						String pop2 = items[EuropeDataFormattingHeader.POP2];
						String pop3 = items[EuropeDataFormattingHeader.POP3];
						String pop4 = items[EuropeDataFormattingHeader.POP4];

						// Find location name
						// Get relevant data for conversion.
						Double val = Double
								.parseDouble(items[EuropeDataFormattingHeader.NUMID]);
						String numID = String.valueOf(val.intValue());

						// Find the location name based on its numeric ID
						String location = GenUtils.getEuropeanLocation(numID,
								namesList);

						if (repeated.contains(location)) {
							continue;
						}
						// remember this element
						repeated.add(location);

						String pop = null;

						// Get first the most up-to-date population value. If it
						// is zero, then get next
						// one and so on. POP4 is the most up-to-date value.
						pop = pop4;

						if (Double.parseDouble(pop) == 0.0) {
							pop = pop3;
						}

						if (Double.parseDouble(pop) == 0.0) {
							pop = pop2;
						}

						if (Double.parseDouble(pop) == 0.0) {
							// This is the most outdated value, but there is no
							// other choice.
							pop = pop1;
						}

						if (Double.parseDouble(pop) <= 0.0) {
							System.out
									.println("\t\tPopulation is zero for location : " //$NON-NLS-1$
											+ items[EuropeDataFormattingHeader.STRID]);
						}

						if (Double.valueOf(area) < 1.0) {
							area = "1.0"; //$NON-NLS-1$
						}

						// Write area value
						GenUtils.addData(areaFile, location + " : 1 : " //$NON-NLS-1$
								+ Double.valueOf(area) + "\n"); //$NON-NLS-1$

						// Write population value
						GenUtils.addData(popFile, location + " : 1 : " //$NON-NLS-1$
								+ Double.valueOf(pop).intValue() + "\n"); //$NON-NLS-1$

					}// while

					// Reset ISO Code
					isoCode = null;

					// Reset file name
					fileName = null;

					// Close the target files.
					areaFile.close();
					areaFile = null;
					popFile.close();
					popFile = null;

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
	 * Main execution entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// final int ISO_3166_1 = 0;
		// final int EUROPE_NAMES = 1;
		// final int TARGET_LIST = 2;
		// final int OUTPUT_DIR = 3;
		// final int PARAMS = 4;
		//
		// if (args.length < PARAMS) {
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
		// System.out.println("\t\t European locations file"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }

		// EuropeDataExtractor converter = new EuropeDataExtractor(
		// args[ISO_3166_1], args[EUROPE_NAMES], args[TARGET_LIST],
		// args[OUTPUT_DIR]);
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

		EuropeDataExtractor extractor = new EuropeDataExtractor(
				args[CONFIG_FILE]);
		extractor.run();
	}

}
