/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.experimental.tests;

import java.util.Random;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.stem.diseasemodels.experimental.ExperimentalFactory;
import org.eclipse.stem.diseasemodels.experimental.PercolationDiseaseModel;
import org.eclipse.stem.diseasemodels.experimental.impl.PercolationDiseaseModelImpl;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.tests.SEIRLabelValueTestUtil;



/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Percolation Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PercolationDiseaseModelTest extends TestCase {

	/**
	 * Seed for test
	 */
	public static final long RANDOM_SEED = 1l;
	
	/**
	 * default gain factor
	 */
	public static final double TEST_GAIN = 0.01d;
	
	
	/**
	 * The fixture for this Percolation Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PercolationDiseaseModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param args 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PercolationDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Percolation Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name 
	 * @generated
	 */
	public PercolationDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Tests the modelSpecificAdjustments operation.
	 * 
	 * @generated NOT
	 */
	public void testModelSpecificAdjustments(){
		PercolationDiseaseModelTesterImpl percolationDiseaseModel = new PercolationDiseaseModelTesterImpl();
		SEIRLabelValueImpl currentSEIR = new SEIRLabelValueImpl(1000d, 50d, 40d, 30d, 20d, 60d, 100d, 10d);
		SEIRLabelValueImpl seirAdditions = new SEIRLabelValueImpl(10d, 1d, 2d, 3d, 3d, 2d, 3d, 1d);
		SEIRLabelValueImpl seirDeaths = new SEIRLabelValueImpl(10d, 1d, 2d, 3d, 3d, 2d, 3d, 1d);
		doTest(percolationDiseaseModel, currentSEIR, seirAdditions, seirDeaths);
	}
	
	
	/**
	 * Do the test
	 * @param percolationDiseaseModel
	 * @param currentSEIR
	 * @param seirAdditions
	 * @param seirDeaths
	 * @generated NOT
	 */
	private void doTest(PercolationDiseaseModelTesterImpl percolationDiseaseModel,
			SEIRLabelValueImpl currentSEIR, SEIRLabelValueImpl seirAdditions,
			SEIRLabelValueImpl seirDeaths) {
		SEIRLabelValueImpl newSeirAdditions = SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl(seirAdditions);
		SEIRLabelValueImpl newSeirDeaths = SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl(seirDeaths);
		
		percolationDiseaseModel.doModelSpecificAdjustments(currentSEIR, newSeirAdditions, newSeirDeaths, RANDOM_SEED, TEST_GAIN);
		
		SEIRLabelValueImpl calculatedSeirAdditions = SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl(seirAdditions);
		SEIRLabelValueImpl calculatedSeirDeaths = SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl(seirDeaths);
		
		doCalculateModelSpecificAdjustments(currentSEIR, calculatedSeirAdditions, calculatedSeirDeaths, RANDOM_SEED, TEST_GAIN);

		String state = getState(currentSEIR, seirAdditions, seirDeaths, newSeirAdditions, newSeirDeaths, calculatedSeirAdditions, calculatedSeirDeaths);
		
		validateModelSpecificAdjustments(newSeirAdditions,
				newSeirDeaths,
				calculatedSeirAdditions,
				calculatedSeirDeaths,
				state);
	}
	

	private void doCalculateModelSpecificAdjustments(
			SEIRLabelValueImpl pCurrentSEIR,
			SEIRLabelValueImpl pCalculatedSeirAdditions,
			SEIRLabelValueImpl pCalculatedSeirDeaths, long pRandomSeed, double pTestGain) {
		
		final SEIRLabelValue currentSEIR = (SEIRLabelValue) pCurrentSEIR;
		final SEIRLabelValue seirAdditions = (SEIRLabelValue) pCalculatedSeirAdditions;
		final SEIRLabelValue seirDeaths = (SEIRLabelValue) pCalculatedSeirDeaths;
		
		
		// The noise is a multiplier of (1+/-x) with x small.
		// Compute the transitions
		
		Random random = new Random(pRandomSeed);
		
		seirAdditions.setS(Math.min(currentSEIR.getR(), (seirAdditions.getS() * computeNoise(pTestGain, random))));
	
		seirAdditions.setE(Math.min(currentSEIR.getS(), (seirAdditions.getE() * computeNoise(pTestGain, random))));
	
		seirAdditions.setR(Math.min(currentSEIR.getI(), (seirAdditions.getR() * computeNoise(pTestGain, random))));
       
		
		
		
		
		// Infectious case is more complicated
		double inoisy = seirAdditions.getI()* computeNoise(pTestGain, random);
		double deltaInoise = inoisy;
		if (deltaInoise > currentSEIR.getE()) {
			double rescale = currentSEIR.getE() / deltaInoise;
			inoisy *= rescale;
		}
		
		// set the change in infectious recovered
		seirAdditions.setI(inoisy);
		
		//////////////////////////

        /////////////////////////
		// now handle the deaths
		seirDeaths.setS(Math.min(currentSEIR.getS() , (seirDeaths.getS() * computeNoise(pTestGain, random))));

		seirDeaths.setE(Math.min(currentSEIR.getE() , (seirDeaths.getE() * computeNoise(pTestGain, random))));
        
		seirDeaths.setR(Math.min(currentSEIR.getR() , (seirDeaths.getR() * computeNoise(pTestGain, random))));
		
		// We do not need to change the Infectious death rate as we have already added noise
		// to both Infectious Recovered and Infectious Fatal

		seirDeaths.setDeaths(seirDeaths.getPopulationCount());
				
	}

	private void validateModelSpecificAdjustments(SEIRLabelValueImpl newSeirAdditions,
			SEIRLabelValueImpl newSeirDeaths,
			SEIRLabelValueImpl calculatedSeirAdditions,
			SEIRLabelValueImpl calculatedSeirDeaths,
			String state) {

		
		try{
			newSeirAdditions.sane();
		}
		catch(Throwable t){
			throw new IllegalStateException("newSeirAdditions is insane, state is: " + state, t);
		}
		try{
			newSeirDeaths.sane();
		}
		catch(Throwable t){
			throw new IllegalStateException("newSeirDeaths is insane, state is: " + state, t);
		}

		
		
		assertTrue(String.format("newSeirAdditions has insane values %s", state), mySanityCheck(newSeirAdditions));
		assertTrue(String.format("newSeirDeaths has insane values %s", state), mySanityCheck(newSeirDeaths));

		assertTrue(String.format("newSeirAdditions[%s] != calculatedSeirAdditions[%s]", newSeirAdditions, calculatedSeirAdditions), checkEqual(calculatedSeirAdditions, newSeirAdditions));
		assertTrue(String.format("newSeirDeaths[%s] != calculatedSeirDeaths[%s]", newSeirDeaths, calculatedSeirDeaths), checkEqual(calculatedSeirDeaths, newSeirDeaths));
		
	}
	
	private boolean checkEqual(SEIRLabelValueImpl pCalculatedSeirAdditions,
			SEIRLabelValueImpl pNewSeirAdditions) {
		if((pCalculatedSeirAdditions.getBirths() != pNewSeirAdditions.getBirths()) ||
				(pCalculatedSeirAdditions.getDeaths() != pNewSeirAdditions.getDeaths()) ||
				(pCalculatedSeirAdditions.getDiseaseDeaths() != pNewSeirAdditions.getDiseaseDeaths()) ||
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
			SEIRLabelValueImpl pSeirAdditions, SEIRLabelValueImpl pSeirDeaths,
			SEIRLabelValueImpl pNewSeirAdditions,
			SEIRLabelValueImpl pNewSeirDeaths, SEIRLabelValueImpl pCalculatedSeirAdditions, SEIRLabelValueImpl pCalculatedSeirDeaths) {
		return String.format("\npresent state is: \nCurrentSEIR[%s]\n SeirAdditions[%s]\n SeirDeaths[%s]\n NewSeirAdditions[%s]\n NewSeirDeaths[%s]\n CalculatedSeirAdditions[%s]\n CalculatedSeirDeaths[%s]", 
				pCurrentSEIR, pSeirAdditions, pSeirDeaths,pNewSeirAdditions,pNewSeirDeaths, pCalculatedSeirAdditions, pCalculatedSeirDeaths);
	}

	
	
	/**
	 * Sets the fixture for this Percolation Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PercolationDiseaseModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Percolation Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PercolationDiseaseModel getFixture() {
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
		setFixture(ExperimentalFactory.eINSTANCE.createPercolationDiseaseModel());
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
	private class PercolationDiseaseModelTesterImpl extends PercolationDiseaseModelImpl{

		public void doModelSpecificAdjustments(
				StandardDiseaseModelLabelValue pCurrentState,
				StandardDiseaseModelLabelValue pStateAdditions2,
				StandardDiseaseModelLabelValue pStateDeaths2,
				long pRandomSeed, double pTestGain) {
			// TODO Auto-generated method stub
			setSeed(pRandomSeed);
			setGain(pTestGain);
			
			//SEIRLabelValueImpl oldCurrentState = org.eclipse.stem.diseasemodels.standard.tests.SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl((SEIRLabelValueImpl)pCurrentState);
			//SEIRLabelValueImpl oldStateAdditions2 = org.eclipse.stem.diseasemodels.standard.tests.SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl((SEIRLabelValueImpl)pStateAdditions2);
			//SEIRLabelValueImpl oldStateDeaths2 = org.eclipse.stem.diseasemodels.standard.tests.SEIRLabelValueTestUtil.cloneSEIRLabelValueImpl((SEIRLabelValueImpl)pStateDeaths2);
			
			super.doModelSpecificAdjustments(pCurrentState, pStateAdditions2, pStateDeaths2);
		}
		
	}// PercolationDiseaseModelTesterImpl  inner class
	
} //PercolationDiseaseModelTest
