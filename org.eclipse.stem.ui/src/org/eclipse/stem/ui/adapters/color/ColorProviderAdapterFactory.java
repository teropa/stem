// ColorProviderAdapterFactory.java
package org.eclipse.stem.ui.adapters.color;

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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 * This is the interface of the adapter factory that will be used for providing
 * colors. The {@link ColorProviderAdapterFactory} is implemented by the
 * {@link ColorProviderAdapterFactoryImpl} class and is the parent adapter
 * factory ({@link ComposedAdapterFactory}) for all the other adapter
 * factories.
 * 
 * Factories will be added to this composed object by using the Eclipse
 * extension points mechanism for extending plug-ins.
 */
public interface ColorProviderAdapterFactory {
	/**
	 * This is the singleton instance of the factory
	 */
	public ColorProviderAdapterFactoryImpl INSTANCE = new ColorProviderAdapterFactoryImpl();
	
	/**
	 * This class is the implementation of the
	 * {@link ColorProviderAdapterFactory} interface.
	 * 
	 * @see ColorProviderAdapterFactory
	 */
	public class ColorProviderAdapterFactoryImpl 
		extends ComposedAdapterFactory
		implements ColorProviderAdapterFactory {
		
		/**
		 * List of supported color providers
		 */
		protected final List<Class> supportedColorProviders = new ArrayList<Class>();
		/**
		 * List of supported color providers names
		 */
		protected final List<String> supportedColorProvidersNames = new ArrayList<String>();
		
		/**
		 * Constructor
		 */
		protected ColorProviderAdapterFactoryImpl() {
			//Nothing
		}

		/**
		 * Add a {@link ComposeableAdapterFactory} to this composed factory.
		 * @param adapterFactory The adapter factory to be added
		 * @param colorProvider The {@link ColorProvider} class 
		 * @param displayName A display name for the adapter (to be added to the UI)
		 */
		public void addAdapterFactory(AdapterFactory adapterFactory, Class colorProvider, String displayName) {
			supportedColorProviders.add(colorProvider);
			supportedColorProvidersNames.add(displayName);
			super.addAdapterFactory(adapterFactory);
		}

		/**
		 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#isFactoryForType(java.lang.Object)
		 */
		@Override
		public boolean isFactoryForType(final Object type) {
			return type == ColorProvider.class;
		} // isFactoryForType

		/**
		 * @return the supportedColorProviders
		 */
		public List<Class> getSupportedColorProviders() {
			return supportedColorProviders;
		}

		/**
		 * @return the supportedColorProvidersNames
		 */
		public List<String> getSupportedColorProvidersNames() {
			return supportedColorProvidersNames;
		}
	} // ColorProviderAdapterFactoryImpl
} // ColorProviderAdapterFactory
