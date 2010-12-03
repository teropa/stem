/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.tests;

import junit.textui.TestRunner;

import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.YetiPopulationInitializer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Yeti Population Initializer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class YetiPopulationInitializerTest extends EarthSciencePopulationInitializerTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(YetiPopulationInitializerTest.class);
	}

	/**
	 * Constructs a new Yeti Population Initializer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YetiPopulationInitializerTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Yeti Population Initializer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected YetiPopulationInitializer getFixture() {
		YetiPopulationInitializer retValue = StandardFactory.eINSTANCE.createYetiPopulationInitializer();
		return retValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(StandardFactory.eINSTANCE.createYetiPopulationInitializer());
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

	
	public void testInitializeRegion() {
		// TODO: Implement test
		assertTrue(true);
	}
} //YetiPopulationInitializerTest
