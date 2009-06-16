package org.eclipse.stem.ui.wizards;
import java.util.EventListener;

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


/**
 * This interface is implemented by classes that want to be informed when an ISO
 * key is selected from the {@link ISOKeyPicker};
 */
public interface ISOKeyPickedEventListener extends EventListener {
	void isoKeyPicked(ISOKeyPickedEvent ikpe);
} // ISOKeyPickedEventListener
