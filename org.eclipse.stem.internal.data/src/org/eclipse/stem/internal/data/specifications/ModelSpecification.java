// ModelSpecification.java
package org.eclipse.stem.internal.data.specifications;

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

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.ModelPackage;

/**
 * This class represents the specification of an {@link Identifiable} that is a
 * {@link Model}.
 */
abstract public class ModelSpecification extends IdentifiableSpecification {

	@Override
	protected String getSerializationFileNameExtension() {
		return ModelPackage.eNAME;
	}

	// Nothing

	@Override
	protected Model createIdentifiableInstance() {
		final Model retValue = ModelFactory.eINSTANCE.createModel();
		dublinCore.setFormat(ModelPackage.eNS_URI);
		return retValue;
	} // createIdentifiableInstance

} // ModelSpecification