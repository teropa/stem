// CommonBorderRelationshipLabelValue.java
package org.eclipse.stem.definitions.labels;

/******************************************************************************* 
 * Copyright (c) 2008 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/

/**
 * This interface defines a class in an EMF model for Road Transport
 * Relationship Label Values.
 * 
 * @model
 */
public interface RoadTransportRelationshipLabelValue extends
		PhysicalRelationshipLabelValue{

	/**
	 * @return the name of the road
	 * @model default="road"
	 */
	String getRoadName();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.RoadTransportRelationshipLabelValue#getRoadName <em>Road Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Road Name</em>' attribute.
	 * @see #getRoadName()
	 * @generated
	 */
	void setRoadName(String value);

	/**
	 * @return the class of the road (e.g., Interstate, State Route, etc.)
	 * @model default="route"
	 */
	String getRoadClass();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.RoadTransportRelationshipLabelValue#getRoadClass <em>Road Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Road Class</em>' attribute.
	 * @see #getRoadClass()
	 * @generated
	 */
	void setRoadClass(String value);

	/**
	 * Roads may wander back and forth across a single border. This counts the crossings
	 * @return the number of times a road crosses a border between two locations
	 * @model default="1"
	 */
	int getNumberCrossings();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.RoadTransportRelationshipLabelValue#getNumberCrossings <em>Number Crossings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Crossings</em>' attribute.
	 * @see #getNumberCrossings()
	 * @generated
	 */
	void setNumberCrossings(int value);
	

} // RoadTransportRelationshipLabelValue
