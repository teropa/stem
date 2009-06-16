// BatchState.java
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

import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationState;

/**
 * This enumeration defines the states that a {@link Batch} can be in.
 * 
 * @see SimulationState
 */
public enum BatchState {
	/**
	 * When the {@link Batch} has been scheduled for execution and is running.
	 * This is the initial state of all newly created {@link Batch}s.
	 * <p>
	 * The next state is: {@link #PAUSED}
	 */
	RUNNING,

	/**
	 * When all of the {@link Simulation}s in a {@link Batch} are not scheduled
	 * for execution.
	 * <p>
	 * The next states are {@link #RUNNING}, {@link #STOPPED}
	 * 
	 * @see #RUNNING
	 * @see #STOPPED
	 */
	PAUSED,

	/**
	 * The simulation is being removed from the {@link SimulationManager} and its state
	 * information destroyed.
	 */
	STOPPED
} // BatchState
