package org.eclipse.stem.diseasemodels.standard.provider;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
//import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;

import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class StandardDiseaseModelItemProvider extends DiseaseModelItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc -->
	 * 
	 * @param adapterFactory
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardDiseaseModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc -->
	 * 
	 * @param object
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);
			addReferencePopulationDensityPropertyDescriptor(object);
			addRoadNetworkInfectiousProportionPropertyDescriptor(object);
			addCharacteristicMixingDistancePropertyDescriptor(object);
			//addTotalPopulationCountPropertyDescriptor(object);
			//addTotalPopulationCountReciprocalPropertyDescriptor(object);
			//addTotalAreaPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc -->
	 * 
	 * @param object
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptorsGen(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTotalPopulationCountPropertyDescriptor(object);
			addTotalPopulationCountReciprocalPropertyDescriptor(object);
			addTotalAreaPropertyDescriptor(object);
			addReferencePopulationDensityPropertyDescriptor(object);
			addRoadNetworkInfectiousProportionPropertyDescriptor(object);
			addCharacteristicMixingDistancePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	
	/**
	 * This adds a property descriptor for the Total Population Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTotalPopulationCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StandardDiseaseModel_totalPopulationCount_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_StandardDiseaseModel_totalPopulationCount_feature", "_UI_StandardDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Total Population Count Reciprocal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTotalPopulationCountReciprocalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StandardDiseaseModel_totalPopulationCountReciprocal_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_StandardDiseaseModel_totalPopulationCountReciprocal_feature", "_UI_StandardDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Total Area feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTotalAreaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StandardDiseaseModel_totalArea_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_StandardDiseaseModel_totalArea_feature", "_UI_StandardDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.STANDARD_DISEASE_MODEL__TOTAL_AREA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reference Population Density feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencePopulationDensityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StandardDiseaseModel_referencePopulationDensity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_StandardDiseaseModel_referencePopulationDensity_feature", "_UI_StandardDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Road Network Infectious Proportion feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoadNetworkInfectiousProportionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StandardDiseaseModel_roadNetworkInfectiousProportion_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_StandardDiseaseModel_roadNetworkInfectiousProportion_feature", "_UI_StandardDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.STANDARD_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Characteristic Mixing Distance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCharacteristicMixingDistancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StandardDiseaseModel_characteristicMixingDistance_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_StandardDiseaseModel_characteristicMixingDistance_feature", "_UI_StandardDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.STANDARD_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * -->
	 * 
	 * @param object
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * 
	 * @param notification
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(StandardDiseaseModel.class)) {
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT:
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL:
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA:
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
			case StandardPackage.STANDARD_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
			case StandardPackage.STANDARD_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE:
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

}
