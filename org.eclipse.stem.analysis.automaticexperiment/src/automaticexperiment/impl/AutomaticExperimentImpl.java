package automaticexperiment.impl;

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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.stem.core.common.impl.IdentifiableImpl;
import org.eclipse.stem.core.scenario.Scenario;

import automaticexperiment.AutomaticExperiment;
import automaticexperiment.AutomaticexperimentPackage;
import automaticexperiment.ModifiableParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Automatic Experiment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link automaticexperiment.impl.AutomaticExperimentImpl#getBaseScenario <em>Base Scenario</em>}</li>
 *   <li>{@link automaticexperiment.impl.AutomaticExperimentImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link automaticexperiment.impl.AutomaticExperimentImpl#getErrorAnalysisAlgorithm <em>Error Analysis Algorithm</em>}</li>
 *   <li>{@link automaticexperiment.impl.AutomaticExperimentImpl#getErrorFunction <em>Error Function</em>}</li>
 *   <li>{@link automaticexperiment.impl.AutomaticExperimentImpl#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link automaticexperiment.impl.AutomaticExperimentImpl#getReferanceDataDir <em>Referance Data Dir</em>}</li>
 *   <li>{@link automaticexperiment.impl.AutomaticExperimentImpl#getMaximumNumberOfIterations <em>Maximum Number Of Iterations</em>}</li>
 *   <li>{@link automaticexperiment.impl.AutomaticExperimentImpl#isReInit <em>Re Init</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutomaticExperimentImpl extends IdentifiableImpl implements AutomaticExperiment {
	/**
	 * The default value of the '{@link #getErrorAnalysisAlgorithm() <em>Error Analysis Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorAnalysisAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_ANALYSIS_ALGORITHM_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getErrorFunction() <em>Error Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorFunction()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_FUNCTION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTolerance() <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTolerance()
	 * @generated
	 * @ordered
	 */
	protected static final double TOLERANCE_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getReferanceDataDir() <em>Referance Data Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferanceDataDir()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERANCE_DATA_DIR_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getMaximumNumberOfIterations() <em>Maximum Number Of Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfIterations()
	 * @generated
	 * @ordered
	 */
	protected static final long MAXIMUM_NUMBER_OF_ITERATIONS_EDEFAULT = 0L;

	/**
	 * The default value of the '{@link #isReInit() <em>Re Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReInit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RE_INIT_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AutomaticExperimentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario getBaseScenario() {
		return (Scenario)eDynamicGet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__BASE_SCENARIO, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__BASE_SCENARIO, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario basicGetBaseScenario() {
		return (Scenario)eDynamicGet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__BASE_SCENARIO, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__BASE_SCENARIO, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseScenario(Scenario newBaseScenario) {
		eDynamicSet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__BASE_SCENARIO, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__BASE_SCENARIO, newBaseScenario);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ModifiableParameter> getParameters() {
		return (EList<ModifiableParameter>)eDynamicGet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__PARAMETERS, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__PARAMETERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getErrorAnalysisAlgorithm() {
		return (String)eDynamicGet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorAnalysisAlgorithm(String newErrorAnalysisAlgorithm) {
		eDynamicSet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM, newErrorAnalysisAlgorithm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getErrorFunction() {
		return (String)eDynamicGet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorFunction(String newErrorFunction) {
		eDynamicSet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION, newErrorFunction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTolerance() {
		return (Double)eDynamicGet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__TOLERANCE, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__TOLERANCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTolerance(double newTolerance) {
		eDynamicSet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__TOLERANCE, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__TOLERANCE, newTolerance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferanceDataDir() {
		return (String)eDynamicGet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferanceDataDir(String newReferanceDataDir) {
		eDynamicSet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR, newReferanceDataDir);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaximumNumberOfIterations() {
		return (Long)eDynamicGet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfIterations(long newMaximumNumberOfIterations) {
		eDynamicSet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS, newMaximumNumberOfIterations);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReInit() {
		return (Boolean)eDynamicGet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__RE_INIT, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__RE_INIT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReInit(boolean newReInit) {
		eDynamicSet(AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__RE_INIT, AutomaticexperimentPackage.Literals.AUTOMATIC_EXPERIMENT__RE_INIT, newReInit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__BASE_SCENARIO:
				if (resolve) return getBaseScenario();
				return basicGetBaseScenario();
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__PARAMETERS:
				return getParameters();
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM:
				return getErrorAnalysisAlgorithm();
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION:
				return getErrorFunction();
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__TOLERANCE:
				return getTolerance();
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR:
				return getReferanceDataDir();
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS:
				return getMaximumNumberOfIterations();
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__RE_INIT:
				return isReInit();
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
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__BASE_SCENARIO:
				setBaseScenario((Scenario)newValue);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ModifiableParameter>)newValue);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM:
				setErrorAnalysisAlgorithm((String)newValue);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION:
				setErrorFunction((String)newValue);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__TOLERANCE:
				setTolerance((Double)newValue);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR:
				setReferanceDataDir((String)newValue);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS:
				setMaximumNumberOfIterations((Long)newValue);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__RE_INIT:
				setReInit((Boolean)newValue);
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
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__BASE_SCENARIO:
				setBaseScenario((Scenario)null);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__PARAMETERS:
				getParameters().clear();
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM:
				setErrorAnalysisAlgorithm(ERROR_ANALYSIS_ALGORITHM_EDEFAULT);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION:
				setErrorFunction(ERROR_FUNCTION_EDEFAULT);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__TOLERANCE:
				setTolerance(TOLERANCE_EDEFAULT);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR:
				setReferanceDataDir(REFERANCE_DATA_DIR_EDEFAULT);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS:
				setMaximumNumberOfIterations(MAXIMUM_NUMBER_OF_ITERATIONS_EDEFAULT);
				return;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__RE_INIT:
				setReInit(RE_INIT_EDEFAULT);
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
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__BASE_SCENARIO:
				return basicGetBaseScenario() != null;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__PARAMETERS:
				return !getParameters().isEmpty();
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM:
				return ERROR_ANALYSIS_ALGORITHM_EDEFAULT == null ? getErrorAnalysisAlgorithm() != null : !ERROR_ANALYSIS_ALGORITHM_EDEFAULT.equals(getErrorAnalysisAlgorithm());
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION:
				return ERROR_FUNCTION_EDEFAULT == null ? getErrorFunction() != null : !ERROR_FUNCTION_EDEFAULT.equals(getErrorFunction());
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__TOLERANCE:
				return getTolerance() != TOLERANCE_EDEFAULT;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR:
				return REFERANCE_DATA_DIR_EDEFAULT == null ? getReferanceDataDir() != null : !REFERANCE_DATA_DIR_EDEFAULT.equals(getReferanceDataDir());
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS:
				return getMaximumNumberOfIterations() != MAXIMUM_NUMBER_OF_ITERATIONS_EDEFAULT;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__RE_INIT:
				return isReInit() != RE_INIT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //AutomaticExperimentImpl
