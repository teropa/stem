/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.solvers.rk;

import org.eclipse.stem.core.solver.Solver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runge Kutta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.solvers.rk.RungeKutta#getRelativeTolerance <em>Relative Tolerance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.solvers.rk.RkPackage#getRungeKutta()
 * @model
 * @generated
 */
public interface RungeKutta extends Solver {
	/**
	 * Returns the value of the '<em><b>Relative Tolerance</b></em>' attribute.
	 * The default value is <code>"1E-9"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative Tolerance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relative Tolerance</em>' attribute.
	 * @see #setRelativeTolerance(double)
	 * @see org.eclipse.stem.solvers.rk.RkPackage#getRungeKutta_RelativeTolerance()
	 * @model default="1E-9"
	 * @generated
	 */
	double getRelativeTolerance();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.solvers.rk.RungeKutta#getRelativeTolerance <em>Relative Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Tolerance</em>' attribute.
	 * @see #getRelativeTolerance()
	 * @generated
	 */
	void setRelativeTolerance(double value);

} // RungeKutta
