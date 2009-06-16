// StandardColorProvider.java
package org.eclipse.stem.ui.adapters.color;

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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Preferences.IPropertyChangeListener;
import org.eclipse.core.runtime.Preferences.PropertyChangeEvent;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.preferences.MapsColorsPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.RGB;

/**
 * This class provides standard colors for rendered maps.
 * The colors are based on the colors from the preferences page. This class is being used because
 * taking the values directly from the preferences is time consuming and this is being done many
 * times and the cumulative time may be large.
 */
public class StandardColorProvider 
	implements IPropertyChangeListener {
	
	/**
	 * A map for holding the values of color IDs
	 */
	private Map<String, Color> colorIdToColor = new HashMap<String, Color>();
	
	private Device device = null;
	
	/**
	 * The constructor will update the current colors from the preferences and register
	 * this object as a listener to preferences changes.
	 * @param device A {@link Device} that will be used when creating {@link Color} objects.
	 */
	public StandardColorProvider(Device device) {
		this.device = device;
		final Preferences prefs = Activator.getDefault().getPluginPreferences();
		prefs.addPropertyChangeListener(this);
		updateColorsFromPreferences();
	} // StandardColorProvider
	
	/**
	 * The method will return the background {@link Color}.
	 * @return the background {@link Color}
	 */
	public Color getBackgroundColor() {
		return colorIdToColor.get(MapsColorsPreferencePage.BACKGROUND_COLOR_ID);
	} // getBackgroundColor

	/**
	 * The method will return the borders {@link Color}.
	 * @return the borders {@link Color}
	 */
	public Color getBordersColor() {
		return colorIdToColor.get(MapsColorsPreferencePage.BORDERS_COLOR_ID);
	} // getBordersColor
	
	/**
	 * The method will return the edges {@link Color}.
	 * @return the edges {@link Color}
	 */
	public Color getEdgesColor() {
		return colorIdToColor.get(MapsColorsPreferencePage.EDGES_COLOR_ID);
	} // getEdgesColor

	/**
	 * The method will return the foreground {@link Color}.
	 * @return the foreground {@link Color}
	 */
	public Color getForegroundColor() {
		return colorIdToColor.get(MapsColorsPreferencePage.FOREGROUND_COLOR_ID);
	} // getForegroundColor
	
	/**
	 * The method is used to convert RGB as string to {@link Color}. 
	 * @param rgbString the RGB string
	 * @return the matching {@link Color}
	 */
	public Color getColorFromString(final String rgbString) {
		if (rgbString.equals("")) {
			return device.getSystemColor(SWT.COLOR_BLACK);
		}
		RGB rgb = StringConverter.asRGB(rgbString);
		//return new Color(rgb.red, rgb.green, rgb.blue);
		return new Color(device, rgb.red, rgb.green, rgb.blue);
	} // getColorFromString
	
	/**
	 * The method will update the colors from the preferences page.
	 */
	private void updateColorsFromPreferences() {
		final Preferences prefs = Activator.getDefault().getPluginPreferences();
		String colorId = MapsColorsPreferencePage.FOREGROUND_COLOR_ID;
		colorIdToColor.put(colorId, getColorFromString(prefs.getString(colorId)));
		colorId = MapsColorsPreferencePage.BACKGROUND_COLOR_ID;
		colorIdToColor.put(colorId, getColorFromString(prefs.getString(colorId)));
		colorId = MapsColorsPreferencePage.BORDERS_COLOR_ID;
		colorIdToColor.put(colorId, getColorFromString(prefs.getString(colorId)));
		colorId = MapsColorsPreferencePage.EDGES_COLOR_ID;
		colorIdToColor.put(colorId, getColorFromString(prefs.getString(colorId)));
	} // updateColorsFromPreferences

	/**
	 * @see org.eclipse.core.runtime.Preferences.IPropertyChangeListener#propertyChange(org.eclipse.core.runtime.Preferences.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event) {
		String colorId = event.getProperty();
		if (!colorIdToColor.containsKey(colorId)) {
			return;
		}
		Color color = getColorFromString((String)event.getNewValue());
		colorIdToColor.put(colorId, color);
	} // propertyChange
	
} // StandardColorProvider
