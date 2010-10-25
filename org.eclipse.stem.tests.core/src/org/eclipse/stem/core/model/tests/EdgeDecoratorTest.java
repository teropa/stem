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

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.model.EdgeDecorator;
import org.eclipse.stem.core.model.ModelFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Edge Decorator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class EdgeDecoratorTest extends DecoratorTest {
	
	public static URI DECORATOR_URI = STEMURI.createURI("decorator/edgeDecoratorTest.decorator");
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EdgeDecoratorTest.class);
	}

	/**
	 * Constructs a new Edge Decorator test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EdgeDecoratorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Edge Decorator test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EdgeDecorator getFixture() {
		return (EdgeDecorator)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		
		EdgeDecorator d = ModelFactory.eINSTANCE.createEdgeDecorator();
		d.setURI(DECORATOR_URI);
		
		setFixture(d);
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
	 * Test the sanity of the fixture
	 */
	public void testSane() {
		final EdgeDecorator edgeDecorator = getFixture();
		assertTrue(edgeDecorator.sane());
	} // testSane


} // EdgeDecoratorTest
