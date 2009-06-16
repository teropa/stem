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
import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.edges.MigrationEdge;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabel;
import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.core.graph.tests.EdgeTest;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Migration Edge</b></em>'.
 * <!-- end-user-doc -->
 * @generated NOT
 */
@SuppressWarnings("all")
public class MigrationEdgeTest extends EdgeTest {
	
	/**Static label for use in tests*/
	static MigrationEdgeLabel TEST_LABEL = EdgesFactory.eINSTANCE.createMigrationEdgeLabel();

	/**
	 * The fixture for this Migration Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MigrationEdge fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MigrationEdgeTest.class);
	}

	/**
	 * Constructs a new Migration Edge test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationEdgeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Migration Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MigrationEdge fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Migration Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MigrationEdge getFixture() {
		return fixture;
	}
	
	/**
	 * Creates the fixture. We need to have nodes on both sides in order to be sane().
	 * 
	 * */
	public MigrationEdge createFixture() {
		final Node nodeA = TestUtil.createStaticallyLabeledNode();
		final Node nodeB = TestUtil.createStaticallyLabeledNode();
		MigrationEdge migrationEdge = EdgesFactory.eINSTANCE.createMigrationEdge();
		migrationEdge.setNodeAURI(nodeA.getURI());
		migrationEdge.setNodeBURI(nodeB.getURI());	
		
		//Make sure the node relations are cool
		migrationEdge.setA(nodeA);
		migrationEdge.setB(nodeB);
		nodeA.getEdges().add(migrationEdge);
		nodeB.getEdges().add(migrationEdge);
		
		
		return migrationEdge;
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
	
	/**Perform basic tests on this fixture*/
	public void testFixture() {
		MigrationEdge migrationEdge  = getFixture();
		assertNotNull(migrationEdge);
		assertTrue(migrationEdge.sane());
		assertTrue(migrationEdge.isDirected());
		
		assertNotNull(migrationEdge.getLabel());
	}
	
	/**Test setting the label*/
	public void testSetLabel() {
		MigrationEdge migrationEdge = getFixture();
		assertFalse(migrationEdge.getLabel() == TEST_LABEL);
		migrationEdge.setLabel(TEST_LABEL);
		assertTrue(migrationEdge.getLabel()==TEST_LABEL);
		assertTrue(migrationEdge.sane());
	}
	
	/**Test Directed*/
	public void testIsDirectedAt__Node() {
		final Edge edge = getFixture();
		final Node nodeA = edge.getA();
		final Node nodeB = edge.getB();
		
		edge.setDirected(true);
		assertTrue(edge.isDirected());

		assertFalse(edge.isDirectedAt(nodeA));
		assertTrue(edge.isDirectedAt(nodeB));
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

} //MigrationEdgeTest
