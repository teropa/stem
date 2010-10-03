package org.eclipse.stem.definitions.edges.impl;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
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

import org.eclipse.stem.definitions.edges.EdgesPackage;
import org.eclipse.stem.definitions.edges.MixingEdgeLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixing Edge Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelValueImpl#getMixingRate <em>Mixing Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MixingEdgeLabelValueImpl extends LabelValueImpl implements MixingEdgeLabelValue {
	/**
	 * The default value of the '{@link #getMixingRate() <em>Mixing Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixingRate()
	 * @generated
	 * @ordered
	 */
	protected static final double MIXING_RATE_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MixingEdgeLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdgesPackage.Literals.MIXING_EDGE_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMixingRate() {
		return (Double)eDynamicGet(EdgesPackage.MIXING_EDGE_LABEL_VALUE__MIXING_RATE, EdgesPackage.Literals.MIXING_EDGE_LABEL_VALUE__MIXING_RATE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMixingRate(double newMixingRate) {
		eDynamicSet(EdgesPackage.MIXING_EDGE_LABEL_VALUE__MIXING_RATE, EdgesPackage.Literals.MIXING_EDGE_LABEL_VALUE__MIXING_RATE, newMixingRate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdgesPackage.MIXING_EDGE_LABEL_VALUE__MIXING_RATE:
				return getMixingRate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EdgesPackage.MIXING_EDGE_LABEL_VALUE__MIXING_RATE:
				setMixingRate((Double)newValue);
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
			case EdgesPackage.MIXING_EDGE_LABEL_VALUE__MIXING_RATE:
				setMixingRate(MIXING_RATE_EDEFAULT);
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
			case EdgesPackage.MIXING_EDGE_LABEL_VALUE__MIXING_RATE:
				return getMixingRate() != MIXING_RATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * for reset set the rate to the default rate.
	 */
	@Override
	public void reset() {
		setMixingRate(MIXING_RATE_EDEFAULT);	
	}
	

} //MixingEdgeLabelValueImpl
