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
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SEIR Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl#getCurrentSEIRValue <em>Current SEIR Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl#getNextSEIRValue <em>Next SEIR Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SEIRLabelImpl extends SIRLabelImpl implements SEIRLabel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SEIRLabelImpl() {
		super();
		setTypeURI(URI_TYPE_SEIR_LABEL);
		setCurrentValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setNextValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setDeltaValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setCurrentY(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setCurrentDiseaseModelTempLabelValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setYScale(StandardFactory.eINSTANCE.createSEIRLabelValue());
	} // SEIRLabelImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SEIR_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SEIRLabelValue getCurrentSEIRValue() {
		return (SEIRLabelValue) getCurrentValue();
	} // getCurrentSEIRValue

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SEIRLabelValue getNextSEIRValue() {
		return (SEIRLabelValue) getNextValue();
	} // getNextSEIRValue

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#setE(double)
	 */
	public void setE(double e) {
		getCurrentSEIRValue().setE(e);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getE()
	 */
	public double getE() {
		return getCurrentSEIRValue().getE();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getNextE()
	 */
	public double getNextE() {
		return getNextSEIRValue().getE();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#setNextE(double)
	 */
	public void setNextE(double e) {
		getNextSEIRValue().setE(e);
	}

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
			case StandardPackage.SEIR_LABEL__CURRENT_SEIR_VALUE:
				return getCurrentSEIRValue();
			case StandardPackage.SEIR_LABEL__NEXT_SEIR_VALUE:
				return getNextSEIRValue();
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
			case StandardPackage.SEIR_LABEL__CURRENT_SEIR_VALUE:
				return getCurrentSEIRValue() != null;
			case StandardPackage.SEIR_LABEL__NEXT_SEIR_VALUE:
				return getNextSEIRValue() != null;
		}
		return super.eIsSet(featureID);
	}

} // SEIRLabelImpl
