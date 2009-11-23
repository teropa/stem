// AreaRelativeValueColorProviderAdapterFactory.java
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
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;

/**
 * This factory create adapters that adapt
 * {@link org.eclipse.stem.core.graph.Node}s to
 * {@link AreaRelativeValueColorProvider}s.
 */
public class AreaRelativeValueColorProviderAdapterFactory extends
		AbstractRelativeValueColorProviderAdapterFactory {

	/**
	 * Constructor
	 */
	public AreaRelativeValueColorProviderAdapterFactory() {
		super();
	} // AreaRelativeValueColorProviderAdapterFactory

	/**
	 * @see org.eclipse.stem.core.graph.util.GraphAdapterFactory#createNodeAdapter()
	 */
	@Override
	public Adapter createNodeAdapter() {
		final AreaRelativeValueColorProviderAdapter adapter = new AreaRelativeValueColorProviderAdapter();
		return adapter;
	} // createNodeAdapter

	/**
	 * @see org.eclipse.stem.ui.adapters.color.AbstractRelativeValueColorProviderAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == AreaRelativeValueColorProvider.class;
	} // isFactoryForType

	/**
	 * @see org.eclipse.stem.ui.adapters.color.IColorProviderAdapterFactory#createPropertiesComposite(org.eclipse.swt.widgets.Composite, int, org.eclipse.stem.core.model.Decorator)
	 */
	@Override
	public Composite createPropertiesComposite(final Composite parent, @SuppressWarnings("unused") final int style, @SuppressWarnings("unused") final Decorator selectedDecorator)
	{
		final Composite composite = new Composite(parent, SWT.NONE);
		final Layout layout = new RowLayout();
		composite.setLayout(layout);
		final Label label = new Label(composite, SWT.NONE);
		label.setText("This color provider is not implemented yet");
		return composite;
	} // createPropertiesComposite

	/**
	 * @see org.eclipse.stem.ui.adapters.color.AbstractRelativeValueColorProviderAdapterFactory#createColorsLegendComposite(org.eclipse.swt.widgets.Composite,
	 *      int)
	 */
	@Override
	public Composite createColorsLegendComposite(final Composite parent,
			final int style) {
		final ColorsLegendComposite colorsLegendComposite = new ColorsLegendComposite(
				parent, style);
		colorsLegendComposite.addColorEntry(
				RelativeValueColorPreferences.FOREGROUND_COLOR_RANGE_4_ID,
				"Area relative value");
		return colorsLegendComposite;
	} // createColorsLegendComposite

} // AreaRelativeValueColorProviderAdapterFactory
