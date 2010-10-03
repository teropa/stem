package org.eclipse.stem.tests.util.decorators.impl;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.EdgeDecorator;
import org.eclipse.stem.core.model.GraphDecorator;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.sequencer.SequencerPackage;
import org.eclipse.stem.core.solver.SolverPackage;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.DecoratorsPackage;
import org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1;
import org.eclipse.stem.tests.util.decorators.TestGraphDecorator1;
import org.eclipse.stem.tests.util.decorators.TestNodeDecorator1;
import org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1;
import org.eclipse.stem.tests.util.labels.LabelsPackage;
import org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DecoratorsPackageImpl extends EPackageImpl implements DecoratorsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testEdgeDecorator1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testGraphDecorator1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testNodeDecorator1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testScenarioGraphDecorator1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

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
	 * @see org.eclipse.stem.tests.util.decorators.DecoratorsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DecoratorsPackageImpl() {
		super(eNS_URI, DecoratorsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DecoratorsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DecoratorsPackage init() {
		if (isInited) return (DecoratorsPackage)EPackage.Registry.INSTANCE.getEPackage(DecoratorsPackage.eNS_URI);

		// Obtain or create and register package
		DecoratorsPackageImpl theDecoratorsPackage = (DecoratorsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DecoratorsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DecoratorsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();
		GraphPackage.eINSTANCE.eClass();
		ModifierPackage.eINSTANCE.eClass();
		ScenarioPackage.eINSTANCE.eClass();
		SequencerPackage.eINSTANCE.eClass();
		SolverPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		LabelsPackageImpl theLabelsPackage = (LabelsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LabelsPackage.eNS_URI) instanceof LabelsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LabelsPackage.eNS_URI) : LabelsPackage.eINSTANCE);

		// Create package meta-data objects
		theDecoratorsPackage.createPackageContents();
		theLabelsPackage.createPackageContents();

		// Initialize created meta-data
		theDecoratorsPackage.initializePackageContents();
		theLabelsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDecoratorsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DecoratorsPackage.eNS_URI, theDecoratorsPackage);
		return theDecoratorsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestEdgeDecorator1() {
		return testEdgeDecorator1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestEdgeDecorator1_NodeAURI() {
		return (EAttribute)testEdgeDecorator1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestEdgeDecorator1_NodeBURI() {
		return (EAttribute)testEdgeDecorator1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestEdgeDecorator1_EdgeURI() {
		return (EAttribute)testEdgeDecorator1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestGraphDecorator1() {
		return testGraphDecorator1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestNodeDecorator1() {
		return testNodeDecorator1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestScenarioGraphDecorator1() {
		return testScenarioGraphDecorator1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestScenarioGraphDecorator1_DoubleValue() {
		return (EAttribute)testScenarioGraphDecorator1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestScenarioGraphDecorator1_IntValue() {
		return (EAttribute)testScenarioGraphDecorator1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestScenarioGraphDecorator1_StringValue() {
		return (EAttribute)testScenarioGraphDecorator1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestScenarioGraphDecorator1_STEMTimeValue() {
		return (EReference)testScenarioGraphDecorator1EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestScenarioGraphDecorator1_BooleanValue() {
		return (EAttribute)testScenarioGraphDecorator1EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeDecorator() {
		return edgeDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphDecorator() {
		return graphDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeDecorator() {
		return nodeDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecoratorsFactory getDecoratorsFactory() {
		return (DecoratorsFactory)getEFactoryInstance();
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
		testEdgeDecorator1EClass = createEClass(TEST_EDGE_DECORATOR1);
		createEAttribute(testEdgeDecorator1EClass, TEST_EDGE_DECORATOR1__NODE_AURI);
		createEAttribute(testEdgeDecorator1EClass, TEST_EDGE_DECORATOR1__NODE_BURI);
		createEAttribute(testEdgeDecorator1EClass, TEST_EDGE_DECORATOR1__EDGE_URI);

		testGraphDecorator1EClass = createEClass(TEST_GRAPH_DECORATOR1);

		testNodeDecorator1EClass = createEClass(TEST_NODE_DECORATOR1);

		testScenarioGraphDecorator1EClass = createEClass(TEST_SCENARIO_GRAPH_DECORATOR1);
		createEAttribute(testScenarioGraphDecorator1EClass, TEST_SCENARIO_GRAPH_DECORATOR1__DOUBLE_VALUE);
		createEAttribute(testScenarioGraphDecorator1EClass, TEST_SCENARIO_GRAPH_DECORATOR1__INT_VALUE);
		createEAttribute(testScenarioGraphDecorator1EClass, TEST_SCENARIO_GRAPH_DECORATOR1__STRING_VALUE);
		createEReference(testScenarioGraphDecorator1EClass, TEST_SCENARIO_GRAPH_DECORATOR1__STEM_TIME_VALUE);
		createEAttribute(testScenarioGraphDecorator1EClass, TEST_SCENARIO_GRAPH_DECORATOR1__BOOLEAN_VALUE);

		edgeDecoratorEClass = createEClass(EDGE_DECORATOR);

		graphDecoratorEClass = createEClass(GRAPH_DECORATOR);

		nodeDecoratorEClass = createEClass(NODE_DECORATOR);

		// Create data types
		uriEDataType = createEDataType(URI);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		testEdgeDecorator1EClass.getESuperTypes().add(theModelPackage.getEdgeDecorator());
		testGraphDecorator1EClass.getESuperTypes().add(theModelPackage.getGraphDecorator());
		testNodeDecorator1EClass.getESuperTypes().add(theModelPackage.getNodeDecorator());
		testScenarioGraphDecorator1EClass.getESuperTypes().add(theModelPackage.getGraphDecorator());

		// Initialize classes and features; add operations and parameters
		initEClass(testEdgeDecorator1EClass, TestEdgeDecorator1.class, "TestEdgeDecorator1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTestEdgeDecorator1_NodeAURI(), this.getURI(), "nodeAURI", null, 0, 1, TestEdgeDecorator1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTestEdgeDecorator1_NodeBURI(), this.getURI(), "nodeBURI", null, 0, 1, TestEdgeDecorator1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTestEdgeDecorator1_EdgeURI(), this.getURI(), "edgeURI", null, 0, 1, TestEdgeDecorator1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(testGraphDecorator1EClass, TestGraphDecorator1.class, "TestGraphDecorator1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(testNodeDecorator1EClass, TestNodeDecorator1.class, "TestNodeDecorator1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(testScenarioGraphDecorator1EClass, TestScenarioGraphDecorator1.class, "TestScenarioGraphDecorator1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTestScenarioGraphDecorator1_DoubleValue(), ecorePackage.getEDouble(), "doubleValue", null, 0, 1, TestScenarioGraphDecorator1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTestScenarioGraphDecorator1_IntValue(), ecorePackage.getEInt(), "intValue", null, 0, 1, TestScenarioGraphDecorator1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTestScenarioGraphDecorator1_StringValue(), ecorePackage.getEString(), "stringValue", null, 0, 1, TestScenarioGraphDecorator1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTestScenarioGraphDecorator1_STEMTimeValue(), theModelPackage.getSTEMTime(), null, "sTEMTimeValue", null, 0, 1, TestScenarioGraphDecorator1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTestScenarioGraphDecorator1_BooleanValue(), ecorePackage.getEBoolean(), "booleanValue", null, 0, 1, TestScenarioGraphDecorator1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(edgeDecoratorEClass, EdgeDecorator.class, "EdgeDecorator", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(graphDecoratorEClass, GraphDecorator.class, "GraphDecorator", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nodeDecoratorEClass, NodeDecorator.class, "NodeDecorator", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //DecoratorsPackageImpl
