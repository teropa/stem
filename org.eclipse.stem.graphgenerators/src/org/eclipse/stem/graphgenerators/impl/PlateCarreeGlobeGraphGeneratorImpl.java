/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.graphgenerators.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.definitions.lattice.GraphLatticeGeneratorInterface;
import org.eclipse.stem.definitions.lattice.impl.LatticeGeneratorUtilityImpl;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plate Carree Globe Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.PlateCarreeGlobeGraphGeneratorImpl#getAngularStep <em>Angular Step</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.PlateCarreeGlobeGraphGeneratorImpl#getRadius <em>Radius</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlateCarreeGlobeGraphGeneratorImpl extends LatticeGraphGeneratorImpl implements PlateCarreeGlobeGraphGenerator {
	/**
	 * The default value of the '{@link #getAngularStep() <em>Angular Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngularStep()
	 * @generated
	 * @ordered
	 */
	protected static final int ANGULAR_STEP_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getAngularStep() <em>Angular Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngularStep()
	 * @generated
	 * @ordered
	 */
	protected int angularStep = ANGULAR_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getRadius() <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected static final double RADIUS_EDEFAULT = 6371.0;

	/**
	 * The cached value of the '{@link #getRadius() <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRadius()
	 * @generated
	 * @ordered
	 */
	protected double radius = RADIUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PlateCarreeGlobeGraphGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphgeneratorsPackage.Literals.PLATE_CARREE_GLOBE_GRAPH_GENERATOR;
	}

	/**
	 * @see LatticeGeneratorUtilityImpl
	 */
	@Override
	public Graph getGraph() {
		LatticeGeneratorUtilityImpl slgi = new LatticeGeneratorUtilityImpl(GraphLatticeGeneratorInterface.GLOBE_LATTICE_TYPE);
		Graph g = slgi.getPlateCareeGraph(this.getAngularStep(), this.getRadius(), this.isUseNearestNeighbors(), this.isUseNextNearestNeighbors(), this.isPeriodicBoundaries());
		
		return g;
		

	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAngularStep() {
		return angularStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngularStep(int newAngularStep) {
		int oldAngularStep = angularStep;
		angularStep = newAngularStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__ANGULAR_STEP, oldAngularStep, angularStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadius(double newRadius) {
		double oldRadius = radius;
		radius = newRadius;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__RADIUS, oldRadius, radius));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__ANGULAR_STEP:
				return getAngularStep();
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__RADIUS:
				return getRadius();
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
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__ANGULAR_STEP:
				setAngularStep((Integer)newValue);
				return;
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__RADIUS:
				setRadius((Double)newValue);
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
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__ANGULAR_STEP:
				setAngularStep(ANGULAR_STEP_EDEFAULT);
				return;
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__RADIUS:
				setRadius(RADIUS_EDEFAULT);
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
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__ANGULAR_STEP:
				return angularStep != ANGULAR_STEP_EDEFAULT;
			case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__RADIUS:
				return radius != RADIUS_EDEFAULT;
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
		result.append(" (angularStep: ");
		result.append(angularStep);
		result.append(", radius: ");
		result.append(radius);
		result.append(')');
		return result.toString();
	}

} //PlateCarreeGlobeGraphGeneratorImpl
