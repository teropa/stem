// ConfigurationElementExecutableAdapterFactory.java
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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.jobs.execution.IExecutable;

/**
 * This class is an {@link ExecutableAdapterFactory} that adapts
 * {@link IConfigurationElement}s to {@link IExecutable}s.
 */
public class ConfigurationElementExecutableAdapterFactory extends
		ExecutableAdapterFactory {

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	public Object getAdapter(final Object adaptableObject,
			final Class adapterType) {
		IExecutable retValue = null;
		// A IConfigurationElement?
		if (adaptableObject instanceof IConfigurationElement
				&& adapterType.equals(IExecutable.class)) {
			// Yes
			retValue = (IExecutable) Platform.getAdapterManager().getAdapter(
					Platform.getAdapterManager().getAdapter(adaptableObject,
							Identifiable.class), IExecutable.class);
		} // if
		return retValue;
	} // getAdapter

} // ConfigurationElementExecutableAdapterFactory
