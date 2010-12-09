package org.eclipse.stem.tests.automaticexperiment;

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
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.textui.TestRunner;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.stem.analysis.automaticexperiment.ErrorAnalysisAlgorithm;
import org.eclipse.stem.analysis.automaticexperiment.ErrorAnalysisAlgorithmFactory;
import org.eclipse.stem.core.STEMXMIResourceFactoryImpl;
import org.eclipse.stem.core.common.tests.IdentifiableTest;

import automaticexperiment.AutomaticExperiment;

public class AutomaticExperimentTest 
	extends IdentifiableTest {
	
	static final String RUNTIME_WORKSPACE_PATH =  Platform.getLocation().toOSString();
	private final static String REFERENCE_DIR = "./resources/"; //$NON-NLS-1$
	private final static String AUTOMATED_EXPERIMENT_EXAMPLE = "AutomatedExperimentExample";//$NON-NLS-1$
	private final static String sep = File.separator;
	private final static String AUTOMATIC_EXPERIMENT_RUN_TARGET = "/experiments/AutomatedExperiment.automaticexperiment"; //$NON-NLS-1$
	private static File targetDirectory = null;

	
	public static void main(String[] args) {
		TestRunner.run(AutomaticExperimentTest.class);
	}

	public AutomaticExperimentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Experiment test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AutomaticExperiment getFixture() {
		return (AutomaticExperiment)fixture;
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
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	    //// clean up ////
		try {
			assertTrue(TestUtil.removeDirectory(targetDirectory));
		} catch(CoreException ce) {
			ce.printStackTrace();
			fail();
		}	
		/////////////////////
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.experiment.Experiment#updateScenario() <em>Update Scenario</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.experiment.Experiment#updateScenario()
	 * @generated NOT
	 */
	public void testAutomaticExperiment() 
	{
		AutomaticExperiment automaticExperiment = getFixture();
		assertNotNull(automaticExperiment);
		String algorithmName = automaticExperiment.getErrorAnalysisAlgorithm();
		ErrorAnalysisAlgorithm algorithm = 
			ErrorAnalysisAlgorithmFactory.INSTANCE.createErrorAnalysisAlgorithm(algorithmName);
		assertNotNull(algorithm);
		algorithm.init(automaticExperiment, algorithm);
		algorithm.execute();
		assertTrue(true);
	}

	/**
	 * @return an {@link AutomaticExperiment} for testing.
	 */
	public static AutomaticExperiment createFixture() {
		// 1. copy the project folders for the experiment to run 
		//    FROM the source directory TO the runtime workspace where ever that is
		File refDirectory = new File(REFERENCE_DIR);
		if (refDirectory.isDirectory()) {
			// should always be true
			File[] projects = refDirectory.listFiles();
			if(projects==null) fail("Error:AutomatedExperiment projects not found !!");//$NON-NLS-1$
			for (int i = 0; i < projects.length; i ++) {
				if(projects[i].isDirectory()) {
					String runProjectName = RUNTIME_WORKSPACE_PATH+sep+projects[i].getName();
					if(projects[i].getName().equalsIgnoreCase(AUTOMATED_EXPERIMENT_EXAMPLE)) {
						targetDirectory = new File(runProjectName);
						try {
							TestUtil.importProject(projects[i], targetDirectory);
							// 2. there is only one in this test. Integration tests will provide for more.
							
								return loadAutomaticExperiment(runProjectName+AUTOMATIC_EXPERIMENT_RUN_TARGET);
							
						} catch (Exception ioe) {
							System.out.println("Copy failed "+ioe.getMessage());
							ioe.printStackTrace();
							fail("Error:AutomatedExperiment failed to copy test project  !!");//$NON-NLS-1$
						}
					}
				}// if project directory
			}//for
	
		}// if
		// else we faile
		fail("Error:AutomatedExperiment failed to initialize test project  !!");//$NON-NLS-1$
		return null;
	}
	
	static AutomaticExperiment loadAutomaticExperiment(final String filename) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", //$NON-NLS-1$
				STEMXMIResourceFactoryImpl.INSTANCE);
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put("platform", //$NON-NLS-1$
				STEMXMIResourceFactoryImpl.INSTANCE);
		final Resource resource = resourceSet.getResource(URI.createFileURI(filename), true);
		try 
		{			
			resource.load(null);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		AutomaticExperiment toReturn = (AutomaticExperiment)resource.getContents().get(0);
		return toReturn;
	}
}
