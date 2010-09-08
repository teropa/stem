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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.definitions.LocationUtility;
import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.edges.MigrationEdge;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabel;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue;
import org.eclipse.stem.definitions.edges.impl.EdgesFactoryImpl;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabel;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabelValue;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Migration Edge Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.MigrationEdgeGraphGeneratorImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.MigrationEdgeGraphGeneratorImpl#getMigrationRate <em>Migration Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.MigrationEdgeGraphGeneratorImpl#getPopulation <em>Population</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MigrationEdgeGraphGeneratorImpl extends GraphGeneratorImpl implements MigrationEdgeGraphGenerator {
	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final URI LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected URI location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMigrationRate() <em>Migration Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMigrationRate()
	 * @generated
	 * @ordered
	 */
	protected static final double MIGRATION_RATE_EDEFAULT = 0.1;

	/**
	 * The cached value of the '{@link #getMigrationRate() <em>Migration Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMigrationRate()
	 * @generated
	 * @ordered
	 */
	protected double migrationRate = MIGRATION_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPopulation() <em>Population</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulation()
	 * @generated
	 * @ordered
	 */
	protected static final String POPULATION_EDEFAULT = "human";

	/**
	 * The cached value of the '{@link #getPopulation() <em>Population</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulation()
	 * @generated
	 * @ordered
	 */
	protected String population = POPULATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MigrationEdgeGraphGeneratorImpl() {
		super();
	}

	/**
	 * Generate migration edges 
	 */
	@Override
	public Graph getGraph() {
		final Graph graph = GraphFactory.eINSTANCE.createGraph();
		final DublinCore dc = graph.getDublinCore();
		dc.populate();
		dc.setTitle(MIGRATION_EDGE_TYPE);
		dc.setSource(this.getClass().getSimpleName());
		Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        String valid = formatter.format(c.getTime());
       	dc.setValid(valid);
       	// TODO for now, just for testing
       	// gets ALL common border edges
       	Set<Edge> commonBorderEdges = LocationUtility.getCommonBorderEdges(project, this.getLocation());
		
		Iterator<Edge> iter = commonBorderEdges.iterator();
		while((iter!=null)&&(iter.hasNext())){
       	 		Edge e = iter.next();
				int sourceLevel = Utility.keyLevel(e.getNodeAURI().lastSegment());
				int targetLevel = Utility.keyLevel(e.getNodeBURI().lastSegment());
				URI sourceURI = e.getNodeAURI();
				URI targetURI = e.getNodeBURI();
				
				EdgesFactory ef = EdgesFactoryImpl.init();
				MigrationEdge mEdge1 = ef.createMigrationEdge();
				MigrationEdge mEdge2 = ef.createMigrationEdge();
				
				// The URI of the edge 1 
				URI edgeURI1 = mEdge1.getURI();
				// the autogenerated edge uri is not correct. Need to replace it
				String s1 = edgeURI1.toString();
				int last = s1.lastIndexOf("/");
				String sEdge1 = s1.substring(0,last);
				String sEdge2 = s1.substring(last,s1.length());
				s1 = sEdge1+"/relationship/migration"+sEdge2;
				URI newURI = URI.createURI(s1);
				mEdge1.setURI(newURI);
				
				
				// The URI of the edge 2
				URI edgeURI2 = mEdge2.getURI();
				// the autogenerated edge uri is not correct. Need to replace it
				String s2 = edgeURI2.toString();
				int last2 = s2.lastIndexOf("/");
				sEdge1 = s2.substring(0,last2);
				sEdge2 = s2.substring(last,s2.length());
				s2 = sEdge1+"/relationship/migration"+sEdge2;
				URI newURI2 = URI.createURI(s2);
				mEdge2.setURI(newURI2);
				
				// ADD The URIs of the nodes connected by these two directed edges
				// A => B
				mEdge1.setNodeAURI(sourceURI);
				mEdge1.setNodeBURI(targetURI);
				// B => A
				mEdge2.setNodeBURI(sourceURI);
				mEdge2.setNodeAURI(targetURI);
										
				// now we need to set the uri for the label
				MigrationEdgeLabel label1 = mEdge1.getLabel();
				MigrationEdgeLabel label2 = mEdge2.getLabel();
				
				//System.out.println("BEFORE: mEdgeLabel1 URI was "+label1.getURI().toString());
				//System.out.println("BEFORE: mEdgeLabel2 URI was "+label2.getURI().toString());
				
				label1.setURI(createEdgeLabelURI(sourceURI, targetURI));
				label2.setURI(createEdgeLabelURI(targetURI, sourceURI));
				
				MigrationEdgeLabelValue melv1 = label1.getCurrentValue();
				melv1.setMigrationRate(this.getMigrationRate());
				MigrationEdgeLabelValue melv2 = label2.getCurrentValue();
				melv2.setMigrationRate(this.getMigrationRate());
				
				final DublinCore dc1 = mEdge1.getDublinCore();
				dc1.setTitle(createEdgeTitle(sourceURI, targetURI));
				
				final DublinCore dc2 = mEdge2.getDublinCore();
				dc2.setTitle(createEdgeTitle(targetURI, sourceURI));
				
				mEdge1.setPopulationIdentifier(this.getPopulation());
				mEdge2.setPopulationIdentifier(this.getPopulation());
				
				graph.putEdge(mEdge1);
				graph.putEdge(mEdge2);
		}

		assert graph.sane();

		return graph;
		}// getGraph
	
	/**
	 * IProject to create edges in
	 */
	private IProject project;
	public IProject getProject() {
		return project; 
	}
	public void setProject(IProject p) {
		this.project = p;
	}
	
	/**
	 * 
	 * @param uriA
	 * @param uriB
	 * @return
	 */
	private static URI createEdgeLabelURI(URI uriA, URI uriB) {
		
		//System.out.println("createEdgeLabelURI() : initially, uriA = "+uriA.toString());
		//System.out.println("createEdgeLabelURI() : initially, uriB = "+uriB.toString());
		
		String sA = uriA.lastSegment();
		String sB = uriB.lastSegment();
		
		// TODO is this still true??
		// MigrationEdgeLabelItemProvider
		// uses _ as a special character to separate the two nodes
		// so we need to replace it.
		sA=sA.replace('_','.');
		sB=sB.replace('_','.');
		String uriString = sA+"_"+sB;
		
		//System.out.println("createEdgeLabelURI() : FINALLY, uri = "+uriString);
		
        URI uri = STEMURI.createURI(uriString);
		return uri;
	} // createRegionNodeURI
	
	/**
	 * @param x
	 *            the x of the node in the lattice
	 * @param y
	 *            the y of the node in the lattice
	 * @return a title for a node
	 */
	public static String createEdgeTitle(URI uriA, URI uriB) {
		String sA = uriA.lastSegment();
		String sB = uriB.lastSegment();
		final StringBuilder sb = new StringBuilder("MigrationEdge[(");
		sb.append(sA);
		sb.append(")<-->(");
		sb.append(sB);
		sb.append(")]");
		
		return sb.toString();
	} // createEdgeTitle
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphgeneratorsPackage.Literals.MIGRATION_EDGE_GRAPH_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(URI newLocation) {
		URI oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMigrationRate() {
		return migrationRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMigrationRate(double newMigrationRate) {
		double oldMigrationRate = migrationRate;
		migrationRate = newMigrationRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__MIGRATION_RATE, oldMigrationRate, migrationRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPopulation() {
		return population;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulation(String newPopulation) {
		String oldPopulation = population;
		population = newPopulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION, oldPopulation, population));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__LOCATION:
				return getLocation();
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__MIGRATION_RATE:
				return getMigrationRate();
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION:
				return getPopulation();
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
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__LOCATION:
				setLocation((URI)newValue);
				return;
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__MIGRATION_RATE:
				setMigrationRate((Double)newValue);
				return;
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION:
				setPopulation((String)newValue);
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
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__MIGRATION_RATE:
				setMigrationRate(MIGRATION_RATE_EDEFAULT);
				return;
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION:
				setPopulation(POPULATION_EDEFAULT);
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
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__MIGRATION_RATE:
				return migrationRate != MIGRATION_RATE_EDEFAULT;
			case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION:
				return POPULATION_EDEFAULT == null ? population != null : !POPULATION_EDEFAULT.equals(population);
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
		result.append(" (location: ");
		result.append(location);
		result.append(", migrationRate: ");
		result.append(migrationRate);
		result.append(", population: ");
		result.append(population);
		result.append(')');
		return result.toString();
	}

} //MigrationEdgeGraphGeneratorImpl
