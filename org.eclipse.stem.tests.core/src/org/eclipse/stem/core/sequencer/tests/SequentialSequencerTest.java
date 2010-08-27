package org.eclipse.stem.core.sequencer.tests;

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

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.stem.core.sequencer.SequencerFactory;
import org.eclipse.stem.core.sequencer.SequentialSequencer;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Sequential Sequencer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class SequentialSequencerTest extends SequencerTest {

	public static URI SEQUENCER_WITH_END_URI = STEMURI.createURI("sequencer/sequentialSequencerWithEndTest.sequencer");
	public static URI SEQUENCER_WITH_NO_END_URI = STEMURI.createURI("sequencer/sequentialSequencerWithNoEndTest.sequencer");
	
	
	private static final int START_DAY = 20;
	private static final int END_DAY = 29;
	private static final int NUMBER_OF_DAYS =  END_DAY - START_DAY + 1;
	
	// The fixture sequencer sequences through 10 days
	public static final STEMTime START_TIME = createSTEMTime(2006,
			Calendar.NOVEMBER, START_DAY);

	public static final STEMTime END_TIME = createSTEMTime(2006,
			Calendar.NOVEMBER, END_DAY);

	public static final long TIME_INCREMENT = STEMTime.Units.DAY.getMilliseconds();
	

	
	
	
	protected SequentialSequencer sequencerWithNoEndTime = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SequentialSequencerTest.class);
	}

	/**
	 * Constructs a new Sequential Sequencer test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SequentialSequencerTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Sequential Sequencer test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void setFixture(SequentialSequencer fixture) {
		super.setFixture(fixture);
	}

	/**
	 * Returns the fixture for this Sequential Sequencer test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SequentialSequencer getFixture() {
		return (SequentialSequencer) super.fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());

		sequencerWithNoEndTime = SequencerFactory.eINSTANCE
				.createSequentialSequencer();
		sequencerWithNoEndTime.setStartTime((STEMTime) EcoreUtil
				.copy(START_TIME));
		sequencerWithNoEndTime.setCurrentTime((STEMTime) EcoreUtil
				.copy(START_TIME));
		sequencerWithNoEndTime.setTimeIncrement(TIME_INCREMENT);
		
		sequencerWithNoEndTime.setURI(SEQUENCER_WITH_NO_END_URI);
	} // setUp

	/**
	 * @return a sequential sequencer
	 */
	public static SequentialSequencer createFixture() {
		final SequentialSequencer sequencerWithEnd = SequencerFactory.eINSTANCE
				.createSequentialSequencer();
		sequencerWithEnd.setStartTime((STEMTime) EcoreUtil.copy(START_TIME));
		sequencerWithEnd.setCurrentTime((STEMTime) EcoreUtil.copy(START_TIME));
		sequencerWithEnd.setEndTime((STEMTime) EcoreUtil.copy(END_TIME));
		sequencerWithEnd.setTimeIncrement(TIME_INCREMENT);
		sequencerWithEnd.setURI(SEQUENCER_WITH_END_URI);
		
		return sequencerWithEnd;
	} // createFixture

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
		sequencerWithNoEndTime = null;
	} // tearDown

	/**
	 * @see org.eclipse.stem.core.scenario.tests.SequencerTest#testGetNextTime()
	 */
	@Override
	public void testGetNextTime() {

		final STEMTime nextTime = START_TIME.addIncrement(TIME_INCREMENT);

		final SequentialSequencer seqWithEndTime = getFixture();
		// The first time should be the start time
		assertTrue(seqWithEndTime.getNextTime().equals(START_TIME));
		
		assertTrue(seqWithEndTime.getNextTime().equals(nextTime));
		assertFalse(seqWithEndTime.getNextTime().equals(nextTime));

		final SequentialSequencer seqWithNoEndTime = sequencerWithNoEndTime;
		assertTrue(seqWithNoEndTime.getNextTime().equals( START_TIME));
		assertTrue(seqWithNoEndTime.getNextTime().equals(nextTime));
		assertFalse(seqWithNoEndTime.getNextTime().equals(nextTime));
	} // testGetNextTime

	/**
	 * Test that the duration is computed correctly
	 */
	public void testGetDuration() {
		final SequentialSequencer seqWithEndTime = getFixture();
		assertTrue(seqWithEndTime.getDuration() == END_TIME.getTime().getTime()
				- START_TIME.getTime().getTime());

		final SequentialSequencer seqWithNoEndTime = sequencerWithNoEndTime;
		assertTrue(seqWithNoEndTime.getDuration() == Sequencer.UNKNOWN_DURATION);
	} // testGetDuration

	/**
	 * @see org.eclipse.stem.core.scenario.tests.SequencerTest#testGetWorkIncrement()
	 */
	@Override
	public void testGetWorkIncrement() {
		final SequentialSequencer seqWithEndTime = getFixture();
		assertTrue(seqWithEndTime.getWorkIncrement() == 10);

		final SequentialSequencer seqWithNoEndTime = sequencerWithNoEndTime;
		assertTrue(seqWithNoEndTime.getWorkIncrement() == 0);
	} // testGetWorkIncrement

	/**
	 * @see org.eclipse.stem.core.scenario.tests.SequencerTest#testIsTimeToStop()
	 */
	@Override
	public void testIsTimeToStop() {
		final SequentialSequencer seqWithEndTime = getFixture();
		assertNotNull(seqWithEndTime.getEndTime());
		assertFalse(seqWithEndTime.isTimeToStop());
		for (int i = 0; i < NUMBER_OF_DAYS; i++) {
			assertFalse(seqWithEndTime.isTimeToStop());
			seqWithEndTime.getNextTime();
		}
		assertTrue(seqWithEndTime.isTimeToStop());

		final SequentialSequencer seqWithNoEndTime = sequencerWithNoEndTime;
		assertFalse(seqWithNoEndTime.isTimeToStop());
		for (int i = 0; i < 10; i++) {
			seqWithNoEndTime.getNextTime();
			assertFalse(seqWithNoEndTime.isTimeToStop());
		}
		seqWithNoEndTime.getNextTime();
		assertFalse(seqWithNoEndTime.isTimeToStop());
	} // testIsTimeToStop

	/**
	 * @see org.eclipse.stem.core.tests.SequencerTest#testGetWorkComplete()
	 */
	public void testGetWorkComplete() {
		final SequentialSequencer seqWithEndTime = getFixture();
		assertFalse(seqWithEndTime.isTimeToStop());
		for (int i = 0; i < NUMBER_OF_DAYS; i++) {
			seqWithEndTime.getNextTime();
			assertTrue(seqWithEndTime.getWorkComplete() == (i+1) * NUMBER_OF_DAYS);
		}
		assertTrue(seqWithEndTime.getWorkComplete() == 100);

		final SequentialSequencer seqWithNoEndTime = sequencerWithNoEndTime;
		assertFalse(seqWithNoEndTime.isTimeToStop());
		for (int i = 0; i < NUMBER_OF_DAYS; i++) {
			seqWithNoEndTime.getNextTime();
			assertTrue(seqWithNoEndTime.getWorkComplete() == 0);
		}
		seqWithNoEndTime.getNextTime();
		assertTrue(seqWithNoEndTime.getWorkComplete() == 0);
	} // testGetWorkComplete

	/**
	 * @see org.eclipse.stem.core.sequencer.tests.SequencerTest#testReset()
	 */
	@Override
	public void testReset() {
		final SequentialSequencer seqWithEndTime = getFixture();
		assertTrue(seqWithEndTime.getStartTime().equals(
				seqWithEndTime.getCurrentTime()));
		final STEMTime time1 = seqWithEndTime.getNextTime();
		assertTrue(seqWithEndTime.getStartTime().equals(
				seqWithEndTime.getCurrentTime()));
		seqWithEndTime.reset();
		assertTrue(seqWithEndTime.getStartTime().equals(
				seqWithEndTime.getCurrentTime()));
	} // testReset

	/**
	 * Create an instance of STEMTime
	 * 
	 * @return the instance
	 */
	private static STEMTime createSTEMTime(final int year, final int month,
			final int day) {
		final STEMTime retValue = getCurrentSystemTime();

		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		retValue.setTime(calendar.getTime());
		return retValue;
	} // createSTEMTime

	/**
	 * @return the current real wall clock time as returned by the system.
	 */
	protected static STEMTime getCurrentSystemTime() {
		return ModelFactory.eINSTANCE.createSTEMTime();
	} // getCurrentSystemTime
} // SequentialSequencerTest
