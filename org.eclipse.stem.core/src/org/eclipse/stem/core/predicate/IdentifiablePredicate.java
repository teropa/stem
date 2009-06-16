// IdentifiablePredicate.java
package org.eclipse.stem.core.predicate;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.common.Identifiable;

/**
 * A <code>IdentifiablePredicate</code> represents a testable condition that is
 * Identifiable.
 * 
 * @model abstract="true"
 */
public interface IdentifiablePredicate extends Identifiable, Predicate {
	
	/**
	 * This is the segment of the type {@link URI} that prefixes all other segments in a
	 * predicate {@link URI}s.
	 */
	String URI_TYPE_PREDICATE_SEGMENT = "predicate";
} // IdentifiablePredicate