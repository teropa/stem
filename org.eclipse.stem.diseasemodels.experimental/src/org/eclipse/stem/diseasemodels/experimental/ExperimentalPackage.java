/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.experimental;

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
 * @see org.eclipse.stem.diseasemodels.experimental.ExperimentalFactory
 * @model kind="package"
 * @generated
 */
public interface ExperimentalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "experimental";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/diseasemodels/experimental.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.diseasemodels.experimental";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExperimentalPackage eINSTANCE = org.eclipse.stem.diseasemodels.experimental.impl.ExperimentalPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.experimental.impl.PercolationDiseaseModelImpl <em>Percolation Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.experimental.impl.PercolationDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.experimental.impl.ExperimentalPackageImpl#getPercolationDiseaseModel()
	 * @generated
	 */
	int PERCOLATION_DISEASE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__URI = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__TYPE_URI = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__DUBLIN_CORE = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__LABELS_TO_UPDATE = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__GRAPH = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__POPULATION_IDENTIFIER = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__TIME_PERIOD = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__DISEASE_NAME = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__TOTAL_POPULATION_COUNT = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__TOTAL_AREA = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__TOTAL_AREA;

	
	/**
	 * The feature id for the '<em><b>Transmission Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__TRANSMISSION_RATE = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__TRANSMISSION_RATE;

	/**
	 * The feature id for the '<em><b>Non Linearity Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__NON_LINEARITY_COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__RECOVERY_RATE = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__RECOVERY_RATE;

	/**
	 * The feature id for the '<em><b>Infectious Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION;

	/**
	 * The feature id for the '<em><b>Immunity Loss Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__IMMUNITY_LOSS_RATE = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__IMMUNITY_LOSS_RATE;

	/**
	 * The feature id for the '<em><b>Incubation Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__INCUBATION_RATE = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__INCUBATION_RATE;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__SEED = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__SEED;

	/**
	 * The feature id for the '<em><b>Random Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__RANDOM_GENERATOR = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__RANDOM_GENERATOR;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL__GAIN = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL__GAIN;

	/**
	 * The number of structural features of the '<em>Percolation Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCOLATION_DISEASE_MODEL_FEATURE_COUNT = StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.experimental.PercolationDiseaseModel <em>Percolation Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Percolation Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.experimental.PercolationDiseaseModel
	 * @generated
	 */
	EClass getPercolationDiseaseModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExperimentalFactory getExperimentalFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.experimental.impl.PercolationDiseaseModelImpl <em>Percolation Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.experimental.impl.PercolationDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.experimental.impl.ExperimentalPackageImpl#getPercolationDiseaseModel()
		 * @generated
		 */
		EClass PERCOLATION_DISEASE_MODEL = eINSTANCE.getPercolationDiseaseModel();

	}

} //ExperimentalPackage
