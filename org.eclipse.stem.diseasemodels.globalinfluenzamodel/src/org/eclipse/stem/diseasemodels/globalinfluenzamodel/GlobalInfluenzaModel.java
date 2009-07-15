/**
 * 
 */
package org.eclipse.stem.diseasemodels.globalinfluenzamodel;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
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
public interface GlobalInfluenzaModel  extends StochasticSIRDiseaseModel {

	
/**
 * Latitude of the Tropic of Cancer in Degrees (Tropic of Capricorn is -ve of this).
 */
public static final double TROPIC_OF_CANCER_LATITUDE = 23.439444;


/**
 * The modulation of the transmission coefficient of influenza is Latitude dependent.
 * We model this with a sigmoid function that goes from zero to one
 * with center at the tropic of cancer, and the tropic of capricorn.
 * The default width factor is 4.5 which gives the sigmoid a slope proportional to the 
 * observed variation in seasonal flu epidemics as a function of latitude in Brazil.
 * See: http://aje.oxfordjournals.org/cgi/content/full/165/12/1434
 * 
 * As our sigmoid we use the basic logistic function 1/1+exp(-x) 
 * so
 * Sigmoid Function (lat)  = SeasonalModulationFloor/(1.0 + exp((TROPIC_OF_CANCER_LATITUDE - abs(Lat))./4.5) );
 * This is near zero near the equator and goes to SeasonalModulationFloor above and below 
 * the tropics.
 * 
 * @return the Latitude Sigmoid width
 * @model default="4.50"
 */
double getLatitudeSigmoidWidth();

/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalInfluenzaModel#getLatitudeSigmoidWidth <em>Latitude Sigmoid Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude Sigmoid Width</em>' attribute.
	 * @see #getLatitudeSigmoidWidth()
	 * @generated
	 */
	void setLatitudeSigmoidWidth(double value);

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
	 * @see org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalinfluenzamodelPackage#getGlobalInfluenzaModel_SeasonalModulationExponent()
	 * @model default="2.0"
	 * @generated
	 */
double getSeasonalModulationExponent();

/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalInfluenzaModel#getSeasonalModulationExponent <em>Seasonal Modulation Exponent</em>}' attribute.
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
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalInfluenzaModel#getModulationPeriod <em>Modulation Period</em>}' attribute.
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
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalInfluenzaModel#getModulationPhaseShift <em>Modulation Phase Shift</em>}' attribute.
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
	 * @see org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalinfluenzamodelPackage#getGlobalInfluenzaModel_SeasonalModulationFloor()
	 * @model default="0.6"
	 * @generated
	 */
double getSeasonalModulationFloor();

/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalInfluenzaModel#getSeasonalModulationFloor <em>Seasonal Modulation Floor</em>}' attribute.
	 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seasonal Modulation Floor</em>' attribute.
	 * @see #getSeasonalModulationFloor()
	 * @generated
	 */
void setSeasonalModulationFloor(double value);
} // GlobalInfluenzaModel


