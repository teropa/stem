// ReportControlFactory.java
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
 * This interface is implemented by factories that create instances of
 * {@link ReportControl}.
 */
public interface ReportControlFactory {
	
	/**
	 * One of two factory types. This factory type creates a control associated with an individual
	 * identifiable
	 */
	public static final String IDENTIFABLE_TYPE = "IDENTIFIABLE_CONTROL_FACTORY";
	/**
	 * One of two factory types. This factory type creates a control associated with an individual
	 * Simulation
	 */
	public static final String SIMULATION_TYPE = "SIMULATION_CONTROL_FACTORY";
	
	
	/**
	 * @param parent
	 *            the parent of the control
	 * @return a new {@link ReportControl} instance.
	 */
	ReportControl create(final Composite parent);

	/**
	 * @return the unique type of control
	 */
	public String getUniqueControlName();
	
	/**
	 * @return the unique factory type
	 */
	public String getFactoryType();

} // ReportControlFactory
