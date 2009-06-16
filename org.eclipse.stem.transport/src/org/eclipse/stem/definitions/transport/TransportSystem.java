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

import org.eclipse.stem.core.graph.Node;

/**
 * Node representing the transport system.
 * 
 * @author jlessler
 *
 * @model abstract="true"
 */
public interface TransportSystem extends Node {
	
	/**
	 * 
	 */
	String URI_TYPE_TRANSPORT_SYSTEM_NODE_SEGMENT = URI_TYPE_NODE_SEGMENT
		+ "/transport";
}
