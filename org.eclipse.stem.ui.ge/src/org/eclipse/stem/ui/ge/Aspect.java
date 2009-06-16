package org.eclipse.stem.ui.ge;

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

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.Assert;
/**
 * Aspect 
 * 
 * This class is used to describe the Aspects of a disease that 
 * we are interested in.  The common ones are: S, E I,and R for 
 * Susceptible, Exposed, Infectious, and Recoverable.  However 
 * there could be others or some diseases may have less.
 * 
 * The valid Aspects are described by a property file.  
 * The default is aspects.properties which would be found in the 
 * org.eclipse.stem.ui.ge package. The default if no properties
 * file is found is S,E,I,R with default values for each aspect.
 * 
 * Each valid Aspect is described by an instance of this class and 
 * the set of Aspects are stored in a HashMap that can be accessed 
 * as a static value for Aspect. 
 * <pre>
 * Each Aspect has the following attributes:
 *
 *    code     - the String code by which it is accessed (e.g "S")
 *    name     - The String that the user would understand
 *               (e.g "Susceptiple"
 *    description - The text description of the aspect.
 *    range    - A list of double values that describe the range 
 *               of values that the aspect might have. 
 *               For a relative aspect, these would range from 0.0 to 1.0
 *               (e.g  0.1, 0.33, 0.66, 0.9)
 *    red        The value (0 to 255) for the color "Red" if the value 
 *               is in the specified range. 
 *               (e.g  0,255,255,255 would cause an aspect with a value of 0
 *               to have red=0; with a value greater than 0 then red=255
 *               Assuming the green and blue values were 0,0,0,0 then the
 *               aspect would be shown as red. Equal values for red and green
 *               would result in yellow etc. 
 *    green      Same as above but for the color green.
 *    blue       Same as above but for the color blue.
 *    opacity    The value (0 to 255) that descripes the tranparency 
 *     			 used by GoogleEarth when drawing a polygon to 
 *               represent the value of the aspect.  
 *               (e.g 0,128,160,192 with the range above would cause an area
 *                with a aspect value of 0 to 0.1 to not be filled in at all, 
 *                with a value less or equal to 0.33 to have an opacity
 *                of 128 and values greater thatn 0.9 an opacity of 192) 
 * 
 * </pre>
 */
public class Aspect {
    /**
     * Aspect code 
     *   Example "E"
     */
	private String code = null;
	
	/**
	 * Aspect Name
	 *   Example "Exposed"
	 *   
	 *   
	 */
	private String name = null;
	
	
	/**
	 * Description of the value.  
	 * 
	 */
	// TODO  how do we make this translatable?
	private String description = null;
	/**
	 * filename for properties file
	 */
	public static final String PROPERTIES_NAME = "aspect.properties";
	/** default range */
	public static final double[] DEFAULT_RANGE = {0.0, 0.33, 0.66, 1.0};
	/** default opacity */
	public static final int[] DEFAULT_OPACITY = {0,128,160,192};
	
	/**
	 * range of values that will be shown.  
	 * This range will be used to select the value
	 * of opacity,red,green and blue in the display.
	 * For Example, if the Exposed relative value is 0.5 then 
	 * this is the less than or equal to the 3rd entry in range (0.66) 
	 * so the 3rd entry in the list of Opacity(160) will be used and 
	 * the 3rd entry in the  red,green and blue lists would be used.
	 * 
	 */
	private double[] range = DEFAULT_RANGE;
	
	
	private int[] opacity = DEFAULT_OPACITY;
	/**
	 * The array of color entries.  
	 * For example, the aspect Exposed is displayed as yellow.
	 * so the blue array is all 0 and the red and green arrays
	 * are all 255.  But this could be otherwise specified in 
	 * the properties file.    
	 *   
	 */
	private int[] red = null ;
	private int[] green = null;
	private int[] blue = null;
	/**
	 * relative or absolute
	 */
	private String type = "relative";
	
	/**
	 * If specified could be something like "population/sq km"
	 * Currently not used.
	 */
	private String unit = null;
	
	/**
	 * Map of Aspects that are used 
	 * 
	 * The Key is a String cdode value (like "S") 
	 * The entries are Aspect instances.
	 */
	private static Map<String,Aspect> map = null;
	/**
	 * default Aspect to be displayed 
	 */
	private static String defaultAspect = "";
	/**
	 * Class that is called to generate the KML file 
	 * to display the aspects.  
	 * See IKMLDisplay.java for requirements of the class.
	 */
	private static String kmlDisplayClass = 
		"org.eclipse.stem.ui.ge.kml.KmlDisplay";
	
