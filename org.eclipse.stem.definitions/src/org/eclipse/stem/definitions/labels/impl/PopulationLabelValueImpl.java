package org.eclipse.stem.definitions.labels.impl;

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
import org.eclipse.stem.core.graph.impl.LabelValueImpl;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Population Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.PopulationLabelValueImpl#getCount <em>Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PopulationLabelValueImpl extends LabelValueImpl implements
		PopulationLabelValue {
	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final double COUNT_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PopulationLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.POPULATION_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCount() {
		return (Double)eDynamicGet(LabelsPackage.POPULATION_LABEL_VALUE__COUNT, LabelsPackage.Literals.POPULATION_LABEL_VALUE__COUNT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(double newCount) {
		eDynamicSet(LabelsPackage.POPULATION_LABEL_VALUE__COUNT, LabelsPackage.Literals.POPULATION_LABEL_VALUE__COUNT, newCount);
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelValueImpl#reset()
	 */
	@Override
	public void reset() {
		// We don't reset
		// setCount(COUNT_EDEFAULT);
	} // reset

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
			case LabelsPackage.POPULATION_LABEL_VALUE__COUNT:
				return getCount();
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
			case LabelsPackage.POPULATION_LABEL_VALUE__COUNT:
				setCount((Double)newValue);
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
			case LabelsPackage.POPULATION_LABEL_VALUE__COUNT:
				setCount(COUNT_EDEFAULT);
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
			case LabelsPackage.POPULATION_LABEL_VALUE__COUNT:
				return getCount() != COUNT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @return <code>true</code> if the value is sane
	 * @see org.eclipse.stem.core.graph.impl.LabelImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = true;

		retValue = retValue
				&& (!eIsSet(LabelsPackage.POPULATION_LABEL_VALUE__COUNT) || getCount() >= 0);
		assert retValue;

		return retValue;
	} // sane
} // PopulationLabelValueImpl
