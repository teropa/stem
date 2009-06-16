package org.eclipse.stem.core.sequencer.tests;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import junit.textui.TestRunner;

import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.sequencer.RealTimeSequencer;
import org.eclipse.stem.core.sequencer.SequencerFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Real Time Sequencer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class RealTimeSequencerTest extends SequentialSequencerTest {
	
	private static final long REAL_TIME_TIME_INCREMENT = STEMTime.Units.SECOND.getMilliseconds();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RealTimeSequencerTest.class);
	}

	/**
	 * Constructs a new Real Time Sequencer test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RealTimeSequencerTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Real Time Sequencer test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected RealTimeSequencer getFixture() {
		return (RealTimeSequencer)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());
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
	 * @see org.eclipse.stem.core.sequencer.tests.SequentialSequencerTest#testGetWorkComplete()
	 */
	@Override
	public void testGetWorkComplete() {
		// final RealTimeSequencer fixture = getFixture();
		assertTrue(true);
	}

	/**
	 * @see org.eclipse.stem.core.sequencer.tests.SequentialSequencerTest#testGetWorkIncrement()
	 */
	@Override
	public void testGetWorkIncrement() {
		// final RealTimeSequencer fixture = getFixture();
		assertTrue(true);
	}

	/**
	 * @see org.eclipse.stem.core.sequencer.tests.SequentialSequencerTest#testGetDuration()
	 */
	@Override
	public void testGetDuration() {
		// final RealTimeSequencer fixture = getFixture();
		assertTrue(true);
	}

	/**
	 * @see org.eclipse.stem.core.sequencer.tests.SequentialSequencerTest#testGetNextTime()
	 */
	@Override
	public void testGetNextTime() {
		// This is a bit hard to test given that the value returned by 
		// getNextTime() can vary.
//		 final RealTimeSequencer fixture = getFixture();
//		 final STEMTime nextTime = fixture.getNextTime();
		assertTrue(true);
	} // testGetNextTime

	/**
	 * @see org.eclipse.stem.core.sequencer.tests.SequentialSequencerTest#testIsTimeToStop()
	 */
	@Override
	public void testIsTimeToStop() {
		// final RealTimeSequencer fixture = getFixture();
		assertTrue(true);
	}

	/**
	 * @see org.eclipse.stem.core.sequencer.tests.SequentialSequencerTest#testReset()
	 */
	@Override
	public void testReset() {
		// final RealTimeSequencer fixture = getFixture();
		assertTrue(true);
	} // testReset

	/**
	 * @return an instance of {@link RealTimeSequencer} for testing purposes.
	 */
	public static final RealTimeSequencer createFixture() {
		final RealTimeSequencer retValue = SequencerFactory.eINSTANCE.createRealTimeSequencer();
		
		retValue.setTimeIncrement(REAL_TIME_TIME_INCREMENT);
		
		return retValue;
	} // createFixture


} // RealTimeSequencerTest
