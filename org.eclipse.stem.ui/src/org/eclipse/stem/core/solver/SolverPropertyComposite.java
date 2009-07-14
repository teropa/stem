// DiseaseModelPropertyComposite.java
package org.eclipse.stem.core.solver;

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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.stem.core.solver.Solver;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.wizards.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * 
 */
public class SolverPropertyComposite extends Composite {

	private Map<Solver, SolverPropertyEditor> modelMap = new HashMap<Solver, SolverPropertyEditor>();

	private StackLayout stackLayout = null;

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public SolverPropertyComposite(final Composite parent,
			final int style, final Solver[] solvers,
			ModifyListener projectValidator) {
		super(parent, style);
		stackLayout = new StackLayout();
		setLayout(stackLayout);

		Label label;
		label = new Label(this, SWT.NONE);
		label.setText(Messages.getString("SPC1")); //$NON-NLS-1$
		SolverPropertyEditor firstOne = null;
		// Any disease models?
		if (solvers != null) {
			// Yes
			for (int i = 0; i < solvers.length; i++) {
				SolverPropertyEditorAdapter spea = (SolverPropertyEditorAdapter) SolverPropertyEditorAdapterFactory.INSTANCE
						.adapt(solvers[i],
								SolverPropertyEditorAdapter.class);

				final SolverPropertyEditor spe = spea
						.createSolverPropertyEditor(this, SWT.NONE,
								projectValidator);

				modelMap.put(solvers[i], spe);
				if (firstOne == null) {
					// Yes
					firstOne = spe;
				} // if
			} // for i
		} // if any disease models?

		stackLayout.topControl = firstOne;
	} // DiseaseModelPropertyComposite

	public void displaySolver(final Solver solver) {
		final SolverPropertyEditor spe = modelMap.get(solver);
		// Did we find it?
		if (spe != null) {
			// Yes
			stackLayout.topControl = spe;
			layout();
		} // if
		else {
			Activator.logError(Messages.getString("SPC2") //$NON-NLS-1$
					+ solver.getClass().getName() + "\"", null); //$NON-NLS-1$
		}
	} // displaySolver
	
	public Solver createSolver() {
		SolverPropertyEditor spe = (SolverPropertyEditor)stackLayout.topControl;
		return spe.createAndPopulateSolver();
	}
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents sub-classing of SWT components
	}

	/**
	 * @return <code>true</code> if the contents of the composite are valid,
	 *         <code>false</code> otherwise.
	 */
	public boolean validate() {
		return ((SolverPropertyEditor) (stackLayout.topControl))
				.validate();
	} // validate

	/**
	 * @return
	 */
	public String getErrorMessage() {
		return ((SolverPropertyEditor) (stackLayout.topControl))
				.getErrorMessage();
	}

	/**
	 * @param solver
	 */
	public void populateSolver(Solver solver) {
		((SolverPropertyEditor) (stackLayout.topControl))
				.populate(solver);
	} // populateSolver

} // SolverPropertyComposite
