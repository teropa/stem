package org.eclipse.stem.diseasemodels.multipopulation;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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

import org.eclipse.emf.ecore.EReference;
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
 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationFactory
 * @model kind="package"
 * @generated
 */
public interface MultipopulationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "multipopulation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/diseasemodels/multipopulation.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.diseasemodels.multipopulation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MultipopulationPackage eINSTANCE = org.eclipse.stem.diseasemodels.multipopulation.impl.MultipopulationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl <em>Multi Population SI Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultipopulationPackageImpl#getMultiPopulationSIDiseaseModel()
	 * @generated
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__URI = StandardPackage.STANDARD_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__TYPE_URI = StandardPackage.STANDARD_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__DUBLIN_CORE = StandardPackage.STANDARD_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__LABELS_TO_UPDATE = StandardPackage.STANDARD_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__GRAPH = StandardPackage.STANDARD_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__ENABLED = StandardPackage.STANDARD_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__GRAPH_DECORATED = StandardPackage.STANDARD_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__PROGRESS = StandardPackage.STANDARD_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = StandardPackage.STANDARD_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_IDENTIFIER = StandardPackage.STANDARD_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__TIME_PERIOD = StandardPackage.STANDARD_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__DISEASE_NAME = StandardPackage.STANDARD_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__RELATIVE_TOLERANCE = StandardPackage.STANDARD_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__FINITE_DIFFERENCE = StandardPackage.STANDARD_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__FREQUENCY_DEPENDENT = StandardPackage.STANDARD_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = StandardPackage.STANDARD_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT = StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__TOTAL_AREA = StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Population Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Characteristic Mixing Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Multi Population SI Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SI_DISEASE_MODEL_FEATURE_COUNT = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 7;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIRDiseaseModelImpl <em>Multi Population SIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultipopulationPackageImpl#getMultiPopulationSIRDiseaseModel()
	 * @generated
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__URI = MULTI_POPULATION_SI_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__TYPE_URI = MULTI_POPULATION_SI_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__DUBLIN_CORE = MULTI_POPULATION_SI_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__LABELS_TO_UPDATE = MULTI_POPULATION_SI_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__GRAPH = MULTI_POPULATION_SI_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__ENABLED = MULTI_POPULATION_SI_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__GRAPH_DECORATED = MULTI_POPULATION_SI_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__PROGRESS = MULTI_POPULATION_SI_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = MULTI_POPULATION_SI_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER = MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__TIME_PERIOD = MULTI_POPULATION_SI_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__DISEASE_NAME = MULTI_POPULATION_SI_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE = MULTI_POPULATION_SI_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__FINITE_DIFFERENCE = MULTI_POPULATION_SI_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = MULTI_POPULATION_SI_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = MULTI_POPULATION_SI_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = MULTI_POPULATION_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = MULTI_POPULATION_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__TOTAL_AREA = MULTI_POPULATION_SI_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = MULTI_POPULATION_SI_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Population Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__POPULATION_GROUPS = MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__TRANSMISSION_RATE = MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__RECOVERY_RATE = MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Characteristic Mixing Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE = MULTI_POPULATION_SI_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE = MULTI_POPULATION_SI_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multi Population SIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SIR_DISEASE_MODEL_FEATURE_COUNT = MULTI_POPULATION_SI_DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSEIRDiseaseModelImpl <em>Multi Population SEIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSEIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultipopulationPackageImpl#getMultiPopulationSEIRDiseaseModel()
	 * @generated
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__URI = MULTI_POPULATION_SIR_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__TYPE_URI = MULTI_POPULATION_SIR_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__DUBLIN_CORE = MULTI_POPULATION_SIR_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__LABELS_TO_UPDATE = MULTI_POPULATION_SIR_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__GRAPH = MULTI_POPULATION_SIR_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__ENABLED = MULTI_POPULATION_SIR_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__GRAPH_DECORATED = MULTI_POPULATION_SIR_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__PROGRESS = MULTI_POPULATION_SIR_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = MULTI_POPULATION_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__POPULATION_IDENTIFIER = MULTI_POPULATION_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__TIME_PERIOD = MULTI_POPULATION_SIR_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__DISEASE_NAME = MULTI_POPULATION_SIR_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__RELATIVE_TOLERANCE = MULTI_POPULATION_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__FINITE_DIFFERENCE = MULTI_POPULATION_SIR_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = MULTI_POPULATION_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = MULTI_POPULATION_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = MULTI_POPULATION_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = MULTI_POPULATION_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__TOTAL_AREA = MULTI_POPULATION_SIR_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = MULTI_POPULATION_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Population Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__POPULATION_GROUPS = MULTI_POPULATION_SIR_DISEASE_MODEL__POPULATION_GROUPS;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__TRANSMISSION_RATE = MULTI_POPULATION_SIR_DISEASE_MODEL__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__RECOVERY_RATE = MULTI_POPULATION_SIR_DISEASE_MODEL__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = MULTI_POPULATION_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = MULTI_POPULATION_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = MULTI_POPULATION_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Characteristic Mixing Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE = MULTI_POPULATION_SIR_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE = MULTI_POPULATION_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Incubation Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE = MULTI_POPULATION_SIR_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multi Population SEIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_POPULATION_SEIR_DISEASE_MODEL_FEATURE_COUNT = MULTI_POPULATION_SIR_DISEASE_MODEL_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel <em>Multi Population SI Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Population SI Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel
	 * @generated
	 */
	EClass getMultiPopulationSIDiseaseModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getTransmissionRate <em>Transmission Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transmission Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getTransmissionRate()
	 * @see #getMultiPopulationSIDiseaseModel()
	 * @generated
	 */
	EReference getMultiPopulationSIDiseaseModel_TransmissionRate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getRecoveryRate <em>Recovery Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Recovery Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getRecoveryRate()
	 * @see #getMultiPopulationSIDiseaseModel()
	 * @generated
	 */
	EReference getMultiPopulationSIDiseaseModel_RecoveryRate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getInfectiousMortalityRate <em>Infectious Mortality Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Infectious Mortality Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getInfectiousMortalityRate()
	 * @see #getMultiPopulationSIDiseaseModel()
	 * @generated
	 */
	EReference getMultiPopulationSIDiseaseModel_InfectiousMortalityRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getPhysicallyAdjacentInfectiousProportion <em>Physically Adjacent Infectious Proportion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Physically Adjacent Infectious Proportion</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getPhysicallyAdjacentInfectiousProportion()
	 * @see #getMultiPopulationSIDiseaseModel()
	 * @generated
	 */
	EAttribute getMultiPopulationSIDiseaseModel_PhysicallyAdjacentInfectiousProportion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getRoadNetworkInfectiousProportion <em>Road Network Infectious Proportion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Road Network Infectious Proportion</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getRoadNetworkInfectiousProportion()
	 * @see #getMultiPopulationSIDiseaseModel()
	 * @generated
	 */
	EAttribute getMultiPopulationSIDiseaseModel_RoadNetworkInfectiousProportion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getCharacteristicMixingDistance <em>Characteristic Mixing Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Characteristic Mixing Distance</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getCharacteristicMixingDistance()
	 * @see #getMultiPopulationSIDiseaseModel()
	 * @generated
	 */
	EAttribute getMultiPopulationSIDiseaseModel_CharacteristicMixingDistance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIRDiseaseModel <em>Multi Population SIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Population SIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIRDiseaseModel
	 * @generated
	 */
	EClass getMultiPopulationSIRDiseaseModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIRDiseaseModel#getImmunityLossRate <em>Immunity Loss Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Immunity Loss Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIRDiseaseModel#getImmunityLossRate()
	 * @see #getMultiPopulationSIRDiseaseModel()
	 * @generated
	 */
	EReference getMultiPopulationSIRDiseaseModel_ImmunityLossRate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSEIRDiseaseModel <em>Multi Population SEIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Population SEIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSEIRDiseaseModel
	 * @generated
	 */
	EClass getMultiPopulationSEIRDiseaseModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSEIRDiseaseModel#getIncubationRate <em>Incubation Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Incubation Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSEIRDiseaseModel#getIncubationRate()
	 * @see #getMultiPopulationSEIRDiseaseModel()
	 * @generated
	 */
	EReference getMultiPopulationSEIRDiseaseModel_IncubationRate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getPopulationGroups <em>Population Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Population Groups</em>'.
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getPopulationGroups()
	 * @see #getMultiPopulationSIDiseaseModel()
	 * @generated
	 */
	EReference getMultiPopulationSIDiseaseModel_PopulationGroups();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MultipopulationFactory getMultipopulationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl <em>Multi Population SI Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultipopulationPackageImpl#getMultiPopulationSIDiseaseModel()
		 * @generated
		 */
		EClass MULTI_POPULATION_SI_DISEASE_MODEL = eINSTANCE.getMultiPopulationSIDiseaseModel();
		/**
		 * The meta object literal for the '<em><b>Transmission Rate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE = eINSTANCE.getMultiPopulationSIDiseaseModel_TransmissionRate();
		/**
		 * The meta object literal for the '<em><b>Recovery Rate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE = eINSTANCE.getMultiPopulationSIDiseaseModel_RecoveryRate();
		/**
		 * The meta object literal for the '<em><b>Infectious Mortality Rate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = eINSTANCE.getMultiPopulationSIDiseaseModel_InfectiousMortalityRate();
		/**
		 * The meta object literal for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = eINSTANCE.getMultiPopulationSIDiseaseModel_PhysicallyAdjacentInfectiousProportion();
		/**
		 * The meta object literal for the '<em><b>Road Network Infectious Proportion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = eINSTANCE.getMultiPopulationSIDiseaseModel_RoadNetworkInfectiousProportion();
		/**
		 * The meta object literal for the '<em><b>Characteristic Mixing Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_POPULATION_SI_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE = eINSTANCE.getMultiPopulationSIDiseaseModel_CharacteristicMixingDistance();
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIRDiseaseModelImpl <em>Multi Population SIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultipopulationPackageImpl#getMultiPopulationSIRDiseaseModel()
		 * @generated
		 */
		EClass MULTI_POPULATION_SIR_DISEASE_MODEL = eINSTANCE.getMultiPopulationSIRDiseaseModel();
		/**
		 * The meta object literal for the '<em><b>Immunity Loss Rate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_POPULATION_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE = eINSTANCE.getMultiPopulationSIRDiseaseModel_ImmunityLossRate();
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSEIRDiseaseModelImpl <em>Multi Population SEIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSEIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.multipopulation.impl.MultipopulationPackageImpl#getMultiPopulationSEIRDiseaseModel()
		 * @generated
		 */
		EClass MULTI_POPULATION_SEIR_DISEASE_MODEL = eINSTANCE.getMultiPopulationSEIRDiseaseModel();
		/**
		 * The meta object literal for the '<em><b>Incubation Rate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE = eINSTANCE.getMultiPopulationSEIRDiseaseModel_IncubationRate();
		/**
		 * The meta object literal for the '<em><b>Population Groups</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS = eINSTANCE.getMultiPopulationSIDiseaseModel_PopulationGroups();

	}

} //MultipopulationPackage
