package org.eclipse.stem.diseasemodels.vector.presentation;
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

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.DoubleValue;
import org.eclipse.stem.core.common.DoubleValueList;
import org.eclipse.stem.core.common.DoubleValueMatrix;
import org.eclipse.stem.core.common.StringValueList;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel;
import org.eclipse.stem.diseasemodels.vector.VectorPackage;
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
public class VectorDiseaseModelPropertyEditor extends
		StandardDiseaseModelPropertyEditor {
	
	/**
	 * @param parent
	 * @param style
	 * @param diseaseModel
	 * @param projectValidator
	 */
	public VectorDiseaseModelPropertyEditor(Composite parent,
			int style, DiseaseModel diseaseModel,
			ModifyListener projectValidator, IProject project) {
		super(parent, style, diseaseModel, projectValidator, project);
	} // MultiDiseaseModelPropertyEditor

	/**
	 * @see org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor#populate(org.eclipse.stem.diseasemodels.standard.DiseaseModel)
	 */
	@Override
	public void populate(DiseaseModel diseaseModel) {
		super.populate(diseaseModel);
		
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			double dVal = 0.0;
			String sVal;
			switch (entry.getKey().getFeatureID()) {
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__BITING_RATE:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((MacdonaldRossDiseaseModel) diseaseModel).setBitingRate(dVal);
				break;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_HUMAN:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((MacdonaldRossDiseaseModel) diseaseModel).setInfectiousBitingProportionHuman(dVal);
				break;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_VECTOR:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((MacdonaldRossDiseaseModel) diseaseModel).setInfectiousBitingProportionVector(dVal);
				break;	
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__RECOVERY_RATE:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((MacdonaldRossDiseaseModel) diseaseModel).setRecoveryRate(dVal);
				break;	
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__VECTOR_MORTALITY_RATE:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((MacdonaldRossDiseaseModel) diseaseModel).setVectorMortalityRate(dVal);
				break;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER:
				sVal = entry.getValue().getText().trim();
				((MacdonaldRossDiseaseModel) diseaseModel).setVectorPopulationIdentifier(sVal);
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
		// Infectious Mortality Rate
/*		if (retValue) {
			// Yes
			final Text text = map
					.get(MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("RECOVERY_RATE_INVALID"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = MultipopulationDiseaseWizardMessages
								.getString("RECOVERY_RATE_INVALID"); //$NON-NLS-1$
					} // if
				}
			} // if
		}
		if (retValue) {
				// Yes
				Text text = map
						.get(MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION);
				if (text != null) {
					// Yes
					retValue = !text.getText().equals(""); //$NON-NLS-1$
					// nothing?
					if (!retValue) {
						// Yes
						errorMessage = DiseaseWizardMessages
								.getString("PHYS_ADJ_INVALID"); //$NON-NLS-1$
					} // if
					else {
						// No
						// Is it a valid value?
						retValue = isValidValue(text.getText(), 0.0);
						if (!retValue) {
							// No
							errorMessage = MultipopulationDiseaseWizardMessages
									.getString("PHYS_ADJ_INVALID"); //$NON-NLS-1$
						} // if
					}
				} // if
		}		
		if (retValue) {
					// Yes
					Text text = map
							.get(MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION);
					if (text != null) {
						// Yes
						retValue = !text.getText().equals(""); //$NON-NLS-1$
						// nothing?
						if (!retValue) {
							// Yes
							errorMessage = DiseaseWizardMessages
									.getString("ROAD_NET_INVALID"); //$NON-NLS-1$
						} // if
						else {
							// No
							// Is it a valid value?
							retValue = isValidValue(text.getText(), 0.0);
							if (!retValue) {
								// No
								errorMessage = MultipopulationDiseaseWizardMessages
										.getString("ROAD_NET_INVALID"); //$NON-NLS-1$
							} // if
						}
					} // if
		}
	*/	
		return retValue;
	}
	
	
	
	
} // VectorDiseaseModelPropertyEditor
