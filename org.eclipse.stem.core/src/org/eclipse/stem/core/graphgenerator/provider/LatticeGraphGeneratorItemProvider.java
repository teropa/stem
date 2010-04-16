/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.graphgenerator.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage;
import org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LatticeGraphGeneratorItemProvider
	extends GraphGeneratorItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LatticeGraphGeneratorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addXSizePropertyDescriptor(object);
			addYSizePropertyDescriptor(object);
			addUseNearestNeighborsPropertyDescriptor(object);
			addUseNextNearestNeighborsPropertyDescriptor(object);
			addPeriodicBoundariesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the XSize feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addXSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LatticeGraphGenerator_xSize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_LatticeGraphGenerator_xSize_feature", "_UI_LatticeGraphGenerator_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 GraphgeneratorPackage.Literals.LATTICE_GRAPH_GENERATOR__XSIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the YSize feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addYSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LatticeGraphGenerator_ySize_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_LatticeGraphGenerator_ySize_feature", "_UI_LatticeGraphGenerator_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 GraphgeneratorPackage.Literals.LATTICE_GRAPH_GENERATOR__YSIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Nearest Neighbors feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUseNearestNeighborsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LatticeGraphGenerator_useNearestNeighbors_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_LatticeGraphGenerator_useNearestNeighbors_feature", "_UI_LatticeGraphGenerator_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 GraphgeneratorPackage.Literals.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Next Nearest Neighbors feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUseNextNearestNeighborsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LatticeGraphGenerator_useNextNearestNeighbors_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_LatticeGraphGenerator_useNextNearestNeighbors_feature", "_UI_LatticeGraphGenerator_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 GraphgeneratorPackage.Literals.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Periodic Boundaries feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPeriodicBoundariesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LatticeGraphGenerator_periodicBoundaries_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_LatticeGraphGenerator_periodicBoundaries_feature", "_UI_LatticeGraphGenerator_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 GraphgeneratorPackage.Literals.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		URI labelValue = ((LatticeGraphGenerator)object).getURI();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_LatticeGraphGenerator_type") : //$NON-NLS-1$
			getString("_UI_LatticeGraphGenerator_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(LatticeGraphGenerator.class)) {
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__XSIZE:
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__YSIZE:
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
