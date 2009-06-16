package org.eclipse.stem.ui.ge.views;
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
import java.io.IOException;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.stem.ui.ge.Activator;
import org.eclipse.stem.ui.ge.GELog;



/**
 * Class used to initialize default preference values.
 * 
 * Be sure to update whatever documentation there is 
 * to match what we specify below.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		Preferences store = Activator.getDefault()
				.getPluginPreferences();
		// set default to Manual mode
		store.setDefault(GEPreferencePage.P_METHOD,
				GEPreferencePage.M_MANUAL_DISPLAY);

		String defaultFolder = getDefaultFolder();
		store.setDefault(GEPreferencePage.P_FOLDER,defaultFolder);
		store.setDefault(GEPreferencePage.P_INTERNAL_SERVER,true);
		store.setDefault(GEPreferencePage.P_SERVER_HOST,"localhost:8080");
		store.setDefault(GEPreferencePage.P_ASPECT, "");
		store.setDefault(GEPreferencePage.P_WHICH_CYCLE,1);
		store.setDefault(GEPreferencePage.P_AUTO_LAUNCH,true);
		store.setDefault(GEPreferencePage.P_AUTO_LOGGING,true);
		store.setDefault(GEPreferencePage.P_BBOX,false);
		store.setDefault(GEPreferencePage.P_DEBUG, false);
		store.setDefault(GEPreferencePage.P_SHOW_BORDER, false);
		store.setDefault(GEPreferencePage.P_TEST, false);
	}

	/**
	 * determine the default folder
	 * 
	 */
	private String getDefaultFolder() {
		String folder = "/tmp/ge";
		File file = new File(folder);
		if (file.exists() && file.isDirectory()) {
			return folder;
		}		
		try {
			File tmpFile = File.createTempFile("test", ".kml");
			folder = tmpFile.getParent();
			tmpFile.delete();
		} catch (IOException e) {
			GELog.error("Unable to generate KML DisplayArea file.", e);
			folder = null;
		}
		
		return folder;
	}
}
