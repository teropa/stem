package org.eclipse.stem.internal.data.generatedplugin;

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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Extension</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.Extension#getCategories
 * <em>Categories</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.Extension#getDublinCores
 * <em>Dublin Cores</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.Extension#getPoint
 * <em>Point</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getExtension()
 * @model extendedMetaData="name='extension' kind='elementOnly'"
 * @generated
 */
public interface Extension extends EObject {
	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Categories</em>' containment reference
	 *         list.
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getExtension_Categories()
	 * @model containment="true" required="true" extendedMetaData=
	 *        "kind='element' name='categories' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<StemCategory> getCategories();

	/**
	 * Returns the value of the '<em><b>Dublin Cores</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dublin Cores</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Dublin Cores</em>' containment reference
	 *         list.
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getExtension_DublinCores()
	 * @model containment="true" extendedMetaData=
	 *        "kind='element' name='dublinCores' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DublinCore> getDublinCores();

	/**
	 * Returns the value of the '<em><b>Point</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Point</em>' attribute.
	 * @see #setPoint(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getExtension_Point()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='point'"
	 * @generated
	 */
	String getPoint();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.Extension#getPoint
	 * <em>Point</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Point</em>' attribute.
	 * @see #getPoint()
	 * @generated
	 */
	void setPoint(String value);

} // Extension
