package org.eclipse.stem.definitions.transport;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
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

import org.eclipse.stem.core.graph.GraphPackage;

import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.definitions.edges.EdgesPackage;

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
 * @see org.eclipse.stem.definitions.transport.TransportFactory
 * @model kind="package"
 * @generated
 */
public interface TransportPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "transport";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/definitions/transport.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.definitions.transport";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransportPackage eINSTANCE = org.eclipse.stem.definitions.transport.impl.TransportPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.transport.impl.TransportSystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.transport.impl.TransportSystemImpl
	 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getTransportSystem()
	 * @generated
	 */
	int TRANSPORT_SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_SYSTEM__URI = GraphPackage.NODE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_SYSTEM__TYPE_URI = GraphPackage.NODE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_SYSTEM__DUBLIN_CORE = GraphPackage.NODE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_SYSTEM__EDGES = GraphPackage.NODE__EDGES;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_SYSTEM__LABELS = GraphPackage.NODE__LABELS;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_SYSTEM_FEATURE_COUNT = GraphPackage.NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.transport.impl.PipeStyleTransportSystemImpl <em>Pipe Style Transport System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.transport.impl.PipeStyleTransportSystemImpl
	 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getPipeStyleTransportSystem()
	 * @generated
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM__URI = TRANSPORT_SYSTEM__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM__TYPE_URI = TRANSPORT_SYSTEM__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM__DUBLIN_CORE = TRANSPORT_SYSTEM__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM__EDGES = TRANSPORT_SYSTEM__EDGES;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM__LABELS = TRANSPORT_SYSTEM__LABELS;

	/**
	 * The feature id for the '<em><b>In Transport Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM__IN_TRANSPORT_EDGES = TRANSPORT_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out Transport Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM__OUT_TRANSPORT_EDGES = TRANSPORT_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM__MAX_CAPACITY = TRANSPORT_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Pipe Style Transport System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_STYLE_TRANSPORT_SYSTEM_FEATURE_COUNT = TRANSPORT_SYSTEM_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeImpl <em>Pipe Transport Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeImpl
	 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getPipeTransportEdge()
	 * @generated
	 */
	int PIPE_TRANSPORT_EDGE = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__URI = EdgesPackage.POPULATION_EDGE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__TYPE_URI = EdgesPackage.POPULATION_EDGE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__DUBLIN_CORE = EdgesPackage.POPULATION_EDGE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__A = EdgesPackage.POPULATION_EDGE__A;

	/**
	 * The feature id for the '<em><b>Node AURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__NODE_AURI = EdgesPackage.POPULATION_EDGE__NODE_AURI;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__B = EdgesPackage.POPULATION_EDGE__B;

	/**
	 * The feature id for the '<em><b>Node BURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__NODE_BURI = EdgesPackage.POPULATION_EDGE__NODE_BURI;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__LABEL = EdgesPackage.POPULATION_EDGE__LABEL;

	/**
	 * The feature id for the '<em><b>Directed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__DIRECTED = EdgesPackage.POPULATION_EDGE__DIRECTED;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE__POPULATION_IDENTIFIER = EdgesPackage.POPULATION_EDGE__POPULATION_IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Pipe Transport Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_FEATURE_COUNT = EdgesPackage.POPULATION_EDGE_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelImpl <em>Pipe Transport Edge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelImpl
	 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getPipeTransportEdgeLabel()
	 * @generated
	 */
	int PIPE_TRANSPORT_EDGE_LABEL = 3;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL__URI = GraphPackage.EDGE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL__TYPE_URI = GraphPackage.EDGE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL__DUBLIN_CORE = GraphPackage.EDGE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL__CURRENT_VALUE = GraphPackage.EDGE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL__IDENTIFIABLE = GraphPackage.EDGE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL__EDGE = GraphPackage.EDGE_LABEL__EDGE;

	/**
	 * The number of structural features of the '<em>Pipe Transport Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL_FEATURE_COUNT = GraphPackage.EDGE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelValueImpl <em>Pipe Transport Edge Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelValueImpl
	 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getPipeTransportEdgeLabelValue()
	 * @generated
	 */
	int PIPE_TRANSPORT_EDGE_LABEL_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Max Flow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL_VALUE__MAX_FLOW = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL_VALUE__TIME_PERIOD = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pipe Transport Edge Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_TRANSPORT_EDGE_LABEL_VALUE_FEATURE_COUNT = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.transport.PipeStyleTransportSystem <em>Pipe Style Transport System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipe Style Transport System</em>'.
	 * @see org.eclipse.stem.definitions.transport.PipeStyleTransportSystem
	 * @generated
	 */
	EClass getPipeStyleTransportSystem();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.definitions.transport.PipeStyleTransportSystem#getInTransportEdges <em>In Transport Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Transport Edges</em>'.
	 * @see org.eclipse.stem.definitions.transport.PipeStyleTransportSystem#getInTransportEdges()
	 * @see #getPipeStyleTransportSystem()
	 * @generated
	 */
	EReference getPipeStyleTransportSystem_InTransportEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.definitions.transport.PipeStyleTransportSystem#getOutTransportEdges <em>Out Transport Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out Transport Edges</em>'.
	 * @see org.eclipse.stem.definitions.transport.PipeStyleTransportSystem#getOutTransportEdges()
	 * @see #getPipeStyleTransportSystem()
	 * @generated
	 */
	EReference getPipeStyleTransportSystem_OutTransportEdges();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.definitions.transport.PipeStyleTransportSystem#getMaxCapacity <em>Max Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Capacity</em>'.
	 * @see org.eclipse.stem.definitions.transport.PipeStyleTransportSystem#getMaxCapacity()
	 * @see #getPipeStyleTransportSystem()
	 * @generated
	 */
	EAttribute getPipeStyleTransportSystem_MaxCapacity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.transport.TransportSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.eclipse.stem.definitions.transport.TransportSystem
	 * @generated
	 */
	EClass getTransportSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.transport.PipeTransportEdge <em>Pipe Transport Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipe Transport Edge</em>'.
	 * @see org.eclipse.stem.definitions.transport.PipeTransportEdge
	 * @generated
	 */
	EClass getPipeTransportEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabel <em>Pipe Transport Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipe Transport Edge Label</em>'.
	 * @see org.eclipse.stem.definitions.transport.PipeTransportEdgeLabel
	 * @generated
	 */
	EClass getPipeTransportEdgeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue <em>Pipe Transport Edge Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipe Transport Edge Label Value</em>'.
	 * @see org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue
	 * @generated
	 */
	EClass getPipeTransportEdgeLabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue#getMaxFlow <em>Max Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Flow</em>'.
	 * @see org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue#getMaxFlow()
	 * @see #getPipeTransportEdgeLabelValue()
	 * @generated
	 */
	EAttribute getPipeTransportEdgeLabelValue_MaxFlow();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue#getTimePeriod <em>Time Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Period</em>'.
	 * @see org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue#getTimePeriod()
	 * @see #getPipeTransportEdgeLabelValue()
	 * @generated
	 */
	EAttribute getPipeTransportEdgeLabelValue_TimePeriod();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TransportFactory getTransportFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.transport.impl.PipeStyleTransportSystemImpl <em>Pipe Style Transport System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.transport.impl.PipeStyleTransportSystemImpl
		 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getPipeStyleTransportSystem()
		 * @generated
		 */
		EClass PIPE_STYLE_TRANSPORT_SYSTEM = eINSTANCE.getPipeStyleTransportSystem();

		/**
		 * The meta object literal for the '<em><b>In Transport Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPE_STYLE_TRANSPORT_SYSTEM__IN_TRANSPORT_EDGES = eINSTANCE.getPipeStyleTransportSystem_InTransportEdges();

		/**
		 * The meta object literal for the '<em><b>Out Transport Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPE_STYLE_TRANSPORT_SYSTEM__OUT_TRANSPORT_EDGES = eINSTANCE.getPipeStyleTransportSystem_OutTransportEdges();

		/**
		 * The meta object literal for the '<em><b>Max Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPE_STYLE_TRANSPORT_SYSTEM__MAX_CAPACITY = eINSTANCE.getPipeStyleTransportSystem_MaxCapacity();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.transport.impl.TransportSystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.transport.impl.TransportSystemImpl
		 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getTransportSystem()
		 * @generated
		 */
		EClass TRANSPORT_SYSTEM = eINSTANCE.getTransportSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeImpl <em>Pipe Transport Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeImpl
		 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getPipeTransportEdge()
		 * @generated
		 */
		EClass PIPE_TRANSPORT_EDGE = eINSTANCE.getPipeTransportEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelImpl <em>Pipe Transport Edge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelImpl
		 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getPipeTransportEdgeLabel()
		 * @generated
		 */
		EClass PIPE_TRANSPORT_EDGE_LABEL = eINSTANCE.getPipeTransportEdgeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelValueImpl <em>Pipe Transport Edge Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelValueImpl
		 * @see org.eclipse.stem.definitions.transport.impl.TransportPackageImpl#getPipeTransportEdgeLabelValue()
		 * @generated
		 */
		EClass PIPE_TRANSPORT_EDGE_LABEL_VALUE = eINSTANCE.getPipeTransportEdgeLabelValue();

		/**
		 * The meta object literal for the '<em><b>Max Flow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPE_TRANSPORT_EDGE_LABEL_VALUE__MAX_FLOW = eINSTANCE.getPipeTransportEdgeLabelValue_MaxFlow();

		/**
		 * The meta object literal for the '<em><b>Time Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPE_TRANSPORT_EDGE_LABEL_VALUE__TIME_PERIOD = eINSTANCE.getPipeTransportEdgeLabelValue_TimePeriod();

	}

} //TransportPackage
