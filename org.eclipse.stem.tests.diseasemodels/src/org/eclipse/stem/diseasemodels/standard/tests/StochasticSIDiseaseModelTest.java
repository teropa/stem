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
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StochasticSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StandardStochasticDiseaseModelImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StochasticSIDiseaseModelImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Stochastic SI Disease Model</b></em>'.
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
public class StochasticSIDiseaseModelTest extends SITest {

	public static final long RANDOM_SEED = 1l;
	public static final double TEST_GAIN = 0.01d;
	
	/**
	 * The name of the test disease (an instance of a disease model)
	 */
	public static final String TEST_SI_DISEASE_NAME = "Test Stocastic SI Disease";

	
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StochasticSIDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Stochastic SI Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticSIDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Stochastic SI Disease Model test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StochasticSIDiseaseModel getFixture() {
		return (StochasticSIDiseaseModel)fixture;
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
	public static StochasticSIDiseaseModel createFixture() {
		return createFixture(StandardStochasticDiseaseModelImpl.GAIN_EDEFAULT);
	} // createFixture
	
	/**
	 * Create disease model instance
	 * 
	 * @return a disease model instance for test purposes
	 */
	public static StochasticSIDiseaseModel createFixture(double newGain) {
		return StochasticSIDiseaseModelImpl.createStochasticSIDiseaseModel(
				TEST_SI_DISEASE_NAME, MORTALITY_RATE,
				INFECTIOUS_MORTALITY_RATE, TRANSMISSION_RATE, RECOVERY_RATE,
				NON_LINEARITY_COEFFICIENT,
				TEST_TIME_PERIOD, TEST_POPULATION_IDENTIFIER, newGain);
		
	} // createFixture

	
	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments() <em>doModelSpecificAdjustments</em>}' operation.
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments()
	 * @generated NOT
	 */
	@SuppressWarnings("synthetic-access")
	public void testModelSpecificAdjustments(){
		StochasticSIDiseaseModelTesterImpl stochasticSIDiseaseModel = new StochasticSIDiseaseModelTesterImpl();
		SILabelValueImpl currentSI = new SILabelValueImpl(1000d, 40d, 20d, 60d, 100d, 10d);
		SILabelValueImpl SIAdditions = new SILabelValueImpl(10d, 2d, 3d, 2d, 3d, 1d);
		SILabelValueImpl SIDeaths =    new SILabelValueImpl(10d, 2d, 3d, 2d, 3d, 1d);
		doTest(stochasticSIDiseaseModel, currentSI, SIAdditions, SIDeaths);
	}

//	private void doTestWithPermutations() {
//		StochasticSIDiseaseModelTesterImpl stochasticSIDiseaseModel = new StochasticSIDiseaseModelTesterImpl();
//		List<SILabelValueImpl> modelLableValues = SILabelValueTestUtil.createRandomSILabelValueImpl();
//		
//		int count1 = 0;
//		int count2 = 0;
//		System.out.println();
//		for(SILabelValueImpl currentSI: modelLableValues){
//			System.out.println(count1++);
//			for(SILabelValueImpl SIAdditions: modelLableValues){
//				System.out.println("	" + count2++);
//				for(SILabelValueImpl SIDeaths: modelLableValues){
//					//SIDeaths and SIAdditions will be modified my the test method, so we better clone them 
//					doTest(stochasticSIDiseaseModel, currentSI,
//							SIAdditions, SIDeaths);
//			 	}
//			}
//		}
//	}

