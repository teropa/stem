package org.eclipse.stem.core.graph.tests;

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

import java.util.Map;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.NodeLabel;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>URI To Node Label Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class URIToNodeLabelMapEntryTest extends TestCase {

	/**
	 * The fixture for this URI To Node Label Map Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<URI, NodeLabel> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(URIToNodeLabelMapEntryTest.class);
	}

	/**
	 * Constructs a new URI To Node Label Map Entry test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URIToNodeLabelMapEntryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this URI To Node Label Map Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<URI, NodeLabel> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this URI To Node Label Map Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<URI, NodeLabel> getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void setUp() throws Exception {
		setFixture((Map.Entry<URI, NodeLabel>)GraphFactory.eINSTANCE.create(GraphPackage.Literals.URI_TO_NODE_LABEL_MAP_ENTRY));
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
	 * Keeps JUnit quiet
	 */
	public void testNothing() {
		assertTrue(true);
	} // testNothing
} //URIToNodeLabelMapEntryTest
