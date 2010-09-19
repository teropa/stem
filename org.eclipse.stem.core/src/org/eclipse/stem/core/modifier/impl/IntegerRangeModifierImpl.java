package org.eclipse.stem.core.modifier.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.modifier.IntegerRangeModifier;
import org.eclipse.stem.core.modifier.ModifierPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Range Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.IntegerRangeModifierImpl#getStartValue <em>Start Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.IntegerRangeModifierImpl#getEndValue <em>End Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.IntegerRangeModifierImpl#getIncrement <em>Increment</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.IntegerRangeModifierImpl#getNextValue <em>Next Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.IntegerRangeModifierImpl#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("boxing")
public class IntegerRangeModifierImpl extends RangeModifierImpl implements IntegerRangeModifier {
	/**
	 * The default value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected static final int START_VALUE_EDEFAULT = -99999999;
	/**
	 * The default value of the '{@link #getEndValue() <em>End Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndValue()
	 * @generated
	 * @ordered
	 */
	protected static final int END_VALUE_EDEFAULT = -99999999;
	/**
	 * The default value of the '{@link #getIncrement() <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected static final int INCREMENT_EDEFAULT = -99999999;
	/**
	 * The default value of the '{@link #getNextValue() <em>Next Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextValue()
	 * @generated
	 * @ordered
	 */
	protected static final int NEXT_VALUE_EDEFAULT = -99999999;
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
	protected IntegerRangeModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.INTEGER_RANGE_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartValue() {
		return (Integer)eDynamicGet(ModifierPackage.INTEGER_RANGE_MODIFIER__START_VALUE, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__START_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartValue(int newStartValue) {
		eDynamicSet(ModifierPackage.INTEGER_RANGE_MODIFIER__START_VALUE, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__START_VALUE, newStartValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndValue() {
		return (Integer)eDynamicGet(ModifierPackage.INTEGER_RANGE_MODIFIER__END_VALUE, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__END_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndValue(int newEndValue) {
		eDynamicSet(ModifierPackage.INTEGER_RANGE_MODIFIER__END_VALUE, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__END_VALUE, newEndValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIncrement() {
		return (Integer)eDynamicGet(ModifierPackage.INTEGER_RANGE_MODIFIER__INCREMENT, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__INCREMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrement(int newIncrement) {
		eDynamicSet(ModifierPackage.INTEGER_RANGE_MODIFIER__INCREMENT, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__INCREMENT, newIncrement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNextValue() {
		// Unset?
		if (!eDynamicIsSet(ModifierPackage.INTEGER_RANGE_MODIFIER__NEXT_VALUE)) {
			// Yes
			setNextValue(getStartValue());
		} // if
		
		final int retValue = (Integer)eDynamicGet(ModifierPackage.INTEGER_RANGE_MODIFIER__NEXT_VALUE, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__NEXT_VALUE, false, true);
		complete = retValue == getEndValue();
		
		// Still incrementing?
		if (!complete) {
			// Yes
			final int temp = retValue + getIncrement();
			// Would the new currentValue be equal or "past" the endValue?
			if (Math.abs(temp) < Math.abs(getEndValue())) {
				// No
				setNextValue(temp);
			} // if
			else {
				// Yes
				setNextValue(getEndValue());
			} // else 
		} // if 
		eDynamicSet(ModifierPackage.INTEGER_MODIFIER__CURRENT_VALUE_TEXT, ModifierPackage.Literals.FEATURE_MODIFIER__CURRENT_VALUE_TEXT, Integer.toString(retValue));
		return retValue;
	} // getNextValue
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextValue(int newNextValue) {
		eDynamicSet(ModifierPackage.INTEGER_RANGE_MODIFIER__NEXT_VALUE, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__NEXT_VALUE, newNextValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOriginalValue() {
		return (Integer)eDynamicGet(ModifierPackage.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(int newOriginalValue) {
		eDynamicSet(ModifierPackage.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE, ModifierPackage.Literals.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#updateFeature()
	 */
	
	@Override
	public void updateFeature() {
		// Original value captured yet?
		if (!eIsSet(ModifierPackage.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE)) {
			// No
			setOriginalValue((Integer)getTarget().eGet(getEStructuralFeature()));
		} // if
		getTarget().eSet(getEStructuralFeature(),getNextValue());
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.RangeModifierImpl#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		eUnset(ModifierPackage.INTEGER_RANGE_MODIFIER__NEXT_VALUE);
		getTarget().eSet(getEStructuralFeature(), getOriginalValue());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.INTEGER_RANGE_MODIFIER__START_VALUE:
				return getStartValue();
			case ModifierPackage.INTEGER_RANGE_MODIFIER__END_VALUE:
				return getEndValue();
			case ModifierPackage.INTEGER_RANGE_MODIFIER__INCREMENT:
				return getIncrement();
			case ModifierPackage.INTEGER_RANGE_MODIFIER__NEXT_VALUE:
				return getNextValue();
			case ModifierPackage.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE:
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
			case ModifierPackage.INTEGER_RANGE_MODIFIER__START_VALUE:
				setStartValue((Integer)newValue);
				return;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__END_VALUE:
				setEndValue((Integer)newValue);
				return;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__INCREMENT:
				setIncrement((Integer)newValue);
				return;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__NEXT_VALUE:
				setNextValue((Integer)newValue);
				return;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE:
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
			case ModifierPackage.INTEGER_RANGE_MODIFIER__START_VALUE:
				setStartValue(START_VALUE_EDEFAULT);
				return;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__END_VALUE:
				setEndValue(END_VALUE_EDEFAULT);
				return;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__INCREMENT:
				setIncrement(INCREMENT_EDEFAULT);
				return;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__NEXT_VALUE:
				setNextValue(NEXT_VALUE_EDEFAULT);
				return;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE:
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
			case ModifierPackage.INTEGER_RANGE_MODIFIER__START_VALUE:
				return getStartValue() != START_VALUE_EDEFAULT;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__END_VALUE:
				return getEndValue() != END_VALUE_EDEFAULT;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__INCREMENT:
				return getIncrement() != INCREMENT_EDEFAULT;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__NEXT_VALUE:
				return getNextValue() != NEXT_VALUE_EDEFAULT;
			case ModifierPackage.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE:
				return getOriginalValue() != ORIGINAL_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see org.eclipse.stem.core.common.SanityChecker#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		assert retValue;
		
		retValue = retValue && (getEndValue() >= getStartValue());
		assert retValue;
		
		retValue = retValue && (getIncrement() > 0);
		assert retValue;
		
		return retValue;
	} // sane

} //IntegerRangeModifierImpl
