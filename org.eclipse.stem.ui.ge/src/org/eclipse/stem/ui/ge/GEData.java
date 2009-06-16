package org.eclipse.stem.ui.ge;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/ 
import java.awt.Polygon;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong;
import org.eclipse.stem.ui.ge.views.GEPreferencePage;



/**
 * Store info about a geographic location and SEIR status in STEM.
 * It would represent an area such as a US county and
 * contains an id and the border expressed as one or more
 * list of points.  The points are Longitude and latitude.
 * 
 * Note that (perhaps for an island group) there may be 
 * more than 1 list of points.
 * 
 * It also contains the values for various aspects relative to Population
 * For SEIR diceases, these aspects would be Susceptible,Exposed,
 * Infectious, and Recovered  There may be more or less aspects.
 * These are stored in a Map keyed by aspect code.
 *
 */
public class GEData {
    /**
     * Name of the Admin area involved
     */
	private String name = "";
	/**
	 * Can be set by the creater with setDescription.
	 * Usually used for the list of relative values
	 */
	private String description = "";
	
	/**
	 * used to set the kml id
	 */
	private String id = "";
	/** 
	 * used to format the longitude/latitude values
	 * default of DecimalFormat() would result in 3 digit precision 
	 */
	
	private static final DecimalFormat df = new DecimalFormat("####.##");
	
    /**
     * A LatLong instance is a collection of latitude/longitude data pairs partititioned
     * into one or more "segments". Each segment is a sequence of latitude/longitude
     * data pairs. A segment could form a closed polygon or it could be a path.
     * In our case this should always be a closed polygon.
     * <pre>
     * Each LatLong describes 1 or more polygon border. There may be 
     *   more than one polygon in the case of an island or ...
     * 
     *  </pre>
     */	
    private LatLong polygons = null;
    
    /**
     * Contains the aspect values for the area
     * Keyed by the aspect code. 
     * For Example. with an SEIR disease you would have
     * keyed entries for "S", "E", "I" and "R"   
     */
    private final Map<String,Double> valueMap = new HashMap<String,Double>(8); 
    /**
     * Bounding Box for this LatLong polygon.  
     * If LatLong contains more than 1 polygon this is the 
     * union of the BoundingBox for each polygon
     */
    private Rectangle bBox = null;
    
    private double[] placemark = null;
    
	/**
	 * Create an instance of GEData with LatLong
	 * @param name
	 * @param areas
	 */
	public GEData(String name, LatLong areas) {
		super();
		this.name = name;
		this.id = name;
		this.polygons = areas;
		//if (areas.size() > 1) {
		//	GELog.debug(this,name+": "+areas.size());
		//}
		if (GEPreferencePage.isBBOX()) {
			this.bBox = getBBox(areas);
		}
		
	} 
	/**
	 * Create an instance of GEData with LatLong
	 * @param id    admin area id
	 * @param name  admin area name
	 * @param areas lat/long border of 1 of more polygons
	 */
	public GEData(String id, String name, LatLong areas) {
		super();
		this.name = name;
		this.id = id;
		this.polygons = areas;
		//if (areas.size() > 1) {
		//	GELog.debug(this,name+": "+areas.size());
		//}
		if (GEPreferencePage.isBBOX()) {
			this.bBox = getBBox(areas);
		}
		
	} 
	/**
	 * 
	 * format needed by KML 
	 *    long,lat long,lat ...
	 *    
	 * By default DecimalFormat will return 
	 * doubles as nnnn.ddd 
	 *    
	 * @param numArea Normally 0 if just 1 contagious area 
	 *                but it could be a set of islands or
	 *                other multiple areas. 
	 * @return the coordinates as a String in the form
	 *   long1,lat1 long2,lat2 ...
	 */
	public String getCoordinatesAsString(int numArea) {
		Segment segment = polygons.getSegments().get(numArea);		
		// we don't care about altitude 
		
		StringBuffer strbuf = new StringBuffer(400);	
		final int size = segment.size();
		for (int i=0; i< size; i++) {			
			strbuf.append(df.format(segment.longitude(i)));
			strbuf.append(",");
			strbuf.append(df.format(segment.latitude(i) ));
			strbuf.append(" ");
		}
		return strbuf.toString();
	}
	/**
	 * 
	 *Get the aspect values as a String
	 *        
	 * 
	 * @return the values as a String in the form
	 *   a1: v1 a2:v2 ...
	 */
	public String getValuesAsString() {
				
		StringBuffer strbuf = new StringBuffer(64);
		for(Map.Entry<String, Double> entry: valueMap.entrySet() ) {
		    strbuf.append(entry.getKey());
			strbuf.append(":");
			strbuf.append(df.format(entry.getValue()));
			strbuf.append(" ");
		}
		
		
		return strbuf.toString();
	}

