/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.experimental;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.diseasemodels.experimental.ExperimentalPackage
 * @generated
 */
public interface ExperimentalFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExperimentalFactory eINSTANCE = org.eclipse.stem.diseasemodels.experimental.impl.ExperimentalFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Percolation Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Percolation Disease Model</em>'.
	 * @generated
	 */
	PercolationDiseaseModel createPercolationDiseaseModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExperimentalPackage getExperimentalPackage();

} //ExperimentalFactory
