// PhaseSpaceFactory.java
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
public class PhaseSpaceFactory implements ReportControlFactory {

	static PhaseSpaceFactory INSTANCE = new PhaseSpaceFactory();

	/**
	 * Constants for saving ReportViewPreferences
	 */
	public static final String PHASE_SPACE_TYPE = "PhaseSpace";

	/**
	 * @param parent
	 *            the parent of the {@link PhaseSpaceHistoryPlotter}
	 * @return a {@link PhaseSpaceHistoryPlotter}
	 * @see org.eclipse.stem.ui.views.geographic.GeographicControlFactory#create(org.eclipse.swt.widgets.Composite)
	 */
	public ReportControl create(final Composite parent) {
		return new PhaseSpaceHistoryPlotter(parent);
	}

	/**
	 * @return TODO JFK
	 * 
	 */
	public String getUniqueControlName() {
		return PHASE_SPACE_TYPE;
	}
	
	/**
	 * This Factory creates a control associated with an Idenfiable
	 * @return type of factory
	 */
	public String getFactoryType() {
		return IDENTIFABLE_TYPE;
	}

} // PhaseSpaceFactory
