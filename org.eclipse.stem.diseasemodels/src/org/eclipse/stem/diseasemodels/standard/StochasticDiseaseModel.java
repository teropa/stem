// StochasticDiseaseModel.java
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

import java.util.Random;

/**
 * This interface defines an EMF model
 * @model abstract="true"
 */
public interface StochasticDiseaseModel extends DiseaseModel {

	
	/**
	 * @return the seed used to initialize the random number generator.
	 * @model default="0"
	 */
	long getSeed();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel#getSeed <em>Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seed</em>' attribute.
	 * @see #getSeed()
	 * @generated
	 */
	void setSeed(long value);

	/**
	 * @model changeable="false" default="0"
	 */
	Random getRandomGenerator();
} // StochasticDiseaseModel