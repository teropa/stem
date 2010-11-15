package org.eclipse.stem.diseasemodels.vector;

import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;


/**

*  This is the textbook Macdonald-Ross vector borne disease model
*
* @model
*/



public interface MacdonaldRossDiseaseModel extends VectorDiseaseModel{

	/**
	 * Returns the value of the '<em><b>Biting Rate</b></em>' attribute.
	 * The default value is <code>"0.5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Biting Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Biting Rate</em>' attribute.
	 * @see #setBitingRate(double)
	 * @see org.eclipse.stem.diseasemodels.vector.VectorPackage#getMacdonaldRossDiseaseModel_BitingRate()
	 * @model default="0.5"
	 * @generated
	 */
	double getBitingRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getBitingRate <em>Biting Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Biting Rate</em>' attribute.
	 * @see #getBitingRate()
	 * @generated
	 */
	void setBitingRate(double value);

	/**
	 * Returns the value of the '<em><b>Infectious Biting Proportion Human</b></em>' attribute.
	 * The default value is <code>"0.5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infectious Biting Proportion Human</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infectious Biting Proportion Human</em>' attribute.
	 * @see #setInfectiousBitingProportionHuman(double)
	 * @see org.eclipse.stem.diseasemodels.vector.VectorPackage#getMacdonaldRossDiseaseModel_InfectiousBitingProportionHuman()
	 * @model default="0.5"
	 * @generated
	 */
	double getInfectiousBitingProportionHuman();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getInfectiousBitingProportionHuman <em>Infectious Biting Proportion Human</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infectious Biting Proportion Human</em>' attribute.
	 * @see #getInfectiousBitingProportionHuman()
	 * @generated
	 */
	void setInfectiousBitingProportionHuman(double value);

	/**
	 * Returns the value of the '<em><b>Infectious Biting Proportion Vector</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infectious Biting Proportion Vector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infectious Biting Proportion Vector</em>' attribute.
	 * @see #setInfectiousBitingProportionVector(double)
	 * @see org.eclipse.stem.diseasemodels.vector.VectorPackage#getMacdonaldRossDiseaseModel_InfectiousBitingProportionVector()
	 * @model default="1.0"
	 * @generated
	 */
	double getInfectiousBitingProportionVector();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getInfectiousBitingProportionVector <em>Infectious Biting Proportion Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infectious Biting Proportion Vector</em>' attribute.
	 * @see #getInfectiousBitingProportionVector()
	 * @generated
	 */
	void setInfectiousBitingProportionVector(double value);

	/**
	 * Returns the value of the '<em><b>Recovery Rate</b></em>' attribute.
	 * The default value is <code>"3.33E-3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recovery Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recovery Rate</em>' attribute.
	 * @see #setRecoveryRate(double)
	 * @see org.eclipse.stem.diseasemodels.vector.VectorPackage#getMacdonaldRossDiseaseModel_RecoveryRate()
	 * @model default="3.33E-3"
	 * @generated
	 */
	double getRecoveryRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel#getRecoveryRate <em>Recovery Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recovery Rate</em>' attribute.
	 * @see #getRecoveryRate()
	 * @generated
	 */
	void setRecoveryRate(double value);

}
