// DiseaseModelTestUtil.java
package org.eclipse.stem.diseasemodels.forcing.tests;

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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.adapters.spatial.geo.InlineLatLongDataProvider;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabel;
import org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl;
import org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl;
import org.eclipse.stem.definitions.nodes.NodesFactory;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;


/**
 * This class contains a number of utilities for creating artifacts useful for
 * testing disease model.
 */
public class GaussianDiseaseModelTestUtil {
	
	

	/**
	 * This is the rate at which population members (on average) transition from
	 * all of the other states (except <em>Pre-Born</em>) to the state
	 * <em>Dead</em>, per time period. Units: population members
	 * 
	 * @see StandardDiseaseModel#getBackgroundMortalityRate()
	 */
	public static final double MORTALITY_RATE = 0.01;
	public static final double MODULATION_FLOUR = 0.5;
	public static final double IMMUNITY_LOSS_RATE = 0.001;
	public static final double TRANSMISSION_RATE = 1.0+MODULATION_FLOUR;
	public static final double RECOVERY_RATE = 0.1;
	public static final long TIME_PERIOD = STEMTime.Units.DAY.getMilliseconds();

	/**
	 * The minimum latitude value of the rectangular area to which node spatial
	 * data is mapped.
	 */
	public final static double MIN_LATITUDE_VALUE = 0.0;

	/**
	 * The maximum latitude value of the rectangular area to which node spatial
	 * data is mapped.
	 */
	public final static double MAX_LATITUDE_VALUE = 50.0;

	/**
	 * The minimum longitude value of the rectangular area to which node spatial
	 * data is mapped.
	 */
	public final static double MIN_LONGITUDE_VALUE = 0.0;

	/**
	 * The maximum longitude value of the rectangular area to which node spatial
	 * data is mapped.
	 */
	public final static double MAX_LONGITUDE_VALUE = 100.0;

	/**
	 * The number of degrees of latitude of the area on the Earth's surface to
	 * which the nodes are mapped.
	 */
	public final static double LATITUDE_HEIGHT = MAX_LATITUDE_VALUE
			- MIN_LATITUDE_VALUE;

	/**
	 * The number of degrees of longitude of the area on the Earth's surface to
	 * which the nodes are mapped.
	 */
	public final static double LONGITUDE_WIDTH = MAX_LONGITUDE_VALUE
			- MIN_LONGITUDE_VALUE;

	/**
	 * The value used for the population of a node.
	 */
	public final static double TEST_POPULATION_COUNT = 100;

	/**
	 * The value used for area of a node.
	 */
	public final static double TEST_AREA = 100.0;

	/**
	 * The population used for the disease model tests.
	 */
	public static final String TEST_POPULATION_IDENTIFIER = PopulationLabel.HUMAN;

	/**
	 * This is the time period between successive computations of label values.
	 */
	public static final long TEST_TRANSPORT_RATE_TIME_PERIOD = STEMTime.Units.DAY.getMilliseconds();

	/**
	 * The number of humans that travel by air from one node to another.
	 */
	public static final int AIR_TRANSPORT_MAX_CAPACITY = 5;

	/**
	 * The number of humans that travel by road 1 from one node to another.
	 */
	public static final int ROAD1_TRANSPORT_MAX_CAPACITY = 3;

	/**
	 * The number of humans that travel by road 2 from one node to another.
	 */
	public static final int ROAD2_TRANSPORT_MAX_CAPACITY = 2;

	/**
	 * The name of a road connecting two nodes together in the graph.
	 */
	public static final String ROAD1_TRANSPORT_ID = "road1";

	/**
	 * The name of a road connecting two nodes together in the graph.
	 */
	public static final String ROAD2_TRANSPORT_ID = "road2";

	/**
	 * The number of kilometers of common border that two nodes share.
	 */
	public static final int COMMON_BORDER_LENGTH = 10;

	/**
	 * The identifier used for air transport
	 */
	public static final String AIR_TRANSPORT_ID = "aircanada";

