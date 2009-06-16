package org.eclipse.stem.core.common.tests;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;

import junit.framework.TestCase;


/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Identifiable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.common.Identifiable#sane() <em>Sane</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class IdentifiableTest extends TestCase {

	private static final URI TEST_URI = URI.createURI("http://testuri");

	private static final URI TEST_TYPE_URI = URI
			.createURI("http://testtypeuri");

	/**
	 * The fixture for this Identifiable test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected Identifiable fixture = null;

	/**
	 * Constructs a new Identifiable test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 *            <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifiableTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Identifiable test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Identifiable fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Identifiable test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Identifiable getFixture() {
		return fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.common.Identifiable#sane() <em>Sane</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.Identifiable#sane()
	 * @generated NOT
	 */
	public void testSane() {
		final Identifiable identifiable = getFixture();
		assertTrue(identifiable.sane());
	} // testSane

	/**
	 * Test that when setURI is called, it also updates the Identifier of the
	 * Identifiable's DublinCore instance.
	 * 
	 * @generated NOT
	 */
	public void testSetURI() {
		final Identifiable id = getFixture();
		final DublinCore dc = id.getDublinCore();

		assertTrue(id.getURI().toString().equals(dc.getIdentifier()));
		assertFalse(TEST_URI.toString().equals(dc.getIdentifier()));
		assertFalse(id.getURI().equals(TEST_URI));

		id.setURI(TEST_URI);

		assertTrue(id.getURI().toString().equals(dc.getIdentifier()));
		assertTrue(TEST_URI.toString().equals(dc.getIdentifier()));
		assertTrue(id.getURI().equals(TEST_URI));
	} // testSetURI

	/**
	 * Test that when setTypeURI is called, it also updates the Type of the
	 * Identifiable's DublinCore instance.
	 * 
	 * @generated NOT
	 */
	public void testSetTypeURI() {
		final Identifiable id = getFixture();
		final DublinCore dc = id.getDublinCore();

		assertTrue(id.getTypeURI().toString().equals(dc.getType()));
		assertFalse(TEST_TYPE_URI.toString().equals(dc.getType()));
		assertFalse(id.getTypeURI().equals(TEST_TYPE_URI));

		id.setTypeURI(TEST_TYPE_URI);

		assertTrue(id.getTypeURI().toString().equals(dc.getType()));
		assertTrue(TEST_TYPE_URI.toString().equals(dc.getType()));
		assertTrue(id.getTypeURI().equals(TEST_TYPE_URI));
	} // testSetTypeURI
} // IdentifiableTest
