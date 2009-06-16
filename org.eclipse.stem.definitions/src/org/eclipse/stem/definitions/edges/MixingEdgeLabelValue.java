package org.eclipse.stem.definitions.edges;

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

import org.eclipse.stem.core.graph.LabelValue;


/**
 * Label value denoting the rate of mixing between two populations.
 * 
 * @model
 **/
public interface MixingEdgeLabelValue extends LabelValue {
		
	/**The rate of mixing between the two populations.
	 * 
	 * @model*/
	double getMixingRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.edges.MixingEdgeLabelValue#getMixingRate <em>Mixing Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mixing Rate</em>' attribute.
	 * @see #getMixingRate()
	 * @generated
	 */
	void setMixingRate(double value);

}
