/**
 * 
 */
package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
 * 
 * STEM II Data Migration/Generation Utilities : Instances of this class finds
 * out how many level 2 administrations each level 1 admin has. In other words,
 * it profiles each level 1 admin based on its population and the number of
 * level 2 administrations that belong to it.
 * 
 * To run add the following parameters to the run configuration:
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISO3166-1\ISO3166_1_en.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\AreaPopulationData\
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\Countries.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\profiles\
 * 
 */
public class PopulationProfiler {

	private String populationData = null;

	private String outputDir = null;

	private String targetFile = null;

	private String iso3166_1 = null;

	/**
	 * Lists for population data.
	 */

	List targetList = null;

	List populationList = null;

	List codeList = null;

	/**
	 * String used to indicate default value for unknown areas.
	 */
	String DEFAULT = "0"; //$NON-NLS-1$

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param populationData -
	 *            the directory containing population data for all countries
	 * @param targetFile -
	 *            data file where we find a list of countries for generation of
	 *            their corresponding area.properties files.
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	public PopulationProfiler(String iso3166_1, String populationData,
			String targetFile, String outputDir) {
		// Set values of global variables.
		this.iso3166_1 = iso3166_1;
		this.outputDir = outputDir;
		this.targetFile = targetFile;
		this.populationData = populationData;
	}

	/**
	 * Run the generator.
	 * 
	 */
	public void run() {
		// Read and keep in memory a list of the countries we want.
		targetList = GenUtils.populateList(targetFile);

		// Read and keep in memory a list of the ISO3166-1 ALPHA2, ALPHA3, and
		// numeric codes.
		codeList = GenUtils.populateList(iso3166_1);

		// Now, process each item in the target list.
		process();

	}

	/**
	 * Process our global list of target countries. For each country in list,
	 * generate its population.properties file.
	 * 
	 */
	protected void process() {

		final int CONTAINER = 0;
		final int COUNT = 1;

		/**
		 * Hash map for dealing with population data
		 */
		HashMap<String, String> pData = new HashMap<String, String>();

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

		// A writer for the new file we are creating.
		PrintWriter propertiesFile = null;

		// Name of the new properties file.
		String fileName = null;

		int size = targetList.size();

		// Iterate for every country and create its population.properties file.
		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = ((String) targetList.get(i)).trim();

			// An index for unknwon or n.a. entries
			int unkCounter = 1;

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);
			System.out.println("<<<< Processing country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$
			try {

				if (reader != null) {

					String buffer = null;
					// Describes level
					// of data we
					// are now processing : LEVEL0, LEVEL1, or LEVEL2.
					int level = -1;
					// Record the previous level.
					int oldLevel = level - 1;
					// We take a chunk of the data [BUFFER_MIN,BUFFER_MAX] to
					// make processing more
					// efficient, we dont need all of it.
					int BUFFER_MIN = 0;
					int BUFFER_MAX = 120;

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

						// Read and keep in memory a list of the population data
						// for this country.
						if (populationList == null) {
							String name = populationData + country
									+ "_POPULATION.txt"; //$NON-NLS-1$
							populationList = GenUtils.populateList(name);
						}

						// Get the level of the data we are processing.
						level = GenUtils.getDataLevel(items);

						// This variable indicates a transition in our data
						// processing
						boolean transition = (level != oldLevel) ? true : false;

						if (transition == true) {
							// Keep track of previous level in order to detect
							// transitions.
							oldLevel = level;
							// Reset our repeated history
							// repeatedEntries = new String();
							entryList = new ArrayList<String>();
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
							String alpha3 = isoCode.getAlpha3();
							fileName = countryDir + "\\" + alpha3 + "_" //$NON-NLS-1$ //$NON-NLS-2$
									+ "population.profile"; //$NON-NLS-1$
							// Create tne new population file for this country.
							propertiesFile = GenUtils.openWriter(fileName);
						}

						// The current entity we are dealing with.
						// Based on its admin level it can be a country, a
						// county, etc;
						String current = null;

						switch (level) {

						case DataTypes.LEVEL_0:
							// Do Nothinng
							continue;

						case DataTypes.LEVEL_1:
							current = items[ISOData.ADMIN1_NAME].toUpperCase();
							break;

						case DataTypes.LEVEL_2:
							current = items[ISOData.ADMIN2_NAME].toUpperCase();
							break;

						} // Switch

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

						// Make sure this is not a repeated level 1 entry.
						if (level == 1) {

							if (GenUtils.isRepeated(current, entryList) == true) {
								// Duplicated, ignore.
								continue;
							}

							// Remember this entity to avoid duplicates.
							entryList.add(current);
						}

						// Make sure this is not a repeated level 2 entry.
						if (level == 2) {

							if (GenUtils.isRepeated(items[ISOData.ADMIN1_NAME]
									+ current, entryList) == true) {
								// Duplicated, ignore.
								continue;
							}

							// Remember this entity to avoid duplicates.
							entryList.add(items[ISOData.ADMIN1_NAME] + current);
						}

						String population = null;

						population = getPopulation(items[ISOData.ADMIN1_NAME],
								items[ISOData.COUNTRY_NAME], level);

						// increase count for the container of this entity
						String pVal = pData.get(items[ISOData.ADMIN1_NAME]);

						if (pVal == null) {

							pData.put(items[ISOData.ADMIN1_NAME], population
									+ ":" + 0); //$NON-NLS-1$
							continue;
						}

						// Tokenize
						StringTokenizer tokenizer = new StringTokenizer(pVal,
								":"); //$NON-NLS-1$

						// We know that we expect only two tokens. Get them.
						// Order matters here.
						String[] tokens = new String[2];
						// This is the location
						tokens[CONTAINER] = tokenizer.nextToken().toUpperCase();
						// This is the count of entities
						tokens[COUNT] = tokenizer.nextToken();

						int count = Integer.parseInt(tokens[1]);
						count++;

						pVal = tokens[CONTAINER] + ":" + count; //$NON-NLS-1$

						pData.put(items[ISOData.ADMIN1_NAME], pVal);

						System.out.println("Counted : " //$NON-NLS-1$
								+ items[ISOData.ADMIN1_NAME] + " ADMIN 2 : " //$NON-NLS-1$
								+ items[ISOData.ADMIN2_NAME]);

					} // while loop

					// Now write the results
					Iterator it = pData.keySet().iterator();

					while (it.hasNext()) {

						String key = (String) it.next();
						System.out.println("Key is " + key); //$NON-NLS-1$

						String value = pData.get(key);
						System.out.println("Value is : " + value); //$NON-NLS-1$

						GenUtils.addData(propertiesFile, key + ":" + value //$NON-NLS-1$
								+ "\n"); //$NON-NLS-1$

					}

					// We dont need the ISO code object for this country
					// anymore, we are done processing it.
					isoCode = null;

					// Reset the population list
					if (populationList != null) {
						populationList.clear();
						populationList = null;
					}

					// Reset teh hash map
					pData.clear();

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

		} // For loop

	}

