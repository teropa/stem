/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.stem.core.common.Identifiable;

import org.eclipse.stem.graphgenerators.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage
 * @generated
 */
public class GraphgeneratorsSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphgeneratorsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphgeneratorsSwitch() {
		if (modelPackage == null) {
			modelPackage = GraphgeneratorsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T1 doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GraphgeneratorsPackage.GRAPH_GENERATOR: {
				GraphGenerator graphGenerator = (GraphGenerator)theEObject;
				T1 result = caseGraphGenerator(graphGenerator);
				if (result == null) result = caseIdentifiable(graphGenerator);
				if (result == null) result = caseComparable(graphGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR: {
				LatticeGraphGenerator latticeGraphGenerator = (LatticeGraphGenerator)theEObject;
				T1 result = caseLatticeGraphGenerator(latticeGraphGenerator);
				if (result == null) result = caseGraphGenerator(latticeGraphGenerator);
				if (result == null) result = caseIdentifiable(latticeGraphGenerator);
				if (result == null) result = caseComparable(latticeGraphGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR: {
				SquareLatticeGraphGenerator squareLatticeGraphGenerator = (SquareLatticeGraphGenerator)theEObject;
				T1 result = caseSquareLatticeGraphGenerator(squareLatticeGraphGenerator);
				if (result == null) result = caseLatticeGraphGenerator(squareLatticeGraphGenerator);
				if (result == null) result = caseGraphGenerator(squareLatticeGraphGenerator);
				if (result == null) result = caseIdentifiable(squareLatticeGraphGenerator);
				if (result == null) result = caseComparable(squareLatticeGraphGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR: {
				MigrationEdgeGraphGenerator migrationEdgeGraphGenerator = (MigrationEdgeGraphGenerator)theEObject;
				T1 result = caseMigrationEdgeGraphGenerator(migrationEdgeGraphGenerator);
				if (result == null) result = caseGraphGenerator(migrationEdgeGraphGenerator);
				if (result == null) result = caseIdentifiable(migrationEdgeGraphGenerator);
				if (result == null) result = caseComparable(migrationEdgeGraphGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR: {
				PlateCarreeGlobeGraphGenerator plateCarreeGlobeGraphGenerator = (PlateCarreeGlobeGraphGenerator)theEObject;
				T1 result = casePlateCarreeGlobeGraphGenerator(plateCarreeGlobeGraphGenerator);
				if (result == null) result = caseLatticeGraphGenerator(plateCarreeGlobeGraphGenerator);
				if (result == null) result = caseGraphGenerator(plateCarreeGlobeGraphGenerator);
				if (result == null) result = caseIdentifiable(plateCarreeGlobeGraphGenerator);
				if (result == null) result = caseComparable(plateCarreeGlobeGraphGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphGenerator(GraphGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lattice Graph Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lattice Graph Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLatticeGraphGenerator(LatticeGraphGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Square Lattice Graph Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Square Lattice Graph Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSquareLatticeGraphGenerator(SquareLatticeGraphGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Migration Edge Graph Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Migration Edge Graph Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMigrationEdgeGraphGenerator(MigrationEdgeGraphGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plate Carree Globe Graph Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plate Carree Globe Graph Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePlateCarreeGlobeGraphGenerator(PlateCarreeGlobeGraphGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseComparable(Comparable<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T1 defaultCase(EObject object) {
		return null;
	}

} //GraphgeneratorsSwitch
