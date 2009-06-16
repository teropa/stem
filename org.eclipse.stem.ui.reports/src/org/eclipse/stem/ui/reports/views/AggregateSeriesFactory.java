// TimeSeriesFactory.java
package org.eclipse.stem.ui.reports.views;

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

import org.eclipse.swt.widgets.Composite;

/**
 * This class is a factory for creating {@link ReportControl} instances.
 */
public class AggregateSeriesFactory implements ReportControlFactory {

	static AggregateSeriesFactory INSTANCE = new AggregateSeriesFactory();

	/**
	 * Constants for saving ReportViewPreferences
	 */
	public static final String AGGREGATE_SERIES_TYPE = "AggregateTimeSeries";

	/**
	 * @param parent
	 *            the parent of the {@link RelativeValueHistoryPlotter}
	 * @return a {@link RelativeValueHistoryPlotter}
	 * @see org.eclipse.stem.ui.views.geographic.GeographicControlFactory#create(org.eclipse.swt.widgets.Composite)
	 */
	public ReportControl create(final Composite parent) {
		return new AggregateValueHistoryPlotter(parent);
	}

	/**
	 * @return TODO JFK
	 * 
	 */
	public String getUniqueControlName() {
		return AGGREGATE_SERIES_TYPE;
	}
	
	/**
	 * This Factory creates a control associated with an Simulation
	 * @return type of factory
	 */
	public String getFactoryType() {
		return SIMULATION_TYPE;
	}

} // TimeSeriesFactory
