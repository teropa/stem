// RealTimeSequencer.java
package org.eclipse.stem.core.sequencer;

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

/**
 * A <code>RealTimeSequencer</code> is a <code>SequentialSequencer</code>
 * that always as a starting time equal to the current time. It also sleeps for
 * the time increment of the sequence.
 * 
 * @model
 */
public interface RealTimeSequencer extends SequentialSequencer {

} // RealTimeSequencer
