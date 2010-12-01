// BatchManager.java
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
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.experiment.Experiment;
import org.eclipse.stem.jobs.Activator;
import org.eclipse.stem.jobs.execution.ExecutableManager;
import org.eclipse.swt.widgets.Display;

/**
 * This class implements a centralized manager for running {@link Experiment}s
 * in "batch mode". The idea of batch mode is that a {@link Scenario} referenced
 * by an {@link Experiment} can be used as a base from which a collection of
 * other {@link Scenario}s can be derived. These derived {@link Scenario}s
 * differ from the base in some (usually) minor variation of one or more of the
 * base's configuration parameters.
 * <p>
 * The manager controls the creation of the derived {@link Scenario}s from
 * specifications provided by a user, and then, their subsequent execution as
 * {@link Simulation}s.
 * 
 * @see Batch
 * @see Experiment
 * @see Modifier
 */
public class BatchManager extends ExecutableManager implements IBatchListener {

	/**
	 * The singleton instance of the {@link BatchManager}.
	 */
	public static BatchManager INSTANCE = new BatchManager();

	/**
	 * This is the sequence number assigned to each successive {@link Batch}
	 * instance the manager creates.
	 */
	static private int sequenceNumber = 0;

	/**
	 * Constant empty array of {@link Batch}s.
	 */
	public static final IBatch[] NONE = new Batch[] {};

	/**
	 * The collection of {@link IBatchManagerListener}'s waiting to be told
	 * about {@link BatchManagerEvent}'s
	 */
	private final List<IBatchManagerListener> listeners = new CopyOnWriteArrayList<IBatchManagerListener>();

	/**
	 * The collection of {@link IBatchManagerListenerSync}'s waiting to be told
	 * about {@link BatchManagerEvent}'s
	 */
	private final List<IBatchManagerListenerSync> listenersSync = new CopyOnWriteArrayList<IBatchManagerListenerSync>();

	/**
	 * The {@link Set} of {@link Batch}s being managed.
	 */
	private final List<IBatch> batches = new ArrayList<IBatch>();

	/**
	 * Private constructor so that instances of the {@link BatchManager} cannot
	 * be created externally.
	 */
	private BatchManager() {
		// nothing
	} // BatchManager

	/**
	 * @return the next {@link Batch} sequence number and increment the value.
	 */
	synchronized private static final int getAndIncrementBatchSequenceNumber() {
		return sequenceNumber++;
	} // getAndIncrementBatchSequenceNumber

	/**
	 * @return the {@link List} of {@link Batch}s being managed.
	 */
	public List<IBatch> getActiveBatches() {
		return batches;
	} // getActiveBatches

	/**
	 * Add a new {@link Batch} to the manager's collection and notify any
	 * listeners of the addition.
	 */
	private void addActiveBatch(final IBatch batch) {
		batches.add(batch);
		batch.addBatchListener(this);
		fireBatchManagerChanged(new IBatch[] { batch }, NONE);
	} // addActiveBatch

	/**
	 * Remove an {@link IBatch} from the collection of active {@link IBatch}s.
	 * 
	 * @param simulation
	 *            the {@link IBatch} to remove
	 */
	private final void removeActiveBatch(final IBatch batch) {
		batches.remove(batch);
		// We're no longer a listener
		batch.removeBatchListener(this);
		fireBatchManagerChanged(NONE, new IBatch[] { batch });
	} // removeActiveBatch

	/**
	 * Create a {@link IBatch} that's ready to run
	 * 
	 * @param experiment
	 *            the {@link Experiment} that is the basis for the {@link Batch}
	 * @return an {@link IBatch} from the {@link Experiment}
	 */
	public IBatch createBatch(final Experiment experiment) {
		final Batch batch = new Batch(experiment,
				getAndIncrementBatchSequenceNumber());
		batch.setPriority(Job.LONG);
		final IBatch retValue = new BatchAdapter(batch);
		addActiveBatch(retValue);
		return retValue;
	} // createBatch

	/**
	 * @param configurationElement
	 * @param monitor
	 * @return
	 */
	protected IBatch createBatch(
			final IConfigurationElement configurationElement,
			final IProgressMonitor monitor) {
		IBatch retValue = null;

		final String experimentURIString = configurationElement
				.getAttribute(DublinCore.IDENTIFIER);
		try {
			retValue = createBatch(URI.createURI(experimentURIString), monitor);
		} catch (final Exception e) {
			Activator
					.logError(
							MessageFormat
									.format(
											Messages
													.getString("BatchMgr.Deserialization_Error"), experimentURIString), e); //$NON-NLS-1$
			retValue = null;
		}
		return retValue;
	} // createBatch

