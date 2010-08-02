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
	 * The cached value of the '{@link #getDataFile_net() <em>Data File net</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFile_net()
	 * @generated
	 * @ordered
	 */
	protected String dataFile_net = DATA_FILE_NET_EDEFAULT;

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
	 * The cached value of the '{@link #getArea() <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArea()
	 * @generated
	 * @ordered
	 */
	protected double area = AREA_EDEFAULT;

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
	 * The cached value of the '{@link #getZoomFactor() <em>Zoom Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoomFactor()
	 * @generated
	 * @ordered
	 */
	protected int zoomFactor = ZOOM_FACTOR_EDEFAULT;

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
	 * The cached value of the '{@link #getColArea() <em>Col Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColArea()
	 * @generated
	 * @ordered
	 */
	protected int colArea = COL_AREA_EDEFAULT;

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
		return dataFile_net;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataFile_net(String newDataFile_net) {
		String oldDataFile_net = dataFile_net;
		dataFile_net = newDataFile_net;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET, oldDataFile_net, dataFile_net));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getArea() {
		return area;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(double newArea) {
		double oldArea = area;
		area = newArea;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA, oldArea, area));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getZoomFactor() {
		return zoomFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZoomFactor(int newZoomFactor) {
		int oldZoomFactor = zoomFactor;
		zoomFactor = newZoomFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR, oldZoomFactor, zoomFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColArea() {
		return colArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColArea(int newColArea) {
		int oldColArea = colArea;
		colArea = newColArea;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__COL_AREA, oldColArea, colArea));
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
				return DATA_FILE_NET_EDEFAULT == null ? dataFile_net != null : !DATA_FILE_NET_EDEFAULT.equals(dataFile_net);
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
				return area != AREA_EDEFAULT;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__ZOOM_FACTOR:
				return zoomFactor != ZOOM_FACTOR_EDEFAULT;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__COL_AREA:
				return colArea != COL_AREA_EDEFAULT;
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
		result.append(" (dataFile_net: ");
		result.append(dataFile_net);
		result.append(", area: ");
		result.append(area);
		result.append(", zoomFactor: ");
		result.append(zoomFactor);
		result.append(", colArea: ");
		result.append(colArea);
		result.append(')');
		return result.toString();
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
		Graph g = null;
        File file = new File(getDataFile_net());
        if (file != null && !file.isDirectory() && file.exists()) g = getGraph(file);	
        else Activator.logError("Pajek importing: File cannot be found", null);
		return g;
	}

	private Graph getGraph(File pajekNETFileURI) {
       	final Graph graph = GraphFactory.eINSTANCE.createGraph();
		final DublinCore dc = graph.getDublinCore();
		dc.populate();
		dc.setTitle("Pajek Import");
		dc.setSource(this.getClass().getSimpleName());
		Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        String valid = formatter.format(c.getTime());
       	dc.setValid(valid);
       	
       	Node nodeHolder[] = new Node[0];

		Scanner input;
		try {
			input = new Scanner(pajekNETFileURI);

			boolean doNodes = false, doEdges = false;
			int numNodes = 0;
			String nodeName[] = new String[0];
			while(input.hasNext()) {
			    String nextLine = input.nextLine();
			    StreamTokenizer tok = new StreamTokenizer(new StringReader(nextLine.trim()));
			    tok.parseNumbers();
		    	int ttype = getNextToken(tok);
		    	if (ttype == StreamTokenizer.TT_WORD) {
		    		// e.g. Vertices     26
		    		if (tok.sval.equalsIgnoreCase("vertices")) {
				    	doNodes = true;
				    	doEdges = false;
				    	ttype = getNextToken(tok);
				    	if (ttype == StreamTokenizer.TT_NUMBER) {
				    		numNodes = (int) tok.nval;
				    		nodeHolder = new Node[numNodes];
				    		nodeName = new String[numNodes];
					    	numNodes = 0;		    			
				    	}
				    	else {
				    		Activator.logError("Pajek importing " + pajekNETFileURI.getName() + ": vertices keyword without valid number of nodes... Not processable!", null);
					    	input.close();
					    	return null;
				    	}
		    		}
		    		else if (tok.sval.equalsIgnoreCase("arcs") || tok.sval.equalsIgnoreCase("arcslist") || tok.sval.equalsIgnoreCase("edges")) {
				    	doNodes = false;
				    	doEdges = true;
		    		}
		    		else {
		    			doNodes = false;
		    			doEdges = false;
		    		}
			    }
			    else if (doNodes && ttype == StreamTokenizer.TT_NUMBER) { // Nodes = Vertices
			    	double x = 0, y = 0;
			    	double nodeArea = 0;
			    	
			    	// vertex/node number
			    	if (tok.nval != numNodes+1) {
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": usually successive numbering of vertices/nodes... Please check! Exiting!", null);
				    	input.close();
			    		return null;
			    	}
			    	else nodeName[numNodes] = ""+(int)tok.nval;
			    	
			    	// label
			    	ttype = getNextToken(tok); 
			    	if (ttype == StreamTokenizer.TT_WORD || ttype == '"') nodeName[numNodes] = tok.sval;
			    	else if (ttype == StreamTokenizer.TT_NUMBER) nodeName[numNodes] = ""+(int)tok.nval;
			    	else {
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": a label for the node/vertex is obligatory... Exiting!", null);
				    	input.close();
			    		return null;
			    	}
			    	
			    	// coordinates of vertex/node, at least x and y, z is not used at the moment
			    	ttype = getNextToken(tok);
			    	if (ttype == StreamTokenizer.TT_NUMBER)	x = tok.nval;
			    	else {
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": coordinates for the node/vertex are necessary... Exiting!", null);
			    		input.close();
			    		return null;
			    	} 	    	
			    	ttype = getNextToken(tok);
			    	if (ttype == StreamTokenizer.TT_NUMBER)	y = tok.nval;
			    	else {
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": coordinates for the node/vertex are necessary... Exiting!", null);
			    		input.close();
			    		return null;
			    	} 
			    	
			    	if (getColArea() > 4) {
			    		for (int actualCol = 5; ttype != StreamTokenizer.TT_EOF; actualCol++) {
			    			ttype = getNextToken(tok);
			    			if (getColArea() == actualCol && ttype == StreamTokenizer.TT_NUMBER) nodeArea = tok.nval;
			    		}
			    	}
					
			    	// Thats it. At the moment we are not interested in more parameters, maybe later...
			    	// Creating node:
			    	x=x*getZoomFactor();
			    	y=y*getZoomFactor();
			    	final Region regionNode = createRegionNode("PAJ_NET_" + nodeName[numNodes] + "_", x, y, graph);
					
			    	double area = (nodeArea > 0 ? nodeArea : getArea());
					final AreaLabel areaLabel = LabelsFactory.eINSTANCE.createAreaLabel();
					areaLabel.getCurrentAreaValue().setArea(area);
					regionNode.getLabels().add(areaLabel);
										
					final LatLong nodeSegments = createNodePolygon(x,y,area);
					final String spatialURIString = InlineLatLongDataProvider.createSpatialInlineURIString(nodeSegments);
					regionNode.getDublinCore().setSpatial(spatialURIString);
					
					nodeHolder[numNodes] = regionNode;
					graph.putNode(regionNode);
			    	numNodes++;
			    }
			    else if (doEdges && ttype == StreamTokenizer.TT_NUMBER) { // Edges = Arcs
			    	int a, b = 0;
			    	int borderLength = 0;
			    	
			    	// initial vertex number
			    	a = (int) tok.nval;
			    	
			    	// terminal vertex number
			    	ttype = getNextToken(tok);
			    	if (ttype == StreamTokenizer.TT_NUMBER)	b = (int) tok.nval;
			    	else {
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": wrong arcs format. Cannot identify terminal node with initial node " + a + " ... Exiting!", null);
			    		input.close();
			    		return null;
			    	}
			    	
			    	// value of arc from a to b, we interpret it as borderLength, usually in Pajek format it is thickness of arc
			    	ttype = getNextToken(tok);
			    	if (ttype == StreamTokenizer.TT_NUMBER)	borderLength = (int) tok.nval;
			    	else {
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": wrong arcs format. Cannot identify value of arc between node " + a + " and node " + b + " ... Exiting!", null);
			    		input.close();
			    		return null;
			    	}
			    	
			    	if (borderLength < 0) borderLength *= -1;
			    	createEdge(graph,nodeHolder[a-1],nodeHolder[b-1], borderLength);
			    }
			    else {
			    	Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": very special Pajek format?!? Not processable!", null);
			    	input.close();
			    	return null;
			    }
			}

			input.close();		
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		assert graph.sane();

		return graph;
	}
	private int getNextToken(StreamTokenizer tok) throws IOException {
		int ttype = 0; 
		while((ttype = tok.nextToken()) != StreamTokenizer.TT_WORD && ttype != StreamTokenizer.TT_NUMBER && ttype != StreamTokenizer.TT_EOF && ttype != '"');
		return ttype;
	}		
	
	


	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param area
	 * @return
	 */
	private LatLong createNodePolygon(final double x, double y, double area) {
		final LatLong retValue = new LatLong();
		
		final SegmentBuilder sb = new SegmentBuilder();
		// We just make a square...
		double area2 = Math.sqrt(area) / 2;
		sb.add(x-area2, y-area2);
		sb.add(x-area2, y+area2);
		sb.add(x+area2, y+area2);
		sb.add(x+area2, y-area2);
		sb.add(x-area2, y-area2);
		retValue.add(sb.toSegment());

		return retValue;
	} // createNodePolygon


	/**
	 * @param x
	 *            the x coord of the node in the lattice
	 * @param y
	 *            the y coord of the node in the lattice
	 * @return a node
	 */
	private Region createRegionNode(String uriPrefix, double x, double y, Graph graph) {
		final Region node = NodesFactory.eINSTANCE.createRegion();
		final DublinCore dc = node.getDublinCore();
		dc.setTitle(createNodeTitle(x, y));
		node.setURI(createRegionNodeURI(uriPrefix, x, y, graph));
		return node;
	} // createRegionNode
	
	
	/**
	 * @param x
	 *            the x of the node in the lattice
	 * @param y
	 *            the y of the node in the lattice
	 * @return a title for a node
	 */
	private String createNodeTitle(double x, double y) {
		final StringBuilder sb = new StringBuilder("Node[");
		sb.append(Double.toString(x));
		sb.append(", ");
		sb.append(Double.toString(y));
		sb.append("]");
		return sb.toString();
	} // createNodeTitle
	
	
	/**
	 * @param x
	 *            the x of the region in the lattice
	 * @param y
	 *            the y of the region in the lattice
	 * @return a URI for the region node
	 */
	private URI createRegionNodeURI(String uriPrefix, double x, double y, Graph graph) {
		String nodeUriSuffix = uriPrefix+x+"_"+y;
		String nodeUriString = Node.URI_TYPE_NODE_SEGMENT + "/"
								+ graph.getURI().lastSegment()+"/"
								+ nodeUriSuffix;
		
        URI uri = STEMURI.createURI(nodeUriString);
		return uri;
	} // createRegionNodeURI
	
	
	/**
	 * @param x
	 *            the x of the region in the lattice
	 * @param y
	 *            the y of the region in the lattice
	 * @return a URI for the region node
	 */
	private URI createEdgeLabelURI(Node nodeA, Node nodeB) {
		URI uriA = nodeA.getURI();
		URI uriB = nodeB.getURI();
		String sA = uriA.lastSegment();
		String sB = uriB.lastSegment();
		// CommonBorderRelationshipLabelItemProvider
		// uses _ as a special character to separate the two nodes
		// so we need to replace it.
		sA=sA.replace('_','.');
		sB=sB.replace('_','.');
		String uriString = sA+"_"+sB;
        URI uri = STEMURI.createURI(uriString);
		return uri;
	} // createRegionNodeURI
	
	

	/**
	 * 
	 * @param graph
	 * @param nodeA
	 * @param nodeB
	 * @param borderLength
	 */
	private void createEdge(final Graph graph, final Node nodeA, final Node nodeB, int borderLength) {

		// create the edge
		final Edge edge = CommonBorderRelationshipLabelImpl.createCommonBorderRelationship(nodeA, nodeB, borderLength);
		
		URI edgeURI = edge.getURI();
		// the autogenerated edge uri is not correct. Need to replace it
		String sEdge = edgeURI.toString();
		int last = sEdge.lastIndexOf("/");
		String sEdge1 = sEdge.substring(0,last);
		String sEdge2 = sEdge.substring(last,sEdge.length());
		sEdge = sEdge1+"/relationship/commonborder"+sEdge2;
		URI newURI = URI.createURI(sEdge);
		edge.setURI(newURI);
		
		// now we need to set the uri for the label
		CommonBorderRelationshipLabel label = (CommonBorderRelationshipLabel)edge.getLabel();
		label.setURI(createEdgeLabelURI(nodeA, nodeB));

		final DublinCore dc = edge.getDublinCore();
		dc.setTitle(createEdgeTitle(nodeA, nodeB));
		
		graph.putEdge(edge);
	} // createEdgeList
	
	/**
	 * @param x
	 *            the x of the node in the lattice
	 * @param y
	 *            the y of the node in the lattice
	 * @return a title for a node
	 */
	private String createEdgeTitle(Node nodeA, Node nodeB) {
		String nA = nodeA.getDublinCore().getTitle();
		String nB = nodeB.getDublinCore().getTitle();
		final StringBuilder sb = new StringBuilder("Edge[(");
		sb.append(nA);
		sb.append(")<-->(");
		sb.append(nB);
		sb.append(")]");
		return sb.toString();
	} // createEdgeTitle

} //PajekNetGraphGeneratorImpl
