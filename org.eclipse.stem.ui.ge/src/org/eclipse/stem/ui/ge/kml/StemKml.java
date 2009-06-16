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

import java.io.*;
import java.util.*;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.help.internal.appserver.*;
import org.eclipse.stem.ui.ge.Activator;
import org.eclipse.stem.ui.ge.GEData;
import org.eclipse.stem.ui.ge.GELog;
import org.eclipse.stem.ui.ge.Aspect;

import org.eclipse.stem.ui.ge.servlet.VerifyClient;
import org.eclipse.stem.ui.ge.views.GEPreferencePage;
import org.eclipse.swt.program.Program;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;




/**
 * StemKML works with GEInterface to handle the 
 * KML side of the interface between STEM and GoogleEarth.
 * Refer to GEInterface for more information.
 * <pre>
 *     
 *  
 *  - PolygonMap  Map<String,GEData> 
 *       Map of info to generate a set of Polygons
 *       The key is the area 
 *       
 *  - aspect   SEIR value
 *  - cycle    Nth time interval
 *  
 * 
 * During operation, when appropriate The "controlxxxx.kml" file 
 * will be rewriten with new instructions.
 * StemView will call generatePolygons() to generate a control file
 * that will display all of the county/areas of the map with the 
 * appropriate color fill to match the corresponding Stem map.
 * 
 * When the user selects a specific county/area on the map,
 * then StemView will call the generatePolygon method.
 * 
 *
 */
@SuppressWarnings("restriction")
public class StemKml {
	/**
     * Servlet context.  
     * 
     */
    public static final String CONTEXT = "STEM";
       
    /**
     * If internal web server started then this is set true
     */
    private static boolean _started = false;
    /** 
     * If internal server fails to start then this is set true
     */
    private static boolean _failed = false;
    
    /**
     * URL for either the embeded web server or 
     * an assigned web server.  
     * If this webserver was inoperative then this
     * is null.
     */
    private static String _baseurl = null;
    /**
     * System temp directory. 
     * calculated once and saved
     */
    private static String tmpFolder = null;
    /**
     * Number of intensities of color
     */
    static final int MAX = 5;
    static final int MIN = 0;
    
    /**
     *   unique id used for servlet communication
     */
    static String servletId = null;
    /**
     * FileName for KML control file.
     */
    static final String CONTROL_FN = "control.kml";
    /**
     * FileName for KML control file used to display
     * a named admin area.
     */
    static final String DISPLAYAREA_FN = "displayarea.kml";
    /**
     * if true then servlet will wait when 
     * sending files to GE and it has run 
     * out of files to send.  
     * 
     */
    private static boolean waitForKML = true;
    
    /**
     * Interval in seconds between requests
     * for refresh.  Filled into the 
     * NetworkLink request.
     */
	static int interval = 2;
    
	/**
	 * Indicate if KML is a valid filetype.
	 * If not then GoogleEarth has probably 
	 * not been installed and we cannot 
	 * simply launch a .kml file.
	 */
	static boolean validKML = true;
	/**
	 * implementation of IKmlDisplay that will create and write
	 * the KML file that is sent to GoogleEarth.
	 */
	private IKmlDisplay display = null;
	

