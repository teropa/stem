package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * This class represents 
 */
public class ContainmentRelationshipFinder {

	private static String CNTRY_LVL0_CODE;
	// get the path
	private static final String sep = File.separator;
	@SuppressWarnings("nls")
	private static final String PATH = "C:"+sep+"eclipse"+sep+"workspace3"+sep;
	@SuppressWarnings("nls")
	private static final String[] excludeList = {"USA","JPN","CVS","THA","ZZZ"};
	private static HashSet<String> excludeSet = new HashSet<String>();
	private static File level1Nodes = null;
	private static File level2Nodes = null;
	
	// the sets of Nodes
	static Set<String> levelOneSet= new HashSet<String>();
	static Set<String> levelTwoSet= new HashSet<String>();
	// for and level two nodes not inside level
	static Set<String> orphanedSet = new HashSet<String>();
	static String outFileName;
	static FileWriter fw;
	
	/**
	 * @param args
	 */
	@SuppressWarnings("nls")
	public static void main(String[] args) {
		for (int i = 0; i < excludeList.length; i ++) {
			excludeSet.add(excludeList[i]);
		}
		
		
		Set allCountries = getAllCountries();
		Iterator iter = allCountries.iterator();
		
		while(iter.hasNext()) {
			levelOneSet.clear();
			levelTwoSet.clear();
			orphanedSet.clear();
			
			CNTRY_LVL0_CODE = (String) iter.next();
			setNodesFiles(CNTRY_LVL0_CODE);
			levelOneSet = getNodesInFile(level1Nodes);
			levelTwoSet = getNodesInFile(level2Nodes);
			
			String nodeDir = PATH+"org.eclipse.stem.internal.data"+sep+"resources"+sep+"data"+sep+"relationship"+sep+"relativephysical"+sep;
			///////////////////////////////////////
			outFileName = nodeDir+CNTRY_LVL0_CODE+"_1_"+CNTRY_LVL0_CODE+"_2.properties"; 
			// 1. process level TWO if we have them
			if(levelTwoSet.size() >= 1) {
				if (levelOneSet.size()<=0) {
					System.out.println("ERROR. Found Level 2 data with no level 1 data for... "+CNTRY_LVL0_CODE);
					System.exit(1);
				}
																	
				 try {
						fw = new FileWriter(outFileName);
					} catch (IOException e) {
						System.out.println("Error creating file writer " + e.getMessage());
						e.printStackTrace();
						System.exit(1);
					}
				writeL1ToL2Header();
				orphanedSet = writeL2inL1Nodes();
				if (fw != null) {
					 try {
							fw.flush();
							fw.close();
						} catch (IOException e) {
							System.out.println("Error creating file writer " + e.getMessage());
							e.printStackTrace();
							System.exit(1);
						}
					}
			}// if level2 exists
			
			
			
			/////////////////////////////////////
			outFileName = nodeDir+CNTRY_LVL0_CODE+"_0_"+CNTRY_LVL0_CODE+"_1.properties"; 
			// now write any level 1 and or orphaned nodes into the level0-1 file
			if (orphanedSet.size() >= 1) {
				levelOneSet.addAll(orphanedSet);
				System.out.println("Warning, country "+CNTRY_LVL0_CODE+" has "+orphanedSet.size()+" orphaned levelTwoNodes ");
				Iterator ugh = orphanedSet.iterator();
				while(ugh.hasNext()) {
					String code = (String) ugh.next();
					System.out.println("orphan = "+code);
				}// level1
			}
				
			
			if(levelOneSet.size()>=1) {
				 try {
						fw = new FileWriter(outFileName);
					} catch (IOException e) {
						System.out.println("Error creating file writer " + e.getMessage());
						e.printStackTrace();
						System.exit(1);
					}
				writeL0ToL1Header();
				writeL1inL0Nodes();
				
				if (fw != null) {
					 try {
							fw.flush();
							fw.close();
						} catch (IOException e) {
							System.out.println("Error creating file writer " + e.getMessage());
							e.printStackTrace();
							System.exit(1);
						}
					}
			}// if level 1 exists
			
		
			
		} // all countries
		
	}// main
	
	
	

