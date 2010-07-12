/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Seasonal Population Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getPhase <em>Phase</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getModulationAmplitude <em>Modulation Amplitude</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#isUseLatitude <em>Use Latitude</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getSeasonalPopulationModel()
 * @model
 * @generated
 */
public interface SeasonalPopulationModel extends StandardPopulationModel {
	/**
	 * Returns the value of the '<em><b>Phase</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phase</em>' attribute.
	 * @see #setPhase(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getSeasonalPopulationModel_Phase()
	 * @model default="0.0"
	 * @generated
	 */
	double getPhase();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getPhase <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase</em>' attribute.
	 * @see #getPhase()
	 * @generated
	 */
	void setPhase(double value);

	/**
	 * Returns the value of the '<em><b>Modulation Amplitude</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modulation Amplitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modulation Amplitude</em>' attribute.
	 * @see #setModulationAmplitude(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getSeasonalPopulationModel_ModulationAmplitude()
	 * @model default="1.0"
	 * @generated
	 */
	double getModulationAmplitude();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getModulationAmplitude <em>Modulation Amplitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modulation Amplitude</em>' attribute.
	 * @see #getModulationAmplitude()
	 * @generated
	 */
	void setModulationAmplitude(double value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * The default value is <code>"365.25"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getSeasonalPopulationModel_Period()
	 * @model default="365.25" changeable="false"
	 * @generated
	 */
	double getPeriod();

	/**
	 * Returns the value of the '<em><b>Use Latitude</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Latitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Latitude</em>' attribute.
	 * @see #setUseLatitude(boolean)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getSeasonalPopulationModel_UseLatitude()
	 * @model default="true"
	 * @generated
	 */
	boolean isUseLatitude();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#isUseLatitude <em>Use Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Latitude</em>' attribute.
	 * @see #isUseLatitude()
	 * @generated
	 */
	void setUseLatitude(boolean value);

} // SeasonalPopulationModel
