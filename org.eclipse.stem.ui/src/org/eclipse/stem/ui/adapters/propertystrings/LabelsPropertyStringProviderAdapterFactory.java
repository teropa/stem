package org.eclipse.stem.ui.adapters.propertystrings;

/******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.stem.definitions.labels.util.LabelsAdapterFactory;

/**
 * This class is used to NLS'd strings for Label properties.
 */
public class LabelsPropertyStringProviderAdapterFactory extends
		LabelsAdapterFactory implements PropertyStringProviderAdapterFactory {

	PropertyStringProviderAdapter adapter = null;

	/**
	 * Default Constructor
	 */
	public LabelsPropertyStringProviderAdapterFactory() {
		super();
		PropertyStringProviderAdapterFactory.INSTANCE.addAdapterFactory(this);
	}

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return type == PropertyStringProvider.class
				|| super.isFactoryForType(type);
	}

//	/**
//	 * @see org.eclipse.stem.definitions.labels.util.LabelsAdapterFactory#createAreaLabelAdapter()
//	 */
//	@Override
//	public Adapter createAreaLabelAdapter() {
//		// Have we created one before?
//		if (adapter == null) {
//			// No
//			adapter = new LabelsPropertyStringProviderAdapter();
//		} // if we didn't create one before
//		return adapter;
//	}

	
	/**
	 * @see org.eclipse.stem.definitions.labels.util.LabelsAdapterFactory#createStaticLabelAdapter()
	 */
	@Override
	public Adapter createStaticLabelAdapter() {
		// Have we created one before?
		if (adapter == null) {
			// No
			adapter = new LabelsPropertyStringProviderAdapter();
		} // if we didn't create one before
		return adapter;
	} // createStaticLabelAdapter
	


	/**
	 * This class represents
	 */
	public static class LabelsPropertyStringProviderAdapter extends
			PropertyStringProviderAdapter {

		/**
		 * @param descriptor
		 * @return the NLS'd name of the property to display to the user
		 */
		public String getPropertyName(IItemPropertyDescriptor descriptor) {
			return Messages.getString(((EStructuralFeature) descriptor
					.getFeature(null)).getName());
		} // getPropertyName

		/**
		 * @param descriptor
		 * @return the NLS'd tool tip text that describes the property
		 */
		public String getPropertyToolTip(IItemPropertyDescriptor descriptor) {
			final EStructuralFeature feature = (EStructuralFeature) descriptor
					.getFeature(null);
			return Messages.getString(feature.getName() + TT_SUFFIX);
		} // getPropertyToolTip

		/**
		 * @param descriptor
		 * @return the NLS'd text that represents the units of the property
		 */
		public String getPropertyUnits(IItemPropertyDescriptor descriptor) {
			final EStructuralFeature feature = (EStructuralFeature) descriptor
					.getFeature(null);
			return Messages.getString(feature.getName() + UNIT_SUFFIX);
		} // getPropertyUnits

	} // LabelsPropertyStringProviderAdapter
} // LabelsPropertyStringProviderAdapterFactory
