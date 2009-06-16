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
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SI Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl#getCurrentSIValue <em>Current SI Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl#getNextSIValue <em>Next SI Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SILabelImpl extends StandardDiseaseModelLabelImpl implements
		SILabel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SILabelImpl() {
		setCurrentValue(StandardFactory.eINSTANCE.createSILabelValue());
		setNextValue(StandardFactory.eINSTANCE.createSILabelValue());
		setDeltaValue(StandardFactory.eINSTANCE.createSILabelValue());
		setCurrentY(StandardFactory.eINSTANCE.createSILabelValue());
		setCurrentDiseaseModelTempLabelValue(StandardFactory.eINSTANCE.createSILabelValue());
		setYScale(StandardFactory.eINSTANCE.createSILabelValue());
	} // SILabelImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SI_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SILabelValue getCurrentSIValue() {
		return (SILabelValue) getCurrentValue();
	} // getCurrentSIValue

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public SILabelValue getNextSIValue() {
		return (SILabelValue) getNextValue();
	} // getNextSIValue

	/**
	 * @return set the number number of infectious population members
	 */
	public void setNextI(double i) {
		((SILabelValue)getNextValue()).setI(i);
	}

	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getI()
	 */
	public double getI() {
		return getCurrentSIValue().getI();
	} // getI

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#setI()
	 */
	public void setI(double i) {
		getCurrentSIValue().setI(i);
	} // getI

	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getNextI()
	 */
	public double getNextI() {
		return getNextSIValue().getI();
	} // getNextI

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param resolve
	 * @param coreType
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.SI_LABEL__CURRENT_SI_VALUE:
				return getCurrentSIValue();
			case StandardPackage.SI_LABEL__NEXT_SI_VALUE:
				return getNextSIValue();
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
			case StandardPackage.SI_LABEL__CURRENT_SI_VALUE:
				return getCurrentSIValue() != null;
			case StandardPackage.SI_LABEL__NEXT_SI_VALUE:
				return getNextSIValue() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getIncidence()
	 */
	public double getIncidence() {
		return this.getCurrentSIValue().getIncidence();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#setIncidence(double)
	 */
	public void setIncidence(double incidence) {
		this.getCurrentSIValue().setIncidence(incidence);
	}

} // SILabelImpl
