package org.eclipse.stem.definitions.transport;

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

import org.eclipse.stem.core.graph.NodeLabel;

/**
 * Label for a packet transport. Right now only provides a capacity.
 * 
 * @author jlessler
 * 
 * @model
 */
public interface PacketTransportLabel extends NodeLabel {

	/**
	 * Make the current value stuff have to be PacketTransportLabelValues
	 * @return TODO
	 */
	PacketTransportLabelValue getCurrentValue();

	/**
	 * @param val
	 */
	void setCurrentValue(PacketTransportLabelValue val);
}
