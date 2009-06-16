// SIRInoculator.java
package org.eclipse.stem.diseasemodels.standard;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
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
 * inoculated population in a Standard disease model.
 * 
 * The inoculator removes a fraction of the population from the <em>Susceptible</em> state
 * to the <em>Recovered</em> state at at particular node.
 * 
 * @model
 */
public interface SIRInoculator extends SIInfector {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard infector or inoculator type URI.
	 */
	String URI_TYPE_SIR_INFECTOR_SEGMENT = URI_TYPE_STANDARD_INFECTOR_SEGMENT
			+ "/sir";
	
	/**
	 * @return the number percentage of the population to be inoculated
	 * @model default="1";
	 */
	double getInoculatedPercentage();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SIRInoculator#getInoculatedPercentage <em>Inoculated Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inoculated Percentage</em>' attribute.
	 * @see #getInoculatedPercentage()
	 * @generated
	 */
	void setInoculatedPercentage(double value);
	
	

} // SIInoculator
