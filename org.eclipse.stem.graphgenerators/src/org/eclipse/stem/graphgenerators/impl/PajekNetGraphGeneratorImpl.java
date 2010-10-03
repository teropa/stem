package org.eclipse.stem.graphgenerators.impl;

/*******************************************************************************
* Copyright (c) 2010 IBM Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* IBM Corporation - initial API and implementation
*******************************************************************************/

import java.io.File;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.definitions.Activator;
import org.eclipse.stem.definitions.adapters.spatial.geo.InlineLatLongDataProvider;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabel;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.impl.CommonBorderRelationshipLabelImpl;
import org.eclipse.stem.definitions.nodes.NodesFactory;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.PajekNetGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pajek Net Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.PajekNetGraphGeneratorImpl#getDataFile_net <em>Data File net</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.PajekNetGraphGeneratorImpl#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.PajekNetGraphGeneratorImpl#getZoomFactor <em>Zoom Factor</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.PajekNetGraphGeneratorImpl#getColArea <em>Col Area</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PajekNetGraphGeneratorImpl extends GraphGeneratorImpl implements PajekNetGraphGenerator {
	/**
	 * The default value of the '{@link #getDataFile_net() <em>Data File net</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFile_net()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_FILE_NET_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getArea() <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArea()
	 * @generated
	 * @ordered
	 */
	protected static final double AREA_EDEFAULT = 100.0;

	/**
	 * The default value of the '{@link #getZoomFactor() <em>Zoom Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoomFactor()
	 * @generated
	 * @ordered
	 */
	protected static final int ZOOM_FACTOR_EDEFAULT = 1000;

	/**
	 * The default value of the '{@link #getColArea() <em>Col Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColArea()
	 * @generated
	 * @ordered
	 */
	protected static final int COL_AREA_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PajekNetGraphGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataFile_net() {
		return (String)eDynamicGet(GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET, GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataFile_net(String newDataFile_net) {
		eDynamicSet(GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET, GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET, newDataFile_net);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getArea() {
		return (Double)eDynamicGet(GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA, GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__AREA, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(double newArea) {
		eDynamicSet(GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA, GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__AREA, newArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getZoomFactor() {
		return (Integer)eDynamicGet(GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR, GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZoomFactor(int newZoomFactor) {
		eDynamicSet(GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR, GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR, newZoomFactor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColArea() {
		return (Integer)eDynamicGet(GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__COL_AREA, GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__COL_AREA, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColArea(int newColArea) {
		eDynamicSet(GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__COL_AREA, GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__COL_AREA, newColArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET:
				return getDataFile_net();
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
				return getArea();
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR:
				return getZoomFactor();
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__COL_AREA:
				return getColArea();
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
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET:
				setDataFile_net((String)newValue);
				return;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
				setArea((Double)newValue);
				return;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR:
				setZoomFactor((Integer)newValue);
				return;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__COL_AREA:
				setColArea((Integer)newValue);
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
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET:
				setDataFile_net(DATA_FILE_NET_EDEFAULT);
				return;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
				setArea(AREA_EDEFAULT);
				return;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR:
				setZoomFactor(ZOOM_FACTOR_EDEFAULT);
				return;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__COL_AREA:
				setColArea(COL_AREA_EDEFAULT);
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
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET:
				return DATA_FILE_NET_EDEFAULT == null ? getDataFile_net() != null : !DATA_FILE_NET_EDEFAULT.equals(getDataFile_net());
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
				return getArea() != AREA_EDEFAULT;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR:
				return getZoomFactor() != ZOOM_FACTOR_EDEFAULT;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__COL_AREA:
				return getColArea() != COL_AREA_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Import PajekNets into Graphs
	 * for Pajek format see: http://vlado.fmf.uni-lj.si/pub/networks/pajek/doc/pajekman.pdf
	 * 
	 * we use compatible definitions of the pajek format only, which is:
	 * Vertices: vertexNumber label x y - the first 4 parameters are mandatory
	 * Arcs: v1 v2 value - all three parameters are mandatory
	 * 
	 * Data File: Pajek file to import
	 * Area: Default Area of each node if undefined
	 * Zoomfactor: Factorizing the initial coordinates of the Pajek NET
	 * colArea: Field that defines the individual area for each node. If missing the default area is used. Value must be greater than 4 as the first four columns are predefined.
	 * 
	 */
	@Override		
	public Graph getGraph() {
		return  null;
		// IP not yet ready for EPL
	}

} //PajekNetGraphGeneratorImpl
