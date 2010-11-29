package org.eclipse.stem.diseasemodels.standard.tests;

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

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StochasticSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StandardStochasticDiseaseModelImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StochasticSEIRDiseaseModelImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Stochastic SEIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel#computeNoise() <em>Compute Noise</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class StochasticSEIRDiseaseModelTest extends SEIRTest {

	public static final long RANDOM_SEED = 1l;
	public static final double TEST_GAIN = 0.01d;
	private static final String DISEASE_IDENTIFIER = "StochasticSEIRDiseaseModel";
	public static final URI DISEASE_URI = STEMURI.createURI("diseasemodel" + "/" + DISEASE_IDENTIFIER);
	
	
	/**
	 * The name of the test disease (an instance of a disease model)
	 */
	public static final String TEST_SEIR_DISEASE_NAME = "Test Stocastic SEIR Disease";

	
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StochasticSEIRDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Stochastic SEIR Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticSEIRDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Stochastic SEIR Disease Model test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StochasticSEIRDiseaseModel getFixture() {
		return (StochasticSEIRDiseaseModel)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());
		StandardDiseaseModelLabel dml = createLabelFixture();
		DiseaseModelState dms = getFixture().createDiseaseModelState();
		dml.setDiseaseModelState(dms);
		setLabelFixture(dml);
		fixture.initializeDiseaseState(dms, dml);
	} // setUp

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	} // tearDown

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel#computeNoise() <em>Compute Noise</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel#computeNoise()
	 * @generated NOT
	 */
	public void testComputeNoise() {
		StandardStochasticDiseaseModelTest.staticComputeNoiseTest();
	}

	/**
	 * Create disease model instance
	 * 
	 * @return a disease model instance for test purposes
	 */
	public static StochasticSEIRDiseaseModel createFixture() {
		return createFixture(StandardStochasticDiseaseModelImpl.GAIN_EDEFAULT);
	} // createFixture
	
	/**
	 * Create disease model instance
	 * 
	 * @return a disease model instance for test purposes
	 */
	public static StochasticSEIRDiseaseModel createFixture(double newGain) {
		StochasticSEIRDiseaseModel diseaseModel = StochasticSEIRDiseaseModelImpl.createStochasticSEIRDiseaseModel(
				TEST_SEIR_DISEASE_NAME, MORTALITY_RATE,
				INFECTIOUS_MORTALITY_RATE, TRANSMISSION_RATE, RECOVERY_RATE,
				IMMUNITY_LOSS_RATE, INCUBATION_RATE, NON_LINEARITY_COEFFICIENT,
				TEST_TIME_PERIOD, TEST_POPULATION_IDENTIFIER, newGain);
		
		final DublinCore dc = diseaseModel.getDublinCore();
		diseaseModel.setURI(DISEASE_URI);
		dc.setIdentifier(diseaseModel.getURI().toString());
		return diseaseModel;
		
		
	} // createFixture

	
	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments() <em>doModelSpecificAdjustments</em>}' operation.
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments()
	 * @generated NOT
	 */
	@SuppressWarnings("synthetic-access")
	public void testModelSpecificAdjustments(){
		StochasticSEIRDiseaseModelTesterImpl stochasticSEIRDiseaseModel = new StochasticSEIRDiseaseModelTesterImpl();
		SEIRLabelValueImpl currentSEIR = new SEIRLabelValueImpl(1000d, 50d, 40d, 30d, 20d, 10d);
		doTest(stochasticSEIRDiseaseModel, currentSEIR);
	}

//	private void doTestWithPermutations() {
//		StochasticSEIRDiseaseModelTesterImpl stochasticSEIRDiseaseModel = new StochasticSEIRDiseaseModelTesterImpl();
//		List<SEIRLabelValueImpl> modelLableValues = SEIRLabelValueTestUtil.createRandomSEIRLabelValueImpl();
//		
//		int count1 = 0;
//		int count2 = 0;
//		System.out.println();
//		for(SEIRLabelValueImpl currentSEIR: modelLableValues){
//			System.out.println(count1++);
//			for(SEIRLabelValueImpl seirAdditions: modelLableValues){
//				System.out.println("	" + count2++);
//				for(SEIRLabelValueImpl seirDeaths: modelLableValues){
//					//seirDeaths and seirAdditions will be modified my the test method, so we better clone them 
//					doTest(stochasticSEIRDiseaseModel, currentSEIR,
//							seirAdditions, seirDeaths);
//			 	}
//			}
//		}
//	}

	private void doTest(StochasticSEIRDiseaseModelTesterImpl stochasticSEIRDiseaseModel,
			SEIRLabelValueImpl currentSEIR) {
		
		SEIRLabelValueImpl oldSEIR = (SEIRLabelValueImpl)EcoreUtil.copy(currentSEIR);
		stochasticSEIRDiseaseModel.doModelSpecificAdjustments(currentSEIR, RANDOM_SEED, TEST_GAIN);
		
		doCalculateModelSpecificAdjustments(currentSEIR, RANDOM_SEED, TEST_GAIN);

		String state = getState(currentSEIR, oldSEIR);
		
		validateModelSpecificAdjustments(currentSEIR,
				oldSEIR,
				state);
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
	
	
	private void doCalculateModelSpecificAdjustments(
			SEIRLabelValueImpl pCurrentSEIR, long pRandomSeed, double pTestGain) {
		
		
		final SEIRLabelValue currentSEIR = (SEIRLabelValue) pCurrentSEIR;
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
			throw new IllegalStateException("currentSEIR is insane, state is: " + state, t);
		}
		try{
			oldSEIR.sane();
		}
		catch(Throwable t){
			throw new IllegalStateException("oldSEIR is insane, state is: " + state, t);
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

	private boolean assertValidDouble(double pDouble) {
		return !(Double.isNaN(pDouble) || Double.isInfinite(pDouble));
	}

	private String getState(SEIRLabelValueImpl pCurrentSEIR,
			SEIRLabelValueImpl oldSEIR) {
		return String.format("\npresent state is: \ncurrentSEIR[%s]\n oldSEIR[%s]", 
				pCurrentSEIR, oldSEIR);
	}

	
	/**
	 * created just for testings since '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments() <em>doModelSpecificAdjustments</em>}' is protected.
	 * @author eishay
	 *
	 */
	private class StochasticSEIRDiseaseModelTesterImpl extends StochasticSEIRDiseaseModelImpl{

		public void doModelSpecificAdjustments(
				StandardDiseaseModelLabelValue pCurrentState,
				long pRandomSeed, double pTestGain) {
			setSeed(pRandomSeed);
			setGain(pTestGain);
			
			SEIRLabelValueImpl oldCurrentState = SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl((SEIRLabelValueImpl)pCurrentState);
			super.doModelSpecificAdjustments(pCurrentState);
		}
		
	}
	
} // StochasticSEIRDiseaseModelTest
