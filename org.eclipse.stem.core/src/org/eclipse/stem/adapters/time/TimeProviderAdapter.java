// TimeProviderAdapter.java
package org.eclipse.stem.adapters.time;

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

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;

/**
 * This class is a {@link TimeProvider}.
 */
public class TimeProviderAdapter extends AdapterImpl implements TimeProvider {

	/**
	 * @see org.eclipse.stem.adapters.time.TimeProvider#getTime()
	 */
	public STEMTime getTime() {
		return ModelFactory.eINSTANCE.createSTEMTime();
	}

} // TimeProviderAdapter