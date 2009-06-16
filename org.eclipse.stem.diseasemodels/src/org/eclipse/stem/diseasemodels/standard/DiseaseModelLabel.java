// DiseaseModelLabel.java
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
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;

/**
 * This interface defines a class in an EMF model for an STEM Disease model
 * label. It is the top-level disease model, all other disease model labels
 * derive from this class.
 * 
 * @model abstract="true"
 */
public interface DiseaseModelLabel extends DynamicNodeLabel {

	/**
	 * This is the top-level segment for all type URI's for disease model
	 * labels.
	 */
	String URI_TYPE_DISEASE_MODEL_LABEL_SEGMENT = URI_TYPE_DYNAMIC_LABEL_SEGMENT
			+ "/diseasemodel";

	/**
	 * This is the type URI for disease model labels
	 */
	URI URI_TYPE_SIR_LABEL = STEMURI
			.createTypeURI(URI_TYPE_DISEASE_MODEL_LABEL_SEGMENT);

	/**
	 * This is the Population being infected by a Disease. The values for this
	 * disease model label apply to the population represented by the population
	 * label.
	 * 
	 * @return the Population affected by the disease.
	 * 
	 * @model
	 */
	PopulationLabel getPopulationLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getPopulationLabel <em>Population Label</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Label</em>' reference.
	 * @see #getPopulationLabel()
	 * @generated
	 */
	void setPopulationLabel(PopulationLabel value);

	/**
	 * @return the disease model state associated with this label (if any).
	 * @model containment="true" opposite="label"
	 */
	DiseaseModelState getDiseaseModelState();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getDiseaseModelState <em>Disease Model State</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disease Model State</em>' containment reference.
	 * @see #getDiseaseModelState()
	 * @generated
	 */
	void setDiseaseModelState(DiseaseModelState value);

	/**
	 * @return the value of the number of population members born.
	 */
	double getBirths();

	/**
	 * @param b the number of births
	 */
	void setBirths(final double b);
	
	/**
	 * @return the next value of the number of population members born.
	 */
	double getNextBirths();

	/**
	 * @param b the number of births
	 */
	void setNextBirths(final double b);
	
	/**
	 * @return the value of the number of population members who have died.
	 */
	double getDeaths();

	/**
	 * @param d the number of deaths
	 */
	void setDeaths(final double d);
	
	/**
	 * @return the next value of the number of population members who have died.
	 */
	double getNextDeaths();

	/**
	 * @param d the number of deaths
	 */
	void setNextDeaths(final double d);
	
	
	/**
	 * @return the value of the number of population members who have died from
	 *         the disease.
	 */
	double getDiseaseDeaths();

	/**
	 * @param d the number of deaths
	 */
	void setDiseaseDeaths(final double d);
	
	/**
	 * @return the next value of the number of population members who have died
	 *         from the disease.
	 */
	double getNextDiseaseDeaths();

	/**
	 * @param d the number of deaths
	 */
	void setNextDiseaseDeaths(final double d);
	
	
	/**
	 * @return the current SI label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	DiseaseModelLabelValue getCurrentDiseaseModelLabelValue();

	/**
	 * @return the next SI label value
	 * @model volatile="true" changeable="false" resolveProxies="false"
	 */
	DiseaseModelLabelValue getNextDiseaseModelLabelValue();

	/**
	 * Returns the value of the '<em><b>Delta Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta Value</em>' reference.
	 * @see #setDeltaValue(DiseaseModelLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModelLabel_DeltaValue()
	 * @model resolveProxies="false"
	 * @generated
	 */
	DiseaseModelLabelValue getDeltaValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getDeltaValue <em>Delta Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta Value</em>' reference.
	 * @see #getDeltaValue()
	 * @generated
	 */
	void setDeltaValue(DiseaseModelLabelValue value);

	/**
	 * Returns the value of the '<em><b>Current Y</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Y</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Y</em>' reference.
	 * @see #setCurrentY(DiseaseModelLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModelLabel_CurrentY()
	 * @model resolveProxies="false"
	 * @generated
	 */
	DiseaseModelLabelValue getCurrentY();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getCurrentY <em>Current Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Y</em>' reference.
	 * @see #getCurrentY()
	 * @generated
	 */
	void setCurrentY(DiseaseModelLabelValue value);

	/**
	 * Returns the value of the '<em><b>Current Disease Model Temp Label Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Disease Model Temp Label Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Disease Model Temp Label Value</em>' reference.
	 * @see #setCurrentDiseaseModelTempLabelValue(DiseaseModelLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModelLabel_CurrentDiseaseModelTempLabelValue()
	 * @model
	 * @generated
	 */
	DiseaseModelLabelValue getCurrentDiseaseModelTempLabelValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getCurrentDiseaseModelTempLabelValue <em>Current Disease Model Temp Label Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Disease Model Temp Label Value</em>' reference.
	 * @see #getCurrentDiseaseModelTempLabelValue()
	 * @generated
	 */
	void setCurrentDiseaseModelTempLabelValue(DiseaseModelLabelValue value);

	/**
	 * Returns the value of the '<em><b>YScale</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YScale</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YScale</em>' reference.
	 * @see #setYScale(DiseaseModelLabelValue)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getDiseaseModelLabel_YScale()
	 * @model resolveProxies="false"
	 * @generated
	 */
	DiseaseModelLabelValue getYScale();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getYScale <em>YScale</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YScale</em>' reference.
	 * @see #getYScale()
	 * @generated
	 */
	void setYScale(DiseaseModelLabelValue value);
} // DiseaseModelLabel
