// IntegrationLabel
package org.eclipse.stem.core.graph;




/**
 * The interface is implemented by any label value that is able to switch between 
 * current and next value optionally using an integration technique, for instance
 * the Runge Kutta numerical ODE solver.  
 */
public interface IntegrationLabelValue extends SimpleDataExchangeLabelValue {

	/**
	 * Set the value from another value
	 * 
	 * @param v The value
	 * @return The changed value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	IntegrationLabelValue set(IntegrationLabelValue v);

	
	/**
	 * Add
	 * 
	 * @param value Value to add
	 * @return IntegrationLabelValue Changed value
	 */

	public IntegrationLabelValue add(IntegrationLabelValue value);

	/**
	 * Sub
	 * 
	 * @param value Value to sub
	 * @return IntegrationLabelValue Changed value
	*/
	public IntegrationLabelValue sub(IntegrationLabelValue value);

	
	/**
	 * Scale
	 * 
	 * @param value Value to scale
	 * @return IntegrationLabelValue Changed value
	*/
	public IntegrationLabelValue scale(double scaleFactor);
	
	/**
	 * Add
	 * 
	 * @param value Value to add
	 * @return IntegrationLabelValue Changed value
	*/
	public IntegrationLabelValue add(double addition);

	/**
	 * Abs
	 * 
	 * @return IntegrationLabelValue Changed value
	*/
	public IntegrationLabelValue abs();
	
	/**
	 * adjustDelta. Adjust this delta value according to the input
	 * 
	 * @param value reference value
	 * @return boolean True if changed
	*/
	public boolean adjustDelta(IntegrationLabelValue value);
	
	/**
	 * Set the incidence
	 * @param i The incidence
	 */
	public void setIncidence(double i);
	
	/**
	 * Return the incidence
	 * 
	 * @return double Incidence
	 */
	public double getIncidence();
	
	/**
	 * divide. Divide the input with this value
	 * 
	 * @param value The denominator
	 * @return The changed value
	*/
	public IntegrationLabelValue divide(IntegrationLabelValue value);
	
	/**
	 * max. Return the maximum if the label values
	 * 
	 * @return double The maximum value
	*/
	public double max();
	

}
