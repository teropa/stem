// ISimulation.java
package org.eclipse.stem.jobs.simulation;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.jobs.execution.IExecutable;

/**
 * This interface is implemented by classes that represent {@link Simulation}s
 * of {@link Scenario}s.
 */
public interface ISimulation extends IExecutable {

	/**
	 * @param sequenceNumber
	 *            The sequence number of the {@link Simulation}
	 */
	void setSequenceNumber(int sequenceNumber);

	/**
	 * @return the state of the {@link Simulation}
	 */
	SimulationState getSimulationState();

	/**
	 * Start running the {@link Simulation}.
	 */
	void run();

	/**
	 * Pause the {@link Simulation}
	 */
	void pause();

	/**
	 * Reset the {@link Simulation}.
	 */
	void reset();

	/**
	 * Step the {@link Simulation} one step/cycle if it hasn't already ended
	 */
	void step();

	/**
	 * Stop the {@link Simulation}
	 */
	void stop();

	/**
	 * Wait for execution to complete.
	 * 
	 * @throws InterruptedException
	 *             if the job is interrupted
	 */
	void join() throws InterruptedException;

	/**
	 * @return <code>true</code> if execution has been canceled.
	 */
	boolean cancel();

	/**
	 * @return the {@link Scenario} being simulated
	 */
	Scenario getScenario();

	/**
	 * Add a {@link ISimulationListener} to those that will be notified of
	 * changes.
	 * 
	 * @param simulationListener
	 */
	void addSimulationListener(ISimulationListener simulationListener);

	/**
	 * Remove {@link ISimulationListener} to those that will be notified of
	 * changes.
	 * 
	 * @param simulationListener
	 */
	void removeSimulationListener(ISimulationListener simulationListener);

	/**
	 * Add a {@link ISimulationListener} to those that will be notified of
	 * changes.
	 * 
	 * @param simulationListener
	 */
	void addSimulationListenerSync(ISimulationListenerSync simulationListener);

	/**
	 * Remove {@link ISimulationListener} to those that will be notified of
	 * changes.
	 * 
	 * @param simulationListener
	 */
	void removeSimulationListenerSync(ISimulationListenerSync simulationListener);

} // ISimulation
