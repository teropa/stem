// Util.java
package org.eclipse.stem.core.tests.util;

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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.impl.IdentifiableFilterImpl;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.tests.GraphTest;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.tests.ModelTest;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.tests.ScenarioTest;

/**
 * This class holds utility methods for testing. The Main method creates
 * instances of the the graph, model and scenario's being used for the JUnit
 * tests and serializes them.
 */
public class Util {

	private static final String SCENARIO_FILE_NAME = "testscenario.xml";

	private static final String GRAPH_FILE_NAME = "testgraph.xml";

	private static final String MODEL_FILE_NAME = "testmodel.xml";

	private static final String CANONICAL_GRAPH_FILE_NAME = "testcanonicalgraph.xml";

	public static void main(final String[] args) {
		try {
			serializeGraph(GRAPH_FILE_NAME);
			serializeModel(MODEL_FILE_NAME);
			serializeScenario(SCENARIO_FILE_NAME);
			serializeCanonicalGraph(CANONICAL_GRAPH_FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main

	/**
	 * Serialize a graph.
	 * 
	 * @param fileName
	 *            the name of the file to serialize into
	 * @throws IOException 
	 */
	private static void serializeGraph(final String fileName) throws IOException {
		final Graph graph = GraphTest.createFixture();
		refreshDublinCore(graph);
		Utility.serializeIdentifiable(graph, createURI(fileName));
	} // serializeGraph

	/**
	 * Serialize a model.
	 * 
	 * @param fileName
	 *            the name of the file to serialize into
	 * @throws IOException 
	 */
	private static void serializeModel(final String fileName) throws IOException {
		final Model model = ModelTest.createFixture();
		refreshDublinCore(model);
		Utility.serializeIdentifiable(model, createURI(fileName));
	} // serializeModel

	/**
	 * Serialize a scenario.
	 * @throws IOException 
	 */
	private static void serializeScenario(final String fileName) throws IOException {
		final Scenario scenario = ScenarioTest.createFixture();
		refreshDublinCore(scenario);
		Utility.serializeIdentifiable(scenario, createURI(fileName));
	} // serializeScenario

	/**
	 * @param canonical_graph_file_name2
	 * @throws IOException 
	 */
	private static void serializeCanonicalGraph(final String fileName) throws IOException {
		final Scenario scenario = ScenarioTest.createFixture();
		refreshDublinCore(scenario);
		STEMTime now = ModelFactory.eINSTANCE.createSTEMTime();
		final Graph canonicalGraph = scenario.getModel().getCanonicalGraph(
				STEMURI.createURI("canonical"), new IdentifiableFilterImpl(scenario.getModel().getDublinCore().getCoverage()), now);
		Utility.serializeIdentifiable(canonicalGraph, createURI(fileName));
	} // serializeCanonicalGraph

	/**
	 * @param fileName
	 * @return a uri
	 */
	private static URI createURI(final String filePath) {
		final URI retValue = URI.createURI(filePath);

		return retValue;
	} // createURI

	/**
	 * @param graph
	 */
	private static void refreshDublinCore(final Identifiable identifiable) {
		final DublinCore dc = identifiable.getDublinCore();
		dc.populate();
		dc.setFormat(identifiable.eClass().getEPackage().getNsURI());
	} // refreshDublinCore
} // Util
