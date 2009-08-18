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

import java.text.NumberFormat;
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
import org.eclipse.stem.core.graph.provider.LabelValueItemProvider;
import org.eclipse.stem.definitions.edges.provider.DefinitionsEditPlugin;
import org.eclipse.stem.definitions.labels.AreaLabelValue;
import org.eclipse.stem.definitions.labels.LabelsPackage;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.stem.definitions.labels.AreaLabelValue} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AreaLabelValueItemProvider extends LabelValueItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	private static final int NUMBER_OF_FACTIONAL_DIGITS = 2;
	private static NumberFormat formatter;

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * 
	 * @param adapterFactory
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaLabelValueItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	/*
	 * @return a number formatter
	 */
	static NumberFormat getFormatter() {
		// Is there already a formatter?
		if (formatter == null) {
			// No
			formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(NUMBER_OF_FACTIONAL_DIGITS);
			formatter.setMinimumFractionDigits(NUMBER_OF_FACTIONAL_DIGITS);
		}
		return formatter;
	} // getFormatter

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
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

			addAreaPropertyDescriptor(object);
			addAverageExtentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Area feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAreaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AreaLabelValue_area_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AreaLabelValue_area_feature", "_UI_AreaLabelValue_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.AREA_LABEL_VALUE__AREA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Average Extent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAverageExtentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AreaLabelValue_averageExtent_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AreaLabelValue_averageExtent_feature", "_UI_AreaLabelValue_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 LabelsPackage.Literals.AREA_LABEL_VALUE__AVERAGE_EXTENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * 
	 * @param object
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		final StringBuilder sb = new StringBuilder(getFormatter().format(((AreaLabelValue)object).getArea()));
		sb.append(" km^2");
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
//	@Override
	public String getTextGen(Object object) {
		AreaLabelValue areaLabelValue = (AreaLabelValue)object;
		return getString("_UI_AreaLabelValue_type") + " " + areaLabelValue.getArea(); //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(AreaLabelValue.class)) {
			case LabelsPackage.AREA_LABEL_VALUE__AREA:
			case LabelsPackage.AREA_LABEL_VALUE__AVERAGE_EXTENT:
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
		return DefinitionsEditPlugin.INSTANCE;
	}

}
