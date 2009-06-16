package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * STEM II Data Migration/Generation Utilities : The methods in this class are
 * utility methods used by the various data generators for STEM II.
 * 
 */

public class GenUtils {

	/**
	 * Add data to the properties file.
	 * 
	 * @param propertiesFile
	 *            a writer to the output file
	 * @param data
	 *            the data we want to write
	 */
	static protected void addData(PrintWriter propertiesFile, String data) {
		propertiesFile.write(data);
	}

	/**
	 * This method finds what kind of data we are dealing with currently.
	 * 
	 * @param data
	 *            a buffer of diva data
	 * 
	 * @return the admin level of the data
	 */
	static protected int getDataLevel(String[] data) {

		if (isNumeric(data[ISOData.ADMIN2_NAME]) == false) {
			return DataTypes.LEVEL_2;
		} else if (isNumeric(data[ISOData.ADMIN1_NAME]) == false) {
			return DataTypes.LEVEL_1;
		}

		return DataTypes.LEVEL_0;
	}

	/**
	 * Convert from radians to degrees.
	 * 
	 * @param value
	 *            in radians
	 * 
	 * @return double -- the value in degrees
	 */
	static protected double toDegrees(double value) {
		double dValue = value;
		dValue *= 180.0 * (1.0 / java.lang.Math.PI);
		return dValue;
	} // toDegrees

	/**
	 * Extract the workspace out of a path i.e. if given path =
	 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISO3166-1\ISO3166_1_en.txt
	 * This method should return : C:\stemII\
	 * 
	 * @param path
	 * @return workspace
	 */
	static protected String getWorkspace(String path) {
		int i = Integer.MIN_VALUE;
		int j = Integer.MIN_VALUE;

		if (path.contains("\\") == false) //$NON-NLS-1$
			return new String("C:\\Dummy\\"); //$NON-NLS-1$
		i = path.indexOf("\\"); //$NON-NLS-1$
		j = path.indexOf("\\", i + 1); //$NON-NLS-1$

		if (j != Integer.MIN_VALUE) {
			return path.substring(0, j + 1);
		}

		return new String(GenConstants.DUMMY_DIR);
	}

	/**
	 * Convert from a String holding a double value of the form D.DDDDDDD into
	 * an Integer of the form : DDDDDDDD
	 * 
	 * @param value
	 *            string holding a double value in the form D.DDDDDDD
	 * 
	 * @return an Integer value in form DDDDDDDD
	 */
	static protected Integer toIntFormat(String value) {
		Double dVal = Double.valueOf(value);
		return Integer.valueOf((int) (100000000.0 * dVal.doubleValue()));
	}

	/**
	 * Convert an array of Integers into an array of ints.
	 * 
	 * @param an
	 *            array of Integers
	 * 
	 * @return an array of int[]
	 */
	static protected int[] toIntArray(ArrayList<Integer> array) {

		int[] intArray = new int[array.size()];
		Iterator it = array.iterator();

		int index = 0;

		while (it.hasNext()) {
			intArray[index] = ((Integer) it.next()).intValue();
			index++;
		}

		return intArray;

	}

	/**
	 * Convert the value of string to a double
	 * 
	 * @param str
	 * 
	 * @return double
	 */
	static protected double getDouble(String str) {
		Double holder = new Double(str);
		return holder.doubleValue();
	}

	/**
	 * Remove decimal point from value and return its string representation
	 * 
	 * @param degrees
	 * 
	 * @return formatted string
	 */
	static protected String format(double degrees) {
		// String str = null;
		// String subStr = null;

		double dVal = degrees;
		// boolean negative = false;

		// Decimal format does the rounding for us.
		// if (dVal < -0.0000005) {
		// dVal -= 0.0000005;
		// } else if (dVal > 0.0000005) {
		// dVal += 0.0000005;
		// }

		// dVal *= 1000000.0;
		// int iVal = (int) dVal;
		// return ""+iVal;
		// str = Double.toString(dVal);
		// int dot = str.indexOf("."); //$NON-NLS-1$
		// subStr = str.substring(0, str.length() < dot + 7 ? str.length()
		// : dot + 7);
		// return subStr;
		DecimalFormat form = new DecimalFormat("###0.000000"); //$NON-NLS-1$
		return form.format(dVal);

	} // formatData

	/**
	 * Format only six decimal digits after decimal point.
	 * 
	 * @param value
	 *            unformatted value
	 * 
	 * @return formatted string
	 */
	static protected String format(String value) {
		String subStr = null;

		int dot = value.indexOf("."); //$NON-NLS-1$
		subStr = value.substring(0, value.length() < dot + 7 ? value.length()
				: dot + 7);
		return subStr;

	} // formatData

