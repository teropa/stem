package org.eclipse.stem.utility.generators;

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

/**
 * 
 * Relevant keys to the Canadian dataset. Keys in this class are used during the
 * data cleaning process to extract only the relevant keys from the original
 * data source file for Canada. These keys are used when running an instance of
 * RussiaDataCleaner to perform data cleaning.
 * 
 */
public abstract class CanadaDataCleaningHeader {

	/**
	 * Total Area
	 */
	public static final int AREA = 1;

	/**
	 * Country identifier
	 */
	public static final int COUNTRY = 7;

	/**
	 * Location name 1
	 */
	public static final int NAME1 = 8;

	/**
	 * Population value this is not really the population but it will create
	 * dummy files
	 */
	public static final int POP1 = 4;

}