package org.eclipse.stem.diseasemodels.multipopulation.presentation;
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
import org.eclipse.stem.diseasemodels.multipopulation.util.MultipopulationAdapterFactory;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditorAdapter;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditorAdapterFactory;

/**
 * @author james
 * 
 */
public class MultiPopulationDiseaseModelPropertyEditorAdapterFactory extends
		MultipopulationAdapterFactory implements
		DiseaseModelPropertyEditorAdapterFactory {

	/**
	 * 
	 */
	public MultiPopulationDiseaseModelPropertyEditorAdapterFactory() {
		super();
		DiseaseModelPropertyEditorAdapterFactory.INSTANCE
				.addAdapterFactory(this);
	}

	/**
	 * 
	 */
	@Override
	public Adapter createMultiPopulationSIDiseaseModelAdapter() {
		return new MultiPopulationDiseaseModelPropertyEditorAdapter();
	}

	/**
	 * 
	 * @see org.eclipse.stem.diseasemodels.example.util.ExampleAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	public boolean isFactoryForType(Object type) {
		return type == DiseaseModelPropertyEditorAdapter.class
				|| super.isFactoryForType(type);
	}
} // MultiPopulationDiseaseModelPropertyEditorAdapterFactory
