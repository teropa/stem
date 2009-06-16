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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.stem.definitions.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By sub-classing <code>FieldEditorPreferencePage</code>,
 * we can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class MapDataManagementPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	/**
	 * This is the minimum sample frequency for lat/long polygon data. A value
	 * of 1 means all points are included (i.e. no sampling)
	 */
	public static final int MIN_SAMPLE_FREQUENCY = 1;

	/**
	 * This is the maximum sample frequency for lat/long polygon data. There is
	 * no good value for this.
	 */
	private static final int MAX_SAMPLE_FREQUENCY = 1000;

	BooleanFieldEditor enableDownsampleFieldEditor = null;

	IntegerFieldEditor latLongSampleFrequencyFieldEditor = null;

	BooleanFieldEditor enableIOExceptionReportingFieldEditor = null;

	BooleanFieldEditor useLowResolutionLatLongDataFieldEditor = null;

	/**
	 * Constructor
	 */
	public MapDataManagementPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Latitude/Longitude polygon sample frequence specification.");
	} // MapDataManagementPreferencePage

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {
		enableDownsampleFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.DOWN_SAMPLE_LAT_LONG_DATA_BOOLEAN_PREFERENCE,
				"&Down sample latitude/longitude polygons.",
				getFieldEditorParent());

		latLongSampleFrequencyFieldEditor = new IntegerFieldEditor(
				PreferenceConstants.LAT_LONG_SAMPLE_FREQUENCY_INTEGER_PREFERENCE,
				"&latitude/longitude data sample frequency.",
				getFieldEditorParent());
		latLongSampleFrequencyFieldEditor.setValidRange(MIN_SAMPLE_FREQUENCY,
				MAX_SAMPLE_FREQUENCY);
		latLongSampleFrequencyFieldEditor
				.setErrorMessage("Error: Valid range: " + MIN_SAMPLE_FREQUENCY
						+ " to " + MAX_SAMPLE_FREQUENCY + " data points.");

		enableIOExceptionReportingFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.REPORT_IO_EXCEPTIONS_BOOLEAN_PREFERENCE,
				"&Report I/O Exceptions.", getFieldEditorParent());

		useLowResolutionLatLongDataFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.USE_LOWER_RESOLUTION_LAT_LONG_DATA_BOOLEAN_PREFERENCE,
				"&Use lower resolution lat/long data if available.",
				getFieldEditorParent());

		addField(enableDownsampleFieldEditor);
		addField(latLongSampleFrequencyFieldEditor);
		addField(enableIOExceptionReportingFieldEditor);
		addField(useLowResolutionLatLongDataFieldEditor);
	} // createFieldEditors

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(final IWorkbench workbench) {
		// Nothing
	}

} // MapDataManagementPreferencePage
