package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Split a log file into 2 or more files
 */
public class SplitLogFile {

	static String LS = System.getProperty("line.separator"); //$NON-NLS-1$
	
	
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings("nls")
	public static void main(String [] args) {
		if(args.length < 1) {
			System.err.println("Usage: SplitLogFile <log file> <segments>"); //$NON-NLS-1$
			System.exit(-1);
		}
		
		String logFile = args[0];
		int segments = 2; //default
		if(args.length == 2)
			segments = Integer.parseInt(args[1]);
		
		
		ArrayList<String>headers = new ArrayList<String>();
		ArrayList<ArrayList<String>>logText = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<Double>>logData = new ArrayList<ArrayList<Double>>();
		
		List<String>iterations = new ArrayList<String>();
		List<String>timestamps = new ArrayList<String>();
		List<List>dataVals = new ArrayList<List>();
		
		try {
			 // Read infectious file
			 FileInputStream ifile = new FileInputStream(logFile); 
		     BufferedReader ireader = new BufferedReader(new InputStreamReader(ifile));
		     String header = null;
		     header=ireader.readLine();
		     if(header == null) {
		    	 System.err.println("Error, "+args[0]+" file is empty!");  //$NON-NLS-1$//$NON-NLS-2$
		    	 System.exit(-2);
		     }
		     StringTokenizer st = new StringTokenizer(header, ","); //$NON-NLS-1$
		     int column = 0;
		     while(st.hasMoreTokens()) {
		    	 String val = st.nextToken();
		    	 headers.add(val.trim());
		    	 ++column;
		     }
		    
		   
		    
		    FileWriter [] writers = null;
		    int columnsperfile = (headers.size()-2)/segments;
		    writers = new FileWriter[segments];
		    for(int i=0;i<segments;++i) {
		    	writers[i] = new FileWriter(logFile+"."+i+".csv");
		    	writers[i].write(headers.get(0));
		    	writers[i].write(",");
		    	writers[i].write(headers.get(1));
		    	writers[i].write(",");
		    	int end = (i==segments-1)? headers.size() : (2+(i+1)*columnsperfile);
		    	for(int j=2+i*columnsperfile;j<end;++j) {
		    		writers[i].write(headers.get(j));
		    		if(j<end-1)writers[i].write(",");
		    	}
		    	writers[i].write(LS);
		    }
		    
		    String data = null; 
		    data=ireader.readLine();
		    if(data == null) {
		    	 System.err.println("Error, "+args[0]+" file has no data!");  //$NON-NLS-1$//$NON-NLS-2$
		    	 System.exit(-2);
		     }
		    while(data != null && data.trim().length() > 0) {
			    st = new StringTokenizer(data, ","); //$NON-NLS-1$
			    column = 0;
			    ArrayList<String> txtlist = new ArrayList<String>();
			    ArrayList<Double> datalist = new ArrayList<Double>();
				while (st.hasMoreTokens()) {
					String val = st.nextToken().trim();
					txtlist.add(val);
				    ++ column;
			    } // read tokens
				
				for(int i=0;i<segments;++i) {
					writers[i].write(txtlist.get(0));
				 	writers[i].write(",");
					writers[i].write(txtlist.get(1));
				 	writers[i].write(",");
				 	
					int end = (i==segments-1)? headers.size() : (2+(i+1)*columnsperfile);
			    	for(int j=2+i*columnsperfile;j<end;++j) {
			    		writers[i].write(txtlist.get(j));
			    		if(j<end-1)writers[i].write(",");
			    	}
			    	writers[i].write(LS);
				}
				txtlist.clear();
				data=ireader.readLine();
		    }
		    ireader.close();
		    for(int i=0;i<segments;++i) {writers[i].flush();writers[i].close();}
		    // Process the data
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

