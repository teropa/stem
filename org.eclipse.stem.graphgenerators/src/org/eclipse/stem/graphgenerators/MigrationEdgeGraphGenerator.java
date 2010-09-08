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

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Migration Edge Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getMigrationRate <em>Migration Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getPopulation <em>Population</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getMigrationEdgeGraphGenerator()
 * @model
 * @generated
 */
public interface MigrationEdgeGraphGenerator extends GraphGenerator {
	
	/** 
	 * Migration Edge Type
	 */
	public static final String MIGRATION_EDGE_TYPE="Migration Edges";
	
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(URI)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getMigrationEdgeGraphGenerator_Location()
	 * @model dataType="org.eclipse.stem.core.graph.URI"
	 * @generated
	 */
	URI getLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(URI value);

	/**
	 * Returns the value of the '<em><b>Migration Rate</b></em>' attribute.
	 * The default value is <code>"0.1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Migration Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Migration Rate</em>' attribute.
	 * @see #setMigrationRate(double)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getMigrationEdgeGraphGenerator_MigrationRate()
	 * @model default="0.1"
	 * @generated
	 */
	double getMigrationRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getMigrationRate <em>Migration Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Migration Rate</em>' attribute.
	 * @see #getMigrationRate()
	 * @generated
	 */
	void setMigrationRate(double value);

	/**
	 * Returns the value of the '<em><b>Population</b></em>' attribute.
	 * The default value is <code>"human"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population</em>' attribute.
	 * @see #setPopulation(String)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getMigrationEdgeGraphGenerator_Population()
	 * @model default="human"
	 * @generated
	 */
	String getPopulation();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator#getPopulation <em>Population</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population</em>' attribute.
	 * @see #getPopulation()
	 * @generated
	 */
	void setPopulation(String value);

	public IProject getProject();
	public void setProject(IProject p);
	
} // MigrationEdgeGraphGenerator
