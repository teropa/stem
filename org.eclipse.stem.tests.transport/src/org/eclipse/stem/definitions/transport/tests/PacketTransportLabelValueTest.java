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

import org.eclipse.stem.core.graph.tests.LabelValueTest;
import org.eclipse.stem.definitions.transport.PacketTransportLabelValue;
import org.eclipse.stem.definitions.transport.TransportFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Packet Transport Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class PacketTransportLabelValueTest extends LabelValueTest {
	
	public static double TEST_CAPACITY = 1234.0;

	/**
	 * The fixture for this Packet Transport Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PacketTransportLabelValue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PacketTransportLabelValueTest.class);
	}

	/**
	 * Constructs a new Packet Transport Label Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketTransportLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Packet Transport Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PacketTransportLabelValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Packet Transport Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PacketTransportLabelValue getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TransportFactory.eINSTANCE.createPacketTransportLabelValue());
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
	
	/**Make sure the fixture makes sense*/
	public void testFixture() {
		final PacketTransportLabelValue ptlValue = getFixture();
		assertNotNull(ptlValue);
		assertTrue(ptlValue.sane());
				
		/*Make sure we can set the value*/
		ptlValue.setCapacity(TEST_CAPACITY);
		assertTrue(ptlValue.getCapacity()==TEST_CAPACITY);
		
	}

	/**
	 * Makes sure that reset sets this back to its default value*/
	@Override
	public void testReset() {
		final PacketTransportLabelValue ptlValue = getFixture();
		double defVal = ptlValue.getCapacity();

		ptlValue.setCapacity(TEST_CAPACITY);
		assertFalse(ptlValue.getCapacity()==defVal);
		ptlValue.reset();
		
		assertTrue(ptlValue.getCapacity()==defVal);
		
		
	}
	
	

} //PacketTransportLabelValueTest
