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

import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.predicate.IdentifiablePredicate;
import org.eclipse.stem.core.predicate.Predicate;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Identifiable Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.predicate.Predicate#evaluate(org.eclipse.stem.core.model.STEMTime, long, org.eclipse.stem.core.model.Decorator) <em>Evaluate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class IdentifiablePredicateTest extends IdentifiableTest {

	/**
	 * Constructs a new Identifiable Predicate test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifiablePredicateTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Identifiable Predicate test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IdentifiablePredicate getFixture() {
		return (IdentifiablePredicate)fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.predicate.Predicate#evaluate(org.eclipse.stem.core.model.STEMTime, long, org.eclipse.stem.core.model.Decorator) <em>Evaluate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.Predicate#evaluate(org.eclipse.stem.core.model.STEMTime, long, org.eclipse.stem.core.model.Decorator)
	 * @generated NOT
	 */
	public void testEvaluate__STEMTime_long_Decorator() {
		final Predicate fixture = getFixture();
		final STEMTime currentTime = getCurrentTimetoTest();
		final long elapsedTime = getElapsedTimeToTest();
		final boolean result = fixture.evaluate(currentTime, elapsedTime, null);
		assertTrue (result == getExpectedResult());
	}

	/**
	 * @return
	 */
	protected long getElapsedTimeToTest() {
		return 0L;
	}

	/**
	 * @return
	 */
	protected STEMTime getCurrentTimetoTest() {
		return null;
	}

	/**
	 * @return the expected result of calling getFixture.evaluate();
	 */
	abstract protected boolean getExpectedResult();
	
} //IdentifiablePredicateTest
