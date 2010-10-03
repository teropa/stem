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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.generatedplugin.Extension;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage;
import org.eclipse.stem.internal.data.generatedplugin.StemCategory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Extension</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.ExtensionImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.ExtensionImpl#getDublinCores <em>Dublin Cores</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.ExtensionImpl#getPoint <em>Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("all")
public class ExtensionImpl extends CDOObjectImpl implements Extension {
	/**
	 * The default value of the '{@link #getPoint() <em>Point</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected static final String POINT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedpluginPackage.Literals.EXTENSION;
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
	@SuppressWarnings("unchecked")
	public EList<StemCategory> getCategories() {
		return (EList<StemCategory>)eDynamicGet(GeneratedpluginPackage.EXTENSION__CATEGORIES, GeneratedpluginPackage.Literals.EXTENSION__CATEGORIES, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DublinCore> getDublinCores() {
		return (EList<DublinCore>)eDynamicGet(GeneratedpluginPackage.EXTENSION__DUBLIN_CORES, GeneratedpluginPackage.Literals.EXTENSION__DUBLIN_CORES, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPoint() {
		return (String)eDynamicGet(GeneratedpluginPackage.EXTENSION__POINT, GeneratedpluginPackage.Literals.EXTENSION__POINT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoint(String newPoint) {
		eDynamicSet(GeneratedpluginPackage.EXTENSION__POINT, GeneratedpluginPackage.Literals.EXTENSION__POINT, newPoint);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedpluginPackage.EXTENSION__CATEGORIES:
				return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
			case GeneratedpluginPackage.EXTENSION__DUBLIN_CORES:
				return ((InternalEList<?>)getDublinCores()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedpluginPackage.EXTENSION__CATEGORIES:
				return getCategories();
			case GeneratedpluginPackage.EXTENSION__DUBLIN_CORES:
				return getDublinCores();
			case GeneratedpluginPackage.EXTENSION__POINT:
				return getPoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneratedpluginPackage.EXTENSION__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends StemCategory>)newValue);
				return;
			case GeneratedpluginPackage.EXTENSION__DUBLIN_CORES:
				getDublinCores().clear();
				getDublinCores().addAll((Collection<? extends DublinCore>)newValue);
				return;
			case GeneratedpluginPackage.EXTENSION__POINT:
				setPoint((String)newValue);
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
			case GeneratedpluginPackage.EXTENSION__CATEGORIES:
				getCategories().clear();
				return;
			case GeneratedpluginPackage.EXTENSION__DUBLIN_CORES:
				getDublinCores().clear();
				return;
			case GeneratedpluginPackage.EXTENSION__POINT:
				setPoint(POINT_EDEFAULT);
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
			case GeneratedpluginPackage.EXTENSION__CATEGORIES:
				return !getCategories().isEmpty();
			case GeneratedpluginPackage.EXTENSION__DUBLIN_CORES:
				return !getDublinCores().isEmpty();
			case GeneratedpluginPackage.EXTENSION__POINT:
				return POINT_EDEFAULT == null ? getPoint() != null : !POINT_EDEFAULT.equals(getPoint());
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
		result.append("point: ");
		result.append(getPoint());
		return result.toString();
	}

} // ExtensionImpl
