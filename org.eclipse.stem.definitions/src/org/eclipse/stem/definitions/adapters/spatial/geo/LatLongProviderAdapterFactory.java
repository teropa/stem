// LatLongProviderAdapterFactory.java
package org.eclipse.stem.definitions.adapters.spatial.geo;

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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapterFactory;

/**
 * This class creates adapters that that adapt <code>Identifiable</code>'s to
 * <code>LatLongProvider</code>'s. The typical <code>LatLongProvider</code>
 * that is returned extracts the lat/long data from the <em>spatial</em>
 * attribute of an <code>Identifiable</code>'s dublin core instance.
 * 
 * @see org.eclipse.stem.core.common.Identifiable
 */
public class LatLongProviderAdapterFactory extends
		SpatialProviderAdapterFactory {

	/**
	 * This is the singleton instance of the adapter.
	 */
	private static LatLongProviderAdapter adapter = null;

	/**
	 * This is a static reference to the adapter factory to use.
	 */
	public final static LatLongProviderAdapterFactory INSTANCE = new LatLongProviderAdapterFactory();

	/**
	 * @see org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == LatLongProvider.class;
	} // isFactoryForType

	/**
	 * @see org.eclipse.stem.definitions.adapters.spatial.LatLongProviderAdapterFactory#createAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected Adapter createAdapter(final Notifier target) {
		// Have we already created an adapter?
		if (adapter == null) {
			// No
			adapter = new LatLongProviderAdapter();
		}
		return adapter;
	} // createAdapter

} // LatLongProviderAdapterFactory
