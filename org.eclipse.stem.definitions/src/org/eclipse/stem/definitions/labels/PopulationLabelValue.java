// PopulationLabelValue.java
package org.eclipse.stem.definitions.labels;

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
 * This interface defines a class in an EMF model for a Population Label Value.
 * 
 * @model
 */
public interface PopulationLabelValue extends LabelValue {

	/**
	 * @return the number of population members
	 * @model
	 */
	double getCount();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.PopulationLabelValue#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(double value);

} // PopulationLabelValue
