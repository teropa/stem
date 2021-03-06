/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.graphgenerators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.stem.graphgenerators.*;
import org.eclipse.stem.graphgenerators.GraphgeneratorsFactory;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator;
import org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphgeneratorsFactoryImpl extends EFactoryImpl implements GraphgeneratorsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphgeneratorsFactory init() {
		try {
			GraphgeneratorsFactory theGraphgeneratorsFactory = (GraphgeneratorsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/graphgenerators/graphgenerators.ecore"); 
			if (theGraphgeneratorsFactory != null) {
				return theGraphgeneratorsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphgeneratorsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphgeneratorsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR: return createSquareLatticeGraphGenerator();
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR: return createMigrationEdgeGraphGenerator();
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR: return createPlateCarreeGlobeGraphGenerator();
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR: return createPajekNetGraphGenerator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SquareLatticeGraphGenerator createSquareLatticeGraphGenerator() {
		SquareLatticeGraphGeneratorImpl squareLatticeGraphGenerator = new SquareLatticeGraphGeneratorImpl();
		return squareLatticeGraphGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationEdgeGraphGenerator createMigrationEdgeGraphGenerator() {
		MigrationEdgeGraphGeneratorImpl migrationEdgeGraphGenerator = new MigrationEdgeGraphGeneratorImpl();
		return migrationEdgeGraphGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlateCarreeGlobeGraphGenerator createPlateCarreeGlobeGraphGenerator() {
		PlateCarreeGlobeGraphGeneratorImpl plateCarreeGlobeGraphGenerator = new PlateCarreeGlobeGraphGeneratorImpl();
		return plateCarreeGlobeGraphGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PajekNetGraphGenerator createPajekNetGraphGenerator() {
		PajekNetGraphGeneratorImpl pajekNetGraphGenerator = new PajekNetGraphGeneratorImpl();
		return pajekNetGraphGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphgeneratorsPackage getGraphgeneratorsPackage() {
		return (GraphgeneratorsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphgeneratorsPackage getPackage() {
		return GraphgeneratorsPackage.eINSTANCE;
	}

} //GraphgeneratorsFactoryImpl
