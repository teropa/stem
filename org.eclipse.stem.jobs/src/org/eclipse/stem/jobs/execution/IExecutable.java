// IExecutable.java
package org.eclipse.stem.jobs.execution;

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

import java.util.Date;

/**
 * This interface is implemented by classes that can are executable.
 */
public interface IExecutable {

	/**
	 * The units of work (100) that represents complete execution.
	 */
	int TOTAL_WORK = 100;

	/**
	 * @return the unique sequence number of the {@link IExecutable}.
	 * @see #getNameWithSequenceNumber()
	 */
	int getSequenceNumber();

	/**
	 * @return the name of the {@link IExecutable}.
	 */
	String getName();

	/**
	 * @return a {@link String} that contains the sequence number of the
	 *         {@link IExecutable} and it's name.
	 * @see #getName()
	 */
	String getNameWithSequenceNumber();

	/**
	 * @return a {@link String} without spaces that is unique to this
	 *         {@link Executable} instance.
	 */
	String getUniqueIDString();

	/**
	 * @return the time (wall clock) that the {@link Executable} was created.
	 */
	Date getCreationTime();

	/**
	 * Start running the {@link IExecutable}.
	 */
	void run();

	/**
	 * Pause the {@link IExecutable}.
	 */
	void pause();

	/**
	 * Reset the {@link IExecutable}.
	 */
	void reset();

	/**
	 * Step the {@link IExecutable} one step/cycle if it hasn't already ended.
	 */
	void step();

	/**
	 * Stop the {@link IExecutable}.
	 */
	void stop();

	/**
	 * @return <code>true</code> if the {@link IExecutable} is running.
	 */
	boolean isRunning();

	/**
	 * @return <code>true</code> if the {@link IExecutable} can be stopped.
	 *         This is only <code>true</code> for {@link IExecutable}s for
	 *         which {@link #isRunning()} can be <code>true</code>.
	 */
	boolean isStoppable();
} // IExecutable
