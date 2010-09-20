package org.eclipse.stem.populationmodels.standard.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.stem.populationmodels.standard.*;
import org.eclipse.stem.populationmodels.standard.DemographicPopulationModel;
import org.eclipse.stem.populationmodels.standard.PopulationGroup;
import org.eclipse.stem.populationmodels.standard.PopulationInitializer;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabelValue;
import org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue;
import org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StandardFactoryImpl extends EFactoryImpl implements StandardFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StandardFactory init() {
		try {
			StandardFactory theStandardFactory = (StandardFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/populationmodels/standard"); 
			if (theStandardFactory != null) {
				return theStandardFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StandardFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StandardPackage.STANDARD_POPULATION_MODEL: return createStandardPopulationModel();
			case StandardPackage.POPULATION_MODEL_LABEL: return createPopulationModelLabel();
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL: return createStandardPopulationModelLabel();
			case StandardPackage.POPULATION_MODEL_LABEL_VALUE: return createPopulationModelLabelValue();
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE: return createStandardPopulationModelLabelValue();
			case StandardPackage.STOCHASTIC_STANDARD_POPULATION_MODEL: return createStochasticStandardPopulationModel();
			case StandardPackage.DEMOGRAPHIC_POPULATION_MODEL: return createDemographicPopulationModel();
			case StandardPackage.POPULATION_GROUP: return createPopulationGroup();
			case StandardPackage.STANDARD_POPULATION_INITIALIZER: return createStandardPopulationInitializer();
			case StandardPackage.SEASONAL_POPULATION_MODEL: return createSeasonalPopulationModel();
			case StandardPackage.YETI_POPULATION_INITIALIZER: return createYetiPopulationInitializer();
			case StandardPackage.MOSQUITO_POPULATION_MODEL: return createMosquitoPopulationModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModel createStandardPopulationModel() {
		StandardPopulationModelImpl standardPopulationModel = new StandardPopulationModelImpl();
		return standardPopulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationModelLabel createPopulationModelLabel() {
		PopulationModelLabelImpl populationModelLabel = new PopulationModelLabelImpl();
		return populationModelLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabel createStandardPopulationModelLabel() {
		StandardPopulationModelLabelImpl standardPopulationModelLabel = new StandardPopulationModelLabelImpl();
		return standardPopulationModelLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationModelLabelValue createPopulationModelLabelValue() {
		PopulationModelLabelValueImpl populationModelLabelValue = new PopulationModelLabelValueImpl();
		return populationModelLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue createStandardPopulationModelLabelValue() {
		StandardPopulationModelLabelValueImpl standardPopulationModelLabelValue = new StandardPopulationModelLabelValueImpl();
		return standardPopulationModelLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticStandardPopulationModel createStochasticStandardPopulationModel() {
		StochasticStandardPopulationModelImpl stochasticStandardPopulationModel = new StochasticStandardPopulationModelImpl();
		return stochasticStandardPopulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemographicPopulationModel createDemographicPopulationModel() {
		DemographicPopulationModelImpl demographicPopulationModel = new DemographicPopulationModelImpl();
		return demographicPopulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationGroup createPopulationGroup() {
		PopulationGroupImpl populationGroup = new PopulationGroupImpl();
		return populationGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationInitializer createStandardPopulationInitializer() {
		StandardPopulationInitializerImpl standardPopulationInitializer = new StandardPopulationInitializerImpl();
		return standardPopulationInitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeasonalPopulationModel createSeasonalPopulationModel() {
		SeasonalPopulationModelImpl seasonalPopulationModel = new SeasonalPopulationModelImpl();
		return seasonalPopulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YetiPopulationInitializer createYetiPopulationInitializer() {
		YetiPopulationInitializerImpl yetiPopulationInitializer = new YetiPopulationInitializerImpl();
		return yetiPopulationInitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MosquitoPopulationModel createMosquitoPopulationModel() {
		MosquitoPopulationModelImpl mosquitoPopulationModel = new MosquitoPopulationModelImpl();
		return mosquitoPopulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPackage getStandardPackage() {
		return (StandardPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StandardPackage getPackage() {
		return StandardPackage.eINSTANCE;
	}

} //StandardFactoryImpl
