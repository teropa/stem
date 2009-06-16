// CommonBorderRelationshipLabelValue.java
package org.eclipse.stem.definitions.labels;

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

/**
 * This interface defines a class in an EMF model for a Common border
 * Relationship Label Value.
 * 
 * @model
 */
public interface CommonBorderRelationshipLabelValue extends
		PhysicalRelationshipLabelValue{

	/**
	 * @return the length of the common border in kilometers
	 * @model
	 */
	double getBorderLength();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabelValue#getBorderLength <em>Border Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Length</em>' attribute.
	 * @see #getBorderLength()
	 * @generated
	 */
	void setBorderLength(double value);

} // CommonBorderRelationshipLabelValue
