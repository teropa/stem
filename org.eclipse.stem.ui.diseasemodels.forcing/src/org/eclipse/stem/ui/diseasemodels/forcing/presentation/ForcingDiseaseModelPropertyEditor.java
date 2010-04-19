package org.eclipse.stem.ui.diseasemodels.forcing.presentation;
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
import org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel;
import org.eclipse.stem.diseasemodels.forcing.ForcingPackage;
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
public class ForcingDiseaseModelPropertyEditor extends
		DiseaseModelPropertyEditor {
	
	/**
	 * @param parent
	 * @param style
	 * @param diseaseModel
	 * @param projectValidator
	 */
	public ForcingDiseaseModelPropertyEditor(Composite parent,
			int style, DiseaseModel diseaseModel,
			ModifyListener projectValidator) {
		super(parent, style, diseaseModel, projectValidator);
	} // ForcingDiseaseModelPropertyEditor

	/**
	 * @see org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor#populate(org.eclipse.stem.diseasemodels.standard.DiseaseModel)
	 */
	@Override
	public void populate(DiseaseModel diseaseModel) {
		super.populate(diseaseModel);
		
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			double dVal = 0.0;
			int iVal = 0;
			switch (entry.getKey().getFeatureID()) {
			case ForcingPackage.FORCING_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((ForcingDiseaseModel) diseaseModel).setSeasonalModulationFloor(dVal);
				break;
			case ForcingPackage.FORCING_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT:
				iVal = (new Integer(entry.getValue().getText())).intValue();
				((ForcingDiseaseModel) diseaseModel).setSeasonalModulationExponent(iVal);
				break;	
			case ForcingPackage.FORCING_DISEASE_MODEL__MODULATION_PERIOD:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((ForcingDiseaseModel) diseaseModel)
						.setModulationPeriod(dVal);
				break;
			case ForcingPackage.FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((ForcingDiseaseModel) diseaseModel)
						.setModulationPhaseShift(dVal);
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
					.get(ForcingPackage.Literals.FORCING_DISEASE_MODEL__MODULATION_PERIOD);
			String sVal = text.getText();
			try {
				// TODO check if all three params are a valid number
				new Double(sVal);
			} catch(Exception e) {
				retValue = false;
				errorMessage = DiseaseWizardMessages.getString("NDizWizErr20"); //$NON-NLS-1$
			} // if
		} // if
		
		return retValue;
	}
	
} // ForcingDiseaseModelPropertyEditor
