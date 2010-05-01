package org.eclipse.stem.diseasemodels.multipopulation;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

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
	 * Returns a new object of class '<em>Multi Population SIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Population SIR Disease Model</em>'.
	 * @generated
	 */
	MultiPopulationSIRDiseaseModel createMultiPopulationSIRDiseaseModel();

	/**
	 * Returns a new object of class '<em>Multi Population SEIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Population SEIR Disease Model</em>'.
	 * @generated
	 */
	MultiPopulationSEIRDiseaseModel createMultiPopulationSEIRDiseaseModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MultipopulationPackage getMultipopulationPackage();

} //MultipopulationFactory
