package org.eclipse.stem.core.graph.util;

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
 
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.SanityChecker;

import org.eclipse.stem.core.graph.*;

import org.eclipse.stem.core.modifier.Modifiable;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.StaticNodeLabel;
import org.eclipse.stem.core.graph.UnresolvedIdentifiable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.core.graph.GraphPackage
 * @generated
 */
public class GraphSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphSwitch() {
		if (modelPackage == null) {
			modelPackage = GraphPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T1 doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GraphPackage.DYNAMIC_LABEL: {
				DynamicLabel dynamicLabel = (DynamicLabel)theEObject;
				T1 result = caseDynamicLabel(dynamicLabel);
				if (result == null) result = caseLabel(dynamicLabel);
				if (result == null) result = caseIdentifiable(dynamicLabel);
				if (result == null) result = caseComparable(dynamicLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.DYNAMIC_NODE_LABEL: {
				DynamicNodeLabel dynamicNodeLabel = (DynamicNodeLabel)theEObject;
				T1 result = caseDynamicNodeLabel(dynamicNodeLabel);
				if (result == null) result = caseDynamicLabel(dynamicNodeLabel);
				if (result == null) result = caseNodeLabel(dynamicNodeLabel);
				if (result == null) result = caseLabel(dynamicNodeLabel);
				if (result == null) result = caseIdentifiable(dynamicNodeLabel);
				if (result == null) result = caseComparable(dynamicNodeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.EDGE: {
				Edge edge = (Edge)theEObject;
				T1 result = caseEdge(edge);
				if (result == null) result = caseIdentifiable(edge);
				if (result == null) result = caseModifiable(edge);
				if (result == null) result = caseComparable(edge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.GRAPH: {
				Graph graph = (Graph)theEObject;
				T1 result = caseGraph(graph);
				if (result == null) result = caseIdentifiable(graph);
				if (result == null) result = caseComparable(graph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.LABEL: {
				Label label = (Label)theEObject;
				T1 result = caseLabel(label);
				if (result == null) result = caseIdentifiable(label);
				if (result == null) result = caseComparable(label);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.LABEL_VALUE: {
				LabelValue labelValue = (LabelValue)theEObject;
				T1 result = caseLabelValue(labelValue);
				if (result == null) result = caseSanityChecker(labelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.NODE: {
				Node node = (Node)theEObject;
				T1 result = caseNode(node);
				if (result == null) result = caseIdentifiable(node);
				if (result == null) result = caseComparable(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.NODE_LABEL: {
				NodeLabel nodeLabel = (NodeLabel)theEObject;
				T1 result = caseNodeLabel(nodeLabel);
				if (result == null) result = caseLabel(nodeLabel);
				if (result == null) result = caseIdentifiable(nodeLabel);
				if (result == null) result = caseComparable(nodeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.STATIC_NODE_LABEL: {
				StaticNodeLabel staticNodeLabel = (StaticNodeLabel)theEObject;
				T1 result = caseStaticNodeLabel(staticNodeLabel);
				if (result == null) result = caseNodeLabel(staticNodeLabel);
				if (result == null) result = caseStaticLabel(staticNodeLabel);
				if (result == null) result = caseLabel(staticNodeLabel);
				if (result == null) result = caseModifiable(staticNodeLabel);
				if (result == null) result = caseIdentifiable(staticNodeLabel);
				if (result == null) result = caseComparable(staticNodeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.UNRESOLVED_IDENTIFIABLE: {
				UnresolvedIdentifiable unresolvedIdentifiable = (UnresolvedIdentifiable)theEObject;
				T1 result = caseUnresolvedIdentifiable(unresolvedIdentifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.URI_TO_IDENTIFIABLE_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<URI, Identifiable> uriToIdentifiableMapEntry = (Map.Entry<URI, Identifiable>)theEObject;
				T1 result = caseURIToIdentifiableMapEntry(uriToIdentifiableMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.DYNAMIC_EDGE_LABEL: {
				DynamicEdgeLabel dynamicEdgeLabel = (DynamicEdgeLabel)theEObject;
				T1 result = caseDynamicEdgeLabel(dynamicEdgeLabel);
				if (result == null) result = caseDynamicLabel(dynamicEdgeLabel);
				if (result == null) result = caseEdgeLabel(dynamicEdgeLabel);
				if (result == null) result = caseLabel(dynamicEdgeLabel);
				if (result == null) result = caseIdentifiable(dynamicEdgeLabel);
				if (result == null) result = caseComparable(dynamicEdgeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.EDGE_LABEL: {
				EdgeLabel edgeLabel = (EdgeLabel)theEObject;
				T1 result = caseEdgeLabel(edgeLabel);
				if (result == null) result = caseLabel(edgeLabel);
				if (result == null) result = caseIdentifiable(edgeLabel);
				if (result == null) result = caseComparable(edgeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.STATIC_EDGE_LABEL: {
				StaticEdgeLabel staticEdgeLabel = (StaticEdgeLabel)theEObject;
				T1 result = caseStaticEdgeLabel(staticEdgeLabel);
				if (result == null) result = caseEdgeLabel(staticEdgeLabel);
				if (result == null) result = caseStaticLabel(staticEdgeLabel);
				if (result == null) result = caseLabel(staticEdgeLabel);
				if (result == null) result = caseModifiable(staticEdgeLabel);
				if (result == null) result = caseIdentifiable(staticEdgeLabel);
				if (result == null) result = caseComparable(staticEdgeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.URI_TO_EDGE_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<URI, Edge> uriToEdgeMapEntry = (Map.Entry<URI, Edge>)theEObject;
				T1 result = caseURIToEdgeMapEntry(uriToEdgeMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.URI_TO_NODE_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<URI, Node> uriToNodeMapEntry = (Map.Entry<URI, Node>)theEObject;
				T1 result = caseURIToNodeMapEntry(uriToNodeMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.URI_TO_LABEL_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<URI, Label> uriToLabelMapEntry = (Map.Entry<URI, Label>)theEObject;
				T1 result = caseURIToLabelMapEntry(uriToLabelMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.URI_TO_NODE_LABEL_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<URI, NodeLabel> uriToNodeLabelMapEntry = (Map.Entry<URI, NodeLabel>)theEObject;
				T1 result = caseURIToNodeLabelMapEntry(uriToNodeLabelMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphPackage.STATIC_LABEL: {
				StaticLabel staticLabel = (StaticLabel)theEObject;
				T1 result = caseStaticLabel(staticLabel);
				if (result == null) result = caseLabel(staticLabel);
				if (result == null) result = caseModifiable(staticLabel);
				if (result == null) result = caseIdentifiable(staticLabel);
				if (result == null) result = caseComparable(staticLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicLabel(DynamicLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraph(Graph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLabelValue(LabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unresolved Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unresolved Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUnresolvedIdentifiable(UnresolvedIdentifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URI To Identifiable Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URI To Identifiable Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseURIToIdentifiableMapEntry(Map.Entry<URI, Identifiable> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sanity Checker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sanity Checker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSanityChecker(SanityChecker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicEdgeLabel(DynamicEdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEdgeLabel(EdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStaticEdgeLabel(StaticEdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URI To Edge Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URI To Edge Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseURIToEdgeMapEntry(Map.Entry<URI, Edge> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URI To Node Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URI To Node Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseURIToNodeMapEntry(Map.Entry<URI, Node> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URI To Label Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URI To Label Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseURIToLabelMapEntry(Map.Entry<URI, Label> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URI To Node Label Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URI To Node Label Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseURIToNodeLabelMapEntry(Map.Entry<URI, NodeLabel> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStaticLabel(StaticLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseComparable(Comparable<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Node Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Node Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicNodeLabel(DynamicNodeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Node Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Node Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStaticNodeLabel(StaticNodeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNodeLabel(NodeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModifiable(Modifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T1 defaultCase(EObject object) {
		return null;
	}

} //GraphSwitch
