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
package org.eclipse.stem.diseasemodels.vector.provider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.core.common.StringValueList;
import org.eclipse.stem.definitions.adapters.population.PopulationEnumeratorAdapter;
import org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel;

public class VectorPopulationEnumeratorAdapter extends
		PopulationEnumeratorAdapter implements Adapter {

	@Override
	public String[] getPopulationIdentifiers() {
		MacdonaldRossDiseaseModel dm = (MacdonaldRossDiseaseModel)getTarget();
		
		String [] res = new String[2];
		res[0] = dm.getPopulationIdentifier();
		res[1] = dm.getVectorPopulationIdentifier();
		return res;
	}
}
