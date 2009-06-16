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

/**
 * This class is extended by classes that adapt {@link Object}s to
 * {@link IExecutable}s.
 */
abstract public class ExecutableAdapter extends AdapterImpl implements
		IExecutable {

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#getSequenceNumber()
	 */
	public int getSequenceNumber() {
		return ((IExecutable) getTarget()).getSequenceNumber();
	} // getSequenceNumber

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#getName()
	 */
	public String getName() {
		return ((IExecutable) getTarget()).getName();
	} // getName

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#getNameWithSequenceNumber()
	 */
	public String getNameWithSequenceNumber() {
		return ((IExecutable) getTarget()).getNameWithSequenceNumber();
	} // getNameWithSequenceNumber

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#getCreationTime()
	 */
	public Date getCreationTime() {
		return ((IExecutable) getTarget()).getCreationTime();
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#getUniqueIDString()
	 */
	public String getUniqueIDString() {
		return ((IExecutable) getTarget()).getUniqueIDString();
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#run()
	 */
	public void run() {
		logUnimplementedError("run");
	}

	/**
	 * @see org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapter#pause()
	 */
	public void pause() {
		logUnimplementedError("pause");
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#step()
	 */
	public void step() {
		logUnimplementedError("step");
	}

	/**
	 * @see org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapter#reset()
	 */
	public void reset() {
		logUnimplementedError("reset");
	}

	/**
	 * @see org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapter#stop()
	 */
	public void stop() {
		logUnimplementedError("stop");
	}

	private void logUnimplementedError(final String action) {
		Activator
				.logError("Internal error: " + action + " unimplemented", null);
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#isRunning()
	 */
	public boolean isRunning() {
		return false;
	}

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#isStoppable()
	 */
	public boolean isStoppable() {
		return false;
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(final Object type) {
		return type == IExecutable.class;
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(
			@SuppressWarnings("unused") final Notification notification) {
		// Nothing
	}

} // ExecutableAdapter
