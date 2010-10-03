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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.definitions.transport.LoadUnloadEdge;
import org.eclipse.stem.definitions.transport.PacketStyleTransportSystem;
import org.eclipse.stem.definitions.transport.PacketTransportLabel;
import org.eclipse.stem.definitions.transport.TransportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Packet Style Transport System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.PacketStyleTransportSystemImpl#getPacketTransportLabel <em>Packet Transport Label</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.PacketStyleTransportSystemImpl#getLoadingEdges <em>Loading Edges</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.PacketStyleTransportSystemImpl#getUnloadingEdges <em>Unloading Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PacketStyleTransportSystemImpl extends TransportSystemImpl implements PacketStyleTransportSystem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected PacketStyleTransportSystemImpl() {
		super();
				
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.PACKET_STYLE_TRANSPORT_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketTransportLabel getPacketTransportLabel() {
		return (PacketTransportLabel)eDynamicGet(TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL, TransportPackage.Literals.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketTransportLabel basicGetPacketTransportLabel() {
		return (PacketTransportLabel)eDynamicGet(TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL, TransportPackage.Literals.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPacketTransportLabel(PacketTransportLabel newPacketTransportLabel) {
		eDynamicSet(TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL, TransportPackage.Literals.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL, newPacketTransportLabel);
		newPacketTransportLabel.setURIOfIdentifiableToBeLabeled(this.getURI());
		this.getLabels().add(newPacketTransportLabel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<LoadUnloadEdge> getLoadingEdges() {
		return (EList<LoadUnloadEdge>)eDynamicGet(TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__LOADING_EDGES, TransportPackage.Literals.PACKET_STYLE_TRANSPORT_SYSTEM__LOADING_EDGES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<LoadUnloadEdge> getUnloadingEdges() {
		return (EList<LoadUnloadEdge>)eDynamicGet(TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__UNLOADING_EDGES, TransportPackage.Literals.PACKET_STYLE_TRANSPORT_SYSTEM__UNLOADING_EDGES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL:
				if (resolve) return getPacketTransportLabel();
				return basicGetPacketTransportLabel();
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__LOADING_EDGES:
				return getLoadingEdges();
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__UNLOADING_EDGES:
				return getUnloadingEdges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL:
				setPacketTransportLabel((PacketTransportLabel)newValue);
				return;
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__LOADING_EDGES:
				getLoadingEdges().clear();
				getLoadingEdges().addAll((Collection<? extends LoadUnloadEdge>)newValue);
				return;
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__UNLOADING_EDGES:
				getUnloadingEdges().clear();
				getUnloadingEdges().addAll((Collection<? extends LoadUnloadEdge>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL:
				setPacketTransportLabel((PacketTransportLabel)null);
				return;
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__LOADING_EDGES:
				getLoadingEdges().clear();
				return;
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__UNLOADING_EDGES:
				getUnloadingEdges().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL:
				return basicGetPacketTransportLabel() != null;
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__LOADING_EDGES:
				return !getLoadingEdges().isEmpty();
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__UNLOADING_EDGES:
				return !getUnloadingEdges().isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	
} //PacketStyleTransportSystemImpl
