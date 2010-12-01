// RelativeValueHistoryProvider.java
package org.eclipse.stem.definitions.adapters.relativevalue.history;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;

/**
 * This interface is implemented by classes that have properties and can map the
 * value of the property to a value between 0.0 (zero) and 1.0 (one), inclusive,
 * and which can provide historic values for those properties as a function of
 * time.
 */
public interface RelativeValueHistoryProvider extends RelativeValueProvider {
	/**
	 * Determine the relative (0.0 to 1.0) value of the property as compared to
	 * the other properties as a function of Time.
	 * 
	 * @param property
	 *            the property whose relative value is to be determined
	 * @param time
	 *            the time to use when determining which value to return.
	 * @return relative (0.0-1.0) value of the property as compared to the other
	 *         properties and whose associated time value is either equal to or
	 *         after/later than the parameter time.
	 */
	double getRelativeValue(final ItemPropertyDescriptor property,
			final STEMTime time);

	/**
	 * Determine the relative (0.0 to 1.0) value of the property as compared to
	 * the other properties.
	 * 
	 * @param feature
	 *            feature of the property whose relative value is to be
	 *            determined
	 * @param time
	 *            the time to use when determining which value to return.
	 * @return relative (0.0-1.0) value of the property as compared to the other
	 *         properties and whose associated time value is either equal to or
	 *         after/later than the parameter time.
	 */
	double getRelativeValue(final EStructuralFeature feature,
			final STEMTime time);

	/**
	 * Produce all relative values for a given property.
	 * 
	 * @param property
	 *            the property whose relative value is to be determined
	 * 
	 * @return all relative (0.0-1.0) values of the property as compared to the
	 *         other properties. The first value of the array (index 0) is the
	 *         oldest value.
	 */
	double[] getAllHistoricRelativeValues(final ItemPropertyDescriptor property);

	/**
	 * Produce all relative values for a given feature.
	 * 
	 * @param feature
	 *            feature of the property whose relative value is to be
	 *            determined
	 * @return all relative (0.0-1.0) values of the feature as compared to the
	 *         other properties. The first value of the array (index 0) is the
	 *         oldest value.
	 */
	double[] getAllHistoricRelativeValues(final EStructuralFeature feature);
	
	
	/**
	 * Produce all relative values in a time range
	 * @param timeRange
	 * @return all relative (0.0-1.0) values of the feature as compared to the
	 *         other properties. The first value of the array (index 0) is the
	 *         oldest value.
	 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getHistoricInstances()
	 */
	public double[] getHistoricInstances(final ItemPropertyDescriptor property, STEMTime[] timeRange);

	/**
	 * @return all of the time values that correspond to the historic relative
	 *         time values. The first value of the collection is the time value
	 *         for the first value of the collection returned by
	 *         {@link #getAllHistoricRelativeValues(ItemPropertyDescriptor)} and
	 *         by {@link #getAllHistoricRelativeValues(EStructuralFeature)}.
	 */
	STEMTime[] getAllHistoricTimeValues();

	/**
	 * @return the earliest time value associated with a relative value.
	 */
	STEMTime getEarliestTimeValue();

	/**
	 * @return the earliest (lowest) cycle number
	 */
	int getEarliestCycleNumber();

} // RelativeValueHistoryProvider
