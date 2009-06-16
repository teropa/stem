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
//import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.provider.StaticEdgeLabelItemProvider;

import org.eclipse.stem.core.graph.GraphPackage;
//import org.eclipse.stem.core.graph.provider.DynamicEdgeLabelItemProvider;
//
//import org.eclipse.stem.core.graph.provider.LabelItemProvider;
import org.eclipse.stem.definitions.labels.LabelsFactory;
//import org.eclipse.stem.definitions.edges.provider.DefinitionsEditPlugin;
import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabel;
import org.eclipse.stem.definitions.labels.PhysicalRelationshipLabel;
import org.eclipse.stem.data.geography.GeographicNames;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.definitions.labels.PhysicalRelationshipLabel} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class PhysicalRelationshipLabelItemProvider extends StaticEdgeLabelItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PhysicalRelationshipLabelItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		final URI labelURI = ((PhysicalRelationshipLabel) object).getURI();
		final String lastSegment = labelURI
				.segment(labelURI.segmentCount() - 2).toString();
		final int i = lastSegment.indexOf("_");
		final String firstISOKey = lastSegment.substring(0, i);
		final String secondISOKey = lastSegment.substring(i + 1);

		final String firstGeoName = GeographicNames.getName(firstISOKey);
		final String secondGeoName = GeographicNames.getName(secondISOKey);

		final StringBuilder sb = new StringBuilder(
				firstGeoName.startsWith("!") ? firstISOKey : firstGeoName);
		final Edge edge = ((EdgeLabel) object).getEdge();
		sb.append(edge.isDirected() ? " -> " : " <-> ");
		sb
				.append(secondGeoName.startsWith("!") ? secondGeoName
						: secondGeoName);

		return sb.toString();
	} // getText
	
	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextGen(Object object) {
		URI labelValue = ((PhysicalRelationshipLabel)object).getURI();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_PhysicalRelationshipLabel_type") : //$NON-NLS-1$
			getString("_UI_PhysicalRelationshipLabel_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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