	@SuppressWarnings("nls")
	private static Set<String> writeL2inL1Nodes() {
		// ... then
		//1 = JP-0, JP-0-G100001, Contains 
		//2 = JP-TOH, JP-TOH-G460002, Contains
		//3 = JP-TOH, JP-TOH-G460001, Contains
		//4 = JP-TOH, JP-TOH-G460004, Contains
		int icount = 0;
		Set<String> orphans = new HashSet<String>();
		Set<String> matchSet = new HashSet<String>(); 
		Iterator iter = levelOneSet.iterator();
		while(iter.hasNext()) {
			String levelOneCode = (String) iter.next();
			Iterator iter2 = levelTwoSet.iterator();
			while(iter2.hasNext()) {
				String levelTwoCode = (String) iter2.next();
				if(levelTwoCode.indexOf(levelOneCode)>=0) {
					icount ++;
					write(""+icount+" = "+levelOneCode+", "+levelTwoCode+", Contains");
					matchSet.add(levelTwoCode);
				}
			}//level 2
		}// level1
		
		// check that everyone was added somewhere
		Iterator iter3 = levelTwoSet.iterator();
		while(iter3.hasNext()) {
			String levelTwoCode = (String) iter3.next();
		    if (!matchSet.contains(levelTwoCode)) orphans.add(levelTwoCode);
		}
		
		return orphans;
	}




	/**
	 * 
	 */
	@SuppressWarnings("nls")
	private static void writeL1inL0Nodes() {
		//1 = JPN, JP-CHB, Contains
		//2 = JPN, JP-CHG, Contains
		//3 = JPN, JP-0, Contains
		//4 = JPN, JP-KNT, Contains
		int icount = 0;
		Iterator iter = levelOneSet.iterator();
		while(iter.hasNext()) {
			String levelOneCode = (String) iter.next();
			icount ++;
			write(""+icount+" = "+CNTRY_LVL0_CODE+", "+levelOneCode+", Contains");
		}// level1
	}//writeL1inL0Nodes()




	/**
	 * @param str
	 */
	@SuppressWarnings("nls")
	public static void write(String str) {
		try {
		     fw.write(str+"\n"); 
		 } catch (IOException e) {
				System.out.println("Error writing to file writer "+e.getMessage());
			    e.printStackTrace();
			    System.exit(1);
		  }// try
	} // write
	
	
	

	/**
	 * 
	 */
	@SuppressWarnings("nls")
	public static void writeL0ToL1Header() {
		write("# "+CNTRY_LVL0_CODE+"_0_"+CNTRY_LVL0_CODE+"_1.properties ");
		write("#/*******************************************************************************");
		write("# * Copyright (c) 2007 IBM Corporation and others.");
		write("# * All rights reserved. This program and the accompanying materials");
		write("# * are made available under the terms of the Eclipse Public License v1.0");
		write("# * which accompanies this distribution, and is available at");
		write("# * http://www.eclipse.org/legal/epl-v10.html");
		write("# *");
		write("# * Contributors:");
		write("# *     IBM Corporation - initial API and implementation");
		write("# *******************************************************************************/");
		write("");
		write("# This is the name of the class that will interpret the rest of the file's contents");
		write("RECORD_CLASSNAME = org.eclipse.stem.internal.data.records.RelativePhysicalRelationshipGraphRecord");
		write("");
		write("# The title of the relationship");
		write("TITLE = Physical containment of "+CNTRY_LVL0_CODE+" level (1) by "+CNTRY_LVL0_CODE+" (0)");
		write("");
		write("# This is the date range for which the values in this file are valid");
		write("# See http://purl.org/dc/terms/1.1/valid");
		write("VALID = start=1900-01-01;");
		write("");
		write("# This is the source of the data");
		write("SOURCE = http://www.ibm.com");
		write("");
		write("# ISO3166-1 alpha3 keys and levels of relationship");
		write("ISOKEY_0 = "+CNTRY_LVL0_CODE+"");
		write("ISOKEY_0_LEVEL = 0");
		write("ISOKEY_1 = "+CNTRY_LVL0_CODE+"");
		write("ISOKEY_1_LEVEL = 1");
		write("");
		write("# Record Number = Key1, Key2, relationship");
		
		
		
	}
	
	
	/**
	 * 
	 */
	@SuppressWarnings("nls")
	public static void writeL1ToL2Header() {
		write("# "+CNTRY_LVL0_CODE+"_1_"+CNTRY_LVL0_CODE+"_2.properties ");
		write("#/*******************************************************************************");
		write("# * Copyright (c) 2007 IBM Corporation and others.");
		write("# * All rights reserved. This program and the accompanying materials");
		write("# * are made available under the terms of the Eclipse Public License v1.0");
		write("# * which accompanies this distribution, and is available at");
		write("# * http://www.eclipse.org/legal/epl-v10.html");
		write("# *");
		write("# * Contributors:");
		write("# *     IBM Corporation - initial API and implementation");
		write("# *******************************************************************************/");
		write("");
		write("# This is the name of the class that will interpret the rest of the file's contents");
		write("RECORD_CLASSNAME = org.eclipse.stem.internal.data.records.RelativePhysicalRelationshipGraphRecord");
		write("");
		write("# The title of the relationship");
		write("TITLE = Physical containment of Japan level (2) by "+CNTRY_LVL0_CODE+" (1)");
		write("");
		write("# This is the date range for which the values in this file are valid");
		write("# See http://purl.org/dc/terms/1.1/valid");
		write("VALID = start=1900-01-01;");
		write("");
		write("# This is the source of the data");
		write("SOURCE = http://www.ibm.com");
		write("");
		write("# ISO3166-1 alpha3 keys and levels of relationship");
		write("ISOKEY_0 = "+CNTRY_LVL0_CODE+"");
		write("ISOKEY_0_LEVEL = 1");
		write("ISOKEY_1 = "+CNTRY_LVL0_CODE+"");
		write("ISOKEY_1_LEVEL = 2");
		write("");
		write("# Record Number = Key1, Key2, relationship");
	}
	/**
	 * 
	 * @return a set of all the countries
	 */
	@SuppressWarnings("nls")
	public static Set getAllCountries() {
		HashSet<String> all = new HashSet<String>();
		int icount = 0;
		String nodeDir = PATH+"org.eclipse.stem.internal.data"+sep+"resources"+sep+"data"+sep+"country"+sep;
		System.out.println("country dir = "+nodeDir);
		File nodes = new File(nodeDir);
		if (nodes.exists()&&nodes.isDirectory()) {
			//System.out.println("found top level data dir");
			File[] contained = nodes.listFiles();
			for (int i = 0; i < contained.length; i ++) {
				File file = contained[i];
				if (file.isDirectory()) {
					String fileName = file.getName();
					if((fileName.length()==3)&&(!excludeSet.contains(fileName))) {
						all.add(fileName);
						icount ++;
						//System.out.println("found "+fileName);
					}// if it's a country dir not on exclude lise
				}// if directory
			}// for all contained files
			System.out.println(" found "+icount+" countries");
		} else {
			System.out.println("top level data dir not found - check static path hardcoded");
		}
		
		return all;
	}
	
	/**
	 * @param countryCode
	 */
	@SuppressWarnings("nls")
	public static void setNodesFiles(String countryCode) {
		// init
		level1Nodes = null;
		level2Nodes = null;

		// directory of node data
		String nodeDir = PATH+"org.eclipse.stem.internal.data"+sep+"resources"+sep+"data"+sep+"country"+sep+countryCode;
		File dir = new File(nodeDir);
		
		if (dir.exists()&&dir.isDirectory()) {
			//System.out.println("found top level data dir");
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i ++) {
				File file = files[i];
				if (file.isFile()) {
					if(file.getName().indexOf("_1_node.properties") >= 1) {
						level1Nodes = file;
					}
					if(file.getName().indexOf("_2_node.properties") >= 1) {
						level2Nodes = file;
					}
				}
				
			}// for i files contained
		}// if directory
		return;
	}
	
	
	
	/**
	 * @param file
	 * @return foo
	 */
	@SuppressWarnings("nls")
	public static Set<String> getNodesInFile(File file ) {
		HashSet<String> nodeSet = new HashSet<String>();
		if (file==null) return nodeSet;
		// the data starts after this required string. must have both
		final String startString1 = "SPATIAL_URI";
		final String startString2 = "platform:/plugin/org.eclipse.stem.geography/resources/data/geo/country/";
		FileInputStream fis;
		BufferedReader d = null;
		try {
			fis = new FileInputStream(file); 
			d = new BufferedReader(new InputStreamReader(fis));
		} catch(Exception e) {
        	System.out.println("error opening stream for file "+file.getName());
        	System.out.println(" error "+e.getMessage());
        	e.printStackTrace();
        	System.exit(1);
        }
        
        String record = "";
        boolean start = false;
        try {
        while ( (record=d.readLine()) != null ) { 
           // get past the header and make sure we found
           // the required tags of a valid node file
           // System.out.println( "line=  " + record);
          
           
           if (start) {
        	   int comment = record.indexOf("#");
                if(comment < 0) {
                	// not a comment
                	int eqChr = record.indexOf("=");
                	if (eqChr >= 1) {
                		// this is a node
                		String padded = record.substring(0,eqChr);
                		String node = padded.trim();
                		
                		//************
                		//System.out.println("found key= ["+node+"]");
                		//************
                		
                		nodeSet.add(node);
                	}// if this is a node
                }// not a comment
           } // if start string has been found
           if ((record.indexOf(startString1)>=0)&&(record.indexOf(startString2)>=0)) {
        	   start = true;
           }
        }// while
        } catch(Exception e) {
        	System.out.println("error reading file "+file.getName());
        	System.out.println(" error "+e.getMessage());
        	e.printStackTrace();
        	System.exit(1);
        }
        
        if (!start) {
        	System.out.println(" file "+file.getName()+" has no valid data");
        	System.exit(1);
        }
		
		return nodeSet;
	}// get Nodes in File
	
	
	
	
}// Class ContainmentRelationshipFinder 
