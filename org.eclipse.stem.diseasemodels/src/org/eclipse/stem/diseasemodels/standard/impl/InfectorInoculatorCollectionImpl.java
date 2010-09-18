/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.diseasemodels.standard.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.NodeDecoratorImpl;

import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.InfectorInoculatorCollection;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infector Inoculator Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorInoculatorCollectionImpl#getList <em>List</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorInoculatorCollectionImpl#getImportFolder <em>Import Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfectorInoculatorCollectionImpl extends NodeDecoratorImpl implements InfectorInoculatorCollection {
	/**
	 * The default value of the '{@link #getImportFolder() <em>Import Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORT_FOLDER_EDEFAULT = ""; //$NON-NLS-1$
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfectorInoculatorCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.INFECTOR_INOCULATOR_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 8;
	}

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph(org.eclipse.stem.core.graph.Graph)
	 */
	@Override
	public boolean decorateGraph(STEMTime time) {
		if(this.isGraphDecorated()) return true;
		boolean success = true;
		if(this.getList() != null)
			for(Infector i:this.getList())
				if(!i.decorateGraph(time)) success = false;
		return success;
	}
	
	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#resetLabels(org.eclipse.stem.core.graph.Graph)
	 */
	@Override
	public void resetLabels() {
		if(this.getList() != null)
			for(Infector i:this.getList()) i.resetLabels();
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Infector> getList() {
		return (EList<Infector>)eDynamicGet(StandardPackage.INFECTOR_INOCULATOR_COLLECTION__LIST, StandardPackage.Literals.INFECTOR_INOCULATOR_COLLECTION__LIST, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImportFolder() {
		return (String)eDynamicGet(StandardPackage.INFECTOR_INOCULATOR_COLLECTION__IMPORT_FOLDER, StandardPackage.Literals.INFECTOR_INOCULATOR_COLLECTION__IMPORT_FOLDER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportFolder(String newImportFolder) {
		eDynamicSet(StandardPackage.INFECTOR_INOCULATOR_COLLECTION__IMPORT_FOLDER, StandardPackage.Literals.INFECTOR_INOCULATOR_COLLECTION__IMPORT_FOLDER, newImportFolder);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION__LIST:
				return ((InternalEList<?>)getList()).basicRemove(otherEnd, msgs);
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
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION__LIST:
				return getList();
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION__IMPORT_FOLDER:
				return getImportFolder();
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
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION__LIST:
				getList().clear();
				getList().addAll((Collection<? extends Infector>)newValue);
				return;
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION__IMPORT_FOLDER:
				setImportFolder((String)newValue);
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
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION__LIST:
				getList().clear();
				return;
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION__IMPORT_FOLDER:
				setImportFolder(IMPORT_FOLDER_EDEFAULT);
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
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION__LIST:
				return !getList().isEmpty();
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION__IMPORT_FOLDER:
				return IMPORT_FOLDER_EDEFAULT == null ? getImportFolder() != null : !IMPORT_FOLDER_EDEFAULT.equals(getImportFolder());
		}
		return super.eIsSet(featureID);
	}

} //InfectorInoculatorCollectionImpl
