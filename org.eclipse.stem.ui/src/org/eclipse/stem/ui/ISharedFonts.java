package org.eclipse.stem.ui;

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
 * This interface contains identifiers used to mark SWT fonts added to this
 * plug-in's font registry. These fonts are intended to be shared by referencing
 * the fonts registry and using the identifiers defined here to select the
 * appropriate image.
 */

public interface ISharedFonts {

	/**
	 * Default font used in simulation control
	 */
	String DEFAULT = "default"; //$NON-NLS-1$

}
