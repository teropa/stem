package org.eclipse.stem.definitions.lattice.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.impl.EdgeImpl;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabel;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel;
import org.eclipse.stem.definitions.labels.impl.CommonBorderRelationshipLabelImpl;
import org.eclipse.stem.definitions.lattice.GraphLatticeGeneratorInterface;
import org.eclipse.stem.definitions.nodes.NodesFactory;
import org.eclipse.stem.definitions.nodes.Region;



/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

public abstract class GraphLatticeGenerator implements GraphLatticeGeneratorInterface {

	/**
	 * @param x
	 *            the x coord of the node in the lattice
	 * @param y
	 *            the y coord of the node in the lattice
	 * @return a node
	 */
	public static Region createRegionNode(String uriPrefix, int x, int y, Graph graph) {
		final Region node = NodesFactory.eINSTANCE.createRegion();
		final DublinCore dc = node.getDublinCore();
		dc.setTitle(createNodeTitle(x, y));
		node.setURI(createRegionNodeURI(uriPrefix, x, y, graph));
		return node;
	} // createRegionNode
	

	/**
	 * 
	 * @param uriPrefix
	 * @param lat
	 * @param lng
	 * @param graph
	 * @return node
	 */
	public static Region createRegionNode(String uriPrefix, String lat, String lng, Graph graph) {
		final Region node = NodesFactory.eINSTANCE.createRegion();
		final DublinCore dc = node.getDublinCore();
		dc.setTitle(createNodeTitle(lat, lng));
		node.setURI(createRegionNodeURI(uriPrefix, lat, lng, graph));
		return node;
	} // createRegionNode
	
	
	
	/**
	 * @param x
	 *            the lat of the node in the lattice
	 * @param y
	 *            the lng of the node in the lattice
	 * @return a title for a node
	 */
	public static String createNodeTitle(double x, double y) {
		final StringBuilder sb = new StringBuilder("Node[");
		sb.append(Double.toString(x));
		sb.append(", ");
		sb.append(Double.toString(y));
		sb.append("]");
		return sb.toString();
	} // createNodeTitle
	
	/**
	 * @param x
	 *            the lat of the node as a string. Allows N/S indicator
	 * @param y
	 *            the lng of the node as a string. Allows N/S indicator
	 * @return a title for a node
	 */
	public static String createNodeTitle(String x, String y) {
		final StringBuilder sb = new StringBuilder("Node[");
		sb.append(x);
		sb.append(", ");
		sb.append(y);
		sb.append("]");
		return sb.toString();
	} // createNodeTitle
	
	
	/**
	 * @param x
	 *            the x of the region in the lattice
	 * @param y
	 *            the y of the region in the lattice
	 * @return a URI for the region node
	 */
	public static URI createRegionNodeURI(String uriPrefix, int x, int y, Graph graph) {
		String nodeUriSuffix = uriPrefix+x+"_"+y;
		String nodeUriString = Node.URI_TYPE_NODE_SEGMENT + "/"
								+ graph.getURI().lastSegment()+"/"
								+ nodeUriSuffix;
		
        URI uri = STEMURI.createURI(nodeUriString);
		return uri;
	} // createRegionNodeURI
	
	/**
	 * @param x
	 *            the x of the region node as a string. Allows N/S indicator
	 * @param y
	 *            the y of the region node as a string. Allows N/S indicator
	 * @return a URI for the region node
	 */
	public static URI createRegionNodeURI(String uriPrefix, String x, String y, Graph graph) {
		String nodeUriSuffix = uriPrefix+x+"_"+y;
		String nodeUriString = Node.URI_TYPE_NODE_SEGMENT + "/"
								+ graph.getURI().lastSegment()+"/"
								+ nodeUriSuffix;
		
        URI uri = STEMURI.createURI(nodeUriString);
		return uri;
	} // createRegionNodeURI
	
	
	/**
	 * @param x
	 *            the x of the region in the lattice
	 * @param y
	 *            the y of the region in the lattice
	 * @return a URI for the region node
	 */
	private static URI createEdgeLabelURI(Node nodeA, Node nodeB) {
		URI uriA = nodeA.getURI();
		URI uriB = nodeB.getURI();
		String sA = uriA.lastSegment();
		String sB = uriB.lastSegment();
		// CommonBorderRelationshipLabelItemProvider
		// uses _ as a special character to separate the two nodes
		// so we need to replace it.
		sA=sA.replace('_','.');
		sB=sB.replace('_','.');
		String uriString = sA+"_"+sB;
        URI uri = STEMURI.createURI(uriString);
		return uri;
	} // createRegionNodeURI
	
	

	/**
	 * 
	 * @param graph
	 * @param nodeA
	 * @param nodeB
	 * @param borderLength
	 */
	public static void createEdge(final Graph graph, final Node nodeA,
			final Node nodeB, int borderLength) {
		final List<Edge> edgeList = new ArrayList<Edge>();
		 
		// create the edge
		final Edge edge = CommonBorderRelationshipLabelImpl.createCommonBorderRelationship(nodeA, nodeB,
				borderLength);
		
		URI edgeURI = edge.getURI();
		// the autogenerated edge uri is not correct. Need to replace it
		String sEdge = edgeURI.toString();
		int last = sEdge.lastIndexOf("/");
		String sEdge1 = sEdge.substring(0,last);
		String sEdge2 = sEdge.substring(last,sEdge.length());
		sEdge = sEdge1+"/relationship/commonborder"+sEdge2;
		URI newURI = URI.createURI(sEdge);
		edge.setURI(newURI);
		
		// now we need to set the uri for the label
		CommonBorderRelationshipLabel label = (CommonBorderRelationshipLabel)edge.getLabel();
		label.setURI(createEdgeLabelURI(nodeA, nodeB));
		URI labelURI = label.getURI();
		
		final DublinCore dc = edge.getDublinCore();
		dc.setTitle(createEdgeTitle(nodeA, nodeB));
		
		graph.putEdge(edge);
	} // createEdgeList
	
	/**
	 * @param x
	 *            the x of the node in the lattice
	 * @param y
	 *            the y of the node in the lattice
	 * @return a title for a node
	 */
	public static String createEdgeTitle(Node nodeA, Node nodeB) {
		String nA = nodeA.getDublinCore().getTitle();
		String nB = nodeB.getDublinCore().getTitle();
		final StringBuilder sb = new StringBuilder("Edge[(");
		sb.append(nA);
		sb.append(")<-->(");
		sb.append(nB);
		sb.append(")]");
		return sb.toString();
	} // createEdgeTitle
	
	/**
	 * @param populationCount
	 *            number of (Default: human) population members at the node
	 * @param node
	 *            the node
	 * @return a population label
	 */
	public static PopulationLabel createPopulationLabel(
			final String populationIdentifier, final double populationCount,
			final Node node) {
		final PopulationLabel retValue = LabelsFactory.eINSTANCE
				.createPopulationLabel();
		retValue.setPopulationIdentifier(populationIdentifier);
		retValue.getCurrentPopulationValue().setCount(populationCount);
		node.getLabels().add(retValue);
		return retValue;
	}// create PopulationLabel
	
	
} //GraphLatticeGenerator
