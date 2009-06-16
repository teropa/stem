/**
 * <copyright>
 * </copyright>
 *
 * $Id: PipeTransportEdgeLabelValue.java,v 1.2 2009/04/03 17:49:18 sedlund Exp $
 */
package org.eclipse.stem.definitions.transport;

import org.eclipse.stem.core.graph.LabelValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipe Transport Edge Label Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue#getMaxFlow <em>Max Flow</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue#getTimePeriod <em>Time Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.definitions.transport.TransportPackage#getPipeTransportEdgeLabelValue()
 * @model
 * @generated
 */
public interface PipeTransportEdgeLabelValue extends LabelValue {
	/**
	 * Returns the value of the '<em><b>Max Flow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Flow</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Flow</em>' attribute.
	 * @see #setMaxFlow(double)
	 * @see org.eclipse.stem.definitions.transport.TransportPackage#getPipeTransportEdgeLabelValue_MaxFlow()
	 * @model
	 * @generated
	 */
	double getMaxFlow();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue#getMaxFlow <em>Max Flow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Flow</em>' attribute.
	 * @see #getMaxFlow()
	 * @generated
	 */
	void setMaxFlow(double value);

	/**
	 * Returns the value of the '<em><b>Time Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Period</em>' attribute.
	 * @see #setTimePeriod(long)
	 * @see org.eclipse.stem.definitions.transport.TransportPackage#getPipeTransportEdgeLabelValue_TimePeriod()
	 * @model
	 * @generated
	 */
	long getTimePeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue#getTimePeriod <em>Time Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Period</em>' attribute.
	 * @see #getTimePeriod()
	 * @generated
	 */
	void setTimePeriod(long value);

} // PipeTransportEdgeLabelValue
