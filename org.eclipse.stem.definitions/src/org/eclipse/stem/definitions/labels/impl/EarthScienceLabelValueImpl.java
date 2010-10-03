/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.definitions.labels.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.stem.core.graph.impl.LabelValueImpl;

import org.eclipse.stem.definitions.labels.EarthScienceLabelValue;
import org.eclipse.stem.definitions.labels.LabelsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Earth Science Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.EarthScienceLabelValueImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.EarthScienceLabelValueImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.EarthScienceLabelValueImpl#getUnits <em>Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EarthScienceLabelValueImpl extends LabelValueImpl implements EarthScienceLabelValue {
	/**
	 * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_TYPE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getUnits() <em>Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected static final String UNITS_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EarthScienceLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.EARTH_SCIENCE_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Double> getData() {
		return (EList<Double>)eDynamicGet(LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA, LabelsPackage.Literals.EARTH_SCIENCE_LABEL_VALUE__DATA, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataType() {
		return (String)eDynamicGet(LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA_TYPE, LabelsPackage.Literals.EARTH_SCIENCE_LABEL_VALUE__DATA_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(String newDataType) {
		eDynamicSet(LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA_TYPE, LabelsPackage.Literals.EARTH_SCIENCE_LABEL_VALUE__DATA_TYPE, newDataType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnits() {
		return (String)eDynamicGet(LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__UNITS, LabelsPackage.Literals.EARTH_SCIENCE_LABEL_VALUE__UNITS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnits(String newUnits) {
		eDynamicSet(LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__UNITS, LabelsPackage.Literals.EARTH_SCIENCE_LABEL_VALUE__UNITS, newUnits);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA:
				return getData();
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA_TYPE:
				return getDataType();
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__UNITS:
				return getUnits();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA:
				getData().clear();
				getData().addAll((Collection<? extends Double>)newValue);
				return;
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA_TYPE:
				setDataType((String)newValue);
				return;
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__UNITS:
				setUnits((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA:
				getData().clear();
				return;
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA_TYPE:
				setDataType(DATA_TYPE_EDEFAULT);
				return;
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__UNITS:
				setUnits(UNITS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA:
				return !getData().isEmpty();
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__DATA_TYPE:
				return DATA_TYPE_EDEFAULT == null ? getDataType() != null : !DATA_TYPE_EDEFAULT.equals(getDataType());
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE__UNITS:
				return UNITS_EDEFAULT == null ? getUnits() != null : !UNITS_EDEFAULT.equals(getUnits());
		}
		return super.eIsSet(featureID);
	}

} //EarthScienceLabelValueImpl
