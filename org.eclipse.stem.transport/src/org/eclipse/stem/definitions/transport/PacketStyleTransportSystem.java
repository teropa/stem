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

import org.eclipse.emf.common.util.EList;


/**
 * Packet style transport systems have dynamic edges connecting
 * them to different areas. They remain connected for a while, having 
 * only an influx of population (the loading phase), then are
 * disconnected for a small period (the transport phase), and finally
 * are connected to a destination for a defined period (the unloading phase)
 * 
 * @author jlessler
 *
 * @model
 */
public interface PacketStyleTransportSystem extends TransportSystem {

	/**
	 * 
	 */
	String URI_TYPE_PACKET_STYLE_TRANSPORT_SYSTEM = URI_TYPE_TRANSPORT_SYSTEM_NODE_SEGMENT 
	+ "/packet";
	
	/**
	 * This give a label that describes the behavior of this transport system
	 * 
	 * @return a label describing this system
	 * 
	 * @model
	 */
	PacketTransportLabel getPacketTransportLabel ();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.transport.PacketStyleTransportSystem#getPacketTransportLabel <em>Packet Transport Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Packet Transport Label</em>' reference.
	 * @see #getPacketTransportLabel()
	 * @generated
	 */
	void setPacketTransportLabel(PacketTransportLabel value);

	/**
	 * Gets the series of edges that the packet transport system will use to
	 * load the system. This is a list of migration edges that will be made
	 * active at the specified times in that edge.
	 * 
	 * @return a list of migration edges
	 * 
	 * @model
	 */
	EList<LoadUnloadEdge> getLoadingEdges();
			
	
	/**
	 * Gets the series of edges that the packet transport system will use to
	 * unload the system. This is a list of migration edges that will be made
	 * active at the specified times in that edge.
	 * 
	 * @return a list of migration edges
	 * 
	 * @model
	 */
	EList<LoadUnloadEdge> getUnloadingEdges();
		
	
}
	
