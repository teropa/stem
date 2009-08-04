package org.eclipse.stem.ui.populationmodels.preferences;

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

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.stem.ui.populationmodels.Activator;
import org.eclipse.stem.ui.populationmodels.standard.wizards.PopulationModelWizardMessages;
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

public class PopulationPreferencePage extends
		FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	
	/**
	 * Constructor
	 */
	public PopulationPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(PopulationModelWizardMessages.getString("PopulationPPageTITLE")); //$NON-NLS-1$
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		long refPop = store.getLong(PreferenceConstants.REFERENCE_POPULATION);
		long refDens = store.getLong(PreferenceConstants.REFERENCE_DENSITY);
		
		final IntegerFieldEditor referencePopulationThreadsFieldEditor = new IntegerFieldEditor(
				PreferenceConstants.REFERENCE_POPULATION,
				PopulationModelWizardMessages.getString("ReferencePopulation"), getFieldEditorParent()); //$NON-NLS-1$
		
		referencePopulationThreadsFieldEditor.setStringValue(""+refPop);
		addField(referencePopulationThreadsFieldEditor);
		
		final IntegerFieldEditor referenceDensityThreadsFieldEditor = new IntegerFieldEditor(
				PreferenceConstants.REFERENCE_DENSITY,
				PopulationModelWizardMessages.getString("ReferenceDensity"), getFieldEditorParent()); //$NON-NLS-1$
		referencePopulationThreadsFieldEditor.setStringValue(""+refDens);
		addField(referenceDensityThreadsFieldEditor);
		
	} // createFieldEditors

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		// Nothing
	}

} // PopulationPreferencePage
