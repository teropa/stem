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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plate Carree Globe Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getAngularStep <em>Angular Step</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getRadius <em>Radius</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPlateCarreeGlobeGraphGenerator()
 * @model
 * @generated
 */
public interface PlateCarreeGlobeGraphGenerator extends LatticeGraphGenerator {
	/**
	 * Returns the value of the '<em><b>Angular Step</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angular Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angular Step</em>' attribute.
	 * @see #setAngularStep(int)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPlateCarreeGlobeGraphGenerator_AngularStep()
	 * @model default="10"
	 * @generated
	 */
	int getAngularStep();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getAngularStep <em>Angular Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angular Step</em>' attribute.
	 * @see #getAngularStep()
	 * @generated
	 */
	void setAngularStep(int value);

	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * The default value is <code>"6371.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #setRadius(double)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPlateCarreeGlobeGraphGenerator_Radius()
	 * @model default="6371.0" required="true"
	 * @generated
	 */
	double getRadius();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(double value);

} // PlateCarreeGlobeGraphGenerator
