package org.eclipse.stem.diseasemodels.standard.tests;

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

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.definitions.nodes.impl.RegionImpl;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.TestNodeDecorator1;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Infector</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public abstract class InfectorTest extends TestCase {
	
	/**
	 * URI for testing
	 */
	protected static final URI GRAPH_TARGET_URI = STEMURI.createURI("graph/US");
	
	/**
	 * URI for testing
	 */
	protected static final String ISO_TARGET = "US";
	
	/**
	 * URI for testing
	 */
	protected static final URI NODE_TARGET_URI = RegionImpl.createRegionNodeURI(ISO_TARGET);
	
	/**
	 * The fixture for this Infector test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected Infector fixture = null;

	/**
	 * Constructs a new Infector test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfectorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Infector test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Infector fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Infector test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Infector getFixture() {
		return fixture;
	}

	/**
	 * test the sanity of the fixture
	 */
	public void testFixtureSanity() {
		final Infector fixture = getFixture();
		assertTrue(fixture.sane());
	} // testFixtureSanity
	
	/**
	 * create a graph including a node to test with infectors and innoculators
	 * @return
	 */
	public static final Graph getTestGraph() {
		// create at test graph with a node and nodeURI== the target URI for the innoculator
		final Graph g = GraphFactory.eINSTANCE.createGraph();
		g.setURI(GRAPH_TARGET_URI);
		final TestNodeDecorator1 nodeDecorator = DecoratorsFactory.eINSTANCE.createTestNodeDecorator1();
		final Node nodeA = TestUtil.createDynamicalyLabeledNode(nodeDecorator);
		nodeA.setURI(NODE_TARGET_URI);
		g.putNode(nodeA);
		return g;	
	}// get graph for testing
	
} // InfectorTest
