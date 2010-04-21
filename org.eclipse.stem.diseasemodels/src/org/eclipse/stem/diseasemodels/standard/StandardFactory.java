package org.eclipse.stem.diseasemodels.standard;

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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage
 * @generated
 */
public interface StandardFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StandardFactory eINSTANCE = org.eclipse.stem.diseasemodels.standard.impl.StandardFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Deterministic SEIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deterministic SEIR Disease Model</em>'.
	 * @generated
	 */
	DeterministicSEIRDiseaseModel createDeterministicSEIRDiseaseModel();

	/**
	 * Returns a new object of class '<em>Deterministic SI Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deterministic SI Disease Model</em>'.
	 * @generated
	 */
	DeterministicSIDiseaseModel createDeterministicSIDiseaseModel();

	/**
	 * Returns a new object of class '<em>Deterministic SIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deterministic SIR Disease Model</em>'.
	 * @generated
	 */
	DeterministicSIRDiseaseModel createDeterministicSIRDiseaseModel();

	/**
	 * Returns a new object of class '<em>SEIR Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SEIR Label</em>'.
	 * @generated
	 */
	SEIRLabel createSEIRLabel();

	/**
	 * Returns a new object of class '<em>SEIR Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SEIR Label Value</em>'.
	 * @generated
	 */
	SEIRLabelValue createSEIRLabelValue();

	/**
	 * Returns a new object of class '<em>SI Disease Model State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SI Disease Model State</em>'.
	 * @generated
	 */
	SIDiseaseModelState createSIDiseaseModelState();

	/**
	 * Returns a new object of class '<em>SI Infector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SI Infector</em>'.
	 * @generated
	 */
	SIInfector createSIInfector();

	/**
	 * Returns a new object of class '<em>SI Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SI Label</em>'.
	 * @generated
	 */
	SILabel createSILabel();

	/**
	 * Returns a new object of class '<em>SI Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SI Label Value</em>'.
	 * @generated
	 */
	SILabelValue createSILabelValue();

	/**
	 * Returns a new object of class '<em>SIR Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SIR Label</em>'.
	 * @generated
	 */
	SIRLabel createSIRLabel();

	/**
	 * Returns a new object of class '<em>SIR Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SIR Label Value</em>'.
	 * @generated
	 */
	SIRLabelValue createSIRLabelValue();

	/**
	 * Returns a new object of class '<em>Stochastic SEIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stochastic SEIR Disease Model</em>'.
	 * @generated
	 */
	StochasticSEIRDiseaseModel createStochasticSEIRDiseaseModel();

	/**
	 * Returns a new object of class '<em>Stochastic SI Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stochastic SI Disease Model</em>'.
	 * @generated
	 */
	StochasticSIDiseaseModel createStochasticSIDiseaseModel();

	/**
	 * Returns a new object of class '<em>Stochastic SIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stochastic SIR Disease Model</em>'.
	 * @generated
	 */
	StochasticSIRDiseaseModel createStochasticSIRDiseaseModel();

	/**
	 * Returns a new object of class '<em>Aggregating SI Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregating SI Disease Model</em>'.
	 * @generated
	 */
	AggregatingSIDiseaseModel createAggregatingSIDiseaseModel();

	/**
	 * Returns a new object of class '<em>Aggregating Disease Model State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregating Disease Model State</em>'.
	 * @generated
	 */
	AggregatingDiseaseModelState createAggregatingDiseaseModelState();

	/**
	 * Returns a new object of class '<em>Aggregating SEIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregating SEIR Disease Model</em>'.
	 * @generated
	 */
	AggregatingSEIRDiseaseModel createAggregatingSEIRDiseaseModel();

	/**
	 * Returns a new object of class '<em>Aggregating SIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregating SIR Disease Model</em>'.
	 * @generated
	 */
	AggregatingSIRDiseaseModel createAggregatingSIRDiseaseModel();

	/**
	 * Returns a new object of class '<em>SIR Inoculator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SIR Inoculator</em>'.
	 * @generated
	 */
	SIRInoculator createSIRInoculator();

	/**
	 * Returns a new object of class '<em>Stochastic Poisson SI Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stochastic Poisson SI Disease Model</em>'.
	 * @generated
	 */
	StochasticPoissonSIDiseaseModel createStochasticPoissonSIDiseaseModel();

	/**
	 * Returns a new object of class '<em>Stochastic Poisson SIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stochastic Poisson SIR Disease Model</em>'.
	 * @generated
	 */
	StochasticPoissonSIRDiseaseModel createStochasticPoissonSIRDiseaseModel();

	/**
	 * Returns a new object of class '<em>Stochastic Poisson SEIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stochastic Poisson SEIR Disease Model</em>'.
	 * @generated
	 */
	StochasticPoissonSEIRDiseaseModel createStochasticPoissonSEIRDiseaseModel();

	/**
	 * Returns a new object of class '<em>Infector Inoculator Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infector Inoculator Collection</em>'.
	 * @generated
	 */
	InfectorInoculatorCollection createInfectorInoculatorCollection();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StandardPackage getStandardPackage();

} //StandardFactory
