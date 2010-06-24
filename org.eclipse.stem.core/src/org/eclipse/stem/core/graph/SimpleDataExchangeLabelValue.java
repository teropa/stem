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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * The interface is used for various models to exchange information with each other. A population model 
 * uses this interface to report births/deaths and inflow/outflow via migration. A disease model uses
 * it to report disease deaths.
 */
public interface SimpleDataExchangeLabelValue  extends EObject {

	/**
	 * getArrivals. 
	 * 
	 * @return Map<Node, Double> A map where the key is the source of the arrival (can be local node for births)
	 */
	
	public Map<Node, Double> getArrivals();
	
	/**
	 * getDepartures
	 * 
	 * @return Map<Node, Double> A map where the key is the source of the departure (can be local node for deaths)
	 */
	
	public Map<Node, Double> getDepartures();
	
}
