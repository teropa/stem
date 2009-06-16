// AggregatingDiseaseModelState.java
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

import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.common.util.EMap;

/**
 * This class represents the state of an aggregate disease model at a label.
 * 
 * @model
 */
public interface AggregatingDiseaseModelState extends DiseaseModelState {

	/**
	 * @return the disease model labels whose values are to be aggregated
	 * @model type="SILabel" containment="false"
	 */
	EList<SILabel> getChildrensLabels();

} // AggregatingDiseaseModelState
