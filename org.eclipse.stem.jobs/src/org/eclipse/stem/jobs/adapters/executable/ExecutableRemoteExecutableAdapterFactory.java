// ExecutableRemoteExecutableAdapterFactory.java
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

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapter;
import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.jobs.execution.remote.IRemoteExecutable;
import org.eclipse.stem.jobs.simulation.remote.RemoteSimulationManager;

/**
 * This class is an {@link ExecutableAdapterFactory} that adapts
 * {@link Identifiable}s to {@link IExecutable}s.
 * <p>
 * This class serves as a "bridge" between the Eclipse {@link IAdapterManager}
 * and
 * {@link org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapterFactory}
 * which is the EMF {@link Adapter} implementation that adapts
 * {@link Identifiable}s to {@link IExecutable}s.
 * 
 * @see org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapter
 * @see org.eclipse.stem.jobs.adapters.executable.emf.ScenarioExecutableAdapterFactory
 * @see org.eclipse.stem.jobs.adapters.executable.emf.ExperimentExecutableAdapterFactory
 */
public class ExecutableRemoteExecutableAdapterFactory extends
		ExecutableAdapterFactory {

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	public Object getAdapter(final Object adaptableObject,
			final Class adapterType) {
		IRemoteExecutable retValue = null;
		// It it what we're looking for?
		if (adaptableObject instanceof IExecutable
				&& adapterType.equals(IRemoteExecutable.class)) {
			// Yes
			retValue = new RemoteExecutableAdapter((IExecutable)adaptableObject);
		} // if
		return retValue;
	} // getAdapter
	
	protected static class RemoteExecutableAdapter extends ExecutableAdapter implements IRemoteExecutable {

		private IExecutable executable;
		
		public RemoteExecutableAdapter(IExecutable executable) {
			this.executable = executable;
		}

		@Override
		public void run() {
			RemoteSimulationManager.getManager().run(executable);
		}
	}

} // IdentifiableExecutableAdapterFactory
