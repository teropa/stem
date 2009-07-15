package org.eclipse.stem.diseasemodels.standard.impl;

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

import java.util.Random;
//import java.util.Map;

import org.eclipse.emf.common.util.EList;

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
import org.eclipse.stem.core.common.SanityChecker;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.solver.SolverPackage;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.sequencer.SequencerPackage;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.diseasemodels.standard.AggregatingDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.AggregatingSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.AggregatingSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DeterministicSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DeterministicSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SIDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SIRInoculator;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardInfector;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StandardPackageImpl extends EPackageImpl implements StandardPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deterministicSEIRDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deterministicSIDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deterministicSIRDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diseaseModelLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diseaseModelLabelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diseaseModelStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seirEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seirLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seirLabelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass siEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass siDiseaseModelStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass siInfectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass siLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass siLabelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sirEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sirLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sirLabelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardDiseaseModelLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardDiseaseModelLabelValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardDiseaseModelStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardInfectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stochasticSEIRDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stochasticSIDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stochasticSIRDiseaseModelEClass = null;

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
	private EClass aggregatingSIDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatingDiseaseModelStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatingSEIRDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatingSIRDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stochasticDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardStochasticDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sirInoculatorEClass = null;

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
	private EDataType eListEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType randomEDataType = null;

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
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StandardPackageImpl() {
		super(eNS_URI, StandardFactory.eINSTANCE);
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
	public static StandardPackage init() {
		if (isInited) return (StandardPackage)EPackage.Registry.INSTANCE.getEPackage(StandardPackage.eNS_URI);

		// Obtain or create and register package
		StandardPackageImpl theStandardPackage = (StandardPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof StandardPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new StandardPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		LabelsPackage.eINSTANCE.eClass();
		SolverPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStandardPackage.createPackageContents();

		// Initialize created meta-data
		theStandardPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStandardPackage.freeze();

		return theStandardPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeterministicSEIRDiseaseModel() {
		return deterministicSEIRDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeterministicSIDiseaseModel() {
		return deterministicSIDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeterministicSIRDiseaseModel() {
		return deterministicSIRDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiseaseModel() {
		return diseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_BackgroundMortalityRate() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_PopulationIdentifier() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_TimePeriod() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_DiseaseName() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_StepSize() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_CurrentX() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_RelativeTolerance() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_FiniteDifference() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_FrequencyDependent() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModel_BackgroundBirthRate() {
		return (EAttribute)diseaseModelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiseaseModelLabel() {
		return diseaseModelLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiseaseModelLabel_PopulationLabel() {
		return (EReference)diseaseModelLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiseaseModelLabel_DiseaseModelState() {
		return (EReference)diseaseModelLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiseaseModelLabel_CurrentDiseaseModelLabelValue() {
		return (EReference)diseaseModelLabelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiseaseModelLabel_NextDiseaseModelLabelValue() {
		return (EReference)diseaseModelLabelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiseaseModelLabel_DeltaValue() {
		return (EReference)diseaseModelLabelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiseaseModelLabel_CurrentY() {
		return (EReference)diseaseModelLabelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiseaseModelLabel_CurrentDiseaseModelTempLabelValue() {
		return (EReference)diseaseModelLabelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiseaseModelLabel_YScale() {
		return (EReference)diseaseModelLabelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiseaseModelLabelValue() {
		return diseaseModelLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModelLabelValue_Births() {
		return (EAttribute)diseaseModelLabelValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModelLabelValue_Deaths() {
		return (EAttribute)diseaseModelLabelValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModelLabelValue_DiseaseDeaths() {
		return (EAttribute)diseaseModelLabelValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModelLabelValue_PopulationCount() {
		return (EAttribute)diseaseModelLabelValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiseaseModelLabelValue_Incidence() {
		return (EAttribute)diseaseModelLabelValueEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiseaseModelState() {
		return diseaseModelStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiseaseModelState_Label() {
		return (EReference)diseaseModelStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfector() {
		return infectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfector_DiseaseModel() {
		return (EReference)infectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInfector_TargetURI() {
		return (EAttribute)infectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInfector_DiseaseName() {
		return (EAttribute)infectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInfector_TargetISOKey() {
		return (EAttribute)infectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfector_LabelsToInfect() {
		return (EReference)infectorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInfector_PopulationIdentifier() {
		return (EAttribute)infectorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSEIR() {
		return seirEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSEIR_IncubationRate() {
		return (EAttribute)seirEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSEIRLabel() {
		return seirLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSEIRLabel_CurrentSEIRValue() {
		return (EReference)seirLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSEIRLabel_NextSEIRValue() {
		return (EReference)seirLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSEIRLabelValue() {
		return seirLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSEIRLabelValue_E() {
		return (EAttribute)seirLabelValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSI() {
		return siEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSI_TransmissionRate() {
		return (EAttribute)siEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSI_NonLinearityCoefficient() {
		return (EAttribute)siEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSI_RecoveryRate() {
		return (EAttribute)siEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSI_InfectiousMortalityRate() {
		return (EAttribute)siEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSI_PhysicallyAdjacentInfectiousProportion() {
		return (EAttribute)siEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSI_RoadNetworkInfectiousProportion() {
		return (EAttribute)siEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSI_InfectiousMortality() {
		return (EAttribute)siEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIDiseaseModelState() {
		return siDiseaseModelStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIInfector() {
		return siInfectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSIInfector_InfectiousCount() {
		return (EAttribute)siInfectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSILabel() {
		return siLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSILabel_CurrentSIValue() {
		return (EReference)siLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSILabel_NextSIValue() {
		return (EReference)siLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSILabelValue() {
		return siLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSILabelValue_I() {
		return (EAttribute)siLabelValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIR() {
		return sirEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSIR_ImmunityLossRate() {
		return (EAttribute)sirEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIRLabel() {
		return sirLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSIRLabel_CurrentSIRValue() {
		return (EReference)sirLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSIRLabel_NextSIRValue() {
		return (EReference)sirLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIRLabelValue() {
		return sirLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSIRLabelValue_R() {
		return (EAttribute)sirLabelValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardDiseaseModel() {
		return standardDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardDiseaseModel_TotalPopulationCount() {
		return (EAttribute)standardDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardDiseaseModel_TotalPopulationCountReciprocal() {
		return (EAttribute)standardDiseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardDiseaseModel_TotalArea() {
		return (EAttribute)standardDiseaseModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardDiseaseModel_ReferencePopulationDensity() {
		return (EAttribute)standardDiseaseModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardDiseaseModelLabel() {
		return standardDiseaseModelLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardDiseaseModelLabel_CurrentStandardDiseaseModelLabelValue() {
		return (EReference)standardDiseaseModelLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardDiseaseModelLabel_NextStandardDiseaseModelLabelValue() {
		return (EReference)standardDiseaseModelLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardDiseaseModelLabel_DeltaStandardDiseaseModelLabelValue() {
		return (EReference)standardDiseaseModelLabelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardDiseaseModelLabel_CurrentYStandardDiseaseModelLabelValue() {
		return (EReference)standardDiseaseModelLabelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardDiseaseModelLabelValue() {
		return standardDiseaseModelLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardDiseaseModelLabelValue_S() {
		return (EAttribute)standardDiseaseModelLabelValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardDiseaseModelState() {
		return standardDiseaseModelStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardDiseaseModelState_AreaRatio() {
		return (EAttribute)standardDiseaseModelStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardInfector() {
		return standardInfectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStochasticSEIRDiseaseModel() {
		return stochasticSEIRDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStochasticSIDiseaseModel() {
		return stochasticSIDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStochasticSIRDiseaseModel() {
		return stochasticSIRDiseaseModelEClass;
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
	public EClass getAggregatingSIDiseaseModel() {
		return aggregatingSIDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregatingDiseaseModelState() {
		return aggregatingDiseaseModelStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatingDiseaseModelState_ChildrensLabels() {
		return (EReference)aggregatingDiseaseModelStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregatingSEIRDiseaseModel() {
		return aggregatingSEIRDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregatingSIRDiseaseModel() {
		return aggregatingSIRDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStochasticDiseaseModel() {
		return stochasticDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStochasticDiseaseModel_Seed() {
		return (EAttribute)stochasticDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStochasticDiseaseModel_RandomGenerator() {
		return (EAttribute)stochasticDiseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardStochasticDiseaseModel() {
		return standardStochasticDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardStochasticDiseaseModel_Gain() {
		return (EAttribute)standardStochasticDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIRInoculator() {
		return sirInoculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSIRInoculator_InoculatedPercentage() {
		return (EAttribute)sirInoculatorEClass.getEStructuralFeatures().get(0);
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
	public EDataType getEList() {
		return eListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRandom() {
		return randomEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardFactory getStandardFactory() {
		return (StandardFactory)getEFactoryInstance();
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
		deterministicSEIRDiseaseModelEClass = createEClass(DETERMINISTIC_SEIR_DISEASE_MODEL);

		deterministicSIDiseaseModelEClass = createEClass(DETERMINISTIC_SI_DISEASE_MODEL);

		deterministicSIRDiseaseModelEClass = createEClass(DETERMINISTIC_SIR_DISEASE_MODEL);

		diseaseModelEClass = createEClass(DISEASE_MODEL);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__BACKGROUND_MORTALITY_RATE);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__POPULATION_IDENTIFIER);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__TIME_PERIOD);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__DISEASE_NAME);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__STEP_SIZE);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__CURRENT_X);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__RELATIVE_TOLERANCE);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__FINITE_DIFFERENCE);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__FREQUENCY_DEPENDENT);
		createEAttribute(diseaseModelEClass, DISEASE_MODEL__BACKGROUND_BIRTH_RATE);

		diseaseModelLabelEClass = createEClass(DISEASE_MODEL_LABEL);
		createEReference(diseaseModelLabelEClass, DISEASE_MODEL_LABEL__POPULATION_LABEL);
		createEReference(diseaseModelLabelEClass, DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE);
		createEReference(diseaseModelLabelEClass, DISEASE_MODEL_LABEL__CURRENT_DISEASE_MODEL_LABEL_VALUE);
		createEReference(diseaseModelLabelEClass, DISEASE_MODEL_LABEL__NEXT_DISEASE_MODEL_LABEL_VALUE);
		createEReference(diseaseModelLabelEClass, DISEASE_MODEL_LABEL__DELTA_VALUE);
		createEReference(diseaseModelLabelEClass, DISEASE_MODEL_LABEL__CURRENT_Y);
		createEReference(diseaseModelLabelEClass, DISEASE_MODEL_LABEL__CURRENT_DISEASE_MODEL_TEMP_LABEL_VALUE);
		createEReference(diseaseModelLabelEClass, DISEASE_MODEL_LABEL__YSCALE);

		diseaseModelLabelValueEClass = createEClass(DISEASE_MODEL_LABEL_VALUE);
		createEAttribute(diseaseModelLabelValueEClass, DISEASE_MODEL_LABEL_VALUE__BIRTHS);
		createEAttribute(diseaseModelLabelValueEClass, DISEASE_MODEL_LABEL_VALUE__DEATHS);
		createEAttribute(diseaseModelLabelValueEClass, DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS);
		createEAttribute(diseaseModelLabelValueEClass, DISEASE_MODEL_LABEL_VALUE__POPULATION_COUNT);
		createEAttribute(diseaseModelLabelValueEClass, DISEASE_MODEL_LABEL_VALUE__INCIDENCE);

		diseaseModelStateEClass = createEClass(DISEASE_MODEL_STATE);
		createEReference(diseaseModelStateEClass, DISEASE_MODEL_STATE__LABEL);

		infectorEClass = createEClass(INFECTOR);
		createEReference(infectorEClass, INFECTOR__DISEASE_MODEL);
		createEAttribute(infectorEClass, INFECTOR__TARGET_URI);
		createEAttribute(infectorEClass, INFECTOR__DISEASE_NAME);
		createEAttribute(infectorEClass, INFECTOR__TARGET_ISO_KEY);
		createEReference(infectorEClass, INFECTOR__LABELS_TO_INFECT);
		createEAttribute(infectorEClass, INFECTOR__POPULATION_IDENTIFIER);

		seirEClass = createEClass(SEIR);
		createEAttribute(seirEClass, SEIR__INCUBATION_RATE);

		seirLabelEClass = createEClass(SEIR_LABEL);
		createEReference(seirLabelEClass, SEIR_LABEL__CURRENT_SEIR_VALUE);
		createEReference(seirLabelEClass, SEIR_LABEL__NEXT_SEIR_VALUE);

		seirLabelValueEClass = createEClass(SEIR_LABEL_VALUE);
		createEAttribute(seirLabelValueEClass, SEIR_LABEL_VALUE__E);

		siEClass = createEClass(SI);
		createEAttribute(siEClass, SI__TRANSMISSION_RATE);
		createEAttribute(siEClass, SI__NON_LINEARITY_COEFFICIENT);
		createEAttribute(siEClass, SI__RECOVERY_RATE);
		createEAttribute(siEClass, SI__INFECTIOUS_MORTALITY_RATE);
		createEAttribute(siEClass, SI__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION);
		createEAttribute(siEClass, SI__ROAD_NETWORK_INFECTIOUS_PROPORTION);
		createEAttribute(siEClass, SI__INFECTIOUS_MORTALITY);

		siDiseaseModelStateEClass = createEClass(SI_DISEASE_MODEL_STATE);

		siInfectorEClass = createEClass(SI_INFECTOR);
		createEAttribute(siInfectorEClass, SI_INFECTOR__INFECTIOUS_COUNT);

		siLabelEClass = createEClass(SI_LABEL);
		createEReference(siLabelEClass, SI_LABEL__CURRENT_SI_VALUE);
		createEReference(siLabelEClass, SI_LABEL__NEXT_SI_VALUE);

		siLabelValueEClass = createEClass(SI_LABEL_VALUE);
		createEAttribute(siLabelValueEClass, SI_LABEL_VALUE__I);

		sirEClass = createEClass(SIR);
		createEAttribute(sirEClass, SIR__IMMUNITY_LOSS_RATE);

		sirLabelEClass = createEClass(SIR_LABEL);
		createEReference(sirLabelEClass, SIR_LABEL__CURRENT_SIR_VALUE);
		createEReference(sirLabelEClass, SIR_LABEL__NEXT_SIR_VALUE);

		sirLabelValueEClass = createEClass(SIR_LABEL_VALUE);
		createEAttribute(sirLabelValueEClass, SIR_LABEL_VALUE__R);

		standardDiseaseModelEClass = createEClass(STANDARD_DISEASE_MODEL);
		createEAttribute(standardDiseaseModelEClass, STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT);
		createEAttribute(standardDiseaseModelEClass, STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL);
		createEAttribute(standardDiseaseModelEClass, STANDARD_DISEASE_MODEL__TOTAL_AREA);
		createEAttribute(standardDiseaseModelEClass, STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY);

		standardDiseaseModelLabelEClass = createEClass(STANDARD_DISEASE_MODEL_LABEL);
		createEReference(standardDiseaseModelLabelEClass, STANDARD_DISEASE_MODEL_LABEL__CURRENT_STANDARD_DISEASE_MODEL_LABEL_VALUE);
		createEReference(standardDiseaseModelLabelEClass, STANDARD_DISEASE_MODEL_LABEL__NEXT_STANDARD_DISEASE_MODEL_LABEL_VALUE);
		createEReference(standardDiseaseModelLabelEClass, STANDARD_DISEASE_MODEL_LABEL__DELTA_STANDARD_DISEASE_MODEL_LABEL_VALUE);
		createEReference(standardDiseaseModelLabelEClass, STANDARD_DISEASE_MODEL_LABEL__CURRENT_YSTANDARD_DISEASE_MODEL_LABEL_VALUE);

		standardDiseaseModelLabelValueEClass = createEClass(STANDARD_DISEASE_MODEL_LABEL_VALUE);
		createEAttribute(standardDiseaseModelLabelValueEClass, STANDARD_DISEASE_MODEL_LABEL_VALUE__S);

		standardDiseaseModelStateEClass = createEClass(STANDARD_DISEASE_MODEL_STATE);
		createEAttribute(standardDiseaseModelStateEClass, STANDARD_DISEASE_MODEL_STATE__AREA_RATIO);

		standardInfectorEClass = createEClass(STANDARD_INFECTOR);

		stochasticSEIRDiseaseModelEClass = createEClass(STOCHASTIC_SEIR_DISEASE_MODEL);

		stochasticSIDiseaseModelEClass = createEClass(STOCHASTIC_SI_DISEASE_MODEL);

		stochasticSIRDiseaseModelEClass = createEClass(STOCHASTIC_SIR_DISEASE_MODEL);

		sanityCheckerEClass = createEClass(SANITY_CHECKER);

		aggregatingSIDiseaseModelEClass = createEClass(AGGREGATING_SI_DISEASE_MODEL);

		aggregatingDiseaseModelStateEClass = createEClass(AGGREGATING_DISEASE_MODEL_STATE);
		createEReference(aggregatingDiseaseModelStateEClass, AGGREGATING_DISEASE_MODEL_STATE__CHILDRENS_LABELS);

		aggregatingSEIRDiseaseModelEClass = createEClass(AGGREGATING_SEIR_DISEASE_MODEL);

		aggregatingSIRDiseaseModelEClass = createEClass(AGGREGATING_SIR_DISEASE_MODEL);

		stochasticDiseaseModelEClass = createEClass(STOCHASTIC_DISEASE_MODEL);
		createEAttribute(stochasticDiseaseModelEClass, STOCHASTIC_DISEASE_MODEL__SEED);
		createEAttribute(stochasticDiseaseModelEClass, STOCHASTIC_DISEASE_MODEL__RANDOM_GENERATOR);

		standardStochasticDiseaseModelEClass = createEClass(STANDARD_STOCHASTIC_DISEASE_MODEL);
		createEAttribute(standardStochasticDiseaseModelEClass, STANDARD_STOCHASTIC_DISEASE_MODEL__GAIN);

		sirInoculatorEClass = createEClass(SIR_INOCULATOR);
		createEAttribute(sirInoculatorEClass, SIR_INOCULATOR__INOCULATED_PERCENTAGE);

		// Create data types
		uriEDataType = createEDataType(URI);
		eListEDataType = createEDataType(ELIST);
		randomEDataType = createEDataType(RANDOM);
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
		ModifierPackage theModifierPackage = (ModifierPackage)EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);
		LabelsPackage theLabelsPackage = (LabelsPackage)EPackage.Registry.INSTANCE.getEPackage(LabelsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		deterministicSEIRDiseaseModelEClass.getESuperTypes().add(this.getSEIR());
		deterministicSIDiseaseModelEClass.getESuperTypes().add(this.getSI());
		deterministicSIRDiseaseModelEClass.getESuperTypes().add(this.getSIR());
		diseaseModelEClass.getESuperTypes().add(theModelPackage.getNodeDecorator());
		diseaseModelEClass.getESuperTypes().add(this.getSanityChecker());
		diseaseModelEClass.getESuperTypes().add(theModifierPackage.getModifiable());
		diseaseModelLabelEClass.getESuperTypes().add(theGraphPackage.getDynamicNodeLabel());
		diseaseModelLabelValueEClass.getESuperTypes().add(theGraphPackage.getLabelValue());
		infectorEClass.getESuperTypes().add(theModelPackage.getNodeDecorator());
		seirEClass.getESuperTypes().add(this.getSIR());
		seirLabelEClass.getESuperTypes().add(this.getSIRLabel());
		seirLabelValueEClass.getESuperTypes().add(this.getSIRLabelValue());
		siEClass.getESuperTypes().add(this.getStandardDiseaseModel());
		siDiseaseModelStateEClass.getESuperTypes().add(this.getStandardDiseaseModelState());
		siInfectorEClass.getESuperTypes().add(this.getStandardInfector());
		siLabelEClass.getESuperTypes().add(this.getStandardDiseaseModelLabel());
		siLabelValueEClass.getESuperTypes().add(this.getStandardDiseaseModelLabelValue());
		sirEClass.getESuperTypes().add(this.getSI());
		sirLabelEClass.getESuperTypes().add(this.getSILabel());
		sirLabelValueEClass.getESuperTypes().add(this.getSILabelValue());
		standardDiseaseModelEClass.getESuperTypes().add(this.getDiseaseModel());
		standardDiseaseModelLabelEClass.getESuperTypes().add(this.getDiseaseModelLabel());
		standardDiseaseModelLabelValueEClass.getESuperTypes().add(this.getDiseaseModelLabelValue());
		standardDiseaseModelStateEClass.getESuperTypes().add(this.getDiseaseModelState());
		standardInfectorEClass.getESuperTypes().add(this.getInfector());
		stochasticSEIRDiseaseModelEClass.getESuperTypes().add(this.getSEIR());
		stochasticSEIRDiseaseModelEClass.getESuperTypes().add(this.getStandardStochasticDiseaseModel());
		stochasticSIDiseaseModelEClass.getESuperTypes().add(this.getSI());
		stochasticSIDiseaseModelEClass.getESuperTypes().add(this.getStandardStochasticDiseaseModel());
		stochasticSIRDiseaseModelEClass.getESuperTypes().add(this.getSIR());
		stochasticSIRDiseaseModelEClass.getESuperTypes().add(this.getStandardStochasticDiseaseModel());
		aggregatingSIDiseaseModelEClass.getESuperTypes().add(this.getSI());
		aggregatingDiseaseModelStateEClass.getESuperTypes().add(this.getDiseaseModelState());
		aggregatingSEIRDiseaseModelEClass.getESuperTypes().add(this.getAggregatingSIRDiseaseModel());
		aggregatingSIRDiseaseModelEClass.getESuperTypes().add(this.getAggregatingSIDiseaseModel());
		stochasticDiseaseModelEClass.getESuperTypes().add(this.getDiseaseModel());
		standardStochasticDiseaseModelEClass.getESuperTypes().add(this.getStochasticDiseaseModel());
		sirInoculatorEClass.getESuperTypes().add(this.getSIInfector());

		// Initialize classes and features; add operations and parameters
		initEClass(deterministicSEIRDiseaseModelEClass, DeterministicSEIRDiseaseModel.class, "DeterministicSEIRDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(deterministicSIDiseaseModelEClass, DeterministicSIDiseaseModel.class, "DeterministicSIDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(deterministicSIRDiseaseModelEClass, DeterministicSIRDiseaseModel.class, "DeterministicSIRDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(diseaseModelEClass, DiseaseModel.class, "DiseaseModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDiseaseModel_BackgroundMortalityRate(), ecorePackage.getEDouble(), "backgroundMortalityRate", "5.5E-5", 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModel_PopulationIdentifier(), ecorePackage.getEString(), "populationIdentifier", "human", 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModel_TimePeriod(), ecorePackage.getELong(), "timePeriod", "86400000", 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModel_DiseaseName(), ecorePackage.getEString(), "diseaseName", null, 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDiseaseModel_StepSize(), ecorePackage.getEDouble(), "stepSize", "1.0", 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModel_CurrentX(), ecorePackage.getEDouble(), "currentX", "0.0", 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModel_RelativeTolerance(), ecorePackage.getEDouble(), "relativeTolerance", "1E-9", 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModel_FiniteDifference(), ecorePackage.getEBoolean(), "finiteDifference", "true", 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModel_FrequencyDependent(), ecorePackage.getEBoolean(), "frequencyDependent", "true", 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModel_BackgroundBirthRate(), theEcorePackage.getEDouble(), "backgroundBirthRate", "5.5E-5", 0, 1, DiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		EOperation op = addEOperation(diseaseModelEClass, ecorePackage.getEDouble(), "getAdjustedBackgroundMortalityRate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getELong(), "timeDelta", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(diseaseModelEClass, this.getDiseaseModelLabel(), "createDiseaseModelLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(diseaseModelEClass, this.getDiseaseModelLabelValue(), "createDiseaseModelLabelValue", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(diseaseModelEClass, this.getDiseaseModelState(), "createDiseaseModelState", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(diseaseModelEClass, this.getDiseaseModelState(), "initializeDiseaseState", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getDiseaseModelState(), "diseaseModelState", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getDiseaseModelLabel(), "diseaseModelLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(diseaseModelEClass, null, "initializeDiseaseState", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getDiseaseModelLabel(), "diseaseModelLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(diseaseModelEClass, this.getInfector(), "createInfector", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(diseaseModelEClass, theEcorePackage.getEDouble(), "getAdjustedBackgroundBirthRate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getELong(), "timeDelta", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(diseaseModelLabelEClass, DiseaseModelLabel.class, "DiseaseModelLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDiseaseModelLabel_PopulationLabel(), theLabelsPackage.getPopulationLabel(), null, "populationLabel", null, 0, 1, DiseaseModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDiseaseModelLabel_DiseaseModelState(), this.getDiseaseModelState(), this.getDiseaseModelState_Label(), "diseaseModelState", null, 0, 1, DiseaseModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDiseaseModelLabel_CurrentDiseaseModelLabelValue(), this.getDiseaseModelLabelValue(), null, "currentDiseaseModelLabelValue", null, 0, 1, DiseaseModelLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDiseaseModelLabel_NextDiseaseModelLabelValue(), this.getDiseaseModelLabelValue(), null, "nextDiseaseModelLabelValue", null, 0, 1, DiseaseModelLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDiseaseModelLabel_DeltaValue(), this.getDiseaseModelLabelValue(), null, "deltaValue", null, 0, 1, DiseaseModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDiseaseModelLabel_CurrentY(), this.getDiseaseModelLabelValue(), null, "currentY", null, 0, 1, DiseaseModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDiseaseModelLabel_CurrentDiseaseModelTempLabelValue(), this.getDiseaseModelLabelValue(), null, "currentDiseaseModelTempLabelValue", null, 0, 1, DiseaseModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDiseaseModelLabel_YScale(), this.getDiseaseModelLabelValue(), null, "yScale", null, 0, 1, DiseaseModelLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(diseaseModelLabelValueEClass, DiseaseModelLabelValue.class, "DiseaseModelLabelValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDiseaseModelLabelValue_Births(), ecorePackage.getEDouble(), "births", "0", 0, 1, DiseaseModelLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModelLabelValue_Deaths(), ecorePackage.getEDouble(), "deaths", "0", 0, 1, DiseaseModelLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModelLabelValue_DiseaseDeaths(), ecorePackage.getEDouble(), "diseaseDeaths", "0", 0, 1, DiseaseModelLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDiseaseModelLabelValue_PopulationCount(), ecorePackage.getEDouble(), "populationCount", null, 0, 1, DiseaseModelLabelValue.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDiseaseModelLabelValue_Incidence(), ecorePackage.getEDouble(), "incidence", null, 0, 1, DiseaseModelLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(diseaseModelLabelValueEClass, this.getDiseaseModelLabelValue(), "set", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getDiseaseModelLabelValue(), "value", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(diseaseModelLabelValueEClass, this.getDiseaseModelLabelValue(), "add", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getDiseaseModelLabelValue(), "value", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(diseaseModelLabelValueEClass, this.getDiseaseModelLabelValue(), "sub", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getDiseaseModelLabelValue(), "value", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(diseaseModelLabelValueEClass, this.getDiseaseModelLabelValue(), "scale", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEDouble(), "scaleFactor", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(diseaseModelLabelValueEClass, null, "zeroOutPopulationCount", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(diseaseModelStateEClass, DiseaseModelState.class, "DiseaseModelState", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDiseaseModelState_Label(), this.getDiseaseModelLabel(), this.getDiseaseModelLabel_DiseaseModelState(), "label", null, 0, 1, DiseaseModelState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(infectorEClass, Infector.class, "Infector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getInfector_DiseaseModel(), this.getStandardDiseaseModel(), null, "diseaseModel", null, 0, 1, Infector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInfector_TargetURI(), this.getURI(), "targetURI", null, 0, 1, Infector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInfector_DiseaseName(), ecorePackage.getEString(), "diseaseName", null, 0, 1, Infector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInfector_TargetISOKey(), ecorePackage.getEString(), "targetISOKey", null, 0, 1, Infector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInfector_LabelsToInfect(), this.getDiseaseModelLabel(), null, "labelsToInfect", null, 0, -1, Infector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInfector_PopulationIdentifier(), ecorePackage.getEString(), "populationIdentifier", null, 0, 1, Infector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(seirEClass, org.eclipse.stem.diseasemodels.standard.SEIR.class, "SEIR", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSEIR_IncubationRate(), ecorePackage.getEDouble(), "incubationRate", "0.0", 0, 1, org.eclipse.stem.diseasemodels.standard.SEIR.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		op = addEOperation(seirEClass, ecorePackage.getEDouble(), "getAdjustedIncubationRate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getELong(), "timeDelta", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(seirLabelEClass, SEIRLabel.class, "SEIRLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSEIRLabel_CurrentSEIRValue(), this.getSEIRLabelValue(), null, "currentSEIRValue", null, 0, 1, SEIRLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSEIRLabel_NextSEIRValue(), this.getSEIRLabelValue(), null, "nextSEIRValue", null, 0, 1, SEIRLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(seirLabelValueEClass, SEIRLabelValue.class, "SEIRLabelValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSEIRLabelValue_E(), ecorePackage.getEDouble(), "e", null, 0, 1, SEIRLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(siEClass, org.eclipse.stem.diseasemodels.standard.SI.class, "SI", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSI_TransmissionRate(), ecorePackage.getEDouble(), "transmissionRate", "0.0", 0, 1, org.eclipse.stem.diseasemodels.standard.SI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getSI_NonLinearityCoefficient(), ecorePackage.getEDouble(), "nonLinearityCoefficient", "1.0", 0, 1, org.eclipse.stem.diseasemodels.standard.SI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getSI_RecoveryRate(), ecorePackage.getEDouble(), "recoveryRate", "0.0", 0, 1, org.eclipse.stem.diseasemodels.standard.SI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getSI_InfectiousMortalityRate(), ecorePackage.getEDouble(), "infectiousMortalityRate", "0.0", 0, 1, org.eclipse.stem.diseasemodels.standard.SI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getSI_PhysicallyAdjacentInfectiousProportion(), ecorePackage.getEDouble(), "physicallyAdjacentInfectiousProportion", "0.05", 0, 1, org.eclipse.stem.diseasemodels.standard.SI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getSI_RoadNetworkInfectiousProportion(), ecorePackage.getEDouble(), "roadNetworkInfectiousProportion", "0.01", 0, 1, org.eclipse.stem.diseasemodels.standard.SI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getSI_InfectiousMortality(), theEcorePackage.getEDouble(), "infectiousMortality", null, 0, 1, org.eclipse.stem.diseasemodels.standard.SI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(siEClass, ecorePackage.getEDouble(), "getAdjustedInfectiousMortalityRate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getELong(), "timeDelta", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(siEClass, ecorePackage.getEDouble(), "getAdjustedTransmissionRate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getELong(), "timeDelta", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(siEClass, ecorePackage.getEDouble(), "getAdjustedRecoveryRate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getELong(), "timeDelta", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(siEClass, ecorePackage.getEDouble(), "getEffectiveInfectious", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theGraphPackage.getNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getStandardDiseaseModelLabel(), "diseaseLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEDouble(), "onsiteInfectious", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(siEClass, ecorePackage.getEDouble(), "getNormalizedEffectiveInfectious", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theGraphPackage.getNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getStandardDiseaseModelLabel(), "diseaseLabel", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEDouble(), "onsiteInfectious", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(siDiseaseModelStateEClass, SIDiseaseModelState.class, "SIDiseaseModelState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(siInfectorEClass, SIInfector.class, "SIInfector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSIInfector_InfectiousCount(), ecorePackage.getEDouble(), "infectiousCount", "1", 0, 1, SIInfector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(siLabelEClass, SILabel.class, "SILabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSILabel_CurrentSIValue(), this.getSILabelValue(), null, "currentSIValue", null, 0, 1, SILabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSILabel_NextSIValue(), this.getSILabelValue(), null, "nextSIValue", null, 0, 1, SILabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(siLabelValueEClass, SILabelValue.class, "SILabelValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSILabelValue_I(), ecorePackage.getEDouble(), "i", null, 0, 1, SILabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sirEClass, org.eclipse.stem.diseasemodels.standard.SIR.class, "SIR", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSIR_ImmunityLossRate(), ecorePackage.getEDouble(), "immunityLossRate", "0.0", 0, 1, org.eclipse.stem.diseasemodels.standard.SIR.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		op = addEOperation(sirEClass, ecorePackage.getEDouble(), "getAdjustedImmunityLossRate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getELong(), "timeDelta", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(sirLabelEClass, SIRLabel.class, "SIRLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSIRLabel_CurrentSIRValue(), this.getSIRLabelValue(), null, "currentSIRValue", null, 0, 1, SIRLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSIRLabel_NextSIRValue(), this.getSIRLabelValue(), null, "nextSIRValue", null, 0, 1, SIRLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(sirLabelValueEClass, SIRLabelValue.class, "SIRLabelValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSIRLabelValue_R(), ecorePackage.getEDouble(), "r", null, 0, 1, SIRLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(standardDiseaseModelEClass, StandardDiseaseModel.class, "StandardDiseaseModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStandardDiseaseModel_TotalPopulationCount(), ecorePackage.getEDouble(), "totalPopulationCount", "0", 0, 1, StandardDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getStandardDiseaseModel_TotalPopulationCountReciprocal(), ecorePackage.getEDouble(), "totalPopulationCountReciprocal", null, 0, 1, StandardDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStandardDiseaseModel_TotalArea(), ecorePackage.getEDouble(), "totalArea", "0", 0, 1, StandardDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getStandardDiseaseModel_ReferencePopulationDensity(), ecorePackage.getEDouble(), "referencePopulationDensity", "100", 0, 1, StandardDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		op = addEOperation(standardDiseaseModelEClass, null, "addToTotalPopulationCount", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEDouble(), "populationCount", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(standardDiseaseModelEClass, ecorePackage.getEDouble(), "computeTotalPopulationCountReciprocal", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(standardDiseaseModelEClass, null, "addToTotalArea", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEDouble(), "area", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(standardDiseaseModelEClass, null, "calculateDelta", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theModelPackage.getSTEMTime(), "time", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getELong(), "timeDelta", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		EGenericType g1 = createEGenericType(theEcorePackage.getEEList());
		EGenericType g2 = createEGenericType(theGraphPackage.getDynamicLabel());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "labels", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(standardDiseaseModelEClass, null, "doModelSpecificAdjustments", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getStandardDiseaseModelLabelValue(), "label", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(standardDiseaseModelLabelEClass, StandardDiseaseModelLabel.class, "StandardDiseaseModelLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getStandardDiseaseModelLabel_CurrentStandardDiseaseModelLabelValue(), this.getStandardDiseaseModelLabelValue(), null, "currentStandardDiseaseModelLabelValue", null, 0, 1, StandardDiseaseModelLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getStandardDiseaseModelLabel_NextStandardDiseaseModelLabelValue(), this.getStandardDiseaseModelLabelValue(), null, "nextStandardDiseaseModelLabelValue", null, 0, 1, StandardDiseaseModelLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getStandardDiseaseModelLabel_DeltaStandardDiseaseModelLabelValue(), this.getStandardDiseaseModelLabelValue(), null, "deltaStandardDiseaseModelLabelValue", null, 0, 1, StandardDiseaseModelLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getStandardDiseaseModelLabel_CurrentYStandardDiseaseModelLabelValue(), this.getStandardDiseaseModelLabelValue(), null, "currentYStandardDiseaseModelLabelValue", null, 0, 1, StandardDiseaseModelLabel.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(standardDiseaseModelLabelValueEClass, StandardDiseaseModelLabelValue.class, "StandardDiseaseModelLabelValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStandardDiseaseModelLabelValue_S(), ecorePackage.getEDouble(), "s", null, 0, 1, StandardDiseaseModelLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(standardDiseaseModelStateEClass, StandardDiseaseModelState.class, "StandardDiseaseModelState", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStandardDiseaseModelState_AreaRatio(), ecorePackage.getEDouble(), "areaRatio", null, 0, 1, StandardDiseaseModelState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(standardInfectorEClass, StandardInfector.class, "StandardInfector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stochasticSEIRDiseaseModelEClass, StochasticSEIRDiseaseModel.class, "StochasticSEIRDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stochasticSIDiseaseModelEClass, StochasticSIDiseaseModel.class, "StochasticSIDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stochasticSIRDiseaseModelEClass, StochasticSIRDiseaseModel.class, "StochasticSIRDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(sanityCheckerEClass, SanityChecker.class, "SanityChecker", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(aggregatingSIDiseaseModelEClass, AggregatingSIDiseaseModel.class, "AggregatingSIDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(aggregatingDiseaseModelStateEClass, AggregatingDiseaseModelState.class, "AggregatingDiseaseModelState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAggregatingDiseaseModelState_ChildrensLabels(), this.getSILabel(), null, "childrensLabels", null, 0, -1, AggregatingDiseaseModelState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(aggregatingSEIRDiseaseModelEClass, AggregatingSEIRDiseaseModel.class, "AggregatingSEIRDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(aggregatingSIRDiseaseModelEClass, AggregatingSIRDiseaseModel.class, "AggregatingSIRDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stochasticDiseaseModelEClass, StochasticDiseaseModel.class, "StochasticDiseaseModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStochasticDiseaseModel_Seed(), ecorePackage.getELong(), "seed", "0", 0, 1, StochasticDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getStochasticDiseaseModel_RandomGenerator(), this.getRandom(), "randomGenerator", "0", 0, 1, StochasticDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(standardStochasticDiseaseModelEClass, StandardStochasticDiseaseModel.class, "StandardStochasticDiseaseModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStandardStochasticDiseaseModel_Gain(), ecorePackage.getEDouble(), "gain", "0.01", 0, 1, StandardStochasticDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		addEOperation(standardStochasticDiseaseModelEClass, ecorePackage.getEDouble(), "computeNoise", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(sirInoculatorEClass, SIRInoculator.class, "SIRInoculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSIRInoculator_InoculatedPercentage(), ecorePackage.getEDouble(), "inoculatedPercentage", "1", 0, 1, SIRInoculator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(eListEDataType, EList.class, "EList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(randomEDataType, Random.class, "Random", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //StandardPackageImpl
