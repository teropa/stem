// LoggerControlFactory.java
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

import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.swt.widgets.Composite;

/**
 * This interface is implemented by factories that create instances of
 * {@link LoggerControl}.
 */
public interface LoggerControlFactory {
	/**
	 * New method
	 * 
	 * @param parent
	 * @param dirName
	 * @param simulation
	 * @param diseaseModel 
	 * @return the LoggerControl
	 */
	
	LoggerControl create(final Composite parent, String dirName, ISimulation simulation, IntegrationDecorator diseaseModel);

	
	/**
	 * @return TODO JFK
	 */
	public String getControlType();

} // LoggerControlFactory
