// SimulationExecutableAdapterFactory.java
package org.eclipse.stem.jobs.adapters.executable;

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

import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.jobs.simulation.ISimulation;

/**
 * This class is an {@link ExecutableAdapterFactory} that adapts
 * {@link ISimulation}s to {@link IExecutable}s.
 */
public class SimulationExecutableAdapterFactory extends
		ExecutableAdapterFactory {

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	public Object getAdapter(final Object adaptableObject,
			final Class adapterType) {
		ISimulation retValue = null;
		// A Simulation?
		if (adaptableObject instanceof ISimulation
				&& adapterType.equals(IExecutable.class)) {
			// Yes
			retValue = (ISimulation) adaptableObject;
		} // if
		return retValue;
	} // getAdapter

} // SimulationExecutableAdapterFactory
