/**
 * <copyright>
 * </copyright>
 *
 * $Id: PipeTransportEdgeImpl.java,v 1.2 2009/04/11 11:10:20 sedlund Exp $
 */
package org.eclipse.stem.definitions.transport.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.impl.EdgeImpl;

import org.eclipse.stem.definitions.transport.PipeTransportEdge;
import org.eclipse.stem.definitions.transport.TransportFactory;
import org.eclipse.stem.definitions.transport.TransportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipe Transport Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PipeTransportEdgeImpl extends EdgeImpl implements PipeTransportEdge {
	
	/**
	 * This is used to generate unique URI's for each pipe transport edge generated
	 */
	static int pipeTransportEdgeCounter = 0;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected PipeTransportEdgeImpl() {
		super();
		//set the URI
		setURI(STEMURI.createURI(URI_TYPE_PIPE_TRANSPORT_EDGE_SEGMENT + "/"
				+ Integer.toString(pipeTransportEdgeCounter++)));
			
		//Make a label
		setLabel(TransportFactory.eINSTANCE.createPipeTransportEdgeLabel());				
		
		//this edge must be directed
		setDirected(true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.PIPE_TRANSPORT_EDGE;
	}

} //PipeTransportEdgeImpl
