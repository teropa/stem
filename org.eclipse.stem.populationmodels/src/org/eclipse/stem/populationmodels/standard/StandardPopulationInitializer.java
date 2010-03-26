/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Population Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#getIndividuals <em>Individuals</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#isUseDensity <em>Use Density</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#getPopulationIdentifier <em>Population Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationInitializer()
 * @model
 * @generated
 */
public interface StandardPopulationInitializer extends PopulationInitializer {
	/**
	 * Returns the value of the '<em><b>Individuals</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Individuals</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Individuals</em>' attribute.
	 * @see #setIndividuals(double)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationInitializer_Individuals()
	 * @model default="1"
	 * @generated
	 */
	double getIndividuals();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#getIndividuals <em>Individuals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Individuals</em>' attribute.
	 * @see #getIndividuals()
	 * @generated
	 */
	void setIndividuals(double value);

	/**
	 * Returns the value of the '<em><b>Use Density</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Density</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Density</em>' attribute.
	 * @see #setUseDensity(boolean)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationInitializer_UseDensity()
	 * @model default="false"
	 * @generated
	 */
	boolean isUseDensity();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#isUseDensity <em>Use Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Density</em>' attribute.
	 * @see #isUseDensity()
	 * @generated
	 */
	void setUseDensity(boolean value);

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
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationInitializer_PopulationIdentifier()
	 * @model default="human"
	 * @generated
	 */
	String getPopulationIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer#getPopulationIdentifier <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Identifier</em>' attribute.
	 * @see #getPopulationIdentifier()
	 * @generated
	 */
	void setPopulationIdentifier(String value);

} // StandardPopulationInitializer
