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
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.LatticeGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lattice Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl#isUseNearestNeighbors <em>Use Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl#isUseNextNearestNeighbors <em>Use Next Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl#isPeriodicBoundaries <em>Periodic Boundaries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LatticeGraphGeneratorImpl extends GraphGeneratorImpl implements LatticeGraphGenerator {
	/**
	 * The default value of the '{@link #isUseNearestNeighbors() <em>Use Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseNearestNeighbors()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_NEAREST_NEIGHBORS_EDEFAULT = true;

	/**
	 * The default value of the '{@link #isUseNextNearestNeighbors() <em>Use Next Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseNextNearestNeighbors()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_NEXT_NEAREST_NEIGHBORS_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isPeriodicBoundaries() <em>Periodic Boundaries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPeriodicBoundaries()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PERIODIC_BOUNDARIES_EDEFAULT = true;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LatticeGraphGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphgeneratorsPackage.Literals.LATTICE_GRAPH_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseNearestNeighbors() {
		return (Boolean)eDynamicGet(GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS, GraphgeneratorsPackage.Literals.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseNearestNeighbors(boolean newUseNearestNeighbors) {
		eDynamicSet(GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS, GraphgeneratorsPackage.Literals.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS, newUseNearestNeighbors);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseNextNearestNeighbors() {
		return (Boolean)eDynamicGet(GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS, GraphgeneratorsPackage.Literals.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseNextNearestNeighbors(boolean newUseNextNearestNeighbors) {
		eDynamicSet(GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS, GraphgeneratorsPackage.Literals.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS, newUseNextNearestNeighbors);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPeriodicBoundaries() {
		return (Boolean)eDynamicGet(GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES, GraphgeneratorsPackage.Literals.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriodicBoundaries(boolean newPeriodicBoundaries) {
		eDynamicSet(GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES, GraphgeneratorsPackage.Literals.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES, newPeriodicBoundaries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				return isUseNearestNeighbors();
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				return isUseNextNearestNeighbors();
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				return isPeriodicBoundaries();
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
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				setUseNearestNeighbors((Boolean)newValue);
				return;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				setUseNextNearestNeighbors((Boolean)newValue);
				return;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				setPeriodicBoundaries((Boolean)newValue);
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
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				setUseNearestNeighbors(USE_NEAREST_NEIGHBORS_EDEFAULT);
				return;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				setUseNextNearestNeighbors(USE_NEXT_NEAREST_NEIGHBORS_EDEFAULT);
				return;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				setPeriodicBoundaries(PERIODIC_BOUNDARIES_EDEFAULT);
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
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				return isUseNearestNeighbors() != USE_NEAREST_NEIGHBORS_EDEFAULT;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				return isUseNextNearestNeighbors() != USE_NEXT_NEAREST_NEIGHBORS_EDEFAULT;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				return isPeriodicBoundaries() != PERIODIC_BOUNDARIES_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //LatticeGraphGeneratorImpl
