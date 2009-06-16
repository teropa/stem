/**
 * 
 */
package org.eclipse.stem.internal.data.utility;


/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * DatarUtility contains methods to validate and test different internal data in STEM
 * 
 **/
public class DataUtility {
	
	private static final String PARENT_DIR 		= "./resources/data/country";
	private static final String POP_FILE_SUFFIX = "population.properties";
	private static final String AREA_FILE_SUFFIX = "area.properties";
	private static final String NODE_FILE_SUFFIX = "node.properties";
	private static final String ADMIN_LEVEL 	= "ADMIN_LEVEL";
	
	/**
	 * zero population finder
	 */
	public static final int FIND_ZERO_POPULATION = 0;
	
	/**
	 * find duplicate ids
	 */
	public static final int FIND_DUPLICATE_IDS   = 1;
	

	/**
	 * Main method for testing
	 * @param args
	 */
	public static void main(String[] args) {
		scanFiles(FIND_ZERO_POPULATION);

	}

	/**
	 * This Method scans STEM property files and runs various optional tests
	 */
	static void scanFiles(int option) {
		 
		  String record;  
          int recCount = 0;
          try { 
        	  File f = new File(PARENT_DIR);
        	  if (f.isDirectory()) {
        		 File[] children = f.listFiles();
        		 for (int i = 0; i < children.length; i ++) {
        			 File child = children[i];
        			 
        			 if ((!child.getName().equalsIgnoreCase("ZZZ"))||(!child.getName().equalsIgnoreCase("ZZZ")) ) {
        				 if (child.isDirectory()) {
        					 File[] files = child.listFiles();
        					 int poptotal = 0;
        					 for (int j = 0; j < files.length; j ++) {
        						 File next = files[j];
        						 poptotal = 0;
        						 String name = next.getName();
        						 if( (name.indexOf("RUS")>=0) && (name.indexOf(AREA_FILE_SUFFIX)>=1) ) checkAreas(next);
        					
        						 if(option==FIND_DUPLICATE_IDS) {
        							 if(name.indexOf(NODE_FILE_SUFFIX)>=0) checkDuplicates(next) ;
        						 }
        						 

        						 if(option==FIND_ZERO_POPULATION) {
        							 if(name.indexOf(POP_FILE_SUFFIX)>=2) {
          							   FileInputStream fis = new FileInputStream(next); 
          					           BufferedReader d = new BufferedReader(new InputStreamReader(fis));
          					           while ( (record=d.readLine()) != null ) {
          					        	 //  System.out.println(""+name+":   "+record);
          					                 recCount++;
          					                 
          					                 if (record.indexOf(ADMIN_LEVEL)==-1) {
          					                 if(record.indexOf("= 0")>= 1) {
          					                		 System.out.println(""+name+":   "+record);
          					                 } else if (record.indexOf(" = ")>= 1) {
          					                		 int idx = record.indexOf("=");
          					                		 String val = record.substring(idx+1, record.length());
          					                		 
          					                		 try {
          					                		 Integer obj = new Integer(val.trim());
          					                		 poptotal += obj.intValue();
          					                		 } catch(NumberFormatException nfe) {
          					                			 // nothing
          					                		 }
          					                 }
          					                	 
          					                 }
          					           } // while
          					          
          					           // USE THIS FOR ZERO POPULATION REPAIR
          					           //
          					 // System.out.println(""+name+" pop= "+poptotal);
          					           //
          					           //
          						 }
        						 }// find zero populations
        						 
        						 
        					 }// for j files
        				 }// if directory
        			 }// if name
        				
        		 }
        	  }
        	 
           } catch (Exception e) { 
              // catch io errors from FileInputStream or readLine() 
              System.out.println(" IOException error!" + e.getMessage()); 
              e.printStackTrace();
           }
	} // read codes
	
	/**
	 * check a file for zero areas
	 * @param file
	 */
	private static void checkAreas(File file) {
		int recCount = 0;
		double areaTotal = 0.0;
		String record;
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader d = new BufferedReader(new InputStreamReader(fis));
		
		while ((record = d.readLine()) != null) {
			//  System.out.println(""+name+":   "+record);
			recCount++;

			if (record.indexOf(ADMIN_LEVEL) == -1) {
				if (record.indexOf("= 0") >= 1) {
					// System.out.println(""+name+":   "+record);
				} else if (record.indexOf(" = ") >= 1) {
					int idx = record.indexOf("=");
					String val = record.substring(idx + 1, record.length());

					try {
						Double obj = new Double(val.trim());
						areaTotal += obj.intValue();
					} catch (NumberFormatException nfe) {
						// nothing
					}
				}

			}
		} // while
		} catch (Exception e) {
			// catch io errors from FileInputStream or readLine() 
			System.out.println(" IOException error!" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("*******************   " + file.getName()
				+ " AREA = " + areaTotal);

	}// CHECK AREAS
	
	/**
	 * check a file for duplicate ids
	 * @param file
	 */
	private static void checkDuplicates(File file) {
		
		int recCount = 0;
		Set<String> keySet = new HashSet<String>();
		Set<String> duplicateSet = new HashSet<String>();
		String record;
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader d = new BufferedReader(new InputStreamReader(fis));
		
		while ((record = d.readLine()) != null) {
			//  System.out.println(""+name+":   "+record);
			recCount++;

			if (record.indexOf(ADMIN_LEVEL) == -1) {
				if (record.indexOf("= 0") >= 1) {
					// System.out.println(""+name+":   "+record);
				} else if ((record.indexOf(" = ") >= 1)&&((record.indexOf("#") == -1))) {
					int idx = record.indexOf("=");
					//String val = record.substring(idx + 1, record.length());
					String key = (record.substring(0, idx)).trim();
					//System.out.println("key = "+key);
					try {
						//Double obj = new Double(val.trim());
						if(keySet.contains(key)) duplicateSet.add(key);
						
						keySet.add(key);
					} catch (NumberFormatException nfe) {
						// nothing
					}
				}

			}
		} // while
		} catch (Exception e) {
			// catch io errors from FileInputStream or readLine() 
			System.out.println(" IOException error!" + e.getMessage());
			e.printStackTrace();
		}
		
		String[] allKeys = new String[duplicateSet.size()];
		Iterator<String> iter = duplicateSet.iterator();
		int icount = 0;
		while((iter!=null)&&(iter.hasNext())) {
			if(icount==0) System.out.println(" ** DUPLICATES in filename = "+file.getName());
			allKeys[icount] = iter.next();
			icount ++;
		}
		Arrays.sort(allKeys);
		
		for (int i = 0 ; i < allKeys.length; i ++) {
			System.out.println(""+allKeys[i]);
		}
		

	}// CHECK DUPLICATES
	
}
