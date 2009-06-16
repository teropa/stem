// Example1.java
package org.eclipse.stem.sample.adaption;

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

import java.util.Iterator;

import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLongProvider;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLongProviderAdapterFactory;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;
import org.eclipse.stem.diseasemodels.standard.tests.DeterministicSEIRScenarioTest;

/**
 * This class is an example of how to obtain the canonical graph from a
 * scenario, access the nodes in the graph, and adapt the nodes to produce
 * lat/long data sets for each node.
 */
public class Example1 {

	/**
	 * @param args
	 *            none
	 */
	public static void main(String[] args) {

		// This creates a scenario that's ready to be "stepped" (i.e.,
		// simulated). The world is a lattice (grid) that 2x2 where each node
		// has a population of 100 humans and has an area of 100 square
		// kilometers. There is one disease that is modeled with a
		// "deterministic SEIR disease model". One person in the node at
		// position [0][0], in the upper left of the grid, is infected.
		final Scenario scenario = DeterministicSEIRScenarioTest.createScenario(
				2, 2);

		// This will initialize the scenario and make it ready to step through
		// the simulation sequence. In particular, it will create the canonical
		// graph from the scenario's model.
		scenario.initialize();

		// We get the graph...
		final Graph canonicalGraph = scenario.getCanonicalGraph();

		// ...and can now iterate through the nodes. Note that the method
		// "getNodes" returns a map indexed by the URI of each of the nodes,
		// thus we need to get the values of the map to have an actual list to
		// iterator over.
		for (final Iterator nodeIter = canonicalGraph.getNodes().values()
				.iterator(); nodeIter.hasNext();) {
			final Node node = (Node) nodeIter.next();

			// We'd like to have access to lat/long data of the node if there is
			// any, to do that we use a factory to create an adapter that knows
			// about the inner details of nodes (it really knows about all
			// Identifiables) and implements the LatLongProvider interface.
			final LatLongProvider latLongProvider = (LatLongProvider) LatLongProviderAdapterFactory.INSTANCE
					.adapt(node, LatLongProvider.class);

			// The node may or may not have lat/long data associated with it, if
			// it doesn't the list that's returned will be empty.
			final LatLong latLongData = latLongProvider.getLatLong();

			System.out.println("The lat/long data for \""
					+ node.getDublinCore().getTitle() + "\" is:");
			outputLatLongData(latLongData);
		} // for each node

		System.out.println("Edges...");

		// For fun, let's do the edges, there might not be anything defined for
		// them...yet
		for (final Iterator edgeIter = canonicalGraph.getEdges().values()
				.iterator(); edgeIter.hasNext();) {
			final Edge edge = (Edge) edgeIter.next();
			final LatLongProvider latLongProvider = (LatLongProvider) LatLongProviderAdapterFactory.INSTANCE
					.adapt(edge, LatLongProvider.class);

			final LatLong latLongData = latLongProvider.getLatLong();

			System.out.println("The lat/long data for \""
					+ edge.getDublinCore().getTitle() + "\" is:");
			outputLatLongData(latLongData);
		} // for each edge
	} // main

	/**
	 * @param latLong
	 *            a LatLong instance
	 */
	public static void outputLatLongData(LatLong latLong) {
		for (Segment segment : latLong.getSegments()) {
			final int size = segment.size();
			for (int i = 0; i < size; i++) {
				System.out.println(createStringOfLatLongData(segment));
			} // for each lat/long pair
			System.out.println();
		} // for each segment
	} // outputLatLongData

	/**
	 * @param segment
	 * @return a string of the lat/long points
	 */
	public static String createStringOfLatLongData(final Segment segment) {
		final StringBuilder sb = new StringBuilder();
		final int size = segment.size();
		for (int i = 0; i < size; i++) {
			sb.append("(");
			sb.append(segment.latitude(i));
			sb.append(", ");
			sb.append(segment.longitude(i));
			sb.append(")");
		} // for each lat/long pair
		return sb.toString();
	} // createStringOfLatLongData
} // Example1
