// GraphPropertyFileSpecification.java
package org.eclipse.stem.internal.data.specifications;

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

import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.internal.data.generatedplugin.DublinCore;

/**
 * This class represents a {@link Graph} that is specified by a properties file.
 */
abstract public class GraphPropertyFileSpecification extends
		IdentifiablePropertyFileSpecification {

	/**
	 * These are the properties that define the {@link Graph}.
	 */
	protected Map<String, String> graphProperties = null;

	protected GraphPropertyFileSpecification() {
		// nothing
	}

	/**
	 * @return the {@link Graph}
	 */
	public Graph getGraph() {
		return (Graph) getIdentifiable();
	} // getGraph

	@Override
	protected Graph createIdentifiableInstance() {
		final Graph retValue = GraphFactory.eINSTANCE.createGraph();
		dublinCore.setFormat(GraphPackage.eNS_URI);
		return retValue;
	} // createIdentifiableInstance

	@Override
	protected String getSerializationFileNameExtension() {
		return GraphPackage.eNAME;
	} // getRecordType

	/**
	 * @param type
	 *            the type of elements in the Graph (e.g., "Edge", "Label",
	 *            "Node")
	 * @param subject
	 *            the thing the type represents (e.g., "area", "population",
	 *            "region")
	 * @return the String to put in the {@link DublinCore#getSubject()} string
	 */
	public static String createDublinCoreSubjectString(final String type,
			final String subject) {
		final StringBuilder sb = new StringBuilder(type);
		sb.append(":");
		sb.append(subject);
		return sb.toString();
	} // createDublinCoreSubjectString

	/**
	 * @param dcSubjectString
	 *            a String created by
	 *            {@link #createDublinCoreSubjectString(String, String)}
	 * @return the type and subject extracted from the String
	 */
	public static String[] parseDublinCoreSubjectString(final String dcSubjectString) {
		final StringTokenizer st = new StringTokenizer(dcSubjectString, ":");
		final String type = st.nextToken();
		final String subject = st.nextToken();
		return new String[] { type, subject };
	} // parseDublinCoreSubjectString

} // GraphPropertyFileSpecification
