package org.eclipse.stem.utility.generators;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/**
 * 
 * STEM II Data Migration/Generation Utilities : Instances of this class
 * represent a Lex1 object which is not much more than a holder of data for a
 * given location during a lexicographic sorting of level 2 administrations.
 * 
 */

public class Lex2Obj {

	/**
	 * The four data items describing our ISO3166-1 object
	 */
	private String index = null;

	private String alpha2 = null;

	private String admin2 = null;

	private String alpha3 = null;

	private String admin1 = null;

	private String country = null;

	/**
	 * Constructor
	 * 
	 * @param index
	 * @param alpha2
	 * @param alpha3
	 * @param country
	 * @param admin1
	 * @param admin2
	 */
	public Lex2Obj(String index, String alpha2, String alpha3, String country,
			String admin1, String admin2) {
		this.index = index;
		this.alpha2 = alpha2;
		this.admin2 = admin2;
		this.admin1 = admin1;
		this.alpha3 = alpha3;
		this.country = country;
	}

	/**
	 * Get the country code
	 * 
	 * @return the country code
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Get the alpha 1 code
	 * 
	 * @return the alpha 1 code
	 */
	public String getAlpha3() {
		return alpha3;
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
	 * Get the admin 2 code
	 * 
	 * @return the alpha 2 code
	 */
	public String getAdmin2() {
		return admin2.toUpperCase();
	}

	/**
	 * Get the admin 1 code
	 * 
	 * @return the a code
	 */
	public String getAdmin1() {
		return admin1.toUpperCase();
	}

	/**
	 * Get the index
	 * 
	 * @return the numeric code
	 */
	public int getIndex() {
		return Integer.parseInt(index);
	}

	/**
	 * Get the index padded with as many leftmost zeroes as necessary.
	 * 
	 * @return the index padded with leftmost zeroes
	 */
	public String getFormattedIndex() {
		final int MINSIZE = 4;
		if (index.length() < MINSIZE) {
			int padding = MINSIZE - index.length();
			for (int i = 0; i < padding; i++) {
				index = "0" + index; //$NON-NLS-1$
			}
		}
		return index;
	}

	/**
	 * Get the index padded with as many leftmost zeroes as necessary. Special
	 * case for the USA : at most three characters insteadd
	 * 
	 * @return the index padded with leftmost zeroes
	 */
	public String getFormattedIndexUSA() {
		final int MINSIZE = 3;
		if (index.length() < MINSIZE) {
			int padding = MINSIZE - index.length();
			for (int i = 0; i < padding; i++) {
				index = "0" + index; //$NON-NLS-1$
			}
		}
		return index;
	}

}
