// SEIRLabelValue.java
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
 * This interface defines a class in an EMF model for an SEIR disease model
 * label value. The values of this label record the number of population members
 * who are in one of four states with repsect to a particular disease.
 * <ul>
 * <li><em>Susceptible</em> which means that they are not infected by the
 * disease, but they can become exposed (and later infected) to the disease.</li>
 * <li><em>Exposed</em> which means that they are infected with the disease,
 * but are not yet infectious to others. </li>
 * <li><em>Infectious</em> which means that population members are infected
 * with the disease and they can infect others. </li>
 * <li><em>Recovered</em> which means that population members are not
 * infected with the disease and <em>cannot</em> become infected by the
 * disease. Note that in some disease models a population member in the
 * <em>Recovered</em> state could transition to the <em>Susceptible</em>
 * state and then become a candidate for re-infection.</li>
 * </ul>
 * <p>
 * Sub-classes could introduce additional states in which population members
 * could exist.
 * </p>
 * 
 * @see SIR
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * 
 * @model
 */
public interface SEIRLabelValue extends SIRLabelValue {

	/**
	 * @return the number of population members in the <em>Exposed</em> state.
	 * @model
	 */
	double getE();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabelValue#getE <em>E</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>E</em>' attribute.
	 * @see #getE()
	 * @generated
	 */
	void setE(double value);

} // SEIRLabelValue
