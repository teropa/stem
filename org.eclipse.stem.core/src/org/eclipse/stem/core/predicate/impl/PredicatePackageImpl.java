package org.eclipse.stem.core.predicate.impl;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
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

import org.eclipse.stem.core.common.CommonPackage;

import org.eclipse.stem.core.common.impl.CommonPackageImpl;

import org.eclipse.stem.core.experiment.ExperimentPackage;

import org.eclipse.stem.core.experiment.impl.ExperimentPackageImpl;

import org.eclipse.stem.core.graph.GraphPackage;

import org.eclipse.stem.core.graph.impl.GraphPackageImpl;

import org.eclipse.stem.core.model.ModelPackage;

import org.eclipse.stem.core.model.impl.ModelPackageImpl;

import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.impl.ModifierPackageImpl;
import org.eclipse.stem.core.predicate.AbsoluteTimeTest;
import org.eclipse.stem.core.predicate.And;
import org.eclipse.stem.core.predicate.BooleanExpression;
import org.eclipse.stem.core.predicate.BooleanOperator;
import org.eclipse.stem.core.predicate.ElapsedTimeTest;
import org.eclipse.stem.core.predicate.False;
import org.eclipse.stem.core.predicate.IdentifiablePredicate;
import org.eclipse.stem.core.predicate.IdentifiablePredicateExpression;
import org.eclipse.stem.core.predicate.IdentifiableTest;
import org.eclipse.stem.core.predicate.NaryBooleanOperator;
import org.eclipse.stem.core.predicate.Not;
import org.eclipse.stem.core.predicate.Or;
import org.eclipse.stem.core.predicate.Predicate;
import org.eclipse.stem.core.predicate.PredicateExpression;
import org.eclipse.stem.core.predicate.PredicateFactory;
import org.eclipse.stem.core.predicate.PredicatePackage;
import org.eclipse.stem.core.predicate.PredicateReference;
import org.eclipse.stem.core.predicate.Test;
import org.eclipse.stem.core.predicate.TimeTest;
import org.eclipse.stem.core.predicate.True;
import org.eclipse.stem.core.predicate.UnaryBooleanOperator;

import org.eclipse.stem.core.scenario.ScenarioPackage;

import org.eclipse.stem.core.scenario.impl.ScenarioPackageImpl;

import org.eclipse.stem.core.sequencer.SequencerPackage;

import org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl;

import org.eclipse.stem.core.simulation.SimulationPackage;
import org.eclipse.stem.core.simulation.impl.SimulationPackageImpl;
import org.eclipse.stem.core.solver.SolverPackage;
import org.eclipse.stem.core.solver.impl.SolverPackageImpl;
import org.eclipse.stem.core.trigger.TriggerPackage;

