// DiseaseModel.java
package org.eclipse.stem.diseasemodels.standard;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.common.SanityChecker;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.modifier.Modifiable;

/**
 * This interface defines a class in an EMF model for an STEM Disease model. It
 * is the top-level disease model, all other disease models derive from this
 * class.
 * 
 * @model abstract="true"
 */
public interface DiseaseModel extends NodeDecorator, SanityChecker, Modifiable {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * disease model type URI.
	 */
	String URI_TYPE_DISEASEMODEL_SEGMENT = "diseasemodel";

	/**
	 * This is the "background" rate (i.e., in the absence of disease) at which
	 * population members (on average) transition from all of the other states
	 * (except <em>Pre-Born</em> and including Infectious) to the state
	 * <em>Dead</em>, per time period. For the population in the Infectious
	 * state the mortality rate may also be increased. This is specified by
	 * {@link #getInfectiousMortality()}.
	 * 
	 * 1/mortalityRate is the average life span in time periods, on average,
	 * that is takes for a population member to die from any state.
	 * 
	 * In typical models, the background mortality rate is specified to be the
	 * same as the "birth rate" to keep the population fixed.
	 * 
	 * @return the number of population members that die per time period
	 * @model default="5.5E-5"
	 */
	double getBackgroundMortalityRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getBackgroundMortalityRate <em>Background Mortality Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Mortality Rate</em>' attribute.
	 * @see #getBackgroundMortalityRate()
	 * @generated
	 */
	void setBackgroundMortalityRate(double value);

	/**
	 * Compute the background mortality rate adjusted for a time delta
	 * potentially different from the time period specified for the rate.
	 * 
	 * @param timeDelta
	 *            the time period (milliseconds) to which the rate is to be
	 *            adjusted.
	 * @return the adjusted rate
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	double getAdjustedBackgroundMortalityRate(final long timeDelta);

	/**
	 * This is the name of the disease
	 * @return the name of the disease
	 * 
	 * @model
	 */
	String getDiseaseName();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getDiseaseName <em>Disease Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disease Name</em>' attribute.
	 * @see #getDiseaseName()
	 * @generated
	 */
	void setDiseaseName(String value);

	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Size</em>' attribute.
	 * @see #setStepSize(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModel_StepSize()
	 * @model default="1.0"
	 * @generated
	 */
	double getStepSize();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' attribute.
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(double value);

	/**
	 * Returns the value of the '<em><b>Current X</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current X</em>' attribute.
	 * @see #setCurrentX(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModel_CurrentX()
	 * @model default="0.0"
	 * @generated
	 */
	double getCurrentX();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getCurrentX <em>Current X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current X</em>' attribute.
	 * @see #getCurrentX()
	 * @generated
	 */
	void setCurrentX(double value);

	/**
	 * Returns the value of the '<em><b>Relative Tolerance</b></em>' attribute.
	 * The default value is <code>"1E-9"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative Tolerance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relative Tolerance</em>' attribute.
	 * @see #setRelativeTolerance(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModel_RelativeTolerance()
	 * @model default="1E-9"
	 * @generated
	 */
	double getRelativeTolerance();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getRelativeTolerance <em>Relative Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Tolerance</em>' attribute.
	 * @see #getRelativeTolerance()
	 * @generated
	 */
	void setRelativeTolerance(double value);

	/**
	 * Returns the value of the '<em><b>Finite Difference</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finite Difference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finite Difference</em>' attribute.
	 * @see #setFiniteDifference(boolean)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModel_FiniteDifference()
	 * @model default="true"
	 * @generated
	 */
	boolean isFiniteDifference();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#isFiniteDifference <em>Finite Difference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finite Difference</em>' attribute.
	 * @see #isFiniteDifference()
	 * @generated
	 */
	void setFiniteDifference(boolean value);

	/**
	 * Returns the value of the '<em><b>Frequency Dependent</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frequency Dependent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frequency Dependent</em>' attribute.
	 * @see #setFrequencyDependent(boolean)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModel_FrequencyDependent()
	 * @model default="true"
	 * @generated
	 */
	boolean isFrequencyDependent();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#isFrequencyDependent <em>Frequency Dependent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frequency Dependent</em>' attribute.
	 * @see #isFrequencyDependent()
	 * @generated
	 */
	void setFrequencyDependent(boolean value);

	/**
	 * Returns the value of the '<em><b>Background Birth Rate</b></em>' attribute.
	 * The default value is <code>"5.5E-5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Birth Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Birth Rate</em>' attribute.
	 * @see #setBackgroundBirthRate(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModel_BackgroundBirthRate()
	 * @model default="5.5E-5"
	 * @generated
	 */
	double getBackgroundBirthRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getBackgroundBirthRate <em>Background Birth Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Birth Rate</em>' attribute.
	 * @see #getBackgroundBirthRate()
	 * @generated
	 */
	void setBackgroundBirthRate(double value);

	/**
	 * This is the identifier of the population being infected by a Disease.
	 * 
	 * @return the identifier of the Population affected by the disease.
	 * 
	 * @model default="human"
	 */
	String getPopulationIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getPopulationIdentifier <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Identifier</em>' attribute.
	 * @see #getPopulationIdentifier()
	 * @generated
	 */
	void setPopulationIdentifier(String value);

	/**
	 * The time period for the specified rates.  Default: 1 Day
	 * @return the time period (milliseconds) of the rates specified for this
	 *         disease model
	 * 
	 * @model default="86400000"
	 */
	long getTimePeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getTimePeriod <em>Time Period</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Period</em>' attribute.
	 * @see #getTimePeriod()
	 * @generated
	 */
	void setTimePeriod(long value);

	/**
	 * @return an instance of the disease model label that this disease model
	 *         updates.
	 * @model abstract="true"
	 */
	DiseaseModelLabel createDiseaseModelLabel();

	/**
	 * @return an instance of the disease model label value that this disease model
	 *         updates.
	 * @model abstract="true"
	 */
	DiseaseModelLabelValue createDiseaseModelLabelValue();
	
	/**
	 * @return an instance of the disease model state that this disease model
	 *         would use to hold computation state information attached to a
	 *         disease model label.
	 * @model abstract="true"
	 */
	DiseaseModelState createDiseaseModelState();

	/**
	 * @param diseaseModelState
	 *            the state information to be initialized
	 * @param diseaseModelLabel
	 *            the label to use to initialize the state information
	 * @return the initialized disease model state instance
	 * @model volatile="true" transient="true" changeable="false"
	 */
	DiseaseModelState initializeDiseaseState(
			DiseaseModelState diseaseModelState,
			DiseaseModelLabel diseaseModelLabel);

	
	/**
	 * @param diseaseModelLabel
	 *            the label to use to initialize the state information
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void initializeDiseaseState(
			DiseaseModelLabel diseaseModelLabel);

	/**
	 * @return a new instance of an infector for this disease model.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	Infector createInfector();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	double getAdjustedBackgroundBirthRate(long timeDelta);

} // DiseaseModel
