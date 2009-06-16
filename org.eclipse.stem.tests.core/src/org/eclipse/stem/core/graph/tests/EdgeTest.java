package org.eclipse.stem.core.graph.tests;

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

//import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.graph.Edge;
//import org.eclipse.stem.core.graph.GraphFactory;

import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.tests.util.TestUtil;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.Edge#getOtherNode(org.eclipse.stem.core.graph.Node) <em>Get Other Node</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.Edge#isDirectedAt(org.eclipse.stem.core.graph.Node) <em>Is Directed At</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class EdgeTest extends IdentifiableTest {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EdgeTest.class);
	}

	/**
	 * Constructs a new Edge test case with the given name.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Edge test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	protected Edge getFixture() {
		return (Edge)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());
	} // setUp

	/**
	 * @return a statically labeled edge
	 */
	public Edge createFixture() {
		final Node nodeA = TestUtil.createStaticallyLabeledNode();
		final Node nodeB = TestUtil.createStaticallyLabeledNode();
		final Edge edge = TestUtil.createStaticallyLabeledEdge(nodeA.getURI(),
				nodeB.getURI());

		edge.setA(nodeA);
		edge.setB(nodeB);
		nodeA.getEdges().add(edge);
		nodeB.getEdges().add(edge);

		assert edge.sane();

		return edge;
	} // createFixture

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
	 * Test the sanity of the fixture
	 */
	public void testSane() {
		final Edge edge = getFixture();
		assertTrue(edge.sane());
	} // testSane

	/**
	 * Tests the '{@link org.eclipse.stem.core.graph.Edge#getOtherNode(org.eclipse.stem.core.graph.Node) <em>Get Other Node</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Edge#getOtherNode(org.eclipse.stem.core.graph.Node)
	 * @generated NOT
	 */
	public void testGetOtherNode__Node() {
		final Edge edge = getFixture();
		final Node nodeA = edge.getA();
		final Node nodeB = edge.getB();

		assertEquals(edge.getOtherNode(nodeB), nodeA);
		assertEquals(edge.getOtherNode(nodeA), nodeB);
	} // testGetOtherNode__Node

	/**
	 * Tests the '{@link org.eclipse.stem.core.graph.Edge#isDirectedAt(org.eclipse.stem.core.graph.Node) <em>Is Directed At</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.Edge#isDirectedAt(org.eclipse.stem.core.graph.Node)
	 * @generated NOT
	 */
	public void testIsDirectedAt__Node() {
		final Edge edge = getFixture();
		final Node nodeA = edge.getA();
		final Node nodeB = edge.getB();

		edge.setDirected(false);
		assertFalse(edge.isDirected());

		assertFalse(edge.isDirectedAt(nodeA));
		assertFalse(edge.isDirectedAt(nodeB));

		edge.setDirected(true);
		assertTrue(edge.isDirected());

		assertFalse(edge.isDirectedAt(nodeA));
		assertTrue(edge.isDirectedAt(nodeB));

	} // testIsDirectedAt__Node

	/**
	 * Test the Edge has the right type URI.
	 * 
	 * @generated NOT
	 */
	public void testGetTypeURI() {
		final Edge edge = getFixture();
		assertTrue(edge.getTypeURI().equals(STEMURI.EDGE_TYPE_URI));
	} // testGetTypeURI

} // EdgeTest
