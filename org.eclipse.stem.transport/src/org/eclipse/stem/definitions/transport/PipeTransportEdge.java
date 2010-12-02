package org.eclipse.stem.definitions.transport;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.definitions.edges.PopulationEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipe Transport Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.stem.definitions.transport.TransportPackage#getPipeTransportEdge()
 * @model
 * @generated
 */
public interface PipeTransportEdge extends PopulationEdge {
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * pipe transport edge URI.
	 */
	public String URI_TYPE_PIPE_TRANSPORT_EDGE_SEGMENT = URI_TYPE_EDGE_SEGMENT + "/pipetransport";

} // PipeTransportEdge
