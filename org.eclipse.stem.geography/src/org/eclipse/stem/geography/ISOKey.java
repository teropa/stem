// ISOKey.java
package org.eclipse.stem.geography;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * This class represents an ISO-3166-1 alpha3 or alpha2 country key (or
 * combination).
 */
public class ISOKey implements Comparable<ISOKey> {
	/**
	 * This is the ISO key used to represent The Earth
	 */
	public static final ISOKey EARTH = new ISOKey("ZZZ"); //$NON-NLS-1$

	private String key = null;

	/**
	 * @param key
	 *            the key
	 */
	public ISOKey(final String key) {
		this.key = key.trim();
	}

	/**
	 * @return the key
	 */
	public final String getKey() {
		return key;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return key.hashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ISOKey other = (ISOKey) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return key;
	}

	/**
	 * @param isoKey
	 *            the key to compare to
	 * @return the value of string compareTo
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(final ISOKey isoKey) {
		return this.key.compareTo(isoKey.key);
	}

} // ISOKey
