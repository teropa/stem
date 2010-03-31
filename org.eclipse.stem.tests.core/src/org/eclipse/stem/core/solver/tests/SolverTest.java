package org.eclipse.stem.core.solver.tests;

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

import junit.textui.TestRunner;

import org.eclipse.stem.core.common.tests.IdentifiableTest;

import org.eclipse.stem.core.solver.Solver;
import org.eclipse.stem.core.solver.SolverFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Solver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.solver.Solver#step(org.eclipse.stem.core.model.STEMTime, long, int) <em>Step</em>}</li>
 *   <li>{@link org.eclipse.stem.core.solver.Solver#reset() <em>Reset</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SolverTest extends IdentifiableTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SolverTest.class);
	}

	/**
	 * Constructs a new Solver test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Solver test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Solver getFixture() {
		return (Solver)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SolverFactory.eINSTANCE.createSolver());
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
	 * Tests the '{@link org.eclipse.stem.core.solver.Solver#step(org.eclipse.stem.core.model.STEMTime, long, int) <em>Step</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.solver.Solver#step(org.eclipse.stem.core.model.STEMTime, long, int)
	 * @generated
	 */
	public void testStep__STEMTime_long_int() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.solver.Solver#reset() <em>Reset</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.solver.Solver#reset()
	 * @generated
	 */
	public void testReset() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //SolverTest
