package automaticexperiment;

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

import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.scenario.Scenario;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Automatic Experiment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link automaticexperiment.AutomaticExperiment#getBaseScenario <em>Base Scenario</em>}</li>
 *   <li>{@link automaticexperiment.AutomaticExperiment#getParameters <em>Parameters</em>}</li>
 *   <li>{@link automaticexperiment.AutomaticExperiment#getErrorAnalysisAlgorithm <em>Error Analysis Algorithm</em>}</li>
 *   <li>{@link automaticexperiment.AutomaticExperiment#getErrorFunction <em>Error Function</em>}</li>
 *   <li>{@link automaticexperiment.AutomaticExperiment#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link automaticexperiment.AutomaticExperiment#getReferanceDataDir <em>Referance Data Dir</em>}</li>
 *   <li>{@link automaticexperiment.AutomaticExperiment#getMaximumNumberOfIterations <em>Maximum Number Of Iterations</em>}</li>
 *   <li>{@link automaticexperiment.AutomaticExperiment#isReInit <em>Re Init</em>}</li>
 * </ul>
 * </p>
 *
 * @see automaticexperiment.AutomaticexperimentPackage#getAutomaticExperiment()
 * @model
 * @generated
 */
public interface AutomaticExperiment extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Base Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Scenario</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Scenario</em>' reference.
	 * @see #setBaseScenario(Scenario)
	 * @see automaticexperiment.AutomaticexperimentPackage#getAutomaticExperiment_BaseScenario()
	 * @model required="true"
	 * @generated
	 */
	Scenario getBaseScenario();

	/**
	 * Sets the value of the '{@link automaticexperiment.AutomaticExperiment#getBaseScenario <em>Base Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Scenario</em>' reference.
	 * @see #getBaseScenario()
	 * @generated
	 */
	void setBaseScenario(Scenario value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link automaticexperiment.ModifiableParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see automaticexperiment.AutomaticexperimentPackage#getAutomaticExperiment_Parameters()
	 * @model required="true"
	 * @generated
	 */
	EList<ModifiableParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Error Analysis Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Analysis Algorithm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Analysis Algorithm</em>' attribute.
	 * @see #setErrorAnalysisAlgorithm(String)
	 * @see automaticexperiment.AutomaticexperimentPackage#getAutomaticExperiment_ErrorAnalysisAlgorithm()
	 * @model required="true"
	 * @generated
	 */
	String getErrorAnalysisAlgorithm();

	/**
	 * Sets the value of the '{@link automaticexperiment.AutomaticExperiment#getErrorAnalysisAlgorithm <em>Error Analysis Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Analysis Algorithm</em>' attribute.
	 * @see #getErrorAnalysisAlgorithm()
	 * @generated
	 */
	void setErrorAnalysisAlgorithm(String value);

	/**
	 * Returns the value of the '<em><b>Error Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Function</em>' attribute.
	 * @see #setErrorFunction(String)
	 * @see automaticexperiment.AutomaticexperimentPackage#getAutomaticExperiment_ErrorFunction()
	 * @model required="true"
	 * @generated
	 */
	String getErrorFunction();

	/**
	 * Sets the value of the '{@link automaticexperiment.AutomaticExperiment#getErrorFunction <em>Error Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Function</em>' attribute.
	 * @see #getErrorFunction()
	 * @generated
	 */
	void setErrorFunction(String value);

	/**
	 * Returns the value of the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tolerance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tolerance</em>' attribute.
	 * @see #setTolerance(double)
	 * @see automaticexperiment.AutomaticexperimentPackage#getAutomaticExperiment_Tolerance()
	 * @model required="true"
	 * @generated
	 */
	double getTolerance();

	/**
	 * Sets the value of the '{@link automaticexperiment.AutomaticExperiment#getTolerance <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tolerance</em>' attribute.
	 * @see #getTolerance()
	 * @generated
	 */
	void setTolerance(double value);

	/**
	 * Returns the value of the '<em><b>Referance Data Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referance Data Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referance Data Dir</em>' attribute.
	 * @see #setReferanceDataDir(String)
	 * @see automaticexperiment.AutomaticexperimentPackage#getAutomaticExperiment_ReferanceDataDir()
	 * @model required="true"
	 * @generated
	 */
	String getReferanceDataDir();

	/**
	 * Sets the value of the '{@link automaticexperiment.AutomaticExperiment#getReferanceDataDir <em>Referance Data Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referance Data Dir</em>' attribute.
	 * @see #getReferanceDataDir()
	 * @generated
	 */
	void setReferanceDataDir(String value);

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Iterations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Iterations</em>' attribute.
	 * @see #setMaximumNumberOfIterations(long)
	 * @see automaticexperiment.AutomaticexperimentPackage#getAutomaticExperiment_MaximumNumberOfIterations()
	 * @model required="true"
	 * @generated
	 */
	long getMaximumNumberOfIterations();

	/**
	 * Sets the value of the '{@link automaticexperiment.AutomaticExperiment#getMaximumNumberOfIterations <em>Maximum Number Of Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Iterations</em>' attribute.
	 * @see #getMaximumNumberOfIterations()
	 * @generated
	 */
	void setMaximumNumberOfIterations(long value);

	/**
	 * Returns the value of the '<em><b>Re Init</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Re Init</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Re Init</em>' attribute.
	 * @see #setReInit(boolean)
	 * @see automaticexperiment.AutomaticexperimentPackage#getAutomaticExperiment_ReInit()
	 * @model required="true"
	 * @generated
	 */
	boolean isReInit();

	/**
	 * Sets the value of the '{@link automaticexperiment.AutomaticExperiment#isReInit <em>Re Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Re Init</em>' attribute.
	 * @see #isReInit()
	 * @generated
	 */
	void setReInit(boolean value);

} // AutomaticExperiment
