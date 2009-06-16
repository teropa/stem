// NewInfectorWizard.java
package org.eclipse.stem.ui.wizards;

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
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.impl.SIRInoculatorImpl;
import org.eclipse.stem.data.geography.GeographicNames;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This class represents
 */
public class NewInfectorWizard extends NewIdentifiableWizard {

	private NewInfectorPage nip = null;

	/**
	 * Constructor
	 */
	public NewInfectorWizard() {
		// Nothing
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getWizardTitle()
	 */
	@Override
	protected String getWizardTitle() {
		return DiseaseWizardMessages.getString("NInfectorWiz.wizard_title"); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createNewIdentifiablePage()
	 */
	@Override
	protected NewIdentifiablePage createNewIdentifiablePage() {
		nip = new NewInfectorPage(DiseaseWizardMessages.getString("NInfectorWiz.page_title")); //$NON-NLS-1$
		nip.setTitle(DiseaseWizardMessages.getString("NInfectorWiz.page_title")); //$NON-NLS-1$
		nip.setDescription(DiseaseWizardMessages.getString("NInfectorWiz.page_description")); //$NON-NLS-1$

		return nip;
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
				// type.setText("undefined");
				// type.setText(STEMURI.SCENARIO_TYPE_URI.toString());
				type.setEnabled(false);
			}
		}; // DublinCorePage
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createIdentifiable()
	 */
	@Override
	protected Identifiable createIdentifiable() {
		final Infector retValue = nip.getInfector();
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
	}

	protected static class NewInfectorPage extends NewIdentifiablePage {

		private InfectorDefinitionComposite idc;

		/**
		 * @param pageName
		 */
		protected NewInfectorPage(String pageName) {
			super(pageName);
		}

		/**
		 * @return
		 */
		public Infector getInfector() {
			SIInfector retValue = null;
			if(idc.isInfectorMode()) {
				retValue = StandardFactory.eINSTANCE.createSIInfector();
			} else {
				retValue = StandardFactory.eINSTANCE.createSIRInoculator();
			}
			retValue.setDiseaseName(idc.getDiseaseName());
			retValue.setPopulationIdentifier(idc.getPopulation());
			retValue.setTargetISOKey(idc.getIsoKey());
			if(idc.isInfectorMode()) {
				retValue.setInfectiousCount(idc.getNumberOfInfections());
			} else {
				((SIRInoculatorImpl) retValue).setInoculatedPercentage(idc.getPercentToInoculate());
				// just to be sure - since this is NOT and Infector
				retValue.setInfectiousCount(0.0);
			}
			return retValue;
		} // getInfector

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#getDCDescription()
		 */
		@Override
		protected String getDCDescription() {
			if(idc.isInfectorMode()) {
				return MessageFormat.format(DiseaseWizardMessages.getString("NInfectorWiz.DC_DESCRIPTION"), //$NON-NLS-1$
						new Object[] { Double.valueOf(idc.getNumberOfInfections()),
										idc.getPopulation(), 
										idc.getDiseaseName(),
										GeographicNames.getReverseHierarchyName(idc.getIsoKey()), idc.getIsoKey() 
										});
			} 
			// else inoculator
			return MessageFormat.format(DiseaseWizardMessages.getString("NInfectorWiz.DC_DESCRIPTION2"), //$NON-NLS-1$
					new Object[] { Double.valueOf(idc.getPercentToInoculate()),
									idc.getPopulation(), 
									idc.getDiseaseName(),
									GeographicNames.getReverseHierarchyName(idc.getIsoKey()), idc.getIsoKey() 
									});
			
		} // getDCDescription

		@Override
		protected Composite createSpecificComposite(final Composite parent) {
			idc = new InfectorDefinitionComposite(parent, SWT.NONE,
					projectValidator);
			return idc;
		} // createSpecificComposite

		@Override
		protected boolean validatePage() {
			boolean retValue = super.validatePage();
			if (retValue) {
				setErrorMessage(null);
				retValue = idc.validate();
				// Error?
				if (!retValue) {
					// Yes
					setErrorMessage(idc.getErrorMessage());
				} // if
			}
			return retValue;
		} // validatePage
	} // NewInfectorPage

	/**
	 * This class is a {@link IHandler} for the command that creates a
	 * {@link NewInfectorWizard}
	 */
	public static class NewInfectorWizardCommandHandler extends AbstractHandler
			implements IHandler {

		/**
		 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
		 */
		public Object execute(final ExecutionEvent executionEvent)
				throws ExecutionException {
			final IWorkbenchWindow window = HandlerUtil
					.getActiveWorkbenchWindowChecked(executionEvent);
			final NewInfectorWizard wizard = new NewInfectorWizard();
			wizard.init(window.getWorkbench(), StructuredSelection.EMPTY);
			final WizardDialog wizardDialog = new WizardDialog(window
					.getShell(), wizard);
			wizardDialog.open();
			return null;
		} // execute
	} // NewInfectorWizardCommandHandler
} // NewInfectorWizard