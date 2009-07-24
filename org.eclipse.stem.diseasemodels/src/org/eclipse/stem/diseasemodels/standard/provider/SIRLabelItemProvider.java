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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;

import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.stem.diseasemodels.standard.SIRLabel} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SIRLabelItemProvider extends StandardDiseaseModelLabelItemProvider
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
	public SIRLabelItemProvider(AdapterFactory adapterFactory) {
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

			addDeltaValuePropertyDescriptor(object);
			addProbeValuePropertyDescriptor(object);
			addTempValuePropertyDescriptor(object);
			addOriginalValuePropertyDescriptor(object);
			addErrorScalePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Delta Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDeltaValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SIRLabel_deltaValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_SIRLabel_deltaValue_feature", "_UI_SIRLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.SIR_LABEL__DELTA_VALUE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Probe Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProbeValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SIRLabel_probeValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_SIRLabel_probeValue_feature", "_UI_SIRLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.SIR_LABEL__PROBE_VALUE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Temp Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTempValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SIRLabel_tempValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_SIRLabel_tempValue_feature", "_UI_SIRLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.SIR_LABEL__TEMP_VALUE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Original Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOriginalValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SIRLabel_originalValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_SIRLabel_originalValue_feature", "_UI_SIRLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.SIR_LABEL__ORIGINAL_VALUE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Error Scale feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addErrorScalePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SIRLabel_errorScale_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_SIRLabel_errorScale_feature", "_UI_SIRLabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 StandardPackage.Literals.SIR_LABEL__ERROR_SCALE,
				 true,
				 false,
				 true,
				 null,
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
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		URI labelValue = ((SIRLabel)object).getURI();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_SIRLabel_type") : //$NON-NLS-1$
			getString("_UI_SIRLabel_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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
