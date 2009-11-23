// SimulationEventTest.java
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

import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.tests.ScenarioTest;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationState;

/**
 * This class is a JUnit test case for the class SimulationEvent
 */
public class SimulationEventTest extends TestCase {

	/**
	 * The fixture for this SimulationEvent test.
	 */
	protected SimulationEvent fixture;

	/**
	 * Sets the fixture for this SimulationEvent test case.
	 */
	protected void setFixture(SimulationEvent fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SimulationEvent test case.
	 */
	private SimulationEvent getFixture() {
		return this.fixture;
	} // getFixture

	/**
	 * @return a SimulationEvent for testing
	 */
	public static SimulationEvent createFixture() {
		Scenario scenario = ScenarioTest.createFixture();
		final ISimulation simulation = SimulationManager.getManager()
				.createSimulation(scenario, null);
		return new SimulationEvent(simulation, SimulationState.RUNNING);
	} // createFixture

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setFixture(createFixture());
	} // setUp

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Test method for the ability to get the state
	 * {@link org.eclipse.stem.jobs.simulation.SimulationEvent#getSimulationState()}.
	 */
	public void testGetSimulationState() {
		final SimulationEvent simulationEvent = getFixture();
		assertTrue(simulationEvent.getSimulationState().equals(
				SimulationState.RUNNING));
	} // testGetSimulationState

	/**
	 * Test method for the ability to get the originating Simulation
	 * {@link org.eclipse.stem.jobs.simulation.SimulationEvent#getSimulation()}.
	 */
	public void testGetSimulation() {
		final SimulationEvent simulationEvent = getFixture();
		assertNotNull(simulationEvent.getSimulation());
	} // testGetSimulation

}
// SimulationEventTest
