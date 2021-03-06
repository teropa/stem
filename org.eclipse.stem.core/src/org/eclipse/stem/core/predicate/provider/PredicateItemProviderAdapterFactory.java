package org.eclipse.stem.core.predicate.provider;

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

import org.eclipse.stem.core.predicate.util.PredicateAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PredicateItemProviderAdapterFactory extends PredicateAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public PredicateItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.And} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndItemProvider andItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.And}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAndAdapter() {
		if (andItemProvider == null) {
			andItemProvider = new AndItemProvider(this);
		}

		return andItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.False} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FalseItemProvider falseItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.False}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFalseAdapter() {
		if (falseItemProvider == null) {
			falseItemProvider = new FalseItemProvider(this);
		}

		return falseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.Not} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotItemProvider notItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.Not}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNotAdapter() {
		if (notItemProvider == null) {
			notItemProvider = new NotItemProvider(this);
		}

		return notItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.Or} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrItemProvider orItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.Or}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOrAdapter() {
		if (orItemProvider == null) {
			orItemProvider = new OrItemProvider(this);
		}

		return orItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.PredicateReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateReferenceItemProvider predicateReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.PredicateReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPredicateReferenceAdapter() {
		if (predicateReferenceItemProvider == null) {
			predicateReferenceItemProvider = new PredicateReferenceItemProvider(this);
		}

		return predicateReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.True} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrueItemProvider trueItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.True}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTrueAdapter() {
		if (trueItemProvider == null) {
			trueItemProvider = new TrueItemProvider(this);
		}

		return trueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.PredicateExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateExpressionItemProvider predicateExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.PredicateExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPredicateExpressionAdapter() {
		if (predicateExpressionItemProvider == null) {
			predicateExpressionItemProvider = new PredicateExpressionItemProvider(this);
		}

		return predicateExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.IdentifiablePredicateExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifiablePredicateExpressionItemProvider identifiablePredicateExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.IdentifiablePredicateExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIdentifiablePredicateExpressionAdapter() {
		if (identifiablePredicateExpressionItemProvider == null) {
			identifiablePredicateExpressionItemProvider = new IdentifiablePredicateExpressionItemProvider(this);
		}

		return identifiablePredicateExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.AbsoluteTimeTest} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbsoluteTimeTestItemProvider absoluteTimeTestItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.AbsoluteTimeTest}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbsoluteTimeTestAdapter() {
		if (absoluteTimeTestItemProvider == null) {
			absoluteTimeTestItemProvider = new AbsoluteTimeTestItemProvider(this);
		}

		return absoluteTimeTestItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.predicate.ElapsedTimeTest} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElapsedTimeTestItemProvider elapsedTimeTestItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.predicate.ElapsedTimeTest}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createElapsedTimeTestAdapter() {
		if (elapsedTimeTestItemProvider == null) {
			elapsedTimeTestItemProvider = new ElapsedTimeTestItemProvider(this);
		}

		return elapsedTimeTestItemProvider;
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
		if (andItemProvider != null) andItemProvider.dispose();
		if (falseItemProvider != null) falseItemProvider.dispose();
		if (notItemProvider != null) notItemProvider.dispose();
		if (orItemProvider != null) orItemProvider.dispose();
		if (predicateReferenceItemProvider != null) predicateReferenceItemProvider.dispose();
		if (trueItemProvider != null) trueItemProvider.dispose();
		if (predicateExpressionItemProvider != null) predicateExpressionItemProvider.dispose();
		if (identifiablePredicateExpressionItemProvider != null) identifiablePredicateExpressionItemProvider.dispose();
		if (absoluteTimeTestItemProvider != null) absoluteTimeTestItemProvider.dispose();
		if (elapsedTimeTestItemProvider != null) elapsedTimeTestItemProvider.dispose();
	}

}
