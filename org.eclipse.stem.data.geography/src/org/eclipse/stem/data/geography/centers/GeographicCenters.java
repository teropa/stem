// GeographicCenters.java
package org.eclipse.stem.data.geography.centers;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import org.eclipse.stem.data.geography.Activator;
import org.eclipse.stem.data.geography.GeographicMapper;

/**
 * This class is responsible for providing pre-computed geographic Latitude and
 * Longitude for the center of geographic locations.
 */
@SuppressWarnings("nls")
public class GeographicCenters extends GeographicMapper {
	/**
	 * This is the string that identifies the type of bundle for geographic
	 * centers.
	 */
	private static final String CENTERS_BUNDLE_TYPE = "centers"; //$NON-NLS-1$

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
	 *            the ISO-3166 alpha2 or alpha3 key of a geographic location
	 * @return the center of the geographic location that matches isoKey, the
	 *         first index (0) of the array is the latitude, the second (1) is
	 *         the longitude, or <code>null</code> if the center could not be
	 *         found for the key.
	 */
	public static double[] getCenter(final String isoKey) {
		return getCenter(isoKey, keyLevel(isoKey));
	} // getCenter

	/**
	 * @param isoKey
	 *            the ISO-3166 alpha2 or alpha3 key of a geographic location
	 * @param level
	 *            the level of the key
	 * @return the latitude and longitude of the center of the geographic region
	 *         that matches isoKey, or <code>null</code> if not found.
	 */
	
	public static double[] getCenter(final String isoKey, final int level) {
		double[] retValue = null;
		String latLongString = "";

		
		try {
			// World is special
			if(isoKey.equalsIgnoreCase("ZZZ")) {
				retValue = new double[2];
				retValue[0] = 0.0;
				retValue[1] = 0.0;
				return retValue;
			}
			
			String isoKey2 = isoKey;
			// alpha3 key?
			if (isoKey.length() == 3) {
				// Yes
				isoKey2 = getAlpha2(isoKey);
			} // if

			ResourceBundle rb = getResourceBundle(isoKey2, level,
					RB_PREFIX + ".centers", CENTERS_BUNDLE_TYPE,
					LEVEL_0_RB_NAME, level0RB, rbMap);
			try {
			latLongString = rb.getString(isoKey2).trim();
			}  catch (final MissingResourceException e) {
				// Try the 3 letter version
				rb = getResourceBundle(isoKey, level,
						RB_PREFIX + ".centers", CENTERS_BUNDLE_TYPE,
						LEVEL_0_RB_NAME, level0RB, rbMap);
				latLongString = rb.getString(isoKey).trim();
			}
			// Did we get anything?
			if (latLongString != null && !latLongString.equals("")) {
				// Yes
				final StringTokenizer st = new StringTokenizer(latLongString,
						",");
				final String latitudeString = st.nextToken();
				final String longitudeString = st.nextToken();

				retValue = new double[2];
				retValue[0] = Double.parseDouble(latitudeString);
				retValue[1] = Double.parseDouble(longitudeString);
			} // if

		} catch (final MissingResourceException e) {
			retValue = null;
		} catch (final NullPointerException e) {
			retValue = null;
		} // catch NullPointerException
		catch (NumberFormatException nfe) {
			Activator.logError("Error parsing \"" + latLongString
					+ "\" for the lat/long center of \"" + isoKey
					+ "\" Number format?", nfe);
		} // catch NumberFormatException
		catch (NoSuchElementException nsee) {
			Activator.logError("Error parsing \"" + latLongString
					+ "\" for the lat/long center of \"" + isoKey
					+ "\" Missing value?", nsee);
		} // catch NoSuchElementException

		return retValue;
	} // getCenter

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
			final int level,
			final String bundlePrefix, final String bundleType,
			final String level0RBName, ResourceBundle level0RB,
			Map<String, ResourceBundle> rbMap) {
		ResourceBundle retValue = null;

		String alpha2ISOKey = isoKey;
		if (isoKey.length() == 3) {
			alpha2ISOKey = getAlpha2(isoKey);
		}
		else {
			alpha2ISOKey = (isoKey.trim()).substring(0, 2);
		}

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
				Activator.logError("Could not read Resource Bundle of type "
						+ bundleType + " for \"" + alpha2ISOKey + "\"", null);
			} // if
			else {
				// No
				rbMap.put(alpha2ISOKey, retValue);
			} // else
		} // if
		return retValue;
	} // getResourceBundle
} // GeographicCenters
