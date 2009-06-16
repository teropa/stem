
package org.eclipse.stem.definitions.labels.impl;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.impl.EdgeImpl;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabel;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabelValue;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.definitions.labels.RoadTransportRelationshipLabel;
import org.eclipse.stem.definitions.labels.RoadTransportRelationshipLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Road Transport Relationship Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RoadTransportRelationshipLabelImpl extends PhysicalRelationshipLabelImpl implements RoadTransportRelationshipLabel {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RoadTransportRelationshipLabelImpl() {
		super();
		setCurrentValue(LabelsFactory.eINSTANCE
				.createRoadTransportRelationshipLabelValue());
	}
	
	/**
	 * Create an edge between two nodes that represents the relationship of
	 * sharing a common border.
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @param roadName
	 *            the name of the roadway
	 * @param roadClass           
	 *            the class of road (Interstate, route, etc)
	 * @param numCrossings
	 *            the number of times the road crosses between nodeA and nodeB
	 * @return an edge between the two nodes
	 */
	public static Edge createRoadTransportRelationship(final Node nodeA,
			final Node nodeB, final String roadName, final String roadClass, final int numCrossings) {
		final Edge retValue = EdgeImpl.createEdge(nodeA, nodeB);
		final RoadTransportRelationshipLabel label = LabelsFactory.eINSTANCE
				.createRoadTransportRelationshipLabel();
		label.setURIOfIdentifiableToBeLabeled(retValue.getURI());

		final RoadTransportRelationshipLabelValue labelValue = (RoadTransportRelationshipLabelValue) label
				.getCurrentValue();
		labelValue.setRoadName(roadName);
		labelValue.setRoadClass(roadClass);
		labelValue.setNumberCrossings(numCrossings);
		retValue.setLabel(label);

		return retValue;
	} // createCommonBorderRelationship
	
	
	/**
	 * @param node
	 *            the node
	 * @return the Edges that represent the common border relationship between
	 *         the node and other nodes.
	 * @generated NOT
	 */
	public static List<Edge> getRoadEdgesFromNode(final Node node) {
		final List<Edge> retValue = new ArrayList<Edge>();

		if(node == null || node.getEdges() == null) return retValue;
		
		for (Iterator<Edge> edgeIter = node.getEdges().iterator(); edgeIter.hasNext();) {
			final Edge edge = edgeIter.next();
			final EdgeLabel edgeLabel = edge.getLabel();
			// Is the label a common border label?
			if (edgeLabel instanceof RoadTransportRelationshipLabel) {
				// Yes
				retValue.add(edge);
			}
		} // for

		return retValue;
	} // getCommonBorderEdgesFromNode
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.ROAD_TRANSPORT_RELATIONSHIP_LABEL;
	}

} //RoadTransportRelationshipLabelImpl
