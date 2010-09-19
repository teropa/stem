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
import org.eclipse.stem.core.modifier.LongRangeModifier;
import org.eclipse.stem.core.modifier.ModifierPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Long Range Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.LongRangeModifierImpl#getStartValue <em>Start Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.LongRangeModifierImpl#getEndValue <em>End Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.LongRangeModifierImpl#getIncrement <em>Increment</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.LongRangeModifierImpl#getNextValue <em>Next Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.LongRangeModifierImpl#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("boxing")
public class LongRangeModifierImpl extends RangeModifierImpl implements LongRangeModifier {
	/**
	 * The default value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected static final long START_VALUE_EDEFAULT = -99999999L;
	/**
	 * The default value of the '{@link #getEndValue() <em>End Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndValue()
	 * @generated
	 * @ordered
	 */
	protected static final long END_VALUE_EDEFAULT = -99999999L;
	/**
	 * The default value of the '{@link #getIncrement() <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected static final long INCREMENT_EDEFAULT = -99999999L;
	/**
	 * The default value of the '{@link #getNextValue() <em>Next Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextValue()
	 * @generated
	 * @ordered
	 */
	protected static final long NEXT_VALUE_EDEFAULT = -99999999L;
	/**
	 * The default value of the '{@link #getOriginalValue() <em>Original Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected static final long ORIGINAL_VALUE_EDEFAULT = -99999999L;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LongRangeModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.LONG_RANGE_MODIFIER;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartValue() {
		return (Long)eDynamicGet(ModifierPackage.LONG_RANGE_MODIFIER__START_VALUE, ModifierPackage.Literals.LONG_RANGE_MODIFIER__START_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartValue(long newStartValue) {
		eDynamicSet(ModifierPackage.LONG_RANGE_MODIFIER__START_VALUE, ModifierPackage.Literals.LONG_RANGE_MODIFIER__START_VALUE, newStartValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEndValue() {
		return (Long)eDynamicGet(ModifierPackage.LONG_RANGE_MODIFIER__END_VALUE, ModifierPackage.Literals.LONG_RANGE_MODIFIER__END_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndValue(long newEndValue) {
		eDynamicSet(ModifierPackage.LONG_RANGE_MODIFIER__END_VALUE, ModifierPackage.Literals.LONG_RANGE_MODIFIER__END_VALUE, newEndValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getIncrement() {
		return (Long)eDynamicGet(ModifierPackage.LONG_RANGE_MODIFIER__INCREMENT, ModifierPackage.Literals.LONG_RANGE_MODIFIER__INCREMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrement(long newIncrement) {
		eDynamicSet(ModifierPackage.LONG_RANGE_MODIFIER__INCREMENT, ModifierPackage.Literals.LONG_RANGE_MODIFIER__INCREMENT, newIncrement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public long getNextValue() {
		// Unset?
		if (!eDynamicIsSet(ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE)) {
			// Yes
			setNextValue(getStartValue());
		} // if
		
		final long retValue = (Long)eDynamicGet(ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE, ModifierPackage.Literals.LONG_RANGE_MODIFIER__NEXT_VALUE, false, true);
		complete = retValue == getEndValue();
		
		// Still incrementing?
		if (!complete) {
			// Yes
			final long temp = retValue + getIncrement();
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
		eDynamicSet(ModifierPackage.LONG_RANGE_MODIFIER__CURRENT_VALUE_TEXT, ModifierPackage.Literals.FEATURE_MODIFIER__CURRENT_VALUE_TEXT, Long.toString(retValue));
		return retValue;
	} // getNextValue
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextValue(long newNextValue) {
		eDynamicSet(ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE, ModifierPackage.Literals.LONG_RANGE_MODIFIER__NEXT_VALUE, newNextValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getOriginalValue() {
		return (Long)eDynamicGet(ModifierPackage.LONG_RANGE_MODIFIER__ORIGINAL_VALUE, ModifierPackage.Literals.LONG_RANGE_MODIFIER__ORIGINAL_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(long newOriginalValue) {
		eDynamicSet(ModifierPackage.LONG_RANGE_MODIFIER__ORIGINAL_VALUE, ModifierPackage.Literals.LONG_RANGE_MODIFIER__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#updateFeature()
	 */

	@Override
	public void updateFeature() {
		// Original value captured yet?
		if (!eIsSet(ModifierPackage.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE)) {
			// No
			setOriginalValue((Long)getTarget().eGet(getEStructuralFeature()));
		} // if
		getTarget().eSet(getEStructuralFeature(),getNextValue());
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.RangeModifierImpl#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		eUnset(ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE);
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
			case ModifierPackage.LONG_RANGE_MODIFIER__START_VALUE:
				return getStartValue();
			case ModifierPackage.LONG_RANGE_MODIFIER__END_VALUE:
				return getEndValue();
			case ModifierPackage.LONG_RANGE_MODIFIER__INCREMENT:
				return getIncrement();
			case ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE:
				return getNextValue();
			case ModifierPackage.LONG_RANGE_MODIFIER__ORIGINAL_VALUE:
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
			case ModifierPackage.LONG_RANGE_MODIFIER__START_VALUE:
				setStartValue((Long)newValue);
				return;
			case ModifierPackage.LONG_RANGE_MODIFIER__END_VALUE:
				setEndValue((Long)newValue);
				return;
			case ModifierPackage.LONG_RANGE_MODIFIER__INCREMENT:
				setIncrement((Long)newValue);
				return;
			case ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE:
				setNextValue((Long)newValue);
				return;
			case ModifierPackage.LONG_RANGE_MODIFIER__ORIGINAL_VALUE:
				setOriginalValue((Long)newValue);
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
			case ModifierPackage.LONG_RANGE_MODIFIER__START_VALUE:
				setStartValue(START_VALUE_EDEFAULT);
				return;
			case ModifierPackage.LONG_RANGE_MODIFIER__END_VALUE:
				setEndValue(END_VALUE_EDEFAULT);
				return;
			case ModifierPackage.LONG_RANGE_MODIFIER__INCREMENT:
				setIncrement(INCREMENT_EDEFAULT);
				return;
			case ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE:
				setNextValue(NEXT_VALUE_EDEFAULT);
				return;
			case ModifierPackage.LONG_RANGE_MODIFIER__ORIGINAL_VALUE:
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
			case ModifierPackage.LONG_RANGE_MODIFIER__START_VALUE:
				return getStartValue() != START_VALUE_EDEFAULT;
			case ModifierPackage.LONG_RANGE_MODIFIER__END_VALUE:
				return getEndValue() != END_VALUE_EDEFAULT;
			case ModifierPackage.LONG_RANGE_MODIFIER__INCREMENT:
				return getIncrement() != INCREMENT_EDEFAULT;
			case ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE:
				return getNextValue() != NEXT_VALUE_EDEFAULT;
			case ModifierPackage.LONG_RANGE_MODIFIER__ORIGINAL_VALUE:
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
		
		retValue = retValue && (getIncrement() > 0L);
		assert retValue;
		
		return retValue;
	} // sane

} //LongRangeModifierImpl
