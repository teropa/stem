package org.eclipse.stem.core.sequencer.impl;

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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.CorePlugin;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.sequencer.RealTimeSequencer;
import org.eclipse.stem.core.sequencer.SequencerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Real Time Sequencer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RealTimeSequencerImpl extends SequentialSequencerImpl implements
		RealTimeSequencer {
	/**
	 * If <code>true</code> then the method {@link #getNextCalled()} has been
	 * called once. This is checked below in {@link #getStartTime()}.
	 */
	private boolean getNextCalled = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RealTimeSequencerImpl() {
		super();
	}

	/**
	 * The start time for a real-time sequencer is the current time until there
	 * is a call to getNextTime(), at which point the start time is fixed.
	 * 
	 * @see #getNextCalled
	 * @see #getNextTime()
	 */
	@Override
	public STEMTime getStartTime() {
		// Has getNextTime been called yet.
		if (!getNextCalled) {
			// No
			return getCurrentSystemTime();
		} // if
		else {
			return super.getStartTime();
		}
	} // getStartTime

	/**
	 * @see org.eclipse.stem.core.sequencer.impl.SequentialSequencerImpl#getNextTime()
	 */
	@Override
	public STEMTime getNextTime() {
		super.getNextTime();
		
		// Is this our first call?
		if (!getNextCalled) {
			// Yes
			getNextCalled = true;
			// The start time is right now
			setStartTime(getCurrentSystemTime());
		} // if

		final STEMTime currentTime = getCurrentTime();
		
		final STEMTime timeToWakeUp = super.getNextTime();

		// Now we sleep until it is the next time
		sleepUntil(timeToWakeUp, currentTime);

		// We may or may not have woken up when we expected. Set the current
		// time to be whatever the time is now.
		setCurrentTime(getCurrentSystemTime());
		return getCurrentTime();
	} // getNextTime

	/**
	 * @param currentTime TODO
	 * @param retValue
	 */
	private void sleepUntil(STEMTime futureTime, STEMTime currentTime) {
		final long millisecondsToSleep = futureTime.getTime().getTime()
				- currentTime.getTime().getTime();
		try {
			Thread.sleep(millisecondsToSleep);
		} catch (InterruptedException e) {
			CorePlugin.logInformation(
					"RealTimeSequencer's sleep was interrupted", e);
		}
	} // sleepUntil

	/**
	 * @see org.eclipse.stem.core.sequencer.impl.SequencerImpl#setEndTime(org.eclipse.stem.core.model.STEMTime)
	 * @throws IllegalArgumentException
	 *             if the new end time is before the current (wall clock) time.
	 */
	@Override
	public void setEndTime(STEMTime newEndTime) {
		// The end time should be later than the current time
		final STEMTime currentTime = getCurrentSystemTime();
		if (isEndTimeBefore(currentTime)) {
			super.setEndTime(newEndTime);
		} // if
		else {
			throw new IllegalArgumentException("The new end time \""
					+ newEndTime.toString()
					+ "\" is not after the current time of \""
					+ currentTime.toString() + "\"");
		} // else
	} // setEndTime

	/**
	 * @see org.eclipse.stem.core.sequencer.impl.SequentialSequencerImpl#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		getNextCalled = false;
	} // reset

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequencerPackage.Literals.REAL_TIME_SEQUENCER;
	}

	/**
	 * @return the current real wall clock time as returned by the system.
	 */
	protected static STEMTime getCurrentSystemTime() {
		return ModelFactory.eINSTANCE.createSTEMTime();
	} // getCurrentSystemTime
} // RealTimeSequencerImpl
