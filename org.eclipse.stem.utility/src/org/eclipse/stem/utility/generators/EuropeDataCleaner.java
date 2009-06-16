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
 * STEM II Data Migration/Generation Utilities : Instances of this utility class
 * clean the data for Europe. This program will remove all unnecesary data from
 * the original data source file for Europe. The original data source file for
 * Europe was downloaded from :
 * http://www.grid.unep.ch/data/data.php?category=human_related
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/EuropeDataCleaner.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\EuropeDataCleaner.config)
 * 
 * 
 * Add the following values to the run configuration:
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\EuropeCountries.txt
 * C:\EuropeData2007\EuropeUN\UNdataShp\
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
 */
public class EuropeDataCleaner {

	private String targetFile = null;

	private String outputDir = null;

	private String workspace = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */
	List<String> targetList = null;

	List<String> codeList = null;

	/**
	 * Hash map to keep track of polygons.
	 */
	HashMap<String, String> map = null;

	/**
	 * Constructor
	 * 
	 * @param targetFile -
	 *            data file where we find a list of countries for generation of
	 *            their corresponding area.properties files.
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	// public EuropeDataCleaner(String targetFile, String outputDir) {
	// // Set values of global variables.
	// this.targetFile = targetFile;
	// this.outputDir = outputDir;
	// targetList = null;
	// map = new HashMap<String, String>();
	//	}

	/**
	 * @param configFile
	 */
	public EuropeDataCleaner(String configFile) {

		// Load all configuration variables
		HashMap<String, String> vars = GenUtils.loadConfigFile(configFile);

		Set<String> keys = vars.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String var = (String) it.next();

			// Assign values to configuration variables :
			if (var.equals("WORKSPACE")) { //$NON-NLS-1$
				workspace = vars.get(var);
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

		if (targetFile == null) {
			targetFile = path + GenConstants.EUROPE_COUNTRIES;
		}
		if (outputDir == null) {
			outputDir = GenConstants.DUMMY_DIR;
		}

		targetList = null;

		map = new HashMap<String, String>();

	}

	/**
	 * This method sets up and runs the finder.
	 * 
	 */
	public void run() {
		// Read and keep in memory a list of the countries we want.
		targetList = GenUtils.populateList(targetFile);

		// Now, process each item in the target list.
		process();
	}

	/**
	 * Process our global list of target countries.
	 * 
	 */
	protected void process() {

		// A writer for the new file we are creating.
		PrintWriter europeFile = null;

		// Name of the new properties file.
		String fileName = null;

		int size = targetList.size();

		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = targetList.get(i).trim();

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);
			System.out
					.println("\t\t<<<< EUROPE DATA CLEANER -- Processing Country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$
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
						buffer = buffer.replace(",,,", ",UNKNOWN,UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						String[] items = buffer.substring(BUFFER_MIN,
								BUFFER_MAX).split(","); //$NON-NLS-1$

						// Clear buffer of data we dont need.
						String cleanBuffer = clean(buffer);
						// System.out.println(Messages.getString("EuropeDataCleaner.20")
						// + cleanBuffer); //$NON-NLS-1$

						File countryDir = new File(outputDir);

						if (countryDir != null && countryDir.exists() == false) {
							// Directory does not exist. Create it.
							countryDir.mkdir();
						}

						// Create and open the new file.
						if (europeFile == null) {
							fileName = countryDir + "\\" + "EuropeSorted.txt"; //$NON-NLS-1$ //$NON-NLS-2$									
							// Create tne new properties.file for this country.
							europeFile = GenUtils.openWriter(fileName);
						}

						String val = map
								.get(items[EuropeDataCleaningHeader.STRID]
										.substring(0, 2));
						if (val != null) {
							// Concatenate
							val += cleanBuffer + "\n"; //$NON-NLS-1$
						} else {
							// First entry
							val = cleanBuffer + "\n"; //$NON-NLS-1$
						}
						map.put(items[EuropeDataCleaningHeader.STRID]
								.substring(0, 2), val);

					}// while

					// Close all open resources.
					reader.close();

					if (europeFile != null) {
						String output = consolidateData(map);
						if (output != null) {
							GenUtils.addData(europeFile, output);
						}
						europeFile.close();
						europeFile = null;
						System.out.println("\t\tGenerated :" //$NON-NLS-1$
								+ fileName);
						fileName = null;
					}

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} // for

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
	 * Remove all irrelevant data from our buffer
	 */
	String clean(String buffer) {

		final int LIMIT = 20;
		String newBuffer = null;

		String[] items = buffer.split(","); //$NON-NLS-1$

		int index = 0;

		while (index < items.length) {

			if (index > LIMIT) {
				newBuffer += "," + items[index++]; //$NON-NLS-1$
				continue;
			}

			switch (index) {

			case EuropeDataCleaningHeader.NUMID:
				newBuffer = items[index];
				break;

			case EuropeDataCleaningHeader.STRID:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			case EuropeDataCleaningHeader.AREA:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			case EuropeDataCleaningHeader.POP1:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			case EuropeDataCleaningHeader.POP2:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			case EuropeDataCleaningHeader.POP3:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			case EuropeDataCleaningHeader.POP4:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			case EuropeDataCleaningHeader.TEMPID:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			}

			index++;

		}

		return newBuffer;

	}

	/**
	 * Main execution entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// final int TARGET_LIST = 0;
		// final int OUTPUT_DIR = 1;
		// final int PARAMS = 2;
		//
		// if (args.length < PARAMS) {
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }
		//
		// EuropeDataCleaner formatter = new
		// EuropeDataCleaner(args[TARGET_LIST],
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

		EuropeDataCleaner cleaner = new EuropeDataCleaner(args[CONFIG_FILE]);
		cleaner.run();

	}
}
