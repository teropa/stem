package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * The utility attenuates seasonal data to dampen infectious cases during seasons when
 * a particular strain is not dominant. For instance, if a log file contains influenza
 * cases for 10 years worth of data, and year 1, 2, 5 and 7 of those years had H3N2 strain,
 * you can use the program to get rid of the peaks for year 3, 4, 6, 8, 9 and 10.
 */
public class AttenuateLogFile {

	static String LS = System.getProperty("line.separator"); //$NON-NLS-1$
	
	
	/**
	 * NLS Prefix for Infector name
	 */
	public static String infectorPrefix = Messages.getString("Inoculator.1"); //$NON-NLS-1$
	
	/**
	 * NLS Prefix for Inoculator name
	 */
	public static String inoculatorPrefix = Messages.getString("Inoculator.2"); //$NON-NLS-1$
	
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings("nls")
	public static void main(String [] args) {
		if(args.length < 4) {
			System.err.println("Usage: AttenuateLogFile <log file> <cycle period> <start offset> <signal1> <signal2> ... <signal n>"); //$NON-NLS-1$
			System.exit(-1);
		}
		
		String logFile = args[0];
		double period = Double.parseDouble(args[1]);
		int offset = Integer.parseInt(args[2]);
		double damp  = Double.parseDouble(args[3]);
		
		int [] signal = new int[args.length-4];
		for(int i=4;i<args.length;++i) signal[i-4]=Integer.parseInt(args[i]);
		
		ArrayList<String>headers = new ArrayList<String>();
		ArrayList<ArrayList<String>>logText = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<Double>>logData = new ArrayList<ArrayList<Double>>();
		
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
					if(column < 2)
						txtlist.add(val);
					else
						datalist.add(Double.parseDouble(val));
				    ++ column;
			    } // read tokens
				logText.add(txtlist);
				logData.add(datalist);
				data=ireader.readLine();
		    }
		    ireader.close();
		    
		    // Process the data
		    
		    int day = offset;
		    int year = 0;
		    double startNewYear = period;
		    System.out.println("signal: "+signal);
		    for(int i=0;i<logText.size();++i) {
		    	int sig = signal[year];
		    	ArrayList<Double> infdata = logData.get(i);
		    	if(sig == 0)
		    		for(int j=0;j<infdata.size();++j) infdata.set(j, infdata.get(j)*damp);
		    	
		    	day += 1;
		    	if(day > startNewYear) {
		    		startNewYear += period;
		    		++year;
		    	}
		    	System.out.println("iteration "+i+" signal: "+sig);
		    }
		    
		    FileWriter outfw = new FileWriter(logFile+".new.csv");
		    for(int i=0;i<headers.size();++i) {
		    	outfw.write(headers.get(i));
		    	if(i <headers.size()-1) outfw.write(",");
		    }
		    outfw.write(LS);
		    
		    for(int i=0;i<logText.size();++i) {
		    	 ArrayList<String> txtlist = logText.get(i);
				 ArrayList<Double> datalist = logData.get(i);
				 for(String t:txtlist) outfw.write(t+",");
				 for(int j=0;j<datalist.size();++j) {
					 outfw.write(datalist.get(j)+"");
					 if(j<datalist.size()-1)outfw.write(",");
				}
				 outfw.write(LS);
		    }		    
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
