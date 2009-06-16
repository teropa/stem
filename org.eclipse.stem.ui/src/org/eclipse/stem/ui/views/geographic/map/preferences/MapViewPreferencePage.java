// GeographicPreferencePage.java
package org.eclipse.stem.ui.views.geographic.map.preferences;

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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.stem.ui.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents the preferences for the Map view of a simulation.
 */
public class MapViewPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	/**
	 * The ID of the STEM Preference page.
	 */
	public static final String ID_STEM_MAP_VIEW_PAGE = "org.eclipse.stem.ui.views.geographic.map.preferences.MapViewPreferencePage";

	private static final int FIELD_WIDTH = 11;

	private ColorFieldEditor backgroundColorFieldEditor;

	private ColorFieldEditor foregroundColorRelativeValueZeroFieldEditor;

	private BooleanFieldEditor enableMultiColorDisplayFieldEditor;
	private StringFieldEditor sFactorFieldEditor;
	private StringFieldEditor eFactorFieldEditor;
	private StringFieldEditor iFactorFieldEditor;
	private StringFieldEditor rFactorFieldEditor;

	private StringFieldEditor guiScalingFactorFieldEditor;

	/**
	 * Constructor
	 */
	public MapViewPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.getString("MapVPPage.Viz"));
	} // GeographicPreferencePage

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	@Override
	protected void createFieldEditors() {
		backgroundColorFieldEditor = new ColorFieldEditor(
				PreferenceConstants.BACKGROUND_COLOR_PREFERENCE, Messages
						.getString("MapVPPage.bgc"), getFieldEditorParent());

		foregroundColorRelativeValueZeroFieldEditor = new ColorFieldEditor(
				PreferenceConstants.FOREGROUND_RELATIVE_VALUE_ZERO_COLOR_PREFERENCE,
				Messages.getString("MapVPPage.fgrvzeroc"),
				getFieldEditorParent());

		enableMultiColorDisplayFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.MULTI_COLOR_DISPLAY_BOOLEAN_PREFERENCE,
				Messages.getString("MapVPPage.multicolordisplay"),
				getFieldEditorParent());

		sFactorFieldEditor = new StringFieldEditor(
				PreferenceConstants.S_COLOR_WEIGHT_PREFERENCE, Messages
						.getString("MapVPPage.ScolorWeight"), FIELD_WIDTH,
				getFieldEditorParent());
		sFactorFieldEditor.setEmptyStringAllowed(false);

		eFactorFieldEditor = new StringFieldEditor(
				PreferenceConstants.E_COLOR_WEIGHT_PREFERENCE, Messages
						.getString("MapVPPage.EcolorWeight"), FIELD_WIDTH,
				getFieldEditorParent());
		eFactorFieldEditor.setEmptyStringAllowed(false);

		iFactorFieldEditor = new StringFieldEditor(
				PreferenceConstants.I_COLOR_WEIGHT_PREFERENCE, Messages
						.getString("MapVPPage.IcolorWeight"), FIELD_WIDTH,
				getFieldEditorParent());
		iFactorFieldEditor.setEmptyStringAllowed(false);

		rFactorFieldEditor = new StringFieldEditor(
				PreferenceConstants.R_COLOR_WEIGHT_PREFERENCE, Messages
						.getString("MapVPPage.RcolorWeight"), FIELD_WIDTH,
				getFieldEditorParent());
		rFactorFieldEditor.setEmptyStringAllowed(false);

		guiScalingFactorFieldEditor = new StringFieldEditor(
				PreferenceConstants.GUI_SCALING_FACTOR_DOUBLE_PREFERENCE,
				Messages.getString("MapVPPage.gsf"), FIELD_WIDTH,
				getFieldEditorParent());
		guiScalingFactorFieldEditor.setEmptyStringAllowed(false);

		addField(backgroundColorFieldEditor);
		addField(foregroundColorRelativeValueZeroFieldEditor);
		addField(enableMultiColorDisplayFieldEditor);
		addField(sFactorFieldEditor);
		addField(eFactorFieldEditor);
		addField(iFactorFieldEditor);
		addField(rFactorFieldEditor);
		addField(guiScalingFactorFieldEditor);
	} // createFieldEditors

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#checkState()
	 */
	@Override
	protected void checkState() {
		super.checkState();

		// TODO for some reason only the GUI scaling factor is validated on
		// field change
		// Check GUI Scaling factor?
		if (isValid()) {
			// Yes
			// Is the GUI scale factor ok?
			try {
				final double factor = Double
						.parseDouble(guiScalingFactorFieldEditor
								.getStringValue());
				if (factor <= 0.0) {
					setErrorMessage(Messages.getString("GUIScale.negErr"));
					setValid(false);
				} // if
			} catch (Exception e) {
				setErrorMessage(Messages.getString("MapVPPage.numErr"));
				setValid(false);
			} // catch Exception
		} // Check gui Scaling factor

	} // checkState

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if (event.getProperty().equals(FieldEditor.VALUE)) {
			if (event.getSource() == guiScalingFactorFieldEditor) {
				checkState();
			} // if
		} // if
	} // propertyChange

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(@SuppressWarnings("unused")
	IWorkbench workbench) {
		// Nothing
	} // init

} // GeographicPreferencePage
