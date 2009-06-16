// BatchEvent.java
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

import java.util.EventObject;

/**
 * This class represents the occurrence of an event in a {@link Batch}.
 */
public class BatchEvent extends EventObject {

	/**
	 * Default serial id
	 */
	private static final long serialVersionUID = 1L;
	private BatchState batchState;

	/**
	 * @param batchState
	 *            the new state of a {@link IBatch}.
	 * @param batch
	 *            the source of the event.
	 */
	public BatchEvent(final IBatch batch, final BatchState batchState) {
		super(batch);
		this.batchState = batchState;
	}

	/**
	 * @return the batchState
	 */
	public final BatchState getBatchState() {
		return batchState;
	}

	/**
	 * @return the {@link IBatch} that is the source of the event.
	 */
	public final IBatch getBatch() {
		return (IBatch) getSource();
	}

	/**
	 * @see java.util.EventObject#toString()
	 */
	@Override
	public String toString() {
		return batchState.toString();
	}

} // BatchEvent
