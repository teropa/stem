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

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.STEMTimeModifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STEM Time Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.STEMTimeModifierImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.STEMTimeModifierImpl#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STEMTimeModifierImpl extends SingleValueModifierImpl implements STEMTimeModifier {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected STEMTime value;

	/**
	 * The cached value of the '{@link #getOriginalValue() <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected STEMTime originalValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STEMTimeModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.STEM_TIME_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (STEMTime)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModifierPackage.STEM_TIME_MODIFIER__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(STEMTime newValue) {
		STEMTime oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.STEM_TIME_MODIFIER__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getOriginalValue() {
		if (originalValue != null && originalValue.eIsProxy()) {
			InternalEObject oldOriginalValue = (InternalEObject)originalValue;
			originalValue = (STEMTime)eResolveProxy(oldOriginalValue);
			if (originalValue != oldOriginalValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE, oldOriginalValue, originalValue));
			}
		}
		return originalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetOriginalValue() {
		return originalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(STEMTime newOriginalValue) {
		STEMTime oldOriginalValue = originalValue;
		originalValue = newOriginalValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE, oldOriginalValue, originalValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.STEM_TIME_MODIFIER__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
			case ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE:
				if (resolve) return getOriginalValue();
				return basicGetOriginalValue();
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
			case ModifierPackage.STEM_TIME_MODIFIER__VALUE:
				setValue((STEMTime)newValue);
				return;
			case ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE:
				setOriginalValue((STEMTime)newValue);
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
			case ModifierPackage.STEM_TIME_MODIFIER__VALUE:
				setValue((STEMTime)null);
				return;
			case ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE:
				setOriginalValue((STEMTime)null);
				return;
		}
		super.eUnset(featureID);
	}

	@SuppressWarnings("boxing")
	@Override
	public void updateFeature() {
		// Original value captured yet?
		if (!eIsSet(ModifierPackage.DOUBLE_MODIFIER__ORIGINAL_VALUE)) {
			// No
			setOriginalValue((STEMTime)target.eGet(getEStructuralFeature()));
		} // if
		target.eSet(getEStructuralFeature(), getValue());
		complete = true;
	} // updateFeature

	
	/**
	 *reset
	 */
	@Override
	public void reset() {
		complete = false;
		target.eSet(getEStructuralFeature(), getOriginalValue());
	}
	
	private boolean complete = false;
	/**
	 * isComplete
	 */
	@Override
	public boolean isComplete() {
		return complete;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModifierPackage.STEM_TIME_MODIFIER__VALUE:
				return value != null;
			case ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE:
				return originalValue != null;
		}
		return super.eIsSet(featureID);
	}

} //STEMTimeModifierImpl
