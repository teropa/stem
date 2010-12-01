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
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabelValue;
import org.eclipse.stem.definitions.labels.LabelsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Common Border Relationship Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.CommonBorderRelationshipLabelValueImpl#getBorderLength <em>Border Length</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommonBorderRelationshipLabelValueImpl extends
		PhysicalRelationshipLabelValueImpl implements
		CommonBorderRelationshipLabelValue {
	/**
	 * The default value of the '{@link #getBorderLength() <em>Border Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBorderLength()
	 * @generated
	 * @ordered
	 */
	protected static final double BORDER_LENGTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBorderLength() <em>Border Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBorderLength()
	 * @generated
	 * @ordered
	 */
	protected double borderLength = BORDER_LENGTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CommonBorderRelationshipLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getBorderLength() {
		return borderLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderLength(double newBorderLength) {
		double oldBorderLength = borderLength;
		borderLength = newBorderLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE__BORDER_LENGTH, oldBorderLength, borderLength));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE__BORDER_LENGTH:
				return getBorderLength();
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
			case LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE__BORDER_LENGTH:
				setBorderLength((Double)newValue);
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
			case LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE__BORDER_LENGTH:
				setBorderLength(BORDER_LENGTH_EDEFAULT);
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
			case LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE__BORDER_LENGTH:
				return borderLength != BORDER_LENGTH_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (borderLength: "); //$NON-NLS-1$
		result.append(borderLength);
		result.append(')');
		return result.toString();
	}

} // CommonBorderRelationshipLabelValueImpl
