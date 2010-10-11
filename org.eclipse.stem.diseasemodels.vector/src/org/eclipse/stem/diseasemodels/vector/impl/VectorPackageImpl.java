/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.vector.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.stem.diseasemodels.standard.StandardPackage;

import org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel;
import org.eclipse.stem.diseasemodels.vector.VectorDiseaseModel;
import org.eclipse.stem.diseasemodels.vector.VectorFactory;
import org.eclipse.stem.diseasemodels.vector.VectorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VectorPackageImpl extends EPackageImpl implements VectorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass macdonaldRossDiseaseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vectorDiseaseModelEClass = null;

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
	 * @see org.eclipse.stem.diseasemodels.vector.VectorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VectorPackageImpl() {
		super(eNS_URI, VectorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link VectorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VectorPackage init() {
		if (isInited) return (VectorPackage)EPackage.Registry.INSTANCE.getEPackage(VectorPackage.eNS_URI);

		// Obtain or create and register package
		VectorPackageImpl theVectorPackage = (VectorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VectorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VectorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theVectorPackage.createPackageContents();

		// Initialize created meta-data
		theVectorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVectorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VectorPackage.eNS_URI, theVectorPackage);
		return theVectorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMacdonaldRossDiseaseModel() {
		return macdonaldRossDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMacdonaldRossDiseaseModel_BitingRate() {
		return (EAttribute)macdonaldRossDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMacdonaldRossDiseaseModel_InfectiousBitingProportionHuman() {
		return (EAttribute)macdonaldRossDiseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMacdonaldRossDiseaseModel_InfectiousBitingProportionVector() {
		return (EAttribute)macdonaldRossDiseaseModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMacdonaldRossDiseaseModel_RecoveryRate() {
		return (EAttribute)macdonaldRossDiseaseModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMacdonaldRossDiseaseModel_VectorMortalityRate() {
		return (EAttribute)macdonaldRossDiseaseModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVectorDiseaseModel() {
		return vectorDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVectorDiseaseModel_VectorPopulationIdentifier() {
		return (EAttribute)vectorDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VectorFactory getVectorFactory() {
		return (VectorFactory)getEFactoryInstance();
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
		macdonaldRossDiseaseModelEClass = createEClass(MACDONALD_ROSS_DISEASE_MODEL);
		createEAttribute(macdonaldRossDiseaseModelEClass, MACDONALD_ROSS_DISEASE_MODEL__BITING_RATE);
		createEAttribute(macdonaldRossDiseaseModelEClass, MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_HUMAN);
		createEAttribute(macdonaldRossDiseaseModelEClass, MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_VECTOR);
		createEAttribute(macdonaldRossDiseaseModelEClass, MACDONALD_ROSS_DISEASE_MODEL__RECOVERY_RATE);
		createEAttribute(macdonaldRossDiseaseModelEClass, MACDONALD_ROSS_DISEASE_MODEL__VECTOR_MORTALITY_RATE);

		vectorDiseaseModelEClass = createEClass(VECTOR_DISEASE_MODEL);
		createEAttribute(vectorDiseaseModelEClass, VECTOR_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER);
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
		StandardPackage theStandardPackage = (StandardPackage)EPackage.Registry.INSTANCE.getEPackage(StandardPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		macdonaldRossDiseaseModelEClass.getESuperTypes().add(this.getVectorDiseaseModel());
		vectorDiseaseModelEClass.getESuperTypes().add(theStandardPackage.getStandardDiseaseModel());

		// Initialize classes and features; add operations and parameters
		initEClass(macdonaldRossDiseaseModelEClass, MacdonaldRossDiseaseModel.class, "MacdonaldRossDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMacdonaldRossDiseaseModel_BitingRate(), theEcorePackage.getEDouble(), "bitingRate", "0.5", 0, 1, MacdonaldRossDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMacdonaldRossDiseaseModel_InfectiousBitingProportionHuman(), theEcorePackage.getEDouble(), "infectiousBitingProportionHuman", "0.5", 0, 1, MacdonaldRossDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMacdonaldRossDiseaseModel_InfectiousBitingProportionVector(), theEcorePackage.getEDouble(), "infectiousBitingProportionVector", "1.0", 0, 1, MacdonaldRossDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMacdonaldRossDiseaseModel_RecoveryRate(), theEcorePackage.getEDouble(), "recoveryRate", "3.33E-3", 0, 1, MacdonaldRossDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMacdonaldRossDiseaseModel_VectorMortalityRate(), theEcorePackage.getEDouble(), "vectorMortalityRate", "0.05", 0, 1, MacdonaldRossDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vectorDiseaseModelEClass, VectorDiseaseModel.class, "VectorDiseaseModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVectorDiseaseModel_VectorPopulationIdentifier(), theEcorePackage.getEString(), "vectorPopulationIdentifier", "anopheles", 0, 1, VectorDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //VectorPackageImpl