	/**
	 * Find the population value for a given entity.
	 * 
	 * @param entity
	 *            a location
	 * @param level
	 *            administrative level
	 * 
	 * @return the population value for a location
	 */
	protected String getPopulation(String entity, int level) {

		final int ENTITY = 0;

		final int LEVEL = 1;

		final int POPULATION = 2;

		Iterator it = populationList.iterator();

		String entityStr = entity.toUpperCase();

		while (it.hasNext()) {

			String[] popData = ((String) it.next()).split(":"); //$NON-NLS-1$

			if (entityStr.equals(popData[ENTITY].trim().toUpperCase())) {

				// Check both entities belong to same level
				if (String.valueOf(level).equals(popData[LEVEL].trim()) == false) {
					// Ignore : same name , but different level
					continue;
				}

				return popData[POPULATION].trim();
			}
		}
		return DEFAULT;
	}

	/**
	 * Find the population value for a given entity.
	 * 
	 * @param entity
	 *            a location
	 * 
	 * @param entityContainer
	 *            a container for the location (entity)
	 * 
	 * @return the population value for a location
	 */
	protected String getPopulation(String entity, String entityContainer,
			int level) {

		final int ENTITY = 0;

		final int LEVEL = 1;

		final int POPULATION = 2;

		String[] popData = null;

		Iterator it = populationList.iterator();

		String entityStr = entity.toUpperCase().trim();

		String entityContainerStr = entityContainer.toUpperCase();

		while (it.hasNext()) {

			popData = ((String) it.next()).split(":"); //$NON-NLS-1$

			String[] compare = null;

			// Get the entity name and remove blanks
			String location = popData[ENTITY];

			location = location.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

			location = location.toUpperCase().trim();

			// Handle Aliases -- complex stuff :$
			if (location.contains("[")) { //$NON-NLS-1$

				location = location.replace("]", ""); //$NON-NLS-1$ //$NON-NLS-2$

				// Tokenize
				StringTokenizer tokens = new StringTokenizer(location, "["); //$NON-NLS-1$

				// Get tokens -> order matters here!
				compare = new String[tokens.countTokens()];
				int i = 0;
				while (tokens.hasMoreTokens()) {
					compare[i++] = tokens.nextToken().toUpperCase().trim();
				}
			}

			if (compare != null) {
				for (int i = 0; i < compare.length; i++) {
					if (entityStr.replace("-", " ").equals( //$NON-NLS-1$ //$NON-NLS-2$
							compare[i].replace("-", " ")) //$NON-NLS-1$ //$NON-NLS-2$
							|| compare[i].equals(entityStr + "-1") //$NON-NLS-1$
							|| compare[i].equals(entityContainerStr)) {

						return popData[POPULATION].trim();
					}

				}
			} else if (entityStr.equals(location)
					|| entityStr.replace("-", " ").equals(location) //$NON-NLS-1$ //$NON-NLS-2$
					|| location.equals(entityStr + "-1")) { //$NON-NLS-1$

				// Check both entities belong to same level
				if (String.valueOf(level).equals(popData[LEVEL].trim()) == false) {
					// Ignore : same name , but different level
					continue;
				}

				return popData[POPULATION].trim();

			}

		} // while

		return DEFAULT;
	}

	/**
	 * Main execution entry point.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		final int ISO_3166_1 = 0;
		final int POPULATION_DATA = 1;
		final int TARGET_LIST = 2;
		final int OUTPUT_DIR = 3;
		final int PARAMS = 4;

		if (args.length < PARAMS) {
			System.out.println("--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\tTo run, please provide the following arguments : "); //$NON-NLS-1$
			System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
			System.out.println("\t\t Population data file"); //$NON-NLS-1$
			System.out.println("\t\t Target countries file"); //$NON-NLS-1$			
			System.out.println("\t\t Output directory"); //$NON-NLS-1$								
			return;
		}

		PopulationProfiler profiler = new PopulationProfiler(args[ISO_3166_1],
				args[POPULATION_DATA], args[TARGET_LIST], args[OUTPUT_DIR]);
		profiler.run();
	}

}
