// IColorProviderAdapterFactory.java
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

import org.eclipse.stem.core.model.Decorator;
import org.eclipse.swt.widgets.Composite;

/**
 * Interface to be used my any ColorProviderAdapterFactory class.
 * Provides methods that are common to all types of ColorProviderAdapterFactory.
 */
public interface IColorProviderAdapterFactory {	
	/**
	 * The method will return a boolean value about whether the factory supports the specified type
	 * @param type The color provider type to check
	 * @return true if the factory supports it
	 */
	public boolean isFactoryForType(Object type);
	
	/**
	 * The method will return a {@link Composite} widget that will be added to the GUI and holds
	 * the information that can be configured for the specific factory.
	 * @param parent The parent of the {@link Composite}
	 * @param style the style for the generated {@link Composite}
	 * @param selectedDecorator the selected {@link Decorator}
	 * @return the generated {@link Composite}
	 */
	public Composite createPropertiesComposite(final Composite parent, final int style, final Decorator selectedDecorator);
	
	/**
	 * The method will return a {@link Composite} widget that will be added to the GUI and holds
	 * the a legend of the colors that this color provider provides.
	 * @param parent The parent of the {@link Composite}
	 * @param style the style for the generated {@link Composite}
	 * @return the generated {@link Composite}
	 */
	public Composite createColorsLegendComposite(final Composite parent, final int style);
	
	/**
	 * The method will return the {@link Composite} widget that will be added to the GUI and holds
	 * the information that can be configured for the specific factory.
	 * @return the {@link Composite}
	 */
	public Composite getPropertiesComposite();
} // IColorProviderAdapterFactory
