// SILabel.java
package org.eclipse.stem.diseasemodels.standard;

/*******************************************************************************
 * Copyright (c) 2006, 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * This interface defines a class in an EMF model for an SI disease model
 * dynamic label.
 * 
 * @see StandardDiseaseModel
 * @see StandardDiseaseModelLabel
 * @see StandardDiseaseModelLabelValue
 * @see SIR
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model
 */
public interface SILabel extends StandardDiseaseModelLabel {

	/**
	 * This is the top-level segment for all type URI's for SI disease model
	 * labels.
	 */
	String URI_TYPE_SI_LABEL_SEGMENT = URI_TYPE_STANDARD_DISEASE_MODEL_LABEL_SEGMENT
			+ "/si";

	/**
	 * @return the current number of "infectious" population members
	 */
	public double getI();

	/**
	 * @return set the current number of "infectious" population members
	 */
	public void setI(double i);

	
	/**
	 * @return the incidence - which is the "new infectious" or "new exposed" number that comes from
	 * the interaction term in any disease model. This corresponds to the count of actual new disease
	 * reports in real public health surveillance statistics.
	 */
	public double getIncidence();
	
	/**
	 * set the incidence - which is the "new infectious" or "new exposed" number that comes from
	 * the interaction term in any disease model. This corresponds to the count of actual new disease
	 * reports in real public health surveillance statistics.
	 */
	public void setIncidence(double incidence);



	/**
	 * @return the next number of "infectious" population members
	 */
	public double getNextI();

	/**
	 * @return set the number number of infectious population members
	 */
	public void setNextI(double i);

	/**
	 * @return the current SI label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SILabelValue getCurrentSIValue();

	/**
	 * @return the next SI label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SILabelValue getNextSIValue();

} // SILabel
