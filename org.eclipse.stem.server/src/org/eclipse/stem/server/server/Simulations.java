/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.server.server;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.stem.core.scenario.Scenario;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.server.server.Simulations#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.server.server.ServerPackage#getSimulations()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Simulations extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.stem.core.scenario.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenarios</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' reference list.
	 * @see org.eclipse.stem.server.server.ServerPackage#getSimulations_Scenarios()
	 * @model
	 * @generated
	 */
	EList<Scenario> getScenarios();

} // Simulations
