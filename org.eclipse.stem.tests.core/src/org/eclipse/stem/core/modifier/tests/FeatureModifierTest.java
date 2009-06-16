package org.eclipse.stem.core.modifier.tests;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.Arrays;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.SanityChecker;
import org.eclipse.stem.core.modifier.FeatureModifier;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Feature Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.FeatureModifier#isComplete() <em>Complete</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.FeatureModifier#updateFeature() <em>Update Feature</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.FeatureModifier#reset() <em>Reset</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class FeatureModifierTest extends TestCase {

	public static final String STRUCTURAL_FEATURE_NAME = "attribute";

	/**
	 * The fixture for this Feature Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureModifier fixture = null;

	/**
	 * The object to be modified.
	 */
	protected EObject testObject = null;

	/**
	 * Constructs a new Feature Modifier test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureModifierTest(String name) {
		super(name);
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testObject = createTestObject();
	}

	/**
	 * Sets the fixture for this Feature Modifier test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(FeatureModifier fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Feature Modifier test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FeatureModifier getFixture() {
		return fixture;
	}

	protected EObject getTestObject() {
		return testObject;
	} // getTestObject

	/**
	 * Test that the fixture is "sane"
	 * 
	 * @see SanityChecker
	 */
	public void testFixtureSanity() {
		final SanityChecker fixture = getFixture();
		assertTrue(fixture.sane());
	} // testFixtureSanity

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.FeatureModifier#getModificationSummary() <em>Modification Summary</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#getModificationSummary()
	 * @generated NOT
	 */
	public void testGetModificationSummary() {
		final FeatureModifier fixture = getFixture();
		final EObject testObject = getTestObject();
		fixture.setTarget(testObject);
		
		final int numberOfModifications = getNumberOfModifications();
		for (int i = 0; i < numberOfModifications; i++) {
			assertFalse(fixture.isComplete());
			fixture.updateFeature();
			final String temp = fixture.getModificationSummary();
			assertNotNull(temp);
			assertFalse(temp.equals(""));
		} // for i
		assertTrue(fixture.isComplete());

	} // testGetModificationSummary

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.FeatureModifier#isComplete() <em>Complete</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#isComplete()
	 * @generated NOT
	 */
	public void testIsComplete() {
		final FeatureModifier fixture = getFixture();
		final EObject testObject = getTestObject();
		fixture.setTarget(testObject);

		final int numberOfModifications = getNumberOfModifications();
		for (int i = 0; i < numberOfModifications; i++) {
			assertFalse(fixture.isComplete());
			fixture.updateFeature();
		} // for i
		assertTrue(fixture.isComplete());
	} // testIsComplete

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.FeatureModifier#updateFeature() <em>Update Feature</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#updateFeature()
	 * @generated NOT
	 */
	public void testUpdateFeature() {
		final FeatureModifier fixture = getFixture();
		final EObject testObject = getTestObject();
		fixture.setTarget(testObject);

		final int numberOfModifications = getNumberOfModifications();
		for (int i = 0; i < numberOfModifications; i++) {
			assertFalse(fixture.isComplete());
			fixture.updateFeature();
			assertTrue(validateFeatureValue(i));
		} // for i
		assertTrue(fixture.isComplete());
	} // testUpdateFeature

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.FeatureModifier#reset() <em>Reset</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#reset()
	 * @generated NOT
	 */
	public void testReset() {
		final FeatureModifier fixture = getFixture();
		final EObject testObject = getTestObject();
		fixture.setTarget(testObject);
		// TODO implement FeatureModifierTest.testReset()
		assertTrue(true);
	} // testReset

	/**
	 * @return an {@link EObject} to be modified
	 */
	protected EObject createTestObject() {
		return ModifierTest.createTestObject("TestClass", Arrays
				.asList(getTestAttributeEType()));
	} // createTestObject

	/**
	 * @return the {@link EClassifier} of that is the type of the attribute in
	 *         the test object.
	 */
	abstract protected EClassifier getTestAttributeEType();

	/**
	 * @return the number of modifications the {@link FeatureModifier} will make
	 *         to the test object.
	 */
	abstract int getNumberOfModifications();

	/**
	 * @param i
	 * @return <code>true</code> if the feature value matches the i'th
	 *         expected value.
	 */
	abstract protected boolean validateFeatureValue(int i);

} // FeatureModifierTest
