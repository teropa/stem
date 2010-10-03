package org.eclipse.stem.tests.util.labels.impl;

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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.impl.LabelValueImpl;
import org.eclipse.stem.tests.util.labels.LabelsPackage;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Integer Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.tests.util.labels.impl.TestIntegerLabelValueImpl#getI <em>I</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestIntegerLabelValueImpl extends LabelValueImpl implements
		TestIntegerLabelValue {
	/**
	 * The default value of the '{@link #getI() <em>I</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected static final int I_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TestIntegerLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.TEST_INTEGER_LABEL_VALUE;
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelValueImpl#reset()
	 */
	@Override
	public void reset() {
		setI(I_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getI() {
		return (Integer)eDynamicGet(LabelsPackage.TEST_INTEGER_LABEL_VALUE__I, LabelsPackage.Literals.TEST_INTEGER_LABEL_VALUE__I, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setI(int newI) {
		eDynamicSet(LabelsPackage.TEST_INTEGER_LABEL_VALUE__I, LabelsPackage.Literals.TEST_INTEGER_LABEL_VALUE__I, newI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void increment() {
		setI(getI() + 1);
	} // increment

	/**
	 * @see org.eclipse.stem.core.common.SanityChecker#sane()
	 */
	public boolean sane() {
		boolean retValue = true;

		retValue = retValue && getI() >= 0;
		return retValue;
	} // sane

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.TEST_INTEGER_LABEL_VALUE__I:
				return getI();
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
			case LabelsPackage.TEST_INTEGER_LABEL_VALUE__I:
				setI((Integer)newValue);
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
			case LabelsPackage.TEST_INTEGER_LABEL_VALUE__I:
				setI(I_EDEFAULT);
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
			case LabelsPackage.TEST_INTEGER_LABEL_VALUE__I:
				return getI() != I_EDEFAULT;
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

		final StringBuilder result = new StringBuilder(Integer.toString(getI()));
		return result.toString();
	} // toString

} // TestIntegerLabelValueImpl
