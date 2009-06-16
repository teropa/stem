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

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.impl.DublinCoreImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Dublin Core</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.common.DublinCore#populate() <em>Populate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class DublinCoreTest extends TestCase {
	// Used when comparing Date instances for equality.
	final long MILLISECOND_TOLERANCE = 60000;
	
	/**
	 * The fixture for this Dublin Core test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected DublinCore fixture = null;

	/**
	 * @generated NOT
	 */
	protected static final String TEST_STRING = "Dublin Core test string";

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 *            <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DublinCoreTest.class);
	}

	/**
	 * Constructs a new Dublin Core test case with the given name. <!--
	 * begin-user-doc --> Constructs a new Dublin Core test case with the given
	 * name.
	 * 
	 * @param name
	 *            <!-- end-user-doc -->
	 * @generated
	 */
	public DublinCoreTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Dublin Core test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DublinCore fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Dublin Core test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DublinCore getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CommonFactory.eINSTANCE.createDublinCore());
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
	 * Tests the '{@link org.eclipse.stem.core.common.DublinCore#populate()
	 * <em>Populate</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#populate()
	 * @generated NOT
	 */
	public void testPopulate() {
		final String correctDateString = DublinCoreImpl
				.createISO8601DateString(Calendar.getInstance().getTime());
		final DublinCore dc = getFixture();

		final DublinCore tempDC = dc.populate();
		assertTrue(tempDC == dc);

		assertTrue(dc.getCreated().equals(correctDateString));
		assertTrue(dc.getCreator().equals(System.getProperty("user.name")));
	} // testPopulate

	/**
	 * Simple.
	 */
	public void testGetSetIdentifier() {
		final DublinCore dc = getFixture();
		assertNull(dc.getIdentifier());
		dc.setIdentifier(TEST_STRING);
		assertEquals(dc.getIdentifier(), TEST_STRING);
	} // testGetSetIdentifier

	/**
	 * Test that setting the valid start date works
	 */
	public void testSetValidStartDate() {
		final DublinCore dc = getFixture();
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2006, Calendar.JUNE, 1);
		final Date startDate = calendar.getTime();
		dc.setValid(startDate);

		final String validDatesValue = dc.getValid();
		assertTrue(validDatesValue.equals(VALID_START_DATE));
	} // testSetValidStartDate

	public static final String VALID_START_DATE_STRING = "2006-06-01";

	public static final String VALID_END_DATE_STRING = "2006-06-02";

	public static final String VALID_START_DATE = DublinCoreImpl.START
			+ VALID_START_DATE_STRING + ";";

	public static final String VALID_START_AND_END_DATE = VALID_START_DATE
			+ " " + DublinCoreImpl.END + VALID_END_DATE_STRING + ";";

	public static final String VALID_START_AND_BAD_END_DATE = VALID_START_DATE
			+ " " + DublinCoreImpl.END + "adfsf2" + ";";

	/**
	 * Test that setting the valid start and end dates works
	 */
	public void testSetValidStartEndDates() {
		final DublinCore dc = getFixture();
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2006, Calendar.JUNE, 1);
		final Date startDate = calendar.getTime();
		calendar.set(2006, Calendar.JUNE, 2);
		final Date endDate = calendar.getTime();
		dc.setValid(startDate, endDate);

		final String validDatesValue = dc.getValid();
		assertTrue(validDatesValue.equals(VALID_START_AND_END_DATE));
	} // testSetValidStartEndDates

	/**
	 * Test that a {@link Date} can be created from the values in the valid
	 * field.
	 */
	public void testGetValidStartDate() {
		// The number of milliseconds two dates can differ by and still be
		// considered "equal" Value: 1 minute
		

		final DublinCore dc = getFixture();
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2006, Calendar.JUNE, 1, 0, 0, 0);
		final Date startDate = calendar.getTime();
		calendar.set(2006, Calendar.JUNE, 2, 0, 0, 0);
		final Date endDate = calendar.getTime();

		// Just a start date for the range
		dc.setValid(startDate);
		Date start = dc.getValidStartDate();
		assertTrue(Math.abs(start.getTime() - startDate.getTime()) < MILLISECOND_TOLERANCE);
		assertTrue(dc.getValidEndDate() == null);

		// A start and an end date for the range
		dc.setValid(startDate, endDate);
		start = dc.getValidStartDate();
		Date end = dc.getValidEndDate();
		assertTrue(Math.abs(start.getTime() - startDate.getTime()) < MILLISECOND_TOLERANCE);
		assertTrue(Math.abs(end.getTime() - endDate.getTime()) < MILLISECOND_TOLERANCE);

		// No valid value
		dc.setValid((String) null);
		assertTrue(dc.getValidStartDate() == null);
		assertTrue(dc.getValidEndDate() == null);

		// Gibberish
		dc.setValid("asdfasd23");
		assertTrue(dc.getValidStartDate() == null);
		assertTrue(dc.getValidEndDate() == null);

		// Gibberish
		dc.setValid(VALID_START_AND_BAD_END_DATE);
		start = dc.getValidStartDate();
		end = dc.getValidEndDate();
		assertTrue(Math.abs(start.getTime() - startDate.getTime()) < MILLISECOND_TOLERANCE);
		assertTrue(dc.getValidEndDate() == null);
	} // testGetValidStartDate

	/**
	 * Test that the valid date ranges can be compared.
	 */
	public void testIsValidBefore() {
		final DublinCore dcYounger = getFixture();

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2006, Calendar.JUNE, 1, 0, 0, 0); // June 1, 2006
		final Date startDateYounger = calendar.getTime();
		dcYounger.setValid(startDateYounger);

		final DublinCore dcOlder = (DublinCore) EcoreUtil.copy(dcYounger);
		calendar.set(2006, Calendar.JUNE, 2, 0, 0, 0); // June 2, 2006
		final Date startDateOlder = calendar.getTime();
		dcOlder.setValid(startDateOlder);

		final DublinCore dcSameStart = (DublinCore) EcoreUtil.copy(dcYounger);
		dcSameStart.setValid(startDateYounger);

		assertTrue(dcYounger.isValidBefore(dcOlder));
		assertFalse(dcOlder.isValidBefore(dcYounger));
		assertFalse(dcYounger.isValidBefore(dcSameStart));

	} // testIsValidBefore

	/**
	 * Test computing the overlap of valid date ranges.
	 */
	public void testComputeValidDateRangeOverlap() {
		final DublinCore dc = getFixture();
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2006, Calendar.JUNE, 1, 0, 0, 0); // June 1, 2006
		final Date jun0106 = calendar.getTime();
		calendar.set(2006, Calendar.JUNE, 30, 0, 0, 0); // June 30, 2006
		final Date jun3006 = calendar.getTime();
		dc.setValid(jun0106,jun3006);

		// Only over laps start date
		final DublinCore dcOverlapStart = (DublinCore) EcoreUtil.copy(dc);
		calendar.set(2006, Calendar.MAY, 1, 0, 0, 0); // May 1, 2006
		final Date may0106 = calendar.getTime();
		calendar.set(2006, Calendar.JUNE, 15, 0, 0, 0); // June 15, 2006
		final Date jun1506 = calendar.getTime();
		dcOverlapStart.setValid(may0106,jun1506);

		// In between...
		final DublinCore dcBetween = (DublinCore) EcoreUtil.copy(dc);
		calendar.set(2006, Calendar.JUNE, 2, 0, 0, 0); // June 2, 2006
		final Date jun0206 = calendar.getTime();
		dcBetween.setValid(jun0206,jun1506);

		// Only overlaps end date
		final DublinCore dcOverlapEnd = (DublinCore) EcoreUtil.copy(dc);
		calendar.set(2006, Calendar.AUGUST, 1, 0, 0, 0); // August 1, 2006
		final Date aug0106 = calendar.getTime();
		dcOverlapEnd.setValid(jun0206,aug0106);

		// No overlap
		final DublinCore dcNoOverlap = (DublinCore) EcoreUtil.copy(dc);
		calendar.set(2006, Calendar.AUGUST, 30, 0, 0, 0); // August 30, 2006
		final Date aug3006 = calendar.getTime();
		dcNoOverlap.setValid(aug3006,aug0106);

		final Date[] overlapStart = dc.computeValidDateRangeOverlap(dcOverlapStart);
		assertTrue(Math.abs(overlapStart[0].getTime() - jun0106.getTime()) < MILLISECOND_TOLERANCE);
		assertTrue(Math.abs(overlapStart[1].getTime() - jun1506.getTime()) < MILLISECOND_TOLERANCE);
		
		final Date[] between = dc.computeValidDateRangeOverlap(dcBetween);
		assertTrue(Math.abs(between[0].getTime() - jun0206.getTime()) < MILLISECOND_TOLERANCE);
		assertTrue(Math.abs(between[1].getTime() - jun1506.getTime()) < MILLISECOND_TOLERANCE);
		
		final Date[] overlapEnd = dc.computeValidDateRangeOverlap(dcOverlapEnd);
		assertTrue(Math.abs(overlapEnd[0].getTime() - jun0206.getTime()) < MILLISECOND_TOLERANCE);
		assertTrue(Math.abs(overlapEnd[1].getTime() - jun3006.getTime()) < MILLISECOND_TOLERANCE);
		
		final Date[] noOverlapEnd = dc.computeValidDateRangeOverlap(dcNoOverlap);
		assertNull(noOverlapEnd);
		
	} // testComputeValidDateRangeOverlap

} // DublinCoreTest
