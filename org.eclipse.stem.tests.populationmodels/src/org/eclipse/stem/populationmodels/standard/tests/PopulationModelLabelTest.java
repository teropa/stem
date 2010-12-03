/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.StandardFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Population Model Label</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PopulationModelLabelTest extends TestCase {

	/**
	 * The fixture for this Population Model Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PopulationModelLabel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PopulationModelLabelTest.class);
	}

	/**
	 * Constructs a new Population Model Label test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationModelLabelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Population Model Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PopulationModelLabel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Population Model Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PopulationModelLabel getFixture() {
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
		setFixture(StandardFactory.eINSTANCE.createPopulationModelLabel());
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

	protected static void labelRegion(final PopulationModelLabel popLabel,
			final Region region) {
		popLabel.setURIOfIdentifiableToBeLabeled(region.getURI());
		region.getLabels().add(popLabel);
	} // labelRegion
	
	public void testPopulationModelLabel() {
		// TODO: Implement test
		assertTrue(true);
	}
} //PopulationModelLabelTest
