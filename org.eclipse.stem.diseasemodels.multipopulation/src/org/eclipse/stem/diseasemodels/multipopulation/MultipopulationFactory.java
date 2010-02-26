/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.multipopulation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage
 * @generated
 */
public interface MultipopulationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MultipopulationFactory eINSTANCE = org.eclipse.stem.diseasemodels.multipopulation.impl.MultipopulationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Multi Population SI Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Population SI Disease Model</em>'.
	 * @generated
	 */
	MultiPopulationSIDiseaseModel createMultiPopulationSIDiseaseModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MultipopulationPackage getMultipopulationPackage();

} //MultipopulationFactory
