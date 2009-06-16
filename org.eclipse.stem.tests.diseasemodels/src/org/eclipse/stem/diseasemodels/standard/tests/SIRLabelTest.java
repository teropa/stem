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

import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.TestNodeDecorator1;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>SIR Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getCurrentSIRValue() <em>Current SIR Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getNextSIRValue() <em>Next SIR Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class SIRLabelTest extends SILabelTest {
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SIRLabelTest.class);
	}

	/**
	 * Constructs a new SIR Label test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SIR Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SIRLabel getFixture() {
		return (SIRLabel)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
	} // setUp

	/**
	 * @return an SIRLabel instance
	 */
	public static SIRLabel createFixture() {
		final SIRLabel retValue = StandardFactory.eINSTANCE.createSIRLabel();
		final Region node = DiseaseModelTestUtil
				.createPopulationRegionNode(DiseaseModelTestUtil.TEST_POPULATION_IDENTIFIER);

		final TestNodeDecorator1 tnd = DecoratorsFactory.eINSTANCE
				.createTestNodeDecorator1();
		retValue.setDecorator(tnd);
		DiseaseModelLabelTest.labelRegion(retValue,
				DiseaseModelTestUtil.TEST_POPULATION_IDENTIFIER, node);
		return retValue;
	} // createFixture

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getCurrentSIRValue() <em>Current SIR Value</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getCurrentSIRValue()
	 * @generated NOT
	 */
	public void testGetCurrentSIRValue() {
		final SIRLabel sirLabel = getFixture();
		final SIRLabelValue value = sirLabel.getCurrentSIRValue();
		assertNotNull(value);
	} // testGetCurrentSIRValue

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getNextSIRValue() <em>Next SIR Value</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getNextSIRValue()
	 * @generated NOT
	 */
	public void testGetNextSIRValue() {
		final SIRLabel sirLabel = getFixture();
		final SIRLabelValue value = sirLabel.getNextSIRValue();
		assertNotNull(value);
	} // testGetNextSIRValue

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#setR(double)
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getR()
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#setNextR(double)
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getNextR()
	 */
	public void testSetGetCurrentNextSIRLabelR() {
		final SIRLabel sirLabel = getFixture();
		assertTrue(sirLabel.getR() == 0.0);
		assertTrue(sirLabel.getNextR() == 0.0);
		sirLabel.setR(SIRLabelValueTest.TEST_R);
		sirLabel.setNextR(SIRLabelValueTest.TEMP_TEST_R);
		assertTrue(sirLabel.getR() == SIRLabelValueTest.TEST_R);
		assertTrue(sirLabel.getNextR() == SIRLabelValueTest.TEMP_TEST_R);
		sirLabel.setNextValueValid(true);
		sirLabel.switchToNextValue();
		assertTrue(sirLabel.getR() == SIRLabelValueTest.TEMP_TEST_R);
		assertTrue(sirLabel.getNextR() == SIRLabelValueTest.TEST_R);
	} // testSetGetCurrentNextSIRLabelR

	/**
	 * test that the fixture is sane
	 */
	public void testFixtureSane() {
		final SIRLabel sirLabel = getFixture();
		assertTrue(sirLabel.sane());
	} // testFixtureSane

} // SIRLabelTest
