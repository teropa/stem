/**
 * <copyright>
 * </copyright>
 *
 * $Id: PipeTransportEdge.java,v 1.2 2009/04/11 11:10:20 sedlund Exp $
 */
package org.eclipse.stem.definitions.transport;

import org.eclipse.stem.core.graph.Edge;

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
public interface PipeTransportEdge extends Edge {
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * pipe transport edge URI.
	 */
	public String URI_TYPE_PIPE_TRANSPORT_EDGE_SEGMENT = URI_TYPE_EDGE_SEGMENT + "/pipetransport";

} // PipeTransportEdge
