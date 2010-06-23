/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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

	public IProject getProject();
	public void setProject(IProject p);
	
} // MigrationEdgeGraphGenerator
