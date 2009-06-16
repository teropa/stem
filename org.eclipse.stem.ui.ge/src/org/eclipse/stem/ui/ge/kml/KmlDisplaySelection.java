package org.eclipse.stem.ui.ge.kml;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.stem.ui.ge.Aspect;
import org.eclipse.stem.ui.ge.GEData;
import org.eclipse.stem.ui.ge.GELog;
import org.eclipse.stem.ui.ge.views.GEPreferencePage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
 * Display the polygon and placemark as the result of a 
 * Selection event from a MapView mouse click. 
 *
 */
public class KmlDisplaySelection implements IKmlDisplay   {

	/**
     * initialization
     * 
     * currently we have nothing to do
     * 
     * 
     */
    public void init() {
    	        
    }
    /**
     * Create the KML control file to display a
     * selected admin area and placemark icon.
     * The GEData objects in the Map that is passed 
     * contains the information about the polygon and 
     * the points where the placemark icons are to be 
     * placed.
     *      * 
     * @param controlFileName File where KML will be written 
     * @param geData Map of GEData objects 
     * 
     */
    
	public void generatePolygons(String controlFileName,
			Map<String, GEData> geData, Aspect unused) {
		
		GELog.debug(this, "file=" + controlFileName + " number="
				+ geData.size());

		KmlDoc kml = new KmlDoc();
		Document doc = kml.getDocument();
		Element root = kml.setRoot(null);
		Element document = kml.appendElement(root, "Document");
		
		// generate the KML Style info that will be used by 
		// the followig placemarks
		Style styles = setupStyles(kml, document);
		
		
        // There is normally only one entry in geData
		// but handle more
		
		Iterator it = geData.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			GEData data = (GEData) e.getValue();
			// generate placmark for point
			PlaceMark placeMark = new PlaceMark(doc);
			
			placeMark.setDescription(data.getDescription());

			placeMark.setName(data.getName());
		
			placeMark.setStyleUrl(styles);
			Point point = new Point(doc);
			double[] pts = data.getPoint();
			point.setCoordinates(pts[0],pts[1]);
			placeMark.appendChild(point.getElement());
			document.appendChild(placeMark.getElement());
			// Setup the placemarks for polygon	
			placeMark = new PlaceMark(doc);
			Element multiGeometry = null;
			placeMark.setDescription("polygon description");

			placeMark.setName(data.getName());
		
			placeMark.setStyleUrl(styles);
			
			document.appendChild(placeMark.getElement());
			
			multiGeometry = doc.createElement("MultiGeometry");
			placeMark.appendChild(multiGeometry);

			int n = data.getNumAreas();
			for (int i = 0; i < n; i++) {

				String coord = data.getCoordinatesAsString(i);
				String county = data.getName();
				// if (i > 0)
				GELog.debug(this,i+": "+county+" "+coord);
				Polygon polygon = new Polygon(doc);
				kml.appendText(polygon.getElement(), "name",county );
				polygon.setCoordinates(coord);
				multiGeometry.appendChild(polygon.getElement());
			}
			
		}

		kml.writeFile(controlFileName);
		// GELog.debug(this,"end write of "+controlFileName);
		kml.display();
		return;
	}

	
	
	
//	<Style id="Style">
//	  <LineStyle>
//	     <width>0.3</width>
//	  </LineStyle>
//	  <PolyStyle>
//	    <outline>0</outline>
//	    <fill>1</fill>
//	    <color>800000f0</color>
//	  </PolyStyle>
//	
//    <BalloonStyle>      
//      <bgColor>ffffffbb</bgColor>      
//      <text><![CDATA[
//      <b><font color="#CC0000" size="+3">$[name]</font></b>
//      <br/><br/>
//      <font face="Courier">$[description]</font>
//      <br/><br/>    
//      ]]></text>
//    </BalloonStyle>
//  </Style>
  /**
   * Build the Style statements that will be refereded to 
   * by the polygons listed later.  
   * 
   * @param kml
   * @param document
   * 
   * @return Style  KML Style instances
   */
	private Style setupStyles(KmlDoc kml,Element document) {
		Document doc = kml.getDocument();	

		Style styles = new Style(doc,"StyleSelect");
		styles.setLineStyle(0.3);
		document.appendChild(styles.getElement());
		/* set the PolyStyle value with color in hex format:
		 *          oobbggbb  
		 *            00 Opacity (00 to ff)
		 *            bb Blue (00 to ff)
		 *            gg green (00 to ff)
		 *            rr red  (00 to ff)
		 */ 
		int oo = 128;
		int blue = 128;
		int red = 0;
		int green = 128;
		/**
		 * Use our preference to outline the borders
		 */ 
		boolean outline = GEPreferencePage.isShowBorder();				


		String hex = StemKml.getHex(oo)+
		StemKml.getHex(blue)+
		StemKml.getHex(green)+
		StemKml.getHex(red);
		styles.setPolyStyle(hex,outline);
        
		styles.setBalloonStyle();

		return styles;
	}

  
  /**
   * Select the color to be used by the GoogleEarth Polygon
   * based on the relative value for the property
   * 
   * @param aspect  enum value specifing which type of
   *                display is shown (population, susceptible, 
   *                exposed,infectious,recovered)
   * @param geData
   * 
   * @return  value 0 to MAX that determines which grouping
   *   of polygons this area will be displayed with.
   */
  
  public int selectByValue(Aspect aspect, GEData geData) {
 
  	int type = 0;

  	try {
  		String code = aspect.getCode();
  		Assert.isNotNull(code, "Aspect code is null");
  		if (code == null)
  			return 0;
  		Map<String,Double> map = geData.getValueMap();
  		Assert.isNotNull(map, "Aspect map is null");  					
  		double value = 0.0;
  		if (map != null) {
  			Double d = map.get(code);
  			if (d != null)
  			    value = d;
  		} else { 
  			return 0;
  		}
  		
  		double[] range = aspect.getRange();	
  		for (int i=0; i<range.length; i++) {
  			if (value <= range[i]) {
  				type = i;
  				break;
  			}
  		}
  		
  		
  		
  	} catch (RuntimeException e1) {

  		GELog.error("selectByValue",e1);
  	}
  	return type;  
  }
  
}
