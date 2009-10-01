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
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.SequenceModifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.SequenceModifierImpl#getSequenceSize <em>Sequence Size</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.SequenceModifierImpl#getCurrentSequenceIndex <em>Current Sequence Index</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.SequenceModifierImpl#getNextValue <em>Next Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.SequenceModifierImpl#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SequenceModifierImpl extends FeatureModifierImpl implements SequenceModifier {
	/**
	 * The default value of the '{@link #getSequenceSize() <em>Sequence Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SEQUENCE_SIZE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getCurrentSequenceIndex() <em>Current Sequence Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentSequenceIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_SEQUENCE_INDEX_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getCurrentSequenceIndex() <em>Current Sequence Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentSequenceIndex()
	 * @generated
	 * @ordered
	 */
	protected int currentSequenceIndex = CURRENT_SEQUENCE_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getNextValue() <em>Next Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object NEXT_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getOriginalValue() <em>Original Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object ORIGINAL_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalValue() <em>Original Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected Object originalValue = ORIGINAL_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.SEQUENCE_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSequenceSize() {
		// TODO: implement this method to return the 'Sequence Size' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentSequenceIndex() {
		return currentSequenceIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentSequenceIndex(int newCurrentSequenceIndex) {
		int oldCurrentSequenceIndex = currentSequenceIndex;
		currentSequenceIndex = newCurrentSequenceIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX, oldCurrentSequenceIndex, currentSequenceIndex));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	abstract public Object getNextValue();
		
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNextValue() {
		// TODO: implement this method to return whether the 'Next Value' attribute is set
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOriginalValue() {
		return originalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(Object newOriginalValue) {
		Object oldOriginalValue = originalValue;
		originalValue = newOriginalValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.SEQUENCE_MODIFIER__ORIGINAL_VALUE, oldOriginalValue, originalValue));
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#isComplete()
	 */
	@Override
	public boolean isComplete() {
		return getCurrentSequenceIndex() >= getSequenceSize();
	} // isComplete

	
	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#reset()
	 */
	@Override
	public void reset() {
		setCurrentSequenceIndex(CURRENT_SEQUENCE_INDEX_EDEFAULT);		
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#updateFeature()
	 */
	@Override
	public void updateFeature() {
		// Capture the original value?
		if (getCurrentSequenceIndex() == CURRENT_SEQUENCE_INDEX_EDEFAULT) {
			// Yes
			setOriginalValue(target.eGet(getEStructuralFeature()));
		} // if
	} // updateFeature

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.SEQUENCE_MODIFIER__SEQUENCE_SIZE:
				return getSequenceSize();
			case ModifierPackage.SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX:
				return getCurrentSequenceIndex();
			case ModifierPackage.SEQUENCE_MODIFIER__NEXT_VALUE:
				return getNextValue();
			case ModifierPackage.SEQUENCE_MODIFIER__ORIGINAL_VALUE:
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
			case ModifierPackage.SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX:
				setCurrentSequenceIndex((Integer)newValue);
				return;
			case ModifierPackage.SEQUENCE_MODIFIER__ORIGINAL_VALUE:
				setOriginalValue(newValue);
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
			case ModifierPackage.SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX:
				setCurrentSequenceIndex(CURRENT_SEQUENCE_INDEX_EDEFAULT);
				return;
			case ModifierPackage.SEQUENCE_MODIFIER__ORIGINAL_VALUE:
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
			case ModifierPackage.SEQUENCE_MODIFIER__SEQUENCE_SIZE:
				return getSequenceSize() != SEQUENCE_SIZE_EDEFAULT;
			case ModifierPackage.SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX:
				return currentSequenceIndex != CURRENT_SEQUENCE_INDEX_EDEFAULT;
			case ModifierPackage.SEQUENCE_MODIFIER__NEXT_VALUE:
				return isSetNextValue();
			case ModifierPackage.SEQUENCE_MODIFIER__ORIGINAL_VALUE:
				return ORIGINAL_VALUE_EDEFAULT == null ? originalValue != null : !ORIGINAL_VALUE_EDEFAULT.equals(originalValue);
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
		result.append(" (currentSequenceIndex: "); //$NON-NLS-1$
		result.append(currentSequenceIndex);
		result.append(", originalValue: "); //$NON-NLS-1$
		result.append(originalValue);
		result.append(')');
		return result.toString();
	}

} //SequenceModifierImpl
