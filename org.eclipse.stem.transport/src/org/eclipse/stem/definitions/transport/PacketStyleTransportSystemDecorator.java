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

import org.eclipse.stem.core.model.EdgeDecorator;

/**
 * 
 * Decorator for packet style transport systems. Responsible for setting their 
 * edge connections, etc., based upon the current time. The meant that the
 * decorator will make sure the correct load/unload edges are zeroed out or
 * active at the correct times.
 *
 * 
 * @author jlessler
 *
 * @model
 */
public interface PacketStyleTransportSystemDecorator extends EdgeDecorator {
	// Empty	
}
