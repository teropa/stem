// ISimulationListener.java
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

import org.eclipse.stem.jobs.execution.IExecutableListener;

/**
 * This interface is implemented by classes that want to listen to events
 * generated by a {@link Simulation}.
 * 
 * @see ISimulation
 */
public interface ISimulationListener extends IExecutableListener {
	/**
	 * @param event
	 *            the event that records what happened to the {@link Simulation}
	 *            .
	 */
	void simulationChanged(SimulationEvent event);
} // ISimulationListener