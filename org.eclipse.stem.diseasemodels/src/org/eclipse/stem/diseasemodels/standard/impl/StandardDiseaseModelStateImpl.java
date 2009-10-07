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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Disease Model State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelStateImpl#getAreaRatio <em>Area Ratio</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StandardDiseaseModelStateImpl extends
		DiseaseModelStateImpl implements StandardDiseaseModelState {
	/**
	 * The default value of the '{@link #getAreaRatio() <em>Area Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreaRatio()
	 * @generated
	 * @ordered
	 */
	protected static final double AREA_RATIO_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAreaRatio() <em>Area Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreaRatio()
	 * @generated
	 * @ordered
	 */
	protected double areaRatio = AREA_RATIO_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardDiseaseModelStateImpl() {
		super();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelStateImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		return retValue;
	} // sane

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_DISEASE_MODEL_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAreaRatio() {
		return areaRatio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAreaRatio(double newAreaRatio) {
		double oldAreaRatio = areaRatio;
		areaRatio = newAreaRatio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_DISEASE_MODEL_STATE__AREA_RATIO, oldAreaRatio, areaRatio));
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
			case StandardPackage.STANDARD_DISEASE_MODEL_STATE__AREA_RATIO:
				return getAreaRatio();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param newValue
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StandardPackage.STANDARD_DISEASE_MODEL_STATE__AREA_RATIO:
				setAreaRatio((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StandardPackage.STANDARD_DISEASE_MODEL_STATE__AREA_RATIO:
				setAreaRatio(AREA_RATIO_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
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
			case StandardPackage.STANDARD_DISEASE_MODEL_STATE__AREA_RATIO:
				return areaRatio != AREA_RATIO_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (areaRatio: "); //$NON-NLS-1$
		result.append(areaRatio);
		result.append(')');
		return result.toString();
	}

} // StandardDiseaseModelStateImpl
