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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.sequencer.SequencerPackage;
import org.eclipse.stem.core.sequencer.SequentialSequencer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sequential Sequencer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequentialSequencerImpl#getTimeIncrement <em>Time Increment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequentialSequencerImpl extends SequencerImpl implements
		SequentialSequencer {
	/**
	 * The default value of the '{@link #getTimeIncrement() <em>Time Increment</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTimeIncrement()
	 * @generated NOT
	 * @ordered
	 */
	protected static final long TIME_INCREMENT_EDEFAULT = STEMTime.Units.DAY.getMilliseconds();

	/**
	 * The cached value of the '{@link #getTimeIncrement() <em>Time Increment</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTimeIncrement()
	 * @generated
	 * @ordered
	 */
	protected long timeIncrement = TIME_INCREMENT_EDEFAULT;

	/**
	 * This is an accumulator of the work increment that keeps account of the
	 * fraction of the work increments until they exceed 1.0
	 */
	private double workIncrementRunningTotal = 0.0;

	/**
	 * If <code>true</code> then the last value has been returned by
	 * {@link #getNextTime()}
	 */
	private boolean endOfSequenceReached = false;

	/**
	 * If <code>true</code> then the method {@link #getNextTime()} has not
	 * been called yet so when it is it should return the value returned by
	 * {@link #getStartTime()}
	 */
	private boolean getNextTimeNotCalled = true;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SequentialSequencerImpl() {
		super();
		// The time delta is always the same with a sequential sequencer
		timeDelta = getTimeIncrement();
	} // SequentialSequencerImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequencerPackage.Literals.SEQUENTIAL_SEQUENCER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeIncrement() {
		return timeIncrement;
	}

	/**
	 * @see org.eclipse.stem.scenario.impl.SequencerImpl#isTimeToStop()
	 */
	@Override
	public boolean isTimeToStop() {
		return endOfSequenceReached || isEndTimeBefore(getCurrentTime());
	} // isTimeToStop

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setTimeIncrement(long newTimeIncrement) {
		long oldTimeIncrement = timeIncrement;
		timeIncrement = newTimeIncrement;
		timeDelta = timeIncrement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SequencerPackage.SEQUENTIAL_SEQUENCER__TIME_INCREMENT,
					oldTimeIncrement, timeIncrement));
	}

	/**
	 * @see org.eclipse.stem.scenario.impl.SequencerImpl#getNextTime()
	 * 
	 * Among other things that this does, it increments the 
	 * count of the number of completed cycles. 
	 *
	 */
	@Override
	public STEMTime getNextTime() {
		super.getNextTime();
		
		STEMTime nextTime = null;
		// Is this our first call?
		if (getNextTimeNotCalled) {
			// Yes
			// then the start time is the first value to return, we don't
			// test for it relationship to the end time here.  This makes
			// it possible that the value returned would be after the end time.
			nextTime = getStartTime();
			getNextTimeNotCalled = false;
		} // if first call
		else {
			final STEMTime potentialNextTime = getCurrentTime().addIncrement(
					getTimeIncrement());
			
			// Was an end time specified and is it before the potential next
			// time?
			if (isEndTimeBefore(potentialNextTime)) {
				// Yes
				// Then the end time is the next value to return
				nextTime = (STEMTime) EcoreUtil.copy(getEndTime());
			} // if end time specified
			else {
				nextTime = potentialNextTime;
			} // else

			// Are we returning a value equal to the specified end time?
			if (nextTime.equals(getEndTime())) {
				// Yes
				// ok, then this is the last value of the sequence. The next
				// call
				// to isTimeToStop() should fail
				endOfSequenceReached = true;
			} // if
		} // else not first call
		setCurrentTime(nextTime);
		setWorkComplete(Math.min(getWorkComplete() + getWorkIncrement(), 100));
		
		return getCurrentTime();
	} // getNextTime

	/**
	 * @param time
	 * @return <code>true</code> if the end time is specified and it is before
	 *         the current time, <code>false</code>, otherwise.
	 */
	protected boolean isEndTimeBefore(STEMTime time) {
		return getEndTime() != null
				&& (getEndTime().getTime().before(time.getTime()));
	} // isEndTimeBefore

	/**
	 * @see org.eclipse.stem.scenario.impl.SequencerImpl#getWorkIncrement()
	 */
	@SuppressWarnings("cast")
	@Override
	public int getWorkIncrement() {
		int retValue = 0;
		// Is there a work increment?
		if (getDuration() != UNKNOWN_DURATION) {
			// Yes
			// The work increment could be fractional (<1.0). If so then it will
			// not accumulate in the progress monitor. So, we keep a running sum
			// of the work increment and when it exceeds 1.0 we return the value
			// less the fractional part and keep that for the future.
			workIncrementRunningTotal += 100.0 * (double) getTimeIncrement()
					/ (double) (getDuration()+getTimeIncrement());

			// Do we have more than 1.0?
			if (workIncrementRunningTotal >= 1.0) {
				// Yes
				retValue = (int) workIncrementRunningTotal;
				workIncrementRunningTotal -= retValue;
			}
		}

		return retValue;

	} // getWorkIncrement

	/**
	 * handle what needs to be done when a simulation is reset.
	 */
	@Override
	public void reset() {
		super.reset();
		workIncrementRunningTotal = 0.0;
		getNextTimeNotCalled = true;
		endOfSequenceReached = false;
	} // reset
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SequencerPackage.SEQUENTIAL_SEQUENCER__TIME_INCREMENT:
				return getTimeIncrement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SequencerPackage.SEQUENTIAL_SEQUENCER__TIME_INCREMENT:
				setTimeIncrement((Long)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SequencerPackage.SEQUENTIAL_SEQUENCER__TIME_INCREMENT:
				setTimeIncrement(TIME_INCREMENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SequencerPackage.SEQUENTIAL_SEQUENCER__TIME_INCREMENT:
				return timeIncrement != TIME_INCREMENT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (timeIncrement: "); //$NON-NLS-1$
		result.append(timeIncrement);
		result.append(')');
		return result.toString();
	}

} // SequentialSequencerImpl
