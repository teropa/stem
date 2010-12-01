/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.tests;

import junit.textui.TestRunner;

import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Stochastic Standard Population Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StochasticStandardPopulationModelTest extends StandardPopulationModelTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StochasticStandardPopulationModelTest.class);
	}

	/**
	 * Constructs a new Stochastic Standard Population Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticStandardPopulationModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Stochastic Standard Population Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StochasticStandardPopulationModel getFixture() {
		return (StochasticStandardPopulationModel)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(StandardFactory.eINSTANCE.createStochasticStandardPopulationModel());
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

} //StochasticStandardPopulationModelTest
