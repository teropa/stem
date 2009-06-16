// ProcessorFactory.java
package org.eclipse.stem.util.analysis.views;

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
 * This class is a factory for creating {@link ProcessorControl} instances.
 */
public class ProcessorFactory implements AnalysisControlFactory {

	/**
	 * public INSTANCE for this Factory
	 */
	public static ProcessorFactory INSTANCE = new ProcessorFactory();

	/**
	 * Constants 
	 */
	public static final String ANALYSIS_TYPE = "Processor";
	
	/**
	 * 
	 * @param parent
	 * @param dirName
	 * @return new ProcessorControl()
	 */
	public AnalysisControl create(final Composite parent, String dirName) {
				
		return new ProcessorControl(parent);
	}

	/**
	 * @return type of analysis
	 * 
	 */
	public String getControlType() {
		return ANALYSIS_TYPE;
	}

} // ProcessorFactory