	/**
	 * The difference between two double values that constitutes inequality
	 */
	public static final double DOUBLE_EQUALITY_TOLERANCE = 0.02;
	
	// Disease Model Test URI's
	public static final String MODEL = "DISEASEMODEL";
	public static final URI DEFAULT_URI = STEMURI.createURI(MODEL + "/" + "defaultTestURI");
	public static long TIME_ONE_DAY = 1;
	public static long TIME_TWO_DAY = 2;
	
	/**
	 * URI for the Solver
	 */
	public static URI SOLVER_URI = STEMURI.createURI("solver/solverTest.solver");
	
	public static STEMTime getSTEMTime() {
		return ModelFactory.eINSTANCE.createSTEMTime();
	}


	/**
	 * @param v1
	 *            a double
	 * @param v2
	 *            a double
	 * @return <code>true</code> if the two double values differ than by less
	 *         than {@link #DOUBLE_EQUALITY_TOLERANCE} and so should be
	 *         considered to be equal.
	 */
	public static final boolean closeEnough(final double v1, final double v2) {
		return Math.abs(v1 - v2) < DOUBLE_EQUALITY_TOLERANCE;
	} // closeEnough

	

	
	/**
	 * This method creates a Model where the nodes are interconnected as in a
	 * lattice.
	 * 
	 * @param nodeDecorators
	 *            the node decorators for the model
	 * @param numRows
	 *            the number of rows of nodes in the lattice
	 * @param numColumns
	 *            the number of columns of nodes in the lattice
	 * @param populationCount
	 *            the (Default: human) population at each node
	 * @param area
	 *            the area (km^2) of each node
	 * @return the model
	 */
	public static Model createLatticeModel(
			final Collection<NodeDecorator> nodeDecorators, final int numRows,
			final int numColumns, final double populationCount,
			final double area) {
		final Model retValue = ModelFactory.eINSTANCE.createModel();
		final DublinCore dc = retValue.getDublinCore();
		dc.populate();
		dc.setTitle(createModelTitle(nodeDecorators, numRows, numColumns,
				populationCount, area));

		retValue.getNodeDecorators().addAll(nodeDecorators);
		final Graph latticeGraph = createLatticeGraph(numRows, numColumns,
				populationCount, area);
		retValue.getGraphs().add(latticeGraph);

		assert retValue.sane();

		return retValue;
	} // createLatticeModel

	/**
	 * This method creates a graph where the nodes are interconnected as in a
	 * lattice.
	 * 
	 * @param numRows
	 *            the number of rows of nodes in the lattice
	 * @param numColumns
	 *            the number of columns of nodes in the lattice
	 * @param populationCount
	 *            the (Default: human) population at each node
	 * @param area
	 *            the area (km^2) of each node
	 * @return graph that is a lattice of nodes.
	 */
	public static Graph createLatticeGraph(final int numRows,
			final int numColumns, final double populationCount,
			final double area) {

		final Node nodeHolder[][] = new Node[numRows][numColumns];
		final Graph retValue = GraphFactory.eINSTANCE.createGraph();

		final DublinCore dc = retValue.getDublinCore();
		dc.populate();
		dc
				.setTitle(createGraphTitle(numRows, numColumns,
						populationCount, area));

		// Create the nodes and put them into the graph
		for (int row = 0; row < numRows; row++) {
			for (int column = 0; column < numColumns; column++) {
				final Region regionNode = createRegionNode(row, column);
				nodeHolder[row][column] = regionNode;
				retValue.putNode(regionNode);
			} // for each column
		} // for each row

		// Add the Population and Area labels
		for (int row = 0; row < numRows; row++) {
			for (int column = 0; column < numColumns; column++) {
				final Node node = nodeHolder[row][column];

				// Population
				retValue.putNodeLabel(createPopulationLabel(
						TEST_POPULATION_IDENTIFIER, populationCount, node));

				// Area
				retValue.putNodeLabel(createAreaLabel(area, node));
			} // for each column
		} // for each row

		// Now add relationships

	
		// Add the spatial specification to the spatial attribute of each node's
		// dublin core instance and for each edge. The value for the nodes will
		// be a rectangular area expressed as a set of lat/long points that
		// layout a polygon. The position of the polygon will at position that
		// matches the position (row, column) of the node in the lattice.
		addSpatialSpecifications(nodeHolder);

		assert retValue.sane();

		return retValue;
	} // createLatticeGraph

