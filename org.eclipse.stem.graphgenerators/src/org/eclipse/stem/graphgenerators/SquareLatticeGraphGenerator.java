/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Square Lattice Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getArea <em>Area</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getSquareLatticeGraphGenerator()
 * @model
 * @generated
 */
public interface SquareLatticeGraphGenerator extends LatticeGraphGenerator {

	/**
	 * Returns the value of the '<em><b>Area</b></em>' attribute.
	 * The default value is <code>"2025"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' attribute.
	 * @see #setArea(double)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getSquareLatticeGraphGenerator_Area()
	 * @model default="2025"
	 * @generated
	 */
	double getArea();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getArea <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' attribute.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(double value);
} // SquareLatticeGraphGenerator
