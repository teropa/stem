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
	 * The cached value of the '{@link #getPacketTransportLabel() <em>Packet Transport Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPacketTransportLabel()
	 * @generated
	 * @ordered
	 */
	protected PacketTransportLabel packetTransportLabel;

	/**
	 * The cached value of the '{@link #getLoadingEdges() <em>Loading Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<LoadUnloadEdge> loadingEdges;

	/**
	 * The cached value of the '{@link #getUnloadingEdges() <em>Unloading Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnloadingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<LoadUnloadEdge> unloadingEdges;

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
		if (packetTransportLabel != null && packetTransportLabel.eIsProxy()) {
			InternalEObject oldPacketTransportLabel = (InternalEObject)packetTransportLabel;
			packetTransportLabel = (PacketTransportLabel)eResolveProxy(oldPacketTransportLabel);
			if (packetTransportLabel != oldPacketTransportLabel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL, oldPacketTransportLabel, packetTransportLabel));
			}
		}
		return packetTransportLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketTransportLabel basicGetPacketTransportLabel() {
		return packetTransportLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPacketTransportLabel(PacketTransportLabel newPacketTransportLabel) {
		PacketTransportLabel oldPacketTransportLabel = packetTransportLabel;
		packetTransportLabel = newPacketTransportLabel;
		newPacketTransportLabel.setURIOfIdentifiableToBeLabeled(this.getURI());
		this.getLabels().add(newPacketTransportLabel);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__PACKET_TRANSPORT_LABEL, oldPacketTransportLabel, packetTransportLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LoadUnloadEdge> getLoadingEdges() {
		if (loadingEdges == null) {
			loadingEdges = new EObjectResolvingEList<LoadUnloadEdge>(LoadUnloadEdge.class, this, TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__LOADING_EDGES);
		}
		return loadingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LoadUnloadEdge> getUnloadingEdges() {
		if (unloadingEdges == null) {
			unloadingEdges = new EObjectResolvingEList<LoadUnloadEdge>(LoadUnloadEdge.class, this, TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__UNLOADING_EDGES);
		}
		return unloadingEdges;
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
				return packetTransportLabel != null;
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__LOADING_EDGES:
				return loadingEdges != null && !loadingEdges.isEmpty();
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM__UNLOADING_EDGES:
				return unloadingEdges != null && !unloadingEdges.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	
} //PacketStyleTransportSystemImpl
