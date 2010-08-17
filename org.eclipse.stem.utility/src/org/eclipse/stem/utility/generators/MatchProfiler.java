/**
 * 
 */
package org.eclipse.stem.utility.generators;

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
 * STEM II Data Migration/Generation Utilities : Instances of this class were
 * used at some intermediate point to find matches with missing identifiers. It
 * had a short period of useful life.
 * 
 * To run add the following parameters to the run configuration:
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISO3166-1\ISO3166_1_en.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\AreaPopulationData\
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\Countries.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\match\matchList.txt
 * 
 */

public class MatchProfiler {

	private String ciaData = null;

	private String targetFile = null;

	private String matchFile = null;

	private String iso3166_1 = null;

	/**
	 * Lists for population data.
	 */

	List targetList = null;

	List populationList = null;

	List matchList = null;

	List areaList = null;

	List codeList = null;

	/**
	 * String used to indicate default value for unknown locations.
	 */
	String DEFAULT = "0"; //$NON-NLS-1$

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param ciaData -
	 *            the directory containing population data for all countries
	 * @param targetFile -
	 *            the list of countries to process
	 * @param matchFile -
	 *            the list of locations already matched
	 * 
	 */
	public MatchProfiler(String iso3166_1, String ciaData,
			String targetFile, String matchFile) {
		// Set values of global variables.
		this.iso3166_1 = iso3166_1;
		this.targetFile = targetFile;
		this.matchFile = matchFile;
		this.ciaData = ciaData;
	}

