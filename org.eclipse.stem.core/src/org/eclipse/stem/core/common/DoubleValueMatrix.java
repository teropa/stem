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
 * A representation of the model object '<em><b>Double Value Matrix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.common.DoubleValueMatrix#getValueLists <em>Value Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.core.common.CommonPackage#getDoubleValueMatrix()
 * @model
 * @generated
 */
public interface DoubleValueMatrix extends EObject {
	/**
	 * Returns the value of the '<em><b>Value Lists</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.stem.core.common.DoubleValueList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Lists</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Lists</em>' containment reference list.
	 * @see org.eclipse.stem.core.common.CommonPackage#getDoubleValueMatrix_ValueLists()
	 * @model containment="true"
	 * @generated
	 */
	EList<DoubleValueList> getValueLists();

} // DoubleValueMatrix
