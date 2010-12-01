package org.eclipse.stem.core.predicate.impl;

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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.predicate.ElapsedTimeTest;
import org.eclipse.stem.core.predicate.PredicatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Elapsed Time Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.predicate.impl.ElapsedTimeTestImpl#isReferenceTimeValid <em>Reference Time Valid</em>}</li>
 *   <li>{@link org.eclipse.stem.core.predicate.impl.ElapsedTimeTestImpl#getElapsedMilliseconds <em>Elapsed Milliseconds</em>}</li>
 *   <li>{@link org.eclipse.stem.core.predicate.impl.ElapsedTimeTestImpl#getNumberofDays <em>Numberof Days</em>}</li>
 *   <li>{@link org.eclipse.stem.core.predicate.impl.ElapsedTimeTestImpl#getReferenceTime <em>Reference Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElapsedTimeTestImpl extends TimeTestImpl implements ElapsedTimeTest {
	/**
	 * The default value of the '{@link #isReferenceTimeValid() <em>Reference Time Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReferenceTimeValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFERENCE_TIME_VALID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReferenceTimeValid() <em>Reference Time Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReferenceTimeValid()
	 * @generated
	 * @ordered
	 */
	protected boolean referenceTimeValid = REFERENCE_TIME_VALID_EDEFAULT;

	/**
	 * The default value of the '{@link #getElapsedMilliseconds() <em>Elapsed Milliseconds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElapsedMilliseconds()
	 * @generated
	 * @ordered
	 */
	protected static final long ELAPSED_MILLISECONDS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getElapsedMilliseconds() <em>Elapsed Milliseconds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElapsedMilliseconds()
	 * @generated
	 * @ordered
	 */
	protected long elapsedMilliseconds = ELAPSED_MILLISECONDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberofDays() <em>Numberof Days</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberofDays()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBEROF_DAYS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberofDays() <em>Numberof Days</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberofDays()
	 * @generated
	 * @ordered
	 */
	protected int numberofDays = NUMBEROF_DAYS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferenceTime() <em>Reference Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceTime()
	 * @generated
	 * @ordered
	 */
	protected STEMTime referenceTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ElapsedTimeTestImpl() {
		super();
		setReferenceTime(ModelFactory.eINSTANCE.createSTEMTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PredicatePackage.Literals.ELAPSED_TIME_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReferenceTimeValid() {
		return referenceTimeValid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceTimeValid(boolean newReferenceTimeValid) {
		boolean oldReferenceTimeValid = referenceTimeValid;
		referenceTimeValid = newReferenceTimeValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME_VALID, oldReferenceTimeValid, referenceTimeValid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getElapsedMilliseconds() {
		return elapsedMilliseconds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberofDays() {
		return numberofDays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setNumberofDays(int newNumberofDays) {
		int oldNumberofDays = getNumberofDays();
		numberofDays = newNumberofDays;
		
		elapsedMilliseconds = getNumberofDays() * STEMTime.Units.DAY.getMilliseconds();
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatePackage.ELAPSED_TIME_TEST__NUMBEROF_DAYS, oldNumberofDays, numberofDays));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getReferenceTime() {
		return referenceTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferenceTime(STEMTime newReferenceTime, NotificationChain msgs) {
		STEMTime oldReferenceTime = referenceTime;
		referenceTime = newReferenceTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME, oldReferenceTime, newReferenceTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceTime(STEMTime newReferenceTime) {
		if (newReferenceTime != referenceTime) {
			NotificationChain msgs = null;
			if (referenceTime != null)
				msgs = ((InternalEObject)referenceTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME, null, msgs);
			if (newReferenceTime != null)
				msgs = ((InternalEObject)newReferenceTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME, null, msgs);
			msgs = basicSetReferenceTime(newReferenceTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME, newReferenceTime, newReferenceTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME:
				return basicSetReferenceTime(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME_VALID:
				return isReferenceTimeValid();
			case PredicatePackage.ELAPSED_TIME_TEST__ELAPSED_MILLISECONDS:
				return getElapsedMilliseconds();
			case PredicatePackage.ELAPSED_TIME_TEST__NUMBEROF_DAYS:
				return getNumberofDays();
			case PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME:
				return getReferenceTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME_VALID:
				setReferenceTimeValid((Boolean)newValue);
				return;
			case PredicatePackage.ELAPSED_TIME_TEST__NUMBEROF_DAYS:
				setNumberofDays((Integer)newValue);
				return;
			case PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME:
				setReferenceTime((STEMTime)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME_VALID:
				setReferenceTimeValid(REFERENCE_TIME_VALID_EDEFAULT);
				return;
			case PredicatePackage.ELAPSED_TIME_TEST__NUMBEROF_DAYS:
				setNumberofDays(NUMBEROF_DAYS_EDEFAULT);
				return;
			case PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME:
				setReferenceTime((STEMTime)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME_VALID:
				return referenceTimeValid != REFERENCE_TIME_VALID_EDEFAULT;
			case PredicatePackage.ELAPSED_TIME_TEST__ELAPSED_MILLISECONDS:
				return elapsedMilliseconds != ELAPSED_MILLISECONDS_EDEFAULT;
			case PredicatePackage.ELAPSED_TIME_TEST__NUMBEROF_DAYS:
				return numberofDays != NUMBEROF_DAYS_EDEFAULT;
			case PredicatePackage.ELAPSED_TIME_TEST__REFERENCE_TIME:
				return referenceTime != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (referenceTimeValid: "); //$NON-NLS-1$
		result.append(referenceTimeValid);
		result.append(", elapsedMilliseconds: "); //$NON-NLS-1$
		result.append(elapsedMilliseconds);
		result.append(", numberofDays: "); //$NON-NLS-1$
		result.append(numberofDays);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see org.eclipse.stem.core.predicate.impl.PredicateImpl#evaluate(org.eclipse.stem.core.model.STEMTime, long, org.eclipse.stem.core.model.Decorator)
	 */
	@Override
	public boolean evaluate(STEMTime time, long timerPeriod, Decorator action) {
		boolean retValue = false;
		// Is the reference time valid?
		if (isReferenceTimeValid()) {
			// Yes
			final long elapsedTimeMS = time.getTime().getTime() - getReferenceTime().getTime().getTime();
			// Has enough time gone by?
			retValue = elapsedTimeMS >= getElapsedMilliseconds();
		} // if reference time valid?
		else {
			// No
			// This must be the first time this has been called so this must be
			// the start of the simulation. Remember the time value passed in as
			// the reference value.
			
			STEMTime newTime = (STEMTime)EcoreUtil.copy(time);
			newTime = newTime.addIncrement(-timerPeriod); // Substract one time period
			setReferenceTime(newTime);
			setReferenceTimeValid(true);			
		} // else
		
		return retValue;
	} // evaluate
	
} //ElapsedTimeTestImpl
