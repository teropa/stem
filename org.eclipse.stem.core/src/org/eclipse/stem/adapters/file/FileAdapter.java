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
package org.eclipse.stem.adapters.file;

import java.io.IOException;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.stem.core.common.Identifiable;



public class FileAdapter extends AdapterImpl implements File {

	public XMIResource getResource() {
		// Override
		return null;
	}

	public void delete() throws IOException {
		// override
	}

	public void rename(String newname) throws IOException {
		// override
	}

	public Identifiable getIdentifiable() {
		// override
		return null;
	}
	
}
