// Modifiable.java
package org.eclipse.stem.core.modifier;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.Identifiable;

/**
 * This interface is a "marker interface" used to identify {@link Identifiable}s
 * that can be modified by a {@link Modifier}. The main use of this marker is in
 * <a href="http://wiki.eclipse.org/Command_Core_Expressions">Command Core
 * Expressions</a> where they are used in <em>adapt</em> elements to test if the
 * current selection can be adapted to the type <code>Modifiable</code>. </p>
 * <p>
 * An example of its use can be found in
 * <code>org.eclipse.stem.ui/plugin.xml</code>. In that file there are
 * several instances of extensions of the extension point
 * <code>org.eclipse.core.expressions.definitions</code>; one contains the
 * definition of the expression
 * <code>org.eclipse.stem.ui.isModifiableIdentifiable</code> which includes
 * a test that the current selection can be adapted to <code>Modifiable</code>
 * (among other things). The value of the expression is used to enable the
 * command <code>org.eclipse.stem.ui.command.newmodifierwizard</code>
 * defined via a <code>org.eclipse.ui.commands</code> extension point elsewhere
 * in the same file. The command opens the wizard for creating a new
 * <code>Modifiable</code> given the current selection. The "Create Modifier"
 * entry in the popup context menu for the current selection will appear when
 * this command is enabled.
 * </p>
 * <p>
 * It is not sufficient to simply implement the <code>Modifiable</code>
 * interface for this test to return <code>true</code> in the core expression.
 * An instance of {@link IAdapterFactory} needs to be defined and then
 * registered as a "run time adapter factory" using the extension point
 * <code>org.eclipse.core.runtime.adapters</code>. The file
 * <code>org.eclipse.stem.ui/plugin.xml</code> contains examples.
 * 
 * 
 * @model interface="true"
 */
public interface Modifiable extends EObject {
	// Nothing
} // Modifiable