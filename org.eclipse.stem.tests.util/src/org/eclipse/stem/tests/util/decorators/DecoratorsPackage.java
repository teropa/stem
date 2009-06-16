package org.eclipse.stem.tests.util.decorators;

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
import org.eclipse.stem.core.model.ModelPackage;

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
 * @see org.eclipse.stem.tests.util.decorators.DecoratorsFactory
 * @model kind="package"
 * @generated
 */
public interface DecoratorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "decorators"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/tests/util/decorators.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.tests.util.decorators"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DecoratorsPackage eINSTANCE = org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.EdgeDecorator <em>Edge Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.EdgeDecorator
	 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getEdgeDecorator()
	 * @generated
	 */
	int EDGE_DECORATOR = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.decorators.impl.TestEdgeDecorator1Impl <em>Test Edge Decorator1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.decorators.impl.TestEdgeDecorator1Impl
	 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getTestEdgeDecorator1()
	 * @generated
	 */
	int TEST_EDGE_DECORATOR1 = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__URI = ModelPackage.EDGE_DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__TYPE_URI = ModelPackage.EDGE_DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__DUBLIN_CORE = ModelPackage.EDGE_DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__LABELS_TO_UPDATE = ModelPackage.EDGE_DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__GRAPH = ModelPackage.EDGE_DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__ENABLED = ModelPackage.EDGE_DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__GRAPH_DECORATED = ModelPackage.EDGE_DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Node AURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__NODE_AURI = ModelPackage.EDGE_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node BURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__NODE_BURI = ModelPackage.EDGE_DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Edge URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1__EDGE_URI = ModelPackage.EDGE_DECORATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Test Edge Decorator1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDGE_DECORATOR1_FEATURE_COUNT = ModelPackage.EDGE_DECORATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.GraphDecorator <em>Graph Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.GraphDecorator
	 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getGraphDecorator()
	 * @generated
	 */
	int GRAPH_DECORATOR = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.decorators.impl.TestGraphDecorator1Impl <em>Test Graph Decorator1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.decorators.impl.TestGraphDecorator1Impl
	 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getTestGraphDecorator1()
	 * @generated
	 */
	int TEST_GRAPH_DECORATOR1 = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRAPH_DECORATOR1__URI = ModelPackage.GRAPH_DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRAPH_DECORATOR1__TYPE_URI = ModelPackage.GRAPH_DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRAPH_DECORATOR1__DUBLIN_CORE = ModelPackage.GRAPH_DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRAPH_DECORATOR1__LABELS_TO_UPDATE = ModelPackage.GRAPH_DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRAPH_DECORATOR1__GRAPH = ModelPackage.GRAPH_DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRAPH_DECORATOR1__ENABLED = ModelPackage.GRAPH_DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRAPH_DECORATOR1__GRAPH_DECORATED = ModelPackage.GRAPH_DECORATOR__GRAPH_DECORATED;

	/**
	 * The number of structural features of the '<em>Test Graph Decorator1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRAPH_DECORATOR1_FEATURE_COUNT = ModelPackage.GRAPH_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.NodeDecorator <em>Node Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.NodeDecorator
	 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getNodeDecorator()
	 * @generated
	 */
	int NODE_DECORATOR = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.decorators.impl.TestNodeDecorator1Impl <em>Test Node Decorator1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.decorators.impl.TestNodeDecorator1Impl
	 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getTestNodeDecorator1()
	 * @generated
	 */
	int TEST_NODE_DECORATOR1 = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_NODE_DECORATOR1__URI = ModelPackage.NODE_DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_NODE_DECORATOR1__TYPE_URI = ModelPackage.NODE_DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_NODE_DECORATOR1__DUBLIN_CORE = ModelPackage.NODE_DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_NODE_DECORATOR1__LABELS_TO_UPDATE = ModelPackage.NODE_DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_NODE_DECORATOR1__GRAPH = ModelPackage.NODE_DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_NODE_DECORATOR1__ENABLED = ModelPackage.NODE_DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_NODE_DECORATOR1__GRAPH_DECORATED = ModelPackage.NODE_DECORATOR__GRAPH_DECORATED;

	/**
	 * The number of structural features of the '<em>Test Node Decorator1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_NODE_DECORATOR1_FEATURE_COUNT = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.tests.util.decorators.impl.TestScenarioGraphDecorator1Impl <em>Test Scenario Graph Decorator1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.tests.util.decorators.impl.TestScenarioGraphDecorator1Impl
	 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getTestScenarioGraphDecorator1()
	 * @generated
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1 = 3;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__URI = ModelPackage.GRAPH_DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__TYPE_URI = ModelPackage.GRAPH_DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__DUBLIN_CORE = ModelPackage.GRAPH_DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__LABELS_TO_UPDATE = ModelPackage.GRAPH_DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__GRAPH = ModelPackage.GRAPH_DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__ENABLED = ModelPackage.GRAPH_DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__GRAPH_DECORATED = ModelPackage.GRAPH_DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Double Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__DOUBLE_VALUE = ModelPackage.GRAPH_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Int Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__INT_VALUE = ModelPackage.GRAPH_DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__STRING_VALUE = ModelPackage.GRAPH_DECORATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>STEM Time Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__STEM_TIME_VALUE = ModelPackage.GRAPH_DECORATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Boolean Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1__BOOLEAN_VALUE = ModelPackage.GRAPH_DECORATOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Test Scenario Graph Decorator1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SCENARIO_GRAPH_DECORATOR1_FEATURE_COUNT = ModelPackage.GRAPH_DECORATOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Edge Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Graph Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Node Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getURI()
	 * @generated
	 */
	int URI = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1 <em>Test Edge Decorator1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Edge Decorator1</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1
	 * @generated
	 */
	EClass getTestEdgeDecorator1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1#getNodeAURI <em>Node AURI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node AURI</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1#getNodeAURI()
	 * @see #getTestEdgeDecorator1()
	 * @generated
	 */
	EAttribute getTestEdgeDecorator1_NodeAURI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1#getNodeBURI <em>Node BURI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node BURI</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1#getNodeBURI()
	 * @see #getTestEdgeDecorator1()
	 * @generated
	 */
	EAttribute getTestEdgeDecorator1_NodeBURI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1#getEdgeURI <em>Edge URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edge URI</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1#getEdgeURI()
	 * @see #getTestEdgeDecorator1()
	 * @generated
	 */
	EAttribute getTestEdgeDecorator1_EdgeURI();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.decorators.TestGraphDecorator1 <em>Test Graph Decorator1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Graph Decorator1</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestGraphDecorator1
	 * @generated
	 */
	EClass getTestGraphDecorator1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.decorators.TestNodeDecorator1 <em>Test Node Decorator1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Node Decorator1</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestNodeDecorator1
	 * @generated
	 */
	EClass getTestNodeDecorator1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1 <em>Test Scenario Graph Decorator1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Scenario Graph Decorator1</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1
	 * @generated
	 */
	EClass getTestScenarioGraphDecorator1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getDoubleValue <em>Double Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Value</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getDoubleValue()
	 * @see #getTestScenarioGraphDecorator1()
	 * @generated
	 */
	EAttribute getTestScenarioGraphDecorator1_DoubleValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getIntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Int Value</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getIntValue()
	 * @see #getTestScenarioGraphDecorator1()
	 * @generated
	 */
	EAttribute getTestScenarioGraphDecorator1_IntValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getStringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Value</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getStringValue()
	 * @see #getTestScenarioGraphDecorator1()
	 * @generated
	 */
	EAttribute getTestScenarioGraphDecorator1_StringValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getSTEMTimeValue <em>STEM Time Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STEM Time Value</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getSTEMTimeValue()
	 * @see #getTestScenarioGraphDecorator1()
	 * @generated
	 */
	EReference getTestScenarioGraphDecorator1_STEMTimeValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#isBooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Value</em>'.
	 * @see org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#isBooleanValue()
	 * @see #getTestScenarioGraphDecorator1()
	 * @generated
	 */
	EAttribute getTestScenarioGraphDecorator1_BooleanValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.EdgeDecorator <em>Edge Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Decorator</em>'.
	 * @see org.eclipse.stem.core.model.EdgeDecorator
	 * @model instanceClass="org.eclipse.stem.core.model.EdgeDecorator"
	 * @generated
	 */
	EClass getEdgeDecorator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.GraphDecorator <em>Graph Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Decorator</em>'.
	 * @see org.eclipse.stem.core.model.GraphDecorator
	 * @model instanceClass="org.eclipse.stem.core.model.GraphDecorator"
	 * @generated
	 */
	EClass getGraphDecorator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.NodeDecorator <em>Node Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Decorator</em>'.
	 * @see org.eclipse.stem.core.model.NodeDecorator
	 * @model instanceClass="org.eclipse.stem.core.model.NodeDecorator"
	 * @generated
	 */
	EClass getNodeDecorator();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DecoratorsFactory getDecoratorsFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.decorators.impl.TestEdgeDecorator1Impl <em>Test Edge Decorator1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.decorators.impl.TestEdgeDecorator1Impl
		 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getTestEdgeDecorator1()
		 * @generated
		 */
		EClass TEST_EDGE_DECORATOR1 = eINSTANCE.getTestEdgeDecorator1();

		/**
		 * The meta object literal for the '<em><b>Node AURI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_EDGE_DECORATOR1__NODE_AURI = eINSTANCE.getTestEdgeDecorator1_NodeAURI();

		/**
		 * The meta object literal for the '<em><b>Node BURI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_EDGE_DECORATOR1__NODE_BURI = eINSTANCE.getTestEdgeDecorator1_NodeBURI();

		/**
		 * The meta object literal for the '<em><b>Edge URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_EDGE_DECORATOR1__EDGE_URI = eINSTANCE.getTestEdgeDecorator1_EdgeURI();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.decorators.impl.TestGraphDecorator1Impl <em>Test Graph Decorator1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.decorators.impl.TestGraphDecorator1Impl
		 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getTestGraphDecorator1()
		 * @generated
		 */
		EClass TEST_GRAPH_DECORATOR1 = eINSTANCE.getTestGraphDecorator1();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.decorators.impl.TestNodeDecorator1Impl <em>Test Node Decorator1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.decorators.impl.TestNodeDecorator1Impl
		 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getTestNodeDecorator1()
		 * @generated
		 */
		EClass TEST_NODE_DECORATOR1 = eINSTANCE.getTestNodeDecorator1();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.tests.util.decorators.impl.TestScenarioGraphDecorator1Impl <em>Test Scenario Graph Decorator1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.tests.util.decorators.impl.TestScenarioGraphDecorator1Impl
		 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getTestScenarioGraphDecorator1()
		 * @generated
		 */
		EClass TEST_SCENARIO_GRAPH_DECORATOR1 = eINSTANCE.getTestScenarioGraphDecorator1();

		/**
		 * The meta object literal for the '<em><b>Double Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SCENARIO_GRAPH_DECORATOR1__DOUBLE_VALUE = eINSTANCE.getTestScenarioGraphDecorator1_DoubleValue();

		/**
		 * The meta object literal for the '<em><b>Int Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SCENARIO_GRAPH_DECORATOR1__INT_VALUE = eINSTANCE.getTestScenarioGraphDecorator1_IntValue();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SCENARIO_GRAPH_DECORATOR1__STRING_VALUE = eINSTANCE.getTestScenarioGraphDecorator1_StringValue();

		/**
		 * The meta object literal for the '<em><b>STEM Time Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SCENARIO_GRAPH_DECORATOR1__STEM_TIME_VALUE = eINSTANCE.getTestScenarioGraphDecorator1_STEMTimeValue();

		/**
		 * The meta object literal for the '<em><b>Boolean Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SCENARIO_GRAPH_DECORATOR1__BOOLEAN_VALUE = eINSTANCE.getTestScenarioGraphDecorator1_BooleanValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.EdgeDecorator <em>Edge Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.EdgeDecorator
		 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getEdgeDecorator()
		 * @generated
		 */
		EClass EDGE_DECORATOR = eINSTANCE.getEdgeDecorator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.GraphDecorator <em>Graph Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.GraphDecorator
		 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getGraphDecorator()
		 * @generated
		 */
		EClass GRAPH_DECORATOR = eINSTANCE.getGraphDecorator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.NodeDecorator <em>Node Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.NodeDecorator
		 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getNodeDecorator()
		 * @generated
		 */
		EClass NODE_DECORATOR = eINSTANCE.getNodeDecorator();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipse.stem.tests.util.decorators.impl.DecoratorsPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //DecoratorsPackage
