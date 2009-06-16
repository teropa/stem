package org.eclipse.stem.definitions.edges.tests;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import junit.textui.TestRunner;

import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.tests.EdgeTest;
import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.edges.MixingEdge;
import org.eclipse.stem.definitions.edges.MixingEdgeLabel;
import org.eclipse.stem.tests.util.TestUtil;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mixing Edge</b></em>'.
 * <!-- end-user-doc -->
 * @generated NOT
 */
@SuppressWarnings("all")
public class MixingEdgeTest extends EdgeTest {

	static MixingEdgeLabel TEST_LABEL = EdgesFactory.eINSTANCE.createMixingEdgeLabel();
	
	/**
	 * The fixture for this Mixing Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MixingEdge fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MixingEdgeTest.class);
	}

	/**
	 * Constructs a new Mixing Edge test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MixingEdgeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Mixing Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MixingEdge fixture) {
		this.fixture = fixture;
	}
	
	/**
	 * Creates the fixture. We need to have nodes on both sides in order to be sane().
	 * 
	 * */
	public MixingEdge createFixture() {
		final Node nodeA = TestUtil.createStaticallyLabeledNode();
		final Node nodeB = TestUtil.createStaticallyLabeledNode();
		MixingEdge mixingEdge = EdgesFactory.eINSTANCE.createMixingEdge();
		mixingEdge.setNodeAURI(nodeA.getURI());
		mixingEdge.setNodeBURI(nodeB.getURI());
		
		//Make sure the node stuff is all cool.
		mixingEdge.setA(nodeA);
		mixingEdge.setB(nodeB);
		nodeA.getEdges().add(mixingEdge);
		nodeB.getEdges().add(mixingEdge);
		
		return mixingEdge;
	}

	/**
	 * Returns the fixture for this Mixing Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MixingEdge getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	/**Perform basic tests on this fixture*/
	public void testFixture() {
		MixingEdge mixingEdge  = getFixture();
		assertNotNull(mixingEdge);
		assertTrue(mixingEdge.sane());
		assertFalse(mixingEdge.isDirected());
		
		assertNotNull(mixingEdge.getLabel());
	}
	
	/**Test setting the label*/
	public void testSetLabel() {
		MixingEdge mixingEdge = getFixture();
		assertFalse(mixingEdge.getLabel() == TEST_LABEL);
		mixingEdge.setLabel(TEST_LABEL);
		assertTrue(mixingEdge.getLabel()==TEST_LABEL);
		assertTrue(mixingEdge.sane());
	}
	
	/**
	*override of is directed test, since these edges
	*cannot be directed
	 */
	public void testIsDirectedAt__Node() {
		final Edge edge = getFixture();
		final Node nodeA = edge.getA();
		final Node nodeB = edge.getB();

		assertFalse(edge.isDirected());

		assertFalse(edge.isDirectedAt(nodeA));
		assertFalse(edge.isDirectedAt(nodeB));

	} // testIsDirectedAt__Node

} //MixingEdgeTest
