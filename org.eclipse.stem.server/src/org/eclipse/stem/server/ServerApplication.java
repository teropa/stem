package org.eclipse.stem.server;

import java.io.File;

import org.eclipse.emf.cdo.internal.server.RepositoryConfigurator;
import org.eclipse.emf.cdo.internal.server.bundle.OM;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.net4j.TransportConfigurator;
import org.eclipse.net4j.acceptor.IAcceptor;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.OSGiApplication;

public class ServerApplication extends OSGiApplication {

	private static String ID = OM.BUNDLE_ID + ".app";
	
	private IRepository[] repositories;
	private IAcceptor[] acceptors;
	
	public ServerApplication() {
		super(ID);
	}
	
	@Override
	public void doStart() throws Exception {
		super.doStart();
		startCDOServer();
	}

	private void startCDOServer() throws Exception {
		OM.LOG.info("CDO Server starting");		
		File configFile = OMPlatform.INSTANCE.getConfigFile("cdo-server.xml");
		if (configFile != null && configFile.exists()) {
			startRepositories(configFile);
			startAcceptors(configFile);
		} else {
			OM.LOG.warn("CDO server config file not found "+configFile.getAbsolutePath());
		}
		OM.LOG.info("CDO Server started");
	}

	private void startRepositories(File configFile) throws Exception {
		RepositoryConfigurator configurator = new RepositoryConfigurator(IPluginContainer.INSTANCE);
		repositories = configurator.configure(configFile);
		if (repositories == null || repositories.length == 0) {
			OM.LOG.warn("No repositories configured");
		}
	}

	private void startAcceptors(File configFile) throws Exception {
		TransportConfigurator configurator = new TransportConfigurator(IPluginContainer.INSTANCE);
		acceptors = configurator.configure(configFile);
		if (acceptors == null || acceptors.length == 0) {
			OM.LOG.warn("No acceptors configured");
		}
	}
	
	@Override
	public void doStop() throws Exception {
		stopCDOServer();
		super.doStop();
	}

	private void stopCDOServer() {
		OM.LOG.info("CDO server stopping");
		stopAcceptors();
		stopRepositories();
		OM.LOG.info("CDO server stopped");
	}

	private void stopAcceptors() {
		if (acceptors != null) {
			for (IAcceptor each : acceptors) {
				each.close();
			}
		}
	}

	private void stopRepositories() {
		if (repositories != null) {
			for (IRepository each : repositories) {
				LifecycleUtil.deactivate(each);
			}
		}
	}
	
}
