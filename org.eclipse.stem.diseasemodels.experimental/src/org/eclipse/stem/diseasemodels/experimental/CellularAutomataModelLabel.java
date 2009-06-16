// CellularAutomataModelLabel.java
package org.eclipse.stem.diseasemodels.experimental;

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
import org.eclipse.stem.core.graph.DynamicNodeLabel;

/**
 * This interface defines a class in an EMF model for an STEM Disease model
 * label. It is the top-level disease model, all other disease model labels
 * derive from this class.
 * 
 * @model abstract="true"
 */
public interface CellularAutomataModelLabel extends DynamicNodeLabel {

	/**
	 * This is the top-level segment for all type URI's for disease model
	 * labels.
	 */
	String URI_TYPE_DISEASE_MODEL_LABEL_SEGMENT = URI_TYPE_DYNAMIC_LABEL_SEGMENT
			+ "/diseasemodel";

	/**
	 * This is the type URI for disease model labels
	 */
	URI URI_TYPE_SIR_LABEL = STEMURI
			.createTypeURI(URI_TYPE_DISEASE_MODEL_LABEL_SEGMENT);

	

	/**
	 * @return the disease model state associated with this label (if any).
	 * @model containment="true" opposite="label"
	 */
	CellularAutomataModelState getCellularAutomataModelState();

	/**
	 * Sets the value of the '<em>Disease Model State</em> containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disease Model State</em>' containment reference.
	 * @generated
	 */
	void setCellularAutomataModelState(CellularAutomataModelState value);

	
	
	
	/**
	 * @return the current SI label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	CellularAutomataModelLabelValue getCurrentCellularAutomataModelLabelValue();

	/**
	 * @return the next SI label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	CellularAutomataModelLabelValue getNextCellularAutomataModelLabelValue();
} // CellularAutomataModelLabel
