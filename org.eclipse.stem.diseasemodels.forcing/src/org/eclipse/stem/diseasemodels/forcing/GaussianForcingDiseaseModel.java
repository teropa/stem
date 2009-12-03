/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.forcing;

import org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gaussian Forcing Disease Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getSigma2 <em>Sigma2</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationPeriod <em>Modulation Period</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationPhaseShift <em>Modulation Phase Shift</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationFloor <em>Modulation Floor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussianForcingDiseaseModel()
 * @model
 * @generated
 */
public interface GaussianForcingDiseaseModel extends StochasticSIRDiseaseModel {

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
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussianForcingDiseaseModel_Sigma2()
	 * @model
	 * @generated
	 */
	double getSigma2();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getSigma2 <em>Sigma2</em>}' attribute.
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
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussianForcingDiseaseModel_ModulationPeriod()
	 * @model
	 * @generated
	 */
	double getModulationPeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationPeriod <em>Modulation Period</em>}' attribute.
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
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussianForcingDiseaseModel_ModulationPhaseShift()
	 * @model
	 * @generated
	 */
	double getModulationPhaseShift();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationPhaseShift <em>Modulation Phase Shift</em>}' attribute.
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
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage#getGaussianForcingDiseaseModel_ModulationFloor()
	 * @model
	 * @generated
	 */
	double getModulationFloor();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationFloor <em>Modulation Floor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modulation Floor</em>' attribute.
	 * @see #getModulationFloor()
	 * @generated
	 */
	void setModulationFloor(double value);
} // GaussianForcingDiseaseModel
