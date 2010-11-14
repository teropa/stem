package org.eclipse.stem.cdoserver;

import java.io.File;

import org.eclipse.emf.cdo.internal.server.RepositoryConfigurator;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.net4j.TransportConfigurator;
import org.eclipse.net4j.acceptor.IAcceptor;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.OMPlatform;

public class CDOServer {

	private IRepository[] repositories;
	private IAcceptor[] acceptors;
	
	public void start() throws Exception {
		System.out.println("COO Server starting");
		File configFile = OMPlatform.INSTANCE.getConfigFile("cdo-server.xml");
		if (configFile != null && configFile.exists()) {
			startRepositories(configFile);
			startAcceptors(configFile);
			System.out.println("CDO Server started");
		} else {
			System.out.println("No CDO config file found: "+configFile.getAbsolutePath());
		}
	}

	private void startRepositories(File configFile) throws Exception {
		RepositoryConfigurator configurator = new RepositoryConfigurator(IPluginContainer.INSTANCE);
		repositories = configurator.configure(configFile);
	}

	private void startAcceptors(File configFile) throws Exception {
		TransportConfigurator configurator = new TransportConfigurator(IPluginContainer.INSTANCE);
		acceptors = configurator.configure(configFile);
	}

	public void stop() {
		stopAcceptors();
		stopRepositories();
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
