package org.eclipse.stem.ui.ge.kml;

import java.util.Iterator;
import java.util.Map;

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
 * Custom display OF SEIR aspects. 
 *   
 */
public class KmlDisplayCustom implements IKmlDisplay   {

	
    /**
     * Create the KML control file to display all of the 
     * polygon (county) areas
     *
     * We will have N PlaceMarks, each of which will 
     * be associated with a differnt Style (for color) 
     * The polygons will be placed in a placemark based
     * on the color selection.
     * 
     * @param controlFileName File where KML will be written 
     * @param geData Map of GEData objects 
     * @param aspect  which type of map (population,susceptiple...
     * 
     */
    
	public void generatePolygons(String controlFileName, 
			Map<String,GEData> geData, Aspect aspect) {
        
		GELog.debug(this,"generatePolygons: aspect="+
				aspect +" number="+geData.size());
		
		KmlDoc kml = new KmlDoc();
		Document doc = kml.getDocument();
		Element root = kml.setRoot(null);
		Element document = kml.appendElement(root,"Document");
		Style[] styles = setupStyles(kml,document,aspect);
		int max = styles.length;
		
		//Setup the placemarks for polygons with same attribute
		PlaceMark[] placeMark = new PlaceMark[max];
		Element[] multiGeometry = new Element[max];
		for (int j=0;j<max;j++) {
			placeMark[j] = new PlaceMark(doc);
			document.appendChild(placeMark[j].getElement());
			placeMark[j].setDescription("STEM map");

			placeMark[j].setName("STEM"+j);
			placeMark[j].setStyleUrl(styles[j]);   
			multiGeometry[j] = doc.createElement("MultiGeometry");
			placeMark[j].appendChild(multiGeometry[j]);
		} 
		
		// now we generate a polygon for each county
//		int debugcounter =0;
		Iterator it = geData.entrySet().iterator();
		while(it.hasNext()) {
			int type = 0;
			Map.Entry e = (Map.Entry)it.next();
			GEData data = (GEData)e.getValue();
			String county = data.getName();	
//			 check if we are filtering out some areas
			if (filter(data))  {
				type = 0;	
			} else {
				type = selectByValue(data);
			}

			// ignore return type -1
            
			if (type >=0) {
				for (int i = 0; i < data.getNumAreas(); i++) {
					String coord = data.getCoordinatesAsString(i);
					
					Polygon polygon = new Polygon(doc);
					kml.appendText(polygon.getElement(), "name", county);
					polygon.setCoordinates(coord);
					multiGeometry[type].appendChild(polygon.getElement());
				}
			}

		}

		//GELog.debug(this,"start write of "+controlFileName);
		kml.writeFile(controlFileName);
		//GELog.debug(this,"end write of "+controlFileName); 
		return;
	}
	
