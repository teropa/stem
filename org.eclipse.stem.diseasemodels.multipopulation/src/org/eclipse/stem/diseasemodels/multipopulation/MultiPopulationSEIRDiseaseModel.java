/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.multipopulation;

import org.eclipse.stem.core.common.DoubleValueList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Population SEIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSEIRDiseaseModel#getIncubationRate <em>Incubation Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSEIRDiseaseModel()
 * @model
 * @generated
 */
public interface MultiPopulationSEIRDiseaseModel extends MultiPopulationSIRDiseaseModel {
	/**
	 * Returns the value of the '<em><b>Incubation Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incubation Rate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incubation Rate</em>' containment reference.
	 * @see #setIncubationRate(DoubleValueList)
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSEIRDiseaseModel_IncubationRate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DoubleValueList getIncubationRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSEIRDiseaseModel#getIncubationRate <em>Incubation Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incubation Rate</em>' containment reference.
	 * @see #getIncubationRate()
	 * @generated
	 */
	void setIncubationRate(DoubleValueList value);

} // MultiPopulationSEIRDiseaseModel
