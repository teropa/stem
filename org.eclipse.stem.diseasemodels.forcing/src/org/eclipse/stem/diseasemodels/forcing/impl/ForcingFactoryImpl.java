package org.eclipse.stem.diseasemodels.forcing.impl;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
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

import org.eclipse.stem.diseasemodels.forcing.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForcingFactoryImpl extends EFactoryImpl implements ForcingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ForcingFactory init() {
		try {
			ForcingFactory theForcingFactory = (ForcingFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/diseasemodels/forcing.ecore"); //$NON-NLS-1$ 
			if (theForcingFactory != null) {
				return theForcingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ForcingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForcingFactoryImpl() {
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
			case ForcingPackage.FORCING_DISEASE_MODEL: return createForcingDiseaseModel();
			case ForcingPackage.GAUSSIAN_FORCING_DISEASE_MODEL: return createGaussianForcingDiseaseModel();
			case ForcingPackage.GAUSSIAN2_FORCING_DISEASE_MODEL: return createGaussian2ForcingDiseaseModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForcingDiseaseModel createForcingDiseaseModel() {
		ForcingDiseaseModelImpl forcingDiseaseModel = new ForcingDiseaseModelImpl();
		return forcingDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaussianForcingDiseaseModel createGaussianForcingDiseaseModel() {
		GaussianForcingDiseaseModelImpl gaussianForcingDiseaseModel = new GaussianForcingDiseaseModelImpl();
		return gaussianForcingDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gaussian2ForcingDiseaseModel createGaussian2ForcingDiseaseModel() {
		Gaussian2ForcingDiseaseModelImpl gaussian2ForcingDiseaseModel = new Gaussian2ForcingDiseaseModelImpl();
		return gaussian2ForcingDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForcingPackage getForcingPackage() {
		return (ForcingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ForcingPackage getPackage() {
		return ForcingPackage.eINSTANCE;
	}

} //ExampleFactoryImpl
