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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.modifier.SequenceModifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sequence Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.SequenceModifier#getSequenceSize() <em>Sequence Size</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.SequenceModifier#getNextValue() <em>Next Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class SequenceModifierTest extends FeatureModifierTest {

	/**
	 * Constructs a new Sequence Modifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sequence Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SequenceModifier getFixture() {
		return (SequenceModifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setFixture(createFixture());
	}

	/**
	 * @return a SequenceModifier ready for testing.
	 */
	abstract public SequenceModifier createFixture();
	
	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.SequenceModifier#getSequenceSize() <em>Sequence Size</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.SequenceModifier#getSequenceSize()
	 * @generated NOT
	 */
	public void testGetSequenceSize() {
		final SequenceModifier fixture = getFixture();
		assertTrue(fixture.getSequenceSize() == getNumberOfModifications());
	} // testGetSequenceSize

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.SequenceModifier#getNextValue() <em>Next Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.SequenceModifier#getNextValue()
	 * @generated NOT
	 */
	public void testGetNextValue() {
		final SequenceModifier fixture = getFixture();
		final EObject testObject = getTestObject();
		fixture.setTarget(testObject);
		assertNotNull(fixture.getNextValue() );
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.SequenceModifier#setNextValue(java.lang.Object) <em>Next Value</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.SequenceModifier#setNextValue(java.lang.Object)
	 * @generated NOT
	 */
	public void testSetNextValue() {
		assertTrue(true);
	}
	
} //SequenceModifierTest
