// PropertyStringProviderAdapterFactory.java
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.stem.core.common.Identifiable;

/**
 * This interface is implemented by classes that create {@link Adapter}s that
 * adapt the properties of {@link  Identifiable}s to NLS'd {@link String}s.
 */
public interface PropertyStringProviderAdapterFactory {

	/**
	 * This is the singleton instance of the factory that creates
	 * {@link PropertyStringProvider} instances.
	 * <p>
	 * This instance is a {@link ComposedAdapterFactory} which means that it
	 * collects together other {@link ComposeableAdapterFactory} adapter
	 * factories. Each class that implements
	 * {@link PropertyStringProviderAdapterFactory} needs to add itself to this
	 * instance with a call to
	 * {@link ComposedAdapterFactory#addAdapterFactory(org.eclipse.emf.common.notify.AdapterFactory)}.
	 * This will then allow adapters created by that factory to be found when
	 * adapting class instances handled by the new factory.
	 * <p>
	 * Basically, if you create an EMF model and define a
	 * {@link PropertyStringProviderAdapterFactory} for it so that the classes
	 * in that model can be adapted, you need to hook that factory into this one
	 * so that later when an attempt is made to adapt a class from that model is
	 * made the associated factory will be found. You can do that by adding the
	 * line: <code>
	 * PropertyStringProviderAdapterFactory.INSTANCE.addAdapterFactory(this);
	 * </code>
	 * to the default constructor of the new factory after the super call.
	 * You're not done however, you also have to "force" an instance of the
	 * class to be created so that the constructor is run. This is typically
	 * achieved by allocating an instance in the <code>start</code> method of
	 * the <code>Activator</code> of the plug-in that defines the factory.
	 */
	PropertyStringProviderAdapterFactoryImpl INSTANCE = new PropertyStringProviderAdapterFactoryImpl();

	/**
	 * This class is the implementation of the factory that creates
	 * {@link PropertyStringProvider}'s
	 */
	public static class PropertyStringProviderAdapterFactoryImpl extends
			ComposedAdapterFactory implements ComposeableAdapterFactory,
			IChangeNotifier, IDisposable, PropertyStringProviderAdapterFactory {

		private static DefaultPropertyStringProviderAdapter DEFAULT_PROPERTY_STRING_PROVIDER = new DefaultPropertyStringProviderAdapter();

		/**
		 * @see org.eclipse.emf.edit.provider.ComposedAdapterFactory#adapt(org.eclipse.emf.common.notify.Notifier,
		 *      java.lang.Object)
		 */
		@Override
		public Adapter adapt(final Notifier target, final Object type) {
			return returnDefaultIfNeeded(super.adapt(target, type));
		}

		/**
		 * @see org.eclipse.emf.edit.provider.ComposedAdapterFactory#adaptNew(org.eclipse.emf.common.notify.Notifier,
		 *      java.lang.Object)
		 */
		@Override
		public Adapter adaptNew(final Notifier target, final Object type) {
			return returnDefaultIfNeeded(super.adaptNew(target, type));
		}

		private Adapter returnDefaultIfNeeded(final Adapter adapter) {
			if (adapter == null) {
				// Yes
				return DEFAULT_PROPERTY_STRING_PROVIDER;
			} // if
			return adapter;
		} // returnDefaultIfNeeded

		/**
		 * @see org.eclipse.emf.common.notify.AdapterFactory#isFactoryForType(java.lang.Object)
		 */
		@Override
		public boolean isFactoryForType(final Object type) {
			return type == PropertyStringProvider.class;
		}
	} // PropertyStringProviderAdapterFactoryImpl
} // PropertyStringProviderAdapterFactory
