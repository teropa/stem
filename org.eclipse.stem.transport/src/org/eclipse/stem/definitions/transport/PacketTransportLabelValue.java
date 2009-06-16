package org.eclipse.stem.definitions.transport;

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
 * The value for the packet transport label. This has a capacity, indicating how big the system is.
 * 
 * @author jlessler
 *
 *@model
 */
public interface PacketTransportLabelValue extends LabelValue {

	/**
	 * Get the capacity for the network
	 * 
	 * @return the capacity of the network (units?)
	 * @model default=100.0
	 */
	double getCapacity();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.transport.PacketTransportLabelValue#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(double value);
	
}
