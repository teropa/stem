// SpatialProviderAdapterFactory.java
package org.eclipse.stem.definitions.adapters.spatial;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

/**
 * This class is extended by classes that create adapters that adapt
 * Identifiables to SpatialProviders.
 * 
 * @see org.eclipse.stem.core.common.Identifiable
 */
public abstract class SpatialProviderAdapterFactory extends AdapterFactoryImpl {

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return type == SpatialProvider.class;
	} // isFactoryForType

} // SpatialProviderAdapterFactory
