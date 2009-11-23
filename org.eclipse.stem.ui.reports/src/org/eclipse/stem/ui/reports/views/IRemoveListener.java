package org.eclipse.stem.ui.reports.views;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.common.Identifiable;

/**
 * When the remove button is pressed by the user
 * @author James
 *
 */
public interface IRemoveListener {
	/**
	 * 
	 * @param identifiable
	 */
	void identifiableRemoved(Identifiable identifiable) ;
	

}
