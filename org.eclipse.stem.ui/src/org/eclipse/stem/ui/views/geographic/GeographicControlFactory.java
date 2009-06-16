// GeographicControlFactory.java
package org.eclipse.stem.ui.views.geographic;

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

import org.eclipse.swt.widgets.Composite;

/**
 * This interface is implemented by factories that create instances of
 * {@link GeographicControl}.
 */
public interface GeographicControlFactory {

	/**
	 * @param parent
	 *            the parent of the control
	 * @return a new {@link GeographicControl} instance.
	 */
	GeographicControl create(final Composite parent);

} // GeographicControlFactory