	/**
	 * @param experimentURI
	 *            the {@link URI} of a serialized {@link Experiment}
	 * @param monitor
	 *            a {@link ProgressMonitor}
	 * @return an {@link IBatch} deserialized from the source identified by the
	 *         experimentURI, or <code>null</code> if there was a problem.
	 */
	private IBatch createBatch(final URI experimentURI,
			final IProgressMonitor monitor) {
		IBatch retValue = null;
		try {
			final ResourceSet resourceSet = new ResourceSetImpl();
			final Resource resource = resourceSet.getResource(experimentURI,
					true);
			monitor.subTask("Reading Experiment from file");
			resource.load(null);
			monitor.subTask("Creating Batch from Experiment");
			retValue = createBatch((Experiment) resource.getContents().get(0));
		} catch (final Exception e) {
			Activator
					.logError(
							MessageFormat
									.format(
											Messages
													.getString("BatchMgr.Deserialization_Error"), experimentURI.toString()), e); //$NON-NLS-1$
			retValue = null;
		}
		return retValue;
	} // createBatch

	/**
	 * Create a {@link IBatch} from an {@link Experiment} instance and then
	 * start it running.
	 * 
	 * @param experiment
	 *            the {@link Experiment} to be run
	 */
	public void createAndRunBatch(final Experiment experiment) {
		new Job(Messages.getString("BatchMgr.StartBatch")) {
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				try {
					final IBatch batch = createBatch(experiment);
					monitor.subTask(Messages.getString("BatchMgr.Run"));
					batch.run();
				} catch (final Exception e) {
					// The error was logged in createBatch
					monitor.done();
				} // catch Exception
				return Status.OK_STATUS;
			} // run
		}.schedule();
	} // createAndRunBatch

	/**
	 * @param configurationElement
	 *            a {@link IConfigurationElement} that specifies the details and
	 *            serialized location of an {@link Experiment} to simulate.
	 */
	public void createAndRunBatch(
			final IConfigurationElement configurationElement) {
		new Job(Messages.getString("BatchMgr.StartBatch")) { //$NON-NLS-1$
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				monitor.beginTask(Messages.getString("BatchMgr.CrtSim"),
						IProgressMonitor.UNKNOWN);
				try {
					final IBatch batch = createBatch(configurationElement,
							monitor);
					monitor.subTask(Messages.getString("BatchMgr.Run"));
					batch.run();
				} // try
				catch (final NullPointerException e) {
					// The error was logged in createBatch
					monitor.done();
				}
				monitor.done();
				return Status.OK_STATUS;
			} // run
		}.schedule();
	} // createAndRunBatch

	/**
	 * @return the current batch sequence number
	 */
	public final int getSequenceNumber() {
		return sequenceNumber;
	} // getSequenceNumber

	/**
	 * @param listener
	 *            a listener wanting to be told about changes to the manager.
	 */
	public void addBatchManagerListener(final IBatchManagerListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	} // addBatchManagerListener

	/**
	 * @param listenerSync
	 *            a listener wanting to be told about changes to the manager.
	 */
	public void addBatchManagerListenerSync(
			final IBatchManagerListenerSync listenerSync) {
		if (!listenersSync.contains(listenerSync)) {
			listenersSync.add(listenerSync);
		}
	} // addBatchManagerListenerSync

	/**
	 * @param listener
	 *            a listener NOT wanting to be told about changes to the
	 *            manager.
	 */
	public void removeListener(final IBatchManagerListener listener) {
		listeners.remove(listener);
	} // removeListener

	/**
	 * @param listenerSync
	 *            a listener NOT wanting to be told about changes to the
	 *            manager.
	 */
	public void removeListenerSync(final IBatchManagerListenerSync listenerSync) {
		listenersSync.remove(listenerSync);
	} // removeListenerSync

	/**
	 * Tell the listeners about the change.
	 * 
	 * @param batchesAdded
	 *            the {@link Batch}s added
	 * @param batchesRemoved
	 *            the {@link Batch}s removed
	 */
	private void fireBatchManagerChanged(final IBatch[] batchesAdded,
			final IBatch[] batchesRemoved) {
		final BatchManagerEvent event = new BatchManagerEvent(this,
				batchesAdded, batchesRemoved);

		// Inform the asynchronous listeners
		for (final IBatchManagerListener listener : listeners) {
			try {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						listener.batchesChanged(event);
					}
				});
			} catch (final Error ncdfe) {
				// If we get this exception, it is because we're not running in
				// eclipse. Just fire the event.
				listener.batchesChanged(event);
			} // catch
		} // for

		// Now inform the synchronized listeners
		for (final IBatchManagerListenerSync listenerSync : listenersSync) {
			try {
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						listenerSync.batchesChangedSync(event);
					}
				});
			} catch (final Error ncdfe) {
				// If we get this exception, it is because we're not running in
				// eclipse. Just fire the event.
				listenerSync.batchesChangedSync(event);
			} // catch
		} // for

	} // fireBatchManagerChanged

	/**
	 * @see org.eclipse.stem.jobs.batch.IBatchListener#batchChanged(org.eclipse.stem.jobs.batch.BatchEvent)
	 */
	public void batchChanged(final BatchEvent event) {
		// Has a batch stopped?
		if (event.getBatchState().equals(BatchState.STOPPED)) {
			// Yes
			removeActiveBatch(event.getBatch());
		}
	} // batchChanged

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for (final IBatch batch : batches) {
			sb.append(batch.toString());
			sb.append("\n");
		} // for each Batch
		return sb.toString();
	} // toString

	/**
	 * Discard the current {@link BatchManager} and replace it with a newly
	 * allocated one. This method is primarily intended to be used by JUnit test
	 * cases that need a {@link BatchManager} with a known initial state.
	 */
	public static void resetBatchManager() {
		INSTANCE = new BatchManager();
	} // resetBatchManager

	/**
	 * This class adapts a {@link Batch} instance that runs as an asynchronous
	 * Eclipse {@link Job} to be an {@link IBatch} instance. The adapter manages
	 * thread safety issues so that the UI thread can access the {@link IBatch}
	 * instance directly.
	 */
	protected static class BatchAdapter implements IBatch, IBatchListener,
			IBatchListenerSync {

		/**
		 * The collection of {@link IBatchListener}'s waiting to be told about
		 * {@link BatchEvent}s.
		 */
		private final List<IBatchListener> listeners = new CopyOnWriteArrayList<IBatchListener>();

		/**
		 * The collection of {@link IBatchListenerSync}'s waiting to be told
		 * about {@link BatchEvent}s.
		 */
		private final List<IBatchListenerSync> listenersSync = new CopyOnWriteArrayList<IBatchListenerSync>();

		/**
		 * The {@link Batch} instance to adapt. This will be an instance of
		 * {@link Batch} which is also an eclipse {@link Job} and runs
		 * asynchronously from the UI thread of eclipse. This adapter registers
		 * as a listener of adapted {@link Batch} and safely passes
		 * {@link BatchEvent}'s on to listeners in the UI or other threads.
		 */
		private final IBatch batch;

		/**
		 * Constructor
		 * 
		 * @param batch
		 *            the {@link Batch} to adapt
		 */
		protected BatchAdapter(final IBatch batch) {
			this.batch = batch;
			batch.addBatchListener(this);
			batch.addBatchListenerSync(this);
		} // BatchAdapter

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#getName()
		 */
		public String getName() {
			return batch.getName();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#getNameWithSequenceNumber()
		 */
		public String getNameWithSequenceNumber() {
			return batch.getNameWithSequenceNumber();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#getExperiment()
		 */
		public Experiment getExperiment() {
			return batch.getExperiment();
		}

		/**
		 * @see org.eclipse.stem.jobs.execution.IExecutable#getCreationTime()
		 */
		public Date getCreationTime() {
			return batch.getCreationTime();
		}

		/**
		 * @see org.eclipse.stem.jobs.execution.IExecutable#getUniqueIDString()
		 */
		public String getUniqueIDString() {
			return batch.getUniqueIDString();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#getBatchState()
		 */
		public BatchState getBatchState() {
			return batch.getBatchState();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#getSequenceNumber()
		 */
		public int getSequenceNumber() {
			return batch.getSequenceNumber();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#isRunningInBackground()
		 */
		public boolean isRunningInBackground() {
			return batch.isRunningInBackground();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#isRunningSimulationsSequentially()
		 */
		public boolean isRunningSimulationsSequentially() {
			return batch.isRunningSimulationsSequentially();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#setRunningInBackground(boolean)
		 */
		public void setRunningInBackground(final boolean runningInBackground) {
			batch.setRunningInBackground(runningInBackground);
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#setRunningSimulationsSequentially(boolean)
		 */
		public void setRunningSimulationsSequentially(
				final boolean runningSimulationsSequentially) {
			batch
					.setRunningSimulationsSequentially(runningSimulationsSequentially);
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#run()
		 */
		public void run() {
			batch.run();
		}

		/**
		 * @see org.eclipse.stem.jobs.execution.IExecutable#pause()
		 */
		public void pause() {
			batch.pause();
		}

		/**
		 * @see org.eclipse.stem.jobs.execution.IExecutable#step()
		 */
		public void step() {
			batch.step();
		}

		/**
		 * @see org.eclipse.stem.jobs.execution.IExecutable#reset()
		 */
		public void reset() {
			batch.reset();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#stop()
		 */
		public void stop() {
			batch.stop();
		}

		/**
		 * @see org.eclipse.stem.jobs.execution.IExecutable#isRunning()
		 */
		public boolean isRunning() {
			return batch.isRunning();
		}

		/**
		 * @see org.eclipse.stem.jobs.execution.IExecutable#isStoppable()
		 */
		public boolean isStoppable() {
			return batch.isStoppable();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#cancel()
		 */
		public boolean cancel() {
			return batch.cancel();
		}

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#addBatchListener(org.eclipse.stem.jobs.batch.IBatchListener)
		 */
		public void addBatchListener(final IBatchListener listener) {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		} // addBatchListener

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#removeBatchListener(org.eclipse.stem.jobs.batch.IBatchListener)
		 */
		public void removeBatchListener(final IBatchListener listener) {
			listeners.remove(listener);
		} // removeBatchListener

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#addBatchListenerSync(org.eclipse.stem.jobs.batch.IBatchListenerSync)
		 */
		public void addBatchListenerSync(final IBatchListenerSync listener) {
			if (!listenersSync.contains(listener)) {
				listenersSync.add(listener);
			}
		} // addBatchListenerSync

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatch#removeBatchListenerSync(org.eclipse.stem.jobs.batch.IBatchListenerSync)
		 */
		public void removeBatchListenerSync(final IBatchListenerSync listener) {
			listenersSync.remove(listener);
		} // removeBatchListenerSync

		/**
		 * Tell the listeners about the change in the {@link Batch}'s state
		 * 
		 * @param batchState
		 *            the new state of the {@link Batch}
		 */
		protected void fireBatchChanged(final BatchState batchState) {
			final BatchEvent event = new BatchEvent(this, batchState);
			for (final IBatchListener listener : listeners) {
				listener.batchChanged(event);
			} // for
		} // fireBatchManagerChanged

		/**
		 * Tell the listeners about the change in the {@link Batch}'s state
		 * 
		 * @param batchState
		 *            the new state of the {@link Batch}
		 */
		protected void fireBatchChangedSync(final BatchState batchState) {
			final BatchEvent event = new BatchEvent(this, batchState);
			for (final IBatchListenerSync listener : listenersSync) {
				listener.batchChangedSync(event);
			} // for
		} // fireBatchChangedSync

		/**
		 * This is where the adapted {@link Batch} tells us of its state changes
		 * and we need to adapt them to the UI thread.
		 * 
		 * @see org.eclipse.stem.jobs.batch.IBatchListener#batchChanged(org.eclipse.stem.jobs.batch.BatchEvent)
		 */
		public void batchChanged(final BatchEvent event) {
			try {
				if (!Display.getDefault().isDisposed()) {
					// Yes
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							fireBatchChanged(event.getBatchState());
						}
					});
				} // if
			} // try
			catch (final NullPointerException e) {
				// Nothing to do, shutting down...
			} // catch NullPointerException
			catch (final Error ncdfe) {
				// If we get this exception, it is because we're not running in
				// eclipse. Just fire the event.
				fireBatchChanged(event.getBatchState());
			} // catch

		} // batchChanged

		/**
		 * @see org.eclipse.stem.jobs.batch.IBatchListenerSync#batchChangedSync(org.eclipse.stem.jobs.batch.BatchEvent)
		 */
		public void batchChangedSync(final BatchEvent event) {
			try {
				if (!Display.getDefault().isDisposed()) {
					// Yes
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							fireBatchChangedSync(event.getBatchState());
						}
					});
				} // if
			} // try
			catch (final NullPointerException e) {
				// Nothing to do, shutting down...
			} // catch NullPointerException
			catch (final Error ncdfe) {
				// If we get this exception, it is because we're not running in
				// eclipse. Just fire the event.
				fireBatchChanged(event.getBatchState());
			} // catch

		} // batchChangedSync

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return batch.toString();
		} // toString
	} // BatchAdapter
} // BatchManager
