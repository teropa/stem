// SIInfector.java
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
 * This interface defines a class in an EMF model for the initialization of an
 * infectious population in a Standard disease model.
 * 
 * The infector removes population members from the <em>Susceptible</em> state
 * to the <em>Infectious</em> state at at particular node.
 * 
 * @model
 */
public interface SIInfector extends StandardInfector {

	/**
	 * Returns the value of the '<em><b>Infectious Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infectious Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infectious Count</em>' attribute.
	 * @see #setInfectiousCount(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSIInfector_InfectiousCount()
	 * @model default="1"
	 * @generated
	 */
	double getInfectiousCount();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SIInfector#getInfectiousCount <em>Infectious Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infectious Count</em>' attribute.
	 * @see #getInfectiousCount()
	 * @generated
	 */
	void setInfectiousCount(double value);

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard infector type URI.
	 */
	String URI_TYPE_SI_INFECTOR_SEGMENT = URI_TYPE_STANDARD_INFECTOR_SEGMENT
			+ "/si";
} // SIInfector
