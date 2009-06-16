package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * STEM II Data Migration/Generation Utilities : Instances of this utility class
 * will take as input the cleaned data source file for Europe (EuropeSorted.txt)
 * and will break it into multiple data files, one for each European country in
 * the dataset. The new output data files will be created under :
 * C:\stemII\org.eclipse.stem.utility\dataMigration\output
 * 
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/EuropeDataFormatter.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\EuropeDataFormatter.config)
 * 
 * 
 * 
 * Add the following values to the run configuration:
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISO3166-1\ISO3166_1_en.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISOFix\ISO_LEVEL1_FIX.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\EuropeCountries.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\output\
 * 
 * Brief overview of the data generation process for the Europe data set.
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
public class EuropeDataFormatter {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */

	private String iso3166_1 = null;

	private String fixFile = null;

	private String targetFile = null;

	private String outputDir = null;

	private String workspace = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */
	List<String> targetList = null;

	List<String> codeList = null;

	List<String> codefixList = null;

	/**
	 * Hash map to keep track of polygons.
	 */
	HashMap<String, String> map = null;

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param fixFile -
	 *            file containing missing ISO3166-2 codes
	 * @param targetFile -
	 *            data file where we find a list of countries for generation of
	 *            their corresponding area.properties files.
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	// public EuropeDataFormatter(String iso3166_1, String fixFile,
	// String targetFile, String outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.fixFile = fixFile;
	// this.targetFile = targetFile;
	// this.outputDir = outputDir;
	// targetList = null;
	// // Create the hash maps :
	// map = new HashMap<String, String>();
	// }
	/**
	 * @param configFile
	 */
	public EuropeDataFormatter(String configFile) {

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
			} else if (var.equals("ISO_FIX")) { //$NON-NLS-1$
				fixFile = vars.get(var);
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
		if (fixFile == null) {
			fixFile = path + GenConstants.ISOFIX_FILE;
		}
		if (targetFile == null) {
			targetFile = path + GenConstants.EUROPE_COUNTRIES;
		}
		if (outputDir == null) {
			outputDir = GenConstants.DUMMY_DIR;
		}

		targetList = null;

		// Create the hash maps :
		map = new HashMap<String, String>();

	}

	/**
	 * This method sets up and runs the finder.
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
	 * 
	 * 
	 */
	protected void process() {

		// A writer for the new file we are creating.
		PrintWriter europeFile = null;

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

		// Object to detect transitions in data
		ISOCode1 currentCode = null;

		// Name of the new properties file.
		String fileName = null;

		int size = targetList.size();

		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = targetList.get(i).trim();

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);
			System.out
					.println("\t\t<<<< DATA FORMATTER -- Processing country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$
			try {

				if (reader != null) {

					String buffer = null;

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,,", ",UNKNOWN,UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$				

						String[] items = buffer.split(","); //$NON-NLS-1$

						// Get ISO code for current entry.
						String country = GenUtils.getCountryName(
								items[EuropeDataFormattingHeader.STRID]
										.substring(0, 2), codeList);
						currentCode = GenUtils.getISOCode(country, codeList);

						// Get the ISO3166-1 info for this country
						if (isoCode == null) {
							country = GenUtils.getCountryName(
									items[EuropeDataFormattingHeader.STRID]
											.substring(0, 2), codeList);
							isoCode = GenUtils.getISOCode(country, codeList);
						}

						// Check for country-transitions
						if (isoCode.getAlpha2().equals(currentCode.getAlpha2()) == false) {
							// If we have a transition, then close previous
							// file.
							if (europeFile != null) {
								europeFile.close();
								europeFile = null;
								System.out.println(Messages
										.getString("\t\tGenerated :") //$NON-NLS-1$
										+ fileName);
								fileName = null;
							}

							// Set iso code to the current code.
							isoCode = currentCode;

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
						if (europeFile == null) {
							// Create the file name for the new properties.file.
							fileName = countryDir + "\\" + isoCode.getAlpha3() //$NON-NLS-1$
									+ ".txt"; //$NON-NLS-1$
							// Create tne new properties.file for this country.
							europeFile = GenUtils.openWriter(fileName);
						}

						// Variable used to hold the output data.
						GenUtils.addData(europeFile, buffer + "\n"); //$NON-NLS-1$						

					}// while

					// We dont need the ISO code object for this country
					// anymore, we are done processing it.
					isoCode = null;

					// Close all open resources.
					reader.close();

					// Run garbage collection
					System.gc();

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
		// final int FIX_FILE = 1;
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
		// System.out.println("\t\t ISO fix file"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }

		// EuropeDataFormatter formatter = new EuropeDataFormatter(
		// args[ISO_3166_1], args[FIX_FILE], args[TARGET_LIST],
		// args[OUTPUT_DIR]);
		// formatter.run();

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("\t\t--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\t\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		EuropeDataFormatter formatter = new EuropeDataFormatter(
				args[CONFIG_FILE]);
		formatter.run();
	}
}
