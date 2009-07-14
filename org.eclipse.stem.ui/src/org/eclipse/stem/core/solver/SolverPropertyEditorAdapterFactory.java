// DiseaseModelPropertyEditorAdapterFactory.java
package org.eclipse.stem.core.solver;

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

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 *
 */
public interface SolverPropertyEditorAdapterFactory {

	SolverPropertyEditorAdapterFactoryImpl INSTANCE = new SolverPropertyEditorAdapterFactoryImpl();

	public class SolverPropertyEditorAdapterFactoryImpl extends
			ComposedAdapterFactory implements
			SolverPropertyEditorAdapterFactory {

		@Override
		public boolean isFactoryForType(Object type) {
			return type == SolverPropertyEditorAdapter.class;
		}

	} 
} 
