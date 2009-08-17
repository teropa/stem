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


import org.eclipse.stem.core.model.IntegrationDecorator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Population Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getBirthRate <em>Birth Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getDeathRate <em>Death Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getTimePeriod <em>Time Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModel()
 * @model superTypes="org.eclipse.stem.populationmodels.standard.PopulationModel org.eclipse.stem.populationmodels.standard.IntegrationDecorator"
 * @generated
 */
public interface StandardPopulationModel extends PopulationModel, IntegrationDecorator {
	/**
	 * Returns the value of the '<em><b>Birth Rate</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Rate</em>' attribute.
	 * @see #setBirthRate(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModel_BirthRate()
	 * @model default="0.0"
	 * @generated
	 */
	double getBirthRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getBirthRate <em>Birth Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Rate</em>' attribute.
	 * @see #getBirthRate()
	 * @generated
	 */
	void setBirthRate(double value);

	/**
	 * Returns the value of the '<em><b>Death Rate</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Death Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Death Rate</em>' attribute.
	 * @see #setDeathRate(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModel_DeathRate()
	 * @model default="0.0"
	 * @generated
	 */
	double getDeathRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getDeathRate <em>Death Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Death Rate</em>' attribute.
	 * @see #getDeathRate()
	 * @generated
	 */
	void setDeathRate(double value);

	/**
	 * Returns the value of the '<em><b>Time Period</b></em>' attribute.
	 * The default value is <code>"86400000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Period</em>' attribute.
	 * @see #setTimePeriod(long)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModel_TimePeriod()
	 * @model default="86400000"
	 * @generated
	 */
	long getTimePeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getTimePeriod <em>Time Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Period</em>' attribute.
	 * @see #getTimePeriod()
	 * @generated
	 */
	void setTimePeriod(long value);

} // StandardPopulationModel
