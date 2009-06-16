package org.eclipse.stem.definitions.transport.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.stem.definitions.transport.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransportFactoryImpl extends EFactoryImpl implements TransportFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransportFactory init() {
		try {
			TransportFactory theTransportFactory = (TransportFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/definitions/transport.ecore"); 
			if (theTransportFactory != null) {
				return theTransportFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TransportFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TransportPackage.LOAD_UNLOAD_EDGE: return createLoadUnloadEdge();
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL: return createLoadUnloadEdgeLabel();
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM: return createPacketStyleTransportSystem();
			case TransportPackage.PACKET_TRANSPORT_LABEL: return createPacketTransportLabel();
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM: return createPipeStyleTransportSystem();
			case TransportPackage.PACKET_TRANSPORT_LABEL_VALUE: return createPacketTransportLabelValue();
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM_DECORATOR: return createPacketStyleTransportSystemDecorator();
			case TransportPackage.PIPE_TRANSPORT_EDGE: return createPipeTransportEdge();
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL: return createPipeTransportEdgeLabel();
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE: return createPipeTransportEdgeLabelValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadUnloadEdge createLoadUnloadEdge() {
		LoadUnloadEdgeImpl loadUnloadEdge = new LoadUnloadEdgeImpl();
		return loadUnloadEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadUnloadEdgeLabel createLoadUnloadEdgeLabel() {
		LoadUnloadEdgeLabelImpl loadUnloadEdgeLabel = new LoadUnloadEdgeLabelImpl();
		return loadUnloadEdgeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketStyleTransportSystem createPacketStyleTransportSystem() {
		PacketStyleTransportSystemImpl packetStyleTransportSystem = new PacketStyleTransportSystemImpl();
		return packetStyleTransportSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketTransportLabel createPacketTransportLabel() {
		PacketTransportLabelImpl packetTransportLabel = new PacketTransportLabelImpl();
		return packetTransportLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeStyleTransportSystem createPipeStyleTransportSystem() {
		PipeStyleTransportSystemImpl pipeStyleTransportSystem = new PipeStyleTransportSystemImpl();
		return pipeStyleTransportSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketTransportLabelValue createPacketTransportLabelValue() {
		PacketTransportLabelValueImpl packetTransportLabelValue = new PacketTransportLabelValueImpl();
		return packetTransportLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketStyleTransportSystemDecorator createPacketStyleTransportSystemDecorator() {
		PacketStyleTransportSystemDecoratorImpl packetStyleTransportSystemDecorator = new PacketStyleTransportSystemDecoratorImpl();
		return packetStyleTransportSystemDecorator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeTransportEdge createPipeTransportEdge() {
		PipeTransportEdgeImpl pipeTransportEdge = new PipeTransportEdgeImpl();
		return pipeTransportEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeTransportEdgeLabel createPipeTransportEdgeLabel() {
		PipeTransportEdgeLabelImpl pipeTransportEdgeLabel = new PipeTransportEdgeLabelImpl();
		return pipeTransportEdgeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeTransportEdgeLabelValue createPipeTransportEdgeLabelValue() {
		PipeTransportEdgeLabelValueImpl pipeTransportEdgeLabelValue = new PipeTransportEdgeLabelValueImpl();
		return pipeTransportEdgeLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportPackage getTransportPackage() {
		return (TransportPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TransportPackage getPackage() {
		return TransportPackage.eINSTANCE;
	}

} //TransportFactoryImpl
