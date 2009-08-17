package org.eclipse.stem.populationmodels.standard;

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


import org.eclipse.stem.core.graph.IntegrationLabelValue;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Population Model Label Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getIncidence <em>Incidence</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getBirths <em>Births</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getDeaths <em>Deaths</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getDensity <em>Density</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabelValue()
 * @model superTypes="org.eclipse.stem.populationmodels.standard.PopulationModelLabelValue org.eclipse.stem.populationmodels.standard.IntegrationLabelValue"
 * @generated
 */
public interface StandardPopulationModelLabelValue extends PopulationModelLabelValue, IntegrationLabelValue {

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabelValue_Count()
	 * @model
	 * @generated
	 */
	double getCount();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(double value);

	/**
	 * Returns the value of the '<em><b>Incidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incidence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incidence</em>' attribute.
	 * @see #setIncidence(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabelValue_Incidence()
	 * @model
	 * @generated
	 */
	double getIncidence();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getIncidence <em>Incidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incidence</em>' attribute.
	 * @see #getIncidence()
	 * @generated
	 */
	void setIncidence(double value);

	/**
	 * Returns the value of the '<em><b>Births</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Births</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Births</em>' attribute.
	 * @see #setBirths(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabelValue_Births()
	 * @model
	 * @generated
	 */
	double getBirths();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getBirths <em>Births</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Births</em>' attribute.
	 * @see #getBirths()
	 * @generated
	 */
	void setBirths(double value);

	/**
	 * Returns the value of the '<em><b>Deaths</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deaths</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deaths</em>' attribute.
	 * @see #setDeaths(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabelValue_Deaths()
	 * @model
	 * @generated
	 */
	double getDeaths();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getDeaths <em>Deaths</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deaths</em>' attribute.
	 * @see #getDeaths()
	 * @generated
	 */
	void setDeaths(double value);

	/**
	 * Returns the value of the '<em><b>Density</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Density</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Density</em>' attribute.
	 * @see #isSetDensity()
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabelValue_Density()
	 * @model default="0.0" unsettable="true" changeable="false" volatile="true"
	 * @generated
	 */
	double getDensity();

	/**
	 * Returns whether the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getDensity <em>Density</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Density</em>' attribute is set.
	 * @see #getDensity()
	 * @generated
	 */
	boolean isSetDensity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model valueType="org.eclipse.stem.populationmodels.standard.IntegrationLabelValue"
	 * @generated
	 */
	boolean adjustDelta(IntegrationLabelValue value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	double getAdditions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	double getSubstractions();
} // StandardPopulationModelLabelValue