	/**
	 * Add the spatial specification to the spatial attribute of each node's
	 * dublin core instance. The value will be a retangular area expressed as a
	 * set of lat/long points that layout a polygon. The position of the polygon
	 * will at position that matches the position (row, column) of the node in
	 * the lattice. Node at position [0][0] will be in the upper left while the
	 * node at positon [numrows][numcolumns] will be in the lower right of the
	 * rectangular area.
	 * 
	 * @param nodeHolder
	 *            the array that holds the nodes of the lattic
	 */
	private static void addSpatialSpecifications(final Node[][] nodeHolder) {

		// First run through all of the nodes creating a polygon for their
		// border and adding the data as an inline value in the spatial
		// attribute of the node's dublin core.
		for (int row = 0; row < nodeHolder.length; row++) {
			for (int column = 0; column < nodeHolder[row].length; column++) {
				final Node node = nodeHolder[row][column];
				final LatLong nodeSegments = createNodeBorderLatLongSegments(
						row, nodeHolder.length, column, nodeHolder[row].length);
				final String spatialURIString = InlineLatLongDataProvider
						.createSpatialInlineURIString(nodeSegments);
				node.getDublinCore().setSpatial(spatialURIString);
			} // for each column
		} // for each row

		// Now do all the edges, we'll start in the upper right and do edges
		// between successive pairs of nodes.
		for (int row = 0; row < nodeHolder.length - 1; row++) {
			for (int column = 0; column < nodeHolder[row].length - 1; column++) {

				// First do the edges to the right
				final LatLong edgeSegmentsRight = createEdgeLatLongSegments(
						row, column, row, column + 1, nodeHolder.length,
						nodeHolder[row].length);

				final String edgeSpatialAttributeRight = InlineLatLongDataProvider
						.createSpatialInlineURIString(edgeSegmentsRight);

				for (Edge edge : getEdgesBetweenNodes(nodeHolder[row][column],
						nodeHolder[row][column + 1])) {
					edge.getDublinCore().setSpatial(edgeSpatialAttributeRight);
				}

				// Then do the edges below
				final LatLong edgeSegmentsBelow = createEdgeLatLongSegments(
						row, column, row + 1, column, nodeHolder.length,
						nodeHolder[row].length);

				final String edgeSpatialAttributeBelow = InlineLatLongDataProvider
						.createSpatialInlineURIString(edgeSegmentsBelow);

				for (Edge edge : getEdgesBetweenNodes(nodeHolder[row][column],
						nodeHolder[row + 1][column])) {
					edge.getDublinCore().setSpatial(edgeSpatialAttributeBelow);
				}
			} // for each column
		} // for each row

	} // addSpatialSpecifications

	/**
	 * @param node1
	 * @param node2
	 * @return all the edges between the two nodes
	 */
	private static List<Edge> getEdgesBetweenNodes(Node node1, Node node2) {
		final List<Edge> retValue = new ArrayList<Edge>();
		for (Iterator<Edge> edgeIterator = node1.getEdges().iterator(); edgeIterator
				.hasNext();) {
			final Edge edge = (Edge) edgeIterator.next();
			if (edge.getOtherNode(node1) == node2) {
				retValue.add(edge);
			}
		}
		return retValue;
	} // getEdgesBetweenNodes

