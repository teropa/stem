/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.graphgenerator.tests;

import junit.textui.TestRunner;

import org.eclipse.stem.core.graphgenerator.GraphgeneratorFactory;
import org.eclipse.stem.core.graphgenerator.SquareGraphLatticeGenerator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Square Graph Lattice Generator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SquareGraphLatticeGeneratorTest extends LatticeGraphGeneratorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SquareGraphLatticeGeneratorTest.class);
	}

	/**
	 * Constructs a new Square Graph Lattice Generator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SquareGraphLatticeGeneratorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Square Graph Lattice Generator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SquareGraphLatticeGenerator getFixture() {
		return (SquareGraphLatticeGenerator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GraphgeneratorFactory.eINSTANCE.createSquareGraphLatticeGenerator());
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

} //SquareGraphLatticeGeneratorTest
