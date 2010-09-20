package org.eclipse.stem.ui.populationmodels.standard.wizards;

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
import org.eclipse.stem.populationmodels.standard.util.StandardAdapterFactory;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditorAdapter;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditorAdapterFactory;

public class StandardPopulationModelPropertyEditorAdapterFactory extends
		StandardAdapterFactory implements
		PopulationModelPropertyEditorAdapterFactory {

	public StandardPopulationModelPropertyEditorAdapterFactory() {
		super();
		PopulationModelPropertyEditorAdapterFactory.INSTANCE
				.addAdapterFactory(this);
	}

	@Override
	public Adapter createStandardPopulationModelAdapter() {
		return new StandardPopulationModelPropertyEditorAdapter();
	}


	@Override
	public Adapter createMosquitoPopulationModelAdapter() {
		return new MosquitoPopulationModelPropertyEditorAdapter();
	}
	
	@Override
	public boolean isFactoryForType(Object type) {
		return type == PopulationModelPropertyEditorAdapter.class
				|| super.isFactoryForType(type);
	}

} // StandardPopulationModelPropertyEditorAdapterFactory
