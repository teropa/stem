/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.common;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Value List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.common.DoubleValueList#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.DoubleValueList#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.core.common.CommonPackage#getDoubleValueList()
 * @model
 * @generated
 */
public interface DoubleValueList extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.stem.core.common.DoubleValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.eclipse.stem.core.common.CommonPackage#getDoubleValueList_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<DoubleValue> getValues();

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.eclipse.stem.core.common.CommonPackage#getDoubleValueList_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.DoubleValueList#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

} // DoubleValueList
