package org.eclipse.stem.diseasemodels.standard.impl;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.definitions.labels.TransportMode;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabel;
import org.eclipse.stem.diseasemodels.standard.AggregatingDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Aggregating Disease Model State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.AggregatingDiseaseModelStateImpl#getChildrensLabels <em>Childrens Labels</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregatingDiseaseModelStateImpl extends DiseaseModelStateImpl
		implements AggregatingDiseaseModelState {

	// A list of the names of the transportation modes
	protected List<TransportMode> transportModes = null;

	// Map between transport mode and list of children's transport
	protected Map<TransportMode, List<Edge>> childTransportEdges = null;

	// Map between transport mode and list of parent/peer edges
	protected Map<TransportMode, List<Edge>> parentPeerTransportEdges = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatingDiseaseModelStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.AGGREGATING_DISEASE_MODEL_STATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SILabel> getChildrensLabels() {
		return (EList<SILabel>)eDynamicGet(StandardPackage.AGGREGATING_DISEASE_MODEL_STATE__CHILDRENS_LABELS, StandardPackage.Literals.AGGREGATING_DISEASE_MODEL_STATE__CHILDRENS_LABELS, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.AGGREGATING_DISEASE_MODEL_STATE__CHILDRENS_LABELS:
				return getChildrensLabels();
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
			case StandardPackage.AGGREGATING_DISEASE_MODEL_STATE__CHILDRENS_LABELS:
				getChildrensLabels().clear();
				getChildrensLabels().addAll((Collection<? extends SILabel>)newValue);
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
			case StandardPackage.AGGREGATING_DISEASE_MODEL_STATE__CHILDRENS_LABELS:
				getChildrensLabels().clear();
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
			case StandardPackage.AGGREGATING_DISEASE_MODEL_STATE__CHILDRENS_LABELS:
				return !getChildrensLabels().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @return a list of the transportation modes that send and receive
	 *         population members to and from the <code>Node</code> labeled by
	 *         the disease model label.
	 */
	public List<TransportMode> getTransportModes() {
		// Have we set the transport modes yet?
		if (transportModes == null) {
			// No
			initializeTransportCollections();
		} // if transport modes

		return transportModes;
	} // getTransportModes

	/**
	 * @return a Map between the transportation modes that send and receive
	 *         population members to and from the <code>Node</code> labeled by
	 *         the disease model label and the <code>Edge</code>s to/from the
	 *         <code>Node</code>'s children.
	 */
	public Map<TransportMode, List<Edge>> getChildTransportEdges() {
		// Have we set the child transport edges yet?
		if (childTransportEdges == null) {
			// No
			initializeTransportCollections();
		}
		return childTransportEdges;
	} // getChildTransportEdges

	/**
	 * @return a Map between the transportation modes that send and receive
	 *         population members to and from the <code>Node</code> labeled by
	 *         the disease model label and the <code>Edge</code>s to/from the
	 *         <code>Node</code>'s parent and peers (i.e., not the children).
	 */
	public Map<TransportMode, List<Edge>> getParentPeerTransportEdges() {
		// Have we set the child transport edges yet?
		if (parentPeerTransportEdges == null) {
			// No
			initializeTransportCollections();
		}
		return parentPeerTransportEdges;
	} // getParentPeerTransportEdges

	/**
	 * Initialize the values returned by {@link #getTransportModes()},
	 * {@link #getChildrensLabels()}, and
	 * {@link #getParentPeerTransportEdges()}.
	 * 
	 */
	protected void initializeTransportCollections() {
		transportModes = new ArrayList<TransportMode>();
		childTransportEdges = new HashMap<TransportMode, List<Edge>>();
		parentPeerTransportEdges = new HashMap<TransportMode, List<Edge>>();

		final Node node = getLabel().getNode();

		final List<Edge> transportEdges = getTransportEdges(node);

		// Sort out the transport edges
		for (Edge edge : transportEdges) {
			// Is the edge with one this node's children?
			if (isEdgeWithAChildNode(edge, node)) {
				// Yes
				addEdge(edge, childTransportEdges);
			} else {
				// No
				// Must be the parent or a peer
				addEdge(edge, parentPeerTransportEdges);
			}
		} // for each edge

		final Set<TransportMode> tempSet = new HashSet<TransportMode>();
		tempSet.addAll(childTransportEdges.keySet());
		tempSet.addAll(parentPeerTransportEdges.keySet());
		transportModes.addAll(tempSet);
	} // initializeTransportCollections

	/**
	 * @param node
	 * @return all of the transportation edges to/from the argument
	 *         <code>Node</code>
	 */
	public static List<Edge> getTransportEdges(Node node) {
		final List<Edge> retValue = new ArrayList<Edge>();

		for (final Iterator<Edge> edgeIter = node.getEdges().iterator(); edgeIter
				.hasNext();) {
			final Edge edge = edgeIter.next();
			// Is this a transportation edge?
			final Label label = edge.getLabel();
			if (label instanceof TransportRelationshipLabel) {
				// Yes
				retValue.add(edge);
			}
		} // for each edge

		return retValue;
	} // getTransportEdges

	/**
	 * @param edge
	 * @param node
	 * @return <code>true</code> if the <code>Edge</code> is with one of the
	 *         <code>Node</code>'s children.
	 */
	private boolean isEdgeWithAChildNode(Edge edge, Node node) {
		boolean retValue = false;
		final Node otherNode = edge.getOtherNode(node);
		retValue = AggregatingSIDiseaseModelImpl.getParentNode(otherNode) == node;
		return retValue;
	} // isEdgeWithAChildNode

	/**
	 * Add the edge to the map under the correct transportation mode
	 * 
	 * @param edge
	 * @param transportMap
	 */
	private void addEdge(Edge edge, Map<TransportMode, List<Edge>> transportMap) {
		// Get the transport mode
		final TransportRelationshipLabel trl = (TransportRelationshipLabel) edge
				.getLabel();
		final TransportMode transportMode = trl.getTransportMode();
		List<Edge> edgeList = transportMap.get(transportMode);
		// Was there already a list?
		if (edgeList == null) {
			// No
			// ...there will be.
			edgeList = new ArrayList<Edge>();
			transportMap.put(transportMode, edgeList);
		}
		edgeList.add(edge);
	} // addEdge

} // AggregatingDiseaseModelStateImpl
