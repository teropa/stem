package org.eclipse.stem.graphgenerators;

/*******************************************************************************
* Copyright (c) 2010 IBM Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors: Armin Weiser, Matthias Filter
* Bundesinstitut f�r Risikobewertung
* FG 43 - Epidemiologie und Zoonosen
* Diedersdorfer Weg 1, 12277 Berlin
* 
* IBM Corporation - initial API and implementation
*******************************************************************************/

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pajek Net Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getDataFile_net <em>Data File net</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getArea <em>Area</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPajekNetGraphGenerator()
 * @model
 * @generated
 */
public interface PajekNetGraphGenerator extends GraphGenerator {
	/**
	 * Returns the value of the '<em><b>Data File net</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data File net</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data File net</em>' attribute.
	 * @see #setDataFile_net(String)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPajekNetGraphGenerator_DataFile_net()
	 * @model default=""
	 * @generated
	 */
	String getDataFile_net();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getDataFile_net <em>Data File net</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data File net</em>' attribute.
	 * @see #getDataFile_net()
	 * @generated
	 */
	void setDataFile_net(String value);

	/**
	 * Returns the value of the '<em><b>Area</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' attribute.
	 * @see #setArea(double)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPajekNetGraphGenerator_Area()
	 * @model default="100"
	 * @generated
	 */
	double getArea();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getArea <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' attribute.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(double value);

} // PajekNetGraphGenerator
