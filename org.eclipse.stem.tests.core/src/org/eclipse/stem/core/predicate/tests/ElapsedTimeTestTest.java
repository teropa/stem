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

import java.util.Date;

import junit.textui.TestRunner;

import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.predicate.ElapsedTimeTest;
import org.eclipse.stem.core.predicate.PredicateFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Elapsed Time Test</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class ElapsedTimeTestTest extends TimeTestTest {

	
	/**
	 * This is the number of elapsed days to test 
	 */
	public static final int ELASPED_DAYS_TO_TEST = 2;

	
	/**
	 * This is the expected number of milliseconds of elapsed time.
	 */
	public static final long ELASPED_MS_TO_TEST = ELASPED_DAYS_TO_TEST
			* org.eclipse.stem.core.model.STEMTime.Units.DAY
					.getMilliseconds();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ElapsedTimeTestTest.class);
	}

	/**
	 * Constructs a new Elapsed Time Test test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElapsedTimeTestTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Elapsed Time Test test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ElapsedTimeTest getFixture() {
		return (ElapsedTimeTest)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		final ElapsedTimeTest ett = PredicateFactory.eINSTANCE
				.createElapsedTimeTest();
		ett.setNumberofDays(ELASPED_DAYS_TO_TEST);
		ett.setReferenceTimeValid(true);

		// The current time we'll use for comparison will be one day after the
		// number of days in the test so the expected result is true
		final long currentTimeMS = ett.getReferenceTime().getTime().getTime()
				+ (ELASPED_DAYS_TO_TEST + 1)
				* STEMTime.Units.DAY.getMilliseconds();
		currentTimeToTest = ModelFactory.eINSTANCE.createSTEMTime();
		currentTimeToTest.setTime(new Date(currentTimeMS));

		setFixture(ett);
	} // setUp

	
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
	 * Tests the '{@link org.eclipse.stem.core.predicate.ElapsedTimeTest#getElapsedMilliseconds() <em>Elapsed Milliseconds</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.ElapsedTimeTest#getElapsedMilliseconds()
	 * @generated NOT
	 */
	public void testGetElapsedMilliseconds() {
		final ElapsedTimeTest ett = getFixture();
		assertTrue(ett.getElapsedMilliseconds() == ELASPED_DAYS_TO_TEST
				* STEMTime.Units.DAY.getMilliseconds());
	} // testGetElapsedMilliseconds

	/**
	 * @see org.eclipse.stem.core.predicate.tests.PredicateTest#getExpectedResult()
	 */
	@Override
	protected boolean getExpectedResult() {
		return true;
	}

} //ElapsedTimeTestTest
