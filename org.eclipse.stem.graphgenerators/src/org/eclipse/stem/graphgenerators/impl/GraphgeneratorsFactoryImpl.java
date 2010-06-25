/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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
