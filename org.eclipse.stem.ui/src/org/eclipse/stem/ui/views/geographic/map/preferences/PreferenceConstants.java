// PreferenceConstants.java
package org.eclipse.stem.ui.views.geographic.map.preferences;

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
	 * The preference id for the map's background color
	 */
	public static final String BACKGROUND_COLOR_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.backgroundcolor";

	/**
	 * The preference id for the map's foreground color
	 */
	public static final String FOREGROUND_COLOR_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.foregroundcolor";

	/**
	 * The preference id for the map's foreground color when the relative value =
	 * 0
	 */
	public static final String FOREGROUND_RELATIVE_VALUE_ZERO_COLOR_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.foregroundrelativevaluezerocolor";

	/**
	 * The preference id for the multicolor/multi-variable map display mode.
	 */
	public static final String MULTI_COLOR_DISPLAY_BOOLEAN_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.multicolordisplay";

	/**
	 * Multicolor Display Intensity weighting for variable S
	 */
	public static final String S_COLOR_WEIGHT_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.scolorweight";

	/**
	 * Multicolor Display Intensity weighting for variable E
	 */
	public static final String E_COLOR_WEIGHT_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.ecolorweight";

	/**
	 * Multicolor Display Intensity weighting for variable I
	 */
	public static final String I_COLOR_WEIGHT_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.icolorweight";

	/**
	 * Multicolor Display Intensity weighting for variable R
	 */
	public static final String R_COLOR_WEIGHT_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.rcolorweight";

	/**
	 * The preference id for the map's initial scaling
	 */
	public static final String GUI_SCALING_FACTOR_DOUBLE_PREFERENCE = "org.eclipse.stem.ui.views.geographic.map.preferences.guiscaling";

} // PreferenceConstants
