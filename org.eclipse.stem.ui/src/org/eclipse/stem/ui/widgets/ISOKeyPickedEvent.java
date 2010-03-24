// ISOKeyPickedEvent.java
package org.eclipse.stem.ui.widgets;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
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
 * This class represents the event of an ISOkey being selected using an
 * {@link ISOKeyPicker}.
 */
public class ISOKeyPickedEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	private String isoKey;

	/**
	 * @param source
	 * @param isoKey
	 */
	public ISOKeyPickedEvent(Object source, String isoKey) {
		super(source);
		this.isoKey = isoKey;
	}

	/**
	 * @return the isoKey
	 */
	public final String getIsoKey() {
		return isoKey;
	}

} // ISOKeyPickedEvent
