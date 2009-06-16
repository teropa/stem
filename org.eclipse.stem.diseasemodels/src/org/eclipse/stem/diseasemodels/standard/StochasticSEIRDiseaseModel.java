// StochasticSEIRDiseaseModel.java
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
 * This interface defines a class in an EMF model for an Stochastic SEIR disease
 * model.
 * 
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model
 */
public interface StochasticSEIRDiseaseModel extends SEIR, StandardStochasticDiseaseModel {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard stochastic SEIR disease model type URI.
	 */
	String URI_TYPE_STOCHASTIC_SEIR_DISEASE_MODEL_SEGMENT = URI_TYPE_STANDARD_SEIR_DISEASE_MODEL_SEGMENT
			+ "/stochastic";

} // StochasticSEIRDiseaseModel
