package org.eclipse.stem.core.model.tests;

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

import java.util.Iterator;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.impl.IdentifiableFilterImpl;
import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.EdgeDecorator;
import org.eclipse.stem.core.model.GraphDecorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.model.Model#getCanonicalGraph(org.eclipse.emf.common.util.URI, org.eclipse.stem.core.common.IdentifiableFilter, org.eclipse.stem.core.model.STEMTime) <em>Get Canonical Graph</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.Model#prepare(org.eclipse.stem.core.model.STEMTime) <em>Prepare</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class ModelTest extends IdentifiableTest {

	@SuppressWarnings("unused")
	private static final URI SERIALZATION_TEST_URI = URI
			.createURI("temp/testmodel1.model");

	private static final String MODEL = "model";

	private static final String GRAPH = "graph";

	private static final String LABEL = "label";

	private static final String NODE = "node";

	private static final String NODE_DECORATOR = "nodedecorator";

	// private static final String EDGE_DECORATOR = "edgedecorator";

	private static final String EDGE = "edge";

	// Model URI's
	public static final URI M0_URI = STEMURI.createURI(MODEL + "/" + "m0");

	private static final URI M1_URI = STEMURI.createURI(MODEL + "/" + "m1");

	private static final URI M2_URI = STEMURI.createURI(MODEL + "/" + "m2");

	private static final URI M3_URI = STEMURI.createURI(MODEL + "/" + "m3");

	private static final URI UNRESOLVED_MODEL_URI = STEMURI.createURI(MODEL
			+ "/" + "unresolved");

	// Graph URI's

	private static final URI CANONICAL_GRAPH1_URI = STEMURI.createURI(GRAPH
			+ "/" + "canonicalGraph1");

	private static final URI CANONICAL_GRAPH2_URI = STEMURI.createURI(GRAPH
			+ "/" + "canonicalGraph2");

	private static final URI G0_URI = STEMURI.createURI(GRAPH + "/" + "g0");

	private static final URI G1_URI = STEMURI.createURI(GRAPH + "/" + "g1");

	private static final URI G2_URI = STEMURI.createURI(GRAPH + "/" + "g2");

	private static final URI G3_URI = STEMURI.createURI(GRAPH + "/" + "g3");

	private static final URI G4_URI = STEMURI.createURI(GRAPH + "/" + "g4");

	private static final URI G5_URI = STEMURI.createURI(GRAPH + "/" + "g5");

	// private static final URI GRAPH_RETURN_URI = STEMURI.createURI(GRAPH + "/"
	// + "graph_return");

	// Graph Label URI's
	private static final URI G_L0_URI = STEMURI.createURI(LABEL + "/" + "gl0");

	private static final URI G_L1_URI = STEMURI.createURI(LABEL + "/" + "gl1");

	private static final URI G_L2_URI = STEMURI.createURI(LABEL + "/" + "gl2");

	private static final URI G_L3_URI = STEMURI.createURI(LABEL + "/" + "gl3");

	private static final URI G_L4_URI = STEMURI.createURI(LABEL + "/" + "gl4");

	private static final URI G_L5_URI = STEMURI.createURI(LABEL + "/" + "gl5");

	// Static Node Label URI's
	private static final URI NL0A0_URI = STEMURI.createURI(LABEL + "/"
			+ "nl0a0");

	private static final URI NL0A1_URI = STEMURI.createURI(LABEL + "/"
			+ "nl0a1");

	private static final URI NL3A1_URI = STEMURI.createURI(LABEL + "/"
			+ "nl3a1");

	private static final URI NL3B1_URI = STEMURI.createURI(LABEL + "/"
			+ "nl3b1");

	private static final URI NL4A1_URI = STEMURI.createURI(LABEL + "/"
			+ "nl4a1");

	private static final URI NL4B1_URI = STEMURI.createURI(LABEL + "/"
			+ "nl4b1");

	private static final URI NL4C1_URI = STEMURI.createURI(LABEL + "/"
			+ "nl4c1");

	private static final URI NL5A1_URI = STEMURI.createURI(LABEL + "/"
			+ "nl5a1");

	private static final URI NL5B1_URI = STEMURI.createURI(LABEL + "/"
			+ "nl5b1");

	// Node URI's
	private static final URI N0A_URI = STEMURI.createURI(NODE + "/" + "n0a");

	private static final URI N5A_URI = STEMURI.createURI(NODE + "/" + "n5a");

	private static final URI N5B_URI = STEMURI.createURI(NODE + "/" + "n5b");

	private static final URI N3A_URI = STEMURI.createURI(NODE + "/" + "n3a");

	private static final URI N3B_URI = STEMURI.createURI(NODE + "/" + "n3b");

	public static final URI N4A_URI = STEMURI.createURI(NODE + "/" + "n4a");

	public static final URI N4B_URI = STEMURI.createURI(NODE + "/" + "n4b");

	private static final URI N4C_URI = STEMURI.createURI(NODE + "/" + "n4c");

	private static final URI N4D_URI = STEMURI.createURI(NODE + "/" + "n4d");

	// Decorator URI's
	private static final URI NDEC_0A_URI = STEMURI.createURI(NODE_DECORATOR
			+ "/" + "ndec_0a");

	private static final URI NDEC_2A_URI = STEMURI.createURI(NODE_DECORATOR
			+ "/" + "ndec_2a");

	private static final URI EDEC_1A_URI = STEMURI.createURI(NODE_DECORATOR
			+ "/" + "edec_1a");

	private static final URI EDEC_3A_URI = STEMURI.createURI(NODE_DECORATOR
			+ "/" + "edec_3a");

	private static final URI GDEC_2A_URI = STEMURI.createURI(NODE_DECORATOR
			+ "/" + "gdec_2a");

	// Edge URI'S
	private static final URI E1A_URI = STEMURI.createURI(EDGE + "/" + "e1a");

	private static final URI E1B_URI = STEMURI.createURI(EDGE + "/" + "e1b");

	private static final URI E2A_URI = STEMURI.createURI(EDGE + "/" + "e2a");

	private static final URI E3A_URI = STEMURI.createURI(EDGE + "/" + "e3a");

	private static final URI E4A_URI = STEMURI.createURI(EDGE + "/" + "e4a");

	private static final URI E4B_URI = STEMURI.createURI(EDGE + "/" + "e4b");

	private static final URI E5A_URI = STEMURI.createURI(EDGE + "/" + "e5a");

	// Dynamic Edges
	public static final URI DE4_URI = STEMURI.createTypeURI(EDGE + "/" + "de4");

	/**
	 * This fixture is of a model with unresolved references.
	 * 
	 * @generated NOT
	 */
	protected Model unresolvedFixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModelTest.class);
	}

	/**
	 * Constructs a new Model test case with the given name.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTest(String name) {
		super(name);
	}

	/**
	 * @return the unresolvedFixture
	 * @generated NOT
	 */
	protected final Model getUnresolvedFixture() {
		return unresolvedFixture;
	} // getUnresolvedFixture

	/**
	 * @param unresolvedFixture
	 *            the unresolvedFixture to set
	 * @generated NOT
	 */
	protected final void setUnresolvedFixture(final Model unresolvedFixture) {
		this.unresolvedFixture = unresolvedFixture;
	} // setUnresolvedFixture

	/**
	 * Returns the fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Model getFixture() {
		return (Model)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * 
	 * <pre>
	 *                                                                                  M0
	 *                                                                                  +-NDEC_0A
	 *                                                                                  +-G0
	 *                                                                                  |  +-GL0a
	 *                                                                                  |  +-N0a
	 *                                                                                  |
	 *                                                                                  +-G1
	 *                                                                                  |  +-GL1a
	 *                                                                                  |  +-E1a
	 *                                                                                  |  +-E1b
	 *                                                                                  |
	 *                                                                                  +-M1
	 *                                                                                  |  +-EDEC_1A
	 *                                                                                  |  +-G2
	 *                                                                                  |  |  
	 *                                                                                  |  |  +-GL2a
	 *                                                                                  |  |  +-E2a
	 *                                                                                  |  |
	 *                                                                                  |  +-M2
	 *                                                                                  |     +-GDEC_2A
	 *                                                                                  |     +-NDEC_2A
	 *                                                                                  |     +-G5
	 *                                                                                  |        +-GL5a
	 *                                                                                  |        +-E5a
	 *                                                                                  |        +-N5a
	 *                                                                                  |        +-N5b
	 *                                                                                  |
	 *                                                                                  +-M3
	 *                                                                                     +-EDEC_3A
	 *                                                                                     +-G3
	 *                                                                                     |  +-GL3a
	 *                                                                                     |  +-E3a
	 *                                                                                     |  +-N3a
	 *                                                                                     |  +-N3b
	 *                                                                                     |
	 *                                                                                     +-G4
	 *                                                                                       +-GL4a
	 *                                                                                       +-GL4b
	 *                                                                                       +-E4a
	 *                                                                                       +-E4b
	 *                                                                                       +-N4a
	 *                                                                                       +-N4b
	 *                                                                                       +-N4c
	 *                                                                                       +-N4d
	 *                                                                                      
	 * </pre>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
		setUnresolvedFixture(createUnresolvedFixture(UNRESOLVED_MODEL_URI));
	} // setUp

	/**
	 * Create a Model for testing
	 */
	public static Model createFixture() {
		// *** Model M0 ***
		final Model m0 = createModel(M0_URI);
		m0.getDublinCore().setTitle("m0");
		final NodeDecorator nodeDec0a = createNodeDecorator(NDEC_0A_URI);

		// Graph G0
		final Graph g0 = createGraph(G0_URI);
		g0.getDublinCore().setTitle("g0");
		final Node n0a = TestUtil.createStaticallyLabeledNode(N0A_URI);
		final Label gl0 = TestUtil.createStaticLabel(G_L0_URI, g0.getURI());
		final NodeLabel nl0a0 = TestUtil.createStaticNodeLabel(NL0A0_URI, n0a
				.getURI());
		final NodeLabel nl0a1 = TestUtil.createStaticNodeLabel(NL0A1_URI, n0a
				.getURI());
		final NodeLabel nl3a1 = TestUtil.createStaticNodeLabel(NL3A1_URI,
				N3A_URI);
		final NodeLabel nl3b1 = TestUtil.createStaticNodeLabel(NL3B1_URI,
				N3B_URI);
		final NodeLabel nl5a1 = TestUtil.createStaticNodeLabel(NL5A1_URI,
				N5A_URI);
		final NodeLabel nl5b1 = TestUtil.createStaticNodeLabel(NL5B1_URI,
				N5B_URI);

		// Graph G0
		g0.putGraphLabel(gl0);
		g0.putNode(n0a);
//		g0.putNodeLabel((NodeLabel) n0a.getLabels().get(0));
		g0.putNodeLabel(nl0a0);
		g0.putNodeLabel(nl0a1);
		g0.putNodeLabel(nl3a1);
		g0.putNodeLabel(nl3b1);
		g0.putNodeLabel(nl5a1);
		g0.putNodeLabel(nl5b1);

		// Graph G1
		final Graph g1 = createGraph(G1_URI);
		g1.getDublinCore().setTitle("g1");
		final Label gl1 = TestUtil.createStaticLabel(G_L1_URI, g1.getURI());
		final Edge e1a = TestUtil.createStaticallyLabeledEdge(E1A_URI, N5A_URI,
				N4A_URI, false);
		final Edge e1b = TestUtil.createStaticallyLabeledEdge(E1B_URI, N5B_URI,
				N4B_URI, false);

		// Graph G1
		g1.putGraphLabel(gl1);
		g1.putEdge(e1a);
		g1.putEdge(e1b);

		// *** Model M1 ***
		final Model m1 = createModel(M1_URI);
		m1.getDublinCore().setTitle("m1");
		final EdgeDecorator edec1a = createEdgeDecorator(EDEC_1A_URI, "edec1a",
				N5A_URI, N5B_URI, 0);

		// Graph G2
		final Graph g2 = createGraph(G2_URI);
		g0.getDublinCore().setTitle("g2");
		final Label gl2 = TestUtil.createStaticLabel(G_L2_URI, g2.getURI());
		final Edge e2a = TestUtil.createStaticallyLabeledEdge(E2A_URI, N5A_URI,
				N5B_URI, true);

		// Graph G2
		g2.putGraphLabel(gl2);
		g2.putEdge(e2a);

		// *** Model M2 ***
		final Model m2 = createModel(M2_URI);
		m1.getDublinCore().setTitle("m2");
		final GraphDecorator gdec2a = createGraphDecorator(GDEC_2A_URI);
		final NodeDecorator nodeDec2a = createNodeDecorator(NDEC_2A_URI);

		// Graph G5
		final Graph g5 = createGraph(G5_URI);
		g0.getDublinCore().setTitle("g5");
		final Label gl5 = TestUtil.createStaticLabel(G_L5_URI, g5.getURI());
		final Node n5a = TestUtil.createStaticallyLabeledNode(N5A_URI);
		final Node n5b = TestUtil.createStaticallyLabeledNode(N5B_URI);
		final Edge e5a = TestUtil.createStaticallyLabeledEdge(E5A_URI, N5A_URI,
				N5B_URI, false);

		// Graph G5
		g5.putGraphLabel(gl5);
		g5.putNode(n5a);
		g5.putNode(n5b);
//		g5.putNodeLabel((NodeLabel) n5a.getLabels().get(0));
//		g5.putNodeLabel((NodeLabel) n5b.getLabels().get(0));
		g5.putEdge(e5a);

		// *** Model M3 ***
		final Model m3 = createModel(M3_URI);
		m1.getDublinCore().setTitle("m3");
		final EdgeDecorator edec3a = createEdgeDecorator(EDEC_3A_URI, "edec3a",
				N4A_URI, N4B_URI, 0);

		// Graph G3
		final Graph g3 = createGraph(G3_URI);
		g0.getDublinCore().setTitle("g3");
		final Label gl3 = TestUtil.createStaticLabel(G_L3_URI, g3.getURI());
		final Node n3a = TestUtil.createStaticallyLabeledNode(N3A_URI);
		final Node n3b = TestUtil.createStaticallyLabeledNode(N3B_URI);
		final Edge e3a = TestUtil.createStaticallyLabeledEdge(E3A_URI, N3A_URI,
				N3B_URI, false);

		// Graph G3
		g3.putGraphLabel(gl3);
		g3.putNode(n3a);
		g3.putNode(n3b);
//		g3.putNodeLabel((NodeLabel) n3a.getLabels().get(0));
//		g3.putNodeLabel((NodeLabel) n3b.getLabels().get(0));
		g3.putEdge(e3a);

		// Graph G4
		final Graph g4 = createGraph(G4_URI);
		g0.getDublinCore().setTitle("g4");
		// we deliberately don't label n4d
		final Node n4a = TestUtil.createStaticallyLabeledNode(N4A_URI);
		final Node n4b = TestUtil.createStaticallyLabeledNode(N4B_URI);
		final Node n4c = TestUtil.createStaticallyLabeledNode(N4C_URI);
		final Node n4d = TestUtil.createStaticallyLabeledNode(N4D_URI);
		final Edge e4a = TestUtil.createStaticallyLabeledEdge(E4A_URI, N4A_URI,
				N4B_URI, false);
		final Edge e4b = TestUtil.createStaticallyLabeledEdge(E4B_URI, N4A_URI,
				N4C_URI, false);
		final Label gl4 = TestUtil.createStaticLabel(G_L4_URI, g4.getURI());
		final NodeLabel nl4a1 = TestUtil.createStaticNodeLabel(NL4A1_URI, n4a
				.getURI());
		final NodeLabel nl4b1 = TestUtil.createStaticNodeLabel(NL4B1_URI, n4b
				.getURI());
		final NodeLabel nl4c1 = TestUtil.createStaticNodeLabel(NL4C1_URI, n4c
				.getURI());

		// Graph G4
		g4.putGraphLabel(gl4);
		g4.putNodeLabel(nl4a1);
		g4.putNodeLabel(nl4b1);
		g4.putNodeLabel(nl4c1);
		// we deliberately don't label n4d
		g4.putNode(n4a);
		g4.putNode(n4b);
		g4.putNode(n4c);
		g4.putNode(n4d);
//		g4.putNodeLabel((NodeLabel) n4a.getLabels().get(0));
//		g4.putNodeLabel((NodeLabel) n4b.getLabels().get(0));
//		g4.putNodeLabel((NodeLabel) n4c.getLabels().get(0));
//		g4.putNodeLabel((NodeLabel) n4d.getLabels().get(0));

		g4.putEdge(e4a);
		g4.putEdge(e4b);

		// *** Model M0 ***
		m0.getGraphs().add(g0);
		m0.getGraphs().add(g1);
		m0.getModels().add(m1);
		m0.getModels().add(m3);
		m0.getNodeDecorators().add(nodeDec0a);

		// *** Model M1 ***
		m1.getGraphs().add(g2);
		m1.getModels().add(m2);
		m1.getEdgeDecorators().add(edec1a);

		// *** Model M2 ***
		m2.getGraphs().add(g5);
		m2.getGraphDecorators().add(gdec2a);
		m2.getNodeDecorators().add(nodeDec2a);

		// *** Model M3 ***
		m3.getGraphs().add(g3);
		m3.getGraphs().add(g4);
		m3.getEdgeDecorators().add(edec3a);

		assertTrue(m0.sane());

		return m0;
	} // createFixture

	/**
	 * Create a model with one graph that has one edge and one label that
	 * reference a node that doesn't exist.
	 * 
	 * @param modelURI
	 * @return a fixture for testing
	 */
	private Model createUnresolvedFixture(final URI modelURI) {
		final Model retValue = createModel(modelURI);

		final URI NODE_ONE_URI = STEMURI.createURI(NODE + "/" + "node1");
		final Graph g1 = createGraph(STEMURI.createURI(GRAPH + "/" + "g1"));
		final Edge e1 = TestUtil.createStaticallyLabeledEdge(STEMURI
				.createURI(EDGE + "/" + "e1"), NODE_ONE_URI, NODE_ONE_URI,
				false);
		final NodeLabel l1 = TestUtil.createStaticNodeLabel(STEMURI
				.createURI(LABEL + "/" + "l1"), NODE_ONE_URI);
		g1.putEdge(e1);
		g1.putNodeLabel(l1);

		retValue.getGraphs().add(g1);
		return retValue;
	} // createUnresolvedFixture

	/**
	 * @param uri
	 *            the uri to use for the newly created model
	 * @return a new model instance
	 * @generated NOT
	 */
	private static Model createModel(URI uri) {
		final Model retValue = ModelFactory.eINSTANCE.createModel();
		retValue.setURI(uri);
		return retValue;
	} // createModel

	/**
	 * @param uri
	 *            the uri to use for the newly created graph
	 * @return a new graph instance
	 * @generated NOT
	 */
	private static Graph createGraph(URI uri) {
		final Graph retValue = GraphFactory.eINSTANCE.createGraph();
		retValue.setURI(uri);
		return retValue;
	} // createGraph

	/**
	 * @param uri
	 *            the uri to use for the newly created node decorator
	 * @return the new node decorator instance
	 */
	private static NodeDecorator createNodeDecorator(final URI uri) {
		final NodeDecorator nodeDecorator = DecoratorsFactory.eINSTANCE
				.createTestNodeDecorator1();
		nodeDecorator.setURI(uri);
		return nodeDecorator;
	} // createNodeDecorator

	/**
	 * @param uri
	 *            the uri to use for the newly created edge decorator
	 * @return the new edge decorator instance
	 */
	private static EdgeDecorator createEdgeDecorator(
			final URI edgeDecoratorURI, final String uriString,
			final URI nodeAURI, final URI nodeBURI, final int edgeIndex) {
		final TestEdgeDecorator1 edgeDecorator = DecoratorsFactory.eINSTANCE
				.createTestEdgeDecorator1();
		edgeDecorator.setURI(edgeDecoratorURI);
		edgeDecorator.setNodeAURI(nodeAURI);
		edgeDecorator.setNodeBURI(nodeBURI);
		edgeDecorator.setEdgeURI(createDynamicEdgeURI(uriString, edgeIndex));
		return edgeDecorator;
	} // createEdgeDecorator

	/**
	 * @param edgeDecoratorURI
	 * @return a dynamic edge uri
	 */
	protected static URI createDynamicEdgeURI(final String uriString,
			final int index) {
		final URI retValue = STEMURI.createURI(EDGE + "/" + uriString + index);
		return retValue;
	} // createDynamicEdgeURI

	/**
	 * @param uri
	 *            the uri to use for the newly created graph decorator
	 * @return the new graph decorator instance
	 */
	private static GraphDecorator createGraphDecorator(URI uri) {
		final GraphDecorator graphDecorator = DecoratorsFactory.eINSTANCE
				.createTestGraphDecorator1();
		graphDecorator.setURI(uri);
		return graphDecorator;
	} // createGraphDecorator

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
	 * Tests the '{@link org.eclipse.stem.core.model.Model#getCanonicalGraph(org.eclipse.emf.common.util.URI, org.eclipse.stem.core.common.IdentifiableFilter, org.eclipse.stem.core.model.STEMTime) <em>Get Canonical Graph</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Model#getCanonicalGraph(org.eclipse.emf.common.util.URI, org.eclipse.stem.core.common.IdentifiableFilter, org.eclipse.stem.core.model.STEMTime)
	 * @generated
	 */
	public void testGetCanonicalGraph__URI_IdentifiableFilter_STEMTime() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Model#prepare(org.eclipse.stem.core.model.STEMTime) <em>Prepare</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Model#prepare(org.eclipse.stem.core.model.STEMTime)
	 * @generated
	 */
	public void testPrepare__STEMTime() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Test the sanity of the fixture
	 */
	@Override
	public void testSane() {
		final Model model = getFixture();
		assertTrue(model.sane());
	} // testSane

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Model#getCanonicalGraph(URI) <em>Canonical Graph</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.model.Model#getCanonicalGraph(URI)
	 * @generated NOT
	 */
	public void testGetCanonicalGraph__URI() {
		final int NUM_STATIC_NODES = 9;
		final int NUM_STATIC_EDGES = 7;

		// 1 for EDEC_1A, 1 for EDEC_3A
		final int NUM_DYNAMIC_EDGES = 2;
		final int NUM_STATIC_NODE_LABELS = 2 * NUM_STATIC_NODES;

		// +2 for NDEC_2A on nodes N5a & N5b
		final int NUM_DYNAMIC_NODE_LABELS = NUM_STATIC_NODES + 2;
		final int NUM_STATIC_GRAPH_LABELS = 6;
		final int NUM_DYNAMIC_GRAPH_LABELS = 1;
		final int NUM_DYNAMIC_EDGE_LABELS = NUM_DYNAMIC_EDGES;

		final Model model = getFixture();
		STEMTime time = ModelFactory.eINSTANCE.createSTEMTime();
		final Graph canonicalGraph = model
				.getCanonicalGraph(CANONICAL_GRAPH1_URI, new IdentifiableFilterImpl(model.getDublinCore().getCoverage()), time);

		assertTrue(canonicalGraph.sane());

		// The URI of the graph should be what we think it should be
		assertTrue(canonicalGraph.getURI().equals(CANONICAL_GRAPH1_URI));

		// There shouldn't be any unresolved URI references
		assertTrue(canonicalGraph.getUnresolvedIdentifiables().size() == 0);

		// The numbers should add up
		assertTrue(canonicalGraph.getNumNodes() == NUM_STATIC_NODES);

		assertTrue(canonicalGraph.getNumEdges() == NUM_STATIC_EDGES
				+ NUM_DYNAMIC_EDGES);

		assertTrue(canonicalGraph.getNumGraphLabels() == NUM_STATIC_GRAPH_LABELS
				+ NUM_DYNAMIC_GRAPH_LABELS);

		assertTrue(canonicalGraph.getNumNodeLabels() == NUM_STATIC_NODE_LABELS
				+ NUM_DYNAMIC_NODE_LABELS);

		assertTrue(canonicalGraph.getNumDynamicLabels() == +NUM_DYNAMIC_NODE_LABELS
				+ NUM_DYNAMIC_GRAPH_LABELS + NUM_DYNAMIC_EDGE_LABELS);

		// All the Edges should be hooked up to their nodes
		final Edge e1a = canonicalGraph.getEdge(E1A_URI);
		assertTrue(e1a.getA().getURI().equals(N5A_URI));
		assertTrue(e1a.getB().getURI().equals(N4A_URI));

		final Edge e1b = canonicalGraph.getEdge(E1B_URI);
		assertTrue(e1b.getA().getURI().equals(N5B_URI));
		assertTrue(e1b.getB().getURI().equals(N4B_URI));

		final Edge e2a = canonicalGraph.getEdge(E2A_URI);
		assertTrue(e2a.getA().getURI().equals(N5A_URI));
		assertTrue(e2a.getB().getURI().equals(N5B_URI));

		final Edge e3a = canonicalGraph.getEdge(E3A_URI);
		assertTrue(e3a.getA().getURI().equals(N3A_URI));
		assertTrue(e3a.getB().getURI().equals(N3B_URI));

		final Edge e4a = canonicalGraph.getEdge(E4A_URI);
		assertTrue(e4a.getA().getURI().equals(N4A_URI));
		assertTrue(e4a.getB().getURI().equals(N4B_URI));

		final Edge e4b = canonicalGraph.getEdge(E4B_URI);
		assertTrue(e4b.getA().getURI().equals(N4A_URI));
		assertTrue(e4b.getB().getURI().equals(N4C_URI));

		final Edge e5a = canonicalGraph.getEdge(E5A_URI);
		assertTrue(e5a.getA().getURI().equals(N5A_URI));
		assertTrue(e5a.getB().getURI().equals(N5B_URI));

		// The nodes should have (non-containment) references to their edges and
		// labels
		final Node n0a = canonicalGraph.getNode(N0A_URI);
		final EList n0aEdges = n0a.getEdges();
		assertTrue(n0aEdges.size() == 0);
		final EList n0aLabels = n0a.getLabels();
		// 1 + 2 static labels, 1 dynamic
		assertTrue(n0aLabels.size() == 1 + 2 + 1);
		verifyNodeLabelsReferenceNode(n0a);

		final Node n3a = canonicalGraph.getNode(N3A_URI);
		final EList n3aEdges = n3a.getEdges();
		assertTrue(n3aEdges.size() == 1);
		assertTrue(n3aEdges.contains(e3a));
		final EList n3aLabels = n3a.getLabels();
		// 1 + 1 static label, 1 dynamic
		assertTrue(n3aLabels.size() == 1 + 1 + 1);
		verifyNodeLabelsReferenceNode(n3a);

		final Node n3b = canonicalGraph.getNode(N3B_URI);
		final EList n3bEdges = n3b.getEdges();
		assertTrue(n3bEdges.size() == 1);
		assertTrue(n3bEdges.contains(e3a));
		final EList n3bLabels = n3b.getLabels();
		// 1+ 1 static label, 1 dynamic
		assertTrue(n3bLabels.size() == 1 + 1 + 1);
		verifyNodeLabelsReferenceNode(n3b);

		final Node n4a = canonicalGraph.getNode(N4A_URI);
		final EList n4aEdges = n4a.getEdges();
		// 3 static edges, 1 dynamic
		assertTrue(n4aEdges.size() == 3 + 1);
		assertTrue(n4aEdges.contains(e1a));
		assertTrue(n4aEdges.contains(e4a));
		assertTrue(n4aEdges.contains(e4b));
		// assertTrue(n4aEdges.contains( de4 );
		final EList n4aLabels = n4a.getLabels();
		// 1 + 1 static label, 1 dynamic
		assertTrue(n4aLabels.size() == 1 + 1 + 1);
		verifyNodeLabelsReferenceNode(n4a);

		final Node n4b = canonicalGraph.getNode(N4B_URI);
		final EList n4bEdges = n4b.getEdges();
		// 2 static, 1 dynamic
		assertTrue(n4bEdges.size() == 2 + 1);
		assertTrue(n4bEdges.contains(e1b));
		assertTrue(n4bEdges.contains(e4a));
		// assertTrue(n4aEdges.contains( de4 );
		final EList n4bLabels = n4b.getLabels();
		// 1 + 1 static label, 1 dynamic
		assertTrue(n4bLabels.size() == 1 + 1 + 1);
		verifyNodeLabelsReferenceNode(n4b);

		final Node n4c = canonicalGraph.getNode(N4C_URI);
		final EList n4cEdges = n4c.getEdges();
		assertTrue(n4cEdges.size() == 1);
		assertTrue(n4cEdges.contains(e4b));
		final EList n4cLabels = n4c.getLabels();
		// 1+ 1 static label, 1 dynamic
		assertTrue(n4cLabels.size() == 1 + 1 + 1);
		verifyNodeLabelsReferenceNode(n4c);

		final Node n4d = canonicalGraph.getNode(N4D_URI);
		final EList n4dEdges = n4d.getEdges();
		assertTrue(n4dEdges.size() == 0);
		final EList n4dLabels = n4d.getLabels();
		// 1 static label, 1 dynamic
		assertTrue(n4dLabels.size() == 1 + 1);
		verifyNodeLabelsReferenceNode(n4d);

		final Node n5a = canonicalGraph.getNode(N5A_URI);
		final EList n5aEdges = n5a.getEdges();
		// 3 static, 1 dynamic from edec1a
		assertTrue(n5aEdges.size() == 3 + 1);
		assertTrue(n5aEdges.contains(e1a));
		assertTrue(n5aEdges.contains(e2a));
		assertTrue(n5aEdges.contains(e5a));
		final EList n5aLabels = n5a.getLabels();
		// 1 + 1 static label, 2 dynamic (NDEC_0A & NDEC_2A)
		assertTrue(n5aLabels.size() == 1 + 1 + 2);
		verifyNodeLabelsReferenceNode(n5a);

		final Node n5b = canonicalGraph.getNode(N5B_URI);
		final EList n5bEdges = n5b.getEdges();
		// 3 static, 1 dynamic from edec1a
		assertTrue(n5bEdges.size() == 3 + 1);
		assertTrue(n5bEdges.contains(e1b));
		assertTrue(n5bEdges.contains(e2a));
		assertTrue(n5bEdges.contains(e5a));
		final EList n5bLabels = n5b.getLabels();
		// 1+ 1 static label, 2 dynamic (NDEC_0A & NDEC_2A)
		assertTrue(n5bLabels.size() == 1 + 1 + 2);
		verifyNodeLabelsReferenceNode(n5b);

		// Graph labels should reference the graph
		for (final Iterator graphLabelIter = canonicalGraph.getGraphLabels()
				.values().iterator(); graphLabelIter.hasNext();) {
			final Label label = (Label) graphLabelIter.next();
			final URI graphURI = canonicalGraph.getURI();
			assertTrue("Graph label \"" + label.getURI()
					+ "\" does not reference graph \"" + graphURI
					+ "\", instead, it references \""
					+ label.getURIOfIdentifiableToBeLabeled() + "\"", label
					.getURIOfIdentifiableToBeLabeled().equals(graphURI));
		} // for
	} // testGetCanonicalGraph__URI

	/**
	 * Verify that when a canonical graph is created, it does not destroy the
	 * representation maintained in the model.
	 * 
	 * @generated NOT
	 */
	public void testNonDestructiveGetCanonicalGraph() {
		final Model model = getFixture();

		STEMTime now = ModelFactory.eINSTANCE.createSTEMTime();
		
		final Graph graph1 = model.getCanonicalGraph(CANONICAL_GRAPH1_URI, new IdentifiableFilterImpl(model.getDublinCore().getCoverage()), now);
		final Graph graph2 = model.getCanonicalGraph(CANONICAL_GRAPH2_URI, new IdentifiableFilterImpl(model.getDublinCore().getCoverage()), now);

		final DublinCore dc1 = graph1.getDublinCore();
		final DublinCore dc2 = graph2.getDublinCore();

		// The graphs should be different instances
		assertTrue(graph1 != graph2);
		assertFalse(graph1.getURI().equals(graph2.getURI()));

		// ... but otherwise the same
		assertTrue(graph1.getTypeURI().equals(graph2.getTypeURI()));

		assertTrue(graph1.getURI().toString().equals(dc1.getIdentifier()));
		assertTrue(graph1.getTypeURI().toString().equals(dc1.getType()));

		assertTrue(graph2.getURI().toString().equals(dc2.getIdentifier()));
		assertTrue(graph2.getTypeURI().toString().equals(dc2.getType()));

		assertTrue(graph1.getNumEdges() == graph2.getNumEdges());
		assertTrue(graph1.getNumNodes() == graph2.getNumNodes());
		assertTrue(graph1.getNumNodeLabels() == graph2.getNumNodeLabels());
		assertTrue(graph1.getNumGraphLabels() == graph2.getNumGraphLabels());
		assertTrue(graph1.getNumDynamicLabels() == graph2.getNumDynamicLabels());

		// ... and different
		assertTrue(graph1.getEdge(E1A_URI) != graph2.getEdge(E1A_URI));

	} // testNonDestructiveGetCanonicalGraph

	/**
	 * Test that unresolved identifiers were found
	 * 
	 * @generated NOT
	 */
	public void testGetUnresolvedCanonicalGraph() {
		final Model model = getUnresolvedFixture();
		STEMTime now = ModelFactory.eINSTANCE.createSTEMTime();
		final Graph canonicalGraph = model
				.getCanonicalGraph(CANONICAL_GRAPH1_URI, new IdentifiableFilterImpl(model.getDublinCore().getCoverage()), now);

		// The URI of the graph should be what we think it should be
		assertTrue(canonicalGraph.getURI().equals(CANONICAL_GRAPH1_URI));

		// There should be unresolved URI references
		// 1 for the edge that can't find its nodes and 1 for a Label
		// that can't find its node.
		assertTrue(canonicalGraph.getUnresolvedIdentifiables().size() == 1 + 1);
		// TODO re-do this test
	} // testGetUnresolvedCanonicalGraph

	/**
	 * Test the Model has the right type URI.
	 * 
	 * @generated NOT
	 */
	public void testGetTypeURI() {
		final Model model = getFixture();
		final URI typeURI = model.getTypeURI();
		assertTrue(typeURI.scheme().equals(Constants.STEM_TYPE_SCHEME));
		assertTrue(typeURI.equals(STEMURI.MODEL_TYPE_URI));
	} // testGetTypeURI

	/**
	 * Test that everything in the Model has the correct URI scheme
	 */
	public void testGetURIs() {
		final Model model = getFixture();
		STEMTime now = ModelFactory.eINSTANCE.createSTEMTime();
		final Graph canonicalGraph = model
				.getCanonicalGraph(CANONICAL_GRAPH1_URI, new IdentifiableFilterImpl(model.getDublinCore().getCoverage()), now);

		assertTrue(canonicalGraph.sane());

		assertTrue(canonicalGraph.getNumNodes() > 0);
		assertTrue(canonicalGraph.getNumEdges() > 0);
		assertTrue(canonicalGraph.getNumNodeLabels() > 0);
		assertTrue(canonicalGraph.getNumDynamicLabels() > 0);

		final EList decorators = canonicalGraph.getDecorators();

		assertTrue(decorators.size() > 0);
		// Edge Decorators
		for (final Iterator edgeDecoratorlIter = decorators.iterator(); edgeDecoratorlIter
				.hasNext();) {
			final Decorator edgeDecorator = (Decorator) edgeDecoratorlIter
					.next();
			assertTrue(edgeDecorator.sane());
		} // for each edge decorator

	} // testGetURIs

	/**
	 * Test the ability to serialize a model and then de-serialize it.
	 */
	public void testSerializeDeserialize() {
		final Model model = getFixture();
		try {
			// There is an issue to be resolved with serialization of
			// non-containment references to sub-models and sub-graphs. The
			// fixture we create above has some that do not have a resource
			// specified so when we serialize the fixture they don't get
			// serialized. The result is that when we de-serialize things fail.
			// Comment out the rest of this test until we resolve how to handle
			// this as a solution may emerge from how the editor implementations
			// serialize the things they create. The solution may be to
			// reflectively look for non-containment references when serializing
			// and set the resource for those instances that do not have one so
			// they will be properly serialized too.
			
			//TestUtil.serializeIdentifiable(model, SERIALZATION_TEST_URI);
			// final ResourceSet resourceSet = new ResourceSetImpl();
			// final Resource resource = resourceSet.getResource(
			// SERIALZATION_TEST_URI, true);
			//
			// resource.load(null);
			// final Model deserializedModel = (Model)
			// resource.getContents().get(
			// 0);
			// assertNotNull(deserializedModel);

		}
//			catch (IOException e) {
//			fail(e.getMessage());
//		} // catch
		catch (NullPointerException npe) {
			fail(npe.getMessage());
		} // null pointer exception
		catch (Exception e) {
			fail(e.getMessage());
		}
	} // testSerializeDeserialize

	/**
	 * Perform a JUnit assert ensuring that all of a Node's labels reference the
	 * URI of the node.
	 * 
	 * @param node
	 *            the node to verify
	 */
	private void verifyNodeLabelsReferenceNode(final Node node) {
		final EList labels = node.getLabels();
		final URI nodeURI = node.getURI();
		for (final Iterator nodeLabelIter = labels.iterator(); nodeLabelIter
				.hasNext();) {
			final Label label = (Label) nodeLabelIter.next();
			assertTrue("Label \"" + label.getURI()
					+ "\" does not reference node \"" + nodeURI.toString()
					+ "\", instead, it references \""
					+ label.getURIOfIdentifiableToBeLabeled() + "\"", label
					.getURIOfIdentifiableToBeLabeled().equals(nodeURI));
		} // for each node's label
	} // verifyLabelsReferenceNode

} // ModelTest
