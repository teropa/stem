package org.eclipse.stem.definitions.edges.tests;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import junit.textui.TestRunner;

import org.eclipse.stem.core.graph.tests.LabelValueTest;
import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.edges.MixingEdgeLabelValue;
import org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelValueImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mixing Edge Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated NOT
 */
@SuppressWarnings("all")
public class MixingEdgeLabelValueTest extends LabelValueTest {

	static double MIXING_RATE = .001;
	
	/**
	 * The fixture for this Mixing Edge Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MixingEdgeLabelValue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MixingEdgeLabelValueTest.class);
	}

	/**
	 * Constructs a new Mixing Edge Label Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MixingEdgeLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Mixing Edge Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MixingEdgeLabelValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Mixing Edge Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MixingEdgeLabelValue getFixture() {
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
		setFixture(EdgesFactory.eINSTANCE.createMixingEdgeLabelValue());
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
	 * Make sure the fixture makes sense.
	 */
	public void testFixture() {
		final MixingEdgeLabelValue mixingLabelValue = getFixture();
		assertNotNull(mixingLabelValue);
		assertTrue(((MixingEdgeLabelValueImpl) mixingLabelValue).sane());
		
		/*Make sure we can set the value*/
		mixingLabelValue.setMixingRate(MIXING_RATE);
		assertTrue(mixingLabelValue.getMixingRate()==MIXING_RATE);
		
	} // testFixture
	
	/**
	 * Make sure reset reverts the label value to its default
	 */
	@Override
	public void testReset() {
		MixingEdgeLabelValue mixingLabelValue = getFixture();
		double oldValue = mixingLabelValue.getMixingRate();
		mixingLabelValue.setMixingRate(MIXING_RATE);
		assertFalse(mixingLabelValue.getMixingRate()==oldValue);
		mixingLabelValue.reset();
		assertTrue(mixingLabelValue.getMixingRate()==oldValue);
		
	}

} //MixingEdgeLabelValueTest
