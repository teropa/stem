package org.eclipse.stem.core.common;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Value List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.common.StringValueList#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.core.common.CommonPackage#getStringValueList()
 * @model
 * @generated
 */
public interface StringValueList extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.stem.core.common.StringValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.eclipse.stem.core.common.CommonPackage#getStringValueList_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<StringValue> getValues();

} // StringValueList
