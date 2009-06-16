package org.eclipse.stem.ui.reports.views;

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
