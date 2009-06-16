package org.eclipse.stem.diseasemodels.standard.tests;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import junit.framework.TestCase;

import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Disease Model Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getCurrentDiseaseModelLabelValue() <em>Current Disease Model Label Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getNextDiseaseModelLabelValue() <em>Next Disease Model Label Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class DiseaseModelLabelTest extends TestCase {
	/**
	 * The fixture for this Disease Model Label test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DiseaseModelLabel fixture = null;

	/**
	 * Constructs a new Disease Model Label test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiseaseModelLabelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Disease Model Label test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(DiseaseModelLabel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Disease Model Label test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@SuppressWarnings("unused")
	private DiseaseModelLabel getFixture() {
		return fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getCurrentDiseaseModelLabelValue() <em>Current Disease Model Label Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getCurrentDiseaseModelLabelValue()
	 * @generated NOT
	 */
	public void testGetCurrentDiseaseModelLabelValue() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getNextDiseaseModelLabelValue() <em>Next Disease Model Label Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getNextDiseaseModelLabelValue()
	 * @generated NOT
	 */
	public void testGetNextDiseaseModelLabelValue() {
		assertTrue(true);
	}

	protected static void labelRegion(final DiseaseModelLabel diseaseLabel,
			final String populationIdentifier, final Region region) {
		diseaseLabel.setURIOfIdentifiableToBeLabeled(region.getURI());
		final PopulationLabel populationLabel = PopulationLabelImpl
				.getPopulationLabel(populationIdentifier, region);
		diseaseLabel.setPopulationLabel(populationLabel);
		region.getLabels().add(diseaseLabel);
	} // labelRegion

} // DiseaseModelLabelTest
