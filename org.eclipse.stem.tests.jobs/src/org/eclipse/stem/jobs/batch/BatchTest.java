// BatchTest.java
package org.eclipse.stem.jobs.batch;

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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is a JUnit4 test case for the {@link Batch} class.
 */
abstract public class BatchTest {

	/**
	 * An integer to be used as a sequence number for testing.
	 */
	public static final int BATCH_SEQUENCE_NUMBER = 3;

	/**
	 * The current {@link Batch} under test.
	 */
	protected Batch fixture;

	private Batch getFixture() {
		return fixture;
	} // getFixture

	void setFixture(final Batch batch) {
		this.fixture = batch;
	} // setFixture

	/**
	 * @return a new implementation of {@link Batch} or a subclass for testing
	 *         purposes.
	 */
	abstract public Batch createFixture();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		setFixture(createFixture());
	} // setUp

	// /**
	// * Test method for
	// * {@link
	// org.eclipse.stem.jobs.batch.Batch#run(org.eclipse.core.runtime.IProgressMonitor)}.
	// */
	// @Test
	// public void testRunIProgressMonitor() {
	// fail("Not yet implemented"); // TODO
	// }
	//
	// /**
	// * Test method for
	// * {@link org.eclipse.stem.jobs.batch.Batch#getTotalWork()}.
	// */
	// @Test
	// public void testGetTotalWork() {
	// fail("Not yet implemented"); // TODO
	// }
	//
	// /**
	// * Test method for
	// * {@link org.eclipse.stem.jobs.batch.Batch#getNextSimulationToRun()}.
	// */
	// @Test
	// public void testGetNextSimulationToRun() {
	// fail("Not yet implemented"); // TODO
	// }

	// /**
	// * Test method for {@link org.eclipse.stem.jobs.batch.Batch#run()}.
	// */
	// @Test
	// public void testRun() {
	// fail("Not yet implemented"); // TODO
	// }
	//
	// /**
	// * Test method for {@link org.eclipse.stem.jobs.batch.Batch#stop()}.
	// */
	// @Test
	// public void testStop() {
	// fail("Not yet implemented"); // TODO
	// }

	// /**
	// * Test method for
	// * {@link
	// org.eclipse.stem.jobs.batch.Batch#simulationChanged(org.eclipse.stem.jobs.simulation.SimulationEvent)}.
	// */
	// @Test
	// public void testSimulationChanged() {
	// fail("Not yet implemented"); // TODO
	// }

	/**
	 * Test method for
	 * {@link org.eclipse.stem.jobs.batch.Batch#getSequenceNumber()}.
	 */
	@Test
	public void testGetSequenceNumber() {
		final Batch fixture = getFixture();
		assertTrue(fixture.getSequenceNumber() == BATCH_SEQUENCE_NUMBER);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.stem.jobs.batch.Batch#getBatchState()}.
	 */
	@Test
	public void testGetBatchState() {
		assertTrue(getFixture().getBatchState() == BatchState.PAUSED);
	} // testGetBatchState

	/**
	 * Test method for {@link org.eclipse.stem.jobs.batch.Batch#toString()}.
	 */
	@Test
	public void testToString() {
		assertNotNull(getFixture().toString());
	} // testToString

} // BatchTest
