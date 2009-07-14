package org.eclipse.stem.core.modifier.impl;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
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
import org.eclipse.emf.ecore.EDataType;
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
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.model.impl.ModelPackageImpl;
import org.eclipse.stem.core.modifier.DoubleNOPModifier;
import org.eclipse.stem.core.modifier.DoubleRangeModifier;
import org.eclipse.stem.core.modifier.DoubleSequenceModifier;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.core.modifier.IntegerNOPModifier;
import org.eclipse.stem.core.modifier.IntegerRangeModifier;
import org.eclipse.stem.core.modifier.IntegerSequenceModifier;
import org.eclipse.stem.core.modifier.LongNOPModifier;
import org.eclipse.stem.core.modifier.LongRangeModifier;
import org.eclipse.stem.core.modifier.LongSequenceModifier;
import org.eclipse.stem.core.modifier.Modifiable;
import org.eclipse.stem.core.modifier.Modifier;
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.NOPModifier;
import org.eclipse.stem.core.modifier.RangeModifier;
import org.eclipse.stem.core.modifier.STEMTimeNOPModifier;
import org.eclipse.stem.core.modifier.STEMTimeRangeModifier;
import org.eclipse.stem.core.modifier.STEMTimeSequenceModifier;
import org.eclipse.stem.core.modifier.SequenceModifier;
import org.eclipse.stem.core.modifier.StringNOPModifier;
import org.eclipse.stem.core.modifier.StringSequenceModifier;
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
public class ModifierPackageImpl extends EPackageImpl implements ModifierPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleNOPModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleRangeModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleSequenceModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerNOPModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerRangeModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerSequenceModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longNOPModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longRangeModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longSequenceModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nopModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stemTimeNOPModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stemTimeRangeModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stemTimeSequenceModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringNOPModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringSequenceModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifiableEClass = null;

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
	 * @see org.eclipse.stem.core.modifier.ModifierPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModifierPackageImpl() {
		super(eNS_URI, ModifierFactory.eINSTANCE);
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
	public static ModifierPackage init() {
		if (isInited) return (ModifierPackage)EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI);

		// Obtain or create and register package
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ModifierPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);
		ExperimentPackageImpl theExperimentPackage = (ExperimentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) instanceof ExperimentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) : ExperimentPackage.eINSTANCE);
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		PredicatePackageImpl thePredicatePackage = (PredicatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) instanceof PredicatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) : PredicatePackage.eINSTANCE);
		ScenarioPackageImpl theScenarioPackage = (ScenarioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) instanceof ScenarioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) : ScenarioPackage.eINSTANCE);
		SequencerPackageImpl theSequencerPackage = (SequencerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) instanceof SequencerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) : SequencerPackage.eINSTANCE);
		TriggerPackageImpl theTriggerPackage = (TriggerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) instanceof TriggerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) : TriggerPackage.eINSTANCE);
		SolverPackageImpl theSolverPackage = (SolverPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) instanceof SolverPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI) : SolverPackage.eINSTANCE);

		// Create package meta-data objects
		theModifierPackage.createPackageContents();
		theCommonPackage.createPackageContents();
		theExperimentPackage.createPackageContents();
		theGraphPackage.createPackageContents();
		theModelPackage.createPackageContents();
		thePredicatePackage.createPackageContents();
		theScenarioPackage.createPackageContents();
		theSequencerPackage.createPackageContents();
		theTriggerPackage.createPackageContents();
		theSolverPackage.createPackageContents();

		// Initialize created meta-data
		theModifierPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();
		theExperimentPackage.initializePackageContents();
		theGraphPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		thePredicatePackage.initializePackageContents();
		theScenarioPackage.initializePackageContents();
		theSequencerPackage.initializePackageContents();
		theTriggerPackage.initializePackageContents();
		theSolverPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModifierPackage.freeze();

		return theModifierPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleNOPModifier() {
		return doubleNOPModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleRangeModifier() {
		return doubleRangeModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRangeModifier_StartValue() {
		return (EAttribute)doubleRangeModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRangeModifier_EndValue() {
		return (EAttribute)doubleRangeModifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRangeModifier_Increment() {
		return (EAttribute)doubleRangeModifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRangeModifier_NextValue() {
		return (EAttribute)doubleRangeModifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRangeModifier_OriginalValue() {
		return (EAttribute)doubleRangeModifierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleSequenceModifier() {
		return doubleSequenceModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleSequenceModifier_Sequence() {
		return (EAttribute)doubleSequenceModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureModifier() {
		return featureModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureModifier_Target() {
		return (EReference)featureModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureModifier_EStructuralFeature() {
		return (EReference)featureModifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureModifier_FeatureName() {
		return (EAttribute)featureModifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureModifier_FeatureId() {
		return (EAttribute)featureModifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureModifier_CurrentValueText() {
		return (EAttribute)featureModifierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureModifier_Complete() {
		return (EAttribute)featureModifierEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerNOPModifier() {
		return integerNOPModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerRangeModifier() {
		return integerRangeModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerRangeModifier_StartValue() {
		return (EAttribute)integerRangeModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerRangeModifier_EndValue() {
		return (EAttribute)integerRangeModifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerRangeModifier_Increment() {
		return (EAttribute)integerRangeModifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerRangeModifier_NextValue() {
		return (EAttribute)integerRangeModifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerRangeModifier_OriginalValue() {
		return (EAttribute)integerRangeModifierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerSequenceModifier() {
		return integerSequenceModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerSequenceModifier_Sequence() {
		return (EAttribute)integerSequenceModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongNOPModifier() {
		return longNOPModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongRangeModifier() {
		return longRangeModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongRangeModifier_StartValue() {
		return (EAttribute)longRangeModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongRangeModifier_EndValue() {
		return (EAttribute)longRangeModifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongRangeModifier_Increment() {
		return (EAttribute)longRangeModifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongRangeModifier_NextValue() {
		return (EAttribute)longRangeModifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongRangeModifier_OriginalValue() {
		return (EAttribute)longRangeModifierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongSequenceModifier() {
		return longSequenceModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongSequenceModifier_Sequence() {
		return (EAttribute)longSequenceModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifier() {
		return modifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifier_TargetURI() {
		return (EAttribute)modifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifier_FeatureModifiers() {
		return (EReference)modifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifier_Complete() {
		return (EAttribute)modifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNOPModifier() {
		return nopModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeModifier() {
		return rangeModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTEMTimeNOPModifier() {
		return stemTimeNOPModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTEMTimeRangeModifier() {
		return stemTimeRangeModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTEMTimeRangeModifier_StartValue() {
		return (EReference)stemTimeRangeModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTEMTimeRangeModifier_EndValue() {
		return (EReference)stemTimeRangeModifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTEMTimeRangeModifier_Increment() {
		return (EAttribute)stemTimeRangeModifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTEMTimeRangeModifier_NextValue() {
		return (EReference)stemTimeRangeModifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTEMTimeRangeModifier_OriginalValue() {
		return (EReference)stemTimeRangeModifierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTEMTimeSequenceModifier() {
		return stemTimeSequenceModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTEMTimeSequenceModifier_Sequence() {
		return (EReference)stemTimeSequenceModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceModifier() {
		return sequenceModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceModifier_SequenceSize() {
		return (EAttribute)sequenceModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceModifier_CurrentSequenceIndex() {
		return (EAttribute)sequenceModifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceModifier_NextValue() {
		return (EAttribute)sequenceModifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceModifier_OriginalValue() {
		return (EAttribute)sequenceModifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringNOPModifier() {
		return stringNOPModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringSequenceModifier() {
		return stringSequenceModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringSequenceModifier_Sequence() {
		return (EAttribute)stringSequenceModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifiable() {
		return modifiableEClass;
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
	public ModifierFactory getModifierFactory() {
		return (ModifierFactory)getEFactoryInstance();
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
		doubleNOPModifierEClass = createEClass(DOUBLE_NOP_MODIFIER);

		doubleRangeModifierEClass = createEClass(DOUBLE_RANGE_MODIFIER);
		createEAttribute(doubleRangeModifierEClass, DOUBLE_RANGE_MODIFIER__START_VALUE);
		createEAttribute(doubleRangeModifierEClass, DOUBLE_RANGE_MODIFIER__END_VALUE);
		createEAttribute(doubleRangeModifierEClass, DOUBLE_RANGE_MODIFIER__INCREMENT);
		createEAttribute(doubleRangeModifierEClass, DOUBLE_RANGE_MODIFIER__NEXT_VALUE);
		createEAttribute(doubleRangeModifierEClass, DOUBLE_RANGE_MODIFIER__ORIGINAL_VALUE);

		doubleSequenceModifierEClass = createEClass(DOUBLE_SEQUENCE_MODIFIER);
		createEAttribute(doubleSequenceModifierEClass, DOUBLE_SEQUENCE_MODIFIER__SEQUENCE);

		featureModifierEClass = createEClass(FEATURE_MODIFIER);
		createEReference(featureModifierEClass, FEATURE_MODIFIER__TARGET);
		createEReference(featureModifierEClass, FEATURE_MODIFIER__ESTRUCTURAL_FEATURE);
		createEAttribute(featureModifierEClass, FEATURE_MODIFIER__FEATURE_NAME);
		createEAttribute(featureModifierEClass, FEATURE_MODIFIER__FEATURE_ID);
		createEAttribute(featureModifierEClass, FEATURE_MODIFIER__CURRENT_VALUE_TEXT);
		createEAttribute(featureModifierEClass, FEATURE_MODIFIER__COMPLETE);

		integerNOPModifierEClass = createEClass(INTEGER_NOP_MODIFIER);

		integerRangeModifierEClass = createEClass(INTEGER_RANGE_MODIFIER);
		createEAttribute(integerRangeModifierEClass, INTEGER_RANGE_MODIFIER__START_VALUE);
		createEAttribute(integerRangeModifierEClass, INTEGER_RANGE_MODIFIER__END_VALUE);
		createEAttribute(integerRangeModifierEClass, INTEGER_RANGE_MODIFIER__INCREMENT);
		createEAttribute(integerRangeModifierEClass, INTEGER_RANGE_MODIFIER__NEXT_VALUE);
		createEAttribute(integerRangeModifierEClass, INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE);

		integerSequenceModifierEClass = createEClass(INTEGER_SEQUENCE_MODIFIER);
		createEAttribute(integerSequenceModifierEClass, INTEGER_SEQUENCE_MODIFIER__SEQUENCE);

		longNOPModifierEClass = createEClass(LONG_NOP_MODIFIER);

		longRangeModifierEClass = createEClass(LONG_RANGE_MODIFIER);
		createEAttribute(longRangeModifierEClass, LONG_RANGE_MODIFIER__START_VALUE);
		createEAttribute(longRangeModifierEClass, LONG_RANGE_MODIFIER__END_VALUE);
		createEAttribute(longRangeModifierEClass, LONG_RANGE_MODIFIER__INCREMENT);
		createEAttribute(longRangeModifierEClass, LONG_RANGE_MODIFIER__NEXT_VALUE);
		createEAttribute(longRangeModifierEClass, LONG_RANGE_MODIFIER__ORIGINAL_VALUE);

		longSequenceModifierEClass = createEClass(LONG_SEQUENCE_MODIFIER);
		createEAttribute(longSequenceModifierEClass, LONG_SEQUENCE_MODIFIER__SEQUENCE);

		modifierEClass = createEClass(MODIFIER);
		createEAttribute(modifierEClass, MODIFIER__TARGET_URI);
		createEReference(modifierEClass, MODIFIER__FEATURE_MODIFIERS);
		createEAttribute(modifierEClass, MODIFIER__COMPLETE);

		nopModifierEClass = createEClass(NOP_MODIFIER);

		rangeModifierEClass = createEClass(RANGE_MODIFIER);

		stemTimeNOPModifierEClass = createEClass(STEM_TIME_NOP_MODIFIER);

		stemTimeRangeModifierEClass = createEClass(STEM_TIME_RANGE_MODIFIER);
		createEReference(stemTimeRangeModifierEClass, STEM_TIME_RANGE_MODIFIER__START_VALUE);
		createEReference(stemTimeRangeModifierEClass, STEM_TIME_RANGE_MODIFIER__END_VALUE);
		createEAttribute(stemTimeRangeModifierEClass, STEM_TIME_RANGE_MODIFIER__INCREMENT);
		createEReference(stemTimeRangeModifierEClass, STEM_TIME_RANGE_MODIFIER__NEXT_VALUE);
		createEReference(stemTimeRangeModifierEClass, STEM_TIME_RANGE_MODIFIER__ORIGINAL_VALUE);

		stemTimeSequenceModifierEClass = createEClass(STEM_TIME_SEQUENCE_MODIFIER);
		createEReference(stemTimeSequenceModifierEClass, STEM_TIME_SEQUENCE_MODIFIER__SEQUENCE);

		sequenceModifierEClass = createEClass(SEQUENCE_MODIFIER);
		createEAttribute(sequenceModifierEClass, SEQUENCE_MODIFIER__SEQUENCE_SIZE);
		createEAttribute(sequenceModifierEClass, SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX);
		createEAttribute(sequenceModifierEClass, SEQUENCE_MODIFIER__NEXT_VALUE);
		createEAttribute(sequenceModifierEClass, SEQUENCE_MODIFIER__ORIGINAL_VALUE);

		stringNOPModifierEClass = createEClass(STRING_NOP_MODIFIER);

		stringSequenceModifierEClass = createEClass(STRING_SEQUENCE_MODIFIER);
		createEAttribute(stringSequenceModifierEClass, STRING_SEQUENCE_MODIFIER__SEQUENCE);

		modifiableEClass = createEClass(MODIFIABLE);

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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		ScenarioPackage theScenarioPackage = (ScenarioPackage)EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		doubleNOPModifierEClass.getESuperTypes().add(this.getNOPModifier());
		doubleRangeModifierEClass.getESuperTypes().add(this.getRangeModifier());
		doubleSequenceModifierEClass.getESuperTypes().add(this.getSequenceModifier());
		integerNOPModifierEClass.getESuperTypes().add(this.getNOPModifier());
		integerRangeModifierEClass.getESuperTypes().add(this.getRangeModifier());
		integerSequenceModifierEClass.getESuperTypes().add(this.getSequenceModifier());
		longNOPModifierEClass.getESuperTypes().add(this.getNOPModifier());
		longRangeModifierEClass.getESuperTypes().add(this.getRangeModifier());
		longSequenceModifierEClass.getESuperTypes().add(this.getSequenceModifier());
		modifierEClass.getESuperTypes().add(theModelPackage.getDecorator());
		nopModifierEClass.getESuperTypes().add(this.getFeatureModifier());
		rangeModifierEClass.getESuperTypes().add(this.getFeatureModifier());
		stemTimeNOPModifierEClass.getESuperTypes().add(this.getNOPModifier());
		stemTimeRangeModifierEClass.getESuperTypes().add(this.getRangeModifier());
		stemTimeSequenceModifierEClass.getESuperTypes().add(this.getSequenceModifier());
		sequenceModifierEClass.getESuperTypes().add(this.getFeatureModifier());
		stringNOPModifierEClass.getESuperTypes().add(this.getNOPModifier());
		stringSequenceModifierEClass.getESuperTypes().add(this.getSequenceModifier());

		// Initialize classes and features; add operations and parameters
		initEClass(doubleNOPModifierEClass, DoubleNOPModifier.class, "DoubleNOPModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(doubleRangeModifierEClass, DoubleRangeModifier.class, "DoubleRangeModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDoubleRangeModifier_StartValue(), ecorePackage.getEDouble(), "startValue", "-99999999.0", 0, 1, DoubleRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDoubleRangeModifier_EndValue(), ecorePackage.getEDouble(), "endValue", "-99999999.0", 0, 1, DoubleRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDoubleRangeModifier_Increment(), ecorePackage.getEDouble(), "increment", "-99999999.0", 0, 1, DoubleRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDoubleRangeModifier_NextValue(), ecorePackage.getEDouble(), "nextValue", "0.0", 0, 1, DoubleRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDoubleRangeModifier_OriginalValue(), ecorePackage.getEDouble(), "originalValue", null, 0, 1, DoubleRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(doubleSequenceModifierEClass, DoubleSequenceModifier.class, "DoubleSequenceModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDoubleSequenceModifier_Sequence(), ecorePackage.getEDoubleObject(), "sequence", null, 0, -1, DoubleSequenceModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(featureModifierEClass, FeatureModifier.class, "FeatureModifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFeatureModifier_Target(), theEcorePackage.getEObject(), null, "target", null, 0, 1, FeatureModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getFeatureModifier_EStructuralFeature(), theEcorePackage.getEStructuralFeature(), null, "eStructuralFeature", null, 0, 1, FeatureModifier.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getFeatureModifier_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, FeatureModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getFeatureModifier_FeatureId(), ecorePackage.getEInt(), "featureId", null, 0, 1, FeatureModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getFeatureModifier_CurrentValueText(), ecorePackage.getEString(), "currentValueText", null, 0, 1, FeatureModifier.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getFeatureModifier_Complete(), ecorePackage.getEBoolean(), "complete", null, 0, 1, FeatureModifier.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(featureModifierEClass, null, "updateFeature", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(featureModifierEClass, null, "reset", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(integerNOPModifierEClass, IntegerNOPModifier.class, "IntegerNOPModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(integerRangeModifierEClass, IntegerRangeModifier.class, "IntegerRangeModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIntegerRangeModifier_StartValue(), ecorePackage.getEInt(), "startValue", "-99999999", 0, 1, IntegerRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getIntegerRangeModifier_EndValue(), ecorePackage.getEInt(), "endValue", "-99999999", 0, 1, IntegerRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getIntegerRangeModifier_Increment(), ecorePackage.getEInt(), "increment", "-99999999", 0, 1, IntegerRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getIntegerRangeModifier_NextValue(), ecorePackage.getEInt(), "nextValue", "-99999999", 0, 1, IntegerRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getIntegerRangeModifier_OriginalValue(), ecorePackage.getEInt(), "originalValue", null, 0, 1, IntegerRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(integerSequenceModifierEClass, IntegerSequenceModifier.class, "IntegerSequenceModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIntegerSequenceModifier_Sequence(), ecorePackage.getEIntegerObject(), "sequence", null, 0, -1, IntegerSequenceModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(longNOPModifierEClass, LongNOPModifier.class, "LongNOPModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(longRangeModifierEClass, LongRangeModifier.class, "LongRangeModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLongRangeModifier_StartValue(), ecorePackage.getELong(), "startValue", "-99999999", 0, 1, LongRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getLongRangeModifier_EndValue(), ecorePackage.getELong(), "endValue", "-99999999", 0, 1, LongRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getLongRangeModifier_Increment(), ecorePackage.getELong(), "increment", "-99999999", 0, 1, LongRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getLongRangeModifier_NextValue(), ecorePackage.getELong(), "nextValue", "-99999999", 0, 1, LongRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getLongRangeModifier_OriginalValue(), ecorePackage.getELong(), "originalValue", "-99999999", 0, 1, LongRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(longSequenceModifierEClass, LongSequenceModifier.class, "LongSequenceModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLongSequenceModifier_Sequence(), ecorePackage.getELongObject(), "sequence", null, 0, -1, LongSequenceModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modifierEClass, Modifier.class, "Modifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getModifier_TargetURI(), this.getURI(), "targetURI", null, 0, 1, Modifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModifier_FeatureModifiers(), this.getFeatureModifier(), null, "featureModifiers", null, 0, -1, Modifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getModifier_Complete(), ecorePackage.getEBoolean(), "complete", null, 0, 1, Modifier.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(modifierEClass, null, "updateScenario", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theScenarioPackage.getScenario(), "baseScenario", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(modifierEClass, null, "reset", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(nopModifierEClass, NOPModifier.class, "NOPModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(rangeModifierEClass, RangeModifier.class, "RangeModifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stemTimeNOPModifierEClass, STEMTimeNOPModifier.class, "STEMTimeNOPModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stemTimeRangeModifierEClass, STEMTimeRangeModifier.class, "STEMTimeRangeModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSTEMTimeRangeModifier_StartValue(), theModelPackage.getSTEMTime(), null, "startValue", null, 0, 1, STEMTimeRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSTEMTimeRangeModifier_EndValue(), theModelPackage.getSTEMTime(), null, "endValue", null, 0, 1, STEMTimeRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSTEMTimeRangeModifier_Increment(), ecorePackage.getELong(), "increment", null, 0, 1, STEMTimeRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSTEMTimeRangeModifier_NextValue(), theModelPackage.getSTEMTime(), null, "nextValue", null, 0, 1, STEMTimeRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSTEMTimeRangeModifier_OriginalValue(), theModelPackage.getSTEMTime(), null, "originalValue", null, 0, 1, STEMTimeRangeModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stemTimeSequenceModifierEClass, STEMTimeSequenceModifier.class, "STEMTimeSequenceModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSTEMTimeSequenceModifier_Sequence(), theModelPackage.getSTEMTime(), null, "sequence", null, 0, -1, STEMTimeSequenceModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sequenceModifierEClass, SequenceModifier.class, "SequenceModifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSequenceModifier_SequenceSize(), ecorePackage.getEInt(), "sequenceSize", null, 0, 1, SequenceModifier.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSequenceModifier_CurrentSequenceIndex(), ecorePackage.getEInt(), "currentSequenceIndex", "0", 0, 1, SequenceModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getSequenceModifier_NextValue(), ecorePackage.getEJavaObject(), "nextValue", null, 0, 1, SequenceModifier.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSequenceModifier_OriginalValue(), ecorePackage.getEJavaObject(), "originalValue", null, 0, 1, SequenceModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringNOPModifierEClass, StringNOPModifier.class, "StringNOPModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stringSequenceModifierEClass, StringSequenceModifier.class, "StringSequenceModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStringSequenceModifier_Sequence(), ecorePackage.getEString(), "sequence", null, 0, -1, StringSequenceModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modifiableEClass, Modifiable.class, "Modifiable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //ModifierPackageImpl
