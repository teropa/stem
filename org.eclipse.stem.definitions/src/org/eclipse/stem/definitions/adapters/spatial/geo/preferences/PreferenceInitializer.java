package org.eclipse.stem.definitions.adapters.spatial.geo.preferences;

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
import org.eclipse.stem.definitions.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		final IPreferenceStore store = Activator.getDefault()
				.getPreferenceStore();
		store
				.setDefault(
						PreferenceConstants.LAT_LONG_SAMPLE_FREQUENCY_INTEGER_PREFERENCE,
						MapDataManagementPreferencePage.MIN_SAMPLE_FREQUENCY);
		store
				.setDefault(
						PreferenceConstants.DOWN_SAMPLE_LAT_LONG_DATA_BOOLEAN_PREFERENCE,
						false);
		store.setDefault(
				PreferenceConstants.REPORT_IO_EXCEPTIONS_BOOLEAN_PREFERENCE,
				false);
		store
				.setDefault(
						PreferenceConstants.USE_LOWER_RESOLUTION_LAT_LONG_DATA_BOOLEAN_PREFERENCE,
						true);
	} // initializeDefaultPreferences
} // PreferenceInitializer
