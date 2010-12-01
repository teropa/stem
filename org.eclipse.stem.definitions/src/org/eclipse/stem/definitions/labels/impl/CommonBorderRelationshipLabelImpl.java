package org.eclipse.stem.definitions.labels.impl;

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

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Common Border Relationship Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CommonBorderRelationshipLabelImpl extends
		PhysicalRelationshipLabelImpl implements CommonBorderRelationshipLabel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected CommonBorderRelationshipLabelImpl() {
		super();
		setCurrentValue(LabelsFactory.eINSTANCE
				.createCommonBorderRelationshipLabelValue());
	} // CommonBorderRelationshipLabelImpl

	/**
	 * Create an edge between two nodes that represents the relationship of
	 * sharing a common border.
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @param borderLength
	 *            the length of the border (km's)
	 * @return an edge between the two nodes
	 */
	public static Edge createCommonBorderRelationship(final Node nodeA,
			final Node nodeB, final int borderLength) {
		final Edge retValue = EdgeImpl.createEdge(nodeA, nodeB);
		final CommonBorderRelationshipLabel label = LabelsFactory.eINSTANCE
				.createCommonBorderRelationshipLabel();
		label.setURIOfIdentifiableToBeLabeled(retValue.getURI());

		final CommonBorderRelationshipLabelValue labelValue = (CommonBorderRelationshipLabelValue) label
				.getCurrentValue();
		labelValue.setBorderLength(borderLength);

		retValue.setLabel(label);

		return retValue;
	} // createCommonBorderRelationship

	/**
	 * @param node
	 *            the node
	 * @return the Edges that represent the common border relationship between
	 *         the node and other nodes.
	 */
	public static List<Edge> getCommonBorderEdgesFromNode(final Node node) {
		final List<Edge> retValue = new ArrayList<Edge>();

		if(node == null || node.getEdges() == null) return retValue;
		
		for (Iterator<Edge> edgeIter = node.getEdges().iterator(); edgeIter.hasNext();) {
			final Edge edge = edgeIter.next();
			final EdgeLabel edgeLabel = edge.getLabel();
			// Is the label a common border label?
			if (edgeLabel instanceof CommonBorderRelationshipLabel) {
				// Yes
				retValue.add(edge);
			}
		} // for

		return retValue;
	} // getCommonBorderEdgesFromNode

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.COMMON_BORDER_RELATIONSHIP_LABEL;
	}

} // CommonBorderRelationshipLabelImpl
