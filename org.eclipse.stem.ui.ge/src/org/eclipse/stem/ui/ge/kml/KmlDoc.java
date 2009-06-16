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
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.stem.ui.ge.GELog;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;



/**
 * Utility class used for Google Earth KML support.
 * 
 *  This class is used to build a KML file to be passed to
 *  Google Earth.  
 *  
 *  It basically creates an XML file using KML related arguments.
 *  
 *  See the example in the "main()" method for an example of 
 *  how to use the class.
 * 
 *
 *
 */
public class KmlDoc {

    

    /**
     * This class name
     */
    private static final String _className = "KmlDoc";

    

    /**
     * 
     * A KML document
     */
    private Document _doc;
    
    //private Element _root = null;
   
    /**
     * Construct an instance of KmlDoc.
     * 
     * The Document object is created but nothing is put
     * into it.
     * 
     */
    public KmlDoc() {
        String methodName = _className + ".KmlUtil(constructor) ";
        // Create a new parser using the JAXP API (javax.xml.parser)
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = factory.newDocumentBuilder();
            if (docBuilder != null)
              _doc = docBuilder.newDocument();
        } catch (ParserConfigurationException pce) {
            debug(methodName+ " Error configuring xml document builder"
                    + pce.getMessage());
        }// try

                

    } // constructor

    /**
     * Setup the root of the KML document.
     * 
     * 
     * @param xmlns Value for xmlns 
     * (if null,  use default "http://earth.google.com/kml/2.0")
     * @return xml element
     */
    
    public Element setRoot(String xmlns) {
        //String methodName = _className + ".setRoot ";
        if (xmlns == null)
          xmlns="http://earth.google.com/kml/2.1";     
        
        Element root = _doc.createElement("kml");
        root.setAttribute("xmlns",xmlns);
        _doc.appendChild(root);
        return root;
    } // 

    
    /**
     * 
     * Write an Xml document to an outputStream
     * 
     *
     * @param xmlFileName_
     */

    public  void writeFile(String xmlFileName_) {

        try { 

            FileOutputStream outputStream = new FileOutputStream(xmlFileName_);  
            write(outputStream);
            
        } catch (Exception e) {
        	debug(e);
        }
   }
    /**
     * 
     * Write an Xml document to an outputStream
     * 
     *
     * @param os Allocated output Stream
     */

    public  void write(OutputStream os) {
        try {
            // Use a Transformer for output
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            // turn on indentations
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
          
            // the document source
            DOMSource docSource = new DOMSource(_doc);
            
            StreamResult result = new StreamResult(os);

            // output the doc
            transformer.transform(docSource, result);

            os.flush();

            os.close();

        } catch (Exception e) {
            debug(e);
        }
    } // end write
    
    
    /**
     * Display the current Kml document on stdOut.
     *   <br>
     *      * 
     * 
     */

    public void display() {

        try {
            
            // Use a Transformer for output
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            // turn on indentations
            transformer.setOutputProperty("indent", "yes");

          
            // the document source
            DOMSource docSource = new DOMSource(_doc);

            // the stream
            
            StreamResult result = new StreamResult(System.out);

            // output the doc
            transformer.transform(docSource, result);

            
           

        } catch (Exception e) {
            debug(e);
        }
    } // end display
    
    /**
     * debug output method 
     * @param msg 
     */
    public void debug(String msg) {
        GELog.debug(this,msg);
        
    }
    

    /**
     * debug output method 
     * @param method 
     * @param msg 
     */
    public void debug(String method,String msg) {
        GELog.debug(this,method+msg);
        
    }

    /**
     * debug output method 
     * @param t 
     */
    public void debug(Throwable t) {
        GELog.error("KmlDoc failure",t);
        
    }
    /**
     * debug output method 
     * @param msg 
     * @param t 
     */
    public void debug(String msg,Throwable t) {
    	GELog.error("KmlDoc: "+msg,t);
        
    }

    /**
     * @return Returns the _doc.
     */
    public Document getDocument() {
        return _doc;
    }

    /**
     * @param _doc The _doc to set.
     */
    public void setDocument(Document _doc) {
        this._doc = _doc;
    }
    /**
     * Utility method to Create an element that has 
     * a name and value only. 
     * <pre>
     * There is probably a better way to do this but ...
     *  
     *   
     *   
     * * @param doc Document
     * @param tag  xml tag
     * @param value  string value of tag
     * @return XML element
     */
    
    public static Element createAttr(Document doc,String tag,String value) {
       
        Element nm = doc.createElement(tag);
        Text t = doc.createTextNode(value);
        nm.appendChild(t);        
        return nm;
    }
    /**
     * Utility method to Create an element that has 
     * a name and CData value only. 
     * <pre>
     * There is probably a better way to do this but ...
     *  
     *   
     *   
     * * @param doc Document
     * @param tag  xml tag
     * @param value  string value of tag
     * @return XML element
     */
    
    public static Element createCDataAttr(Document doc,String tag,String value) {
       
        Element nm = doc.createElement(tag);
        Text t = doc.createCDATASection(value);
        nm.appendChild(t);        
        return nm;
    }
    /**
     * Utility method to append an element that has 
     * no values. 
     * <pre>     
     *  Creates an XML tag and
     *  places it in the document as a child of the 
     *  specified element.
     *  
     *   Creates <tag>value</tag> 
     * </pre>
     * 
     * 
     * @param element existing element where new tag is to go
     * @param tag XML tag
     * 
     * @return XML element
     */
     
    public Element appendElement(Element element,String tag) {
        
        Element newtag = _doc.createElement(tag);       
        element.appendChild(newtag);
        return newtag;
    }
    
    /**
     * Utility method to Create an element that has 
     * a name and Text value only. 
     * <pre>     
     *  Creates an XML tag with a text value  and
     *  places it in the document as a child of the 
     *  specified element.
     *   Creates <tag>value</tag> 
     * </pre>
     * 
     * 
     * @param element existing element where new tag is to go
     * @param tag XML tag
     * @param value value of tag
     * @return XML element
     */
     
    public Element appendText(Element element,String tag,String value) {
        // if obvious XML tag then treat it special
        if (value.indexOf("<")>=0 || 
            value.indexOf(">")>=0 ) {
            return appendCDATA(element,tag,value);
        }
        Element nm = _doc.createElement(tag);
        Text t = _doc.createTextNode(value);
        nm.appendChild(t);        
        element.appendChild(nm);
        return nm;
    }
    
    /**
     * Utility method to append an element that has 
     * a name and CData value only. 
     * <pre>
     * 
     *  
     *   <tag>value of tag with  html in it</tag>
     * </pre>
     * 
     * 
     * @param element existing element where new tag is to go
     * @param tag XML tag
     * @param value value of tag
     * @return XML element
     */
    public Element appendCDATA(Element element,String tag,String value) {
       
        Element nm = _doc.createElement(tag);
        CDATASection cdata = _doc.createCDATASection(value);
        nm.appendChild(cdata);        
        element.appendChild(nm);
        return nm;
    }
    
    /**
     * Utility method to Create an element that has 
     * a name and boolean value only. 
     * <pre> 
     *  <tag>1</tag> or <tag>0</tag>
     *   
     * </pre>
     * 
     * @param doc root document
     * @param element existing element where new tag is to go
     * @param tag XML tag
     * @param value true or false
     * @return XML element
     */
    
    public Element appendAttr(Element element,String tag,boolean value) {
       
        Element nm = _doc.createElement(tag);
        String strValue = (value)? "1" : "0";
         
        Text t = _doc.createTextNode(strValue);
        nm.appendChild(t);        
        element.appendChild(nm);
        return nm;
    }
    /**
     * main class used for debug
     * @param args
     */
    
    public static void main(String[] args) {
       KmlDoc kml = new KmlDoc();
       Document doc = kml.getDocument();
       Element root = kml.setRoot(null);
       Element folderA = doc.createElement("Folder");
       root.appendChild(folderA);
       Element folderA1 = doc.createElement("Folder");
       folderA.appendChild(folderA1);
       PlaceMark placeMark = new PlaceMark(doc);
       folderA1.appendChild(placeMark.getElement());
       //placeMark.setDescription("Homebase");
       kml.appendText(placeMark.getElement(),"description",
               "Home at<br>119 Third");
       placeMark.setName("Home");
       
       LookAt lookat = new LookAt(doc);
       lookat.setCoordinates(-122.0059,36.9639);
       lookat.setRange(305.8880792294568);
       lookat.setTilt(46.72425699662645);
       lookat.setHeading(49.06133439171233);
       placeMark.appendChild(lookat.getElement());
       
       //placeMark.setVisibility("0");
       kml.appendAttr(placeMark.getElement(),"visibility",false);
       Point point = new Point(doc);
       point.setCoordinates(-122.0059,36.9639);
       placeMark.appendChild(point.getElement());
       
       Element folderA2 = doc.createElement("Folder");
       folderA.appendChild(folderA2);
       
       Polygon polygon = new Polygon(doc);
       Coordinates[] corners = new Coordinates[4];
       corners[0] = new Coordinates(-122.0059,36.9639);
       corners[1] = new Coordinates(-122.0049,36.9639);
       corners[2] = new Coordinates(-122.0049,36.99);
       corners[2] = new Coordinates(-122.0059,36.9639);
       polygon.setCoordinates(corners);
       folderA2.appendChild(polygon.getElement());
       
       Element folderA3 = doc.createElement("Folder");
       folderA.appendChild(folderA3);
       
       NetworkLink netLink = new NetworkLink(doc);
       String urlfile = "c:/tmp/test.kml";
       int interval = 6;
       netLink.setUrl(urlfile, interval,null);
       folderA3.appendChild(netLink.getElement());
       
       kml.display();
       kml.writeFile("test1.kml");
    }
    
}
