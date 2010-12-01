// RelativeValueProviderAdapterFactory.java
package org.eclipse.stem.definitions.adapters.population;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;

/**
 * 
 */
public interface PopulationEnumeratorAdapterFactory extends
		ComposeableAdapterFactory, IChangeNotifier, IDisposable {


	PopulationEnumeratorAdapterFactoryImpl INSTANCE = new PopulationEnumeratorAdapterFactoryImpl();

	/**
	 * This class is the implementation of the factory that creates
	 * {@link RelativeValueProvider}'s
	 */
	public static class PopulationEnumeratorAdapterFactoryImpl extends
			ComposedAdapterFactory implements
			PopulationEnumeratorAdapterFactory {

		/**
		 * @see org.eclipse.emf.edit.provider.ComposedAdapterFactory#isFactoryForType(java.lang.Object)
		 */
		@Override
		public boolean isFactoryForType(Object type) {
			return type == PopulationEnumerator.class;
		} // isFactoryForType
	} // PopulationEnumeratorAdapterFactoryImpl

} // PopulationEnumeratorAdapterFactory
