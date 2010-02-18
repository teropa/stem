package org.eclipse.stem.diseasemodels.forcing;
/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gaussian2 Forcing Disease Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getSigma2_2 <em>Sigma2 2</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getSigma2 <em>Sigma2</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationPeriod <em>Modulation Period</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationPhaseShift <em>Modulation Phase Shift</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationFloor <em>Modulation Floor</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getAtt1 <em>Att1</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getAtt2 <em>Att2</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getAtt3 <em>Att3</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getAtt4 <em>Att4</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel()
 * @model
 * @generated
 */
public interface Gaussian2ForcingDiseaseModel extends StochasticSIRDiseaseModel {
	/**
	 * Returns the value of the '<em><b>Sigma2 2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sigma2 2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sigma2 2</em>' attribute.
	 * @see #setSigma2_2(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel_Sigma2_2()
	 * @model
	 * @generated
	 */
	double getSigma2_2();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getSigma2_2 <em>Sigma2 2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sigma2 2</em>' attribute.
	 * @see #getSigma2_2()
	 * @generated
	 */
	void setSigma2_2(double value);

	/**
	 * Returns the value of the '<em><b>Sigma2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sigma2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sigma2</em>' attribute.
	 * @see #setSigma2(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel_Sigma2()
	 * @model
	 * @generated
	 */
	double getSigma2();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getSigma2 <em>Sigma2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sigma2</em>' attribute.
	 * @see #getSigma2()
	 * @generated
	 */
	void setSigma2(double value);

	/**
	 * Returns the value of the '<em><b>Modulation Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modulation Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modulation Period</em>' attribute.
	 * @see #setModulationPeriod(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel_ModulationPeriod()
	 * @model
	 * @generated
	 */
	double getModulationPeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationPeriod <em>Modulation Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modulation Period</em>' attribute.
	 * @see #getModulationPeriod()
	 * @generated
	 */
	void setModulationPeriod(double value);

	/**
	 * Returns the value of the '<em><b>Modulation Phase Shift</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modulation Phase Shift</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modulation Phase Shift</em>' attribute.
	 * @see #setModulationPhaseShift(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel_ModulationPhaseShift()
	 * @model
	 * @generated
	 */
	double getModulationPhaseShift();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationPhaseShift <em>Modulation Phase Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modulation Phase Shift</em>' attribute.
	 * @see #getModulationPhaseShift()
	 * @generated
	 */
	void setModulationPhaseShift(double value);

	/**
	 * Returns the value of the '<em><b>Modulation Floor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modulation Floor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modulation Floor</em>' attribute.
	 * @see #setModulationFloor(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel_ModulationFloor()
	 * @model
	 * @generated
	 */
	double getModulationFloor();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationFloor <em>Modulation Floor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modulation Floor</em>' attribute.
	 * @see #getModulationFloor()
	 * @generated
	 */
	void setModulationFloor(double value);

	/**
	 * Returns the value of the '<em><b>Att1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att1</em>' attribute.
	 * @see #setAtt1(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel_Att1()
	 * @model
	 * @generated
	 */
	double getAtt1();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getAtt1 <em>Att1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att1</em>' attribute.
	 * @see #getAtt1()
	 * @generated
	 */
	void setAtt1(double value);

	/**
	 * Returns the value of the '<em><b>Att2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att2</em>' attribute.
	 * @see #setAtt2(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel_Att2()
	 * @model
	 * @generated
	 */
	double getAtt2();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getAtt2 <em>Att2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att2</em>' attribute.
	 * @see #getAtt2()
	 * @generated
	 */
	void setAtt2(double value);

	/**
	 * Returns the value of the '<em><b>Att3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att3</em>' attribute.
	 * @see #setAtt3(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel_Att3()
	 * @model
	 * @generated
	 */
	double getAtt3();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getAtt3 <em>Att3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att3</em>' attribute.
	 * @see #getAtt3()
	 * @generated
	 */
	void setAtt3(double value);

	/**
	 * Returns the value of the '<em><b>Att4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Att4</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Att4</em>' attribute.
	 * @see #setAtt4(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian2ForcingDiseaseModel_Att4()
	 * @model
	 * @generated
	 */
	double getAtt4();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getAtt4 <em>Att4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Att4</em>' attribute.
	 * @see #getAtt4()
	 * @generated
	 */
	void setAtt4(double value);

} // Gaussian2ForcingDiseaseModel
