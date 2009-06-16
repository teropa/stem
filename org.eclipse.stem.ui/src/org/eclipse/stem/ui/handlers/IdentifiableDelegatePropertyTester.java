// RunnableIdentifiablePropertyTester.java
package org.eclipse.stem.ui.handlers;

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

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.stem.core.experiment.Experiment;
import org.eclipse.stem.core.experiment.ExperimentPackage;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.ui.views.IdentifiableDelegate;

/**
 * This class is a {@link PropertyTester} for {@link IdentifiableDelegate}s in
 * "core expressions".
 */
public class IdentifiableDelegatePropertyTester extends PropertyTester {

	// This code isn't being used right now, but it is being retained because we
	// many want to test properties of IdentifiableDelegates in the future.
	private static final String PROPERTY_IS_RUNNABLE = "runnable";

	/**
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object,
	 * 	java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	public boolean test(final Object receiver, final String property,
			@SuppressWarnings("unused") final Object[] args,
			@SuppressWarnings("unused") final Object expectedValue) {
		boolean retValue = false;
		if (IdentifiableDelegate.class.equals(receiver)) {
			// Yes
			final IdentifiableDelegate id = (IdentifiableDelegate) receiver;

			// Runnable?
			if (PROPERTY_IS_RUNNABLE.equals(property)) {
				// Yes
				// Is the configuration element for a Scenario?
				retValue = isScenarioConfigurationElement(id.getFormat())
						|| isExperimentConfigurationElement(id.getFormat());
			} // if runnable
		} // if

		return retValue;
	} // test

	/**
	 * @param configElement
	 * 		a configuration element for a plug-in
	 * @return <code>true</code> if the configuration element is for a {@link
	 * 	Experiment}.
	 */
	private boolean isExperimentConfigurationElement(final String format) {
		return format != null && format.equals(ExperimentPackage.eNS_URI);
	} // isExperimentConfigurationElement

	/**
	 * @param configElement
	 * 		a configuration element for a plug-in
	 * @return <code>true</code> if the configuration element is for a {@link
	 * 	Scenario}.
	 */
	private boolean isScenarioConfigurationElement(final String format) {
		return format != null && format.equals(ScenarioPackage.eNS_URI);
	} // isScenarioConfigurationElement
} // IdentifiablePropertyTester
