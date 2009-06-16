package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Given a set of run parameter names and values, find a matching run parameter
 * file anywhere in a sub directory of the input directory. Useful for finding
 * exactly the logged data you want 
 */
public class FindRunParameterFile {

	/**
	 * 
	 * @param args
	 */
	public static void main(String [] args) {
		if(args.length < 1) {
			System.err.println("Usage: FindRunParameterFile <dir> <param 1> <val 1> <param 2> <val 2> ... <param n> <val n>"); //$NON-NLS-1$
			System.exit(-1);
		}
		
		String dir = args[0];
				
		try {
			 // Open dir
			File d = new File(dir);
			if(!d.exists() || !d.isDirectory()) { 
				System.err.println(dir+ "not found or it is not a directory"); //$NON-NLS-1$
				System.exit(-1);
			}
			
			recurseSearch(d, args);
			} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void recurseSearch(File d, String [] args) {
		 // Read infectious file
		
		try {
		 if(d.isDirectory()) {
			 // Keep going down deeper
			 String [] files  = d.list();
			 for(String _d:files) {
				 File f = new File(d.getAbsolutePath()+File.separator+_d);
				 // Unix make sure it's not parent dir or we get infinite loop problem here
				 // Fix later
				 recurseSearch(f, args);
			 }
		 }
		 
		 // Not a directory. Does the file name match?
		 
		 String name = d.getName();
		 if(!name.equals("runparameters.csv") && !name.equals("runparamters.csv")) return ; // wrong file //$NON-NLS-1$ //$NON-NLS-2$
		 
		 
		 
		 
		 ArrayList<String> paramNames = new ArrayList<String>();
		 ArrayList<String> paramVals = new ArrayList<String>();
		 
		 FileInputStream ifile = new FileInputStream(d); 
	     BufferedReader ireader = new BufferedReader(new InputStreamReader(ifile));
	     String header = null;
	     header=ireader.readLine();
	     if(header == null) {
	    	 System.err.println("Error, "+d.getAbsolutePath()+" file is empty!");  //$NON-NLS-1$//$NON-NLS-2$
	    	 System.exit(-2);
	     }
	     StringTokenizer st = new StringTokenizer(header, ","); //$NON-NLS-1$
	     while(st.hasMoreTokens()) {
	    	 String val = st.nextToken();
	    	 paramNames.add(val.trim());
	     }
	    
	    String data = null; 
	    data=ireader.readLine();
	    if(data == null) {
	    	 System.err.println("Error, "+d.getAbsolutePath()+" file has no data!");  //$NON-NLS-1$//$NON-NLS-2$
	    	 System.exit(-2);
	     }
	    
	    st = new StringTokenizer(data, ","); //$NON-NLS-1$
	   while (st.hasMoreTokens()) {
			String val = st.nextToken().trim();
			
			// Standard format for number 
			try {
				BigDecimal bd = new BigDecimal(val);
			    bd = bd.setScale(5,BigDecimal.ROUND_HALF_UP);
			    val = bd.toString();
			}catch(NumberFormatException nfe) {
				// Ignore not a double
			}
			paramVals.add(val);
	    } // read tokens
	 
	   ireader.close();
		
	   // Now see if the file matches
	   
	   boolean match = true;
	   for(int i = 1;i<args.length;i+=2) {
		   String pname = args[i].trim();
		   String pval = args[i+1].trim(); // index out of bound if bad input
		   // Conform to standard number format if it's a number
		   try {
				BigDecimal bd = new BigDecimal(pval);
			    bd = bd.setScale(5,BigDecimal.ROUND_HALF_UP);
			    pval = bd.toString();
			}catch(NumberFormatException nfe) {
				// Ignore not a double
			}
		   if(!paramNames.contains(pname)) {match = false;break;}
		   for(int n=0;n<paramNames.size();++n) 
			   if(pname.equals(paramNames.get(n)) && !pval.equals(paramVals.get(n))) {match=false;break;}
	   }
	   if(!match) return;
	   
	   System.out.println(d.getAbsolutePath());
	 	} catch(Exception e) {
			e.printStackTrace();
		}
	    
	}
}
