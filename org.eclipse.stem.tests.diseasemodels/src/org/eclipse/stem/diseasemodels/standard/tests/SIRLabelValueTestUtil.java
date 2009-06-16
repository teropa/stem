package org.eclipse.stem.diseasemodels.standard.tests;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.impl.NodeImpl;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl;
import org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.SIDiseaseModelStateImpl;

public abstract class SIRLabelValueTestUtil extends TestCase{
	
	/**
	 * Number of random values to test with
	 */
	private static final int NUMBER_OF_RANDOMS = 0;

	/**
	 * max double value to be used in the test
	 */
	private static final double TEST_MAX_DOUBLE_VALUE = 1e12d;

	/**
	 * max long value to be used in the test
	 */
	private static final long TEST_MAX_LONG_VALUE = Long.MAX_VALUE;

	/**
	 * if there is a system property with this value then the test will be comperhensive. If not
	 * then the test will check only few cases.
	 */
	private static final String COMPERHANSIVE_TEST = "comperhensive.test";

	private static Boolean comperhensive = null;
	
	/**
	 * This method returns a list of {@link SIRLabelValueImpl} objects.
	 * Some objects in the list are random and some not random at all.
	 * The ones that are not random represents extreme cases.
	 * The numeric values for the extreme cases are 0.0, MAX_DOUBLE, and I added the number 1.0. 
	 * The number of random numbers to test with is NUMBER_OF_RANDOMS.
	 * Note that with NUMBER_OF_RANDOMS = 0 you will have 4374 permutations of all values of {@SIRLabelValueImpl}.
	 * If you wish to make NUMBER_OF_RANDOMS higher then 0 then be ready for a long test :-)
	 */
	public static List<SIRLabelValueImpl> createRandomSIRLabelValueImpl(){
		Random random = new Random();
		double[] values = new double[3 + NUMBER_OF_RANDOMS];
		values[0] = 0.0d;
		values[1] = TEST_MAX_DOUBLE_VALUE;
	    values[2] = 1.0d;
		for(int i = (values.length + 1); i < values.length; i++){
			values[i] = random.nextDouble() * TEST_MAX_DOUBLE_VALUE;
		}
		List<SIRLabelValueImpl> modelLevelValues = new LinkedList<SIRLabelValueImpl>();
		int iteration = 0;
		for(double s : values){
			for(double e : values){
				for(double i : values){
					for(double r : values){
						for(double births : values){
							for(double deaths : values){
								for(double diseaseDeaths : values){
									if(diseaseDeaths > deaths){
										continue;
									}
									if(skipValueSet(iteration++, diseaseDeaths, deaths, s, e, i, r)){
										continue;
									}
									SIRLabelValueImpl modelLableValue = new SIRLabelValueImpl(s, i, r, births, deaths,	diseaseDeaths);
									assertTrue("The SIRLabelValueImpl: " + modelLableValue + " is insane!", modelLableValue.sane());
									modelLevelValues.add(modelLableValue);
									System.out.println(modelLevelValues.size());
								}
							}
						}
					}
				}
			}
		}
		return modelLevelValues;
	}
	
	private static boolean skipValueSet(double iteration, double diseaseDeaths, double deaths, double s, double e, double i, double r) {
		if(!isComperhensive()){
			if(iteration % 500 > 1){
				//do only one of any 500 permutations
				System.out.print(".");
				return true;
			}
		}
		if(diseaseDeaths > deaths){
			return true;
		}
		double population = s + i + r;
		if(deaths > population){
			return true;
		}
		if(diseaseDeaths > population){
			return true;
		}
		return false;
	}
	
	private static boolean isComperhensive() {
		if(null != comperhensive ){
			return comperhensive.booleanValue();
		}
		String comperhensiveProperty = System.getProperty(COMPERHANSIVE_TEST);
		if(null != comperhensiveProperty){
			comperhensiveProperty = comperhensiveProperty.trim();
			if(comperhensiveProperty.equalsIgnoreCase("yes") || comperhensiveProperty.equalsIgnoreCase("true")){			
				comperhensive = new Boolean(true);
			}
		}
		if(null == comperhensive ){
			comperhensive = new Boolean(false);
		}
		return comperhensive.booleanValue();
	}
	/**
	 * Clone the SIRLabelValueImpl
	 * @param original will not be modefiles
	 * @return a clone of 'original'
	 */
	public static SIRLabelValueImpl cloneSIRLabelValueImpl(SIRLabelValueImpl original){
		SIRLabelValueImpl value =  new SIRLabelValueImpl(original.getS(), original.getI(), 
				original.getR(), original.getBirths(), original.getDeaths(), original.getDiseaseDeaths());
		return value;
	}

