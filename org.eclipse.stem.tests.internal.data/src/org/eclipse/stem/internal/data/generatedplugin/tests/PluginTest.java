package org.eclipse.stem.internal.data.generatedplugin.tests;

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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginFactory;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage;
import org.eclipse.stem.internal.data.generatedplugin.Plugin;
import org.eclipse.stem.internal.data.generatedplugin.util.GeneratedpluginResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Plugin</b></em>'. <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class PluginTest extends TestCase {

	/**
	 * The fixture for this Plugin test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected Plugin fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PluginTest.class);
	}

	/**
	 * Constructs a new Plugin test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PluginTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Plugin test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Plugin fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Plugin test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Plugin getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeneratedpluginFactory.eINSTANCE.createPlugin());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void testDeserializePluginXML() {

		File file = new File("testdata/plugin.xml");
		final URI PLUGIN_URI = URI.createFileURI(file.getAbsolutePath());

		try {

			GeneratedpluginResourceFactoryImpl rfi = new GeneratedpluginResourceFactoryImpl();

			XMLResource.XMLMap xmlMap = new XMLMapImpl();
			xmlMap.setNoNamespacePackage(GeneratedpluginPackage.eINSTANCE);
			Map options = new HashMap();
			options.put(XMLResource.OPTION_XML_MAP, xmlMap);

			final Resource resource = rfi.createResource(PLUGIN_URI);
			resource.load(options);
			final Plugin plugin = (Plugin) resource.getContents().get(0);

			assertTrue(plugin.getExtensionelement().size() == 1);

			// for (Extension extension : plugin.getExtensionelement()) {
			//				
			// for ( StemCategory category :extension.getCategories()) {
			// System.out.println(category.toString());
			// }
			//				
			// for ( DublinCore dc :extension.getDublinCores()) {
			// System.out.println(dc.toString());
			// }
			//				
			// } // for each
		} catch (final Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	} // testDeserializePluginXML
} // PluginTest
