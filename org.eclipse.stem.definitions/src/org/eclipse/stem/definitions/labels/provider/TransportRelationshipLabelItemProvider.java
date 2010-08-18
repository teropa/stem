package org.eclipse.stem.definitions.labels.provider;

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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.provider.DynamicEdgeLabelItemProvider;

//import org.eclipse.stem.core.graph.provider.LabelItemProvider;
import org.eclipse.stem.definitions.labels.LabelsFactory;
//import org.eclipse.stem.definitions.edges.provider.DefinitionsEditPlugin;
import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabel;
import org.eclipse.stem.definitions.labels.LabelsPackage;
//import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabel;
import org.eclipse.stem.data.geography.GeographicNames;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.definitions.labels.TransportRelationshipLabel} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class TransportRelationshipLabelItemProvider extends DynamicEdgeLabelItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TransportRelationshipLabelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTransportModePropertyDescriptor(object);
			addPopulationIdentifierPropertyDescriptor(object);
			addTransportIdentifierPropertyDescriptor(object);
			addCurrentTransportRelationshipLabelValuePropertyDescriptor(object);
			addRateTimePeriodPropertyDescriptor(object);
			addDepartureCapacityPropertyDescriptor(object);
			addMaximumDepartureCapacityPropertyDescriptor(object);
			addCapacityPropertyDescriptor(object);
			addMaximumCapacityPropertyDescriptor(object);
			addTransitTimePropertyDescriptor(object);
			addStartUpDelayPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Transport Mode feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTransportModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_transportMode_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_transportMode_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Population Identifier feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPopulationIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_populationIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_populationIdentifier_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__POPULATION_IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transport Identifier feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransportIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_transportIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_transportIdentifier_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Current Transport Relationship Label Value feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCurrentTransportRelationshipLabelValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_currentTransportRelationshipLabelValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_currentTransportRelationshipLabelValue_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__CURRENT_TRANSPORT_RELATIONSHIP_LABEL_VALUE,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rate Time Period feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRateTimePeriodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_rateTimePeriod_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_rateTimePeriod_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__RATE_TIME_PERIOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Departure Capacity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDepartureCapacityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_departureCapacity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_departureCapacity_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__DEPARTURE_CAPACITY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Departure Capacity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumDepartureCapacityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_maximumDepartureCapacity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_maximumDepartureCapacity_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_DEPARTURE_CAPACITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Capacity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCapacityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_capacity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_capacity_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__CAPACITY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Capacity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumCapacityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_maximumCapacity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_maximumCapacity_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_CAPACITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transit Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransitTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_transitTime_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_transitTime_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__TRANSIT_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Start Up Delay feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartUpDelayPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TransportRelationshipLabel_startUpDelay_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TransportRelationshipLabel_startUpDelay_feature", "_UI_TransportRelationshipLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL__START_UP_DELAY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		final URI labelURI = ((TransportRelationshipLabel)object).getURI();
		final String lastSegment = labelURI.lastSegment().toString();
		final int i = lastSegment.indexOf("_");
		final String firstISOKey = lastSegment.substring(0, i);
		final String secondISOKey = lastSegment.substring(i+1);
		
		final String firstGeoName = GeographicNames.getName(firstISOKey);
		final String secondGeoName = GeographicNames.getName(secondISOKey);
		
		final StringBuilder sb = new StringBuilder(
				firstGeoName.startsWith("!") ? firstISOKey : firstGeoName);
		final Edge edge = ((EdgeLabel) object).getEdge();
		sb.append(edge.isDirected() ? " -> " : " <-> ");
		// Find Bugs identified an error.  secondGeoName was used 
		// for both conditions of the ternary
		sb.append(secondGeoName.startsWith("!") ? secondISOKey
						: secondGeoName);

		return sb.toString();
	} // getText


	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * 
	 * @param object
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextGen(Object object) {
		URI labelValue = ((TransportRelationshipLabel)object).getURI();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_TransportRelationshipLabel_type") : //$NON-NLS-1$
			getString("_UI_TransportRelationshipLabel_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TransportRelationshipLabel.class)) {
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_MODE:
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__POPULATION_IDENTIFIER:
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_IDENTIFIER:
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__RATE_TIME_PERIOD:
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__DEPARTURE_CAPACITY:
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_DEPARTURE_CAPACITY:
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__CAPACITY:
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_CAPACITY:
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSIT_TIME:
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__START_UP_DELAY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DefinitionsEditPlugin.INSTANCE;
	}

}
