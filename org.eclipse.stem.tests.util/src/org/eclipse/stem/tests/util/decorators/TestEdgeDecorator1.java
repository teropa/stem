// TestEdgeDecorator1.java
package org.eclipse.stem.tests.util.decorators;

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
import org.eclipse.stem.core.model.EdgeDecorator;

/**
 * This interface represents the model of an abstract class in an EMF model that
 * is an example of a EdgeDecorator implementation used for test purposes.
 * 
 * @model
 */
public interface TestEdgeDecorator1 extends EdgeDecorator {
	
	/**
	 * @return the URI for node A
	 * @model
	 */
	URI getNodeAURI();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1#getNodeAURI <em>Node AURI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node AURI</em>' attribute.
	 * @see #getNodeAURI()
	 * @generated
	 */
	void setNodeAURI(URI value);

	/**
	 * @return  the URI for node B
	 * @model
	 */
	URI getNodeBURI();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1#getNodeBURI <em>Node BURI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node BURI</em>' attribute.
	 * @see #getNodeBURI()
	 * @generated
	 */
	void setNodeBURI(URI value);

	/**
	 * @return the URI of the edge
	 * @model
	 */
	URI getEdgeURI();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1#getEdgeURI <em>Edge URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge URI</em>' attribute.
	 * @see #getEdgeURI()
	 * @generated
	 */
	void setEdgeURI(URI value);

} // TestEdgeDecorator1