// Main.java
package org.eclipse.stem.internal.data.geography.isokeycollector;

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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.stem.data.geography.GeographicMapper;
import org.eclipse.stem.data.geography.GeographicNames;
import org.eclipse.stem.data.geography.ISOKey;

/**
 * This class processes the properties files for each country to create a
 * property file that summarizes the level 0 alpha-3 and alpha-2 ISO-3166 codes.
 * It also creates a properties file that contains the names corresponding to
 * each code pair. These are then written to the Earth's "country" (ZZZ) folder.
 */
public class ISOKeyCollector {

	private static final String LEVEL_SUFFIX = "0_node.properties"; //$NON-NLS-1$

	private static final String NAMES_SUFFIX = "names.properties"; //$NON-NLS-1$

	/**
	 * This is the path to the root directory of the property files that define
	 * the graphs.
	 */
	public static final String ROOT_PROPERTY_FILES = "resources" //$NON-NLS-1$
			+ File.separator + "data"; //$NON-NLS-1$

	/**
	 * This is the path to the root directory of the serialized files
	 */
	public static final String ROOT_SERIALIZED_FILES = "temp" + File.separator //$NON-NLS-1$
			+ "data"; //$NON-NLS-1$
	
	private static final String LEVEL_0_PROPERTIES_PATH = ROOT_SERIALIZED_FILES
			+ File.separator
			+ "country" + File.separator + ISOKey.EARTH.toString();//$NON-NLS-1$

	private static final String LEVEL_0_PROPERTIES_FILENAME = LEVEL_0_PROPERTIES_PATH
			+ File.separator + GeographicMapper.ALPHA2_TO_ALPHA3_NAME;

	private static final String LEVEL_0_NAMES_PROPERTIES_FILENAME = LEVEL_0_PROPERTIES_PATH
			+ File.separator
			+ GeographicNames.LEVEL_0_ISO_NAMES_ROOT_NAME
			+ ".properties"; //$NON-NLS-1$

	/**
	 * @param args
	 *            the full path to the root directory of the
	 *            org.eclipse.stem.internal.data plugin directory
	 */
	public static void main(String[] args) {

		// Is the root directory specified?
		if (args.length == 0) {
			// Yes
			System.err
					.println("Missing specification of source directory as an argument"); //$NON-NLS-1$
			return;
		} // if

		final String sourceDir = args[0];

		final String propertyRootDir = sourceDir + File.separator
				+ ROOT_PROPERTY_FILES;

		final Map<ISOKey, ISOKey> isoKeyAlpha2toAlpha3Map = new HashMap<ISOKey, ISOKey>();
		final Map<ISOKey, ISOKey> isoKeyAlpha3toAlpha2Map = new HashMap<ISOKey, ISOKey>();

		final Map<ISOKey, String> isoKeyAlpha2ToNameMap = new HashMap<ISOKey, String>();

		final List<File> propertyFiles = getPropertyFiles(new File(
				propertyRootDir));

		final List<File> level0NodeFiles = getLevel0NodeFiles(propertyFiles);
		for (File nodeFile : level0NodeFiles) {
			final Properties nodeProperties = getProperties(nodeFile);
			final ISOKey alpha3Key = new ISOKey( (String)nodeProperties.get("ISOKEY")); //$NON-NLS-1$
			final ISOKey alpha2Key = extractAlpha2(nodeProperties.getProperty(alpha3Key.toString()));

			isoKeyAlpha2toAlpha3Map.put(alpha2Key, alpha3Key);
			isoKeyAlpha3toAlpha2Map.put(alpha3Key, alpha2Key);
		} // for each File

		// Here we save the mapping between the alpha3 and alpha2 codes for each
		// country
		saveProperties(isoKeyAlpha2toAlpha3Map, sourceDir
				+ File.separator + LEVEL_0_PROPERTIES_FILENAME);

		// Now we need to get the names of each country
		final List<File> nameFiles = getNameFiles(propertyFiles);

		for (File nameFile : nameFiles) {
			final ISOKey isoKey = new ISOKey(nameFile.getName().substring(0, 3));
			final Properties nameProperties = getProperties(nameFile);
			final String name = ((String) nameProperties.get(isoKey.toString()));
			isoKeyAlpha2ToNameMap.put(isoKeyAlpha3toAlpha2Map.get(isoKey),
					(name == null ? isoKey.toString() : name.trim()));
		} // for each File

		saveProperties(isoKeyAlpha2ToNameMap, sourceDir + File.separator
				+ LEVEL_0_NAMES_PROPERTIES_FILENAME);

	} // main

