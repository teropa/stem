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
 
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.impl.IdentifiableImpl;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.GraphPackage;
//import org.eclipse.stem.core.graph.Label;
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
	 * This is used to generate unique URI's for each Edge generated
	 */
	static int edgeCounter = 0;
	
	/**
	 * The cached value of the '{@link #getA() <em>A</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected Node a;

	/**
	 * The default value of the '{@link #getNodeAURI() <em>Node AURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeAURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI NODE_AURI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeAURI() <em>Node AURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeAURI()
	 * @generated
	 * @ordered
	 */
	protected URI nodeAURI = NODE_AURI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getB() <em>B</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected Node b;

	/**
	 * The default value of the '{@link #getNodeBURI() <em>Node BURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeBURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI NODE_BURI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeBURI() <em>Node BURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeBURI()
	 * @generated
	 * @ordered
	 */
	protected URI nodeBURI = NODE_BURI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected EdgeLabel label;

	/**
	 * The default value of the '{@link #isDirected() <em>Directed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDirected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIRECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDirected() <em>Directed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDirected()
	 * @generated
	 * @ordered
	 */
	protected boolean directed = DIRECTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected EdgeImpl() {
		super();
		setURI(STEMURI.createURI(URI_TYPE_EDGE_SEGMENT + "/"
				+ Integer.toString(edgeCounter++)));
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
		if (edgeURI != null) {
			// Yes
			retValue.setURI(edgeURI);
		}
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
		if (a != null && a.eIsProxy()) {
			InternalEObject oldA = (InternalEObject)a;
			a = (Node)eResolveProxy(oldA);
			if (a != oldA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__A, oldA, a));
			}
		}
		return a;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetA() {
		return a;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setA(Node newA) {
		Node oldA = a;
		a = newA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__A, oldA, a));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getNodeAURI() {
		return nodeAURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeAURI(URI newNodeAURI) {
		URI oldNodeAURI = nodeAURI;
		nodeAURI = newNodeAURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__NODE_AURI, oldNodeAURI, nodeAURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node getB() {
		if (b != null && b.eIsProxy()) {
			InternalEObject oldB = (InternalEObject)b;
			b = (Node)eResolveProxy(oldB);
			if (b != oldB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__B, oldB, b));
			}
		}
		return b;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetB() {
		return b;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setB(Node newB) {
		Node oldB = b;
		b = newB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__B, oldB, b));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getNodeBURI() {
		return nodeBURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeBURI(URI newNodeBURI) {
		URI oldNodeBURI = nodeBURI;
		nodeBURI = newNodeBURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__NODE_BURI, oldNodeBURI, nodeBURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeLabel getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabel(EdgeLabel newLabel, NotificationChain msgs) {
		EdgeLabel oldLabel = label;
		label = newLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__LABEL, oldLabel, newLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(EdgeLabel newLabel) {
		if (newLabel != label) {
			NotificationChain msgs = null;
			if (label != null)
				msgs = ((InternalEObject)label).eInverseRemove(this, GraphPackage.EDGE_LABEL__EDGE, EdgeLabel.class, msgs);
			if (newLabel != null)
				msgs = ((InternalEObject)newLabel).eInverseAdd(this, GraphPackage.EDGE_LABEL__EDGE, EdgeLabel.class, msgs);
			msgs = basicSetLabel(newLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__LABEL, newLabel, newLabel));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDirected() {
		return directed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirected(boolean newDirected) {
		boolean oldDirected = directed;
		directed = newDirected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__DIRECTED, oldDirected, directed));
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
		return isDirected() && ( b != null && b.equals(node) 
				|| b== null && nodeBURI.equals(node.getURI()));
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
				return isDirected() ? Boolean.TRUE : Boolean.FALSE;
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
				setDirected(((Boolean)newValue).booleanValue());
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
				return a != null;
			case GraphPackage.EDGE__NODE_AURI:
				return NODE_AURI_EDEFAULT == null ? nodeAURI != null : !NODE_AURI_EDEFAULT.equals(nodeAURI);
			case GraphPackage.EDGE__B:
				return b != null;
			case GraphPackage.EDGE__NODE_BURI:
				return NODE_BURI_EDEFAULT == null ? nodeBURI != null : !NODE_BURI_EDEFAULT.equals(nodeBURI);
			case GraphPackage.EDGE__LABEL:
				return label != null;
			case GraphPackage.EDGE__DIRECTED:
				return directed != DIRECTED_EDEFAULT;
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

		result.append(a != null ? a :  ( nodeAURI != null ? nodeAURI.toString() : "null"));

		result.append(directed ? " -> " : " -- ");

		result.append(b != null ? b : ( nodeBURI != null ? nodeBURI.toString() : "null"));
		return result.toString();
	} // toString

	/**
	 * @see org.eclipse.stem.common.impl.IdentifiableImpl#sane()
	 * @generated NOT
	 */
	@Override
	public boolean sane() {
		
		boolean retValue = super.sane();

		retValue = retValue && nodeAURI != null;
		assert retValue;

		retValue = retValue && nodeBURI != null;
		assert retValue;

		retValue = retValue && label != null;
		assert retValue;

		// A node?
		if (a != null) {
			// Yes
			// If this edge links to a node, then the node should have this edge
			// as one of its edges
			retValue = retValue && a.getEdges().contains(this);
			assert retValue;

			// This edge should be hooked up to the correct node too.
			retValue = retValue && nodeAURI.equals(a.getURI());
			assert retValue;
		} // if A Node

		// B node?
		if (b != null) {
			// Yes
			// If this edge links to a node, then the node should have this edge
			// as one of its edges
			retValue = retValue && b.getEdges().contains(this);
			assert retValue;

			// This edge should be hooked up to the correct node too.
			retValue = retValue && nodeBURI.equals(b.getURI());
			assert retValue;
		}

		// Of course if one node is set, so should the other
		retValue = retValue
				&& ((a == null && b == null) || (a != null && b != null));
		assert retValue;

		// The label should reference this edge with its URI
		retValue = retValue && label.getURIOfIdentifiableToBeLabeled() != null;
		assert retValue;
		retValue = retValue
				&& label.getURIOfIdentifiableToBeLabeled().equals(getURI());
		assert retValue;

		// And the label should be sane
		retValue = retValue && label.sane();
		assert retValue;

		return retValue;
	} // sane

} // EdgeImpl
