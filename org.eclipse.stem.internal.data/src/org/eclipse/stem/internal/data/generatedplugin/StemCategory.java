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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Stem Category</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory#getId
 * <em>Id</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory#getParentId
 * <em>Parent Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getStemCategory()
 * @model extendedMetaData="name='stem_category' kind='empty'"
 * @generated
 */
public interface StemCategory extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getStemCategory_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory#getId
	 * <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getStemCategory_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parent Id</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Id</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Id</em>' attribute.
	 * @see #setParentId(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getStemCategory_ParentId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='parent_id'"
	 * @generated
	 */
	String getParentId();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory#getParentId
	 * <em>Parent Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Parent Id</em>' attribute.
	 * @see #getParentId()
	 * @generated
	 */
	void setParentId(String value);

} // StemCategory
