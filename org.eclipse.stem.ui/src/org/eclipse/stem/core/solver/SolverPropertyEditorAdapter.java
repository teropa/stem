package org.eclipse.stem.core.solver;
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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.swt.events.ModifyListener;

abstract public class SolverPropertyEditorAdapter extends AdapterImpl
		implements Adapter {

	abstract public SolverPropertyEditor createSolverPropertyEditor(
			SolverPropertyComposite solverPropertyComposite,
			int style, ModifyListener projectValidator);
} // SolverPropertyEditorAdapter
