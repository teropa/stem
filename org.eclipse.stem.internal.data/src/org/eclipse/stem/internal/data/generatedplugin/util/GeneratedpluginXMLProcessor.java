package org.eclipse.stem.internal.data.generatedplugin.util;

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

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class GeneratedpluginXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GeneratedpluginXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		GeneratedpluginPackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the
	 * GeneratedpluginResourceFactoryImpl factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION,
					new GeneratedpluginResourceFactoryImpl());
			registrations.put(STAR_EXTENSION,
					new GeneratedpluginResourceFactoryImpl());
		}
		return registrations;
	}

} // GeneratedpluginXMLProcessor
