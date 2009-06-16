package org.eclipse.stem.internal.data.generatedplugin.validation;

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

import org.eclipse.emf.common.util.EList;

import org.eclipse.stem.internal.data.generatedplugin.Extension;

/**
 * A sample validator interface for
 * {@link org.eclipse.stem.internal.data.generatedplugin.Plugin}. This
 * doesn't really do anything, and it's not a real EMF artifact. It was
 * generated by the org.eclipse.emf.examples.generator.validator plug-in to
 * illustrate how EMF's code generator can be extended. This can be disabled
 * with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
@SuppressWarnings("all")
public interface PluginValidator {
	boolean validate();

	boolean validateExtensionelement(EList<Extension> value);
}