	/**
	 * get the number of areas described by the geographic points.
	 * 
	 * @return number of polygons described
	 */
    public int getNumAreas() {
    	if (polygons != null)
    	  return polygons.size();
    	else 
    	  return 0;
    }
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the bBox rectangle
	 */
	public Rectangle getBBox() {
		return bBox;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * set the coordinates of a point within a polygon
	 * @param latitude
	 * @param longitude
	 */
	public void setPoint(double latitude, double longitude) {
		placemark = new double[2];
		placemark[0] = latitude;
		placemark[1] = longitude;
	}
	/**
	 * Return the coordiantes of a point 
	 * 
	 * @return Double[] or null
	 */
	public double[] getPoint() {
		return placemark;
	}
	
	/**
	 * Given a LatLong, generate the overall BoundingBoxes.
	 * 
	 * @param latLong
	 * @return Rectangle
	 */
	private static Rectangle getBBox(LatLong latLong) {
		
		List<Segment> list = latLong.getSegments();
		int numareas = list.size();
		Rectangle bBox = null;
		for (int i=0; i<numareas; i++) {
			final Polygon polygon = new Polygon();
			final Segment segment = list.get(i);
			final int size = segment.size();
			for (int p=0; p< size; p++) {
				double x = segment.longitude(p);
				double y = segment.latitude(p);
				int xint = (int)((x+180)*1000);
				int yint = (int)((y+90)*1000);
				polygon.addPoint(xint, yint);
			} // for
			
			if (bBox == null)
				bBox = polygon.getBounds();
			else 
				bBox = bBox.union(polygon.getBounds());
		}
		   
		return bBox;
	}
	
	
	/**
	 * debug helper
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("GEData: ");
		sb.append(this.getValuesAsString());
		sb.append(" BBox:"+bBox);
		sb.append(" : ");
		for (int i=0; i< polygons.size(); i++) {			
			sb.append(this.getCoordinatesAsString(i));
		}
				
		return sb.toString();
	}

	/**
	 * @return the valueMap for the specified area so 
	 * we can store values into it.
	 */
	public Map<String,Double> getValueMap() {
		return valueMap;
	}
	/**
	 * @param aspect 
	 * @return the value for the specified alpect
	 */
	public double getValue(Aspect aspect) {
		return valueMap.get(aspect.getCode());
	}
	
	/**
	 * Store the value in the data store for the area.
	 * 
	 * @param aspect  The aspect that this value is for. 
	 * @param value the value for the specified aspect
	 */
	public void setValue(Aspect aspect, double value) {
		valueMap.put(aspect.getCode(),value);
	}

	/**
	 * @return the center of the BBox as longitude and latitude.
	 */
	public double[] getBBoxCenter() {
		
		if (bBox == null) {
			bBox = getBBox(polygons);
		}
		if (bBox != null ) {
    		// convert back to double value.
    		double longitude = bBox.getCenterX();
    		longitude = (longitude-180000)/1000;
    		double latitude  = bBox.getCenterY();
    		latitude = (latitude-90000)/1000;
    		
    		double[] center = new double[] {longitude,latitude};
    		return center;
    	} 
		return null;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
