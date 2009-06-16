// StandardStochastiDiseaseModel.java
package org.eclipse.stem.diseasemodels.standard;

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


/**
 * This interface is an EMF model.
 * 
 * @model abstract="true"
 */
public interface StandardStochasticDiseaseModel extends StochasticDiseaseModel {


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model default="0.01"
	 */
	public double getGain();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel#getGain <em>Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gain</em>' attribute.
	 * @see #getGain()
	 * @generated
	 */
	void setGain(double value);

	/**
	 * @model volatile="true" transient="true" changeable="false"
	 */
	public double computeNoise();
	
} // StandardStochastiDiseaseModel