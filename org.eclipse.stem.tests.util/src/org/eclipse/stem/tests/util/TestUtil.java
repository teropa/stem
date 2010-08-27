// TestUtil.java
package org.eclipse.stem.tests.util;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.DynamicEdgeLabel;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.StaticEdgeLabel;
import org.eclipse.stem.core.graph.StaticNodeLabel;
import org.eclipse.stem.core.graph.impl.EdgeImpl;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.EdgeDecorator;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.TestNodeDecorator1;
import org.eclipse.stem.tests.util.labels.LabelsFactory;
import org.eclipse.stem.tests.util.labels.TestDynamicEdgeLabel;
import org.eclipse.stem.tests.util.labels.TestDynamicLabel1;
import org.eclipse.stem.tests.util.labels.TestDynamicNodeLabel;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;
import org.eclipse.stem.tests.util.labels.TestLabel;
import org.eclipse.stem.tests.util.labels.TestStaticEdgeLabel;
import org.eclipse.stem.tests.util.labels.TestStaticNodeLabel;

/**
 * This class contains utility methods for testing STEM.
 */
public class TestUtil {

	/**
	 * This is a counter used to uniquely number the labels that are created.
	 * 
	 * @see #createStaticLabel(URI)
	 */
	private static int labelCounter = 0;

	/**
	 * This is a counter used to uniquely number the dynamic labels that are
	 * created.
	 * 
	 * @see #createDynamicLabel(URI)
	 */
	private static int dynamicLabelCounter = 0;

	/**
	 * This is a counter used to uniquely number the edges that are created.
	 * 
	 * @see #createNextEdgeURI()
	 */
	private static int edgeCounter = 0;

	/**
	 * This is a counter used to uniquely number the nodes that are created.
	 * 
	 * @see #createNextNodeURI()
	 */
	private static int nodeCounter = 0;

	/**
	 * This is a counter used to generate unique URI's of things to label
	 * 
	 * @see #createFixture()
	 */
	private static int idCounter = 0;

	/**
	 * Reset the counters
	 */
	public static void resetCounters() {
		labelCounter = 0;
		dynamicLabelCounter = 0;
		edgeCounter = 0;
		nodeCounter = 0;
		idCounter = 0;
	}

	/**
	 * @return a static label instance
	 */
	public static Label createStaticLabel() {
		return createStaticLabel(createNextIdentifiableToLabelURI());
	} // createStaticLabel

	/**
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a static label instance
	 */
	public static Label createStaticLabel(final URI uriOfIdentifiableToBeLabeled) {
		return createStaticLabel(createNextLabelURI(),
				uriOfIdentifiableToBeLabeled);
	} // createStaticLabel

