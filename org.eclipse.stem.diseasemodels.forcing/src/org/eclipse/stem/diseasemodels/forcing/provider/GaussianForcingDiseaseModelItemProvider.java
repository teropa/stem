package org.eclipse.stem.diseasemodels.forcing.provider;
/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.stem.diseasemodels.forcing.ForcingPackage;
import org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel;

import org.eclipse.stem.diseasemodels.standard.provider.StochasticSIRDiseaseModelItemProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GaussianForcingDiseaseModelItemProvider
	extends StochasticSIRDiseaseModelItemProvider
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
	public GaussianForcingDiseaseModelItemProvider(AdapterFactory adapterFactory) {
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

			addSigma2PropertyDescriptor(object);
			addModulationPeriodPropertyDescriptor(object);
			addModulationPhaseShiftPropertyDescriptor(object);
			addModulationFloorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Sigma2 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSigma2PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GaussianForcingDiseaseModel_sigma2_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GaussianForcingDiseaseModel_sigma2_feature", "_UI_GaussianForcingDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ForcingPackage.Literals.GAUSSIAN_FORCING_DISEASE_MODEL__SIGMA2,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modulation Period feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModulationPeriodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GaussianForcingDiseaseModel_modulationPeriod_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GaussianForcingDiseaseModel_modulationPeriod_feature", "_UI_GaussianForcingDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ForcingPackage.Literals.GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PERIOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modulation Phase Shift feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModulationPhaseShiftPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GaussianForcingDiseaseModel_modulationPhaseShift_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GaussianForcingDiseaseModel_modulationPhaseShift_feature", "_UI_GaussianForcingDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ForcingPackage.Literals.GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modulation Floor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModulationFloorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GaussianForcingDiseaseModel_modulationFloor_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GaussianForcingDiseaseModel_modulationFloor_feature", "_UI_GaussianForcingDiseaseModel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ForcingPackage.Literals.GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_FLOOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns GaussianForcingDiseaseModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GaussianForcingDiseaseModel")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextGen(Object object) {
		String label = ((GaussianForcingDiseaseModel)object).getDiseaseName();
		return label == null || label.length() == 0 ?
			getString("_UI_GaussianForcingDiseaseModel_type") : //$NON-NLS-1$
			getString("_UI_GaussianForcingDiseaseModel_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(GaussianForcingDiseaseModel.class)) {
			case ForcingPackage.GAUSSIAN_FORCING_DISEASE_MODEL__SIGMA2:
			case ForcingPackage.GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PERIOD:
			case ForcingPackage.GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT:
			case ForcingPackage.GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_FLOOR:
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

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ForcingEditPlugin.INSTANCE;
	}

}