	/**
	 * @param row
	 *            the row in the lattice of the node
	 * @param numRows
	 *            the total number of rows in the lattice
	 * @param column
	 *            the column in the lattice of the node
	 * @param numColumns
	 *            the total number of columns in the lattice
	 * @return a list of lat/long polygons/lines for the node
	 */
	private static LatLong createNodeBorderLatLongSegments(final int row,
			final int numRows, final int column, final int numColumns) {
		final LatLong retValue = new LatLong();
		final double nodeLatHeight = LATITUDE_HEIGHT / numRows;
		final double nodeLongWidth = LONGITUDE_WIDTH / numColumns;

		final double lowerLeftLat = MIN_LATITUDE_VALUE + (numRows - row - 1)
				* nodeLatHeight;
		final double lowerLeftLong = MIN_LONGITUDE_VALUE + column
				* nodeLongWidth;

		final double upperRightLat = lowerLeftLat + nodeLatHeight;
		final double upperRightLong = lowerLeftLong + nodeLongWidth;

		final SegmentBuilder sb = new SegmentBuilder();

		// We just make a rectangle...
		sb.add(lowerLeftLat, lowerLeftLong);
		sb.add(upperRightLat, lowerLeftLong);
		sb.add(upperRightLat, upperRightLong);
		sb.add(lowerLeftLat, upperRightLong);
		sb.add(lowerLeftLat, lowerLeftLong);
		retValue.add(sb.toSegment());

		return retValue;
	} // createNodeBorderLatLongSegments

	/**
	 * @param node1Row
	 * @param node1Column
	 * @param node2Row
	 * @param node2Column
	 * @param length
	 * @param length2
	 * @return a list of a lat/long line between the centers of the two nodes.
	 */
	private static LatLong createEdgeLatLongSegments(int node1Row,
			int node1Column, int node2Row, int node2Column, int numRows,
			int numColumns) {
		final LatLong retValue = new LatLong();
		final double nodeLatHeight = LATITUDE_HEIGHT / numColumns;
		final double nodeLongWidth = LONGITUDE_WIDTH / numRows;

		final double relativeNodeCenterLat = nodeLatHeight / 2.0;
		final double relativeNodeCenterLong = nodeLongWidth / 2.0;

		final double node1LowerLeftLat = MIN_LATITUDE_VALUE
				+ (numRows - node1Row - 1) * nodeLatHeight;
		final double node1LowerLeftLong = MIN_LONGITUDE_VALUE + node1Column
				* nodeLongWidth;

		final double node2LowerLeftLat = MIN_LATITUDE_VALUE
				+ (numRows - node2Row - 1) * nodeLatHeight;
		final double node2LowerLeftLong = MIN_LONGITUDE_VALUE + node2Column
				* nodeLongWidth;

		final SegmentBuilder sb = new SegmentBuilder();
		// We just make a straight line between the centers...
		sb.add(node1LowerLeftLat + relativeNodeCenterLat, node1LowerLeftLong
				+ relativeNodeCenterLong);
		sb.add(node2LowerLeftLat + relativeNodeCenterLat, node2LowerLeftLong
				+ relativeNodeCenterLong);

		retValue.add(sb.toSegment());

		return retValue;
	} // createEdgeLatLongSegments

	

	
	/**
	 * @param area
	 *            the area of the node
	 * @param node
	 *            the node
	 * @return an AreaLabel for the node
	 */
	private static AreaLabel createAreaLabel(final double area, final Node node) {
		final AreaLabel retValue = LabelsFactory.eINSTANCE.createAreaLabel();
		retValue.getCurrentAreaValue().setArea(area);
		node.getLabels().add(retValue);
		return retValue;
	} // createAreaLabel

	/**
	 * @param populationCount
	 *            number of (Default: human) population members at the node
	 * @param node
	 *            the node
	 * @return a population label
	 */
	private static PopulationLabel createPopulationLabel(
			final String populationIdentifier, final double populationCount,
			final Node node) {
		final PopulationLabel retValue = LabelsFactory.eINSTANCE
				.createPopulationLabel();
		retValue.setPopulationIdentifier(populationIdentifier);
		retValue.getCurrentPopulationValue().setCount(populationCount);
		node.getLabels().add(retValue);
		return retValue;
	} // createPopulationLabel

	/**
	 * Create a single populated node. This is used by the JUnit tests for
	 * disease models which need to have a disease model label that has an
	 * associated node.
	 * 
	 * 
	 * @return a node
	 */
	public static Region createPopulationRegionNode() {
		return createPopulationRegionNode(TEST_POPULATION_IDENTIFIER);
	} // createPopulationRegionNode

