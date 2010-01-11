package org.eclipse.stem.analysis;
/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

public class States {
	/**
     * possible states with parameters to fit
     */
	public static final String[] statesToFit= {"S","E","I","R","P", "Incidence"};
	/**
	 *  Susceptible index (for statesToFit)
	 */
	public static final int SUSCEPTIBLE = 0;
	/**
	 * Exposed index (for statesToFit)
	 */
	public static final int EXPOSED     = 1;
	/**
	 * Infectious index (for statesToFit)
	 */
	public static final int INFECTIOUS  = 2;
	/**
	 *  Recovered index (for statesToFit)
	 */
	public static final int RECOVERED   = 3;
	/**
	 *  Infectious recover index (for statesToFit)
	 */
	public static final int POPULATION = 4;
	/**
	 *  Incidence
	 */
	public static final int INCIDENCE = 5;
}
