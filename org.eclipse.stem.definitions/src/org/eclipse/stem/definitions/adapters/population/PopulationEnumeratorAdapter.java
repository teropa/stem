package org.eclipse.stem.definitions.adapters.population;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
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
