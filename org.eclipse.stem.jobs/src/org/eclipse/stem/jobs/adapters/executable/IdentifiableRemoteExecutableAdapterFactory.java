// IdentifiableExecutableAdapterFactory.java
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
import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.jobs.execution.remote.IRemoteExecutable;

/**
 * This class is an {@link ExecutableAdapterFactory} that adapts
 * {@link Identifiable}s to {@link IRemoteExecutable}s.
 * <p>
 * This class serves as a "bridge" between the Eclipse {@link IAdapterManager}
 * and
 * {@link org.eclipse.stem.jobs.adapters.executable.emf.RemoteExecutableAdapterFactory}
 * which is the EMF {@link Adapter} implementation that adapts
 * {@link Identifiable}s to {@link IRemoteExecutable}s.
 * 
 * @see org.eclipse.stem.jobs.adapters.executable.emf.RemoteExecutableAdapter
 * @see org.eclipse.stem.jobs.adapters.executable.emf.ScenarioRemoteExecutableAdapterFactory
 */
public class IdentifiableRemoteExecutableAdapterFactory extends
		RemoteExecutableAdapterFactory {

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	public Object getAdapter(final Object adaptableObject,
			final Class adapterType) {
		IRemoteExecutable retValue = null;
		// It it what we're looking for?
		if (adaptableObject instanceof Identifiable
				&& adapterType.equals(IRemoteExecutable.class)) {
			// Yes
			retValue = (IRemoteExecutable) org.eclipse.stem.jobs.adapters.executable.emf.RemoteExecutableAdapterFactory.INSTANCE
					.adapt(adaptableObject, IRemoteExecutable.class);
		} // if
		return retValue;
	} // getAdapter

} // IdentifiableRemoteExecutableAdapterFactory
