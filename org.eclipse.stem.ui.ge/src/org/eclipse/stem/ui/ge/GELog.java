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
import java.util.Date;

import org.eclipse.stem.ui.ge.views.GEPreferencePage;


/**
 * debug Utility methods for GoogleEarth Interface
 *  <p>
 *   * The main use of this class is to provide additional 
	 * debugging output when in debug mode on the primary 
	 * eclipse console and still provide logging of exceptions 
	 * to the eclipse ILog error log facility.  
	 * Although Eclipse provides an Error log facility in the 
	 * application workbench being tested,  it is more convienent
	 * to get your debug messages and unexpected exception in the
	 * Eclipse Console that is controling the test environment.
 * <p>
 * Typical use of this class:
 * <pre>
 *   // early in startup. 
 *   // in view constructor or junit test class
 *   GELog.DEBUG = true; 
 *   ...
 *   GELog.debug(this,"Current simulation: "+simulation);
 *   try {
 *     ...
 *   } catch (Exception e) {
 *      GELOG.error("strange failure",e);
 *   }
 *   </pre>
 *   When DEBUG is true then both the Eclipse console and 
 *   the Eclipse log will get the debug msg and the exception
 *   stacktrace but if DEBUG is false then the debug message 
 *   will not appear anywhere and the Exception stacktrace 
 *   will only appear in the eclipse log.
 *     
 *   
 */
public class GELog {
	/**
	 * if true then GElog methods produces output
	 * 
	 * It would be set true normally in the GEView constructor 
	 * based on the PrefereencePage setting. 
	 * It could be also set in any junit tests where we 
	 * want to have additional debug output.
	 * This could be changed to "static final" to compile 
	 * out the execution of the if (DEBUG) statement.	
	 */
	public static boolean DEBUG = false;

    private static final long start = new Date().getTime();

	/**
	 * temporary debug statements.
	 * Calls to this method are intended for debugging and 
	 * could be removed before publishing the code.
	 * They are displayed on the Eclipse Console only if
	 * the DEBUG variable is true.
	 * @param msg The string to be displayed.
	 */
	public static void debug(String msg) {
		if (GELog.DEBUG) {
		  System.out.println("GE: "+msg);
		  System.out.flush();
		}
	}
	/**
	 * temporary debug statements.
	 * Calls to this method are intended for debugging and 
	 * could be removed before publishing the code.
	 * They are displayed on the Eclipse Console only if
	 * the DEBUG variable is true.
	 * <code>
	 * Example:
	 *    GELog.debug(this,"a msg to help debugging");
	 *  -->>
	 *     System.out.println("AclassName: a msg to help debugging"); 
	 *       
	 * </code>   
	 * @param where - Indicator of class where msg generated
	 *     Can be String, class or instance
	 * @param msg The string to be displayed.
	 */
	public static void debug(Object where,String msg) {
		if (GELog.DEBUG) {
			
			String classname = "";
			if (where instanceof String) {
				classname = (String)where;
			} else if (where instanceof Class) {
				classname = ((Class)where).getSimpleName();
			} else {
				classname = where.getClass().getSimpleName();
				// handle GELog.debug(this,msg)
				Thread t = Thread.currentThread();
				StackTraceElement[] st = t.getStackTrace();
				if (st[3].getClassName().contains(classname)) {
					classname = classname+"."+
				            st[3].getMethodName();
				}
			}
			String prefix = classname+": ";
			// add extra debug info is P_TEST
			if (Activator.getDefault() != null) {
				if (GEPreferencePage.isTest()) {
					String t = getThread();
					String clock = getClock();
					prefix = clock+" "+t+"-"+prefix;
				}
			}
		  
		  System.out.println(prefix + msg);
		  System.out.flush();
		}
	}
	
	private static String getThread() {
		return Thread.currentThread().getName();
	}
	
	private static String getClock() {
		long now = new Date().getTime()-start;
		return Long.toString(now);
	}
	/**
	 * handler for exceptions that occur
	 * 
	 * @param current Class that produced msg
	 * @param msg Messsage to be displayed (if not null)
	 * 
	 */
	public static void info(Class current,String msg) {
		info(current.getSimpleName()+": "+msg);
	}
	/**
	 * Handler for info messages.  
	 * Will be produced even if debug option not on
	 * 
	 * @param msg
	 */
	public static void info(String msg) {
		if (GELog.DEBUG) {
		  System.err.println(msg);
		}  
		// now do the correct OSGI thing
		
		Activator.logInfo(msg,null);
		return;
		
	}
	/**
	 * handler for exceptions that occur
	 * 
	 * @param msg Messsage to be displayed (if not null)
	 * @param t  Exception that caused this if not null
	 */
	public static void error(String msg,Throwable t) {
		if (GELog.DEBUG) {
		  System.err.println(msg);
		  if (t != null)
		    t.printStackTrace();
		}
		System.err.flush();
		// now do the correct OSGI thing
		
		Activator.logError(msg, t);
		return;
	}

	
	
	/**
	 * Call garbage collect and display memory stats
	 */
	public static void memory(){
	
		Runtime rt = Runtime.getRuntime();
		//rt.gc();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
		}
		GELog.debug("Memory Total: "+rt.totalMemory()/1024+"K");
		GELog.debug("Memory Free:  "+rt.freeMemory()/1024+"K");
		GELog.debug("Memory Max:   "+rt.maxMemory()/1024+"K");
	}
	
	/**
	 * test if percent of used memory is greater than specified
	 * percent.  
	 * 
	 *  @param percent to check against.
	 *     Example: 0.9 = 90%
	 *  
	 *  @return true if % memeory used is greater 
	 *    than specified percent.
	 */
	public static boolean memoryCheck(double percent){
	   
		Runtime rt = Runtime.getRuntime();
		
		GELog.debug("Memory Max:   "+rt.maxMemory()/1024+"K");
		long used = rt.totalMemory()-rt.freeMemory();		
		double currentPercent = ((double)used)/((double)rt.maxMemory());
		GELog.debug("Memory Used:  "+used/1024+"K");		
		GELog.debug("Percent Used: "+currentPercent);
		if (currentPercent > percent ) {
			//rt.gc();   // Check after Garbage collector runs
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
			}			
			
			used = rt.totalMemory()-rt.freeMemory();
			currentPercent = ((double)used)/((double)rt.maxMemory());
			GELog.debug("Memory used after GC:  "+used/1024+"K");	
			GELog.debug("Percent Used: "+currentPercent);
			return (currentPercent > percent ) ;
		}
		return false;
	}
	/**
	 * main() method for testing.
	 * @param args
	 */
	public static void main(String[] args) {
		GELog.DEBUG = true;
		
		GELog.debug("msg with no class.");
		
		GELog.debug(GELog.class,"msg with class specified");
		try {
			Object a = null;
			a.getClass();
		} catch (Throwable t) {
			GELog.error("Expected NullPointerException",t);
		}
	}
}
