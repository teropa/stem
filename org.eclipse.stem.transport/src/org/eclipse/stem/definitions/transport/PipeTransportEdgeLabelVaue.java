package org.eclipse.stem.definitions.transport;

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

import org.eclipse.stem.core.graph.LabelValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipe Transport Edge Label Vaue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelVaue#getMaxFlow <em>Max Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @model
 * @generated
 */
public interface PipeTransportEdgeLabelVaue extends LabelValue {
	/**
	 * Returns the value of the '<em><b>Max Flow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Flow</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Flow</em>' attribute.
	 * @see #setMaxFlow(double)
	 * @model
	 * @generated
	 */
	double getMaxFlow();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelVaue#getMaxFlow <em>Max Flow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Flow</em>' attribute.
	 * @see #getMaxFlow()
	 * @generated
	 */
	void setMaxFlow(double value);

} // PipeTransportEdgeLabelVaue
