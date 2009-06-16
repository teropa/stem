// RelativePhysicalRelationshipLabelValue.java
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

import org.eclipse.stem.core.graph.LabelValue;

/**
 * This interface defines a class in an EMF model for a Physical Relationship
 * Label Value.
 * 
 * @model
 */
public interface RelativePhysicalRelationshipLabelValue extends LabelValue {

	/**
	 * True if the relationship involves physical contact (i.e. touching).
	 * @model
	 */
	boolean isAdjacent();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabelValue#isAdjacent <em>Adjacent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adjacent</em>' attribute.
	 * @see #isAdjacent()
	 * @generated
	 */
	void setAdjacent(boolean value);

	/**
	 * @return the physical relationship between two things.
	 * @model
	 */
	RelativePhysicalRelationship getRelationship();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabelValue#getRelationship <em>Relationship</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relationship</em>' attribute.
	 * @see org.eclipse.stem.definitions.labels.RelativePhysicalRelationship
	 * @see #getRelationship()
	 * @generated
	 */
	void setRelationship(RelativePhysicalRelationship value);

} // RelativePhysicalRelationshipLabelValue
