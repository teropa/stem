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

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.stem.definitions.transport.PipeStyleTransportSystem;
import org.eclipse.stem.definitions.transport.PipeTransportEdge;
import org.eclipse.stem.definitions.transport.TransportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipe Style Transport System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.PipeStyleTransportSystemImpl#getInTransportEdges <em>In Transport Edges</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.PipeStyleTransportSystemImpl#getOutTransportEdges <em>Out Transport Edges</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.PipeStyleTransportSystemImpl#getMaxCapacity <em>Max Capacity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PipeStyleTransportSystemImpl extends TransportSystemImpl implements PipeStyleTransportSystem {
	/**
	 * The cached value of the '{@link #getInTransportEdges() <em>In Transport Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransportEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<PipeTransportEdge> inTransportEdges;

	/**
	 * The cached value of the '{@link #getOutTransportEdges() <em>Out Transport Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTransportEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<PipeTransportEdge> outTransportEdges;

	/**
	 * The default value of the '{@link #getMaxCapacity() <em>Max Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_CAPACITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxCapacity() <em>Max Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCapacity()
	 * @generated
	 * @ordered
	 */
	protected double maxCapacity = MAX_CAPACITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeStyleTransportSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.PIPE_STYLE_TRANSPORT_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PipeTransportEdge> getInTransportEdges() {
		if (inTransportEdges == null) {
			inTransportEdges = new EObjectResolvingEList<PipeTransportEdge>(PipeTransportEdge.class, this, TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__IN_TRANSPORT_EDGES);
		}
		return inTransportEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PipeTransportEdge> getOutTransportEdges() {
		if (outTransportEdges == null) {
			outTransportEdges = new EObjectResolvingEList<PipeTransportEdge>(PipeTransportEdge.class, this, TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__OUT_TRANSPORT_EDGES);
		}
		return outTransportEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxCapacity(double newMaxCapacity) {
		double oldMaxCapacity = maxCapacity;
		maxCapacity = newMaxCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__MAX_CAPACITY, oldMaxCapacity, maxCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__IN_TRANSPORT_EDGES:
				return getInTransportEdges();
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__OUT_TRANSPORT_EDGES:
				return getOutTransportEdges();
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__MAX_CAPACITY:
				return new Double(getMaxCapacity());
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
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__IN_TRANSPORT_EDGES:
				getInTransportEdges().clear();
				getInTransportEdges().addAll((Collection<? extends PipeTransportEdge>)newValue);
				return;
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__OUT_TRANSPORT_EDGES:
				getOutTransportEdges().clear();
				getOutTransportEdges().addAll((Collection<? extends PipeTransportEdge>)newValue);
				return;
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__MAX_CAPACITY:
				setMaxCapacity(((Double)newValue).doubleValue());
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
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__IN_TRANSPORT_EDGES:
				getInTransportEdges().clear();
				return;
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__OUT_TRANSPORT_EDGES:
				getOutTransportEdges().clear();
				return;
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__MAX_CAPACITY:
				setMaxCapacity(MAX_CAPACITY_EDEFAULT);
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
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__IN_TRANSPORT_EDGES:
				return inTransportEdges != null && !inTransportEdges.isEmpty();
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__OUT_TRANSPORT_EDGES:
				return outTransportEdges != null && !outTransportEdges.isEmpty();
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM__MAX_CAPACITY:
				return maxCapacity != MAX_CAPACITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (maxCapacity: ");
		result.append(maxCapacity);
		result.append(')');
		return result.toString();
	}

} //PipeStyleTransportSystemImpl
