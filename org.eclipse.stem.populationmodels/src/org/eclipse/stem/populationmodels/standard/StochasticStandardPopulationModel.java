/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stochastic Standard Population Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel#getGain <em>Gain</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStochasticStandardPopulationModel()
 * @model
 * @generated
 */
public interface StochasticStandardPopulationModel extends StandardPopulationModel {
	/**
	 * Returns the value of the '<em><b>Gain</b></em>' attribute.
	 * The default value is <code>"0.01"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gain</em>' attribute.
	 * @see #setGain(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStochasticStandardPopulationModel_Gain()
	 * @model default="0.01"
	 * @generated
	 */
	double getGain();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel#getGain <em>Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gain</em>' attribute.
	 * @see #getGain()
	 * @generated
	 */
	void setGain(double value);

} // StochasticStandardPopulationModel
