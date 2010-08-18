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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.solver.Solver;
import org.eclipse.stem.ui.Activator;
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

public class SolverPreferencePage extends
FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * This is the default number of threads to use when running
	 * a simulation. The default is used if the number of CPUs cannot
	 * be detected
	 */

	public static final int DEFAULT_SIMULATION_THREADS = 2;

	/**
	 * The default solver. Finite difference solver is
	 * always assumed to be available.
	 */

	public static final String DEFAULT_SOLVER = "org.eclipse.stem.solvers.fd.impl.FiniteDifferenceImpl";

	/**
	 * Constructor
	 */
	public SolverPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.getString("DMPPageTITLE")); //$NON-NLS-1$
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {

		final IntegerFieldEditor simulationThreadsFieldEditor = new IntegerFieldEditor(
				PreferenceConstants.SIMULATION_THREADS,
				Messages.getString("DMPPageSimThreads"), getFieldEditorParent()); //$NON-NLS-1$

		addField(simulationThreadsFieldEditor);


		Solver [] solvers = getSolvers();
		String [][] namesAndValues = new String[solvers.length][solvers.length];

		for(int i=0;i<solvers.length;++i) {
			namesAndValues[i][0] = solvers[i].getClass().getSimpleName();
			namesAndValues[i][1] = solvers[i].getClass().getName();
		}

		final ComboFieldEditor comboFieldEditor = new ComboFieldEditor(
				PreferenceConstants.DEFAULT_SOLVER,
				Messages.getString("DMPPageDefaultSolver"),
				namesAndValues, getFieldEditorParent());

		addField(comboFieldEditor);

	} // createFieldEditors

	/**
	 * getSolvers Return registered solvers
	 * 
	 * @return Solver [] Available solvers
	 */

	public static org.eclipse.stem.core.solver.Solver [] getSolvers() {
		Solver [] solvers;
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IConfigurationElement[] solverConfigElements = registry
		.getConfigurationElementsFor(org.eclipse.stem.core.Constants.ID_SOLVER_EXTENSION_POINT);

		final List<Solver> temp = new ArrayList<Solver>();

		//solvers = new Solver[solverConfigElements.length];

		for (int i = 0; i < solverConfigElements.length; i++) {
			final IConfigurationElement element = solverConfigElements[i];
			// Does the element specify the class of the disease model?
			if (element.getName().equals(Constants.SOLVER_ELEMENT)) {
				// Yes
				try {
					temp.add((Solver) element
							.createExecutableExtension("class")); //$NON-NLS-1$
				} catch (final CoreException e) {
					Activator.logError(
							"Can't create solver", e); //$NON-NLS-1$
				}
			} // if
		} // for each configuration element

		solvers = temp.toArray(new Solver[] {});

		return solvers;
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		// Nothing
	}

} // SimulationManagementPreferencePage
