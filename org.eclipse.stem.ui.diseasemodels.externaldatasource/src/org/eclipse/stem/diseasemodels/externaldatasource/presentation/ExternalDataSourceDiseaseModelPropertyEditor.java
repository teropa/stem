package org.eclipse.stem.diseasemodels.externaldatasource.presentation;
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

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel;
import org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourcePackage;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditor;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapter;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapterFactory;
import org.eclipse.stem.ui.wizards.DiseaseWizardMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 *
 */
public class ExternalDataSourceDiseaseModelPropertyEditor extends
		DiseaseModelPropertyEditor {
	
	/**
	 * @param parent
	 * @param style
	 * @param diseaseModel
	 * @param projectValidator
	 */
	public ExternalDataSourceDiseaseModelPropertyEditor(Composite parent,
			int style, DiseaseModel diseaseModel,
			ModifyListener projectValidator) {
		super(parent, style, diseaseModel, projectValidator);
	} // ExternalDataSourceDiseaseModelPropertyEditor

	/**
	 * @see org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor#populate(org.eclipse.stem.diseasemodels.standard.DiseaseModel)
	 */
	@Override
	public void populate(DiseaseModel diseaseModel) {
		super.populate(diseaseModel);
		
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			switch (entry.getKey().getFeatureID()) {
			case ExternalDataSourcePackage.EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DATA_PATH:
				((ExternalDataSourceDiseaseModel) diseaseModel)
						.setDataPath(entry
								.getValue().getText());
				break;
			case ExternalDataSourcePackage.EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DISEASE_TYPE:
				((ExternalDataSourceDiseaseModel) diseaseModel)
						.setDiseaseType(entry
								.getValue().getText());
				break;
			default:
				break;
			} // switch
		} // for each Map.entry
		
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor#validate()
	 */
	@Override
	public boolean validate() {
		boolean retValue = super.validate();
		// Disease Data Directory or File
		if (retValue) {
			// Yes
			final Text text = map
					.get(ExternalDataSourcePackage.Literals.EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DATA_PATH);
			File f = new File(text.getText());
			retValue = f.exists();
			// exists?
			if (!retValue) {
				// Yes
				errorMessage = DiseaseWizardMessages.getString("NDizWizErr20"); //$NON-NLS-1$
			} // if
		} // if
		
		return retValue;
	}
	
} // ExternalDataSourceDiseaseModelPropertyEditor
