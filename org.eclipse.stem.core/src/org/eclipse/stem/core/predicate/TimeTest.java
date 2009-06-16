// TimeTest.java
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


/**
 * A <code>TimeTest</code> is a <code>Test</code> that returns a boolean value
 * depending upon the comparison of the time values passed to
 * {@link #evaluate(org.eclipse.stem.core.model.STEMTime, long, org.eclipse.stem.core.model.Decorator)}
 * and a reference time value.
 * 
 * @model abstract="true"
 */
public interface TimeTest extends Test {
	// Nothing	
} // TimeTest