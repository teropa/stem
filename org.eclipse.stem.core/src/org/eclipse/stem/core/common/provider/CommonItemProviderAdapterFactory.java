package org.eclipse.stem.core.common.provider;

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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.stem.core.common.util.CommonAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonItemProviderAdapterFactory extends CommonAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.common.DublinCore} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DublinCoreItemProvider dublinCoreItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.common.DublinCore}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDublinCoreAdapter() {
		if (dublinCoreItemProvider == null) {
			dublinCoreItemProvider = new DublinCoreItemProvider(this);
		}

		return dublinCoreItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.common.IdentifiableFilter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifiableFilterItemProvider identifiableFilterItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.common.IdentifiableFilter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIdentifiableFilterAdapter() {
		if (identifiableFilterItemProvider == null) {
			identifiableFilterItemProvider = new IdentifiableFilterItemProvider(this);
		}

		return identifiableFilterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.common.DoubleValueList} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValueListItemProvider doubleValueListItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.common.DoubleValueList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDoubleValueListAdapter() {
		if (doubleValueListItemProvider == null) {
			doubleValueListItemProvider = new DoubleValueListItemProvider(this);
		}

		return doubleValueListItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.common.DoubleValueMatrix} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValueMatrixItemProvider doubleValueMatrixItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.common.DoubleValueMatrix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDoubleValueMatrixAdapter() {
		if (doubleValueMatrixItemProvider == null) {
			doubleValueMatrixItemProvider = new DoubleValueMatrixItemProvider(this);
		}

		return doubleValueMatrixItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.common.DoubleValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValueItemProvider doubleValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.common.DoubleValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDoubleValueAdapter() {
		if (doubleValueItemProvider == null) {
			doubleValueItemProvider = new DoubleValueItemProvider(this);
		}

		return doubleValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.common.StringValueList} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringValueListItemProvider stringValueListItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.common.StringValueList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringValueListAdapter() {
		if (stringValueListItemProvider == null) {
			stringValueListItemProvider = new StringValueListItemProvider(this);
		}

		return stringValueListItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.common.StringValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringValueItemProvider stringValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.common.StringValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringValueAdapter() {
		if (stringValueItemProvider == null) {
			stringValueItemProvider = new StringValueItemProvider(this);
		}

		return stringValueItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (dublinCoreItemProvider != null) dublinCoreItemProvider.dispose();
		if (identifiableFilterItemProvider != null) identifiableFilterItemProvider.dispose();
		if (doubleValueListItemProvider != null) doubleValueListItemProvider.dispose();
		if (doubleValueMatrixItemProvider != null) doubleValueMatrixItemProvider.dispose();
		if (doubleValueItemProvider != null) doubleValueItemProvider.dispose();
		if (stringValueListItemProvider != null) stringValueListItemProvider.dispose();
		if (stringValueItemProvider != null) stringValueItemProvider.dispose();
	}

}
