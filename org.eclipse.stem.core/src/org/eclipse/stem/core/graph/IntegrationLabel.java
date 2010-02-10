// IntegrationLabel
package org.eclipse.stem.core.graph;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.STEMTime;

/**
 * The interface is implemented by any label that is able to switch between 
 * current and next value optionally using an integration technique, for instance
 * the Runge Kutta numerical ODE solver.  
 */
public interface IntegrationLabel  extends EObject {

	/**
	 * @return The current value at this simulation cycle
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	LabelValue getCurrentValue();

	/**
	 * @return The next value at next simulation cycle
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	LabelValue getNextValue();

	
	/**
	 * @return The delta value that when added to the current value provides the next value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	LabelValue getDeltaValue();

	// The rest of the label values are for the Runge Kutta solver
	
	/**
	 * @return The temporary value used when the integrating solver advances to the next step
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	LabelValue getTempValue();

	/**
	 * @return The value to probe and calculate delta. This is the label value any disease model should use
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	LabelValue getProbeValue();

	/**
	 * @return The scale used to scale the error calculated by the integrating solver
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	LabelValue getErrorScale();

	// This label value is used for population model decorators to restore the original
	// population value to the correct number at the beginning of a simulation

	/**
	 * @return The original value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	LabelValue getOriginalValue();
	
	/**
	 * Return the decorator 
	 *
	 *@return Decorator
	 */
	
	Decorator getDecorator();
	
	/**
	 * setNextValueValud
	 * 
	 * @param value true if valid
	*/
	public void setNextValueValid(boolean value);
	
	/**
	 * Get the identifier, e.g. population identifier
	 * 
	 *@return String The identifier 
	 */
	
	public String getIdentifier();
	
	/**
	 * reset. Reset the label using the 
	 * stem time 
	 * 
	 * @param time STEM time
	 */
	
	public void reset(STEMTime time);
	
}
