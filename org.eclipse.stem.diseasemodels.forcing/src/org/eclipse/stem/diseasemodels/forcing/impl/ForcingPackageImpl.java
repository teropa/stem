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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel;
import org.eclipse.stem.diseasemodels.forcing.ForcingFactory;
import org.eclipse.stem.diseasemodels.forcing.ForcingPackage;

import org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel;
import org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForcingPackageImpl extends EPackageImpl implements ForcingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forcingDiseaseModelEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gaussianForcingDiseaseModelEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gaussian2ForcingDiseaseModelEClass = null;
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
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ForcingPackageImpl() {
		super(eNS_URI, ForcingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ForcingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ForcingPackage init() {
		if (isInited) return (ForcingPackage)EPackage.Registry.INSTANCE.getEPackage(ForcingPackage.eNS_URI);

		// Obtain or create and register package
		ForcingPackageImpl theForcingPackage = (ForcingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ForcingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ForcingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theForcingPackage.createPackageContents();

		// Initialize created meta-data
		theForcingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theForcingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ForcingPackage.eNS_URI, theForcingPackage);
		return theForcingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForcingDiseaseModel() {
		return forcingDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForcingDiseaseModel_SeasonalModulationExponent() {
		return (EAttribute)forcingDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForcingDiseaseModel_ModulationPeriod() {
		return (EAttribute)forcingDiseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForcingDiseaseModel_ModulationPhaseShift() {
		return (EAttribute)forcingDiseaseModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForcingDiseaseModel_SeasonalModulationFloor() {
		return (EAttribute)forcingDiseaseModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGaussianForcingDiseaseModel() {
		return gaussianForcingDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussianForcingDiseaseModel_Sigma2() {
		return (EAttribute)gaussianForcingDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussianForcingDiseaseModel_ModulationPeriod() {
		return (EAttribute)gaussianForcingDiseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussianForcingDiseaseModel_ModulationPhaseShift() {
		return (EAttribute)gaussianForcingDiseaseModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussianForcingDiseaseModel_ModulationFloor() {
		return (EAttribute)gaussianForcingDiseaseModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGaussian2ForcingDiseaseModel() {
		return gaussian2ForcingDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian2ForcingDiseaseModel_Sigma2_2() {
		return (EAttribute)gaussian2ForcingDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian2ForcingDiseaseModel_Sigma2() {
		return (EAttribute)gaussian2ForcingDiseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian2ForcingDiseaseModel_ModulationPeriod() {
		return (EAttribute)gaussian2ForcingDiseaseModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian2ForcingDiseaseModel_ModulationPhaseShift() {
		return (EAttribute)gaussian2ForcingDiseaseModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian2ForcingDiseaseModel_ModulationFloor() {
		return (EAttribute)gaussian2ForcingDiseaseModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian2ForcingDiseaseModel_Att1() {
		return (EAttribute)gaussian2ForcingDiseaseModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian2ForcingDiseaseModel_Att2() {
		return (EAttribute)gaussian2ForcingDiseaseModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian2ForcingDiseaseModel_Att3() {
		return (EAttribute)gaussian2ForcingDiseaseModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGaussian2ForcingDiseaseModel_Att4() {
		return (EAttribute)gaussian2ForcingDiseaseModelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForcingFactory getForcingFactory() {
		return (ForcingFactory)getEFactoryInstance();
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
		forcingDiseaseModelEClass = createEClass(FORCING_DISEASE_MODEL);
		createEAttribute(forcingDiseaseModelEClass, FORCING_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT);
		createEAttribute(forcingDiseaseModelEClass, FORCING_DISEASE_MODEL__MODULATION_PERIOD);
		createEAttribute(forcingDiseaseModelEClass, FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT);
		createEAttribute(forcingDiseaseModelEClass, FORCING_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR);

		gaussianForcingDiseaseModelEClass = createEClass(GAUSSIAN_FORCING_DISEASE_MODEL);
		createEAttribute(gaussianForcingDiseaseModelEClass, GAUSSIAN_FORCING_DISEASE_MODEL__SIGMA2);
		createEAttribute(gaussianForcingDiseaseModelEClass, GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PERIOD);
		createEAttribute(gaussianForcingDiseaseModelEClass, GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT);
		createEAttribute(gaussianForcingDiseaseModelEClass, GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_FLOOR);

		gaussian2ForcingDiseaseModelEClass = createEClass(GAUSSIAN2_FORCING_DISEASE_MODEL);
		createEAttribute(gaussian2ForcingDiseaseModelEClass, GAUSSIAN2_FORCING_DISEASE_MODEL__SIGMA2_2);
		createEAttribute(gaussian2ForcingDiseaseModelEClass, GAUSSIAN2_FORCING_DISEASE_MODEL__SIGMA2);
		createEAttribute(gaussian2ForcingDiseaseModelEClass, GAUSSIAN2_FORCING_DISEASE_MODEL__MODULATION_PERIOD);
		createEAttribute(gaussian2ForcingDiseaseModelEClass, GAUSSIAN2_FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT);
		createEAttribute(gaussian2ForcingDiseaseModelEClass, GAUSSIAN2_FORCING_DISEASE_MODEL__MODULATION_FLOOR);
		createEAttribute(gaussian2ForcingDiseaseModelEClass, GAUSSIAN2_FORCING_DISEASE_MODEL__ATT1);
		createEAttribute(gaussian2ForcingDiseaseModelEClass, GAUSSIAN2_FORCING_DISEASE_MODEL__ATT2);
		createEAttribute(gaussian2ForcingDiseaseModelEClass, GAUSSIAN2_FORCING_DISEASE_MODEL__ATT3);
		createEAttribute(gaussian2ForcingDiseaseModelEClass, GAUSSIAN2_FORCING_DISEASE_MODEL__ATT4);
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
		forcingDiseaseModelEClass.getESuperTypes().add(theStandardPackage.getStochasticSIRDiseaseModel());
		gaussianForcingDiseaseModelEClass.getESuperTypes().add(theStandardPackage.getStochasticSIRDiseaseModel());
		gaussian2ForcingDiseaseModelEClass.getESuperTypes().add(theStandardPackage.getStochasticSIRDiseaseModel());

		// Initialize classes and features; add operations and parameters
		initEClass(forcingDiseaseModelEClass, ForcingDiseaseModel.class, "ForcingDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getForcingDiseaseModel_SeasonalModulationExponent(), theEcorePackage.getEDouble(), "seasonalModulationExponent", "2.0", 0, 1, ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getForcingDiseaseModel_ModulationPeriod(), ecorePackage.getEDouble(), "modulationPeriod", "365.256363051", 0, 1, ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getForcingDiseaseModel_ModulationPhaseShift(), ecorePackage.getEDouble(), "modulationPhaseShift", "0.0", 0, 1, ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getForcingDiseaseModel_SeasonalModulationFloor(), theEcorePackage.getEDouble(), "seasonalModulationFloor", "0.6", 0, 1, ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(gaussianForcingDiseaseModelEClass, GaussianForcingDiseaseModel.class, "GaussianForcingDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getGaussianForcingDiseaseModel_Sigma2(), ecorePackage.getEDouble(), "sigma2", "100", 0, 1, GaussianForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getGaussianForcingDiseaseModel_ModulationPeriod(), ecorePackage.getEDouble(), "modulationPeriod", "365.25", 0, 1, GaussianForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getGaussianForcingDiseaseModel_ModulationPhaseShift(), ecorePackage.getEDouble(), "modulationPhaseShift", "0", 0, 1, GaussianForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getGaussianForcingDiseaseModel_ModulationFloor(), ecorePackage.getEDouble(), "modulationFloor", "0.6", 0, 1, GaussianForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(gaussian2ForcingDiseaseModelEClass, Gaussian2ForcingDiseaseModel.class, "Gaussian2ForcingDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getGaussian2ForcingDiseaseModel_Sigma2_2(), theEcorePackage.getEDouble(), "sigma2_2", null, 0, 1, Gaussian2ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGaussian2ForcingDiseaseModel_Sigma2(), ecorePackage.getEDouble(), "sigma2", null, 0, 1, Gaussian2ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGaussian2ForcingDiseaseModel_ModulationPeriod(), ecorePackage.getEDouble(), "modulationPeriod", null, 0, 1, Gaussian2ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGaussian2ForcingDiseaseModel_ModulationPhaseShift(), ecorePackage.getEDouble(), "modulationPhaseShift", null, 0, 1, Gaussian2ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGaussian2ForcingDiseaseModel_ModulationFloor(), theEcorePackage.getEDouble(), "modulationFloor", null, 0, 1, Gaussian2ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGaussian2ForcingDiseaseModel_Att1(), theEcorePackage.getEDouble(), "att1", null, 0, 1, Gaussian2ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGaussian2ForcingDiseaseModel_Att2(), theEcorePackage.getEDouble(), "att2", null, 0, 1, Gaussian2ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGaussian2ForcingDiseaseModel_Att3(), theEcorePackage.getEDouble(), "att3", null, 0, 1, Gaussian2ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGaussian2ForcingDiseaseModel_Att4(), theEcorePackage.getEDouble(), "att4", null, 0, 1, Gaussian2ForcingDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //ExamplePackageImpl
