// MapControlFactory.java
package org.eclipse.stem.ui.views.geographic.map;

import org.eclipse.stem.ui.views.geographic.GeographicControl;
import org.eclipse.stem.ui.views.geographic.GeographicControlFactory;
import org.eclipse.swt.widgets.Composite;

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
 * This class represents
 */
class MapControlFactory implements GeographicControlFactory {

	static MapControlFactory INSTANCE = new MapControlFactory();

	/**
	 * @see org.eclipse.stem.ui.views.geographic.GeographicControlFactory#create(Composite)
	 */
	public GeographicControl create(final Composite parent) {
		return new MapControl(parent);
	}

} // MapControlFactory
