/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.graphgenerators;


public interface Constants {
	/**
	 * This is the extension point id for the "graph generator" extension point. 
	 * {@value}
	 */
	String ID_GRAPH_GENERATOR_EXTENSION_POINT = org.eclipse.stem.core.Constants.ID_ROOT
	+ ".graphgenerators.graphgenerator";

	String GRAPH_GENERATOR_ELEMENT = "classdef";
}
