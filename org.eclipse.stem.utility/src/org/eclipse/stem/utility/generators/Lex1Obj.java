/**
 * 
 */
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
 * given location during a lexicographic sorting of level 1 administrations.
 * 
 */
public class Lex1Obj {

	/**
	 * The four data items describing our ISO3166-1 object
	 */
	private String index = null;

	private String desc = null;

	private String alpha2 = null;

	private String admin1 = null;

	/**
	 * Constructor
	 * 
	 * @param index
	 * @param desc
	 * @param alpha2
	 * @param admin1
	 */
	public Lex1Obj(String index, String desc, String alpha2, String admin1) {
		this.index = index;
		this.desc = desc;
		this.alpha2 = alpha2;
		this.admin1 = admin1;
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
		if (index.length() < 2) {
			index = "0" + index; //$NON-NLS-1$
		}
		return index;
	}

	/**
	 * Get the descriptor
	 * 
	 * @return the descriptor
	 */
	public String getDescriptor() {
		return desc;
	}

	/**
	 * Get the ID for the admin1 For example, for US-AK, we want to get AK which
	 * is the ID for the admin1 area.
	 * 
	 * @return the substring with the ID.
	 */
	public String getID() {
		int hyphen = desc.indexOf("-"); //$NON-NLS-1$
		if ((hyphen + 1) < desc.length()) {
			return desc.substring(hyphen + 1);
		}
		return desc;
	}

}
