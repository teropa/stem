/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.sequencer.SequencerPackage;
import org.eclipse.stem.core.solver.SolverPackage;
import org.eclipse.stem.graphgenerators.GraphGenerator;
import org.eclipse.stem.graphgenerators.GraphgeneratorsFactory;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.LatticeGraphGenerator;
import org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator;
import org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphgeneratorsPackageImpl extends EPackageImpl implements GraphgeneratorsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass latticeGraphGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass squareLatticeGraphGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass migrationEdgeGraphGeneratorEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphgeneratorsPackageImpl() {
		super(eNS_URI, GraphgeneratorsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GraphgeneratorsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphgeneratorsPackage init() {
		if (isInited) return (GraphgeneratorsPackage)EPackage.Registry.INSTANCE.getEPackage(GraphgeneratorsPackage.eNS_URI);

		// Obtain or create and register package
		GraphgeneratorsPackageImpl theGraphgeneratorsPackage = (GraphgeneratorsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GraphgeneratorsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GraphgeneratorsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();
		GraphPackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		ModifierPackage.eINSTANCE.eClass();
		ScenarioPackage.eINSTANCE.eClass();
		SequencerPackage.eINSTANCE.eClass();
		SolverPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGraphgeneratorsPackage.createPackageContents();

		// Initialize created meta-data
		theGraphgeneratorsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphgeneratorsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphgeneratorsPackage.eNS_URI, theGraphgeneratorsPackage);
		return theGraphgeneratorsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphGenerator() {
		return graphGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLatticeGraphGenerator() {
		return latticeGraphGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLatticeGraphGenerator_XSize() {
		return (EAttribute)latticeGraphGeneratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLatticeGraphGenerator_YSize() {
		return (EAttribute)latticeGraphGeneratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLatticeGraphGenerator_UseNearestNeighbors() {
		return (EAttribute)latticeGraphGeneratorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLatticeGraphGenerator_UseNextNearestNeighbors() {
		return (EAttribute)latticeGraphGeneratorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLatticeGraphGenerator_PeriodicBoundaries() {
		return (EAttribute)latticeGraphGeneratorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSquareLatticeGraphGenerator() {
		return squareLatticeGraphGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSquareLatticeGraphGenerator_Area() {
		return (EAttribute)squareLatticeGraphGeneratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMigrationEdgeGraphGenerator() {
		return migrationEdgeGraphGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMigrationEdgeGraphGenerator_Location() {
		return (EAttribute)migrationEdgeGraphGeneratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphgeneratorsFactory getGraphgeneratorsFactory() {
		return (GraphgeneratorsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		graphGeneratorEClass = createEClass(GRAPH_GENERATOR);

		latticeGraphGeneratorEClass = createEClass(LATTICE_GRAPH_GENERATOR);
		createEAttribute(latticeGraphGeneratorEClass, LATTICE_GRAPH_GENERATOR__XSIZE);
		createEAttribute(latticeGraphGeneratorEClass, LATTICE_GRAPH_GENERATOR__YSIZE);
		createEAttribute(latticeGraphGeneratorEClass, LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS);
		createEAttribute(latticeGraphGeneratorEClass, LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS);
		createEAttribute(latticeGraphGeneratorEClass, LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES);

		squareLatticeGraphGeneratorEClass = createEClass(SQUARE_LATTICE_GRAPH_GENERATOR);
		createEAttribute(squareLatticeGraphGeneratorEClass, SQUARE_LATTICE_GRAPH_GENERATOR__AREA);

		migrationEdgeGraphGeneratorEClass = createEClass(MIGRATION_EDGE_GRAPH_GENERATOR);
		createEAttribute(migrationEdgeGraphGeneratorEClass, MIGRATION_EDGE_GRAPH_GENERATOR__LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		graphGeneratorEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());
		latticeGraphGeneratorEClass.getESuperTypes().add(this.getGraphGenerator());
		squareLatticeGraphGeneratorEClass.getESuperTypes().add(this.getLatticeGraphGenerator());
		migrationEdgeGraphGeneratorEClass.getESuperTypes().add(this.getGraphGenerator());

		// Initialize classes and features; add operations and parameters
		initEClass(graphGeneratorEClass, GraphGenerator.class, "GraphGenerator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(graphGeneratorEClass, theGraphPackage.getGraph(), "getGraph", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(latticeGraphGeneratorEClass, LatticeGraphGenerator.class, "LatticeGraphGenerator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLatticeGraphGenerator_XSize(), theEcorePackage.getEInt(), "xSize", "10", 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLatticeGraphGenerator_YSize(), theEcorePackage.getEInt(), "ySize", "10", 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLatticeGraphGenerator_UseNearestNeighbors(), theEcorePackage.getEBoolean(), "useNearestNeighbors", "true", 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLatticeGraphGenerator_UseNextNearestNeighbors(), theEcorePackage.getEBoolean(), "useNextNearestNeighbors", "false", 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLatticeGraphGenerator_PeriodicBoundaries(), theEcorePackage.getEBoolean(), "periodicBoundaries", "false", 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(squareLatticeGraphGeneratorEClass, SquareLatticeGraphGenerator.class, "SquareLatticeGraphGenerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSquareLatticeGraphGenerator_Area(), theEcorePackage.getEDouble(), "area", "2025", 0, 1, SquareLatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(migrationEdgeGraphGeneratorEClass, MigrationEdgeGraphGenerator.class, "MigrationEdgeGraphGenerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMigrationEdgeGraphGenerator_Location(), theGraphPackage.getURI(), "location", null, 0, 1, MigrationEdgeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GraphgeneratorsPackageImpl
