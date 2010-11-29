/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.standard.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.stem.diseasemodels.standard.InfectorInoculatorCollection;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Infector Inoculator Collection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfectorInoculatorCollectionTest extends TestCase {

	/**
	 * The fixture for this Infector Inoculator Collection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfectorInoculatorCollection fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InfectorInoculatorCollectionTest.class);
	}

	/**
	 * Constructs a new Infector Inoculator Collection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfectorInoculatorCollectionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Infector Inoculator Collection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(InfectorInoculatorCollection fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Infector Inoculator Collection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfectorInoculatorCollection getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(StandardFactory.eINSTANCE.createInfectorInoculatorCollection());
	}
	
	/**
	 * TODO: Implement this method. This should be done as part of a larger Scenario integration test.
	 * InfectorInnoculatorCollections are read from a user defined File
	 */
	public void testCreateInfectorInnoculatorCollectionFromFile() {
		assertTrue(true);
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

} //InfectorInoculatorCollectionTest