	private void doTest(StochasticSIDiseaseModelTesterImpl stochasticSIDiseaseModel,
			SILabelValueImpl currentSI, SILabelValueImpl SIAdditions,
			SILabelValueImpl SIDeaths) {
		SILabelValueImpl newSIAdditions = SILabelValueTestUtil.cloneSILabelValueImpl(SIAdditions);
		SILabelValueImpl newSIDeaths = SILabelValueTestUtil.cloneSILabelValueImpl(SIDeaths);
		
		stochasticSIDiseaseModel.doModelSpecificAdjustments(currentSI, newSIAdditions, newSIDeaths, RANDOM_SEED, TEST_GAIN);
		
		SILabelValueImpl calculatedSIAdditions = SILabelValueTestUtil.cloneSILabelValueImpl(SIAdditions);
		SILabelValueImpl calculatedSIDeaths = SILabelValueTestUtil.cloneSILabelValueImpl(SIDeaths);
		
		doCalculateModelSpecificAdjustments(currentSI, calculatedSIAdditions, calculatedSIDeaths, RANDOM_SEED, TEST_GAIN);

		String state = getState(currentSI, SIAdditions, SIDeaths, newSIAdditions, newSIDeaths, calculatedSIAdditions, calculatedSIDeaths);
		
		validateModelSpecificAdjustments(newSIAdditions,
				newSIDeaths,
				calculatedSIAdditions,
				calculatedSIDeaths,
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
			SILabelValueImpl pCurrentSI,
			SILabelValueImpl pCalculatedSIAdditions,
			SILabelValueImpl pCalculatedSIDeaths, long pRandomSeed, double pTestGain) {
		
		final SILabelValue currentSI =  pCurrentSI;
		final SILabelValue SIAdditions =  pCalculatedSIAdditions;
		final SILabelValue SIDeaths =  pCalculatedSIDeaths;
		
		
		// The noise is a multiplier of (1+/-x) with x small.
		// Compute the transitions
		
		Random random = new Random(pRandomSeed);
		
		
        //////////////////////////
		// The noise is a multiplier of (1+/-x) with x small.
	    // We must comput the NOISR IR transition first
		// Infectious case is more complicated
		double iRnoisy = SIAdditions.getI()* computeNoise(pTestGain, random);
		double deltaInoise = iRnoisy;
		if (deltaInoise > currentSI.getS()) {
			double rescale = currentSI.getS() / deltaInoise;
			iRnoisy *= rescale;
		}
		
		// set the change in infectious recovered
		SIAdditions.setI(iRnoisy);
		
		// Then Compute the transition to S	
		SIAdditions.setS(Math.min(currentSI.getI(), (SIAdditions.getI() * computeNoise(pTestGain, random))));
		
		
		
		
        /////////////////////////
		// now handle the deaths
		SIDeaths.setS(Math.min(currentSI.getS() , (SIDeaths.getS() * computeNoise(pTestGain, random))));
		
		// We do not need to change the Infectious death rate as we have already added noise
		// to both Infectious Recovered and Infectious Fatal

		SIDeaths.setDeaths(SIDeaths.getPopulationCount());
				
	}

	private void validateModelSpecificAdjustments(SILabelValueImpl newSIAdditions,
			SILabelValueImpl newSIDeaths,
			SILabelValueImpl calculatedSIAdditions,
			SILabelValueImpl calculatedSIDeaths,
			String state) {

		
		try{
			newSIAdditions.sane();
		}
		catch(Throwable t){
			throw new IllegalStateException("newSIAdditions is insane, state is: " + state, t);
		}
		try{
			newSIDeaths.sane();
		}
		catch(Throwable t){
			throw new IllegalStateException("newSIDeaths is insane, state is: " + state, t);
		}

		
		
		assertTrue(String.format("newSIAdditions has insane values %s", state), mySanityCheck(newSIAdditions));
		assertTrue(String.format("newSIDeaths has insane values %s", state), mySanityCheck(newSIDeaths));

		assertTrue(String.format("newSIAdditions[%s] != calculatedSIAdditions[%s]", newSIAdditions, calculatedSIAdditions), checkEqual(calculatedSIAdditions, newSIAdditions));
		assertTrue(String.format("newSIDeaths[%s] != calculatedSIDeaths[%s]", newSIDeaths, calculatedSIDeaths), checkEqual(calculatedSIDeaths, newSIDeaths));
		
	}
	
	private boolean checkEqual(SILabelValueImpl pCalculatedSIAdditions,
			SILabelValueImpl pNewSIAdditions) {
		if((pCalculatedSIAdditions.getBirths() != pNewSIAdditions.getBirths()) ||
				(pCalculatedSIAdditions.getDeaths() != pNewSIAdditions.getDeaths()) ||
				(pCalculatedSIAdditions.getDiseaseDeaths() != pNewSIAdditions.getDiseaseDeaths()) ||
				(pCalculatedSIAdditions.getI() != pNewSIAdditions.getI()) ||
				(pCalculatedSIAdditions.getPopulationCount() != pNewSIAdditions.getPopulationCount()) ||
				(pCalculatedSIAdditions.getS() != pNewSIAdditions.getS())){
					return false;
				}
		return true;
	}

	private boolean mySanityCheck(SILabelValueImpl pSI) {
		return assertValidDouble(pSI.getI()) && 
			assertValidDouble(pSI.getS());
		
	}

	private boolean assertValidDouble(double pDouble) {
		return !(Double.isNaN(pDouble) || Double.isInfinite(pDouble));
	}

	private String getState(SILabelValueImpl pCurrentSI,
			SILabelValueImpl pSIAdditions, SILabelValueImpl pSIDeaths,
			SILabelValueImpl pNewSIAdditions,
			SILabelValueImpl pNewSIDeaths, SILabelValueImpl pCalculatedSIAdditions, SILabelValueImpl pCalculatedSIDeaths) {
		return String.format("\npresent state is: \nCurrentSI[%s]\n SIAdditions[%s]\n SIDeaths[%s]\n NewSIAdditions[%s]\n NewSIDeaths[%s]\n CalculatedSIAdditions[%s]\n CalculatedSIDeaths[%s]", 
				pCurrentSI, pSIAdditions, pSIDeaths,pNewSIAdditions,pNewSIDeaths, pCalculatedSIAdditions, pCalculatedSIDeaths);
	}

	
	/**
	 * created just for testings since '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#doModelSpecificAdjustments() <em>doModelSpecificAdjustments</em>}' is protected.
	 * @author eishay
	 *
	 */
	private class StochasticSIDiseaseModelTesterImpl extends StochasticSIDiseaseModelImpl{

		public void doModelSpecificAdjustments(
				StandardDiseaseModelLabelValue pCurrentState,
				StandardDiseaseModelLabelValue pStateAdditions2,
				StandardDiseaseModelLabelValue pStateDeaths2,
				long pRandomSeed, double pTestGain) {
			setSeed(pRandomSeed);
			setGain(pTestGain);
			
			SILabelValueImpl oldCurrentState = SILabelValueTestUtil.cloneSILabelValueImpl((SILabelValueImpl)pCurrentState);
			SILabelValueImpl oldStateAdditions2 = SILabelValueTestUtil.cloneSILabelValueImpl((SILabelValueImpl)pStateAdditions2);
			SILabelValueImpl oldStateDeaths2 = SILabelValueTestUtil.cloneSILabelValueImpl((SILabelValueImpl)pStateDeaths2);
			
			super.doModelSpecificAdjustments(pCurrentState, pStateAdditions2, pStateDeaths2);
		}
		
	}
	
} // StochasticSIDiseaseModelTest
