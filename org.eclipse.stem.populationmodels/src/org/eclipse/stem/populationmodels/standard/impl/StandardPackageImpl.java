package org.eclipse.stem.populationmodels.standard.impl;

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
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.core.graph.IntegrationLabelValue;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.populationmodels.standard.DemographicPopulationModel;
import org.eclipse.stem.populationmodels.standard.PopulationGroup;
import org.eclipse.stem.populationmodels.standard.PopulationInitializer;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabelValue;
import org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue;
import org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StandardPackageImpl extends EPackageImpl implements StandardPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass populationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardPopulationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass populationModelLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardPopulationModelLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integrationLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integrationLabelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integrationDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass populationModelLabelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardPopulationModelLabelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stochasticStandardPopulationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass demographicPopulationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass populationGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass populationInitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardPopulationInitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seasonalPopulationModelEClass = null;

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
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StandardPackageImpl() {
		super(eNS_URI, StandardFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StandardPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StandardPackage init() {
		if (isInited) return (StandardPackage)EPackage.Registry.INSTANCE.getEPackage(StandardPackage.eNS_URI);

		// Obtain or create and register package
		StandardPackageImpl theStandardPackage = (StandardPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StandardPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StandardPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		LabelsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStandardPackage.createPackageContents();

		// Initialize created meta-data
		theStandardPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStandardPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StandardPackage.eNS_URI, theStandardPackage);
		return theStandardPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPopulationModel() {
		return populationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPopulationModel_PopulationIdentifier() {
		return (EAttribute)populationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPopulationModel_Name() {
		return (EAttribute)populationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPopulationModel_TargetISOKey() {
		return (EAttribute)populationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardPopulationModel() {
		return standardPopulationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationModel_BirthRate() {
		return (EAttribute)standardPopulationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationModel_DeathRate() {
		return (EAttribute)standardPopulationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationModel_TimePeriod() {
		return (EAttribute)standardPopulationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPopulationModelLabel() {
		return populationModelLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPopulationModelLabel_PopulationLabel() {
		return (EReference)populationModelLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPopulationModelLabel_PopulationIdentifier() {
		return (EAttribute)populationModelLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardPopulationModelLabel() {
		return standardPopulationModelLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardPopulationModelLabel_DeltaValue() {
		return (EReference)standardPopulationModelLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardPopulationModelLabel_ProbeValue() {
		return (EReference)standardPopulationModelLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardPopulationModelLabel_TempValue() {
		return (EReference)standardPopulationModelLabelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardPopulationModelLabel_OriginalValue() {
		return (EReference)standardPopulationModelLabelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardPopulationModelLabel_ErrorScale() {
		return (EReference)standardPopulationModelLabelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegrationLabel() {
		return integrationLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegrationLabelValue() {
		return integrationLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegrationDecorator() {
		return integrationDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPopulationModelLabelValue() {
		return populationModelLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardPopulationModelLabelValue() {
		return standardPopulationModelLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationModelLabelValue_Count() {
		return (EAttribute)standardPopulationModelLabelValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationModelLabelValue_Incidence() {
		return (EAttribute)standardPopulationModelLabelValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationModelLabelValue_Births() {
		return (EAttribute)standardPopulationModelLabelValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationModelLabelValue_Deaths() {
		return (EAttribute)standardPopulationModelLabelValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationModelLabelValue_Density() {
		return (EAttribute)standardPopulationModelLabelValueEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStochasticStandardPopulationModel() {
		return stochasticStandardPopulationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStochasticStandardPopulationModel_Gain() {
		return (EAttribute)stochasticStandardPopulationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDemographicPopulationModel() {
		return demographicPopulationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDemographicPopulationModel_PopulationGroups() {
		return (EReference)demographicPopulationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPopulationGroup() {
		return populationGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPopulationGroup_Identifier() {
		return (EAttribute)populationGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPopulationGroup_Fraction() {
		return (EAttribute)populationGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPopulationInitializer() {
		return populationInitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPopulationInitializer_TargetISOKey() {
		return (EAttribute)populationInitializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardPopulationInitializer() {
		return standardPopulationInitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationInitializer_Individuals() {
		return (EAttribute)standardPopulationInitializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationInitializer_UseDensity() {
		return (EAttribute)standardPopulationInitializerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardPopulationInitializer_PopulationIdentifier() {
		return (EAttribute)standardPopulationInitializerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeasonalPopulationModel() {
		return seasonalPopulationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeasonalPopulationModel_Phase() {
		return (EAttribute)seasonalPopulationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeasonalPopulationModel_ModulationAmplitude() {
		return (EAttribute)seasonalPopulationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeasonalPopulationModel_Period() {
		return (EAttribute)seasonalPopulationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeasonalPopulationModel_UseLatitude() {
		return (EAttribute)seasonalPopulationModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardFactory getStandardFactory() {
		return (StandardFactory)getEFactoryInstance();
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
		populationModelEClass = createEClass(POPULATION_MODEL);
		createEAttribute(populationModelEClass, POPULATION_MODEL__POPULATION_IDENTIFIER);
		createEAttribute(populationModelEClass, POPULATION_MODEL__NAME);
		createEAttribute(populationModelEClass, POPULATION_MODEL__TARGET_ISO_KEY);

		standardPopulationModelEClass = createEClass(STANDARD_POPULATION_MODEL);
		createEAttribute(standardPopulationModelEClass, STANDARD_POPULATION_MODEL__BIRTH_RATE);
		createEAttribute(standardPopulationModelEClass, STANDARD_POPULATION_MODEL__DEATH_RATE);
		createEAttribute(standardPopulationModelEClass, STANDARD_POPULATION_MODEL__TIME_PERIOD);

		populationModelLabelEClass = createEClass(POPULATION_MODEL_LABEL);
		createEReference(populationModelLabelEClass, POPULATION_MODEL_LABEL__POPULATION_LABEL);
		createEAttribute(populationModelLabelEClass, POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER);

		standardPopulationModelLabelEClass = createEClass(STANDARD_POPULATION_MODEL_LABEL);
		createEReference(standardPopulationModelLabelEClass, STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE);
		createEReference(standardPopulationModelLabelEClass, STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE);
		createEReference(standardPopulationModelLabelEClass, STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE);
		createEReference(standardPopulationModelLabelEClass, STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE);
		createEReference(standardPopulationModelLabelEClass, STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE);

		integrationLabelEClass = createEClass(INTEGRATION_LABEL);

		integrationLabelValueEClass = createEClass(INTEGRATION_LABEL_VALUE);

		integrationDecoratorEClass = createEClass(INTEGRATION_DECORATOR);

		populationModelLabelValueEClass = createEClass(POPULATION_MODEL_LABEL_VALUE);

		standardPopulationModelLabelValueEClass = createEClass(STANDARD_POPULATION_MODEL_LABEL_VALUE);
		createEAttribute(standardPopulationModelLabelValueEClass, STANDARD_POPULATION_MODEL_LABEL_VALUE__COUNT);
		createEAttribute(standardPopulationModelLabelValueEClass, STANDARD_POPULATION_MODEL_LABEL_VALUE__INCIDENCE);
		createEAttribute(standardPopulationModelLabelValueEClass, STANDARD_POPULATION_MODEL_LABEL_VALUE__BIRTHS);
		createEAttribute(standardPopulationModelLabelValueEClass, STANDARD_POPULATION_MODEL_LABEL_VALUE__DEATHS);
		createEAttribute(standardPopulationModelLabelValueEClass, STANDARD_POPULATION_MODEL_LABEL_VALUE__DENSITY);

		stochasticStandardPopulationModelEClass = createEClass(STOCHASTIC_STANDARD_POPULATION_MODEL);
		createEAttribute(stochasticStandardPopulationModelEClass, STOCHASTIC_STANDARD_POPULATION_MODEL__GAIN);

		demographicPopulationModelEClass = createEClass(DEMOGRAPHIC_POPULATION_MODEL);
		createEReference(demographicPopulationModelEClass, DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS);

		populationGroupEClass = createEClass(POPULATION_GROUP);
		createEAttribute(populationGroupEClass, POPULATION_GROUP__IDENTIFIER);
		createEAttribute(populationGroupEClass, POPULATION_GROUP__FRACTION);

		populationInitializerEClass = createEClass(POPULATION_INITIALIZER);
		createEAttribute(populationInitializerEClass, POPULATION_INITIALIZER__TARGET_ISO_KEY);

		standardPopulationInitializerEClass = createEClass(STANDARD_POPULATION_INITIALIZER);
		createEAttribute(standardPopulationInitializerEClass, STANDARD_POPULATION_INITIALIZER__INDIVIDUALS);
		createEAttribute(standardPopulationInitializerEClass, STANDARD_POPULATION_INITIALIZER__USE_DENSITY);
		createEAttribute(standardPopulationInitializerEClass, STANDARD_POPULATION_INITIALIZER__POPULATION_IDENTIFIER);

		seasonalPopulationModelEClass = createEClass(SEASONAL_POPULATION_MODEL);
		createEAttribute(seasonalPopulationModelEClass, SEASONAL_POPULATION_MODEL__PHASE);
		createEAttribute(seasonalPopulationModelEClass, SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE);
		createEAttribute(seasonalPopulationModelEClass, SEASONAL_POPULATION_MODEL__PERIOD);
		createEAttribute(seasonalPopulationModelEClass, SEASONAL_POPULATION_MODEL__USE_LATITUDE);
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
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		ModifierPackage theModifierPackage = (ModifierPackage)EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);
		LabelsPackage theLabelsPackage = (LabelsPackage)EPackage.Registry.INSTANCE.getEPackage(LabelsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		populationModelEClass.getESuperTypes().add(theModelPackage.getNodeDecorator());
		populationModelEClass.getESuperTypes().add(theModifierPackage.getModifiable());
		standardPopulationModelEClass.getESuperTypes().add(this.getPopulationModel());
		standardPopulationModelEClass.getESuperTypes().add(this.getIntegrationDecorator());
		populationModelLabelEClass.getESuperTypes().add(theGraphPackage.getDynamicNodeLabel());
		standardPopulationModelLabelEClass.getESuperTypes().add(this.getPopulationModelLabel());
		standardPopulationModelLabelEClass.getESuperTypes().add(this.getIntegrationLabel());
		populationModelLabelValueEClass.getESuperTypes().add(theGraphPackage.getLabelValue());
		standardPopulationModelLabelValueEClass.getESuperTypes().add(this.getPopulationModelLabelValue());
		standardPopulationModelLabelValueEClass.getESuperTypes().add(this.getIntegrationLabelValue());
		stochasticStandardPopulationModelEClass.getESuperTypes().add(this.getStandardPopulationModel());
		demographicPopulationModelEClass.getESuperTypes().add(this.getStandardPopulationModel());
		populationInitializerEClass.getESuperTypes().add(theModelPackage.getNodeDecorator());
		populationInitializerEClass.getESuperTypes().add(theModifierPackage.getModifiable());
		standardPopulationInitializerEClass.getESuperTypes().add(this.getPopulationInitializer());
		seasonalPopulationModelEClass.getESuperTypes().add(this.getStandardPopulationModel());

		// Initialize classes and features; add operations and parameters
		initEClass(populationModelEClass, PopulationModel.class, "PopulationModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPopulationModel_PopulationIdentifier(), theEcorePackage.getEString(), "populationIdentifier", "human", 0, 1, PopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPopulationModel_Name(), theEcorePackage.getEString(), "name", "HumanPopulationModel", 0, 1, PopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPopulationModel_TargetISOKey(), theEcorePackage.getEString(), "targetISOKey", "", 0, 1, PopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(standardPopulationModelEClass, StandardPopulationModel.class, "StandardPopulationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStandardPopulationModel_BirthRate(), theEcorePackage.getEDouble(), "birthRate", "0.0", 0, 1, StandardPopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardPopulationModel_DeathRate(), theEcorePackage.getEDouble(), "deathRate", "0.0", 0, 1, StandardPopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardPopulationModel_TimePeriod(), ecorePackage.getELong(), "timePeriod", "86400000", 0, 1, StandardPopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(populationModelLabelEClass, PopulationModelLabel.class, "PopulationModelLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPopulationModelLabel_PopulationLabel(), theLabelsPackage.getPopulationLabel(), null, "populationLabel", null, 0, 1, PopulationModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPopulationModelLabel_PopulationIdentifier(), theEcorePackage.getEString(), "populationIdentifier", null, 0, 1, PopulationModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(standardPopulationModelLabelEClass, StandardPopulationModelLabel.class, "StandardPopulationModelLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStandardPopulationModelLabel_DeltaValue(), this.getStandardPopulationModelLabelValue(), null, "deltaValue", null, 0, 1, StandardPopulationModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStandardPopulationModelLabel_ProbeValue(), this.getStandardPopulationModelLabelValue(), null, "probeValue", null, 0, 1, StandardPopulationModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStandardPopulationModelLabel_TempValue(), this.getStandardPopulationModelLabelValue(), null, "tempValue", null, 0, 1, StandardPopulationModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStandardPopulationModelLabel_OriginalValue(), this.getStandardPopulationModelLabelValue(), null, "originalValue", null, 0, 1, StandardPopulationModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStandardPopulationModelLabel_ErrorScale(), this.getStandardPopulationModelLabelValue(), null, "errorScale", null, 0, 1, StandardPopulationModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integrationLabelEClass, IntegrationLabel.class, "IntegrationLabel", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(integrationLabelValueEClass, IntegrationLabelValue.class, "IntegrationLabelValue", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(integrationDecoratorEClass, IntegrationDecorator.class, "IntegrationDecorator", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(populationModelLabelValueEClass, PopulationModelLabelValue.class, "PopulationModelLabelValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(standardPopulationModelLabelValueEClass, StandardPopulationModelLabelValue.class, "StandardPopulationModelLabelValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStandardPopulationModelLabelValue_Count(), theEcorePackage.getEDouble(), "count", null, 0, 1, StandardPopulationModelLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardPopulationModelLabelValue_Incidence(), theEcorePackage.getEDouble(), "incidence", null, 0, 1, StandardPopulationModelLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardPopulationModelLabelValue_Births(), theEcorePackage.getEDouble(), "births", null, 0, 1, StandardPopulationModelLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardPopulationModelLabelValue_Deaths(), theEcorePackage.getEDouble(), "deaths", null, 0, 1, StandardPopulationModelLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardPopulationModelLabelValue_Density(), theEcorePackage.getEDouble(), "density", "0.0", 0, 1, StandardPopulationModelLabelValue.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(standardPopulationModelLabelValueEClass, theEcorePackage.getEBoolean(), "adjustDelta", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntegrationLabelValue(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stochasticStandardPopulationModelEClass, StochasticStandardPopulationModel.class, "StochasticStandardPopulationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStochasticStandardPopulationModel_Gain(), theEcorePackage.getEDouble(), "gain", "0.01", 0, 1, StochasticStandardPopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(demographicPopulationModelEClass, DemographicPopulationModel.class, "DemographicPopulationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDemographicPopulationModel_PopulationGroups(), this.getPopulationGroup(), null, "populationGroups", null, 1, -1, DemographicPopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(populationGroupEClass, PopulationGroup.class, "PopulationGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPopulationGroup_Identifier(), theEcorePackage.getEString(), "identifier", null, 0, 1, PopulationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPopulationGroup_Fraction(), theEcorePackage.getEDouble(), "fraction", "0.5", 0, 1, PopulationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(populationInitializerEClass, PopulationInitializer.class, "PopulationInitializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPopulationInitializer_TargetISOKey(), theEcorePackage.getEString(), "targetISOKey", null, 0, 1, PopulationInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(standardPopulationInitializerEClass, StandardPopulationInitializer.class, "StandardPopulationInitializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStandardPopulationInitializer_Individuals(), theEcorePackage.getEDouble(), "individuals", "1", 0, 1, StandardPopulationInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardPopulationInitializer_UseDensity(), theEcorePackage.getEBoolean(), "useDensity", "false", 0, 1, StandardPopulationInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardPopulationInitializer_PopulationIdentifier(), theEcorePackage.getEString(), "populationIdentifier", "human", 0, 1, StandardPopulationInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(seasonalPopulationModelEClass, SeasonalPopulationModel.class, "SeasonalPopulationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSeasonalPopulationModel_Phase(), theEcorePackage.getEDouble(), "phase", "0.0", 0, 1, SeasonalPopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeasonalPopulationModel_ModulationAmplitude(), theEcorePackage.getEDouble(), "modulationAmplitude", "1.0", 0, 1, SeasonalPopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeasonalPopulationModel_Period(), theEcorePackage.getEDouble(), "period", "365.25", 0, 1, SeasonalPopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeasonalPopulationModel_UseLatitude(), theEcorePackage.getEBoolean(), "useLatitude", "true", 0, 1, SeasonalPopulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //StandardPackageImpl
