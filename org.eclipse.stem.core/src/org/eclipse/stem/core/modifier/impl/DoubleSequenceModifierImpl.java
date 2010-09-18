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
import org.eclipse.stem.core.modifier.DoubleSequenceModifier;
import org.eclipse.stem.core.modifier.ModifierPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Sequence Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.DoubleSequenceModifierImpl#getSequence <em>Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoubleSequenceModifierImpl extends SequenceModifierImpl implements DoubleSequenceModifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleSequenceModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.DOUBLE_SEQUENCE_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Double> getSequence() {
		return (EList<Double>)eDynamicGet(ModifierPackage.DOUBLE_SEQUENCE_MODIFIER__SEQUENCE, ModifierPackage.Literals.DOUBLE_SEQUENCE_MODIFIER__SEQUENCE, true, true);
	}


	/**
	 * @see org.eclipse.stem.core.modifier.impl.SequenceModifierImpl#getNextValue()
	 */
	@Override
	public Object getNextValue() {
		int index = getCurrentSequenceIndex();
		final Object retValue = getSequence().get(index++);
		setCurrentSequenceIndex(index);
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
		getTarget().eSet(getEStructuralFeature(), getNextValue());
	}
	

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#reset()
	 */
	@Override
	public void reset() {
		super.reset();
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
			case ModifierPackage.DOUBLE_SEQUENCE_MODIFIER__SEQUENCE:
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
			case ModifierPackage.DOUBLE_SEQUENCE_MODIFIER__SEQUENCE:
				getSequence().clear();
				getSequence().addAll((Collection<? extends Double>)newValue);
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
			case ModifierPackage.DOUBLE_SEQUENCE_MODIFIER__SEQUENCE:
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
			case ModifierPackage.DOUBLE_SEQUENCE_MODIFIER__SEQUENCE:
				return !getSequence().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DoubleSequenceModifierImpl
