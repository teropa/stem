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
import org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Migration Edge Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelValueImpl#getMigrationRate <em>Migration Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MigrationEdgeLabelValueImpl extends LabelValueImpl implements MigrationEdgeLabelValue {
	/**
	 * The default value of the '{@link #getMigrationRate() <em>Migration Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMigrationRate()
	 * @generated
	 * @ordered
	 */
	protected static final double MIGRATION_RATE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMigrationRate() <em>Migration Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMigrationRate()
	 * @generated
	 * @ordered
	 */
	protected double migrationRate = MIGRATION_RATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MigrationEdgeLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdgesPackage.Literals.MIGRATION_EDGE_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMigrationRate() {
		return migrationRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMigrationRate(double newMigrationRate) {
		double oldMigrationRate = migrationRate;
		migrationRate = newMigrationRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdgesPackage.MIGRATION_EDGE_LABEL_VALUE__MIGRATION_RATE, oldMigrationRate, migrationRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdgesPackage.MIGRATION_EDGE_LABEL_VALUE__MIGRATION_RATE:
				return new Double(getMigrationRate());
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
			case EdgesPackage.MIGRATION_EDGE_LABEL_VALUE__MIGRATION_RATE:
				setMigrationRate(((Double)newValue).doubleValue());
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
			case EdgesPackage.MIGRATION_EDGE_LABEL_VALUE__MIGRATION_RATE:
				setMigrationRate(MIGRATION_RATE_EDEFAULT);
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
			case EdgesPackage.MIGRATION_EDGE_LABEL_VALUE__MIGRATION_RATE:
				return migrationRate != MIGRATION_RATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (migrationRate: "); //$NON-NLS-1$
		result.append(migrationRate);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * Resets the value for this migration edge to the default value. Is this
	 * really the correct behavior? do we really want to go to the model start
	 * state?
	 */
	@Override
	public void reset() {
		setMigrationRate(MIGRATION_RATE_EDEFAULT);
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelValueImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		
		retValue = retValue && !Double.isNaN( getMigrationRate());
		assert retValue : "Migration rate is NaN";
		
		retValue = retValue && !Double.isInfinite( getMigrationRate());
		assert retValue: "Migration rate is Infinite";
		
		return retValue;
	} // sane

	
} //MigrationEdgeLabelValueImpl
