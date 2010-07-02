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


import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage
 * @generated
 */
public interface StandardFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StandardFactory eINSTANCE = org.eclipse.stem.populationmodels.standard.impl.StandardFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model</em>'.
	 * @generated
	 */
	StandardPopulationModel createStandardPopulationModel();

	/**
	 * Returns a new object of class '<em>Population Model Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model Label</em>'.
	 * @generated
	 */
	PopulationModelLabel createPopulationModelLabel();

	/**
	 * Returns a new object of class '<em>Population Model Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model Label</em>'.
	 * @generated
	 */
	StandardPopulationModelLabel createStandardPopulationModelLabel();

	/**
	 * Returns a new object of class '<em>Population Model Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model Label Value</em>'.
	 * @generated
	 */
	PopulationModelLabelValue createPopulationModelLabelValue();

	/**
	 * Returns a new object of class '<em>Population Model Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model Label Value</em>'.
	 * @generated
	 */
	StandardPopulationModelLabelValue createStandardPopulationModelLabelValue();

	/**
	 * Returns a new object of class '<em>Stochastic Standard Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stochastic Standard Population Model</em>'.
	 * @generated
	 */
	StochasticStandardPopulationModel createStochasticStandardPopulationModel();

	/**
	 * Returns a new object of class '<em>Demographic Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Demographic Population Model</em>'.
	 * @generated
	 */
	DemographicPopulationModel createDemographicPopulationModel();

	/**
	 * Returns a new object of class '<em>Population Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Group</em>'.
	 * @generated
	 */
	PopulationGroup createPopulationGroup();

	/**
	 * Returns a new object of class '<em>Population Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Initializer</em>'.
	 * @generated
	 */
	PopulationInitializer createPopulationInitializer();

	/**
	 * Returns a new object of class '<em>Population Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Initializer</em>'.
	 * @generated
	 */
	StandardPopulationInitializer createStandardPopulationInitializer();

	/**
	 * Returns a new object of class '<em>Seasonal Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Seasonal Population Model</em>'.
	 * @generated
	 */
	SeasonalPopulationModel createSeasonalPopulationModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StandardPackage getStandardPackage();

} //StandardFactory
