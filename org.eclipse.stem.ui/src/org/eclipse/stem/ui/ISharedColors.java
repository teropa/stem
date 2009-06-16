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
 * This interface contains identifiers used to mark SWT colors added to this
 * plug-in's color registry. These colors are intended to be shared by
 * referencing the color registry and using the identifiers defined here to
 * select the appropriate color.
 */
public interface ISharedColors {

	/**
	 * Color green -- used as background when simulation is running
	 */
	String GREEN = "green"; //$NON-NLS-1$

	/**
	 * Color orange -- used as background when simulation is reset
	 */
	String ORANGE = "orange"; //$NON-NLS-1$

	/**
	 * Color yellow -- used as background when simulation is paused
	 */
	String YELLOW = "yellow"; //$NON-NLS-1$

	/**
	 * Color yellow -- used as background for text
	 */
	String GRAY = "gray"; //$NON-NLS-1$

}
