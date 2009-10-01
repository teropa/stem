package org.eclipse.stem.core.modifier.provider;

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
import org.eclipse.stem.core.modifier.util.ModifierAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class ModifierItemProviderAdapterFactory extends ModifierAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public ModifierItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.DoubleNOPModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleNOPModifierItemProvider doubleNOPModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.DoubleNOPModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDoubleNOPModifierAdapter() {
		if (doubleNOPModifierItemProvider == null) {
			doubleNOPModifierItemProvider = new DoubleNOPModifierItemProvider(this);
		}

		return doubleNOPModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.DoubleRangeModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleRangeModifierItemProvider doubleRangeModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.DoubleRangeModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDoubleRangeModifierAdapter() {
		if (doubleRangeModifierItemProvider == null) {
			doubleRangeModifierItemProvider = new DoubleRangeModifierItemProvider(this);
		}

		return doubleRangeModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.DoubleSequenceModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleSequenceModifierItemProvider doubleSequenceModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.DoubleSequenceModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDoubleSequenceModifierAdapter() {
		if (doubleSequenceModifierItemProvider == null) {
			doubleSequenceModifierItemProvider = new DoubleSequenceModifierItemProvider(this);
		}

		return doubleSequenceModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.IntegerNOPModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerNOPModifierItemProvider integerNOPModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.IntegerNOPModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerNOPModifierAdapter() {
		if (integerNOPModifierItemProvider == null) {
			integerNOPModifierItemProvider = new IntegerNOPModifierItemProvider(this);
		}

		return integerNOPModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.IntegerRangeModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerRangeModifierItemProvider integerRangeModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.IntegerRangeModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerRangeModifierAdapter() {
		if (integerRangeModifierItemProvider == null) {
			integerRangeModifierItemProvider = new IntegerRangeModifierItemProvider(this);
		}

		return integerRangeModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.IntegerSequenceModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerSequenceModifierItemProvider integerSequenceModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.IntegerSequenceModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerSequenceModifierAdapter() {
		if (integerSequenceModifierItemProvider == null) {
			integerSequenceModifierItemProvider = new IntegerSequenceModifierItemProvider(this);
		}

		return integerSequenceModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.LongNOPModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LongNOPModifierItemProvider longNOPModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.LongNOPModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLongNOPModifierAdapter() {
		if (longNOPModifierItemProvider == null) {
			longNOPModifierItemProvider = new LongNOPModifierItemProvider(this);
		}

		return longNOPModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.LongRangeModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LongRangeModifierItemProvider longRangeModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.LongRangeModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLongRangeModifierAdapter() {
		if (longRangeModifierItemProvider == null) {
			longRangeModifierItemProvider = new LongRangeModifierItemProvider(this);
		}

		return longRangeModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.LongSequenceModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LongSequenceModifierItemProvider longSequenceModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.LongSequenceModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLongSequenceModifierAdapter() {
		if (longSequenceModifierItemProvider == null) {
			longSequenceModifierItemProvider = new LongSequenceModifierItemProvider(this);
		}

		return longSequenceModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.Modifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifierItemProvider modifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.Modifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifierAdapter() {
		if (modifierItemProvider == null) {
			modifierItemProvider = new ModifierItemProvider(this);
		}

		return modifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.NOPModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NOPModifierItemProvider nopModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.NOPModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNOPModifierAdapter() {
		if (nopModifierItemProvider == null) {
			nopModifierItemProvider = new NOPModifierItemProvider(this);
		}

		return nopModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.STEMTimeNOPModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STEMTimeNOPModifierItemProvider stemTimeNOPModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.STEMTimeNOPModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSTEMTimeNOPModifierAdapter() {
		if (stemTimeNOPModifierItemProvider == null) {
			stemTimeNOPModifierItemProvider = new STEMTimeNOPModifierItemProvider(this);
		}

		return stemTimeNOPModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.STEMTimeRangeModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STEMTimeRangeModifierItemProvider stemTimeRangeModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.STEMTimeRangeModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSTEMTimeRangeModifierAdapter() {
		if (stemTimeRangeModifierItemProvider == null) {
			stemTimeRangeModifierItemProvider = new STEMTimeRangeModifierItemProvider(this);
		}

		return stemTimeRangeModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.STEMTimeSequenceModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STEMTimeSequenceModifierItemProvider stemTimeSequenceModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.STEMTimeSequenceModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSTEMTimeSequenceModifierAdapter() {
		if (stemTimeSequenceModifierItemProvider == null) {
			stemTimeSequenceModifierItemProvider = new STEMTimeSequenceModifierItemProvider(this);
		}

		return stemTimeSequenceModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.StringNOPModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringNOPModifierItemProvider stringNOPModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.StringNOPModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringNOPModifierAdapter() {
		if (stringNOPModifierItemProvider == null) {
			stringNOPModifierItemProvider = new StringNOPModifierItemProvider(this);
		}

		return stringNOPModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.StringSequenceModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringSequenceModifierItemProvider stringSequenceModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.StringSequenceModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringSequenceModifierAdapter() {
		if (stringSequenceModifierItemProvider == null) {
			stringSequenceModifierItemProvider = new StringSequenceModifierItemProvider(this);
		}

		return stringSequenceModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.DoubleModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleModifierItemProvider doubleModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.DoubleModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDoubleModifierAdapter() {
		if (doubleModifierItemProvider == null) {
			doubleModifierItemProvider = new DoubleModifierItemProvider(this);
		}

		return doubleModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.IntegerModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerModifierItemProvider integerModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.IntegerModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerModifierAdapter() {
		if (integerModifierItemProvider == null) {
			integerModifierItemProvider = new IntegerModifierItemProvider(this);
		}

		return integerModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.LongModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LongModifierItemProvider longModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.LongModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLongModifierAdapter() {
		if (longModifierItemProvider == null) {
			longModifierItemProvider = new LongModifierItemProvider(this);
		}

		return longModifierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.core.modifier.STEMTimeModifier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STEMTimeModifierItemProvider stemTimeModifierItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.core.modifier.STEMTimeModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSTEMTimeModifierAdapter() {
		if (stemTimeModifierItemProvider == null) {
			stemTimeModifierItemProvider = new STEMTimeModifierItemProvider(this);
		}

		return stemTimeModifierItemProvider;
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
		if (doubleNOPModifierItemProvider != null) doubleNOPModifierItemProvider.dispose();
		if (doubleRangeModifierItemProvider != null) doubleRangeModifierItemProvider.dispose();
		if (doubleSequenceModifierItemProvider != null) doubleSequenceModifierItemProvider.dispose();
		if (integerNOPModifierItemProvider != null) integerNOPModifierItemProvider.dispose();
		if (integerRangeModifierItemProvider != null) integerRangeModifierItemProvider.dispose();
		if (integerSequenceModifierItemProvider != null) integerSequenceModifierItemProvider.dispose();
		if (longNOPModifierItemProvider != null) longNOPModifierItemProvider.dispose();
		if (longRangeModifierItemProvider != null) longRangeModifierItemProvider.dispose();
		if (longSequenceModifierItemProvider != null) longSequenceModifierItemProvider.dispose();
		if (modifierItemProvider != null) modifierItemProvider.dispose();
		if (nopModifierItemProvider != null) nopModifierItemProvider.dispose();
		if (stemTimeNOPModifierItemProvider != null) stemTimeNOPModifierItemProvider.dispose();
		if (stemTimeRangeModifierItemProvider != null) stemTimeRangeModifierItemProvider.dispose();
		if (stemTimeSequenceModifierItemProvider != null) stemTimeSequenceModifierItemProvider.dispose();
		if (stringNOPModifierItemProvider != null) stringNOPModifierItemProvider.dispose();
		if (stringSequenceModifierItemProvider != null) stringSequenceModifierItemProvider.dispose();
		if (doubleModifierItemProvider != null) doubleModifierItemProvider.dispose();
		if (integerModifierItemProvider != null) integerModifierItemProvider.dispose();
		if (longModifierItemProvider != null) longModifierItemProvider.dispose();
		if (stemTimeModifierItemProvider != null) stemTimeModifierItemProvider.dispose();
	}

}
