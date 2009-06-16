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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.definitions.edges.impl.MigrationEdgeImpl;

import org.eclipse.stem.definitions.transport.LoadUnloadEdge;
import org.eclipse.stem.definitions.transport.LoadUnloadEdgeLabel;
import org.eclipse.stem.definitions.transport.PacketStyleTransportSystem;
import org.eclipse.stem.definitions.transport.TransportPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Unload Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.LoadUnloadEdgeImpl#isLoadingEdge <em>Loading Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadUnloadEdgeImpl extends MigrationEdgeImpl implements LoadUnloadEdge {
	
	/**
	 * The default value of the '{@link #isLoadingEdge() <em>Loading Edge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoadingEdge()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOADING_EDGE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isLoadingEdge() <em>Loading Edge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoadingEdge()
	 * @generated
	 * @ordered
	 */
	protected boolean loadingEdge = LOADING_EDGE_EDEFAULT;
	/**
	 * This is used to generate unique URI's for each LoadUnloadEdgeEdge generated
	 */
	static int loadUnloadEdgeCounter = 0;
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LoadUnloadEdgeImpl() {
		super();
		
		//We need to set the URI
		setURI(STEMURI.createURI(URI_TYPE_LOADUNLOADEDGE_SEGMENT + "/"
						+Integer.toString(loadUnloadEdgeCounter++)));
		
		//Make a label
		//setLabel(TransportFactory.eINSTANCE.createLoadUnloadEdgeLabel());
		

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.LOAD_UNLOAD_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoadingEdge() {
		return loadingEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadingEdge(boolean newLoadingEdge) {
		boolean oldLoadingEdge = loadingEdge;
		loadingEdge = newLoadingEdge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransportPackage.LOAD_UNLOAD_EDGE__LOADING_EDGE, oldLoadingEdge, loadingEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransportPackage.LOAD_UNLOAD_EDGE__LOADING_EDGE:
				return isLoadingEdge() ? Boolean.TRUE : Boolean.FALSE;
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
			case TransportPackage.LOAD_UNLOAD_EDGE__LOADING_EDGE:
				setLoadingEdge(((Boolean)newValue).booleanValue());
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
			case TransportPackage.LOAD_UNLOAD_EDGE__LOADING_EDGE:
				setLoadingEdge(LOADING_EDGE_EDEFAULT);
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
			case TransportPackage.LOAD_UNLOAD_EDGE__LOADING_EDGE:
				return loadingEdge != LOADING_EDGE_EDEFAULT;
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
		result.append(" (loadingEdge: ");
		result.append(loadingEdge);
		result.append(')');
		return result.toString();
	}

	/**Implementation of methods to resolve
	 * return type conflicts.*/
	public LoadUnloadEdgeLabel getLabel() {
		return (LoadUnloadEdgeLabel)super.getLabel();
	}
	public void setLabel(LoadUnloadEdgeLabel lbl) {
		super.setLabel(lbl);
	}
	
	
	/**Perform sanity checks necessary for this type of edge.*/
	public boolean sane() {
		boolean rc = super.sane();
		
		if (this.isLoadingEdge()) {
			rc = rc && this.getB() instanceof PacketStyleTransportSystem;
		} else {
			rc = rc && this.getA() instanceof PacketStyleTransportSystem;
		}
		
		assert rc;
		
		return rc;
	}
	
	
} //LoadUnloadEdgeImpl
