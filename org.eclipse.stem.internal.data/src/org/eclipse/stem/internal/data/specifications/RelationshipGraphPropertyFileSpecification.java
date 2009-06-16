package org.eclipse.stem.internal.data.specifications;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.internal.data.propertydata.PropertyData;
import org.eclipse.stem.internal.data.propertydata.RelationshipPropertyData;

/**
 * This class represents an {@link IdentifiableSpecification} for relationships
 * between {@link Node}s.
 */
abstract public class RelationshipGraphPropertyFileSpecification extends
		GraphPropertyFileSpecification {

	/**
	 * This is the name of the directory that is the root of the directories
	 * that contain relationship {@link org.eclipse.stem.core.graph.Graph}.
	 */
	public static final String RELATIONSHIP_DIR = "relationship";

	@Override
	protected void initializeIdentifiableFromPropertyDataSet(
			Identifiable identifiable, List<PropertyData> propertyDataSet) {
		final Graph graph = (Graph) identifiable;
		for (final PropertyData propertyData : propertyDataSet) {
			final RelationshipPropertyData relationshipPropertyData = (RelationshipPropertyData) propertyData;
			final Edge edge = createEdge(relationshipPropertyData,
					getDublinCore().getSpatial());
			graph.putEdge(edge);
		} // for each node data

	} // initializeIdentifiableFromPropertyDataSet

	/**
	 * @return a single identifier that provides the name of the type of
	 *         relationship (e.g., "commonborder").
	 */
	abstract protected String getRelationshipName();

	/**
	 * Create an {@link Edge} that represents the relationship.
	 * 
	 * @param relationshipPropertyData
	 *            the data that defines the relationship represented by the
	 *            {@link Edge}
	 * @param spatialURI
	 *            the URI string that specifies the file with the Lat/Long data
	 *            that represents the {@link Edge} or <code>null</code> of there
	 *            is no such data.
	 * @return an {@link Edge} the represents the relationship
	 */
	abstract protected Edge createEdge(
			final RelationshipPropertyData relationshipPropertyData,
			final String spatialURI);

	/**
	 * If more than one instance of a relationship can be specified between two
	 * nodes, then this provides a disambiguating string for those two. This
	 * would typically be the case in transportation relationships where more
	 * than one road might connect two
	 * {@link org.eclipse.stem.core.graph.Node}s. If no more than one can
	 * exist return the empty string.
	 * 
	 * @return a disambiguating string e.g., "/I5"
	 */
	protected String getRelationshipSpecifier(
			@SuppressWarnings("unused") final RelationshipPropertyData relationshipGraphData) {
		return "";
	} // 

	/**
	 * @param relationshipGraphData
	 *            the {@link PropertyData} that defines the relationship.
	 * @return the {@link URI} that uniquely identifies the relationship
	 *         {@link org.eclipse.stem.core.graph.Edge}
	 */
	protected URI createRelationshipEdgeURI(
			final RelationshipPropertyData relationshipGraphData) {
		return createRelationshipURI(Edge.URI_TYPE_EDGE_SEGMENT,
				relationshipGraphData);
	} // createRelationshipEdgeURI

	/**
	 * Create a relationship {@link URI}
	 * 
	 * @param segment
	 *            the initial "segment" of the {@link URI}
	 * @param relationshipPropertyData
	 *            the {@link PropertyData} that defines the relationship.
	 * @return a {@link URI} that uniquely describes the relationship
	 */
	abstract protected URI createRelationshipURI(final String segment,
			final RelationshipPropertyData relationshipPropertyData);

	/**
	 * @return the {@link URI} that uniquely identifies the relationship
	 *         {@link Label}
	 */
	protected URI createRelationshipEdgeLabelURI(
			final RelationshipPropertyData relationshipGraphData) {
		return createRelationshipURI(Label.URI_TYPE_LABEL_SEGMENT,
				relationshipGraphData);
	} // createRelationshipEdgeLabelURI

	protected abstract EdgeLabel createEdgeLabel(
			final RelationshipPropertyData relationshipGraphData);
	
	/**
	 * @see org.eclipse.stem.internal.data.specifications.IdentifiableSpecification#createDubinCoreSubject()
	 */
	@Override
	protected String createDubinCoreSubject() {
		return createDublinCoreSubjectString( GraphPackage.Literals.EDGE.getName() , getRelationshipName());
	} // createDubinCoreSubject

	
	
} // RelationshipGraphPropertyFileSpecification