	/**
	 * Save the properties in a file in the Earth's (ZZZ) folder.
	 * 
	 * @param isoKeyMap
	 */
	private static void saveProperties(Map<ISOKey, ? extends Object> isoKeyMap,
			final String fileName) {
		Properties level0Properties = new Properties();
		for (ISOKey isoKey : isoKeyMap.keySet()) {
			level0Properties.setProperty(isoKey.toString(), isoKeyMap.get(
					isoKey).toString());
		} // for
		
		final File level0File = new File(fileName);

		try {
			final File dir = new File(level0File.getParent());
			dir.mkdirs();
			// level0File.createNewFile();
			final BufferedOutputStream propertiesOutputStream = new BufferedOutputStream(
					new FileOutputStream(level0File));
			level0Properties.store(propertiesOutputStream, null);
			propertiesOutputStream.flush();
			propertiesOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // saveProperties

	/**
	 * @param value
	 * @return the ISO 3166 alpha 2 key from the value string
	 */
	private static ISOKey extractAlpha2(final String value) {
		final String temp = value.trim();
		final String retValue = temp.substring(temp.length() - 2);
		return new ISOKey(retValue);
	} // extractAlpha2

	/**
	 * @param nodeFile
	 * @return the properties read from the file
	 */
	private static Properties getProperties(final File nodePropertyFile) {
		final Properties retValue = new Properties();
		if (nodePropertyFile.isFile() && nodePropertyFile.canRead()) {
			// Yes
			BufferedInputStream propertiesInputStream = null;
			try {
				propertiesInputStream = new BufferedInputStream(
						new FileInputStream(nodePropertyFile));
				retValue.load(propertiesInputStream);
				propertiesInputStream.close();
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		} // if can read the properties file
		else {
			System.err.println("The file \"" //$NON-NLS-1$
					+ nodePropertyFile.getAbsolutePath()
					+ "\" is not a file or can't be read."); //$NON-NLS-1$
		}
		// The property values can have extra white space at the end, so we
		// trim...
		for (Object key : retValue.keySet()) {
			final String name = (String) retValue.get(key);
			final String trimmedName = name.trim();
			retValue.put(key, trimmedName);
		} // for each
		return retValue;
	} // getProperties

	/**
	 * @return a list of all the properties files.
	 */
	private static List<File> getPropertyFiles(final File directory) {

		final List<File> retValue = new ArrayList<File>();

		// Does it exist and is it a directory?
		if (directory.exists() && directory.isDirectory()) {
			// Yes
			// Get all of the property files from the directory...
			File[] propertyFiles = directory.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					final String name = pathname.getName();

					boolean valid = pathname.isFile()
							&& name.endsWith(".properties"); //$NON-NLS-1$
					return valid;
				}
			});

			// ...and add them the list we're returning
			Collections.addAll(retValue, propertyFiles);

			// Now get the sub-directories...
			File[] subDirectories = directory.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					return pathname.isDirectory()
							&& !pathname.getName().equals(".svn") //$NON-NLS-1$
							&& !pathname.getName().equals("CVS"); //$NON-NLS-1$
				}
			});

			// ...and process them recursively to get their properties files too
			for (File subDirectory : subDirectories) {
				retValue.addAll(getPropertyFiles(subDirectory));
			}

		} // if directory
		else {
			System.err.println("The directory \"" + directory.getAbsolutePath() //$NON-NLS-1$
					+ "\" doesn't exist or is not a directory"); //$NON-NLS-1$
		}
		return retValue;
	} // getPropertiesFiles

	/**
	 * @param propertyFiles
	 * @return a list of the name property files
	 */
	private static List<File> getNameFiles(List<File> propertyFiles) {
		return filterSuffix(propertyFiles, NAMES_SUFFIX);
	} // getNameFiles

	/**
	 * @param propertyFiles
	 * @return the list of the level 0 node property files
	 */
	private static List<File> getLevel0NodeFiles(List<File> propertyFiles) {
		return filterPath( filterSuffix(propertyFiles, LEVEL_SUFFIX));
	} // getLevel0NodeFiles

	/**
	 * @return the property files whose names end with the suffix.
	 */
	private static List<File> filterSuffix(List<File> propertyFiles,
			String suffix) {
		final List<File> retValue = new ArrayList<File>();

		for (File file : propertyFiles) {
			// Is it a level 0 node file?
			if (file.getName().endsWith(suffix)) {
				// Yes
				retValue.add(file);
			} // if
		} // for each File
		return retValue;
	} // filterSuffix

	/**
	 * @param filterSuffix
	 * @return
	 */
	private static List<File> filterPath(List<File> propertyFiles) {
		final List<File> retValue = new ArrayList<File>();

		final String path = "data" + File.separator + "country"; //$NON-NLS-1$ //$NON-NLS-2$
		
		for (File file : propertyFiles) {
			// Is it a level 0 node file?
			if (file.getAbsolutePath().contains(path)) {
				// Yes
				retValue.add(file);
			} // if
		} // for each File
		return retValue;
	}
	
} // Main
