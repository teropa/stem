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

import org.eclipse.stem.jobs.execution.IExecutableManagerListener;

/**
 * This interface is implemented by classes that listen for
 * {@link BatchManagerEvent}s.
 * 
 * @see BatchManager
 * @see Batch
 */
public interface IBatchManagerListener extends IExecutableManagerListener {

	/**
	 * @param event
	 */
	void batchesChanged(BatchManagerEvent event);

} // IBatchManagerListener