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
import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditor;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapter;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapterFactory;
import org.eclipse.stem.ui.widgets.MatrixEditorWidget.MatrixEditorValidator;
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
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((MultiPopulationSIDiseaseModel) diseaseModel).setPhysicallyAdjacentInfectiousProportion(dVal);
				break;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				dVal = (new Double(entry.getValue().getText())).doubleValue();
				((MultiPopulationSIDiseaseModel) diseaseModel).setRoadNetworkInfectiousProportion(dVal);
				break;

			default:
				break;
			} // switch
		} // for each Map.entry
		
		for(final Map.Entry<EStructuralFeature, String[]>entry:matrixMap.entrySet()) {
			switch(entry.getKey().getFeatureID()) {
				case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE:
					double [] dvals = getDoubleArray(entry.getValue());
					DoubleValueList newList = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValueList();
					((MultiPopulationSIDiseaseModel) diseaseModel).setInfectiousMortalityRate(newList);
					for(double d:dvals) {
						DoubleValue dval = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValue();
						dval.setValue(d);
						((MultiPopulationSIDiseaseModel) diseaseModel).getInfectiousMortalityRate().getValues().add(dval);
					}
					break;
				case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE:
					dvals = getDoubleArray(entry.getValue());
					newList = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValueList();
					((MultiPopulationSIDiseaseModel) diseaseModel).setRecoveryRate(newList);
					for(double d:dvals) {
						DoubleValue dval = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValue();
						dval.setValue(d);
						((MultiPopulationSIDiseaseModel) diseaseModel).getRecoveryRate().getValues().add(dval);
					}
					break;
				case MultipopulationPackage.MULTI_POPULATION_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE:
					dvals = getDoubleArray(entry.getValue());
					newList = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValueList();
					((MultiPopulationSIRDiseaseModel) diseaseModel).setImmunityLossRate(newList);
					for(double d:dvals) {
						DoubleValue dval = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValue();
						dval.setValue(d);
						((MultiPopulationSIRDiseaseModel) diseaseModel).getImmunityLossRate().getValues().add(dval);
					}
					break;
				case MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE:
					dvals = getDoubleArray(entry.getValue());
					newList = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValueList();
					((MultiPopulationSEIRDiseaseModel) diseaseModel).setIncubationRate(newList);
					for(double d:dvals) {
						DoubleValue dval = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValue();
						dval.setValue(d);
						((MultiPopulationSEIRDiseaseModel) diseaseModel).getIncubationRate().getValues().add(dval);
					}
					break;
				case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE:
				    dvals = getDoubleArray(entry.getValue());
					DoubleValueMatrix newMatrix = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValueMatrix();
					((MultiPopulationSIDiseaseModel) diseaseModel).setTransmissionRate(newMatrix);
					// ugh
					int groups = (int)Math.sqrt((double)dvals.length);
				    for(int r=0;r<groups;++r) {	    	
				    	DoubleValueList nl = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValueList();
				    	((MultiPopulationSIDiseaseModel) diseaseModel).getTransmissionRate().getValueLists().add(nl);	
				    	for(int c=0;c<groups;++c) {
				    		DoubleValue dval = CommonPackage.eINSTANCE.getCommonFactory().createDoubleValue();
				    		dval.setValue(dvals[r*groups+c]);
				    		nl.getValues().add(dval);
				    	}
					}
					break;
				case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS:
					String [] svals = entry.getValue();
					StringValueList newSList = CommonPackage.eINSTANCE.getCommonFactory().createStringValueList();
					((MultiPopulationSIDiseaseModel) diseaseModel).setPopulationGroups(newSList);
					for(String s:svals) {
						org.eclipse.stem.core.common.StringValue sval = CommonPackage.eINSTANCE.getCommonFactory().createStringValue();
						sval.setValue(s);
						((MultiPopulationSIDiseaseModel) diseaseModel).getPopulationGroups().getValues().add(sval);
					}
					break;
			}
		}
	}

	private double [] getDoubleArray(String []svals) {
		double [] res = new double[svals.length];
		for(int i=0;i<res.length;++i) res[i] = Double.parseDouble(svals[i]);
		return res;
	}
	
	/**
	 * @see org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor#validate()
	 */
	@Override
	public boolean validate() {
		boolean retValue = super.validate();
		// Infectious Mortality Rate
		if (retValue) {
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
	
	/**
	 * getValidator. Validators
	 * subclass for more advanced validation (>0 etc.)
	 * @param feature
	 * @return
	 */
	@Override
	public MatrixEditorValidator getValidator(EStructuralFeature feature) {
		EClassifier type = feature.getEType();
		MatrixEditorValidator validator=null;
		if(feature.getFeatureID() == MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE ||
				feature.getFeatureID() == MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE ||
				feature.getFeatureID() == MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE) 
			validator = new MatrixEditorValidator() {
				
				public boolean validateValue(String val) {
					if(val == null || val.trim().equals("")) return false;
					try {
						Double.parseDouble(val.trim());
					} catch(NumberFormatException nfe) {
						return false;
					}
					
					return isValidValue(val, 0.0);
				}
		};			
		if(validator == null) validator = super.getValidator(feature);
		return validator;
	}
	
} // MultiPopulationDiseaseModelPropertyEditor
