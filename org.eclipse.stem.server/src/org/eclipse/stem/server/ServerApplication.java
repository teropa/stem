package org.eclipse.stem.server;

import org.eclipse.net4j.util.om.OSGiApplication;

public class ServerApplication extends OSGiApplication {

	private CDOServer cdoServer;
	private SimulationRunner simRunner;
	
	public ServerApplication() {
		super("org.eclipse.stem.server.ServerApplication");
	}
	
	@Override
	public void doStart() throws Exception {
		super.doStart();
		startCDOServer();
		startSimulationRunner();
	}

	private void startCDOServer() throws Exception {
		cdoServer = new CDOServer();
		cdoServer.start();
	}
	
	private void startSimulationRunner() {
		simRunner = new SimulationRunner();
		simRunner.start();
	}

	@Override
	public void doStop() throws Exception {
		stopSimulationRunner();
		stopCDOServer();
		super.doStop();
	}

	private void stopSimulationRunner() {
		simRunner.stop();
		simRunner = null;
	}
	
	private void stopCDOServer() {
		cdoServer.stop();
		cdoServer = null;
	}
	
}
