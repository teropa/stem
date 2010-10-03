package org.eclipse.stem.diseasemodels.multipopulation.impl;

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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.stem.diseasemodels.multipopulation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultipopulationFactoryImpl extends EFactoryImpl implements MultipopulationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MultipopulationFactory init() {
		try {
			MultipopulationFactory theMultipopulationFactory = (MultipopulationFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/diseasemodels/multipopulation.ecore"); 
			if (theMultipopulationFactory != null) {
				return theMultipopulationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MultipopulationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipopulationFactoryImpl() {
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
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL: return (EObject)createMultiPopulationSIDiseaseModel();
			case MultipopulationPackage.MULTI_POPULATION_SIR_DISEASE_MODEL: return (EObject)createMultiPopulationSIRDiseaseModel();
			case MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL: return (EObject)createMultiPopulationSEIRDiseaseModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiPopulationSIDiseaseModel createMultiPopulationSIDiseaseModel() {
		MultiPopulationSIDiseaseModelImpl multiPopulationSIDiseaseModel = new MultiPopulationSIDiseaseModelImpl();
		return multiPopulationSIDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiPopulationSIRDiseaseModel createMultiPopulationSIRDiseaseModel() {
		MultiPopulationSIRDiseaseModelImpl multiPopulationSIRDiseaseModel = new MultiPopulationSIRDiseaseModelImpl();
		return multiPopulationSIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiPopulationSEIRDiseaseModel createMultiPopulationSEIRDiseaseModel() {
		MultiPopulationSEIRDiseaseModelImpl multiPopulationSEIRDiseaseModel = new MultiPopulationSEIRDiseaseModelImpl();
		return multiPopulationSEIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipopulationPackage getMultipopulationPackage() {
		return (MultipopulationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MultipopulationPackage getPackage() {
		return MultipopulationPackage.eINSTANCE;
	}

} //MultipopulationFactoryImpl
