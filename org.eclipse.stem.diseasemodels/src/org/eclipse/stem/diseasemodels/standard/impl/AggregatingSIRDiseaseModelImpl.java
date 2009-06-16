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
import org.eclipse.stem.diseasemodels.standard.AggregatingSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregating SIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AggregatingSIRDiseaseModelImpl extends AggregatingSIDiseaseModelImpl implements AggregatingSIRDiseaseModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatingSIRDiseaseModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.AGGREGATING_SIR_DISEASE_MODEL;
	}

	@Override
	public DiseaseModelLabel createDiseaseModelLabel() {
		return StandardFactory.eINSTANCE.createSIRLabel();
	}

	@Override
	public DiseaseModelLabelValue createDiseaseModelLabelValue() {
		return StandardFactory.eINSTANCE.createSIRLabelValue();
	}

	@Override
	protected void updateFromChildLabel(SILabel parentLabel, SILabel childLabel) {
		super.updateFromChildLabel(parentLabel, childLabel);
		
		final SIRLabel sirParentLabel = (SIRLabel)parentLabel;
		final SIRLabel sirChildLabel = (SIRLabel)childLabel;
		
		final double nextR = sirParentLabel.getNextR();
		sirParentLabel.setNextR(nextR + sirChildLabel.getNextR());
	} // updateFromChildLabel
	
} // AggregatingSIRDiseaseModelImpl