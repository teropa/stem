// ExecutableAdapter.java
package org.eclipse.stem.jobs.adapters.executable.emf;

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

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.stem.jobs.Activator;
import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.jobs.execution.remote.IRemoteExecutable;

/**
 * This class is extended by classes that adapt {@link Object}s to
 * {@link IRemoteExecutable}s.
 */
abstract public class RemoteExecutableAdapter extends AdapterImpl implements
		IRemoteExecutable {

	/**
	 * @see org.eclipse.stem.jobs.execution.IRemoteExecutable#getSequenceNumber()
	 */
	public int getSequenceNumber() {
		return ((IRemoteExecutable) getTarget()).getSequenceNumber();
	} // getSequenceNumber

	/**
	 * @see org.eclipse.stem.jobs.execution.IRemoteExecutable#getName()
	 */
	public String getName() {
		return ((IRemoteExecutable) getTarget()).getName();
	} // getName

	/**
	 * @see org.eclipse.stem.jobs.execution.IRemoteExecutable#getNameWithSequenceNumber()
	 */
	public String getNameWithSequenceNumber() {
		return ((IRemoteExecutable) getTarget()).getNameWithSequenceNumber();
	} // getNameWithSequenceNumber

	/**
	 * @see org.eclipse.stem.jobs.execution.IRemoteExecutable#getCreationTime()
	 */
	public Date getCreationTime() {
		return ((IRemoteExecutable) getTarget()).getCreationTime();
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IRemoteExecutable#getUniqueIDString()
	 */
	public String getUniqueIDString() {
		return ((IRemoteExecutable) getTarget()).getUniqueIDString();
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IRemoteExecutable#run()
	 */
	public void run() {
		logUnimplementedError("run");
	}

	/**
	 * @see org.eclipse.stem.jobs.adapters.executable.emf.RemoteExecutableAdapter#pause()
	 */
	public void pause() {
		logUnimplementedError("pause");
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IRemoteExecutable#step()
	 */
	public void step() {
		logUnimplementedError("step");
	}

	/**
	 * @see org.eclipse.stem.jobs.adapters.executable.emf.RemoteExecutableAdapter#reset()
	 */
	public void reset() {
		logUnimplementedError("reset");
	}

	/**
	 * @see org.eclipse.stem.jobs.adapters.executable.emf.RemoteExecutableAdapter#stop()
	 */
	public void stop() {
		logUnimplementedError("stop");
	}

	private void logUnimplementedError(final String action) {
		Activator
				.logError("Internal error: " + action + " unimplemented", null);
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IRemoteExecutable#isRunning()
	 */
	public boolean isRunning() {
		return false;
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IRemoteExecutable#isStoppable()
	 */
	public boolean isStoppable() {
		return false;
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(final Object type) {
		return type == IRemoteExecutable.class;
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(
			@SuppressWarnings("unused") final Notification notification) {
		// Nothing
	}

} // RemoteExecutableAdapter
