package org.eclipse.stem.tests.util.labels;

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
import org.eclipse.stem.core.graph.GraphPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.tests.util.labels.LabelsFactory
 * @model kind="package"
 * @generated
 */
public interface LabelsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "labels"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/tests/util/labels.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.tests.util.labels"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LabelsPackage eINSTANCE = org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.labels.impl.TestDynamicEdgeLabelImpl <em>Test Dynamic Edge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.labels.impl.TestDynamicEdgeLabelImpl
	 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestDynamicEdgeLabel()
	 * @generated
	 */
	int TEST_DYNAMIC_EDGE_LABEL = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__URI = GraphPackage.DYNAMIC_EDGE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__TYPE_URI = GraphPackage.DYNAMIC_EDGE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__DUBLIN_CORE = GraphPackage.DYNAMIC_EDGE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.DYNAMIC_EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__CURRENT_VALUE = GraphPackage.DYNAMIC_EDGE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__IDENTIFIABLE = GraphPackage.DYNAMIC_EDGE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__NEXT_VALUE_VALID = GraphPackage.DYNAMIC_EDGE_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__NEXT_VALUE = GraphPackage.DYNAMIC_EDGE_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__DECORATOR = GraphPackage.DYNAMIC_EDGE_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL__EDGE = GraphPackage.DYNAMIC_EDGE_LABEL__EDGE;

	/**
	 * The number of structural features of the '<em>Test Dynamic Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_EDGE_LABEL_FEATURE_COUNT = GraphPackage.DYNAMIC_EDGE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.labels.impl.TestDynamicLabel1Impl <em>Test Dynamic Label1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.labels.impl.TestDynamicLabel1Impl
	 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestDynamicLabel1()
	 * @generated
	 */
	int TEST_DYNAMIC_LABEL1 = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1__URI = GraphPackage.DYNAMIC_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1__TYPE_URI = GraphPackage.DYNAMIC_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1__DUBLIN_CORE = GraphPackage.DYNAMIC_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.DYNAMIC_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1__CURRENT_VALUE = GraphPackage.DYNAMIC_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1__IDENTIFIABLE = GraphPackage.DYNAMIC_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1__NEXT_VALUE_VALID = GraphPackage.DYNAMIC_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1__NEXT_VALUE = GraphPackage.DYNAMIC_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1__DECORATOR = GraphPackage.DYNAMIC_LABEL__DECORATOR;

	/**
	 * The number of structural features of the '<em>Test Dynamic Label1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_LABEL1_FEATURE_COUNT = GraphPackage.DYNAMIC_LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.labels.impl.TestDynamicNodeLabelImpl <em>Test Dynamic Node Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.labels.impl.TestDynamicNodeLabelImpl
	 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestDynamicNodeLabel()
	 * @generated
	 */
	int TEST_DYNAMIC_NODE_LABEL = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__URI = GraphPackage.DYNAMIC_NODE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__TYPE_URI = GraphPackage.DYNAMIC_NODE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__DUBLIN_CORE = GraphPackage.DYNAMIC_NODE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.DYNAMIC_NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__CURRENT_VALUE = GraphPackage.DYNAMIC_NODE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__IDENTIFIABLE = GraphPackage.DYNAMIC_NODE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__NEXT_VALUE_VALID = GraphPackage.DYNAMIC_NODE_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__NEXT_VALUE = GraphPackage.DYNAMIC_NODE_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__DECORATOR = GraphPackage.DYNAMIC_NODE_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL__NODE = GraphPackage.DYNAMIC_NODE_LABEL__NODE;

	/**
	 * The number of structural features of the '<em>Test Dynamic Node Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DYNAMIC_NODE_LABEL_FEATURE_COUNT = GraphPackage.DYNAMIC_NODE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.labels.impl.TestIntegerLabelValueImpl <em>Test Integer Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.labels.impl.TestIntegerLabelValueImpl
	 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestIntegerLabelValue()
	 * @generated
	 */
	int TEST_INTEGER_LABEL_VALUE = 3;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_INTEGER_LABEL_VALUE__I = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Integer Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_INTEGER_LABEL_VALUE_FEATURE_COUNT = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.labels.impl.TestLabelImpl <em>Test Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.labels.impl.TestLabelImpl
	 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestLabel()
	 * @generated
	 */
	int TEST_LABEL = 4;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LABEL__URI = GraphPackage.LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LABEL__TYPE_URI = GraphPackage.LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LABEL__DUBLIN_CORE = GraphPackage.LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LABEL__CURRENT_VALUE = GraphPackage.LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LABEL__IDENTIFIABLE = GraphPackage.LABEL__IDENTIFIABLE;

	/**
	 * The number of structural features of the '<em>Test Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LABEL_FEATURE_COUNT = GraphPackage.LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.labels.impl.TestStaticEdgeLabelImpl <em>Test Static Edge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.labels.impl.TestStaticEdgeLabelImpl
	 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestStaticEdgeLabel()
	 * @generated
	 */
	int TEST_STATIC_EDGE_LABEL = 5;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_EDGE_LABEL__URI = GraphPackage.STATIC_EDGE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_EDGE_LABEL__TYPE_URI = GraphPackage.STATIC_EDGE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_EDGE_LABEL__DUBLIN_CORE = GraphPackage.STATIC_EDGE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.STATIC_EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_EDGE_LABEL__CURRENT_VALUE = GraphPackage.STATIC_EDGE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_EDGE_LABEL__IDENTIFIABLE = GraphPackage.STATIC_EDGE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_EDGE_LABEL__EDGE = GraphPackage.STATIC_EDGE_LABEL__EDGE;

	/**
	 * The number of structural features of the '<em>Test Static Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_EDGE_LABEL_FEATURE_COUNT = GraphPackage.STATIC_EDGE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.labels.impl.TestStaticNodeLabelImpl <em>Test Static Node Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.labels.impl.TestStaticNodeLabelImpl
	 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestStaticNodeLabel()
	 * @generated
	 */
	int TEST_STATIC_NODE_LABEL = 6;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_NODE_LABEL__URI = GraphPackage.STATIC_NODE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_NODE_LABEL__TYPE_URI = GraphPackage.STATIC_NODE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_NODE_LABEL__DUBLIN_CORE = GraphPackage.STATIC_NODE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.STATIC_NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_NODE_LABEL__CURRENT_VALUE = GraphPackage.STATIC_NODE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_NODE_LABEL__IDENTIFIABLE = GraphPackage.STATIC_NODE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_NODE_LABEL__NODE = GraphPackage.STATIC_NODE_LABEL__NODE;

	/**
	 * The number of structural features of the '<em>Test Static Node Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATIC_NODE_LABEL_FEATURE_COUNT = GraphPackage.STATIC_NODE_LABEL_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.labels.TestDynamicEdgeLabel <em>Test Dynamic Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Dynamic Edge Label</em>'.
	 * @see org.eclipse.stem.tests.util.labels.TestDynamicEdgeLabel
	 * @generated
	 */
	EClass getTestDynamicEdgeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.labels.TestDynamicLabel1 <em>Test Dynamic Label1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Dynamic Label1</em>'.
	 * @see org.eclipse.stem.tests.util.labels.TestDynamicLabel1
	 * @generated
	 */
	EClass getTestDynamicLabel1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.labels.TestDynamicNodeLabel <em>Test Dynamic Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Dynamic Node Label</em>'.
	 * @see org.eclipse.stem.tests.util.labels.TestDynamicNodeLabel
	 * @generated
	 */
	EClass getTestDynamicNodeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.labels.TestIntegerLabelValue <em>Test Integer Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Integer Label Value</em>'.
	 * @see org.eclipse.stem.tests.util.labels.TestIntegerLabelValue
	 * @generated
	 */
	EClass getTestIntegerLabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.tests.util.labels.TestIntegerLabelValue#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>I</em>'.
	 * @see org.eclipse.stem.tests.util.labels.TestIntegerLabelValue#getI()
	 * @see #getTestIntegerLabelValue()
	 * @generated
	 */
	EAttribute getTestIntegerLabelValue_I();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.labels.TestLabel <em>Test Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Label</em>'.
	 * @see org.eclipse.stem.tests.util.labels.TestLabel
	 * @generated
	 */
	EClass getTestLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.labels.TestStaticEdgeLabel <em>Test Static Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Static Edge Label</em>'.
	 * @see org.eclipse.stem.tests.util.labels.TestStaticEdgeLabel
	 * @generated
	 */
	EClass getTestStaticEdgeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.labels.TestStaticNodeLabel <em>Test Static Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Static Node Label</em>'.
	 * @see org.eclipse.stem.tests.util.labels.TestStaticNodeLabel
	 * @generated
	 */
	EClass getTestStaticNodeLabel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LabelsFactory getLabelsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.labels.impl.TestDynamicEdgeLabelImpl <em>Test Dynamic Edge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.labels.impl.TestDynamicEdgeLabelImpl
		 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestDynamicEdgeLabel()
		 * @generated
		 */
		EClass TEST_DYNAMIC_EDGE_LABEL = eINSTANCE.getTestDynamicEdgeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.labels.impl.TestDynamicLabel1Impl <em>Test Dynamic Label1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.labels.impl.TestDynamicLabel1Impl
		 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestDynamicLabel1()
		 * @generated
		 */
		EClass TEST_DYNAMIC_LABEL1 = eINSTANCE.getTestDynamicLabel1();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.labels.impl.TestDynamicNodeLabelImpl <em>Test Dynamic Node Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.labels.impl.TestDynamicNodeLabelImpl
		 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestDynamicNodeLabel()
		 * @generated
		 */
		EClass TEST_DYNAMIC_NODE_LABEL = eINSTANCE.getTestDynamicNodeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.labels.impl.TestIntegerLabelValueImpl <em>Test Integer Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.labels.impl.TestIntegerLabelValueImpl
		 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestIntegerLabelValue()
		 * @generated
		 */
		EClass TEST_INTEGER_LABEL_VALUE = eINSTANCE.getTestIntegerLabelValue();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_INTEGER_LABEL_VALUE__I = eINSTANCE.getTestIntegerLabelValue_I();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.labels.impl.TestLabelImpl <em>Test Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.labels.impl.TestLabelImpl
		 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestLabel()
		 * @generated
		 */
		EClass TEST_LABEL = eINSTANCE.getTestLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.labels.impl.TestStaticEdgeLabelImpl <em>Test Static Edge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.labels.impl.TestStaticEdgeLabelImpl
		 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestStaticEdgeLabel()
		 * @generated
		 */
		EClass TEST_STATIC_EDGE_LABEL = eINSTANCE.getTestStaticEdgeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.labels.impl.TestStaticNodeLabelImpl <em>Test Static Node Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.labels.impl.TestStaticNodeLabelImpl
		 * @see org.eclipse.stem.tests.util.labels.impl.LabelsPackageImpl#getTestStaticNodeLabel()
		 * @generated
		 */
		EClass TEST_STATIC_NODE_LABEL = eINSTANCE.getTestStaticNodeLabel();

	}

} //LabelsPackage
