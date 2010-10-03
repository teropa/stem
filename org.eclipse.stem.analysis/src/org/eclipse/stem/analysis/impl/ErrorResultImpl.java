package org.eclipse.stem.analysis.impl;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.stem.analysis.AnalysisPackage;
import org.eclipse.stem.analysis.ErrorResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.analysis.impl.ErrorResultImpl#getErrorByTimeStep <em>Error By Time Step</em>}</li>
 *   <li>{@link org.eclipse.stem.analysis.impl.ErrorResultImpl#getError <em>Error</em>}</li>
 *   <li>{@link org.eclipse.stem.analysis.impl.ErrorResultImpl#getReferenceByTime <em>Reference By Time</em>}</li>
 *   <li>{@link org.eclipse.stem.analysis.impl.ErrorResultImpl#getModelByTime <em>Model By Time</em>}</li>
 *   <li>{@link org.eclipse.stem.analysis.impl.ErrorResultImpl#getValidationError <em>Validation Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorResultImpl extends CDOObjectImpl implements ErrorResult {
	/**
	 * The default value of the '{@link #getError() <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getError()
	 * @generated
	 * @ordered
	 */
	protected static final double ERROR_EDEFAULT = 0.0;
	/**
	 * The default value of the '{@link #getValidationError() <em>Validation Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationError()
	 * @generated
	 * @ordered
	 */
	protected static final double VALIDATION_ERROR_EDEFAULT = 0.0;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.ERROR_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getErrorByTimeStep() {
		return (EList<Double>)eDynamicGet(AnalysisPackage.ERROR_RESULT__ERROR_BY_TIME_STEP, AnalysisPackage.Literals.ERROR_RESULT__ERROR_BY_TIME_STEP, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorByTimeStep(EList<Double> newErrorByTimeStep) {
		eDynamicSet(AnalysisPackage.ERROR_RESULT__ERROR_BY_TIME_STEP, AnalysisPackage.Literals.ERROR_RESULT__ERROR_BY_TIME_STEP, newErrorByTimeStep);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getError() {
		return (Double)eDynamicGet(AnalysisPackage.ERROR_RESULT__ERROR, AnalysisPackage.Literals.ERROR_RESULT__ERROR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setError(double newError) {
		eDynamicSet(AnalysisPackage.ERROR_RESULT__ERROR, AnalysisPackage.Literals.ERROR_RESULT__ERROR, newError);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getReferenceByTime() {
		return (EList<Double>)eDynamicGet(AnalysisPackage.ERROR_RESULT__REFERENCE_BY_TIME, AnalysisPackage.Literals.ERROR_RESULT__REFERENCE_BY_TIME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceByTime(EList<Double> newReferenceByTime) {
		eDynamicSet(AnalysisPackage.ERROR_RESULT__REFERENCE_BY_TIME, AnalysisPackage.Literals.ERROR_RESULT__REFERENCE_BY_TIME, newReferenceByTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getModelByTime() {
		return (EList<Double>)eDynamicGet(AnalysisPackage.ERROR_RESULT__MODEL_BY_TIME, AnalysisPackage.Literals.ERROR_RESULT__MODEL_BY_TIME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelByTime(EList<Double> newModelByTime) {
		eDynamicSet(AnalysisPackage.ERROR_RESULT__MODEL_BY_TIME, AnalysisPackage.Literals.ERROR_RESULT__MODEL_BY_TIME, newModelByTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getValidationError() {
		return (Double)eDynamicGet(AnalysisPackage.ERROR_RESULT__VALIDATION_ERROR, AnalysisPackage.Literals.ERROR_RESULT__VALIDATION_ERROR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidationError(double newValidationError) {
		eDynamicSet(AnalysisPackage.ERROR_RESULT__VALIDATION_ERROR, AnalysisPackage.Literals.ERROR_RESULT__VALIDATION_ERROR, newValidationError);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.ERROR_RESULT__ERROR_BY_TIME_STEP:
				return getErrorByTimeStep();
			case AnalysisPackage.ERROR_RESULT__ERROR:
				return getError();
			case AnalysisPackage.ERROR_RESULT__REFERENCE_BY_TIME:
				return getReferenceByTime();
			case AnalysisPackage.ERROR_RESULT__MODEL_BY_TIME:
				return getModelByTime();
			case AnalysisPackage.ERROR_RESULT__VALIDATION_ERROR:
				return getValidationError();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnalysisPackage.ERROR_RESULT__ERROR_BY_TIME_STEP:
				setErrorByTimeStep((EList<Double>)newValue);
				return;
			case AnalysisPackage.ERROR_RESULT__ERROR:
				setError((Double)newValue);
				return;
			case AnalysisPackage.ERROR_RESULT__REFERENCE_BY_TIME:
				setReferenceByTime((EList<Double>)newValue);
				return;
			case AnalysisPackage.ERROR_RESULT__MODEL_BY_TIME:
				setModelByTime((EList<Double>)newValue);
				return;
			case AnalysisPackage.ERROR_RESULT__VALIDATION_ERROR:
				setValidationError((Double)newValue);
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
			case AnalysisPackage.ERROR_RESULT__ERROR_BY_TIME_STEP:
				setErrorByTimeStep((EList<Double>)null);
				return;
			case AnalysisPackage.ERROR_RESULT__ERROR:
				setError(ERROR_EDEFAULT);
				return;
			case AnalysisPackage.ERROR_RESULT__REFERENCE_BY_TIME:
				setReferenceByTime((EList<Double>)null);
				return;
			case AnalysisPackage.ERROR_RESULT__MODEL_BY_TIME:
				setModelByTime((EList<Double>)null);
				return;
			case AnalysisPackage.ERROR_RESULT__VALIDATION_ERROR:
				setValidationError(VALIDATION_ERROR_EDEFAULT);
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
			case AnalysisPackage.ERROR_RESULT__ERROR_BY_TIME_STEP:
				return getErrorByTimeStep() != null;
			case AnalysisPackage.ERROR_RESULT__ERROR:
				return getError() != ERROR_EDEFAULT;
			case AnalysisPackage.ERROR_RESULT__REFERENCE_BY_TIME:
				return getReferenceByTime() != null;
			case AnalysisPackage.ERROR_RESULT__MODEL_BY_TIME:
				return getModelByTime() != null;
			case AnalysisPackage.ERROR_RESULT__VALIDATION_ERROR:
				return getValidationError() != VALIDATION_ERROR_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public ErrorResult copy() {
		ErrorResultImpl res = new ErrorResultImpl();
		res.setError(this.getError());
		res.setValidationError(this.getValidationError());
		EList<Double>newlist = new BasicEList<Double>();
		for(double d:this.getErrorByTimeStep())newlist.add(d);
		res.setErrorByTimeStep(newlist);
		return res;
	}

} //ErrorResultImpl
