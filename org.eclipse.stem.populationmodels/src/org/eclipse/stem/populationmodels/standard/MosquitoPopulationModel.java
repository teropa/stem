/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard;

import org.eclipse.stem.core.model.IntegrationDecorator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mosquito Population Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getScalingFactor <em>Scaling Factor</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getTimePeriod <em>Time Period</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getMortalityRate <em>Mortality Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getMosquitoPopulationModel()
 * @model superTypes="org.eclipse.stem.populationmodels.standard.PopulationModel org.eclipse.stem.populationmodels.standard.IntegrationDecorator"
 * @generated
 */
public interface MosquitoPopulationModel extends PopulationModel, IntegrationDecorator {
	/**
	 * Returns the value of the '<em><b>Scaling Factor</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scaling Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scaling Factor</em>' attribute.
	 * @see #setScalingFactor(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getMosquitoPopulationModel_ScalingFactor()
	 * @model default="1.0"
	 * @generated
	 */
	double getScalingFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getScalingFactor <em>Scaling Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scaling Factor</em>' attribute.
	 * @see #getScalingFactor()
	 * @generated
	 */
	void setScalingFactor(double value);

	/**
	 * Returns the value of the '<em><b>Time Period</b></em>' attribute.
	 * The default value is <code>"86400000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Period</em>' attribute.
	 * @see #setTimePeriod(long)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getMosquitoPopulationModel_TimePeriod()
	 * @model default="86400000"
	 * @generated
	 */
	long getTimePeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getTimePeriod <em>Time Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Period</em>' attribute.
	 * @see #getTimePeriod()
	 * @generated
	 */
	void setTimePeriod(long value);

	/**
	 * Returns the value of the '<em><b>Mortality Rate</b></em>' attribute.
	 * The default value is <code>"0.05"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mortality Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mortality Rate</em>' attribute.
	 * @see #setMortalityRate(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getMosquitoPopulationModel_MortalityRate()
	 * @model default="0.05"
	 * @generated
	 */
	double getMortalityRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getMortalityRate <em>Mortality Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mortality Rate</em>' attribute.
	 * @see #getMortalityRate()
	 * @generated
	 */
	void setMortalityRate(double value);

} // MosquitoPopulationModel
