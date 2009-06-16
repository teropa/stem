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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.stem.core.modifier.LongSequenceModifier;
import org.eclipse.stem.core.modifier.ModifierPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Long Sequence Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.LongSequenceModifierImpl#getSequence <em>Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LongSequenceModifierImpl extends SequenceModifierImpl implements LongSequenceModifier {
	/**
	 * The cached value of the '{@link #getSequence() <em>Sequence</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Long> sequence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LongSequenceModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.LONG_SEQUENCE_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Long> getSequence() {
		if (sequence == null) {
			sequence = new EDataTypeUniqueEList<Long>(Long.class, this, ModifierPackage.LONG_SEQUENCE_MODIFIER__SEQUENCE);
		}
		return sequence;
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.SequenceModifierImpl#getNextValue()
	 */
	@Override
	public Object getNextValue() {
		int index = getCurrentSequenceIndex();
		final Object retValue = getSequence().get(index++);
		setCurrentSequenceIndex(index);	
		currentValueText = retValue.toString();
		return retValue;
	} // getNextValue
	

	/**
	 * @see org.eclipse.stem.core.modifier.impl.SequenceModifierImpl#getSequenceSize()
	 */
	@Override
	public int getSequenceSize() {
		return getSequence().size();
	} // getSequenceSize
	

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#updateFeature()
	 */
	@Override
	public void updateFeature() {
		super.updateFeature();
		target.eSet(getEStructuralFeature(), getNextValue());
	}
	
	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		target.eSet(getEStructuralFeature(), getOriginalValue());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.LONG_SEQUENCE_MODIFIER__SEQUENCE:
				return getSequence();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModifierPackage.LONG_SEQUENCE_MODIFIER__SEQUENCE:
				getSequence().clear();
				getSequence().addAll((Collection<? extends Long>)newValue);
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
			case ModifierPackage.LONG_SEQUENCE_MODIFIER__SEQUENCE:
				getSequence().clear();
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
			case ModifierPackage.LONG_SEQUENCE_MODIFIER__SEQUENCE:
				return sequence != null && !sequence.isEmpty();
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
		result.append(" (sequence: "); //$NON-NLS-1$
		result.append(sequence);
		result.append(')');
		return result.toString();
	}

} //LongSequenceModifierImpl
