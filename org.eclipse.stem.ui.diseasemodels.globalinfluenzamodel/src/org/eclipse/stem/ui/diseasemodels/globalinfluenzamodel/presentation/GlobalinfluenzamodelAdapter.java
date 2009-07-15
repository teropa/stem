package org.eclipse.stem.ui.diseasemodels.globalinfluenzamodel.presentation;
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

import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditor;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditorAdapter;
import org.eclipse.stem.ui.wizards.DiseaseModelPropertyComposite;
import org.eclipse.swt.events.ModifyListener;

/**
 *  
 * Adapter for Property Editor
 *
 */
public class GlobalinfluenzamodelAdapter extends
		DiseaseModelPropertyEditorAdapter {

	/**
	 * 
	 */
	@Override
	public DiseaseModelPropertyEditor createDiseaseModelPropertyEditor(
			DiseaseModelPropertyComposite diseaseModelPropertyComposite,
			int style, ModifyListener projectValidator) {
		return new GlobalinfluenzamodelPropertyEditor(
				diseaseModelPropertyComposite, style,
				(DiseaseModel) getTarget(), projectValidator);
	} // createDiseaseModelPropertyEditor

} // ForcingDiseaseModelAdapter
