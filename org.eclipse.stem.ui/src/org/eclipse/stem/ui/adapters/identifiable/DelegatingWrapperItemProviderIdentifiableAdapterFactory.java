package org.eclipse.stem.ui.adapters.identifiable;

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
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.jobs.adapters.executable.ExecutableAdapterFactory;
import org.eclipse.stem.jobs.adapters.identifiable.IdentifiableAdapterFactory;
import org.eclipse.stem.ui.views.IdentifiableDelegate;

/**
 * This class is an {@link ExecutableAdapterFactory} that adapts
 * {@link IdentifiableDelegate}s to {@link Identifiable}s.
 */
public class DelegatingWrapperItemProviderIdentifiableAdapterFactory extends
		IdentifiableAdapterFactory {

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		Identifiable retValue = null;

		// It it what we're looking for?
		if (adaptableObject instanceof DelegatingWrapperItemProvider
				&& adapterType.equals(Identifiable.class)) {
			// Yes
			final DelegatingWrapperItemProvider dwip = (DelegatingWrapperItemProvider) adaptableObject;
			// Is this an Identifiable?
			if (dwip.getValue() instanceof Identifiable) {
				// Yes
				retValue = (Identifiable) dwip.getValue();
			} // if Identifiable
			else {
				// No
				// Keep adapting...
				retValue = (Identifiable) Platform.getAdapterManager()
						.getAdapter(dwip.getValue(), Identifiable.class);
			}
		} // if
		return retValue;
	} // getAdapter

} // DelegatingWrapperItemProviderIdentifiableAdapterFactory
