// ExecutablePropertyTester.java
package org.eclipse.stem.ui.handlers;

import org.eclipse.core.expressions.IPropertyTester;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.stem.jobs.execution.IExecutable;

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
 * This class is a {@link PropertyTester} for {@link IExecutable}s in "core
 * expressions".
 */
public class ExecutablePropertyTester extends PropertyTester implements
		IPropertyTester {

	private static final String PROPERTY_IS_RUNNING = "running";
	private static final String PROPERTY_IS_STOPPABLE = "stoppable";

	/**
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object,
	 *      java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	public boolean test(final Object receiver, final String property,
			@SuppressWarnings("unused")
			final Object[] args, @SuppressWarnings("unused")
			final Object expectedValue) {
		
		boolean retValue = false;
		if (receiver instanceof IExecutable) {
			// Yes
			// Runnable?
			if (PROPERTY_IS_RUNNING.equals(property)) {
				// Yes
				retValue = ((IExecutable) receiver).isRunning();
			} // if runnable
			// Stoppable?
			else if (PROPERTY_IS_STOPPABLE.equals(property)) {
				// Yes
				retValue = ((IExecutable) receiver).isStoppable();
			} // if 
		} // if

		return retValue;
	} // test

} // ExecutablePropertyTester