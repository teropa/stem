// DeterministicSIDiseaseModel.java
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
 * This interface defines a class in an EMF model for an Deterministic SI
 * disease model.
 * 
 * @see SILabel
 * @see SILabelValue
 * 
 * @model
 */
public interface DeterministicSIDiseaseModel extends SI {
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard stochastic SI disease model type URI.
	 */
	String URI_TYPE_DETERMINISTIC_SI_DISEASE_MODEL_SEGMENT = URI_TYPE_STANDARD_SI_DISEASE_MODEL_SEGMENT
			+ "/deterministic";
} // DeterministicSIDiseaseModel