// DiseaseModelPropertyEditorAdapterFactory.java
package org.eclipse.stem.solvers.fd.presentation;

/******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.stem.core.solver.SolverPropertyEditorAdapter;
import org.eclipse.stem.core.solver.SolverPropertyEditorAdapterFactory;
import org.eclipse.stem.solvers.fd.util.FdAdapterFactory;
import org.eclipse.ui.IStartup;

/**
 *
 */
public class FdSolverPropertyEditorAdapterFactory extends FdAdapterFactory 
	implements SolverPropertyEditorAdapterFactory, IStartup {

	/**
	 * 
	 */
	public FdSolverPropertyEditorAdapterFactory() {
		super();
		SolverPropertyEditorAdapterFactory.INSTANCE
				.addAdapterFactory(this);
	}
	
	/**
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	public void earlyStartup() {
		// Nothing to do here. This method is called after the constructor has
		// run which is the entire point of early activation which causes the
		// factory to be added to the PropertyStringProviderAdapterFactory.INSTANCE
	}

	/**
	 * 
	 */
	@Override
	public Adapter createFiniteDifferenceAdapter() {
		return new FdSolverAdapter();
	}

	/**
	 * 
	 */
	public boolean isFactoryForType(Object type) {
		return type == SolverPropertyEditorAdapter.class
				|| super.isFactoryForType(type);
	}
} 
