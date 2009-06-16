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

/*
 * <Polygon>
 * 
 *   <outerBoundaryIs>
 * 
 *     <LinearRing>
 * 
 *        <coordinates>
 * 
 * -88.306534, 30.227852, 0.000000
 * 
 * ...
 * 
 * 88.306534, 30.227852, 0.000000
 * 
 *        </coordinates>
 * 
 *    </LinearRing>
 * 
 *   </outerBoundaryIs>
 * 
 * </Polygon>
 * 
 */   
/**
 * Build the Polygon section of a KML document.
 */
  
  


public class Polygon {
   
    private Element _polygon = null;
    
    private Element _outerBoundaryIs = null;
    
    
    private Document _doc = null;
    /**
     * Polygon constructor
     * @param doc 
     */
    public Polygon(Document doc) {
        _doc = doc;
        _polygon = _doc.createElement("Polygon");          
        
    }
    
    /**
     * @return Polygon Element 
     */
    public Element getElement() {
        return _polygon;
    }

    /**
     * Add coordinates to the Polygon section.
     * 
     * This is a shortcut for creating a LinearRing 
     * inside of an outerBoundaryIs.
     *      
     * @param corners  coordinates of the corners 
     *    for the outerRing 
     * @return xml element
     * 
     */
    public Element setCoordinates(Coordinates[] corners) {
        
        String coords = Coordinates.toString(corners);
        
        return setCoordinates(coords);
    }
    
    /**
     * Add coordinates to the Polygon section.
     * 
     * This is a shortcut for creating a LinearRing 
     * inside of an outerBoundaryIs.
     *      
     * @param coords  coordinates of the corners 
     *    for the outerRing 
     * @return xml element
     * 
     */
    public Element setCoordinates(String coords) {        
        
        Element e = KmlDoc.createAttr(_doc,"coordinates",coords);
        Element linearRing = _doc.createElement("LinearRing");        
        linearRing.appendChild(e);
        _outerBoundaryIs = _doc.createElement("outerBoundaryIs");
        _outerBoundaryIs.appendChild(linearRing);
        _polygon.appendChild(_outerBoundaryIs);
        return _outerBoundaryIs;
    }
    

    
} // end class
