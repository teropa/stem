/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard;

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
	 * The number of structural features of the '<em>Population Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_FEATURE_COUNT = ModelPackage.NODE_DECORATOR_FEATURE_COUNT + 2;

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
	 * The number of structural features of the '<em>Population Model Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_MODEL_LABEL_FEATURE_COUNT = GraphPackage.DYNAMIC_NODE_LABEL_FEATURE_COUNT + 1;

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

	}

} //StandardPackage
