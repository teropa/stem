package org.eclipse.stem.core.model.tests;

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

//import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#decorateGraph(org.eclipse.stem.core.model.STEMTime) <em>Decorate Graph</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long, int) <em>Update Labels</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#resetLabels() <em>Reset Labels</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#getLabelsToUpdate(int, int) <em>Get Labels To Update</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.Decorator#prepare(org.eclipse.stem.core.model.Model, org.eclipse.stem.core.model.STEMTime) <em>Prepare</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class DecoratorTest extends IdentifiableTest {
	
	public static URI DECORATOR_URI = STEMURI.createURI("decorator/decoratorTest.decorator");
	
	private static final String GRAPH = "graph";
	private static final URI CANONICAL_GRAPH_URI = STEMURI.createURI(GRAPH	+ "/" + "canonicalGraph");
	private static final String MODEL = "model";
	
	public static final URI GRAPH0_URI = STEMURI.createURI(GRAPH + "/" + "g0");
	public static final URI MODEL0_URI = STEMURI.createURI(MODEL + "/" + "m0");
	public static final URI MODEL1_URI = STEMURI.createURI(MODEL + "/" + "m1");
	public static final URI MODEL2_URI = STEMURI.createURI(MODEL + "/" + "m2");
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DecoratorTest.class);
	}

	/**
	 * Constructs a new Decorator test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DecoratorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Decorator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Decorator getFixture() {
		return (Decorator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		final Decorator d = ModelFactory.eINSTANCE.createDecorator();
		d.setURI(DECORATOR_URI);
		setFixture(d);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#decorateGraph(org.eclipse.stem.core.model.STEMTime) <em>Decorate Graph</em>}' operation.
	 * <!-- begin-user-doc -->
	 * Much testing of decorators is also done in 
	 * @see org.eclipse.stem.core.graph.tests.GraphTest.populateGraph()
	 * and 
	 * @see org.eclipse.stem.core.graph.tests.ModelTest.getFixture()
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#decorateGraph(org.eclipse.stem.core.model.STEMTime)
	 * @generated NOT
	 */
	public void testDecorateGraph__STEMTime() {
		// TODO this is the most basic of tests. What other tests would be generally useful for DecorateGraph?
		final Decorator dec = getFixture();
		STEMTime now = ModelFactory.eINSTANCE.createSTEMTime();
		final Graph graph = GraphFactory.eINSTANCE.createGraph();
		final DublinCore dc1 = graph.getDublinCore();
		//final Node node = TestUtil.createStaticallyLabeledNode();
		//graph.putNode(node);
		EList<Decorator>  allDecorators = graph.getDecorators();
		int startSize = allDecorators.size();
		allDecorators.add(dec);
		// This method is not implemented in the abstract... depends on the particular decorator
		//dec.decorateGraph(now);
		int finishSize = graph.getDecorators().size();
		assert(finishSize-startSize==1);
	}
	
	/**
	 * @param uri
	 *            the uri to use for the newly created graph
	 * @return a new graph instance
	 * @generated NOT
	 */
	private static Graph createGraph(URI uri) {
		final Graph retValue = GraphFactory.eINSTANCE.createGraph();
		retValue.setURI(uri);
		return retValue;
	} // createGraph

	
	/**
	 * @param uri
	 *            the uri to use for the newly created model
	 * @return a new model instance
	 * @generated NOT
	 */
	private static Model createModel(URI uri) {
		final Model retValue = ModelFactory.eINSTANCE.createModel();
		retValue.setURI(uri);
		return retValue;
	} // createModel


	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long, int) <em>Update Labels</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long, int)
	 * @generated NOT
	 */
	public void testUpdateLabels__STEMTime_long_int() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long) <em>Update Labels</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long)
	 * @generated NOT
	 */
	public void testUpdateLabels__STEMTime_long() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#resetLabels() <em>Reset Labels</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#resetLabels()
	 * @generated NOT
	 */
	public void testResetLabels() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#getLabelsToUpdate(int, int) <em>Get Labels To Update</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#getLabelsToUpdate(int, int)
	 * @generated NOT
	 */
	public void testGetLabelsToUpdate__int_int() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.model.Decorator#prepare(org.eclipse.stem.core.model.Model, org.eclipse.stem.core.model.STEMTime) <em>Prepare</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.Decorator#prepare(org.eclipse.stem.core.model.Model, org.eclipse.stem.core.model.STEMTime)
	 * @generated NOT
	 */
	public void testPrepare__Model_STEMTime() {
		
		Model m0 = createModel(MODEL0_URI);
		DublinCore dc0 = m0.getDublinCore();
		dc0.setTitle(MODEL+"0");
		Model m1 = createModel(MODEL1_URI);
		DublinCore dc1 = m1.getDublinCore();
		dc1.setTitle(MODEL+"1");
		Model m2 = createModel(MODEL2_URI);
		DublinCore dc2 = m2.getDublinCore();
		dc2.setTitle(MODEL+"2");
		
		
		// Graph G0
		final Graph g0 = createGraph(GRAPH0_URI);
		g0.getDublinCore().setTitle("g0");
		


		// *** Model M0 ***
		m0.getGraphs().add(g0);
		
		// *** Model M1 ***
		m1.getModels().add(m0);
		
		// *** Model M2 ***
		m2.getModels().add(m1);

		assertTrue(m2.sane());

	}

} // DecoratorTest
