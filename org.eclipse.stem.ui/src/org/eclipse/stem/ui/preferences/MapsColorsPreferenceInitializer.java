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
import org.eclipse.stem.ui.adapters.color.RelativeValueColorPreferences;

/**
 * Class used to initialize default preference values.
 */
public class MapsColorsPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(MapsColorsPreferencePage.FOREGROUND_COLOR_ID, MapsColorsPreferencePage.FOREGROUND_COLOR_DEFAULT_RGB_STRING);
		store.setDefault(MapsColorsPreferencePage.BACKGROUND_COLOR_ID, MapsColorsPreferencePage.BACKGROUND_COLOR_DEFAULT_RGB_STRING);
		store.setDefault(MapsColorsPreferencePage.BORDERS_COLOR_ID, MapsColorsPreferencePage.BORDERS_COLOR_DEFAULT_RGB_STRING);
		store.setDefault(MapsColorsPreferencePage.EDGES_COLOR_ID, MapsColorsPreferencePage.EDGES_COLOR_DEFAULT_RGB_STRING);
		
		//This too should be done by using the extension-points mechanism. The color providers are unknown.
		store.setDefault(RelativeValueColorPreferences.FOREGROUND_COLOR_ZERO_RELATIVE_VALUE_ID, RelativeValueColorPreferences.FOREGROUND_COLOR_ZERO_RELATIVE_VALUE_DEFAULT_RGB_STRING);
		store.setDefault(RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_1_ID, RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_1_DEFAULT_RGB_STRING);
		store.setDefault(RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_2_ID, RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_2_DEFAULT_RGB_STRING);
		store.setDefault(RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_3_ID, RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_3_DEFAULT_RGB_STRING);
		store.setDefault(RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_4_ID, RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_4_DEFAULT_RGB_STRING);
		store.setDefault(RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_5_ID, RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_5_DEFAULT_RGB_STRING);
		store.setDefault(RelativeValueColorPreferences.FOREGROUND_COLOR_MAXIMUM_RELATIVE_VALUE_ID, RelativeValueColorPreferences.FOREGROUND_COLOR_MAXIMUM_RELATIVE_VALUE_DEFAULT_RGB_STRING);
	} // initializeDefaultPreferences

} // PreferenceInitializer
