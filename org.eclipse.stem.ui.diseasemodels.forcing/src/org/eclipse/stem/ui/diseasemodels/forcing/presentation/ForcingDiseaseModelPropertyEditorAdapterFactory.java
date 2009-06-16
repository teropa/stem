package org.eclipse.stem.ui.diseasemodels.forcing.presentation;
/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.stem.diseasemodels.forcing.util.ForcingAdapterFactory;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditorAdapter;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditorAdapterFactory;

/**
 * @author james
 * 
 */
public class ForcingDiseaseModelPropertyEditorAdapterFactory extends
		ForcingAdapterFactory implements
		DiseaseModelPropertyEditorAdapterFactory {

	/**
	 * 
	 */
	public ForcingDiseaseModelPropertyEditorAdapterFactory() {
		super();
		DiseaseModelPropertyEditorAdapterFactory.INSTANCE
				.addAdapterFactory(this);
	}

	/**
	 * 
	 */
	@Override
	public Adapter createForcingDiseaseModelAdapter() {
		return new ForcingDiseaseModelAdapter();
	}

	/**
	 * 
	 * @see org.eclipse.stem.diseasemodels.forcing.util.ForcingAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	public boolean isFactoryForType(Object type) {
		return type == DiseaseModelPropertyEditorAdapter.class
				|| super.isFactoryForType(type);
	}
} // ForcingDiseaseModelPropertyEditorAdapterFactory
