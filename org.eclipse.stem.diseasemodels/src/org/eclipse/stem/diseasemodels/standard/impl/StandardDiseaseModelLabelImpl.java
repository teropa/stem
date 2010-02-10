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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Disease Model Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class StandardDiseaseModelLabelImpl extends
		DiseaseModelLabelImpl implements StandardDiseaseModelLabel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardDiseaseModelLabelImpl() {
		super();
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.DynamicLabelImpl#reset()
	 */
	@Override
	public void reset() {
		// The call to super.reset will reset the label value of this label
		// which will zero out all of the disease state values.
		super.reset();
		getTempValue().reset();
		getDeltaValue().reset();
		getErrorScale().reset();
		getProbeValue().reset();
		// Is there a population instance associated with this instance?
		if (getPopulationLabel() != null) {
			// Yes
			// Ok, set the susceptible population to the count of the number of
			// population members
			final StandardDiseaseModelLabelValue sValue = (StandardDiseaseModelLabelValue)getCurrentValue();

			sValue.setS(getPopulationLabel().getCurrentPopulationValue()
					.getCount());
		} // if

	} // reset

	/**
	 * Return the identifier for the label, i.e. the population identifier
	 * 
	 * @return String The identifier
	 */
	
	public String getIdentifier() {
		return this.getPopulationModelLabel().getPopulationIdentifier();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_DISEASE_MODEL_LABEL;
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getS()
	 */
	public double getS() {
		return (((StandardDiseaseModelLabelValue)getCurrentValue())).getS();
	} // getS

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#setS(double)
	 */
	public void setS(double s) {
		(((StandardDiseaseModelLabelValue)getCurrentValue())).setS(s);
	} // setS

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getNextS()
	 */
	public double getNextS() {
		return (((StandardDiseaseModelLabelValue)getNextValue())).getS();
	} // getNextS

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#setNextS(double)
	 */
	public void setNextS(double s) {
		(((StandardDiseaseModelLabelValue)getNextValue())).setS(s);
	} // setNextS

} // StandardDiseaseModelLabelImpl
