package org.eclipse.stem.utility.generators;

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
 * STEM II Data Migration/Generation Utilities : Instances of this class are
 * just a convenience container for ISO3166-1 data.
 * 
 */
public class ISOCode1 {

	/**
	 * The four data items describing our ISO3166-1 object
	 */
	private String alpha3 = null;

	private String alpha2 = null;

	private String numeric = null;

	private String name = null;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param numeric
	 * @param alpha2
	 * @param alpha3
	 */
	public ISOCode1(String name, String numeric, String alpha2, String alpha3) {
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
		this.numeric = numeric;
		this.name = name;
	}

	/**
	 * Get the alpha 2 code
	 * 
	 * @return the alpha 2 code
	 */
	public String getAlpha2() {
		return alpha2;
	}

	/**
	 * Get the alpha 3 code
	 * 
	 * @return the alpha 3 code
	 */
	public String getAlpha3() {
		return alpha3;
	}

	/**
	 * Get the numeric code
	 * 
	 * @return the numeric code
	 */
	public String getNumeric() {
		return numeric;
	}

	/**
	 * Get the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Clear the object
	 */
	public void clear() {
		this.alpha2 = null;
		this.alpha3 = null;
		this.numeric = null;
		this.name = null;
	}
}
