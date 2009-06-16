package org.eclipse.stem.diseasemodels.preferences;

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
import org.eclipse.stem.diseasemodels.Activator;

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

		// Get # of processors from OS here if possible
		
		String osName = System.getProperty("os.name");
		short numThreads = this.getNumCPUs(osName);
		if(numThreads == 0) numThreads = DiseaseModelingPreferencePage.DEFAULT_SIMULATION_THREADS;
		   
		store
		.setDefault(
				PreferenceConstants.SIMULATION_THREADS,
				DiseaseModelingPreferencePage.DEFAULT_SIMULATION_THREADS);
		
	} // initializeDefaultPreferences

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
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader("/proc/cpuinfo"));

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
