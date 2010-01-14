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
import org.eclipse.stem.diseasemodels.standard.DeterministicSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deterministic SIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DeterministicSIRDiseaseModelImpl extends SIRImpl implements
		DeterministicSIRDiseaseModel {
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * The constructor needs to be public so that the new disease wizard can
	 * create an instance of the class without using the factory.
	 * 
	 * <!-- end-user-doc -->
	 */
	public DeterministicSIRDiseaseModelImpl() {
		super();
	} // DeterministicSIRDiseaseModelImpl

	/**
	 * @param diseaseModelName
	 *            the name of the disease model
	 * @param backgroundMortalityRate
	 * @param infectiousMortality
	 * @param infectiousMortalityRate
	 *            the rate at which fatally infectious population members die
	 * @param transmissionRate
	 * @param recoveryRate
	 * @param immunityLossRate
	 * @param nonLinearityCoefficient
	 * @param timePeriod
	 *            the time period for the rates (milliseconds)
	 * @param populationIdentifier
	 *            the identifier of the population affected by the disease
	 * @return an initialized instance of DeterministicSIRDiseaseModel
	 */
	public static final DeterministicSIRDiseaseModel createDeterministicSIRDiseaseModel(
			final String diseaseModelName,
			final double backgroundMortalityRate,
			final double infectiousMortalityRate,
			final double transmissionRate, final double recoveryRate,
			final double immunityLossRate,
			final double nonLinearityCoefficient, final long timePeriod,
			final String populationIdentifier) {
		final DeterministicSIRDiseaseModel sirDiseaseModel = StandardFactory.eINSTANCE
				.createDeterministicSIRDiseaseModel();
		initializeSIRDiseaseModel(sirDiseaseModel, diseaseModelName,
				backgroundMortalityRate,
				infectiousMortalityRate, transmissionRate, recoveryRate,
				immunityLossRate, nonLinearityCoefficient, timePeriod,
				populationIdentifier);
		return sirDiseaseModel;
	} // createDeterministicSIRDiseaseModel

	public void doModelSpecificAdjustments(LabelValue label) {
		// Nothing
	}

	@Override
	public boolean isDeterministic() {
		return true;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.DETERMINISTIC_SIR_DISEASE_MODEL;
	}

} // DeterministicSIRDiseaseModelImpl
