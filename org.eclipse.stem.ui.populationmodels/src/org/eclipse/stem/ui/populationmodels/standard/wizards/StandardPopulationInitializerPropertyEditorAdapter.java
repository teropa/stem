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
import org.eclipse.stem.populationmodels.standard.PopulationInitializer;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationInitializerPropertyEditor;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationInitializerPropertyEditorAdapter;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditor;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditorAdapter;
import org.eclipse.swt.events.ModifyListener;

public class StandardPopulationInitializerPropertyEditorAdapter extends
		PopulationInitializerPropertyEditorAdapter {

	@Override
	public PopulationInitializerPropertyEditor createPopulationInitializerPropertyEditor(
			final PopulationInitializerPropertyComposite populationInitializerPropertyComposite,
			final int style, final ModifyListener projectValidator) {
		return new StandardPopulationInitializerPropertyEditor(
				populationInitializerPropertyComposite, style,
				(PopulationInitializer) getTarget(), projectValidator);
	} 

} 
