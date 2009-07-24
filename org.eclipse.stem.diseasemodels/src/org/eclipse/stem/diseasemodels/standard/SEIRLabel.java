// SEIRLabel.java
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
 * This interface defines a class in an EMF model for a standard SEIR disease
 * model dynamic label.
 * 
 * @see StandardDiseaseModel
 * @see StandardDiseaseModelLabel
 * @see StandardDiseaseModelLabelValue
 * @see SI
 * @see SILabel
 * @see SILabelValue
 * @see SIR
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabelValue
 * 
 * @model
 */
public interface SEIRLabel extends StandardDiseaseModelLabel {

	/**
	 * Returns the value of the '<em><b>Delta Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta Value</em>' reference.
	 * @see #setDeltaValue(SEIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSEIRLabel_DeltaValue()
	 * @model
	 * @generated
	 */
	SEIRLabelValue getDeltaValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getDeltaValue <em>Delta Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta Value</em>' reference.
	 * @see #getDeltaValue()
	 * @generated
	 */
	void setDeltaValue(SEIRLabelValue value);

	/**
	 * Returns the value of the '<em><b>Probe Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probe Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probe Value</em>' reference.
	 * @see #setProbeValue(SEIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSEIRLabel_ProbeValue()
	 * @model
	 * @generated
	 */
	SEIRLabelValue getProbeValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getProbeValue <em>Probe Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probe Value</em>' reference.
	 * @see #getProbeValue()
	 * @generated
	 */
	void setProbeValue(SEIRLabelValue value);

	/**
	 * Returns the value of the '<em><b>Temp Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temp Value</em>' reference.
	 * @see #setTempValue(SEIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSEIRLabel_TempValue()
	 * @model
	 * @generated
	 */
	SEIRLabelValue getTempValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getTempValue <em>Temp Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Value</em>' reference.
	 * @see #getTempValue()
	 * @generated
	 */
	void setTempValue(SEIRLabelValue value);

	/**
	 * Returns the value of the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Value</em>' reference.
	 * @see #setOriginalValue(SEIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSEIRLabel_OriginalValue()
	 * @model
	 * @generated
	 */
	SEIRLabelValue getOriginalValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getOriginalValue <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Value</em>' reference.
	 * @see #getOriginalValue()
	 * @generated
	 */
	void setOriginalValue(SEIRLabelValue value);

	/**
	 * Returns the value of the '<em><b>Error Scale</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Scale</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Scale</em>' reference.
	 * @see #setErrorScale(SEIRLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSEIRLabel_ErrorScale()
	 * @model
	 * @generated
	 */
	SEIRLabelValue getErrorScale();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel#getErrorScale <em>Error Scale</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Scale</em>' reference.
	 * @see #getErrorScale()
	 * @generated
	 */
	void setErrorScale(SEIRLabelValue value);

	/**
	 * This is the top-level segment for all type URI's for SEIR disease model
	 * labels.
	 */
	String URI_TYPE_SEIR_LABEL_SEGMENT = URI_TYPE_STANDARD_DISEASE_MODEL_LABEL_SEGMENT
			+ "/seir";

	/**
	 * This is the type URI for standard SEIR disease labels
	 */
	URI URI_TYPE_SEIR_LABEL = STEMURI
			.createTypeURI(URI_TYPE_SEIR_LABEL_SEGMENT);

	/**
	 * @return the current number of "exposed" population members
	 */
	public double getE();

	/**
	 * @param e
	 *            the new value for the current number of "exposed" population
	 *            members
	 */
	public void setE(double e);

	/**
	 * @return the next number of "exposed" population members
	 */
	public double getNextE();

	/**
	 * @param e
	 *            the new value for the next number of "exposed" population
	 *            members
	 */
	public void setNextE(double e);

	/**
	 * @return the current SEIR label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SEIRLabelValue getCurrentSEIRValue();

	/**
	 * @return the next SEIR label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	SEIRLabelValue getNextSEIRValue();

} // SEIRLabel
