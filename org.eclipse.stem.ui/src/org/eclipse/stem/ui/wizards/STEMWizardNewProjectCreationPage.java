package org.eclipse.stem.ui.wizards;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class STEMWizardNewProjectCreationPage extends WizardNewProjectCreationPage {

	public STEMWizardNewProjectCreationPage(String pageName) {
		super(pageName);
	}

	@Override
	  public void createControl(Composite parent) {
		super.createControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), "org.eclipse.stem.doc.newstemproject_contextid");
	}
}
