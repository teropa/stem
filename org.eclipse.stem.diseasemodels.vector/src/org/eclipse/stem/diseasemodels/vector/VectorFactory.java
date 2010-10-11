/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.vector;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.diseasemodels.vector.VectorPackage
 * @generated
 */
public interface VectorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VectorFactory eINSTANCE = org.eclipse.stem.diseasemodels.vector.impl.VectorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Macdonald Ross Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Macdonald Ross Disease Model</em>'.
	 * @generated
	 */
	MacdonaldRossDiseaseModel createMacdonaldRossDiseaseModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VectorPackage getVectorPackage();

} //VectorFactory
