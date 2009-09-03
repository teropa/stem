package org.eclipse.stem.diseasemodels.globalinfluenzamodel;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
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
 * @see org.eclipse.stem.diseasemodels.globalinfluenzamodel.GlobalinfluenzamodelPackage
 * @generated
 */
public interface GlobalinfluenzamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GlobalinfluenzamodelFactory eINSTANCE = org.eclipse.stem.diseasemodels.globalinfluenzamodel.impl.GlobalinfluenzamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Global Influenza Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Influenza Model</em>'.
	 * @generated
	 */
	GlobalInfluenzaModel createGlobalInfluenzaModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GlobalinfluenzamodelPackage getGlobalinfluenzamodelPackage();

} //GlobalinfluenzamodelFactory
