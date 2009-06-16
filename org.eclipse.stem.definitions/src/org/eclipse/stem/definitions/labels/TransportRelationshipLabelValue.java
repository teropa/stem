// TransportRelationshipLabelValue.java
package org.eclipse.stem.definitions.labels;

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
 * The value of a transportation relationship label is the current available
 * capacity expressed as a proportion of the maximum capacity of the
 * transportation mode/identifier. Typically, this value will be 1.0 (100%), but
 * it could be reduced by travel restrictions.
 * 
 * @see TransportRelationshipLabel#getMaximumCapacity()
 * 
 * @model
 */
public interface TransportRelationshipLabelValue extends LabelValue {

	/**
	 * @return the proportion (i.e., 0.0-1.0) of the departure transportation
	 *         capacity that is available.
	 * @see TransportRelationshipLabel#getDepartureCapacity()
	 * @model default="1.0"
	 */
	double getAvailableDepartureCapacityProportion();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.TransportRelationshipLabelValue#getAvailableDepartureCapacityProportion <em>Available Departure Capacity Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Departure Capacity Proportion</em>' attribute.
	 * @see #getAvailableDepartureCapacityProportion()
	 * @generated
	 */
	void setAvailableDepartureCapacityProportion(double value);

} // TransportRelationshipLabelValue
