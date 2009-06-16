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
import org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue;
import org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelValueImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Migration Edge Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated NOT
 */
@SuppressWarnings("all")
public class MigrationEdgeLabelValueTest extends LabelValueTest {
	/**Migration rates to use in the tests*/
	static final double MIGRATION_RATE = 0.5;
	
	/**
	 * The fixture for this Migration Edge Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MigrationEdgeLabelValue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MigrationEdgeLabelValueTest.class);
	}

	/**
	 * Constructs a new Migration Edge Label Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationEdgeLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Migration Edge Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MigrationEdgeLabelValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Migration Edge Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MigrationEdgeLabelValue getFixture() {
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
		setFixture(EdgesFactory.eINSTANCE.createMigrationEdgeLabelValue());
	}
	

	/**
	 * Make sure the fixture makes sense.
	 */
	public void testFixture() {
		final MigrationEdgeLabelValue migrationLabelValue = getFixture();
		assertNotNull(migrationLabelValue);
		assertTrue(((MigrationEdgeLabelValueImpl) migrationLabelValue).sane());
		
		/*Make sure we can set the value*/
		migrationLabelValue.setMigrationRate(MIGRATION_RATE);
		assertTrue(migrationLabelValue.getMigrationRate()==MIGRATION_RATE);
		
	} // testFixture

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
	 * Make sure reset reverts the label value to its default
	 */
	@Override
	public void testReset() {
		MigrationEdgeLabelValue migrationLabelValue = getFixture();
		double oldValue = migrationLabelValue.getMigrationRate();
		migrationLabelValue.setMigrationRate(MIGRATION_RATE);
		assertFalse(migrationLabelValue.getMigrationRate()==oldValue);
		migrationLabelValue.reset();
		assertTrue(migrationLabelValue.getMigrationRate()==oldValue);
		
	}

} //MigrationEdgeLabelValueTest