	/**
	 * check if this entry should be filtered out 
	 * 
	 * @param data  Instance that contains info for this admin area
	 * 
	 * @return true if it should be filtered out.
	 */
	private boolean filter(GEData data) {
		boolean filtered = false;
		if (GEPreferencePage.isTest()) {			
			String county = data.getName();	
			if (county.indexOf(" US-")>= 0 ) {					
				filtered = false;
			
			} else if (county.indexOf(" MEX")>= 0 ) {					
				filtered = false;
			} else {
				filtered = true;
			}
		}
		return filtered;
	}

//	<Style id="Style1">
//	  <LineStyle>
//	     <width>0.3</width>
//	  </LineStyle>
//	  <PolyStyle>
//	    <outline>0</outline>
//	    <fill>1</fill>
//	    <color>800000f0</color>
//	  </PolyStyle>
//	</Style>
  /**
   * Build the Style statements that will be refereded to 
   * by the polygons listed later.  
   * 
   * @param kml
   * @param document
   * @param aspect
   * @return Style[] array of KML Style instances
   */
  private Style[] setupStyles(KmlDoc kml,Element document, Aspect aspect) {
	Document doc = kml.getDocument();	
	/**
	 * Do not outline the borders
	 */ 		
	boolean outline = false;
	int max = 9;
	// define the Style sections
	Style[] styles = new Style[max];
	for (int k=0;k<max;k++) { 
		styles[k] = new Style(doc,"Style"+k);
		styles[k].setLineStyle(0.3);
		document.appendChild(styles[k].getElement());
		/* set the PolyStyle value with color in hex format:
		 *          oobbggbb  
		 *            00 Opacity (00 to ff)
		 *            bb Blue (00 to ff)
		 *            gg green (00 to ff)
		 *            rr red  (00 to ff)
		 */ 
		int oo = 160;
		int blue = 0;
		int red = 0;
		int green = 0;		
		
		switch (k) {
		case 0:  //red
			red = 0xf0;
			break;
		case 1:  // orange
			red = 0xf0;
			green = 0xa0;
			break;	
		case 2:   // lt green
			red = 0xd0;
			green = 0xf0;
			break;
		case 3:  //orange
			red = 0xd0;
			green = 0xb0;
			break;
		case 4:  // lt green
			red = 0xb0;
			green = 0xf0;
			break;
		case 5:   //orange
			red = 0xf0;
			green = 0xc0;
			break;
		case 6:  // lt green
			red = 0xc0;
			green = 0xf0;
			break;
		case 7:  // yellow
			red = 0xf0;
			green = 0xf0;
			break;
		case 8: // green
			red = 0x00;
			green = 0xf0;
			break;
		default:
			break;
		}
			
		String hex = StemKml.getHex(oo)+
			             StemKml.getHex(blue)+
			             StemKml.getHex(green)+
			             StemKml.getHex(red);
		styles[k].setPolyStyle(hex,outline);
		
	}
	return styles;
  }
  
  
  /**
   * Select the color to be used by the GoogleEarth Polygon
   * based on the relative value for the property
   * <pre>
   *  S    E    I     R   Red Green Blue   Type 
   *   1   0    0     0                      -1
   *   -   -   >.8    -    F0   00            0
   *   -  >R   >.6    -    F0   A0            1
   *   -   -   >.6   >I    D0   F0            2 
   *   -  >R   >.4    -    D0   B0            3
   *   -   0   >.4   >I    B0   F0            4
   *   -  >R   >.2    -    F0   C0            5
   *   -   -   >.2   >I    C0   F0            6
   *   -  >R   <.2    -    F0   F0            7
   *   -   -   <.2   >I    00   F0            8
   *         
   * </pre>
   * 
   * @param geData Instance that hods info about area including 
   *               the latest disease state.
   * 
   * @return  value 0 to MAX that determines which grouping
   *   of polygons this area will be displayed with.
   *   -1 will indicate not to display the polygon
   */
  
    public int selectByValue(GEData geData) {

		int type = 0;

		double s = geData.getValueMap().get("S");
		double e = geData.getValueMap().get("E");
		double i = geData.getValueMap().get("I");
		double r = geData.getValueMap().get("R");

		if (s == 1.0 && e == 0.0 && i == 0.0 && r == 0.0) {
			type = -1; // uninitialized
		} else if (i >= 0.2) {
			type = 0; // red
		} else if (i >= 0.1 ) {
			if ( e >= r) {
				type = 1;  // orange
			} else {
				if (r > 0.9)
				    type = 8;  // lt green
				else 
					type = 0;  // red
			}
//		} else if (i >= 0.4 ) {
//			if ( e >= r) {
//				type = 3;  //  red green  
//			} else {
//				type = 4;  // green red
//			}
		} else if (i > 0.01 ) {
			if ( e >= r) {
				type = 1;  // orange
			} else {
				type = 8;  // green red
			}
		} else if (e >= r) {			
			type = 7; //   // yellow
		} else {
			type = 8;      // green
			
		}
		if (geData.getName().contains(" 25017")) {
			GELog.debug(this, geData.getName() + " "
					+ geData.getValuesAsString() + " " + type);
		}
		return type;
	}
  
}
