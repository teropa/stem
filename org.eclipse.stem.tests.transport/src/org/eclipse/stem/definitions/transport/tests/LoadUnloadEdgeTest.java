package org.eclipse.stem.definitions.transport.tests;

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

import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;

import org.eclipse.stem.definitions.edges.tests.MigrationEdgeTest;
import org.eclipse.stem.definitions.transport.LoadUnloadEdge;
import org.eclipse.stem.definitions.transport.LoadUnloadEdgeLabel;
import org.eclipse.stem.definitions.transport.TransportFactory;
import org.eclipse.stem.tests.util.TestUtil;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Load Unload Edge</b></em>'.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class LoadUnloadEdgeTest extends MigrationEdgeTest {
	
	/**Label to help with some test cases*/
	LoadUnloadEdgeLabel TEST_LABEL = TransportFactory.eINSTANCE.createLoadUnloadEdgeLabel();

	/**
	 * The fixture for this Load Unload Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadUnloadEdge fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LoadUnloadEdgeTest.class);
	}

	/**
	 * Constructs a new Load Unload Edge test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadUnloadEdgeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Load Unload Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(LoadUnloadEdge fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Load Unload Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadUnloadEdge getFixture() {
		return fixture;
	}
	
	/**
	 * Creates the fixture. We need to have nodes on both sides in order to be sane().
	 * 
	 * */
	public LoadUnloadEdge createFixture() {
		
		//This will be a unload edge
		final Node nodeA = TransportFactory.eINSTANCE.createPacketStyleTransportSystem();
		final Node nodeB = TestUtil.createStaticallyLabeledNode();
		LoadUnloadEdge luEdge = TransportFactory.eINSTANCE.createLoadUnloadEdge();
		luEdge.setLabel(TransportFactory.eINSTANCE.createLoadUnloadEdgeLabel());
		luEdge.setLoadingEdge(false);
		luEdge.setNodeAURI(nodeA.getURI());
		luEdge.setNodeBURI(nodeB.getURI());	
		
		
		//We need to set up start and end times for loading
		STEMTime startTime = ModelFactory.eINSTANCE.createSTEMTime();
		STEMTime endTime = startTime.addIncrement(1000);
		
		luEdge.getLabel().setActivationTime(startTime);
		luEdge.getLabel().setDeactivationTime(endTime);
		
		//Make sure the node relations are cool
		luEdge.setA(nodeA);
		luEdge.setB(nodeB);
		nodeA.getEdges().add(luEdge);
		nodeB.getEdges().add(luEdge);
		
		
		return luEdge;
	}


	/**Test setting the for the LoadUnloadEdge*/
	public void testSetLabel() {
		LoadUnloadEdge luEdge = getFixture();
	
		//We need to set up start and end times for loading
		STEMTime startTime = ModelFactory.eINSTANCE.createSTEMTime();
		STEMTime endTime = startTime.addIncrement(2000);
		
		TEST_LABEL.setActivationTime(startTime);
		TEST_LABEL.setDeactivationTime(endTime);
		
		assertFalse(luEdge.getLabel() == TEST_LABEL);
		luEdge.setLabel(TEST_LABEL);
		assertTrue(luEdge.getLabel()==TEST_LABEL);
		assertTrue(luEdge.sane());
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

} //LoadUnloadEdgeTest