	/**
	 * This method checks to see if we have already seen a given entry.
	 * 
	 * @param current
	 *            entry we are trying to match
	 * @param list
	 *            a list containing all seen entries
	 * 
	 * @return boolean whether the entry is repeated or not
	 * 
	 */
	static protected boolean isRepeated(String current, List<String> list) {

		String currentStr = current.toUpperCase().trim();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			String entry = ((String) it.next()).toUpperCase().trim();
			if (entry.equals(currentStr)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * This method finds what kind of data we are dealing with currently.
	 * 
	 * @param data
	 *            A buffer of pure diva data
	 * 
	 * @return the admin level for the data in this buffer
	 */
	static protected int getLevel(String[] data) {

		if (isNumeric(data[ISOData.ADMIN2_NAME]) == false) {
			return DataTypes.LEVEL_2;
		} else if (isNumeric(data[ISOData.ADMIN1_NAME]) == false) {
			return DataTypes.LEVEL_1;
		}

		return DataTypes.LEVEL_0;
	}

	/**
	 * Test if the string contains a number
	 * 
	 * @param str
	 *            the string for which we want to test if it represents a number
	 * 
	 * @return boolean true if this string represents a number
	 */

	static protected boolean isNumeric(String str) {

		try {
			Double.valueOf(str);
		} catch (NumberFormatException e) { // If an exception is thrown, then
			// it is not a number.
			return false;
		}

		return true;
	}

	/**
	 * Test whether this key represents an active URL or not.
	 * 
	 * @param urlStatus
	 *            A map with tuples (URL:STATUS)
	 * @param key
	 *            The URL whose status we want to get.
	 * 
	 * @return Test whether this key represents an active URL or not.
	 * 
	 */
	static protected boolean isActiveURL(HashMap<String, Boolean> urlStatus,
			String key) {

		if (urlStatus.containsKey(key)) {
			return urlStatus.get(key).booleanValue();
		}

		return false;
	}

	/**
	 * Do a lookup based on name and get the ISO3166-2 fix code for this item.
	 * If we cant match, then record the country and entity name of the
	 * unmatched items.
	 * 
	 * @param list
	 *            a list of ISO3166-2 fix codes
	 * @param entity
	 *            the entity for which we are seeking an ISO code
	 * 
	 * @param country
	 *            the country to which the entity belongs to
	 * 
	 * @return the ISO3166-2 fix code for a given country
	 */
	static protected String getFixCode(List list, String entity, String country) {

		final int COUNTRY = 0;

		final int ADMIN1 = 1;

		final int FIX = 3;

		String entityStr = entity.toUpperCase().trim();

		String countryStr = country.toUpperCase().trim();

		if (list != null) {

			Iterator it = list.iterator();

			while (it.hasNext()) {

				String[] compare = null;

				String code = (String) it.next();

				// Tokenize
				StringTokenizer tokens = new StringTokenizer(code, ":"); //$NON-NLS-1$

				// Get tokens -> order matters here!
				compare = new String[tokens.countTokens()];
				int i = 0;
				while (tokens.hasMoreTokens()) {
					compare[i++] = tokens.nextToken().toUpperCase().trim();
				}

				// Now do the comparison
				if (entityStr.equals(compare[ADMIN1])
						&& countryStr.equals(compare[COUNTRY])) {
					return compare[FIX];
				}
			}
		}

		// Match not found, return itself.
		return entityStr;
	}

	/**
	 * Do a lookup based on name and get the ISO3166-2 info for this item. If we
	 * cant match, then record the country and entity name of the unmatched
	 * items.
	 * 
	 * @param list
	 *            a list of ISO3166-2 codes
	 * @param name
	 *            the entity for which we are seeking an ISO code *
	 * @param alpha2
	 *            the alpha2 code of the country to which the entity belongs to
	 * 
	 * @return the ISO3166-2 descriptor.
	 */
	static protected String getISO2Descriptor(List list, String name,
			String alpha2) {

		ISOCode2 code = null;

		String nameStr = name.toUpperCase();

		if (list != null) {

			Iterator it = list.iterator();

			while (it.hasNext()) {

				String[] compare = null;

				code = (ISOCode2) it.next();

				if (code.getAlpha2().equals(alpha2) == false) {
					continue;
				}

				// IF ISO 3166-2 contains brackets then we have to do two
				// comparisons

				// Get the entity name and remove blanks
				String entity = code.getName().toUpperCase().trim();

				if (entity.contains("[")) { //$NON-NLS-1$

					entity = entity.replace("]", ""); //$NON-NLS-1$ //$NON-NLS-2$

					// Tokenize
					StringTokenizer tokens = new StringTokenizer(entity, "["); //$NON-NLS-1$

					// Get tokens -> order matters here!
					compare = new String[tokens.countTokens()];
					int i = 0;
					while (tokens.hasMoreTokens()) {
						compare[i++] = tokens.nextToken().toUpperCase().trim();
					}
				}

				if (compare != null) {
					for (int i = 0; i < compare.length; i++) {
						if (nameStr.replace("-", " ").equals(compare[i])) { //$NON-NLS-1$ //$NON-NLS-2$

							return code.getId();
						}
					}
				} else if (nameStr.replace("-", " ").equals(code.getName())) { //$NON-NLS-1$ //$NON-NLS-2$
					return code.getId();
				}

			} // while

		} // if

		return nameStr;
	}

	/**
	 * Do a lookup based on name and get the ISO3166-2 object for this item. If
	 * we cant match, then record the country and entity name of the unmatched
	 * items.
	 * 
	 * @param list
	 *            a list of ISO3166-2 codes
	 * @param name
	 *            the entity for which we are seeking an ISO code *
	 * @param alpha2
	 *            the alpha2 code of the country to which the entity belongs to
	 * 
	 * @return the ISO2Code
	 */
	static protected ISOCode2 getISO2Object(List list, String name,
			String alpha2) {

		ISOCode2 code = null;

		String nameStr = name.toUpperCase().trim();

		if (list != null) {

			Iterator it = list.iterator();

			while (it.hasNext()) {

				String[] compare = null;

				code = (ISOCode2) it.next();

				if (code.getAlpha2().equals(alpha2) == false) {
					continue;
				}

				// IF ISO 3166-2 contains brackets then we have to do at least
				// two comparisons

				// Get the entity name and remove blanks
				String entity = code.getName().toUpperCase().trim();

				if (entity.contains("[")) { //$NON-NLS-1$

					entity = entity.replace("]", ""); //$NON-NLS-1$ //$NON-NLS-2$

					// Tokenize
					StringTokenizer tokens = new StringTokenizer(entity, "["); //$NON-NLS-1$

					// Get tokens -> order matters here!
					compare = new String[tokens.countTokens()];
					int i = 0;
					while (tokens.hasMoreTokens()) {
						compare[i++] = tokens.nextToken().toUpperCase().trim();
					}
				}

				if (compare != null) {
					for (int i = 0; i < compare.length; i++) {
						if (nameStr.equals(compare[i])) {

							return code;
						}
					}
				} else if (nameStr.equals(code.getName().toUpperCase().trim())) {
					return code;
				}

			} // while

		} // if

		return new ISOCode2("FOO", "UNK", "UNK", "0"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * Do a lookup based on name and get the ISO3166-2 info for this item. If we
	 * cant match, then record the country and entity name of the unmatched
	 * items.
	 * 
	 * @param list
	 *            a list of ISO3166-2 codes.
	 * @param descriptor
	 *            the descriptor we are trying to match.
	 * 
	 * @return the ISO3166-2 code for a given country
	 */
	static protected ISOCode2 getISO2Object(List list, String descriptor) {

		ISOCode2 code = null;

		String descriptorStr = descriptor.toUpperCase();

		if (list != null) {

			Iterator it = list.iterator();

			while (it.hasNext()) {

				code = (ISOCode2) it.next();

				if (descriptorStr.equals(code.getName())) {
					return code;
				}

			} // while

		} // if

		return null;
	}

	/**
	 * Produce a list of ISO2Codes representing the sorted descriptors in list.
	 * 
	 * @param list
	 *            a list of descriptors
	 * 
	 * @return a list of ISO 3166-2 codes.
	 */
	static protected List<ISOCode2> getSortedDescriptors(List<String> list) {

		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println("Descriptor -> " + it.next()); //$NON-NLS-1$

		}

		return null;
	}

	/**
	 * Find a level 2 value for a given level 2 administration It can be either
	 * area or population depending on the type of data.
	 * 
	 * @param entity
	 *            the entity for which we want to find the value
	 * 
	 * @param state
	 * 
	 * @param list
	 *            a list of level 2 administrations
	 * 
	 * @return the level 2 value (area or population value)
	 */
	static protected String getLevel2Data(String entity, String state, List list) {

		final int ENTITY = 0;

		final int STATE_ID = 1;

		final int AREA = 2;

		String[] data = null;

		Iterator it = list.iterator();

		String entityStr = entity.toUpperCase().trim();

		entityStr = entityStr.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

		String stateStr = state.toUpperCase().trim();

		while (it.hasNext()) {

			data = ((String) it.next()).split(":"); //$NON-NLS-1$

			// Get the entity name and remove blanks
			String location = data[ENTITY].toUpperCase().trim();

			location = location.toUpperCase().trim();

			if (entity.equals(location)) {

				// Check both entities belong to same state
				if (stateStr.equals(data[STATE_ID].trim()) == false) {
					// Ignore : same name , but different level
					continue;
				}
				return data[AREA].trim();
			}

		} // while

		return "0"; //$NON-NLS-1$
	}

	/**
	 * Load all the ISO 3166-2 data for the country described
	 * 
	 * @param isoFile
	 *            file containing ISO 3166-2 codes
	 * 
	 * @return a list holding the ISO 3166-2 codes
	 */
	static protected List<ISOCode2> loadISO2(String isoFile) {

		String buffer = null;
		List<ISOCode2> list = new ArrayList<ISOCode2>();

		BufferedReader reader = openReader(isoFile);
		try {

			if (reader != null) {
				while (EOF(buffer = reader.readLine()) != true) {
					// System.out.println("Read : " + buffer);
					// If this line starts with "#", then ignore it.

					if (buffer.trim().startsWith("#")) { //$NON-NLS-1$
						continue;
					}

					// Make sure that we mark all unknown data.
					buffer.replace(";;", ";UNKNOWN;"); //$NON-NLS-1$ //$NON-NLS-2$

					// Make it all uppercase
					buffer.toUpperCase();

					// Tokenize
					StringTokenizer tokens = new StringTokenizer(buffer, ";"); //$NON-NLS-1$

					// Get tokens -> order matters here!
					String alpha2 = tokens.nextToken().trim();
					String id = tokens.nextToken().trim();
					String name = tokens.nextToken().trim();
					String index = tokens.nextToken().trim();

					ISOCode2 code = new ISOCode2(alpha2, id, name, index);

					// add new code to our list
					list.add(code);

					buffer = null;
				}
				reader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param configFile
	 * @return hash map with all configuration variables and their values
	 */
	static protected HashMap<String, String> loadConfigFile(String configFile) {
		final int VAR = 0;
		final int VALUE = 1;
		final int TOTAL = 2;
		HashMap<String, String> vars = new HashMap<String, String>();
		String buffer = null;
		BufferedReader reader = openReader(configFile);

		try {
			if (reader != null) {
				while (EOF(buffer = reader.readLine()) != true) {

					// If this line starts with "#", then ignore it.
					if (buffer.trim().startsWith("#")) { //$NON-NLS-1$
						System.out.println("\t\t" + buffer); //$NON-NLS-1$
						continue;
					}

					if (buffer.contains("=") == false) { //$NON-NLS-1$
						System.out
								.println("\t\tBad configuration file -- format should be : VAR = VALUE "); //$NON-NLS-1$
						System.out.println("\t\tIgnoring line : " + buffer); //$NON-NLS-1$
						continue;
					}

					String[] tokens = buffer.trim().split("="); //$NON-NLS-1$

					if (tokens.length < TOTAL) {
						System.out
								.println("\t\tBad configuration file -- format should be :  VAR = VALUE  "); //$NON-NLS-1$
						System.out.println("\t\tIgnoring line : " + buffer); //$NON-NLS-1$
						continue;
					}

					// Get variable and value and ignore everything else on the
					// line.
					String var = tokens[VAR].toUpperCase().trim();
					String value = tokens[VALUE].trim();

					// Check that it is a valid CONFIGURATION VARIABLE
					if (verifyVar(var) == false) {
						System.out
								.println("\t\tBad configuration file -- invalid configuration variable : " //$NON-NLS-1$
										+ var);
						System.out.println("\t\tIgnoring line : " + buffer); //$NON-NLS-1$
						continue;
					}

					System.out.println("\t\t<+>" + buffer); //$NON-NLS-1$

					vars.put(var, value);

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Verify that we have a valid workspace. It is the only non-optional
		// variable.
		if (GenUtils.verifyWorkspace(vars) == false) {
			System.out
					.println("\t\tBad configuration file -- WORKSPACE variable not found. Please use format VAR = VALUE (i.e. WORKSPACE = C:\\stemII\\ "); //$NON-NLS-1$
			System.out.println("\t\tIgnoring line : " + buffer); //$NON-NLS-1$
		}

		return vars;

	}

	/**
	 * 
	 * @param var
	 * @return boolean
	 */
	static protected boolean verifyVar(String var) {

		if (var.equals("WORKSPACE") || var.equals("ISO3166_1") //$NON-NLS-1$ //$NON-NLS-2$
				|| var.equals("ISO3166_2") || var.equals("ISO_FIX") //$NON-NLS-1$ //$NON-NLS-2$
				|| var.equals("POP_PROFILES") || var.equals("LEX_DIR") //$NON-NLS-1$ //$NON-NLS-2$
				|| var.equals("TARGET_LIST") || var.equals("AREA_POP") //$NON-NLS-1$ //$NON-NLS-2$
				|| var.equals("POLYGON_AREAS") || var.equals("OUTPUT") //$NON-NLS-1$ //$NON-NLS-2$ 
				|| var.equals("PROPERTIES_OUTPUT") || var.equals("MAP_OUTPUT") //$NON-NLS-1$ //$NON-NLS-2$
				|| var.equals("THRESHOLD") || var.equals("NAMES_LIST") //$NON-NLS-1$ //$NON-NLS-2$ 
				|| var.equals("ITERATIONS") || var.equals("REDUCE_LIST") //$NON-NLS-1$ //$NON-NLS-2$
				|| var.equals("INPUT")) { //$NON-NLS-1$
			return true;
		}

		return false;

	}

	/**
	 * 
	 * @param vars --
	 *            all the configuration variables
	 * @return false if we dont have a valid workspace variable
	 */
	static protected boolean verifyWorkspace(HashMap<String, String> vars) {

		Set<String> keys = vars.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String var = (String) it.next();
			if (var.equals("WORKSPACE")) { //$NON-NLS-1$
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * @param vars --
	 *            all the configuration variables
	 * @return false if we dont have a valid output directory
	 */
	static protected boolean verifyOutputDirectory(HashMap<String, String> vars) {

		Set<String> keys = vars.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String var = (String) it.next();
			if (var.equals("OUTPUT") || var.equals("MAP_OUTPUT") //$NON-NLS-1$ //$NON-NLS-2$
					|| var.equals("PROPERTIES_OUTPUT")) { //$NON-NLS-1$
				return true;
			}
		}

		return false;
	}

	/**
	 * Load selectively the ISO 3166-2 data for the country described by desc
	 * 
	 * @param isoFile
	 *            file containing ISO 3166-2 codes
	 * @param desc
	 *            ISO3166-2 two letter country code
	 * 
	 * @return a list holding the ISO 3166-2 codes
	 */
	static protected List<ISOCode2> loadISO2(String isoFile, String desc) {

		String buffer = null;
		List<ISOCode2> list = new ArrayList<ISOCode2>();

		BufferedReader reader = openReader(isoFile);
		try {

			if (reader != null) {
				while (EOF(buffer = reader.readLine()) != true) {
					// System.out.println("Read : " + buffer);

					// If this line starts with "#", then ignore it.
					if (buffer.trim().startsWith("#")) { //$NON-NLS-1$
						continue;
					}

					// Make sure that we mark all unknown data.
					buffer.replace(";;", ";UNKNOWN;"); //$NON-NLS-1$ //$NON-NLS-2$

					// Make it all uppercase
					buffer.toUpperCase();

					// Tokenize
					StringTokenizer tokens = new StringTokenizer(buffer, ";"); //$NON-NLS-1$

					// Get tokens -> order matters here!
					String alpha2 = tokens.nextToken().trim();
					String id = tokens.nextToken().trim();
					String name = tokens.nextToken().trim();
					String index = tokens.nextToken().trim();

					// If current element does not match our target, then ignore
					// it.
					if (desc.equals(alpha2) == false) {
						continue;
					}

					ISOCode2 code = new ISOCode2(alpha2, id, name, index);

					// add new code to our list
					list.add(code);

					buffer = null;
				}
				reader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Load selectively the ISO 3166-2 fix data for the country described by
	 * desc
	 * 
	 * @param list
	 *            list containing ISO 3166-2 codes
	 * @param code
	 *            ISO3166-1 code whose name attribute we want to match or
	 *            filter.
	 * 
	 * @return a list holding the ISO 3166-2 codes matched.
	 * 
	 */
	static protected List<ISOCode2> extractDescriptors(List list, ISOCode1 code) {

		List<ISOCode2> descriptors = new ArrayList<ISOCode2>();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			String current = (String) it.next();

			if (current.trim().startsWith("#")) { //$NON-NLS-1$
				continue;
			}

			// Tokenize
			StringTokenizer tokens = new StringTokenizer(current, ":"); //$NON-NLS-1$

			// Get tokens -> order matters here!
			String country = tokens.nextToken().trim();
			String name = tokens.nextToken().trim();
			// String alias = tokens.nextToken().trim();
			tokens.nextToken().trim();
			String id = tokens.nextToken().trim();

			// If current element does not match our target, then ignore
			// it.
			if (code.getName().equals(country.toUpperCase()) == false) {
				continue;
			}

			ISOCode2 newCode = new ISOCode2(code.getAlpha2(), id, name, "0"); //$NON-NLS-1$

			// add new code to our list
			descriptors.add(newCode);
		}

		return descriptors;
	}

	/**
	 * Check to see if this ID is a relevant URL source or not. As an example,
	 * for area data we only care about URLs with ID = DIVA For Population data,
	 * we care about URLs with ID = CIA
	 * 
	 * @param urlSet
	 * @param id
	 * 
	 * @return whether a URL is part of this URL set.
	 * 
	 */
	static protected boolean isSourceURL(Set<String> urlSet, String id) {

		if (urlSet.contains(id)) {
			return true;
		}

		return false;
	}

	/**
	 * Find the ISO Code for this country and create an ISO object for it.
	 * 
	 * @param country
	 *            the country to look for.
	 * 
	 * @param codeList
	 *            a list will all the ISO 3166-1 codes.
	 * 
	 * @return the ISO object (ISO info) for this country.
	 */
	static protected ISOCode1 getISOCode(String country, List codeList) {

		Iterator it = codeList.iterator();

		String countryStr = country.toUpperCase();

		while (it.hasNext()) {

			String code = ((String) it.next()).toUpperCase();

			// Tokenize
			StringTokenizer tokens = new StringTokenizer(code, ","); //$NON-NLS-1$

			// Get tokens -> order matters here!
			String name = tokens.nextToken().trim();
			String numeric_code = tokens.nextToken().trim();
			String alpha3 = tokens.nextToken().trim();
			String alpha2 = tokens.nextToken().trim();

			if (name.equals(countryStr)) {
				return new ISOCode1(name, numeric_code, alpha2, alpha3);
			}
		}
		return null;
	}

	/**
	 * Extract all relevant data. We need :
	 * 
	 * The 3 letter ISO3166-1 Alpha 3 code, the country name, the admin1 name,
	 * the admin2 name.
	 * 
	 * @param buffer
	 *            a buffer of diva data
	 * 
	 * @return a string array holding the extracted data
	 * 
	 */
	static protected String[] extract(String buffer) {

		String[] data = new String[4];

		// Tokenize
		StringTokenizer code = new StringTokenizer(buffer, ","); //$NON-NLS-1$
		// System.out.println("\t\tRead : " + buffer);
		// System.out.println("alpha 3 code : " + code.nextToken());
		// System.out.println("country name code : " + code.nextToken());
		// System.out.println("admin1 code : " + code.nextToken());
		// System.out.println("admin2 code : " + code.nextToken());
		// Order matters here.
		data[ISOData.ALPHA3_CODE] = code.nextToken().trim();
		data[ISOData.COUNTRY_NAME] = code.nextToken().trim();
		data[ISOData.ADMIN1_NAME] = code.nextToken().trim();
		data[ISOData.ADMIN2_NAME] = code.nextToken().trim();
		return data;
	}

	/**
	 * Indicate End-Of-File
	 * 
	 * @param buffer
	 *            A buffer of diva data
	 * 
	 * @return True if we have reached End-Of-File
	 */
	static protected boolean EOF(String buffer) {
		if (buffer == null || buffer.length() == 0)
			return true;
		return false;
	}

	/**
	 * This method extracts the alpha two code for a state from the ISO3166-2
	 * descriptor. In other words, given: US-NY, this method should return: NY
	 * Useful for generating the USA only.
	 * 
	 * @param descriptor
	 *            the ISO3166-2 descriptor.
	 * 
	 * @return an Alpha 2 code for a state.
	 * 
	 */
	static protected String extractAlpha2(String descriptor) {

		final int ALPHA2 = 1;

		String[] tokens = null;

		if (descriptor != null) {

			tokens = descriptor.split("-"); //$NON-NLS-1$

		}

		if (tokens.length < ALPHA2) {
			return null;
		}

		return tokens[ALPHA2];
	}
	
	/**
	 * This method extracts the alpha one code for a state from the ISO3166-2
	 * descriptor. In other words, given: US-NY, this method should return: NY
	 * Useful for generating the USA only.
	 * 
	 * @param descriptor
	 *            the ISO3166-2 descriptor.
	 * 
	 * @return an Alpha 1 code for country
	 * 
	 */
	static protected String extractAlpha1(String descriptor) {

		final int ALPHA1 = 0;

		String[] tokens = null;

		if (descriptor != null) {

			tokens = descriptor.split("-"); //$NON-NLS-1$

		}

		if (tokens.length < ALPHA1) {
			return null;
		}

		return tokens[ALPHA1];
	}

	/**
	 * This method simply returns a string with IBM's copyright statement.
	 * 
	 * @return the copyright statement
	 */
	static protected String getCopyright() {

		String copyright = "# /*********************************************************************************************\n"; //$NON-NLS-1$
		copyright += "# * Copyright (c) 2007 IBM Corporation and others.\n"; //$NON-NLS-1$
		copyright += "# * All rights reserved. This program and the accompanying materials\n"; //$NON-NLS-1$
		copyright += "# * are made available under the terms of the Eclipse Public License v1.0\n"; //$NON-NLS-1$
		copyright += "# * which accompanies this distribution, and is available at\n"; //$NON-NLS-1$
		copyright += "# * http://www.eclipse.org/legal/epl-v10.html\n"; //$NON-NLS-1$
		copyright += "# *\n"; //$NON-NLS-1$
		copyright += "# * Contributors:\n"; //$NON-NLS-1$
		copyright += "# *     IBM Corporation - initial API and implementation\n"; //$NON-NLS-1$
		copyright += "# ***********************************************************************************************/\n\n"; //$NON-NLS-1$

		return copyright;

	}

	/**
	 * This method simply returns a string with a copyright statement for the
	 * European data (United Nations).
	 * 
	 * @return the licensing policy for Europe
	 */
	static protected String getUNPolicy() {

		String copyright = "# /*********************************************************************************************\n"; //$NON-NLS-1$
		copyright += "# * The Data source for Europe is \"UNESCO (1987) through UNEP/GRID-Europe.\"\n"; //$NON-NLS-1$
		copyright += "# * For more details please visit : http://www.grid.unep.ch/data/policy.php\n"; //$NON-NLS-1$
		copyright += "# ***********************************************************************************************/\n\n"; //$NON-NLS-1$

		return copyright;

	}

	/**
	 * This method simply returns a string with a copyright statement for the
	 * European data (United Nations).
	 * 
	 * @return the licensing policy for Europe
	 */
	static protected String getGMLUNPolicy() {

		String copyright = "<!-- \n"; //$NON-NLS-1$
		copyright += "# /*********************************************************************************************\n"; //$NON-NLS-1$
		copyright += "# * The Data source for Europe is \"UNESCO (1987) through UNEP/GRID-Europe.\"\n"; //$NON-NLS-1$
		copyright += "# * For more details please visit : http://www.grid.unep.ch/data/policy.php\n"; //$NON-NLS-1$
		copyright += "# ***********************************************************************************************/ -->\n\n"; //$NON-NLS-1$

		return copyright;

	}

	/**
	 * Find a descriptor for the USA based on the location's name.
	 * 
	 * @param county -
	 *            the county for which we want to find the descriptor
	 * 
	 * @param stateID -
	 *            the ID for the state in which this county is located
	 * 
	 * @param List -
	 *            a list containing (descriptor:location) tuples
	 * 
	 * @return String - the descriptor
	 */
	static protected String getUSADescriptor(String county, String stateID,
			List list) {

		final int DESCRIPTOR = 0;

		final int LOCATION = 1;

		String[] data = null;

		Iterator it = list.iterator();

		String countyStr = county.toUpperCase().trim();

		while (it.hasNext()) {

			String miniBuffer = (String) it.next();

			if (miniBuffer.contains("#")) { //$NON-NLS-1$
				continue;
			}

			data = miniBuffer.split(":"); //$NON-NLS-1$

			// Get the location name and remove blanks
			String location = data[LOCATION].toUpperCase().trim();

			location = location.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

			if (countyStr.equals(location)) {

				// Check both entities belong to same state
				if (data[DESCRIPTOR].contains(stateID) == false) {
					// Ignore : same name , but different level
					continue;
				}
				return data[DESCRIPTOR];
			}

		} // while

		// Not found
		return "Not Found"; //$NON-NLS-1$
	}

	/**
	 * This method simply returns a string explaining what a key is in our
	 * properties files.
	 * 
	 * @return the explanation of the key format we use in our properties and
	 *         GML files.
	 */
	static protected String getKeyFormatExplanation() {

		String format = "# /**********************************************************************************************\n"; //$NON-NLS-1$
		format += "# * Key Format: \n"; //$NON-NLS-1$
		format += "# * \n"; //$NON-NLS-1$
		format += "# * \t For level 1 data, the key is the ISO3166-2 code. An ISO3166-2 code is composed as follows: \n"; //$NON-NLS-1$
		format += "# * a two letter country code followed by up to three alphanumeric characters for the level 1 administration.\n"; //$NON-NLS-1$
		format += "# *\n"; //$NON-NLS-1$
		format += "# * \t For level 2 data, the key is the ISO3166-2 code followed by six digits. The leftmost two digits indicate\n"; //$NON-NLS-1$
		format += "# * the level 1 container of a level 2 administration (i.e. California is a level 1 container for Orange County\n"; //$NON-NLS-1$
		format += "# * which is a level 2 administration).  The two digits were taken from a lexicographic sorting of all the\n"; //$NON-NLS-1$
		format += "# * level 1 administrations within a country. Similarly, the four leftmost digits indicate a level 2 administration.\n"; //$NON-NLS-1$
		format += "# * Again, these four digits are an index into the lexicographic sorting of all level 2 administrations within \n"; //$NON-NLS-1$
		format += "# * a level 1 administration. \n"; //$NON-NLS-1$
		format += "# ************************************************************************************************/\n\n"; //$NON-NLS-1$

		return format;
	}

	/**
	 * This method simply returns a string explaining what a key is in our GML
	 * files.
	 * 
	 * @return the explanation of the key format we use in our properties and
	 *         GML files.
	 */
	static protected String getGMLKeyFormatExplanation() {

		String format = "<!-- \n"; //$NON-NLS-1$
		format += "# /*******************************************************************************************************\n"; //$NON-NLS-1$
		format += "# * Key Format: \n"; //$NON-NLS-1$
		format += "# * \n"; //$NON-NLS-1$
		format += "# * \t For level 1 data, the key is the ISO3166-2 code. An ISO3166-2 code is composed as follows: \n"; //$NON-NLS-1$
		format += "# * a two letter country code followed by up to three alphanumeric characters for the level 1 administration.\n"; //$NON-NLS-1$
		format += "# *\n"; //$NON-NLS-1$
		format += "# * \t For level 2 data, the key is the ISO3166-2 code followed by six digits. The leftmost two digits indicate\n"; //$NON-NLS-1$
		format += "# * the level 1 container of a level 2 administration (i.e. California is a level 1 container for Orange County\n"; //$NON-NLS-1$
		format += "# * which is a level 2 administration).  The two digits were taken from a lexicographic sorting of all the\n"; //$NON-NLS-1$
		format += "# * level 1 administrations within a country. Similarly, the four leftmost digits indicate the level 2 administration.\n"; //$NON-NLS-1$
		format += "# * Again, these four digits are an index into the lexicographic sorting of all level 2 administrations within \n"; //$NON-NLS-1$
		format += "# * a level 1 administration. \n"; //$NON-NLS-1$
		format += "# *************************************************************************************************** --> \n\n"; //$NON-NLS-1$

		return format;
	}

	/**
	 * This method simply returns a string with IBM's copyright statement
	 * commented out for GML files.
	 * 
	 * @return the copyright statement
	 */
	static protected String geGMLCopyright() {

		String copyright = "<!-- \n"; //$NON-NLS-1$
		copyright += "# ***************************************************************************************************\n"; //$NON-NLS-1$
		copyright += "# * Copyright (c) 2007 IBM Corporation and others.\n"; //$NON-NLS-1$
		copyright += "# * All rights reserved. This program and the accompanying materials\n"; //$NON-NLS-1$
		copyright += "# * are made available under the terms of the Eclipse Public License v1.0\n"; //$NON-NLS-1$
		copyright += "# * which accompanies this distribution, and is available at\n"; //$NON-NLS-1$
		copyright += "# * http://www.eclipse.org/legal/epl-v10.html\n"; //$NON-NLS-1$
		copyright += "# *\n"; //$NON-NLS-1$
		copyright += "# * Contributors:\n"; //$NON-NLS-1$
		copyright += "# *     IBM Corporation - initial API and implementation\n"; //$NON-NLS-1$
		copyright += "# ********************************************************************************************** --> \n"; //$NON-NLS-1$		

		return copyright;

	}

	/**
	 * 
	 * Find the country name by doing a reverse lookup based on the alpha 2
	 * codes
	 * 
	 * @param alpha2
	 * @param codeList
	 * 
	 * @return country name
	 */
	static protected String getCountryName(String alpha2Code, List codeList) {

		Iterator it = codeList.iterator();

		while (it.hasNext()) {

			String code = ((String) it.next()).toUpperCase();

			// Tokenize
			StringTokenizer tokens = new StringTokenizer(code, ","); //$NON-NLS-1$

			// Get tokens -> order matters here!
			String name = tokens.nextToken().trim();
			tokens.nextToken().trim(); // the numeric code, ignore.
			tokens.nextToken().trim(); // the alpha3 code, ignore.
			String alpha2 = tokens.nextToken().trim().toUpperCase();

			if (alpha2.equals(alpha2Code.toUpperCase())) {
				return name;
			}
		}
		// Not found.
		return null;
	}

	/**
	 * 
	 * Find the country name by doing a reverse lookup based on the numeric code
	 * for a given European location
	 * 
	 * @param numID
	 *            the numerical ID for a location in Europe
	 * @param codeList
	 * 
	 * @return country name
	 */
	static protected String getEuropeanLocation(String numID, List codeList) {

		final int NUMCODE = 0;
		final int LOCATION_NAME = 1;

		Iterator it = codeList.iterator();

		while (it.hasNext()) {

			String loc = ((String) it.next());
			loc = loc.replace('\t', ' ');
			String[] tokens = loc.split(":"); //$NON-NLS-1$
			String code = tokens[NUMCODE].trim();
			String name = tokens[LOCATION_NAME];
			if (numID.equals(code)) {
				return name;
			}
		}
		// Not found.
		return null;
	}

	/**
	 * Do a lookup in the lex2 list for the current entry.
	 * 
	 * @param list
	 *            a list of lex2 objects.
	 * @param admin1
	 *            an administrative 1 location.
	 * @param admin2
	 *            an administrative 2 location.
	 * 
	 * @return a lex2 object for the current location.
	 * 
	 */
	static protected Lex2Obj lex2Lookup(List<Lex2Obj> list, String admin1,
			String admin2) {

		Lex2Obj lexObj = null;
		Iterator it = list.iterator();

		while (it.hasNext()) {
			lexObj = (Lex2Obj) it.next();
			if (admin2.toUpperCase().equals(lexObj.getAdmin2())
					&& admin1.toUpperCase().equals(lexObj.getAdmin1())) {
				return lexObj;
			}
		}
		// Not found.
		// System.out
		// .println("lex2Lookup : entry not found. Creating dummy lex2Object for
		// : "
		// + admin2);
		return new Lex2Obj("0", "AA", "AAA", "DUMMY", "FOO", "FOO"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
	}

	/**
	 * Do a lookup in the lex1 list for the current entry. *
	 * 
	 * @param list
	 *            a list of lex1 objects.
	 * @param admin1
	 *            an administrative 1 location.
	 * 
	 * @return a lex1 object for the current location.
	 * 
	 */
	static protected Lex1Obj lex1Lookup(List<Lex1Obj> list, String entry) {

		if (list == null) {
			return null;
		}

		Iterator it = list.iterator();
		String[] compare = null;
		Lex1Obj lexObj = null;

		while (it.hasNext()) {

			lexObj = (Lex1Obj) it.next();

			if (lexObj.getAdmin1().contains("[")) { //$NON-NLS-1$

				String tempHolder = lexObj.getAdmin1().replace("]", ""); //$NON-NLS-1$ //$NON-NLS-2$

				// Tokenize
				StringTokenizer tokens = new StringTokenizer(tempHolder, "["); //$NON-NLS-1$

				// Get tokens -> order matters here!
				compare = new String[tokens.countTokens()];
				int i = 0;
				while (tokens.hasMoreTokens()) {
					compare[i++] = tokens.nextToken().toUpperCase().trim();
				}
			}

			if (compare != null) {
				// We have more than one entry to compare to. Ex
				// 18:AF-KNR:AF:KONAR [KUNAR]
				// We have to compare individually against KONAR and KUNAR
				// Also, remove hyphens. Ex. for Algeria: Tizi-Ouzou should be
				// Tizi Ouzou
				for (int i = 0; i < compare.length; i++) {
					if (entry.toUpperCase().replace("-", " ") //$NON-NLS-1$ //$NON-NLS-2$
							.equals(compare[i])) {
						return lexObj;
					}
				}
			}

			if (entry.toUpperCase().replace("-", " ") //$NON-NLS-1$ //$NON-NLS-2$
					.equals(lexObj.getAdmin1())) {
				return lexObj;
			}
		}
		// Not found.
		// System.out
		// .println("lex1Lookup : entry not found. Creating dummy lex1Object for
		// : "
		// + entry);
		return new Lex1Obj("0", lexObj.getAlpha2() + "-UNK", "AA", "FOO"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * 
	 * This method takes a List<String> and produces a list of Lex1Objects
	 * 
	 * @param list
	 *            a list of locations
	 * 
	 * @return a list of lex1 objects.
	 */
	static protected List<Lex1Obj> createLex1List(List<String> list) {

		String[] lex1Data = null;
		List<Lex1Obj> lex1List = null;

		if (list != null) {

			Iterator it = list.iterator();
			while (it.hasNext()) {

				// Get the content
				String content = (String) it.next();

				// Tokenize the string
				StringTokenizer code = new StringTokenizer(content, ":"); //$NON-NLS-1$

				// Are we dealing with a lex1 object or with a lex2 object ?
				if (code.countTokens() == Lex1Data.CONSTANTS) {

					if (lex1Data == null) {
						lex1Data = new String[Lex1Data.CONSTANTS];
					}

					// Order matters here.
					lex1Data[Lex1Data.INDEX] = code.nextToken().trim();
					lex1Data[Lex1Data.DESC] = code.nextToken().trim();
					lex1Data[Lex1Data.ALPHA2] = code.nextToken().trim();
					lex1Data[Lex1Data.ADMIN1] = code.nextToken().trim();

					// Now create a lex 1 object
					Lex1Obj lexObj = new Lex1Obj(lex1Data[Lex1Data.INDEX],
							lex1Data[Lex1Data.DESC], lex1Data[Lex1Data.ALPHA2],
							lex1Data[Lex1Data.ADMIN1]);

					if (lex1List == null) {
						lex1List = new ArrayList<Lex1Obj>();
					}
					lex1List.add(lexObj);

				} else {
					System.out
							.println("Malformed lex data object. Total data elements = " //$NON-NLS-1$
									+ code.countTokens() + ". Expected : " //$NON-NLS-1$
									+ Lex1Data.CONSTANTS);
				}

			} // while

		} // if

		return lex1List;
	}

	/**
	 * 
	 * This method takes a List<String> and produces a list of Lex2Objects.
	 * 
	 * @param list
	 *            a list of locations.
	 * 
	 * @return a list of lex2 objects.
	 */
	static protected List<Lex2Obj> createLex2List(List<String> list) {

		String[] lex2Data = null;
		List<Lex2Obj> lex2List = null;

		if (list != null) {

			Iterator it = list.iterator();

			while (it.hasNext()) {

				// Get the content
				String content = (String) it.next();

				// Tokenize the string
				StringTokenizer code = new StringTokenizer(content, ":"); //$NON-NLS-1$

				// Are we dealing with a lex1 object or with a lex2 object ?
				if (code.countTokens() == Lex2Data.CONSTANTS) {

					if (code.countTokens() == Lex2Data.CONSTANTS) {

						if (lex2Data == null) {
							lex2Data = new String[Lex2Data.CONSTANTS];
						}

						// Order matters here.
						lex2Data[Lex2Data.INDEX] = code.nextToken().trim();
						lex2Data[Lex2Data.ALPHA2] = code.nextToken().trim();
						lex2Data[Lex2Data.ALPHA3] = code.nextToken().trim();
						lex2Data[Lex2Data.COUNTRY] = code.nextToken().trim();
						lex2Data[Lex2Data.ADMIN1] = code.nextToken().trim();
						lex2Data[Lex2Data.ADMIN2] = code.nextToken().trim();

						// Now create a lex 2 object
						Lex2Obj lexObj = new Lex2Obj(lex2Data[Lex2Data.INDEX],
								lex2Data[Lex2Data.ALPHA2],
								lex2Data[Lex2Data.ALPHA3],
								lex2Data[Lex2Data.COUNTRY],
								lex2Data[Lex2Data.ADMIN1],
								lex2Data[Lex2Data.ADMIN2]);

						// Create the lex 2 list if necessary
						if (lex2List == null) {
							lex2List = new ArrayList<Lex2Obj>();
						}

						// Add it to our list
						lex2List.add(lexObj);

					} else {
						System.out
								.println("Malformed lex data object. Total data elements = " //$NON-NLS-1$
										+ code.countTokens() + ". Expected : " //$NON-NLS-1$
										+ Lex1Data.CONSTANTS);
					}

				} // if

			} // while

		} // if

		return lex2List;
	}

	/**
	 * finds the admin level of the id by counting '-' characters
	 * @param id
	 * @return
	 */
	@SuppressWarnings("nls")
	public static int getLevel(String id) {
		
		if(id.indexOf("-") ==-1) return 0;
		
		int idx1 = id.indexOf("-");
		String firstPart = id.substring(idx1+1,id.length());
		if(firstPart.indexOf("-") ==-1) return 1;
		
		int idx2 = firstPart.indexOf("-");
		String secondPart = firstPart.substring(idx2+1,firstPart.length());
		if(secondPart.indexOf("-") ==-1) return 2;
		

		int idx3 = secondPart.indexOf("-");
		String thirdPart = secondPart.substring(idx3+1,secondPart.length());
		if(thirdPart.indexOf("-") ==-1) {
			return 3;
		} 
		// TODO should generalize this.
		return 4; // two levels past where we now have data....
		
	}
	
	/**
	 * Return the string resulting from "upping" the level of
	 * the passed in stem id. So for instance, a county ID
	 * would return the state id for the county etc.
	 * 
	 * @param id The id
	 * @return The converted stem id
	 */
	public static String upCode(String id) {
		
		int level = getLevel(id);
		int targetLevel = level -1;
		if(targetLevel == -1) return null;
		StringBuilder res = new StringBuilder();
		int lvl = 0;
		for(int i=0;i<id.length();++i) {
			char c = id.charAt(i);
			if(c == '-') {
				if(lvl == targetLevel) return res.toString();
				++lvl;
			}
			res.append(c);
			
		}
		return null;
	}
	
	/**
	 * Populate a list with whatever source of data is specified. NOTE: the
	 * source has to have the format -> token1:token2:...tokenK
	 * 
	 * @param source
	 *            The file which is source of data
	 * 
	 * @return a list loaded with items as specified by the source
	 * 
	 */
	static protected List<String> populateList(String source) {

		List<String> list = new ArrayList<String>();
		String buffer = null;

		BufferedReader reader = openReader(source);
		try {

			if (reader != null) {
				while (EOF(buffer = reader.readLine()) != true) {
					// If this line starts with "#", then ignore it.
					if (buffer.trim().startsWith("#") //$NON-NLS-1$
							|| buffer.trim().startsWith(":")) { //$NON-NLS-1$
						continue;
					}
					list.add(buffer.trim());
					buffer = null;
				}
				reader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Open a folder for reading
	 * 
	 * @param fileName
	 *            the folder to be opened
	 * 
	 * @return a reference to the folder
	 */
	static protected BufferedReader openFolder(String file) {

		BufferedReader buffer = null;

		try {
			File myFile = new File(file);
			if (!myFile.exists() || !myFile.canRead()) {
				System.out.println("Cant read : " + file); //$NON-NLS-1$
				return null;
			}
			buffer = new BufferedReader(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return buffer;
	}

	/**
	 * Open a file for reading
	 * 
	 * @param fileName
	 *            a folder we want to open
	 * 
	 * @return a reference to the folder
	 */
	static protected File openDirectory(String file) {

		File dir = null;

		dir = new File(file);
		if (!dir.exists() || !dir.canRead() || !dir.isDirectory()) {
			System.out.println("Cant read : " + file); //$NON-NLS-1$
			return null;
		}

		return dir;
	}

	/**
	 * Create a newBufferedReader
	 * 
	 * @param fileName
	 *            the name of the file we want to open for reading
	 * 
	 * @return a reader to a given file
	 */
	static protected BufferedReader openReader(String file) {

		try {

			File f = new File(file);

			if (f.exists() == false) {
				return null;
			}

			return new BufferedReader(new FileReader(file));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Create a new PrintWriter
	 * 
	 * @param fileName
	 *            the name of the file we want to open for writing
	 * @return PrintWriter a writer to a given file
	 */
	static protected PrintWriter openWriter(String file) {

		try {

			return new PrintWriter(new BufferedWriter(new FileWriter(file)));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
