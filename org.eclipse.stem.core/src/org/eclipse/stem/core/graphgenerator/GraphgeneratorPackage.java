/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.graphgenerator;

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
 * @see org.eclipse.stem.core.graphgenerator.GraphgeneratorFactory
 * @model kind="package"
 * @generated
 */
public interface GraphgeneratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphgenerator"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/graphgenerator.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.core.graphgenerator"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphgeneratorPackage eINSTANCE = org.eclipse.stem.core.graphgenerator.impl.GraphgeneratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graphgenerator.impl.GraphGeneratorImpl <em>Graph Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graphgenerator.impl.GraphGeneratorImpl
	 * @see org.eclipse.stem.core.graphgenerator.impl.GraphgeneratorPackageImpl#getGraphGenerator()
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
	 * The meta object id for the '{@link org.eclipse.stem.core.graphgenerator.impl.LatticeGraphGeneratorImpl <em>Lattice Graph Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graphgenerator.impl.LatticeGraphGeneratorImpl
	 * @see org.eclipse.stem.core.graphgenerator.impl.GraphgeneratorPackageImpl#getLatticeGraphGenerator()
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
	 * The feature id for the '<em><b>XSize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__XSIZE = GRAPH_GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>YSize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__YSIZE = GRAPH_GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Use Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS = GRAPH_GENERATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Use Next Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS = GRAPH_GENERATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Periodic Boundaries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES = GRAPH_GENERATOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Lattice Graph Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATTICE_GRAPH_GENERATOR_FEATURE_COUNT = GRAPH_GENERATOR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.graphgenerator.impl.SquareGraphLatticeGeneratorImpl <em>Square Graph Lattice Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.graphgenerator.impl.SquareGraphLatticeGeneratorImpl
	 * @see org.eclipse.stem.core.graphgenerator.impl.GraphgeneratorPackageImpl#getSquareGraphLatticeGenerator()
	 * @generated
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR__URI = LATTICE_GRAPH_GENERATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR__TYPE_URI = LATTICE_GRAPH_GENERATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR__DUBLIN_CORE = LATTICE_GRAPH_GENERATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>XSize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR__XSIZE = LATTICE_GRAPH_GENERATOR__XSIZE;

	/**
	 * The feature id for the '<em><b>YSize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR__YSIZE = LATTICE_GRAPH_GENERATOR__YSIZE;

	/**
	 * The feature id for the '<em><b>Use Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR__USE_NEAREST_NEIGHBORS = LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS;

	/**
	 * The feature id for the '<em><b>Use Next Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS = LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS;

	/**
	 * The feature id for the '<em><b>Periodic Boundaries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR__PERIODIC_BOUNDARIES = LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES;

	/**
	 * The number of structural features of the '<em>Square Graph Lattice Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_GRAPH_LATTICE_GENERATOR_FEATURE_COUNT = LATTICE_GRAPH_GENERATOR_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graphgenerator.GraphGenerator <em>Graph Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Generator</em>'.
	 * @see org.eclipse.stem.core.graphgenerator.GraphGenerator
	 * @generated
	 */
	EClass getGraphGenerator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator <em>Lattice Graph Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lattice Graph Generator</em>'.
	 * @see org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator
	 * @generated
	 */
	EClass getLatticeGraphGenerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getXSize <em>XSize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XSize</em>'.
	 * @see org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getXSize()
	 * @see #getLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getLatticeGraphGenerator_XSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getYSize <em>YSize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YSize</em>'.
	 * @see org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getYSize()
	 * @see #getLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getLatticeGraphGenerator_YSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getUseNearestNeighbors <em>Use Nearest Neighbors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Nearest Neighbors</em>'.
	 * @see org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getUseNearestNeighbors()
	 * @see #getLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getLatticeGraphGenerator_UseNearestNeighbors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#isUseNextNearestNeighbors <em>Use Next Nearest Neighbors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Next Nearest Neighbors</em>'.
	 * @see org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#isUseNextNearestNeighbors()
	 * @see #getLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getLatticeGraphGenerator_UseNextNearestNeighbors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#isPeriodicBoundaries <em>Periodic Boundaries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Periodic Boundaries</em>'.
	 * @see org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#isPeriodicBoundaries()
	 * @see #getLatticeGraphGenerator()
	 * @generated
	 */
	EAttribute getLatticeGraphGenerator_PeriodicBoundaries();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.graphgenerator.SquareGraphLatticeGenerator <em>Square Graph Lattice Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Square Graph Lattice Generator</em>'.
	 * @see org.eclipse.stem.core.graphgenerator.SquareGraphLatticeGenerator
	 * @generated
	 */
	EClass getSquareGraphLatticeGenerator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphgeneratorFactory getGraphgeneratorFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.core.graphgenerator.impl.GraphGeneratorImpl <em>Graph Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graphgenerator.impl.GraphGeneratorImpl
		 * @see org.eclipse.stem.core.graphgenerator.impl.GraphgeneratorPackageImpl#getGraphGenerator()
		 * @generated
		 */
		EClass GRAPH_GENERATOR = eINSTANCE.getGraphGenerator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.graphgenerator.impl.LatticeGraphGeneratorImpl <em>Lattice Graph Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graphgenerator.impl.LatticeGraphGeneratorImpl
		 * @see org.eclipse.stem.core.graphgenerator.impl.GraphgeneratorPackageImpl#getLatticeGraphGenerator()
		 * @generated
		 */
		EClass LATTICE_GRAPH_GENERATOR = eINSTANCE.getLatticeGraphGenerator();

		/**
		 * The meta object literal for the '<em><b>XSize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LATTICE_GRAPH_GENERATOR__XSIZE = eINSTANCE.getLatticeGraphGenerator_XSize();

		/**
		 * The meta object literal for the '<em><b>YSize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LATTICE_GRAPH_GENERATOR__YSIZE = eINSTANCE.getLatticeGraphGenerator_YSize();

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
		 * The meta object literal for the '{@link org.eclipse.stem.core.graphgenerator.impl.SquareGraphLatticeGeneratorImpl <em>Square Graph Lattice Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.graphgenerator.impl.SquareGraphLatticeGeneratorImpl
		 * @see org.eclipse.stem.core.graphgenerator.impl.GraphgeneratorPackageImpl#getSquareGraphLatticeGenerator()
		 * @generated
		 */
		EClass SQUARE_GRAPH_LATTICE_GENERATOR = eINSTANCE.getSquareGraphLatticeGenerator();

	}

} //GraphgeneratorPackage
