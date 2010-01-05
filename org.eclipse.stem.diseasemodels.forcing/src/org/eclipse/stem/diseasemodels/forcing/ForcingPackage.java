package org.eclipse.stem.diseasemodels.forcing;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.diseasemodels.forcing.ForcingFactory
 * @model kind="package"
 * @generated
 */
public interface ForcingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "forcing";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/diseasemodels/forcing.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.diseasemodels.forcing";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ForcingPackage eINSTANCE = org.eclipse.stem.diseasemodels.forcing.impl.ForcingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.forcing.impl.ForcingDiseaseModelImpl <em>Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.forcing.impl.ForcingDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.forcing.impl.ForcingPackageImpl#getForcingDiseaseModel()
	 * @generated
	 */
	int FORCING_DISEASE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__URI = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__TYPE_URI = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__DUBLIN_CORE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__LABELS_TO_UPDATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__GRAPH = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__ENABLED = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__GRAPH_DECORATED = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__PROGRESS = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__POPULATION_IDENTIFIER = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__TIME_PERIOD = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__DISEASE_NAME = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__RELATIVE_TOLERANCE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__FINITE_DIFFERENCE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__FREQUENCY_DEPENDENT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__TOTAL_POPULATION_COUNT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__TOTAL_AREA = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__TRANSMISSION_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__RECOVERY_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__INFECTIOUS_MORTALITY = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__IMMUNITY_LOSS_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__SEED = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__SEED;

	/**
	 * The feature id for the '<em><b>Random Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__RANDOM_GENERATOR = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__RANDOM_GENERATOR;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__GAIN = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__GAIN;

	/**
	 * The feature id for the '<em><b>Seasonal Modulation Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modulation Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__MODULATION_PERIOD = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modulation Phase Shift</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Seasonal Modulation Floor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attenuation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL__ATTENUATION = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORCING_DISEASE_MODEL_FEATURE_COUNT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 5;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.forcing.impl.GaussianForcingDiseaseModelImpl <em>Gaussian Forcing Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.forcing.impl.GaussianForcingDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.forcing.impl.ForcingPackageImpl#getGaussianForcingDiseaseModel()
	 * @generated
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__URI = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__TYPE_URI = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__DUBLIN_CORE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__LABELS_TO_UPDATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__GRAPH = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__ENABLED = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__GRAPH_DECORATED = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__PROGRESS = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__POPULATION_IDENTIFIER = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__TIME_PERIOD = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__DISEASE_NAME = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__RELATIVE_TOLERANCE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__FINITE_DIFFERENCE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__FREQUENCY_DEPENDENT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__TOTAL_POPULATION_COUNT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__TOTAL_AREA = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__TRANSMISSION_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__RECOVERY_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__INFECTIOUS_MORTALITY = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__IMMUNITY_LOSS_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__SEED = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__SEED;

	/**
	 * The feature id for the '<em><b>Random Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__RANDOM_GENERATOR = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__RANDOM_GENERATOR;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__GAIN = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__GAIN;

	/**
	 * The feature id for the '<em><b>Sigma2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__SIGMA2 = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modulation Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PERIOD = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modulation Phase Shift</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Modulation Floor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_FLOOR = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Gaussian Forcing Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FORCING_DISEASE_MODEL_FEATURE_COUNT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.forcing.impl.Gaussian2ForcingDiseaseModelImpl <em>Gaussian2 Forcing Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.forcing.impl.Gaussian2ForcingDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.forcing.impl.ForcingPackageImpl#getGaussian2ForcingDiseaseModel()
	 * @generated
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__URI = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__TYPE_URI = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__DUBLIN_CORE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__LABELS_TO_UPDATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__GRAPH = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__ENABLED = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__GRAPH_DECORATED = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__PROGRESS = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__POPULATION_IDENTIFIER = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__TIME_PERIOD = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__DISEASE_NAME = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__RELATIVE_TOLERANCE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__FINITE_DIFFERENCE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__FREQUENCY_DEPENDENT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__TOTAL_POPULATION_COUNT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__TOTAL_AREA = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__TRANSMISSION_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__RECOVERY_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__INFECTIOUS_MORTALITY = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__IMMUNITY_LOSS_RATE = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__SEED = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__SEED;

	/**
	 * The feature id for the '<em><b>Random Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__RANDOM_GENERATOR = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__RANDOM_GENERATOR;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__GAIN = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL__GAIN;

	/**
	 * The feature id for the '<em><b>Sigma2 2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__SIGMA2_2 = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sigma2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__SIGMA2 = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modulation Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__MODULATION_PERIOD = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Modulation Phase Shift</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Modulation Floor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL__MODULATION_FLOOR = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Gaussian2 Forcing Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN2_FORCING_DISEASE_MODEL_FEATURE_COUNT = StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel <em>Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel
	 * @generated
	 */
	EClass getForcingDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getSeasonalModulationExponent <em>Seasonal Modulation Exponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seasonal Modulation Exponent</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getSeasonalModulationExponent()
	 * @see #getForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getForcingDiseaseModel_SeasonalModulationExponent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getModulationPeriod <em>Modulation Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modulation Period</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getModulationPeriod()
	 * @see #getForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getForcingDiseaseModel_ModulationPeriod();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getModulationPhaseShift <em>Modulation Phase Shift</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modulation Phase Shift</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getModulationPhaseShift()
	 * @see #getForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getForcingDiseaseModel_ModulationPhaseShift();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getSeasonalModulationFloor <em>Seasonal Modulation Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seasonal Modulation Floor</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getSeasonalModulationFloor()
	 * @see #getForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getForcingDiseaseModel_SeasonalModulationFloor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getAttenuation <em>Attenuation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attenuation</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.ForcingDiseaseModel#getAttenuation()
	 * @see #getForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getForcingDiseaseModel_Attenuation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel <em>Gaussian Forcing Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gaussian Forcing Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel
	 * @generated
	 */
	EClass getGaussianForcingDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getSigma2 <em>Sigma2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sigma2</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getSigma2()
	 * @see #getGaussianForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getGaussianForcingDiseaseModel_Sigma2();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationPeriod <em>Modulation Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modulation Period</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationPeriod()
	 * @see #getGaussianForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getGaussianForcingDiseaseModel_ModulationPeriod();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationPhaseShift <em>Modulation Phase Shift</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modulation Phase Shift</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationPhaseShift()
	 * @see #getGaussianForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getGaussianForcingDiseaseModel_ModulationPhaseShift();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationFloor <em>Modulation Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modulation Floor</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.GaussianForcingDiseaseModel#getModulationFloor()
	 * @see #getGaussianForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getGaussianForcingDiseaseModel_ModulationFloor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel <em>Gaussian2 Forcing Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gaussian2 Forcing Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel
	 * @generated
	 */
	EClass getGaussian2ForcingDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getSigma2_2 <em>Sigma2 2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sigma2 2</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getSigma2_2()
	 * @see #getGaussian2ForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getGaussian2ForcingDiseaseModel_Sigma2_2();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getSigma2 <em>Sigma2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sigma2</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getSigma2()
	 * @see #getGaussian2ForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getGaussian2ForcingDiseaseModel_Sigma2();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationPeriod <em>Modulation Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modulation Period</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationPeriod()
	 * @see #getGaussian2ForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getGaussian2ForcingDiseaseModel_ModulationPeriod();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationPhaseShift <em>Modulation Phase Shift</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modulation Phase Shift</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationPhaseShift()
	 * @see #getGaussian2ForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getGaussian2ForcingDiseaseModel_ModulationPhaseShift();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationFloor <em>Modulation Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modulation Floor</em>'.
	 * @see org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel#getModulationFloor()
	 * @see #getGaussian2ForcingDiseaseModel()
	 * @generated
	 */
	EAttribute getGaussian2ForcingDiseaseModel_ModulationFloor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ForcingFactory getForcingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.forcing.impl.ForcingDiseaseModelImpl <em>Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.forcing.impl.ForcingDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.forcing.impl.ForcingPackageImpl#getForcingDiseaseModel()
		 * @generated
		 */
		EClass FORCING_DISEASE_MODEL = eINSTANCE.getForcingDiseaseModel();
		/**
		 * The meta object literal for the '<em><b>Seasonal Modulation Exponent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCING_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT = eINSTANCE.getForcingDiseaseModel_SeasonalModulationExponent();
		/**
		 * The meta object literal for the '<em><b>Modulation Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCING_DISEASE_MODEL__MODULATION_PERIOD = eINSTANCE.getForcingDiseaseModel_ModulationPeriod();
		/**
		 * The meta object literal for the '<em><b>Modulation Phase Shift</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT = eINSTANCE.getForcingDiseaseModel_ModulationPhaseShift();
		/**
		 * The meta object literal for the '<em><b>Seasonal Modulation Floor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCING_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR = eINSTANCE.getForcingDiseaseModel_SeasonalModulationFloor();
		/**
		 * The meta object literal for the '<em><b>Attenuation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORCING_DISEASE_MODEL__ATTENUATION = eINSTANCE.getForcingDiseaseModel_Attenuation();
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.forcing.impl.GaussianForcingDiseaseModelImpl <em>Gaussian Forcing Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.forcing.impl.GaussianForcingDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.forcing.impl.ForcingPackageImpl#getGaussianForcingDiseaseModel()
		 * @generated
		 */
		EClass GAUSSIAN_FORCING_DISEASE_MODEL = eINSTANCE.getGaussianForcingDiseaseModel();
		/**
		 * The meta object literal for the '<em><b>Sigma2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN_FORCING_DISEASE_MODEL__SIGMA2 = eINSTANCE.getGaussianForcingDiseaseModel_Sigma2();
		/**
		 * The meta object literal for the '<em><b>Modulation Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PERIOD = eINSTANCE.getGaussianForcingDiseaseModel_ModulationPeriod();
		/**
		 * The meta object literal for the '<em><b>Modulation Phase Shift</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT = eINSTANCE.getGaussianForcingDiseaseModel_ModulationPhaseShift();
		/**
		 * The meta object literal for the '<em><b>Modulation Floor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN_FORCING_DISEASE_MODEL__MODULATION_FLOOR = eINSTANCE.getGaussianForcingDiseaseModel_ModulationFloor();
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.forcing.impl.Gaussian2ForcingDiseaseModelImpl <em>Gaussian2 Forcing Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.forcing.impl.Gaussian2ForcingDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.forcing.impl.ForcingPackageImpl#getGaussian2ForcingDiseaseModel()
		 * @generated
		 */
		EClass GAUSSIAN2_FORCING_DISEASE_MODEL = eINSTANCE.getGaussian2ForcingDiseaseModel();
		/**
		 * The meta object literal for the '<em><b>Sigma2 2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN2_FORCING_DISEASE_MODEL__SIGMA2_2 = eINSTANCE.getGaussian2ForcingDiseaseModel_Sigma2_2();
		/**
		 * The meta object literal for the '<em><b>Sigma2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN2_FORCING_DISEASE_MODEL__SIGMA2 = eINSTANCE.getGaussian2ForcingDiseaseModel_Sigma2();
		/**
		 * The meta object literal for the '<em><b>Modulation Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN2_FORCING_DISEASE_MODEL__MODULATION_PERIOD = eINSTANCE.getGaussian2ForcingDiseaseModel_ModulationPeriod();
		/**
		 * The meta object literal for the '<em><b>Modulation Phase Shift</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN2_FORCING_DISEASE_MODEL__MODULATION_PHASE_SHIFT = eINSTANCE.getGaussian2ForcingDiseaseModel_ModulationPhaseShift();
		/**
		 * The meta object literal for the '<em><b>Modulation Floor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN2_FORCING_DISEASE_MODEL__MODULATION_FLOOR = eINSTANCE.getGaussian2ForcingDiseaseModel_ModulationFloor();

	}

} //ExamplePackage
