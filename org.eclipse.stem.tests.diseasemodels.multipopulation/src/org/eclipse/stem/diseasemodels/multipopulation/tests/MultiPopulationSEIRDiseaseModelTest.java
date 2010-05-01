/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.multipopulation.tests;

import junit.textui.TestRunner;

import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Multi Population SEIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiPopulationSEIRDiseaseModelTest extends MultiPopulationSIRDiseaseModelTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MultiPopulationSEIRDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Multi Population SEIR Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiPopulationSEIRDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Multi Population SEIR Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MultiPopulationSEIRDiseaseModel getFixture() {
		return (MultiPopulationSEIRDiseaseModel)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MultipopulationFactory.eINSTANCE.createMultiPopulationSEIRDiseaseModel());
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

} //MultiPopulationSEIRDiseaseModelTest
