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
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.STEMTimeRangeModifier;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.core.modifier.STEMTimeRangeModifier} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class STEMTimeRangeModifierItemProvider
	extends RangeModifierItemProvider
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
	public STEMTimeRangeModifierItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

//	/**
//	 * This returns the property descriptors for the adapted class.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
//		if (itemPropertyDescriptors == null) {
//			super.getPropertyDescriptors(object);
//
//			addStartValuePropertyDescriptor(object);
//			addEndValuePropertyDescriptor(object);
//			addIncrementPropertyDescriptor(object);
//			addNextValuePropertyDescriptor(object);
//		}
//		return itemPropertyDescriptors;
//	}
	
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

			addStartValuePropertyDescriptor(object);
			addEndValuePropertyDescriptor(object);
			addIncrementPropertyDescriptor(object);
			addNextValuePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	

	/**
	 * This adds a property descriptor for the Start Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_STEMTimeRangeModifier_startValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_STEMTimeRangeModifier_startValue_feature", "_UI_STEMTimeRangeModifier_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModifierPackage.Literals.STEM_TIME_RANGE_MODIFIER__START_VALUE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_STEMTimeRangeModifier_endValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_STEMTimeRangeModifier_endValue_feature", "_UI_STEMTimeRangeModifier_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModifierPackage.Literals.STEM_TIME_RANGE_MODIFIER__END_VALUE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Increment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncrementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_STEMTimeRangeModifier_increment_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_STEMTimeRangeModifier_increment_feature", "_UI_STEMTimeRangeModifier_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModifierPackage.Literals.STEM_TIME_RANGE_MODIFIER__INCREMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Next Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNextValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_STEMTimeRangeModifier_nextValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_STEMTimeRangeModifier_nextValue_feature", "_UI_STEMTimeRangeModifier_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModifierPackage.Literals.STEM_TIME_RANGE_MODIFIER__NEXT_VALUE,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		final STEMTimeRangeModifier rm = (STEMTimeRangeModifier)object;
		final StringBuilder sb = new StringBuilder(rm.getFeatureName());
		sb.append(": ");
		sb.append(rm.getStartValue());
		sb.append(" to ");
		sb.append(rm.getEndValue());
		sb.append(" by ");
		sb.append(rm.getIncrement());
		return sb.toString();
	} // getText
	
	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextGen(Object object) {
		String label = ((STEMTimeRangeModifier)object).getFeatureName();
		return label == null || label.length() == 0 ?
			getString("_UI_STEMTimeRangeModifier_type") : //$NON-NLS-1$
			getString("_UI_STEMTimeRangeModifier_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(STEMTimeRangeModifier.class)) {
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER__INCREMENT:
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
