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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.stem.core.graph.GraphPackage;

import org.eclipse.stem.core.model.ModelPackage;

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
 * @see org.eclipse.stem.diseasemodels.standard.StandardFactory
 * @model kind="package"
 * @generated
 */
public interface StandardPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "standard";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/diseasemodels/standard.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.diseasemodels.standard";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StandardPackage eINSTANCE = org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl <em>Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDiseaseModel()
	 * @generated
	 */
	int DISEASE_MODEL = 3;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__URI = ModelPackage.NODE_DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__TYPE_URI = ModelPackage.NODE_DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__DUBLIN_CORE = ModelPackage.NODE_DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__LABELS_TO_UPDATE = ModelPackage.NODE_DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__GRAPH = ModelPackage.NODE_DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__ENABLED = ModelPackage.NODE_DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__GRAPH_DECORATED = ModelPackage.NODE_DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__PROGRESS = ModelPackage.NODE_DECORATOR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__POPULATION_IDENTIFIER = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__TIME_PERIOD = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__DISEASE_NAME = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__RELATIVE_TOLERANCE = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__FINITE_DIFFERENCE = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__FREQUENCY_DEPENDENT = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL__BACKGROUND_BIRTH_RATE = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_FEATURE_COUNT = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl <em>Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardDiseaseModel()
	 * @generated
	 */
	int STANDARD_DISEASE_MODEL = 19;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__URI = DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__TYPE_URI = DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__DUBLIN_CORE = DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__LABELS_TO_UPDATE = DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__GRAPH = DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__ENABLED = DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__GRAPH_DECORATED = DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__PROGRESS = DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__POPULATION_IDENTIFIER = DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__TIME_PERIOD = DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__DISEASE_NAME = DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__RELATIVE_TOLERANCE = DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__FINITE_DIFFERENCE = DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__FREQUENCY_DEPENDENT = DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT = DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__TOTAL_AREA = DISEASE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = DISEASE_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_FEATURE_COUNT = DISEASE_MODEL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIImpl <em>SI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSI()
	 * @generated
	 */
	int SI = 11;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__URI = STANDARD_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__TYPE_URI = STANDARD_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__DUBLIN_CORE = STANDARD_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__LABELS_TO_UPDATE = STANDARD_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__GRAPH = STANDARD_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__ENABLED = STANDARD_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__GRAPH_DECORATED = STANDARD_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__PROGRESS = STANDARD_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__BACKGROUND_MORTALITY_RATE = STANDARD_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__POPULATION_IDENTIFIER = STANDARD_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__TIME_PERIOD = STANDARD_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__DISEASE_NAME = STANDARD_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__RELATIVE_TOLERANCE = STANDARD_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__FINITE_DIFFERENCE = STANDARD_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__FREQUENCY_DEPENDENT = STANDARD_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__BACKGROUND_BIRTH_RATE = STANDARD_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__TOTAL_POPULATION_COUNT = STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__TOTAL_POPULATION_COUNT_RECIPROCAL = STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__TOTAL_AREA = STANDARD_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__REFERENCE_POPULATION_DENSITY = STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__TRANSMISSION_RATE = STANDARD_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__NON_LINEARITY_COEFFICIENT = STANDARD_DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__RECOVERY_RATE = STANDARD_DISEASE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__INFECTIOUS_MORTALITY_RATE = STANDARD_DISEASE_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = STANDARD_DISEASE_MODEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__ROAD_NETWORK_INFECTIOUS_PROPORTION = STANDARD_DISEASE_MODEL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI__INFECTIOUS_MORTALITY = STANDARD_DISEASE_MODEL_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>SI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_FEATURE_COUNT = STANDARD_DISEASE_MODEL_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIRImpl <em>SIR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIRImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIR()
	 * @generated
	 */
	int SIR = 16;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__URI = SI__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__TYPE_URI = SI__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__DUBLIN_CORE = SI__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__LABELS_TO_UPDATE = SI__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__GRAPH = SI__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__ENABLED = SI__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__GRAPH_DECORATED = SI__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__PROGRESS = SI__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__BACKGROUND_MORTALITY_RATE = SI__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__POPULATION_IDENTIFIER = SI__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__TIME_PERIOD = SI__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__DISEASE_NAME = SI__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__RELATIVE_TOLERANCE = SI__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__FINITE_DIFFERENCE = SI__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__FREQUENCY_DEPENDENT = SI__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__BACKGROUND_BIRTH_RATE = SI__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__TOTAL_POPULATION_COUNT = SI__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__TOTAL_POPULATION_COUNT_RECIPROCAL = SI__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__TOTAL_AREA = SI__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__REFERENCE_POPULATION_DENSITY = SI__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__TRANSMISSION_RATE = SI__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__NON_LINEARITY_COEFFICIENT = SI__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__RECOVERY_RATE = SI__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__INFECTIOUS_MORTALITY_RATE = SI__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SI__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__ROAD_NETWORK_INFECTIOUS_PROPORTION = SI__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__INFECTIOUS_MORTALITY = SI__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR__IMMUNITY_LOSS_RATE = SI_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SIR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_FEATURE_COUNT = SI_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRImpl <em>SEIR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SEIRImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSEIR()
	 * @generated
	 */
	int SEIR = 8;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__URI = SIR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__TYPE_URI = SIR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__DUBLIN_CORE = SIR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__LABELS_TO_UPDATE = SIR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__GRAPH = SIR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__ENABLED = SIR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__GRAPH_DECORATED = SIR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__PROGRESS = SIR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__BACKGROUND_MORTALITY_RATE = SIR__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__POPULATION_IDENTIFIER = SIR__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__TIME_PERIOD = SIR__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__DISEASE_NAME = SIR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__RELATIVE_TOLERANCE = SIR__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__FINITE_DIFFERENCE = SIR__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__FREQUENCY_DEPENDENT = SIR__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__BACKGROUND_BIRTH_RATE = SIR__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__TOTAL_POPULATION_COUNT = SIR__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__TOTAL_POPULATION_COUNT_RECIPROCAL = SIR__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__TOTAL_AREA = SIR__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__REFERENCE_POPULATION_DENSITY = SIR__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__TRANSMISSION_RATE = SIR__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__NON_LINEARITY_COEFFICIENT = SIR__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__RECOVERY_RATE = SIR__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__INFECTIOUS_MORTALITY_RATE = SIR__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SIR__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__ROAD_NETWORK_INFECTIOUS_PROPORTION = SIR__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__INFECTIOUS_MORTALITY = SIR__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__IMMUNITY_LOSS_RATE = SIR__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Incubation Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR__INCUBATION_RATE = SIR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SEIR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_FEATURE_COUNT = SIR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DeterministicSEIRDiseaseModelImpl <em>Deterministic SEIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DeterministicSEIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDeterministicSEIRDiseaseModel()
	 * @generated
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__URI = SEIR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__TYPE_URI = SEIR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__DUBLIN_CORE = SEIR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__LABELS_TO_UPDATE = SEIR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__GRAPH = SEIR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__ENABLED = SEIR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__GRAPH_DECORATED = SEIR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__PROGRESS = SEIR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SEIR__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__POPULATION_IDENTIFIER = SEIR__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__TIME_PERIOD = SEIR__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__DISEASE_NAME = SEIR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__RELATIVE_TOLERANCE = SEIR__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__FINITE_DIFFERENCE = SEIR__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = SEIR__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SEIR__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SEIR__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SEIR__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__TOTAL_AREA = SEIR__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SEIR__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__TRANSMISSION_RATE = SEIR__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SEIR__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__RECOVERY_RATE = SEIR__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SEIR__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SEIR__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SEIR__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY = SEIR__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE = SEIR__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Incubation Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL__INCUBATION_RATE = SEIR__INCUBATION_RATE;

	/**
	 * The number of structural features of the '<em>Deterministic SEIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SEIR_DISEASE_MODEL_FEATURE_COUNT = SEIR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIDiseaseModelImpl <em>Deterministic SI Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDeterministicSIDiseaseModel()
	 * @generated
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__URI = SI__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__TYPE_URI = SI__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__DUBLIN_CORE = SI__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__LABELS_TO_UPDATE = SI__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__GRAPH = SI__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__ENABLED = SI__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__GRAPH_DECORATED = SI__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__PROGRESS = SI__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SI__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__POPULATION_IDENTIFIER = SI__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__TIME_PERIOD = SI__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__DISEASE_NAME = SI__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__RELATIVE_TOLERANCE = SI__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__FINITE_DIFFERENCE = SI__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__FREQUENCY_DEPENDENT = SI__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SI__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SI__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SI__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__TOTAL_AREA = SI__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SI__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__TRANSMISSION_RATE = SI__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SI__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__RECOVERY_RATE = SI__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SI__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SI__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SI__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY = SI__INFECTIOUS_MORTALITY;

	/**
	 * The number of structural features of the '<em>Deterministic SI Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SI_DISEASE_MODEL_FEATURE_COUNT = SI_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIRDiseaseModelImpl <em>Deterministic SIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDeterministicSIRDiseaseModel()
	 * @generated
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__URI = SIR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__TYPE_URI = SIR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__DUBLIN_CORE = SIR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__LABELS_TO_UPDATE = SIR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__GRAPH = SIR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__ENABLED = SIR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__GRAPH_DECORATED = SIR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__PROGRESS = SIR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SIR__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER = SIR__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__TIME_PERIOD = SIR__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__DISEASE_NAME = SIR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE = SIR__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__FINITE_DIFFERENCE = SIR__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = SIR__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SIR__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SIR__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SIR__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__TOTAL_AREA = SIR__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SIR__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__TRANSMISSION_RATE = SIR__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SIR__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__RECOVERY_RATE = SIR__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SIR__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SIR__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SIR__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY = SIR__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE = SIR__IMMUNITY_LOSS_RATE;

	/**
	 * The number of structural features of the '<em>Deterministic SIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETERMINISTIC_SIR_DISEASE_MODEL_FEATURE_COUNT = SIR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelImpl <em>Disease Model Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDiseaseModelLabel()
	 * @generated
	 */
	int DISEASE_MODEL_LABEL = 4;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__URI = GraphPackage.DYNAMIC_NODE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__TYPE_URI = GraphPackage.DYNAMIC_NODE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__DUBLIN_CORE = GraphPackage.DYNAMIC_NODE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.DYNAMIC_NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__CURRENT_VALUE = GraphPackage.DYNAMIC_NODE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__IDENTIFIABLE = GraphPackage.DYNAMIC_NODE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__NEXT_VALUE_VALID = GraphPackage.DYNAMIC_NODE_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__NEXT_VALUE = GraphPackage.DYNAMIC_NODE_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__DECORATOR = GraphPackage.DYNAMIC_NODE_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__NODE = GraphPackage.DYNAMIC_NODE_LABEL__NODE;

	/**
	 * The feature id for the '<em><b>Population Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__POPULATION_LABEL = GraphPackage.DYNAMIC_NODE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Disease Model State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE = GraphPackage.DYNAMIC_NODE_LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Population Model Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL = GraphPackage.DYNAMIC_NODE_LABEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Disease Model Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL_FEATURE_COUNT = GraphPackage.DYNAMIC_NODE_LABEL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl <em>Disease Model Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDiseaseModelLabelValue()
	 * @generated
	 */
	int DISEASE_MODEL_LABEL_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Disease Deaths</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL_VALUE__POPULATION_COUNT = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL_VALUE__INCIDENCE = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Disease Model Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_LABEL_VALUE_FEATURE_COUNT = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelStateImpl <em>Disease Model State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelStateImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDiseaseModelState()
	 * @generated
	 */
	int DISEASE_MODEL_STATE = 6;

	/**
	 * The feature id for the '<em><b>Label</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_STATE__LABEL = 0;

	/**
	 * The number of structural features of the '<em>Disease Model State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISEASE_MODEL_STATE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl <em>Infector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getInfector()
	 * @generated
	 */
	int INFECTOR = 7;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__URI = ModelPackage.NODE_DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__TYPE_URI = ModelPackage.NODE_DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__DUBLIN_CORE = ModelPackage.NODE_DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__LABELS_TO_UPDATE = ModelPackage.NODE_DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__GRAPH = ModelPackage.NODE_DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__ENABLED = ModelPackage.NODE_DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__GRAPH_DECORATED = ModelPackage.NODE_DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__PROGRESS = ModelPackage.NODE_DECORATOR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Disease Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__DISEASE_MODEL = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__TARGET_URI = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__DISEASE_NAME = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__TARGET_ISO_KEY = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Labels To Infect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__LABELS_TO_INFECT = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR__POPULATION_IDENTIFIER = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Infector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFECTOR_FEATURE_COUNT = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelImpl <em>Disease Model Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardDiseaseModelLabel()
	 * @generated
	 */
	int STANDARD_DISEASE_MODEL_LABEL = 20;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__URI = DISEASE_MODEL_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__TYPE_URI = DISEASE_MODEL_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__DUBLIN_CORE = DISEASE_MODEL_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = DISEASE_MODEL_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__CURRENT_VALUE = DISEASE_MODEL_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__IDENTIFIABLE = DISEASE_MODEL_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__NEXT_VALUE_VALID = DISEASE_MODEL_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__NEXT_VALUE = DISEASE_MODEL_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__DECORATOR = DISEASE_MODEL_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__NODE = DISEASE_MODEL_LABEL__NODE;

	/**
	 * The feature id for the '<em><b>Population Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__POPULATION_LABEL = DISEASE_MODEL_LABEL__POPULATION_LABEL;

	/**
	 * The feature id for the '<em><b>Disease Model State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE = DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE;

	/**
	 * The feature id for the '<em><b>Population Model Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL = DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL;

	/**
	 * The number of structural features of the '<em>Disease Model Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT = DISEASE_MODEL_LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl <em>SI Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSILabel()
	 * @generated
	 */
	int SI_LABEL = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl <em>SIR Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIRLabel()
	 * @generated
	 */
	int SIR_LABEL = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl <em>SEIR Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSEIRLabel()
	 * @generated
	 */
	int SEIR_LABEL = 9;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__URI = STANDARD_DISEASE_MODEL_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__TYPE_URI = STANDARD_DISEASE_MODEL_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__DUBLIN_CORE = STANDARD_DISEASE_MODEL_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = STANDARD_DISEASE_MODEL_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__CURRENT_VALUE = STANDARD_DISEASE_MODEL_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__IDENTIFIABLE = STANDARD_DISEASE_MODEL_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__NEXT_VALUE_VALID = STANDARD_DISEASE_MODEL_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__NEXT_VALUE = STANDARD_DISEASE_MODEL_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__DECORATOR = STANDARD_DISEASE_MODEL_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__NODE = STANDARD_DISEASE_MODEL_LABEL__NODE;

	/**
	 * The feature id for the '<em><b>Population Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__POPULATION_LABEL = STANDARD_DISEASE_MODEL_LABEL__POPULATION_LABEL;

	/**
	 * The feature id for the '<em><b>Disease Model State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__DISEASE_MODEL_STATE = STANDARD_DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE;

	/**
	 * The feature id for the '<em><b>Population Model Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__POPULATION_MODEL_LABEL = STANDARD_DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL;

	/**
	 * The feature id for the '<em><b>Delta Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__DELTA_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Probe Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__PROBE_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Temp Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__TEMP_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__ORIGINAL_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Scale</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL__ERROR_SCALE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SEIR Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL_FEATURE_COUNT = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelValueImpl <em>Disease Model Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelValueImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardDiseaseModelLabelValue()
	 * @generated
	 */
	int STANDARD_DISEASE_MODEL_LABEL_VALUE = 21;

	/**
	 * The feature id for the '<em><b>Disease Deaths</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS = DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS;

	/**
	 * The feature id for the '<em><b>Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL_VALUE__POPULATION_COUNT = DISEASE_MODEL_LABEL_VALUE__POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Incidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL_VALUE__INCIDENCE = DISEASE_MODEL_LABEL_VALUE__INCIDENCE;

	/**
	 * The feature id for the '<em><b>S</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL_VALUE__S = DISEASE_MODEL_LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Disease Model Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_LABEL_VALUE_FEATURE_COUNT = DISEASE_MODEL_LABEL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl <em>SI Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSILabelValue()
	 * @generated
	 */
	int SI_LABEL_VALUE = 15;

	/**
	 * The feature id for the '<em><b>Disease Deaths</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL_VALUE__DISEASE_DEATHS = STANDARD_DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS;

	/**
	 * The feature id for the '<em><b>Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL_VALUE__POPULATION_COUNT = STANDARD_DISEASE_MODEL_LABEL_VALUE__POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Incidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL_VALUE__INCIDENCE = STANDARD_DISEASE_MODEL_LABEL_VALUE__INCIDENCE;

	/**
	 * The feature id for the '<em><b>S</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL_VALUE__S = STANDARD_DISEASE_MODEL_LABEL_VALUE__S;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL_VALUE__I = STANDARD_DISEASE_MODEL_LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SI Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL_VALUE_FEATURE_COUNT = STANDARD_DISEASE_MODEL_LABEL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl <em>SIR Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIRLabelValue()
	 * @generated
	 */
	int SIR_LABEL_VALUE = 18;

	/**
	 * The feature id for the '<em><b>Disease Deaths</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL_VALUE__DISEASE_DEATHS = SI_LABEL_VALUE__DISEASE_DEATHS;

	/**
	 * The feature id for the '<em><b>Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL_VALUE__POPULATION_COUNT = SI_LABEL_VALUE__POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Incidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL_VALUE__INCIDENCE = SI_LABEL_VALUE__INCIDENCE;

	/**
	 * The feature id for the '<em><b>S</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL_VALUE__S = SI_LABEL_VALUE__S;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL_VALUE__I = SI_LABEL_VALUE__I;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL_VALUE__R = SI_LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SIR Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL_VALUE_FEATURE_COUNT = SI_LABEL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl <em>SEIR Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSEIRLabelValue()
	 * @generated
	 */
	int SEIR_LABEL_VALUE = 10;

	/**
	 * The feature id for the '<em><b>Disease Deaths</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL_VALUE__DISEASE_DEATHS = SIR_LABEL_VALUE__DISEASE_DEATHS;

	/**
	 * The feature id for the '<em><b>Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL_VALUE__POPULATION_COUNT = SIR_LABEL_VALUE__POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Incidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL_VALUE__INCIDENCE = SIR_LABEL_VALUE__INCIDENCE;

	/**
	 * The feature id for the '<em><b>S</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL_VALUE__S = SIR_LABEL_VALUE__S;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL_VALUE__I = SIR_LABEL_VALUE__I;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL_VALUE__R = SIR_LABEL_VALUE__R;

	/**
	 * The feature id for the '<em><b>E</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL_VALUE__E = SIR_LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SEIR Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEIR_LABEL_VALUE_FEATURE_COUNT = SIR_LABEL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelStateImpl <em>Disease Model State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelStateImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardDiseaseModelState()
	 * @generated
	 */
	int STANDARD_DISEASE_MODEL_STATE = 22;

	/**
	 * The feature id for the '<em><b>Label</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_STATE__LABEL = DISEASE_MODEL_STATE__LABEL;

	/**
	 * The feature id for the '<em><b>Area Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_STATE__AREA_RATIO = DISEASE_MODEL_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Disease Model State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_DISEASE_MODEL_STATE_FEATURE_COUNT = DISEASE_MODEL_STATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIDiseaseModelStateImpl <em>SI Disease Model State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIDiseaseModelStateImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIDiseaseModelState()
	 * @generated
	 */
	int SI_DISEASE_MODEL_STATE = 12;

	/**
	 * The feature id for the '<em><b>Label</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_DISEASE_MODEL_STATE__LABEL = STANDARD_DISEASE_MODEL_STATE__LABEL;

	/**
	 * The feature id for the '<em><b>Area Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_DISEASE_MODEL_STATE__AREA_RATIO = STANDARD_DISEASE_MODEL_STATE__AREA_RATIO;

	/**
	 * The number of structural features of the '<em>SI Disease Model State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_DISEASE_MODEL_STATE_FEATURE_COUNT = STANDARD_DISEASE_MODEL_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardInfectorImpl <em>Infector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardInfectorImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardInfector()
	 * @generated
	 */
	int STANDARD_INFECTOR = 23;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__URI = INFECTOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__TYPE_URI = INFECTOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__DUBLIN_CORE = INFECTOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__LABELS_TO_UPDATE = INFECTOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__GRAPH = INFECTOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__ENABLED = INFECTOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__GRAPH_DECORATED = INFECTOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__PROGRESS = INFECTOR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Disease Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__DISEASE_MODEL = INFECTOR__DISEASE_MODEL;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__TARGET_URI = INFECTOR__TARGET_URI;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__DISEASE_NAME = INFECTOR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__TARGET_ISO_KEY = INFECTOR__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Labels To Infect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__LABELS_TO_INFECT = INFECTOR__LABELS_TO_INFECT;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR__POPULATION_IDENTIFIER = INFECTOR__POPULATION_IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Infector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_INFECTOR_FEATURE_COUNT = INFECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIInfectorImpl <em>SI Infector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIInfectorImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIInfector()
	 * @generated
	 */
	int SI_INFECTOR = 13;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__URI = STANDARD_INFECTOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__TYPE_URI = STANDARD_INFECTOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__DUBLIN_CORE = STANDARD_INFECTOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__LABELS_TO_UPDATE = STANDARD_INFECTOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__GRAPH = STANDARD_INFECTOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__ENABLED = STANDARD_INFECTOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__GRAPH_DECORATED = STANDARD_INFECTOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__PROGRESS = STANDARD_INFECTOR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Disease Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__DISEASE_MODEL = STANDARD_INFECTOR__DISEASE_MODEL;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__TARGET_URI = STANDARD_INFECTOR__TARGET_URI;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__DISEASE_NAME = STANDARD_INFECTOR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__TARGET_ISO_KEY = STANDARD_INFECTOR__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Labels To Infect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__LABELS_TO_INFECT = STANDARD_INFECTOR__LABELS_TO_INFECT;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__POPULATION_IDENTIFIER = STANDARD_INFECTOR__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Infectious Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR__INFECTIOUS_COUNT = STANDARD_INFECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SI Infector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_INFECTOR_FEATURE_COUNT = STANDARD_INFECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__URI = STANDARD_DISEASE_MODEL_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__TYPE_URI = STANDARD_DISEASE_MODEL_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__DUBLIN_CORE = STANDARD_DISEASE_MODEL_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = STANDARD_DISEASE_MODEL_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__CURRENT_VALUE = STANDARD_DISEASE_MODEL_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__IDENTIFIABLE = STANDARD_DISEASE_MODEL_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__NEXT_VALUE_VALID = STANDARD_DISEASE_MODEL_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__NEXT_VALUE = STANDARD_DISEASE_MODEL_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__DECORATOR = STANDARD_DISEASE_MODEL_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__NODE = STANDARD_DISEASE_MODEL_LABEL__NODE;

	/**
	 * The feature id for the '<em><b>Population Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__POPULATION_LABEL = STANDARD_DISEASE_MODEL_LABEL__POPULATION_LABEL;

	/**
	 * The feature id for the '<em><b>Disease Model State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__DISEASE_MODEL_STATE = STANDARD_DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE;

	/**
	 * The feature id for the '<em><b>Population Model Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__POPULATION_MODEL_LABEL = STANDARD_DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL;

	/**
	 * The feature id for the '<em><b>Delta Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__DELTA_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Probe Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__PROBE_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Temp Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__TEMP_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__ORIGINAL_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Scale</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL__ERROR_SCALE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SI Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SI_LABEL_FEATURE_COUNT = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__URI = STANDARD_DISEASE_MODEL_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__TYPE_URI = STANDARD_DISEASE_MODEL_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__DUBLIN_CORE = STANDARD_DISEASE_MODEL_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = STANDARD_DISEASE_MODEL_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__CURRENT_VALUE = STANDARD_DISEASE_MODEL_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__IDENTIFIABLE = STANDARD_DISEASE_MODEL_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__NEXT_VALUE_VALID = STANDARD_DISEASE_MODEL_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__NEXT_VALUE = STANDARD_DISEASE_MODEL_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__DECORATOR = STANDARD_DISEASE_MODEL_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__NODE = STANDARD_DISEASE_MODEL_LABEL__NODE;

	/**
	 * The feature id for the '<em><b>Population Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__POPULATION_LABEL = STANDARD_DISEASE_MODEL_LABEL__POPULATION_LABEL;

	/**
	 * The feature id for the '<em><b>Disease Model State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__DISEASE_MODEL_STATE = STANDARD_DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE;

	/**
	 * The feature id for the '<em><b>Population Model Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__POPULATION_MODEL_LABEL = STANDARD_DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL;

	/**
	 * The feature id for the '<em><b>Delta Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__DELTA_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Probe Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__PROBE_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Temp Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__TEMP_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__ORIGINAL_VALUE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Scale</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL__ERROR_SCALE = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SIR Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_LABEL_FEATURE_COUNT = STANDARD_DISEASE_MODEL_LABEL_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticSEIRDiseaseModelImpl <em>Stochastic SEIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticSEIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticSEIRDiseaseModel()
	 * @generated
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL = 24;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__URI = SEIR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__TYPE_URI = SEIR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__DUBLIN_CORE = SEIR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__LABELS_TO_UPDATE = SEIR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__GRAPH = SEIR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__ENABLED = SEIR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__GRAPH_DECORATED = SEIR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__PROGRESS = SEIR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SEIR__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__POPULATION_IDENTIFIER = SEIR__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__TIME_PERIOD = SEIR__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__DISEASE_NAME = SEIR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__RELATIVE_TOLERANCE = SEIR__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__FINITE_DIFFERENCE = SEIR__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = SEIR__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SEIR__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SEIR__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SEIR__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__TOTAL_AREA = SEIR__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SEIR__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__TRANSMISSION_RATE = SEIR__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SEIR__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__RECOVERY_RATE = SEIR__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SEIR__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SEIR__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SEIR__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY = SEIR__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE = SEIR__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Incubation Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__INCUBATION_RATE = SEIR__INCUBATION_RATE;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__SEED = SEIR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Random Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__RANDOM_GENERATOR = SEIR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL__GAIN = SEIR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stochastic SEIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SEIR_DISEASE_MODEL_FEATURE_COUNT = SEIR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticSIDiseaseModelImpl <em>Stochastic SI Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticSIDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticSIDiseaseModel()
	 * @generated
	 */
	int STOCHASTIC_SI_DISEASE_MODEL = 25;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__URI = SI__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__TYPE_URI = SI__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__DUBLIN_CORE = SI__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__LABELS_TO_UPDATE = SI__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__GRAPH = SI__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__ENABLED = SI__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__GRAPH_DECORATED = SI__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__PROGRESS = SI__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SI__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__POPULATION_IDENTIFIER = SI__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__TIME_PERIOD = SI__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__DISEASE_NAME = SI__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__RELATIVE_TOLERANCE = SI__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__FINITE_DIFFERENCE = SI__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__FREQUENCY_DEPENDENT = SI__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SI__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SI__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SI__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__TOTAL_AREA = SI__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SI__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__TRANSMISSION_RATE = SI__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SI__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__RECOVERY_RATE = SI__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SI__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SI__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SI__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY = SI__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__SEED = SI_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Random Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__RANDOM_GENERATOR = SI_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL__GAIN = SI_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stochastic SI Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SI_DISEASE_MODEL_FEATURE_COUNT = SI_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticSIRDiseaseModelImpl <em>Stochastic SIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticSIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticSIRDiseaseModel()
	 * @generated
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL = 26;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__URI = SIR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__TYPE_URI = SIR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__DUBLIN_CORE = SIR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__LABELS_TO_UPDATE = SIR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__GRAPH = SIR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__ENABLED = SIR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__GRAPH_DECORATED = SIR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__PROGRESS = SIR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SIR__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER = SIR__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__TIME_PERIOD = SIR__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__DISEASE_NAME = SIR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE = SIR__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__FINITE_DIFFERENCE = SIR__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = SIR__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SIR__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SIR__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SIR__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__TOTAL_AREA = SIR__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SIR__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__TRANSMISSION_RATE = SIR__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SIR__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__RECOVERY_RATE = SIR__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SIR__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SIR__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SIR__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY = SIR__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE = SIR__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__SEED = SIR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Random Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__RANDOM_GENERATOR = SIR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL__GAIN = SIR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stochastic SIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_SIR_DISEASE_MODEL_FEATURE_COUNT = SIR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.SanityChecker <em>Sanity Checker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.SanityChecker
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSanityChecker()
	 * @generated
	 */
	int SANITY_CHECKER = 27;

	/**
	 * The number of structural features of the '<em>Sanity Checker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANITY_CHECKER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.IntegrationLabel <em>Integration Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.IntegrationLabel
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getIntegrationLabel()
	 * @generated
	 */
	int INTEGRATION_LABEL = 28;

	/**
	 * The number of structural features of the '<em>Integration Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATION_LABEL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.IntegrationLabelValue <em>Integration Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.IntegrationLabelValue
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getIntegrationLabelValue()
	 * @generated
	 */
	int INTEGRATION_LABEL_VALUE = 29;

	/**
	 * The number of structural features of the '<em>Integration Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATION_LABEL_VALUE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.model.IntegrationDecorator <em>Integration Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.model.IntegrationDecorator
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getIntegrationDecorator()
	 * @generated
	 */
	int INTEGRATION_DECORATOR = 30;

	/**
	 * The number of structural features of the '<em>Integration Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATION_DECORATOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.AggregatingSIDiseaseModelImpl <em>Aggregating SI Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.AggregatingSIDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getAggregatingSIDiseaseModel()
	 * @generated
	 */
	int AGGREGATING_SI_DISEASE_MODEL = 31;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__URI = SI__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__TYPE_URI = SI__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__DUBLIN_CORE = SI__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__LABELS_TO_UPDATE = SI__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__GRAPH = SI__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__ENABLED = SI__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__GRAPH_DECORATED = SI__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__PROGRESS = SI__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SI__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__POPULATION_IDENTIFIER = SI__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__TIME_PERIOD = SI__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__DISEASE_NAME = SI__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__RELATIVE_TOLERANCE = SI__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__FINITE_DIFFERENCE = SI__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__FREQUENCY_DEPENDENT = SI__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SI__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SI__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SI__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__TOTAL_AREA = SI__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SI__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__TRANSMISSION_RATE = SI__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SI__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__RECOVERY_RATE = SI__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SI__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SI__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SI__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY = SI__INFECTIOUS_MORTALITY;

	/**
	 * The number of structural features of the '<em>Aggregating SI Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SI_DISEASE_MODEL_FEATURE_COUNT = SI_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.AggregatingDiseaseModelStateImpl <em>Aggregating Disease Model State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.AggregatingDiseaseModelStateImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getAggregatingDiseaseModelState()
	 * @generated
	 */
	int AGGREGATING_DISEASE_MODEL_STATE = 32;

	/**
	 * The feature id for the '<em><b>Label</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_DISEASE_MODEL_STATE__LABEL = DISEASE_MODEL_STATE__LABEL;

	/**
	 * The feature id for the '<em><b>Childrens Labels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_DISEASE_MODEL_STATE__CHILDRENS_LABELS = DISEASE_MODEL_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aggregating Disease Model State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_DISEASE_MODEL_STATE_FEATURE_COUNT = DISEASE_MODEL_STATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.AggregatingSIRDiseaseModelImpl <em>Aggregating SIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.AggregatingSIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getAggregatingSIRDiseaseModel()
	 * @generated
	 */
	int AGGREGATING_SIR_DISEASE_MODEL = 34;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__URI = AGGREGATING_SI_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__TYPE_URI = AGGREGATING_SI_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__DUBLIN_CORE = AGGREGATING_SI_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__LABELS_TO_UPDATE = AGGREGATING_SI_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__GRAPH = AGGREGATING_SI_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__ENABLED = AGGREGATING_SI_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__GRAPH_DECORATED = AGGREGATING_SI_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__PROGRESS = AGGREGATING_SI_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = AGGREGATING_SI_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER = AGGREGATING_SI_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__TIME_PERIOD = AGGREGATING_SI_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__DISEASE_NAME = AGGREGATING_SI_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE = AGGREGATING_SI_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__FINITE_DIFFERENCE = AGGREGATING_SI_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = AGGREGATING_SI_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = AGGREGATING_SI_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = AGGREGATING_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = AGGREGATING_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__TOTAL_AREA = AGGREGATING_SI_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = AGGREGATING_SI_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__TRANSMISSION_RATE = AGGREGATING_SI_DISEASE_MODEL__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = AGGREGATING_SI_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__RECOVERY_RATE = AGGREGATING_SI_DISEASE_MODEL__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = AGGREGATING_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = AGGREGATING_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = AGGREGATING_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY = AGGREGATING_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY;

	/**
	 * The number of structural features of the '<em>Aggregating SIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SIR_DISEASE_MODEL_FEATURE_COUNT = AGGREGATING_SI_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.AggregatingSEIRDiseaseModelImpl <em>Aggregating SEIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.AggregatingSEIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getAggregatingSEIRDiseaseModel()
	 * @generated
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL = 33;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__URI = AGGREGATING_SIR_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__TYPE_URI = AGGREGATING_SIR_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__DUBLIN_CORE = AGGREGATING_SIR_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__LABELS_TO_UPDATE = AGGREGATING_SIR_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__GRAPH = AGGREGATING_SIR_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__ENABLED = AGGREGATING_SIR_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__GRAPH_DECORATED = AGGREGATING_SIR_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__PROGRESS = AGGREGATING_SIR_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = AGGREGATING_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__POPULATION_IDENTIFIER = AGGREGATING_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__TIME_PERIOD = AGGREGATING_SIR_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__DISEASE_NAME = AGGREGATING_SIR_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__RELATIVE_TOLERANCE = AGGREGATING_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__FINITE_DIFFERENCE = AGGREGATING_SIR_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = AGGREGATING_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = AGGREGATING_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = AGGREGATING_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = AGGREGATING_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__TOTAL_AREA = AGGREGATING_SIR_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = AGGREGATING_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__TRANSMISSION_RATE = AGGREGATING_SIR_DISEASE_MODEL__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = AGGREGATING_SIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__RECOVERY_RATE = AGGREGATING_SIR_DISEASE_MODEL__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = AGGREGATING_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = AGGREGATING_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = AGGREGATING_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY = AGGREGATING_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY;

	/**
	 * The number of structural features of the '<em>Aggregating SEIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATING_SEIR_DISEASE_MODEL_FEATURE_COUNT = AGGREGATING_SIR_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl <em>Stochastic Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticDiseaseModel()
	 * @generated
	 */
	int STOCHASTIC_DISEASE_MODEL = 35;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__URI = DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__TYPE_URI = DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__DUBLIN_CORE = DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__LABELS_TO_UPDATE = DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__GRAPH = DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__ENABLED = DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__GRAPH_DECORATED = DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__PROGRESS = DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__POPULATION_IDENTIFIER = DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__TIME_PERIOD = DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__DISEASE_NAME = DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__RELATIVE_TOLERANCE = DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__FINITE_DIFFERENCE = DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__FREQUENCY_DEPENDENT = DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__SEED = DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Random Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL__RANDOM_GENERATOR = DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Stochastic Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_DISEASE_MODEL_FEATURE_COUNT = DISEASE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardStochasticDiseaseModelImpl <em>Stochastic Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardStochasticDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardStochasticDiseaseModel()
	 * @generated
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL = 36;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__URI = STOCHASTIC_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__TYPE_URI = STOCHASTIC_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__DUBLIN_CORE = STOCHASTIC_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__LABELS_TO_UPDATE = STOCHASTIC_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__GRAPH = STOCHASTIC_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__ENABLED = STOCHASTIC_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__GRAPH_DECORATED = STOCHASTIC_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__PROGRESS = STOCHASTIC_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = STOCHASTIC_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__POPULATION_IDENTIFIER = STOCHASTIC_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__TIME_PERIOD = STOCHASTIC_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__DISEASE_NAME = STOCHASTIC_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__RELATIVE_TOLERANCE = STOCHASTIC_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__FINITE_DIFFERENCE = STOCHASTIC_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__FREQUENCY_DEPENDENT = STOCHASTIC_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = STOCHASTIC_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__SEED = STOCHASTIC_DISEASE_MODEL__SEED;

	/**
	 * The feature id for the '<em><b>Random Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__RANDOM_GENERATOR = STOCHASTIC_DISEASE_MODEL__RANDOM_GENERATOR;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL__GAIN = STOCHASTIC_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stochastic Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_STOCHASTIC_DISEASE_MODEL_FEATURE_COUNT = STOCHASTIC_DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIRInoculatorImpl <em>SIR Inoculator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIRInoculatorImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIRInoculator()
	 * @generated
	 */
	int SIR_INOCULATOR = 37;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__URI = SI_INFECTOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__TYPE_URI = SI_INFECTOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__DUBLIN_CORE = SI_INFECTOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__LABELS_TO_UPDATE = SI_INFECTOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__GRAPH = SI_INFECTOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__ENABLED = SI_INFECTOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__GRAPH_DECORATED = SI_INFECTOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__PROGRESS = SI_INFECTOR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Disease Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__DISEASE_MODEL = SI_INFECTOR__DISEASE_MODEL;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__TARGET_URI = SI_INFECTOR__TARGET_URI;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__DISEASE_NAME = SI_INFECTOR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__TARGET_ISO_KEY = SI_INFECTOR__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Labels To Infect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__LABELS_TO_INFECT = SI_INFECTOR__LABELS_TO_INFECT;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__POPULATION_IDENTIFIER = SI_INFECTOR__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Infectious Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__INFECTIOUS_COUNT = SI_INFECTOR__INFECTIOUS_COUNT;

	/**
	 * The feature id for the '<em><b>Inoculated Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR__INOCULATED_PERCENTAGE = SI_INFECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SIR Inoculator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIR_INOCULATOR_FEATURE_COUNT = SI_INFECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSIDiseaseModelImpl <em>Stochastic Poisson SI Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSIDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticPoissonSIDiseaseModel()
	 * @generated
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL = 38;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__URI = SI__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__TYPE_URI = SI__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__DUBLIN_CORE = SI__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__LABELS_TO_UPDATE = SI__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__GRAPH = SI__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__ENABLED = SI__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__GRAPH_DECORATED = SI__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__PROGRESS = SI__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SI__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__POPULATION_IDENTIFIER = SI__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__TIME_PERIOD = SI__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__DISEASE_NAME = SI__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__RELATIVE_TOLERANCE = SI__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__FINITE_DIFFERENCE = SI__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__FREQUENCY_DEPENDENT = SI__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SI__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SI__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SI__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__TOTAL_AREA = SI__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SI__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__TRANSMISSION_RATE = SI__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SI__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__RECOVERY_RATE = SI__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SI__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SI__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SI__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY = SI__INFECTIOUS_MORTALITY;

	/**
	 * The number of structural features of the '<em>Stochastic Poisson SI Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SI_DISEASE_MODEL_FEATURE_COUNT = SI_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSIRDiseaseModelImpl <em>Stochastic Poisson SIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticPoissonSIRDiseaseModel()
	 * @generated
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL = 39;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__URI = SIR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__TYPE_URI = SIR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__DUBLIN_CORE = SIR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__LABELS_TO_UPDATE = SIR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__GRAPH = SIR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__ENABLED = SIR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__GRAPH_DECORATED = SIR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__PROGRESS = SIR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SIR__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__POPULATION_IDENTIFIER = SIR__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__TIME_PERIOD = SIR__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__DISEASE_NAME = SIR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__RELATIVE_TOLERANCE = SIR__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__FINITE_DIFFERENCE = SIR__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = SIR__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SIR__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SIR__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SIR__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__TOTAL_AREA = SIR__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SIR__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__TRANSMISSION_RATE = SIR__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SIR__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__RECOVERY_RATE = SIR__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SIR__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SIR__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SIR__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__INFECTIOUS_MORTALITY = SIR__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE = SIR__IMMUNITY_LOSS_RATE;

	/**
	 * The number of structural features of the '<em>Stochastic Poisson SIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SIR_DISEASE_MODEL_FEATURE_COUNT = SIR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSEIRDiseaseModelImpl <em>Stochastic Poisson SEIR Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSEIRDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticPoissonSEIRDiseaseModel()
	 * @generated
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL = 40;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__URI = SEIR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__TYPE_URI = SEIR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__DUBLIN_CORE = SEIR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__LABELS_TO_UPDATE = SEIR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__GRAPH = SEIR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__ENABLED = SEIR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__GRAPH_DECORATED = SEIR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__PROGRESS = SEIR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = SEIR__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__POPULATION_IDENTIFIER = SEIR__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__TIME_PERIOD = SEIR__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__DISEASE_NAME = SEIR__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__RELATIVE_TOLERANCE = SEIR__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__FINITE_DIFFERENCE = SEIR__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__FREQUENCY_DEPENDENT = SEIR__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = SEIR__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = SEIR__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = SEIR__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__TOTAL_AREA = SEIR__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = SEIR__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__TRANSMISSION_RATE = SEIR__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = SEIR__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__RECOVERY_RATE = SEIR__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = SEIR__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = SEIR__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION = SEIR__ROAD_NETWORK_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY = SEIR__INFECTIOUS_MORTALITY;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE = SEIR__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Incubation Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL__INCUBATION_RATE = SEIR__INCUBATION_RATE;

	/**
	 * The number of structural features of the '<em>Stochastic Poisson SEIR Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_POISSON_SEIR_DISEASE_MODEL_FEATURE_COUNT = SEIR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getURI()
	 * @generated
	 */
	int URI = 41;


	/**
	 * The meta object id for the '<em>EList</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.EList
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getEList()
	 * @generated
	 */
	int ELIST = 42;


	/**
	 * The meta object id for the '<em>Random</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Random
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getRandom()
	 * @generated
	 */
	int RANDOM = 43;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel <em>Deterministic SEIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deterministic SEIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel
	 * @generated
	 */
	EClass getDeterministicSEIRDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.DeterministicSIDiseaseModel <em>Deterministic SI Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deterministic SI Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DeterministicSIDiseaseModel
	 * @generated
	 */
	EClass getDeterministicSIDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.DeterministicSIRDiseaseModel <em>Deterministic SIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deterministic SIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DeterministicSIRDiseaseModel
	 * @generated
	 */
	EClass getDeterministicSIRDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel <em>Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel
	 * @generated
	 */
	EClass getDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getBackgroundMortalityRate <em>Background Mortality Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Background Mortality Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#getBackgroundMortalityRate()
	 * @see #getDiseaseModel()
	 * @generated
	 */
	EAttribute getDiseaseModel_BackgroundMortalityRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getPopulationIdentifier <em>Population Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population Identifier</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#getPopulationIdentifier()
	 * @see #getDiseaseModel()
	 * @generated
	 */
	EAttribute getDiseaseModel_PopulationIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getTimePeriod <em>Time Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Period</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#getTimePeriod()
	 * @see #getDiseaseModel()
	 * @generated
	 */
	EAttribute getDiseaseModel_TimePeriod();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getDiseaseName <em>Disease Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disease Name</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#getDiseaseName()
	 * @see #getDiseaseModel()
	 * @generated
	 */
	EAttribute getDiseaseModel_DiseaseName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getRelativeTolerance <em>Relative Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relative Tolerance</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#getRelativeTolerance()
	 * @see #getDiseaseModel()
	 * @generated
	 */
	EAttribute getDiseaseModel_RelativeTolerance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#isFiniteDifference <em>Finite Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Finite Difference</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#isFiniteDifference()
	 * @see #getDiseaseModel()
	 * @generated
	 */
	EAttribute getDiseaseModel_FiniteDifference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#isFrequencyDependent <em>Frequency Dependent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frequency Dependent</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#isFrequencyDependent()
	 * @see #getDiseaseModel()
	 * @generated
	 */
	EAttribute getDiseaseModel_FrequencyDependent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getBackgroundBirthRate <em>Background Birth Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Background Birth Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#getBackgroundBirthRate()
	 * @see #getDiseaseModel()
	 * @generated
	 */
	EAttribute getDiseaseModel_BackgroundBirthRate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel <em>Disease Model Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model Label</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel
	 * @generated
	 */
	EClass getDiseaseModelLabel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getPopulationLabel <em>Population Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Population Label</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getPopulationLabel()
	 * @see #getDiseaseModelLabel()
	 * @generated
	 */
	EReference getDiseaseModelLabel_PopulationLabel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getDiseaseModelState <em>Disease Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Disease Model State</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getDiseaseModelState()
	 * @see #getDiseaseModelLabel()
	 * @generated
	 */
	EReference getDiseaseModelLabel_DiseaseModelState();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getPopulationModelLabel <em>Population Model Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Population Model Label</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getPopulationModelLabel()
	 * @see #getDiseaseModelLabel()
	 * @generated
	 */
	EReference getDiseaseModelLabel_PopulationModelLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue <em>Disease Model Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model Label Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue
	 * @generated
	 */
	EClass getDiseaseModelLabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getDiseaseDeaths <em>Disease Deaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disease Deaths</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getDiseaseDeaths()
	 * @see #getDiseaseModelLabelValue()
	 * @generated
	 */
	EAttribute getDiseaseModelLabelValue_DiseaseDeaths();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getPopulationCount <em>Population Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population Count</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getPopulationCount()
	 * @see #getDiseaseModelLabelValue()
	 * @generated
	 */
	EAttribute getDiseaseModelLabelValue_PopulationCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getIncidence <em>Incidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incidence</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue#getIncidence()
	 * @see #getDiseaseModelLabelValue()
	 * @generated
	 */
	EAttribute getDiseaseModelLabelValue_Incidence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelState <em>Disease Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model State</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelState
	 * @generated
	 */
	EClass getDiseaseModelState();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelState#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Label</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelState#getLabel()
	 * @see #getDiseaseModelState()
	 * @generated
	 */
	EReference getDiseaseModelState_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.Infector <em>Infector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infector</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.Infector
	 * @generated
	 */
	EClass getInfector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.Infector#getDiseaseModel <em>Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.Infector#getDiseaseModel()
	 * @see #getInfector()
	 * @generated
	 */
	EReference getInfector_DiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.Infector#getTargetURI <em>Target URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target URI</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.Infector#getTargetURI()
	 * @see #getInfector()
	 * @generated
	 */
	EAttribute getInfector_TargetURI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.Infector#getDiseaseName <em>Disease Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disease Name</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.Infector#getDiseaseName()
	 * @see #getInfector()
	 * @generated
	 */
	EAttribute getInfector_DiseaseName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.Infector#getTargetISOKey <em>Target ISO Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target ISO Key</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.Infector#getTargetISOKey()
	 * @see #getInfector()
	 * @generated
	 */
	EAttribute getInfector_TargetISOKey();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.diseasemodels.standard.Infector#getLabelsToInfect <em>Labels To Infect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Labels To Infect</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.Infector#getLabelsToInfect()
	 * @see #getInfector()
	 * @generated
	 */
	EReference getInfector_LabelsToInfect();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.Infector#getPopulationIdentifier <em>Population Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population Identifier</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.Infector#getPopulationIdentifier()
	 * @see #getInfector()
	 * @generated
	 */
	EAttribute getInfector_PopulationIdentifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SEIR <em>SEIR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SEIR</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIR
	 * @generated
	 */
	EClass getSEIR();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SEIR#getIncubationRate <em>Incubation Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incubation Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIR#getIncubationRate()
	 * @see #getSEIR()
	 * @generated
	 */
	EAttribute getSEIR_IncubationRate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel <em>SEIR Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SEIR Label</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel
	 * @generated
	 */
	EClass getSEIRLabel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getDeltaValue <em>Delta Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delta Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getDeltaValue()
	 * @see #getSEIRLabel()
	 * @generated
	 */
	EReference getSEIRLabel_DeltaValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getProbeValue <em>Probe Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Probe Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getProbeValue()
	 * @see #getSEIRLabel()
	 * @generated
	 */
	EReference getSEIRLabel_ProbeValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getTempValue <em>Temp Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Temp Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getTempValue()
	 * @see #getSEIRLabel()
	 * @generated
	 */
	EReference getSEIRLabel_TempValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getOriginalValue()
	 * @see #getSEIRLabel()
	 * @generated
	 */
	EReference getSEIRLabel_OriginalValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getErrorScale <em>Error Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Scale</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getErrorScale()
	 * @see #getSEIRLabel()
	 * @generated
	 */
	EReference getSEIRLabel_ErrorScale();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabelValue <em>SEIR Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SEIR Label Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabelValue
	 * @generated
	 */
	EClass getSEIRLabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabelValue#getE <em>E</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>E</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabelValue#getE()
	 * @see #getSEIRLabelValue()
	 * @generated
	 */
	EAttribute getSEIRLabelValue_E();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SI <em>SI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SI</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SI
	 * @generated
	 */
	EClass getSI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SI#getTransmissionRate <em>Transmission Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transmission Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getTransmissionRate()
	 * @see #getSI()
	 * @generated
	 */
	EAttribute getSI_TransmissionRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SI#getNonLinearityCoefficient <em>Non Linearity Coefficient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Non Linearity Coefficient</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getNonLinearityCoefficient()
	 * @see #getSI()
	 * @generated
	 */
	EAttribute getSI_NonLinearityCoefficient();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SI#getRecoveryRate <em>Recovery Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recovery Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getRecoveryRate()
	 * @see #getSI()
	 * @generated
	 */
	EAttribute getSI_RecoveryRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SI#getInfectiousMortalityRate <em>Infectious Mortality Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infectious Mortality Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getInfectiousMortalityRate()
	 * @see #getSI()
	 * @generated
	 */
	EAttribute getSI_InfectiousMortalityRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SI#getPhysicallyAdjacentInfectiousProportion <em>Physically Adjacent Infectious Proportion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Physically Adjacent Infectious Proportion</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getPhysicallyAdjacentInfectiousProportion()
	 * @see #getSI()
	 * @generated
	 */
	EAttribute getSI_PhysicallyAdjacentInfectiousProportion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SI#getRoadNetworkInfectiousProportion <em>Road Network Infectious Proportion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Road Network Infectious Proportion</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getRoadNetworkInfectiousProportion()
	 * @see #getSI()
	 * @generated
	 */
	EAttribute getSI_RoadNetworkInfectiousProportion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SI#getInfectiousMortality <em>Infectious Mortality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infectious Mortality</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getInfectiousMortality()
	 * @see #getSI()
	 * @generated
	 */
	EAttribute getSI_InfectiousMortality();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SIDiseaseModelState <em>SI Disease Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SI Disease Model State</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIDiseaseModelState
	 * @generated
	 */
	EClass getSIDiseaseModelState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SIInfector <em>SI Infector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SI Infector</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIInfector
	 * @generated
	 */
	EClass getSIInfector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SIInfector#getInfectiousCount <em>Infectious Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infectious Count</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIInfector#getInfectiousCount()
	 * @see #getSIInfector()
	 * @generated
	 */
	EAttribute getSIInfector_InfectiousCount();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SILabel <em>SI Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SI Label</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel
	 * @generated
	 */
	EClass getSILabel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getDeltaValue <em>Delta Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delta Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getDeltaValue()
	 * @see #getSILabel()
	 * @generated
	 */
	EReference getSILabel_DeltaValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getProbeValue <em>Probe Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Probe Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getProbeValue()
	 * @see #getSILabel()
	 * @generated
	 */
	EReference getSILabel_ProbeValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getTempValue <em>Temp Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Temp Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getTempValue()
	 * @see #getSILabel()
	 * @generated
	 */
	EReference getSILabel_TempValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getOriginalValue()
	 * @see #getSILabel()
	 * @generated
	 */
	EReference getSILabel_OriginalValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getErrorScale <em>Error Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Scale</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getErrorScale()
	 * @see #getSILabel()
	 * @generated
	 */
	EReference getSILabel_ErrorScale();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SILabelValue <em>SI Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SI Label Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabelValue
	 * @generated
	 */
	EClass getSILabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SILabelValue#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>I</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabelValue#getI()
	 * @see #getSILabelValue()
	 * @generated
	 */
	EAttribute getSILabelValue_I();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SIR <em>SIR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIR</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIR
	 * @generated
	 */
	EClass getSIR();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SIR#getImmunityLossRate <em>Immunity Loss Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immunity Loss Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIR#getImmunityLossRate()
	 * @see #getSIR()
	 * @generated
	 */
	EAttribute getSIR_ImmunityLossRate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel <em>SIR Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIR Label</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel
	 * @generated
	 */
	EClass getSIRLabel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getDeltaValue <em>Delta Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delta Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getDeltaValue()
	 * @see #getSIRLabel()
	 * @generated
	 */
	EReference getSIRLabel_DeltaValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getProbeValue <em>Probe Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Probe Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getProbeValue()
	 * @see #getSIRLabel()
	 * @generated
	 */
	EReference getSIRLabel_ProbeValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getTempValue <em>Temp Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Temp Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getTempValue()
	 * @see #getSIRLabel()
	 * @generated
	 */
	EReference getSIRLabel_TempValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getOriginalValue()
	 * @see #getSIRLabel()
	 * @generated
	 */
	EReference getSIRLabel_OriginalValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getErrorScale <em>Error Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Scale</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getErrorScale()
	 * @see #getSIRLabel()
	 * @generated
	 */
	EReference getSIRLabel_ErrorScale();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SIRLabelValue <em>SIR Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIR Label Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabelValue
	 * @generated
	 */
	EClass getSIRLabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SIRLabelValue#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabelValue#getR()
	 * @see #getSIRLabelValue()
	 * @generated
	 */
	EAttribute getSIRLabelValue_R();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel <em>Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel
	 * @generated
	 */
	EClass getStandardDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getTotalPopulationCount <em>Total Population Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Population Count</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getTotalPopulationCount()
	 * @see #getStandardDiseaseModel()
	 * @generated
	 */
	EAttribute getStandardDiseaseModel_TotalPopulationCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getTotalPopulationCountReciprocal <em>Total Population Count Reciprocal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Population Count Reciprocal</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getTotalPopulationCountReciprocal()
	 * @see #getStandardDiseaseModel()
	 * @generated
	 */
	EAttribute getStandardDiseaseModel_TotalPopulationCountReciprocal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getTotalArea <em>Total Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Area</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getTotalArea()
	 * @see #getStandardDiseaseModel()
	 * @generated
	 */
	EAttribute getStandardDiseaseModel_TotalArea();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getReferencePopulationDensity <em>Reference Population Density</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Population Density</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getReferencePopulationDensity()
	 * @see #getStandardDiseaseModel()
	 * @generated
	 */
	EAttribute getStandardDiseaseModel_ReferencePopulationDensity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel <em>Disease Model Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model Label</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel
	 * @generated
	 */
	EClass getStandardDiseaseModelLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue <em>Disease Model Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model Label Value</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue
	 * @generated
	 */
	EClass getStandardDiseaseModelLabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue#getS <em>S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue#getS()
	 * @see #getStandardDiseaseModelLabelValue()
	 * @generated
	 */
	EAttribute getStandardDiseaseModelLabelValue_S();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState <em>Disease Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model State</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState
	 * @generated
	 */
	EClass getStandardDiseaseModelState();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState#getAreaRatio <em>Area Ratio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Area Ratio</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState#getAreaRatio()
	 * @see #getStandardDiseaseModelState()
	 * @generated
	 */
	EAttribute getStandardDiseaseModelState_AreaRatio();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StandardInfector <em>Infector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infector</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardInfector
	 * @generated
	 */
	EClass getStandardInfector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StochasticSEIRDiseaseModel <em>Stochastic SEIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic SEIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticSEIRDiseaseModel
	 * @generated
	 */
	EClass getStochasticSEIRDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StochasticSIDiseaseModel <em>Stochastic SI Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic SI Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticSIDiseaseModel
	 * @generated
	 */
	EClass getStochasticSIDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel <em>Stochastic SIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic SIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel
	 * @generated
	 */
	EClass getStochasticSIRDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.SanityChecker <em>Sanity Checker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sanity Checker</em>'.
	 * @see org.eclipse.stem.core.common.SanityChecker
	 * @model instanceClass="org.eclipse.stem.core.common.SanityChecker"
	 * @generated
	 */
	EClass getSanityChecker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.IntegrationLabel <em>Integration Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integration Label</em>'.
	 * @see org.eclipse.stem.core.graph.IntegrationLabel
	 * @model instanceClass="org.eclipse.stem.core.graph.IntegrationLabel"
	 * @generated
	 */
	EClass getIntegrationLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graph.IntegrationLabelValue <em>Integration Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integration Label Value</em>'.
	 * @see org.eclipse.stem.core.graph.IntegrationLabelValue
	 * @model instanceClass="org.eclipse.stem.core.graph.IntegrationLabelValue"
	 * @generated
	 */
	EClass getIntegrationLabelValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.model.IntegrationDecorator <em>Integration Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integration Decorator</em>'.
	 * @see org.eclipse.stem.core.model.IntegrationDecorator
	 * @model instanceClass="org.eclipse.stem.core.model.IntegrationDecorator"
	 * @generated
	 */
	EClass getIntegrationDecorator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel <em>Aggregating SI Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregating SI Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel
	 * @generated
	 */
	EClass getAggregatingSIDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.AggregatingDiseaseModelState <em>Aggregating Disease Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregating Disease Model State</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.AggregatingDiseaseModelState
	 * @generated
	 */
	EClass getAggregatingDiseaseModelState();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.diseasemodels.standard.AggregatingDiseaseModelState#getChildrensLabels <em>Childrens Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Childrens Labels</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.AggregatingDiseaseModelState#getChildrensLabels()
	 * @see #getAggregatingDiseaseModelState()
	 * @generated
	 */
	EReference getAggregatingDiseaseModelState_ChildrensLabels();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.AggregatingSEIRDiseaseModel <em>Aggregating SEIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregating SEIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.AggregatingSEIRDiseaseModel
	 * @generated
	 */
	EClass getAggregatingSEIRDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.AggregatingSIRDiseaseModel <em>Aggregating SIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregating SIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.AggregatingSIRDiseaseModel
	 * @generated
	 */
	EClass getAggregatingSIRDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel <em>Stochastic Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel
	 * @generated
	 */
	EClass getStochasticDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel#getSeed()
	 * @see #getStochasticDiseaseModel()
	 * @generated
	 */
	EAttribute getStochasticDiseaseModel_Seed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel#getRandomGenerator <em>Random Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Random Generator</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel#getRandomGenerator()
	 * @see #getStochasticDiseaseModel()
	 * @generated
	 */
	EAttribute getStochasticDiseaseModel_RandomGenerator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel <em>Stochastic Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel
	 * @generated
	 */
	EClass getStandardStochasticDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel#getGain <em>Gain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gain</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel#getGain()
	 * @see #getStandardStochasticDiseaseModel()
	 * @generated
	 */
	EAttribute getStandardStochasticDiseaseModel_Gain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.SIRInoculator <em>SIR Inoculator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIR Inoculator</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRInoculator
	 * @generated
	 */
	EClass getSIRInoculator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.standard.SIRInoculator#getInoculatedPercentage <em>Inoculated Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inoculated Percentage</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRInoculator#getInoculatedPercentage()
	 * @see #getSIRInoculator()
	 * @generated
	 */
	EAttribute getSIRInoculator_InoculatedPercentage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StochasticPoissonSIDiseaseModel <em>Stochastic Poisson SI Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic Poisson SI Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticPoissonSIDiseaseModel
	 * @generated
	 */
	EClass getStochasticPoissonSIDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StochasticPoissonSIRDiseaseModel <em>Stochastic Poisson SIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic Poisson SIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticPoissonSIRDiseaseModel
	 * @generated
	 */
	EClass getStochasticPoissonSIRDiseaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.standard.StochasticPoissonSEIRDiseaseModel <em>Stochastic Poisson SEIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic Poisson SEIR Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticPoissonSEIRDiseaseModel
	 * @generated
	 */
	EClass getStochasticPoissonSEIRDiseaseModel();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.EList <em>EList</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EList</em>'.
	 * @see org.eclipse.emf.common.util.EList
	 * @model instanceClass="org.eclipse.emf.common.util.EList"
	 * @generated
	 */
	EDataType getEList();

	/**
	 * Returns the meta object for data type '{@link java.util.Random <em>Random</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Random</em>'.
	 * @see java.util.Random
	 * @model instanceClass="java.util.Random"
	 * @generated
	 */
	EDataType getRandom();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StandardFactory getStandardFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DeterministicSEIRDiseaseModelImpl <em>Deterministic SEIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.DeterministicSEIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDeterministicSEIRDiseaseModel()
		 * @generated
		 */
		EClass DETERMINISTIC_SEIR_DISEASE_MODEL = eINSTANCE.getDeterministicSEIRDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIDiseaseModelImpl <em>Deterministic SI Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDeterministicSIDiseaseModel()
		 * @generated
		 */
		EClass DETERMINISTIC_SI_DISEASE_MODEL = eINSTANCE.getDeterministicSIDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIRDiseaseModelImpl <em>Deterministic SIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDeterministicSIRDiseaseModel()
		 * @generated
		 */
		EClass DETERMINISTIC_SIR_DISEASE_MODEL = eINSTANCE.getDeterministicSIRDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl <em>Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDiseaseModel()
		 * @generated
		 */
		EClass DISEASE_MODEL = eINSTANCE.getDiseaseModel();

		/**
		 * The meta object literal for the '<em><b>Background Mortality Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = eINSTANCE.getDiseaseModel_BackgroundMortalityRate();

		/**
		 * The meta object literal for the '<em><b>Population Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL__POPULATION_IDENTIFIER = eINSTANCE.getDiseaseModel_PopulationIdentifier();

		/**
		 * The meta object literal for the '<em><b>Time Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL__TIME_PERIOD = eINSTANCE.getDiseaseModel_TimePeriod();

		/**
		 * The meta object literal for the '<em><b>Disease Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL__DISEASE_NAME = eINSTANCE.getDiseaseModel_DiseaseName();

		/**
		 * The meta object literal for the '<em><b>Relative Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL__RELATIVE_TOLERANCE = eINSTANCE.getDiseaseModel_RelativeTolerance();

		/**
		 * The meta object literal for the '<em><b>Finite Difference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL__FINITE_DIFFERENCE = eINSTANCE.getDiseaseModel_FiniteDifference();

		/**
		 * The meta object literal for the '<em><b>Frequency Dependent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL__FREQUENCY_DEPENDENT = eINSTANCE.getDiseaseModel_FrequencyDependent();

		/**
		 * The meta object literal for the '<em><b>Background Birth Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL__BACKGROUND_BIRTH_RATE = eINSTANCE.getDiseaseModel_BackgroundBirthRate();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelImpl <em>Disease Model Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDiseaseModelLabel()
		 * @generated
		 */
		EClass DISEASE_MODEL_LABEL = eINSTANCE.getDiseaseModelLabel();

		/**
		 * The meta object literal for the '<em><b>Population Label</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISEASE_MODEL_LABEL__POPULATION_LABEL = eINSTANCE.getDiseaseModelLabel_PopulationLabel();

		/**
		 * The meta object literal for the '<em><b>Disease Model State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE = eINSTANCE.getDiseaseModelLabel_DiseaseModelState();

		/**
		 * The meta object literal for the '<em><b>Population Model Label</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL = eINSTANCE.getDiseaseModelLabel_PopulationModelLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl <em>Disease Model Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDiseaseModelLabelValue()
		 * @generated
		 */
		EClass DISEASE_MODEL_LABEL_VALUE = eINSTANCE.getDiseaseModelLabelValue();

		/**
		 * The meta object literal for the '<em><b>Disease Deaths</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS = eINSTANCE.getDiseaseModelLabelValue_DiseaseDeaths();

		/**
		 * The meta object literal for the '<em><b>Population Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL_LABEL_VALUE__POPULATION_COUNT = eINSTANCE.getDiseaseModelLabelValue_PopulationCount();

		/**
		 * The meta object literal for the '<em><b>Incidence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISEASE_MODEL_LABEL_VALUE__INCIDENCE = eINSTANCE.getDiseaseModelLabelValue_Incidence();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelStateImpl <em>Disease Model State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelStateImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getDiseaseModelState()
		 * @generated
		 */
		EClass DISEASE_MODEL_STATE = eINSTANCE.getDiseaseModelState();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISEASE_MODEL_STATE__LABEL = eINSTANCE.getDiseaseModelState_Label();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl <em>Infector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getInfector()
		 * @generated
		 */
		EClass INFECTOR = eINSTANCE.getInfector();

		/**
		 * The meta object literal for the '<em><b>Disease Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFECTOR__DISEASE_MODEL = eINSTANCE.getInfector_DiseaseModel();

		/**
		 * The meta object literal for the '<em><b>Target URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFECTOR__TARGET_URI = eINSTANCE.getInfector_TargetURI();

		/**
		 * The meta object literal for the '<em><b>Disease Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFECTOR__DISEASE_NAME = eINSTANCE.getInfector_DiseaseName();

		/**
		 * The meta object literal for the '<em><b>Target ISO Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFECTOR__TARGET_ISO_KEY = eINSTANCE.getInfector_TargetISOKey();

		/**
		 * The meta object literal for the '<em><b>Labels To Infect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFECTOR__LABELS_TO_INFECT = eINSTANCE.getInfector_LabelsToInfect();

		/**
		 * The meta object literal for the '<em><b>Population Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFECTOR__POPULATION_IDENTIFIER = eINSTANCE.getInfector_PopulationIdentifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRImpl <em>SEIR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SEIRImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSEIR()
		 * @generated
		 */
		EClass SEIR = eINSTANCE.getSEIR();

		/**
		 * The meta object literal for the '<em><b>Incubation Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEIR__INCUBATION_RATE = eINSTANCE.getSEIR_IncubationRate();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl <em>SEIR Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSEIRLabel()
		 * @generated
		 */
		EClass SEIR_LABEL = eINSTANCE.getSEIRLabel();

		/**
		 * The meta object literal for the '<em><b>Delta Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEIR_LABEL__DELTA_VALUE = eINSTANCE.getSEIRLabel_DeltaValue();

		/**
		 * The meta object literal for the '<em><b>Probe Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEIR_LABEL__PROBE_VALUE = eINSTANCE.getSEIRLabel_ProbeValue();

		/**
		 * The meta object literal for the '<em><b>Temp Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEIR_LABEL__TEMP_VALUE = eINSTANCE.getSEIRLabel_TempValue();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEIR_LABEL__ORIGINAL_VALUE = eINSTANCE.getSEIRLabel_OriginalValue();

		/**
		 * The meta object literal for the '<em><b>Error Scale</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEIR_LABEL__ERROR_SCALE = eINSTANCE.getSEIRLabel_ErrorScale();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl <em>SEIR Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSEIRLabelValue()
		 * @generated
		 */
		EClass SEIR_LABEL_VALUE = eINSTANCE.getSEIRLabelValue();

		/**
		 * The meta object literal for the '<em><b>E</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEIR_LABEL_VALUE__E = eINSTANCE.getSEIRLabelValue_E();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIImpl <em>SI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSI()
		 * @generated
		 */
		EClass SI = eINSTANCE.getSI();

		/**
		 * The meta object literal for the '<em><b>Transmission Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SI__TRANSMISSION_RATE = eINSTANCE.getSI_TransmissionRate();

		/**
		 * The meta object literal for the '<em><b>Non Linearity Coefficient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SI__NON_LINEARITY_COEFFICIENT = eINSTANCE.getSI_NonLinearityCoefficient();

		/**
		 * The meta object literal for the '<em><b>Recovery Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SI__RECOVERY_RATE = eINSTANCE.getSI_RecoveryRate();

		/**
		 * The meta object literal for the '<em><b>Infectious Mortality Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SI__INFECTIOUS_MORTALITY_RATE = eINSTANCE.getSI_InfectiousMortalityRate();

		/**
		 * The meta object literal for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SI__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = eINSTANCE.getSI_PhysicallyAdjacentInfectiousProportion();

		/**
		 * The meta object literal for the '<em><b>Road Network Infectious Proportion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SI__ROAD_NETWORK_INFECTIOUS_PROPORTION = eINSTANCE.getSI_RoadNetworkInfectiousProportion();

		/**
		 * The meta object literal for the '<em><b>Infectious Mortality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SI__INFECTIOUS_MORTALITY = eINSTANCE.getSI_InfectiousMortality();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIDiseaseModelStateImpl <em>SI Disease Model State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SIDiseaseModelStateImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIDiseaseModelState()
		 * @generated
		 */
		EClass SI_DISEASE_MODEL_STATE = eINSTANCE.getSIDiseaseModelState();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIInfectorImpl <em>SI Infector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SIInfectorImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIInfector()
		 * @generated
		 */
		EClass SI_INFECTOR = eINSTANCE.getSIInfector();

		/**
		 * The meta object literal for the '<em><b>Infectious Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SI_INFECTOR__INFECTIOUS_COUNT = eINSTANCE.getSIInfector_InfectiousCount();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl <em>SI Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSILabel()
		 * @generated
		 */
		EClass SI_LABEL = eINSTANCE.getSILabel();

		/**
		 * The meta object literal for the '<em><b>Delta Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SI_LABEL__DELTA_VALUE = eINSTANCE.getSILabel_DeltaValue();

		/**
		 * The meta object literal for the '<em><b>Probe Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SI_LABEL__PROBE_VALUE = eINSTANCE.getSILabel_ProbeValue();

		/**
		 * The meta object literal for the '<em><b>Temp Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SI_LABEL__TEMP_VALUE = eINSTANCE.getSILabel_TempValue();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SI_LABEL__ORIGINAL_VALUE = eINSTANCE.getSILabel_OriginalValue();

		/**
		 * The meta object literal for the '<em><b>Error Scale</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SI_LABEL__ERROR_SCALE = eINSTANCE.getSILabel_ErrorScale();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl <em>SI Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSILabelValue()
		 * @generated
		 */
		EClass SI_LABEL_VALUE = eINSTANCE.getSILabelValue();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SI_LABEL_VALUE__I = eINSTANCE.getSILabelValue_I();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIRImpl <em>SIR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SIRImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIR()
		 * @generated
		 */
		EClass SIR = eINSTANCE.getSIR();

		/**
		 * The meta object literal for the '<em><b>Immunity Loss Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIR__IMMUNITY_LOSS_RATE = eINSTANCE.getSIR_ImmunityLossRate();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl <em>SIR Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIRLabel()
		 * @generated
		 */
		EClass SIR_LABEL = eINSTANCE.getSIRLabel();

		/**
		 * The meta object literal for the '<em><b>Delta Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIR_LABEL__DELTA_VALUE = eINSTANCE.getSIRLabel_DeltaValue();

		/**
		 * The meta object literal for the '<em><b>Probe Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIR_LABEL__PROBE_VALUE = eINSTANCE.getSIRLabel_ProbeValue();

		/**
		 * The meta object literal for the '<em><b>Temp Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIR_LABEL__TEMP_VALUE = eINSTANCE.getSIRLabel_TempValue();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIR_LABEL__ORIGINAL_VALUE = eINSTANCE.getSIRLabel_OriginalValue();

		/**
		 * The meta object literal for the '<em><b>Error Scale</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIR_LABEL__ERROR_SCALE = eINSTANCE.getSIRLabel_ErrorScale();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl <em>SIR Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIRLabelValue()
		 * @generated
		 */
		EClass SIR_LABEL_VALUE = eINSTANCE.getSIRLabelValue();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIR_LABEL_VALUE__R = eINSTANCE.getSIRLabelValue_R();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl <em>Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardDiseaseModel()
		 * @generated
		 */
		EClass STANDARD_DISEASE_MODEL = eINSTANCE.getStandardDiseaseModel();

		/**
		 * The meta object literal for the '<em><b>Total Population Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT = eINSTANCE.getStandardDiseaseModel_TotalPopulationCount();

		/**
		 * The meta object literal for the '<em><b>Total Population Count Reciprocal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = eINSTANCE.getStandardDiseaseModel_TotalPopulationCountReciprocal();

		/**
		 * The meta object literal for the '<em><b>Total Area</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_DISEASE_MODEL__TOTAL_AREA = eINSTANCE.getStandardDiseaseModel_TotalArea();

		/**
		 * The meta object literal for the '<em><b>Reference Population Density</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = eINSTANCE.getStandardDiseaseModel_ReferencePopulationDensity();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelImpl <em>Disease Model Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardDiseaseModelLabel()
		 * @generated
		 */
		EClass STANDARD_DISEASE_MODEL_LABEL = eINSTANCE.getStandardDiseaseModelLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelValueImpl <em>Disease Model Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelValueImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardDiseaseModelLabelValue()
		 * @generated
		 */
		EClass STANDARD_DISEASE_MODEL_LABEL_VALUE = eINSTANCE.getStandardDiseaseModelLabelValue();

		/**
		 * The meta object literal for the '<em><b>S</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_DISEASE_MODEL_LABEL_VALUE__S = eINSTANCE.getStandardDiseaseModelLabelValue_S();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelStateImpl <em>Disease Model State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelStateImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardDiseaseModelState()
		 * @generated
		 */
		EClass STANDARD_DISEASE_MODEL_STATE = eINSTANCE.getStandardDiseaseModelState();

		/**
		 * The meta object literal for the '<em><b>Area Ratio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_DISEASE_MODEL_STATE__AREA_RATIO = eINSTANCE.getStandardDiseaseModelState_AreaRatio();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardInfectorImpl <em>Infector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardInfectorImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardInfector()
		 * @generated
		 */
		EClass STANDARD_INFECTOR = eINSTANCE.getStandardInfector();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticSEIRDiseaseModelImpl <em>Stochastic SEIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticSEIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticSEIRDiseaseModel()
		 * @generated
		 */
		EClass STOCHASTIC_SEIR_DISEASE_MODEL = eINSTANCE.getStochasticSEIRDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticSIDiseaseModelImpl <em>Stochastic SI Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticSIDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticSIDiseaseModel()
		 * @generated
		 */
		EClass STOCHASTIC_SI_DISEASE_MODEL = eINSTANCE.getStochasticSIDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticSIRDiseaseModelImpl <em>Stochastic SIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticSIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticSIRDiseaseModel()
		 * @generated
		 */
		EClass STOCHASTIC_SIR_DISEASE_MODEL = eINSTANCE.getStochasticSIRDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.SanityChecker <em>Sanity Checker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.SanityChecker
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSanityChecker()
		 * @generated
		 */
		EClass SANITY_CHECKER = eINSTANCE.getSanityChecker();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.IntegrationLabel <em>Integration Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.IntegrationLabel
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getIntegrationLabel()
		 * @generated
		 */
		EClass INTEGRATION_LABEL = eINSTANCE.getIntegrationLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.IntegrationLabelValue <em>Integration Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.IntegrationLabelValue
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getIntegrationLabelValue()
		 * @generated
		 */
		EClass INTEGRATION_LABEL_VALUE = eINSTANCE.getIntegrationLabelValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.IntegrationDecorator <em>Integration Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.IntegrationDecorator
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getIntegrationDecorator()
		 * @generated
		 */
		EClass INTEGRATION_DECORATOR = eINSTANCE.getIntegrationDecorator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.AggregatingSIDiseaseModelImpl <em>Aggregating SI Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.AggregatingSIDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getAggregatingSIDiseaseModel()
		 * @generated
		 */
		EClass AGGREGATING_SI_DISEASE_MODEL = eINSTANCE.getAggregatingSIDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.AggregatingDiseaseModelStateImpl <em>Aggregating Disease Model State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.AggregatingDiseaseModelStateImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getAggregatingDiseaseModelState()
		 * @generated
		 */
		EClass AGGREGATING_DISEASE_MODEL_STATE = eINSTANCE.getAggregatingDiseaseModelState();

		/**
		 * The meta object literal for the '<em><b>Childrens Labels</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATING_DISEASE_MODEL_STATE__CHILDRENS_LABELS = eINSTANCE.getAggregatingDiseaseModelState_ChildrensLabels();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.AggregatingSEIRDiseaseModelImpl <em>Aggregating SEIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.AggregatingSEIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getAggregatingSEIRDiseaseModel()
		 * @generated
		 */
		EClass AGGREGATING_SEIR_DISEASE_MODEL = eINSTANCE.getAggregatingSEIRDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.AggregatingSIRDiseaseModelImpl <em>Aggregating SIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.AggregatingSIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getAggregatingSIRDiseaseModel()
		 * @generated
		 */
		EClass AGGREGATING_SIR_DISEASE_MODEL = eINSTANCE.getAggregatingSIRDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl <em>Stochastic Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticDiseaseModel()
		 * @generated
		 */
		EClass STOCHASTIC_DISEASE_MODEL = eINSTANCE.getStochasticDiseaseModel();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCHASTIC_DISEASE_MODEL__SEED = eINSTANCE.getStochasticDiseaseModel_Seed();

		/**
		 * The meta object literal for the '<em><b>Random Generator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCHASTIC_DISEASE_MODEL__RANDOM_GENERATOR = eINSTANCE.getStochasticDiseaseModel_RandomGenerator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StandardStochasticDiseaseModelImpl <em>Stochastic Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardStochasticDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStandardStochasticDiseaseModel()
		 * @generated
		 */
		EClass STANDARD_STOCHASTIC_DISEASE_MODEL = eINSTANCE.getStandardStochasticDiseaseModel();

		/**
		 * The meta object literal for the '<em><b>Gain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_STOCHASTIC_DISEASE_MODEL__GAIN = eINSTANCE.getStandardStochasticDiseaseModel_Gain();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.SIRInoculatorImpl <em>SIR Inoculator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.SIRInoculatorImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getSIRInoculator()
		 * @generated
		 */
		EClass SIR_INOCULATOR = eINSTANCE.getSIRInoculator();

		/**
		 * The meta object literal for the '<em><b>Inoculated Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIR_INOCULATOR__INOCULATED_PERCENTAGE = eINSTANCE.getSIRInoculator_InoculatedPercentage();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSIDiseaseModelImpl <em>Stochastic Poisson SI Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSIDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticPoissonSIDiseaseModel()
		 * @generated
		 */
		EClass STOCHASTIC_POISSON_SI_DISEASE_MODEL = eINSTANCE.getStochasticPoissonSIDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSIRDiseaseModelImpl <em>Stochastic Poisson SIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticPoissonSIRDiseaseModel()
		 * @generated
		 */
		EClass STOCHASTIC_POISSON_SIR_DISEASE_MODEL = eINSTANCE.getStochasticPoissonSIRDiseaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSEIRDiseaseModelImpl <em>Stochastic Poisson SEIR Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StochasticPoissonSEIRDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getStochasticPoissonSEIRDiseaseModel()
		 * @generated
		 */
		EClass STOCHASTIC_POISSON_SEIR_DISEASE_MODEL = eINSTANCE.getStochasticPoissonSEIRDiseaseModel();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

		/**
		 * The meta object literal for the '<em>EList</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.EList
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getEList()
		 * @generated
		 */
		EDataType ELIST = eINSTANCE.getEList();

		/**
		 * The meta object literal for the '<em>Random</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Random
		 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardPackageImpl#getRandom()
		 * @generated
		 */
		EDataType RANDOM = eINSTANCE.getRandom();

	}

} //StandardPackage
