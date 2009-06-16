// PropertyStringProviderAdapter.java
package org.eclipse.stem.ui.adapters.propertystrings;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * This class is extended by classes that provide NLS'd string for disease model
 * properties.
 */
public abstract class PropertyStringProviderAdapter extends AdapterImpl
		implements PropertyStringProvider {

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(final Object type) {
		return type == PropertyStringProvider.class;
	}

} // PropertyStringProviderAdapter
