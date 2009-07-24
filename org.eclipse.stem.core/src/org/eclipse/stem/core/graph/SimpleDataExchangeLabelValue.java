// IntegrationLabel
package org.eclipse.stem.core.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface is implemented by labels that needs to exchange information with other
 * parties. 
 */
public interface SimpleDataExchangeLabelValue  extends EObject {

	/**
	 * getAdditions
	 * 
	 * @return double Additions
	 */
	
	public double getAdditions();
	
	/**
	 * getSubstractions
	 * 
	 * @return double Substractions
	 */
	
	public double getSubstractions();
	
}
