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
 * Build the Style section of a KML document.
 * <pre>
 *    
 * </pre>
 * 
 *
 */
  
  
/*
    <Style> 
          <LineStyle >
            <width>3.0</width>
            <color>7d00ffff</color>
          </LineStyle>
          <PolyStyle>
           <fill>0</fill>
           <outline>0</outline>
          </PolyStyle>
       
     </Style>
*/   
public class Style {
   
    private Element _style = null;
    
    private Document _doc = null;
    
    private String  _id = "StyleURL";
    /**
     * Style constructor
     * @param doc 
     */
    public Style(Document doc) {
        _doc = doc;
        _style = _doc.createElement("Style");
          
        
    }
    /**
     * Style constructor
     * @param doc 
     * @param id 
     */
    public Style(Document doc,String id) {
        _doc = doc;
        _id = id;
        _style = _doc.createElement("Style");
        _style.setAttribute("id",_id);  
        
    }
    /**
     * @return Style Element 
     */
    public Element getElement() {
        return _style;
    }
    /**
     * @return id 
     */
    public String getId() {
        return _id;
    }
    /**
     * Add LineStyle to the Style section
     *      
     * Color is of hexidecimal form oobbggrr where:
     *   oo is 00-ff opacity value
     *   bb is 00-ff blue
     *   gg is 00-ff green
     *   rr is 00-ff red 
     *  so 7fff0000 is Blue with 50%  opacity
     *       
     * @param width line width (e.g. 3.0) 
     * @param color line color (e.g. 7d00ffff)
     */
    public void setLineStyle(float width,String color) {
        Element lineStyle = _doc.createElement("LineStyle");                     
        _style.appendChild(lineStyle);
        Element e = KmlDoc.createAttr(_doc,"width",Float.toString(width)); 
        lineStyle.appendChild(e);
        e = KmlDoc.createAttr(_doc,"color",color); 
        lineStyle.appendChild(e);
    }
   
    /**
     * Add LineStyle to the Style section
     *      
     * @param width line width (e.g. 3.0) 
     * 
     */
    public void setLineStyle(double width) {
        Element lineStyle = _doc.createElement("LineStyle");                     
        _style.appendChild(lineStyle);
        Element e = KmlDoc.createAttr(_doc,"width",Double.toString(width)); 
        lineStyle.appendChild(e);
        
    }
    /**
     * Add PolyStyle to the Style section
     * @param color  KML color
     * @param outline true if outline option to be added
     */
    public void setPolyStyle(String color, boolean outline) {
        Element polyStyle = _doc.createElement("PolyStyle");                     
        _style.appendChild(polyStyle);
        Element e = null;
        if (! outline) { // default is true
            e = KmlDoc.createAttr(_doc,"outline","0");
            polyStyle.appendChild(e); 
        } 
        if (color.equals("0")) {
            e = KmlDoc.createAttr(_doc,"fill","0");
            polyStyle.appendChild(e);
        } else {
            e = KmlDoc.createAttr(_doc,"fill","1");
            polyStyle.appendChild(e);
            e = KmlDoc.createAttr(_doc,"color",color);        
            polyStyle.appendChild(e);
        }
        
    }
    
    /**
     * Add BaloonStyle to the Style section
     * <pre>
     *    <BalloonStyle>      
            <bgColor>ffffffbb</bgColor>      
            <text><![CDATA[
               <b><font color="#CC0000" size="+3">$[name]</font></b>
               <br/><br/>
               <font face="Courier">$[description]</font>
               <br/><br/>    
               ]]>
             </text>
         </BalloonStyle>
     * </pre>
     * @param color  KML color
     * @param outline true if outline option to be added
     */
    public void setBalloonStyle() {
        Element balloonStyle = _doc.createElement("BalloonStyle");                     
        _style.appendChild(balloonStyle);
        Element e = null;
 
        String text = "<b><font color=\"#CC0000\" size=\"+3\">$[name]</font></b> \n" +
                      "<br/><br/> \n" +
                      "<font face=\"Courier\">$[description]</font> \n" +
                      "<br/><br/> "; 

       e = KmlDoc.createCDataAttr(_doc,"text",text);
       balloonStyle.appendChild(e);
    }
} // end class
