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

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class STEMWizardDialog extends WizardDialog {

	public STEMWizardDialog(Shell parentShell, IWizard newWizard) {
		super(parentShell, newWizard);
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
		if (IDialogConstants.HELP_ID == buttonId) {
			if (this.getWizard() instanceof NewIdentifiableWizard){
				PlatformUI.getWorkbench().getHelpSystem().displayHelp(((NewIdentifiableWizard)this.getWizard()).getHelpContextId());
			}
			else{
				PlatformUI.getWorkbench().getHelpSystem().displayHelp(((NewNonIdentifiableWizard)this.getWizard()).getHelpContextId());
			}
		}
	}
}