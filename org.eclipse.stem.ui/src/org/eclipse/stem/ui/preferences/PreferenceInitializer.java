package org.eclipse.stem.ui.preferences;

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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.stem.ui.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	private static String [] UNIX_OS = {"Linux", "Unix"};
	
	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		// for map and y-axis data display
		store.setDefault(PreferenceConstants.INITIAL_ATTRIBUTE_NAME_STRING_PREFERENCE,
						VisualizationPreferencePage.DEFAULT_INITIAL_ATTRIBUTE_NAME_STRING);
		
		// for phase space display only (x-axis initial)
		store.setDefault(PreferenceConstants.INITIAL_ATTRIBUTE_NAME_STRING_PREFERENCE2,
				VisualizationPreferencePage.DEFAULT_INITIAL_ATTRIBUTE_NAME_STRING2);

		
		// Set up the default color values which we will assign to labels
		store.setDefault(PreferenceConstants.FOREGROUND_COLOR_DEFAULT,
				VisualizationPreferencePage.FOREGROUND_COLOR_DEFAULT_RGB_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_COLOR_LABEL_1,
				VisualizationPreferencePage.FOREGROUND_COLOR_1_RGB_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_COLOR_LABEL_2,
				VisualizationPreferencePage.FOREGROUND_COLOR_2_RGB_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_COLOR_LABEL_3,
				VisualizationPreferencePage.FOREGROUND_COLOR_3_RGB_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_COLOR_LABEL_4,
				VisualizationPreferencePage.FOREGROUND_COLOR_4_RGB_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_COLOR_LABEL_5,
				VisualizationPreferencePage.FOREGROUND_COLOR_5_RGB_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_COLOR_LABEL_6,
				VisualizationPreferencePage.FOREGROUND_COLOR_6_RGB_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_COLOR_LABEL_7,
				VisualizationPreferencePage.FOREGROUND_COLOR_7_RGB_STRING);
		
		// Set up the default string values which we will assign to labels
		store.setDefault(PreferenceConstants.FOREGROUND_STRING_LABEL_DEFAULT,
				VisualizationPreferencePage.FOREGROUND_ATTRIBUTE_NAME_DEFAULT_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_STRING_LABEL_1,
				VisualizationPreferencePage.FOREGROUND_ATTRIBUTE_NAME_1_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_STRING_LABEL_2,
				VisualizationPreferencePage.FOREGROUND_ATTRIBUTE_NAME_2_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_STRING_LABEL_3,
				VisualizationPreferencePage.FOREGROUND_ATTRIBUTE_NAME_3_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_STRING_LABEL_4,
				VisualizationPreferencePage.FOREGROUND_ATTRIBUTE_NAME_4_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_STRING_LABEL_5,
				VisualizationPreferencePage.FOREGROUND_ATTRIBUTE_NAME_5_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_STRING_LABEL_6,
				VisualizationPreferencePage.FOREGROUND_ATTRIBUTE_NAME_6_STRING);
		store.setDefault(PreferenceConstants.FOREGROUND_STRING_LABEL_7,
				VisualizationPreferencePage.FOREGROUND_ATTRIBUTE_NAME_7_STRING);

		
		// store.setDefault(PreferenceConstants.P_BOOLEAN, true);
		// store.setDefault(PreferenceConstants.P_CHOICE, "choice2");
		// store.setDefault(PreferenceConstants.P_STRING,
		// "Default value");
		
		// Get # of processors from OS here if possible
		
		String osName = System.getProperty("os.name");
		short numThreads = this.getNumCPUs(osName);
		if(numThreads == 0) numThreads = SolverPreferencePage.DEFAULT_SIMULATION_THREADS;
		store
		.setDefault(
				PreferenceConstants.SIMULATION_THREADS,
				SolverPreferencePage.DEFAULT_SIMULATION_THREADS);
		
		// Set the default solver to Finite Difference
		store
		.setDefault(
				PreferenceConstants.DEFAULT_SOLVER,
				SolverPreferencePage.DEFAULT_SOLVER);
		
	}

	/**
	 * Return the number of CPUs available on the hardware (if possible)
	 * 
	 * @param os
	 * @return short Number of CPUs, or 0 if not found
	 */
	private short getNumCPUs(String os) {
		// Only for unix os for now
		boolean unix = false;
		for(String o : UNIX_OS) if(os.equalsIgnoreCase(o)) unix = true;
		if(!unix) return 0; 
		// For unix, get the CPU's from /proc/cpuinfo

		short numCPUs = 0;
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("/proc/cpuinfo"));

			if (fileReader != null) {
				String buffer = null;
				while (EOF(buffer = fileReader.readLine()) != true) {
					if(buffer.startsWith("processor")) ++numCPUs;
				}
			}
		} catch (FileNotFoundException fnfe) {
			// Ignore, unable to determine number of processors
		} catch (IOException ioe) {
			// Ignore, unable to determine number of processors
		} finally {
			try {
				fileReader.close();
			} catch (Exception e) {
				// exception on close does not matter
			}
		}
		return numCPUs;
	}
	
	/**
	 @param buffer
	 *            A buffer of diva data
	 * 
	 * @return True if we have reached End-Of-File
	 */
	static protected boolean EOF(String buffer) {
		if (buffer == null)
			return true;
		return false;
	}
	
} // PreferenceInitializer
