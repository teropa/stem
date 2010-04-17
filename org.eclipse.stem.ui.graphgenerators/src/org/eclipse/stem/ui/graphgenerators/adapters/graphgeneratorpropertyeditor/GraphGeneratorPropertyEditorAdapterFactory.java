package org.eclipse.stem.ui.graphgenerators.adapters.graphgeneratorpropertyeditor;

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
import org.eclipse.stem.graphgenerators.util.GraphgeneratorsAdapterFactory;

public class GraphGeneratorPropertyEditorAdapterFactory extends
		GraphgeneratorsAdapterFactory implements
		IGraphGeneratorPropertyEditorAdapterFactory {

	public GraphGeneratorPropertyEditorAdapterFactory() {
		super();
		GraphGeneratorPropertyEditorAdapterFactory.INSTANCE
				.addAdapterFactory(this);
	}

	@Override
	public Adapter createGraphGeneratorAdapter() {
		return new GraphGeneratorPropertyEditorAdapter();
	}

	public boolean isFactoryForType(Object type) {
		return type == GraphGeneratorPropertyEditorAdapter.class
				|| super.isFactoryForType(type);
	}

} // StandardGraphGeneratorPropertyEditorAdapterFactory
