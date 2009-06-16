// TransportRelationshipLabel.java
package org.eclipse.stem.definitions.labels;

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.graph.DynamicEdgeLabel;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.STEMTime;

/**
 * This interface is an EMF definition of a class that represents a label for an
 * Edge that represents the physical transportation of population members
 * between two nodes.
 * 
 * @model
 */
public interface TransportRelationshipLabel extends DynamicEdgeLabel {

	/**
	 * @model
	 */
	TransportMode getTransportMode();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.TransportRelationshipLabel#getTransportMode <em>Transport Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport Mode</em>' attribute.
	 * @see org.eclipse.stem.definitions.labels.TransportMode
	 * @see #getTransportMode()
	 * @generated
	 */
	void setTransportMode(TransportMode value);

	/**
	 * @model
	 */
	String getPopulationIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.TransportRelationshipLabel#getPopulationIdentifier <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Identifier</em>' attribute.
	 * @see #getPopulationIdentifier()
	 * @generated
	 */
	void setPopulationIdentifier(String value);

	/**
	 * @return the number of milliseconds it takes to transport the that defines
	 *         the rate at which population members are transported.
	 *         (Milliseconds)
	 * @see STEMTime
	 * @model
	 */
	long getRateTimePeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.TransportRelationshipLabel#getRateTimePeriod <em>Rate Time Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate Time Period</em>' attribute.
	 * @see #getRateTimePeriod()
	 * @generated
	 */
	void setRateTimePeriod(long value);

	/**
	 * @return the current number of population members that can depart given
	 *         the currently available departure capacity.
	 * @see TransportRelationshipLabelValue#getAvailableDepartureCapacityProportion()
	 * @see #getMaximumDepartureCapacity()
	 * @model volatile="true" transient="true" changeable="false"
	 */
	int getDepartureCapacity();

	/**
	 * @return the maximum number of population members that can depart using
	 *         the transportation mode/identifier each time period
	 * @see #getTimePeriod()
	 * @see #getMaximumCapacity()
	 * @see #getStartUpDelay()
	 * @model
	 */
	int getMaximumDepartureCapacity();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.TransportRelationshipLabel#getMaximumDepartureCapacity <em>Maximum Departure Capacity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Departure Capacity</em>' attribute.
	 * @see #getMaximumDepartureCapacity()
	 * @generated
	 */
	void setMaximumDepartureCapacity(int value);

	/**
	 * @return the current number of population members that can be in transit
	 *         at any one time.
	 * 
	 * @see TransportRelationshipLabelValue#getAvailableDepartureCapacityProportion()
	 * @see #getMaximumCapacity()
	 * @model volatile="true" transient="true" changeable="false"
	 */
	int getCapacity();

	/**
	 * @return the total maximum number of population members that can be in
	 *         transit at any one time.
	 * @see #getTimePeriod()
	 * @see #getCapacity()
	 * @see #getStartUpDelay()
	 * @model
	 */
	int getMaximumCapacity();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.TransportRelationshipLabel#getMaximumCapacity <em>Maximum Capacity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Capacity</em>' attribute.
	 * @see #getMaximumCapacity()
	 * @generated
	 */
	void setMaximumCapacity(int value);

	/**
	 * @return the number of milliseconds it takes population members to travel
	 *         from one <code>Node</code> to another using the the type of
	 *         transportation represented by the relationship.
	 * @model default=0
	 */
	long getTransitTime();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.TransportRelationshipLabel#getTransitTime <em>Transit Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transit Time</em>' attribute.
	 * @see #getTransitTime()
	 * @generated
	 */
	void setTransitTime(long value);

	/**
	 * @return the number of milliseconds it takes the transportation capacity
	 *         to linearly increase from zero to maximum capacity. The departure
	 *         capacity also increases at this rate from 0 to its maximum.
	 * @see #getMaximumCapacity()
	 * @see #getDepartureCapacity()
	 * @model default=0
	 */
	long getStartUpDelay();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.TransportRelationshipLabel#getStartUpDelay <em>Start Up Delay</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Up Delay</em>' attribute.
	 * @see #getStartUpDelay()
	 * @generated
	 */
	void setStartUpDelay(long value);

	/**
	 * @return a String that identifiers the specific transportation instance.
	 *         For example, this might be the name of a road.
	 * @model
	 */
	String getTransportIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.TransportRelationshipLabel#getTransportIdentifier <em>Transport Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport Identifier</em>' attribute.
	 * @see #getTransportIdentifier()
	 * @generated
	 */
	void setTransportIdentifier(String value);

	/**
	 * Send a representation of population members to be "transported" from the
	 * <code>Node</code> <code>here</code> to the other <code>Node</code>
	 * in the relationship.
	 * 
	 * @param here
	 *            the <code>Node</code> the population members depart from
	 * @param departees
	 *            the population member representation
	 */
	void send(final Node here, final EObject departees);

	/**
	 * Receive some travelers.
	 * 
	 * @param here
	 *            the <code>Node</code> of arrival
	 * @param currentTime
	 *            the current time of the simulation
	 * @return all of the representations of population members who have
	 *         traveled to the <code>Node</code> <code>here</code> by the
	 *         <code>currentTime</code>
	 * @see STEMTime
	 */
	EList<EObject> receive(final Node here, final STEMTime currentTime);

	/**
	 * @return the current transport relationship value
	 * @model volatile="true" transient="true" changeable="false"
	 *        resolveProxies="false"
	 */
	TransportRelationshipLabelValue getCurrentTransportRelationshipLabelValue();
} // TransportRelationshipLabel
