// SIRLabel.java
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
 * This interface defines a class in an EMF model for an SIR disease model
 * dynamic label.
 * 
 * @see StandardDiseaseModel
 * @see StandardDiseaseModelLabel
 * @see StandardDiseaseModelLabelValue
 * @see SI
 * @see SILabel
 * @see SILabelValue
 * @see SIR
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model
 */
public interface SIRLabel extends SILabel {

	/**
	 * This is the top-level segment for all type URI's for SIR disease model
	 * labels.
	 */
	String URI_TYPE_SIR_LABEL_SEGMENT = URI_TYPE_STANDARD_DISEASE_MODEL_LABEL_SEGMENT
			+ "/sir";

	/**
	 * This is the type URI for standard SIR disease labels
	 */
	URI URI_TYPE_SIR_LABEL = STEMURI.createTypeURI(URI_TYPE_SIR_LABEL_SEGMENT);

	/**
	 * @return the current number of "recovered" population members
	 */
	public double getR();

	/**
	 * @param r
	 *            the new value for the current number of "recovered" population
	 *            members
	 */
	public void setR(double r);

	/**
	 * @return the next number of "recovered" population members
	 */
	public double getNextR();

	/**
	 * @param r
	 *            the new value for the next number of "recovered" population
	 *            members
	 */
	public void setNextR(double r);

	/**
	 * @return the current SIR label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SIRLabelValue getCurrentSIRValue();

	/**
	 * @return the next SIR label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SIRLabelValue getNextSIRValue();
} // SIRLabel
