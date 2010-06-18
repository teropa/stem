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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class STEMWizardDialog extends WizardDialog {

	private Button helpButton;

	public STEMWizardDialog(final Shell parentShell, final IWizard newWizard) {
		super(parentShell, newWizard);
	}

	@Override
	protected void buttonPressed(final int buttonId) {
		super.buttonPressed(buttonId);
		if (IDialogConstants.HELP_ID == buttonId) {
			if (this.getWizard() instanceof NewIdentifiableWizard) {
				PlatformUI.getWorkbench().getHelpSystem().displayHelp(
						((NewIdentifiableWizard) this.getWizard())
								.getHelpContextId());
			} else {
				PlatformUI.getWorkbench().getHelpSystem().displayHelp(
						((NewNonIdentifiableWizard) this.getWizard())
								.getHelpContextId());
			}
		}
	}

	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		super.createButtonsForButtonBar(parent);
		helpButton = super.getButton(IDialogConstants.HELP_ID);
		final ImageDescriptor helpIcon = AbstractUIPlugin
				.imageDescriptorFromPlugin("org.eclipse.stem.ui",
						"icons/full/customobj16/HelpIcon.gif");
		final Image image = helpIcon.createImage();
		final ImageDescriptor helpIconMacOS = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.stem.ui", "icons/full/customobj16/HelpIconMacOS.gif");
		helpButton.setText("");
		if(System.getProperties().getProperty("os.name").contains("Mac")){
			final Image imageMacOS = helpIconMacOS.createImage();
			helpButton.setImage(imageMacOS);
		}
		else{
			helpButton.setImage(image);
		}
		final GridData helpButtonLayout = new GridData();
		helpButtonLayout.verticalAlignment = GridData.FILL;
		helpButton.setLayoutData(helpButtonLayout);
	}
}