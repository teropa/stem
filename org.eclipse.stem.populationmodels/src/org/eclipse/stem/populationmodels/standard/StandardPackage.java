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


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.stem.populationmodels.standard.StandardFactory
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
	String eNS_URI = "http:///org/eclipse/stem/populationmodels/standard";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.populationmodels.standard";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StandardPackage eINSTANCE = org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelImpl <em>Population Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationModelImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationModel()
	 * @generated
	 */
	int POPULATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__URI = ModelPackage.NODE_DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__TYPE_URI = ModelPackage.NODE_DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__DUBLIN_CORE = ModelPackage.NODE_DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__LABELS_TO_UPDATE = ModelPackage.NODE_DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__GRAPH = ModelPackage.NODE_DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__ENABLED = ModelPackage.NODE_DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__GRAPH_DECORATED = ModelPackage.NODE_DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__PROGRESS = ModelPackage.NODE_DECORATOR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__POPULATION_IDENTIFIER = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__NAME = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL__TARGET_ISO_KEY = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Population Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_FEATURE_COUNT = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelImpl <em>Population Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStandardPopulationModel()
	 * @generated
	 */
	int STANDARD_POPULATION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__URI = POPULATION_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__TYPE_URI = POPULATION_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__DUBLIN_CORE = POPULATION_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__LABELS_TO_UPDATE = POPULATION_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__GRAPH = POPULATION_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__ENABLED = POPULATION_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__GRAPH_DECORATED = POPULATION_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__PROGRESS = POPULATION_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__POPULATION_IDENTIFIER = POPULATION_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__NAME = POPULATION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__TARGET_ISO_KEY = POPULATION_MODEL__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__BIRTH_RATE = POPULATION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Death Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__DEATH_RATE = POPULATION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL__TIME_PERIOD = POPULATION_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Population Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_FEATURE_COUNT = POPULATION_MODEL_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelImpl <em>Population Model Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationModelLabel()
	 * @generated
	 */
	int POPULATION_MODEL_LABEL = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__URI = GraphPackage.DYNAMIC_NODE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__TYPE_URI = GraphPackage.DYNAMIC_NODE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__DUBLIN_CORE = GraphPackage.DYNAMIC_NODE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.DYNAMIC_NODE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__CURRENT_VALUE = GraphPackage.DYNAMIC_NODE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__IDENTIFIABLE = GraphPackage.DYNAMIC_NODE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__NEXT_VALUE_VALID = GraphPackage.DYNAMIC_NODE_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__NEXT_VALUE = GraphPackage.DYNAMIC_NODE_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__DECORATOR = GraphPackage.DYNAMIC_NODE_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__NODE = GraphPackage.DYNAMIC_NODE_LABEL__NODE;

	/**
	 * The feature id for the '<em><b>Population Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__POPULATION_LABEL = GraphPackage.DYNAMIC_NODE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER = GraphPackage.DYNAMIC_NODE_LABEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Population Model Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL_FEATURE_COUNT = GraphPackage.DYNAMIC_NODE_LABEL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelImpl <em>Population Model Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStandardPopulationModelLabel()
	 * @generated
	 */
	int STANDARD_POPULATION_MODEL_LABEL = 3;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__URI = POPULATION_MODEL_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__TYPE_URI = POPULATION_MODEL_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__DUBLIN_CORE = POPULATION_MODEL_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = POPULATION_MODEL_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__CURRENT_VALUE = POPULATION_MODEL_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__IDENTIFIABLE = POPULATION_MODEL_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Next Value Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__NEXT_VALUE_VALID = POPULATION_MODEL_LABEL__NEXT_VALUE_VALID;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__NEXT_VALUE = POPULATION_MODEL_LABEL__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__DECORATOR = POPULATION_MODEL_LABEL__DECORATOR;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__NODE = POPULATION_MODEL_LABEL__NODE;

	/**
	 * The feature id for the '<em><b>Population Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__POPULATION_LABEL = POPULATION_MODEL_LABEL__POPULATION_LABEL;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER = POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Delta Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE = POPULATION_MODEL_LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Probe Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE = POPULATION_MODEL_LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Temp Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE = POPULATION_MODEL_LABEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE = POPULATION_MODEL_LABEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Scale</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE = POPULATION_MODEL_LABEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Population Model Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL_FEATURE_COUNT = POPULATION_MODEL_LABEL_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graph.IntegrationLabel <em>Integration Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graph.IntegrationLabel
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getIntegrationLabel()
	 * @generated
	 */
	int INTEGRATION_LABEL = 4;

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
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getIntegrationLabelValue()
	 * @generated
	 */
	int INTEGRATION_LABEL_VALUE = 5;

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
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getIntegrationDecorator()
	 * @generated
	 */
	int INTEGRATION_DECORATOR = 6;

	/**
	 * The number of structural features of the '<em>Integration Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRATION_DECORATOR_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelValueImpl <em>Population Model Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelValueImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationModelLabelValue()
	 * @generated
	 */
	int POPULATION_MODEL_LABEL_VALUE = 7;

	/**
	 * The number of structural features of the '<em>Population Model Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL_VALUE_FEATURE_COUNT = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelValueImpl <em>Population Model Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelValueImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStandardPopulationModelLabelValue()
	 * @generated
	 */
	int STANDARD_POPULATION_MODEL_LABEL_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL_VALUE__COUNT = POPULATION_MODEL_LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL_VALUE__INCIDENCE = POPULATION_MODEL_LABEL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Births</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL_VALUE__BIRTHS = POPULATION_MODEL_LABEL_VALUE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Deaths</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL_VALUE__DEATHS = POPULATION_MODEL_LABEL_VALUE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL_VALUE__DENSITY = POPULATION_MODEL_LABEL_VALUE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Population Model Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_MODEL_LABEL_VALUE_FEATURE_COUNT = POPULATION_MODEL_LABEL_VALUE_FEATURE_COUNT + 5;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.StochasticStandardPopulationModelImpl <em>Stochastic Standard Population Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.StochasticStandardPopulationModelImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStochasticStandardPopulationModel()
	 * @generated
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL = 9;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__URI = STANDARD_POPULATION_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__TYPE_URI = STANDARD_POPULATION_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__DUBLIN_CORE = STANDARD_POPULATION_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__LABELS_TO_UPDATE = STANDARD_POPULATION_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__GRAPH = STANDARD_POPULATION_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__ENABLED = STANDARD_POPULATION_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__GRAPH_DECORATED = STANDARD_POPULATION_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__PROGRESS = STANDARD_POPULATION_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__POPULATION_IDENTIFIER = STANDARD_POPULATION_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__NAME = STANDARD_POPULATION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__TARGET_ISO_KEY = STANDARD_POPULATION_MODEL__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__BIRTH_RATE = STANDARD_POPULATION_MODEL__BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Death Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__DEATH_RATE = STANDARD_POPULATION_MODEL__DEATH_RATE;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__TIME_PERIOD = STANDARD_POPULATION_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL__GAIN = STANDARD_POPULATION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stochastic Standard Population Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCHASTIC_STANDARD_POPULATION_MODEL_FEATURE_COUNT = STANDARD_POPULATION_MODEL_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.DemographicPopulationModelImpl <em>Demographic Population Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.DemographicPopulationModelImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getDemographicPopulationModel()
	 * @generated
	 */
	int DEMOGRAPHIC_POPULATION_MODEL = 10;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__URI = STANDARD_POPULATION_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__TYPE_URI = STANDARD_POPULATION_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__DUBLIN_CORE = STANDARD_POPULATION_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__LABELS_TO_UPDATE = STANDARD_POPULATION_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__GRAPH = STANDARD_POPULATION_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__ENABLED = STANDARD_POPULATION_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__GRAPH_DECORATED = STANDARD_POPULATION_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__PROGRESS = STANDARD_POPULATION_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__POPULATION_IDENTIFIER = STANDARD_POPULATION_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__NAME = STANDARD_POPULATION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__TARGET_ISO_KEY = STANDARD_POPULATION_MODEL__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__BIRTH_RATE = STANDARD_POPULATION_MODEL__BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Death Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__DEATH_RATE = STANDARD_POPULATION_MODEL__DEATH_RATE;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__TIME_PERIOD = STANDARD_POPULATION_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Population Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS = STANDARD_POPULATION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Demographic Population Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMOGRAPHIC_POPULATION_MODEL_FEATURE_COUNT = STANDARD_POPULATION_MODEL_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationGroupImpl <em>Population Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationGroupImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationGroup()
	 * @generated
	 */
	int POPULATION_GROUP = 11;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_GROUP__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Fraction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_GROUP__FRACTION = 1;

	/**
	 * The number of structural features of the '<em>Population Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_GROUP_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationInitializerImpl <em>Population Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationInitializerImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationInitializer()
	 * @generated
	 */
	int POPULATION_INITIALIZER = 12;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__URI = ModelPackage.NODE_DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__TYPE_URI = ModelPackage.NODE_DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__DUBLIN_CORE = ModelPackage.NODE_DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__LABELS_TO_UPDATE = ModelPackage.NODE_DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__GRAPH = ModelPackage.NODE_DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__ENABLED = ModelPackage.NODE_DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__GRAPH_DECORATED = ModelPackage.NODE_DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__PROGRESS = ModelPackage.NODE_DECORATOR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__TARGET_ISO_KEY = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER__POPULATION_IDENTIFIER = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Population Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_INITIALIZER_FEATURE_COUNT = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationInitializerImpl <em>Population Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPopulationInitializerImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStandardPopulationInitializer()
	 * @generated
	 */
	int STANDARD_POPULATION_INITIALIZER = 13;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__URI = POPULATION_INITIALIZER__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__TYPE_URI = POPULATION_INITIALIZER__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__DUBLIN_CORE = POPULATION_INITIALIZER__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__LABELS_TO_UPDATE = POPULATION_INITIALIZER__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__GRAPH = POPULATION_INITIALIZER__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__ENABLED = POPULATION_INITIALIZER__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__GRAPH_DECORATED = POPULATION_INITIALIZER__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__PROGRESS = POPULATION_INITIALIZER__PROGRESS;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__TARGET_ISO_KEY = POPULATION_INITIALIZER__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__POPULATION_IDENTIFIER = POPULATION_INITIALIZER__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Individuals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__INDIVIDUALS = POPULATION_INITIALIZER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Use Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER__USE_DENSITY = POPULATION_INITIALIZER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Population Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_POPULATION_INITIALIZER_FEATURE_COUNT = POPULATION_INITIALIZER_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.SeasonalPopulationModelImpl <em>Seasonal Population Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.SeasonalPopulationModelImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getSeasonalPopulationModel()
	 * @generated
	 */
	int SEASONAL_POPULATION_MODEL = 14;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__URI = STANDARD_POPULATION_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__TYPE_URI = STANDARD_POPULATION_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__DUBLIN_CORE = STANDARD_POPULATION_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__LABELS_TO_UPDATE = STANDARD_POPULATION_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__GRAPH = STANDARD_POPULATION_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__ENABLED = STANDARD_POPULATION_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__GRAPH_DECORATED = STANDARD_POPULATION_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__PROGRESS = STANDARD_POPULATION_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__POPULATION_IDENTIFIER = STANDARD_POPULATION_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__NAME = STANDARD_POPULATION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__TARGET_ISO_KEY = STANDARD_POPULATION_MODEL__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__BIRTH_RATE = STANDARD_POPULATION_MODEL__BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Death Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__DEATH_RATE = STANDARD_POPULATION_MODEL__DEATH_RATE;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__TIME_PERIOD = STANDARD_POPULATION_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__PHASE = STANDARD_POPULATION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modulation Amplitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE = STANDARD_POPULATION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__PERIOD = STANDARD_POPULATION_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Use Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL__USE_LATITUDE = STANDARD_POPULATION_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Seasonal Population Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASONAL_POPULATION_MODEL_FEATURE_COUNT = STANDARD_POPULATION_MODEL_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.EarthSciencePopulationInitializerImpl <em>Earth Science Population Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.EarthSciencePopulationInitializerImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getEarthSciencePopulationInitializer()
	 * @generated
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER = 15;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__URI = POPULATION_INITIALIZER__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__TYPE_URI = POPULATION_INITIALIZER__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__DUBLIN_CORE = POPULATION_INITIALIZER__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__LABELS_TO_UPDATE = POPULATION_INITIALIZER__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__GRAPH = POPULATION_INITIALIZER__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__ENABLED = POPULATION_INITIALIZER__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__GRAPH_DECORATED = POPULATION_INITIALIZER__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__PROGRESS = POPULATION_INITIALIZER__PROGRESS;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__TARGET_ISO_KEY = POPULATION_INITIALIZER__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER__POPULATION_IDENTIFIER = POPULATION_INITIALIZER__POPULATION_IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Earth Science Population Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EARTH_SCIENCE_POPULATION_INITIALIZER_FEATURE_COUNT = POPULATION_INITIALIZER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.YetiPopulationInitializerImpl <em>Yeti Population Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.YetiPopulationInitializerImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getYetiPopulationInitializer()
	 * @generated
	 */
	int YETI_POPULATION_INITIALIZER = 16;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__URI = EARTH_SCIENCE_POPULATION_INITIALIZER__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__TYPE_URI = EARTH_SCIENCE_POPULATION_INITIALIZER__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__DUBLIN_CORE = EARTH_SCIENCE_POPULATION_INITIALIZER__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__LABELS_TO_UPDATE = EARTH_SCIENCE_POPULATION_INITIALIZER__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__GRAPH = EARTH_SCIENCE_POPULATION_INITIALIZER__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__ENABLED = EARTH_SCIENCE_POPULATION_INITIALIZER__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__GRAPH_DECORATED = EARTH_SCIENCE_POPULATION_INITIALIZER__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__PROGRESS = EARTH_SCIENCE_POPULATION_INITIALIZER__PROGRESS;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__TARGET_ISO_KEY = EARTH_SCIENCE_POPULATION_INITIALIZER__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER__POPULATION_IDENTIFIER = EARTH_SCIENCE_POPULATION_INITIALIZER__POPULATION_IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Yeti Population Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YETI_POPULATION_INITIALIZER_FEATURE_COUNT = EARTH_SCIENCE_POPULATION_INITIALIZER_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.populationmodels.standard.impl.MosquitoPopulationModelImpl <em>Mosquito Population Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.populationmodels.standard.impl.MosquitoPopulationModelImpl
	 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getMosquitoPopulationModel()
	 * @generated
	 */
	int MOSQUITO_POPULATION_MODEL = 17;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__URI = POPULATION_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__TYPE_URI = POPULATION_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__DUBLIN_CORE = POPULATION_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__LABELS_TO_UPDATE = POPULATION_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__GRAPH = POPULATION_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__ENABLED = POPULATION_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__GRAPH_DECORATED = POPULATION_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__PROGRESS = POPULATION_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__POPULATION_IDENTIFIER = POPULATION_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__NAME = POPULATION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__TARGET_ISO_KEY = POPULATION_MODEL__TARGET_ISO_KEY;

	/**
	 * The feature id for the '<em><b>Scaling Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__SCALING_FACTOR = POPULATION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL__TIME_PERIOD = POPULATION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mosquito Population Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOSQUITO_POPULATION_MODEL_FEATURE_COUNT = POPULATION_MODEL_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.PopulationModel <em>Population Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Model</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationModel
	 * @generated
	 */
	EClass getPopulationModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.PopulationModel#getPopulationIdentifier <em>Population Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population Identifier</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationModel#getPopulationIdentifier()
	 * @see #getPopulationModel()
	 * @generated
	 */
	EAttribute getPopulationModel_PopulationIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.PopulationModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationModel#getName()
	 * @see #getPopulationModel()
	 * @generated
	 */
	EAttribute getPopulationModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.PopulationModel#getTargetISOKey <em>Target ISO Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target ISO Key</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationModel#getTargetISOKey()
	 * @see #getPopulationModel()
	 * @generated
	 */
	EAttribute getPopulationModel_TargetISOKey();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel <em>Population Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Model</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModel
	 * @generated
	 */
	EClass getStandardPopulationModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getBirthRate <em>Birth Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Birth Rate</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getBirthRate()
	 * @see #getStandardPopulationModel()
	 * @generated
	 */
	EAttribute getStandardPopulationModel_BirthRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getDeathRate <em>Death Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Death Rate</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getDeathRate()
	 * @see #getStandardPopulationModel()
	 * @generated
	 */
	EAttribute getStandardPopulationModel_DeathRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getTimePeriod <em>Time Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Period</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModel#getTimePeriod()
	 * @see #getStandardPopulationModel()
	 * @generated
	 */
	EAttribute getStandardPopulationModel_TimePeriod();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabel <em>Population Model Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Model Label</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationModelLabel
	 * @generated
	 */
	EClass getPopulationModelLabel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationLabel <em>Population Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Population Label</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationLabel()
	 * @see #getPopulationModelLabel()
	 * @generated
	 */
	EReference getPopulationModelLabel_PopulationLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationIdentifier <em>Population Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population Identifier</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationIdentifier()
	 * @see #getPopulationModelLabel()
	 * @generated
	 */
	EAttribute getPopulationModelLabel_PopulationIdentifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel <em>Population Model Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Model Label</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel
	 * @generated
	 */
	EClass getStandardPopulationModelLabel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getDeltaValue <em>Delta Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delta Value</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getDeltaValue()
	 * @see #getStandardPopulationModelLabel()
	 * @generated
	 */
	EReference getStandardPopulationModelLabel_DeltaValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getProbeValue <em>Probe Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Probe Value</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getProbeValue()
	 * @see #getStandardPopulationModelLabel()
	 * @generated
	 */
	EReference getStandardPopulationModelLabel_ProbeValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getTempValue <em>Temp Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Temp Value</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getTempValue()
	 * @see #getStandardPopulationModelLabel()
	 * @generated
	 */
	EReference getStandardPopulationModelLabel_TempValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Value</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getOriginalValue()
	 * @see #getStandardPopulationModelLabel()
	 * @generated
	 */
	EReference getStandardPopulationModelLabel_OriginalValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getErrorScale <em>Error Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Scale</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getErrorScale()
	 * @see #getStandardPopulationModelLabel()
	 * @generated
	 */
	EReference getStandardPopulationModelLabel_ErrorScale();

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
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabelValue <em>Population Model Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Model Label Value</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationModelLabelValue
	 * @generated
	 */
	EClass getPopulationModelLabelValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue <em>Population Model Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Model Label Value</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue
	 * @generated
	 */
	EClass getStandardPopulationModelLabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getCount()
	 * @see #getStandardPopulationModelLabelValue()
	 * @generated
	 */
	EAttribute getStandardPopulationModelLabelValue_Count();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getIncidence <em>Incidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incidence</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getIncidence()
	 * @see #getStandardPopulationModelLabelValue()
	 * @generated
	 */
	EAttribute getStandardPopulationModelLabelValue_Incidence();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getBirths <em>Births</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Births</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getBirths()
	 * @see #getStandardPopulationModelLabelValue()
	 * @generated
	 */
	EAttribute getStandardPopulationModelLabelValue_Births();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getDeaths <em>Deaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deaths</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getDeaths()
	 * @see #getStandardPopulationModelLabelValue()
	 * @generated
	 */
	EAttribute getStandardPopulationModelLabelValue_Deaths();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getDensity <em>Density</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Density</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue#getDensity()
	 * @see #getStandardPopulationModelLabelValue()
	 * @generated
	 */
	EAttribute getStandardPopulationModelLabelValue_Density();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel <em>Stochastic Standard Population Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stochastic Standard Population Model</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel
	 * @generated
	 */
	EClass getStochasticStandardPopulationModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel#getGain <em>Gain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gain</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel#getGain()
	 * @see #getStochasticStandardPopulationModel()
	 * @generated
	 */
	EAttribute getStochasticStandardPopulationModel_Gain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.DemographicPopulationModel <em>Demographic Population Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Demographic Population Model</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.DemographicPopulationModel
	 * @generated
	 */
	EClass getDemographicPopulationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.stem.populationmodels.standard.DemographicPopulationModel#getPopulationGroups <em>Population Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Population Groups</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.DemographicPopulationModel#getPopulationGroups()
	 * @see #getDemographicPopulationModel()
	 * @generated
	 */
	EReference getDemographicPopulationModel_PopulationGroups();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.PopulationGroup <em>Population Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Group</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationGroup
	 * @generated
	 */
	EClass getPopulationGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.PopulationGroup#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationGroup#getIdentifier()
	 * @see #getPopulationGroup()
	 * @generated
	 */
	EAttribute getPopulationGroup_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.PopulationGroup#getFraction <em>Fraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fraction</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationGroup#getFraction()
	 * @see #getPopulationGroup()
	 * @generated
	 */
	EAttribute getPopulationGroup_Fraction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.PopulationInitializer <em>Population Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Initializer</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationInitializer
	 * @generated
	 */
	EClass getPopulationInitializer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.PopulationInitializer#getTargetISOKey <em>Target ISO Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target ISO Key</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationInitializer#getTargetISOKey()
	 * @see #getPopulationInitializer()
	 * @generated
	 */
	EAttribute getPopulationInitializer_TargetISOKey();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.PopulationInitializer#getPopulationIdentifier <em>Population Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population Identifier</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.PopulationInitializer#getPopulationIdentifier()
	 * @see #getPopulationInitializer()
	 * @generated
	 */
	EAttribute getPopulationInitializer_PopulationIdentifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer <em>Population Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Initializer</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer
	 * @generated
	 */
	EClass getStandardPopulationInitializer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#getIndividuals <em>Individuals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Individuals</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#getIndividuals()
	 * @see #getStandardPopulationInitializer()
	 * @generated
	 */
	EAttribute getStandardPopulationInitializer_Individuals();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#isUseDensity <em>Use Density</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Density</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#isUseDensity()
	 * @see #getStandardPopulationInitializer()
	 * @generated
	 */
	EAttribute getStandardPopulationInitializer_UseDensity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel <em>Seasonal Population Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Seasonal Population Model</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel
	 * @generated
	 */
	EClass getSeasonalPopulationModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getPhase <em>Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getPhase()
	 * @see #getSeasonalPopulationModel()
	 * @generated
	 */
	EAttribute getSeasonalPopulationModel_Phase();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getModulationAmplitude <em>Modulation Amplitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modulation Amplitude</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getModulationAmplitude()
	 * @see #getSeasonalPopulationModel()
	 * @generated
	 */
	EAttribute getSeasonalPopulationModel_ModulationAmplitude();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#getPeriod()
	 * @see #getSeasonalPopulationModel()
	 * @generated
	 */
	EAttribute getSeasonalPopulationModel_Period();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#isUseLatitude <em>Use Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Latitude</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel#isUseLatitude()
	 * @see #getSeasonalPopulationModel()
	 * @generated
	 */
	EAttribute getSeasonalPopulationModel_UseLatitude();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.EarthSciencePopulationInitializer <em>Earth Science Population Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Earth Science Population Initializer</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.EarthSciencePopulationInitializer
	 * @generated
	 */
	EClass getEarthSciencePopulationInitializer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.YetiPopulationInitializer <em>Yeti Population Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Yeti Population Initializer</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.YetiPopulationInitializer
	 * @generated
	 */
	EClass getYetiPopulationInitializer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel <em>Mosquito Population Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mosquito Population Model</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel
	 * @generated
	 */
	EClass getMosquitoPopulationModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getScalingFactor <em>Scaling Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scaling Factor</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getScalingFactor()
	 * @see #getMosquitoPopulationModel()
	 * @generated
	 */
	EAttribute getMosquitoPopulationModel_ScalingFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getTimePeriod <em>Time Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Period</em>'.
	 * @see org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel#getTimePeriod()
	 * @see #getMosquitoPopulationModel()
	 * @generated
	 */
	EAttribute getMosquitoPopulationModel_TimePeriod();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelImpl <em>Population Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationModelImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationModel()
		 * @generated
		 */
		EClass POPULATION_MODEL = eINSTANCE.getPopulationModel();

		/**
		 * The meta object literal for the '<em><b>Population Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULATION_MODEL__POPULATION_IDENTIFIER = eINSTANCE.getPopulationModel_PopulationIdentifier();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULATION_MODEL__NAME = eINSTANCE.getPopulationModel_Name();

		/**
		 * The meta object literal for the '<em><b>Target ISO Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULATION_MODEL__TARGET_ISO_KEY = eINSTANCE.getPopulationModel_TargetISOKey();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelImpl <em>Population Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStandardPopulationModel()
		 * @generated
		 */
		EClass STANDARD_POPULATION_MODEL = eINSTANCE.getStandardPopulationModel();

		/**
		 * The meta object literal for the '<em><b>Birth Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_MODEL__BIRTH_RATE = eINSTANCE.getStandardPopulationModel_BirthRate();

		/**
		 * The meta object literal for the '<em><b>Death Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_MODEL__DEATH_RATE = eINSTANCE.getStandardPopulationModel_DeathRate();

		/**
		 * The meta object literal for the '<em><b>Time Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_MODEL__TIME_PERIOD = eINSTANCE.getStandardPopulationModel_TimePeriod();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelImpl <em>Population Model Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationModelLabel()
		 * @generated
		 */
		EClass POPULATION_MODEL_LABEL = eINSTANCE.getPopulationModelLabel();

		/**
		 * The meta object literal for the '<em><b>Population Label</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POPULATION_MODEL_LABEL__POPULATION_LABEL = eINSTANCE.getPopulationModelLabel_PopulationLabel();

		/**
		 * The meta object literal for the '<em><b>Population Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER = eINSTANCE.getPopulationModelLabel_PopulationIdentifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelImpl <em>Population Model Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStandardPopulationModelLabel()
		 * @generated
		 */
		EClass STANDARD_POPULATION_MODEL_LABEL = eINSTANCE.getStandardPopulationModelLabel();

		/**
		 * The meta object literal for the '<em><b>Delta Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE = eINSTANCE.getStandardPopulationModelLabel_DeltaValue();

		/**
		 * The meta object literal for the '<em><b>Probe Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE = eINSTANCE.getStandardPopulationModelLabel_ProbeValue();

		/**
		 * The meta object literal for the '<em><b>Temp Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE = eINSTANCE.getStandardPopulationModelLabel_TempValue();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE = eINSTANCE.getStandardPopulationModelLabel_OriginalValue();

		/**
		 * The meta object literal for the '<em><b>Error Scale</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE = eINSTANCE.getStandardPopulationModelLabel_ErrorScale();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.IntegrationLabel <em>Integration Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.IntegrationLabel
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getIntegrationLabel()
		 * @generated
		 */
		EClass INTEGRATION_LABEL = eINSTANCE.getIntegrationLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graph.IntegrationLabelValue <em>Integration Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graph.IntegrationLabelValue
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getIntegrationLabelValue()
		 * @generated
		 */
		EClass INTEGRATION_LABEL_VALUE = eINSTANCE.getIntegrationLabelValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.model.IntegrationDecorator <em>Integration Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.model.IntegrationDecorator
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getIntegrationDecorator()
		 * @generated
		 */
		EClass INTEGRATION_DECORATOR = eINSTANCE.getIntegrationDecorator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelValueImpl <em>Population Model Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelValueImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationModelLabelValue()
		 * @generated
		 */
		EClass POPULATION_MODEL_LABEL_VALUE = eINSTANCE.getPopulationModelLabelValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelValueImpl <em>Population Model Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelValueImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStandardPopulationModelLabelValue()
		 * @generated
		 */
		EClass STANDARD_POPULATION_MODEL_LABEL_VALUE = eINSTANCE.getStandardPopulationModelLabelValue();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_MODEL_LABEL_VALUE__COUNT = eINSTANCE.getStandardPopulationModelLabelValue_Count();

		/**
		 * The meta object literal for the '<em><b>Incidence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_MODEL_LABEL_VALUE__INCIDENCE = eINSTANCE.getStandardPopulationModelLabelValue_Incidence();

		/**
		 * The meta object literal for the '<em><b>Births</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_MODEL_LABEL_VALUE__BIRTHS = eINSTANCE.getStandardPopulationModelLabelValue_Births();

		/**
		 * The meta object literal for the '<em><b>Deaths</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_MODEL_LABEL_VALUE__DEATHS = eINSTANCE.getStandardPopulationModelLabelValue_Deaths();

		/**
		 * The meta object literal for the '<em><b>Density</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_MODEL_LABEL_VALUE__DENSITY = eINSTANCE.getStandardPopulationModelLabelValue_Density();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.StochasticStandardPopulationModelImpl <em>Stochastic Standard Population Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.StochasticStandardPopulationModelImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStochasticStandardPopulationModel()
		 * @generated
		 */
		EClass STOCHASTIC_STANDARD_POPULATION_MODEL = eINSTANCE.getStochasticStandardPopulationModel();

		/**
		 * The meta object literal for the '<em><b>Gain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCHASTIC_STANDARD_POPULATION_MODEL__GAIN = eINSTANCE.getStochasticStandardPopulationModel_Gain();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.DemographicPopulationModelImpl <em>Demographic Population Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.DemographicPopulationModelImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getDemographicPopulationModel()
		 * @generated
		 */
		EClass DEMOGRAPHIC_POPULATION_MODEL = eINSTANCE.getDemographicPopulationModel();

		/**
		 * The meta object literal for the '<em><b>Population Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS = eINSTANCE.getDemographicPopulationModel_PopulationGroups();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationGroupImpl <em>Population Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationGroupImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationGroup()
		 * @generated
		 */
		EClass POPULATION_GROUP = eINSTANCE.getPopulationGroup();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULATION_GROUP__IDENTIFIER = eINSTANCE.getPopulationGroup_Identifier();

		/**
		 * The meta object literal for the '<em><b>Fraction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULATION_GROUP__FRACTION = eINSTANCE.getPopulationGroup_Fraction();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.PopulationInitializerImpl <em>Population Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.PopulationInitializerImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getPopulationInitializer()
		 * @generated
		 */
		EClass POPULATION_INITIALIZER = eINSTANCE.getPopulationInitializer();

		/**
		 * The meta object literal for the '<em><b>Target ISO Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULATION_INITIALIZER__TARGET_ISO_KEY = eINSTANCE.getPopulationInitializer_TargetISOKey();

		/**
		 * The meta object literal for the '<em><b>Population Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULATION_INITIALIZER__POPULATION_IDENTIFIER = eINSTANCE.getPopulationInitializer_PopulationIdentifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationInitializerImpl <em>Population Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPopulationInitializerImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getStandardPopulationInitializer()
		 * @generated
		 */
		EClass STANDARD_POPULATION_INITIALIZER = eINSTANCE.getStandardPopulationInitializer();

		/**
		 * The meta object literal for the '<em><b>Individuals</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_INITIALIZER__INDIVIDUALS = eINSTANCE.getStandardPopulationInitializer_Individuals();

		/**
		 * The meta object literal for the '<em><b>Use Density</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_POPULATION_INITIALIZER__USE_DENSITY = eINSTANCE.getStandardPopulationInitializer_UseDensity();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.SeasonalPopulationModelImpl <em>Seasonal Population Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.SeasonalPopulationModelImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getSeasonalPopulationModel()
		 * @generated
		 */
		EClass SEASONAL_POPULATION_MODEL = eINSTANCE.getSeasonalPopulationModel();

		/**
		 * The meta object literal for the '<em><b>Phase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASONAL_POPULATION_MODEL__PHASE = eINSTANCE.getSeasonalPopulationModel_Phase();

		/**
		 * The meta object literal for the '<em><b>Modulation Amplitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE = eINSTANCE.getSeasonalPopulationModel_ModulationAmplitude();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASONAL_POPULATION_MODEL__PERIOD = eINSTANCE.getSeasonalPopulationModel_Period();

		/**
		 * The meta object literal for the '<em><b>Use Latitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASONAL_POPULATION_MODEL__USE_LATITUDE = eINSTANCE.getSeasonalPopulationModel_UseLatitude();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.EarthSciencePopulationInitializerImpl <em>Earth Science Population Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.EarthSciencePopulationInitializerImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getEarthSciencePopulationInitializer()
		 * @generated
		 */
		EClass EARTH_SCIENCE_POPULATION_INITIALIZER = eINSTANCE.getEarthSciencePopulationInitializer();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.YetiPopulationInitializerImpl <em>Yeti Population Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.YetiPopulationInitializerImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getYetiPopulationInitializer()
		 * @generated
		 */
		EClass YETI_POPULATION_INITIALIZER = eINSTANCE.getYetiPopulationInitializer();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.populationmodels.standard.impl.MosquitoPopulationModelImpl <em>Mosquito Population Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.populationmodels.standard.impl.MosquitoPopulationModelImpl
		 * @see org.eclipse.stem.populationmodels.standard.impl.StandardPackageImpl#getMosquitoPopulationModel()
		 * @generated
		 */
		EClass MOSQUITO_POPULATION_MODEL = eINSTANCE.getMosquitoPopulationModel();

		/**
		 * The meta object literal for the '<em><b>Scaling Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOSQUITO_POPULATION_MODEL__SCALING_FACTOR = eINSTANCE.getMosquitoPopulationModel_ScalingFactor();

		/**
		 * The meta object literal for the '<em><b>Time Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOSQUITO_POPULATION_MODEL__TIME_PERIOD = eINSTANCE.getMosquitoPopulationModel_TimePeriod();

	}

} //StandardPackage
