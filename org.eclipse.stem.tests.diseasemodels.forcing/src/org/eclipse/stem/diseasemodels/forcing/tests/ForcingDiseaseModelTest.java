/**
 * <copyright>
 * </copyright>
 *
 * $Id: ForcingDiseaseModelTest.java,v 1.2 2009/06/03 00:31:23 sedlund Exp $
 */
package org.eclipse.stem.diseasemodels.forcing.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.stem.adapters.time.TimeProviderAdapter;
import org.eclipse.stem.adapters.time.TimeProviderAdapterFactory.TimeProviderAdapterFactoryImpl;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.STEMTimeImpl;
import org.eclipse.stem.core.model.provider.STEMTimeItemProvider;
import org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel;
import org.eclipse.stem.diseasemodels.forcing.ForcingFactory;
import org.eclipse.stem.diseasemodels.forcing.impl.ForcingDiseaseModelImpl;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StandardFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForcingDiseaseModelTest extends TestCase {

	/**
	 * The fixture for this Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForcingDiseaseModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ForcingDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForcingDiseaseModelTest(String name) {
		super(name);
	}

	
	/**
	 * Sets the fixture for this Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ForcingDiseaseModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForcingDiseaseModel getFixture() {
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
		setFixture(ForcingFactory.eINSTANCE.createForcingDiseaseModel());
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

	public void testForcingDiseaseModel(){
		ForcingDiseaseModelTesterImpl forcingDiseaseModel = new ForcingDiseaseModelTesterImpl();
		SIRLabel label = StandardFactoryImpl.eINSTANCE.createSIRLabel();
		SIRLabelValue labelVal = (SIRLabelValue)label.getProbeValue();
		labelVal.setS(1000d);
		labelVal.setI(50d);
		labelVal.setR(40d);
		SIRLabelValueImpl retVal = new SIRLabelValueImpl(0d, 0d, 0d, 0d);
		STEMTime time = ModelFactory.eINSTANCE.createSTEMTime();

		forcingDiseaseModel.computeDiseaseDeltas(time, labelVal, label, 86400000, retVal);
		assert(retVal.sane());
		
	}
	
	/**
	 *
	 */
	private class ForcingDiseaseModelTesterImpl extends ForcingDiseaseModelImpl{

	}// ForcingDiseaseModelTesterImpl  inner class
	
} //ForcingDiseaseModelTest
