// DiseaseModelPropertyEditorAdapterFactory.java
package org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor;

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
import org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditorAdapter;

/**
 * This class represents
 */
public interface DiseaseModelPropertyEditorAdapterFactory {

	DiseaseModelPropertyEditorAdapterFactoryImpl INSTANCE = new DiseaseModelPropertyEditorAdapterFactoryImpl();

	public class DiseaseModelPropertyEditorAdapterFactoryImpl extends
			ComposedAdapterFactory implements
			DiseaseModelPropertyEditorAdapterFactory {

		@Override
		public boolean isFactoryForType(Object type) {
			return type == DiseaseModelPropertyEditorAdapter.class;
		}

	} // DiseaseModelPropertyEditorAdapterFactoryImpl
} // DiseaseModelPropertyEditorAdapterFactory
