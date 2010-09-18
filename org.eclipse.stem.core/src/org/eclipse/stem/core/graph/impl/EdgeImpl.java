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
 
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.impl.IdentifiableImpl;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.Node;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.impl.EdgeImpl#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.EdgeImpl#getNodeAURI <em>Node AURI</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.EdgeImpl#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.EdgeImpl#getNodeBURI <em>Node BURI</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.EdgeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.EdgeImpl#isDirected <em>Directed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeImpl extends IdentifiableImpl implements Edge {
	
	
	/**
	 * The default value of the '{@link #getNodeAURI() <em>Node AURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeAURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI NODE_AURI_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getNodeBURI() <em>Node BURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeBURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI NODE_BURI_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isDirected() <em>Directed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDirected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIRECTED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected EdgeImpl() {
		super();
//		setURI(STEMURI.createURI(URI_TYPE_EDGE_SEGMENT + "/"
//				+ STEMURI.generateUniquePart()));
		setTypeURI(STEMURI.EDGE_TYPE_URI);
	} // EdgeImpl

	/**
	 * Create an undirected edge between two nodes
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @return an edge between nodeA and nodeB, if directed then from nodeA to
	 *         nodeB
	 */
	public static Edge createEdge(final Node nodeA, final Node nodeB) {
		return createEdge(nodeA, nodeB, false, null);
	} // createEdge

	/**
	 * Create an undirected edge between two nodes
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @param edgeURI
	 *            if non-null then the URI to use for the edge, if null then the
	 *            default is used.
	 * 
	 * @return an edge between nodeA and nodeB, if directed then from nodeA to
	 *         nodeB
	 */
	public static Edge createEdge(final Node nodeA, final Node nodeB,
			final URI edgeURI) {
		return createEdge(nodeA, nodeB, false, edgeURI);
	} // createEdge

	/**
	 * Create an edge between the two nodes
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @return an edge between nodeA and nodeB, if directed then from nodeA to
	 *         nodeB
	 */
	public static Edge createEdge(final Node nodeA, final Node nodeB,
			final boolean directed) {
		return createEdge(nodeA, nodeB, directed, null);
	} // createEdge

	/**
	 * Create an edge between the two nodes
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @param edgeURI
	 *            if non-null then the URI to use for the edge, if null then the
	 *            default is used.
	 * 
	 * @return an edge between nodeA and nodeB, if directed then from nodeA to
	 *         nodeB
	 */
	public static Edge createEdge(final Node nodeA, final Node nodeB,
			final boolean directed, final URI edgeURI) {
		final Edge retValue = createEdge(nodeA.getURI(), nodeB.getURI(),
				directed, edgeURI);
		retValue.setA(nodeA);
		retValue.setB(nodeB);

		nodeA.getEdges().add(retValue);
		nodeB.getEdges().add(retValue);

		return retValue;
	} // createEdge

	/**
	 * Create an undirected edge with two node URI's
	 * 
	 * @param nodeAURI
	 *            the first node's URI
	 * @param nodeBURI
	 *            the second node's URI
	 * 
	 * @return an edge with two URI's, if directed then from nodeAURI to
	 *         nodeBURI
	 */
	public static Edge createEdge(final URI nodeAURI, final URI nodeBURI) {
		return createEdge(nodeAURI, nodeBURI, false, null);
	} // createEdge

	/**
	 * Create an undirected edge with two node URI's
	 * 
	 * @param nodeAURI
	 *            the first node's URI
	 * @param nodeBURI
	 *            the second node's URI
	 * @param edgeURI
	 *            if non-null then the URI to use for the edge, if null then the
	 *            default is used.
	 * 
	 * @return an edge with two URI's, if directed then from nodeAURI to
	 *         nodeBURI
	 */
	public static Edge createEdge(final URI nodeAURI, final URI nodeBURI,
			final URI edgeURI) {
		return createEdge(nodeAURI, nodeBURI, false, edgeURI);
	} // createEdge

	/**
	 * Create an edge with two node URI's
	 * 
	 * @param nodeAURI
	 *            the first node's URI
	 * @param nodeBURI
	 *            the second node's URI
	 * @param directed
	 *            true if the edge is directed from nodeAURI to nodeBURI
	 * 
	 * @return an edge with two URI's, if directed then from nodeAURI to
	 *         nodeBURI
	 */
	public static Edge createEdge(final URI nodeAURI, final URI nodeBURI,
			final boolean directed) {
		return createEdge(nodeAURI, nodeBURI, directed, null);
	} // createEdge

	/**
	 * Create an edge with two node URI's
	 * 
	 * @param nodeAURI
	 *            the first node's URI
	 * @param nodeBURI
	 *            the second node's URI
	 * @param directed
	 *            true if the edge is directed from nodeAURI to nodeBURI
	 * 
	 * @param edgeURI
	 *            if non-null then the URI to use for the edge, if null then the
	 *            default is used.
	 * 
	 * @return an edge with two URI's, if directed then from nodeAURI to
	 *         nodeBURI
	 */
	public static Edge createEdge(final URI nodeAURI, final URI nodeBURI,
			final boolean directed, final URI edgeURI) {
		final Edge retValue = GraphFactory.eINSTANCE.createEdge();
		retValue.setNodeAURI(nodeAURI);
		retValue.setNodeBURI(nodeBURI);
		retValue.setDirected(directed);
		// Edge URI specified?
		if (edgeURI != null) 
			// Yes
			retValue.setURI(edgeURI);
		else 
			retValue.setURI(STEMURI.createURI(URI_TYPE_EDGE_SEGMENT + "/"
					+ STEMURI.generateUniquePart()));
		return retValue;
	} // createEdge

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node getA() {
		return (Node)eDynamicGet(GraphPackage.EDGE__A, GraphPackage.Literals.EDGE__A, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetA() {
		return (Node)eDynamicGet(GraphPackage.EDGE__A, GraphPackage.Literals.EDGE__A, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setA(Node newA) {
		eDynamicSet(GraphPackage.EDGE__A, GraphPackage.Literals.EDGE__A, newA);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getNodeAURI() {
		return (URI)eDynamicGet(GraphPackage.EDGE__NODE_AURI, GraphPackage.Literals.EDGE__NODE_AURI, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeAURI(URI newNodeAURI) {
		eDynamicSet(GraphPackage.EDGE__NODE_AURI, GraphPackage.Literals.EDGE__NODE_AURI, newNodeAURI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node getB() {
		return (Node)eDynamicGet(GraphPackage.EDGE__B, GraphPackage.Literals.EDGE__B, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetB() {
		return (Node)eDynamicGet(GraphPackage.EDGE__B, GraphPackage.Literals.EDGE__B, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setB(Node newB) {
		eDynamicSet(GraphPackage.EDGE__B, GraphPackage.Literals.EDGE__B, newB);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getNodeBURI() {
		return (URI)eDynamicGet(GraphPackage.EDGE__NODE_BURI, GraphPackage.Literals.EDGE__NODE_BURI, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeBURI(URI newNodeBURI) {
		eDynamicSet(GraphPackage.EDGE__NODE_BURI, GraphPackage.Literals.EDGE__NODE_BURI, newNodeBURI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeLabel getLabel() {
		return (EdgeLabel)eDynamicGet(GraphPackage.EDGE__LABEL, GraphPackage.Literals.EDGE__LABEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabel(EdgeLabel newLabel, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newLabel, GraphPackage.EDGE__LABEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(EdgeLabel newLabel) {
		eDynamicSet(GraphPackage.EDGE__LABEL, GraphPackage.Literals.EDGE__LABEL, newLabel);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDirected() {
		return (Boolean)eDynamicGet(GraphPackage.EDGE__DIRECTED, GraphPackage.Literals.EDGE__DIRECTED, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirected(boolean newDirected) {
		eDynamicSet(GraphPackage.EDGE__DIRECTED, GraphPackage.Literals.EDGE__DIRECTED, newDirected);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * Given one node of an edge, return the other.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Node getOtherNode(Node node) {
		assert getA().equals(node) || getB().equals(node);
		return getA().equals(node) ? getB() : getA();
	} // getOtherNode

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return <code>true</code> if the node is B and the edge is directed.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isDirectedAt(Node node) {
		return isDirected() && ( getB() != null && getB().equals(node) 
				|| getB()== null && getNodeBURI().equals(node.getURI()));
	} // isDirectedAt

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.EDGE__LABEL:
				EdgeLabel label = getLabel();
				if (label != null)
					msgs = ((InternalEObject)label).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphPackage.EDGE__LABEL, null, msgs);
				return basicSetLabel((EdgeLabel)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.EDGE__LABEL:
				return basicSetLabel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.EDGE__A:
				if (resolve) return getA();
				return basicGetA();
			case GraphPackage.EDGE__NODE_AURI:
				return getNodeAURI();
			case GraphPackage.EDGE__B:
				if (resolve) return getB();
				return basicGetB();
			case GraphPackage.EDGE__NODE_BURI:
				return getNodeBURI();
			case GraphPackage.EDGE__LABEL:
				return getLabel();
			case GraphPackage.EDGE__DIRECTED:
				return isDirected();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.EDGE__A:
				setA((Node)newValue);
				return;
			case GraphPackage.EDGE__NODE_AURI:
				setNodeAURI((URI)newValue);
				return;
			case GraphPackage.EDGE__B:
				setB((Node)newValue);
				return;
			case GraphPackage.EDGE__NODE_BURI:
				setNodeBURI((URI)newValue);
				return;
			case GraphPackage.EDGE__LABEL:
				setLabel((EdgeLabel)newValue);
				return;
			case GraphPackage.EDGE__DIRECTED:
				setDirected((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphPackage.EDGE__A:
				setA((Node)null);
				return;
			case GraphPackage.EDGE__NODE_AURI:
				setNodeAURI(NODE_AURI_EDEFAULT);
				return;
			case GraphPackage.EDGE__B:
				setB((Node)null);
				return;
			case GraphPackage.EDGE__NODE_BURI:
				setNodeBURI(NODE_BURI_EDEFAULT);
				return;
			case GraphPackage.EDGE__LABEL:
				setLabel((EdgeLabel)null);
				return;
			case GraphPackage.EDGE__DIRECTED:
				setDirected(DIRECTED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphPackage.EDGE__A:
				return basicGetA() != null;
			case GraphPackage.EDGE__NODE_AURI:
				return NODE_AURI_EDEFAULT == null ? getNodeAURI() != null : !NODE_AURI_EDEFAULT.equals(getNodeAURI());
			case GraphPackage.EDGE__B:
				return basicGetB() != null;
			case GraphPackage.EDGE__NODE_BURI:
				return NODE_BURI_EDEFAULT == null ? getNodeBURI() != null : !NODE_BURI_EDEFAULT.equals(getNodeBURI());
			case GraphPackage.EDGE__LABEL:
				return getLabel() != null;
			case GraphPackage.EDGE__DIRECTED:
				return isDirected() != DIRECTED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer("");

		result.append(getA() != null ? getA() :  ( getNodeAURI() != null ? getNodeAURI().toString() : "null"));

		result.append(isDirected() ? " -> " : " -- ");

		result.append(getB() != null ? getB() : ( getNodeBURI() != null ? getNodeBURI().toString() : "null"));
		return result.toString();
	} // toString

	/**
	 * @see org.eclipse.stem.common.impl.IdentifiableImpl#sane()
	 * @generated NOT
	 */
	@Override
	public boolean sane() {
		
		boolean retValue = super.sane();

		retValue = retValue && getNodeAURI() != null;
		assert retValue;

		retValue = retValue && getNodeBURI() != null;
		assert retValue;

		retValue = retValue && getLabel() != null;
		assert retValue;

		// A node?
		if (getA() != null) {
			// Yes
			// If this edge links to a node, then the node should have this edge
			// as one of its edges
			retValue = retValue && getA().getEdges().contains(this);
			assert retValue;

			// This edge should be hooked up to the correct node too.
			retValue = retValue && getNodeAURI().equals(getA().getURI());
			assert retValue;
		} // if A Node

		// B node?
		if (getB() != null) {
			// Yes
			// If this edge links to a node, then the node should have this edge
			// as one of its edges
			retValue = retValue && getB().getEdges().contains(this);
			assert retValue;

			// This edge should be hooked up to the correct node too.
			retValue = retValue && getNodeBURI().equals(getB().getURI());
			assert retValue;
		}

		// Of course if one node is set, so should the other
		retValue = retValue
				&& ((getA() == null && getB() == null) || (getA() != null && getB() != null));
		assert retValue;

		// The label should reference this edge with its URI
		retValue = retValue && getLabel().getURIOfIdentifiableToBeLabeled() != null;
		assert retValue;
		retValue = retValue
				&& getLabel().getURIOfIdentifiableToBeLabeled().equals(getURI());
		assert retValue;

		// And the label should be sane
		retValue = retValue && getLabel().sane();
		assert retValue;

		return retValue;
	} // sane

} // EdgeImpl
