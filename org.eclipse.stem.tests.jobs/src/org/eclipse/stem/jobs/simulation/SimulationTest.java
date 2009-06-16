// SimulationTest.java
package org.eclipse.stem.jobs.simulation;

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

import junit.framework.TestCase;

import org.eclipse.stem.core.scenario.tests.ScenarioTest;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListener;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationState;

/**
 * This class is a JUnit test case for the class Simulation.java
 */
public class SimulationTest extends TestCase implements ISimulationListener {

	/**
	 * The simulation we test.
	 */
	private ISimulation fixture;

	/**
	 * This is the state that we're expecting the fixture simulation to report.
	 */
	private SimulationState expectedSimulationState;

	/**
	 * Returns the fixture for this SimulationEvent test case.
	 */
	private ISimulation getFixture() {
		return this.fixture;
	} // getFixture

	/**
	 * @return a Simulation for testing
	 */
	public static ISimulation createFixture() {
		final ISimulation simulation = SimulationManager.getManager()
				.createSimulation(ScenarioTest.createFixture(), null);
		return simulation;
	} // createFixture

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
		getFixture().addSimulationListener(this);
	} // setUp

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	} // tearDown

	/**
	 * @param object
	 */
	private void setFixture(ISimulation fixture) {
		this.fixture = fixture;
	}

	/**
	 * {@link org.eclipse.stem.jobs.simulation.Simulation#Simulation(org.eclipse.stem.core.scenario.Scenario, int)}
	 */
	public void testSimulationScenario() {
		final ISimulation simulation = getFixture();
		assertNotNull(simulation.getScenario());
	} // testSimulationScenario

	/**
	 * {@link org.eclipse.stem.jobs.simulation.Simulation#getSimulationState()}.
	 */
	public void testGetSimulationState() {
		final ISimulation simulation = getFixture();
		assertTrue(simulation.getSimulationState().equals(
				SimulationState.PAUSED));
	} // testGetSimulationState

	// These are commented out because more work needs to be done to enable the
	// running of the tests out side of eclipse.

	// /**
	// * {@link org.eclipse.stem.jobs.simulation.Simulation#run()}.
	// */
	// public void testRunSimulation() {
	// final ISimulation simulation = getFixture();
	// expectedSimulationState = SimulationState.RUNNING;
	// simulation.run();
	// simulation.stop();
	// } // testRunSimulation
	//
	// /**
	// * {@link org.eclipse.stem.jobs.simulation.Simulation#pause()}.
	// */
	// public void testPauseSimulation() {
	// final ISimulation simulation = getFixture();
	// expectedSimulationState = SimulationState.RUNNING;
	// simulation.run();
	// expectedSimulationState = SimulationState.PAUSED;
	// simulation.stop();
	// } // testPauseSimulation
	//
	// /**
	// * {@link org.eclipse.stem.jobs.simulation.Simulation#reset()}.
	// */
	// public void testResetSimulation() {
	// final ISimulation simulation = getFixture();
	// expectedSimulationState = SimulationState.RUNNING;
	// simulation.run();
	// expectedSimulationState = SimulationState.RUNNING;
	// simulation.pause();
	// expectedSimulationState = SimulationState.RESET;
	// simulation.reset();
	// simulation.stop();
	// } // testResetSimulation

//	/**
//	 * {@link org.eclipse.stem.jobs.simulation.Simulation#step()}.
//	 */
//	@SuppressWarnings("unqualified-field-access")
//	public void testStepSimulation() {
//		final ISimulation simulation = getFixture();
//		expectedSimulationState = SimulationState.RUNNING;
//		simulation.pause();
//		expectedSimulationState = SimulationState.PAUSED;
//		simulation.pause();
//		expectedSimulationState = SimulationState.COMPLETED_CYCLE;
//		simulation.step();
//		expectedSimulationState = SimulationState.STOPPED;
//		simulation.stop();
//	} // testStepSimulation

//	/**
//	 * {@link org.eclipse.stem.jobs.simulation.Simulation#stop()}.
//	 */
//	@SuppressWarnings("unqualified-field-access")
//	public void testStopSimulation() {
//		final ISimulation simulation = getFixture();
//		expectedSimulationState = SimulationState.RUNNING;
//		simulation.pause();
//		expectedSimulationState = SimulationState.STOPPED;
//		simulation.stop();
//	} // testStopSimulation

	/**
	 * {@link org.eclipse.stem.jobs.simulation.Simulation#getScenario()}.
	 */
	public void testGetScenario() {
		final ISimulation simulation = getFixture();
		assertNotNull(simulation.getScenario());
	} // testGetScenario

	/**
	 * {@link org.eclipse.stem.jobs.simulation.Simulation#addSimulationListener(org.eclipse.stem.jobs.simulation.ISimulationListener)}.
	 */
	public void testAddSimulationListener() {
		final ISimulation simulation = getFixture();
		simulation.addSimulationListener(this);
	} // testAddSimulationListener

	/**
	 * {@link org.eclipse.stem.jobs.simulation.Simulation#removeSimulationListener(org.eclipse.stem.jobs.simulation.ISimulationListener)}.
	 */
	public void testRemoveSimulationListener() {
		// Not sure what else to do here, other than to verify that there aren't
		// any exceptions
		testAddSimulationListener();
		final ISimulation simulation = getFixture();
		simulation.removeSimulationListener(this);
	} // testRemoveSimulationListener

	/**
	 * @see org.eclipse.stem.jobs.simulation.ISimulationListener#simulationChanged(org.eclipse.stem.jobs.simulation.SimulationEvent)
	 */
	@SuppressWarnings("unqualified-field-access")
	public void simulationChanged(SimulationEvent event) {
		assertTrue("Expected state \"" + event.getSimulationState()
				+ "\" but received \"" + expectedSimulationState + "\"",
		expectedSimulationState.equals(event.getSimulationState()));
	} // simulationChanged

} // SimulationTest
