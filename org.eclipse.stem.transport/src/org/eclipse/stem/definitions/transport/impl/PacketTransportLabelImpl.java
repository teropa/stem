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

import org.eclipse.stem.core.graph.impl.NodeLabelImpl;


import org.eclipse.stem.definitions.transport.PacketTransportLabel;
import org.eclipse.stem.definitions.transport.PacketTransportLabelValue;
import org.eclipse.stem.definitions.transport.TransportFactory;
import org.eclipse.stem.definitions.transport.TransportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Packet Transport Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PacketTransportLabelImpl extends NodeLabelImpl implements PacketTransportLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected PacketTransportLabelImpl() {
		super();		
		
		//Set the label value
		this.setCurrentValue(TransportFactory.eINSTANCE.createPacketTransportLabelValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.PACKET_TRANSPORT_LABEL;
	}
	
	

	/**Make the current  value stuff have to be PacketTransportLabelValues
	 * */
	public PacketTransportLabelValue getCurrentValue() {
		return (PacketTransportLabelValue)super.getCurrentValue();
	}
	public void setCurrentValue(PacketTransportLabelValue val) {
		super.setCurrentValue(val);
	}
	
	
} //PacketTransportLabelImpl