	/**
	 * This method returns a list of {@link SIRLabelImpl} objects.
	 * Some objects in the list are random and some not random at all.
	 * The ones that are not random represents extreme cases.
	 * The numeric values for the extreme cases are 0.0, MAX_DOUBLE, and I added the number 1.0. 
	 * The number of random numbers to test with is NUMBER_OF_RANDOMS.
	 * Note that with NUMBER_OF_RANDOMS = 0 you will have 4374 permutations of all values of {SIRLabelImpl}.
	 * If you wish to make NUMBER_OF_RANDOMS higher then 0 then be ready for a long test :-)
	 * 
	 */
	public List<SIRLabelImpl> createRandomSIRLabelImpl(){
		Random random = new Random();
		double[] values = new double[3 + NUMBER_OF_RANDOMS];
		values[0] = 0.0d;
		values[1] = TEST_MAX_DOUBLE_VALUE;
		values[2] = 1.0d;
		for(int i = 3; i < values.length; i++){
			values[i] = random.nextDouble() * TEST_MAX_DOUBLE_VALUE;
		}
		List<SIRLabelImpl> modelLevelValues = new LinkedList<SIRLabelImpl>();
		int iteration = 0;
		for(double s : values){
			for(double e : values){
				for(double i : values){
					for(double r : values){
						for(double births : values){
							for(double deaths : values){
								for(double diseaseDeaths : values){
									if(skipValueSet(iteration++, diseaseDeaths, deaths, s, e, i, r)){
										continue;
									}
									SIRLabelImpl modelLable = new SIRLabelTesterImpl(s, i, r, births, deaths, diseaseDeaths, 
											new SIDiseaseModelStateTesterImpl(), new NodeTesterImpl());
									assertTrue("The SIRLabelImpl: " + modelLable + " is insane!", modelLable.sane());
									modelLevelValues.add(modelLable);
								}
							}
						}
					}
				}
			}
		}
	return modelLevelValues;
	}
	
	

	private class SIDiseaseModelStateTesterImpl extends SIDiseaseModelStateImpl{
		public SIDiseaseModelStateTesterImpl(){
			super();
		}
	}
	
	
	private class SIRLabelTesterImpl extends SIRLabelImpl{
		/**
		 * <!-- begin-user-doc -->
		 * 
		 * This is used to create instances for testing purposes.
		 * 
		 * @param s
		 *            the number of susceptible population members
		 * @param iR
		 *            the number of recovering infectious population members
		 * @param iF
		 *            the number of fatally infectious population members
		 * @param r
		 *            the number of recovered population members
		 * @param births
		 *            the number of births that have occured in the population
		 * @param deaths
		 *            the total number of deaths that have occured in the population
		 * @param diseaseDeaths
		 *            the number of deaths due to the disease that have occured in
		 *            the population
		 * 
		 * <!-- end-user-doc -->
		 * @param newDiseaseModelState 
		 * @param newNode 
		 */
		public SIRLabelTesterImpl(final double s, final double i,
				final double r, final double births, final double deaths,
				final double diseaseDeaths, final DiseaseModelState newDiseaseModelState, Node newNode) {
			super();
			setS(s);
			setI(i);
			setR(r);
			setBirths(births);
			setDeaths(deaths);
			setDiseaseDeaths(diseaseDeaths);
			setDiseaseModelState(newDiseaseModelState);
			setNode(newNode);
		} // SIRLabelValueImpl	
	}

	private class NodeTesterImpl extends NodeImpl{
		public NodeTesterImpl(){
			super();
		}
	}
	
	
	public long[] createrandomDeltas() {
		Random random = new Random();
		long[] values = new long[2 + NUMBER_OF_RANDOMS];
		values[0] = TEST_MAX_LONG_VALUE;
		values[1] = 1l;
		for(int i = 3; i < values.length; i++){
			values[i] = random.nextLong() * TEST_MAX_LONG_VALUE;
		}
		return values;
	}
	
}