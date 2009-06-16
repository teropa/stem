package org.eclipse.stem.ui.reports.views;
/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * Thrown when we fail to load a scenario for any reason
 */

public class AggregateFileInitializationException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public AggregateFileInitializationException(String message) {super(message);}
	

	/**
	 * Constructor
	 * 
	 * @param t
	 */
	public AggregateFileInitializationException(Throwable t) {super(t);}

}