	/**
	 * Run the generator.
	 * 
	 */
	public void run() {
		// Read and keep in memory a list of the countries we want.
		targetList = GenUtils.populateList(targetFile);

		// Load the list of matched locations
		matchList = GenUtils.populateList(matchFile);

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

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

		final int LOCATION = 0;

		final int LEVEL = 1;

		int size = targetList.size();

		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = ((String) targetList.get(i)).trim();
	
			String country = extractCountryName(file);

			// Get the ISO3166-1 info for this
			// country
			if (isoCode == null) {
				isoCode = GenUtils.getISOCode(country, codeList);
			}

			// Read and keep in memory a list of the population data
			// for this country.
			if (populationList == null) {
				String name = ciaData + country + "_POPULATION.txt"; //$NON-NLS-1$
				populationList = GenUtils.populateList(name);
			}

			// Now load the area data for this country.
			if (areaList == null) {
				String name = ciaData + country + "_AREA.txt"; //$NON-NLS-1$
				areaList = GenUtils.populateList(name);
			}

			// Iterate through all of the population list trying to
			// find a
			// location that hasnt been matched already.
			// If a location does not have a match, print it.
			Iterator it = populationList.iterator();

			while (it.hasNext()) {

				String[] data = ((String) it.next()).split(":"); //$NON-NLS-1$

				if (country.equals(data[LOCATION].toUpperCase()) == false
						&& findMatch(data[LOCATION].toUpperCase().trim()) == false
						&& data[LEVEL].trim().equals("1")) { //$NON-NLS-1$
					// output info about this location in the format
					// location, area, population
					String population = getPopulation(data[LOCATION], country,
							1);
					String area = getArea(data[LOCATION], country, 1);
					System.out.println(country + "," + data[LOCATION] + "," //$NON-NLS-1$ //$NON-NLS-2$
							+ area + "," + population); //$NON-NLS-1$
				}

			}

			// We dont need the ISO code object for this country
			// anymore, we are done processing it.
			isoCode = null;

			// Reset the population list
			if (populationList != null) {
				populationList.clear();
				populationList = null;
			}

			// Reset the area list
			if (areaList != null) {
				areaList.clear();
				areaList = null;
			}

			// Run garbage collection
			//System.gc();

		} // For loop

	}

	/**
	 * Extract the country name from the file name. Useful utility method.
	 * 
	 * @param file
	 *            a filename.
	 * 
	 * @return the country name embedded in the filename.
	 */
	String extractCountryName(String file) {

		int separator = file.lastIndexOf("\\"); //$NON-NLS-1$

		int dot = file.lastIndexOf("."); //$NON-NLS-1$

		String substring = file.substring(separator + 1, dot);

		return substring.toUpperCase();
	}

	/**
	 * Find if a given location has been matched already.
	 * 
	 * @param a
	 *            location
	 * 
	 * @return whether a match is found or not for the location.
	 */
	protected boolean findMatch(String location) {

		final int LOCATION = 1;

		Iterator it = matchList.iterator();

		while (it.hasNext()) {

			String[] data = ((String) it.next()).split(":"); //$NON-NLS-1$

			String[] compare = null;

			String entity = data[LOCATION];

			String locationStr = location.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

			locationStr = locationStr.toUpperCase().trim();

			// Handle Aliases -- complex stuff :$
			if (locationStr.contains("[")) { //$NON-NLS-1$

				locationStr = locationStr.replace("]", ""); //$NON-NLS-1$ //$NON-NLS-2$

				// Tokenize
				StringTokenizer tokens = new StringTokenizer(locationStr, "["); //$NON-NLS-1$

				// Get tokens -> order matters here!
				compare = new String[tokens.countTokens()];
				int i = 0;
				while (tokens.hasMoreTokens()) {
					compare[i++] = tokens.nextToken().toUpperCase().trim();
				}
			}

			if (compare != null) {
				for (int i = 0; i < compare.length; i++) {
					if (entity.replace("-", " ").equals(compare[i]) //$NON-NLS-1$ //$NON-NLS-2$
							|| compare[i].equals(entity + "-1")) { //$NON-NLS-1$
						return true;
					}

				}
			} else if (entity.equals(location)
					|| entity.replace("-", " ").equals(location) //$NON-NLS-1$ //$NON-NLS-2$
					|| location.equals(entity + "-1")) { //$NON-NLS-1$

				return true;
			}

			// if (data[LOCATION].toUpperCase().trim().equals(location)) {
			// return true;
			// }
		}

		return false;
	}

	/**
	 * Find the population value for a given entity.
	 * 
	 * @param entity
	 *            a location.
	 * 
	 * @return the population of a location (if found).
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
	 *            a container (i.e. level 1 adminitratiion) for the location
	 * 
	 * 
	 * @return the population of the location
	 */
	protected String getPopulation(String entity, String entityContainer,
			int level) {

		final int ENTITY = 0;

		final int LEVEL = 1;

		final int POPULATION = 2;

		String[] popData = null;

		Iterator it = populationList.iterator();

		String entityStr = entity.toUpperCase().trim();

		entityStr = entityStr.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

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

						// Check both entities belong to same level
						if (String.valueOf(level).equals(popData[LEVEL].trim()) == false) {
							// Ignore : same name , but different level
							continue;
						}

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
	 * Find the area value for a given entity.
	 * 
	 * @param entity
	 *            a location
	 * 
	 * @param entityContainer
	 *            a container (i.e. level 1 adminitratiion) for the location
	 * 
	 * @param level
	 *            the administrative level.
	 * 
	 * @return the area of the location
	 */
	protected String getArea(String entity, String entityContainer, int level) {

		final int ENTITY = 0;

		final int LEVEL = 1;

		final int AREA = 2;

		String[] areaData = null;

		Iterator it = areaList.iterator();

		String entityStr = entity.toUpperCase().trim();

		entityStr = entityStr.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

		String entityContainerStr = entityContainer.toUpperCase();

		while (it.hasNext()) {

			areaData = ((String) it.next()).split(":"); //$NON-NLS-1$

			String[] compare = null;

			// Get the entity name and remove blanks
			String location = areaData[ENTITY];

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

						// Check both entities belong to same level
						if (String.valueOf(level)
								.equals(areaData[LEVEL].trim()) == false) {
							// Ignore : same name , but different level
							continue;
						}

						return areaData[AREA].trim();
					}

				}
			} else if (entityStr.equals(location)
					|| entityStr.replace("-", " ").equals(location) //$NON-NLS-1$ //$NON-NLS-2$
					|| location.equals(entityStr + "-1")) { //$NON-NLS-1$

				// Check both entities belong to same level
				if (String.valueOf(level).equals(areaData[LEVEL].trim()) == false) {
					// Ignore : same name , but different level
					continue;
				}

				return areaData[AREA].trim();
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
		final int CIA_DATA = 1;
		final int TARGET_LIST = 2;
		final int MATCHES = 3;
		final int PARAMS = 4;

		if (args.length < PARAMS) {
			System.out.println("--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\tTo run, please provide the following arguments : "); //$NON-NLS-1$
			System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
			System.out.println("\t\t CIA data"); //$NON-NLS-1$			
			System.out.println("\t\t Target countries file"); //$NON-NLS-1$			
			System.out.println("\t\t Output directory"); //$NON-NLS-1$					
			return;
		}

		MatchProfiler profiler = new MatchProfiler(args[ISO_3166_1],
				args[CIA_DATA], args[TARGET_LIST], args[MATCHES]);
		profiler.run();
	}

}
