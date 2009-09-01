// ExternalDataSourceDiseaseModelTest.java
package org.eclipse.stem.diseasemodels.externaldatasource.tests;

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

import java.io.File;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel;
import org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceFactory;
import org.eclipse.stem.diseasemodels.externaldatasource.impl.ExternalDataSourceDiseaseModelImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalDataSourceDiseaseModelTest extends TestCase {
	
	

	
	private static final String sep = File.separator;
	
	/**
	 * This is the Default folder for Import files.
	 * The User can change this but by default, and for testing,
	 * data will be in sub-folders of the disease model plug-in runtime preferences
	 */
	private static final String TEST_SUBDIR = "testing";
	
	/**
	 * This is a test scenario name.
	 */
	// private static final String TEST_SCENARIO = "testscenario";
	
	/**
	 * This is a test location name.
	*/
	private static final String TEST_LOCATION = "testlocation";
	
	/**
	 * The fixture for this Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalDataSourceDiseaseModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExternalDataSourceDiseaseModelTest.class);
	}
	
	/**
	 * Test the logging
	 * @generated NOT
	 */
	public void testLogging() {
		// test the construction

		ExternalDataSourceDiseaseModelImpl externalDataSourceDiseaseModel = new ExternalDataSourceDiseaseModelImpl();
		
		// test the logging
		doTest();
	}
	
	/**
	 * Test the logging (not complete yet)
	 * @generated NOT
	 */
	public void doTest() {
		
		final String dir = ExternalDataSourceDiseaseModel.DEFAULT_DIR+TEST_SUBDIR+sep;
		
		try {
			File file = new File(dir);
			if(!file.exists()) {
				 boolean success = (new File(dir)).mkdirs();
			}
			
		} catch(Exception e) {
			Activator.logError("Error creating Directory ["+dir+"] for JUNIT testing", e);
		}
	
	}
	

	/**
	 * Constructs a new Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalDataSourceDiseaseModelTest(String name) {
		super(name);
	}
	

	/**
	 * Constructs a new Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExternalDataSourceDiseaseModelTest() {
		super("test");
	}

	/**
	 * Sets the fixture for this Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ExternalDataSourceDiseaseModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalDataSourceDiseaseModel getFixture() {
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
		setFixture(ExternalDataSourceFactory.eINSTANCE.createExternalDataSourceDiseaseModel());
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

} //ExternalDataSourceDiseaseModelTest
