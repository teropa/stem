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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.STEMTimeRangeModifier;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>STEM Time Range Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.STEMTimeRangeModifierImpl#getStartValue <em>Start Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.STEMTimeRangeModifierImpl#getEndValue <em>End Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.STEMTimeRangeModifierImpl#getIncrement <em>Increment</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.STEMTimeRangeModifierImpl#getNextValue <em>Next Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.STEMTimeRangeModifierImpl#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STEMTimeRangeModifierImpl extends RangeModifierImpl implements
		STEMTimeRangeModifier {
	/**
	 * The cached value of the '{@link #getStartValue() <em>Start Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected STEMTime startValue;
	/**
	 * The cached value of the '{@link #getEndValue() <em>End Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndValue()
	 * @generated
	 * @ordered
	 */
	protected STEMTime endValue;
	/**
	 * The default value of the '{@link #getIncrement() <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected static final long INCREMENT_EDEFAULT = 0L;
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
	 * The cached value of the '{@link #getNextValue() <em>Next Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextValue()
	 * @generated
	 * @ordered
	 */
	protected STEMTime nextValue;
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected STEMTimeRangeModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.STEM_TIME_RANGE_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getStartValue() {
		if (startValue != null && startValue.eIsProxy()) {
			InternalEObject oldStartValue = (InternalEObject)startValue;
			startValue = (STEMTime)eResolveProxy(oldStartValue);
			if (startValue != oldStartValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModifierPackage.STEM_TIME_RANGE_MODIFIER__START_VALUE, oldStartValue, startValue));
			}
		}
		return startValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetStartValue() {
		return startValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartValue(STEMTime newStartValue) {
		STEMTime oldStartValue = startValue;
		startValue = newStartValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.STEM_TIME_RANGE_MODIFIER__START_VALUE, oldStartValue, startValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getEndValue() {
		if (endValue != null && endValue.eIsProxy()) {
			InternalEObject oldEndValue = (InternalEObject)endValue;
			endValue = (STEMTime)eResolveProxy(oldEndValue);
			if (endValue != oldEndValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModifierPackage.STEM_TIME_RANGE_MODIFIER__END_VALUE, oldEndValue, endValue));
			}
		}
		return endValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetEndValue() {
		return endValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndValue(STEMTime newEndValue) {
		STEMTime oldEndValue = endValue;
		endValue = newEndValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.STEM_TIME_RANGE_MODIFIER__END_VALUE, oldEndValue, endValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getIncrement() {
		return increment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrement(long newIncrement) {
		long oldIncrement = increment;
		increment = newIncrement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.STEM_TIME_RANGE_MODIFIER__INCREMENT, oldIncrement, increment));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__START_VALUE:
				if (resolve) return getStartValue();
				return basicGetStartValue();
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__END_VALUE:
				if (resolve) return getEndValue();
				return basicGetEndValue();
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__INCREMENT:
				return getIncrement();
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__NEXT_VALUE:
				if (resolve) return getNextValue();
				return basicGetNextValue();
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__ORIGINAL_VALUE:
				if (resolve) return getOriginalValue();
				return basicGetOriginalValue();
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
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__START_VALUE:
				setStartValue((STEMTime)newValue);
				return;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__END_VALUE:
				setEndValue((STEMTime)newValue);
				return;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__INCREMENT:
				setIncrement((Long)newValue);
				return;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__NEXT_VALUE:
				setNextValue((STEMTime)newValue);
				return;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__ORIGINAL_VALUE:
				setOriginalValue((STEMTime)newValue);
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
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__START_VALUE:
				setStartValue((STEMTime)null);
				return;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__END_VALUE:
				setEndValue((STEMTime)null);
				return;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__INCREMENT:
				setIncrement(INCREMENT_EDEFAULT);
				return;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__NEXT_VALUE:
				setNextValue((STEMTime)null);
				return;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__ORIGINAL_VALUE:
				setOriginalValue((STEMTime)null);
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
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__START_VALUE:
				return startValue != null;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__END_VALUE:
				return endValue != null;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__INCREMENT:
				return increment != INCREMENT_EDEFAULT;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__NEXT_VALUE:
				return nextValue != null;
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__ORIGINAL_VALUE:
				return originalValue != null;
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
		result.append(" (increment: "); //$NON-NLS-1$
		result.append(increment);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public STEMTime getNextValue() {
		// Unset?
		if (!eIsSet(ModifierPackage.STEM_TIME_RANGE_MODIFIER__NEXT_VALUE)) {
			// Yes
			nextValue = getStartValue();
		} // if

		final STEMTime retValue = nextValue;
		complete = retValue.equals(getEndValue());

		// Still incrementing?
		if (!complete) {
			// Yes
			final STEMTime temp = ((STEMTime) EcoreUtil.copy(retValue))
					.addIncrement(getIncrement());
			// Would the new currentValue be equal or "past" the endValue?
			if (temp.getTime().before(getEndValue().getTime())) {
				// No
				setNextValue(temp);
			} // if
			else {
				// Yes
				setNextValue(getEndValue());
			} // else
		} // if
		eDynamicSet(ModifierPackage.FEATURE_MODIFIER__CURRENT_VALUE_TEXT, ModifierPackage.Literals.FEATURE_MODIFIER__CURRENT_VALUE_TEXT, retValue.toString());
		return retValue;

	} // getNextValue

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetNextValue() {
		return nextValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextValue(STEMTime newNextValue) {
		STEMTime oldNextValue = nextValue;
		nextValue = newNextValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.STEM_TIME_RANGE_MODIFIER__NEXT_VALUE, oldNextValue, nextValue));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModifierPackage.STEM_TIME_RANGE_MODIFIER__ORIGINAL_VALUE, oldOriginalValue, originalValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.STEM_TIME_RANGE_MODIFIER__ORIGINAL_VALUE, oldOriginalValue, originalValue));
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#updateFeature()
	 */
	@Override
	public void updateFeature() {
		// Original value captured yet?
		if (!eIsSet(ModifierPackage.INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE)) {
			// No
			setOriginalValue((STEMTime)getTarget().eGet(getEStructuralFeature()));
		} // if
		getTarget().eSet(getEStructuralFeature(), getNextValue());
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.RangeModifierImpl#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		eUnset(ModifierPackage.STEM_TIME_RANGE_MODIFIER__NEXT_VALUE);
		getTarget().eSet(getEStructuralFeature(), getOriginalValue());
	}
	
	/**
	 * @see org.eclipse.stem.core.common.SanityChecker#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		assert retValue;

		retValue = retValue
				&& !((getEndValue()).getTime().before((getStartValue()).getTime()));
		assert retValue;

		retValue = retValue && getIncrement() > 0;
		assert retValue;

		return retValue;
	} // sane

} // STEMTimeRangeModifierImpl
