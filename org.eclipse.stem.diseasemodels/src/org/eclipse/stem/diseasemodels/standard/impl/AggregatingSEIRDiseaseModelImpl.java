package org.eclipse.stem.diseasemodels.standard.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.diseasemodels.standard.AggregatingSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Aggregating SEIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AggregatingSEIRDiseaseModelImpl extends
		AggregatingSIRDiseaseModelImpl implements AggregatingSEIRDiseaseModel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatingSEIRDiseaseModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.AGGREGATING_SEIR_DISEASE_MODEL;
	}

	@Override
	public DiseaseModelLabel createDiseaseModelLabel() {
		return StandardFactory.eINSTANCE.createSEIRLabel();
	} // createDiseaseModelLabel

	@Override
	public DiseaseModelLabelValue createDiseaseModelLabelValue() {
		return StandardFactory.eINSTANCE.createSEIRLabelValue();
	} // createDiseaseModelLabelValue

	@Override
	protected void updateFromChildLabel(final SILabel parentLabel,
			final SILabel childLabel) {
		super.updateFromChildLabel(parentLabel, childLabel);

		final SEIRLabel seirParentLabel = (SEIRLabel) parentLabel;
		final SEIRLabel seirChildLabel = (SEIRLabel) childLabel;

		final double nextE = ((SEIRLabelValue)seirParentLabel.getNextValue()).getR();
		seirParentLabel.setNextE(nextE + seirChildLabel.getNextE());
	} // updateFromChildLabel

} // AggregatingSEIRDiseaseModelImpl
