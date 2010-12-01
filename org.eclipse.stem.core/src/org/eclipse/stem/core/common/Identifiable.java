// Identifiable.java
package org.eclipse.stem.core.common;

/******************************************************************************* 
 * Copyright (c) 2006 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * An <code>Identifiable</code> instance represents an "identifiable"
 * component in STEM. Such a component is one that is uniquely identified by a
 * {@link URI}. An <code>Identifiable</code> also has {@link DublinCore}
 * metadata (<a href="http://www.dublincore.org/" >http://www.dublincore.org/</a>)
 * associated with it that defines its origin and contents.
 * <p>
 * Virtually all components in a STEM simulation are <code>Identifiable</code>.
 * </p>
 * 
 * @see Graph
 * @see org.eclipse.stem.core.model.Model
 * @see org.eclipse.stem.core.scenario.Scenario
 * 
 * @model abstract="true"
 * @implements SanityChecker
 */
public interface Identifiable extends EObject, Comparable<Identifiable>, SanityChecker {

	/**
	 * @return the URL that uniquely identifies this Identifiable component.
	 * 
	 * @model required="true"
	 */
	URI getURI();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.Identifiable#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(URI value);

	/**
	 * @return the URL that uniquely identifies the type of this Identifiable
	 *         component.
	 * 
	 * @model required="true"
	 */
	URI getTypeURI();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.Identifiable#getTypeURI <em>Type URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type URI</em>' attribute.
	 * @see #getTypeURI()
	 * @generated
	 */
	void setTypeURI(URI value);

	/**
	 * @return the "Dublin Core" metadata <a
	 *         href="http://www.dublincore.org/">http://www.dublincore.org/</a>
	 *         associated with this Identifiable component.
	 * @model containment="true" required="true"
	 */
	DublinCore getDublinCore();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.Identifiable#getDublinCore <em>Dublin Core</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dublin Core</em>' containment reference.
	 * @see #getDublinCore()
	 * @generated
	 */
	void setDublinCore(DublinCore value);

	/**
	 * @return true if the instance is "sane", false otherwise.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	boolean sane();
} // Identifiable
