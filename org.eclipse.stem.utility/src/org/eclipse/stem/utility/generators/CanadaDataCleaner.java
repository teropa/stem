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
 * clean the data for Canada. This program will remove all unnecesary data from
 * the original data source file for Canada. The original data source file for
 * Canada was downloaded from :
 * http://www.geocomm.com/faq/copyright.html
 * 
 * 
 * Add the following values to the run configuration:
 * 
 * C:\workspace2\org.eclipse.stem.utility\dataMigration\input\properties\CountriesLight.txt 
 * C:\shapeFiles\canada\
 * 
 * on nelsons machine it used to be...
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\EuropeCountries.txt
 * C:\EuropeData2007\Canada\
 * 
 * Overview of the data generation process for the Canada data set.
 * 
 * 1) Data Cleaning : start by running CanadaDataCleaner. This program will
 * remove all unnecesary data (i.e. columns) in the original source file. In
 * addition, this program will group the data based on its ID (i.e. NO,IT,FR,UK,
 * etc). The result will be a file named CanadaSorted.txt with cleaned data.
 * 
 * In other words : Canada.txt --> ||CanadaDataCleaner|| --> CanadaSorted.txt
 * 
 * NOTE: CanadaSorted.txt will be used as the input for the remaining part of
 * the process.
 * 
 * 
 * 2) Data Converter : run CanadaDataConverter to convert file in cleaned format
 * into Diva format.
 * 
 * 
 * 3) Area and Population Data Extraction : run CanadaDataExtractor to extract
 * area and population data or all administrations in Canada.
 * 
 */
public class CanadaDataCleaner {

	private String targetFile = null;

	private String outputDir = null;

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
	public CanadaDataCleaner(String targetFile, String outputDir) {
		// Set values of global variables.
		this.targetFile = targetFile;
		this.outputDir = outputDir;
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
		PrintWriter canadaFile = null;

		// Name of the new properties file.
		String fileName = null;

		int size = targetList.size();

		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = targetList.get(i).trim();

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);
			System.out.println("<<<< Processing Country : " + file + " >>>>"); //$NON-NLS-1$  //$NON-NLS-2$
			try {

				if (reader != null) {

					String buffer = null;

					// We take a chunk of the data [BUFFER_MIN,BUFFER_MAX] to
					// make processing more
					// efficient, we dont need all of it.
					int BUFFER_MIN = 0;
					int BUFFER_MAX = 100;

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,,", ",UNKNOWN,UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						String[] items = buffer.substring(BUFFER_MIN,
								BUFFER_MAX).split(","); //$NON-NLS-1$

						// Clear buffer of data we dont need.
						String cleanBuffer = clean(buffer);

						File countryDir = new File(outputDir);

						if (countryDir != null && countryDir.exists() == false) {
							// Directory does not exist. Create it.
							countryDir.mkdir();
						}

						// Create and open the new file.
						if (canadaFile == null) {
							fileName = countryDir + "\\" + "CanadaSorted.txt"; //$NON-NLS-1$ //$NON-NLS-2$									
							// Create tne new properties.file for this country.
							canadaFile = GenUtils.openWriter(fileName);
						}

						String val = map
								.get(items[CanadaDataCleaningHeader.NAME1]);
						if (val != null) {
							// Concatenate
							val += cleanBuffer + "\n"; //$NON-NLS-1$
						} else {
							// First entry
							val = cleanBuffer + "\n"; //$NON-NLS-1$
						}
						map.put(items[CanadaDataCleaningHeader.NAME1], val);

					}// while

					// Close all open resources.
					reader.close();

					if (canadaFile != null) {
						String output = consolidateData(map);
						if (output != null) {
							GenUtils.addData(canadaFile, output);
						}
						canadaFile.close();
						canadaFile = null;
						System.out.println("" //$NON-NLS-1$
								+ fileName);
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
// count by 1
		final int LIMIT = 9;
		String newBuffer = null;

		String[] items = buffer.split(","); //$NON-NLS-1$

		int index = 0;

		while (index < items.length) {

			if (index >= LIMIT) {
				newBuffer += "," + items[index++]; //$NON-NLS-1$
				continue;
			}

			// set the country name manually
			
			newBuffer = "CAN, CANADA"; //$NON-NLS-1$
			
			switch (index) {
/*
			case CanadaDataCleaningHeader.ID:
				newBuffer = items[index];
				break;
*/
			

            /*
			case CanadaDataCleaningHeader.AREA:
				newBuffer = "," + items[index]; //$NON-NLS-1$
				break;

			case CanadaDataCleaningHeader.COUNTRY:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;
            */
			case CanadaDataCleaningHeader.NAME1:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;
/*
			case CanadaDataCleaningHeader.NAME2:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			case CanadaDataCleaningHeader.NAME3:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			case CanadaDataCleaningHeader.POP1:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;

			case CanadaDataCleaningHeader.POP2:
				newBuffer += "," + items[index]; //$NON-NLS-1$
				break;
*/
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
		final int TARGET_LIST = 0;
		final int OUTPUT_DIR = 1;
		final int PARAMS = 2;

		if (args.length < PARAMS) {
			System.out.println("--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\tTo run, please provide the following arguments : "); //$NON-NLS-1$			
			System.out.println("\t\t Target countries file"); //$NON-NLS-1$			
			System.out.println("\t\t Output directory"); //$NON-NLS-1$					
			return;
		}

		CanadaDataCleaner formatter = new CanadaDataCleaner(args[TARGET_LIST],
				args[OUTPUT_DIR]);
		formatter.run();
	}
}
