/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.simulation;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.stem.core.model.STEMTime;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.simulation.SimulationData#getCurrentTime <em>Current Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.core.simulation.SimulationPackage#getSimulationData()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface SimulationData extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Current Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Time</em>' reference.
	 * @see #setCurrentTime(STEMTime)
	 * @see org.eclipse.stem.core.simulation.SimulationPackage#getSimulationData_CurrentTime()
	 * @model
	 * @generated
	 */
	STEMTime getCurrentTime();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.simulation.SimulationData#getCurrentTime <em>Current Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Time</em>' reference.
	 * @see #getCurrentTime()
	 * @generated
	 */
	void setCurrentTime(STEMTime value);

} // SimulationData
