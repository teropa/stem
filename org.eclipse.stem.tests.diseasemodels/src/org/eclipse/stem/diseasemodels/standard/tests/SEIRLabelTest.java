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
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.TestNodeDecorator1;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>SEIR Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getCurrentSEIRValue() <em>Current SEIR Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getNextSEIRValue() <em>Next SEIR Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class SEIRLabelTest extends SIRLabelTest {
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SEIRLabelTest.class);
	}

	/**
	 * Constructs a new SEIR Label test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SEIR Label test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SEIRLabel getFixture() {
		return (SEIRLabel)fixture;
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
	 * @return an SEIRLabel instance
	 */
	public static SEIRLabel createFixture() {
		final SEIRLabel retValue = StandardFactory.eINSTANCE.createSEIRLabel();
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
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getCurrentSEIRValue() <em>Current SEIR Value</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getCurrentSEIRValue()
	 * @generated NOT
	 */
	public void testGetCurrentSEIRValue() {
		final SEIRLabel seirLabel = getFixture();
		final SEIRLabelValue value = seirLabel.getCurrentSEIRValue();
		assertNotNull(value);
	} // testGetCurrentSEIRValue

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getNextSEIRValue() <em>Next SEIR Value</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getNextSEIRValue()
	 * @generated NOT
	 */
	public void testGetNextSEIRValue() {
		final SEIRLabel seirLabel = getFixture();
		final SEIRLabelValue value = seirLabel.getNextSEIRValue();
		assertNotNull(value);
	} // testGetNextSEIRValue

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#setE(double)
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getE()
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#setNextE(double)
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getNextE()
	 */
	public void testSetGetCurrentNextSEIRLabelE() {
		final SEIRLabel seirLabel = getFixture();
		assertTrue(seirLabel.getE() == 0.0);
		assertTrue(seirLabel.getNextE() == 0.0);
		seirLabel.setE(SEIRLabelValueTest.TEST_E);
		seirLabel.setNextE(SEIRLabelValueTest.TEMP_TEST_E);
		assertTrue(seirLabel.getE() == SEIRLabelValueTest.TEST_E);
		assertTrue(seirLabel.getNextE() == SEIRLabelValueTest.TEMP_TEST_E);
		seirLabel.setNextValueValid(true);
		seirLabel.switchToNextValue();
		assertTrue(seirLabel.getE() == SEIRLabelValueTest.TEMP_TEST_E);
		assertTrue(seirLabel.getNextE() == SEIRLabelValueTest.TEST_E);
	} // testSetGetCurrentNextSEIRLabelE

	/**
	 * test that the fixture is sane
	 */
	public void testFixtureSanity() {
		final SEIRLabel seirLabel = getFixture();
		assertTrue(seirLabel.sane());
	} // testFixtureSanity

} // SEIRLabelTest
