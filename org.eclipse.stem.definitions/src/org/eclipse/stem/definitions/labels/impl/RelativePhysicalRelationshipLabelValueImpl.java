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
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationship;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Relative Physical Relationship Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.RelativePhysicalRelationshipLabelValueImpl#isAdjacent <em>Adjacent</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.RelativePhysicalRelationshipLabelValueImpl#getRelationship <em>Relationship</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelativePhysicalRelationshipLabelValueImpl extends LabelValueImpl
		implements RelativePhysicalRelationshipLabelValue {
	/**
	 * The default value of the '{@link #isAdjacent() <em>Adjacent</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAdjacent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADJACENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAdjacent() <em>Adjacent</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAdjacent()
	 * @generated
	 * @ordered
	 */
	protected boolean adjacent = ADJACENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelationship() <em>Relationship</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelationship()
	 * @generated
	 * @ordered
	 */
	protected static final RelativePhysicalRelationship RELATIONSHIP_EDEFAULT = RelativePhysicalRelationship.UNSPECIFIED_LITERAL;

	/**
	 * The cached value of the '{@link #getRelationship() <em>Relationship</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelationship()
	 * @generated
	 * @ordered
	 */
	protected RelativePhysicalRelationship relationship = RELATIONSHIP_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RelativePhysicalRelationshipLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAdjacent() {
		return adjacent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdjacent(boolean newAdjacent) {
		boolean oldAdjacent = adjacent;
		adjacent = newAdjacent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__ADJACENT, oldAdjacent, adjacent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RelativePhysicalRelationship getRelationship() {
		return relationship;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelationship(RelativePhysicalRelationship newRelationship) {
		RelativePhysicalRelationship oldRelationship = relationship;
		relationship = newRelationship == null ? RELATIONSHIP_EDEFAULT : newRelationship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__RELATIONSHIP, oldRelationship, relationship));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__ADJACENT:
				return isAdjacent() ? Boolean.TRUE : Boolean.FALSE;
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__RELATIONSHIP:
				return getRelationship();
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
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__ADJACENT:
				setAdjacent(((Boolean)newValue).booleanValue());
				return;
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__RELATIONSHIP:
				setRelationship((RelativePhysicalRelationship)newValue);
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
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__ADJACENT:
				setAdjacent(ADJACENT_EDEFAULT);
				return;
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__RELATIONSHIP:
				setRelationship(RELATIONSHIP_EDEFAULT);
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
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__ADJACENT:
				return adjacent != ADJACENT_EDEFAULT;
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__RELATIONSHIP:
				return relationship != RELATIONSHIP_EDEFAULT;
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

		StringBuffer result = new StringBuffer("");
		result.append("adjacent: ");
		result.append(adjacent);
		result.append(", relationship: ");
		result.append(relationship);
		return result.toString();
	} // toString

	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelValueImpl#reset()
	 */
	@Override
	public void reset() {
		// Nothing to reset.
	}

	/**
	 * @see org.eclipse.stem.core.common.SanityChecker#sane()
	 */
	@Override
	public boolean sane() {
		return true;
	}

} // RelativePhysicalRelationshipLabelValueImpl
