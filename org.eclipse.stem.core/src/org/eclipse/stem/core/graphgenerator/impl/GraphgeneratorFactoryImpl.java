/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.graphgenerator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.stem.core.graphgenerator.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphgeneratorFactoryImpl extends EFactoryImpl implements GraphgeneratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphgeneratorFactory init() {
		try {
			GraphgeneratorFactory theGraphgeneratorFactory = (GraphgeneratorFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/core/graphgenerator.ecore"); //$NON-NLS-1$ 
			if (theGraphgeneratorFactory != null) {
				return theGraphgeneratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphgeneratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphgeneratorFactoryImpl() {
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
			case GraphgeneratorPackage.SQUARE_GRAPH_LATTICE_GENERATOR: return createSquareGraphLatticeGenerator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SquareGraphLatticeGenerator createSquareGraphLatticeGenerator() {
		SquareGraphLatticeGeneratorImpl squareGraphLatticeGenerator = new SquareGraphLatticeGeneratorImpl();
		return squareGraphLatticeGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphgeneratorPackage getGraphgeneratorPackage() {
		return (GraphgeneratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphgeneratorPackage getPackage() {
		return GraphgeneratorPackage.eINSTANCE;
	}

} //GraphgeneratorFactoryImpl
