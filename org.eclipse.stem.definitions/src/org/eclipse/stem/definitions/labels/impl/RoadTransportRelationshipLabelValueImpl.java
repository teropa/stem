
package org.eclipse.stem.definitions.labels.impl;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
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
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.definitions.labels.RoadTransportRelationshipLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Road Transport Relationship Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.RoadTransportRelationshipLabelValueImpl#getRoadName <em>Road Name</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.RoadTransportRelationshipLabelValueImpl#getRoadClass <em>Road Class</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.RoadTransportRelationshipLabelValueImpl#getNumberCrossings <em>Number Crossings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoadTransportRelationshipLabelValueImpl extends PhysicalRelationshipLabelValueImpl implements RoadTransportRelationshipLabelValue {
	/**
	 * The default value of the '{@link #getRoadName() <em>Road Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadName()
	 * @generated
	 * @ordered
	 */
	protected static final String ROAD_NAME_EDEFAULT = "road";

	/**
	 * The default value of the '{@link #getRoadClass() <em>Road Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadClass()
	 * @generated
	 * @ordered
	 */
	protected static final String ROAD_CLASS_EDEFAULT = "route";

	/**
	 * The default value of the '{@link #getNumberCrossings() <em>Number Crossings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberCrossings()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_CROSSINGS_EDEFAULT = 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoadTransportRelationshipLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoadName() {
		return (String)eDynamicGet(LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_NAME, LabelsPackage.Literals.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoadName(String newRoadName) {
		eDynamicSet(LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_NAME, LabelsPackage.Literals.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_NAME, newRoadName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoadClass() {
		return (String)eDynamicGet(LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_CLASS, LabelsPackage.Literals.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_CLASS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoadClass(String newRoadClass) {
		eDynamicSet(LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_CLASS, LabelsPackage.Literals.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_CLASS, newRoadClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberCrossings() {
		return (Integer)eDynamicGet(LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__NUMBER_CROSSINGS, LabelsPackage.Literals.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__NUMBER_CROSSINGS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberCrossings(int newNumberCrossings) {
		eDynamicSet(LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__NUMBER_CROSSINGS, LabelsPackage.Literals.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__NUMBER_CROSSINGS, newNumberCrossings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_NAME:
				return getRoadName();
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_CLASS:
				return getRoadClass();
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__NUMBER_CROSSINGS:
				return getNumberCrossings();
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
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_NAME:
				setRoadName((String)newValue);
				return;
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_CLASS:
				setRoadClass((String)newValue);
				return;
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__NUMBER_CROSSINGS:
				setNumberCrossings((Integer)newValue);
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
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_NAME:
				setRoadName(ROAD_NAME_EDEFAULT);
				return;
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_CLASS:
				setRoadClass(ROAD_CLASS_EDEFAULT);
				return;
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__NUMBER_CROSSINGS:
				setNumberCrossings(NUMBER_CROSSINGS_EDEFAULT);
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
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_NAME:
				return ROAD_NAME_EDEFAULT == null ? getRoadName() != null : !ROAD_NAME_EDEFAULT.equals(getRoadName());
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__ROAD_CLASS:
				return ROAD_CLASS_EDEFAULT == null ? getRoadClass() != null : !ROAD_CLASS_EDEFAULT.equals(getRoadClass());
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE__NUMBER_CROSSINGS:
				return getNumberCrossings() != NUMBER_CROSSINGS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //RoadTransportRelationshipLabelValueImpl
