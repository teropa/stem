// PropertyStringProvider.java
package org.eclipse.stem.ui.adapters.propertystrings;

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

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * This interface is implemented by classes that provide NLS'd strings for
 * {@link org.eclipse.stem.core.common.Identifiable} properties.
 */
public interface PropertyStringProvider {

	/**
	 * This is the suffix appended to the name of a property to create the key
	 * to extract the tool tip text from the message property file.
	 */
	String TT_SUFFIX = "TT"; //$NON-NLS-1$

	/**
	 * This is the suffix appended to the name of a property to create the key
	 * to extract the text from the message property file that represents the
	 * units of a property.
	 */
	String UNIT_SUFFIX = "UNIT"; //$NON-NLS-1$

	/**
	 * @param descriptor
	 * @return the NLS'd name of the property to display to the user
	 */
	String getPropertyName(IItemPropertyDescriptor descriptor);

	/**
	 * @param descriptor
	 * @return the NLS'd tool tip text that describes the property
	 */
	String getPropertyToolTip(IItemPropertyDescriptor descriptor);

	/**
	 * @param descriptor
	 * @return the NLS'd text that represents the units of the property
	 */
	String getPropertyUnits(IItemPropertyDescriptor descriptor);
} // PropertyStringProvider
