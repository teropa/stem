package org.eclipse.stem.diseasemodels.standard.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deterministic SEIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DeterministicSEIRDiseaseModelImpl extends SEIRImpl implements
		DeterministicSEIRDiseaseModel {
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * The constructor needs to be public so that the new disease wizard can
	 * create an instance of the class without using the factory.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public DeterministicSEIRDiseaseModelImpl() {
		super();
	} // DeterministicSEIRDiseaseModelImpl

	/**
	 * @param diseaseModelName
	 *            the name of the disease model
	 * @param backgroundMortalityRate
	 * @param infectiousMortality
	 * @param transmissionRate
	 * @param recoveryRate
	 * @param immunityLossRate
	 * @param incubationRate
	 * @param nonLinearityCoefficient
	 * @param timePeriod
	 *            the time period for the rates (milliseconds)
	 * @param populationIdentifier
	 *            the identifier of the population affected by the disease
	 * @return an initialized instance of DeterministicSEIRDiseaseModel
	 */
	public static final DeterministicSEIRDiseaseModel createDeterministicSEIRDiseaseModel(
			final String diseaseModelName,
			final double backgroundMortalityRate,
			final double infectiousMortalityRate,
			final double transmissionRate, final double recoveryRate,
			final double immunityLossRate, final double incubationRate,
			final double nonLinearityCoefficient, final long timePeriod,
			final String populationIdentifier) {
		final DeterministicSEIRDiseaseModel seirDiseaseModel = StandardFactory.eINSTANCE
				.createDeterministicSEIRDiseaseModel();
		initializeSEIRDiseaseModel(seirDiseaseModel, diseaseModelName,
				backgroundMortalityRate,
				infectiousMortalityRate, transmissionRate, recoveryRate,
				immunityLossRate, incubationRate, nonLinearityCoefficient,
				timePeriod, populationIdentifier);
		return seirDiseaseModel;
	} // createDeterministicSEIRDiseaseModel

	public void doModelSpecificAdjustments(LabelValue label) {
		// Nothing
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.DETERMINISTIC_SEIR_DISEASE_MODEL;
	}

	@Override
	public boolean isDeterministic() {
		return true;
	}
	
} // DeterministicSEIRDiseaseModelImpl
