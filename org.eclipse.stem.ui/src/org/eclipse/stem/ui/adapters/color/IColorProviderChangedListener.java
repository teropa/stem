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

/**
 * The interface is for listeners that wish to get notified about events of
 * change in the selected color provider.
 * 
 * @author Yossi Mesika (IBM)
 */
public interface IColorProviderChangedListener {

	/**
	 * Listeners will implement this method and it will be called upon
	 * changes of the selected color provider.
	 * 
	 * @param selectedColorProvider The recently selected color provider
	 */
	public void colorProviderChanged(Class selectedColorProvider);
}
