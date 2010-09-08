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
package org.eclipse.stem.diseasemodels.multipopulation.provider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.core.common.StringValueList;
import org.eclipse.stem.definitions.adapters.population.PopulationEnumeratorAdapter;
import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel;

public class MultipopulationPopulationEnumeratorAdapter extends
		PopulationEnumeratorAdapter implements Adapter {

	@Override
	public String[] getPopulationIdentifiers() {
		MultiPopulationSIDiseaseModel dm = (MultiPopulationSIDiseaseModel)getTarget();
		
		StringValueList list = dm.getPopulationGroups();
		EList<org.eclipse.stem.core.common.StringValue> vals = list.getValues();
		String [] res = new String[vals.size()+1];
		res[0] = dm.getPopulationIdentifier();
		for(int i=1;i<vals.size()+1;++i)
			res[i] = vals.get(i-1).getValue();
		return res;
	}
}
