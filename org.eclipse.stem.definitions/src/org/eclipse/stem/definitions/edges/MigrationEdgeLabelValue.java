package org.eclipse.stem.definitions.edges;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.graph.LabelValue;

/**
 * Represents the rate of migration between two nodes. This is a 
 * number between 0 and infinity
 * 
 * @author jlessler
 *
 *@model
 */
public interface MigrationEdgeLabelValue extends LabelValue {
	
	/**Returns the migration rate
	 * @return a number between 0 and infinity
	 * 
	 * @model default="0.0"*/
	double getMigrationRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue#getMigrationRate <em>Migration Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Migration Rate</em>' attribute.
	 * @see #getMigrationRate()
	 * @generated
	 */
	void setMigrationRate(double value);

}
