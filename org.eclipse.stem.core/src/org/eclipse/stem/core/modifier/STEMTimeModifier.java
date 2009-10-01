/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.modifier;

import org.eclipse.stem.core.model.STEMTime;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>STEM Time Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.STEMTimeModifier#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.STEMTimeModifier#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.core.modifier.ModifierPackage#getSTEMTimeModifier()
 * @model
 * @generated
 */
public interface STEMTimeModifier extends SingleValueModifier {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(STEMTime)
	 * @see org.eclipse.stem.core.modifier.ModifierPackage#getSTEMTimeModifier_Value()
	 * @model
	 * @generated
	 */
	STEMTime getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.STEMTimeModifier#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(STEMTime value);

	/**
	 * Returns the value of the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Value</em>' reference.
	 * @see #setOriginalValue(STEMTime)
	 * @see org.eclipse.stem.core.modifier.ModifierPackage#getSTEMTimeModifier_OriginalValue()
	 * @model
	 * @generated
	 */
	STEMTime getOriginalValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.STEMTimeModifier#getOriginalValue <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Value</em>' reference.
	 * @see #getOriginalValue()
	 * @generated
	 */
	void setOriginalValue(STEMTime value);
} // STEMTimeModifier
