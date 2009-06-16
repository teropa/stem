package org.eclipse.stem.internal.data.propertydata;

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

import java.text.ParseException;
import java.util.StringTokenizer;

import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;

/**
 * This class represents a single instance of a property extracted from a
 * properties file that represents a relationship between two {@link Node}s.
 * Ultimately, the relationship will be represented as an {@link Edge} in a
 * {@link Graph}.
 */

abstract public class RelationshipPropertyData extends PropertyData {

	/**
	 * This flag indicates if the relationship is directed or not.
	 */
	protected boolean directed = false;

	/**
	 * @param propertyKey
	 *            the key of the property (typically a number e.g., "1")
	 * @param propertyValue
	 *            a string read from a relationship properties file.
	 */
	protected RelationshipPropertyData(final String propertyKey,
			final String propertyValue) throws ParseException {
		parseAndProcessProperty(propertyKey, propertyValue);
	} // RelationshipPropertyData

	/**
	 * @param propertyKey
	 *            the key of the property (typically a number e.g., "1")
	 * @param propertyValue
	 *            the value of the key (format ISOKEY_A, ISOKEY_B, <string>)
	 */
	private final void parseAndProcessProperty(final String propertyKey,
			final String propertyValue) throws ParseException {
		final StringTokenizer st = new StringTokenizer(propertyValue, ", ");
		parseAndProcessProperty(propertyKey, st);
	} // parseAndProcessProperty

	/**
	 * This method is typically called by the subclass to process the string
	 * before it does so that the tokenizer is properly positioned when it gets
	 * its turn.
	 * 
	 * @param propertyKey
	 *            the key of the property (typically a number e.g., "1")
	 * @param st
	 *            a tokenizer positioned (if all is correct) to extract the two
	 *            keys from the propertyValue
	 * @throws ParseException
	 */
	protected void parseAndProcessProperty(final String propertyKey,
			final StringTokenizer st) throws ParseException {
		return;
	} // parseAndProcessProperty

	/**
	 * @return <code>true</code> if the relationship is directed,
	 *         <code>false</code> otherwise.
	 */
	public final boolean isDirected() {
		return directed;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "";
	} // toString

	/**
	 * @return nothing yet
	 */
	public Object getRelativePhysicalRelationship() {
		return "foo5";
	}
} // RelationshipPropertyData
