// TransportationGeographicRelationshipPropertyFileSpecification.java
package org.eclipse.stem.internal.data.geography.infrastructure.transportation.specifications;

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

import org.eclipse.stem.internal.data.geography.specifications.GeographicRelationshipPropertyFileSpecification;

/**
 * This class represents
 */
abstract public class TransportationGeographicRelationshipPropertyFileSpecification
		extends GeographicRelationshipPropertyFileSpecification {

	@Override
	protected String getTargetPluginId() {
		return org.eclipse.stem.data.geography.infrastructure.transportation.Activator.PLUGIN_ID;
	}

} // TransportationGeographicRelationshipPropertyFileSpecification