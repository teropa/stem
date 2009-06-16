// CSVLoggerFactory.java
package org.eclipse.stem.util.loggers.views;

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

import java.util.List;

import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.swt.widgets.Composite;

/**
 * This class is a factory for creating {@link LoggerControl} instances.
 */
public class CSVLoggerFactory implements LoggerControlFactory {

	/**
	 * public INSTANCE for this Factory
	 */
	public static CSVLoggerFactory INSTANCE = new CSVLoggerFactory();

	/**
	 * Constants 
	 */
	public static final String LOGGER_TYPE = "CSVLogger";
	
	/**
	 * Empty constructor
	 */
	private CSVLoggerFactory() {
		/*
		 * empty constructor
		 */
	}
	
	/**
	 * @param parent
	 * @param dirName
	 * @param simulation
	 * @param dm 
	 * @return new DataHistoryLogger()
	 */
	public LoggerControl create(final Composite parent, String dirName, ISimulation simulation, DiseaseModel dm) {
		NewCSVLogWriter  newCSVWriter = new NewCSVLogWriter(dirName, simulation, dm);
		
		LoggerControl ctrl = new DataHistoryLogger(parent, newCSVWriter, simulation, dm);
		
		return ctrl;
	}
	
	/**
	 * @return TODO JFK
	 * 
	 */
	public String getControlType() {
		return LOGGER_TYPE;
	}

} // CSVLoggerFactory
