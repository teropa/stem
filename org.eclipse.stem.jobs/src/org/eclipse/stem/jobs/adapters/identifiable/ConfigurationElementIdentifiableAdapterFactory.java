// ConfigurationElementIdentifiableAdapterFactory.java
package org.eclipse.stem.jobs.adapters.identifiable;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;

/**
 * This class is an {@link IAdapterFactory} that adapts
 * {@link IConfigurationElement}s to {@link Identifiable}s.
 */
public class ConfigurationElementIdentifiableAdapterFactory extends
		IdentifiableAdapterFactory {

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	public Object getAdapter(final Object adaptableObject,
			final Class adapterType) {
		Identifiable retValue = null;
		if (adaptableObject instanceof IConfigurationElement
				&& adapterType.equals(Identifiable.class)) {
			// Yes
			retValue = (Identifiable) Platform.getAdapterManager().getAdapter(
					URI.createURI(((IConfigurationElement) adaptableObject)
							.getAttribute(DublinCore.IDENTIFIER)),
					Identifiable.class);
		} // if

		return retValue;
	} // getAdapter
} // ConfigurationElementIdentifiableAdapterFactory
