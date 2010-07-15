package org.eclipse.stem.graphgenerators;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.stem.core.common.CommonPackage;

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
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsFactory
 * @model kind="package"
 * @generated
 */
public interface GraphgeneratorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphgenerators";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/graphgenerators/graphgenerators.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.graphgenerators";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphgeneratorsPackage eINSTANCE = org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.graphgenerators.impl.GraphGeneratorImpl <em>Graph Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.graphgenerators.impl.GraphGeneratorImpl
	 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getGraphGenerator()
	 * @generated
	 */
	int GRAPH_GENERATOR = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_GENERATOR__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_GENERATOR__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_GENERATOR__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The number of structural features of the '<em>Graph Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_GENERATOR_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl <em>Lattice Graph Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl
	 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getLatticeGraphGenerator()
	 * @generated
	 */
	int LATTICE_GRAPH_GENERATOR = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__URI = GRAPH_GENERATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__TYPE_URI = GRAPH_GENERATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__DUBLIN_CORE = GRAPH_GENERATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Use Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS = GRAPH_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Use Next Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS = GRAPH_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Periodic Boundaries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES = GRAPH_GENERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Lattice Graph Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR_FEATURE_COUNT = GRAPH_GENERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.graphgenerators.impl.SquareLatticeGraphGeneratorImpl <em>Square Lattice Graph Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.graphgenerators.impl.SquareLatticeGraphGeneratorImpl
	 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getSquareLatticeGraphGenerator()
	 * @generated
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR__URI = LATTICE_GRAPH_GENERATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR__TYPE_URI = LATTICE_GRAPH_GENERATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR__DUBLIN_CORE = LATTICE_GRAPH_GENERATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Use Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS = LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS;

	/**
	 * The feature id for the '<em><b>Use Next Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS = LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS;

	/**
	 * The feature id for the '<em><b>Periodic Boundaries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES = LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES;

	/**
	 * The feature id for the '<em><b>XSize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE = LATTICE_GRAPH_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>YSize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE = LATTICE_GRAPH_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR__AREA = LATTICE_GRAPH_GENERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Square Lattice Graph Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_LATTICE_GRAPH_GENERATOR_FEATURE_COUNT = LATTICE_GRAPH_GENERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.graphgenerators.impl.MigrationEdgeGraphGeneratorImpl <em>Migration Edge Graph Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.graphgenerators.impl.MigrationEdgeGraphGeneratorImpl
	 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getMigrationEdgeGraphGenerator()
	 * @generated
	 */
	int MIGRATION_EDGE_GRAPH_GENERATOR = 3;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_GRAPH_GENERATOR__URI = GRAPH_GENERATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_GRAPH_GENERATOR__TYPE_URI = GRAPH_GENERATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_GRAPH_GENERATOR__DUBLIN_CORE = GRAPH_GENERATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_GRAPH_GENERATOR__LOCATION = GRAPH_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Migration Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_GRAPH_GENERATOR__MIGRATION_RATE = GRAPH_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Population</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION = GRAPH_GENERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Migration Edge Graph Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_GRAPH_GENERATOR_FEATURE_COUNT = GRAPH_GENERATOR_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.graphgenerators.impl.PlateCarreeGlobeGraphGeneratorImpl <em>Plate Carree Globe Graph Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.graphgenerators.impl.PlateCarreeGlobeGraphGeneratorImpl
	 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getPlateCarreeGlobeGraphGenerator()
	 * @generated
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR = 4;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR__URI = LATTICE_GRAPH_GENERATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR__TYPE_URI = LATTICE_GRAPH_GENERATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR__DUBLIN_CORE = LATTICE_GRAPH_GENERATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Use Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS = LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS;

	/**
	 * The feature id for the '<em><b>Use Next Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS = LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS;

	/**
	 * The feature id for the '<em><b>Periodic Boundaries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES = LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES;

	/**
	 * The feature id for the '<em><b>Angular Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR__ANGULAR_STEP = LATTICE_GRAPH_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR__RADIUS = LATTICE_GRAPH_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Plate Carree Globe Graph Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATE_CARREE_GLOBE_GRAPH_GENERATOR_FEATURE_COUNT = LATTICE_GRAPH_GENERATOR_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.graphgenerators.GraphGenerator <em>Graph Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Generator</em>'.
	 * @see org.eclipse.stem.graphgenerators.GraphGenerator
	 * @generated
	 */
	EClass getGraphGenerator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator <em>Lattice Graph Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lattice Graph Generator</em>'.
	 * @see org.eclipse.stem.graphgenerators.LatticeGraphGenerator
	 * @generated
	 */
	EClass getLatticeGraphGenerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isUseNearestNeighbors <em>Use Nearest Neighbors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Nearest Neighbors</em>'.
	 * @see org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isUseNearestNeighbors()
	 * @see #getLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getLatticeGraphGenerator_UseNearestNeighbors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isUseNextNearestNeighbors <em>Use Next Nearest Neighbors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Next Nearest Neighbors</em>'.
	 * @see org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isUseNextNearestNeighbors()
	 * @see #getLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getLatticeGraphGenerator_UseNextNearestNeighbors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isPeriodicBoundaries <em>Periodic Boundaries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Periodic Boundaries</em>'.
	 * @see org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isPeriodicBoundaries()
	 * @see #getLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getLatticeGraphGenerator_PeriodicBoundaries();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator <em>Square Lattice Graph Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Square Lattice Graph Generator</em>'.
	 * @see org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator
	 * @generated
	 */
	EClass getSquareLatticeGraphGenerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getXSize <em>XSize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XSize</em>'.
	 * @see org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getXSize()
	 * @see #getSquareLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getSquareLatticeGraphGenerator_XSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getYSize <em>YSize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YSize</em>'.
	 * @see org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getYSize()
	 * @see #getSquareLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getSquareLatticeGraphGenerator_YSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Area</em>'.
	 * @see org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getArea()
	 * @see #getSquareLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getSquareLatticeGraphGenerator_Area();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator <em>Migration Edge Graph Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Migration Edge Graph Generator</em>'.
	 * @see org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator
	 * @generated
	 */
	EClass getMigrationEdgeGraphGenerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getLocation()
	 * @see #getMigrationEdgeGraphGenerator()
	 * @generated
	 */
	EAttribute getMigrationEdgeGraphGenerator_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getMigrationRate <em>Migration Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Migration Rate</em>'.
	 * @see org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getMigrationRate()
	 * @see #getMigrationEdgeGraphGenerator()
	 * @generated
	 */
	EAttribute getMigrationEdgeGraphGenerator_MigrationRate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getPopulation <em>Population</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population</em>'.
	 * @see org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getPopulation()
	 * @see #getMigrationEdgeGraphGenerator()
	 * @generated
	 */
	EAttribute getMigrationEdgeGraphGenerator_Population();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator <em>Plate Carree Globe Graph Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plate Carree Globe Graph Generator</em>'.
	 * @see org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator
	 * @generated
	 */
	EClass getPlateCarreeGlobeGraphGenerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getAngularStep <em>Angular Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Angular Step</em>'.
	 * @see org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getAngularStep()
	 * @see #getPlateCarreeGlobeGraphGenerator()
	 * @generated
	 */
	EAttribute getPlateCarreeGlobeGraphGenerator_AngularStep();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getRadius <em>Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radius</em>'.
	 * @see org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getRadius()
	 * @see #getPlateCarreeGlobeGraphGenerator()
	 * @generated
	 */
	EAttribute getPlateCarreeGlobeGraphGenerator_Radius();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphgeneratorsFactory getGraphgeneratorsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.graphgenerators.impl.GraphGeneratorImpl <em>Graph Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.graphgenerators.impl.GraphGeneratorImpl
		 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getGraphGenerator()
		 * @generated
		 */
		EClass GRAPH_GENERATOR = eINSTANCE.getGraphGenerator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl <em>Lattice Graph Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl
		 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getLatticeGraphGenerator()
		 * @generated
		 */
		EClass LATTICE_GRAPH_GENERATOR = eINSTANCE.getLatticeGraphGenerator();

		/**
		 * The meta object literal for the '<em><b>Use Nearest Neighbors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS = eINSTANCE.getLatticeGraphGenerator_UseNearestNeighbors();

		/**
		 * The meta object literal for the '<em><b>Use Next Nearest Neighbors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS = eINSTANCE.getLatticeGraphGenerator_UseNextNearestNeighbors();

		/**
		 * The meta object literal for the '<em><b>Periodic Boundaries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES = eINSTANCE.getLatticeGraphGenerator_PeriodicBoundaries();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.graphgenerators.impl.SquareLatticeGraphGeneratorImpl <em>Square Lattice Graph Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.graphgenerators.impl.SquareLatticeGraphGeneratorImpl
		 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getSquareLatticeGraphGenerator()
		 * @generated
		 */
		EClass SQUARE_LATTICE_GRAPH_GENERATOR = eINSTANCE.getSquareLatticeGraphGenerator();

		/**
		 * The meta object literal for the '<em><b>XSize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE = eINSTANCE.getSquareLatticeGraphGenerator_XSize();

		/**
		 * The meta object literal for the '<em><b>YSize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE = eINSTANCE.getSquareLatticeGraphGenerator_YSize();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQUARE_LATTICE_GRAPH_GENERATOR__AREA = eINSTANCE.getSquareLatticeGraphGenerator_Area();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.graphgenerators.impl.MigrationEdgeGraphGeneratorImpl <em>Migration Edge Graph Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.graphgenerators.impl.MigrationEdgeGraphGeneratorImpl
		 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getMigrationEdgeGraphGenerator()
		 * @generated
		 */
		EClass MIGRATION_EDGE_GRAPH_GENERATOR = eINSTANCE.getMigrationEdgeGraphGenerator();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION_EDGE_GRAPH_GENERATOR__LOCATION = eINSTANCE.getMigrationEdgeGraphGenerator_Location();

		/**
		 * The meta object literal for the '<em><b>Migration Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION_EDGE_GRAPH_GENERATOR__MIGRATION_RATE = eINSTANCE.getMigrationEdgeGraphGenerator_MigrationRate();

		/**
		 * The meta object literal for the '<em><b>Population</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION = eINSTANCE.getMigrationEdgeGraphGenerator_Population();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.graphgenerators.impl.PlateCarreeGlobeGraphGeneratorImpl <em>Plate Carree Globe Graph Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.graphgenerators.impl.PlateCarreeGlobeGraphGeneratorImpl
		 * @see org.eclipse.stem.graphgenerators.impl.GraphgeneratorsPackageImpl#getPlateCarreeGlobeGraphGenerator()
		 * @generated
		 */
		EClass PLATE_CARREE_GLOBE_GRAPH_GENERATOR = eINSTANCE.getPlateCarreeGlobeGraphGenerator();

		/**
		 * The meta object literal for the '<em><b>Angular Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATE_CARREE_GLOBE_GRAPH_GENERATOR__ANGULAR_STEP = eINSTANCE.getPlateCarreeGlobeGraphGenerator_AngularStep();

		/**
		 * The meta object literal for the '<em><b>Radius</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATE_CARREE_GLOBE_GRAPH_GENERATOR__RADIUS = eINSTANCE.getPlateCarreeGlobeGraphGenerator_Radius();

	}

} //GraphgeneratorsPackage