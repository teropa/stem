// AggregatingSIDiseaseModel.java
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
 * This interface defines a class in an EMF model for an aggregating SI disease
 * model. This disease model determines its disease state values by summing
 * (aggregating) the (next) values of the labels of other SI disease models.
 * Typically, it is placed in a model that contains the target SI disease model
 * so that its
 * {@link Decorator#updateLabels(org.eclipse.stem.core.model.STEMTime, long)}
 * method will be called after the contained disease model. This ensures that
 * the "next" values that this model collects will be valid by the time it runs.
 * 
 * @see SILabel
 * @see SILabelValue
 * 
 * @model
 */
public interface AggregatingSIDiseaseModel extends SI {
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard stochastic SI disease model type URI.
	 */
	String URI_TYPE_AGGREGATING_SI_DISEASE_MODEL_SEGMENT = URI_TYPE_STANDARD_SI_DISEASE_MODEL_SEGMENT
			+ "/aggregating";
} // AggregatingSIDiseaseModel
