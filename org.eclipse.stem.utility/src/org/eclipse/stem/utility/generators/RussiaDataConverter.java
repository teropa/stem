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
 * Convert a data file that comes into the format UN Russia :
 * http://www.grid.unep.ch/data/data.php?category=human_related into the Diva
 * format that the generators can handle. This wont format any arbitrary format
 * into Diva format. Converts only : UN Russia format -> Diva format
 * 
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/RussiaDataConverter.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\RussiaDataConverter.config)
 * 
 * Add the following values to the run configuration:
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISO3166-1\ISO3166_1_en.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\EuropeNames.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\EuropeCountries.txt
 * C:\diva\Europe\ * Overview of the data generation process for the Russia data
 * set.
 * 
 * 1) Data Cleaning : start by running RussiaDataCleaner. This program will
 * remove all unnecesary data (i.e. columns) in the original source file. In
 * addition, this program will group the data based on its ID (i.e. NO,IT,FR,UK,
 * etc). The result will be a file named RussiaSorted.txt with cleaned data.
 * 
 * In other words : Russia.txt --> ||RussiaDataCleaner|| --> RussiaSorted.txt
 * 
 * NOTE: RussiaSorted.txt will be used as the input for the remaining part of
 * the process.
 * 
 * 
 * 2) Data Converter : run RussiaDataConverter to convert file in cleaned format
 * into Diva format. Process : RussiaSorted.txt --> ||RussiaDataConverter|| -->
 * Russia.txt
 * 
 * 
 * 3) Area and Population Data Extraction : run RussiaDataExtractor to extract
 * area and population data or all administrations in Russia.
 * 
 * 
 */

public class RussiaDataConverter {

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

	List dataList = null;

	/**
	 * An index to count the number of unnamed entries in the data set.
	 */
	int unkCounter = 1;

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param targetFile -
	 *            list of target countries
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	// public RussiaDataConverter(String iso3166_1, /* String namesFile, */
	// String targetFile, String outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.targetFile = targetFile;
	// this.outputDir = outputDir;
	// targetList = null;
	// }
	/**
	 * @param configFile
	 */
	public RussiaDataConverter(String configFile) {

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
		if (targetFile == null) {
			targetFile = path + GenConstants.EUROPE_COUNTRIES;
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
		codeList = GenUtils.populateList(iso3166_1);

		// Run the converter: UN Russia -> Diva set format
		process();
	}

	/**
	 * Convert a data file that comes into the format UN Russia :
	 * http://www.grid.unep.ch/data/data.php?category=human_related into the
	 * Diva format that the generators can handle. This wont format any
	 * arbitrary format into Diva format. Converts only : UN Russiaan format ->
	 * Diva format
	 * 
	 */
	protected void process() {

		// A writer for the new file we are creating.
		PrintWriter divaFile = null;

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
					.println("\t\t<<<< RUSSIA DATA CONVERTER -- Processing Country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$ 
			try {

				if (reader != null) {

					String buffer = null;

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						String[] items = buffer.split(","); //$NON-NLS-1$

						// Get the ISO3166-1 info for this country
						if (isoCode == null) {
							String country = GenUtils.getCountryName(
									items[RussiaDataFormattingHeader.COUNTRY]
											.substring(0, 2), codeList);
							isoCode = GenUtils.getISOCode(country, codeList);
						}

						// If the directory does not exist for this country,
						// create it using ISO alpha3 code.
						File countryDir = new File(outputDir
								+ isoCode.getName());

						if (countryDir != null && countryDir.exists() == false) {
							// Directory does not exist. Create it.
							countryDir.mkdir();
						}

						// Create and open the new output file.
						if (divaFile == null) {
							// Create the file name
							fileName = countryDir + "\\" + isoCode.getName() //$NON-NLS-1$
									+ ".txt"; //$NON-NLS-1$

							System.out.println("\t\tFilename  = " + fileName); //$NON-NLS-1$

							// Create tne new file
							divaFile = GenUtils.openWriter(fileName);
						}

						// Apply the formatting to the current buffer : UN
						// Russia -> Diva format
						String divaLine = convert2Diva(isoCode, items);

						// Write the converted line
						System.out.println("\t\tDiva string = " + divaLine); //$NON-NLS-1$
						GenUtils.addData(divaFile, divaLine);

					}// while

					// Reset ISO Code
					isoCode = null;

					// Reset file name
					fileName = null;

					// Close the target file.
					divaFile.close();
					divaFile = null;

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
	 * Convert the buffer given in UN Russia format into Diva format
	 * 
	 * @param isoCode
	 *            ISO 3166-1 code
	 * 
	 * @param data
	 *            a buffer with data on UN Russia format
	 * 
	 * @return converted string
	 * 
	 */
	public String convert2Diva(ISOCode1 isoCode, String[] data) {

		// ID,AREA,COUNTRY_CODE,NAME1,NAME2,NAME3,POP1,POP2,<...polygon data...>

		// 1.0,2.9789999E+02,RUS,UNKNOWN,UNKNOWN,UNKNOWN,0.0,0.0,<...polygon
		// data...>

		// <ALPHA3,COUNTRY_NAME,ADMIN1,<...polygon data...>

		// AGO,Angola,Luanda,<...polygon data...>

		// The formatted prefix string
		String divaString = ""; //$NON-NLS-1$

		// Get relevant data for conversion.
		String alpha2 = isoCode.getAlpha2();
		String alpha3 = isoCode.getAlpha3();

		String location_name = null;

		if (data[RussiaDataFormattingHeader.NAME3].equals("UNKNOWN") || data[RussiaDataFormattingHeader.NAME3].equals("n.a.")) { //$NON-NLS-1$ //$NON-NLS-2$
			// If this is an unnamed location, then we use our convenation for
			// naming unnamed locations :
			// <ALPHA2_CODE>-UNK-<UNKNOWN_COUNTER_VALUE>
			location_name = isoCode.getAlpha2() + "-UNK-" //$NON-NLS-1$
					+ String.valueOf(unkCounter++);
		} else {
			// The location name is a concatenation of the level 2
			// administration (NAME3) and the level 1 container
			// (NAME2). We ignore the level 0 container (NAME1).
			location_name = data[RussiaDataFormattingHeader.NAME2] + ";" //$NON-NLS-1$
					+ data[RussiaDataFormattingHeader.NAME3];
		}

		// Find the country name based on the alpha 2 code.
		String country_name = GenUtils.getCountryName(alpha2, codeList);

		// Get the number of items in the buffer
		int length = data.length;

		// Add fixed data we already have available :
		divaString = alpha3 + "," + country_name + "," + location_name; //$NON-NLS-1$ //$NON-NLS-2$

		// Concatenate polygon data -- ignore the first eight items
		// which are non-polygon data :
		// ID,AREA,COUNTRY,NAME1,NAME2,NAME3,POP1,POP2
		for (int i = 8; i < length; i++) {

			divaString += "," + data[i]; //$NON-NLS-1$

		} // for

		// Finally add a new line to the string.
		divaString += "\n"; //$NON-NLS-1$

		return divaString;
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
		// RussiaDataConverter converter = new RussiaDataConverter(
		// args[ISO_3166_1], /* args[Russia_NAMES], */args[TARGET_LIST],
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

		RussiaDataConverter converter = new RussiaDataConverter(
				args[CONFIG_FILE]);
		converter.run();
	}

}
