// HistoryProviderAdapterFactory.java
package org.eclipse.stem.adapters.history;

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

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;

/**
 * This interface is implemented by classes that create adapters that adapt
 * {@link  org.eclipse.emf.ecore.EObject}s to {@link HistoryProvider}s.
 */

public interface HistoryProviderAdapterFactory extends
		ComposeableAdapterFactory, IChangeNotifier, IDisposable {

	/**
	 * This is the singleton instance of the factory that creates
	 * {@link HistoryProvider} instances.
	 * <p>
	 * This instance is a {@link ComposedAdapterFactory} which means that it
	 * collects together other {@link ComposeableAdapterFactory} adapter
	 * factories. Each class that implements
	 * {@link RelativeValueProviderAdapterFactory} needs to add itself to this
	 * instance with a call to
	 * {@link ComposedAdapterFactory#addAdapterFactory(org.eclipse.emf.common.notify.AdapterFactory)}.
	 * This will then allow adapters created by that factory to be found when
	 * adapting class instances handled by the new factory.
	 * <p>
	 * Basically, if you create an EMF model and define a
	 * {@link HistoryProviderAdapterFactory} for it so that the classes in that
	 * model can be adapted, you need to hook that factory into this one so that
	 * later when an attempt is made to adapt a class from that model is made
	 * the associated factory will be found. You can do that by adding the line:
	 * <code>
	 * HistoryProviderAdapterFactory.INSTANCE.addAdapterFactory(this);
	 * </code>
	 * to the default constructor of the new factory after the super call.
	 * You're not done however, you also have to "force" an instance of the
	 * class to be created so that the constructor is run. This is typically
	 * achieved by allocating an instance in the <code>start</code> method of
	 * the <code>Activator</code> of the plug-in that defines the factory.
	 */
	HistoryProviderAdapterFactoryImpl INSTANCE = new HistoryProviderAdapterFactoryImpl();

	/**
	 * This class is extended by classes that provide historic values of
	 * {@link Identifiables}.
	 */
	public class HistoryProviderAdapterFactoryImpl extends
			ComposedAdapterFactory implements HistoryProviderAdapterFactory {
		/**
		 * @see org.eclipse.emf.edit.provider.ComposedAdapterFactory#isFactoryForType(java.lang.Object)
		 */
		@Override
		public boolean isFactoryForType(Object type) {
			return type == HistoryProvider.class;
		} // isFactoryForType
	} // RelativeValueHistoryProviderAdapterFactoryImpl

} // HistoryProviderAdapterFactory
