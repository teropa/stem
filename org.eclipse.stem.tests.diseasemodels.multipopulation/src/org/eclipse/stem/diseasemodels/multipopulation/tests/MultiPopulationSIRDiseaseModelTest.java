/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.multipopulation.tests;

import junit.textui.TestRunner;

import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Multi Population SIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiPopulationSIRDiseaseModelTest extends MultiPopulationSIDiseaseModelTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MultiPopulationSIRDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Multi Population SIR Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiPopulationSIRDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Multi Population SIR Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MultiPopulationSIRDiseaseModel getFixture() {
		return (MultiPopulationSIRDiseaseModel)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MultipopulationFactory.eINSTANCE.createMultiPopulationSIRDiseaseModel());
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

} //MultiPopulationSIRDiseaseModelTest
