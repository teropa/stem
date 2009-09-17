package org.eclipse.stem.jobs.preferences;

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
import org.eclipse.stem.jobs.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By sub-classing <samp>FieldEditorPreferencePage</samp>,
 * we can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class SimulationManagementPreferencePage extends
		FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * The minimum number of milliseconds that can be specified to pause each
	 * simulation cycle
	 */
	public static final int MIN_SIMULATION_SLEEP_MILLISECONDS = 0;

	/**
	 * The maximum number of milliseconds that can be specified to pause each
	 */
	public static final int MAX_SIMULATION_SLEEP_MILLISECONDS = 3600000;

	/**
	 * The maximum number of digits allowed in cycle pause milliseconds
	 */
	public static final int MAX_SIMULATION_SLEEP_SECONDS_NUM_DIGITS = Integer
			.toString(MAX_SIMULATION_SLEEP_MILLISECONDS).length();

	/**
	 * The default value for the simulation sleep preference.
	 * 
	 * @see #DEFAULT_SIMULATION_SLEEP
	 */
	public static final boolean DEFAULT_SIMULATION_SLEEP = true;

	/**
	 * This is the default value for the number of seconds to pause the
	 * simulation on each cycle.
	 * 
	 * @see #DEFAULT_SIMULATION_SLEEP
	 */
	public static final int DEFAULT_SIMULATION_SLEEP_MILLISECONDS = 1000;

	/**
	 * This is the default value for reporting all unresolved
	 * <code>Identifiables</code>. Value: <code>false</code>
	 */
	public static final boolean DEFAULT_SIMULATION_REPORT_EACH_UNRESOLVED_IDENTIFIABLE = false;

	/**
	 * This is the default value for reporting all unresolved
	 * Air transport edges Value: <code>false</code>
	 */

	public static final boolean DEFAULT_SIMULATION_REPORT_DANGLING_AIR_TRANPORT_EDGES = false;
	
	/**
	 * This is the default value for reporting the number of unresolved
	 * <code>Identifiables</code>. Value: <code>true</code>
	 */
	public static final boolean DEFAULT_SIMULATION_REPORT_NUMBER_UNRESOLVED_IDENTIFIABLE = false;
	
	/**
	 * This is the default value for caching. Value: <code>true</code>
	 */
	public static final boolean DEFAULT_USE_SCENARIOS_CACHING = true;

	/**
	 * Constructor
	 */
	public SimulationManagementPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.getString("SMPPageTITLE")); //$NON-NLS-1$
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {

		final BooleanFieldEditor cyclePauseFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.SIMULATION_SLEEP_BOOLEAN,
				Messages.getString("SMPPagePause"), getFieldEditorParent()); //$NON-NLS-1$

		final IntegerFieldEditor cyclePauseSecondsFieldEditor = new IntegerFieldEditor(
				PreferenceConstants.SIMULATION_SLEEP_MILLISECONDS_INTEGER,
				Messages.getString("SMPPageMSToPause"), getFieldEditorParent()); //$NON-NLS-1$
		cyclePauseSecondsFieldEditor.setValidRange(
				MIN_SIMULATION_SLEEP_MILLISECONDS, MAX_SIMULATION_SLEEP_MILLISECONDS);
		cyclePauseSecondsFieldEditor
				.setTextLimit(MAX_SIMULATION_SLEEP_SECONDS_NUM_DIGITS);
		cyclePauseSecondsFieldEditor.setErrorMessage(Messages.getString("SMPPage0") //$NON-NLS-1$
				+ MIN_SIMULATION_SLEEP_MILLISECONDS + Messages.getString("SMPPageTO") //$NON-NLS-1$
				+ MAX_SIMULATION_SLEEP_MILLISECONDS + Messages.getString("SMPPageSECONDS")); //$NON-NLS-1$

		final BooleanFieldEditor reportEachUnresolvedIdentifiableFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.REPORT_EACH_UNRESOLVED_IDENTIFIABLE_BOOLEAN,
				Messages.getString("SMPPageReportUnresolved"), getFieldEditorParent()); //$NON-NLS-1$

		final BooleanFieldEditor reportDanglingAirTransportEdgesFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.REPORT_DANGLING_AIR_TRANPORT_EDGES_BOOLEAN,
				Messages.getString("SMPPageReportAirTransport"), getFieldEditorParent()); //$NON-NLS-1$

		final BooleanFieldEditor reportNumberOfUnresolvedIdentifiablesFieldEditor = new BooleanFieldEditor(
				PreferenceConstants.REPORT_NUMBER_OF_UNRESOLVED_IDENTIFIABLES_BOOLEAN,
				Messages.getString("SMPPageReportNumUnresolved"), getFieldEditorParent()); //$NON-NLS-1$
		
		final BooleanFieldEditor useScenariosCaching = new BooleanFieldEditor(
				PreferenceConstants.USE_SCENARIOS_CACHING_BOOLEAN,
				Messages.getString("SMPPageCacheScenarios"), getFieldEditorParent()); //$NON-NLS-1$
		
		addField(cyclePauseFieldEditor);
		addField(cyclePauseSecondsFieldEditor);
		addField(reportEachUnresolvedIdentifiableFieldEditor);
		addField(reportDanglingAirTransportEdgesFieldEditor);
		addField(reportNumberOfUnresolvedIdentifiablesFieldEditor);
		addField(useScenariosCaching);
	} // createFieldEditors

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(@SuppressWarnings("unused")//$NON-NLS-1$
			IWorkbench workbench) {
		// Nothing
	}

} // SimulationManagementPreferencePage
