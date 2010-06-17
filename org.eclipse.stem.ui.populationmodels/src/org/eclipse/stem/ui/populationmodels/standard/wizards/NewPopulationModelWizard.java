// NewDiseaseWizard.java
package org.eclipse.stem.ui.populationmodels.standard.wizards;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
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
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.ui.wizards.DublinCorePage;
import org.eclipse.stem.ui.wizards.NewIdentifiablePage;
import org.eclipse.stem.ui.wizards.NewIdentifiableWizard;
import org.eclipse.stem.ui.wizards.NewSTEMProjectWizard;
import org.eclipse.stem.ui.wizards.STEMWizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This class is a Wizard for making new STEM {@link DiseaseModel} instances.
 */
public class NewPopulationModelWizard extends NewIdentifiableWizard {

	private NewPopulationModelPage ndp = null;

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getWizardTitle()
	 */
	@Override
	protected String getWizardTitle() {
		return PopulationModelWizardMessages.getString("NPopulationModelWiz.wizard_title"); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createNewIdentifiablePage()
	 */
	@Override
	protected NewIdentifiablePage createNewIdentifiablePage() {
		ndp = new NewPopulationModelPage(PopulationModelWizardMessages
				.getString("NPopulationModelWiz.page_title")); //$NON-NLS-1$
		ndp.setTitle(PopulationModelWizardMessages.getString("NPopulationModelWiz.page_title")); //$NON-NLS-1$
		ndp.setDescription(PopulationModelWizardMessages
				.getString("NPopulationModelWiz.page_description")); 
		this.setHelpContextId("org.eclipse.stem.doc.newpopulation_contextid");
		return ndp;
	} // createNewIdentifiablePage

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createDublinCorePage()
	 */
	@Override
	protected DublinCorePage createDublinCorePage() {
		return new DublinCorePage() {
			/**
			 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.DublinCorePage#initializeDCFields()
			 */
			@Override
			protected void initializeDCAttributes() {
				super.initializeDCAttributes();
				format.setText(StandardPackage.eNS_URI);
				format.setEnabled(false);
				type.setText(STEMURI.createTypeURI(
						PopulationModel.URI_TYPE_POPULATIONMODEL_SEGMENT).toString());
				type.setEnabled(false);
			}
		}; // DublinCorePage
	} // createDublinCorePage

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createIdentifiable()
	 */
	@Override
	protected Identifiable createIdentifiable() {
		final PopulationModel retValue = ndp.getSelectedPopulationModel();
		retValue.setDublinCore(newDublinCorePage.createDublinCore());
		return retValue;
	} // createSpecificIdentifiable

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getSerializationFolderName()
	 */
	@Override
	protected String getSerializationFolderName() {
		return NewSTEMProjectWizard.DECORATORS_FOLDER_NAME;
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getSerializationFileNameExtension()
	 */
	@Override
	protected String getSerializationFileNameExtension() {
		return StandardPackage.eNAME;
	} // getIdentifiableSerializationFileExtension

	protected static class NewPopulationModelPage extends NewIdentifiablePage {

		PopulationModelDefinitionControl ddc = null;

		/**
		 * @param pageName
		 */
		protected NewPopulationModelPage(final String pageName) {
			super(pageName);
		}

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#getDCDescription()
		 */
		@Override
		protected String getDCDescription() {
			return MessageFormat.format(PopulationModelWizardMessages
					.getString("NPopulationWiz.DC_DESCRIPTION"), //$NON-NLS-1$
					new Object[] { serializationFileNameField.getText() });
		} // getDCDescription

		@Override
		protected Composite createSpecificComposite(final Composite parent) {
			ddc = new PopulationModelDefinitionControl(parent, SWT.NONE,
					projectValidator, super.getSelectedProject());
			return ddc;
		} // createSpecificComposite

		@Override
		protected boolean validatePage() {
			boolean retValue = super.validatePage();
			if (retValue) {
				setErrorMessage(null);
				retValue = ddc.validate();
				// Error?
				if (!retValue) {
					// Yes
					setErrorMessage(ddc.getErrorMessage());
				} // if
			}
			return retValue;
		} // validatePage

		PopulationModel getSelectedPopulationModel() {
			return ddc.getSelectedPopulationModel();
		} // getSelectedDiseaseModel

	} // NewDiseasePage

	/**
	 * This class is a {@link IHandler} for the command that creates a
	 * {@link NewPopulationModelWizard}
	 */
	public static class NewPopulationModelWizardCommandHandler extends AbstractHandler
			implements IHandler {

		/**
		 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
		 */
		public Object execute(final ExecutionEvent executionEvent)
				throws ExecutionException {
			final IWorkbenchWindow window = HandlerUtil
					.getActiveWorkbenchWindowChecked(executionEvent);
			final NewPopulationModelWizard wizard = new NewPopulationModelWizard();
			wizard.init(window.getWorkbench(), StructuredSelection.EMPTY);
			final WizardDialog wizardDialog = new STEMWizardDialog(window
					.getShell(), wizard);
			wizardDialog.open();
			return null;
		} // execute
	} // NewDiseaseWizardCommandHandler
} // NewDiseaseWizard
