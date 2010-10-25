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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
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
	 * The cached value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected long startValue = START_VALUE_EDEFAULT;
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
	 * The cached value of the '{@link #getEndValue() <em>End Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndValue()
	 * @generated
	 * @ordered
	 */
	protected long endValue = END_VALUE_EDEFAULT;
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
	 * The cached value of the '{@link #getIncrement() <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected long increment = INCREMENT_EDEFAULT;
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
	 * The cached value of the '{@link #getNextValue() <em>Next Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextValue()
	 * @generated
	 * @ordered
	 */
	protected long nextValue = NEXT_VALUE_EDEFAULT;
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
	 * The cached value of the '{@link #getOriginalValue() <em>Original Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected long originalValue = ORIGINAL_VALUE_EDEFAULT;
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
		return startValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartValue(long newStartValue) {
		long oldStartValue = startValue;
		startValue = newStartValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.LONG_RANGE_MODIFIER__START_VALUE, oldStartValue, startValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEndValue() {
		return endValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndValue(long newEndValue) {
		long oldEndValue = endValue;
		endValue = newEndValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.LONG_RANGE_MODIFIER__END_VALUE, oldEndValue, endValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getIncrement() {
		return increment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrement(long newIncrement) {
		long oldIncrement = increment;
		increment = newIncrement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.LONG_RANGE_MODIFIER__INCREMENT, oldIncrement, increment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public long getNextValue() {
		// Unset?
		if (!eIsSet(ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE)) {
			// Yes
			setNextValue(getStartValue());
		} // if
		
		final long retValue = nextValue;
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
		eDynamicSet(ModifierPackage.FEATURE_MODIFIER__CURRENT_VALUE_TEXT, ModifierPackage.Literals.FEATURE_MODIFIER__CURRENT_VALUE_TEXT, Long.toString(retValue));
		return retValue;
	} // getNextValue
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextValue(long newNextValue) {
		long oldNextValue = nextValue;
		nextValue = newNextValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE, oldNextValue, nextValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getOriginalValue() {
		return originalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(long newOriginalValue) {
		long oldOriginalValue = originalValue;
		originalValue = newOriginalValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.LONG_RANGE_MODIFIER__ORIGINAL_VALUE, oldOriginalValue, originalValue));
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
				return startValue != START_VALUE_EDEFAULT;
			case ModifierPackage.LONG_RANGE_MODIFIER__END_VALUE:
				return endValue != END_VALUE_EDEFAULT;
			case ModifierPackage.LONG_RANGE_MODIFIER__INCREMENT:
				return increment != INCREMENT_EDEFAULT;
			case ModifierPackage.LONG_RANGE_MODIFIER__NEXT_VALUE:
				return nextValue != NEXT_VALUE_EDEFAULT;
			case ModifierPackage.LONG_RANGE_MODIFIER__ORIGINAL_VALUE:
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
		result.append(" (startValue: "); //$NON-NLS-1$
		result.append(startValue);
		result.append(", endValue: "); //$NON-NLS-1$
		result.append(endValue);
		result.append(", increment: "); //$NON-NLS-1$
		result.append(increment);
		result.append(", nextValue: "); //$NON-NLS-1$
		result.append(nextValue);
		result.append(", originalValue: "); //$NON-NLS-1$
		result.append(originalValue);
		result.append(')');
		return result.toString();
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
