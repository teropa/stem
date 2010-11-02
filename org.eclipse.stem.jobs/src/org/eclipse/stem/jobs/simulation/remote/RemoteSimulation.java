package org.eclipse.stem.jobs.simulation.remote;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.CDOInvalidationNotification;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.stem.jobs.execution.Executable;
import org.eclipse.stem.jobs.execution.remote.IRemoteExecutable;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListener;
import org.eclipse.stem.jobs.simulation.ISimulationListenerSync;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationState;
import org.eclipse.stem.server.server.Simulations;

public class RemoteSimulation extends Executable implements ISimulation, IRemoteExecutable {

	private final Scenario scenario;
	private final CDOSession session;
	private final List<ISimulationListener> listeners = new CopyOnWriteArrayList<ISimulationListener>();
	private final List<ISimulationListenerSync> listenersSync = new CopyOnWriteArrayList<ISimulationListenerSync>();

	private SimulationState simulationState;

	public RemoteSimulation(Scenario scenario, String title, int sequenceNumber, CDOSession session) {
		super(title == null ? "" : title, sequenceNumber);
		this.scenario = scenario;
		this.session = session;
		this.simulationState = SimulationState.PAUSED;
	}

	public SimulationState getSimulationState() {
		return simulationState;
	}

	private void setSimulationState(SimulationState state) {
		this.simulationState = state;
		fireSimulationChanged(simulationState);
	}

	public boolean isRunning() {
		return !simulationState.equals(SimulationState.PAUSED);
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void run() {
		schedule();
	}

	protected IStatus run(final IProgressMonitor monitor) {
		CDOTransaction tx = session.openTransaction();
		tx.options().setInvalidationNotificationEnabled(true);
		
		IStatus retValue = Status.OK_STATUS;
		try {
			scenario.initialize();
			
			setSimulationState(SimulationState.RUNNING);
			monitor.beginTask(scenario.produceTitle(), TOTAL_WORK);
			final Sequencer sequencer = scenario.getSequencer();
			monitor.worked((int)sequencer.getWorkComplete());

			final AtomicBoolean done = new AtomicBoolean(false);
			final RemoteSimulation self = this;
			sequencer.eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (msg instanceof CDOInvalidationNotification) {
						SimulationEvent event = new SimulationEvent(self, SimulationState.RUNNING, scenario.getProgress());
						self.fireSimulationChangedEvent(event);
						monitor.worked(sequencer.getWorkIncrement());

						if (sequencer.isTimeToStop()) { 
							setSimulationState(SimulationState.COMPLETED_SEQUENCE);
							done.set(true);
						}
					}
				}
			});

			submitScenario(tx);

			while (!done.get()) {
				Thread.sleep(1000);
			}
			
			monitor.done();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.close();
		}
		return retValue;
	}

	public void stop() {
		throw new UnsupportedOperationException("Cannot stop remote simulations right now");
	}

	public void pause() {
		throw new UnsupportedOperationException("Cannot pause remote simulations right now");
	}

	public void step() {
		throw new UnsupportedOperationException("Cannot step remote simulations yet");
	}

	public void reset() {
		throw new UnsupportedOperationException("Cannot reset remote simulations yet");
	}

	public boolean isStoppable() {
		return false;
	}


	public void addSimulationListener(ISimulationListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void removeSimulationListener(ISimulationListener listener) {
		listeners.remove(listener);
	}

	public void addSimulationListenerSync(ISimulationListenerSync listener) {
		if (!listenersSync.contains(listener)) {
			listenersSync.add(listener);
		}
	}

	public void removeSimulationListenerSync(ISimulationListenerSync listener) {
		listenersSync.remove(listener);
	}

	private void fireSimulationChanged(final SimulationState simulationState) {
		final SimulationEvent event = new SimulationEvent(this, simulationState);
		fireSimulationChangedEvent(event);
	}

	private void fireSimulationChangedEvent(final SimulationEvent event) {
		for (final ISimulationListenerSync listener : listenersSync) {
			listener.simulationChangedSync(event);
		}
		for (final ISimulationListener listener : listeners) {
			listener.simulationChanged(event);
		}
	}

	private void submitScenario(CDOTransaction tx) throws CommitException {
		Resource r = tx.getResource("/stem/simulations");
		Simulations sims = (Simulations)r.getContents().get(0);
		sims.cdoWriteLock().lock();
		sims.getScenarios().clear();
		sims.getScenarios().add(scenario);

		Resource content = tx.getOrCreateResource("/stem/simulation1");
		content.getContents().clear();
		content.getContents().add(scenario);
		content.getContents().addAll(getNonContainedNonPlatformObjects(scenario, new HashSet<EObject>()));
		
		tx.commit();
	}
	
	private List<EObject> getNonContainedNonPlatformObjects(EObject object, Set<EObject> visited) {
		final List<EObject> result = new ArrayList<EObject>();
		if (visited.contains(object)) {
			return result;
		} else {
			visited.add(object);
		}
		for (EObject e : object.eCrossReferences()) {
			Resource resource = e.eResource();
			if (resource == null || !isPlatformResource(resource)) {
				if (e.eContainer() == null) {
					result.add(e);
				}
				result.addAll(getNonContainedNonPlatformObjects(e, visited));
			}
		}
		return result;
	}

	private boolean isPlatformResource(Resource resource) {
		if (resource.getURI() == null) return false;
		if (resource.getURI().isPlatformPlugin()) return true;
		if (resource.getURI().isPlatform() && !resource.getURI().isPlatformResource()) return true;
		return false;
	}

}