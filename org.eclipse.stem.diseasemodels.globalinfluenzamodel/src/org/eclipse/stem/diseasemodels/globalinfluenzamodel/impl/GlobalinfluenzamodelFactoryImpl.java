package org.eclipse.stem.diseasemodels.globalinfluenzamodel.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.stem.diseasemodels.globalinfluenzamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GlobalinfluenzamodelFactoryImpl extends EFactoryImpl implements GlobalinfluenzamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GlobalinfluenzamodelFactory init() {
		try {
			GlobalinfluenzamodelFactory theGlobalinfluenzamodelFactory = (GlobalinfluenzamodelFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/diseasemodels/globalinfluenzamodel.ecore"); 
			if (theGlobalinfluenzamodelFactory != null) {
				return theGlobalinfluenzamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GlobalinfluenzamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalinfluenzamodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GlobalinfluenzamodelPackage.GLOBAL_INFLUENZA_MODEL: return createGlobalInfluenzaModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalInfluenzaModel createGlobalInfluenzaModel() {
		GlobalInfluenzaModelImpl globalInfluenzaModel = new GlobalInfluenzaModelImpl();
		return globalInfluenzaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalinfluenzamodelPackage getGlobalinfluenzamodelPackage() {
		return (GlobalinfluenzamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GlobalinfluenzamodelPackage getPackage() {
		return GlobalinfluenzamodelPackage.eINSTANCE;
	}

} //GlobalinfluenzamodelFactoryImpl
