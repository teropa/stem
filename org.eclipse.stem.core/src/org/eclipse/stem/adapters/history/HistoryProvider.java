// HistoryProvider.java
package org.eclipse.stem.adapters.history;

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

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.STEMTime;

/**
 * This interface is implemented by classes that provide instances of
 * {@link Identifiables} as they existed in previous (historic) cycles of a
 * {@link Simulation}.
 */
public interface HistoryProvider {

	/**
	 * @param time
	 *            the time in a {@link Simulation} that specifies the instance
	 *            of the {@ Identifiable} to return
	 * @return the {@link Identifiable} instance that was current in the state
	 *         of the {@link org.eclipse.stem.core.graph.Graph} at the <code>time</code>.
	 */
	Identifiable getInstance(STEMTime time);

	/**
	 * @return all of the historic instances of the {@link Identifiable}. The
	 *         value at index 0 is the earliest.
	 */
	Identifiable[] getAllHistoricInstances();

	
	/**
	 * @return The historic instances that match the time values in
	 * the array timeRange {@link Identifiable}. 
	 */
	Identifiable[] getHistoricInstances(STEMTime[] timeRange);

	
	/**
	 * @return all of the time values that correspond to the historic values.
	 *         The first value of the collection is the time value for the first
	 *         value of the collection returned by
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

} // HistoryProvider
