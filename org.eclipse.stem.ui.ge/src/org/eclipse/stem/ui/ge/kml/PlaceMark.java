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
import org.w3c.dom.Text;

/**
 * Build the PlaceMark section of a KML document.
 */
public class PlaceMark {
   
    private Element _placemark = null;
    
    private Document _doc = null;
    /**
     * PlaceMark constructor
     * @param doc 
     */
    public PlaceMark(Document doc) {
        _doc = doc;
        _placemark = _doc.createElement("Placemark");
       
        
    }
    
    /**
     * @return PlaceMark Element 
     */
    public Element getElement() {
        return _placemark;
    }
    
    /**
     * Add a description tag to the PlaceMark
     * @param description
     */
    public void setDescription(String description) {
       
        Element desc = _doc.createElement("description");
        Text t = _doc.createTextNode(description);
        desc.appendChild(t);        
        _placemark.appendChild(desc);
    }
    
    /**
     * Add a description tag to the PlaceMark
     * @param name
     */
    public void setName(String name) {
       
        Element nm = _doc.createElement("name");
        Text t = _doc.createTextNode(name);
        nm.appendChild(t);        
        _placemark.appendChild(nm);
    }
    
    /**
     * Add a visibility tag to the PlaceMark
     * @param value   Usually "0"
     */
    public void setVisibility(String value) {
        
        Element v = KmlDoc.createAttr(_doc,"visibility","0");     
        _placemark.appendChild(v);
          
    }
    
    /**
     * Add a styleUrl pointing to an existing Style 
     * @param style Style object
     */
    public void setStyleUrl(Style style) {
       String id = style.getId();
       Element url = KmlDoc.createAttr(_doc,"styleUrl","#"+id);            
       _placemark.appendChild(url);
       
    }
    /**
     * Add a section (i.e. LookAt) to the PlaceMark
     * @param element
     */
    public void appendChild(Element element) {            
        _placemark.appendChild(element);
    }
} // end class
