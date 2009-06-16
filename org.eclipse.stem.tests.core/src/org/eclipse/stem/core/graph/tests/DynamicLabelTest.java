package org.eclipse.stem.core.graph.tests;

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

import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.tests.util.TestUtil;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Dynamic Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.DynamicLabel#reset() <em>Reset</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.DynamicLabel#switchToNextValue() <em>Switch To Next Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public abstract class DynamicLabelTest extends LabelTest {

	/**
	 * Constructs a new Dynamic Label test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicLabelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Dynamic Label test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DynamicLabel getFixture() {
		return (DynamicLabel)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());
	} // setUp

	/**
	 * Tests the '{@link org.eclipse.stem.core.graph.DynamicLabel#reset() <em>Reset</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.DynamicLabel#reset()
	 * @generated NOT
	 */
	public void testReset() {
		final DynamicLabel dynamicLabel = getFixture();
		assertFalse(dynamicLabel.isNextValueValid());
		dynamicLabel.setNextValueValid(true);
		dynamicLabel.reset();
		assertFalse(dynamicLabel.isNextValueValid());
	} // testReset

	/**
	 * @return a DynamicLabel
	 */
	public DynamicLabel createFixture() {
		return TestUtil.createDynamicLabel(TestUtil
				.createNextIdentifiableToLabelURI());
	} // createFixture

	/**
	 * Test the sanity of the fixture
	 */
	public void testSane() {
		final DynamicLabel dynamicLabel = getFixture();
		assertTrue(dynamicLabel.sane());
	} // testSane

	/**
	 * Tests the '{@link org.eclipse.stem.core.graph.DynamicLabel#switchToNextValue() <em>Switch To Next Value</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.graph.DynamicLabel#switchToNextValue()
	 * @generated NOT
	 */
	public void testSwitchToNextValue() {
		final DynamicLabel dynamicLabel = getFixture();
		final LabelValue oldCurrentValue = dynamicLabel.getCurrentValue();
		final LabelValue oldNextValue = dynamicLabel.getNextValue();

		assertTrue(oldCurrentValue != oldNextValue);
		assertTrue(dynamicLabel.getCurrentValue() == oldCurrentValue);
		assertTrue(dynamicLabel.getNextValue() == oldNextValue);

		assertFalse(dynamicLabel.isNextValueValid());
		dynamicLabel.setNextValueValid(true);
		assertTrue(dynamicLabel.isNextValueValid());

		// Here's the big S W I T C H!
		dynamicLabel.switchToNextValue();

		assertFalse(dynamicLabel.isNextValueValid());

		assertFalse(dynamicLabel.getCurrentValue() == oldCurrentValue);
		assertFalse(dynamicLabel.getNextValue() == oldNextValue);
		assertTrue(dynamicLabel.getCurrentValue() == oldNextValue);
		assertTrue(dynamicLabel.getNextValue() == oldCurrentValue);

	} // testSwitchToNextValue

	/**
	 * Test the Dynamic Label has the right type URI.
	 * 
	 * @generated NOT
	 */
	public void testGetTypeURI() {
		final Label label = getFixture();
		assertTrue(label.getTypeURI().equals(
				DynamicLabel.URI_TYPE_DYNAMIC_LABEL));
	} // testGetTypeURI

} // DynamicLabelTest
