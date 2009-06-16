/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.experimental.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.diseasemodels.experimental.ExperimentalFactory;
import org.eclipse.stem.diseasemodels.experimental.ExperimentalPackage;
import org.eclipse.stem.diseasemodels.experimental.PercolationDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExperimentalPackageImpl extends EPackageImpl implements ExperimentalPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass PercolationDiseaseModelEClass = null;

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
	 * @see org.eclipse.stem.diseasemodels.experimental.ExperimentalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExperimentalPackageImpl() {
		super(eNS_URI, ExperimentalFactory.eINSTANCE);
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
	 * @return  ExperimentalPackate instance
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExperimentalPackage init() {
		if (isInited) return (ExperimentalPackage)EPackage.Registry.INSTANCE.getEPackage(ExperimentalPackage.eNS_URI);

		// Obtain or create and register package
		ExperimentalPackageImpl theExperimentalPackage = (ExperimentalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExperimentalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExperimentalPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		GraphPackage.eINSTANCE.eClass();
		LabelsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExperimentalPackage.createPackageContents();

		// Initialize created meta-data
		theExperimentalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExperimentalPackage.freeze();

		return theExperimentalPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return PercolationDiseaseModelEClass
	 * @generated
	 */
	public EClass getPercolationDiseaseModel() {
		return PercolationDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return ExperimentalFactory
	 * @generated
	 */
	public ExperimentalFactory getExperimentalFactory() {
		return (ExperimentalFactory)getEFactoryInstance();
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
		PercolationDiseaseModelEClass = createEClass(PERCOLATION_DISEASE_MODEL);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		PercolationDiseaseModelEClass.getESuperTypes().add(theStandardPackage.getStochasticSEIRDiseaseModel());

		// Initialize classes and features; add operations and parameters
		initEClass(PercolationDiseaseModelEClass, PercolationDiseaseModel.class, "PercolationDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ExperimentalPackageImpl
