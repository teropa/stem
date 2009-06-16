package org.eclipse.stem.core.graph;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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

import org.eclipse.stem.core.common.CommonPackage;

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
 * @see org.eclipse.stem.core.graph.GraphFactory
 * @model kind="package"
 * @generated
 */
public interface GraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/graph.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.core.graph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphPackage eINSTANCE = org.eclipse.stem.core.graph.impl.GraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.LabelImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 4;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__CURRENT_VALUE = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__IDENTIFIABLE = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.DynamicLabelImpl <em>Dynamic Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.DynamicLabelImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getDynamicLabel()
	 * @generated
	 */
	int DYNAMIC_LABEL = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL__URI = LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL__TYPE_URI = LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL__DUBLIN_CORE = LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL__CURRENT_VALUE = LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL__IDENTIFIABLE = LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL__NEXT_VALUE_VALID = LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL__NEXT_VALUE = LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL__DECORATOR = LABEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dynamic Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_LABEL_FEATURE_COUNT = LABEL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.DynamicNodeLabelImpl <em>Dynamic Node Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.DynamicNodeLabelImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getDynamicNodeLabel()
	 * @generated
	 */
	int DYNAMIC_NODE_LABEL = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__URI = DYNAMIC_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__TYPE_URI = DYNAMIC_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__DUBLIN_CORE = DYNAMIC_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = DYNAMIC_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__CURRENT_VALUE = DYNAMIC_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__IDENTIFIABLE = DYNAMIC_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__NEXT_VALUE_VALID = DYNAMIC_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__NEXT_VALUE = DYNAMIC_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__DECORATOR = DYNAMIC_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL__NODE = DYNAMIC_LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dynamic Node Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_NODE_LABEL_FEATURE_COUNT = DYNAMIC_LABEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.EdgeImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__A = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node AURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NODE_AURI = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__B = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Node BURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NODE_BURI = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__LABEL = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Directed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__DIRECTED = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.GraphImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 3;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__EDGES = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Graph Labels</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__GRAPH_LABELS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Node Labels</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODE_LABELS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dynamic Labels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__DYNAMIC_LABELS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Num Edges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NUM_EDGES = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Num Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NUM_NODES = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Num Graph Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NUM_GRAPH_LABELS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Num Node Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NUM_NODE_LABELS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Num Dynamic Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NUM_DYNAMIC_LABELS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Unresolved Identifiables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__UNRESOLVED_IDENTIFIABLES = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__DECORATORS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__TIME = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.SanityChecker <em>Sanity Checker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.SanityChecker
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getSanityChecker()
	 * @generated
	 */
	int SANITY_CHECKER = 11;

	/**
	 * The number of structural features of the '<em>Sanity Checker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANITY_CHECKER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.LabelValueImpl <em>Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.LabelValueImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getLabelValue()
	 * @generated
	 */
	int LABEL_VALUE = 5;

	/**
	 * The number of structural features of the '<em>Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_VALUE_FEATURE_COUNT = SANITY_CHECKER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.NodeImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 6;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EDGES = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LABELS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.NodeLabelImpl <em>Node Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.NodeLabelImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getNodeLabel()
	 * @generated
	 */
	int NODE_LABEL = 7;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__URI = LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__TYPE_URI = LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__DUBLIN_CORE = LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__CURRENT_VALUE = LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__IDENTIFIABLE = LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__NODE = LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL_FEATURE_COUNT = LABEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.StaticNodeLabelImpl <em>Static Node Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.StaticNodeLabelImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getStaticNodeLabel()
	 * @generated
	 */
	int STATIC_NODE_LABEL = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl <em>Unresolved Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getUnresolvedIdentifiable()
	 * @generated
	 */
	int UNRESOLVED_IDENTIFIABLE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.URIToIdentifiableMapEntryImpl <em>URI To Identifiable Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.URIToIdentifiableMapEntryImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToIdentifiableMapEntry()
	 * @generated
	 */
	int URI_TO_IDENTIFIABLE_MAP_ENTRY = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.EdgeLabelImpl <em>Edge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.EdgeLabelImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getEdgeLabel()
	 * @generated
	 */
	int EDGE_LABEL = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.DynamicEdgeLabelImpl <em>Dynamic Edge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.DynamicEdgeLabelImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getDynamicEdgeLabel()
	 * @generated
	 */
	int DYNAMIC_EDGE_LABEL = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.StaticEdgeLabelImpl <em>Static Edge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.StaticEdgeLabelImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getStaticEdgeLabel()
	 * @generated
	 */
	int STATIC_EDGE_LABEL = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.URIToEdgeMapEntryImpl <em>URI To Edge Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.URIToEdgeMapEntryImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToEdgeMapEntry()
	 * @generated
	 */
	int URI_TO_EDGE_MAP_ENTRY = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.URIToNodeMapEntryImpl <em>URI To Node Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.URIToNodeMapEntryImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToNodeMapEntry()
	 * @generated
	 */
	int URI_TO_NODE_MAP_ENTRY = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.URIToLabelMapEntryImpl <em>URI To Label Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.URIToLabelMapEntryImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToLabelMapEntry()
	 * @generated
	 */
	int URI_TO_LABEL_MAP_ENTRY = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.URIToNodeLabelMapEntryImpl <em>URI To Node Label Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.URIToNodeLabelMapEntryImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToNodeLabelMapEntry()
	 * @generated
	 */
	int URI_TO_NODE_LABEL_MAP_ENTRY = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.impl.StaticLabelImpl <em>Static Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.impl.StaticLabelImpl
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getStaticLabel()
	 * @generated
	 */
	int STATIC_LABEL = 19;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_NODE_LABEL__URI = NODE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_NODE_LABEL__TYPE_URI = NODE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_NODE_LABEL__DUBLIN_CORE = NODE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_NODE_LABEL__CURRENT_VALUE = NODE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_NODE_LABEL__IDENTIFIABLE = NODE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_NODE_LABEL__NODE = NODE_LABEL__NODE;

	/**
	 * The number of structural features of the '<em>Static Node Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_NODE_LABEL_FEATURE_COUNT = NODE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_IDENTIFIABLE__SCENARIO = 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_IDENTIFIABLE__MODEL = 1;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_IDENTIFIABLE__GRAPH = 2;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE = 3;

	/**
	 * The feature id for the '<em><b>Unresolved URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI = 4;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_IDENTIFIABLE__FIELD_NAME = 5;

	/**
	 * The number of structural features of the '<em>Unresolved Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_IDENTIFIABLE_FEATURE_COUNT = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_IDENTIFIABLE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_IDENTIFIABLE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>URI To Identifiable Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_IDENTIFIABLE_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__URI = DYNAMIC_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__TYPE_URI = DYNAMIC_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__DUBLIN_CORE = DYNAMIC_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = DYNAMIC_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__CURRENT_VALUE = DYNAMIC_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__IDENTIFIABLE = DYNAMIC_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__NEXT_VALUE_VALID = DYNAMIC_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__NEXT_VALUE = DYNAMIC_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__DECORATOR = DYNAMIC_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL__EDGE = DYNAMIC_LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dynamic Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EDGE_LABEL_FEATURE_COUNT = DYNAMIC_LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__URI = LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__TYPE_URI = LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__DUBLIN_CORE = LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__CURRENT_VALUE = LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__IDENTIFIABLE = LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__EDGE = LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL_FEATURE_COUNT = LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_EDGE_LABEL__URI = EDGE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_EDGE_LABEL__TYPE_URI = EDGE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_EDGE_LABEL__DUBLIN_CORE = EDGE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_EDGE_LABEL__CURRENT_VALUE = EDGE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_EDGE_LABEL__IDENTIFIABLE = EDGE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_EDGE_LABEL__EDGE = EDGE_LABEL__EDGE;

	/**
	 * The number of structural features of the '<em>Static Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_EDGE_LABEL_FEATURE_COUNT = EDGE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_EDGE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_EDGE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>URI To Edge Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_EDGE_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_NODE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_NODE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>URI To Node Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_NODE_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_LABEL_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_LABEL_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>URI To Label Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_LABEL_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_NODE_LABEL_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_NODE_LABEL_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>URI To Node Label Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_TO_NODE_LABEL_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_LABEL__URI = LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_LABEL__TYPE_URI = LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_LABEL__DUBLIN_CORE = LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_LABEL__CURRENT_VALUE = LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_LABEL__IDENTIFIABLE = LABEL__IDENTIFIABLE;

	/**
	 * The number of structural features of the '<em>Static Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_LABEL_FEATURE_COUNT = LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURI()
	 * @generated
	 */
	int URI = 20;

	/**
	 * The meta object id for the '<em>Illegal Argument Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.IllegalArgumentException
	 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getIllegalArgumentException()
	 * @generated
	 */
	int ILLEGAL_ARGUMENT_EXCEPTION = 21;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.DynamicLabel <em>Dynamic Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Label</em>'.
	 * @see org.eclipse.stem.core.graph.DynamicLabel
	 * @generated
	 */
	EClass getDynamicLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.DynamicLabel#isNextValueValid <em>Next Value Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next Value Valid</em>'.
	 * @see org.eclipse.stem.core.graph.DynamicLabel#isNextValueValid()
	 * @see #getDynamicLabel()
	 * @generated
	 */
	EAttribute getDynamicLabel_NextValueValid();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.graph.DynamicLabel#getNextValue <em>Next Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Next Value</em>'.
	 * @see org.eclipse.stem.core.graph.DynamicLabel#getNextValue()
	 * @see #getDynamicLabel()
	 * @generated
	 */
	EReference getDynamicLabel_NextValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.graph.DynamicLabel#getDecorator <em>Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Decorator</em>'.
	 * @see org.eclipse.stem.core.graph.DynamicLabel#getDecorator()
	 * @see #getDynamicLabel()
	 * @generated
	 */
	EReference getDynamicLabel_Decorator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.DynamicNodeLabel <em>Dynamic Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Node Label</em>'.
	 * @see org.eclipse.stem.core.graph.DynamicNodeLabel
	 * @generated
	 */
	EClass getDynamicNodeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see org.eclipse.stem.core.graph.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.graph.Edge#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>A</em>'.
	 * @see org.eclipse.stem.core.graph.Edge#getA()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_A();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.Edge#getNodeAURI <em>Node AURI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node AURI</em>'.
	 * @see org.eclipse.stem.core.graph.Edge#getNodeAURI()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_NodeAURI();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.graph.Edge#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>B</em>'.
	 * @see org.eclipse.stem.core.graph.Edge#getB()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_B();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.Edge#getNodeBURI <em>Node BURI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node BURI</em>'.
	 * @see org.eclipse.stem.core.graph.Edge#getNodeBURI()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_NodeBURI();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.graph.Edge#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Label</em>'.
	 * @see org.eclipse.stem.core.graph.Edge#getLabel()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.Edge#isDirected <em>Directed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directed</em>'.
	 * @see org.eclipse.stem.core.graph.Edge#isDirected()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Directed();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see org.eclipse.stem.core.graph.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.stem.core.graph.Graph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Edges</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getEdges()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Edges();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.stem.core.graph.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Nodes</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.stem.core.graph.Graph#getGraphLabels <em>Graph Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Graph Labels</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getGraphLabels()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_GraphLabels();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.stem.core.graph.Graph#getNodeLabels <em>Node Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Node Labels</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getNodeLabels()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_NodeLabels();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.graph.Graph#getDynamicLabels <em>Dynamic Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dynamic Labels</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getDynamicLabels()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_DynamicLabels();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.Graph#getNumEdges <em>Num Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Edges</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getNumEdges()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_NumEdges();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.Graph#getNumNodes <em>Num Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Nodes</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getNumNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_NumNodes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.Graph#getNumGraphLabels <em>Num Graph Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Graph Labels</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getNumGraphLabels()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_NumGraphLabels();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.Graph#getNumNodeLabels <em>Num Node Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Node Labels</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getNumNodeLabels()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_NumNodeLabels();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.Graph#getNumDynamicLabels <em>Num Dynamic Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Dynamic Labels</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getNumDynamicLabels()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_NumDynamicLabels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.stem.core.graph.Graph#getUnresolvedIdentifiables <em>Unresolved Identifiables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unresolved Identifiables</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getUnresolvedIdentifiables()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_UnresolvedIdentifiables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.stem.core.graph.Graph#getDecorators <em>Decorators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decorators</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getDecorators()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Decorators();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.graph.Graph#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time</em>'.
	 * @see org.eclipse.stem.core.graph.Graph#getTime()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Time();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see org.eclipse.stem.core.graph.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.Label#getURIOfIdentifiableToBeLabeled <em>URI Of Identifiable To Be Labeled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI Of Identifiable To Be Labeled</em>'.
	 * @see org.eclipse.stem.core.graph.Label#getURIOfIdentifiableToBeLabeled()
	 * @see #getLabel()
	 * @generated
	 */
	EAttribute getLabel_URIOfIdentifiableToBeLabeled();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.graph.Label#getCurrentValue <em>Current Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Current Value</em>'.
	 * @see org.eclipse.stem.core.graph.Label#getCurrentValue()
	 * @see #getLabel()
	 * @generated
	 */
	EReference getLabel_CurrentValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.graph.Label#getIdentifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifiable</em>'.
	 * @see org.eclipse.stem.core.graph.Label#getIdentifiable()
	 * @see #getLabel()
	 * @generated
	 */
	EReference getLabel_Identifiable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.LabelValue <em>Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label Value</em>'.
	 * @see org.eclipse.stem.core.graph.LabelValue
	 * @generated
	 */
	EClass getLabelValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.stem.core.graph.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.graph.Node#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges</em>'.
	 * @see org.eclipse.stem.core.graph.Node#getEdges()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Edges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.graph.Node#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Labels</em>'.
	 * @see org.eclipse.stem.core.graph.Node#getLabels()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Labels();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.NodeLabel <em>Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Label</em>'.
	 * @see org.eclipse.stem.core.graph.NodeLabel
	 * @generated
	 */
	EClass getNodeLabel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.graph.NodeLabel#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see org.eclipse.stem.core.graph.NodeLabel#getNode()
	 * @see #getNodeLabel()
	 * @generated
	 */
	EReference getNodeLabel_Node();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.StaticNodeLabel <em>Static Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Node Label</em>'.
	 * @see org.eclipse.stem.core.graph.StaticNodeLabel
	 * @generated
	 */
	EClass getStaticNodeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable <em>Unresolved Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unresolved Identifiable</em>'.
	 * @see org.eclipse.stem.core.graph.UnresolvedIdentifiable
	 * @generated
	 */
	EClass getUnresolvedIdentifiable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scenario</em>'.
	 * @see org.eclipse.stem.core.graph.UnresolvedIdentifiable#getScenario()
	 * @see #getUnresolvedIdentifiable()
	 * @generated
	 */
	EReference getUnresolvedIdentifiable_Scenario();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.stem.core.graph.UnresolvedIdentifiable#getModel()
	 * @see #getUnresolvedIdentifiable()
	 * @generated
	 */
	EReference getUnresolvedIdentifiable_Model();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Graph</em>'.
	 * @see org.eclipse.stem.core.graph.UnresolvedIdentifiable#getGraph()
	 * @see #getUnresolvedIdentifiable()
	 * @generated
	 */
	EReference getUnresolvedIdentifiable_Graph();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getIdentifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifiable</em>'.
	 * @see org.eclipse.stem.core.graph.UnresolvedIdentifiable#getIdentifiable()
	 * @see #getUnresolvedIdentifiable()
	 * @generated
	 */
	EReference getUnresolvedIdentifiable_Identifiable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getUnresolvedURI <em>Unresolved URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unresolved URI</em>'.
	 * @see org.eclipse.stem.core.graph.UnresolvedIdentifiable#getUnresolvedURI()
	 * @see #getUnresolvedIdentifiable()
	 * @generated
	 */
	EAttribute getUnresolvedIdentifiable_UnresolvedURI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see org.eclipse.stem.core.graph.UnresolvedIdentifiable#getFieldName()
	 * @see #getUnresolvedIdentifiable()
	 * @generated
	 */
	EAttribute getUnresolvedIdentifiable_FieldName();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>URI To Identifiable Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI To Identifiable Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.stem.core.graph.URI"
	 *        valueType="org.eclipse.stem.core.common.Identifiable" valueContainment="true"
	 * @generated
	 */
	EClass getURIToIdentifiableMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToIdentifiableMapEntry()
	 * @generated
	 */
	EAttribute getURIToIdentifiableMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToIdentifiableMapEntry()
	 * @generated
	 */
	EReference getURIToIdentifiableMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.SanityChecker <em>Sanity Checker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sanity Checker</em>'.
	 * @see org.eclipse.stem.core.common.SanityChecker
	 * @model instanceClass="org.eclipse.stem.core.common.SanityChecker"
	 * @generated
	 */
	EClass getSanityChecker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.DynamicEdgeLabel <em>Dynamic Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Edge Label</em>'.
	 * @see org.eclipse.stem.core.graph.DynamicEdgeLabel
	 * @generated
	 */
	EClass getDynamicEdgeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.EdgeLabel <em>Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Label</em>'.
	 * @see org.eclipse.stem.core.graph.EdgeLabel
	 * @generated
	 */
	EClass getEdgeLabel();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.stem.core.graph.EdgeLabel#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Edge</em>'.
	 * @see org.eclipse.stem.core.graph.EdgeLabel#getEdge()
	 * @see #getEdgeLabel()
	 * @generated
	 */
	EReference getEdgeLabel_Edge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.StaticEdgeLabel <em>Static Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Edge Label</em>'.
	 * @see org.eclipse.stem.core.graph.StaticEdgeLabel
	 * @generated
	 */
	EClass getStaticEdgeLabel();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>URI To Edge Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI To Edge Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.stem.core.graph.URI"
	 *        valueType="org.eclipse.stem.core.graph.Edge" valueContainment="true"
	 * @generated
	 */
	EClass getURIToEdgeMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToEdgeMapEntry()
	 * @generated
	 */
	EAttribute getURIToEdgeMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToEdgeMapEntry()
	 * @generated
	 */
	EReference getURIToEdgeMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>URI To Node Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI To Node Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.stem.core.graph.URI"
	 *        valueType="org.eclipse.stem.core.graph.Node" valueContainment="true"
	 * @generated
	 */
	EClass getURIToNodeMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToNodeMapEntry()
	 * @generated
	 */
	EAttribute getURIToNodeMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToNodeMapEntry()
	 * @generated
	 */
	EReference getURIToNodeMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>URI To Label Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI To Label Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.stem.core.graph.URI"
	 *        valueType="org.eclipse.stem.core.graph.Label" valueContainment="true"
	 * @generated
	 */
	EClass getURIToLabelMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToLabelMapEntry()
	 * @generated
	 */
	EAttribute getURIToLabelMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToLabelMapEntry()
	 * @generated
	 */
	EReference getURIToLabelMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>URI To Node Label Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI To Node Label Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.stem.core.graph.URI"
	 *        valueType="org.eclipse.stem.core.graph.NodeLabel" valueContainment="true"
	 * @generated
	 */
	EClass getURIToNodeLabelMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToNodeLabelMapEntry()
	 * @generated
	 */
	EAttribute getURIToNodeLabelMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getURIToNodeLabelMapEntry()
	 * @generated
	 */
	EReference getURIToNodeLabelMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.StaticLabel <em>Static Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Label</em>'.
	 * @see org.eclipse.stem.core.graph.StaticLabel
	 * @generated
	 */
	EClass getStaticLabel();

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
	 * Returns the meta object for data type '{@link java.lang.IllegalArgumentException <em>Illegal Argument Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Illegal Argument Exception</em>'.
	 * @see java.lang.IllegalArgumentException
	 * @model instanceClass="java.lang.IllegalArgumentException"
	 * @generated
	 */
	EDataType getIllegalArgumentException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphFactory getGraphFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.DynamicLabelImpl <em>Dynamic Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.DynamicLabelImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getDynamicLabel()
		 * @generated
		 */
		EClass DYNAMIC_LABEL = eINSTANCE.getDynamicLabel();

		/**
		 * The meta object literal for the '<em><b>Next Value Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_LABEL__NEXT_VALUE_VALID = eINSTANCE.getDynamicLabel_NextValueValid();

		/**
		 * The meta object literal for the '<em><b>Next Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_LABEL__NEXT_VALUE = eINSTANCE.getDynamicLabel_NextValue();

		/**
		 * The meta object literal for the '<em><b>Decorator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_LABEL__DECORATOR = eINSTANCE.getDynamicLabel_Decorator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.DynamicNodeLabelImpl <em>Dynamic Node Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.DynamicNodeLabelImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getDynamicNodeLabel()
		 * @generated
		 */
		EClass DYNAMIC_NODE_LABEL = eINSTANCE.getDynamicNodeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.EdgeImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__A = eINSTANCE.getEdge_A();

		/**
		 * The meta object literal for the '<em><b>Node AURI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__NODE_AURI = eINSTANCE.getEdge_NodeAURI();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__B = eINSTANCE.getEdge_B();

		/**
		 * The meta object literal for the '<em><b>Node BURI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__NODE_BURI = eINSTANCE.getEdge_NodeBURI();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__LABEL = eINSTANCE.getEdge_Label();

		/**
		 * The meta object literal for the '<em><b>Directed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__DIRECTED = eINSTANCE.getEdge_Directed();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.GraphImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__EDGES = eINSTANCE.getGraph_Edges();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Graph Labels</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__GRAPH_LABELS = eINSTANCE.getGraph_GraphLabels();

		/**
		 * The meta object literal for the '<em><b>Node Labels</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODE_LABELS = eINSTANCE.getGraph_NodeLabels();

		/**
		 * The meta object literal for the '<em><b>Dynamic Labels</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__DYNAMIC_LABELS = eINSTANCE.getGraph_DynamicLabels();

		/**
		 * The meta object literal for the '<em><b>Num Edges</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NUM_EDGES = eINSTANCE.getGraph_NumEdges();

		/**
		 * The meta object literal for the '<em><b>Num Nodes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NUM_NODES = eINSTANCE.getGraph_NumNodes();

		/**
		 * The meta object literal for the '<em><b>Num Graph Labels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NUM_GRAPH_LABELS = eINSTANCE.getGraph_NumGraphLabels();

		/**
		 * The meta object literal for the '<em><b>Num Node Labels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NUM_NODE_LABELS = eINSTANCE.getGraph_NumNodeLabels();

		/**
		 * The meta object literal for the '<em><b>Num Dynamic Labels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NUM_DYNAMIC_LABELS = eINSTANCE.getGraph_NumDynamicLabels();

		/**
		 * The meta object literal for the '<em><b>Unresolved Identifiables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__UNRESOLVED_IDENTIFIABLES = eINSTANCE.getGraph_UnresolvedIdentifiables();

		/**
		 * The meta object literal for the '<em><b>Decorators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__DECORATORS = eINSTANCE.getGraph_Decorators();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__TIME = eINSTANCE.getGraph_Time();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.LabelImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = eINSTANCE.getLabel_URIOfIdentifiableToBeLabeled();

		/**
		 * The meta object literal for the '<em><b>Current Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL__CURRENT_VALUE = eINSTANCE.getLabel_CurrentValue();

		/**
		 * The meta object literal for the '<em><b>Identifiable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL__IDENTIFIABLE = eINSTANCE.getLabel_Identifiable();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.LabelValueImpl <em>Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.LabelValueImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getLabelValue()
		 * @generated
		 */
		EClass LABEL_VALUE = eINSTANCE.getLabelValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.NodeImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__EDGES = eINSTANCE.getNode_Edges();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__LABELS = eINSTANCE.getNode_Labels();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.NodeLabelImpl <em>Node Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.NodeLabelImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getNodeLabel()
		 * @generated
		 */
		EClass NODE_LABEL = eINSTANCE.getNodeLabel();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_LABEL__NODE = eINSTANCE.getNodeLabel_Node();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.StaticNodeLabelImpl <em>Static Node Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.StaticNodeLabelImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getStaticNodeLabel()
		 * @generated
		 */
		EClass STATIC_NODE_LABEL = eINSTANCE.getStaticNodeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl <em>Unresolved Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getUnresolvedIdentifiable()
		 * @generated
		 */
		EClass UNRESOLVED_IDENTIFIABLE = eINSTANCE.getUnresolvedIdentifiable();

		/**
		 * The meta object literal for the '<em><b>Scenario</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNRESOLVED_IDENTIFIABLE__SCENARIO = eINSTANCE.getUnresolvedIdentifiable_Scenario();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNRESOLVED_IDENTIFIABLE__MODEL = eINSTANCE.getUnresolvedIdentifiable_Model();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNRESOLVED_IDENTIFIABLE__GRAPH = eINSTANCE.getUnresolvedIdentifiable_Graph();

		/**
		 * The meta object literal for the '<em><b>Identifiable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE = eINSTANCE.getUnresolvedIdentifiable_Identifiable();

		/**
		 * The meta object literal for the '<em><b>Unresolved URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI = eINSTANCE.getUnresolvedIdentifiable_UnresolvedURI();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNRESOLVED_IDENTIFIABLE__FIELD_NAME = eINSTANCE.getUnresolvedIdentifiable_FieldName();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.URIToIdentifiableMapEntryImpl <em>URI To Identifiable Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.URIToIdentifiableMapEntryImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToIdentifiableMapEntry()
		 * @generated
		 */
		EClass URI_TO_IDENTIFIABLE_MAP_ENTRY = eINSTANCE.getURIToIdentifiableMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_TO_IDENTIFIABLE_MAP_ENTRY__KEY = eINSTANCE.getURIToIdentifiableMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URI_TO_IDENTIFIABLE_MAP_ENTRY__VALUE = eINSTANCE.getURIToIdentifiableMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.SanityChecker <em>Sanity Checker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.SanityChecker
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getSanityChecker()
		 * @generated
		 */
		EClass SANITY_CHECKER = eINSTANCE.getSanityChecker();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.DynamicEdgeLabelImpl <em>Dynamic Edge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.DynamicEdgeLabelImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getDynamicEdgeLabel()
		 * @generated
		 */
		EClass DYNAMIC_EDGE_LABEL = eINSTANCE.getDynamicEdgeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.EdgeLabelImpl <em>Edge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.EdgeLabelImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getEdgeLabel()
		 * @generated
		 */
		EClass EDGE_LABEL = eINSTANCE.getEdgeLabel();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_LABEL__EDGE = eINSTANCE.getEdgeLabel_Edge();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.StaticEdgeLabelImpl <em>Static Edge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.StaticEdgeLabelImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getStaticEdgeLabel()
		 * @generated
		 */
		EClass STATIC_EDGE_LABEL = eINSTANCE.getStaticEdgeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.URIToEdgeMapEntryImpl <em>URI To Edge Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.URIToEdgeMapEntryImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToEdgeMapEntry()
		 * @generated
		 */
		EClass URI_TO_EDGE_MAP_ENTRY = eINSTANCE.getURIToEdgeMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_TO_EDGE_MAP_ENTRY__KEY = eINSTANCE.getURIToEdgeMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URI_TO_EDGE_MAP_ENTRY__VALUE = eINSTANCE.getURIToEdgeMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.URIToNodeMapEntryImpl <em>URI To Node Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.URIToNodeMapEntryImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToNodeMapEntry()
		 * @generated
		 */
		EClass URI_TO_NODE_MAP_ENTRY = eINSTANCE.getURIToNodeMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_TO_NODE_MAP_ENTRY__KEY = eINSTANCE.getURIToNodeMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URI_TO_NODE_MAP_ENTRY__VALUE = eINSTANCE.getURIToNodeMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.URIToLabelMapEntryImpl <em>URI To Label Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.URIToLabelMapEntryImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToLabelMapEntry()
		 * @generated
		 */
		EClass URI_TO_LABEL_MAP_ENTRY = eINSTANCE.getURIToLabelMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_TO_LABEL_MAP_ENTRY__KEY = eINSTANCE.getURIToLabelMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URI_TO_LABEL_MAP_ENTRY__VALUE = eINSTANCE.getURIToLabelMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.URIToNodeLabelMapEntryImpl <em>URI To Node Label Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.URIToNodeLabelMapEntryImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURIToNodeLabelMapEntry()
		 * @generated
		 */
		EClass URI_TO_NODE_LABEL_MAP_ENTRY = eINSTANCE.getURIToNodeLabelMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_TO_NODE_LABEL_MAP_ENTRY__KEY = eINSTANCE.getURIToNodeLabelMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URI_TO_NODE_LABEL_MAP_ENTRY__VALUE = eINSTANCE.getURIToNodeLabelMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.impl.StaticLabelImpl <em>Static Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.impl.StaticLabelImpl
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getStaticLabel()
		 * @generated
		 */
		EClass STATIC_LABEL = eINSTANCE.getStaticLabel();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

		/**
		 * The meta object literal for the '<em>Illegal Argument Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.IllegalArgumentException
		 * @see org.eclipse.stem.core.graph.impl.GraphPackageImpl#getIllegalArgumentException()
		 * @generated
		 */
		EDataType ILLEGAL_ARGUMENT_EXCEPTION = eINSTANCE.getIllegalArgumentException();

	}

} //GraphPackage
