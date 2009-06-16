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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Build the point section of a KML document.
 */
  
  
/*
<Point>    
    <coordinates>-122.0856204541786,37.42244015321688,50</coordinates>
  </Point>

*/   
public class Point {
   
    private Element _point = null;
    
    private Document _doc = null;
    /**
     * Point constructor
     * @param doc 
     */
    public Point(Document doc) {
        _doc = doc;
        _point = _doc.createElement("Point");
          
        
    }
    
    /**
     * @return Point Element 
     */
    public Element getElement() {
        return _point;
    }

    /**
     * Add coordinates to the Point section
     *      
     * @param longitude
     * @param latitude
     */
    public void setCoordinates(double longitude,double latitude) {
        String coord =  Double.toString(longitude)+","+
                        Double.toString(latitude);
        Element e = KmlDoc.createAttr(_doc,"coordinates",coord);             
        _point.appendChild(e);
       
    }
    /**
     * Add coordinates to the Point section (with altitude)
     *      
     * @param longitude
     * @param latitude
     * @param alt
     */
    public void setCoordinates(double longitude,double latitude,int alt) {
        String coord =  Double.toString(longitude)+","+
                        Double.toString(latitude)+","+Integer.toString(alt);
        Element e = KmlDoc.createAttr(_doc,"coordinates",coord);             
        _point.appendChild(e);
       
    }
    
    /**
     * Add coordinates as a String to the Point section 
     *      
     * @param coord LatLong coordinates
     * 
     */
    public void setCoordinates(String coord) {
       
        Element e = KmlDoc.createAttr(_doc,"coordinates",coord);             
        _point.appendChild(e);
       
    }
    
} // end class
