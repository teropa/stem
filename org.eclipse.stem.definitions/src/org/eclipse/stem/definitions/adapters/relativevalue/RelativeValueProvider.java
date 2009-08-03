// RelativeValueProvider.java
package org.eclipse.stem.definitions.adapters.relativevalue;

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

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

/**
 * This interface is implemented by classes that have properties and can map the
 * value of the property to a value between 0.0 (zero) and 1.0 (one), inclusive.
 */
public interface RelativeValueProvider {

	/**
	 * @return the properties of the provider
	 */
	List<IItemPropertyDescriptor> getProperties();

	/**
	 * Determine the relative (0.0 to 1.0) value of the property as compared to
	 * the other properties.
	 * 
	 * @param property
	 *            the property whose relative value is to be determined
	 * @return relative (0.0-1.0) value of the property as compared to the other
	 *         properties.
	 */
	double getRelativeValue(final ItemPropertyDescriptor property);

	/**
	 * Determine the relative (0.0 to 1.0) value of the property as compared to
	 * the other properties.
	 * 
	 * @param feature
	 *            feature of the property whose relative value is to be
	 *            determined
	 * @return relative (0.0-1.0) value of the property as compared to the other
	 *         properties.
	 */
	double getRelativeValue(final EStructuralFeature feature);
	
	/**
	 * This method returns the denominator or scale used to convert to relative
	 * values in the range 0-1. For example, in an Epidemic Compartment model
	 * the state values are normalized by population.
	 * It is required whenever we need to switch between relative and absolute values
	 * or can be used to create a label showing the maximum scale for any relative value.
	 * @return the denominator or scale used to normalize the relative value
	 */
	double getDenominator(final EStructuralFeature feature) ;
}// RelativeValueProvider
