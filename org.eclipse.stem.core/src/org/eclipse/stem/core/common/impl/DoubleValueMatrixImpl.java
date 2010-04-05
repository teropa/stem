package org.eclipse.stem.core.common.impl;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.DoubleValueList;
import org.eclipse.stem.core.common.DoubleValueMatrix;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Value Matrix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.common.impl.DoubleValueMatrixImpl#getValueLists <em>Value Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoubleValueMatrixImpl extends EObjectImpl implements DoubleValueMatrix {
	/**
	 * The cached value of the '{@link #getValueLists() <em>Value Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLists()
	 * @generated
	 * @ordered
	 */
	protected EList<DoubleValueList> valueLists;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValueMatrixImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.DOUBLE_VALUE_MATRIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DoubleValueList> getValueLists() {
		if (valueLists == null) {
			valueLists = new EObjectContainmentEList<DoubleValueList>(DoubleValueList.class, this, CommonPackage.DOUBLE_VALUE_MATRIX__VALUE_LISTS);
		}
		return valueLists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonPackage.DOUBLE_VALUE_MATRIX__VALUE_LISTS:
				return ((InternalEList<?>)getValueLists()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.DOUBLE_VALUE_MATRIX__VALUE_LISTS:
				return getValueLists();
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
			case CommonPackage.DOUBLE_VALUE_MATRIX__VALUE_LISTS:
				getValueLists().clear();
				getValueLists().addAll((Collection<? extends DoubleValueList>)newValue);
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
			case CommonPackage.DOUBLE_VALUE_MATRIX__VALUE_LISTS:
				getValueLists().clear();
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
			case CommonPackage.DOUBLE_VALUE_MATRIX__VALUE_LISTS:
				return valueLists != null && !valueLists.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DoubleValueMatrixImpl
