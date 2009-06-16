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

//import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StandardStochasticDiseaseModelImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StochasticSIRDiseaseModelImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Stochastic SIR Disease Model</b></em>'.
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
public class StochasticSIRDiseaseModelTest extends SIRTest {

	public static final long RANDOM_SEED = 1l;
	public static final double TEST_GAIN = 0.01d;
	
	/**
	 * The name of the test disease (an instance of a disease model)
	 */
	public static final String TEST_SIR_DISEASE_NAME = "Test Stocastic SIR Disease";

	
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StochasticSIRDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Stochastic SIR Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticSIRDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Stochastic SIR Disease Model test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StochasticSIRDiseaseModel getFixture() {
		return (StochasticSIRDiseaseModel)fixture;
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
	public static StochasticSIRDiseaseModel createFixture() {
		return createFixture(StandardStochasticDiseaseModelImpl.GAIN_EDEFAULT);
	} // createFixture
	
	/**
	 * Create disease model instance
	 * 
	 * @return a disease model instance for test purposes
	 */
	public static StochasticSIRDiseaseModel createFixture(double newGain) {
		return StochasticSIRDiseaseModelImpl.createStochasticSIRDiseaseModel(
				TEST_SIR_DISEASE_NAME, MORTALITY_RATE,
				INFECTIOUS_MORTALITY_RATE, TRANSMISSION_RATE, RECOVERY_RATE,
				IMMUNITY_LOSS_RATE, NON_LINEARITY_COEFFICIENT,
				TEST_TIME_PERIOD, TEST_POPULATION_IDENTIFIER, newGain);
		
	} // createFixture

	
	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments() <em>doModelSpecificAdjustments</em>}' operation.
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments()
	 * @generated NOT
	 */
	@SuppressWarnings("synthetic-access")
	public void testModelSpecificAdjustments(){
		StochasticSIRDiseaseModelTesterImpl stochasticSIRDiseaseModel = new StochasticSIRDiseaseModelTesterImpl();
		SIRLabelValueImpl currentSIR = new SIRLabelValueImpl(1000d, 40d, 30d, 20d, 60d, 100d, 10d);
		SIRLabelValueImpl SIRAdditions = new SIRLabelValueImpl(10d, 2d, 3d, 3d, 2d, 3d, 1d);
		SIRLabelValueImpl SIRDeaths = new SIRLabelValueImpl(10d, 2d, 3d, 3d, 2d, 3d, 1d);
		doTest(stochasticSIRDiseaseModel, currentSIR, SIRAdditions, SIRDeaths);
	}

//	@SuppressWarnings("synthetic-access")
//	private void doTestWithPermutations() {
//		StochasticSIRDiseaseModelTesterImpl stochasticSIRDiseaseModel = new StochasticSIRDiseaseModelTesterImpl();
//		List<SIRLabelValueImpl> modelLableValues = SIRLabelValueTestUtil.createRandomSIRLabelValueImpl();
//		
//		int count1 = 0;
//		int count2 = 0;
//		System.out.println();
//		for(SIRLabelValueImpl currentSIR: modelLableValues){
//			System.out.println(count1++);
//			for(SIRLabelValueImpl SIRAdditions: modelLableValues){
//				System.out.println("	" + count2++);
//				for(SIRLabelValueImpl SIRDeaths: modelLableValues){
//					//SIRDeaths and SIRAdditions will be modified my the test method, so we better clone them 
//					doTest(stochasticSIRDiseaseModel, currentSIR,
//							SIRAdditions, SIRDeaths);
//			 	}
//			}
//		}
//	}

