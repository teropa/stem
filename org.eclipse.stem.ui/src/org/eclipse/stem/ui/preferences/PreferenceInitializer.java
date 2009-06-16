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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.stem.ui.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

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
	}

} // PreferenceInitializer
