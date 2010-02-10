// StandardDiseaseModelLabel.java
package org.eclipse.stem.diseasemodels.standard;

import org.eclipse.stem.core.graph.IntegrationLabel;

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
 * This interface defines a class in an EMF model for a Standard Disease model
 * label. A standard disease model is one that computes the changes in
 * population state when there is a single <em>Susceptible</em> state.
 * 
 * @see SI
 * @see SILabel
 * @see SILabelValue
 * @see SIR
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model abstract="true"
 */
public interface StandardDiseaseModelLabel extends DiseaseModelLabel, IntegrationLabel {
	/**
	 * This is the top-level segment for all type URI's for standard disease
	 * model labels.
	 */
	String URI_TYPE_STANDARD_DISEASE_MODEL_LABEL_SEGMENT = URI_TYPE_DISEASE_MODEL_LABEL_SEGMENT
			+ "/standard";

	/**
	 * @return the current number of "susceptible" population members
	 */
	public double getS();

	/**
	 * @param s
	 *            the new value for the current number of "susceptible"
	 *            population members
	 */
	public void setS(double s);

	/**
	 * @return the next number of "susceptible" population members
	 */
	public double getNextS();

	/**
	 * @param s
	 *            the new value for the next number of "susceptible" population
	 *            members
	 */
	public void setNextS(double s);


} // StandardDiseaseModelLabel
