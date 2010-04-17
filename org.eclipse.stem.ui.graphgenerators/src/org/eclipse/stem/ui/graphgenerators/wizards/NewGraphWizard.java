// NewGraphWizard.java
package org.eclipse.stem.ui.graphgenerators.wizards;

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
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.ui.wizards.DublinCorePage;
import org.eclipse.stem.ui.wizards.NewIdentifiablePage;
import org.eclipse.stem.ui.wizards.NewIdentifiableWizard;
import org.eclipse.stem.ui.wizards.NewSTEMProjectWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This class is a {@link NewIdentifiableWizard} for that creates new STEM
 * {@link Graph}s.
 */
public class NewGraphWizard extends NewIdentifiableWizard {

	private NewGraphPage ngp = null;

	
	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getWizardTitle()
	 */
	@Override
	protected String getWizardTitle() {
		return Messages.getString("NGraphWiz.wizard_title"); //$NON-NLS-1$
	} // getWizardTitle

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createNewIdentifiablePage()
	 */
	@Override
	protected NewIdentifiablePage createNewIdentifiablePage() {
		ngp = new NewGraphPage(Messages
				.getString("NGraphWiz.page_title")); //$NON-NLS-1$
		ngp.setTitle(Messages.getString("NGraphWiz.page_title")); //$NON-NLS-1$
		ngp.setDescription(Messages
				.getString("NGraphWiz.page_description")); //$NON-NLS-1$

		return ngp;

	} // createNewIdentifiablePage

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createDublinCorePage()
	 */
	@Override
	protected DublinCorePage createDublinCorePage() {
		return new DublinCorePage() {
			@Override
			protected void initializeDCAttributes() {
				super.initializeDCAttributes();
				format.setText(GraphPackage.eNS_URI);
				format.setEnabled(false);
				type.setText(STEMURI.GRAPH_TYPE_URI.toString());
				type.setEnabled(false);
			}
		};
	} // createDublinCorePage

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createIdentifiable()
	 */
	@Override
	protected Identifiable createIdentifiable() {
		final Graph retValue = ngp.getGraph();
		retValue.setDublinCore(newDublinCorePage.createDublinCore());
		return retValue;
	} // createIdentifiable

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getSerializationFolderName()
	 */
	@Override
	protected String getSerializationFolderName() {
		return NewSTEMProjectWizard.GRAPHS_FOLDER_NAME;
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getSerializationFileNameExtension()
	 */
	@Override
	protected String getSerializationFileNameExtension() {
		return GraphPackage.eNAME;
	} // getSerializationFileNameExtension

	/**
	 * This class is a {@link NewIdentifiablePage} that contains the interface
	 * components needed to define a new {@link Graph}.
	 */
	protected static class NewGraphPage extends NewIdentifiablePage {

		GraphGeneratorDefinitionControl ggdc = null;

		/**
		 * @param pageName
		 */
		protected NewGraphPage(final String pageName) {
			super(pageName);
		}

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#getDCDescription()
		 */
		@Override
		protected String getDCDescription() {
			return MessageFormat.format(Messages
					.getString("NGGWiz.DC_DESCRIPTION"), //$NON-NLS-1$
					new Object[] { serializationFileNameField.getText() });
		} // getDCDescription

		@Override
		protected Composite createSpecificComposite(final Composite parent) {
			ggdc = new GraphGeneratorDefinitionControl(parent, SWT.NONE,
					projectValidator);
			return ggdc;
		} // createSpecificComposite

		@Override
		protected boolean validatePage() {
			boolean retValue = super.validatePage();
			if (retValue) {
				setErrorMessage(null);
				retValue = ggdc.validate();
				// Error?
				if (!retValue) {
					// Yes
					setErrorMessage(ggdc.getErrorMessage());
				} // if
			}
			return retValue;
		} // validatePage

		Graph getGraph() {
			return ggdc.getGraph();
		} // getSelectedDiseaseModel

	} // NewGraphPage

	
	
	/**
	 * This class is a {@link IHandler} for the command that creates a
	 * {@link NewGraphWizard}
	 */
	public static class NewGraphWizardCommandHandler extends AbstractHandler
			implements IHandler {

		/**
		 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
		 */
		public Object execute(final ExecutionEvent executionEvent)
				throws ExecutionException {
			final IWorkbenchWindow window = HandlerUtil
					.getActiveWorkbenchWindowChecked(executionEvent);
			final NewGraphWizard wizard = new NewGraphWizard();
			wizard.init(window.getWorkbench(), StructuredSelection.EMPTY);
			final WizardDialog wizardDialog = new WizardDialog(window
					.getShell(), wizard);
			wizardDialog.open();
			return null;
		} // execute
	} // NewGraphWizardCommandHandler

} // NewGraphWizard