    /**
     * Constructor  
     *
     */
    public StemKml() {
    	
    	
       try {
		   String kmlDisplayClass = Aspect.getKmlDisplayClass();

		   display = (IKmlDisplay)Class.forName(kmlDisplayClass).newInstance();
	   } catch (Throwable t) {		
		   GELog.error("Failed to create instance for KmlDisplay", t);
	   }
		  	
      
    }
        
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
     * Verify that GoogleEarth is installed by 
     * checking that the KML filetype is known.
     * 
     * @return true if the KML file type is known.
     */
    public static boolean verifyGE() {
    	
    	String extension = ".kml";
    	Program p = Program.findProgram(extension);
    	if (p != null) {
    		GELog.debug("StemKml.verifyGE","KML handler: "+p.getName());
    		   			
    	} else {
    		validKML = false;
    	}
    	
    	return validKML;
    	
    }
	/**
	 * 
     * Create a GoogleEarth empty control files and launch it 
     * so that googleEarth starts up.
     *
	 * @throws DOMException
	 */
	public static void launchGE() throws DOMException {
		
		try {
			
			String fn = getControlFile();
			
		
			// write an empty control file so that 
			// to begin with, nothing happens but 
			// GoogleEarth gets a headstart on initialization
			
			KmlDoc kml = new KmlDoc();
			kml.setRoot(null);
			kml.getDocument();
			kml.writeFile(fn);
			GELog.debug("StemKml.launchGE",fn);
			// launch the file
			// 
			launch(fn);
			Thread.sleep(1*1000);
		} catch (Exception e) {
			String msg = "Error launching initial GoogleEarth control file.";
			GELog.error(msg,e);
		}
	}
	
	
	/**
	 * Generate the name used for KML Control.
	 * 
	 * @return Fully qualified filename (e.g. c:/tmp/control.kml)
	 */
	public static String getControlFile() {	
		String fn = null;
		if (tmpFolder == null) {
			tmpFolder = getTmpFolder();
		}
		if (tmpFolder == null) {
			GELog.error("Unable to generate KML Control file.",null);
		} else {
		
		    fn = tmpFolder+File.separator+CONTROL_FN;
		}
		
		return fn;
	}
	/**
	 * obtain the system temporary folder.
	 * 
	 * @return Fully qualified path (e.g. c:/tmp or /tmp)
	 */
	public static String getTmpFolder() {	
		String tmp = null;
		String slash = File.separator;		
		try {
			File tmpFile = File.createTempFile("control",".kml",null);
			tmp = tmpFile.getParent();
			tmpFile.delete();		
			
		} catch (IOException e) {			
			GELog.error("System Temporary Directory not defined: ",null);
			// if no system temp folder, use our log folder
			tmp = getLogFolder();
			tmp = tmp+slash+"tmp";
			File tmpFile = new File(tmp);
			tmpFile.mkdirs();
			
		} catch (Exception e) {			
			GELog.error("Failure getting TMP folder.",e);
			
		}
		return tmp;
	}
	/**
	 * obtain the users preference for the folder
	 * used to generate KML files.
	 * 
	 * @return Fully qualified path (e.g. c:/tmp or /tmp)
	 */
	public static String getLogFolder() {	
		String log = null;
				
		try {
			log = GEPreferencePage.getFolder();
			File logFolder = new File(log);
			if (logFolder.exists()) {
				if (logFolder.isDirectory()) {
					return log;
				} else {
					throw new RuntimeException("Log Folder "+
							log+ " is not valid");
				}
			}  else {
				boolean ok = logFolder.mkdirs();
				if (ok)
					return log; 
				else 
					throw new RuntimeException("Log Folder "+
							log+ " cannot be created ");
			}
			
			
		} catch (Exception e) {			
			GELog.error("Failed to get LOG folder: "+log,e);
			log = null;
		} 
		return log;
	}
	/**
	 * Generate the name used for KML when using
	 * the DisplayArea utility function
	 * 
	 * @return Fully qualified filename (e.g. c:/tmp/control.kml)
	 */
	public static String getDisplayAreaFile() {	
		String fn = null;
		try {
			if (tmpFolder == null) {
				File tmpFile = File.createTempFile("displayarea",".kml");
				tmpFolder = tmpFile.getParent();
				tmpFile.delete();
			}
			fn = tmpFolder+"/"+DISPLAYAREA_FN;
		} catch (IOException e) {			
			GELog.error("Unable to generate KML DisplayArea file.",e);
		}
		return fn;
	}
	/**
	 *  write an empty control file so that 
	 *  it clears the current display
	 */
	public static void clearDisplayArea() {
		String fn = tmpFolder+"/"+DISPLAYAREA_FN;	
		
		KmlDoc kml = new KmlDoc();
		kml.setRoot(null);
		kml.getDocument();
		kml.writeFile(fn);
		
		// launch the file
		// 
		launch(fn);
	}
    /**
	 * create and launch a network link file that will read the 
	 * kml files that we will be generating.
     *
     * @param folder Folder that contains KML files
     * @param file   If not null then pass this name to the servlet.  
     * @return URL used
	 *
	 */
	public static String launchNetworkLink(	String folder, String file) {
					
		String url = null;
		// clear if needed
		StemKml.launchGE();

		try {
			
			String fn = getControlFile();
			
			long time = new Date().getTime();
			servletId = Long.toHexString(time);
			String wait = "n";
			if (waitForKML) 
				wait = "y";
            
			url = _baseurl+
				"/"+CONTEXT+"/slideshow?id="+servletId+
				"&folder="+folder+
				"&wait="+wait;
			if (file != null) {
				url = url+"&file="+file;
			}
			GELog.debug(StemKml.class,"launchNetworkLink url="+url);
			
			StemKml.writeNetLink(fn, interval, url);
			
			String bboxurl = _baseurl+
			       "/"+CONTEXT+"/bbox?id="+servletId;
			
			// start Thread to access BBox info from GE
			if (GEPreferencePage.isBBOX()) {
				BBoxInfo bbox = new BBoxInfo(bboxurl,servletId);
				Thread t = (new Thread(bbox));
				t.start();
			}
			try {
				Program.launch(fn);
				GELog.debug(StemKml.class,"Launched networkLink file "+fn);
				Thread.sleep(5*1000);
			} catch (InterruptedException ie) {
			} catch (Throwable e) {
				GELog.error("Launch failure", e);
			}
		} catch (Exception e) {
			GELog.error("Failure launching NetworkLink.kml file",e);
			
		}
		return url;
    }
	/**
	 * 
	 * Write the network Link file that will tell GoogleEarth how 
	 * to make callbacks to the servlet.
	 * 
	 * @param fn  folder + fn to write  
	 * @param interval  How often to call back (seconds)
	 * @param url     Where to call back + parms
	 * @throws DOMException
	 */
	public static void writeNetLink(String fn, int interval, String url) 
	  throws DOMException {
		KmlDoc kml;
		// write a file using networklink that tells 
		// google earth to read the control file 
		// every N seconds and do whatever it says.
		kml = new KmlDoc();        
		Document doc = kml.getDocument();
		Element root = kml.setRoot(null);
		NetworkLink netLink = new NetworkLink(doc);        

		String mode = "onInterval";
		netLink.setUrl(url, interval,mode);
		// add <flyToView>1</flyToView> 
		kml.appendAttr(netLink.getElement(),"flyToView",false);
		root.appendChild(netLink.getElement());

		//kml.display();  // debug
		kml.writeFile(fn);
	}
	
	
  /**
  * Create the KML control file to display all of the 
  * polygon (county) areas
  *
  * Call the implementation of IKmlDisplay to create and 
  * write the kml file.
  * 
  * @param controlFileName File where KML will be written 
  * @param geData Map of GEData objects 
  * @param aspect  which type of map (population,susceptiple...
  * @param cycle current number of cycle being displayed
  */
    
