package org.eclipse.stem.tests.util.labels.impl;

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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.sequencer.SequencerPackage;
import org.eclipse.stem.core.solver.SolverPackage;
import org.eclipse.stem.tests.util.decorators.DecoratorsPackage;
import org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl;
import org.eclipse.stem.tests.util.labels.LabelsFactory;
import org.eclipse.stem.tests.util.labels.LabelsPackage;
import org.eclipse.stem.tests.util.labels.TestDynamicEdgeLabel;
import org.eclipse.stem.tests.util.labels.TestDynamicLabel1;
import org.eclipse.stem.tests.util.labels.TestDynamicNodeLabel;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;
import org.eclipse.stem.tests.util.labels.TestLabel;
import org.eclipse.stem.tests.util.labels.TestStaticEdgeLabel;
import org.eclipse.stem.tests.util.labels.TestStaticNodeLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LabelsPackageImpl extends EPackageImpl implements LabelsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testDynamicEdgeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testDynamicLabel1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testDynamicNodeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testIntegerLabelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testStaticEdgeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testStaticNodeLabelEClass = null;

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
	 * @see org.eclipse.stem.tests.util.labels.LabelsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LabelsPackageImpl() {
		super(eNS_URI, LabelsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LabelsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LabelsPackage init() {
		if (isInited) return (LabelsPackage)EPackage.Registry.INSTANCE.getEPackage(LabelsPackage.eNS_URI);

		// Obtain or create and register package
		LabelsPackageImpl theLabelsPackage = (LabelsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LabelsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LabelsPackageImpl());

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
		DecoratorsPackageImpl theDecoratorsPackage = (DecoratorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DecoratorsPackage.eNS_URI) instanceof DecoratorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DecoratorsPackage.eNS_URI) : DecoratorsPackage.eINSTANCE);

		// Create package meta-data objects
		theLabelsPackage.createPackageContents();
		theDecoratorsPackage.createPackageContents();

		// Initialize created meta-data
		theLabelsPackage.initializePackageContents();
		theDecoratorsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLabelsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LabelsPackage.eNS_URI, theLabelsPackage);
		return theLabelsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestDynamicEdgeLabel() {
		return testDynamicEdgeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestDynamicLabel1() {
		return testDynamicLabel1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestDynamicNodeLabel() {
		return testDynamicNodeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestIntegerLabelValue() {
		return testIntegerLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestIntegerLabelValue_I() {
		return (EAttribute)testIntegerLabelValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestLabel() {
		return testLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestStaticEdgeLabel() {
		return testStaticEdgeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestStaticNodeLabel() {
		return testStaticNodeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelsFactory getLabelsFactory() {
		return (LabelsFactory)getEFactoryInstance();
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
		testDynamicEdgeLabelEClass = createEClass(TEST_DYNAMIC_EDGE_LABEL);

		testDynamicLabel1EClass = createEClass(TEST_DYNAMIC_LABEL1);

		testDynamicNodeLabelEClass = createEClass(TEST_DYNAMIC_NODE_LABEL);

		testIntegerLabelValueEClass = createEClass(TEST_INTEGER_LABEL_VALUE);
		createEAttribute(testIntegerLabelValueEClass, TEST_INTEGER_LABEL_VALUE__I);

		testLabelEClass = createEClass(TEST_LABEL);

		testStaticEdgeLabelEClass = createEClass(TEST_STATIC_EDGE_LABEL);

		testStaticNodeLabelEClass = createEClass(TEST_STATIC_NODE_LABEL);
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
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		testDynamicEdgeLabelEClass.getESuperTypes().add(theGraphPackage.getDynamicEdgeLabel());
		testDynamicLabel1EClass.getESuperTypes().add(theGraphPackage.getDynamicLabel());
		testDynamicNodeLabelEClass.getESuperTypes().add(theGraphPackage.getDynamicNodeLabel());
		testIntegerLabelValueEClass.getESuperTypes().add(theGraphPackage.getLabelValue());
		testLabelEClass.getESuperTypes().add(theGraphPackage.getLabel());
		testStaticEdgeLabelEClass.getESuperTypes().add(theGraphPackage.getStaticEdgeLabel());
		testStaticNodeLabelEClass.getESuperTypes().add(theGraphPackage.getStaticNodeLabel());

		// Initialize classes and features; add operations and parameters
		initEClass(testDynamicEdgeLabelEClass, TestDynamicEdgeLabel.class, "TestDynamicEdgeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(testDynamicEdgeLabelEClass, null, "increment", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(testDynamicLabel1EClass, TestDynamicLabel1.class, "TestDynamicLabel1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(testDynamicLabel1EClass, null, "increment", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(testDynamicNodeLabelEClass, TestDynamicNodeLabel.class, "TestDynamicNodeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(testDynamicNodeLabelEClass, null, "increment", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(testIntegerLabelValueEClass, TestIntegerLabelValue.class, "TestIntegerLabelValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTestIntegerLabelValue_I(), ecorePackage.getEInt(), "i", null, 0, 1, TestIntegerLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(testIntegerLabelValueEClass, null, "increment", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(testLabelEClass, TestLabel.class, "TestLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(testStaticEdgeLabelEClass, TestStaticEdgeLabel.class, "TestStaticEdgeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(testStaticNodeLabelEClass, TestStaticNodeLabel.class, "TestStaticNodeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //LabelsPackageImpl
