// SILabelValue.java
package org.eclipse.stem.diseasemodels.standard;

/*******************************************************************************
 * Copyright (c) 2006, 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * This interface defines a class in an EMF model for an SI disease model label
 * value. The values of this label record the number of population members who
 * are in one of two states with respect to a particular disease.
 * <ul>
 * <li><em>Susceptible</em> which means that they are not infected by the
 * disease, but they can become infected by the disease.</li>
 * <li><em>Infectious</em> which means that population members are infected
 * with the disease and they can infect others. </li>
 * </ul>
 * <p>
 * Sub-classes could introduce additional states in which population members
 * could exist.
 * </p>
 * 
 * @see SIR
 * @see SIRLabel
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model
 */
public interface SILabelValue extends StandardDiseaseModelLabelValue {

	/**
	 * @return the number of population members in the <em>Infectious</em>
	 *         state.
	 * @model
	 */
	double getI();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SILabelValue#getI <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>I</em>' attribute.
	 * @see #getI()
	 * @generated
	 */
	void setI(double value);

	/**
	 * @return the incidence - which is the "new infectious" or "new exposed" number that comes from
	 * the interaction term in any disease model. This corresponds to the count of actual new disease
	 * reports in real public health surveillance statistics.
	 * @see #getI()
	 *
	 */
	double getIncidence();

} // SILabelValue
