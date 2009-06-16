// DefaultPropertyStringProviderAdapter.java
package org.eclipse.stem.ui.adapters.propertystrings;

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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * This class is the PropertyStringProviderAdapter that is returned by the
 * {@link PropertyStringProviderAdapterFactory} when no other
 * {@link PropertyStringProviderAdapter} is found.
 */
public class DefaultPropertyStringProviderAdapter extends
		PropertyStringProviderAdapter {

	/**
	 * @see org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider#getPropertyName(org.eclipse.emf.edit.provider.IItemPropertyDescriptor)
	 */
	public String getPropertyName(final IItemPropertyDescriptor descriptor) {
		return "!"
				+ ((EStructuralFeature) descriptor.getFeature(null)).getName()
				+ "!";
	}

	/**
	 * @see org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider#getPropertyToolTip(org.eclipse.emf.edit.provider.IItemPropertyDescriptor)
	 */
	public String getPropertyToolTip(final IItemPropertyDescriptor descriptor) {
		return "!"
				+ ((EStructuralFeature) descriptor.getFeature(null)).getName()
				+ TT_SUFFIX + "!";
	}

	/**
	 * @see org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider#getPropertyUnits(org.eclipse.emf.edit.provider.IItemPropertyDescriptor)
	 */
	public String getPropertyUnits(final IItemPropertyDescriptor descriptor) {
		return "!"
				+ ((EStructuralFeature) descriptor.getFeature(null)).getName()
				+ UNIT_SUFFIX + "!";
	}

} // DefaultPropertyStringProviderAdapter

