package org.eclipse.stem.core.model;

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
 * @see org.eclipse.stem.core.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.core.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipse.stem.core.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.impl.DecoratorImpl <em>Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl
	 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getDecorator()
	 * @generated
	 */
	int DECORATOR = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR__LABELS_TO_UPDATE = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR__GRAPH = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR__ENABLED = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR__GRAPH_DECORATED = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR__PROGRESS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATOR_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.impl.EdgeDecoratorImpl <em>Edge Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.impl.EdgeDecoratorImpl
	 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getEdgeDecorator()
	 * @generated
	 */
	int EDGE_DECORATOR = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR__URI = DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR__TYPE_URI = DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR__DUBLIN_CORE = DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR__LABELS_TO_UPDATE = DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR__GRAPH = DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR__ENABLED = DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR__GRAPH_DECORATED = DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR__PROGRESS = DECORATOR__PROGRESS;

	/**
	 * The number of structural features of the '<em>Edge Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_DECORATOR_FEATURE_COUNT = DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.impl.GraphDecoratorImpl <em>Graph Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.impl.GraphDecoratorImpl
	 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getGraphDecorator()
	 * @generated
	 */
	int GRAPH_DECORATOR = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR__URI = DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR__TYPE_URI = DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR__DUBLIN_CORE = DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR__LABELS_TO_UPDATE = DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR__GRAPH = DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR__ENABLED = DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR__GRAPH_DECORATED = DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR__PROGRESS = DECORATOR__PROGRESS;

	/**
	 * The number of structural features of the '<em>Graph Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_DECORATOR_FEATURE_COUNT = DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.impl.ModelImpl
	 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 3;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__MODELS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Graphs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__GRAPHS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Graph Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__GRAPH_DECORATORS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Node Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NODE_DECORATORS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Edge Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__EDGE_DECORATORS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.impl.NodeDecoratorImpl <em>Node Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.impl.NodeDecoratorImpl
	 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getNodeDecorator()
	 * @generated
	 */
	int NODE_DECORATOR = 4;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR__URI = DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR__TYPE_URI = DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR__DUBLIN_CORE = DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR__LABELS_TO_UPDATE = DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR__GRAPH = DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR__ENABLED = DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR__GRAPH_DECORATED = DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR__PROGRESS = DECORATOR__PROGRESS;

	/**
	 * The number of structural features of the '<em>Node Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DECORATOR_FEATURE_COUNT = DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link java.lang.Comparable <em>Comparable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Comparable
	 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getComparable()
	 * @generated
	 */
	int COMPARABLE = 6;

	/**
	 * The number of structural features of the '<em>Comparable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.impl.STEMTimeImpl <em>STEM Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.impl.STEMTimeImpl
	 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getSTEMTime()
	 * @generated
	 */
	int STEM_TIME = 5;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME__TIME = COMPARABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>STEM Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_FEATURE_COUNT = COMPARABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getURI()
	 * @generated
	 */
	int URI = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.Decorator <em>Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decorator</em>'.
	 * @see org.eclipse.stem.core.model.Decorator
	 * @generated
	 */
	EClass getDecorator();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.model.Decorator#getLabelsToUpdate <em>Labels To Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Labels To Update</em>'.
	 * @see org.eclipse.stem.core.model.Decorator#getLabelsToUpdate()
	 * @see #getDecorator()
	 * @generated
	 */
	EReference getDecorator_LabelsToUpdate();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.stem.core.model.Decorator#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see org.eclipse.stem.core.model.Decorator#getGraph()
	 * @see #getDecorator()
	 * @generated
	 */
	EReference getDecorator_Graph();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.model.Decorator#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.eclipse.stem.core.model.Decorator#isEnabled()
	 * @see #getDecorator()
	 * @generated
	 */
	EAttribute getDecorator_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.model.Decorator#isGraphDecorated <em>Graph Decorated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Graph Decorated</em>'.
	 * @see org.eclipse.stem.core.model.Decorator#isGraphDecorated()
	 * @see #getDecorator()
	 * @generated
	 */
	EAttribute getDecorator_GraphDecorated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.model.Decorator#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see org.eclipse.stem.core.model.Decorator#getProgress()
	 * @see #getDecorator()
	 * @generated
	 */
	EAttribute getDecorator_Progress();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.EdgeDecorator <em>Edge Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Decorator</em>'.
	 * @see org.eclipse.stem.core.model.EdgeDecorator
	 * @generated
	 */
	EClass getEdgeDecorator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.GraphDecorator <em>Graph Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Decorator</em>'.
	 * @see org.eclipse.stem.core.model.GraphDecorator
	 * @generated
	 */
	EClass getGraphDecorator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipse.stem.core.model.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.model.Model#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Models</em>'.
	 * @see org.eclipse.stem.core.model.Model#getModels()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Models();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.model.Model#getGraphs <em>Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Graphs</em>'.
	 * @see org.eclipse.stem.core.model.Model#getGraphs()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Graphs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.model.Model#getGraphDecorators <em>Graph Decorators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Graph Decorators</em>'.
	 * @see org.eclipse.stem.core.model.Model#getGraphDecorators()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_GraphDecorators();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.model.Model#getNodeDecorators <em>Node Decorators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Node Decorators</em>'.
	 * @see org.eclipse.stem.core.model.Model#getNodeDecorators()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_NodeDecorators();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.model.Model#getEdgeDecorators <em>Edge Decorators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edge Decorators</em>'.
	 * @see org.eclipse.stem.core.model.Model#getEdgeDecorators()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_EdgeDecorators();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.NodeDecorator <em>Node Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Decorator</em>'.
	 * @see org.eclipse.stem.core.model.NodeDecorator
	 * @generated
	 */
	EClass getNodeDecorator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.STEMTime <em>STEM Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STEM Time</em>'.
	 * @see org.eclipse.stem.core.model.STEMTime
	 * @generated
	 */
	EClass getSTEMTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.model.STEMTime#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.stem.core.model.STEMTime#getTime()
	 * @see #getSTEMTime()
	 * @generated
	 */
	EAttribute getSTEMTime_Time();

	/**
	 * Returns the meta object for class '{@link java.lang.Comparable <em>Comparable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparable</em>'.
	 * @see java.lang.Comparable
	 * @model instanceClass="java.lang.Comparable" typeParameters="T"
	 * @generated
	 */
	EClass getComparable();

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
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.impl.DecoratorImpl <em>Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.impl.DecoratorImpl
		 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getDecorator()
		 * @generated
		 */
		EClass DECORATOR = eINSTANCE.getDecorator();

		/**
		 * The meta object literal for the '<em><b>Labels To Update</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECORATOR__LABELS_TO_UPDATE = eINSTANCE.getDecorator_LabelsToUpdate();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECORATOR__GRAPH = eINSTANCE.getDecorator_Graph();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECORATOR__ENABLED = eINSTANCE.getDecorator_Enabled();

		/**
		 * The meta object literal for the '<em><b>Graph Decorated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECORATOR__GRAPH_DECORATED = eINSTANCE.getDecorator_GraphDecorated();

		/**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECORATOR__PROGRESS = eINSTANCE.getDecorator_Progress();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.impl.EdgeDecoratorImpl <em>Edge Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.impl.EdgeDecoratorImpl
		 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getEdgeDecorator()
		 * @generated
		 */
		EClass EDGE_DECORATOR = eINSTANCE.getEdgeDecorator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.impl.GraphDecoratorImpl <em>Graph Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.impl.GraphDecoratorImpl
		 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getGraphDecorator()
		 * @generated
		 */
		EClass GRAPH_DECORATOR = eINSTANCE.getGraphDecorator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.impl.ModelImpl
		 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__MODELS = eINSTANCE.getModel_Models();

		/**
		 * The meta object literal for the '<em><b>Graphs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__GRAPHS = eINSTANCE.getModel_Graphs();

		/**
		 * The meta object literal for the '<em><b>Graph Decorators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__GRAPH_DECORATORS = eINSTANCE.getModel_GraphDecorators();

		/**
		 * The meta object literal for the '<em><b>Node Decorators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__NODE_DECORATORS = eINSTANCE.getModel_NodeDecorators();

		/**
		 * The meta object literal for the '<em><b>Edge Decorators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__EDGE_DECORATORS = eINSTANCE.getModel_EdgeDecorators();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.impl.NodeDecoratorImpl <em>Node Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.impl.NodeDecoratorImpl
		 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getNodeDecorator()
		 * @generated
		 */
		EClass NODE_DECORATOR = eINSTANCE.getNodeDecorator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.impl.STEMTimeImpl <em>STEM Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.impl.STEMTimeImpl
		 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getSTEMTime()
		 * @generated
		 */
		EClass STEM_TIME = eINSTANCE.getSTEMTime();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEM_TIME__TIME = eINSTANCE.getSTEMTime_Time();

		/**
		 * The meta object literal for the '{@link java.lang.Comparable <em>Comparable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Comparable
		 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getComparable()
		 * @generated
		 */
		EClass COMPARABLE = eINSTANCE.getComparable();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipse.stem.core.model.impl.ModelPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //ModelPackage
