// ExampleDiseaseModel.java
package org.eclipse.stem.diseasemodels.example;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
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
 * This interface is an EMF Model.
 * 
 * @model
 */
public interface ExampleDiseaseModel extends StochasticSIRDiseaseModel {
	/**
	 * Returns the value of the '<em><b>Seasonal Modulation Exponent</b></em>' attribute.
	 * The default value is <code>"2.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seasonal Modulation Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seasonal Modulation Exponent</em>' attribute.
	 * @see #setSeasonalModulationExponent(double)
	 * @see org.eclipse.stem.diseasemodels.example.ExamplePackage#getExampleDiseaseModel_SeasonalModulationExponent()
	 * @model default="2.0"
	 * @generated
	 */
	double getSeasonalModulationExponent();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.example.ExampleDiseaseModel#getSeasonalModulationExponent <em>Seasonal Modulation Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seasonal Modulation Exponent</em>' attribute.
	 * @see #getSeasonalModulationExponent()
	 * @generated
	 */
	void setSeasonalModulationExponent(double value);

	/**
	 * @return the default modulation period is 1 year. This default value assumes time steps in days. Note that one year = 365.256363051 days 
	 * @model default="365.256363051"
	 */
	double getModulationPeriod();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.example.ExampleDiseaseModel#getModulationPeriod <em>Modulation Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modulation Period</em>' attribute.
	 * @see #getModulationPeriod()
	 * @generated
	 */
	void setModulationPeriod(double value);

	/**
	 * @return the modulation phase shift shift. 
	 * @model default="0.0"
	 */
	double getModulationPhaseShift();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.example.ExampleDiseaseModel#getModulationPhaseShift <em>Modulation Phase Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modulation Phase Shift</em>' attribute.
	 * @see #getModulationPhaseShift()
	 * @generated
	 */
	void setModulationPhaseShift(double value);

	/**
	 * Returns the value of the '<em><b>Seasonal Modulation Floor</b></em>' attribute.
	 * The default value is <code>"0.6"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seasonal Modulation Floor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seasonal Modulation Floor</em>' attribute.
	 * @see #setSeasonalModulationFloor(double)
	 * @see org.eclipse.stem.diseasemodels.example.ExamplePackage#getExampleDiseaseModel_SeasonalModulationFloor()
	 * @model default="0.6"
	 * @generated
	 */
	double getSeasonalModulationFloor();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.example.ExampleDiseaseModel#getSeasonalModulationFloor <em>Seasonal Modulation Floor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seasonal Modulation Floor</em>' attribute.
	 * @see #getSeasonalModulationFloor()
	 * @generated
	 */
	void setSeasonalModulationFloor(double value);
} // ExampleDiseaseModel
