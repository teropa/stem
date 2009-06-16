// CountryDirectoryUtilities.java
package org.eclipse.stem.tests.util;

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

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * This class contains utility methods for extracting information such as
 * ISO30166-1 alpha3 codes from directories and their names that contain
 * property files defining graphs representing countries.
 */
public class CountryDirectoryUtilities {

	final static String COUNTRY_DIR_PATH = CountryGraphCreator.RESOURCES_DIR
			+ File.separator + CountryGraphCreator.DATA_DIR + File.separator
			+ CountryGraphCreator.COUNTRY_DIR;

	/**
	 * @param countryCode
	 * @return the name of the country
	 */
	public static String getCountryName(CountryCode countryCode) {
		String retValue = "";

		final String countryPath = COUNTRY_DIR_PATH + File.separator
				+ countryCode + File.separator + countryCode
				+ "_names.properties";

		File countryNamesFile = new File(countryPath);
		if (countryNamesFile.isFile() && countryNamesFile.canRead()) {
			Properties countryNameData = new Properties();
			FileInputStream countryNamesInputStream = null;
			try {
				countryNamesInputStream = new FileInputStream(countryNamesFile);
				countryNameData.load(countryNamesInputStream);
				retValue = countryNameData.getProperty(countryCode.toString());
				countryNamesInputStream.close();
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}

		} else {
			// System.err.println("Trouble reading \"" + countryNamesFile +
			// "\"");
		}
		return retValue;

	} // getCountryName

	/**
	 * This method examines a directory consisting of subdirectories named with
	 * IS03166-1 alpha3 codes and extracts the codes.
	 * 
	 * @return a list of the all of the IS03166-1 alpha3 country codes
	 */
	public static List<CountryCode> getAllCountryCodes() {
		final List<CountryCode> retValue = new ArrayList<CountryCode>();
		for (File countryDirectory : getCountryDirectories()) {
			retValue.add(getCountryCode(countryDirectory));
		}
		return retValue;
	} // getAllCountryCodes

	/**
	 * @param countryDirectory
	 *            directory for a specific country that contains data that
	 *            defines the geograph and features of that country.
	 * @return the three letter code the identifies the country
	 */
	private static CountryCode getCountryCode(final File countryDirectory) {
		CountryCode retValue = null;
		try {
			retValue = new CountryCode(countryDirectory.getCanonicalFile()
					.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retValue;
	} // getCountryCode

	/**
	 * @return a list of the directories that contain the country data
	 */
	public static List<File> getCountryDirectories() {
		List<File> retValue = new ArrayList<File>();

		final File countryDirectory = new File(COUNTRY_DIR_PATH);

		if (countryDirectory.isDirectory()) {
			final File[] countries = countryDirectory
					.listFiles(new FileFilter() {
						public boolean accept(File pathname) {
							// Skip over the subversion directory
							return !pathname.getName().endsWith(".svn");
						}
					});

			for (int i = 0; i < countries.length; i++) {
				retValue.add(countries[i]);
			}
		} else {
			System.err.println("\"" + COUNTRY_DIR_PATH
					+ "\" is not a directory");
		}
		return retValue;

	} // getCountryDirectories

	/**
	 * 
	 * @param countryCode
	 *            the country
	 * @param dataType
	 *            the type of files to return
	 * @return a list of the files for the specified country that contain data
	 *         specified by the data type.
	 */
	public static List<File> getDataFiles(CountryCode countryCode,
			String dataType) {
		final List<File> retValue = new ArrayList<File>();

		final File countryDirectory = new File(COUNTRY_DIR_PATH
				+ File.separator + countryCode);

		if (countryDirectory.isDirectory()) {
			final String suffix = dataType + ".properties";
			final File[] countries = countryDirectory
					.listFiles(new FileFilter() {
						public boolean accept(File pathname) {
							return pathname.getName().endsWith(suffix);
						}
					});

			for (int i = 0; i < countries.length; i++) {
				retValue.add(countries[i]);
			}
		} else {
			System.err.println("\"" + COUNTRY_DIR_PATH
					+ "\" is not a directory");
		}
		return retValue;

	} // getDataFiles

	/**
	 * This class represents an ISO-3166-alpha3 country code
	 */
	public static class CountryCode implements Comparable<CountryCode> {
		private String code = null;

		/**
		 * @param code
		 */
		public CountryCode(String code) {
			this.code = code;
		}

		/**
		 * @return the code
		 */
		public final String getCode() {
			return code;
		}

		/**
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return code.hashCode();
		}

		/**
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final CountryCode other = (CountryCode) obj;
			if (code == null) {
				if (other.code != null)
					return false;
			} else if (!code.equals(other.code))
				return false;
			return true;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return code;
		}

		/**
		 * @param o
		 * @return the value of string compareTo
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(CountryCode o) {
			return this.code.compareTo(o.code);
		}

	} // CountryCode

} // CountryDirectoryUtilities
