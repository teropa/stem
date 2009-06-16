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
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard infector type URI.
	 */
	String URI_TYPE_SI_INFECTOR_SEGMENT = URI_TYPE_STANDARD_INFECTOR_SEGMENT
			+ "/si";
	
	/**
	 * @return the number of population members to be infectious
	 * @model default="1";
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

} // SIInfector
