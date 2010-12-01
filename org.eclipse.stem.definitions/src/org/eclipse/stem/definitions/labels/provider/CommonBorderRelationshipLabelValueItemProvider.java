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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabelValue;
import org.eclipse.stem.definitions.labels.LabelsPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabelValue} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class CommonBorderRelationshipLabelValueItemProvider extends
		PhysicalRelationshipLabelValueItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommonBorderRelationshipLabelValueItemProvider(
			AdapterFactory adapterFactory) {
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

			addBorderLengthPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Border Length feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBorderLengthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CommonBorderRelationshipLabelValue_borderLength_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CommonBorderRelationshipLabelValue_borderLength_feature", "_UI_CommonBorderRelationshipLabelValue_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE__BORDER_LENGTH,
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
	 * --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		CommonBorderRelationshipLabelValue commonBorderRelationshipLabelValue = (CommonBorderRelationshipLabelValue)object;
		return commonBorderRelationshipLabelValue.getBorderLength() + " km"; //$NON-NLS-1$ 
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	//@Override
	public String getTextGen(Object object) {
		CommonBorderRelationshipLabelValue commonBorderRelationshipLabelValue = (CommonBorderRelationshipLabelValue)object;
		return getString("_UI_CommonBorderRelationshipLabelValue_type") + " " + commonBorderRelationshipLabelValue.getBorderLength(); //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(CommonBorderRelationshipLabelValue.class)) {
			case LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE__BORDER_LENGTH:
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
