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
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SIR Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl#getCurrentSIRValue <em>Current SIR Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl#getNextSIRValue <em>Next SIR Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SIRLabelImpl extends SILabelImpl implements SIRLabel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SIRLabelImpl() {
		super();
		setCurrentValue(StandardFactory.eINSTANCE.createSIRLabelValue());
		setNextValue(StandardFactory.eINSTANCE.createSIRLabelValue());
		setDeltaValue(StandardFactory.eINSTANCE.createSIRLabelValue());
		setCurrentY(StandardFactory.eINSTANCE.createSIRLabelValue());
		setCurrentDiseaseModelTempLabelValue(StandardFactory.eINSTANCE.createSIRLabelValue());
		setYScale(StandardFactory.eINSTANCE.createSIRLabelValue());
	} // SIRLabelImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SIR_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SIRLabelValue getNextSIRValue() {
		return (SIRLabelValue) getNextValue();
	} // getNextSIRValue

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SIRLabelValue getCurrentSIRValue() {
		return (SIRLabelValue) getCurrentValue();
	} // getCurrentSIRValue

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getR()
	 */
	public double getR() {
		return getCurrentSIRValue().getR();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#setR(double)
	 */
	public void setR(double r) {
		getCurrentSIRValue().setR(r);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getNextR()
	 */
	public double getNextR() {
		return getNextSIRValue().getR();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#setNextR(double)
	 */
	public void setNextR(double r) {
		getNextSIRValue().setR(r);
	} // setNextR

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
			case StandardPackage.SIR_LABEL__CURRENT_SIR_VALUE:
				return getCurrentSIRValue();
			case StandardPackage.SIR_LABEL__NEXT_SIR_VALUE:
				return getNextSIRValue();
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
			case StandardPackage.SIR_LABEL__CURRENT_SIR_VALUE:
				return getCurrentSIRValue() != null;
			case StandardPackage.SIR_LABEL__NEXT_SIR_VALUE:
				return getNextSIRValue() != null;
		}
		return super.eIsSet(featureID);
	}

} // SIRLabelImpl
