package org.eclipse.stem.diseasemodels.standard.provider;

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
//import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.stem.core.model.provider.NodeDecoratorItemProvider;
import org.eclipse.stem.diseasemodels.standard.Infector;

import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.stem.diseasemodels.standard.Infector} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class InfectorItemProvider extends NodeDecoratorItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
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
	public InfectorItemProvider(AdapterFactory adapterFactory) {
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
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDiseaseModelPropertyDescriptor(object);
			addTargetURIPropertyDescriptor(object);
			addDiseaseNamePropertyDescriptor(object);
			addTargetISOKeyPropertyDescriptor(object);
			addLabelsToInfectPropertyDescriptor(object);
			addPopulationIdentifierPropertyDescriptor(object);
			addInfectPercentagePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Disease Model feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDiseaseModelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Infector_diseaseModel_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Infector_diseaseModel_feature", "_UI_Infector_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.INFECTOR__DISEASE_MODEL,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target URI feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTargetURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Infector_targetURI_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Infector_targetURI_feature", "_UI_Infector_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.INFECTOR__TARGET_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Disease Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiseaseNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Infector_diseaseName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Infector_diseaseName_feature", "_UI_Infector_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.INFECTOR__DISEASE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target ISO Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetISOKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Infector_targetISOKey_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Infector_targetISOKey_feature", "_UI_Infector_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.INFECTOR__TARGET_ISO_KEY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Labels To Infect feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelsToInfectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Infector_labelsToInfect_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Infector_labelsToInfect_feature", "_UI_Infector_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.INFECTOR__LABELS_TO_INFECT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Population Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPopulationIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Infector_populationIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Infector_populationIdentifier_feature", "_UI_Infector_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.INFECTOR__POPULATION_IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Infect Percentage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInfectPercentagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Infector_infectPercentage_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Infector_infectPercentage_feature", "_UI_Infector_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.INFECTOR__INFECT_PERCENTAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns infector.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/custom16/infector"));
	}
	
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
	public String getText(Object object) {
		String label = ((Infector)object).getDiseaseName();
		return label == null || label.length() == 0 ?
			getString("_UI_Infector_type") : //$NON-NLS-1$
			getString("_UI_Infector_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(Infector.class)) {
			case StandardPackage.INFECTOR__TARGET_URI:
			case StandardPackage.INFECTOR__DISEASE_NAME:
			case StandardPackage.INFECTOR__TARGET_ISO_KEY:
			case StandardPackage.INFECTOR__POPULATION_IDENTIFIER:
			case StandardPackage.INFECTOR__INFECT_PERCENTAGE:
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
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DiseasemodelsEditPlugin.INSTANCE;
	}

}
