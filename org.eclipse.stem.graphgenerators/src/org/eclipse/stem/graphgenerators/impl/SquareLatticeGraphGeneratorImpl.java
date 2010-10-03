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
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.definitions.lattice.GraphLatticeGeneratorInterface;
import org.eclipse.stem.definitions.lattice.impl.LatticeGeneratorUtilityImpl;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Square Lattice Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.SquareLatticeGraphGeneratorImpl#getXSize <em>XSize</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.SquareLatticeGraphGeneratorImpl#getYSize <em>YSize</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.SquareLatticeGraphGeneratorImpl#getArea <em>Area</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SquareLatticeGraphGeneratorImpl extends LatticeGraphGeneratorImpl implements SquareLatticeGraphGenerator {
	/**
	 * The default value of the '{@link #getXSize() <em>XSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSize()
	 * @generated
	 * @ordered
	 */
	protected static final int XSIZE_EDEFAULT = 10;
	/**
	 * The default value of the '{@link #getYSize() <em>YSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYSize()
	 * @generated
	 * @ordered
	 */
	protected static final int YSIZE_EDEFAULT = 10;
	/**
	 * The default value of the '{@link #getArea() <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArea()
	 * @generated
	 * @ordered
	 */
	protected static final double AREA_EDEFAULT = 2025.0;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SquareLatticeGraphGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getXSize() {
		return (Integer)eDynamicGet(GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE, GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXSize(int newXSize) {
		eDynamicSet(GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE, GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE, newXSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getYSize() {
		return (Integer)eDynamicGet(GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE, GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYSize(int newYSize) {
		eDynamicSet(GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE, GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE, newYSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getArea() {
		return (Double)eDynamicGet(GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__AREA, GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__AREA, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(double newArea) {
		eDynamicSet(GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__AREA, GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__AREA, newArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE:
				return getXSize();
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE:
				return getYSize();
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__AREA:
				return getArea();
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
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE:
				setXSize((Integer)newValue);
				return;
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE:
				setYSize((Integer)newValue);
				return;
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__AREA:
				setArea((Double)newValue);
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
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE:
				setXSize(XSIZE_EDEFAULT);
				return;
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE:
				setYSize(YSIZE_EDEFAULT);
				return;
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__AREA:
				setArea(AREA_EDEFAULT);
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
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE:
				return getXSize() != XSIZE_EDEFAULT;
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE:
				return getYSize() != YSIZE_EDEFAULT;
			case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__AREA:
				return getArea() != AREA_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see LatticeGeneratorUtilityImpl
	 */
	@Override
	public Graph getGraph() {
		LatticeGeneratorUtilityImpl slgi = new LatticeGeneratorUtilityImpl(GraphLatticeGeneratorInterface.SQR_LATTICE_TYPE);
		// Get the graph
		Graph g = slgi.getGraph(this.getXSize(), this.getYSize(), this.getArea(), this.isUseNearestNeighbors(), this.isUseNextNearestNeighbors(), this.isPeriodicBoundaries());
		return g;
	}
} //SquareLatticeGraphGeneratorImpl
