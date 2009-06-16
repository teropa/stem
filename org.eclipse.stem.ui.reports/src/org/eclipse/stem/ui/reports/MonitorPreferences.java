package org.eclipse.stem.ui.reports;

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

import java.util.HashSet;
import java.util.Set;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.URI;

/**
 * This class represents
 */
public class MonitorPreferences {

	Plugin plugin = Activator.getDefault();

	/**
	 * the users preferences
	 */
	Preferences prefs = plugin.getPluginPreferences();

	/**
	 * This is a list of location IDs from the user runtime preferences that
	 * remember what locations the user wants to monitor. If no preferences
	 * exist it will create one for the aggregated data at the world level
	 */
	private Set<String> monitorLocationPreferences = new HashSet<String>();

	/**
	 * the ID of the default location the location ID for the aggregated data at
	 * the world level
	 */
	private static final String DEFAULT_LOCATION_ID = "stem://org.eclipse.stem/node/geo/region/ZZZ";

	/**
	 * Prefix to all node URI's
	 */
	private static final String URI_PREFIX = "stem://org.eclipse.stem/node/geo/region/";

	/**
	 * any preference location key must contain this substring
	 * 
	 */
	private static final String LOCATION_KEY_SUBSTRING = "location.";

	/**
	 * the key to the default location should always be defined and should point
	 * to the location ID for the aggregated data at the world level
	 */
	private static final String DEFAULT_LOCATION_KEY = "default.locationID";

	/**
	 * The key to the reference file name for the aggregate view report
	 */
	
	public static final String REFERENCE_FILE_KEY = "reference.file";
	
	/**
	 * 
	 */
	public MonitorPreferences() {

		if (prefs.contains(DEFAULT_LOCATION_KEY)) {
			String uri = prefs.getString(DEFAULT_LOCATION_KEY);
			if (uri != DEFAULT_LOCATION_ID) {
				setDefaultLocation();
			} else {
				monitorLocationPreferences.add(uri);
			}
		} else {
			// set the default ID
			setDefaultLocation();
		}

		// now check the other URI's
		String[] allKeys = prefs.propertyNames();
		for (int i = 0; i < allKeys.length; i++) {
			if (allKeys[i].contains(LOCATION_KEY_SUBSTRING)
					|| allKeys[i].contains(DEFAULT_LOCATION_KEY)) {
				String nextID = prefs.getString(allKeys[i]);
				monitorLocationPreferences.add(nextID);
			}
		} // for all keys

	} // constructor

	/**
	 * 
	 */
	public void setDefaultLocation() {
		prefs.setValue(DEFAULT_LOCATION_KEY, DEFAULT_LOCATION_ID);
		monitorLocationPreferences.add(DEFAULT_LOCATION_ID);
		plugin.savePluginPreferences();
	}

	/**
	 * 
	 * @return a set of preferred locations to monitor
	 */
	public Set<String> getMonitorLocationPreferences() {
		return monitorLocationPreferences;
	}

	/**
	 * @param monitorLocationPreferences
	 */
	public void setMonitorLocationPreferences(
			Set<String> monitorLocationPreferences) {
		this.monitorLocationPreferences = monitorLocationPreferences;
	}

	/**
	 * @param newID
	 */
	public void addLocationPref(String newID) {
		if (prefs != null) {
			// is it really new?

			if (!monitorLocationPreferences.contains(newID)) {
				// we use the uri being added to generate a unique key
				// by concatenating "location."+newURI
				// preferences keys must be unique
				// this also guarantees we never duplicate the same location
				prefs.setValue(LOCATION_KEY_SUBSTRING + newID, newID);
				this.monitorLocationPreferences.add(newID);
				plugin.savePluginPreferences();
			} // it ID is really new
		} // if prefs not null
	} // addLocationPref

	/**
	 * @param oldID
	 */
	public void removeLocationPref(String oldID) {
		if (prefs != null) {
			// is it really new?
			if (!monitorLocationPreferences.contains(oldID))
				this.monitorLocationPreferences.remove(oldID);

			// does not work. No remove method?
			// prefs.setToDefault(oldID);
			// prefs.setValue(oldID, "");
			plugin.savePluginPreferences();
		} // if prefs not null
	} // removeLocationPref

	/**
	 * removes the uri prefix from an string ID
	 * 
	 * @param uri
	 * @return URIsuffix - the geographic code part of the uri
	 */
	public static String getURIsuffix(String uri) {
		String retVal = uri.replaceAll(URI_PREFIX, "");
		return retVal;
	}// get uri suffix

	/**
	 * returns the default location ID as a URI
	 * 
	 * @return the URI
	 */
	public static URI getDefaultURI() {
		return URI.createURI(DEFAULT_LOCATION_ID);
	}
}
