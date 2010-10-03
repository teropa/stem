package org.eclipse.stem.internal.data.generatedplugin.impl;

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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage;
import org.eclipse.stem.internal.data.generatedplugin.StemCategory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Stem Category</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.StemCategoryImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.StemCategoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.StemCategoryImpl#getParentId <em>Parent Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("all")
public class StemCategoryImpl extends CDOObjectImpl implements StemCategory {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getParentId() <em>Parent Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getParentId()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StemCategoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedpluginPackage.Literals.STEM_CATEGORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eDynamicGet(GeneratedpluginPackage.STEM_CATEGORY__ID, GeneratedpluginPackage.Literals.STEM_CATEGORY__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(GeneratedpluginPackage.STEM_CATEGORY__ID, GeneratedpluginPackage.Literals.STEM_CATEGORY__ID, newId);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(GeneratedpluginPackage.STEM_CATEGORY__NAME, GeneratedpluginPackage.Literals.STEM_CATEGORY__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(GeneratedpluginPackage.STEM_CATEGORY__NAME, GeneratedpluginPackage.Literals.STEM_CATEGORY__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getParentId() {
		return (String)eDynamicGet(GeneratedpluginPackage.STEM_CATEGORY__PARENT_ID, GeneratedpluginPackage.Literals.STEM_CATEGORY__PARENT_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentId(String newParentId) {
		eDynamicSet(GeneratedpluginPackage.STEM_CATEGORY__PARENT_ID, GeneratedpluginPackage.Literals.STEM_CATEGORY__PARENT_ID, newParentId);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedpluginPackage.STEM_CATEGORY__ID:
				return getId();
			case GeneratedpluginPackage.STEM_CATEGORY__NAME:
				return getName();
			case GeneratedpluginPackage.STEM_CATEGORY__PARENT_ID:
				return getParentId();
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
			case GeneratedpluginPackage.STEM_CATEGORY__ID:
				setId((String)newValue);
				return;
			case GeneratedpluginPackage.STEM_CATEGORY__NAME:
				setName((String)newValue);
				return;
			case GeneratedpluginPackage.STEM_CATEGORY__PARENT_ID:
				setParentId((String)newValue);
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
			case GeneratedpluginPackage.STEM_CATEGORY__ID:
				setId(ID_EDEFAULT);
				return;
			case GeneratedpluginPackage.STEM_CATEGORY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneratedpluginPackage.STEM_CATEGORY__PARENT_ID:
				setParentId(PARENT_ID_EDEFAULT);
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
			case GeneratedpluginPackage.STEM_CATEGORY__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case GeneratedpluginPackage.STEM_CATEGORY__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case GeneratedpluginPackage.STEM_CATEGORY__PARENT_ID:
				return PARENT_ID_EDEFAULT == null ? getParentId() != null : !PARENT_ID_EDEFAULT.equals(getParentId());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer();
		result.append("id: ");
		result.append(getId());
		result.append(", name: ");
		result.append(getName());
		result.append(", parentId: ");
		result.append(getParentId());
		return result.toString();
	}

} // StemCategoryImpl
