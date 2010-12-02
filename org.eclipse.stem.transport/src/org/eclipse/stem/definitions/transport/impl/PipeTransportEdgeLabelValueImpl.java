package org.eclipse.stem.definitions.transport.impl;

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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.impl.LabelValueImpl;
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue;
import org.eclipse.stem.definitions.transport.TransportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipe Transport Edge Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelValueImpl#getMaxFlow <em>Max Flow</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.PipeTransportEdgeLabelValueImpl#getTimePeriod <em>Time Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PipeTransportEdgeLabelValueImpl extends LabelValueImpl implements PipeTransportEdgeLabelValue {
	/**
	 * The default value of the '{@link #getMaxFlow() <em>Max Flow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxFlow()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_FLOW_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxFlow() <em>Max Flow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxFlow()
	 * @generated
	 * @ordered
	 */
	protected double maxFlow = MAX_FLOW_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimePeriod() <em>Time Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePeriod()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_PERIOD_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimePeriod() <em>Time Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePeriod()
	 * @generated
	 * @ordered
	 */
	protected long timePeriod = TIME_PERIOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdgeLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.PIPE_TRANSPORT_EDGE_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaxFlow() {
		return maxFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxFlow(double newMaxFlow) {
		double oldMaxFlow = maxFlow;
		maxFlow = newMaxFlow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__MAX_FLOW, oldMaxFlow, maxFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimePeriod() {
		return timePeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimePeriod(long newTimePeriod) {
		long oldTimePeriod = timePeriod;
		timePeriod = newTimePeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__TIME_PERIOD, oldTimePeriod, timePeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__MAX_FLOW:
				return getMaxFlow();
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__TIME_PERIOD:
				return getTimePeriod();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__MAX_FLOW:
				setMaxFlow((Double)newValue);
				return;
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__TIME_PERIOD:
				setTimePeriod((Long)newValue);
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
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__MAX_FLOW:
				setMaxFlow(MAX_FLOW_EDEFAULT);
				return;
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__TIME_PERIOD:
				setTimePeriod(TIME_PERIOD_EDEFAULT);
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
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__MAX_FLOW:
				return maxFlow != MAX_FLOW_EDEFAULT;
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE__TIME_PERIOD:
				return timePeriod != TIME_PERIOD_EDEFAULT;
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
		result.append(" (maxFlow: ");
		result.append(maxFlow);
		result.append(", timePeriod: ");
		result.append(timePeriod);
		result.append(')');
		return result.toString();
	}

} //PipeTransportEdgeLabelValueImpl
