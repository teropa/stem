package org.eclipse.stem.core.graph.impl;

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
 
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.UnresolvedIdentifiable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphFactoryImpl extends EFactoryImpl implements GraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphFactory init() {
		try {
			GraphFactory theGraphFactory = (GraphFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/core/graph.ecore"); //$NON-NLS-1$ 
			if (theGraphFactory != null) {
				return theGraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GraphPackage.EDGE: return createEdge();
			case GraphPackage.GRAPH: return createGraph();
			case GraphPackage.NODE: return createNode();
			case GraphPackage.UNRESOLVED_IDENTIFIABLE: return createUnresolvedIdentifiable();
			case GraphPackage.URI_TO_IDENTIFIABLE_MAP_ENTRY: return (EObject)createURIToIdentifiableMapEntry();
			case GraphPackage.URI_TO_EDGE_MAP_ENTRY: return (EObject)createURIToEdgeMapEntry();
			case GraphPackage.URI_TO_NODE_MAP_ENTRY: return (EObject)createURIToNodeMapEntry();
			case GraphPackage.URI_TO_LABEL_MAP_ENTRY: return (EObject)createURIToLabelMapEntry();
			case GraphPackage.URI_TO_NODE_LABEL_MAP_ENTRY: return (EObject)createURIToNodeLabelMapEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GraphPackage.URI:
				return createURIFromString(eDataType, initialValue);
			case GraphPackage.ILLEGAL_ARGUMENT_EXCEPTION:
				return createIllegalArgumentExceptionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GraphPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			case GraphPackage.ILLEGAL_ARGUMENT_EXCEPTION:
				return convertIllegalArgumentExceptionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge createEdge() {
		EdgeImpl edge = new EdgeImpl();
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph createGraph() {
		GraphImpl graph = new GraphImpl();
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnresolvedIdentifiable createUnresolvedIdentifiable() {
		UnresolvedIdentifiableImpl unresolvedIdentifiable = new UnresolvedIdentifiableImpl();
		return unresolvedIdentifiable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<URI, Identifiable> createURIToIdentifiableMapEntry() {
		URIToIdentifiableMapEntryImpl uriToIdentifiableMapEntry = new URIToIdentifiableMapEntryImpl();
		return uriToIdentifiableMapEntry;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<URI, Edge> createURIToEdgeMapEntry() {
		URIToEdgeMapEntryImpl uriToEdgeMapEntry = new URIToEdgeMapEntryImpl();
		return uriToEdgeMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<URI, Node> createURIToNodeMapEntry() {
		URIToNodeMapEntryImpl uriToNodeMapEntry = new URIToNodeMapEntryImpl();
		return uriToNodeMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<URI, Label> createURIToLabelMapEntry() {
		URIToLabelMapEntryImpl uriToLabelMapEntry = new URIToLabelMapEntryImpl();
		return uriToLabelMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<URI, NodeLabel> createURIToNodeLabelMapEntry() {
		URIToNodeLabelMapEntryImpl uriToNodeLabelMapEntry = new URIToNodeLabelMapEntryImpl();
		return uriToNodeLabelMapEntry;
	}

		/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return URI.createURI(initialValue);
	} // createURIFromString

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return instanceValue.toString();
	} // convertURIToString

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IllegalArgumentException createIllegalArgumentExceptionFromString(EDataType eDataType, String initialValue) {
		return (IllegalArgumentException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIllegalArgumentExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphPackage getGraphPackage() {
		return (GraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphPackage getPackage() {
		return GraphPackage.eINSTANCE;
	}

} //GraphFactoryImpl
