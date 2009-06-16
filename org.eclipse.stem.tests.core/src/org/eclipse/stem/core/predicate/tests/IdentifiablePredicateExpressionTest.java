package org.eclipse.stem.core.predicate.tests;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import junit.textui.TestRunner;

import org.eclipse.stem.core.predicate.IdentifiablePredicateExpression;
import org.eclipse.stem.core.predicate.PredicateFactory;
import org.eclipse.stem.core.predicate.True;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Identifiable Predicate Expression</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class IdentifiablePredicateExpressionTest extends IdentifiablePredicateTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IdentifiablePredicateExpressionTest.class);
	}

	/**
	 * Constructs a new Identifiable Predicate Expression test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifiablePredicateExpressionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Identifiable Predicate Expression test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IdentifiablePredicateExpression getFixture() {
		return (IdentifiablePredicateExpression)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		final IdentifiablePredicateExpression pExpression = PredicateFactory.eINSTANCE.createIdentifiablePredicateExpression();
		final True true0 = PredicateFactory.eINSTANCE.createTrue();
		pExpression.setPredicate(true0);
		setFixture(pExpression);
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
	 * @see org.eclipse.stem.core.predicate.tests.IdentifiablePredicateTest#getExpectedResult()
	 */
	@Override
	protected boolean getExpectedResult() {
		return true;
	}


} //IdentifiablePredicateExpressionTest
