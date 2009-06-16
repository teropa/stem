// SEIRLabel.java
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;


/**
 * This interface defines a class in an EMF model for a standard SEIR disease
 * model dynamic label.
 * 
 * @see StandardDiseaseModel
 * @see StandardDiseaseModelLabel
 * @see StandardDiseaseModelLabelValue
 * @see SI
 * @see SILabel
 * @see SILabelValue
 * @see SIR
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabelValue
 * 
 * @model
 */
public interface SEIRLabel extends SIRLabel {

	/**
	 * This is the top-level segment for all type URI's for SEIR disease model
	 * labels.
	 */
	String URI_TYPE_SEIR_LABEL_SEGMENT = URI_TYPE_STANDARD_DISEASE_MODEL_LABEL_SEGMENT
			+ "/seir";

	/**
	 * This is the type URI for standard SEIR disease labels
	 */
	URI URI_TYPE_SEIR_LABEL = STEMURI
			.createTypeURI(URI_TYPE_SEIR_LABEL_SEGMENT);

	/**
	 * @return the current number of "exposed" population members
	 */
	public double getE();

	/**
	 * @param e
	 *            the new value for the current number of "exposed" population
	 *            members
	 */
	public void setE(double e);

	/**
	 * @return the next number of "exposed" population members
	 */
	public double getNextE();

	/**
	 * @param e
	 *            the new value for the next number of "exposed" population
	 *            members
	 */
	public void setNextE(double e);

	/**
	 * @return the current SEIR label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SEIRLabelValue getCurrentSEIRValue();

	/**
	 * @return the next SEIR label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SEIRLabelValue getNextSEIRValue();

} // SEIRLabel