	private void doTest(StochasticSIRDiseaseModelTesterImpl stochasticSIRDiseaseModel,
			SIRLabelValueImpl currentSIR, SIRLabelValueImpl SIRAdditions,
			SIRLabelValueImpl SIRDeaths) {
		SIRLabelValueImpl newSIRAdditions = SIRLabelValueTestUtil.cloneSIRLabelValueImpl(SIRAdditions);
		SIRLabelValueImpl newSIRDeaths = SIRLabelValueTestUtil.cloneSIRLabelValueImpl(SIRDeaths);
		
		stochasticSIRDiseaseModel.doModelSpecificAdjustments(currentSIR, newSIRAdditions, newSIRDeaths, RANDOM_SEED, TEST_GAIN);
		
		SIRLabelValueImpl calculatedSIRAdditions = SIRLabelValueTestUtil.cloneSIRLabelValueImpl(SIRAdditions);
		SIRLabelValueImpl calculatedSIRDeaths = SIRLabelValueTestUtil.cloneSIRLabelValueImpl(SIRDeaths);
		
		doCalculateModelSpecificAdjustments(currentSIR, calculatedSIRAdditions, calculatedSIRDeaths, RANDOM_SEED, TEST_GAIN);

		String state = getState(currentSIR, SIRAdditions, SIRDeaths, newSIRAdditions, newSIRDeaths, calculatedSIRAdditions, calculatedSIRDeaths);
		
		validateModelSpecificAdjustments(newSIRAdditions,
				newSIRDeaths,
				calculatedSIRAdditions,
				calculatedSIRDeaths,
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
			SIRLabelValueImpl pCurrentSIR,
			SIRLabelValueImpl pCalculatedSIRAdditions,
			SIRLabelValueImpl pCalculatedSIRDeaths, long pRandomSeed, double pTestGain) {
		
		final SIRLabelValue currentSIR =  pCurrentSIR;
		final SIRLabelValue SIRAdditions =  pCalculatedSIRAdditions;
		final SIRLabelValue SIRDeaths =  pCalculatedSIRDeaths;
		
		
		// The noise is a multiplier of (1+/-x) with x small.
		// Compute the transitions
		
		Random random = new Random(pRandomSeed);
		
		SIRAdditions.setS(Math.min(currentSIR.getR(), (SIRAdditions.getS() * computeNoise(pTestGain, random))));
		SIRAdditions.setR(Math.min(currentSIR.getI(), (SIRAdditions.getR() * computeNoise(pTestGain, random))));
       
		// Infectious case is more complicated
		double iRnoisy = SIRAdditions.getI()* computeNoise(pTestGain, random);
		double deltaInoise = iRnoisy;
		if (deltaInoise > currentSIR.getS()) {
			double rescale = currentSIR.getS() / deltaInoise;
			iRnoisy *= rescale;
		}
		
		// set the change in infectious recovered
		SIRAdditions.setI(iRnoisy);
		//////////////////////////

        /////////////////////////
		// now handle the deaths
		SIRDeaths.setS(Math.min(currentSIR.getS() , (SIRDeaths.getS() * computeNoise(pTestGain, random))));
		SIRDeaths.setR(Math.min(currentSIR.getR() , (SIRDeaths.getR() * computeNoise(pTestGain, random))));
		
		// We do not need to change the Infectious death rate as we have already added noise
		// to both Infectious Recovered and Infectious Fatal

		SIRDeaths.setDeaths(SIRDeaths.getPopulationCount());
				
	}

	private void validateModelSpecificAdjustments(SIRLabelValueImpl newSIRAdditions,
			SIRLabelValueImpl newSIRDeaths,
			SIRLabelValueImpl calculatedSIRAdditions,
			SIRLabelValueImpl calculatedSIRDeaths,
			String state) {

		
		try{
			newSIRAdditions.sane();
		}
		catch(Throwable t){
			throw new IllegalStateException("newSIRAdditions is insane, state is: " + state, t);
		}
		try{
			newSIRDeaths.sane();
		}
		catch(Throwable t){
			throw new IllegalStateException("newSIRDeaths is insane, state is: " + state, t);
		}

		
		
		assertTrue(String.format("newSIRAdditions has insane values %s", state), mySanityCheck(newSIRAdditions));
		assertTrue(String.format("newSIRDeaths has insane values %s", state), mySanityCheck(newSIRDeaths));

		assertTrue(String.format("newSIRAdditions[%s] != calculatedSIRAdditions[%s]", newSIRAdditions, calculatedSIRAdditions), checkEqual(calculatedSIRAdditions, newSIRAdditions));
		assertTrue(String.format("newSIRDeaths[%s] != calculatedSIRDeaths[%s]", newSIRDeaths, calculatedSIRDeaths), checkEqual(calculatedSIRDeaths, newSIRDeaths));
		
	}
	
	private boolean checkEqual(SIRLabelValueImpl pCalculatedSIRAdditions,
			SIRLabelValueImpl pNewSIRAdditions) {
		if((pCalculatedSIRAdditions.getBirths() != pNewSIRAdditions.getBirths()) ||
				(pCalculatedSIRAdditions.getDeaths() != pNewSIRAdditions.getDeaths()) ||
				(pCalculatedSIRAdditions.getDiseaseDeaths() != pNewSIRAdditions.getDiseaseDeaths()) ||
				(pCalculatedSIRAdditions.getI() != pNewSIRAdditions.getI()) ||
				(pCalculatedSIRAdditions.getPopulationCount() != pNewSIRAdditions.getPopulationCount()) ||
				(pCalculatedSIRAdditions.getR() != pNewSIRAdditions.getR()) ||
				(pCalculatedSIRAdditions.getS() != pNewSIRAdditions.getS())){
					return false;
				}
		return true;
	}

	private boolean mySanityCheck(SIRLabelValueImpl pSIR) {
		return assertValidDouble(pSIR.getI()) && 
			assertValidDouble(pSIR.getR()) && 
			assertValidDouble(pSIR.getS());
		
	}

	private boolean assertValidDouble(double pDouble) {
		return !(Double.isNaN(pDouble) || Double.isInfinite(pDouble));
	}

	private String getState(SIRLabelValueImpl pCurrentSIR,
			SIRLabelValueImpl pSIRAdditions, SIRLabelValueImpl pSIRDeaths,
			SIRLabelValueImpl pNewSIRAdditions,
			SIRLabelValueImpl pNewSIRDeaths, SIRLabelValueImpl pCalculatedSIRAdditions, SIRLabelValueImpl pCalculatedSIRDeaths) {
		return String.format("\npresent state is: \nCurrentSIR[%s]\n SIRAdditions[%s]\n SIRDeaths[%s]\n NewSIRAdditions[%s]\n NewSIRDeaths[%s]\n CalculatedSIRAdditions[%s]\n CalculatedSIRDeaths[%s]", 
				pCurrentSIR, pSIRAdditions, pSIRDeaths,pNewSIRAdditions,pNewSIRDeaths, pCalculatedSIRAdditions, pCalculatedSIRDeaths);
	}

	
	/**
	 * created just for testings since '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments() <em>doModelSpecificAdjustments</em>}' is protected.
	 * @author eishay
	 *
	 */
	private class StochasticSIRDiseaseModelTesterImpl extends StochasticSIRDiseaseModelImpl{

		public void doModelSpecificAdjustments(
				StandardDiseaseModelLabelValue pCurrentState,
				StandardDiseaseModelLabelValue pStateAdditions2,
				StandardDiseaseModelLabelValue pStateDeaths2,
				long pRandomSeed, double pTestGain) {
			setSeed(pRandomSeed);
			setGain(pTestGain);
			
			SIRLabelValueImpl oldCurrentState = SIRLabelValueTestUtil.cloneSIRLabelValueImpl((SIRLabelValueImpl)pCurrentState);
			SIRLabelValueImpl oldStateAdditions2 = SIRLabelValueTestUtil.cloneSIRLabelValueImpl((SIRLabelValueImpl)pStateAdditions2);
			SIRLabelValueImpl oldStateDeaths2 = SIRLabelValueTestUtil.cloneSIRLabelValueImpl((SIRLabelValueImpl)pStateDeaths2);
			
			super.doModelSpecificAdjustments(pCurrentState, pStateAdditions2, pStateDeaths2);
		}
		
	}
	
} // StochasticSIRDiseaseModelTest
