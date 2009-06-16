// GraphTimeProviderAdapterFactory.java
package org.eclipse.stem.core.graph.provider;

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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.stem.adapters.time.TimeProvider;
import org.eclipse.stem.adapters.time.TimeProviderAdapter;
import org.eclipse.stem.adapters.time.TimeProviderAdapterFactory;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.util.GraphAdapterFactory;
import org.eclipse.stem.core.model.STEMTime;

/**
 * This class is an {@link TimeProviderAdapterFactory}.
 */
public class GraphTimeProviderAdapterFactory extends GraphAdapterFactory
		implements TimeProviderAdapterFactory {

	/**
	 * This keeps track of the root adapter factory that delegates to this
	 * adapter factory.
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link
	 * org.eclipse.emf.edit.provider.IChangeNotifier}.
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * Default Constructor
	 */
	public GraphTimeProviderAdapterFactory() {
		super();
		TimeProviderAdapterFactory.INSTANCE.addAdapterFactory(this);
	}

	/**
	 * @see org.eclipse.stem.core.graph.util.GraphAdapterFactory#
	 * 	createGraphAdapter()
	 */
	@Override
	public Adapter createGraphAdapter() {
		return new GraphTimeProvider();
	}

	/**
	 * @see
	 * 	org.eclipse.emf.edit.provider.IChangeNotifier#addListener(org.eclipse
	 * 	.emf.edit.provider.INotifyChangedListener)
	 */
	public void addListener(final INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * @see
	 * 	org.eclipse.emf.edit.provider.IChangeNotifier#removeListener(org.eclipse
	 * 	.emf.edit.provider.INotifyChangedListener)
	 */
	public void removeListener(
			final INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#fireNotifyChanged(org.
	 * 	eclipse.emf.common.notify.Notification)
	 */
	public void fireNotifyChanged(final Notification notification) {
		changeNotifier.fireNotifyChanged(notification);
		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ComposeableAdapterFactory#
	 * 	getRootAdapterFactory()
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory
				.getRootAdapterFactory();
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ComposeableAdapterFactory#
	 * 	setParentAdapterFactory
	 * 	(org.eclipse.emf.edit.provider.ComposedAdapterFactory)
	 */
	public void setParentAdapterFactory(
			final ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * @see
	 * 	org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory
	 * 	#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == TimeProvider.class || super.isFactoryForType(type);
	} // isFactoryForType

	/**
	 * @see org.eclipse.emf.edit.provider.IDisposable#dispose()
	 */
	public void dispose() {
		// Nothing
	}

	/**
	 * This class is a {@link TimeProvider} for {@link Graph} instances. It
	 * provides a time value for the graph. The value is the time that the
	 * {@link LabelValue}s of {@link DynamicLabel} were last updated.
	 */
	private static class GraphTimeProvider extends TimeProviderAdapter
			implements TimeProvider {
		/**
		 * @see org.eclipse.stem.adapters.time.TimeProviderAdapter#getTime()
		 */
		@Override
		public STEMTime getTime() {
			Graph graph = (Graph)getTarget();
			return graph.getTime();
		}

	} // GraphTimeProvider

} // GraphTimeProviderAdapterFactory