// EstimatorFactory.java
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
 * This class is a factory for creating {@link AnalysisControl} instances.
 */
public class LyapunovFactory implements AnalysisControlFactory {

	/**
	 * public INSTANCE for this Factory
	 */
	public static LyapunovFactory INSTANCE = new LyapunovFactory();

	/**
	 * Constants 
	 */
	public static final String ANALYSIS_TYPE = "Lyapunov";
	

	/**
	 * 
	 * @param parent
	 * @param dirName
	 * @return new LyapunovControl()
	 */
	public AnalysisControl create(final Composite parent, String dirName) {
				
		return new LyapunovControl(parent);
	}
	

	/**
	 * @return type of analysis
	 * 
	 */
	public String getControlType() {
		return ANALYSIS_TYPE;
	}

} // EstimatorFactory
