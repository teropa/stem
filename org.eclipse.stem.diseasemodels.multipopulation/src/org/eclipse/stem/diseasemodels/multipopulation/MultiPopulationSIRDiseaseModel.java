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
 * A representation of the model object '<em><b>Multi Population SIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIRDiseaseModel#getImmunityLossRate <em>Immunity Loss Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSIRDiseaseModel()
 * @model
 * @generated
 */
public interface MultiPopulationSIRDiseaseModel extends MultiPopulationSIDiseaseModel {
	/**
	 * Returns the value of the '<em><b>Immunity Loss Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Immunity Loss Rate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Immunity Loss Rate</em>' containment reference.
	 * @see #setImmunityLossRate(DoubleValueList)
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSIRDiseaseModel_ImmunityLossRate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DoubleValueList getImmunityLossRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIRDiseaseModel#getImmunityLossRate <em>Immunity Loss Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immunity Loss Rate</em>' containment reference.
	 * @see #getImmunityLossRate()
	 * @generated
	 */
	void setImmunityLossRate(DoubleValueList value);

} // MultiPopulationSIRDiseaseModel
