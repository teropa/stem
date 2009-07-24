package org.eclipse.stem.core.model.impl;

/******************************************************************************* 
 * Copyright (c) 2006, 2008 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/
 
import java.lang.Comparable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.impl.CommonPackageImpl;
import org.eclipse.stem.core.experiment.ExperimentPackage;
import org.eclipse.stem.core.experiment.impl.ExperimentPackageImpl;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.impl.GraphPackageImpl;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.EdgeDecorator;
import org.eclipse.stem.core.model.GraphDecorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.model.STEMTime;
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
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stemTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comparableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

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
	 * @see org.eclipse.stem.core.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		ExperimentPackageImpl theExperimentPackage = (ExperimentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) instanceof ExperimentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) : ExperimentPackage.eINSTANCE);
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		PredicatePackageImpl thePredicatePackage = (PredicatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) instanceof PredicatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) : PredicatePackage.eINSTANCE);
		ScenarioPackageImpl theScenarioPackage = (ScenarioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) instanceof ScenarioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) : ScenarioPackage.eINSTANCE);
		SequencerPackageImpl theSequencerPackage = (SequencerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) instanceof SequencerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) : SequencerPackage.eINSTANCE);
		TriggerPackageImpl theTriggerPackage = (TriggerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) instanceof TriggerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) : TriggerPackage.eINSTANCE);
		SolverPackageImpl theSolverPackage = (SolverPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) instanceof SolverPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) : SolverPackage.eINSTANCE);

		// Create package meta-data objects
		theModelPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theExperimentPackage.createPackageContents();
		theGraphPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		thePredicatePackage.createPackageContents();
		theScenarioPackage.createPackageContents();
		theSequencerPackage.createPackageContents();
		theTriggerPackage.createPackageContents();
		theSolverPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theExperimentPackage.initializePackageContents();
		theGraphPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		thePredicatePackage.initializePackageContents();
		theScenarioPackage.initializePackageContents();
		theSequencerPackage.initializePackageContents();
		theTriggerPackage.initializePackageContents();
		theSolverPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecorator() {
		return decoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecorator_LabelsToUpdate() {
		return (EReference)decoratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecorator_Graph() {
		return (EReference)decoratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecorator_Enabled() {
		return (EAttribute)decoratorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecorator_GraphDecorated() {
		return (EAttribute)decoratorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecorator_Progress() {
		return (EAttribute)decoratorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeDecorator() {
		return edgeDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphDecorator() {
		return graphDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Models() {
		return (EReference)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Graphs() {
		return (EReference)modelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_GraphDecorators() {
		return (EReference)modelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_NodeDecorators() {
		return (EReference)modelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_EdgeDecorators() {
		return (EReference)modelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeDecorator() {
		return nodeDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTEMTime() {
		return stemTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTEMTime_Time() {
		return (EAttribute)stemTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComparable() {
		return comparableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
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
		decoratorEClass = createEClass(DECORATOR);
		createEReference(decoratorEClass, DECORATOR__LABELS_TO_UPDATE);
		createEReference(decoratorEClass, DECORATOR__GRAPH);
		createEAttribute(decoratorEClass, DECORATOR__ENABLED);
		createEAttribute(decoratorEClass, DECORATOR__GRAPH_DECORATED);
		createEAttribute(decoratorEClass, DECORATOR__PROGRESS);

		edgeDecoratorEClass = createEClass(EDGE_DECORATOR);

		graphDecoratorEClass = createEClass(GRAPH_DECORATOR);

		modelEClass = createEClass(MODEL);
		createEReference(modelEClass, MODEL__MODELS);
		createEReference(modelEClass, MODEL__GRAPHS);
		createEReference(modelEClass, MODEL__GRAPH_DECORATORS);
		createEReference(modelEClass, MODEL__NODE_DECORATORS);
		createEReference(modelEClass, MODEL__EDGE_DECORATORS);

		nodeDecoratorEClass = createEClass(NODE_DECORATOR);

		stemTimeEClass = createEClass(STEM_TIME);
		createEAttribute(stemTimeEClass, STEM_TIME__TIME);

		comparableEClass = createEClass(COMPARABLE);

		// Create data types
		uriEDataType = createEDataType(URI);
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
		addETypeParameter(comparableEClass, "T"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes
		decoratorEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());
		edgeDecoratorEClass.getESuperTypes().add(this.getDecorator());
		graphDecoratorEClass.getESuperTypes().add(this.getDecorator());
		modelEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());
		nodeDecoratorEClass.getESuperTypes().add(this.getDecorator());
		EGenericType g1 = createEGenericType(this.getComparable());
		EGenericType g2 = createEGenericType(this.getSTEMTime());
		g1.getETypeArguments().add(g2);
		stemTimeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(decoratorEClass, Decorator.class, "Decorator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDecorator_LabelsToUpdate(), theGraphPackage.getDynamicLabel(), theGraphPackage.getDynamicLabel_Decorator(), "labelsToUpdate", null, 0, -1, Decorator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDecorator_Graph(), theGraphPackage.getGraph(), theGraphPackage.getGraph_Decorators(), "graph", null, 0, 1, Decorator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDecorator_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, Decorator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDecorator_GraphDecorated(), ecorePackage.getEBoolean(), "graphDecorated", "false", 0, 1, Decorator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDecorator_Progress(), ecorePackage.getEDouble(), "progress", "0.0", 0, 1, Decorator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		addEOperation(decoratorEClass, null, "decorateGraph", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(decoratorEClass, null, "updateLabels", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getSTEMTime(), "time", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getELong(), "timerPeriod", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEInt(), "cycle", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(decoratorEClass, null, "resetLabels", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(decoratorEClass, null, "getLabelsToUpdate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEInt(), "partition", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEInt(), "max", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(theEcorePackage.getEEList());
		g2 = createEGenericType(theGraphPackage.getDynamicLabel());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(edgeDecoratorEClass, EdgeDecorator.class, "EdgeDecorator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(graphDecoratorEClass, GraphDecorator.class, "GraphDecorator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModel_Models(), this.getModel(), null, "models", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModel_Graphs(), theGraphPackage.getGraph(), null, "graphs", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModel_GraphDecorators(), this.getGraphDecorator(), null, "graphDecorators", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModel_NodeDecorators(), this.getNodeDecorator(), null, "nodeDecorators", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModel_EdgeDecorators(), this.getEdgeDecorator(), null, "edgeDecorators", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(modelEClass, theGraphPackage.getGraph(), "getCanonicalGraph", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(nodeDecoratorEClass, NodeDecorator.class, "NodeDecorator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stemTimeEClass, STEMTime.class, "STEMTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSTEMTime_Time(), ecorePackage.getEDate(), "time", null, 0, 1, STEMTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(stemTimeEClass, this.getSTEMTime(), "addIncrement", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getELong(), "timeIncrement", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(stemTimeEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(stemTimeEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEJavaObject(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(comparableEClass, Comparable.class, "Comparable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
