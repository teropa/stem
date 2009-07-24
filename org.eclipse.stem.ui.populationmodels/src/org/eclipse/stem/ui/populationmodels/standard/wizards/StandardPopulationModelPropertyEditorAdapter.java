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
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditor;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditorAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;

public class StandardPopulationModelPropertyEditorAdapter extends
		PopulationModelPropertyEditorAdapter {

	@Override
	public PopulationModelPropertyEditor createPopulationModelPropertyEditor(
			final PopulationModelPropertyComposite populationModelPropertyComposite,
			final int style, final ModifyListener projectValidator) {
		return new StandardPopulationModelPropertyEditor(
				populationModelPropertyComposite, style,
				(PopulationModel) getTarget(), projectValidator);
	} // createPopulationModelPropertyEditor

} // StandardPopulationModelPropertyEditorAdapter
