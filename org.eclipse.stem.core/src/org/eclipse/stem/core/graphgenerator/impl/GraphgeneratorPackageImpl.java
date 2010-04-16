/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.graphgenerator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.stem.core.common.CommonPackage;

import org.eclipse.stem.core.common.impl.CommonPackageImpl;

import org.eclipse.stem.core.experiment.ExperimentPackage;

import org.eclipse.stem.core.experiment.impl.ExperimentPackageImpl;

import org.eclipse.stem.core.graph.GraphPackage;

import org.eclipse.stem.core.graph.impl.GraphPackageImpl;

import org.eclipse.stem.core.graphgenerator.GraphGenerator;
import org.eclipse.stem.core.graphgenerator.GraphgeneratorFactory;
import org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage;
import org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator;
import org.eclipse.stem.core.graphgenerator.SquareGraphLatticeGenerator;

import org.eclipse.stem.core.model.ModelPackage;

import org.eclipse.stem.core.model.impl.ModelPackageImpl;

import org.eclipse.stem.core.modifier.ModifierPackage;

import org.eclipse.stem.core.modifier.impl.ModifierPackageImpl;

import org.eclipse.stem.core.predicate.PredicatePackage;

import org.eclipse.stem.core.predicate.impl.PredicatePackageImpl;

import org.eclipse.stem.core.scenario.ScenarioPackage;

import org.eclipse.stem.core.scenario.impl.ScenarioPackageImpl;

import org.eclipse.stem.core.sequencer.SequencerPackage;

import org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl;

import org.eclipse.stem.core.solver.SolverPackage;

import org.eclipse.stem.core.solver.impl.SolverPackageImpl;

import org.eclipse.stem.core.trigger.TriggerPackage;

import org.eclipse.stem.core.trigger.impl.TriggerPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphgeneratorPackageImpl extends EPackageImpl implements GraphgeneratorPackage {
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
	private EClass squareGraphLatticeGeneratorEClass = null;

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
	 * @see org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphgeneratorPackageImpl() {
		super(eNS_URI, GraphgeneratorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraphgeneratorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphgeneratorPackage init() {
		if (isInited) return (GraphgeneratorPackage)EPackage.Registry.INSTANCE.getEPackage(GraphgeneratorPackage.eNS_URI);

		// Obtain or create and register package
		GraphgeneratorPackageImpl theGraphgeneratorPackage = (GraphgeneratorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GraphgeneratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GraphgeneratorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		ExperimentPackageImpl theExperimentPackage = (ExperimentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) instanceof ExperimentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) : ExperimentPackage.eINSTANCE);
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		PredicatePackageImpl thePredicatePackage = (PredicatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) instanceof PredicatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) : PredicatePackage.eINSTANCE);
		ScenarioPackageImpl theScenarioPackage = (ScenarioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) instanceof ScenarioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) : ScenarioPackage.eINSTANCE);
		SequencerPackageImpl theSequencerPackage = (SequencerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) instanceof SequencerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) : SequencerPackage.eINSTANCE);
		TriggerPackageImpl theTriggerPackage = (TriggerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) instanceof TriggerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) : TriggerPackage.eINSTANCE);
		SolverPackageImpl theSolverPackage = (SolverPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) instanceof SolverPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) : SolverPackage.eINSTANCE);

		// Create package meta-data objects
		theGraphgeneratorPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theExperimentPackage.createPackageContents();
		theGraphPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		thePredicatePackage.createPackageContents();
		theScenarioPackage.createPackageContents();
		theSequencerPackage.createPackageContents();
		theTriggerPackage.createPackageContents();
		theSolverPackage.createPackageContents();

		// Initialize created meta-data
		theGraphgeneratorPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theExperimentPackage.initializePackageContents();
		theGraphPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		thePredicatePackage.initializePackageContents();
		theScenarioPackage.initializePackageContents();
		theSequencerPackage.initializePackageContents();
		theTriggerPackage.initializePackageContents();
		theSolverPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphgeneratorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphgeneratorPackage.eNS_URI, theGraphgeneratorPackage);
		return theGraphgeneratorPackage;
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
	public EClass getSquareGraphLatticeGenerator() {
		return squareGraphLatticeGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphgeneratorFactory getGraphgeneratorFactory() {
		return (GraphgeneratorFactory)getEFactoryInstance();
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

		squareGraphLatticeGeneratorEClass = createEClass(SQUARE_GRAPH_LATTICE_GENERATOR);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		graphGeneratorEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());
		latticeGraphGeneratorEClass.getESuperTypes().add(this.getGraphGenerator());
		squareGraphLatticeGeneratorEClass.getESuperTypes().add(this.getLatticeGraphGenerator());

		// Initialize classes and features; add operations and parameters
		initEClass(graphGeneratorEClass, GraphGenerator.class, "GraphGenerator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(latticeGraphGeneratorEClass, LatticeGraphGenerator.class, "LatticeGraphGenerator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLatticeGraphGenerator_XSize(), theEcorePackage.getEInt(), "xSize", null, 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLatticeGraphGenerator_YSize(), theEcorePackage.getEInt(), "ySize", null, 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLatticeGraphGenerator_UseNearestNeighbors(), theEcorePackage.getEBooleanObject(), "useNearestNeighbors", null, 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLatticeGraphGenerator_UseNextNearestNeighbors(), theEcorePackage.getEBoolean(), "useNextNearestNeighbors", null, 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getLatticeGraphGenerator_PeriodicBoundaries(), theEcorePackage.getEBoolean(), "periodicBoundaries", null, 0, 1, LatticeGraphGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(squareGraphLatticeGeneratorEClass, SquareGraphLatticeGenerator.class, "SquareGraphLatticeGenerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //GraphgeneratorPackageImpl
