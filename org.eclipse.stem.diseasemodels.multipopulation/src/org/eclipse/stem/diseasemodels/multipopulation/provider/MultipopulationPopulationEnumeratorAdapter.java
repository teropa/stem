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
