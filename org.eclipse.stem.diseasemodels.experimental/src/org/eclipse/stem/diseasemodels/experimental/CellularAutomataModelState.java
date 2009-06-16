// CellularAutomataModelState.java
package org.eclipse.stem.diseasemodels.experimental;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.SanityChecker;

/**
 * This interface defines a class in an EMF model that contains state
 * information for a STEM cellular automata model's computations from one simulation cycle
 * to another. The basic idea is that the cellular automata model can store state
 * information in an instance and attach it to a cellular automata model label such that
 * when it revisits the label to compute its value it can refer to the state
 * information to as part of its computation. For instance, if the value of
 * a label is dependent on the values of other labels, references to those
 * labels could be "cached" in the state instance and not recomputed for each
 * cycle.
 * 
 * @model abstract="true"
 * @implements SanityChecker
 */
public interface CellularAutomataModelState extends EObject, SanityChecker {

	/**
	 * @return the label associated with the state information
	 * @model
	 */
	CellularAutomataModelLabel getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.experimental.CellularAutomataModelState#getLabel <em>Label</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' container reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(CellularAutomataModelLabel value);

}// CellularAutomataModelState
