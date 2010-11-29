package org.eclipse.stem.diseasemodels.standard.tests;

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

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.definitions.nodes.impl.RegionImpl;
import org.eclipse.stem.diseasemodels.standard.SIRInoculator;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.TestNodeDecorator1;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SIR Inoculator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class SIRInoculatorTest extends SIInfectorTest {

	public static final URI INOCULATOR_URI = STEMURI.createURI("innoculator/testInoculator.decorator");
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SIRInoculatorTest.class);
	}

	/**
	 * Constructs a new SIR Inoculator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRInoculatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SIR Inoculator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SIRInoculator getFixture() {
		return (SIRInoculator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		SIRInoculator innoculator = StandardFactory.eINSTANCE.createSIRInoculator();
		// get test graph from abstract superclass
		Graph g = getTestGraph();
		innoculator.setGraph(g);
		
		// target the innoculator
		innoculator.setTargetISOKey(ISO_TARGET);
		innoculator.setURI(INOCULATOR_URI);
		setFixture(innoculator);
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

} //SIRInoculatorTest
