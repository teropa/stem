// ColorProvider.java
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;

/**
 * The interface will be extended by more specific interfaces that provides colors
 * methods.
 */
public interface ColorProvider {
	/**
	 * The method will return a {@link Color} object that matches some adapted object
	 * @param device A device for created colors
	 * @return a {@link Color} object
	 */
	public Color getColor(Device device);
	/**
	 * The method will update the specified {@link GC} object with values
	 * that matches the adapted object (like fill color).
	 * 
	 * @param gcToUpdate {@link GC} object to update
	 */
	public void updateGC(GC gcToUpdate);
	/**
	 * The method will update the specified {@link GC} object with values
	 * that matches the adapted object (like fill color).
	 * 
	 * @param gcToUpdate {@link GC} object to update
	 * @param gainFactor Gain factor
	 * @param useLogScaling Use logarithmic scaling?
	 */
	public void updateGC(GC gcToUpdate, float gainFactor, boolean useLogScaling);
	/**
	 * The method will set the selected {@link Decorator}.
	 * @param selectedDecorator The selected decorator
	 */
	public void setSelectedDecorator(final Decorator selectedDecorator);
}
// ColorProvider