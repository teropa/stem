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

//import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.ModelFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#decorateGraph(org.eclipse.stem.core.model.STEMTime) <em>Decorate Graph</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long, int) <em>Update Labels</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#resetLabels() <em>Reset Labels</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#getLabelsToUpdate(int, int) <em>Get Labels To Update</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#prepare(org.eclipse.stem.core.model.Model, org.eclipse.stem.core.model.STEMTime) <em>Prepare</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class DecoratorTest extends IdentifiableTest {
	
	public static URI DECORATOR_URI = STEMURI.createURI("decorator/decoratorTest.decorator");
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DecoratorTest.class);
	}

	/**
	 * Constructs a new Decorator test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DecoratorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Decorator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Decorator getFixture() {
		return (Decorator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelFactory.eINSTANCE.createDecorator());
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
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#decorateGraph(org.eclipse.stem.core.model.STEMTime) <em>Decorate Graph</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#decorateGraph(org.eclipse.stem.core.model.STEMTime)
	 * @generated
	 */
	public void testDecorateGraph__STEMTime() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}


	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long, int) <em>Update Labels</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long, int)
	 * @generated NOT
	 */
	public void testUpdateLabels__STEMTime_long_int() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long) <em>Update Labels</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long)
	 * @generated NOT
	 */
	public void testUpdateLabels__STEMTime_long() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#resetLabels() <em>Reset Labels</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#resetLabels()
	 * @generated NOT
	 */
	public void testResetLabels() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#getLabelsToUpdate(int, int) <em>Get Labels To Update</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#getLabelsToUpdate(int, int)
	 * @generated NOT
	 */
	public void testGetLabelsToUpdate__int_int() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#prepare(org.eclipse.stem.core.model.Model, org.eclipse.stem.core.model.STEMTime) <em>Prepare</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#prepare(org.eclipse.stem.core.model.Model, org.eclipse.stem.core.model.STEMTime)
	 * @generated
	 */
	public void testPrepare__Model_STEMTime() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} // DecoratorTest
