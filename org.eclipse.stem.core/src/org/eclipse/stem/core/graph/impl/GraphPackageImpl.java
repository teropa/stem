package org.eclipse.stem.core.graph.impl;

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
 
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.SanityChecker;
import org.eclipse.stem.core.common.impl.CommonPackageImpl;
import org.eclipse.stem.core.experiment.ExperimentPackage;
import org.eclipse.stem.core.experiment.impl.ExperimentPackageImpl;
import org.eclipse.stem.core.graph.DynamicEdgeLabel;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.StaticEdgeLabel;
import org.eclipse.stem.core.graph.StaticLabel;
import org.eclipse.stem.core.graph.StaticNodeLabel;
import org.eclipse.stem.core.graph.UnresolvedIdentifiable;
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
public class GraphPackageImpl extends EPackageImpl implements GraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicNodeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticNodeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unresolvedIdentifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uriToIdentifiableMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sanityCheckerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicEdgeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticEdgeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uriToEdgeMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uriToNodeMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uriToLabelMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uriToNodeLabelMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType illegalArgumentExceptionEDataType = null;

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
	 * @see org.eclipse.stem.core.graph.GraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphPackageImpl() {
		super(eNS_URI, GraphFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphPackage init() {
		if (isInited) return (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);

		// Obtain or create and register package
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GraphPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		ExperimentPackageImpl theExperimentPackage = (ExperimentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) instanceof ExperimentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) : ExperimentPackage.eINSTANCE);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		PredicatePackageImpl thePredicatePackage = (PredicatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) instanceof PredicatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) : PredicatePackage.eINSTANCE);
		ScenarioPackageImpl theScenarioPackage = (ScenarioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) instanceof ScenarioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) : ScenarioPackage.eINSTANCE);
		SequencerPackageImpl theSequencerPackage = (SequencerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) instanceof SequencerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) : SequencerPackage.eINSTANCE);
		TriggerPackageImpl theTriggerPackage = (TriggerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) instanceof TriggerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) : TriggerPackage.eINSTANCE);
		SolverPackageImpl theSolverPackage = (SolverPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) instanceof SolverPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) : SolverPackage.eINSTANCE);

		// Create package meta-data objects
		theGraphPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theExperimentPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		thePredicatePackage.createPackageContents();
		theScenarioPackage.createPackageContents();
		theSequencerPackage.createPackageContents();
		theTriggerPackage.createPackageContents();
		theSolverPackage.createPackageContents();

		// Initialize created meta-data
		theGraphPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theExperimentPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		thePredicatePackage.initializePackageContents();
		theScenarioPackage.initializePackageContents();
		theSequencerPackage.initializePackageContents();
		theTriggerPackage.initializePackageContents();
		theSolverPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphPackage.eNS_URI, theGraphPackage);
		return theGraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicLabel() {
		return dynamicLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicLabel_NextValueValid() {
		return (EAttribute)dynamicLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicLabel_NextValue() {
		return (EReference)dynamicLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicLabel_Decorator() {
		return (EReference)dynamicLabelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicNodeLabel() {
		return dynamicNodeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_A() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdge_NodeAURI() {
		return (EAttribute)edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_B() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdge_NodeBURI() {
		return (EAttribute)edgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Label() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdge_Directed() {
		return (EAttribute)edgeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraph() {
		return graphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_GraphLabels() {
		return (EReference)graphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_NodeLabels() {
		return (EReference)graphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_DynamicLabels() {
		return (EReference)graphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraph_NumEdges() {
		return (EAttribute)graphEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraph_NumNodes() {
		return (EAttribute)graphEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraph_NumGraphLabels() {
		return (EAttribute)graphEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraph_NumNodeLabels() {
		return (EAttribute)graphEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraph_NumDynamicLabels() {
		return (EAttribute)graphEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_UnresolvedIdentifiables() {
		return (EReference)graphEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Decorators() {
		return (EReference)graphEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Time() {
		return (EReference)graphEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Nodes() {
		return (EReference)graphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Edges() {
		return (EReference)graphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabel() {
		return labelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabel_URIOfIdentifiableToBeLabeled() {
		return (EAttribute)labelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLabel_CurrentValue() {
		return (EReference)labelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLabel_Identifiable() {
		return (EReference)labelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabelValue() {
		return labelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Edges() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Labels() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeLabel() {
		return nodeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeLabel_Node() {
		return (EReference)nodeLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticNodeLabel() {
		return staticNodeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnresolvedIdentifiable() {
		return unresolvedIdentifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnresolvedIdentifiable_Scenario() {
		return (EReference)unresolvedIdentifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnresolvedIdentifiable_Model() {
		return (EReference)unresolvedIdentifiableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnresolvedIdentifiable_Graph() {
		return (EReference)unresolvedIdentifiableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnresolvedIdentifiable_Identifiable() {
		return (EReference)unresolvedIdentifiableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnresolvedIdentifiable_UnresolvedURI() {
		return (EAttribute)unresolvedIdentifiableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnresolvedIdentifiable_FieldName() {
		return (EAttribute)unresolvedIdentifiableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURIToIdentifiableMapEntry() {
		return uriToIdentifiableMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURIToIdentifiableMapEntry_Key() {
		return (EAttribute)uriToIdentifiableMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURIToIdentifiableMapEntry_Value() {
		return (EReference)uriToIdentifiableMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSanityChecker() {
		return sanityCheckerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicEdgeLabel() {
		return dynamicEdgeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeLabel() {
		return edgeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeLabel_Edge() {
		return (EReference)edgeLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticEdgeLabel() {
		return staticEdgeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURIToEdgeMapEntry() {
		return uriToEdgeMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURIToEdgeMapEntry_Key() {
		return (EAttribute)uriToEdgeMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURIToEdgeMapEntry_Value() {
		return (EReference)uriToEdgeMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURIToNodeMapEntry() {
		return uriToNodeMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURIToNodeMapEntry_Key() {
		return (EAttribute)uriToNodeMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURIToNodeMapEntry_Value() {
		return (EReference)uriToNodeMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURIToLabelMapEntry() {
		return uriToLabelMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURIToLabelMapEntry_Key() {
		return (EAttribute)uriToLabelMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURIToLabelMapEntry_Value() {
		return (EReference)uriToLabelMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURIToNodeLabelMapEntry() {
		return uriToNodeLabelMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURIToNodeLabelMapEntry_Key() {
		return (EAttribute)uriToNodeLabelMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURIToNodeLabelMapEntry_Value() {
		return (EReference)uriToNodeLabelMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticLabel() {
		return staticLabelEClass;
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
	public EDataType getIllegalArgumentException() {
		return illegalArgumentExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphFactory getGraphFactory() {
		return (GraphFactory)getEFactoryInstance();
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
		dynamicLabelEClass = createEClass(DYNAMIC_LABEL);
		createEAttribute(dynamicLabelEClass, DYNAMIC_LABEL__NEXT_VALUE_VALID);
		createEReference(dynamicLabelEClass, DYNAMIC_LABEL__NEXT_VALUE);
		createEReference(dynamicLabelEClass, DYNAMIC_LABEL__DECORATOR);

		dynamicNodeLabelEClass = createEClass(DYNAMIC_NODE_LABEL);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__A);
		createEAttribute(edgeEClass, EDGE__NODE_AURI);
		createEReference(edgeEClass, EDGE__B);
		createEAttribute(edgeEClass, EDGE__NODE_BURI);
		createEReference(edgeEClass, EDGE__LABEL);
		createEAttribute(edgeEClass, EDGE__DIRECTED);

		graphEClass = createEClass(GRAPH);
		createEReference(graphEClass, GRAPH__EDGES);
		createEReference(graphEClass, GRAPH__NODES);
		createEReference(graphEClass, GRAPH__GRAPH_LABELS);
		createEReference(graphEClass, GRAPH__NODE_LABELS);
		createEReference(graphEClass, GRAPH__DYNAMIC_LABELS);
		createEAttribute(graphEClass, GRAPH__NUM_EDGES);
		createEAttribute(graphEClass, GRAPH__NUM_NODES);
		createEAttribute(graphEClass, GRAPH__NUM_GRAPH_LABELS);
		createEAttribute(graphEClass, GRAPH__NUM_NODE_LABELS);
		createEAttribute(graphEClass, GRAPH__NUM_DYNAMIC_LABELS);
		createEReference(graphEClass, GRAPH__UNRESOLVED_IDENTIFIABLES);
		createEReference(graphEClass, GRAPH__DECORATORS);
		createEReference(graphEClass, GRAPH__TIME);

		labelEClass = createEClass(LABEL);
		createEAttribute(labelEClass, LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED);
		createEReference(labelEClass, LABEL__CURRENT_VALUE);
		createEReference(labelEClass, LABEL__IDENTIFIABLE);

		labelValueEClass = createEClass(LABEL_VALUE);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__EDGES);
		createEReference(nodeEClass, NODE__LABELS);

		nodeLabelEClass = createEClass(NODE_LABEL);
		createEReference(nodeLabelEClass, NODE_LABEL__NODE);

		staticNodeLabelEClass = createEClass(STATIC_NODE_LABEL);

		unresolvedIdentifiableEClass = createEClass(UNRESOLVED_IDENTIFIABLE);
		createEReference(unresolvedIdentifiableEClass, UNRESOLVED_IDENTIFIABLE__SCENARIO);
		createEReference(unresolvedIdentifiableEClass, UNRESOLVED_IDENTIFIABLE__MODEL);
		createEReference(unresolvedIdentifiableEClass, UNRESOLVED_IDENTIFIABLE__GRAPH);
		createEReference(unresolvedIdentifiableEClass, UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE);
		createEAttribute(unresolvedIdentifiableEClass, UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI);
		createEAttribute(unresolvedIdentifiableEClass, UNRESOLVED_IDENTIFIABLE__FIELD_NAME);

		uriToIdentifiableMapEntryEClass = createEClass(URI_TO_IDENTIFIABLE_MAP_ENTRY);
		createEAttribute(uriToIdentifiableMapEntryEClass, URI_TO_IDENTIFIABLE_MAP_ENTRY__KEY);
		createEReference(uriToIdentifiableMapEntryEClass, URI_TO_IDENTIFIABLE_MAP_ENTRY__VALUE);

		sanityCheckerEClass = createEClass(SANITY_CHECKER);

		dynamicEdgeLabelEClass = createEClass(DYNAMIC_EDGE_LABEL);

		edgeLabelEClass = createEClass(EDGE_LABEL);
		createEReference(edgeLabelEClass, EDGE_LABEL__EDGE);

		staticEdgeLabelEClass = createEClass(STATIC_EDGE_LABEL);

		uriToEdgeMapEntryEClass = createEClass(URI_TO_EDGE_MAP_ENTRY);
		createEAttribute(uriToEdgeMapEntryEClass, URI_TO_EDGE_MAP_ENTRY__KEY);
		createEReference(uriToEdgeMapEntryEClass, URI_TO_EDGE_MAP_ENTRY__VALUE);

		uriToNodeMapEntryEClass = createEClass(URI_TO_NODE_MAP_ENTRY);
		createEAttribute(uriToNodeMapEntryEClass, URI_TO_NODE_MAP_ENTRY__KEY);
		createEReference(uriToNodeMapEntryEClass, URI_TO_NODE_MAP_ENTRY__VALUE);

		uriToLabelMapEntryEClass = createEClass(URI_TO_LABEL_MAP_ENTRY);
		createEAttribute(uriToLabelMapEntryEClass, URI_TO_LABEL_MAP_ENTRY__KEY);
		createEReference(uriToLabelMapEntryEClass, URI_TO_LABEL_MAP_ENTRY__VALUE);

		uriToNodeLabelMapEntryEClass = createEClass(URI_TO_NODE_LABEL_MAP_ENTRY);
		createEAttribute(uriToNodeLabelMapEntryEClass, URI_TO_NODE_LABEL_MAP_ENTRY__KEY);
		createEReference(uriToNodeLabelMapEntryEClass, URI_TO_NODE_LABEL_MAP_ENTRY__VALUE);

		staticLabelEClass = createEClass(STATIC_LABEL);

		// Create data types
		uriEDataType = createEDataType(URI);
		illegalArgumentExceptionEDataType = createEDataType(ILLEGAL_ARGUMENT_EXCEPTION);
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
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		ModifierPackage theModifierPackage = (ModifierPackage)EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dynamicLabelEClass.getESuperTypes().add(this.getLabel());
		dynamicNodeLabelEClass.getESuperTypes().add(this.getDynamicLabel());
		dynamicNodeLabelEClass.getESuperTypes().add(this.getNodeLabel());
		edgeEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());
		edgeEClass.getESuperTypes().add(theModifierPackage.getModifiable());
		graphEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());
		labelEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());
		labelValueEClass.getESuperTypes().add(this.getSanityChecker());
		nodeEClass.getESuperTypes().add(theCommonPackage.getIdentifiable());
		nodeLabelEClass.getESuperTypes().add(this.getLabel());
		staticNodeLabelEClass.getESuperTypes().add(this.getNodeLabel());
		staticNodeLabelEClass.getESuperTypes().add(this.getStaticLabel());
		dynamicEdgeLabelEClass.getESuperTypes().add(this.getDynamicLabel());
		dynamicEdgeLabelEClass.getESuperTypes().add(this.getEdgeLabel());
		edgeLabelEClass.getESuperTypes().add(this.getLabel());
		staticEdgeLabelEClass.getESuperTypes().add(this.getEdgeLabel());
		staticEdgeLabelEClass.getESuperTypes().add(this.getStaticLabel());
		staticLabelEClass.getESuperTypes().add(this.getLabel());
		staticLabelEClass.getESuperTypes().add(theModifierPackage.getModifiable());

		// Initialize classes and features; add operations and parameters
		initEClass(dynamicLabelEClass, DynamicLabel.class, "DynamicLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDynamicLabel_NextValueValid(), ecorePackage.getEBoolean(), "nextValueValid", "false", 0, 1, DynamicLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getDynamicLabel_NextValue(), this.getLabelValue(), null, "nextValue", null, 1, 1, DynamicLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDynamicLabel_Decorator(), theModelPackage.getDecorator(), theModelPackage.getDecorator_LabelsToUpdate(), "decorator", null, 0, 1, DynamicLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(dynamicLabelEClass, null, "reset", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(dynamicLabelEClass, null, "switchToNextValue", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(dynamicNodeLabelEClass, DynamicNodeLabel.class, "DynamicNodeLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEdge_A(), this.getNode(), null, "a", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdge_NodeAURI(), this.getURI(), "nodeAURI", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEdge_B(), this.getNode(), null, "b", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdge_NodeBURI(), this.getURI(), "nodeBURI", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEdge_Label(), this.getEdgeLabel(), this.getEdgeLabel_Edge(), "label", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdge_Directed(), ecorePackage.getEBoolean(), "directed", "false", 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		EOperation op = addEOperation(edgeEClass, this.getNode(), "getOtherNode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getIllegalArgumentException());

		op = addEOperation(edgeEClass, ecorePackage.getEBoolean(), "isDirectedAt", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(graphEClass, Graph.class, "Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getGraph_Edges(), this.getURIToEdgeMapEntry(), null, "edges", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGraph_Nodes(), this.getURIToNodeMapEntry(), null, "nodes", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGraph_GraphLabels(), this.getURIToLabelMapEntry(), null, "graphLabels", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGraph_NodeLabels(), this.getURIToNodeLabelMapEntry(), null, "nodeLabels", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGraph_DynamicLabels(), this.getDynamicLabel(), null, "dynamicLabels", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGraph_NumEdges(), ecorePackage.getEInt(), "numEdges", null, 0, 1, Graph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGraph_NumNodes(), ecorePackage.getEInt(), "numNodes", null, 0, 1, Graph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGraph_NumGraphLabels(), ecorePackage.getEInt(), "numGraphLabels", null, 0, 1, Graph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGraph_NumNodeLabels(), ecorePackage.getEInt(), "numNodeLabels", null, 0, 1, Graph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGraph_NumDynamicLabels(), ecorePackage.getEInt(), "numDynamicLabels", null, 0, 1, Graph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGraph_UnresolvedIdentifiables(), this.getUnresolvedIdentifiable(), null, "unresolvedIdentifiables", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGraph_Decorators(), theModelPackage.getDecorator(), theModelPackage.getDecorator_Graph(), "decorators", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getGraph_Time(), theModelPackage.getSTEMTime(), null, "time", null, 0, 1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, this.getNodeLabel(), "getNodeLabelsByTypeURI", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getURI(), "typeURI", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, null, "addGraph", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theCommonPackage.getIdentifiableFilter(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, null, "putEdge", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEdge(), "edge", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, this.getEdge(), "getEdge", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, null, "putNode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, this.getNode(), "getNode", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, null, "putNodeLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getNodeLabel(), "label", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, this.getNodeLabel(), "getNodeLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, null, "putGraphLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getLabel(), "label", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, this.getLabel(), "getGraphLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, null, "addDynamicLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getDynamicLabel(), "dynamiclabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(graphEClass, null, "switchToNextValue", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theModelPackage.getSTEMTime(), "currentTime", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(labelEClass, Label.class, "Label", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLabel_URIOfIdentifiableToBeLabeled(), this.getURI(), "uRIOfIdentifiableToBeLabeled", null, 0, 1, Label.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLabel_CurrentValue(), this.getLabelValue(), null, "currentValue", null, 1, 1, Label.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLabel_Identifiable(), theCommonPackage.getIdentifiable(), null, "identifiable", null, 0, 1, Label.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(labelValueEClass, LabelValue.class, "LabelValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(labelValueEClass, null, "reset", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNode_Edges(), this.getEdge(), null, "edges", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNode_Labels(), this.getNodeLabel(), this.getNodeLabel_Node(), "labels", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(nodeLabelEClass, NodeLabel.class, "NodeLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNodeLabel_Node(), this.getNode(), this.getNode_Labels(), "node", null, 0, 1, NodeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(staticNodeLabelEClass, StaticNodeLabel.class, "StaticNodeLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(unresolvedIdentifiableEClass, UnresolvedIdentifiable.class, "UnresolvedIdentifiable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getUnresolvedIdentifiable_Scenario(), theCommonPackage.getIdentifiable(), null, "scenario", null, 0, 1, UnresolvedIdentifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnresolvedIdentifiable_Model(), theCommonPackage.getIdentifiable(), null, "model", null, 0, 1, UnresolvedIdentifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnresolvedIdentifiable_Graph(), theCommonPackage.getIdentifiable(), null, "graph", null, 0, 1, UnresolvedIdentifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnresolvedIdentifiable_Identifiable(), theCommonPackage.getIdentifiable(), null, "identifiable", null, 0, 1, UnresolvedIdentifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnresolvedIdentifiable_UnresolvedURI(), this.getURI(), "unresolvedURI", null, 0, 1, UnresolvedIdentifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnresolvedIdentifiable_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, UnresolvedIdentifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(uriToIdentifiableMapEntryEClass, Map.Entry.class, "URIToIdentifiableMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getURIToIdentifiableMapEntry_Key(), this.getURI(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getURIToIdentifiableMapEntry_Value(), theCommonPackage.getIdentifiable(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sanityCheckerEClass, SanityChecker.class, "SanityChecker", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(dynamicEdgeLabelEClass, DynamicEdgeLabel.class, "DynamicEdgeLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(edgeLabelEClass, EdgeLabel.class, "EdgeLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEdgeLabel_Edge(), this.getEdge(), this.getEdge_Label(), "edge", null, 0, 1, EdgeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(staticEdgeLabelEClass, StaticEdgeLabel.class, "StaticEdgeLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(uriToEdgeMapEntryEClass, Map.Entry.class, "URIToEdgeMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getURIToEdgeMapEntry_Key(), this.getURI(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getURIToEdgeMapEntry_Value(), this.getEdge(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(uriToNodeMapEntryEClass, Map.Entry.class, "URIToNodeMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getURIToNodeMapEntry_Key(), this.getURI(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getURIToNodeMapEntry_Value(), this.getNode(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(uriToLabelMapEntryEClass, Map.Entry.class, "URIToLabelMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getURIToLabelMapEntry_Key(), this.getURI(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getURIToLabelMapEntry_Value(), this.getLabel(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(uriToNodeLabelMapEntryEClass, Map.Entry.class, "URIToNodeLabelMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getURIToNodeLabelMapEntry_Key(), this.getURI(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getURIToNodeLabelMapEntry_Value(), this.getNodeLabel(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(staticLabelEClass, StaticLabel.class, "StaticLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(illegalArgumentExceptionEDataType, IllegalArgumentException.class, "IllegalArgumentException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //GraphPackageImpl
