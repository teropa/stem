/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.modifier.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.stem.core.modifier.LongModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Long Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LongModifierTest extends SingleValueModifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LongModifierTest.class);
	}

	/**
	 * Constructs a new Long Modifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Long Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LongModifier getFixture() {
		return (LongModifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModifierFactory.eINSTANCE.createLongModifier());
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

	@Override
	int getNumberOfModifications() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected EClassifier getTestAttributeEType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean validateFeatureValue(int i) {
		// TODO Auto-generated method stub
		return false;
	}

} //LongModifierTest
