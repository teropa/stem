package org.eclipse.stem.core.common.provider;

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
import java.util.Iterator;
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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptorDecorator;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;


/**
 * This is the item provider adapter for a {@link org.eclipse.stem.core.common.Identifiable} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IdentifiableItemProvider
	extends ItemProviderAdapter
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
	public IdentifiableItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);
			//getPropertyDescriptorsGen(object);
			addDublinCorePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	} // getPropertyDescriptors
	
	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptorsGen(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addURIPropertyDescriptor(object);
			addTypeURIPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * <!-- begin-user-doc --> 
	 * This adds the Dublin Core of the Identifiable as a property
	 * category of all Identifiables. 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addDublinCorePropertyDescriptor(Object object) {
		final DublinCore dc = ((Identifiable) object).getDublinCore();

		final AdapterFactory factory = ((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory();

		final DublinCoreItemProvider dcItemProvider = (DublinCoreItemProvider) (factory
				.adapt(dc, IItemPropertySource.class));

		final List<IItemPropertyDescriptor> dcDescriptors = dcItemProvider
				.getPropertyDescriptors(dc);

		for (Iterator<IItemPropertyDescriptor> iter = dcDescriptors.iterator(); iter.hasNext();) {
			final ItemPropertyDescriptor dcDescriptor = (ItemPropertyDescriptor) iter
					.next();
			itemPropertyDescriptors.add(new ItemPropertyDescriptorDecorator(
					dc, dcDescriptor) {
				@Override
				public String getCategory(Object thisObject) {
					return getString("_UI_Identifiable_dublinCore_feature");
				}
			});
		} // for each idDescriptor
	} // addDublinCorePropertyDescriptorcriptor
	
	/**
	 * This adds a property descriptor for the URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Identifiable_uRI_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Identifiable_uRI_feature", "_UI_Identifiable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.IDENTIFIABLE__URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypeURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Identifiable_typeURI_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Identifiable_typeURI_feature", "_UI_Identifiable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.IDENTIFIABLE__TYPE_URI,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Identifiable.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Identifiable")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		
       // Use the dublin core title if it's available, otherwise use
		// the URI
		final Identifiable identifiable = (Identifiable)object;
		
		final String title = identifiable.getDublinCore().getTitle();
		// Was a title specified?
		if (title != null && !title.equals("")) {
			// Yes
			return title;
		}
		else {
			return identifiable.getURI().lastSegment();
		}
		
	} // getText

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	@Override
	public String getTextGen(Object object) {
		URI labelValue = ((Identifiable)object).getURI();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Identifiable_type") : //$NON-NLS-1$
			getString("_UI_Identifiable_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(Identifiable.class)) {
			case CommonPackage.IDENTIFIABLE__URI:
			case CommonPackage.IDENTIFIABLE__TYPE_URI:
			case CommonPackage.IDENTIFIABLE__DUBLIN_CORE:
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
		return CoreEditPlugin.INSTANCE;
	}

}
