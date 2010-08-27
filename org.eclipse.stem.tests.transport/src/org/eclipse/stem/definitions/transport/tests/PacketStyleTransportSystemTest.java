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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.transport.PacketStyleTransportSystem;
import org.eclipse.stem.definitions.transport.TransportFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Packet Style Transport System</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PacketStyleTransportSystemTest extends TransportSystemTest {

	public static final URI TRANSPORT_SYSTEM_URI = STEMURI.createURI("PacketStyleTransportSystem");
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PacketStyleTransportSystemTest.class);
	}

	/**
	 * Constructs a new Packet Style Transport System test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketStyleTransportSystemTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Packet Style Transport System test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PacketStyleTransportSystem getFixture() {
		return (PacketStyleTransportSystem)fixture;
	}
	
	/**create the fixture*/
	private static PacketStyleTransportSystem createFixture() {
		PacketStyleTransportSystem rc = TransportFactory.eINSTANCE.createPacketStyleTransportSystem();
		rc.setURI(TRANSPORT_SYSTEM_URI);
		rc.getLabels().add(LabelsFactory.eINSTANCE.createPopulationLabel());
		return rc;
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

} //PacketStyleTransportSystemTest
