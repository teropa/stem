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
package org.eclipse.stem.graphgenerators;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Square Lattice Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getXSize <em>XSize</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getYSize <em>YSize</em>}</li>
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
	 * Returns the value of the '<em><b>XSize</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSize</em>' attribute.
	 * @see #setXSize(int)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getSquareLatticeGraphGenerator_XSize()
	 * @model default="10"
	 * @generated
	 */
	int getXSize();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getXSize <em>XSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XSize</em>' attribute.
	 * @see #getXSize()
	 * @generated
	 */
	void setXSize(int value);

	/**
	 * Returns the value of the '<em><b>YSize</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YSize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YSize</em>' attribute.
	 * @see #setYSize(int)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getSquareLatticeGraphGenerator_YSize()
	 * @model default="10"
	 * @generated
	 */
	int getYSize();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator#getYSize <em>YSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YSize</em>' attribute.
	 * @see #getYSize()
	 * @generated
	 */
	void setYSize(int value);

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
