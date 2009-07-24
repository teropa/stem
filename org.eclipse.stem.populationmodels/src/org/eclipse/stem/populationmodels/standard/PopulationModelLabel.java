/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard;

import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Population Model Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationLabel <em>Population Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationModelLabel()
 * @model
 * @generated
 */
public interface PopulationModelLabel extends DynamicNodeLabel {

	/**
	 * Returns the value of the '<em><b>Population Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population Label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population Label</em>' reference.
	 * @see #setPopulationLabel(PopulationLabel)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationModelLabel_PopulationLabel()
	 * @model
	 * @generated
	 */
	PopulationLabel getPopulationLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationLabel <em>Population Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Label</em>' reference.
	 * @see #getPopulationLabel()
	 * @generated
	 */
	void setPopulationLabel(PopulationLabel value);
} // PopulationModelLabel