import org.eclipse.stem.core.trigger.impl.TriggerPackageImpl;
import simulation.SimulationPackage;
import simulation.impl.SimulationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PredicatePackageImpl extends EPackageImpl implements PredicatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass naryBooleanOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryBooleanOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiablePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiablePredicateExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass absoluteTimeTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elapsedTimeTestEClass = null;

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
	 * @see org.eclipse.stem.core.predicate.PredicatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PredicatePackageImpl() {
		super(eNS_URI, PredicateFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PredicatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PredicatePackage init() {
		if (isInited) return (PredicatePackage)EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI);

		// Obtain or create and register package
		PredicatePackageImpl thePredicatePackage = (PredicatePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PredicatePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PredicatePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SimulationPackageImpl theSimulationPackage = (SimulationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimulationPackage.eNS_URI) instanceof SimulationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimulationPackage.eNS_URI) : SimulationPackage.eINSTANCE);
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		ExperimentPackageImpl theExperimentPackage = (ExperimentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) instanceof ExperimentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) : ExperimentPackage.eINSTANCE);
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		ScenarioPackageImpl theScenarioPackage = (ScenarioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) instanceof ScenarioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) : ScenarioPackage.eINSTANCE);
		SequencerPackageImpl theSequencerPackage = (SequencerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) instanceof SequencerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) : SequencerPackage.eINSTANCE);
		SolverPackageImpl theSolverPackage = (SolverPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) instanceof SolverPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) : SolverPackage.eINSTANCE);
		TriggerPackageImpl theTriggerPackage = (TriggerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) instanceof TriggerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) : TriggerPackage.eINSTANCE);

		// Create package meta-data objects
		thePredicatePackage.createPackageContents();
		theSimulationPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theExperimentPackage.createPackageContents();
		theGraphPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		theScenarioPackage.createPackageContents();
		theSequencerPackage.createPackageContents();
		theSolverPackage.createPackageContents();
		theTriggerPackage.createPackageContents();

		// Initialize created meta-data
		thePredicatePackage.initializePackageContents();
		theSimulationPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theExperimentPackage.initializePackageContents();
		theGraphPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		theScenarioPackage.initializePackageContents();
		theSequencerPackage.initializePackageContents();
		theSolverPackage.initializePackageContents();
		theTriggerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePredicatePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PredicatePackage.eNS_URI, thePredicatePackage);
		return thePredicatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanExpression() {
		return booleanExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanOperator() {
		return booleanOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFalse() {
		return falseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNaryBooleanOperator() {
		return naryBooleanOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNaryBooleanOperator_Operands() {
		return (EReference)naryBooleanOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNot() {
		return notEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOr() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredicate() {
		return predicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredicateReference() {
		return predicateReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicateReference_Predicate() {
		return (EReference)predicateReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTest() {
		return testEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrue() {
		return trueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryBooleanOperator() {
		return unaryBooleanOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryBooleanOperator_Operand() {
		return (EReference)unaryBooleanOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredicateExpression() {
		return predicateExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicateExpression_Predicate() {
		return (EReference)predicateExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiablePredicate() {
		return identifiablePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiablePredicateExpression() {
		return identifiablePredicateExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiableTest() {
		return identifiableTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeTest() {
		return timeTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbsoluteTimeTest() {
		return absoluteTimeTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbsoluteTimeTest_Time() {
		return (EReference)absoluteTimeTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElapsedTimeTest() {
		return elapsedTimeTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElapsedTimeTest_ReferenceTimeValid() {
		return (EAttribute)elapsedTimeTestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElapsedTimeTest_ElapsedMilliseconds() {
		return (EAttribute)elapsedTimeTestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElapsedTimeTest_NumberofDays() {
		return (EAttribute)elapsedTimeTestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElapsedTimeTest_ReferenceTime() {
		return (EReference)elapsedTimeTestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateFactory getPredicateFactory() {
		return (PredicateFactory)getEFactoryInstance();
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
		andEClass = createEClass(AND);

		booleanExpressionEClass = createEClass(BOOLEAN_EXPRESSION);

		booleanOperatorEClass = createEClass(BOOLEAN_OPERATOR);

		falseEClass = createEClass(FALSE);

		naryBooleanOperatorEClass = createEClass(NARY_BOOLEAN_OPERATOR);
		createEReference(naryBooleanOperatorEClass, NARY_BOOLEAN_OPERATOR__OPERANDS);

		notEClass = createEClass(NOT);

		orEClass = createEClass(OR);

		predicateEClass = createEClass(PREDICATE);

		predicateReferenceEClass = createEClass(PREDICATE_REFERENCE);
		createEReference(predicateReferenceEClass, PREDICATE_REFERENCE__PREDICATE);

		testEClass = createEClass(TEST);

		trueEClass = createEClass(TRUE);

		unaryBooleanOperatorEClass = createEClass(UNARY_BOOLEAN_OPERATOR);
		createEReference(unaryBooleanOperatorEClass, UNARY_BOOLEAN_OPERATOR__OPERAND);

		predicateExpressionEClass = createEClass(PREDICATE_EXPRESSION);
		createEReference(predicateExpressionEClass, PREDICATE_EXPRESSION__PREDICATE);

		identifiablePredicateEClass = createEClass(IDENTIFIABLE_PREDICATE);

		identifiablePredicateExpressionEClass = createEClass(IDENTIFIABLE_PREDICATE_EXPRESSION);

		identifiableTestEClass = createEClass(IDENTIFIABLE_TEST);

		timeTestEClass = createEClass(TIME_TEST);

		absoluteTimeTestEClass = createEClass(ABSOLUTE_TIME_TEST);
		createEReference(absoluteTimeTestEClass, ABSOLUTE_TIME_TEST__TIME);

		elapsedTimeTestEClass = createEClass(ELAPSED_TIME_TEST);
		createEAttribute(elapsedTimeTestEClass, ELAPSED_TIME_TEST__REFERENCE_TIME_VALID);
		createEAttribute(elapsedTimeTestEClass, ELAPSED_TIME_TEST__ELAPSED_MILLISECONDS);
		createEAttribute(elapsedTimeTestEClass, ELAPSED_TIME_TEST__NUMBEROF_DAYS);
		createEReference(elapsedTimeTestEClass, ELAPSED_TIME_TEST__REFERENCE_TIME);
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
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		andEClass.getESuperTypes().add(this.getNaryBooleanOperator());
		booleanExpressionEClass.getESuperTypes().add(this.getPredicate());
		booleanOperatorEClass.getESuperTypes().add(this.getBooleanExpression());
		falseEClass.getESuperTypes().add(this.getTest());
		naryBooleanOperatorEClass.getESuperTypes().add(this.getBooleanOperator());
		notEClass.getESuperTypes().add(this.getUnaryBooleanOperator());
		orEClass.getESuperTypes().add(this.getNaryBooleanOperator());
		predicateReferenceEClass.getESuperTypes().add(this.getPredicate());
		testEClass.getESuperTypes().add(this.getPredicate());
		trueEClass.getESuperTypes().add(this.getTest());
		unaryBooleanOperatorEClass.getESuperTypes().add(this.getBooleanOperator());
		predicateExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
		identifiablePredicateEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());
		identifiablePredicateEClass.getESuperTypes().add(this.getPredicate());
		identifiablePredicateExpressionEClass.getESuperTypes().add(this.getIdentifiablePredicate());
		identifiablePredicateExpressionEClass.getESuperTypes().add(this.getPredicateExpression());
		identifiableTestEClass.getESuperTypes().add(this.getIdentifiablePredicate());
		identifiableTestEClass.getESuperTypes().add(this.getTest());
		timeTestEClass.getESuperTypes().add(this.getTest());
		absoluteTimeTestEClass.getESuperTypes().add(this.getTimeTest());
		elapsedTimeTestEClass.getESuperTypes().add(this.getTimeTest());

		// Initialize classes and features; add operations and parameters
		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(booleanExpressionEClass, BooleanExpression.class, "BooleanExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(booleanOperatorEClass, BooleanOperator.class, "BooleanOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(falseEClass, False.class, "False", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(naryBooleanOperatorEClass, NaryBooleanOperator.class, "NaryBooleanOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNaryBooleanOperator_Operands(), this.getPredicate(), null, "operands", null, 0, -1, NaryBooleanOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(notEClass, Not.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(predicateEClass, Predicate.class, "Predicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		EOperation op = addEOperation(predicateEClass, ecorePackage.getEBoolean(), "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theModelPackage.getSTEMTime(), "time", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getELong(), "timerPeriod", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theModelPackage.getDecorator(), "action", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(predicateReferenceEClass, PredicateReference.class, "PredicateReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPredicateReference_Predicate(), this.getPredicate(), null, "predicate", null, 0, 1, PredicateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(testEClass, Test.class, "Test", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(trueEClass, True.class, "True", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(unaryBooleanOperatorEClass, UnaryBooleanOperator.class, "UnaryBooleanOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getUnaryBooleanOperator_Operand(), this.getPredicate(), null, "operand", null, 0, 1, UnaryBooleanOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(predicateExpressionEClass, PredicateExpression.class, "PredicateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPredicateExpression_Predicate(), this.getPredicate(), null, "predicate", null, 0, 1, PredicateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(identifiablePredicateEClass, IdentifiablePredicate.class, "IdentifiablePredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(identifiablePredicateExpressionEClass, IdentifiablePredicateExpression.class, "IdentifiablePredicateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(identifiableTestEClass, IdentifiableTest.class, "IdentifiableTest", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(timeTestEClass, TimeTest.class, "TimeTest", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(absoluteTimeTestEClass, AbsoluteTimeTest.class, "AbsoluteTimeTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbsoluteTimeTest_Time(), theModelPackage.getSTEMTime(), null, "time", null, 0, 1, AbsoluteTimeTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(elapsedTimeTestEClass, ElapsedTimeTest.class, "ElapsedTimeTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getElapsedTimeTest_ReferenceTimeValid(), ecorePackage.getEBoolean(), "referenceTimeValid", "false", 0, 1, ElapsedTimeTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getElapsedTimeTest_ElapsedMilliseconds(), ecorePackage.getELong(), "elapsedMilliseconds", null, 0, 1, ElapsedTimeTest.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getElapsedTimeTest_NumberofDays(), ecorePackage.getEInt(), "numberofDays", "0", 0, 1, ElapsedTimeTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getElapsedTimeTest_ReferenceTime(), theModelPackage.getSTEMTime(), null, "referenceTime", null, 0, 1, ElapsedTimeTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //PredicatePackageImpl
