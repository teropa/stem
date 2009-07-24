// DiseaseModelPropertyEditorAdapterFactory.java
package org.eclipse.stem.ui.populationmodels.adapters;

/******************************************************************************
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
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 * This class represents
 */
public interface PopulationModelPropertyEditorAdapterFactory {

	PopulationModelPropertyEditorAdapterFactoryImpl INSTANCE = new PopulationModelPropertyEditorAdapterFactoryImpl();

	public class PopulationModelPropertyEditorAdapterFactoryImpl extends
			ComposedAdapterFactory implements
			PopulationModelPropertyEditorAdapterFactory {

		@Override
		public boolean isFactoryForType(Object type) {
			return type == PopulationModelPropertyEditorAdapter.class;
		}

	} // PopulationModelPropertyEditorAdapterFactoryImpl
} // PopulationModelPropertyEditorAdapterFactory