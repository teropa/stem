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
package org.eclipse.stem.definitions.adapters.population;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * The adapter is implemented by any class that needs to enumerate multiple population identifiers,
 * such as multipopulation disease models and demographic population models
 * @author edlund
 *
 */
public class PopulationEnumeratorAdapter extends AdapterImpl implements PopulationEnumerator {

	public String[] getPopulationIdentifiers() {
		// TODO Auto-generated method stub
		return null;
	}

}
