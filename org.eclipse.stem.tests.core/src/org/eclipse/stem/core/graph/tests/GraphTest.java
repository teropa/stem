package org.eclipse.stem.core.graph.tests;

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

import java.io.IOException;
import java.util.Iterator;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.EdgeDecorator;
import org.eclipse.stem.core.model.GraphDecorator;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1;
import org.eclipse.stem.tests.util.decorators.TestGraphDecorator1;
import org.eclipse.stem.tests.util.decorators.TestNodeDecorator1;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Graph</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getNumEdges() <em>Num Edges</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getNumNodes() <em>Num Nodes</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getNumGraphLabels() <em>Num Graph Labels</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getNumNodeLabels() <em>Num Node Labels</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getNumDynamicLabels() <em>Num Dynamic Labels</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getNodeLabelsByTypeURI(org.eclipse.emf.common.util.URI) <em>Get Node Labels By Type URI</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#addGraph(org.eclipse.stem.core.graph.Graph) <em>Add Graph</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#putEdge(org.eclipse.stem.core.graph.Edge) <em>Put Edge</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getEdge(org.eclipse.emf.common.util.URI) <em>Get Edge</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#putNode(org.eclipse.stem.core.graph.Node) <em>Put Node</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getNode(org.eclipse.emf.common.util.URI) <em>Get Node</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#putNodeLabel(org.eclipse.stem.core.graph.NodeLabel) <em>Put Node Label</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getNodeLabel(org.eclipse.emf.common.util.URI) <em>Get Node Label</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#putGraphLabel(org.eclipse.stem.core.graph.Label) <em>Put Graph Label</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#getGraphLabel(org.eclipse.emf.common.util.URI) <em>Get Graph Label</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#addDynamicLabel(org.eclipse.stem.core.graph.DynamicLabel) <em>Add Dynamic Label</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Graph#switchToNextValue(org.eclipse.stem.core.model.STEMTime) <em>Switch To Next Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class GraphTest extends IdentifiableTest {

	private static final STEMTime SWITCH_TIME = ModelFactory.eINSTANCE
			.createSTEMTime();

	protected static final URI GRAPH1_URI = STEMURI
			.createURI("graph/testgraph1");

	protected static final URI GRAPH2_URI = STEMURI.createURI("graph/g2");

	// The parameters for the graph ("main") to be added to
	private static final int MAIN_NUM_DYNAMIC_EDGE_LABELS = 1;

	private static final int MAIN_NUM_STATIC_EDGE_LABELS = 1;

	private static final int MAIN_NUM_DYNAMIC_GRAPH_LABELS = 1;

	private static final int MAIN_NUM_STATIC_GRAPH_LABELS = 1;

	private static final int MAIN_NUM_STATIC_NODE_LABELS = 2;

	private static final int MAIN_NUM_DYNAMIC_NODE_LABELS = 2 * MAIN_NUM_DYNAMIC_EDGE_LABELS;

	private static final int MAIN_NUM_EDGES = MAIN_NUM_DYNAMIC_EDGE_LABELS
			+ MAIN_NUM_STATIC_EDGE_LABELS;

	private static final int MAIN_NUM_NODES = 2 * MAIN_NUM_EDGES;

	private static final int MAIN_NUM_NODE_LABELS = MAIN_NUM_STATIC_NODE_LABELS
			+ MAIN_NUM_DYNAMIC_NODE_LABELS;

	private static final int MAIN_NUM_GRAPH_LABELS = MAIN_NUM_DYNAMIC_GRAPH_LABELS
			+ MAIN_NUM_STATIC_GRAPH_LABELS;

	private static final int MAIN_NUM_DYNAMIC_LABELS = MAIN_NUM_DYNAMIC_GRAPH_LABELS
			+ MAIN_NUM_DYNAMIC_EDGE_LABELS + MAIN_NUM_DYNAMIC_NODE_LABELS;

	// The parameters for the graph ("add") to be added
	private static final int ADD_NUM_DYNAMIC_EDGE_LABELS = 2;

	private static final int ADD_NUM_STATIC_EDGE_LABELS = 3;

	private static final int ADD_NUM_STATIC_GRAPH_LABELS = 3;

	private static final int ADD_NUM_DYNAMIC_GRAPH_LABELS = 2;

	private static final int ADD_NUM_STATIC_NODE_LABELS = 2 * ADD_NUM_STATIC_EDGE_LABELS;

	private static final int ADD_NUM_DYNAMIC_NODE_LABELS = 2 * ADD_NUM_DYNAMIC_EDGE_LABELS;

	private static final int ADD_NUM_EDGES = ADD_NUM_DYNAMIC_EDGE_LABELS
			+ ADD_NUM_STATIC_EDGE_LABELS;

	private static final int ADD_NUM_NODES = 2 * ADD_NUM_EDGES;

	private static final int ADD_NUM_NODE_LABELS = ADD_NUM_STATIC_NODE_LABELS
			+ ADD_NUM_DYNAMIC_NODE_LABELS;

	private static final int ADD_NUM_GRAPH_LABELS = ADD_NUM_DYNAMIC_GRAPH_LABELS
			+ ADD_NUM_STATIC_GRAPH_LABELS;

	private static final int ADD_NUM_DYNAMIC_LABELS = ADD_NUM_DYNAMIC_GRAPH_LABELS
			+ ADD_NUM_DYNAMIC_EDGE_LABELS + ADD_NUM_DYNAMIC_NODE_LABELS;

	// Results after the "addGraph" operation

	// private static final int RESULT_NUM_STATIC_NODE_LABELS = 0;

	// private static final int RESULT_NUM_DYNAMIC_NODE_LABELS =
	// MAIN_NUM_DYNAMIC_NODE_LABELS
	// + ADD_NUM_DYNAMIC_NODE_LABELS;

	private static final int RESULT_NUM_NODES = MAIN_NUM_NODES + ADD_NUM_NODES;

	private static final int RESULT_NUM_EDGES = MAIN_NUM_EDGES + ADD_NUM_EDGES;

	private static final int RESULT_NUM_NODE_LABELS = MAIN_NUM_NODE_LABELS
			+ ADD_NUM_NODE_LABELS;

	private static final int RESULT_NUM_GRAPH_LABELS = MAIN_NUM_GRAPH_LABELS
			+ ADD_NUM_GRAPH_LABELS;

	private static final int RESULT_NUM_DYNAMIC_LABELS = MAIN_NUM_DYNAMIC_LABELS
			+ ADD_NUM_DYNAMIC_LABELS;

	private static final URI SERIALZATION_TEST_URI = URI
			.createURI("temp/testgraph1.graph");

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphTest.class);
	}

	/**
	 * Constructs a new Graph test case with the given name.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public GraphTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Graph getFixture() {
		return (Graph)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		TestUtil.resetCounters();
		setFixture(createFixture());
	} // setUp

	/**
	 * @return a test graph
	 */
	public static Graph createFixture() {
		final Graph retValue = GraphFactory.eINSTANCE.createGraph();
		retValue.setURI(GRAPH1_URI);

		populateGraph(MAIN_NUM_DYNAMIC_EDGE_LABELS,
				MAIN_NUM_STATIC_EDGE_LABELS, MAIN_NUM_DYNAMIC_GRAPH_LABELS,
				MAIN_NUM_STATIC_GRAPH_LABELS, retValue);

		return retValue;
	} // createFixture

	/**
	 * Add edges, nodes and labels to a graph.
	 */
	private static void populateGraph(
			final int numberOfDynamicallyLabeledEdges,
			final int numberOfStaticallyLabeledEdges,
			final int numberOfDynamicallyLabeledGraphLabels,
			final int numberOfStaticallyLabeledGraphLabels, final Graph graph) {

		final TestNodeDecorator1 tnd = DecoratorsFactory.eINSTANCE
				.createTestNodeDecorator1();
		final TestEdgeDecorator1 ted = DecoratorsFactory.eINSTANCE
				.createTestEdgeDecorator1();
		final TestGraphDecorator1 tgd = DecoratorsFactory.eINSTANCE
				.createTestGraphDecorator1();

		graph.getDecorators().add(tnd);
		graph.getDecorators().add(ted);
		graph.getDecorators().add(tgd);
		
		populateDynamicallyLabeledEdges(graph, numberOfDynamicallyLabeledEdges,
				tnd, ted);
		populateStaticallyLabeledEdges(graph, numberOfStaticallyLabeledEdges,
				tnd, ted, tgd);
		populateDynamicGraphLabels(graph,
				numberOfDynamicallyLabeledGraphLabels, tgd);
		populateStaticGraphLabels(graph, numberOfStaticallyLabeledGraphLabels);

	} // populateGraph

	/**
	 * @param graph
	 * @param numberOfStaticallyLabeledGraphLabels
	 */
	private static void populateStaticGraphLabels(Graph graph,
			int numberOfStaticallyLabeledGraphLabels) {
		for (int staticGraphLabelNumber = 0; staticGraphLabelNumber < numberOfStaticallyLabeledGraphLabels; staticGraphLabelNumber++) {
			final Label graphLabel = TestUtil.createStaticLabel(graph.getURI());
			graph.putGraphLabel(graphLabel);
		} // for labelNumber
	} // populateStaticGraphLabels

	/**
	 * @param graph
	 * @param numberOfDynamicallyLabeledGraphLabels
	 * @param graphDecorator
	 *            TODO
	 */
	private static void populateDynamicGraphLabels(Graph graph,
			final int numberOfDynamicallyLabeledGraphLabels,
		final	GraphDecorator graphDecorator) {
		for (int dynamicGraphLabelNumber = 0; dynamicGraphLabelNumber < numberOfDynamicallyLabeledGraphLabels; dynamicGraphLabelNumber++) {
			final DynamicLabel dynamicLabel = TestUtil.createDynamicLabel(graph
					.getURI(), graphDecorator);

			assert dynamicLabel.sane();

			graph.putGraphLabel(dynamicLabel);
		} // for labelNumber
	} // populateDynamicGraphLabels

	/**
	 * 
	 * @param graph
	 * @param numberOfDynamicallyLabeledEdges
	 * @param nodeDecorator
	 *            TODO
	 * @param edgeDecorator
	 *            TODO
	 */
	private static void populateDynamicallyLabeledEdges(final Graph graph,
			final int numberOfDynamicallyLabeledEdges,
			NodeDecorator nodeDecorator, EdgeDecorator edgeDecorator) {

		for (int edgeNumber = 0; edgeNumber < numberOfDynamicallyLabeledEdges; edgeNumber++) {
			// Each edge adds two nodes to the graph, all three have dynamic
			// labels
			final Node nodeA = TestUtil
					.createDynamicalyLabeledNode(nodeDecorator);
			final Node nodeB = TestUtil
					.createDynamicalyLabeledNode(nodeDecorator);
			final Edge edge = TestUtil.createDynamicallyLabeledEdge(nodeA
					.getURI(), nodeB.getURI(), edgeDecorator);

			edge.setA(nodeA);
			edge.setB(nodeB);
			nodeA.getEdges().add(edge);
			nodeB.getEdges().add(edge);

			assert edge.sane();
			assert nodeA.sane();
			assert nodeB.sane();

			graph.putEdge(edge);
			graph.putNode(nodeA);
			graph.putNode(nodeB);

		} // for edgeNumber

	} // populateDynamicallyLabeledEdges

	/**
	 * @param graph
	 * @param numberOfStaticallyLabeledEdges
	 * @param nodeDecorator
	 *            TODO
	 * @param edgeDecorator
	 *            TODO
	 * @param graphDecorator
	 *            TODO
	 */
	private static void populateStaticallyLabeledEdges(final Graph graph,
			final int numberOfStaticallyLabeledEdges,
			NodeDecorator nodeDecorator, EdgeDecorator edgeDecorator,
			GraphDecorator graphDecorator) {
		for (int edgeNumber = 0; edgeNumber < numberOfStaticallyLabeledEdges; edgeNumber++) {
			// Each statically labeled edge adds two nodes
			final Node nodeA = TestUtil.createStaticallyLabeledNode();
			final Node nodeB = TestUtil.createStaticallyLabeledNode();
			final Edge edge = TestUtil.createStaticallyLabeledEdge(nodeA
					.getURI(), nodeB.getURI());

			edge.setA(nodeA);
			edge.setB(nodeB);
			nodeA.getEdges().add(edge);
			nodeB.getEdges().add(edge);

			assert edge.sane();
			assert nodeA.sane();
			assert nodeB.sane();

			graph.putEdge(edge);
			graph.putNode(nodeA);
			graph.putNode(nodeB);
			// final NodeLabel nodeALabel = (NodeLabel)
			// nodeA.getLabels().get(0);
			// final NodeLabel nodeBLabel = (NodeLabel)
			// nodeB.getLabels().get(0);
			// graph.putNodeLabel(nodeALabel);
			// graph.putNodeLabel(nodeBLabel);
		} // for edgeNumber
	} // populateStaticallyLabeledEdges

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.graph.Graph#getNumEdges()
	 * <em> Edges</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getNumEdges()
	 * @generated NOT
	 */
	public void testGetNumEdges() {
		final Graph graph = getFixture();
		assertTrue(graph.getNumEdges() == 2);
	} // testGetNumEdges

	/**
	 * Tests the '{@link org.eclipse.stem.core.graph.Graph#getNumNodes()
	 * <em>Num Nodes</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getNumNodes()
	 * @generated NOT
	 */
	public void testGetNumNodes() {
		final Graph graph = getFixture();
		assertTrue(graph.getNumNodes() == 4);
	} // testGetNumNodes

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#getNumGraphLabels()
	 * <em>Num Graph Labels</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getNumGraphLabels()
	 * @generated NOT
	 */
	public void testGetNumGraphLabels() {
		final Graph graph = getFixture();
		assertTrue(graph.getNumGraphLabels() == 2);
	} // testGetNumGraphLabels

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#getNumNodeLabels()
	 * <em>Num Node Labels</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getNumNodeLabels()
	 * @generated NOT
	 */
	public void testGetNumNodeLabels() {
		final Graph graph = getFixture();
		assertTrue(graph.getNumNodeLabels() == graph.getNumNodes());
	} // testGetNumNodeLabels

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#getNumDynamicLabels()
	 * <em>Num Dynamic Labels</em>}' feature getter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getNumDynamicLabels()
	 * @generated NOT
	 */
	public void testGetNumDynamicLabels() {
		final Graph graph = getFixture();
		assertTrue(graph.getNumDynamicLabels() == 4);
	} // testGetNumDynamicLabels

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#getNodeLabelsByTypeURI(org.eclipse.emf.common.util.URI)
	 * <em>Get Node Labels By Type URI</em>}' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getNodeLabelsByTypeURI(org.eclipse.emf.common.util.URI)
	 * @generated NOT
	 */
	public void testGetNodeLabelsByTypeURI__URI() {
		final Graph graph = getFixture();
		final EList nodeLabels = graph
				.getNodeLabelsByTypeURI(DynamicLabel.URI_TYPE_DYNAMIC_LABEL);
		assertTrue(nodeLabels.size() == 2);
	} // testGetNodeLabelsByTypeURI__URI

	/**
	 * Test the sanity of the fixture
	 */
	@Override
	public void testSane() {
		final Graph graph = getFixture();
		assertTrue(graph.sane());
	} // testSane

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#addGraph(org.eclipse.stem.core.graph.Graph)
	 * <em>Add Graph</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#addGraph(org.eclipse.stem.core.graph.Graph)
	 * @generated NOT
	 */
	public void testAddGraph__Graph() {
		final Graph mainGraph = getFixture();

		final Graph addGraph = GraphFactory.eINSTANCE.createGraph();

		populateGraph(ADD_NUM_DYNAMIC_EDGE_LABELS, ADD_NUM_STATIC_EDGE_LABELS,
				ADD_NUM_DYNAMIC_GRAPH_LABELS, ADD_NUM_STATIC_GRAPH_LABELS,
				addGraph);

		assertTrue(mainGraph.getNumEdges() == MAIN_NUM_EDGES);
		assertTrue(mainGraph.getNumNodes() == MAIN_NUM_NODES);
		assertTrue(mainGraph.getNumNodeLabels() == MAIN_NUM_NODE_LABELS);

		assertTrue(addGraph.getNumEdges() == ADD_NUM_EDGES);
		assertTrue(addGraph.getNumNodes() == ADD_NUM_NODES);
		assertTrue(addGraph.getNumNodeLabels() == ADD_NUM_NODE_LABELS);

		// Add the two graphs together
		mainGraph.addGraph(addGraph, null);

		assertTrue(mainGraph.getNumEdges() == RESULT_NUM_EDGES);
		assertTrue(mainGraph.getNumNodes() == RESULT_NUM_NODES);
		assertTrue(mainGraph.getNumNodeLabels() == RESULT_NUM_NODE_LABELS);
		assertTrue(mainGraph.getNumGraphLabels() == RESULT_NUM_GRAPH_LABELS);
		assertTrue(mainGraph.getNumDynamicLabels() == RESULT_NUM_DYNAMIC_LABELS);
	} // testAddGraph__Graph

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#putEdge(org.eclipse.stem.core.graph.Edge)
	 * <em>Put Edge</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#putEdge(org.eclipse.stem.core.graph.Edge)
	 * @generated NOT
	 */
	public void testPutEdge__Edge() {
		final Graph graph = getFixture();
		final Edge edge = TestUtil.createStaticallyLabeledEdge(TestUtil
				.createNextIdentifiableToLabelURI(), TestUtil
				.createNextIdentifiableToLabelURI());
		graph.putEdge(edge);
		assertTrue(edge.equals(graph.getEdge(edge.getURI())));
	} // testPutEdge__Edge

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#getEdge(org.eclipse.emf.common.util.URI)
	 * <em>Get Edge</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getEdge(org.eclipse.emf.common.util.URI)
	 * @see #testPutEdge__Edge()
	 * @generated NOT
	 */
	public void testGetEdge__URI() {
		// Implemented in testPutEdge__Edge
		assertTrue(true);
	} // testGetEdge__URI

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#putNode(org.eclipse.stem.core.graph.Node)
	 * <em>Put Node</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#putNode(org.eclipse.stem.core.graph.Node)
	 * @generated NOT
	 */
	public void testPutNode__Node() {
		final Graph graph = getFixture();
		final Node node = TestUtil.createStaticallyLabeledNode();
		graph.putNode(node);
		assertTrue(node.equals(graph.getNode(node.getURI())));
	} // testPutNode__Node

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#getNode(org.eclipse.emf.common.util.URI)
	 * <em>Get Node</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getNode(org.eclipse.emf.common.util.URI)
	 * @see #testPutNode__Node()
	 * @generated NOT
	 */
	public void testGetNode__URI() {
		// Implemented in testPutNode__Node
		assertTrue(true);
	} // testGetNode__URI

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#putNodeLabel(org.eclipse.stem.core.graph.NodeLabel)
	 * <em>Put Node Label</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#putNodeLabel(org.eclipse.stem.core.graph.NodeLabel)
	 * @generated NOT
	 */
	public void testPutNodeLabel__NodeLabel() {
		final Graph graph = getFixture();
		final DynamicNodeLabel label = TestUtil.createDynamicNodeLabel();
		graph.putNodeLabel(label);
		assertTrue(label.equals(graph.getNodeLabel(label.getURI())));
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#getNodeLabel(org.eclipse.emf.common.util.URI)
	 * <em>Get Node Label</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getNodeLabel(org.eclipse.emf.common.util.URI)
	 * @see #testPutNodeLabel__NodeLabel()
	 * @generated NOT
	 */
	public void testGetNodeLabel__URI() {
		// Implemented in testPutNodeLabel__NodeLabel
		assertTrue(true);
	} // testGetNodeLabel__URI

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#putGraphLabel(org.eclipse.stem.core.graph.Label)
	 * <em>Put Graph Label</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#putGraphLabel(org.eclipse.stem.core.graph.Label)
	 * @generated NOT
	 */
	public void testPutGraphLabel__Label() {
		final Graph graph = getFixture();
		final Label label = TestUtil.createStaticLabel();
		graph.putGraphLabel(label);
		assertTrue(label.equals(graph.getGraphLabel(label.getURI())));
	} // testPutGraphLabel__Label

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#getGraphLabel(org.eclipse.emf.common.util.URI)
	 * <em>Get Graph Label</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#getGraphLabel(org.eclipse.emf.common.util.URI)
	 * @see #testPutGraphLabel__Label()
	 * @generated NOT
	 */
	public void testGetGraphLabel__URI() {
		// Implemented in testPutGraphLabel__Label
		assertTrue(true);
	} // testGetGraphLabel__URI

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#addDynamicLabel(org.eclipse.stem.core.graph.DynamicLabel)
	 * <em>Add Dynamic Label</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#addDynamicLabel(org.eclipse.stem.core.graph.DynamicLabel)
	 * @generated NOT
	 */
	public void testAddDynamicLabel__DynamicLabel() {
		final Graph graph = getFixture();
		final DynamicLabel label = TestUtil.createDynamicLabel(TestUtil
				.createNextIdentifiableToLabelURI());
		graph.addDynamicLabel(label);
		assertTrue(graph.getDynamicLabels().contains(label));
	} // testAddDynamicLabel__DynamicLabel

	/**
	 * Tests the '
	 * {@link org.eclipse.stem.core.graph.Graph#switchToNextValue(org.eclipse.stem.core.model.STEMTime)
	 * <em>Switch To Next Value</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Graph#switchToNextValue(org.eclipse.stem.core.model.STEMTime)
	 * @generated NOT
	 */
	public void testSwitchToNextValue__STEMTime() {
		final Graph mainGraph = getFixture();

		// All of the dynamic label current values should be 0 (zero)
		for (final Iterator dynamicLabelIter = mainGraph.getDynamicLabels()
				.iterator(); dynamicLabelIter.hasNext();) {
			assertFalse(valuesSwapped((DynamicLabel) dynamicLabelIter.next()));
		} // for each dynamic label

		for (final Iterator nodeIterator = mainGraph.getNodes().values()
				.iterator(); nodeIterator.hasNext();) {
			final Node node = (Node) nodeIterator.next();
			for (final Iterator labelIter = node.getLabels().iterator(); labelIter
					.hasNext();) {
				final Label label = (Label) labelIter.next();
				// Is it a dynamic label?
				if (label instanceof DynamicLabel) {
					final DynamicLabel dynamicLabel = (DynamicLabel) label;
					assertFalse(valuesSwapped(dynamicLabel));
				}
			} // for node's labels
		} // for each node

		// At this point all of the next values are considered "invalid" this is
		// tested in switchToNextValue.
		for (final Iterator dynamicLabelIter = mainGraph.getDynamicLabels()
				.iterator(); dynamicLabelIter.hasNext();) {
			final DynamicLabel dynamicLabel = (DynamicLabel) dynamicLabelIter
					.next();
			dynamicLabel.setNextValueValid(true);
		} // for

		// DO IT!
		mainGraph.switchToNextValue(SWITCH_TIME);

		assertTrue(mainGraph.getTime().equals(SWITCH_TIME));

		// After the switch
		// All of the dynamic label current values should be swapped
		for (final Iterator dynamicLabelIter = mainGraph.getDynamicLabels()
				.iterator(); dynamicLabelIter.hasNext();) {
			final DynamicLabel dynamicLabel = (DynamicLabel) dynamicLabelIter
					.next();
			assertTrue(valuesSwapped(dynamicLabel));
			assertFalse(dynamicLabel.isNextValueValid());
		} // for each dynamic label

		// There shouldn't be any other dynamic labels lying around that are 0
		for (final Iterator graphLabelIter = mainGraph.getGraphLabels()
				.values().iterator(); graphLabelIter.hasNext();) {
			final Label label = (Label) graphLabelIter.next();
			// Is it a dynamic label?
			if (label instanceof DynamicLabel) {
				final DynamicLabel dynamicLabel = (DynamicLabel) label;
				assertTrue(valuesSwapped(dynamicLabel));
			}
		} // for graph labels

		for (final Iterator nodeIterator = mainGraph.getNodes().values()
				.iterator(); nodeIterator.hasNext();) {
			final Node node = (Node) nodeIterator.next();
			for (final Iterator labelIter = node.getLabels().iterator(); labelIter
					.hasNext();) {
				final Label label = (Label) labelIter.next();
				// Is it a dynamic label?
				if (label instanceof DynamicLabel) {
					final DynamicLabel dynamicLabel = (DynamicLabel) label;
					assertTrue(valuesSwapped(dynamicLabel));
				}
			} // for node's labels
		} // for each node

		for (final Iterator edgeIterator = mainGraph.getEdges().values()
				.iterator(); edgeIterator.hasNext();) {
			final Edge edge = (Edge) edgeIterator.next();
			final Label label = edge.getLabel();
			// Is it a dynamic label?
			if (label instanceof DynamicLabel) {
				final DynamicLabel dynamicLabel = (DynamicLabel) label;
				assertTrue(valuesSwapped(dynamicLabel));
			}
		} // for each edge
	} // testSwitchToNextValue

	/**
	 * Test the Graph has the right type URI.
	 * 
	 * @generated NOT
	 */
	public void testGetTypeURI() {
		final Graph graph = getFixture();
		assertTrue(graph.getTypeURI().equals(STEMURI.GRAPH_TYPE_URI));
	} // testGetTypeURI

	/**
	 * Test that when the URI is set for the graph, the target URI of any
	 * GraphLabels it has also are updated to the new URI value.
	 * 
	 * @generated NOT
	 */
	public void testSetURISetsGraphLabels() {
		final Graph graph = getFixture();
		final URI uriBefore = graph.getURI();

		for (final Iterator labelIter = graph.getGraphLabels().values()
				.iterator(); labelIter.hasNext();) {
			final Label label = (Label) labelIter.next();
			assertTrue(label.getURIOfIdentifiableToBeLabeled().equals(
					graph.getURI()));
			assertFalse(label.getURIOfIdentifiableToBeLabeled().equals(
					GRAPH2_URI));
		} // for

		graph.setURI(GRAPH2_URI);

		for (final Iterator labelIter = graph.getGraphLabels().values()
				.iterator(); labelIter.hasNext();) {
			final Label label = (Label) labelIter.next();
			assertTrue(label.getURIOfIdentifiableToBeLabeled().equals(
					graph.getURI()));
			assertFalse(label.getURIOfIdentifiableToBeLabeled().equals(
					uriBefore));
		} // for
	} // testSetURISetsGraphLabels

	/**
	 * Test the ability to serialize a graph and then de-serialize it.
	 */
	public void testSerializeDeserialize() {
		final Graph graph = getFixture();

		assert graph.sane();
		try {
			Utility.serializeIdentifiable(graph, SERIALZATION_TEST_URI);

			final ResourceSet resourceSet = new ResourceSetImpl();
			final Resource resource = resourceSet.getResource(
					SERIALZATION_TEST_URI, true);

			resource.load(null);

			final Graph deserializedGraph = (Graph) resource.getContents().get(
					0);
			assertNotNull(deserializedGraph);
			assertTrue(graph.getNumEdges() == deserializedGraph.getNumEdges());
			assertTrue(graph.getNumNodes() == deserializedGraph.getNumNodes());
			assertTrue(graph.getNumDynamicLabels() == deserializedGraph
					.getNumDynamicLabels());
			assertTrue(graph.getNumGraphLabels() == deserializedGraph
					.getNumGraphLabels());
			assertTrue(graph.getNumNodeLabels() == deserializedGraph
					.getNumNodeLabels());
		} catch (IOException e) {
			fail(e.getMessage());
		} // catch
		catch (NullPointerException npe) {
			fail(npe.getMessage());
		} // null pointer exception
		catch (Exception e) {
			fail(e.getMessage());
		}

	} // testSerializeDeserialize

	/**
	 * @param label
	 * @return true if the labels have been swapped from their original values.
	 * @generated NOT
	 */
	private boolean valuesSwapped(final Label label) {
		boolean retValue = false;

		// Is it a dynamic label?
		if (label instanceof DynamicLabel) {
			final DynamicLabel dynamicLabel = (DynamicLabel) label;
			retValue = ((TestIntegerLabelValue) label.getCurrentValue()).getI() == TestIntegerLabelValue.NEXT_LABEL_INTEGER_VALUE;
			retValue = retValue
					&& ((TestIntegerLabelValue) dynamicLabel.getNextValue())
							.getI() == TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE;
		} else {
			retValue = ((TestIntegerLabelValue) label.getCurrentValue()).getI() != TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE;
		}
		return retValue;
	} // valuesSwapped

} // GraphTest
