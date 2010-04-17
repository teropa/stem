// Messages.java
package org.eclipse.stem.ui.graphgenerators.wizards;

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

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.stem.core.Constants;


/**
 * This class is the Resource Bundle for this package.
 */
public class Messages {
	private static final String BUNDLE_NAME = Constants.ID_ROOT
			+ ".ui.graphgenerators.wizards.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
		// empty
	}

	/**
	 * @param key
	 *            the key for the message
	 * @return the string that matches the key
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	} // getString
} // WizardMessages
