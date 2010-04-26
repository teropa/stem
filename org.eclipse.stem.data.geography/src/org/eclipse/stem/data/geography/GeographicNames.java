// GeographicNames.java
package org.eclipse.stem.data.geography;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.eclipse.emf.common.util.URI;

/**
 * This class is responsible for providing NLS'd names for geographic locations.
 */
public class GeographicNames extends GeographicMapper {

	/**
	 * This is the string that identifies the type of bundle for geographic
	 * names.
	 */
	private static final String NAMES_BUNDLE_TYPE = "names"; //$NON-NLS-1$

	/**
	 * The root name of the file that contains the level 0 names.
	 */
	public static final String LEVEL_0_ISO_NAMES_ROOT_NAME = "level0ISONames"; //$NON-NLS-1$

	private static final String LEVEL_0_RB_NAME = RB_PREFIX + "." //$NON-NLS-1$
			+ LEVEL_0_ISO_NAMES_ROOT_NAME;

	private static ResourceBundle level0RB = null;

	private static Map<String, ResourceBundle> rbMap = new HashMap<String, ResourceBundle>();

	/**
	 * @param isoKey
	 * @return the name of the geographic location that matches isoKey
	 */
	public static String getName(final String isoKey) {
		return getName(isoKey, keyLevel(isoKey));
	} // getName

	/**
	 * @param isoKey
	 * @param level
	 * @return the name of the geographic location that matches isoKey
	 */
	public static String getName(final String isoKey, final int level) {
		try {
			String isoKey2 = isoKey;
			// alpha3 key?
			if (isoKey.length() == 3) {
				// Yes
				isoKey2 = getAlpha2(isoKey);
			} // if

			final ResourceBundle rb = getResourceBundle(isoKey2, level,
					RB_PREFIX, NAMES_BUNDLE_TYPE, LEVEL_0_RB_NAME, level0RB, rbMap);
			return rb.getString(isoKey2).trim();
		} catch (final MissingResourceException e) {
			return isoKey;
		} catch (final NullPointerException e) {
			return '!' + isoKey + '!';
		} // catch NullPointerException
	} // getName

	/**
	 * @param uri the {@link URI} of a geographic location
	 * @return the name of the geographic location that matches {@link URI}
	 */
	public static String getName(URI uri) {
		return getName(uri.lastSegment().toString());
	} // getName

	/**
	 * @param isoKey
	 *            the ISO-3166 alpha2 or alpha3 key of a geographic location
	 * @return the name of the location specified by the isoKey in reverse
	 *         hierarchy, e.g., "Santa Clara Country, California, USA" for the
	 *         ISO Key "US-CA-06085"
	 */
	public static String getReverseHierarchyName(final String isoKey) {
		final StringBuilder sb = new StringBuilder(getName(isoKey));

		String temp = isoKey;
		int i = temp.lastIndexOf("-"); //$NON-NLS-1$
		while( i > 0) {
			// Strip off the last segment of the key
			temp = isoKey.substring(0,i);
			sb.append(", "); //$NON-NLS-1$
			sb.append(getName(temp));
			i = temp.lastIndexOf("-"); //$NON-NLS-1$
		}
		return sb.toString();
	} // getReverseHierarchyName

	/**
	 * @param isoKey
	 *            the isoKey for which any "sub" keys at the level should be
	 *            returned.
	 * @param level
	 *            the administrative level of the key
	 * @return an array of the ISO keys that have the passed key as a prefix.
	 */
	public static Object[] getSubISOKeys(final String isoKey, final int level) {
		Object[] retValue = new Object[] {};

		// Earth (ZZZ)?
		if (isoKey.equals(EARTH_ALPHA3_ISO_KEY)) {
			// Yes
			final Properties alpha2ToAlpha3Map = getAlpha2ToAlpha3Map();
			// Do we have the map?
			if (alpha2ToAlpha3Map != null) {
				// Yes
				// retValue = alpha2ToAlpha3Map.keySet().toArray();
				retValue = alpha2ToAlpha3Map.values().toArray();
			} // if
		} // if Earth
		else {
			// No
			try {
				final ResourceBundle rb = getResourceBundle(isoKey, level,
						RB_PREFIX, NAMES_BUNDLE_TYPE, LEVEL_0_RB_NAME, level0RB, rbMap);
				final List<String> temp = new ArrayList<String>();
				for (final Enumeration<String> keys = rb.getKeys(); keys
						.hasMoreElements();) {
					final String tempKey = keys.nextElement();
					// Is this key at the next level?
					if (tempKey.startsWith(isoKey)
							&& keyLevel(tempKey) == level /* + 1 */) {
						// Yes
						temp.add(tempKey);
					} // if
				} // for each key
				retValue = temp.toArray(new String[] {});
			} catch (final MissingResourceException mre) {
				Activator.logError(mre.getMessage(), mre);
			}
		} // else

		return retValue;
	} // getSubISOKeys
	
	/**
	 * @param isoKey
	 * @param bundlePrefix
	 *            TODO
	 * @param bundleType
	 *            a {@link String} that identifies the type of bundle
	 * @param level0RBName
	 *            the name of the {@link ResourceBundle} file that contains the
	 *            level 0 resources
	 * @param level0RB
	 *            the reference of the level 0 {@link ResourceBundle}
	 * @param rbMap
	 *            a {@link Map} between alpha-2 iso key and
	 *            {@link ResourceBundle}s
	 * @return the {@link ResourceBundle} that contains the mapping
	 */
	protected static ResourceBundle getResourceBundle(final String isoKey,
			final int level, final String bundlePrefix,
			final String bundleType, final String level0RBName,
			ResourceBundle level0RB, Map<String, ResourceBundle> rbMap) {
		ResourceBundle retValue = null;
		// If the level is 0, we handle things specially. There is a single
		// resource bundle that contains all of the level 0 mappings (i.e., the
		// names of all countries) This allows us to avoid reading in all of the
		// other (245!) resource bundles just to obtain the names of the
		// countries. For the other levels we retrieve the bundle specific to
		// the country because it has the names for all levels (i.e., all ISO
		// keys).

		// Level 0?
		if (level == -1 || level == 0) {
			// Yes
			// Have we retrieved the level 0 resource bundle yet?
			if (level0RB == null) {
				// No
				level0RB = ResourceBundle.getBundle(level0RBName);
			} // if
			retValue = level0RB;
		} // if level 0
		else {
			// No
			final String alpha2ISOKey = isoKey.substring(0, 2);

			// We use that value as the key to "cache" the resource bundle
			retValue = rbMap.get(alpha2ISOKey);

			// Have we retrieved this ResourceBundle before?
			if (retValue == null) {
				// No
				retValue = readResourceBundle(alpha2ISOKey, bundlePrefix,
						bundleType);
				// Were we successful?
				if (retValue == null) {
					// No
					Activator.logError(
							"Could not read Resource Bundle of type " //$NON-NLS-1$
									+ bundleType + " for \"" + alpha2ISOKey //$NON-NLS-1$
									+ "\"", null); //$NON-NLS-1$
				} // if
				else {
					// No
					rbMap.put(alpha2ISOKey, retValue);
				} // else
			} // if
		} // else
		return retValue;
	} // getResourceBundle
} // GeographicNames
