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

import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.edges.tests.MigrationEdgeLabelTest;
import org.eclipse.stem.definitions.transport.LoadUnloadEdgeLabel;
import org.eclipse.stem.definitions.transport.TransportFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Load Unload Edge Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.DynamicLabel#reset() <em>Reset</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.DynamicLabel#switchToNextValue() <em>Switch To Next Value</em>}</li>
 * </ul>
 * </p>
 * @generated NOT
 */
public class LoadUnloadEdgeLabelTest extends MigrationEdgeLabelTest {
	protected static final double TEST_RATE = 1.0;
	
	/**
	 * The fixture for this Load Unload Edge Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadUnloadEdgeLabel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LoadUnloadEdgeLabelTest.class);
	}

	/**
	 * Constructs a new Load Unload Edge Label test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadUnloadEdgeLabelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Load Unload Edge Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(LoadUnloadEdgeLabel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Load Unload Edge Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadUnloadEdgeLabel getFixture() {
		return fixture;
	}
	
	/**
	 * Create a LoadUnloadEdgeLabel for use in these test case.
	 * */
	public LoadUnloadEdgeLabel createFixture() {
		LoadUnloadEdgeLabel lueLbl = TransportFactory.eINSTANCE.createLoadUnloadEdgeLabel();
		
		STEMTime startTime = ModelFactory.eINSTANCE.createSTEMTime();
		STEMTime endTime = startTime.addIncrement(1000);
		lueLbl.setActivationTime(startTime);
		lueLbl.setDeactivationTime(endTime);
				
		
		return lueLbl;
	}
	
	/**
	 * Test the setting of the label
	 **/
	public void testActivatedRate () {
		LoadUnloadEdgeLabel lueLabel = getFixture();
		assertTrue(lueLabel.getActivatedRate()==0);
		
		lueLabel.setActivatedRate(TEST_RATE);
		assertTrue(lueLabel.getActivatedRate()==TEST_RATE);
		
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
	
	/**
	 * Tests the '{@link org.eclipse.stem.core.graph.DynamicLabel#reset() <em>Reset</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.DynamicLabel#reset()
	 * @generated NOT
	 */
	public void testReset() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.graph.DynamicLabel#switchToNextValue() <em>Switch To Next Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.DynamicLabel#switchToNextValue()
	 * @generated NOT
	 */
	public void testSwitchToNextValue() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		assertTrue(true);
	}

	/**
	 * Test the Label has the right type URI.
	 * Override test of getTypeURI
	 * @generated NOT
	 */
	public void testGetTypeURI() {
		final Label label = getFixture();
		assertTrue(label.getTypeURI().equals(LoadUnloadEdgeLabel.URI_TYPE_LOAD_UNLOAD_EDGE_LABEL));
	} // testGetTypeURI

	

} //LoadUnloadEdgeLabelTest
