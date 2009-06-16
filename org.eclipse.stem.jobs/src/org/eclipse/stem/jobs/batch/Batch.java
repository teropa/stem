// Batch.java
package org.eclipse.stem.jobs.batch;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.stem.core.experiment.Experiment;
import org.eclipse.stem.core.modifier.Modifier;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.jobs.Activator;
import org.eclipse.stem.jobs.execution.Executable;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListener;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationState;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This class is the runtime handle for the execution of an {@link Experiment}.
 * Each {@link Experiment} has a {@link Scenario} and a collection of
 * {@link Modifier}s. The {@link Scenario} forms the basis for the creation of a
 * set of derived {@link Scenario}s that are created by the application of the
 * {@link Experiment}'s {@link Modifier}s. Each of the derived {@link Scenario}s
 * is executed as a {@link Simulation}. A {@link Batch} maintains the link
 * between an {@link Experiment} and the resulting {@link Simulation}s.
 * <p>
 * Each {@link Batch} has a unique sequence number and its {@link Simulation}s
 * can be run sequentially or in parallel and in the "foreground" (i.e., appear
 * in the GUI) or in the "background" (i.e., not appear in the GUI).
 */
public class Batch extends Executable implements IBatch, ISimulationListener {

	/**
	 * The current state of the {@link Batch}
	 */
	private BatchState batchState = BatchState.PAUSED;

	/**
	 * The {@link Experiment} that is being executed by the {@link Batch}.
	 */
	private Experiment experiment = null;

	/**
	 * The Set of {@link ISimulation}s that are actively running as part of the
	 * {@link Batch};
	 */
	private final List<ISimulation> activeSimulations = new ArrayList<ISimulation>();

	// TODO these need to be initialized from preferences
	// If this is ever false, you need to re-implement run(IProgressMonitor) to
	// handle parallel Simulations
	private boolean runningSimulationsSequentially = true;

	private boolean runningInBackground = false;

	/**
	 * This flag indicates whether the {@link Batch} should continue executing
	 * or not. If it becomes <code>false</code>, then the {@link Batch} will
	 * kill all of its {@link ISimulation}s.
	 */
	private boolean keepRunning = true;

	/**
	 * The collection of {@link IBatchListener} waiting to be told about
	 * {@link BatchEvent}'s
	 */
	private final List<IBatchListener> listeners = new CopyOnWriteArrayList<IBatchListener>();

	/**
	 * The collection of {@link IBatchListenerSync} waiting to be told about
	 * {@link BatchEvent}'s
	 */
	private final List<IBatchListenerSync> listenersSync = new CopyOnWriteArrayList<IBatchListenerSync>();

	private IProgressMonitor monitor;

	private boolean cancelRequested;

	/**
	 * Constructor
	 * 
	 * @param experiment
	 *            the {@link Experiment} that forms the basis of this
	 *            {@link Batch}
	 * 
	 * @param sequenceNumber
	 *            the unique sequence number of this {@link Batch}. This is
	 *            typically provided by the {@link BatchManager}.
	 */
	Batch(final Experiment experiment, final int sequenceNumber) {
		super("Batch: " + sequenceNumber, sequenceNumber);
		this.experiment = experiment;
	} // Batch

