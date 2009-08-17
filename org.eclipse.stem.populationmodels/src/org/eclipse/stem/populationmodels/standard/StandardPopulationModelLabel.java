package org.eclipse.stem.populationmodels.standard;
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

import org.eclipse.stem.core.graph.IntegrationLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Population Model Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getDeltaValue <em>Delta Value</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getProbeValue <em>Probe Value</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getTempValue <em>Temp Value</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getOriginalValue <em>Original Value</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getErrorScale <em>Error Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabel()
 * @model superTypes="org.eclipse.stem.populationmodels.standard.PopulationModelLabel org.eclipse.stem.populationmodels.standard.IntegrationLabel"
 * @generated
 */
public interface StandardPopulationModelLabel extends PopulationModelLabel, IntegrationLabel {

	/**
	 * Returns the value of the '<em><b>Delta Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta Value</em>' reference.
	 * @see #setDeltaValue(StandardPopulationModelLabelValue)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabel_DeltaValue()
	 * @model
	 * @generated
	 */
	StandardPopulationModelLabelValue getDeltaValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getDeltaValue <em>Delta Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta Value</em>' reference.
	 * @see #getDeltaValue()
	 * @generated
	 */
	void setDeltaValue(StandardPopulationModelLabelValue value);

	/**
	 * Returns the value of the '<em><b>Probe Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probe Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probe Value</em>' reference.
	 * @see #setProbeValue(StandardPopulationModelLabelValue)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabel_ProbeValue()
	 * @model
	 * @generated
	 */
	StandardPopulationModelLabelValue getProbeValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getProbeValue <em>Probe Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probe Value</em>' reference.
	 * @see #getProbeValue()
	 * @generated
	 */
	void setProbeValue(StandardPopulationModelLabelValue value);

	/**
	 * Returns the value of the '<em><b>Temp Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temp Value</em>' reference.
	 * @see #setTempValue(StandardPopulationModelLabelValue)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabel_TempValue()
	 * @model
	 * @generated
	 */
	StandardPopulationModelLabelValue getTempValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getTempValue <em>Temp Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Value</em>' reference.
	 * @see #getTempValue()
	 * @generated
	 */
	void setTempValue(StandardPopulationModelLabelValue value);

	/**
	 * Returns the value of the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Value</em>' reference.
	 * @see #setOriginalValue(StandardPopulationModelLabelValue)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabel_OriginalValue()
	 * @model
	 * @generated
	 */
	StandardPopulationModelLabelValue getOriginalValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getOriginalValue <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Value</em>' reference.
	 * @see #getOriginalValue()
	 * @generated
	 */
	void setOriginalValue(StandardPopulationModelLabelValue value);

	/**
	 * Returns the value of the '<em><b>Error Scale</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Scale</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Scale</em>' reference.
	 * @see #setErrorScale(StandardPopulationModelLabelValue)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getStandardPopulationModelLabel_ErrorScale()
	 * @model
	 * @generated
	 */
	StandardPopulationModelLabelValue getErrorScale();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel#getErrorScale <em>Error Scale</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Scale</em>' reference.
	 * @see #getErrorScale()
	 * @generated
	 */
	void setErrorScale(StandardPopulationModelLabelValue value);
} // StandardPopulationModelLabel
