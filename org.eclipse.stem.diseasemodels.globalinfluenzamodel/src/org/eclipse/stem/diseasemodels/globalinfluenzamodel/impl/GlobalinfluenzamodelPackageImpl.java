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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalInfluenzaModel;
import org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalinfluenzamodelFactory;
import org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalinfluenzamodelPackage;

import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GlobalinfluenzamodelPackageImpl extends EPackageImpl implements GlobalinfluenzamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalInfluenzaModelEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalinfluenzamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GlobalinfluenzamodelPackageImpl() {
		super(eNS_URI, GlobalinfluenzamodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GlobalinfluenzamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GlobalinfluenzamodelPackage init() {
		if (isInited) return (GlobalinfluenzamodelPackage)EPackage.Registry.INSTANCE.getEPackage(GlobalinfluenzamodelPackage.eNS_URI);

		// Obtain or create and register package
		GlobalinfluenzamodelPackageImpl theGlobalinfluenzamodelPackage = (GlobalinfluenzamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GlobalinfluenzamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GlobalinfluenzamodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGlobalinfluenzamodelPackage.createPackageContents();

		// Initialize created meta-data
		theGlobalinfluenzamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGlobalinfluenzamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GlobalinfluenzamodelPackage.eNS_URI, theGlobalinfluenzamodelPackage);
		return theGlobalinfluenzamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalInfluenzaModel() {
		return globalInfluenzaModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalInfluenzaModel_LatitudeSigmoidWidth() {
		return (EAttribute)globalInfluenzaModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalInfluenzaModel_SeasonalModulationExponent() {
		return (EAttribute)globalInfluenzaModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalInfluenzaModel_ModulationPeriod() {
		return (EAttribute)globalInfluenzaModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalInfluenzaModel_ModulationPhaseShift() {
		return (EAttribute)globalInfluenzaModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalInfluenzaModel_SeasonalModulationFloor() {
		return (EAttribute)globalInfluenzaModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalinfluenzamodelFactory getGlobalinfluenzamodelFactory() {
		return (GlobalinfluenzamodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		globalInfluenzaModelEClass = createEClass(GLOBAL_INFLUENZA_MODEL);
		createEAttribute(globalInfluenzaModelEClass, GLOBAL_INFLUENZA_MODEL__LATITUDE_SIGMOID_WIDTH);
		createEAttribute(globalInfluenzaModelEClass, GLOBAL_INFLUENZA_MODEL__SEASONAL_MODULATION_EXPONENT);
		createEAttribute(globalInfluenzaModelEClass, GLOBAL_INFLUENZA_MODEL__MODULATION_PERIOD);
		createEAttribute(globalInfluenzaModelEClass, GLOBAL_INFLUENZA_MODEL__MODULATION_PHASE_SHIFT);
		createEAttribute(globalInfluenzaModelEClass, GLOBAL_INFLUENZA_MODEL__SEASONAL_MODULATION_FLOOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		StandardPackage theStandardPackage = (StandardPackage)EPackage.Registry.INSTANCE.getEPackage(StandardPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		globalInfluenzaModelEClass.getESuperTypes().add(theStandardPackage.getStochasticSIRDiseaseModel());

		// Initialize classes and features; add operations and parameters
		initEClass(globalInfluenzaModelEClass, GlobalInfluenzaModel.class, "GlobalInfluenzaModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGlobalInfluenzaModel_LatitudeSigmoidWidth(), ecorePackage.getEDouble(), "latitudeSigmoidWidth", "4.50", 0, 1, GlobalInfluenzaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGlobalInfluenzaModel_SeasonalModulationExponent(), ecorePackage.getEDouble(), "seasonalModulationExponent", "2.0", 0, 1, GlobalInfluenzaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGlobalInfluenzaModel_ModulationPeriod(), ecorePackage.getEDouble(), "modulationPeriod", "365.256363051", 0, 1, GlobalInfluenzaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGlobalInfluenzaModel_ModulationPhaseShift(), ecorePackage.getEDouble(), "modulationPhaseShift", "0.0", 0, 1, GlobalInfluenzaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGlobalInfluenzaModel_SeasonalModulationFloor(), ecorePackage.getEDouble(), "seasonalModulationFloor", "0.6", 0, 1, GlobalInfluenzaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GlobalinfluenzamodelPackageImpl
