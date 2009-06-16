package org.eclipse.stem.ui.ge.servlet;
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
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet that provides a service interface allows the client to 
 * get the BBox info that was sent to SlideShowServlet by GoogleEarth. 
 * 
 * 
 * 
 * 
 * 
 */
public class BBoxServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final String DEFAULT_BBOX = 
		    "-75.20637865775808,40.19453859682661," +
			"-68.769920795513,43.94930914694464";	
  /**
  * Service interface. 
  * - BBox - Send back the GE BBox info
  * 
  * 
  * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
  */
 protected void service(HttpServletRequest request,HttpServletResponse response) 
         throws ServletException, IOException {
 	
		DataInputStream in = 
			new DataInputStream(request.getInputStream());
		response.setContentType("application/octer-stream");
		// use ByteArray output
		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
		
		DataOutputStream output =
			new DataOutputStream(byteOutput);
		//
		// read the input from the client
		//
		String command = in.readUTF();
		// BBOX servletID 
		
		if (command.startsWith("BBOX ")) {
			String id = command.substring(5).trim();
			SlideShowInfo info = SlideShowServlet.getInfo(id);
			//SlideShowServlet.debug("id: "+id+" info: "+info);
			
			if (info != null)
			    output.writeUTF("BBOX: "+info.getBBOX());
			else 
				output.writeUTF("BBOX: "+DEFAULT_BBOX);
		
		} else {
			String errmsg = "Error: Received: "+command;
			//SlideShowServlet.debug(errmsg);
			output.writeUTF(errmsg);
		}
		output.flush();
		byte[] buf = byteOutput.toByteArray();
		response.setContentLength(buf.length);
		ServletOutputStream servletOutput = response.getOutputStream();
		servletOutput.write(buf);
		servletOutput.close();
		
	}
	
    
	
	@SuppressWarnings("unused")
	private void errHtml(HttpServletResponse response, String msg)
			throws IOException {
		response.setContentType("text/html");
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.println("<html>");
		out.println("<head><title>BBoxServlet Error</title></head>");
		out.println("<body>");
		out.println("<p>" + msg + "</p>");
		out.println("</body></html>");
		out.flush();
	}
	


}


