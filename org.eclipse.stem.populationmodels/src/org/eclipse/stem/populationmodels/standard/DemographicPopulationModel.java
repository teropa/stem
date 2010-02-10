package org.eclipse.stem.populationmodels.standard;

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
 

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Demographic Population Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.DemographicPopulationModel#getPopulationGroups <em>Population Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getDemographicPopulationModel()
 * @model
 * @generated
 */
public interface DemographicPopulationModel extends StandardPopulationModel {
	/**
	 * Returns the value of the '<em><b>Population Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.stem.populationmodels.standard.PopulationGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population Groups</em>' containment reference list.
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getDemographicPopulationModel_PopulationGroups()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PopulationGroup> getPopulationGroups();

} // DemographicPopulationModel
