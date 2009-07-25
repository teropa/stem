/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage
 * @generated
 */
public interface StandardFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StandardFactory eINSTANCE = org.eclipse.stem.populationmodels.standard.impl.StandardFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model</em>'.
	 * @generated
	 */
	StandardPopulationModel createStandardPopulationModel();

	/**
	 * Returns a new object of class '<em>Population Model Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model Label</em>'.
	 * @generated
	 */
	PopulationModelLabel createPopulationModelLabel();

	/**
	 * Returns a new object of class '<em>Population Model Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model Label</em>'.
	 * @generated
	 */
	StandardPopulationModelLabel createStandardPopulationModelLabel();

	/**
	 * Returns a new object of class '<em>Population Model Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model Label Value</em>'.
	 * @generated
	 */
	PopulationModelLabelValue createPopulationModelLabelValue();

	/**
	 * Returns a new object of class '<em>Population Model Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Model Label Value</em>'.
	 * @generated
	 */
	StandardPopulationModelLabelValue createStandardPopulationModelLabelValue();

	/**
	 * Returns a new object of class '<em>Stochastic Standard Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stochastic Standard Population Model</em>'.
	 * @generated
	 */
	StochasticStandardPopulationModel createStochasticStandardPopulationModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StandardPackage getStandardPackage();

} //StandardFactory
