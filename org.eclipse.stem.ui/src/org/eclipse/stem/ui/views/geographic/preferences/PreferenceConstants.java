// PreferenceConstants.java
package org.eclipse.stem.ui.views.geographic.preferences;

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

/**
 * Constant definitions for plug-in preferences
 */
public interface PreferenceConstants {

	/**
	 * The preference id for the drawing polygon borders.
	 */
	public static final String DRAW_POLYGON_BORDERS_BOOLEAN_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.polygonborders";
	/**
	 * The preference id for using a logarithmic scale of the values in the
	 * display.
	 */
	public static final String LOGSCALE_BOOLEAN_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.logscale";
	/**
	 * The preference id for the map gain factor
	 */
	public static final String GAIN_FACTOR_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.gainfactor";
	/**
	 * The preference id for the map's border color
	 */
	public static final String BORDER_COLOR_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.bordercolor";

} // PreferenceConstants
