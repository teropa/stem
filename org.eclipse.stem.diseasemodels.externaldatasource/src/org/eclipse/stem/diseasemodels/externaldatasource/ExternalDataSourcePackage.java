// ExternalDataSourcePackage 
package org.eclipse.stem.diseasemodels.externaldatasource;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceFactory
 * @model kind="package"
 * @generated
 */
public interface ExternalDataSourcePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "externaldatasource";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/diseasemodels/externaldatasource.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.diseasemodels.externaldatasource";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExternalDataSourcePackage eINSTANCE = org.eclipse.stem.diseasemodels.externaldatasource.impl.ExternalDataSourcePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.diseasemodels.externaldatasource.impl.ExternalDataSourceDiseaseModelImpl <em>Disease Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.externaldatasource.impl.ExternalDataSourceDiseaseModelImpl
	 * @see org.eclipse.stem.diseasemodels.externaldatasource.impl.ExternalDataSourcePackageImpl#getExternalDataSourceDiseaseModel()
	 * @generated
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__URI = StandardPackage.DISEASE_MODEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__TYPE_URI = StandardPackage.DISEASE_MODEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DUBLIN_CORE = StandardPackage.DISEASE_MODEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__LABELS_TO_UPDATE = StandardPackage.DISEASE_MODEL__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__GRAPH = StandardPackage.DISEASE_MODEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__ENABLED = StandardPackage.DISEASE_MODEL__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__GRAPH_DECORATED = StandardPackage.DISEASE_MODEL__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Background Mortality Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__BACKGROUND_MORTALITY_RATE = StandardPackage.DISEASE_MODEL__BACKGROUND_MORTALITY_RATE;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__POPULATION_IDENTIFIER = StandardPackage.DISEASE_MODEL__POPULATION_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__TIME_PERIOD = StandardPackage.DISEASE_MODEL__TIME_PERIOD;

	/**
	 * The feature id for the '<em><b>Disease Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DISEASE_NAME = StandardPackage.DISEASE_MODEL__DISEASE_NAME;

	/**
	 * The feature id for the '<em><b>Data Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DATA_PATH = StandardPackage.DISEASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Disease Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DISEASE_TYPE = StandardPackage.DISEASE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Disease Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_DATA_SOURCE_DISEASE_MODEL_FEATURE_COUNT = StandardPackage.DISEASE_MODEL_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel <em>Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disease Model</em>'.
	 * @see org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel
	 * @generated
	 */
	EClass getExternalDataSourceDiseaseModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel#getDataPath <em>Data Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Path</em>'.
	 * @see org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel#getDataPath()
	 * @see #getExternalDataSourceDiseaseModel()
	 * @generated
	 */
	EAttribute getExternalDataSourceDiseaseModel_DataPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel#getDiseaseType <em>Disease Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disease Type</em>'.
	 * @see org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel#getDiseaseType()
	 * @see #getExternalDataSourceDiseaseModel()
	 * @generated
	 */
	EAttribute getExternalDataSourceDiseaseModel_DiseaseType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExternalDataSourceFactory getExternalDataSourceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.diseasemodels.externaldatasource.impl.ExternalDataSourceDiseaseModelImpl <em>Disease Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.diseasemodels.externaldatasource.impl.ExternalDataSourceDiseaseModelImpl
		 * @see org.eclipse.stem.diseasemodels.externaldatasource.impl.ExternalDataSourcePackageImpl#getExternalDataSourceDiseaseModel()
		 * @generated
		 */
		EClass EXTERNAL_DATA_SOURCE_DISEASE_MODEL = eINSTANCE.getExternalDataSourceDiseaseModel();

		/**
		 * The meta object literal for the '<em><b>Data Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DATA_PATH = eINSTANCE.getExternalDataSourceDiseaseModel_DataPath();

		/**
		 * The meta object literal for the '<em><b>Disease Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DISEASE_TYPE = eINSTANCE.getExternalDataSourceDiseaseModel_DiseaseType();

	}

} //ExternalDataSourcePackage
