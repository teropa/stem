// StandardDiseaseModelPropertyEditor.java
package org.eclipse.stem.ui.wizards;

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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.SEIR;
import org.eclipse.stem.diseasemodels.standard.SI;
import org.eclipse.stem.diseasemodels.standard.SIR;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditor;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapter;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapterFactory;
import org.eclipse.stem.ui.widgets.MatrixEditorDialog;
import org.eclipse.stem.ui.widgets.MatrixEditorWidget;
import org.eclipse.stem.ui.widgets.MatrixEditorWidget.MatrixEditorValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * This class is a {@link Composite} that presents the properties of a
 * {@link DiseaseModel} for editing.
 */
public class StandardDiseaseModelPropertyEditor extends DiseaseModelPropertyEditor {

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public StandardDiseaseModelPropertyEditor(final Composite parent, final int style,
			final DiseaseModel diseaseModel,
			final ModifyListener projectValidator, IProject project) {
		super(parent, style, diseaseModel, projectValidator, project);

	} // StandardDiseaseModelPropertyEditor

	

	/**
	 * @param diseaseModel
	 *            the {@link DiseaseModel} instance to populate.
	 */
	public void populate(final DiseaseModel diseaseModel) {
		super.populate(diseaseModel);
		
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			switch (entry.getKey().getFeatureID()) {
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
				((StandardDiseaseModel) diseaseModel)
						.setReferencePopulationDensity(Double.parseDouble(entry
								.getValue().getText()));
				break;
			}
		}
		if(diseaseModel instanceof SI)
			for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			switch (entry.getKey().getFeatureID()) {	
			case StandardPackage.STOCHASTIC_DISEASE_MODEL__SEED:
				((StochasticDiseaseModel) diseaseModel).setSeed(Long
						.parseLong(entry.getValue().getText()));
				break;
			case StandardPackage.STANDARD_STOCHASTIC_DISEASE_MODEL__GAIN:
				((StandardStochasticDiseaseModel) diseaseModel).setGain(Double
						.parseDouble(entry.getValue().getText()));
				break;
			case StandardPackage.SI__TRANSMISSION_RATE:
				((SI) diseaseModel).setTransmissionRate(Double
						.parseDouble(entry.getValue().getText()));
				break;
			case StandardPackage.SI__NON_LINEARITY_COEFFICIENT:
				((SI) diseaseModel).setNonLinearityCoefficient(Double
						.parseDouble(entry.getValue().getText()));
				break;
			case StandardPackage.SI__RECOVERY_RATE:
				((SI) diseaseModel).setRecoveryRate(Double.parseDouble(entry
						.getValue().getText()));
				break;
			case StandardPackage.SI__INFECTIOUS_MORTALITY_RATE:
				((SI) diseaseModel).setInfectiousMortalityRate(Double
						.parseDouble(entry.getValue().getText()));
				break;
//	 Deprecated
//			case StandardPackage.SI__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION:
//				((SI) diseaseModel)
//						.setPhysicallyAdjacentInfectiousProportion(Double
//								.parseDouble(entry.getValue().getText()));
//				break;
			case StandardPackage.SI__CHARACTERISTIC_MIXING_DISTANCE:
				((SI) diseaseModel)
						.setCharacteristicMixingDistance(Double
								.parseDouble(entry.getValue().getText()));
				break;
			case StandardPackage.SI__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				((SI) diseaseModel)
						.setRoadNetworkInfectiousProportion(Double
								.parseDouble(entry.getValue().getText()));
				break;
			case StandardPackage.SIR__IMMUNITY_LOSS_RATE:
				((SIR) diseaseModel).setImmunityLossRate(Double
						.parseDouble(entry.getValue().getText()));
				break;
			case StandardPackage.SEIR__INCUBATION_RATE:
				((SEIR) diseaseModel).setIncubationRate(Double
						.parseDouble(entry.getValue().getText()));
				break;

			default:
				break;
			} // switch
		} // for each Map.entry
	} // populate

	/**
	 * @return <code>true</code> if the contents are valid, <code>false</code>
	 *         otherwise.
	 */
	@Override
	public boolean validate() {
		boolean retValue = super.validate();

		// Transmission Rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SI__TRANSMISSION_RATE);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr6"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr7"); //$NON-NLS-1$
					} // if
				}
			} // if text != null
		} // if Transmission Rate

		// Non-Linearity Coefficient
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SI__NON_LINEARITY_COEFFICIENT);
			if (text != null) {
				// Yes

				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr8"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr9"); //$NON-NLS-1$
					} // if
				}
			} // if text != null
		} // if Non-Linearity Coefficient

		// Infectious Recovery Rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SI__RECOVERY_RATE);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr10"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr11"); //$NON-NLS-1$
					} // if
				}
			} // if
		} // if Infectious Recovery Rate

		// Infectious Mortality Rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SI__INFECTIOUS_MORTALITY_RATE);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr12"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr13"); //$NON-NLS-1$
					} // if
				}
			} // if
		} // if Infectious Mortality Rate

		// Immunity Loss Rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SIR__IMMUNITY_LOSS_RATE);
			// specified?
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr16"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr17"); //$NON-NLS-1$
					} // if
				}
			} // if
		} // if Immunity Loss Rate

		// Incubation Rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SEIR__INCUBATION_RATE);
			if (text != null) {
				// Yes

				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr18"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr19"); //$NON-NLS-1$
					} // if
				}
			} // if
		} // if Incubation Rate

		return retValue;
	} // validate

} // StandardDiseaseModelPropertyEditor
