// ExampleDiseaseWizardMessages.java
package org.eclipse.stem.diseasemodels.multipopulation.presentation;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.stem.core.Constants;

/**
 * This class is the Resource Bundle for this package.
 */
public class MultipopulationDiseaseWizardMessages {
	private static final String BUNDLE_NAME = Constants.ID_ROOT
			+ ".diseasemodels.multipopulation.presentation.multipopulationdiseasemessages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	/**
	 * 
	 */
	public MultipopulationDiseaseWizardMessages() {
		// empty
	}

	/**
	 * @param key
	 *            the key for the message
	 * @return the string that matches the key
	 * @throws MissingResourceException if the key cannot be found
	 */
	public static String getString(final String key) throws MissingResourceException{
			return RESOURCE_BUNDLE.getString(key);
	} // getString
} // ExampleDiseaseWizardMessages