	/**
	 * Create a single populated node. This is used by the JUnit tests for
	 * disease models which need to have a disease model label that has an
	 * associated node.
	 * 
	 * @param populationIdentifier
	 *            the identifier of the population
	 * 
	 * 
	 * @return a node
	 */
	public static Region createPopulationRegionNode(
			final String populationIdentifier) {
		return createPopulationRegionNode(populationIdentifier,
				TEST_POPULATION_COUNT, TEST_AREA);
	} // createPopulationRegionNode

	/**
	 * Create a single populated node. This is used by the JUnit tests for
	 * disease models which need to have a disease model label that has an
	 * associated node.
	 * 
	 * @param populationIdentifier
	 *            the identifier of the population
	 * 
	 * @param populationCount
	 *            the number of population members
	 * @param area
	 *            the area of the node (km^2)
	 * @return a node
	 */
	public static Region createPopulationRegionNode(
			final String populationIdentifier, final double populationCount,
			final double area) {
		return createPopulationRegionNode(0, 0, populationIdentifier,
				populationCount, area);
	} // createPopulationRegionNode

	/**
	 * Create a single populated node. This is used by the JUnit tests for
	 * disease models which need to have a disease model label that has an
	 * associated node.
	 * 
	 * @param row
	 *            the row index of the node
	 * @param column
	 *            the column index of the node
	 * @param populationIdentifier
	 *            the identifier of the population
	 * @param populationCount
	 *            the number of population members
	 * @param area
	 *            the area of the node (km^2)
	 * @return a node
	 */
	public static Region createPopulationRegionNode(final int row,
			final int column, final String populationIdentifier,
			final double populationCount, final double area) {
		final Region retValue = createRegionNode(row, column);

		// Population
		createPopulationLabel(populationIdentifier, populationCount, retValue);

		// Area
		createAreaLabel(area, retValue);
		return retValue;
	} // createPopulationRegionNode

	/**
	 * @param row
	 *            the row of the node in the lattice
	 * @param column
	 *            the column of the node in the lattice
	 * @return a node
	 */
	private static Region createRegionNode(int row, int column) {
		final Region retValue = NodesFactory.eINSTANCE.createRegion();

		final DublinCore dc = retValue.getDublinCore();
		dc.setTitle(createNodeTitle(row, column));
		retValue.setURI(createRegionNodeURI(row, column));
		return retValue;
	} // createRegionNode

	/**
	 * @param row
	 *            the row of the region in the lattice
	 * @param column
	 *            the column of the region in the lattice
	 * @return a URI for the region node
	 */
	public static URI createRegionNodeURI(int row, int column) {
		URI retValue = STEMURI.createURI(Region.URI_TYPE_REGION_NODE_SEGMENT
				+ "/" + row + "_" + column);
		return retValue;
	} // createRegionNodeURI

	/**
	 * @param row
	 *            the row of the node in the lattice
	 * @param column
	 *            the column of the node in the lattice
	 * @return a title for a node
	 */
	public static String createNodeTitle(int row, int column) {
		final StringBuilder sb = new StringBuilder("Node[");
		sb.append(Integer.toString(row));
		sb.append(", ");
		sb.append(Integer.toString(column));
		sb.append("]");
		return sb.toString();
	} // createNodeTitle

	/**
	 * @param numRows
	 *            the number of rows of nodes in the lattice
	 * @param numColumns
	 *            the number of columns of nodes in the lattice
	 * @param populationCount
	 *            the (Default: human) population at each node
	 * @param area
	 *            the area (km^2) of each node
	 * @return a title for a graph
	 */
	private static String createGraphTitle(int numRows, int numColumns,
			double populationCount, double area) {
		final StringBuilder sb = new StringBuilder("Graph");
		sb.append(Integer.toString(numRows));
		sb.append("x");
		sb.append(Integer.toString(numColumns));
		sb.append("[");
		sb.append(Double.toString(populationCount));
		sb.append(", ");
		sb.append(area);
		sb.append("]");
		return sb.toString();
	} // createGraphTitle

