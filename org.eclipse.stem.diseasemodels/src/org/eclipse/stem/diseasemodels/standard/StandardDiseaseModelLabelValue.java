// StandardDiseaseModelLabelValue.java
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

/**
 * This interface defines a class in an EMF model for an Standard disease model
 * label value. In a standard disease model population members can be in a
 * single <em>Susceptible</em> state, which means that they are not exposed or
 * infected by a disease. Sub-classes could introduce additional states in which
 * population members could exist.
 * 
 * @see SIR
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model abstract="true"
 */

public interface StandardDiseaseModelLabelValue extends DiseaseModelLabelValue {
	/**
	 * @return the number of population members in the <em>Susceptible</em>
	 *         state.
	 * @model
	 */
	double getS();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue#getS <em>S</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>S</em>' attribute.
	 * @see #getS()
	 * @generated
	 */
	void setS(double value);


} // StandardDiseaseModelLabelValue
