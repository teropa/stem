package org.eclipse.stem.definitions.transport;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabel;

/**
 * Label for loading and unloading edges. Has information about connection times, disconnection times, etc.
 * 
 * @author jlessler
 *
 *@model
 */
public interface LoadUnloadEdgeLabel extends MigrationEdgeLabel, DynamicLabel {
		
	
	/** Give these labels a special URI */	
	String URI_TYPE_LOAD_UNLOAD_EDGE_LABEL_SEGMENT = URI_TYPE_MIGRATION_RELATIONSHIP_LABEL_SEGMENT + "/loadUnload";
	
	/**
	 * 
	 */
	URI URI_TYPE_LOAD_UNLOAD_EDGE_LABEL = STEMURI.createTypeURI(URI_TYPE_LOAD_UNLOAD_EDGE_LABEL_SEGMENT);
	
	/**
	 * get the activation time for this edge, that is when loading/unloading starts
	 * @return time of activation
	 * 
	 * @model*/
	STEMTime getActivationTime();
	
	/**
	 * Get the activated rate. The rate of this edge when not active is 0. This
	 * rate is based on the capacity of the PacketTransportSystem being loaded
	 * or unloaded, so it needs to be normalized before being passed on to the
	 * disease models.
	 * 
	 * @return the rate of load or unload compared to the packet transport
	 *         system when activated.
	 * 
	 * @model
	 */
	double getActivatedRate();
	
	/**
	 * Gets the activated rate normalized for the size of the population being
	 * loaded/unloaded.
	 * 
	 * @return the normalized rate.
	 */
	double getNormalizedActivatedRate();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.transport.LoadUnloadEdgeLabel#getActivatedRate <em>Activated Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activated Rate</em>' attribute.
	 * @see #getActivatedRate()
	 * @generated
	 */
	void setActivatedRate(double value);

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.transport.LoadUnloadEdgeLabel#getActivationTime <em>Activation Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activation Time</em>' reference.
	 * @see #getActivationTime()
	 * @generated
	 */
	void setActivationTime(STEMTime value);


	/**
	 * Get the deactivation time for this edge, that is when loading/unloading
	 * ends.
	 * 
	 * @return the time of deactivation
	 * 
	 * @model
	 */
	STEMTime getDeactivationTime();


	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.transport.LoadUnloadEdgeLabel#getDeactivationTime <em>Deactivation Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deactivation Time</em>' reference.
	 * @see #getDeactivationTime()
	 * @generated
	 */
	void setDeactivationTime(STEMTime value);
	
	
}
