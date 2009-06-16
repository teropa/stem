// Predicate.java
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.trigger.Trigger;

/**
 * A <code>Predicate</code> represents a testable condition. Instances of
 * <code>Predicate</code> are referenced by {@link Trigger}s that use the value
 * returned by {@link #evaluate(STEMTime, long, Decorator)} to control the
 * execution of another {@link Decorator} called the {@link Trigger}'s "action".
 * <p>
 * This interface definition is also an "Annotated Java Interface" that defines
 * one class in a <a href="http://www.uml.org/">UML</a> "model". The UML class
 * diagram for the model is in the <code>documentation</code> folder of the
 * project. This file and the other interfaces in this Java package are
 * processed by the Eclipse Modeling Framework (aka EMF <a
 * href="http://org.eclipse/emf">http://org.eclipse/emf</a>). to automatically
 * generate an implementation of the model. EMF is documented in the book <a
 * href="http://www.awprofessional.com/bookstore/product.asp?isbn=0131425420&rl=1">Eclipse
 * Modeling Framework </a> by Budinsky, et al.
 * </p>
 * @see Trigger
 * @see Modifier
 * @model abstract="true"
 */
public interface Predicate extends EObject {

	/**
	 * Determine if a particular condition is <code>true</code> or
	 * <code>false</code>.
	 * 
	 * @param time
	 *            the time to be used when determining if the {@link Predicate}
	 *            is <code>true</code> or <code>false</code>.
	 * @param timePeriod
	 *            the number of milliseconds difference between the time and the
	 *            previous time value.
	 * @param action
	 *            a {@link Decorator}
	 * @return <code>true</code> if the {@link Predicate} is <code>true</code>,
	 *         <code>false</code> otherwise.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	boolean evaluate(final STEMTime time, final long timerPeriod,
			final Decorator action);

} // Predicate