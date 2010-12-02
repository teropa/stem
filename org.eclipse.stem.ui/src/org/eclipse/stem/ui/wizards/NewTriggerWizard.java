// NewTriggerWizard.java
package org.eclipse.stem.ui.wizards;

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
import java.text.MessageFormat;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.trigger.Trigger;
import org.eclipse.stem.core.trigger.TriggerFactory;
import org.eclipse.stem.core.trigger.TriggerPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;


/**
 * This class is a {@link NewIdentifiableWizard} for that creates new STEM
 * {@link Trigger}s
 */
public class NewTriggerWizard extends NewIdentifiableWizard {

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getWizardTitle()
	 */
	@Override
	protected String getWizardTitle() {
		return Messages.getString("NTriggerWiz.wizard_title"); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createNewIdentifiablePage()
	 */
	@Override
	protected NewIdentifiablePage createNewIdentifiablePage() {
		this.setHelpContextId("org.eclipse.stem.doc.newtrigger_contextid");
		return new NewTriggerPage();
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createDublinCorePage()
	 */
	@Override
	protected DublinCorePage createDublinCorePage() {
		return new DublinCorePage() {
			@Override
			protected void initializeDCAttributes() {
				super.initializeDCAttributes();
				format.setText(TriggerPackage.eNS_URI);
				format.setEnabled(false);
				type.setText(STEMURI.TRIGGER_TYPE_URI.toString());
				type.setEnabled(false);
			}
		};
	} // createDublinCorePage

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createIdentifiable()
	 */
	@Override
	protected Identifiable createIdentifiable() {
		final Trigger retValue = TriggerFactory.eINSTANCE.createTrigger();
		retValue.setDublinCore(newDublinCorePage.createDublinCore());
		return retValue;
	} // createIdentifiable

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getSerializationFolderName()
	 */
	@Override
	protected String getSerializationFolderName() {
		return NewSTEMProjectWizard.TRIGGERS_FOLDER_NAME;
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getSerializationFileNameExtension()
	 */
	@Override
	protected String getSerializationFileNameExtension() {
		return TriggerPackage.eNAME;
	}

	protected static class NewTriggerPage extends NewIdentifiablePage {

		/**
		 * Default Constructor
		 */
		protected NewTriggerPage() {
			super(Messages.getString("NTriggerWiz.page_title")); //$NON-NLS-1$
			setTitle(Messages.getString("NTriggerWiz.page_title")); //$NON-NLS-1$
			setDescription(Messages.getString("NTriggerWiz.page_description")); //$NON-NLS-1$
		} // NewTriggerPage

		@Override
		protected Composite createSpecificComposite(final Composite parent) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "org.eclipse.stem.doc.newtrigger_contextid");
			return new Composite(parent, SWT.NONE);
		} // createSpecificComposite
		
		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#getDCDescription()
		 */
		@Override
		protected String getDCDescription() {
			// Leave description/title blank
			return "";
//			return MessageFormat.format(Messages
//					.getString("NTriggerWiz.DC_DESCRIPTION"),
//					new Object[] { serializationFileNameField.getText() });
		} // getDCDescription

	} // NewTriggerPage

	/**
	 * This class is a {@link IHandler} for the command that creates a
	 * {@link NewTriggerWizard}
	 */
	public static class NewTriggerWizardCommandHandler extends AbstractHandler
			implements IHandler {

		/**
		 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
		 */
		public Object execute(final ExecutionEvent executionEvent)
				throws ExecutionException {
			final IWorkbenchWindow window = HandlerUtil
					.getActiveWorkbenchWindowChecked(executionEvent);
			final NewTriggerWizard wizard = new NewTriggerWizard();
			wizard.init(window.getWorkbench(), StructuredSelection.EMPTY);
			final WizardDialog wizardDialog = new STEMWizardDialog(window
					.getShell(), wizard);
			wizardDialog.open();
			return null;
		} // execute
	} // NewTriggerWizardCommandHandler
	
} // NewTriggerWizard