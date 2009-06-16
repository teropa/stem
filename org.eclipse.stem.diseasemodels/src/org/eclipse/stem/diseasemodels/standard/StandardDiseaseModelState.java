// StandardDiseaseModelState.java
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
 * This interface defines a class in an EMF model that contains state
 * information for a standard STEM disease model's computations from one
 * simulation cycle to another.
 * 
 * @model abstract="true"
 */
public interface StandardDiseaseModelState extends DiseaseModelState {

	/**
	 * 
	 * @return the ratio between the total area of all {@link Node}s processed
	 *         by the {@link StandardDiseaseModel} and the area of the
	 *         {@link Node} that the {@link DiseaseModelLabel} is associated
	 *         with.
	 * @model
	 */
	double getAreaRatio();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState#getAreaRatio <em>Area Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area Ratio</em>' attribute.
	 * @see #getAreaRatio()
	 * @generated
	 */
	void setAreaRatio(double value);

}// StandardDiseaseModelState
