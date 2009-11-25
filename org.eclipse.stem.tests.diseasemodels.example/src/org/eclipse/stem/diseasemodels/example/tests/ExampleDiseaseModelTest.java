package org.eclipse.stem.diseasemodels.example.tests;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.Random;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.diseasemodels.example.ExampleDiseaseModel;
import org.eclipse.stem.diseasemodels.example.ExampleFactory;
import org.eclipse.stem.diseasemodels.example.impl.ExampleDiseaseModelImpl;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl;



/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Example Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExampleDiseaseModelTest extends TestCase {

	public static final long RANDOM_SEED = 1l;
	public static final double TEST_GAIN = 0.01d;
	
	
	/**
	 * The fixture for this Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExampleDiseaseModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExampleDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExampleDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments() <em>doModelSpecificAdjustments</em>}' operation.
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments()
	 * @generated NOT
	 */
	@SuppressWarnings("synthetic-access")
	public void testModelSpecificAdjustments(){
		ExampleDiseaseModelTesterImpl experimentalDiseaseModel = new ExampleDiseaseModelTesterImpl();
		SEIRLabelValueImpl currentSEIR = new SEIRLabelValueImpl(1000d, 50d, 40d, 30d, 20d, 10d);
		doTest(experimentalDiseaseModel, currentSEIR);
	}
	
	
	/**
	 * Do the test
	 * @param experimentalDiseaseModel
	 * @param currentSEIR
	 * @param seirAdditions
	 * @param seirDeaths
	 * @generated NOT
	 */
	private void doTest(ExampleDiseaseModelTesterImpl experimentalDiseaseModel,
			SEIRLabelValueImpl currentSEIR) {
		
		SEIRLabelValueImpl oldVal = (SEIRLabelValueImpl)EcoreUtil.copy(currentSEIR);
		
		doCalculateModelSpecificAdjustments(currentSEIR, RANDOM_SEED, TEST_GAIN);

		String state = getState(currentSEIR, oldVal);
		
		validateModelSpecificAdjustments(currentSEIR,
				oldVal,
				state);
	}
	

	private void doCalculateModelSpecificAdjustments(
			SEIRLabelValueImpl pCurrentSEIR,
			long pRandomSeed, double pTestGain) {
		
		
		final SEIRLabelValue currentSEIR = pCurrentSEIR;
		Random random = new Random(pRandomSeed);
		double Inoisy = currentSEIR.getI()* computeNoise(pTestGain, random);
		currentSEIR.setI(Inoisy);
		return;
				
				
	}

	private void validateModelSpecificAdjustments(SEIRLabelValueImpl currentSEIR,
			SEIRLabelValueImpl oldSEIR,
			String state) {
		
		try{
			currentSEIR.sane();
		}
		catch(Throwable t){
			throw new IllegalStateException("newSeirAdditions is insane, state is: " + state, t);
		}
		try{
			oldSEIR.sane();
		}
		catch(Throwable t){
			throw new IllegalStateException("newSeirDeaths is insane, state is: " + state, t);
		}

		
		
		assertTrue(String.format("currentSEIR has insane values %s", state), mySanityCheck(currentSEIR));
		assertTrue(String.format("oldSEIR has insane values %s", state), mySanityCheck(oldSEIR));

	}
	
	private boolean checkEqual(SEIRLabelValueImpl pCalculatedSeirAdditions,
			SEIRLabelValueImpl pNewSeirAdditions) {
		if((pCalculatedSeirAdditions.getDiseaseDeaths() != pNewSeirAdditions.getDiseaseDeaths()) ||
				(pCalculatedSeirAdditions.getE() != pNewSeirAdditions.getE()) ||
				(pCalculatedSeirAdditions.getI() != pNewSeirAdditions.getI()) ||
				(pCalculatedSeirAdditions.getPopulationCount() != pNewSeirAdditions.getPopulationCount()) ||
				(pCalculatedSeirAdditions.getR() != pNewSeirAdditions.getR()) ||
				(pCalculatedSeirAdditions.getS() != pNewSeirAdditions.getS())){
					return false;
				}
		return true;
	}

	private boolean mySanityCheck(SEIRLabelValueImpl pSeir) {
		return assertValidDouble(pSeir.getE()) && 
			assertValidDouble(pSeir.getI()) && 
			assertValidDouble(pSeir.getR()) && 
			assertValidDouble(pSeir.getS());
		
	}
	

	/**
	 * This method returns a double precision random noise variable
	 * r between (1.0+x) and (1.0-x)
	 * where x is a product G* Math.rand(), and G is a gain factor 0<G<max noise
	 * 
	 * @param gain
	 * @param rand
	 * @return noise
	 */
	public static double computeNoise(final double gain, final Random rand) {

		double x = (2.0*rand.nextDouble())-1.0; // +/- 1
		x *= gain;
		x += 1.0;
		assert ((x>0.0)&&(x<2.0)) : "random noise should be a small perturbation Gain factor, g,  must 0.0 < g << 1.0 ";
		return x;
		
	} // getNoise
	

	private boolean assertValidDouble(double pDouble) {
		return !(Double.isNaN(pDouble) || Double.isInfinite(pDouble));
	}
	

	private String getState(SEIRLabelValueImpl pCurrentSEIR,
			SEIRLabelValueImpl oldSEIR) {
		return String.format("\npresent state is: \nCurrentSEIR[%s]\n oldSEIR[%s]\n", 
				pCurrentSEIR, oldSEIR);
	}

	
	
	/**
	 * Sets the fixture for this Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ExampleDiseaseModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExampleDiseaseModel getFixture() {
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
		setFixture(ExampleFactory.eINSTANCE.createExampleDiseaseModel());
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
	 * created just for testings since '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments() <em>doModelSpecificAdjustments</em>}' is protected.
	 * @author kaufman
	 *
	 */
	private class ExampleDiseaseModelTesterImpl extends ExampleDiseaseModelImpl{

		public void doModelSpecificAdjustments(
				StandardDiseaseModelLabelValue pCurrentState,
				long pRandomSeed, double pTestGain) {
			setSeed(pRandomSeed);
			setGain(pTestGain);
			
			//SEIRLabelValueImpl oldCurrentState = org.eclipse.stem.diseasemodels.standard.tests.SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl((SEIRLabelValueImpl)pCurrentState);
			//SEIRLabelValueImpl oldStateAdditions2 = org.eclipse.stem.diseasemodels.standard.tests.SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl((SEIRLabelValueImpl)pStateAdditions2);
			//SEIRLabelValueImpl oldStateDeaths2 = org.eclipse.stem.diseasemodels.standard.tests.SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl((SEIRLabelValueImpl)pStateDeaths2);
			
			super.doModelSpecificAdjustments(pCurrentState);
		}
		
	}// ExampleDiseaseModelTesterImpl  inner class
	
} //ExampleDiseaseModelTest
