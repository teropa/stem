package org.eclipse.stem.core.sequencer.impl;

/******************************************************************************* 
 * Copyright (c) 2007, 2008 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/

import java.text.SimpleDateFormat;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.stem.core.common.impl.IdentifiableImpl;

import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;

import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.stem.core.sequencer.SequencerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sequencer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#getCurrentTime <em>Current Time</em>}</li>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#getNextTime <em>Next Time</em>}</li>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#getTimeDelta <em>Time Delta</em>}</li>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#isTimeToStop <em>Time To Stop</em>}</li>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#getWorkComplete <em>Work Complete</em>}</li>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#getWorkIncrement <em>Work Increment</em>}</li>
 *   <li>{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl#getCycle <em>Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SequencerImpl extends IdentifiableImpl implements
		Sequencer {

	/**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartTime()
	 * @generated NOT
	 * @ordered
	 */
	protected STEMTime startTime = ModelFactory.eINSTANCE.createSTEMTime();

	/**
	 * The cached value of the '{@link #getEndTime() <em>End Time</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected STEMTime endTime;

	/**
	 * The cached value of the '{@link #getCurrentTime() <em>Current Time</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCurrentTime()
	 * @generated
	 * @ordered
	 */
	protected STEMTime currentTime;

	/**
	 * The default value of the '{@link #getTimeDelta() <em>Time Delta</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTimeDelta()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_DELTA_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimeDelta() <em>Time Delta</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTimeDelta()
	 * @generated
	 * @ordered
	 */
	protected long timeDelta = TIME_DELTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final long DURATION_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected long duration = DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isTimeToStop() <em>Time To Stop</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isTimeToStop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TIME_TO_STOP_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getWorkComplete() <em>Work Complete</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWorkComplete()
	 * @generated
	 * @ordered
	 */
	protected static final double WORK_COMPLETE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWorkComplete() <em>Work Complete</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWorkComplete()
	 * @generated
	 * @ordered
	 */
	protected double workComplete = WORK_COMPLETE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorkIncrement() <em>Work Increment</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWorkIncrement()
	 * @generated
	 * @ordered
	 */
	protected static final int WORK_INCREMENT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getCycle() <em>Cycle</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCycle()
	 * @generated
	 * @ordered
	 */
	protected static final int CYCLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCycle() <em>Cycle</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCycle()
	 * @generated
	 * @ordered
	 */
	protected int cycle = CYCLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SequencerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequencerPackage.Literals.SEQUENCER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public STEMTime getStartTime() {
		return (STEMTime) EcoreUtil.copy(startTime);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartTime(STEMTime newStartTime,
			NotificationChain msgs) {
		STEMTime oldStartTime = startTime;
		startTime = newStartTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencerPackage.SEQUENCER__START_TIME, oldStartTime, newStartTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(STEMTime newStartTime) {
		if (newStartTime != startTime) {
			NotificationChain msgs = null;
			if (startTime != null)
				msgs = ((InternalEObject)startTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencerPackage.SEQUENCER__START_TIME, null, msgs);
			if (newStartTime != null)
				msgs = ((InternalEObject)newStartTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencerPackage.SEQUENCER__START_TIME, null, msgs);
			msgs = basicSetStartTime(newStartTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencerPackage.SEQUENCER__START_TIME, newStartTime, newStartTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getEndTime() {
		return endTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndTime(STEMTime newEndTime,
			NotificationChain msgs) {
		STEMTime oldEndTime = endTime;
		endTime = newEndTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencerPackage.SEQUENCER__END_TIME, oldEndTime, newEndTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTime(STEMTime newEndTime) {
		if (newEndTime != endTime) {
			NotificationChain msgs = null;
			if (endTime != null)
				msgs = ((InternalEObject)endTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencerPackage.SEQUENCER__END_TIME, null, msgs);
			if (newEndTime != null)
				msgs = ((InternalEObject)newEndTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencerPackage.SEQUENCER__END_TIME, null, msgs);
			msgs = basicSetEndTime(newEndTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencerPackage.SEQUENCER__END_TIME, newEndTime, newEndTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public STEMTime getCurrentTime() {
		// Is the current time set yet?
		if (currentTime == null) {
			// No
			// Then the current time is the start time.
			setCurrentTime((STEMTime) EcoreUtil.copy(getStartTime()));
		}
		return (STEMTime) EcoreUtil.copy(currentTime);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurrentTime(STEMTime newCurrentTime,
			NotificationChain msgs) {
		STEMTime oldCurrentTime = currentTime;
		currentTime = newCurrentTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencerPackage.SEQUENCER__CURRENT_TIME, oldCurrentTime, newCurrentTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentTime(STEMTime newCurrentTime) {
		if (newCurrentTime != currentTime) {
			NotificationChain msgs = null;
			if (currentTime != null)
				msgs = ((InternalEObject)currentTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencerPackage.SEQUENCER__CURRENT_TIME, null, msgs);
			if (newCurrentTime != null)
				msgs = ((InternalEObject)newCurrentTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencerPackage.SEQUENCER__CURRENT_TIME, null, msgs);
			msgs = basicSetCurrentTime(newCurrentTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencerPackage.SEQUENCER__CURRENT_TIME, newCurrentTime, newCurrentTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public STEMTime getNextTime() {
		cycle++; // count this as a completed cycle
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeDelta() {
		return timeDelta;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getDuration() {
		// Can we compute a duration?
		if (duration == UNKNOWN_DURATION && getStartTime() != null
				&& getEndTime() != null) {
			// Yes
			duration = getEndTime().getTime().getTime()
					- getStartTime().getTime().getTime();
		}
		return duration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(long newDuration) {
		long oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencerPackage.SEQUENCER__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTimeToStop() {
		// TODO: implement this method to return the 'Time To Stop' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getWorkComplete() {
		return workComplete;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkComplete(double newWorkComplete) {
		double oldWorkComplete = workComplete;
		workComplete = newWorkComplete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencerPackage.SEQUENCER__WORK_COMPLETE, oldWorkComplete, workComplete));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getWorkIncrement() {
		// TODO: implement this method to return the 'Work Increment' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getCycle() {
		return cycle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCycle(int newCycle) {
		int oldCycle = cycle;
		cycle = newCycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencerPackage.SEQUENCER__CYCLE, oldCycle, cycle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void reset() {
		setCurrentTime((STEMTime) EcoreUtil.copy(getStartTime()));
		setWorkComplete(0);
		setCycle(CYCLE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SequencerPackage.SEQUENCER__START_TIME:
				return basicSetStartTime(null, msgs);
			case SequencerPackage.SEQUENCER__END_TIME:
				return basicSetEndTime(null, msgs);
			case SequencerPackage.SEQUENCER__CURRENT_TIME:
				return basicSetCurrentTime(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SequencerPackage.SEQUENCER__START_TIME:
				return getStartTime();
			case SequencerPackage.SEQUENCER__END_TIME:
				return getEndTime();
			case SequencerPackage.SEQUENCER__CURRENT_TIME:
				return getCurrentTime();
			case SequencerPackage.SEQUENCER__NEXT_TIME:
				return getNextTime();
			case SequencerPackage.SEQUENCER__TIME_DELTA:
				return new Long(getTimeDelta());
			case SequencerPackage.SEQUENCER__DURATION:
				return new Long(getDuration());
			case SequencerPackage.SEQUENCER__TIME_TO_STOP:
				return isTimeToStop() ? Boolean.TRUE : Boolean.FALSE;
			case SequencerPackage.SEQUENCER__WORK_COMPLETE:
				return new Double(getWorkComplete());
			case SequencerPackage.SEQUENCER__WORK_INCREMENT:
				return new Integer(getWorkIncrement());
			case SequencerPackage.SEQUENCER__CYCLE:
				return new Integer(getCycle());
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
			case SequencerPackage.SEQUENCER__START_TIME:
				setStartTime((STEMTime)newValue);
				return;
			case SequencerPackage.SEQUENCER__END_TIME:
				setEndTime((STEMTime)newValue);
				return;
			case SequencerPackage.SEQUENCER__CURRENT_TIME:
				setCurrentTime((STEMTime)newValue);
				return;
			case SequencerPackage.SEQUENCER__DURATION:
				setDuration(((Long)newValue).longValue());
				return;
			case SequencerPackage.SEQUENCER__WORK_COMPLETE:
				setWorkComplete(((Double)newValue).doubleValue());
				return;
			case SequencerPackage.SEQUENCER__CYCLE:
				setCycle(((Integer)newValue).intValue());
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
			case SequencerPackage.SEQUENCER__START_TIME:
				setStartTime((STEMTime)null);
				return;
			case SequencerPackage.SEQUENCER__END_TIME:
				setEndTime((STEMTime)null);
				return;
			case SequencerPackage.SEQUENCER__CURRENT_TIME:
				setCurrentTime((STEMTime)null);
				return;
			case SequencerPackage.SEQUENCER__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case SequencerPackage.SEQUENCER__WORK_COMPLETE:
				setWorkComplete(WORK_COMPLETE_EDEFAULT);
				return;
			case SequencerPackage.SEQUENCER__CYCLE:
				setCycle(CYCLE_EDEFAULT);
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
			case SequencerPackage.SEQUENCER__START_TIME:
				return startTime != null;
			case SequencerPackage.SEQUENCER__END_TIME:
				return endTime != null;
			case SequencerPackage.SEQUENCER__CURRENT_TIME:
				return currentTime != null;
			case SequencerPackage.SEQUENCER__NEXT_TIME:
				return getNextTime() != null;
			case SequencerPackage.SEQUENCER__TIME_DELTA:
				return timeDelta != TIME_DELTA_EDEFAULT;
			case SequencerPackage.SEQUENCER__DURATION:
				return duration != DURATION_EDEFAULT;
			case SequencerPackage.SEQUENCER__TIME_TO_STOP:
				return isTimeToStop() != TIME_TO_STOP_EDEFAULT;
			case SequencerPackage.SEQUENCER__WORK_COMPLETE:
				return workComplete != WORK_COMPLETE_EDEFAULT;
			case SequencerPackage.SEQUENCER__WORK_INCREMENT:
				return getWorkIncrement() != WORK_INCREMENT_EDEFAULT;
			case SequencerPackage.SEQUENCER__CYCLE:
				return cycle != CYCLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");

		final StringBuffer result = new StringBuffer();
		result.append(dateFormat.format(startTime.getTime()));

		if (endTime != null) {
			result.append(" to ");
			result.append(dateFormat.format(endTime.getTime()));
		}

		if (currentTime != null) {
			result.append(", current=");
			result.append(dateFormat.format(currentTime.getTime()));
		}

		result.append(" (timeDelta: "); //$NON-NLS-1$
		result.append(timeDelta);
		result.append(" (");
		final long days = timeDelta / STEMTime.Units.DAY.getMilliseconds();
		result.append(days);
		result.append(days == 1 ? " day)" : " days)");
		result.append(", duration: "); //$NON-NLS-1$
		result.append(duration);
		result.append(", workComplete: "); //$NON-NLS-1$
		result.append(workComplete);
		result.append(')');
		return result.toString();
	}

} // SequencerImpl
