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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.modifier.IntegerModifier;
import org.eclipse.stem.core.modifier.ModifierPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.IntegerModifierImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.IntegerModifierImpl#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntegerModifierImpl extends SingleValueModifierImpl implements IntegerModifier {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 0;
	/**
	 * The default value of the '{@link #getOriginalValue() <em>Original Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected static final int ORIGINAL_VALUE_EDEFAULT = 0;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.INTEGER_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return (Integer)eDynamicGet(ModifierPackage.INTEGER_MODIFIER__VALUE, ModifierPackage.Literals.INTEGER_MODIFIER__VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(int newValue) {
		eDynamicSet(ModifierPackage.INTEGER_MODIFIER__VALUE, ModifierPackage.Literals.INTEGER_MODIFIER__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOriginalValue() {
		return (Integer)eDynamicGet(ModifierPackage.INTEGER_MODIFIER__ORIGINAL_VALUE, ModifierPackage.Literals.INTEGER_MODIFIER__ORIGINAL_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(int newOriginalValue) {
		eDynamicSet(ModifierPackage.INTEGER_MODIFIER__ORIGINAL_VALUE, ModifierPackage.Literals.INTEGER_MODIFIER__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.INTEGER_MODIFIER__VALUE:
				return getValue();
			case ModifierPackage.INTEGER_MODIFIER__ORIGINAL_VALUE:
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
			case ModifierPackage.INTEGER_MODIFIER__VALUE:
				setValue((Integer)newValue);
				return;
			case ModifierPackage.INTEGER_MODIFIER__ORIGINAL_VALUE:
				setOriginalValue((Integer)newValue);
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
			case ModifierPackage.INTEGER_MODIFIER__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ModifierPackage.INTEGER_MODIFIER__ORIGINAL_VALUE:
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
			case ModifierPackage.INTEGER_MODIFIER__VALUE:
				return getValue() != VALUE_EDEFAULT;
			case ModifierPackage.INTEGER_MODIFIER__ORIGINAL_VALUE:
				return getOriginalValue() != ORIGINAL_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
			setOriginalValue((Integer)getTarget().eGet(getEStructuralFeature()));
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

} //IntegerModifierImpl
