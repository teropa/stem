// SILabel.java
package org.eclipse.stem.diseasemodels.standard;

/*******************************************************************************
 * Copyright (c) 2006, 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * This interface defines a class in an EMF model for an SI disease model
 * dynamic label.
 * 
 * @see StandardDiseaseModel
 * @see StandardDiseaseModelLabel
 * @see StandardDiseaseModelLabelValue
 * @see SIR
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model
 */
public interface SILabel extends StandardDiseaseModelLabel {

	/**
	 * Returns the value of the '<em><b>Delta Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta Value</em>' reference.
	 * @see #setDeltaValue(SILabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSILabel_DeltaValue()
	 * @model
	 * @generated
	 */
	SILabelValue getDeltaValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getDeltaValue <em>Delta Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta Value</em>' reference.
	 * @see #getDeltaValue()
	 * @generated
	 */
	void setDeltaValue(SILabelValue value);

	/**
	 * Returns the value of the '<em><b>Probe Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probe Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probe Value</em>' reference.
	 * @see #setProbeValue(SILabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSILabel_ProbeValue()
	 * @model
	 * @generated
	 */
	SILabelValue getProbeValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getProbeValue <em>Probe Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probe Value</em>' reference.
	 * @see #getProbeValue()
	 * @generated
	 */
	void setProbeValue(SILabelValue value);

	/**
	 * Returns the value of the '<em><b>Temp Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temp Value</em>' reference.
	 * @see #setTempValue(SILabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSILabel_TempValue()
	 * @model
	 * @generated
	 */
	SILabelValue getTempValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getTempValue <em>Temp Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Value</em>' reference.
	 * @see #getTempValue()
	 * @generated
	 */
	void setTempValue(SILabelValue value);

	/**
	 * Returns the value of the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Value</em>' reference.
	 * @see #setOriginalValue(SILabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSILabel_OriginalValue()
	 * @model
	 * @generated
	 */
	SILabelValue getOriginalValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getOriginalValue <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Value</em>' reference.
	 * @see #getOriginalValue()
	 * @generated
	 */
	void setOriginalValue(SILabelValue value);

	/**
	 * Returns the value of the '<em><b>Error Scale</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Scale</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Scale</em>' reference.
	 * @see #setErrorScale(SILabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSILabel_ErrorScale()
	 * @model
	 * @generated
	 */
	SILabelValue getErrorScale();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SILabel#getErrorScale <em>Error Scale</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Scale</em>' reference.
	 * @see #getErrorScale()
	 * @generated
	 */
	void setErrorScale(SILabelValue value);

	/**
	 * This is the top-level segment for all type URI's for SI disease model
	 * labels.
	 */
	String URI_TYPE_SI_LABEL_SEGMENT = URI_TYPE_STANDARD_DISEASE_MODEL_LABEL_SEGMENT
			+ "/si";

	/**
	 * @return the current number of "infectious" population members
	 */
	public double getI();

	/**
	 * @return set the current number of "infectious" population members
	 */
	public void setI(double i);

	
	/**
	 * @return the incidence - which is the "new infectious" or "new exposed" number that comes from
	 * the interaction term in any disease model. This corresponds to the count of actual new disease
	 * reports in real public health surveillance statistics.
	 */
	public double getIncidence();
	
	/**
	 * set the incidence - which is the "new infectious" or "new exposed" number that comes from
	 * the interaction term in any disease model. This corresponds to the count of actual new disease
	 * reports in real public health surveillance statistics.
	 */
	public void setIncidence(double incidence);



	/**
	 * @return the next number of "infectious" population members
	 */
	public double getNextI();

	/**
	 * @return set the number number of infectious population members
	 */
	public void setNextI(double i);


} // SILabel
