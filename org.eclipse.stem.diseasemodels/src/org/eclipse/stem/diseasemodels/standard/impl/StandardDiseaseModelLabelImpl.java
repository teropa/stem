package org.eclipse.stem.diseasemodels.standard.impl;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Disease Model Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelImpl#getCurrentStandardDiseaseModelLabelValue <em>Current Standard Disease Model Label Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelImpl#getNextStandardDiseaseModelLabelValue <em>Next Standard Disease Model Label Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelImpl#getDeltaStandardDiseaseModelLabelValue <em>Delta Standard Disease Model Label Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelImpl#getCurrentYStandardDiseaseModelLabelValue <em>Current YStandard Disease Model Label Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StandardDiseaseModelLabelImpl extends
		DiseaseModelLabelImpl implements StandardDiseaseModelLabel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardDiseaseModelLabelImpl() {
		super();
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.DynamicLabelImpl#reset()
	 */
	@Override
	public void reset() {
		// The call to super.reset will reset the label value of this label
		// which will zero out all of the disease state values.
		super.reset();
		// Is there a population instance associated with this instance?
		if (getPopulationLabel() != null) {
			// Yes
			// Ok, set the susceptible population to the count of the number of
			// population members
			final StandardDiseaseModelLabelValue sValue = getCurrentStandardDiseaseModelLabelValue();

			sValue.setS(getPopulationLabel().getCurrentPopulationValue()
					.getCount());
		} // if

	} // reset

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_DISEASE_MODEL_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StandardDiseaseModelLabelValue getCurrentStandardDiseaseModelLabelValue() {
		return (StandardDiseaseModelLabelValue) getCurrentValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StandardDiseaseModelLabelValue getCurrentYStandardDiseaseModelLabelValue() {
		return (StandardDiseaseModelLabelValue) getCurrentY();
	} // getEstimatedStandardDiseaseModelLabelValue

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StandardDiseaseModelLabelValue getDeltaStandardDiseaseModelLabelValue() {
		return (StandardDiseaseModelLabelValue) getDeltaValue();
	} // getDeltaStandardDiseaseModelLabelValue
	
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StandardDiseaseModelLabelValue getNextStandardDiseaseModelLabelValue() {
		return (StandardDiseaseModelLabelValue) getNextValue();
	} // getNextStandardDiseaseModelLabelValue
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getS()
	 */
	public double getS() {
		return getCurrentStandardDiseaseModelLabelValue().getS();
	} // getS

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#setS(double)
	 */
	public void setS(double s) {
		getCurrentStandardDiseaseModelLabelValue().setS(s);
	} // setS

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getNextS()
	 */
	public double getNextS() {
		return getNextStandardDiseaseModelLabelValue().getS();
	} // getNextS

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#setNextS(double)
	 */
	public void setNextS(double s) {
		getNextStandardDiseaseModelLabelValue().setS(s);
	} // setNextS

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param resolve
	 * @param coreType
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL__CURRENT_STANDARD_DISEASE_MODEL_LABEL_VALUE:
				return getCurrentStandardDiseaseModelLabelValue();
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL__NEXT_STANDARD_DISEASE_MODEL_LABEL_VALUE:
				return getNextStandardDiseaseModelLabelValue();
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL__DELTA_STANDARD_DISEASE_MODEL_LABEL_VALUE:
				return getDeltaStandardDiseaseModelLabelValue();
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL__CURRENT_YSTANDARD_DISEASE_MODEL_LABEL_VALUE:
				return getCurrentYStandardDiseaseModelLabelValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL__CURRENT_STANDARD_DISEASE_MODEL_LABEL_VALUE:
				return getCurrentStandardDiseaseModelLabelValue() != null;
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL__NEXT_STANDARD_DISEASE_MODEL_LABEL_VALUE:
				return getNextStandardDiseaseModelLabelValue() != null;
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL__DELTA_STANDARD_DISEASE_MODEL_LABEL_VALUE:
				return getDeltaStandardDiseaseModelLabelValue() != null;
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL__CURRENT_YSTANDARD_DISEASE_MODEL_LABEL_VALUE:
				return getCurrentYStandardDiseaseModelLabelValue() != null;
		}
		return super.eIsSet(featureID);
	}

} // StandardDiseaseModelLabelImpl
