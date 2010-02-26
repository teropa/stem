/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.multipopulation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationFactory;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage;

import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultipopulationPackageImpl extends EPackageImpl implements MultipopulationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiPopulationSIDiseaseModelEClass = null;

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
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MultipopulationPackageImpl() {
		super(eNS_URI, MultipopulationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MultipopulationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MultipopulationPackage init() {
		if (isInited) return (MultipopulationPackage)EPackage.Registry.INSTANCE.getEPackage(MultipopulationPackage.eNS_URI);

		// Obtain or create and register package
		MultipopulationPackageImpl theMultipopulationPackage = (MultipopulationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MultipopulationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MultipopulationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMultipopulationPackage.createPackageContents();

		// Initialize created meta-data
		theMultipopulationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMultipopulationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MultipopulationPackage.eNS_URI, theMultipopulationPackage);
		return theMultipopulationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiPopulationSIDiseaseModel() {
		return multiPopulationSIDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiPopulationSIDiseaseModel_TransmissionRate() {
		return (EReference)multiPopulationSIDiseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiPopulationSIDiseaseModel_RecoveryRate() {
		return (EReference)multiPopulationSIDiseaseModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiPopulationSIDiseaseModel_InfectiousMortalityRate() {
		return (EReference)multiPopulationSIDiseaseModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiPopulationSIDiseaseModel_PhysicallyAdjacentInfectiousProportion() {
		return (EAttribute)multiPopulationSIDiseaseModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiPopulationSIDiseaseModel_RoadNetworkInfectiousProportion() {
		return (EAttribute)multiPopulationSIDiseaseModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiPopulationSIDiseaseModel_PopulationGroups() {
		return (EReference)multiPopulationSIDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipopulationFactory getMultipopulationFactory() {
		return (MultipopulationFactory)getEFactoryInstance();
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
		multiPopulationSIDiseaseModelEClass = createEClass(MULTI_POPULATION_SI_DISEASE_MODEL);
		createEReference(multiPopulationSIDiseaseModelEClass, MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS);
		createEReference(multiPopulationSIDiseaseModelEClass, MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE);
		createEReference(multiPopulationSIDiseaseModelEClass, MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE);
		createEReference(multiPopulationSIDiseaseModelEClass, MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE);
		createEAttribute(multiPopulationSIDiseaseModelEClass, MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION);
		createEAttribute(multiPopulationSIDiseaseModelEClass, MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION);
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
		StandardPackage theStandardPackage = (StandardPackage)EPackage.Registry.INSTANCE.getEPackage(StandardPackage.eNS_URI);
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		multiPopulationSIDiseaseModelEClass.getESuperTypes().add(theStandardPackage.getStandardDiseaseModel());

		// Initialize classes and features; add operations and parameters
		initEClass(multiPopulationSIDiseaseModelEClass, MultiPopulationSIDiseaseModel.class, "MultiPopulationSIDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiPopulationSIDiseaseModel_PopulationGroups(), theCommonPackage.getStringValueList(), null, "populationGroups", null, 1, 1, MultiPopulationSIDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiPopulationSIDiseaseModel_TransmissionRate(), theCommonPackage.getDoubleValueMatrix(), null, "transmissionRate", null, 1, 1, MultiPopulationSIDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiPopulationSIDiseaseModel_RecoveryRate(), theCommonPackage.getDoubleValueList(), null, "recoveryRate", null, 1, 1, MultiPopulationSIDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiPopulationSIDiseaseModel_InfectiousMortalityRate(), theCommonPackage.getDoubleValueList(), null, "infectiousMortalityRate", null, 1, 1, MultiPopulationSIDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiPopulationSIDiseaseModel_PhysicallyAdjacentInfectiousProportion(), theEcorePackage.getEDouble(), "physicallyAdjacentInfectiousProportion", null, 0, 1, MultiPopulationSIDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiPopulationSIDiseaseModel_RoadNetworkInfectiousProportion(), theEcorePackage.getEDouble(), "roadNetworkInfectiousProportion", null, 0, 1, MultiPopulationSIDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MultipopulationPackageImpl
