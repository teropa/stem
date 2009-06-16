package org.eclipse.stem.diseasemodels.experimental.impl;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author James
 *
 */
public class LogDiseaseState {

    private static FileWriter fw;

    /**
     * Constructor
     * @param fileName
     */
	public LogDiseaseState(String fileName) {
		try {
			fw = new FileWriter(fileName);
	} catch (IOException e) {
				System.out.println("Error creating file writer "+e.getMessage());
			    e.printStackTrace();
			    System.exit(1);
	}
	}
	

/**
 * write string
 * @param str
 */
public void write(String str) {
	try {
		 //System.out.print(str);
	     fw.write(str); 
	 } catch (IOException e) {
			System.out.println("Error writing to file writer "+e.getMessage());
		    e.printStackTrace();
		    System.exit(1);
	  }// try
} // write

/**
 * close
 */
public static void close() {
			
	try {
		  fw.flush();
	      fw.close();
	} catch (IOException e) {
			System.out.println("Error closing file writer "+e.getMessage());
		    e.printStackTrace();
	}// try
}
	

} // LogDiseaseState