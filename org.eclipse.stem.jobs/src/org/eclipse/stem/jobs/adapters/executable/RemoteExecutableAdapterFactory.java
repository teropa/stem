// ExecutableAdapterFactory.java
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

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.jobs.execution.remote.IRemoteExecutable;

/**
 * This class is an {@link IAdapterFactory} that is extended by classes that
 * adapt {@link Object}s to {@link IRemoteExecutable}s.
 */
abstract public class RemoteExecutableAdapterFactory implements IAdapterFactory {

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	public Class[] getAdapterList() {
		return new Class[] { IRemoteExecutable.class };
	}

} // RemoteExecutableAdapterFactory
