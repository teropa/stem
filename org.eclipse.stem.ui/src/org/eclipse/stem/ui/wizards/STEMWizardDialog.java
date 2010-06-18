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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

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

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		Button helpButton = super.getButton(IDialogConstants.HELP_ID);
		ImageDescriptor helpIcon = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.stem.ui", "icons/full/customobj16/questionmark.gif");
		Image image = helpIcon.createImage();
		helpButton.setText("");
		helpButton.setImage(image);
		GridData helpButtonLayout = new GridData();
		helpButtonLayout.verticalAlignment = GridData.FILL;
		helpButton.setLayoutData(helpButtonLayout);
	}
}