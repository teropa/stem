package org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor;

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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.SEIR;
import org.eclipse.stem.diseasemodels.standard.SI;
import org.eclipse.stem.diseasemodels.standard.SIR;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel;
import org.eclipse.stem.ui.editors.GenericPropertyEditor;
import org.eclipse.stem.ui.widgets.MatrixEditorWidget;
import org.eclipse.stem.ui.wizards.DiseaseWizardMessages;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

abstract public class DiseaseModelPropertyEditor extends GenericPropertyEditor {

	/**
	 * @param feature
	 * @return <code>true</code> if the feature is a dublin core feature that
	 *         is specified by a user.
	 */
	@Override
	public boolean isUserSpecifiedProperty(final EStructuralFeature feature) {
		boolean retValue = false;
		final EClass containingClass = feature.getEContainingClass();
		// Is it a disease model property?
		if (containingClass.equals(StandardPackage.eINSTANCE.getDiseaseModel())
				|| containingClass.getEAllSuperTypes().contains(
						StandardPackage.eINSTANCE.getDiseaseModel())) {
			// Deprecated, don't use!
			if(feature.getName().equals("finiteDifference")
					|| feature.getName().equals("relativeTolerance")) return false;
			// Yes
			retValue = true;
		} // if a disease model property
		return retValue;
	} // isUserSpecifiedDiseaseModelProperty


	public DiseaseModelPropertyEditor(Composite parent, int style, IProject project) {
		super(parent,style, project);
	}

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public DiseaseModelPropertyEditor(final Composite parent, final int style,
			final DiseaseModel diseaseModel,
			final ModifyListener projectValidator, IProject project) {
		super(parent, style, diseaseModel, projectValidator, project);
	}
	
	public void populate(DiseaseModel diseaseModel) {
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			switch (entry.getKey().getFeatureID()) {
			case StandardPackage.DISEASE_MODEL__DISEASE_NAME:
				diseaseModel.setDiseaseName(entry.getValue().getText());
				break;
			case StandardPackage.DISEASE_MODEL__POPULATION_IDENTIFIER:
				diseaseModel
						.setPopulationIdentifier(entry.getValue().getText());
				break;
			case StandardPackage.DISEASE_MODEL__TIME_PERIOD:
				diseaseModel.setTimePeriod(Long.parseLong(entry.getValue()
						.getText()));
				break;
			case StandardPackage.DISEASE_MODEL__BACKGROUND_MORTALITY_RATE:
				diseaseModel.setBackgroundMortalityRate(Double
						.parseDouble(entry.getValue().getText()));
				break;

			default:
				break;
			} // switch
		} // for each Map.entry
	}

	@Override
	public boolean validate() {
		boolean retValue = true;
		// Disease name?
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.DISEASE_MODEL__DISEASE_NAME);
			retValue = !text.getText().equals(""); //$NON-NLS-1$
			// nothing?
			if (!retValue) {
				// Yes
				errorMessage = DiseaseWizardMessages.getString("NDizWizErr0"); //$NON-NLS-1$
			} // if
		} // if

		// Population?
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.DISEASE_MODEL__POPULATION_IDENTIFIER);
			retValue = !text.getText().equals(""); //$NON-NLS-1$
			// nothing?
			if (!retValue) {
				// Yes
				errorMessage = DiseaseWizardMessages.getString("NDizWizErr1"); //$NON-NLS-1$
			} // if
		} // if

		// Time Period
		// Right now it is specified in milliseconds
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.DISEASE_MODEL__TIME_PERIOD);
			retValue = !text.getText().equals(""); //$NON-NLS-1$
			// nothing?
			if (!retValue) {
				// Yes
				errorMessage = DiseaseWizardMessages.getString("NDizWizErr2"); //$NON-NLS-1$
			} // if
			else {
				// No
				// Is it a valid value?
				retValue = isValidLongValue(text.getText(), 1);
				if (!retValue) {
					// No
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr3"); //$NON-NLS-1$
				} // if
			}
		} // if time period

		/**
		 * These fields has been moved to Population Model
		 */
		
		// Background mortality rate?
/*		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.DISEASE_MODEL__BACKGROUND_MORTALITY_RATE);
			retValue = !text.getText().equals(""); //$NON-NLS-1$
			// nothing?
			if (!retValue) {
				// Yes
				errorMessage = DiseaseWizardMessages.getString("NDizWizErr4"); //$NON-NLS-1$
			} // if
			else {
				// No
				// Is it a valid value > 0?
				retValue = isValidValue(text.getText(), 0.0);
				if (!retValue) {
					// No
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr5"); //$NON-NLS-1$
				} // if
			}
		} // if Background mortality rate
*/		
		
		/**
		 * MAD 7/15/2009
		 * Relative tolerance is no longer needed in the disease model editor
		 */
//		// Relative tolerance
//		if (retValue) {
//			// Yes
//			final Text text = map
//					.get(StandardPackage.Literals.DISEASE_MODEL__RELATIVE_TOLERANCE);
//			retValue = !text.getText().equals(""); //$NON-NLS-1$
//			// nothing?
//			if (!retValue) {
//				// Yes
//				errorMessage = DiseaseWizardMessages.getString("NDizWizErr22"); //$NON-NLS-1$
//			} // if
//			else {
//				// No
//				// Is it a valid value < 0.1 and > 0?
//				retValue = isValidRelativeTolerance(text.getText(), 0.1);
//				if (!retValue) {
//					// No
//					errorMessage = DiseaseWizardMessages
//							.getString("NDizWizErr23"); //$NON-NLS-1$
//				} // if
//			}
//		} // if Background mortality rate
		
		/**
		 * End remove relative tolerance from disease model editor
		 */
		return retValue;
	} // validate

	
	
	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents sub-classing of SWT components
	}


} // DiseaseModelPropertyEditor
