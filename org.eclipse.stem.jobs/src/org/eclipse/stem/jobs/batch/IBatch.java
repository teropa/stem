// IBatch.java
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

import org.eclipse.stem.core.experiment.Experiment;
import org.eclipse.stem.jobs.execution.IExecutable;

/**
 * This interface is implemented by classes that represent {@link Batch}
 * simulations.
 * 
 * @see BatchManager
 */
public interface IBatch extends IExecutable {

	/**
	 * @return the current state of the {@link IBatch}
	 */
	BatchState getBatchState();

	/**
	 * @return <code>true</code> if the derived simulations are to be run
	 *         sequentially, <code>false</code>, otherwise.
	 */
	boolean isRunningSimulationsSequentially();

	/**
	 * @param runningSimulationsSequentially
	 *            the value of the flag controlling the choice of sequential or
	 *            parallel execution of the derived {@link Simulation}s.
	 *            <code>true</code> if the derived {@link Simulation}s are to be
	 *            run sequentially, <code>false</code>, otherwise.
	 */
	void setRunningSimulationsSequentially(
			boolean runningSimulationsSequentially);

	/**
	 * @return <code>true</code>, if the derived {@link Simulation}s will be run
	 *         in the background (i.e., no GUI), <code>false</code>, otherwise.
	 */
	boolean isRunningInBackground();

	/**
	 * @param runningInBackground
	 *            the value of the flag controlling the choice of background or
	 *            foreground execution of the derived {@link Simulation}s.
	 *            <code>true</code> if the derived {@link Simulation}s are to be
	 *            run in the background, <code>false</code>, if in the
	 *            foreground.
	 */
	void setRunningInBackground(boolean runningInBackground);

	/**
	 * Start running the {@link IBatch}.
	 */
	void run();

	/**
	 * Stop the {@link IBatch} and all of the derived {@link ISimulation}s.
	 */
	void stop();

	/**
	 * @return <code>true</code> if the execution of the {@link IBatch} has been
	 *         canceled.
	 */
	boolean cancel();

	/**
	 * Add a listener to the {@link IBatch}.
	 * 
	 * @param listener
	 *            an {@link IBatchListener} who wants to be kept informed of the
	 *            state of the {@link IBatch}.
	 */
	void addBatchListener(final IBatchListener listener);

	/**
	 * Remove a listener from the {@link IBatch}.
	 * 
	 * @param listener
	 *            the listener to remove.
	 */
	void removeBatchListener(final IBatchListener listener);

	/**
	 * Add a listener to the {@link IBatch}.
	 * 
	 * @param listener
	 *            an {@link IBatchListener} who wants to be kept informed of the
	 *            state of the {@link IBatch}.
	 */
	void addBatchListenerSync(final IBatchListenerSync listener);

	/**
	 * Remove a listener from the {@link IBatch}.
	 * 
	 * @param listener
	 *            the listener to remove.
	 */
	void removeBatchListenerSync(final IBatchListenerSync listener);

	/**
	 * @return the {@link Experiment} that is used to created the
	 *         {@link Simulation}s.
	 */
	Experiment getExperiment();

} // IBatch
