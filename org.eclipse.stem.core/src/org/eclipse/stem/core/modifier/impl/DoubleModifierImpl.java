package org.eclipse.stem.core.modifier.impl;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
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
import org.eclipse.stem.core.modifier.DoubleModifier;
import org.eclipse.stem.core.modifier.ModifierPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.DoubleModifierImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.DoubleModifierImpl#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoubleModifierImpl extends SingleValueModifierImpl implements DoubleModifier {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final double VALUE_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected double value = VALUE_EDEFAULT;
	/**
	 * The default value of the '{@link #getOriginalValue() <em>Original Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected static final double ORIGINAL_VALUE_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getOriginalValue() <em>Original Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected double originalValue = ORIGINAL_VALUE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.DOUBLE_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(double newValue) {
		double oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.DOUBLE_MODIFIER__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getOriginalValue() {
		return originalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(double newOriginalValue) {
		double oldOriginalValue = originalValue;
		originalValue = newOriginalValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.DOUBLE_MODIFIER__ORIGINAL_VALUE, oldOriginalValue, originalValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.DOUBLE_MODIFIER__VALUE:
				return getValue();
			case ModifierPackage.DOUBLE_MODIFIER__ORIGINAL_VALUE:
				return getOriginalValue();
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
			case ModifierPackage.DOUBLE_MODIFIER__VALUE:
				setValue((Double)newValue);
				return;
			case ModifierPackage.DOUBLE_MODIFIER__ORIGINAL_VALUE:
				setOriginalValue((Double)newValue);
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
			case ModifierPackage.DOUBLE_MODIFIER__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ModifierPackage.DOUBLE_MODIFIER__ORIGINAL_VALUE:
				setOriginalValue(ORIGINAL_VALUE_EDEFAULT);
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
			case ModifierPackage.DOUBLE_MODIFIER__VALUE:
				return value != VALUE_EDEFAULT;
			case ModifierPackage.DOUBLE_MODIFIER__ORIGINAL_VALUE:
				return originalValue != ORIGINAL_VALUE_EDEFAULT;
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
		result.append(" (value: "); //$NON-NLS-1$
		result.append(value);
		result.append(", originalValue: "); //$NON-NLS-1$
		result.append(originalValue);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#updateFeature()
	 */
	
	@SuppressWarnings("boxing")
	@Override
	public void updateFeature() {
		// Original value captured yet?
		if (!eIsSet(ModifierPackage.DOUBLE_MODIFIER__ORIGINAL_VALUE)) {
			// No
			setOriginalValue((Double)getTarget().eGet(getEStructuralFeature()));
		} // if
		getTarget().eSet(getEStructuralFeature(), getValue());
		complete = true;
	} // updateFeature

	
	/**
	 *reset
	 */
	@Override
	public void reset() {
		complete = false;
		getTarget().eSet(getEStructuralFeature(), getOriginalValue());
	}
	
	private boolean complete = false;
	/**
	 * isComplete
	 */
	@Override
	public boolean isComplete() {
		return complete;
	}

} //DoubleModifierImpl
