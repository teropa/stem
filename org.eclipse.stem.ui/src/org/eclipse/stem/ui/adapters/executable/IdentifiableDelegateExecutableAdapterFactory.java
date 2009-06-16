// IdentifiableDelegateExecutableAdapterFactory.java
package org.eclipse.stem.ui.adapters.executable;

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

import org.eclipse.core.runtime.Platform;
import org.eclipse.stem.jobs.adapters.executable.ExecutableAdapterFactory;
import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.ui.views.IdentifiableDelegate;

/**
 * This class is an {@link ExecutableAdapterFactory} that adapts {@link
 * IdentifiableDelegate}s to {@link IExecutable}s.
 */
public class IdentifiableDelegateExecutableAdapterFactory extends
		ExecutableAdapterFactory {

	/**
	 * @see
	 * 	org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 * 	java.lang.Class)
	 */
	public Object getAdapter(final Object adaptableObject,
			final Class adapterType) {
		IExecutable retValue = null;
		// It it what we're looking for?
		if (adaptableObject instanceof IdentifiableDelegate
				&& adapterType.equals(IExecutable.class)) {
			// Yes
			retValue = (IExecutable) Platform.getAdapterManager().getAdapter(
					((IdentifiableDelegate) adaptableObject).getIdentifiable(),
					IExecutable.class);
		} // if
		return retValue;
	} // getAdapter

} // IdentifiableDelegateExecutableAdapterFactory
