package org.eclipse.stem.ui.populationmodels.standard.wizards;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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
import org.eclipse.stem.ui.populationmodels.adapters.PopulationInitializerPropertyEditorAdapter;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationInitializerPropertyEditorAdapterFactory;

public class StandardPopulationInitializerPropertyEditorAdapterFactory extends
		StandardAdapterFactory implements
		PopulationInitializerPropertyEditorAdapterFactory {

	public StandardPopulationInitializerPropertyEditorAdapterFactory() {
		super();
		PopulationInitializerPropertyEditorAdapterFactory.INSTANCE
				.addAdapterFactory(this);
	}

	@Override
	public Adapter createStandardPopulationInitializerAdapter() {
		return new StandardPopulationInitializerPropertyEditorAdapter();
	}

	@Override
	public Adapter createYetiPopulationInitializerAdapter() {
		return new StandardPopulationInitializerPropertyEditorAdapter();
	}
	
	@Override
	public boolean isFactoryForType(Object type) {
		return type == PopulationInitializerPropertyEditorAdapter.class
				|| super.isFactoryForType(type);
	}

} // StandardPopulationModelPropertyEditorAdapterFactory
