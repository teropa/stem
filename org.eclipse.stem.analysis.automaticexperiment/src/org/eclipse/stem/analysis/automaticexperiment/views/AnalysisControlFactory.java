// AnalysisControlFactory.java
package org.eclipse.stem.analysis.automaticexperiment.views;

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

import org.eclipse.swt.widgets.Composite;

/**
 * This interface is implemented by factories that create instances of
 * {@link AnalysisControl}.
 */
public interface AnalysisControlFactory {

	/**
	 * 
	 * @param parent 
	 * @return the AnalysisControl
	 */
	AnalysisControl create(final Composite parent);

	/**
	 * @return TODO JFK
	 */
	public String getControlType();

} // AnalysisControlFactory
