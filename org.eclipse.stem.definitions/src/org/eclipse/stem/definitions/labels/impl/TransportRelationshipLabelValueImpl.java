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
import org.eclipse.stem.definitions.labels.TransportRelationshipLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Transport Relationship Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelValueImpl#getAvailableDepartureCapacityProportion <em>Available Departure Capacity Proportion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransportRelationshipLabelValueImpl extends LabelValueImpl
		implements TransportRelationshipLabelValue {
	/**
	 * The default value of the '{@link #getAvailableDepartureCapacityProportion() <em>Available Departure Capacity Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableDepartureCapacityProportion()
	 * @generated
	 * @ordered
	 */
	protected static final double AVAILABLE_DEPARTURE_CAPACITY_PROPORTION_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getAvailableDepartureCapacityProportion() <em>Available Departure Capacity Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableDepartureCapacityProportion()
	 * @generated
	 * @ordered
	 */
	protected double availableDepartureCapacityProportion = AVAILABLE_DEPARTURE_CAPACITY_PROPORTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TransportRelationshipLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAvailableDepartureCapacityProportion() {
		return availableDepartureCapacityProportion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailableDepartureCapacityProportion(double newAvailableDepartureCapacityProportion) {
		double oldAvailableDepartureCapacityProportion = availableDepartureCapacityProportion;
		availableDepartureCapacityProportion = newAvailableDepartureCapacityProportion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL_VALUE__AVAILABLE_DEPARTURE_CAPACITY_PROPORTION, oldAvailableDepartureCapacityProportion, availableDepartureCapacityProportion));
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelValueImpl#reset()
	 */
	@Override
	public void reset() {
		// Nothing to do
	}

	/**
	 * @see org.eclipse.stem.core.common.SanityChecker#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = true;

		retValue = retValue && availableDepartureCapacityProportion >= 0 && availableDepartureCapacityProportion<= AVAILABLE_DEPARTURE_CAPACITY_PROPORTION_EDEFAULT;
		assert retValue;

		return retValue;
	} // sane

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL_VALUE__AVAILABLE_DEPARTURE_CAPACITY_PROPORTION:
				return getAvailableDepartureCapacityProportion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL_VALUE__AVAILABLE_DEPARTURE_CAPACITY_PROPORTION:
				setAvailableDepartureCapacityProportion((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL_VALUE__AVAILABLE_DEPARTURE_CAPACITY_PROPORTION:
				setAvailableDepartureCapacityProportion(AVAILABLE_DEPARTURE_CAPACITY_PROPORTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL_VALUE__AVAILABLE_DEPARTURE_CAPACITY_PROPORTION:
				return availableDepartureCapacityProportion != AVAILABLE_DEPARTURE_CAPACITY_PROPORTION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(" (available proportion: ");
		result.append(availableDepartureCapacityProportion);
		result.append(')');
		return result.toString();
	} // toString

} // TransportRelationshipLabelValueImpl
