package org.eclipse.stem.util.analysis;

/*******************************************************************************
 * Copyright (c) 2007 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Preferences;

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
	 * the ID of the default location the location ID for the aggregated data at
	 * the world level
	 */
	private static final String DEFAULT_PREFERENCE = "PREVIOUS_FOLDER";
	
	/**
	 * the ID of the estimator method
	 */
	private static final String ESTIMATOR_PREFERENCE = "ESTIMATOR_METHOD";

	
	/**
	 * the default folder location
	 */
	private static final String DEFAULT_PREF_VALUE = "";
    
	String recentFolder = null;
	
	String recentEstimationMethod = null;
	

	/**
	 * 
	 */
	public MonitorPreferences() {
		if (prefs.contains(DEFAULT_PREFERENCE)) {
			recentFolder = prefs.getString(DEFAULT_PREFERENCE);
		}  else {
			// first time only
			recentFolder = DEFAULT_PREF_VALUE;
			setPreferences();
		}
		
		if (prefs.contains(ESTIMATOR_PREFERENCE)) {
			recentEstimationMethod = prefs.getString(ESTIMATOR_PREFERENCE);
		}  else {
			recentEstimationMethod = null;
			setPreferences();
		}
	} // constructor

	/**
	 *  set the preferences
	 */
	public void setPreferences() {
		prefs.setValue(DEFAULT_PREFERENCE, recentFolder);
		if(recentEstimationMethod != null) prefs.setValue(ESTIMATOR_PREFERENCE, recentEstimationMethod);
		plugin.savePluginPreferences();
	}
	
	

	

	/**
	 *  set the preferences based on user action
	 * @param consumer specific class that sets or gets this folder preference
	 * @param recent 
	 */
	public void setRecentFolder(String consumer, String recent) {
		recentFolder=recent;
		prefs.setValue(consumer+"_"+DEFAULT_PREFERENCE, recentFolder);
		plugin.savePluginPreferences();
	}

	/**
	 *  set the preferences based on user action
	 * @param method 
	 */
	public void setEstimatorMethod(String method) {
		recentEstimationMethod=method;
		prefs.setValue(ESTIMATOR_PREFERENCE, recentEstimationMethod);
		plugin.savePluginPreferences();
	}
	
	
	
	/**
	 * 
	 * @param consumer 
	 * @return recently used folder
	 */
	public String getRecentFolder(String consumer) {
		recentFolder = prefs.getString(consumer+"_"+DEFAULT_PREFERENCE);
		if((recentFolder==null)||(recentFolder.length()==0)) {
			recentFolder = DEFAULT_PREF_VALUE;
			setRecentFolder(consumer, recentFolder);
			}
		return recentFolder;
	}
	
	
	
	
	/**
	 * 
	 * @return recently used estimation method
	 */
	public String getRecentEstimatorMethod() {
		return recentEstimationMethod;
	}
}// class
