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
 * Build the NetworkLink section of a KML document.
 * <pre>
 *    
 * </pre>
 * 
 *
 */
/*    
<NetworkLink>
  <name>NetworkLink </name>
 <flyToView>1</flyToView> 
  <Url>
     <href>E:/tmp/test1.kml</href>  
     <refreshInterval>10</refreshInterval>   
     <refreshMode>onInterval</refreshMode>          
  </Url>
</NetworkLink>
*/   
public class NetworkLink {
   
    private Element _networkLink = null;
    
    
    
    private Document _doc = null;
    /**
     * NetworkLink constructor
     * 
     * @param doc Document
     */
    public NetworkLink(Document doc) {
        _doc = doc;
        _networkLink = _doc.createElement("NetworkLink");          
        
    }
    
    /**
     * @return  Element 
     */
    public Element getElement() {
        return _networkLink;
    }

    /**
     * Add an Url with href attribute
     * 
     * <pre>
     * Note: The url can have one of the the forms:
     *   http://node:port/address
     *   c:/path/file.kml
     *  
     * The valid URL of "file:///c:/path/file.kml 
     * does not work with GoogleEarth NetworkLink.   
     * </pre>
     * @param url URL to be downloaded
     * @param interval seconds between refresh
     * @param mode 
     * @param refresh mode 
     *         If null then "onInterval"
     * @return XML element
     */
    public Element setUrl(String url,int interval,String mode) {
    	Element link = null;
        link = _doc.createElement("Link");             
        _networkLink.appendChild(link);   
        Element e = KmlDoc.createAttr(_doc,"href",url);             
        link.appendChild(e);
        e = KmlDoc.createAttr(_doc,"refreshInterval",Integer.toString(interval));             
        link.appendChild(e);
        e = KmlDoc.createAttr(_doc,"refreshMode",mode);             
        link.appendChild(e);
        e = KmlDoc.createAttr(_doc,"viewRefreshMode","onStop");             
        link.appendChild(e);
        e = KmlDoc.createAttr(_doc,"viewRefreshTime","2");             
        link.appendChild(e);
        return link;
    }
   
    
} // end class
