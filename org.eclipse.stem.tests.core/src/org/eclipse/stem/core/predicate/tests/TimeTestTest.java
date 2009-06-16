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

import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.predicate.TimeTest;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Time Test</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public abstract class TimeTestTest extends TestTest {

	protected STEMTime currentTimeToTest = null;

	/**
	 * Constructs a new Time Test test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeTestTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Time Test test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TimeTest getFixture() {
		return (TimeTest)fixture;
	}

	/**
	 * @see org.eclipse.stem.core.predicate.tests.PredicateTest#getCurrentTimetoTest()
	 */
	@Override
	protected STEMTime getCurrentTimetoTest() {
		return currentTimeToTest;
	}

	/**
	 * @see org.eclipse.stem.core.predicate.tests.PredicateTest#getElapsedTimeToTest()
	 */
	@Override
	protected long getElapsedTimeToTest() {
		return STEMTime.Units.DAY.getMilliseconds();
	}

} // TimeTestTest