	/**
	 * Reference to the properties instance used 
	 * to determine the Aspects used in this implementation
	 */
	private static Properties properties = new Properties ();
	/**
	 * Initialization code.
	 * It reads the property file and creates the Aspects 
	 * and then stores each one in a hashmap.
	 * 
	 */
	public static void setup() {
		
		
		try {
			InputStream in = Aspect.class.getResourceAsStream (PROPERTIES_NAME);
			 if (in != null) {				
				 properties.load (in); // Can throw IOException
				 Aspect.map = null;
				 getAspects(properties);
			 } else {
				 GELog.error("Failed reading Aspect properties. "+
						 PROPERTIES_NAME , null);
				// use the map that that was constructed 
				 // during class initialization
				 if (Aspect.map == null) {
						map = new HashMap<String,Aspect>(5);	
				}
				
			 }
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * Read the Properties from the Properties instance that
	 * was read from the aspect.properties file and create a
	 *  Map of Aspects.
	 * 
	 * @param properties  colletion of properties
	 */
	private static void getAspects(Properties properties) {
		String list = properties.getProperty("Aspects","S,E,I,R");
		StringTokenizer tokens = new StringTokenizer(list,",");
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if (defaultAspect == null || defaultAspect.length()==0) {
				// make 1st Aspect the default default
				defaultAspect = token;
			}
			String name = properties.getProperty(token+".name",null);
			Aspect aspect = new Aspect(token,name);
			
			String description = 
				properties.getProperty(token+".description",null);			
			aspect.setDescription(description);
			String range = properties.getProperty(token+".range",null);
			aspect.setRange(range);
			String opacity = properties.getProperty(token+".opacity",null);
			aspect.setOpacity(opacity);
			String color = properties.getProperty(token+".red","0");
			aspect.setRed(color);
			color = properties.getProperty(token+".green","0");
			aspect.setGreen(color);
			color = properties.getProperty(token+".blue","0");
			aspect.setBlue(color);
//			GELog.debug(Aspect.class,token+":"+
//					" "+aspect.getCode()+" "+aspect.getName()+
//					" "+aspect.getRange()+" "+aspect.getOpacity());
		}
		defaultAspect = properties.getProperty("Default",defaultAspect);
		kmlDisplayClass = 
			properties.getProperty("kmlDisplay",kmlDisplayClass);
	}
	/**
	 * Create an instance of Aspect and place it into the Hashmap.
	 * 
	 * @param code
	 * @param name
	 * @param id 
	 */
	public Aspect(String code, String name) {
		this.code = code;
		this.name = name;		
		// set some defaults
		if (red == null)
			setRed("0");
		if (green == null)
			setGreen("0");
		if (blue == null)
			setBlue("0");
		if (Aspect.map == null) {
			map = new HashMap<String,Aspect>(5);	
		}
		Aspect.map.put(code,this);
	}

	/**
	 * Verify that this instance of Aspect makes good sense
	 * and follows all of the rules. 
	 * 
	 * @return true if no problems found
	 *         false if not  
	 *         
	 */
	public boolean isSane() {
		
		try {
			Assert.isNotNull(range);
			int n = range.length;
			Assert.isTrue(opacity.length == n,"Invalid Opacity dimension");
			Assert.isTrue(red.length == n,"Invalid Color Red dimension");
			Assert.isTrue(green.length == n,"Invalid Color Blue dimension");
			Assert.isTrue(blue.length == n,"Invalid Color Green dimension");
			
		} catch (RuntimeException e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Return the Aspect that is associated with the specified
	 * code.  Reurn defaultAspect if unknown.
	 * 
	 * @param code
	 * @return specified aspect
	 */
	public static Aspect getAspect(String code) {
		Aspect aspect = null;
		if (map == null) {
			setup();
		}
		if (map != null) {
			aspect = map.get(code);
			if (aspect == null) {
				aspect = map.get(defaultAspect);
			}
		} else {			
			GELog.error("Invalid condition. Aspect map is null",null);
		}
		return aspect;
	}
	/**
	 * Test if specified aspect code is in the map of aspects.
	 *
	 * 
	 * @param aspectCode  
	 * @return true if the specified aspect code is in the map
	 */
	public static boolean exists(String aspectCode) {
		return map.containsKey(aspectCode);
	}
	/**
	 * @return the map
	 */
	public static Map<String, Aspect> getMap() {
		return map;
	}
	/**
	 * @param map the map to set
	 */
	public static void setMap(Map<String, Aspect> map) {
		Aspect.map = map;
	}

	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param newcode the code to set
	 */
	public void setCode(String newcode) {
		map.remove(this.code);
		this.code = newcode;
		map.put(newcode, this);
	}

	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Return the code that this Aspect represents.
	 *   For Example "E" for Exposed.
	 */
	public String toString() {
		return code;
	}

	

	/**
	 * @return the description
	 */
	public String getDescription() {
		if (description == null) 
			return name;
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the range
	 */
	public double[] getRange() {
		return range;
	}
	/**
	 * Get a specific entry in the array of range values
	 * @param n  entry within the array 
	 * @return the range entry in list
	 */
	public double getRange(int n) {
		return range[n];
	}
	/**
	 * Set the range of values used to display value.
	 * It is given as a String of , separated values
	 * and converted to an array of doubles
	 * 
	 * @param range the range to set
	 */
	public void setRange(String range) {
		if (range == null) {
			this.range = DEFAULT_RANGE;
			return;
		}
		StringTokenizer tokens = new StringTokenizer(range,",");
		
		int n = tokens.countTokens();
		this.range = new double[n];
		for (int i=0; i<n; i++) {
			double value = Double.parseDouble(tokens.nextToken().trim());
			this.range[i] = value;
			
		}
		
	}
	
	/**
	 * @return the opacity array
	 */
	public int[] getOpacity() {
		return opacity;
	}
	/**
	 * @param n entry the list to get
	 * @return the opacity
	 */
	public int getOpacity(int n) {
		return opacity[n];
	}
	/**
	 * Set the Opacity of the displayed polygons
	 * based on the range of values.  
	 * It is given as a String and converted to 
	 * an array of ints that is the same size as 
	 * range.  If Less values specified, then last 
	 * value will be repeated.
	 * @param opacity comma separated list
	 */
	public void setOpacity(String opacity) {
		int n = getRange().length;
		this.opacity = new int[n];
		if (opacity == null) {	
			this.opacity[0] = 0;
			for (int i=1;i<n;i++) {
				this.opacity[i] = DEFAULT_OPACITY[i];
			}
			return;
		} 
		StringTokenizer tokens = new StringTokenizer(opacity,",");		
		
		int value = 0;
		for (int i=0; i<n; i++) {
			if (tokens.hasMoreTokens()) {
			  value = Integer.parseInt(tokens.nextToken().trim());
			}
			this.opacity[i] = value;			
		}
		
	}


	/**
	 * Set the Color of the displayed polygons
	 * based on the range of values.  
	 * It is given as a String and converted to 
	 * an array of ints that is the same size as 
	 * range.  If Less values specified, then last 
	 * value will be repeated.
	 * @param color range of colors 
	 */
	public void setRed(String color) {
		int n = getRange().length;
		this.red = new int[n];
		if (color == null) {			
			for (int i=0;i<n;i++) {
				this.red[i] = 0;
			}
			return;
		} 
		StringTokenizer tokens = new StringTokenizer(color,",");		
		int value = 0;
		for (int i=0; i<n; i++) {
			if (tokens.hasMoreTokens()) {
			  value = Integer.parseInt(tokens.nextToken().trim());
			}
			this.red[i] = value;			
		}		
	}
	/**
	 * Set the Color of the displayed polygons
	 * based on the range of values.  
	 * It is given as a String and converted to 
	 * an array of ints that is the same size as 
	 * range.  If Less values specified, then last 
	 * value will be repeated.
	 * @param color range of colors 
	 */
	public void setGreen(String color) {
		int n = getRange().length;
		this.green = new int[n];
		if (color == null) {			
			for (int i=0;i<n;i++) {
				this.green[i] = 0;
			}
			return;
		} 
		StringTokenizer tokens = new StringTokenizer(color,",");		
		int value = 0;
		for (int i=0; i<n; i++) {
			if (tokens.hasMoreTokens()) {
			  value = Integer.parseInt(tokens.nextToken().trim());
			}
			this.green[i] = value;			
		}		
	}
	
	/**
	 * Set the Color of the displayed polygons
	 * based on the range of values.  
	 * It is given as a String and converted to 
	 * an array of ints that is the same size as 
	 * range.  If Less values specified, then last 
	 * value will be repeated.
	 * @param color range of colors 
	 */
	public void setBlue(String color) {
		int n = getRange().length;
		this.blue = new int[n];
		if (color == null) {			
			for (int i=0;i<n;i++) {
				this.blue[i] = 0;
			}
			return;
		} 
		StringTokenizer tokens = new StringTokenizer(color,",");		
		int value = 0;
		for (int i=0; i<n; i++) {
			if (tokens.hasMoreTokens()) {
			  value = Integer.parseInt(tokens.nextToken());
			}
			this.blue[i] = value;			
		}		
	}
	
	/**
	 * @param n list entry
	 * @return the color entry
	 */
	
	public int getRed(int n) {
		return red[n];
	}
	
	/**
	 * @param n list entry
	 * @return the color entry
	 */
	
	public int getGreen(int n) {
		return green[n];
	}
	
	/**
	 * @param n list entry
	 * @return the color entry
	 */
	
	public int getBlue(int n) {
		return blue[n];
	}
	/**
	 * @param range the range to set
	 */
	public void setRange(double[] range) {
		this.range = range;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the default Aspect
	 */
	public static Aspect getDefault() {
		String code = getDefaultCode();		
		return getAspect(code);
	}
	/**
	 * @return the default Aspect code
	 */
	public static String getDefaultCode() {
		return defaultAspect;
	}
	/**
	 * @param defaultAspectCode the aspect to set
	 */
	public static void setDefaultCode(String defaultAspectCode) {
		defaultAspect = defaultAspectCode;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the kmlDisplayClass
	 */
	public static String getKmlDisplayClass() {
		return kmlDisplayClass;
	}
	/**
	 * @return the properties
	 */
	public static Properties getProperties() {
		return properties;
	}
}
