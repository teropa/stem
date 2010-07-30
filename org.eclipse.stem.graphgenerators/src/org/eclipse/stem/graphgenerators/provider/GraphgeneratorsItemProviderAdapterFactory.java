/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators.provider;

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

import org.eclipse.stem.graphgenerators.util.GraphgeneratorsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphgeneratorsItemProviderAdapterFactory extends GraphgeneratorsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public GraphgeneratorsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SquareLatticeGraphGeneratorItemProvider squareLatticeGraphGeneratorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSquareLatticeGraphGeneratorAdapter() {
		if (squareLatticeGraphGeneratorItemProvider == null) {
			squareLatticeGraphGeneratorItemProvider = new SquareLatticeGraphGeneratorItemProvider(this);
		}

		return squareLatticeGraphGeneratorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MigrationEdgeGraphGeneratorItemProvider migrationEdgeGraphGeneratorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMigrationEdgeGraphGeneratorAdapter() {
		if (migrationEdgeGraphGeneratorItemProvider == null) {
			migrationEdgeGraphGeneratorItemProvider = new MigrationEdgeGraphGeneratorItemProvider(this);
		}

		return migrationEdgeGraphGeneratorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlateCarreeGlobeGraphGeneratorItemProvider plateCarreeGlobeGraphGeneratorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlateCarreeGlobeGraphGeneratorAdapter() {
		if (plateCarreeGlobeGraphGeneratorItemProvider == null) {
			plateCarreeGlobeGraphGeneratorItemProvider = new PlateCarreeGlobeGraphGeneratorItemProvider(this);
		}

		return plateCarreeGlobeGraphGeneratorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PajekNetGraphGeneratorItemProvider pajekNetGraphGeneratorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPajekNetGraphGeneratorAdapter() {
		if (pajekNetGraphGeneratorItemProvider == null) {
			pajekNetGraphGeneratorItemProvider = new PajekNetGraphGeneratorItemProvider(this);
		}

		return pajekNetGraphGeneratorItemProvider;
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
		if (squareLatticeGraphGeneratorItemProvider != null) squareLatticeGraphGeneratorItemProvider.dispose();
		if (migrationEdgeGraphGeneratorItemProvider != null) migrationEdgeGraphGeneratorItemProvider.dispose();
		if (plateCarreeGlobeGraphGeneratorItemProvider != null) plateCarreeGlobeGraphGeneratorItemProvider.dispose();
		if (pajekNetGraphGeneratorItemProvider != null) pajekNetGraphGeneratorItemProvider.dispose();
	}

}
