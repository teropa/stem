// NewIdentifiableWizard.java
package org.eclipse.stem.ui.wizards;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.presentation.CoreEditorAdvisor;
import org.eclipse.stem.core.experiment.ExperimentPackage;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.ui.Activator;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * This class is the super class for the {@link Wizard}s that create
 * {@link Identifiable}s. The basic {@link Identifiable} wizard contains two
 * {@link WizardPage}s. The first is a subclass instance of the abstract class
 * {@link NewIdentifiablePage} and the second is an instance of
 * {@link DublinCorePage}. The {@link NewIdentifiablePage} implements the
 * template pattern by creating an overall structure for the page that is filled
 * in by the results of calls to abstract methods implemented by the subclasses.
 * 
 * @see org.eclipse.stem.core.common.Identifiable
 * @see org.eclipse.stem.core.graph.Graph
 * @see org.eclipse.stem.core.model.Model
 * @see org.eclipse.stem.core.scenario.Scenario
 */
abstract public class NewIdentifiableWizard extends Wizard implements
		INewWizard {

	/**
	 * The wizard's link to the {@link IWorkbench}.
	 */
	private IWorkbench workbench;

	/**
	 * The first page in the wizard that a user uses to specify the details of a
	 * new {@link Identifiable} to be created.
	 * 
	 * @see #newDublinCorePage
	 */
	protected NewIdentifiablePage newIdentifiablePage = null;

	/**
	 * The second page in the wizard that a user uses to specify the details of
	 * the {@link DublinCore} metadata associated with the {@link Identifiable}
	 * being created.
	 * 
	 * @see #newIdentifiablePage
	 */
	protected DublinCorePage newDublinCorePage;

	/**
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(final IWorkbench workbench,
			@SuppressWarnings("unused") final IStructuredSelection selection) {
		this.workbench = workbench;
		setWindowTitle(getWizardTitle());
	} // init

	/**
	 * Create the {@link Wizard}'s pages.
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		setForcePreviousAndNextButtons(false);
		newIdentifiablePage = createNewIdentifiablePage();
		// Were we successful in creating the page?
		if (newIdentifiablePage == null) {
			// No
			return;
		}
		newDublinCorePage = createDublinCorePage();
		// Were we successful in creating the page?
		if (newDublinCorePage == null) {
			// No
			return;
		}
		addPage(newIdentifiablePage);
		addPage(newDublinCorePage);
	} // addPages

	/**
	 * @param page
	 *            the {@link IWizardPage} page currently being displayed.
	 * @return the next {@link IWizardPage} to be displayed to the user.
	 */
	@Override
	public IWizardPage getNextPage(final IWizardPage page) {
		final IWizardPage nextPage = super.getNextPage(page);
		// Dublin Core next?
		if (nextPage instanceof DublinCorePage) {
			// Yes
			// We pre-populate some of the fields in the DublinCore page with
			// values obtained from the newIdentifaiblePage that the user has
			// just completed. The exact details are specific to the type of
			// Identifiable being created.
			final DublinCorePage dcPage = (DublinCorePage) nextPage;
			dcPage.title.setText(newIdentifiablePage.getDCTitle());
			dcPage.description.setText(newIdentifiablePage.getDCDescription());
			dcPage.valid.setText(newIdentifiablePage.getDCValidDateRange());
		} // if DublinCorePage

		return nextPage;
	} // getNextPage

	/**
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		// This is executed when the user clicks on the "Finish" button of the
		// wizard. It uses the details in the two pages (newIdentifiablePage and
		// newDublinCorePage) to create the Identifiable. It serializes the
		// Identifiable in a file in the project that was selected on the
		// newIdentifablePage.
		final boolean retValue = true;
		try {
			// The fileURI specifies where the Identifiable will be serialized
			final URI serializationURI = createSerializationURI();

			// Creating the Identifiable can potentially take a while so we
			// wrap the call to createIdentifable in an "operation" so that it
			// can be run in the background.
			final WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
				@Override
				protected void execute(final IProgressMonitor monitor) {
					createIdentifiable(
							monitor == null ? new NullProgressMonitor()
									: monitor, serializationURI);
				} // execute
			}; // WorkspaceModifyOperation

			// The container is a IRunnableContext, we use it to execute the
			// operation we created above. The first argument of false indicates
			// not to "fork", the second of "true" indicates that the operation
			// is cancelable.
			getContainer().run(false, true, op);

			// Refresh the project so that the new serialized file will display
			try {
				newIdentifiablePage.getSelectedProject().refreshLocal(
						IResource.DEPTH_INFINITE, null);
			} catch (final CoreException e) {
				// Ignore
			}
			// Now open up the appropriate editor for the new Identifiable.
			return CoreEditorAdvisor.openEditor(workbench, CommonPlugin
					.asLocalURI(serializationURI));
		} // try
		catch (final InvocationTargetException e) {
			Activator.logError(Activator.PLUGIN_ID, e);
		} catch (final InterruptedException e) {
			// This gets thrown if the operation is canceled
			Activator.logInformation(Activator.PLUGIN_ID, e);
		}
		return retValue;

	} // performFinish

	/**
	 * Create the specific {@link Identifiable} as specified by the contents of
	 * the wizard pages and serialize it in the file specified by the
	 * {@link URI} returned by {@link #createSerializationURI()}.
	 * 
	 * @param monitor
	 *            a {@link IProgressMonitor} to use to report our progress
	 * @param serializationURI
	 *            the {@link URI} of the serialization file
	 * @see #performFinish()
	 */
	void createIdentifiable(IProgressMonitor monitor, final URI serializationURI) {
		// Was a progress monitor specified?
		if (monitor == null) {
			// No
			monitor = new NullProgressMonitor();
		}

		monitor.beginTask(Messages.getString("NIdWiz.creating"), 100); //$NON-NLS-1$
		try {
			// Create the Identifiable from the contents of the Wizard
			// Pages.
			final Identifiable identifiable = createIdentifiable();
			identifiable.setURI(serializationURI);
			assert identifiable.sane();

			Utility.serializeIdentifiable(identifiable, serializationURI);
		} catch (final IOException e) {
			Activator.logError(Messages.getString("NIdWiz.saveErr"), e); //$NON-NLS-1$
		} catch (final Exception e) {
			Activator.logError(Messages.getString("NIdWiz.saveErr"), e); //$NON-NLS-1$
		} finally {
			monitor.done();
		}
	} // createIdentifiable

	/**
	 * Create the {@link URI} to be used to serialize the {@link Identifiable}
	 * created in {@link #performFinish()}. The path in the {@link URI} will
	 * place the serialization file into the project returned by
	 * {@link #getSelectedProject()}. The name of the folder in the project is
	 * supplied by {@link #getSerializationFolderName()} which is overridden by
	 * a subclass. The name of the file and the file extension are provided by
	 * the methods {@link #getSerializationFileName()} and
	 * {@link #getSerializationFileNameExtension()}, both of which are
	 * implemented by a subclass.
	 * 
	 * @return the {@link URI} that will be used to serialize the
	 *         {@link Identifiable} created in {@link #performFinish()}.
	 * 
	 * @see #createIdentifiable(IProgressMonitor, URI)
	 */
	private URI createSerializationURI() {

		final StringBuilder sb = new StringBuilder(newIdentifiablePage
				.getSelectedProject().getName());
		sb.append("/"); //$NON-NLS-1$
		sb.append(getSerializationFolderName());
		sb.append("/"); //$NON-NLS-1$
		sb.append(getSerializationFileName());
		sb.append("."); //$NON-NLS-1$
		sb.append(getSerializationFileNameExtension());

		return URI.createPlatformResourceURI(sb.toString(), true);
	} // createSerializationURI

	/**
	 * @return the name of the serialization file for the {@link Identifiable}
	 *         entered by the user on {@link #newIdentifiablePage}.
	 */
	private String getSerializationFileName() {
		return newIdentifiablePage.serializationFileNameField.getText();
	} // getSerializationFileName

	/**
	 * @return the title of the Wizard for use as the title of the window.
	 */
	abstract protected String getWizardTitle();

	/**
	 * This method is implemented by subclasses to create a {@link WizardPage}
	 * that is specific to the type of {@link Identifiable} that is being
	 * created.
	 * 
	 * @return the page used to specify the new {@link Identifiable} to create.
	 * @see #createDublinCorePage()
	 */
	abstract protected NewIdentifiablePage createNewIdentifiablePage();

	/**
	 * This method is implemented by subclasses to create a
	 * {@link DublinCorePage} that is specific to the type of
	 * {@link Identifiable} that is being created. Typically, the method will
	 * create a {@link DublinCorePage} with some of the fields pre-populated
	 * with values specific to the {@link Identifiable}.
	 * 
	 * @return a pre-populated {@link DublinCorePage}.
	 * @see #createNewIdentifiablePage()
	 */
	abstract protected DublinCorePage createDublinCorePage();

	/**
	 * This method is implemented by subclasses to create the specific type of
	 * {@link Identifiable} that the {@link #newIdentifiablePage} that they
	 * returned from {@link #createNewIdentifiablePage()} specifies.
	 * 
	 * @return the specific type of {@link Identifiable} created by a subclasses
	 *         of this class.
	 */
	abstract protected Identifiable createIdentifiable();

	/**
	 * @return the name of the folder under the selected project that the
	 *         {@link Identifiable} created by
	 *         {@link #createIdentifiable(IProgressMonitor, URI)} should be
	 *         serialized in.
	 * @see #getSelectedProject()
	 * @see #createSerializationURI()
	 */
	abstract protected String getSerializationFolderName();

	/**
	 * @return the file extension of the serialization file of the
	 *         {@link Identifiable} created by
	 *         {@link #createIdentifiable(IProgressMonitor, URI)}. Typically,
	 *         this is the EMF "eNAME" of the model in which the
	 *         {@link Identifiable} is defined.
	 * @see GraphPackage#eNAME
	 * @see ModelPackage#eNAME
	 * @see ScenarioPackage#eNAME
	 * @see ExperimentPackage#eNAME
	 */
	abstract protected String getSerializationFileNameExtension();

	/**
	 * Run the Wizard from an Action
	 */
	abstract protected static class NewIdentifiableWizardAction extends
			WorkbenchWindowActionDelegate {
		protected void run(final NewIdentifiableWizard wizard) {
			wizard.init(getWindow().getWorkbench(), StructuredSelection.EMPTY);
			final WizardDialog wizardDialog = new WizardDialog(getWindow()
					.getShell(), wizard);
			wizardDialog.open();
		} // run
	} // NewIdentifiableWizardAction

} // NewIdentifiableWizard
