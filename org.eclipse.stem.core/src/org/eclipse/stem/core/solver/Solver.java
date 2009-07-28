/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.solver;

import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.core.common.Identifiable;

import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.STEMTime;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.solver.Solver#getDecorators <em>Decorators</em>}</li>
 *   <li>{@link org.eclipse.stem.core.solver.Solver#isInitialized <em>Initialized</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.core.solver.SolverPackage#getSolver()
 * @model
 * @generated
 */
public interface Solver extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Decorators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decorators</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorators</em>' attribute.
	 * @see #setDecorators(EList)
	 * @see org.eclipse.stem.core.solver.SolverPackage#getSolver_Decorators()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<Decorator> getDecorators();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.solver.Solver#getDecorators <em>Decorators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decorators</em>' attribute.
	 * @see #getDecorators()
	 * @generated
	 */
	void setDecorators(EList<Decorator> value);

	/**
	 * Returns the value of the '<em><b>Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized</em>' attribute.
	 * @see #setInitialized(boolean)
	 * @see org.eclipse.stem.core.solver.SolverPackage#getSolver_Initialized()
	 * @model
	 * @generated
	 */
	boolean isInitialized();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.solver.Solver#isInitialized <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized</em>' attribute.
	 * @see #isInitialized()
	 * @generated
	 */
	void setInitialized(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void step(STEMTime time, long timeDelta, int cycle);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void reset();

} // Solver
