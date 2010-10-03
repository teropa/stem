package org.eclipse.stem.diseasemodels.example.impl;

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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.stem.core.common.CommonPackage;

import org.eclipse.stem.core.graph.GraphPackage;

import org.eclipse.stem.core.model.ModelPackage;

import org.eclipse.stem.definitions.labels.LabelsPackage;

import org.eclipse.stem.diseasemodels.example.ExampleDiseaseModel;
import org.eclipse.stem.diseasemodels.example.ExampleFactory;
import org.eclipse.stem.diseasemodels.example.ExamplePackage;

import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExamplePackageImpl extends EPackageImpl implements ExamplePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleDiseaseModelEClass = null;

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
	 * @see org.eclipse.stem.diseasemodels.example.ExamplePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExamplePackageImpl() {
		super(eNS_URI, ExampleFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExamplePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExamplePackage init() {
		if (isInited) return (ExamplePackage)EPackage.Registry.INSTANCE.getEPackage(ExamplePackage.eNS_URI);

		// Obtain or create and register package
		ExamplePackageImpl theExamplePackage = (ExamplePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExamplePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExamplePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExamplePackage.createPackageContents();

		// Initialize created meta-data
		theExamplePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExamplePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExamplePackage.eNS_URI, theExamplePackage);
		return theExamplePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExampleDiseaseModel() {
		return exampleDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExampleDiseaseModel_SeasonalModulationExponent() {
		return (EAttribute)exampleDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExampleDiseaseModel_ModulationPeriod() {
		return (EAttribute)exampleDiseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExampleDiseaseModel_ModulationPhaseShift() {
		return (EAttribute)exampleDiseaseModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExampleDiseaseModel_SeasonalModulationFloor() {
		return (EAttribute)exampleDiseaseModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExampleFactory getExampleFactory() {
		return (ExampleFactory)getEFactoryInstance();
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
		exampleDiseaseModelEClass = createEClass(EXAMPLE_DISEASE_MODEL);
		createEAttribute(exampleDiseaseModelEClass, EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT);
		createEAttribute(exampleDiseaseModelEClass, EXAMPLE_DISEASE_MODEL__MODULATION_PERIOD);
		createEAttribute(exampleDiseaseModelEClass, EXAMPLE_DISEASE_MODEL__MODULATION_PHASE_SHIFT);
		createEAttribute(exampleDiseaseModelEClass, EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		exampleDiseaseModelEClass.getESuperTypes().add(theStandardPackage.getStochasticSIRDiseaseModel());

		// Initialize classes and features; add operations and parameters
		initEClass(exampleDiseaseModelEClass, ExampleDiseaseModel.class, "ExampleDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getExampleDiseaseModel_SeasonalModulationExponent(), theEcorePackage.getEDouble(), "seasonalModulationExponent", "2.0", 0, 1, ExampleDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getExampleDiseaseModel_ModulationPeriod(), ecorePackage.getEDouble(), "modulationPeriod", "365.256363051", 0, 1, ExampleDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getExampleDiseaseModel_ModulationPhaseShift(), ecorePackage.getEDouble(), "modulationPhaseShift", "0.0", 0, 1, ExampleDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getExampleDiseaseModel_SeasonalModulationFloor(), theEcorePackage.getEDouble(), "seasonalModulationFloor", "0.6", 0, 1, ExampleDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		// Create resource
		createResource(eNS_URI);
	}

} //ExamplePackageImpl
