package org.eclipse.stem.solvers.fd.presentation;
/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.stem.core.solver.Solver;
import org.eclipse.stem.core.solver.SolverPropertyComposite;
import org.eclipse.stem.core.solver.SolverPropertyEditor;
import org.eclipse.swt.events.ModifyListener;

public class FdSolverPropertyEditorAdapter extends org.eclipse.stem.core.solver.SolverPropertyEditorAdapter
		implements Adapter {

	/**
	 * 
	 */
	@Override
	public SolverPropertyEditor createSolverPropertyEditor(
			SolverPropertyComposite solverPropertyComposite,
			int style, ModifyListener projectValidator) {
		return new FdSolverPropertyEditor(
				solverPropertyComposite, style,
				(Solver) getTarget(), projectValidator);
	} // createSolverPropertyEditor

} // SolverPropertyEditorAdapter
