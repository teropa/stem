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
 
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.impl.IdentifiableImpl;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.impl.NodeImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.NodeImpl#getLabels <em>Labels</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends IdentifiableImpl implements Node {

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edges;

	/**
	 * The cached value of the '{@link #getLabels() <em>Labels</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeLabel> labels;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected NodeImpl() {
		super();
		setURI(STEMURI.createURI(URI_TYPE_NODE_SEGMENT + "/"
				+ STEMURI.generateUniquePart()));
		setTypeURI(STEMURI.NODE_TYPE_URI);
	} // NodeImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdges() {
		if (edges == null) {
			edges = new EObjectResolvingEList<Edge>(Edge.class, this, GraphPackage.NODE__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeLabel> getLabels() {
		if (labels == null) {
			labels = new EObjectWithInverseResolvingEList<NodeLabel>(NodeLabel.class, this, GraphPackage.NODE__LABELS, GraphPackage.NODE_LABEL__NODE);
		}
		return labels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.NODE__LABELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLabels()).basicAdd(otherEnd, msgs);
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
			case GraphPackage.NODE__LABELS:
				return ((InternalEList<?>)getLabels()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * @see org.eclipse.stem.common.impl.IdentifiableImpl#sane()
	 * @generated NOT
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		if (labels != null) {
			// All the labels should be sane
			for (final Iterator<NodeLabel> labelIter = getLabels().iterator(); labelIter
					.hasNext()
					&& retValue;) {
				final NodeLabel nodeLabel = labelIter.next();
				// The sanity of individual NodeLabels is checked elsewhere
				// The node label should be the one that labels this node
				retValue = retValue
						&& nodeLabel.getURIOfIdentifiableToBeLabeled().equals(
								getURI());
				assert retValue;
			} // for each label
		}
		// All the edges should be sane
		// We don't test that because their test is to check their nodes
		// which results in infinite recursion

		return retValue;
	} // sane

	/**
	 * @see org.eclipse.stem.common.impl.IdentifiableImpl#toString()
	 * @generated NOT
	 */
	@Override
	public String toString() {
		// Return the title of the node from it's DublinCore if it is set
		final String title = getDublinCore().getTitle();
		return (title != null) ? title : super.toString();
	} // toString

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.NODE__EDGES:
				return getEdges();
			case GraphPackage.NODE__LABELS:
				return getLabels();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.NODE__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case GraphPackage.NODE__LABELS:
				getLabels().clear();
				getLabels().addAll((Collection<? extends NodeLabel>)newValue);
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
			case GraphPackage.NODE__EDGES:
				getEdges().clear();
				return;
			case GraphPackage.NODE__LABELS:
				getLabels().clear();
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
			case GraphPackage.NODE__EDGES:
				return edges != null && !edges.isEmpty();
			case GraphPackage.NODE__LABELS:
				return labels != null && !labels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // NodeImpl
