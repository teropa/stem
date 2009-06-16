// MapControl.java
package org.eclipse.stem.ui.views.geographic.map;

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

import org.eclipse.stem.ui.views.geographic.GeographicControl;
import org.eclipse.stem.ui.views.geographic.GeographicRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * This class is a SWT {@link Composite} that displays Lat/Long data adapted
 * from the contents of the canonical graph in a
 * {@link org.eclipse.stem.core.scenario.Scenario} being simulated. It
 * listens for changes in the
 * {@link org.eclipse.stem.jobs.simulation.Simulation} and then redraws its
 * view as appropriate.
 */
public class MapControl extends GeographicControl {

	/**
	 * @param parent
	 *            the parent {@link Composite} of the <code>MapControl</code>
	 */
	public MapControl(final Composite parent) {
		super(parent, SWT.NONE);
	} // MapControl

	/**
	 * @return the {@link GeographicRenderer} to use.
	 */
	protected GeographicRenderer createGeographicRenderer() {
		return new MapRenderer(this, SWT.NONE);
	}
} // MapControl
