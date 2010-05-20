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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gaussian3 Forcing Disease Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel#getSigma2_3 <em>Sigma2 3</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel#getTransmissionRate2 <em>Transmission Rate2</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel#getTransmissionRate3 <em>Transmission Rate3</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel#getModulationFloor_2 <em>Modulation Floor 2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian3ForcingDiseaseModel()
 * @model
 * @generated
 */
public interface Gaussian3ForcingDiseaseModel extends Gaussian2ForcingDiseaseModel {
	/**
	 * Returns the value of the '<em><b>Sigma2 3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sigma2 3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sigma2 3</em>' attribute.
	 * @see #setSigma2_3(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian3ForcingDiseaseModel_Sigma2_3()
	 * @model
	 * @generated
	 */
	double getSigma2_3();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel#getSigma2_3 <em>Sigma2 3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sigma2 3</em>' attribute.
	 * @see #getSigma2_3()
	 * @generated
	 */
	void setSigma2_3(double value);

	/**
	 * Returns the value of the '<em><b>Transmission Rate2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transmission Rate2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transmission Rate2</em>' attribute.
	 * @see #setTransmissionRate2(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian3ForcingDiseaseModel_TransmissionRate2()
	 * @model
	 * @generated
	 */
	double getTransmissionRate2();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel#getTransmissionRate2 <em>Transmission Rate2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transmission Rate2</em>' attribute.
	 * @see #getTransmissionRate2()
	 * @generated
	 */
	void setTransmissionRate2(double value);

	/**
	 * Returns the value of the '<em><b>Transmission Rate3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transmission Rate3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transmission Rate3</em>' attribute.
	 * @see #setTransmissionRate3(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian3ForcingDiseaseModel_TransmissionRate3()
	 * @model
	 * @generated
	 */
	double getTransmissionRate3();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel#getTransmissionRate3 <em>Transmission Rate3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transmission Rate3</em>' attribute.
	 * @see #getTransmissionRate3()
	 * @generated
	 */
	void setTransmissionRate3(double value);

	/**
	 * Returns the value of the '<em><b>Modulation Floor 2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modulation Floor 2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modulation Floor 2</em>' attribute.
	 * @see #setModulationFloor_2(double)
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussian3ForcingDiseaseModel_ModulationFloor_2()
	 * @model
	 * @generated
	 */
	double getModulationFloor_2();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel#getModulationFloor_2 <em>Modulation Floor 2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modulation Floor 2</em>' attribute.
	 * @see #getModulationFloor_2()
	 * @generated
	 */
	void setModulationFloor_2(double value);

} // Gaussian3ForcingDiseaseModel
