// SIRLabel.java
package org.eclipse.stem.diseasemodels.standard;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;


/**
 * This interface defines a class in an EMF model for an SIR disease model
 * dynamic label.
 * 
 * @see StandardDiseaseModel
 * @see StandardDiseaseModelLabel
 * @see StandardDiseaseModelLabelValue
 * @see SI
 * @see SILabel
 * @see SILabelValue
 * @see SIR
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model
 */
public interface SIRLabel extends StandardDiseaseModelLabel {

	/**
	 * Returns the value of the '<em><b>Delta Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta Value</em>' reference.
	 * @see #setDeltaValue(SIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSIRLabel_DeltaValue()
	 * @model
	 * @generated
	 */
	SIRLabelValue getDeltaValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getDeltaValue <em>Delta Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta Value</em>' reference.
	 * @see #getDeltaValue()
	 * @generated
	 */
	void setDeltaValue(SIRLabelValue value);

	/**
	 * Returns the value of the '<em><b>Probe Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probe Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probe Value</em>' reference.
	 * @see #setProbeValue(SIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSIRLabel_ProbeValue()
	 * @model
	 * @generated
	 */
	SIRLabelValue getProbeValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getProbeValue <em>Probe Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probe Value</em>' reference.
	 * @see #getProbeValue()
	 * @generated
	 */
	void setProbeValue(SIRLabelValue value);

	/**
	 * Returns the value of the '<em><b>Temp Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temp Value</em>' reference.
	 * @see #setTempValue(SIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSIRLabel_TempValue()
	 * @model
	 * @generated
	 */
	SIRLabelValue getTempValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getTempValue <em>Temp Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Value</em>' reference.
	 * @see #getTempValue()
	 * @generated
	 */
	void setTempValue(SIRLabelValue value);

	/**
	 * Returns the value of the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Value</em>' reference.
	 * @see #setOriginalValue(SIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSIRLabel_OriginalValue()
	 * @model
	 * @generated
	 */
	SIRLabelValue getOriginalValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getOriginalValue <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Value</em>' reference.
	 * @see #getOriginalValue()
	 * @generated
	 */
	void setOriginalValue(SIRLabelValue value);

	/**
	 * Returns the value of the '<em><b>Error Scale</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Scale</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Scale</em>' reference.
	 * @see #setErrorScale(SIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSIRLabel_ErrorScale()
	 * @model
	 * @generated
	 */
	SIRLabelValue getErrorScale();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel#getErrorScale <em>Error Scale</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Scale</em>' reference.
	 * @see #getErrorScale()
	 * @generated
	 */
	void setErrorScale(SIRLabelValue value);

	/**
	 * This is the top-level segment for all type URI's for SIR disease model
	 * labels.
	 */
	String URI_TYPE_SIR_LABEL_SEGMENT = URI_TYPE_STANDARD_DISEASE_MODEL_LABEL_SEGMENT
			+ "/sir";

	/**
	 * This is the type URI for standard SIR disease labels
	 */
	URI URI_TYPE_SIR_LABEL = STEMURI.createTypeURI(URI_TYPE_SIR_LABEL_SEGMENT);

	/**
	 * @return the current number of "recovered" population members
	 */
	public double getR();

	/**
	 * @param r
	 *            the new value for the current number of "recovered" population
	 *            members
	 */
	public void setR(double r);

	/**
	 * @return the next number of "recovered" population members
	 */
	public double getNextR();

	/**
	 * @param r
	 *            the new value for the next number of "recovered" population
	 *            members
	 */
	public void setNextR(double r);

	/**
	 * @return the current SIR label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SIRLabelValue getCurrentSIRValue();

	/**
	 * @return the next SIR label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SIRLabelValue getNextSIRValue();
} // SIRLabel
