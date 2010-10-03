package org.eclipse.stem.internal.data.generatedplugin.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.stem.internal.data.generatedplugin.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class GeneratedpluginFactoryImpl extends EFactoryImpl implements
		GeneratedpluginFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static GeneratedpluginFactory init() {
		try {
			GeneratedpluginFactory theGeneratedpluginFactory = (GeneratedpluginFactory)EPackage.Registry.INSTANCE.getEFactory("http://data.internal.stem.eclipse.org/generatedplugin"); 
			if (theGeneratedpluginFactory != null) {
				return theGeneratedpluginFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GeneratedpluginFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public GeneratedpluginFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GeneratedpluginPackage.DUBLIN_CORE: return (EObject)createDublinCore();
			case GeneratedpluginPackage.EXTENSION: return (EObject)createExtension();
			case GeneratedpluginPackage.PLUGIN: return (EObject)createPlugin();
			case GeneratedpluginPackage.STEM_CATEGORY: return (EObject)createStemCategory();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DublinCore createDublinCore() {
		DublinCoreImpl dublinCore = new DublinCoreImpl();
		return dublinCore;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Extension createExtension() {
		ExtensionImpl extension = new ExtensionImpl();
		return extension;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Plugin createPlugin() {
		PluginImpl plugin = new PluginImpl();
		return plugin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StemCategory createStemCategory() {
		StemCategoryImpl stemCategory = new StemCategoryImpl();
		return stemCategory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedpluginPackage getGeneratedpluginPackage() {
		return (GeneratedpluginPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GeneratedpluginPackage getPackage() {
		return GeneratedpluginPackage.eINSTANCE;
	}

} // GeneratedpluginFactoryImpl
