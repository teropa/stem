package org.eclipse.stem.definitions.edges;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
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
import org.eclipse.emf.ecore.EReference;

import org.eclipse.stem.core.graph.GraphPackage;

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
 * @see org.eclipse.stem.definitions.edges.EdgesFactory
 * @model kind="package"
 * @generated
 */
public interface EdgesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "edges";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/definitions/edges.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.definitions.edges";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EdgesPackage eINSTANCE = org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.edges.impl.PopulationEdgeImpl <em>Population Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.edges.impl.PopulationEdgeImpl
	 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getPopulationEdge()
	 * @generated
	 */
	int POPULATION_EDGE = 6;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__URI = GraphPackage.EDGE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__TYPE_URI = GraphPackage.EDGE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__DUBLIN_CORE = GraphPackage.EDGE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__A = GraphPackage.EDGE__A;

	/**
	 * The feature id for the '<em><b>Node AURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__NODE_AURI = GraphPackage.EDGE__NODE_AURI;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__B = GraphPackage.EDGE__B;

	/**
	 * The feature id for the '<em><b>Node BURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__NODE_BURI = GraphPackage.EDGE__NODE_BURI;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__LABEL = GraphPackage.EDGE__LABEL;

	/**
	 * The feature id for the '<em><b>Directed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__DIRECTED = GraphPackage.EDGE__DIRECTED;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE__POPULATION_IDENTIFIER = GraphPackage.EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Population Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULATION_EDGE_FEATURE_COUNT = GraphPackage.EDGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.edges.impl.MigrationEdgeImpl <em>Migration Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.edges.impl.MigrationEdgeImpl
	 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMigrationEdge()
	 * @generated
	 */
	int MIGRATION_EDGE = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__URI = POPULATION_EDGE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__TYPE_URI = POPULATION_EDGE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__DUBLIN_CORE = POPULATION_EDGE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__A = POPULATION_EDGE__A;

	/**
	 * The feature id for the '<em><b>Node AURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__NODE_AURI = POPULATION_EDGE__NODE_AURI;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__B = POPULATION_EDGE__B;

	/**
	 * The feature id for the '<em><b>Node BURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__NODE_BURI = POPULATION_EDGE__NODE_BURI;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__LABEL = POPULATION_EDGE__LABEL;

	/**
	 * The feature id for the '<em><b>Directed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__DIRECTED = POPULATION_EDGE__DIRECTED;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE__POPULATION_IDENTIFIER = POPULATION_EDGE__POPULATION_IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Migration Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_FEATURE_COUNT = POPULATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelImpl <em>Migration Edge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelImpl
	 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMigrationEdgeLabel()
	 * @generated
	 */
	int MIGRATION_EDGE_LABEL = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL__URI = GraphPackage.EDGE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL__TYPE_URI = GraphPackage.EDGE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL__DUBLIN_CORE = GraphPackage.EDGE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL__CURRENT_VALUE = GraphPackage.EDGE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL__IDENTIFIABLE = GraphPackage.EDGE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL__EDGE = GraphPackage.EDGE_LABEL__EDGE;

	/**
	 * The number of structural features of the '<em>Migration Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL_FEATURE_COUNT = GraphPackage.EDGE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelValueImpl <em>Migration Edge Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelValueImpl
	 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMigrationEdgeLabelValue()
	 * @generated
	 */
	int MIGRATION_EDGE_LABEL_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Migration Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL_VALUE__MIGRATION_RATE = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Migration Edge Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_EDGE_LABEL_VALUE_FEATURE_COUNT = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.edges.impl.MixingEdgeImpl <em>Mixing Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.edges.impl.MixingEdgeImpl
	 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMixingEdge()
	 * @generated
	 */
	int MIXING_EDGE = 3;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__URI = POPULATION_EDGE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__TYPE_URI = POPULATION_EDGE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__DUBLIN_CORE = POPULATION_EDGE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__A = POPULATION_EDGE__A;

	/**
	 * The feature id for the '<em><b>Node AURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__NODE_AURI = POPULATION_EDGE__NODE_AURI;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__B = POPULATION_EDGE__B;

	/**
	 * The feature id for the '<em><b>Node BURI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__NODE_BURI = POPULATION_EDGE__NODE_BURI;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__LABEL = POPULATION_EDGE__LABEL;

	/**
	 * The feature id for the '<em><b>Directed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__DIRECTED = POPULATION_EDGE__DIRECTED;

	/**
	 * The feature id for the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE__POPULATION_IDENTIFIER = POPULATION_EDGE__POPULATION_IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Mixing Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_FEATURE_COUNT = POPULATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelImpl <em>Mixing Edge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelImpl
	 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMixingEdgeLabel()
	 * @generated
	 */
	int MIXING_EDGE_LABEL = 4;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL__URI = GraphPackage.EDGE_LABEL__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL__TYPE_URI = GraphPackage.EDGE_LABEL__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL__DUBLIN_CORE = GraphPackage.EDGE_LABEL__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>URI Of Identifiable To Be Labeled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED = GraphPackage.EDGE_LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL__CURRENT_VALUE = GraphPackage.EDGE_LABEL__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Identifiable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL__IDENTIFIABLE = GraphPackage.EDGE_LABEL__IDENTIFIABLE;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL__EDGE = GraphPackage.EDGE_LABEL__EDGE;

	/**
	 * The number of structural features of the '<em>Mixing Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL_FEATURE_COUNT = GraphPackage.EDGE_LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelValueImpl <em>Mixing Edge Label Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelValueImpl
	 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMixingEdgeLabelValue()
	 * @generated
	 */
	int MIXING_EDGE_LABEL_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Mixing Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL_VALUE__MIXING_RATE = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mixing Edge Label Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXING_EDGE_LABEL_VALUE_FEATURE_COUNT = GraphPackage.LABEL_VALUE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.edges.MigrationEdge <em>Migration Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Migration Edge</em>'.
	 * @see org.eclipse.stem.definitions.edges.MigrationEdge
	 * @generated
	 */
	EClass getMigrationEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.edges.MigrationEdgeLabel <em>Migration Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Migration Edge Label</em>'.
	 * @see org.eclipse.stem.definitions.edges.MigrationEdgeLabel
	 * @generated
	 */
	EClass getMigrationEdgeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue <em>Migration Edge Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Migration Edge Label Value</em>'.
	 * @see org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue
	 * @generated
	 */
	EClass getMigrationEdgeLabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue#getMigrationRate <em>Migration Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Migration Rate</em>'.
	 * @see org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue#getMigrationRate()
	 * @see #getMigrationEdgeLabelValue()
	 * @generated
	 */
	EAttribute getMigrationEdgeLabelValue_MigrationRate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.edges.MixingEdge <em>Mixing Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mixing Edge</em>'.
	 * @see org.eclipse.stem.definitions.edges.MixingEdge
	 * @generated
	 */
	EClass getMixingEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.edges.MixingEdgeLabel <em>Mixing Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mixing Edge Label</em>'.
	 * @see org.eclipse.stem.definitions.edges.MixingEdgeLabel
	 * @generated
	 */
	EClass getMixingEdgeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.edges.MixingEdgeLabelValue <em>Mixing Edge Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mixing Edge Label Value</em>'.
	 * @see org.eclipse.stem.definitions.edges.MixingEdgeLabelValue
	 * @generated
	 */
	EClass getMixingEdgeLabelValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.definitions.edges.MixingEdgeLabelValue#getMixingRate <em>Mixing Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mixing Rate</em>'.
	 * @see org.eclipse.stem.definitions.edges.MixingEdgeLabelValue#getMixingRate()
	 * @see #getMixingEdgeLabelValue()
	 * @generated
	 */
	EAttribute getMixingEdgeLabelValue_MixingRate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.definitions.edges.PopulationEdge <em>Population Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Population Edge</em>'.
	 * @see org.eclipse.stem.definitions.edges.PopulationEdge
	 * @generated
	 */
	EClass getPopulationEdge();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.definitions.edges.PopulationEdge#getPopulationIdentifier <em>Population Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population Identifier</em>'.
	 * @see org.eclipse.stem.definitions.edges.PopulationEdge#getPopulationIdentifier()
	 * @see #getPopulationEdge()
	 * @generated
	 */
	EAttribute getPopulationEdge_PopulationIdentifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EdgesFactory getEdgesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.edges.impl.MigrationEdgeImpl <em>Migration Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.edges.impl.MigrationEdgeImpl
		 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMigrationEdge()
		 * @generated
		 */
		EClass MIGRATION_EDGE = eINSTANCE.getMigrationEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelImpl <em>Migration Edge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelImpl
		 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMigrationEdgeLabel()
		 * @generated
		 */
		EClass MIGRATION_EDGE_LABEL = eINSTANCE.getMigrationEdgeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelValueImpl <em>Migration Edge Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelValueImpl
		 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMigrationEdgeLabelValue()
		 * @generated
		 */
		EClass MIGRATION_EDGE_LABEL_VALUE = eINSTANCE.getMigrationEdgeLabelValue();

		/**
		 * The meta object literal for the '<em><b>Migration Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION_EDGE_LABEL_VALUE__MIGRATION_RATE = eINSTANCE.getMigrationEdgeLabelValue_MigrationRate();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.edges.impl.MixingEdgeImpl <em>Mixing Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.edges.impl.MixingEdgeImpl
		 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMixingEdge()
		 * @generated
		 */
		EClass MIXING_EDGE = eINSTANCE.getMixingEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelImpl <em>Mixing Edge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelImpl
		 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMixingEdgeLabel()
		 * @generated
		 */
		EClass MIXING_EDGE_LABEL = eINSTANCE.getMixingEdgeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelValueImpl <em>Mixing Edge Label Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.edges.impl.MixingEdgeLabelValueImpl
		 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getMixingEdgeLabelValue()
		 * @generated
		 */
		EClass MIXING_EDGE_LABEL_VALUE = eINSTANCE.getMixingEdgeLabelValue();

		/**
		 * The meta object literal for the '<em><b>Mixing Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIXING_EDGE_LABEL_VALUE__MIXING_RATE = eINSTANCE.getMixingEdgeLabelValue_MixingRate();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.definitions.edges.impl.PopulationEdgeImpl <em>Population Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.definitions.edges.impl.PopulationEdgeImpl
		 * @see org.eclipse.stem.definitions.edges.impl.EdgesPackageImpl#getPopulationEdge()
		 * @generated
		 */
		EClass POPULATION_EDGE = eINSTANCE.getPopulationEdge();

		/**
		 * The meta object literal for the '<em><b>Population Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULATION_EDGE__POPULATION_IDENTIFIER = eINSTANCE.getPopulationEdge_PopulationIdentifier();

	}

} //EdgesPackage
