package org.eclipse.stem.ui.wizards;

/*******************************************************************************
 * Copyright (c) 2006,2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;

abstract public class NewNonIdentifiableWizard extends Wizard implements
		INewWizard {

	/**
	 * This is the context sensitive help context id for the wizard
	 */
	
	protected String helpContextId = "org.eclipse.stem.doc.newexperiment_contextid";
	
	protected String getHelpContextId() {
		return helpContextId;
	}

	protected void setHelpContextId(String helpContextId) {
		this.helpContextId = helpContextId;
	}
}