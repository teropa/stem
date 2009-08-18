/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypesPackageImpl.java,v 1.1 2009/01/16 18:46:08 dford Exp $
 */
package org.eclipse.stem.definitions.types.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.stem.core.common.CommonPackage;

import org.eclipse.stem.core.graph.GraphPackage;

import org.eclipse.stem.core.model.ModelPackage;

import org.eclipse.stem.core.modifier.ModifierPackage;

import org.eclipse.stem.core.scenario.ScenarioPackage;

import org.eclipse.stem.core.sequencer.SequencerPackage;

import org.eclipse.stem.core.solver.SolverPackage;
import org.eclipse.stem.definitions.edges.EdgesPackage;

import org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl;

import org.eclipse.stem.definitions.labels.LabelsPackage;

import org.eclipse.stem.definitions.labels.impl.LabelsPackageImpl;

import org.eclipse.stem.definitions.nodes.NodesPackage;

import org.eclipse.stem.definitions.nodes.impl.NodesPackageImpl;

import org.eclipse.stem.definitions.types.CategorizedType;
import org.eclipse.stem.definitions.types.Rate;
import org.eclipse.stem.definitions.types.TypesFactory;
import org.eclipse.stem.definitions.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categorizedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rateEClass = null;

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
	 * @see org.eclipse.stem.definitions.types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl() {
		super(eNS_URI, TypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init() {
		if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GraphPackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		ModifierPackage.eINSTANCE.eClass();
		ScenarioPackage.eINSTANCE.eClass();
		SequencerPackage.eINSTANCE.eClass();
		SolverPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EdgesPackageImpl theEdgesPackage = (EdgesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EdgesPackage.eNS_URI) instanceof EdgesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EdgesPackage.eNS_URI) : EdgesPackage.eINSTANCE);
		LabelsPackageImpl theLabelsPackage = (LabelsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LabelsPackage.eNS_URI) instanceof LabelsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LabelsPackage.eNS_URI) : LabelsPackage.eINSTANCE);
		NodesPackageImpl theNodesPackage = (NodesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NodesPackage.eNS_URI) instanceof NodesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NodesPackage.eNS_URI) : NodesPackage.eINSTANCE);

		// Create package meta-data objects
		theTypesPackage.createPackageContents();
		theEdgesPackage.createPackageContents();
		theLabelsPackage.createPackageContents();
		theNodesPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();
		theEdgesPackage.initializePackageContents();
		theLabelsPackage.initializePackageContents();
		theNodesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategorizedType() {
		return categorizedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRate() {
		return rateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRate_Rate() {
		return (EAttribute)rateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactory getTypesFactory() {
		return (TypesFactory)getEFactoryInstance();
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
		categorizedTypeEClass = createEClass(CATEGORIZED_TYPE);

		rateEClass = createEClass(RATE);
		createEAttribute(rateEClass, RATE__RATE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(categorizedTypeEClass, CategorizedType.class, "CategorizedType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(rateEClass, Rate.class, "Rate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getRate_Rate(), ecorePackage.getEDouble(), "rate", null, 0, 1, Rate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //TypesPackageImpl
