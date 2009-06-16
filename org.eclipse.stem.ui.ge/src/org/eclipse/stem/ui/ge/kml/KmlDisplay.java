package org.eclipse.stem.ui.ge.kml;

import java.awt.Rectangle;
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
 * Standard DISPLAY OF SEIR aspects. 
 *
 */
public class KmlDisplay implements IKmlDisplay   {

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
     * @param cycle current number of cycle being displayed
     */
    
	public void generatePolygons(String controlFileName, 
			Map<String,GEData> geData, Aspect aspect) {
        int written = 0;
		//GELog.debug(this,"aspect="+aspect+" number="+geData.size());
		
		KmlDoc kml = new KmlDoc();
		Document doc = kml.getDocument();
		Element root = kml.setRoot(null);
		Element document = kml.appendElement(root,"Document");
		Style[] styles = setupStyles(kml,document,aspect);
		int max = aspect.getRange().length;
		
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
		// Get latest BBox info from GoogleEarth
		Rectangle bboxView = BBoxInfo.getBBox();
		Iterator it = geData.entrySet().iterator();
		boolean bboxFilter = GEPreferencePage.isBBOX(); 
		while(it.hasNext()) {
			int type = 0;
			Map.Entry e = (Map.Entry)it.next();
			GEData data = (GEData)e.getValue();

			String county = data.getName();	
			// check if we are filtering out some areas
			if (bboxFilter && filter(data,bboxView))  {
				type = 0;	
			} else {				
				type = selectByValue(aspect,data);
			}
			
//			 DEBUG temp
//			String locid = loc.getId().toString();	
//			if (county.startsWith("Middlesex")) {								 
//				GELog.debug(this,"generatePolygons: "+i+": "+county+":"+locid+
//						": "+type+": "+coord);                          
//			}
			if (type > 0) {
				//GELog.debug(this,county); 
				int n = data.getNumAreas();
				for (int i = 0; i < n; i++) {
					
					String coord = data.getCoordinatesAsString(i);
					//if (i > 0)
					//   GELog.debug(this,i+": "+county+" "+coord);
					Polygon polygon = new Polygon(doc);
					kml.appendText(polygon.getElement(), "name", county);
					polygon.setCoordinates(coord);
					multiGeometry[type].appendChild(polygon.getElement());
				}
				written++;
			}

		}

		GELog.debug(this,"write "+controlFileName+
				" with "+written+" entries.");
		kml.writeFile(controlFileName);
		//GELog.debug(this,"end write of "+controlFileName); 
		return;
	}

	/**
	 * check if this entry should be filtered out 
	 * 
	 * @param data  Instance that contains info for this admin area
	 * @param bboxView Screen boundary box from GoogleEarth 
	 * @return true if it should be filtered out.
	 */
	private boolean filter(GEData data,Rectangle bboxView) {
		boolean filtered = false;  // default - not filtered
		if (bboxView != null ) {				
			Rectangle bbox = data.getBBox();
			filtered = ! BBoxInfo.testContainment(bbox,bboxView);
			return filtered;
		} 
//				if (county.indexOf(" MA ")>=0  ||
//				    county.indexOf(" MT ")>=0    ) {                                
//			        filtered = ! testContainment(bbox,bboxView);			    	
//			    	GELog.debug(this," bbox:    "+bbox);
//			    	GELog.debug(this," bboxView:"+bboxView);
//				}
//		if (GEPreferencePage.isTest()) {		
//			String county = data.getName();	
//			if (county.indexOf(" US-")>= 0 ) {					
//				filtered = false;
//			
//			} else if (county.indexOf(" MEX")>= 0 ) {					
//				filtered = false;
//			} else {
//				filtered = true;
//			}
//			
//			//GELog.debug(this,county+" "+filtered);
//		}
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
	int max = aspect.getRange().length;
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
		int oo = 0;
		int blue = 0;
		int red = 0;
		int green = 0;
		/**
		 * Use our preference to outline the borders
		 */ 
		boolean outline = GEPreferencePage.isShowBorder();				
		
		if (k==0) {
			// Style0 does not show the polygon			
			styles[0].setPolyStyle("0", outline);
		} else {
			blue = aspect.getBlue(k);
			red = aspect.getRed(k);
			green = aspect.getGreen(k);
			oo = aspect.getOpacity(k);
			
			String hex = StemKml.getHex(oo)+
			             StemKml.getHex(blue)+
			             StemKml.getHex(green)+
			             StemKml.getHex(red);
			styles[k].setPolyStyle(hex,outline);
		}
	}
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
