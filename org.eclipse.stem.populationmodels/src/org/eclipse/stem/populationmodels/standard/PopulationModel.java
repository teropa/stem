/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard;

import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.model.Decorator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Population Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.PopulationModel#getPopulationIdentifier <em>Population Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.PopulationModel#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationModel()
 * @model abstract="true"
 * @generated
 */
public interface PopulationModel extends NodeDecorator {
	
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * population model type URI.
	 */
	String URI_TYPE_POPULATIONMODEL_SEGMENT = "population";

	
	/**
	 * Returns the value of the '<em><b>Population Identifier</b></em>' attribute.
	 * The default value is <code>"human"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population Identifier</em>' attribute.
	 * @see #setPopulationIdentifier(String)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationModel_PopulationIdentifier()
	 * @model default="human"
	 * @generated
	 */
	String getPopulationIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.PopulationModel#getPopulationIdentifier <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Identifier</em>' attribute.
	 * @see #getPopulationIdentifier()
	 * @generated
	 */
	void setPopulationIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"HumanPopulationModel"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationModel_Name()
	 * @model default="HumanPopulationModel"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.PopulationModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // PopulationModel