	/**
	 * @param labelURI
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a static label instance
	 */
	public static Label createStaticLabel(final URI labelURI,
			final URI uriOfIdentifiableToBeLabeled) {
		final TestLabel retValue = LabelsFactory.eINSTANCE.createTestLabel();
		retValue.setURI(labelURI);
		retValue.setURIOfIdentifiableToBeLabeled(uriOfIdentifiableToBeLabeled);

		final TestIntegerLabelValue staticLabelCurrentValue = LabelsFactory.eINSTANCE
				.createTestIntegerLabelValue();
		staticLabelCurrentValue
				.setI(TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		retValue.setCurrentValue(staticLabelCurrentValue);

		assert retValue.sane();

		return retValue;
	} // createStaticLabel

	/**
	 * @return a unique URI for a label.
	 */
	private static URI createNextLabelURI() {
		return STEMURI.createURI("LABEL" + "/" + labelCounter++);
	} // createNextLabelURI

	/**
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a unique dynamic label
	 */
	public static TestDynamicLabel1 createDynamicLabel(
			final URI uriOfIdentifiableToBeLabeled) {
		final TestNodeDecorator1 tnd = DecoratorsFactory.eINSTANCE
				.createTestNodeDecorator1();
		return createDynamicLabel(createNextDynamicLabelURI(),
				uriOfIdentifiableToBeLabeled, tnd);
	} // createDynamicLabel

	/**
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a unique dynamic label
	 */
	public static TestDynamicLabel1 createDynamicLabel(
			final URI uriOfIdentifiableToBeLabeled, final Decorator decorator) {
		return createDynamicLabel(createNextDynamicLabelURI(),
				uriOfIdentifiableToBeLabeled, decorator);
	} // createDynamicLabel

	/**
	 * @param labelURI
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a unique dynamic label
	 */
	public static TestDynamicLabel1 createDynamicLabel(final URI labelURI,
			final URI uriOfIdentifiableToBeLabeled, final Decorator decorator) {
		final TestDynamicLabel1 retValue = LabelsFactory.eINSTANCE
				.createTestDynamicLabel1();
		retValue.setURI(labelURI);
		retValue.setURIOfIdentifiableToBeLabeled(uriOfIdentifiableToBeLabeled);
		retValue.setDecorator(decorator);
		final TestIntegerLabelValue dynamicLabelCurrentValue = LabelsFactory.eINSTANCE
				.createTestIntegerLabelValue();
		final TestIntegerLabelValue dynamicLabelNextValue = LabelsFactory.eINSTANCE
				.createTestIntegerLabelValue();
		dynamicLabelCurrentValue
				.setI(TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		dynamicLabelNextValue
				.setI(TestIntegerLabelValue.NEXT_LABEL_INTEGER_VALUE);

		retValue.setCurrentValue(dynamicLabelCurrentValue);
		retValue.setNextValue(dynamicLabelNextValue);

		assert retValue.sane();

		return retValue;
	} // createDynamicLabel

	/**
	 * @param labelURI
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a static node label
	 */
	public static StaticNodeLabel createStaticNodeLabel(final URI labelURI,
			final URI uriOfIdentifiableToBeLabeled) {
		final TestStaticNodeLabel retValue = LabelsFactory.eINSTANCE
				.createTestStaticNodeLabel();
		retValue.setURI(labelURI);
		retValue.setURIOfIdentifiableToBeLabeled(uriOfIdentifiableToBeLabeled);

		final TestIntegerLabelValue staticLabelCurrentValue = LabelsFactory.eINSTANCE
				.createTestIntegerLabelValue();
		staticLabelCurrentValue
				.setI(TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		retValue.setCurrentValue(staticLabelCurrentValue);

		assert retValue.sane();
		return retValue;
	} // createStaticNodeLabel

	/**
	 * @return a unique dynamic node label
	 */
	public static TestDynamicNodeLabel createDynamicNodeLabel() {
		final TestNodeDecorator1 tnd = DecoratorsFactory.eINSTANCE
				.createTestNodeDecorator1();
		return createDynamicNodeLabel(createNextDynamicLabelURI(),
				createNextIdentifiableToLabelURI(), tnd);
	} // createDynamicNodeLabel

	/**
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a unique dynamic node label
	 */
	public static TestDynamicNodeLabel createDynamicNodeLabel(
			final URI uriOfIdentifiableToBeLabeled,
			final NodeDecorator nodeDecorator) {
		return createDynamicNodeLabel(createNextDynamicLabelURI(),
				uriOfIdentifiableToBeLabeled, nodeDecorator);
	} // createDynamicNodeLabel

	/**
	 * @param labelURI
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a unique dynamic label
	 */
	public static TestDynamicNodeLabel createDynamicNodeLabel(
			final URI labelURI, final URI uriOfIdentifiableToBeLabeled,
			final NodeDecorator nodeDecorator) {
		final TestDynamicNodeLabel retValue = LabelsFactory.eINSTANCE
				.createTestDynamicNodeLabel();
		retValue.setURI(labelURI);
		retValue.setURIOfIdentifiableToBeLabeled(uriOfIdentifiableToBeLabeled);

		retValue.setDecorator(nodeDecorator);

		final TestIntegerLabelValue dynamicLabelCurrentValue = LabelsFactory.eINSTANCE
				.createTestIntegerLabelValue();
		final TestIntegerLabelValue dynamicLabelNextValue = LabelsFactory.eINSTANCE
				.createTestIntegerLabelValue();
		dynamicLabelCurrentValue
				.setI(TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		dynamicLabelNextValue
				.setI(TestIntegerLabelValue.NEXT_LABEL_INTEGER_VALUE);

		retValue.setCurrentValue(dynamicLabelCurrentValue);
		retValue.setNextValue(dynamicLabelNextValue);

		assert retValue.sane();

		return retValue;
	} // createDynamicNodeLabel

	/**
	 * @return a unique URI for a label.
	 */
	private static URI createNextDynamicLabelURI() {
		return STEMURI.createURI("DYNAMICLABEL" + "/" + dynamicLabelCounter++);
	} // createNextDynamicLabelURI

	/**
	 * @return a unique URI for a Identifiable to label
	 */
	public static URI createNextIdentifiableToLabelURI() {
		return STEMURI.createURI("FOOBAR" + "/" + idCounter++);
	} // createNextThingToLabelURI

	/**
	 * @param nodeAURI
	 *            the URI of the A node the edge links to
	 * @param nodeBURI
	 *            the URI of the B node the edge links to
	 * @param edgeDecorator
	 * @return a dynamically labeled edge linking nodes with the two URI's
	 */
	public static Edge createDynamicallyLabeledEdge(final URI nodeAURI,
			final URI nodeBURI, EdgeDecorator edgeDecorator) {
		return createDynamicallyLabeledEdge(nodeAURI, nodeBURI,
				createNextEdgeURI(), edgeDecorator);
	} // createDynamicallyLabeledEdge

	/**
	 * @param nodeAURI
	 *            the URI of the A node the edge links to
	 * @param nodeBURI
	 *            the URI of the B node the edge links to
	 * @param edgeURI
	 *            uri to use for the edge
	 * @param edgeDecorator
	 * @return a dynamically labeled edge linking nodes with the two URI's
	 */
	public static Edge createDynamicallyLabeledEdge(final URI nodeAURI,
			final URI nodeBURI, final URI edgeURI, EdgeDecorator edgeDecorator) {
		final Edge edge = EdgeImpl.createEdge(nodeAURI, nodeBURI, edgeURI);
		final DynamicEdgeLabel del = createDynamicEdgeLabel(
				createNextDynamicLabelURI(), edge.getURI());
		del.setDecorator(edgeDecorator);
		edge.setLabel(del);
		assert edge.sane();
		return edge;
	} // createDynamicallyLabeledEdge

	/**
	 * @param labelURI
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a DynamicEdgeLabel
	 */
	private static DynamicEdgeLabel createDynamicEdgeLabel(final URI labelURI,
			final URI uriOfIdentifiableToBeLabeled) {
		final TestDynamicEdgeLabel retValue = LabelsFactory.eINSTANCE
				.createTestDynamicEdgeLabel();
		retValue.setURI(labelURI);
		retValue.setURIOfIdentifiableToBeLabeled(uriOfIdentifiableToBeLabeled);

		final TestIntegerLabelValue dynamicLabelCurrentValue = LabelsFactory.eINSTANCE
				.createTestIntegerLabelValue();
		final TestIntegerLabelValue dynamicLabelNextValue = LabelsFactory.eINSTANCE
				.createTestIntegerLabelValue();
		dynamicLabelCurrentValue
				.setI(TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		dynamicLabelNextValue
				.setI(TestIntegerLabelValue.NEXT_LABEL_INTEGER_VALUE);

		retValue.setCurrentValue(dynamicLabelCurrentValue);
		retValue.setNextValue(dynamicLabelNextValue);

		return retValue;
	} // createDynamicEdgeLabel

	/**
	 * @param nodeAURI
	 *            the URI of the A node the edge links to
	 * @param nodeBURI
	 *            the URI of the B node the edge links to
	 * @return a statically labeled edge linking nodes with the two URI's
	 */
	public static Edge createStaticallyLabeledEdge(final URI nodeAURI,
			final URI nodeBURI) {
		return createStaticallyLabeledEdge(createNextEdgeURI(), nodeAURI,
				nodeBURI);
	} // createStaticallyLabeledEdge

	/**
	 * @param edgeURI
	 * @param nodeAURI
	 * @param nodeBURI
	 * @return a statically labeled edge
	 */
	public static Edge createStaticallyLabeledEdge(final URI edgeURI,
			final URI nodeAURI, final URI nodeBURI) {
		return createStaticallyLabeledEdge(edgeURI, nodeAURI, nodeBURI, false);
	} // createStaticallyLabeledEdge

	/**
	 * @param edgeURI
	 * @param nodeAURI
	 * @param nodeBURI
	 * @param directed
	 * @return a statically labeled edge
	 */
	public static Edge createStaticallyLabeledEdge(final URI edgeURI,
			final URI nodeAURI, final URI nodeBURI, final boolean directed) {
		final Edge retValue = EdgeImpl.createEdge(nodeAURI, nodeBURI, directed,
				edgeURI);
		retValue.setLabel(createStaticEdgeLabel(retValue.getURI(), retValue
				.getURI()));
		return retValue;
	} // createStaticallyLabeledEdge

	/**
	 * @param labelURI
	 * @param uriOfIdentifiableToBeLabeled
	 * @return a StaticEdgeLabel
	 */
	private static StaticEdgeLabel createStaticEdgeLabel(final URI labelURI,
			final URI uriOfIdentifiableToBeLabeled) {
		final TestStaticEdgeLabel retValue = LabelsFactory.eINSTANCE
				.createTestStaticEdgeLabel();
		retValue.setURI(labelURI);
		retValue.setURIOfIdentifiableToBeLabeled(uriOfIdentifiableToBeLabeled);

		final TestIntegerLabelValue staticLabelCurrentValue = LabelsFactory.eINSTANCE
				.createTestIntegerLabelValue();
		staticLabelCurrentValue
				.setI(TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		retValue.setCurrentValue(staticLabelCurrentValue);

		assert retValue.sane();
		return retValue;
	} // createStaticEdgeLabel

	/**
	 * @return a unique URI for an edge.
	 */
	private static URI createNextEdgeURI() {
		return STEMURI.createURI("EDGE" + "/" + edgeCounter++);
	}

	/**
	 * @param nodeDecorator
	 *            TODO
	 * @return a dynamically labeled node
	 */
	public static Node createDynamicalyLabeledNode(NodeDecorator nodeDecorator) {
		final Node retValue = GraphFactory.eINSTANCE.createNode();
		retValue.setURI(createNextNodeURI());

		final DynamicNodeLabel dynamicNodeLabel = TestUtil
				.createDynamicNodeLabel(retValue.getURI(), nodeDecorator);

		retValue.getLabels().add(dynamicNodeLabel);

		assert retValue.sane();

		return retValue;
	} // createDynamicalyLabeledNode

	/**
	 * @param nodeURI
	 * @return a dynamically labeled node
	 */
	@SuppressWarnings("unchecked")
	public static Node createStaticallyLabeledNode(final URI nodeURI) {
		final Node retValue = GraphFactory.eINSTANCE.createNode();
		retValue.setURI(nodeURI);
		final StaticNodeLabel staticNodeLabel = TestUtil.createStaticNodeLabel(
				TestUtil.createNextLabelURI(), retValue.getURI());
		retValue.getLabels().add(staticNodeLabel);

		assert retValue.sane();

		return retValue;
	} // createStaticallyLabeledNode

	/**
	 * @return a dynamically labeled node
	 */
	@SuppressWarnings("unchecked")
	public static Node createStaticallyLabeledNode() {
		final Node retValue = GraphFactory.eINSTANCE.createNode();

		retValue.setURI(createNextNodeURI());
		
		final StaticNodeLabel staticNodeLabel = TestUtil.createStaticNodeLabel(
				TestUtil.createNextLabelURI(), retValue.getURI());
		// staticNodeLabel.setNode(retValue);
		retValue.getLabels().add(staticNodeLabel);

		assert retValue.sane();

		return retValue;
	} // createStaticallyLabeledNode

	/**
	 * @return a unique URI for a node.
	 */
	private static URI createNextNodeURI() {
		return STEMURI.createURI("NODE" + "/" + nodeCounter++);
	} // createNextNodeURI

	/**
	 * @param graph
	 */
	@SuppressWarnings("unused")
	private static void refreshDublinCore(final Identifiable identifiable) {
		final DublinCore dc = identifiable.getDublinCore();
		dc.populate();
		dc.setFormat(identifiable.eClass().getEPackage().getNsURI());
		// dc.setSubject("JUnit test output");
	} // refreshDublinCore

} // TestUtil
