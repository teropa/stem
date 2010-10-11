/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.vector;

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
 * @see org.eclipse.stem.diseasemodels.vector.VectorFactory
 * @model kind="package"
 * @generated
 */
public interface VectorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vector";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/diseasemodels/vector.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.diseasemodels.vector";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VectorPackage eINSTANCE = org.eclipse.stem.diseasemodels.vector.impl.VectorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.vector.impl.VectorDiseaseModelImpl <em>Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.vector.impl.VectorDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.vector.impl.VectorPackageImpl#getVectorDiseaseModel()
	 * @generated
	 */
	int VECTOR_DISEASE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__URI = StandardPackage.STANDARD_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__TYPE_URI = StandardPackage.STANDARD_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__DUBLIN_CORE = StandardPackage.STANDARD_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__LABELS_TO_UPDATE = StandardPackage.STANDARD_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__GRAPH = StandardPackage.STANDARD_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__ENABLED = StandardPackage.STANDARD_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__GRAPH_DECORATED = StandardPackage.STANDARD_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__PROGRESS = StandardPackage.STANDARD_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = StandardPackage.STANDARD_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__POPULATION_IDENTIFIER = StandardPackage.STANDARD_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__TIME_PERIOD = StandardPackage.STANDARD_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__DISEASE_NAME = StandardPackage.STANDARD_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__RELATIVE_TOLERANCE = StandardPackage.STANDARD_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__FINITE_DIFFERENCE = StandardPackage.STANDARD_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__FREQUENCY_DEPENDENT = StandardPackage.STANDARD_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = StandardPackage.STANDARD_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__TOTAL_POPULATION_COUNT = StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__TOTAL_AREA = StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Vector Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_DISEASE_MODEL_FEATURE_COUNT = StandardPackage.STANDARD_DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.vector.impl.MacdonaldRossDiseaseModelImpl <em>Macdonald Ross Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.vector.impl.MacdonaldRossDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.vector.impl.VectorPackageImpl#getMacdonaldRossDiseaseModel()
	 * @generated
	 */
	int MACDONALD_ROSS_DISEASE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__URI = VECTOR_DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__TYPE_URI = VECTOR_DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__DUBLIN_CORE = VECTOR_DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__LABELS_TO_UPDATE = VECTOR_DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__GRAPH = VECTOR_DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__ENABLED = VECTOR_DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__GRAPH_DECORATED = VECTOR_DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__PROGRESS = VECTOR_DISEASE_MODEL__PROGRESS;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = VECTOR_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__POPULATION_IDENTIFIER = VECTOR_DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__TIME_PERIOD = VECTOR_DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__DISEASE_NAME = VECTOR_DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__RELATIVE_TOLERANCE = VECTOR_DISEASE_MODEL__RELATIVE_TOLERANCE;

	/**
	 * The feature id for the '<em><b>Finite Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__FINITE_DIFFERENCE = VECTOR_DISEASE_MODEL__FINITE_DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Frequency Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__FREQUENCY_DEPENDENT = VECTOR_DISEASE_MODEL__FREQUENCY_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Background Birth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__BACKGROUND_BIRTH_RATE = VECTOR_DISEASE_MODEL__BACKGROUND_BIRTH_RATE;

	/**
	 * The feature id for the '<em><b>Total Population Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__TOTAL_POPULATION_COUNT = VECTOR_DISEASE_MODEL__TOTAL_POPULATION_COUNT;

	/**
	 * The feature id for the '<em><b>Total Population Count Reciprocal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL = VECTOR_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL;

	/**
	 * The feature id for the '<em><b>Total Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__TOTAL_AREA = VECTOR_DISEASE_MODEL__TOTAL_AREA;

	/**
	 * The feature id for the '<em><b>Reference Population Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY = VECTOR_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY;

	/**
	 * The feature id for the '<em><b>Vector Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER = VECTOR_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Biting Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__BITING_RATE = VECTOR_DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Infectious Biting Proportion Human</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_HUMAN = VECTOR_DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Infectious Biting Proportion Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_VECTOR = VECTOR_DISEASE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Recovery Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__RECOVERY_RATE = VECTOR_DISEASE_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Vector Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL__VECTOR_MORTALITY_RATE = VECTOR_DISEASE_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Macdonald Ross Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACDONALD_ROSS_DISEASE_MODEL_FEATURE_COUNT = VECTOR_DISEASE_MODEL_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel <em>Macdonald Ross Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Macdonald Ross Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel
	 * @generated
	 */
	EClass getMacdonaldRossDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getBitingRate <em>Biting Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Biting Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getBitingRate()
	 * @see #getMacdonaldRossDiseaseModel()
	 * @generated
	 */
	EAttribute getMacdonaldRossDiseaseModel_BitingRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getInfectiousBitingProportionHuman <em>Infectious Biting Proportion Human</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infectious Biting Proportion Human</em>'.
	 * @see org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getInfectiousBitingProportionHuman()
	 * @see #getMacdonaldRossDiseaseModel()
	 * @generated
	 */
	EAttribute getMacdonaldRossDiseaseModel_InfectiousBitingProportionHuman();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getInfectiousBitingProportionVector <em>Infectious Biting Proportion Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infectious Biting Proportion Vector</em>'.
	 * @see org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getInfectiousBitingProportionVector()
	 * @see #getMacdonaldRossDiseaseModel()
	 * @generated
	 */
	EAttribute getMacdonaldRossDiseaseModel_InfectiousBitingProportionVector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getRecoveryRate <em>Recovery Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recovery Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getRecoveryRate()
	 * @see #getMacdonaldRossDiseaseModel()
	 * @generated
	 */
	EAttribute getMacdonaldRossDiseaseModel_RecoveryRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getVectorMortalityRate <em>Vector Mortality Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vector Mortality Rate</em>'.
	 * @see org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getVectorMortalityRate()
	 * @see #getMacdonaldRossDiseaseModel()
	 * @generated
	 */
	EAttribute getMacdonaldRossDiseaseModel_VectorMortalityRate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.vector.VectorDiseaseModel <em>Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.vector.VectorDiseaseModel
	 * @generated
	 */
	EClass getVectorDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.vector.VectorDiseaseModel#getVectorPopulationIdentifier <em>Vector Population Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vector Population Identifier</em>'.
	 * @see org.eclipse.stem.diseasemodels.vector.VectorDiseaseModel#getVectorPopulationIdentifier()
	 * @see #getVectorDiseaseModel()
	 * @generated
	 */
	EAttribute getVectorDiseaseModel_VectorPopulationIdentifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VectorFactory getVectorFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.vector.impl.MacdonaldRossDiseaseModelImpl <em>Macdonald Ross Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.vector.impl.MacdonaldRossDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.vector.impl.VectorPackageImpl#getMacdonaldRossDiseaseModel()
		 * @generated
		 */
		EClass MACDONALD_ROSS_DISEASE_MODEL = eINSTANCE.getMacdonaldRossDiseaseModel();
		/**
		 * The meta object literal for the '<em><b>Biting Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACDONALD_ROSS_DISEASE_MODEL__BITING_RATE = eINSTANCE.getMacdonaldRossDiseaseModel_BitingRate();
		/**
		 * The meta object literal for the '<em><b>Infectious Biting Proportion Human</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_HUMAN = eINSTANCE.getMacdonaldRossDiseaseModel_InfectiousBitingProportionHuman();
		/**
		 * The meta object literal for the '<em><b>Infectious Biting Proportion Vector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_VECTOR = eINSTANCE.getMacdonaldRossDiseaseModel_InfectiousBitingProportionVector();
		/**
		 * The meta object literal for the '<em><b>Recovery Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACDONALD_ROSS_DISEASE_MODEL__RECOVERY_RATE = eINSTANCE.getMacdonaldRossDiseaseModel_RecoveryRate();
		/**
		 * The meta object literal for the '<em><b>Vector Mortality Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACDONALD_ROSS_DISEASE_MODEL__VECTOR_MORTALITY_RATE = eINSTANCE.getMacdonaldRossDiseaseModel_VectorMortalityRate();
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.vector.impl.VectorDiseaseModelImpl <em>Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.vector.impl.VectorDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.vector.impl.VectorPackageImpl#getVectorDiseaseModel()
		 * @generated
		 */
		EClass VECTOR_DISEASE_MODEL = eINSTANCE.getVectorDiseaseModel();
		/**
		 * The meta object literal for the '<em><b>Vector Population Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VECTOR_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER = eINSTANCE.getVectorDiseaseModel_VectorPopulationIdentifier();

	}

} //VectorPackage