	/**
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		IStatus retValue = Status.OK_STATUS;
		this.monitor = monitor;
		try {
			setBatchState(BatchState.RUNNING);
			monitor.beginTask("Batch: " + getSequenceNumber(), getTotalWork());

			// Initialize the scenario that is part of the experiment
			getExperiment().initScenario();
			
			// Iterate through each of the Simulations to run and begin their
			// execution.
			for (ISimulation simulation = getNextSimulationToRun(); keepRunning
					&& simulation != null; simulation = getNextSimulationToRun()) {
				setBatchState(BatchState.RUNNING);

				startSimulationRunning(simulation);

				// Are we running the simulations sequentially?
				if (isRunningSimulationsSequentially()) {
					// Yes
					// Then we only start one here and then handle the rest in
					// simulationChanged()
					break;
				} // if
				// Canceled?
				if (monitor.isCanceled()) {
					// Yes
					cancelRequested = true;
					stopAllSimulations();
					retValue = Status.CANCEL_STATUS;
				}
			} // for each Simulation

			// If we're running the Simulations in parallel then we need to
			// pause here and wait for them all to end.
		} catch (final Exception e) {
			handleException(e);
			keepRunning = false;

			// Are there any Simulations running?
			if (activeSimulations.size() > 0) {
				// Yes
				// Stop'em
				cancelRequested = true;
				stopAllSimulations();
			} // if
			monitor.done();
			setBatchState(BatchState.STOPPED);
		} // catch Exception

		return retValue;
	} // run

	/**
	 * Do the processing required to handle a {@link RuntimeException}
	 * 
	 * @param e
	 *            the {@link Exception} that was caught in the {@link #run()}
	 *            method.
	 */
	private void handleException(final Exception e) {

		// We can get a Runtime exception if the user tries to run an Experiment
		// that doesn't have a Scenario. Or, we can get one because of some real
		// internal error.

		String tempErrorMessage = "";
		boolean logIt = false;

		// Could we be missing a Scenario or something in the Scenario?
		if (e instanceof NullPointerException) {
			// Yes
			// Does the Experiment have a Scenario?
			if (experiment.getScenario() == null) {
				// No
				tempErrorMessage = MessageFormat.format(Messages
						.getString("Exp.MissingScenario"),
						new Object[] { getName() });
			} // if missing a sequencer
			else {
				// Yes
				// Does the Scenario have a Sequencer?
				if (experiment.getScenario().getSequencer() == null) {
					// No
					tempErrorMessage = MessageFormat.format(Messages
							.getString("Exp.MissingSeq"),
							new Object[] { getName() });
				} // if missing a sequencer
				// How about a model?
				else if (experiment.getScenario().getModel() == null) {
					// No
					tempErrorMessage = MessageFormat.format(Messages
							.getString("Exp.MissingModel"),
							new Object[] { getName() });
				} // if missing model
				else {
					// Yes
					// Just some other NPE
					logIt = true;
					tempErrorMessage = MessageFormat.format(Messages
							.getString("Exp.IErr"), new Object[] { getName() });
				} // else
			} // else has a Scenario

		} // if NullPointerException
		else {
			// No
			logIt = true;
			tempErrorMessage = MessageFormat.format(Messages
					.getString("Exp.IErr"), new Object[] { getName() });
		} // else

		final String errorMessage = tempErrorMessage;

		// Log it?
		if (logIt) {
			// Yes
			Activator.logError(errorMessage, e);
		} // if

		try {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					final IWorkbenchWindow window = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow();
					final IStatus warning = new Status(IStatus.WARNING,
							Activator.PLUGIN_ID, 1, errorMessage, null);
					ErrorDialog.openError(window.getShell(), null, null,
							warning);
				} // run
			});
		} catch (final Error ncdfe) {
			// If we get this exception, it is because we're not running in
			// eclipse.
		} // catch

	} // handleException

	/**
	 * Iterate through all of the active {@link Simulation}s and stop/cancel
	 * them.
	 */
	private void stopAllSimulations() {
		for (final ISimulation simulation : activeSimulations) {
			simulation.stop();
			simulation.cancel();
		} // for each ISimulation
	} // stopAllSimulations

	/**
	 * @param simulation
	 *            a {@link Simulation} that is to be started.
	 */
	private void startSimulationRunning(final ISimulation simulation) {
		activeSimulations.add(simulation);
		simulation.addSimulationListener(this);
		simulation.run();
	} // startSimulationRunning

	/**
	 * @return the value to be passed to the {@link Batch}'s
	 *         {@link IProgressMonitor} when beginning the task. This value
	 *         could be {@link IProgressMonitor#UNKNOWN} if the number of
	 *         {@link ISimulation}s to be run is not known before hand.
	 *         Otherwise, it should be the number of {@link ISimulation}'s that
	 *         will be returned by {@link #getNextSimulationToRun()}.
	 */
	protected int getTotalWork() {
		return 1;
	}

	/**
	 * @return the next {@link ISimulation} to run as part of the {@link Batch},
	 *         or <code>null</code>, if there are no more.
	 */
	protected ISimulation getNextSimulationToRun() {
		ISimulation retValue = null;
		// Is the experiment complete?
		if (!experiment.isComplete()) {
			// No
			retValue = SimulationManager.getManager().createSimulation(
					experiment.updateScenario(), null);
		}

		return retValue;
	} // getNextSimulationToRun

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#run()
	 */
	public void run() {
		schedule();
	} // run

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#pause()
	 */
	public void pause() {
		// TODO implement Batch.pause()
		throw new UnsupportedOperationException();
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#step()
	 */
	public void step() {
		// TODO implement Batch.step()
		throw new UnsupportedOperationException();
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#reset()
	 */
	public void reset() {
		// TODO implement Batch.reset()
		throw new UnsupportedOperationException();
	}

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#stop()
	 */
	public void stop() {
		keepRunning = false;
	} // stop

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#isRunning()
	 */
	public boolean isRunning() {
		return !batchState.equals(BatchState.PAUSED);
	}

	/**
	 * @see org.eclipse.stem.jobs.simulation.ISimulationListener#simulationChanged(org.eclipse.stem.jobs.simulation.SimulationEvent)
	 */
	public void simulationChanged(final SimulationEvent event) {

		// For the case when we're running {@link Simulation}s sequentially,
		// this method contains most of the control logic for the execution of
		// the {@link Batch}. Basically, as each of the {@link Batch}'s
		// {@link Simulation}s changes state, this method is called. In it we
		// check to see if the {@link Batch} has been canceled, or has been
		// requested to stop.

		// Did the Simulation complete?
		if (event.getSimulationState() == SimulationState.COMPLETED_SEQUENCE) {
			// Yes

			monitor.worked(1);
			event.getSimulation().stop();
//			event.getSimulation().step();

			// Are we waiting for Simulations to end?
			if (keepRunning) {
				// No
				// Should we try to start another one?
				if (!monitor.isCanceled() && runningSimulationsSequentially) {
					// Yes
					final ISimulation simulation = getNextSimulationToRun();
					// Is there another simulation to run?
					if (simulation != null) {
						// Yes
						startSimulationRunning(simulation);
					} // if
					// Have all the Simulations ended?
					else if (activeSimulations.size() == 0) {
						// Yes
						monitor.done();
						setBatchState(BatchState.STOPPED);
					} // else all the Simulations ended
				} // if
			} // if waiting for Simulations to end
			else {
				// Yes
				// Have all the Simulations ended?
				if (activeSimulations.size() == 0) {
					// Yes
					monitor.done();
					setBatchState(BatchState.STOPPED);
				} // if
			} // else waiting for Simulations to end
		} // if a simulation completed cycle
		else if (event.getSimulationState() == SimulationState.STOPPED) {
			activeSimulations.remove(event.getSimulation());
			event.getSimulation().removeSimulationListener(this);
			if (activeSimulations.size() == 0) {
				// Yes
				monitor.done();
				setBatchState(BatchState.STOPPED);
			} // else all the Simulations ended
		} // if stopped

		// Should we cancel all the Simulations?
		if (!cancelRequested && monitor.isCanceled()) {
			// Yes
			keepRunning = false;
			cancelRequested = true;
			stopAllSimulations();
		} // if canceled

		// Have we been asked to stop?
		if (!keepRunning && !cancelRequested) {
			// Yes
			cancelRequested = true;
			stopAllSimulations();
		} // if
	}// simulationChanged

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#getExperiment()
	 */
	public Experiment getExperiment() {
		return experiment;
	} // getExperiment

	/**
	 * @return the current state of the {@link Batch}
	 */
	public final BatchState getBatchState() {
		return batchState;
	}

	/**
	 * @param batchState
	 *            the new state of the {@link Batch}
	 */
	private void setBatchState(final BatchState batchState) {
		// Is the state changing?
		if (getBatchState() != batchState) {
			// Yes
			this.batchState = batchState;
			fireBatchChanged(batchState);
		} // if

	} // setBatchState

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#isRunningSimulationsSequentially()
	 */
	public final boolean isRunningSimulationsSequentially() {
		return runningSimulationsSequentially;
	}

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#setRunningSimulationsSequentially(boolean)
	 */
	public final void setRunningSimulationsSequentially(
			final boolean runningSimulationsSequentially) {
		this.runningSimulationsSequentially = runningSimulationsSequentially;
	}

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#isRunningInBackground()
	 */
	public final boolean isRunningInBackground() {
		return runningInBackground;
	}

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#setRunningInBackground(boolean)
	 */
	public final void setRunningInBackground(final boolean runningInBackground) {
		this.runningInBackground = runningInBackground;
	}

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#addBatchListener(org.eclipse.stem.jobs.batch.IBatchListener)
	 */
	final public void addBatchListener(final IBatchListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#removeBatchListener(org.eclipse.stem.jobs.batch.IBatchListener)
	 */
	final public void removeBatchListener(final IBatchListener listener) {
		listeners.remove(listener);
	}

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#addBatchListenerSync(org.eclipse.stem.jobs.batch.IBatchListenerSync)
	 */
	public void addBatchListenerSync(IBatchListenerSync listener) {
		if (!listenersSync.contains(listener)) {
			listenersSync.add(listener);
		}
	} // addBatchListenerSync

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatch#removeBatchListenerSync(org.eclipse.stem.jobs.batch.IBatchListenerSync)
	 */
	public void removeBatchListenerSync(IBatchListenerSync listener) {
		listenersSync.remove(listener);
	} // removeBatchListenerSync

	/**
	 * Tell the listeners about the change in the {@link Batch}'s state
	 * 
	 * @param batchState
	 *            the new state of the {@link Batch}
	 */
	private void fireBatchChanged(final BatchState batchState) {
		final BatchEvent event = new BatchEvent(this, batchState);
		for (final IBatchListener listener : listeners) {
			listener.batchChanged(event);
		} // for

		for (final IBatchListenerSync listener : listenersSync) {
			listener.batchChangedSync(event);
		} // for
	} // fireBatchChanged

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("[");
		sb.append(getSequenceNumber());
		sb.append("] ");
		sb.append(isRunningSimulationsSequentially() ? "S/" : "P/");
		sb.append(isRunningInBackground() ? "B " : "F ");
		sb.append(getBatchState().toString());
		return sb.toString();
	} // toString

} // Batch
