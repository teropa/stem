// CellularAutomataModelLabelValue.java
package org.eclipse.stem.diseasemodels.experimental;

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

import org.eclipse.stem.core.graph.LabelValue;

/**
 * This interface defines a class in an EMF model for an disease model label
 * value. The values of this label record the number of population members who
 * have been "born" and who have "died".
 * 
 * @model abstract="true"
 */

public interface CellularAutomataModelLabelValue extends LabelValue {

	
	
	/**
	 * @return the genome property 
	 * @model default="0"
	 */
	double getGenome();

	/**
	 * Sets the value of the <em>Genome</em> attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Births</em>' attribute.
	 * @generated
	 */
	void setGenome(String value);


	/**
	 * Set the value of this disease model label to be the same as the value
	 * 
	 * @param value
	 *            the new value for this disease model value
	 * @return this instance with the new values
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	CellularAutomataModelLabelValue set(final CellularAutomataModelLabelValue value);

	/**
	 * Add the value of this disease model label to the value
	 * 
	 * @param value
	 *            the value to be added to this disease model value
	 * @return this instance with the sum of values
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	CellularAutomataModelLabelValue add(final CellularAutomataModelLabelValue value);

	
} // CellularAutomataModelLabelValue
