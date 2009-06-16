// GeographicPreferencePage.java
package org.eclipse.stem.ui.views.geographic.preferences;

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
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.stem.ui.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents the preferences for the Map view of a simulation.
 */
public class GeographicPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	/**
	 * The ID of the STEM Geographic view Preference page.
	 */
	public static final String ID_STEM_GEOGRAPHIC_VIEW_PREFERENCE_PAGE = "org.eclipse.stem.ui.views.geographic.preferences.GeographicViewPreferencePage";

	private static final int FIELD_WIDTH = 11;

	private BooleanFieldEditor drawPolygonBordersFieldEditor;

	private ColorFieldEditor borderColorFieldEditor;

	private BooleanFieldEditor logScaleFieldEditor;

	private StringFieldEditor gainFactorFieldEditor;

	/**
	 * Constructor
	 */
	public GeographicPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.getString("GeoPPage.Viz"));
	} // GeographicPreferencePage

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	@Override
	protected void createFieldEditors() {

		drawPolygonBordersFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.DRAW_POLYGON_BORDERS_BOOLEAN_PREFERENCE,
				Messages.getString("GeoPPage.drawpolyborders"),
				getFieldEditorParent());

		borderColorFieldEditor = new ColorFieldEditor(
				PreferenceConstants.BORDER_COLOR_PREFERENCE, Messages
						.getString("GeoPPage.bc"), getFieldEditorParent());

		logScaleFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.LOGSCALE_BOOLEAN_PREFERENCE, Messages
						.getString("GeoPPage.logscale"), getFieldEditorParent());

		gainFactorFieldEditor = new StringFieldEditor(
				PreferenceConstants.GAIN_FACTOR_PREFERENCE, Messages
						.getString("GeoPPage.gainf"), FIELD_WIDTH,
				getFieldEditorParent());
		gainFactorFieldEditor.setEmptyStringAllowed(false);

		addField(drawPolygonBordersFieldEditor);
		addField(borderColorFieldEditor);
		addField(logScaleFieldEditor);
		addField(gainFactorFieldEditor);
	} // createFieldEditors

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#checkState()
	 */
	@Override
	protected void checkState() {
		super.checkState();

		// Check Gain factor?
		if (isValid()) {
			// Yes
			// Is the Gain factor ok?
			try {
				final double factor = Double.parseDouble(gainFactorFieldEditor
						.getStringValue());
				if (factor <= 0.0) {
					setErrorMessage(Messages.getString("GFactor.negErr"));
					setValid(false);
				} // if
			} catch (Exception e) {
				setErrorMessage(Messages.getString("GeoPPage.numErr"));
				setValid(false);
			} // catch Exception
		} // Check gui Scaling factor

	} // checkState

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(@SuppressWarnings("unused")
	IWorkbench workbench) {
		// Nothing
	} // init

} // GeographicPreferencePage
