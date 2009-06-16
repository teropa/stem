// DiseaseModelLabelValue.java
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

import org.eclipse.stem.core.graph.LabelValue;

/**
 * This interface defines a class in an EMF model for an disease model label
 * value. The values of this label record the number of population members who
 * have been "born" and who have "died".
 * 
 * @model abstract="true"
 */

public interface DiseaseModelLabelValue extends LabelValue {

	/**
	 * This is the maximum value for any population.
	 */
	double MAX_POPULATION_VALUE = 1e12;
	
	/**
	 * Set the incidence.
	 * @param incidence
	 * @model
	 */
	double getIncidence();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getIncidence <em>Incidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incidence</em>' attribute.
	 * @see #getIncidence()
	 * @generated
	 */
	void setIncidence(double value);

	
	/**
	 * @return the number of population members who have been born
	 * @model default="0"
	 */
	double getBirths();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getBirths <em>Births</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Births</em>' attribute.
	 * @see #getBirths()
	 * @generated
	 */
	void setBirths(double value);

	/**
	 * @return the number of population members who have died
	 * @model default="0"
	 */
	double getDeaths();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getDeaths <em>Deaths</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deaths</em>' attribute.
	 * @see #getDeaths()
	 * @generated
	 */
	void setDeaths(double value);

	/**
	 * @return the number of population members who have died due to the disease
	 *         being modeled
	 * @model default="0"
	 */
	double getDiseaseDeaths();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getDiseaseDeaths <em>Disease Deaths</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disease Deaths</em>' attribute.
	 * @see #getDiseaseDeaths()
	 * @generated
	 */
	void setDiseaseDeaths(double value);

	/**
	 * Set the value of this disease model label to be the same as the value
	 * 
	 * @param value
	 *            the new value for this disease model value
	 * @return this instance with the new values
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	DiseaseModelLabelValue set(final DiseaseModelLabelValue value);

	/**
	 * Add the value of this disease model label to the value
	 * 
	 * @param value
	 *            the value to be added to this disease model value
	 * @return this instance with the sum of values
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	DiseaseModelLabelValue add(final DiseaseModelLabelValue value);

	/**
	 * Subtract the value of the passed disease model label value from this
	 * disease model label to the value.
	 * 
	 * @param value
	 *            the value to be added to this disease model value
	 * @return this instance with the difference of values
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	DiseaseModelLabelValue sub(final DiseaseModelLabelValue value);

	/**
	 * Multiply the values by a scale factor.
	 * 
	 * @param scaleFactor
	 * 	the multiplier
	 * @return this instance with the new scaled values
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	DiseaseModelLabelValue scale(final double scaleFactor);

	/**
	 * Add a scalar to each value
	 * 
	 * @param scalar
	 * 	The scalar
	 * @return this instance with the new added value
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	DiseaseModelLabelValue add(final double scaleFactor);

	/**
	 * Make the values absolute 
	 * 
	 * @return this instance with negative replaced with positive values
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	DiseaseModelLabelValue abs();

	/**
	 * Check to make sure that if this label value represents a
	 * delta, make sure that none of the delta changes causes
	 * the target label value to go negative. If so, adjust
	 * this value to avoid.
	 * 
	 * @return boolean True if an adjustment was made
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	 boolean adjustDelta(DiseaseModelLabelValue target);
		
	/**
	 * scaledmax. Return the max of the label values scaled using the
	 * passed in label value
	 * 
	 * @param scale Scale using this label value
	 * @return double The maximum value
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	double scaledmax(DiseaseModelLabelValue scale);
	
	/**
	 * @return the sum of the living population members in all states
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	double getPopulationCount();

	/**
	 * Set all population values in all states to zero.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void zeroOutPopulationCount();
} // DiseaseModelLabelValue
