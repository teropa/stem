// SimulationManagerTest.java
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

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.stem.core.scenario.tests.ScenarioTest;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationManagerListener;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationManagerEvent;

/**
 * This class is a JUnit test for {@link SimulationManager}.
 */
public class SimulationManagerTest extends TestCase implements
		ISimulationManagerListener {

	/**
	 * The fixture to be tested.
	 */
	protected SimulationManager fixture;

	private ISimulation[] expectedRemoved;

	private ISimulation[] expectedAdded;

	/**
	 * Returns the fixture for this SimulationEvent test case.
	 */
	private SimulationManager getFixture() {
		return this.fixture;
	} // getFixture

	/**
	 * @return a SimulationManager for testing
	 */
	public static SimulationManager createFixture() {
		SimulationManager.resetSimulationManager();
		final SimulationManager manager = SimulationManager.getManager();
		manager.createSimulation(ScenarioTest.createFixture(), null);
		return manager;
	} // createFixture

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
		getFixture().addSimulationManagerListener(this);
	} // setUp

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	} // tearDown

	/**
	 * @param fixture
	 *            the simulation manager to test
	 */
	private void setFixture(SimulationManager fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 * {@link org.eclipse.stem.jobs.simulation.SimulationManager#getManager()}.
	 */
	public void testGetManager() {
		final SimulationManager manager = getFixture();
		assertNotNull(manager);
	} // testGetManager

	/**
	 * {@link org.eclipse.stem.jobs.simulation.SimulationManager#getActiveSimulations()}.
	 */
	public void testGetActiveSimulations() {
		final SimulationManager manager = createFixture();
		List<ISimulation> simulations = manager.getActiveSimulations();
		assertTrue(simulations.size() > 0);
	} // testGetActiveSimulations

	// /**
	// * {@link
	// org.eclipse.stem.jobs.simulation.SimulationManager#createSimulation(org.eclipse.core.runtime.IConfigurationElement)}.
	// */
	// public void testCreateSimulationIConfigurationElement() {
	// final SimulationManager manager = createFixture();
	// final ISimulation simulation =
	// manager.createSimulation(getConfigurationElement());
	// assertNotNull(simulation);
	// } // testCreateSimulationIConfigurationElement

	// /**
	// * @return a ConfigurationElement that specifies a Scenario
	// */
	// private Scenario getConfigurationElement() {
	//		
	// } // getConfigurationElement

	/**
	 * {@link org.eclipse.stem.jobs.simulation.SimulationManager#createSimulation(org.eclipse.stem.scenario.Scenario)}.
	 * TODO the URI isn't "mapped", need to work on this test.
	 */
	// public void testCreateSimulationURI() {
	// final SimulationManager manager = createFixture();
	// manager.createSimulation(URI
	// .createURI(TestConstants.JUNIT_TEST_SCENARIO_1_URI_STRING));
	// assertTrue(manager.getActiveSimulations().size() == 2);
	// } // testCreateSimulationURI
	/**
	 * {@link org.eclipse.stem.jobs.simulation.SimulationManager#createSimulation(org.eclipse.stem.core.scenario.Scenario)}.
	 */
	public void testCreateSimulationScenario() {
		final SimulationManager manager = createFixture();
		manager.createSimulation(ScenarioTest.createFixture(), null);
		assertTrue(manager.getActiveSimulations().size() == 2);
	} // testCreateSimulationScenario

	/**
	 * {@link org.eclipse.stem.jobs.simulation.SimulationManager#createSimulation(org.eclipse.stem.core.scenario.Scenario)}.
	 */
	public void testSimulationSequenceNumber() {
		final SimulationManager manager = createFixture();
		// The manager is created with an active simulation so the sequence
		// number of that simulation should be "0" (zero).
		assertTrue(manager.getActiveSimulations().size() == 1);
		ISimulation simulation = manager.getActiveSimulations().get(0);
		assertTrue(simulation.getSequenceNumber() == 0);

		// Let's create another simulation and check its number
		manager.createSimulation(ScenarioTest.createFixture(), null);
		assertTrue(manager.getActiveSimulations().size() == 2);
		simulation = manager.getActiveSimulations().get(1);
		assertTrue(simulation.getSequenceNumber() == 1);
	} // testSimulationSequenceNumber

	/**
	 * test creating and running a simulation from a scenario
	 * 
	 * You can't test this. What happens is the call to simulationsChanged
	 * occurs before the assignment to expectedAdded.
	 */
	// public void testCreateAndRunSimulationScenario() {
	// final SimulationManager manager = getFixture();
	// final ISimulation newSimulation = manager
	// .createAndRunSimulation(ScenarioTest.createFixture());
	// expectedAdded = new ISimulation[] { newSimulation };
	// } // testCreateAndRunSimulationScenario
	/**
	 * {@link org.eclipse.stem.jobs.simulation.SimulationManager#addSimulationManagerListener(org.eclipse.stem.jobs.simulation.ISimulationManagerListener)}.
	 */
	public void testAddSimulationManagerListener() {
		final SimulationManager manager = getFixture();
		manager.addSimulationManagerListener(this);
	} // testAddSimulationManagerListener

	/**
	 * {@link org.eclipse.stem.jobs.simulation.SimulationManager#removeListener(org.eclipse.stem.jobs.simulation.ISimulationManagerListener)}.
	 */
	public void testRemoveListener() {
		// Not sure what else to do here, other than to verify that there aren't
		// any exceptions
		testAddSimulationManagerListener();
		final SimulationManager manager = getFixture();
		manager.removeListener(this);
	} // testRemoveListener

	/**
	 * @see org.eclipse.stem.jobs.simulation.ISimulationManagerListener#simulationsChanged(org.eclipse.stem.jobs.simulation.SimulationManagerEvent)
	 */
	@SuppressWarnings("unqualified-field-access")
	public void simulationsChanged(SimulationManagerEvent event) {
		assertTrue(event.getSimulationsAdded().equals(expectedAdded));
		assertTrue(event.getSimulationsRemoved().equals(expectedRemoved));
	} // simulationsChanged

}// SimulationManagerTest
