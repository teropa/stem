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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditor;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapter;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapterFactory;
import org.eclipse.stem.ui.wizards.DiseaseWizardMessages;
import org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor;
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
public class MultiPopulationDiseaseModelPropertyEditor extends
		StandardDiseaseModelPropertyEditor {
	
	/**
	 * @param parent
	 * @param style
	 * @param diseaseModel
	 * @param projectValidator
	 */
	public MultiPopulationDiseaseModelPropertyEditor(Composite parent,
			int style, DiseaseModel diseaseModel,
			ModifyListener projectValidator) {
		super(parent, style, diseaseModel, projectValidator);
	} // MultiDiseaseModelPropertyEditor

	/**
	 * @see org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor#populate(org.eclipse.stem.diseasemodels.standard.DiseaseModel)
	 */
	@Override
	public void populate(DiseaseModel diseaseModel) {
		super.populate(diseaseModel);
		
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			double dVal = 0.0;
		
			switch (entry.getKey().getFeatureID()) {
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((MultiPopulationSIDiseaseModel) diseaseModel).getPopulationGroups().getValues().clear();
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
					.get(MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS);
			String sVal = text.getText();
			try {
				// TODO check if all three params are a valid number
				new Double(sVal);
			} catch(Exception e) {
				retValue = false;
				errorMessage = MultipopulationDiseaseWizardMessages.getString("NDizWizErr1"); //$NON-NLS-1$
			} // if
		} // if
		
		return retValue;
	}
	
	/**
	 * These are overriden by subclass
	 */
	@Override
	public short getColCount(EStructuralFeature feature) {
		String [] groups = matrixMap.get(MultipopulationPackage.eINSTANCE.getMultiPopulationSIDiseaseModel_PopulationGroups());
		if(groups == null)return 0;
		else return (short)groups.length;
	}

	@Override
	public boolean getFixedSize(EStructuralFeature feature) {
		if(feature.getFeatureID() == MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS)
			return false;
		return true;
	}

	@Override
	public String[] getRowNames(EStructuralFeature feature) {
		String [] groups = matrixMap.get(MultipopulationPackage.eINSTANCE.getMultiPopulationSIDiseaseModel_PopulationGroups());
		return groups;
	}

	@Override
	public String[] getColNames(EStructuralFeature feature) {
		String [] groups = matrixMap.get(MultipopulationPackage.eINSTANCE.getMultiPopulationSIDiseaseModel_PopulationGroups());
		return groups;
	}
	
	@Override
	public short getRowCount(EStructuralFeature feature) {
		String [] groups = matrixMap.get(MultipopulationPackage.eINSTANCE.getMultiPopulationSIDiseaseModel_PopulationGroups());
		if(groups == null)return 0;
		else return (short)groups.length;
	}
} // ExampleDiseaseModelPropertyEditor
