// RelativeValueColorProvider.java
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

/**
 * This interface is implemented by classes that will provide an relative value for a
 * specific adapted object.
 */
public interface RelativeValueColorProvider extends ColorProvider {

	/**
	 * The relative value for the adapted object.
	 * @return the relative value
	 */
	public float getRelativeValue();
	
}// RelativeValueColorProvider
