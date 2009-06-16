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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.DublinCore;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.core.common.DublinCore} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DublinCoreItemProvider
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
	public DublinCoreItemProvider(AdapterFactory adapterFactory) {
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

			addTitlePropertyDescriptor(object);
			addIdentifierPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addCreatorPropertyDescriptor(object);
			addDatePropertyDescriptor(object);
			addFormatPropertyDescriptor(object);
			addPublisherPropertyDescriptor(object);
			addCoveragePropertyDescriptor(object);
			addContributorPropertyDescriptor(object);
			addRelationPropertyDescriptor(object);
			addRightsPropertyDescriptor(object);
			addSourcePropertyDescriptor(object);
			addSubjectPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addLanguagePropertyDescriptor(object);
			addBibliographicCitationPropertyDescriptor(object);
			addCreatedPropertyDescriptor(object);
			addLicensePropertyDescriptor(object);
			addRequiredPropertyDescriptor(object);
			addSpatialPropertyDescriptor(object);
			addValidPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_title_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_title_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Creator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_creator_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_creator_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__CREATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Subject feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_subject_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_subject_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__SUBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_description_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_description_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Publisher feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPublisherPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_publisher_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_publisher_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__PUBLISHER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Contributor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContributorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_contributor_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_contributor_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__CONTRIBUTOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_date_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_date_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_type_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_type_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__TYPE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_format_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_format_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__FORMAT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_identifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_identifier_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__IDENTIFIER,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_source_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_source_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__SOURCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_language_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_language_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__LANGUAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Relation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_relation_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_relation_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__RELATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Coverage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCoveragePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_coverage_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_coverage_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__COVERAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rights feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRightsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_rights_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_rights_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__RIGHTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bibliographic Citation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBibliographicCitationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_bibliographicCitation_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_bibliographicCitation_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Created feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreatedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_created_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_created_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__CREATED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the License feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLicensePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_license_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_license_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__LICENSE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_required_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_required_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__REQUIRED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Spatial feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpatialPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_spatial_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_spatial_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__SPATIAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Valid feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addValidPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_valid_feature"), //$NON-NLS-1$
				 //getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_valid_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 getString("_UI_DC_Valid_Desc"), //$NON-NLS-1$ 
				 CommonPackage.Literals.DUBLIN_CORE__VALID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	} // addValidPropertyDescriptor

	/**
	 * This adds a property descriptor for the Valid feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidPropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DublinCore_valid_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DublinCore_valid_feature", "_UI_DublinCore_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommonPackage.Literals.DUBLIN_CORE__VALID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}
	
	/**
	 * This returns DublinCore.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/customobj16/DublinCore"));
	} // getImage

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DublinCore)object).getTitle();
		return label == null || label.length() == 0 ?
			getString("_UI_DublinCore_type") : //$NON-NLS-1$
			getString("_UI_DublinCore_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(DublinCore.class)) {
			case CommonPackage.DUBLIN_CORE__TITLE:
			case CommonPackage.DUBLIN_CORE__IDENTIFIER:
			case CommonPackage.DUBLIN_CORE__DESCRIPTION:
			case CommonPackage.DUBLIN_CORE__CREATOR:
			case CommonPackage.DUBLIN_CORE__DATE:
			case CommonPackage.DUBLIN_CORE__FORMAT:
			case CommonPackage.DUBLIN_CORE__PUBLISHER:
			case CommonPackage.DUBLIN_CORE__COVERAGE:
			case CommonPackage.DUBLIN_CORE__CONTRIBUTOR:
			case CommonPackage.DUBLIN_CORE__RELATION:
			case CommonPackage.DUBLIN_CORE__RIGHTS:
			case CommonPackage.DUBLIN_CORE__SOURCE:
			case CommonPackage.DUBLIN_CORE__SUBJECT:
			case CommonPackage.DUBLIN_CORE__TYPE:
			case CommonPackage.DUBLIN_CORE__LANGUAGE:
			case CommonPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
			case CommonPackage.DUBLIN_CORE__CREATED:
			case CommonPackage.DUBLIN_CORE__LICENSE:
			case CommonPackage.DUBLIN_CORE__REQUIRED:
			case CommonPackage.DUBLIN_CORE__SPATIAL:
			case CommonPackage.DUBLIN_CORE__VALID:
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
