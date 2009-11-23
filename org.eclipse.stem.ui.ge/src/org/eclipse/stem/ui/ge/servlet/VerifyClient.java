package org.eclipse.stem.ui.ge.servlet;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.stem.ui.ge.Activator;
import org.eclipse.stem.ui.ge.GELog;


/**
 * Holder for the verify method that
 * will verify that the specified webserver 
 * is available and that the Stem-GoogleEarth servlets
 * are deployed.
 * 
 * It will also send the setting of the DEBUG flag
 * to the servlet codebase so it can be used there.
 * 
 * <code>
 *    String url = "http://localhost:8080/STEM/verify"
 *    VerifyClient vc = new VerifyClient();
 *    boolean ok = vc.verify(url)
 *    if (! ok) {
 *       System.out.println(vc.getError());
 *       return;
 *    }
 *    ...
 * </code>
 *
 */
public class VerifyClient {

	;
	/**
     * String that we will send the client
     */
 	public static String outputText="VerifyClient "+
 			Version.version;
 	/**
 	 * String that client should send us.
 	 */
 	public static String expectedText="VerifyServlet "+
 			Version.version;	
    private String error = "";
	/**
	 * Verify: 
	 *   (1) that the web server is active 
	 *   (2) that the servlets are deployed
	 *   
	 * @param urlstr  URL like //localhost:8080/STEM/verify
	 * @return OK" or an error message
	 */
	public  boolean verify(String urlstr) {
		boolean result = true;
		error = "";
		try {
			//GELog.DEBUG=true;
			URL url = new URL(urlstr);
			URLConnection connect = url.openConnection();
			connect.setUseCaches(false);
			connect.setDoInput(true);
			connect.setDoOutput(true);
			connect.setRequestProperty("Content-type", "application/octet-stream");
			
			  // use ByteArray output
			ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
			DataOutputStream output =
				new DataOutputStream(byteOutput);
			String outputString = outputText;
			if (GELog.DEBUG) {
				outputString = outputText+" DEBUG ";
			}
			GELog.debug(this,"Sending: "+outputString);
			output.writeUTF(outputString);
			
			output.flush();
			byte[] buf = byteOutput.toByteArray();
			
			connect.setRequestProperty("Content-length", ""+buf.length);
			DataOutputStream dataOutput =
				new DataOutputStream(connect.getOutputStream());
			dataOutput.write(buf);
			dataOutput.flush();
			dataOutput.close();
			
			DataInputStream in = 
				new DataInputStream(connect.getInputStream());
			String stringValue = in.readUTF();
			
			in.close();
			
			if (stringValue.equals(expectedText)) {
				String msg = "OK: "+              
	            " Received: "+stringValue;
	            GELog.debug(this,msg);
			} else {
				error = "ERROR "+
					                "Expected: "+expectedText+
					                " Received: "+stringValue;
				GELog.debug(this,error);
				result=false;	
			}
		} catch (MalformedURLException e) {	
			
			GELog.debug(e.getMessage());
		
			error ="ERROR Invalid URL "+urlstr;
			result = false;
		} catch (IOException e) {			
			GELog.debug(e+": "+e.getMessage());
			
			error="EXCEPTION  "+e+": "+e.getMessage();
			result = false;
		}
		Activator.logError(error, null);
		return result;
	}
	
	
	/**
	 * Return the error message from the last check.
	 * 
	 * @return Error message from the previous call 
	 * to VerifyClient.
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
}
