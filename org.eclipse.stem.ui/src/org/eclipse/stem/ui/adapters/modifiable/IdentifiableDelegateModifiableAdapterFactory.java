// IdentifiableDelegateModifiableAdapterFactory.java
package org.eclipse.stem.ui.adapters.modifiable;

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
import org.eclipse.stem.core.modifier.Modifiable;
import org.eclipse.stem.jobs.adapters.identifiable.IdentifiableAdapterFactory;
import org.eclipse.stem.ui.views.IdentifiableDelegate;

/**
 * This class is an {@link IdentifiableAdapterFactory} that adapts
 * {@link IdentifiableDelegate}s to {@link Identifiable}s.
 */
public class IdentifiableDelegateModifiableAdapterFactory extends
		IdentifiableAdapterFactory {

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		Identifiable retValue = null;
		// It it what we're looking for?
		if (adaptableObject instanceof IdentifiableDelegate
				&& adapterType.equals(Modifiable.class)) {
			// Yes
			final Identifiable temp = ((IdentifiableDelegate) adaptableObject).getIdentifiable();
			
			retValue = temp != null && temp instanceof Modifiable ? temp : null;
		} // if
		return retValue;
	} // getAdapter

} // IdentifiableDelegateModifiableAdapterFactory
