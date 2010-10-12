package org.eclipse.stem.graphgenerators.impl;

/*******************************************************************************
* Copyright (c) 2010 IBM Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors: Armin Weiser, Matthias Filter
* Bundesinstitut für Risikobewertung
* FG 43 - Epidemiologie und Zoonosen
* Diedersdorfer Weg 1, 12277 Berlin
*
* IBM Corporation - initial API and implementation
*******************************************************************************/

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

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
import org.eclipse.stem.definitions.Activator;
import org.eclipse.stem.definitions.adapters.spatial.geo.InlineLatLongDataProvider;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder;
import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.edges.MigrationEdge;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabel;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue;
import org.eclipse.stem.definitions.edges.impl.EdgesFactoryImpl;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabel;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;
import org.eclipse.stem.definitions.labels.impl.CommonBorderRelationshipLabelImpl;
import org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl;
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET:
				return getDataFile_net();
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
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
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET:
				setDataFile_net((String)newValue);
				return;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
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
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET:
				setDataFile_net(DATA_FILE_NET_EDEFAULT);
				return;
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
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
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET:
				return DATA_FILE_NET_EDEFAULT == null ? dataFile_net != null : !DATA_FILE_NET_EDEFAULT.equals(dataFile_net);
			case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
				return area != AREA_EDEFAULT;
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
			    tok.wordChars('_','_'); // otherwise s_size wouldn't be detected
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
			    	// default values
			    	double x = 0, y = 0, z = 0;
			    	String shape = "box";
			    	double nodeArea = 0;
			    	Color shapeColor = null;
			    	LinkedHashMap<String, Double> vPopulation = new LinkedHashMap<String, Double>();

		    		String populationIdentifier = "";
			    	String parameter;
			    	
			    	// vertex/node number
			    	if (tok.nval != numNodes+1) {
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": usually successive numbering of vertices/nodes... Please check! Exiting!", null);
				    	input.close();
			    		return null;
			    	}
			    	else {
			    		nodeName[numNodes] = ""+(int)tok.nval;
			    	}
			    	
			    	// label
			    	ttype = getNextToken(tok); 
			    	if (ttype == StreamTokenizer.TT_WORD || ttype == '"') nodeName[numNodes] = tok.sval;
			    	else if (ttype == StreamTokenizer.TT_NUMBER) {
			    		nodeName[numNodes] = ""+(int)tok.nval;
			    	}
			    	else {
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": a label for the node/vertex is obligatory... Exiting!", null);
				    	input.close();
			    		return null;
			    	}
			    	
			    	// coordinates of vertex/node, at least x and y, z is not used at the moment
			    	ttype = getNextToken(tok);
			    	if (ttype == StreamTokenizer.TT_NUMBER)	{
			    		x = tok.nval;
			    	}
			    	/*
			    	else {
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": coordinates for the node/vertex are necessary... Exiting!", null);
			    		input.close();
			    		return null;
			    	} 	 
*/  	
			    	ttype = getNextToken(tok);
			    	if (ttype == StreamTokenizer.TT_NUMBER)	{
			    		y = tok.nval;
			    	}

			    	ttype = getNextToken(tok);
			    	if (ttype == StreamTokenizer.TT_NUMBER)	{
			    		z = tok.nval;
			    	}

			    	// shape
		    		ttype = getNextToken(tok);
			    	if (ttype == StreamTokenizer.TT_WORD) {
			    		parameter = tok.sval.toLowerCase();
			    		if (parameter.equals("ellipse") || parameter.equals("box") || parameter.equals("diamond") || parameter.equals("triangle") || parameter.equals("cross") || parameter.equals("empty")) {
			    			shape = parameter;
			    		}
			    		else {
			    			tok.pushBack();
			    		}
			    	}

					/* other interesting parameters:
					ñ s_size ñ default size
					ñ bc ñ boundary color of vertex
					*/
		    		while(ttype != StreamTokenizer.TT_EOF) {
		    			ttype = getNextToken(tok);
		    			if (ttype == StreamTokenizer.TT_WORD) {
		    				parameter = tok.sval.toLowerCase();
		    				if (parameter.equals("s_size")) {
		    					ttype = getNextToken(tok);
		    					if (ttype == StreamTokenizer.TT_NUMBER) {
		    						nodeArea = tok.nval;
		    					}
		    			    	else {
		    			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": size of node has wrong format... Exiting!", null);
		    			    		input.close();
		    			    		return null;
		    			    	} 
		    				}
		    				else if (parameter.equals("bc")) {
		    					ttype = getNextToken(tok);
		    					if (ttype == StreamTokenizer.TT_WORD) {
		    						shapeColor = getColor(tok.sval);
		    					}
		    			    	else {
		    			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": shapeColor value has wrong format... Exiting!", null);
		    			    		input.close();
		    			    		return null;
		    			    	} 
		    				}
		    				else if (parameter.equals("popcount")) {
		    					ttype = getNextToken(tok);
		    					if (ttype == StreamTokenizer.TT_NUMBER) {
		    						//populationCount = tok.nval;
		    						vPopulation.put(populationIdentifier, tok.nval);
		    					}
		    			    	else {
		    			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": popCount value has wrong format... Exiting!", null);
		    			    		input.close();
		    			    		return null;
		    			    	} 
		    				}
		    				else if (parameter.equals("popid")) {
		    					ttype = getNextToken(tok);
		    					if (ttype == StreamTokenizer.TT_WORD) {
		    						populationIdentifier = tok.sval;
		    					}
		    			    	else {
		    			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": popCount value has wrong format... Exiting!", null);
		    			    		input.close();
		    			    		return null;
		    			    	} 
		    				}
		    				else {
		    					ttype = getNextToken(tok);
		    				}
		    			}
		    		}
					
			    	// Thats it. At the moment we are not interested in more parameters, maybe later...
			    	// Creating node:

		    		final Region regionNode = createRegionNode("PAJ_NET_" + nodeName[numNodes] + "_", x, y, graph);
					
			    	double area = (nodeArea > 0 ? nodeArea : getArea());
					final AreaLabel areaLabel = LabelsFactory.eINSTANCE.createAreaLabel();
					areaLabel.getCurrentAreaValue().setArea(area);
					regionNode.getLabels().add(areaLabel);
										
					final LatLong nodeSegments = createNodePolygon(x,y,area,shape);
					final String spatialURIString = InlineLatLongDataProvider.createSpatialInlineURIString(nodeSegments);
					regionNode.getDublinCore().setSpatial(spatialURIString);
					
					nodeHolder[numNodes] = regionNode;
							    							
					graph.putNode(regionNode);
			    	numNodes++;

			    	for (Map.Entry<String, Double> entry : vPopulation.entrySet()) {
			    		String populationID = entry.getKey();
			    		if (populationID.length() > 0) {
			    			double populationCount = entry.getValue();
							// Create a new population label
							PopulationLabel newLabel = LabelsFactory.eINSTANCE.createPopulationLabel();
							newLabel.setPopulationIdentifier(populationID);
							//newLabel.setName(populationID + "_" + populationCount);
							//newLabel.setPopulatedArea(area);
							newLabel.setURIOfIdentifiableToBeLabeled(regionNode.getURI());
							newLabel.setNode(regionNode);
							URI newURI = createPopulationLabelURI(regionNode, populationID);
							graph.getNodeLabels().put(newURI, newLabel);
							initializeLabel(newLabel, populationID, populationCount);							    			
			    		}
			    	}
			    }
			    else if (doEdges && ttype == StreamTokenizer.TT_NUMBER) { // Edges = Arcs
			    	int a, b = 0;
			    	int borderLength = 0;

		    		double[] migrationRates = new double[2];
		    		migrationRates[0] = 0; migrationRates[1] = 0;
		    		String populationIdentifier = "";
			    	LinkedHashMap<String, double[]> vPopulation = new LinkedHashMap<String, double[]>();
		    		Color edgeColor = null;
			    	
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
			    	if (ttype == StreamTokenizer.TT_NUMBER)	{
			    		borderLength = (int) tok.nval;
			    	}
			    	else if (ttype == StreamTokenizer.TT_EOF) {
			    		// borderLength is not defined - no problem for MigrationEdges
			    	}
			    	else {
			    		tok.pushBack();
			    		/*
			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": wrong arcs format. Cannot identify value of arc between node " + a + " and node " + b + " ... Exiting!", null);
			    		input.close();
			    		return null;
			    		*/
			    	}			    	
			    	if (borderLength < 0) borderLength *= -1;

		    		while(ttype != StreamTokenizer.TT_EOF) {
		    			ttype = getNextToken(tok);
		    			if (ttype == StreamTokenizer.TT_WORD) {
		    				String parameter = tok.sval.toLowerCase();
		    				if (parameter.equals("c")) {
		    					ttype = getNextToken(tok);
		    					if (ttype == StreamTokenizer.TT_WORD) {
		    						edgeColor = getColor(tok.sval);
		    					}
		    			    	else {
		    			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": color of edge has wrong format... Exiting!", null);
		    			    		input.close();
		    			    		return null;
		    			    	} 
		    				}
		    				else if (parameter.equals("rateab")) {
		    					ttype = getNextToken(tok);
		    					if (ttype == StreamTokenizer.TT_NUMBER) {
		    						//migrationRateAB = tok.nval;
		    						migrationRates[0] = tok.nval;
		    						vPopulation.put(populationIdentifier, migrationRates);
		    					}
		    			    	else {
		    			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": migration rate AB of edge has wrong format... Exiting!", null);
		    			    		input.close();
		    			    		return null;
		    			    	} 
		    				}
		    				else if (parameter.equals("rateba")) {
		    					ttype = getNextToken(tok);
		    					if (ttype == StreamTokenizer.TT_NUMBER) {
		    						//migrationRateBA = tok.nval;
		    						migrationRates[1] = tok.nval;
		    						vPopulation.put(populationIdentifier, migrationRates);
		    					}
		    			    	else {
		    			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": migration rate BA of edge has wrong format... Exiting!", null);
		    			    		input.close();
		    			    		return null;
		    			    	} 
		    				}
		    				else if (parameter.equals("popid")) {
		    					ttype = getNextToken(tok);
		    					if (ttype == StreamTokenizer.TT_WORD) {
		    						populationIdentifier = tok.sval;
		    					}
		    			    	else {
		    			    		Activator.logError("Pajek importing: " + pajekNETFileURI.getName() + ": population identifier of edge has wrong format... Exiting!", null);
		    			    		input.close();
		    			    		return null;
		    			    	} 
		    				}
		    			}
		    		}

		    		if (vPopulation.size() == 0) {
				    	createCommonBorderEdge(graph,nodeHolder[a-1],nodeHolder[b-1], borderLength);		    			
		    		}
		    		else {
				    	for (Map.Entry<String, double[]> entry : vPopulation.entrySet()) {
				    		String populationID = entry.getKey();
				    		if (populationID.length() > 0) {
					    		migrationRates = entry.getValue();
					    		createMigrationEdge(graph,nodeHolder[a-1],nodeHolder[b-1], entry.getKey(), migrationRates[0], migrationRates[1]);
				    		}
				    	}
		    		}
			    				    	
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
		while((ttype = tok.nextToken()) != StreamTokenizer.TT_WORD && ttype != StreamTokenizer.TT_NUMBER && ttype != StreamTokenizer.TT_EOF && ttype != '"') {
			;
		}
		return ttype;
	}		
	private Color getColor(String strColor) {
		String c = strColor.toLowerCase();
		if (c.equals("black")) return Color.BLACK;
		else if (c.equals("blue")) return Color.BLUE;
		else if (c.equals("cyan")) return Color.CYAN;
		else if (c.equals("gray")) return Color.GRAY;
		else if (c.equals("green")) return Color.GREEN;
		else if (c.equals("magenta")) return Color.MAGENTA;
		else if (c.equals("orange")) return Color.ORANGE;
		else if (c.equals("pink")) return Color.PINK;
		else if (c.equals("red")) return Color.RED;
		else if (c.equals("white")) return Color.WHITE;
		else if (c.equals("yellow")) return Color.YELLOW;
		else return Color.BLACK;
	}
	
	


	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param area
	 * @return
	 */
	private LatLong createNodePolygon(final double x, double y, double area, String shape) {
		final LatLong retValue = new LatLong();
		
		final SegmentBuilder sb = new SegmentBuilder();
		// ellipse box diamond triangle cross empty
		if (shape.toLowerCase().equals("triangle")) {
			double areax2 = Math.sqrt(4 * area / Math.sqrt(3)) / 2;
			double areay = areax2 / Math.sqrt(3);
			sb.add(x-areax2, y-areay);
			sb.add(x+areax2, y-areay);
			sb.add(x, y+2*areay);
			sb.add(x-areax2, y-areay);
		}
		else if (shape.toLowerCase().equals("cross")) {
			double area2 = Math.sqrt(2 * area / Math.sqrt(3)) / 2;
			sb.add(x+area2, y+area2);
			sb.add(x-area2, y-area2);
			sb.add(x-area2, y+area2);
			sb.add(x+area2, y-area2);
			sb.add(x+area2, y+area2);
		}
		else if (shape.toLowerCase().equals("ellipse")) { // circle
			double r = Math.sqrt(area / Math.PI);
			int numSegs = 20;
			for (int i=0;i<=numSegs;i++) {
				sb.add(x + r * Math.cos(2*Math.PI*i/numSegs), y + r * Math.sin(2*Math.PI*i/numSegs));
			}
		}
		else { // box,diamond,empty,default
			double area2 = Math.sqrt(area) / 2;
			// We just make a square...
			sb.add(x-area2, y-area2);
			sb.add(x-area2, y+area2);
			sb.add(x+area2, y+area2);
			sb.add(x+area2, y-area2);
			sb.add(x-area2, y-area2);
		}
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
	 * 
	 * @param graph
	 * @param nodeA
	 * @param nodeB
	 * @param borderLength
	 */
	private void createCommonBorderEdge(final Graph graph, final Node nodeA, final Node nodeB, int borderLength) {

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
		label.setURI(createEdgeLabelURI(nodeA.getURI(), nodeB.getURI()));

		final DublinCore dc = edge.getDublinCore();
		dc.setTitle(createEdgeTitle(nodeA, nodeB));
		
		graph.putEdge(edge);
	} // createCommonBorderEdge
	
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

	/**
	 * 
	 * @param uriA
	 * @param uriB
	 * @return
	 */
	private static URI createEdgeLabelURI(URI uriA, URI uriB) {
		String sA = uriA.lastSegment();
		String sB = uriB.lastSegment();
		
		// MigrationEdgeLabelItemProvider
		// uses _ as a special character to separate the two nodes
		// so we need to replace it.
		sA=sA.replace('_','.');
		sB=sB.replace('_','.');
		String uriString = sA+"_"+sB;
		
		//System.out.println("createEdgeLabelURI() : FINALLY, uri = "+uriString);
		
        URI uri = STEMURI.createURI(uriString);
		return uri;
	} // createEdgeLabelURI
	
	

	
	
	private void createMigrationEdge(final Graph graph, final Node nodeA, final Node nodeB, String populationIdentifier, double migrationRateAB, double migrationRateBA) {
		URI sourceURI = nodeA.getURI();
		URI targetURI = nodeB.getURI();
		
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
		melv1.setMigrationRate(migrationRateAB);
		MigrationEdgeLabelValue melv2 = label2.getCurrentValue();
		melv2.setMigrationRate(migrationRateBA);
		
		final DublinCore dc1 = mEdge1.getDublinCore();
		dc1.setTitle(createMigrationEdgeTitle(sourceURI, targetURI));
		
		final DublinCore dc2 = mEdge2.getDublinCore();
		dc2.setTitle(createMigrationEdgeTitle(targetURI, sourceURI));
		
		mEdge1.setPopulationIdentifier(populationIdentifier);
		mEdge2.setPopulationIdentifier(populationIdentifier);
		
		graph.putEdge(mEdge1);
		graph.putEdge(mEdge2);		
	}
	
	
	/**
	 * @param x
	 *            the x of the node in the lattice
	 * @param y
	 *            the y of the node in the lattice
	 * @return a title for a node
	 */
	public static String createMigrationEdgeTitle(URI uriA, URI uriB) {
		String sA = uriA.lastSegment();
		String sB = uriB.lastSegment();
		final StringBuilder sb = new StringBuilder("MigrationEdge[(");
		sb.append(sA);
		sb.append(")<-->(");
		sb.append(sB);
		sb.append(")]");
		
		return sb.toString();
	} // createEdgeTitle


	private URI createPopulationLabelURI(Node n, String population) {
		int adminLevel = Utility.keyLevel(n.getURI().lastSegment());
		String countryCode = getCountryCode(n);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String code = n.getURI().lastSegment();
		
		return PopulationLabelImpl.createPopulationLabelURI(adminLevel, countryCode, population, year+"", code);
	}
	private String getCountryCode(Node n) {
		if(Utility.keyLevel(n.getURI().lastSegment()) == 0) return n.getURI().lastSegment();
		else for(Edge e:n.getEdges()) 
			if(Utility.keyLevel(e.getA().getURI().lastSegment()) < Utility.keyLevel(n.getURI().lastSegment()))
			return getCountryCode(e.getA());
		
		return "ZZZ"; // Not found, but ZZZ is the parent of everything
	}
	private void initializeLabel(PopulationLabel lab, String populationIdentifier, double populationCount) {
		 PopulationLabelValue plv = lab.getCurrentPopulationValue();
		 plv.setCount(populationCount);
		
		// Set the valid year to the start year of the sequencer		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		lab.setValidYear(year);
		
	}
} //PajekNetGraphGeneratorImpl
