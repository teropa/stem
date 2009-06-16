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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.stem.internal.data.generatedplugin.Extension;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage;
import org.eclipse.stem.internal.data.generatedplugin.Plugin;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Plugin</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.PluginImpl#getExtensionelement
 * <em>Extensionelement</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
@SuppressWarnings("all")
public class PluginImpl extends EObjectImpl implements Plugin {
	/**
	 * The cached value of the '{@link #getExtensionelement()
	 * <em>Extensionelement</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExtensionelement()
	 * @generated
	 * @ordered
	 */
	protected EList<Extension> extensionelement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PluginImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedpluginPackage.Literals.PLUGIN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Extension> getExtensionelement() {
		if (extensionelement == null) {
			extensionelement = new EObjectContainmentEList<Extension>(
					Extension.class, this,
					GeneratedpluginPackage.PLUGIN__EXTENSIONELEMENT);
		}
		return extensionelement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GeneratedpluginPackage.PLUGIN__EXTENSIONELEMENT:
			return ((InternalEList<?>) getExtensionelement()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GeneratedpluginPackage.PLUGIN__EXTENSIONELEMENT:
			return getExtensionelement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GeneratedpluginPackage.PLUGIN__EXTENSIONELEMENT:
			getExtensionelement().clear();
			getExtensionelement().addAll(
					(Collection<? extends Extension>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case GeneratedpluginPackage.PLUGIN__EXTENSIONELEMENT:
			getExtensionelement().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case GeneratedpluginPackage.PLUGIN__EXTENSIONELEMENT:
			return extensionelement != null && !extensionelement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // PluginImpl
