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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
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
	 * The default value of the '{@link #getTimeDelta() <em>Time Delta</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTimeDelta()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_DELTA_EDEFAULT = 0L;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final long DURATION_EDEFAULT = -1L;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SequencerImpl() {
		super();
		if (!eDynamicIsSet(SequencerPackage.SEQUENCER__START_TIME)) {
			setStartTime(ModelFactory.eINSTANCE.createSTEMTime());
		}
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
		return (STEMTime)eDynamicGet(SequencerPackage.SEQUENCER__START_TIME, SequencerPackage.Literals.SEQUENCER__START_TIME, true, true);
//		return (STEMTime) EcoreUtil.copy(startTime);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartTime(STEMTime newStartTime,
			NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newStartTime, SequencerPackage.SEQUENCER__START_TIME, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(STEMTime newStartTime) {
		eDynamicSet(SequencerPackage.SEQUENCER__START_TIME, SequencerPackage.Literals.SEQUENCER__START_TIME, newStartTime);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getEndTime() {
		return (STEMTime)eDynamicGet(SequencerPackage.SEQUENCER__END_TIME, SequencerPackage.Literals.SEQUENCER__END_TIME, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndTime(STEMTime newEndTime,
			NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newEndTime, SequencerPackage.SEQUENCER__END_TIME, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTime(STEMTime newEndTime) {
		eDynamicSet(SequencerPackage.SEQUENCER__END_TIME, SequencerPackage.Literals.SEQUENCER__END_TIME, newEndTime);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public STEMTime getCurrentTime() {
		STEMTime currentTime = (STEMTime)eDynamicGet(SequencerPackage.SEQUENCER__CURRENT_TIME, SequencerPackage.Literals.SEQUENCER__CURRENT_TIME, true, true);
		// Is the current time set yet?
		if (currentTime == null) {
			// No
			// Then the current time is the start time.
			currentTime = (STEMTime) EcoreUtil.copy(getStartTime());
			setCurrentTime(currentTime);
		}
		return (STEMTime) EcoreUtil.copy(currentTime);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurrentTime(STEMTime newCurrentTime,
			NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newCurrentTime, SequencerPackage.SEQUENCER__CURRENT_TIME, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentTime(STEMTime newCurrentTime) {
		eDynamicSet(SequencerPackage.SEQUENCER__CURRENT_TIME, SequencerPackage.Literals.SEQUENCER__CURRENT_TIME, newCurrentTime);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public STEMTime getNextTime() {
		setCycle(getCycle() + 1); // count this as a completed cycle
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeDelta() {
		return (Long)eDynamicGet(SequencerPackage.SEQUENCER__TIME_DELTA, SequencerPackage.Literals.SEQUENCER__TIME_DELTA, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeDelta(long newTimeDelta) {
		eDynamicSet(SequencerPackage.SEQUENCER__TIME_DELTA, SequencerPackage.Literals.SEQUENCER__TIME_DELTA, newTimeDelta);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getDuration() {
		long duration = (Long)eDynamicGet(SequencerPackage.SEQUENCER__DURATION, SequencerPackage.Literals.SEQUENCER__DURATION, true, true);
		// Can we compute a duration?
		if (duration == UNKNOWN_DURATION && getStartTime() != null
				&& getEndTime() != null) {
			// Yes
			duration = getEndTime().getTime().getTime()
					- getStartTime().getTime().getTime();
			setDuration(duration);
		}
		return duration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(long newDuration) {
		eDynamicSet(SequencerPackage.SEQUENCER__DURATION, SequencerPackage.Literals.SEQUENCER__DURATION, newDuration);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTimeToStop() {
		return (Boolean)eDynamicGet(SequencerPackage.SEQUENCER__TIME_TO_STOP, SequencerPackage.Literals.SEQUENCER__TIME_TO_STOP, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getWorkComplete() {
		return (Double)eDynamicGet(SequencerPackage.SEQUENCER__WORK_COMPLETE, SequencerPackage.Literals.SEQUENCER__WORK_COMPLETE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkComplete(double newWorkComplete) {
		eDynamicSet(SequencerPackage.SEQUENCER__WORK_COMPLETE, SequencerPackage.Literals.SEQUENCER__WORK_COMPLETE, newWorkComplete);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getWorkIncrement() {
		return (Integer)eDynamicGet(SequencerPackage.SEQUENCER__WORK_INCREMENT, SequencerPackage.Literals.SEQUENCER__WORK_INCREMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getCycle() {
		return (Integer)eDynamicGet(SequencerPackage.SEQUENCER__CYCLE, SequencerPackage.Literals.SEQUENCER__CYCLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCycle(int newCycle) {
		eDynamicSet(SequencerPackage.SEQUENCER__CYCLE, SequencerPackage.Literals.SEQUENCER__CYCLE, newCycle);
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
				return getTimeDelta();
			case SequencerPackage.SEQUENCER__DURATION:
				return getDuration();
			case SequencerPackage.SEQUENCER__TIME_TO_STOP:
				return isTimeToStop();
			case SequencerPackage.SEQUENCER__WORK_COMPLETE:
				return getWorkComplete();
			case SequencerPackage.SEQUENCER__WORK_INCREMENT:
				return getWorkIncrement();
			case SequencerPackage.SEQUENCER__CYCLE:
				return getCycle();
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
			case SequencerPackage.SEQUENCER__TIME_DELTA:
				setTimeDelta((Long)newValue);
				return;
			case SequencerPackage.SEQUENCER__DURATION:
				setDuration((Long)newValue);
				return;
			case SequencerPackage.SEQUENCER__WORK_COMPLETE:
				setWorkComplete((Double)newValue);
				return;
			case SequencerPackage.SEQUENCER__CYCLE:
				setCycle((Integer)newValue);
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
			case SequencerPackage.SEQUENCER__TIME_DELTA:
				setTimeDelta(TIME_DELTA_EDEFAULT);
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
				return getStartTime() != null;
			case SequencerPackage.SEQUENCER__END_TIME:
				return getEndTime() != null;
			case SequencerPackage.SEQUENCER__CURRENT_TIME:
				return getCurrentTime() != null;
			case SequencerPackage.SEQUENCER__NEXT_TIME:
				return getNextTime() != null;
			case SequencerPackage.SEQUENCER__TIME_DELTA:
				return getTimeDelta() != TIME_DELTA_EDEFAULT;
			case SequencerPackage.SEQUENCER__DURATION:
				return getDuration() != DURATION_EDEFAULT;
			case SequencerPackage.SEQUENCER__TIME_TO_STOP:
				return isTimeToStop() != TIME_TO_STOP_EDEFAULT;
			case SequencerPackage.SEQUENCER__WORK_COMPLETE:
				return getWorkComplete() != WORK_COMPLETE_EDEFAULT;
			case SequencerPackage.SEQUENCER__WORK_INCREMENT:
				return getWorkIncrement() != WORK_INCREMENT_EDEFAULT;
			case SequencerPackage.SEQUENCER__CYCLE:
				return getCycle() != CYCLE_EDEFAULT;
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
		result.append(dateFormat.format(getStartTime().getTime()));

		if (getEndTime() != null) {
			result.append(" to ");
			result.append(dateFormat.format(getEndTime().getTime()));
		}

		if (getCurrentTime() != null) {
			result.append(", current=");
			result.append(dateFormat.format(getCurrentTime().getTime()));
		}

		result.append(" (timeDelta: "); //$NON-NLS-1$
		result.append(getTimeDelta());
		result.append(" (");
		final long days = getTimeDelta() / STEMTime.Units.DAY.getMilliseconds();
		result.append(days);
		result.append(days == 1 ? " day)" : " days)");
		result.append(", duration: "); //$NON-NLS-1$
		result.append(getDuration());
		result.append(", workComplete: "); //$NON-NLS-1$
		result.append(getWorkComplete());
		result.append(')');
		return result.toString();
	}

} // SequencerImpl
