// IBatchManagerListener.java
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

import org.eclipse.stem.jobs.execution.IExecutableManagerListenerSync;

/**
 * This interface is implemented by classes that listen for
 * {@link BatchManagerEvent}s. The thread running the {@link BatchManager} will
 * wait until the {@link #batchesChangedSync(BatchManagerEvent)} method returns
 * before it continues execution.
 * 
 * @see IBatchManagerListener
 */
public interface IBatchManagerListenerSync extends
		IExecutableManagerListenerSync {

	/**
	 * @param event
	 */
	void batchesChangedSync(BatchManagerEvent event);

} // IBatchManagerListenerSync