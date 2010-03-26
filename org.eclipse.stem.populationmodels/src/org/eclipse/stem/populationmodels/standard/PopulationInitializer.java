/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard;

import org.eclipse.stem.core.model.NodeDecorator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Population Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.PopulationInitializer#getTargetISOKey <em>Target ISO Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationInitializer()
 * @model
 * @generated
 */
public interface PopulationInitializer extends NodeDecorator {
	/**
	 * Returns the value of the '<em><b>Target ISO Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target ISO Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target ISO Key</em>' attribute.
	 * @see #setTargetISOKey(String)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationInitializer_TargetISOKey()
	 * @model
	 * @generated
	 */
	String getTargetISOKey();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.PopulationInitializer#getTargetISOKey <em>Target ISO Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target ISO Key</em>' attribute.
	 * @see #getTargetISOKey()
	 * @generated
	 */
	void setTargetISOKey(String value);

} // PopulationInitializer
