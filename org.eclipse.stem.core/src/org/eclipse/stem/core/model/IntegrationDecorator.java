package org.eclipse.stem.core.model;

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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.LabelValue;

/**
 * The interface is implemented by any decorator able to calculate a delta (change)
 * value given a current value and a time 
 */
public interface IntegrationDecorator extends EObject {

	/**
	 * Method invoked to calculate a delta 
	 * 
	 * @param time The STEM time
	 * @param timeDelta The number of ms for a single cycle of the simulation
	 * @param labels The labels to update
	 */
	void calculateDelta(STEMTime time, long timeDelta, EList<DynamicLabel> labels);

	/**
	 * applyExternalDeltas. After calculateDelta has been invoked for all
	 * integration decorators on a simulation, each decorator can adjust
	 * it's own delta values taking into account deltas calculated by 
	 * other decorators the the same node. For instance, in an SIR model
	 * people are removed from each compartment that depends on deaths
	 * calculated by general background deaths (from Population Models)
	 * and deaths caused by other diseases (disease models) 
	 * 
	 * @param time The STEM time
	 * @param timeDelta The number of ms for a single cycle of the simulation
	 * @param labels The labels to update
	 */
	void applyExternalDeltas(STEMTime time, long timeDelta, EList<DynamicLabel> labels);

	
	/**
	 * Invoked at the end of a simulation cycle to add additional perturbations
	 * such as noise.
	 */
	void doModelSpecificAdjustments(LabelValue label);

	/**
	 * Determine whether the decorator is deterministic. The developer returns
	 * the proper value here depending upon whether calculatedDelta always
	 * returns the same delta for the same input
	 * 
	 * @return true If the decorator is deterministic, false otherwise
	 */
	public boolean isDeterministic();
}
