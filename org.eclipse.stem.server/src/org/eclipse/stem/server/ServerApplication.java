package org.eclipse.stem.server;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class ServerApplication implements IApplication {

	public Object start(IApplicationContext context) throws Exception {
		return IApplication.EXIT_OK;
	}
	
	public void stop() {		
	}
	
}
