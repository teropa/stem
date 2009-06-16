// Sequencer.java
package org.eclipse.stem.core.sequencer;

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

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.scenario.Scenario;

/**
 * A <code>Sequencer</code> is the computational unit that determines the
 * sequence of time points at which the state of the canonical {@link Graph} is
 * determined. It also is used to determine if and when the sequence terminates.
 * <p>
 * This interface definition is also an "Annotated Java Interface" that defines
 * one class in a <a href="http://www.uml.org/">UML</a> "model". The UML class
 * diagram for the model is in the <code>documentation</code> folder of the
 * project. This file and the other interfaces in this Java package are
 * processed by the Eclipse Modeling Framework (aka EMF <a
 * href="http://org.eclipse/emf">http://org.eclipse/emf</a>). to automatically
 * generate an implementation of the model. EMF is documented in the book <a
 * href="http://www.awprofessional.com/bookstore/product.asp?isbn=0131425420&rl=1">Eclipse
 * Modeling Framework </a> by Budinsky, et al.
 * </p>
 * @see Scenario#step()
 * @see STEMTime
 * 
 * @model abstract="true"
 */
public interface Sequencer extends Identifiable {

	/**
	 * This constant is returned by {@link #getEndTime()} when a
	 * <code>Sequencer</code> has no specified end time.
	 * 
	 * @see #getDuration()
	 */
	long UNKNOWN_DURATION = -1;

	/**
	 * @return the start time of the sequence.
	 * 
	 * @model resolveProxies="false" containment="true"
	 */
	STEMTime getStartTime();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.sequencer.Sequencer#getStartTime <em>Start Time</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' containment reference.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(STEMTime value);

	/**
	 * @return the ending time of the sequence, or {@link #UNKNOWN_DURATION} if
	 *         there is no end time.
	 * 
	 * @model resolveProxies="false" containment="true"
	 */
	STEMTime getEndTime();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.sequencer.Sequencer#getEndTime <em>End Time</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' containment reference.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(STEMTime value);

	/**
	 * @return the <code>Sequencer</code>'s current time.
	 * @model resolveProxies="false" containment="true"
	 */
	STEMTime getCurrentTime();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.sequencer.Sequencer#getCurrentTime <em>Current Time</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Time</em>' containment reference.
	 * @see #getCurrentTime()
	 * @generated
	 */
	void setCurrentTime(STEMTime value);

	/**
	 * @return the next time point in the sequence. As a side effect the
	 *         <code>sequencer</code>'s current time is set to the returned
	 *         value.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 *        resolveProxies="false"
	 */
	STEMTime getNextTime();

	/**
	 * @return the time difference in milliseconds between the value returned by
	 *         {@link  #getCurrentTime()} and that returned by
	 *         {@link #getNextTime()}. This value is only valid after a call to
	 *         {@link #getNextTime()}.
	 * 
	 * @see #getCurrentTime()
	 * @see #getNextTime()
	 * 
	 * @model changeable="false" transient="true"
	 */
	long getTimeDelta();

	/**
	 * @return the total amount of time in milliseconds in the sequence. If
	 *         there is no ending time specified for the sequence, the constant
	 *         {@link #UNKNOWN_DURATION} is returned.
	 * @see #UNKNOWN_DURATION
	 * @model default="-1"
	 */
	long getDuration();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.sequencer.Sequencer#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(long value);

	/**
	 * @return true if the sequence has ended.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	boolean isTimeToStop();

	/**
	 * Set the current time to the start time and prepare the
	 * <code>Sequencer</code> to begin computing the next time from that
	 * point. Also reset the amount of work complete
	 * 
	 * @see #getNextTime()
	 * @see #getWorkComplete()
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void reset();

	/**
	 * @return an value (0-100) representing the percentage of the sequence
	 *         that has been completed so far. If no end time has been
	 *         specified, then return 0.
	 * 
	 * @model
	 */
	double getWorkComplete();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.sequencer.Sequencer#getWorkComplete <em>Work Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Work Complete</em>' attribute.
	 * @see #getWorkComplete()
	 * @generated
	 */
	void setWorkComplete(double value);

	/**
	 * @return an integer (0-100) representing the percentage of the sequence
	 *         that was completed by the time delta between the previous two
	 *         calls to {@link #getNextTime()}
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	int getWorkIncrement();

	/**
	 * obtain the number of processing cycles that have 
	 * been completed.  
	 * It will return 0 if no cycles have been completed 
	 * or if the simulation was reset or is just starting.
	 * 
	 * @return number of completed cycles.
	 * @model default="0"
	 */
	int getCycle();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.sequencer.Sequencer#getCycle <em>Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cycle</em>' attribute.
	 * @see #getCycle()
	 * @generated
	 */
	void setCycle(int value);
	
} // Sequencer
