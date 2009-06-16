// SEIRRelativeValueColorProviderAdapterFactory.java
package org.eclipse.stem.ui.adapters.color;

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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.ui.preferences.PreferenceConstants;
import org.eclipse.stem.ui.widgets.ColorProviderPropertiesComposite;
import org.eclipse.stem.ui.widgets.ColorProviderPropertiesComposite.PropertySelectionEvent;
import org.eclipse.swt.widgets.Composite;

/**
 * This factory create adapters that adapt {@link  Node}s to
 * {@link SEIRRelativeValueColorProvider}s.
 */
public class SEIRRelativeValueColorProviderAdapterFactory extends
		AbstractRelativeValueColorProviderAdapterFactory { 

	/**
	 * @see org.eclipse.stem.core.graph.util.GraphAdapterFactory#createNodeAdapter()
	 */
	@Override
	public Adapter createNodeAdapter() {
		final SEIRRelativeValueColorProviderAdapter adapter = 
			new SEIRRelativeValueColorProviderAdapter(selectedProperty);
		addPropertySelectionListener(adapter);
		adapter.propertySelected(selectedProperty);
		return adapter;
	} // createNodeAdapter

	/**
	 * @see org.eclipse.stem.ui.adapters.color.AbstractRelativeValueColorProviderAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == SEIRRelativeValueColorProvider.class;
	} // isFactoryForType
	
	/**
	 * @see org.eclipse.stem.ui.adapters.color.IColorProviderAdapterFactory#createPropertiesComposite(org.eclipse.swt.widgets.Composite, int, org.eclipse.stem.core.model.Decorator)
	 */
	public Composite createPropertiesComposite(final Composite parent, final int style, final Decorator selectedDecorator)
	{	
		final ColorProviderPropertiesComposite propertiesComposite = new ColorProviderPropertiesComposite(
				parent, style);
		propertiesComposite.setInitialPropertyName(getPreferenceValue(PreferenceConstants.INITIAL_ATTRIBUTE_NAME_STRING_PREFERENCE));
		propertiesComposite.initialize(selectedDecorator);
		selectedProperty = propertiesComposite.getSelectedProperty();
		propertiesComposite
				.addPropertySelectionListener(new ColorProviderPropertiesComposite.PropertySelectionListener() {
					public void propertySelected(
							final PropertySelectionEvent propertySelectionEvent) {
						firePropertySelectionListener(propertySelectionEvent.getProperty());
					}
				});
		this.propertiesComposite = propertiesComposite;
		return propertiesComposite;
	}

	/**
	 * @see org.eclipse.stem.ui.adapters.color.AbstractRelativeValueColorProviderAdapterFactory#createColorsLegendComposite(org.eclipse.swt.widgets.Composite,
	 *      int)
	 */
	@Override
	public Composite createColorsLegendComposite(final Composite parent,
			final int style) {
		final ColorsLegendComposite colorsLegendComposite = new ColorsLegendComposite(
				parent, style);
		colorsLegendComposite
				.addColorEntry(
						RelativeValueColorPreferences.FOREGROUND_COLOR_ZERO_RELATIVE_VALUE_ID,
						"Relative value is 0");
		colorsLegendComposite.addColorEntry(
				RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_1_ID,
				"Relative value between 0 and 0.2");
		colorsLegendComposite.addColorEntry(
				RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_2_ID,
				"Relative value between 0.2 and 0.4");
		colorsLegendComposite.addColorEntry(
				RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_3_ID,
				"Relative value between 0.4 and 0.6");
		colorsLegendComposite.addColorEntry(
				RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_4_ID,
				"Relative value between 0.6 and 0.8");
		colorsLegendComposite.addColorEntry(
				RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_5_ID,
				"Relative value between 0.8 and 1");
		colorsLegendComposite
				.addColorEntry(
						RelativeValueColorPreferences.FOREGROUND_COLOR_MAXIMUM_RELATIVE_VALUE_ID,
						"Relative value is 1 (maximum)");
		return colorsLegendComposite;
	} // createColorsLegendComposite

} // SEIRRelativeValueColorProviderAdapterFactory
