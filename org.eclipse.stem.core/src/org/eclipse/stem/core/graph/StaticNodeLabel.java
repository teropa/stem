// StaticNodeLabel.java
package org.eclipse.stem.core.graph;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.lang.reflect.Modifier;

import org.eclipse.stem.core.modifier.Modifiable;
import org.eclipse.stem.core.trigger.Trigger;

/**
 * A <code>StaticNodeLabel</code> is a {@link NodeLabel} that only has a single
 * "current" {@link LabelValue}. It is typically used for {@link Node}
 * attributes that rarely change in a <code>Simulation</code>. An example would
 * be the area of a geographic location.
 * <p>
 * By implementing the {@link Modifiable} interface, a
 * <code>StaticNodeLabel</code> is identified as being something that can be
 * altered by a {@link Modifier} activated by a {@link Trigger}.
 * 
 * @model abstract="true"
 */
public interface StaticNodeLabel extends NodeLabel, StaticLabel {
	// Nothing
} // StaticNodeLabel
