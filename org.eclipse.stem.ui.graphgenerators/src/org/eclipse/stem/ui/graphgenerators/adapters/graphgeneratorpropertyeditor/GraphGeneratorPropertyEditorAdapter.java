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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.stem.graphgenerators.GraphGenerator;
import org.eclipse.stem.ui.graphgenerators.wizards.GraphGeneratorPropertyComposite;
import org.eclipse.swt.events.ModifyListener;

public class GraphGeneratorPropertyEditorAdapter extends AdapterImpl
		implements Adapter {

	public GraphGeneratorPropertyEditor createGraphGeneratorPropertyEditor(
			final GraphGeneratorPropertyComposite graphGeneratorPropertyComposite,
			final int style, final ModifyListener projectValidator) {
		return new GraphGeneratorPropertyEditor(
				graphGeneratorPropertyComposite, style,
				(GraphGenerator) getTarget(), projectValidator);
	} // createGraphGeneratorPropertyEditor
	
} // GraphGeneratorPropertyEditorAdapter
