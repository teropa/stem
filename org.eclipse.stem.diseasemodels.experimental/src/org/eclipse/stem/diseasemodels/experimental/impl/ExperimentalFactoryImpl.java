package org.eclipse.stem.diseasemodels.experimental.impl;

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
import org.eclipse.stem.diseasemodels.experimental.*;
import org.eclipse.stem.diseasemodels.experimental.ExperimentalFactory;
import org.eclipse.stem.diseasemodels.experimental.ExperimentalPackage;
import org.eclipse.stem.diseasemodels.experimental.PercolationDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExperimentalFactoryImpl extends EFactoryImpl implements ExperimentalFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExperimentalFactory init() {
		try {
			ExperimentalFactory theExperimentalFactory = (ExperimentalFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/diseasemodels/experimental.ecore"); 
			if (theExperimentalFactory != null) {
				return theExperimentalFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExperimentalFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentalFactoryImpl() {
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
			case ExperimentalPackage.PERCOLATION_DISEASE_MODEL: return (EObject)createPercolationDiseaseModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PercolationDiseaseModel createPercolationDiseaseModel() {
		PercolationDiseaseModelImpl percolationDiseaseModel = new PercolationDiseaseModelImpl();
		return percolationDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentalPackage getExperimentalPackage() {
		return (ExperimentalPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExperimentalPackage getPackage() {
		return ExperimentalPackage.eINSTANCE;
	}

} //ExperimentalFactoryImpl
