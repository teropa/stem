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
		return (STEMTime)eDynamicGet(ModifierPackage.STEM_TIME_MODIFIER__VALUE, ModifierPackage.Literals.STEM_TIME_MODIFIER__VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetValue() {
		return (STEMTime)eDynamicGet(ModifierPackage.STEM_TIME_MODIFIER__VALUE, ModifierPackage.Literals.STEM_TIME_MODIFIER__VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(STEMTime newValue) {
		eDynamicSet(ModifierPackage.STEM_TIME_MODIFIER__VALUE, ModifierPackage.Literals.STEM_TIME_MODIFIER__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getOriginalValue() {
		return (STEMTime)eDynamicGet(ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE, ModifierPackage.Literals.STEM_TIME_MODIFIER__ORIGINAL_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetOriginalValue() {
		return (STEMTime)eDynamicGet(ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE, ModifierPackage.Literals.STEM_TIME_MODIFIER__ORIGINAL_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(STEMTime newOriginalValue) {
		eDynamicSet(ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE, ModifierPackage.Literals.STEM_TIME_MODIFIER__ORIGINAL_VALUE, newOriginalValue);
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
			setOriginalValue((STEMTime)getTarget().eGet(getEStructuralFeature()));
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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModifierPackage.STEM_TIME_MODIFIER__VALUE:
				return basicGetValue() != null;
			case ModifierPackage.STEM_TIME_MODIFIER__ORIGINAL_VALUE:
				return basicGetOriginalValue() != null;
		}
		return super.eIsSet(featureID);
	}

} //STEMTimeModifierImpl
