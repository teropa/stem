package automaticexperiment.impl;

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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.sequencer.SequencerPackage;

import automaticexperiment.AutomaticExperiment;
import automaticexperiment.AutomaticexperimentFactory;
import automaticexperiment.AutomaticexperimentPackage;
import automaticexperiment.ModifiableParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AutomaticexperimentPackageImpl extends EPackageImpl implements AutomaticexperimentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass automaticExperimentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifiableParameterEClass = null;

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
	 * @see automaticexperiment.AutomaticexperimentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AutomaticexperimentPackageImpl() {
		super(eNS_URI, AutomaticexperimentFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AutomaticexperimentPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AutomaticexperimentPackage init() {
		if (isInited) return (AutomaticexperimentPackage)EPackage.Registry.INSTANCE.getEPackage(AutomaticexperimentPackage.eNS_URI);

		// Obtain or create and register package
		AutomaticexperimentPackageImpl theAutomaticexperimentPackage = (AutomaticexperimentPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AutomaticexperimentPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AutomaticexperimentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();
		GraphPackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		ModifierPackage.eINSTANCE.eClass();
		ScenarioPackage.eINSTANCE.eClass();
		SequencerPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAutomaticexperimentPackage.createPackageContents();

		// Initialize created meta-data
		theAutomaticexperimentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAutomaticexperimentPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AutomaticexperimentPackage.eNS_URI, theAutomaticexperimentPackage);
		return theAutomaticexperimentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutomaticExperiment() {
		return automaticExperimentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAutomaticExperiment_BaseScenario() {
		return (EReference)automaticExperimentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAutomaticExperiment_Parameters() {
		return (EReference)automaticExperimentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutomaticExperiment_ErrorAnalysisAlgorithm() {
		return (EAttribute)automaticExperimentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutomaticExperiment_ErrorFunction() {
		return (EAttribute)automaticExperimentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutomaticExperiment_Tolerance() {
		return (EAttribute)automaticExperimentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutomaticExperiment_ReferanceDataDir() {
		return (EAttribute)automaticExperimentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutomaticExperiment_MaximumNumberOfIterations() {
		return (EAttribute)automaticExperimentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifiableParameter() {
		return modifiableParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifiableParameter_InitialValue() {
		return (EAttribute)modifiableParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifiableParameter_Feature() {
		return (EReference)modifiableParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifiableParameter_Step() {
		return (EAttribute)modifiableParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifiableParameter_FeatureName() {
		return (EAttribute)modifiableParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifiableParameter_LowerBound() {
		return (EAttribute)modifiableParameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifiableParameter_UpperBound() {
		return (EAttribute)modifiableParameterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutomaticexperimentFactory getAutomaticexperimentFactory() {
		return (AutomaticexperimentFactory)getEFactoryInstance();
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
		automaticExperimentEClass = createEClass(AUTOMATIC_EXPERIMENT);
		createEReference(automaticExperimentEClass, AUTOMATIC_EXPERIMENT__BASE_SCENARIO);
		createEReference(automaticExperimentEClass, AUTOMATIC_EXPERIMENT__PARAMETERS);
		createEAttribute(automaticExperimentEClass, AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM);
		createEAttribute(automaticExperimentEClass, AUTOMATIC_EXPERIMENT__ERROR_FUNCTION);
		createEAttribute(automaticExperimentEClass, AUTOMATIC_EXPERIMENT__TOLERANCE);
		createEAttribute(automaticExperimentEClass, AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR);
		createEAttribute(automaticExperimentEClass, AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS);

		modifiableParameterEClass = createEClass(MODIFIABLE_PARAMETER);
		createEAttribute(modifiableParameterEClass, MODIFIABLE_PARAMETER__INITIAL_VALUE);
		createEReference(modifiableParameterEClass, MODIFIABLE_PARAMETER__FEATURE);
		createEAttribute(modifiableParameterEClass, MODIFIABLE_PARAMETER__STEP);
		createEAttribute(modifiableParameterEClass, MODIFIABLE_PARAMETER__FEATURE_NAME);
		createEAttribute(modifiableParameterEClass, MODIFIABLE_PARAMETER__LOWER_BOUND);
		createEAttribute(modifiableParameterEClass, MODIFIABLE_PARAMETER__UPPER_BOUND);
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
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		ScenarioPackage theScenarioPackage = (ScenarioPackage)EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		automaticExperimentEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());

		// Initialize classes and features; add operations and parameters
		initEClass(automaticExperimentEClass, AutomaticExperiment.class, "AutomaticExperiment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAutomaticExperiment_BaseScenario(), theScenarioPackage.getScenario(), null, "baseScenario", null, 1, 1, AutomaticExperiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAutomaticExperiment_Parameters(), this.getModifiableParameter(), null, "parameters", null, 1, -1, AutomaticExperiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutomaticExperiment_ErrorAnalysisAlgorithm(), theEcorePackage.getEString(), "errorAnalysisAlgorithm", null, 1, 1, AutomaticExperiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutomaticExperiment_ErrorFunction(), theEcorePackage.getEString(), "errorFunction", null, 1, 1, AutomaticExperiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutomaticExperiment_Tolerance(), theEcorePackage.getEDouble(), "tolerance", null, 1, 1, AutomaticExperiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutomaticExperiment_ReferanceDataDir(), theEcorePackage.getEString(), "referanceDataDir", null, 1, 1, AutomaticExperiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutomaticExperiment_MaximumNumberOfIterations(), theEcorePackage.getELong(), "maximumNumberOfIterations", null, 1, 1, AutomaticExperiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifiableParameterEClass, ModifiableParameter.class, "ModifiableParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModifiableParameter_InitialValue(), theEcorePackage.getEDouble(), "initialValue", null, 1, 1, ModifiableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifiableParameter_Feature(), theEcorePackage.getEStructuralFeature(), null, "feature", null, 1, 1, ModifiableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModifiableParameter_Step(), theEcorePackage.getEDouble(), "step", null, 1, 1, ModifiableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModifiableParameter_FeatureName(), theEcorePackage.getEString(), "featureName", null, 1, 1, ModifiableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModifiableParameter_LowerBound(), theEcorePackage.getEDouble(), "lowerBound", "-1", 0, 1, ModifiableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModifiableParameter_UpperBound(), theEcorePackage.getEDouble(), "upperBound", "-1", 0, 1, ModifiableParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AutomaticexperimentPackageImpl
