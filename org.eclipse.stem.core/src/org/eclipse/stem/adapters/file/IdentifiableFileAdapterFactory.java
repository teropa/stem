/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.adapters.file;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.stem.core.common.Identifiable;

public class IdentifiableFileAdapterFactory extends FileAdapterFactory  {

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(final Object adaptableObject,
			final Class adapterType) {
		File retValue = null;
		// An identifiable
		if (adaptableObject instanceof Identifiable
				&& adapterType.equals(File.class)) {
			// Yes
			
			IdentifiableFileAdapter ifa = new IdentifiableFileAdapter();
			ifa.setTarget((Notifier)adaptableObject);
			retValue = ifa;
		} // if
		return retValue;
	} // getAdapter
}
