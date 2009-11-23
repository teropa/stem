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
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutomaticExperimentImpl extends IdentifiableImpl implements AutomaticExperiment {
	/**
	 * The cached value of the '{@link #getBaseScenario() <em>Base Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseScenario()
	 * @generated
	 * @ordered
	 */
	protected Scenario baseScenario;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ModifiableParameter> parameters;

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
	 * The cached value of the '{@link #getErrorAnalysisAlgorithm() <em>Error Analysis Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorAnalysisAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String errorAnalysisAlgorithm = ERROR_ANALYSIS_ALGORITHM_EDEFAULT;

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
	 * The cached value of the '{@link #getErrorFunction() <em>Error Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorFunction()
	 * @generated
	 * @ordered
	 */
	protected String errorFunction = ERROR_FUNCTION_EDEFAULT;

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
	 * The cached value of the '{@link #getTolerance() <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTolerance()
	 * @generated
	 * @ordered
	 */
	protected double tolerance = TOLERANCE_EDEFAULT;

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
	 * The cached value of the '{@link #getReferanceDataDir() <em>Referance Data Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferanceDataDir()
	 * @generated
	 * @ordered
	 */
	protected String referanceDataDir = REFERANCE_DATA_DIR_EDEFAULT;

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
	 * The cached value of the '{@link #getMaximumNumberOfIterations() <em>Maximum Number Of Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfIterations()
	 * @generated
	 * @ordered
	 */
	protected long maximumNumberOfIterations = MAXIMUM_NUMBER_OF_ITERATIONS_EDEFAULT;

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
		if (baseScenario != null && baseScenario.eIsProxy()) {
			InternalEObject oldBaseScenario = (InternalEObject)baseScenario;
			baseScenario = (Scenario)eResolveProxy(oldBaseScenario);
			if (baseScenario != oldBaseScenario) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__BASE_SCENARIO, oldBaseScenario, baseScenario));
			}
		}
		return baseScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario basicGetBaseScenario() {
		return baseScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseScenario(Scenario newBaseScenario) {
		Scenario oldBaseScenario = baseScenario;
		baseScenario = newBaseScenario;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__BASE_SCENARIO, oldBaseScenario, baseScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModifiableParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<ModifiableParameter>(ModifiableParameter.class, this, AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getErrorAnalysisAlgorithm() {
		return errorAnalysisAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorAnalysisAlgorithm(String newErrorAnalysisAlgorithm) {
		String oldErrorAnalysisAlgorithm = errorAnalysisAlgorithm;
		errorAnalysisAlgorithm = newErrorAnalysisAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM, oldErrorAnalysisAlgorithm, errorAnalysisAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getErrorFunction() {
		return errorFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorFunction(String newErrorFunction) {
		String oldErrorFunction = errorFunction;
		errorFunction = newErrorFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION, oldErrorFunction, errorFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTolerance() {
		return tolerance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTolerance(double newTolerance) {
		double oldTolerance = tolerance;
		tolerance = newTolerance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__TOLERANCE, oldTolerance, tolerance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferanceDataDir() {
		return referanceDataDir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferanceDataDir(String newReferanceDataDir) {
		String oldReferanceDataDir = referanceDataDir;
		referanceDataDir = newReferanceDataDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR, oldReferanceDataDir, referanceDataDir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaximumNumberOfIterations() {
		return maximumNumberOfIterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfIterations(long newMaximumNumberOfIterations) {
		long oldMaximumNumberOfIterations = maximumNumberOfIterations;
		maximumNumberOfIterations = newMaximumNumberOfIterations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS, oldMaximumNumberOfIterations, maximumNumberOfIterations));
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
				return baseScenario != null;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM:
				return ERROR_ANALYSIS_ALGORITHM_EDEFAULT == null ? errorAnalysisAlgorithm != null : !ERROR_ANALYSIS_ALGORITHM_EDEFAULT.equals(errorAnalysisAlgorithm);
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__ERROR_FUNCTION:
				return ERROR_FUNCTION_EDEFAULT == null ? errorFunction != null : !ERROR_FUNCTION_EDEFAULT.equals(errorFunction);
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__TOLERANCE:
				return tolerance != TOLERANCE_EDEFAULT;
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR:
				return REFERANCE_DATA_DIR_EDEFAULT == null ? referanceDataDir != null : !REFERANCE_DATA_DIR_EDEFAULT.equals(referanceDataDir);
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS:
				return maximumNumberOfIterations != MAXIMUM_NUMBER_OF_ITERATIONS_EDEFAULT;
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
		result.append(" (errorAnalysisAlgorithm: ");
		result.append(errorAnalysisAlgorithm);
		result.append(", errorFunction: ");
		result.append(errorFunction);
		result.append(", tolerance: ");
		result.append(tolerance);
		result.append(", referanceDataDir: ");
		result.append(referanceDataDir);
		result.append(", maximumNumberOfIterations: ");
		result.append(maximumNumberOfIterations);
		result.append(')');
		return result.toString();
	}

} //AutomaticExperimentImpl