	public void generatePolygons(String controlFileName, 
			Map<String,GEData> geData, Aspect aspect,long cycle) {
 	
	    
	    display.generatePolygons(controlFileName, geData, aspect);
	}
		
 

      

    /**
	 * get the Hex value corresponding to an int value. 
	 * This has leading zeros.
	 * 
	 * @param v      value to translate.
	 * @return Hex String
	 */
	public static String getHex(int v) {
		String hex = Integer.toHexString(v);
		if ((hex.length() % 2) != 0) {
			hex = "0" + hex;
		}
		return hex;
	}

/**
 * Launch the KML file to GoogleEarth
 * 
 * @param controlFileName
 *            absolute file path or a url
 * 
 */
public static void launch(String controlFileName) {
	try {
		if (!validKML) {
			GELog.debug("launch: KML is unknown filetype");
			return;
		}
		File controlFile = new File(controlFileName);
		
		
		Program.launch(controlFile.getAbsolutePath());
		GELog.debug("StemKml.launch","Launched file "+controlFileName);
	} catch (Throwable e) {
		GELog.error("StemKml: Launch failure", e);
	}
}

/** 
 * Startup and verify a web server to run the 
 * GEServlet servlets.
 * 
 * If specified it will try to start the embedded web server
 * If not or it failed then it will check if an 
 * external server was specified and try to access it.
 * 
 * @return url for host and port 
 *       example: http://127.0.0.1:54345/
 *       It will return null if unable to start server or 
 *       if server does not support our servlets
 */	 
public static String initWebServer() {
	
	if (GEPreferencePage.isInternalServer()){		
		_baseurl = startWebServer();		
	}
	
	if (_baseurl == null ) {
		String host =GEPreferencePage.getServerHost();
		if (host != null && host.length() > 0)
			_baseurl = "http://"+host;
	} 
	if (_baseurl != null) {
		GELog.debug(StemKml.class,"VerifyClient "+_baseurl);
		// verify that we have a working web server
		VerifyClient vc = new VerifyClient();
		boolean test = vc.verify(_baseurl+
			            	"/"+CONTEXT+"/verify");
		if (! test) {
			GELog.info(vc.getError());
			GELog.error("StemKml: Unable to communicate with web server @ "
					+_baseurl,null);
			if (GEPreferencePage.isInternalServer()){
				_failed = true;
			}
			_baseurl = null;
		} 
	}
	if (_baseurl == null) {
		GELog.error("GoogleEarth Servlet support disabled",null);
	}
	return _baseurl;
}

/** 
 * Startup an internal web server to run the 
 * GEServlet servlets.
 * @return url for host and port 
 *       example: http://127.0.0.1:54345/
 *       It will return null if unable to start server
 */	
@SuppressWarnings({ "deprecation" }) 
public static String startWebServer() {
	String url = null;
	if (!_started && !_failed)	  {
	    try {
	    	GELog.debug(StemKml.class,"Start webServer");
			WebappManager.start(CONTEXT, Activator.PLUGIN_ID, Path.EMPTY);
			
			String internalHost = WebappManager.getHost() + ":" + WebappManager.getPort();
			 url = "http://" +  internalHost;
			 GELog.debug(StemKml.class,"Started webServer "+url);
			 
		} catch (CoreException e) {
			GELog.error(e.getMessage(), e);
			_failed = true;
			url = null;
		}
	  } else if (!_failed ) {
		  String internalHost = WebappManager.getHost() + ":" + WebappManager.getPort();
			 url = "http://" +  internalHost; 
	  }
	GELog.debug(StemKml.class,"embedded web server at: "+url);
	if (! _failed) 
		_started = true;
	return url;
}

/**
 * obtain the URL used to access the GE Servlets.
 * 
 * @return The URL as a string, null if unable to 
 *   access a valid web server.
 */
static public String getServerUrl() {
	return _baseurl;
}

/**
 * Set the filename based on the Template and 
 * the current aspect and cycle number.
 * 
 * @param folder Folder where kml files are written
 * @param template 
 * @param aspect aspect to be displayed
 * @param cycle
 * 
 * @return resulting absolute filename
 */
	public static String getControlFN(String folder, String template,
			Aspect aspect, long cycle) {
        String controlFN = "";
		String seq = "0000" + cycle;
		if (cycle > 9)
			seq = "000" + cycle;
		if (cycle > 99)
			seq = "00" + cycle;
		if (cycle > 999)
			seq = "0" + cycle;
		if (cycle > 9999)
			seq = "" + cycle;
		// we won't worry about cycle > 99,999
		
		controlFN = folder + "/" + template;
		controlFN = controlFN.replaceAll("&T", aspect.toString());
		controlFN = controlFN.replaceAll("&N", seq);
		GELog.debug(StemKml.class,"Output file="+controlFN);
		return controlFN;

	}
/**
 * 
 * @return true if servlet should wait when it has
 *  sent all of the available kml files to GE
 */
public static boolean isWaitForKML() {
	return waitForKML;
}
/**
 * Set true if servlet should wait
 * @param waitForKML
 */
public static void setWaitForKML(boolean waitForKML) {
	StemKml.waitForKML = waitForKML;
}
 
}// class

