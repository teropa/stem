package org.eclipse.stem.core.model.tests;

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
import junit.textui.TestRunner;

import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>STEM Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.model.STEMTime#addIncrement(long) <em>Add Increment</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.STEMTime#hashCode() <em>Hash Code</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.STEMTime#equals(java.lang.Object) <em>Equals</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class STEMTimeTest extends TestCase {

	// One day's worth of milliseconds
	private static final long TEST_INCREMENT = 24 * 60 * 60 * 1000;

	/**
	 * The fixture for this STEM Time test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected STEMTime fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STEMTimeTest.class);
	}

	/**
	 * Constructs a new STEM Time test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public STEMTimeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this STEM Time test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(STEMTime fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this STEM Time test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STEMTime getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelFactory.eINSTANCE.createSTEMTime());
	}

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
	 * Tests the '{@link org.eclipse.stem.core.model.STEMTime#addIncrement(long) <em>Add Increment</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.model.STEMTime#addIncrement(long)
	 * @generated NOT
	 */
	public void testAddIncrement__long() {
		final STEMTime startTime = getFixture();
		final STEMTime newTime = startTime.addIncrement(TEST_INCREMENT);
		assertTrue(newTime.getTime().compareTo(startTime.getTime()) > 0);
		assertTrue(newTime.getTime().getTime() - startTime.getTime().getTime() == TEST_INCREMENT);
	} // testAddIncrement__long

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.STEMTime#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.STEMTime#hashCode()
	 * @generated NOT
	 */
	public void testHashCode() {
		final STEMTime time1 = getFixture();
		final STEMTime time1a = getFixture();
		assertTrue(time1.hashCode() == time1a.hashCode());
		final STEMTime time2 = time1a.addIncrement(TEST_INCREMENT);
		assertFalse(time1.hashCode() == time2.hashCode());
	} // testHashCode

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.STEMTime#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.STEMTime#equals(java.lang.Object)
	 * @generated NOT
	 */
	public void testEquals__Object() {
		final STEMTime time1 = getFixture();
		final STEMTime time1a = getFixture();
		assertTrue(time1.equals( time1a));
	} // testEquals__Object

} // STEMTimeTest
