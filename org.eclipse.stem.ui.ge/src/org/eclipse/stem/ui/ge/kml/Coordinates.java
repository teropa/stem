package org.eclipse.stem.ui.ge.kml;
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

/**
 * Build a coordinates attribute for a KML document.
 * <pre>
 *    
 * </pre>
 * 
 *
 */
  
  
/*
<coordinates>
    32.567,-122.098,50 
  </coordinates>

*/   
public class Coordinates {
   
    private double _longitude;
    
    private double _latitude;
    
    private double _altitude;
    
    private boolean _isAltitudeSpecified;
    /**
     * Coordinates constructor without altitude.
     *    
     * Create a coordinate.
     * 
     * @param longitude
     * @param latitude
     */
    public Coordinates(double longitude,
            double latitude) {
        _longitude = longitude;
        _latitude = latitude;             
    }
    
    /**
     * Coordinates constructor with altitude.
     *    
     * Create a coordinate.
     * 
     * @param longitude
     * @param latitude
     * @param altitude
     */
    public Coordinates(double longitude,
            double latitude,
            double altitude) {
        this(longitude,latitude);        
        _isAltitudeSpecified = true;
        _altitude = altitude;
    }
    /**
     * 
     * @return String with longitude,latitude[,altitude] ) 
     */
    
    public String getCoordinates() {
        StringBuffer str = new StringBuffer();
        str.append(Double.toString(_longitude));
        str.append(",");
        str.append(Double.toString(_latitude));
        if (_isAltitudeSpecified) {
            str.append(",");
            str.append(Double.toString(_altitude));
        }
        return str.toString();
    }
    
    /**
     * 
     * @return longitude 
     */
    
    public double getLongitude() {
        return _longitude;
    }
    /**
     * 
     * @return latitude 
     */
    
    public double getLatitude() {
        return _latitude;
    }
    /**
     * 
     * @return altitude 
     */
    
    public double getAltitude () {
        return _altitude;
    }
    /**
     * Add coordinates to the Coordinates section
     *      
     * @param longitude
     * @param latitude
     */
    public void setCoordinates(double longitude,double latitude) {
        _longitude = longitude;
        _latitude = latitude;    
    }
    /**
     * Add coordinates to the Coordinates section (with altitude)
     *      
     * @param longitude
     * @param latitude
     * @param alt
     */
    public void setCoordinates(double longitude,
                               double latitude,int alt) {
        _longitude = longitude;
        _latitude = latitude;   
        _altitude = alt;
    }
    /**
     * return a set of coordinates as a String.
     * 
     *  This is needed to build a polygon from a
     *  list of points.
     *  
     *   long1,lat1,alt1 long2,lat2,alt2 ...
     * @param corners
     * @return String value
     */
    public static String toString(Coordinates[] corners) {
        
        StringBuffer strbuf = new StringBuffer(100);
        for (int i=0; i<corners.length; i++) {
            if (i!=0)
                strbuf.append(",");
            String v = Double.toString(corners[i].getLongitude());
            strbuf.append(v);
            strbuf.append(",");
            v = Double.toString(corners[i].getLatitude());
            strbuf.append(v);
            strbuf.append(",");
            if (corners[i]._isAltitudeSpecified) {
                v = Double.toString(corners[i].getLatitude());
                strbuf.append(v); 
            }
        }
        return strbuf.toString();
    }

	/**
	 * @return the _isAltitudeSpecified
	 */
	public boolean isAltitudeSpecified() {
		return _isAltitudeSpecified;
	}
    
    
} // end class
