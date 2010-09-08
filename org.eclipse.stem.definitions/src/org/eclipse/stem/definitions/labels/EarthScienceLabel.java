/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.definitions.labels;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.StaticNodeLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Earth Science Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.EarthScienceLabel#getCurrentEarthScienceValue <em>Current Earth Science Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.definitions.labels.LabelsPackage#getEarthScienceLabel()
 * @model
 * @generated
 */
public interface EarthScienceLabel extends StaticNodeLabel {
	
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * earth science label type URI.
	 */
	String URI_TYPE_EARTH_SCIENCE_LABEL_SEGMENT = URI_TYPE_LABEL_SEGMENT + "/earthscience";

	/**
	 * This is the type URI for area labels
	 */
	URI URI_TYPE_EARTH_SCIENCE_LABEL = STEMURI
			.createTypeURI(URI_TYPE_EARTH_SCIENCE_LABEL_SEGMENT);

	/**
	 * Returns the value of the '<em><b>Current Earth Science Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Earth Science Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Earth Science Value</em>' reference.
	 * @see org.eclipse.stem.definitions.labels.LabelsPackage#getEarthScienceLabel_CurrentEarthScienceValue()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	EarthScienceLabelValue getCurrentEarthScienceValue();

} // EarthScienceLabel