	/**
	 * @param nodeDecorators
	 * @param numRows
	 * @param numColumns
	 * @param populationCount
	 * @param area
	 * @return the title of the model
	 */
	private static String createModelTitle(
			final Collection<NodeDecorator> nodeDecorators, int numRows,
			int numColumns, double populationCount, double area) {
		final StringBuilder sb = new StringBuilder("Model");
		sb.append(Integer.toString(numRows));
		sb.append("x");
		sb.append(Integer.toString(numColumns));
		for (Iterator<NodeDecorator> nodeDecoratorIter = nodeDecorators
				.iterator(); nodeDecoratorIter.hasNext();) {
			final NodeDecorator nodeDecorator = nodeDecoratorIter.next();
			sb.append(nodeDecorator.getDublinCore().getTitle());
		} // for

		sb.append("[");
		sb.append(Double.toString(populationCount));
		sb.append(", ");
		sb.append(area);
		sb.append("]");
		return sb.toString();
	} // createModelTitle

	

	
	/**
	 * @param graph
	 * @param row
	 * @param column
	 * @return the indexed region from the graph
	 */
	public static Region getRegion(final Graph graph, final int row,
			final int column) {
		Region retValue = null;

		for (Iterator<Node> nodeIter = graph.getNodes().values().iterator(); nodeIter
				.hasNext();) {
			final Region region = (Region) nodeIter.next();
			final String name = region.getDublinCore().getTitle();
			// Is this the region we're looking for?
			if (name.equals(GaussianDiseaseModelTestUtil.createNodeTitle(row, column))) {
				// Yes
				retValue = region;
				break;
			}
		}
		return retValue;
	} // getRegion

	/**
	 * Examine the transportation edges coming into nodeA from nodeB and return
	 * the one with the specified identifier.
	 * 
	 * @param nodeA
	 * @param nodeB
	 * @param transportId
	 * @return the transportation edge between two nodes with a specific
	 *         transport id
	 */
	public static Edge getTransportEdge(final Node nodeA, final Node nodeB,
			final String transportId) {
		Edge retValue = null;

		for (Edge transportEdge : TransportRelationshipLabelImpl
				.getTransportEdgesToNode(nodeA,
						GaussianDiseaseModelTestUtil.TEST_POPULATION_IDENTIFIER)) {
			// Is this edge from nodeB?
			if (transportEdge.getOtherNode(nodeA) == nodeB) {
				// Yes
				final TransportRelationshipLabel trl = (TransportRelationshipLabel) transportEdge
						.getLabel();
				// Does this edge have the transport id we're looking for?
				if (trl.getTransportIdentifier().equalsIgnoreCase(transportId)) {
					// Yes
					retValue = transportEdge;
					break;
				}
			}
		} // for each transport edge
		return retValue;
	} // getTransportEdge
	
	/**
	 * @return an SILabel instance
	 */
	public static SIRLabel createLabel() {
		final SIRLabel retValue = StandardFactory.eINSTANCE.createSIRLabel();
		final Region node = GaussianDiseaseModelTestUtil.createPopulationRegionNode(GaussianDiseaseModelTestUtil.TEST_POPULATION_IDENTIFIER);

		labelRegion(retValue,GaussianDiseaseModelTestUtil.TEST_POPULATION_IDENTIFIER, node);
		return retValue;	
	} // createLabel() 

	/**
	 * 
	 * @param diseaseLabel
	 * @param populationIdentifier
	 * @param region
	 */
	protected static void labelRegion(final DiseaseModelLabel diseaseLabel,
			final String populationIdentifier, final Region region) {
		diseaseLabel.setURIOfIdentifiableToBeLabeled(region.getURI());
		final PopulationLabel populationLabel = PopulationLabelImpl
				.getPopulationLabel(populationIdentifier, region);
		diseaseLabel.setPopulationLabel(populationLabel);
		region.getLabels().add(diseaseLabel);
	} // labelRegion

} // DiseaseModelTestUtil
