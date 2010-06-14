// NewScenarioWizard.java
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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.solver.Solver;
import org.eclipse.stem.core.solver.SolverPropertyComposite;
import org.eclipse.stem.ui.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This class is a {@link NewIdentifiableWizard} for that creates new STEM
 * {@link Scenario}s.
 */
public class NewScenarioWizard extends NewIdentifiableWizard {

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getWizardTitle()
	 */
	@Override
	protected String getWizardTitle() {
		return Messages.getString("NScenarioWiz.wizard_title"); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createNewIdentifiablePage()
	 */
	@Override
	protected NewIdentifiablePage createNewIdentifiablePage() {
		return new NewScenarioPage();
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
				format.setText(ScenarioPackage.eNS_URI);
				format.setEnabled(false);
				type.setText(STEMURI.SCENARIO_TYPE_URI.toString());
				type.setEnabled(false);
			}
		};
	} // createDublinCorePage

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createIdentifiable()
	 */
	@Override
	protected Identifiable createIdentifiable() {
		final Scenario retValue = ScenarioFactory.eINSTANCE.createScenario();
		retValue.setDublinCore(newDublinCorePage.createDublinCore());
		SolverPropertyComposite spc = ((NewScenarioPage)newIdentifiablePage).solverPC;
		Solver s = spc.createSolver();
		retValue.setSolver(s);
		return retValue;
	} // createSpecificIdentifiable

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getSerializationFolderName()
	 */
	@Override
	protected String getSerializationFolderName() {
		return NewSTEMProjectWizard.SCEANARIOS_FOLDER_NAME;
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getSerializationFileNameExtension()
	 */
	@Override
	protected String getSerializationFileNameExtension() {
		return ScenarioPackage.eNAME;
	}

	protected static class NewScenarioPage extends NewIdentifiablePage {

		private Solver [] solvers = null;
		
		SolverPropertyComposite solverPC;
		
		private Combo combo;
		/**
		 * Default Constructor
		 */
		protected NewScenarioPage() {
			super(Messages.getString("NScenarioWiz.page_title")); //$NON-NLS-1$
			setTitle(Messages.getString("NScenarioWiz.page_title")); //$NON-NLS-1$
			setDescription(Messages.getString("NScenarioWiz.page_description")); //$NON-NLS-1$
		} // NewScenarioPage

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#createSpecificComposite(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected Composite createSpecificComposite(final Composite parent) {

			Solver [] solvers = getSolvers();
			
			final Composite composite = new Composite(parent, SWT.NONE);

			
			final GridLayout gridLayout = new GridLayout();
			gridLayout.marginWidth = 0;
			gridLayout.numColumns = 1;
			composite.setLayout(gridLayout);

			final Label solverLabel = new Label(composite, SWT.NONE);
			final GridData gd_solverLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
			gd_solverLabel.widthHint = 100;
			solverLabel.setLayoutData(gd_solverLabel);
			solverLabel.setText(Messages.getString("NScenarioWiz.solver")); //$NON-NLS-1$

			combo = new Combo(composite, SWT.READ_ONLY);
			combo.setTextLimit(30);
			final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true,
					false);
			gd_combo.widthHint = 303;
			combo.setLayoutData(gd_combo);

			combo.setToolTipText(Messages.getString("NScenarioWiz.solver")); //$NON-NLS-1$
			// Initialize the list of disease models available
			combo.setItems(getSolverNames(solvers));
			// Set the one from preferences
			
			final NewScenarioPage self = this;
			combo.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					self.displaySolver(getSolvers()[combo
									.getSelectionIndex()]);
					// layout();
				} // widgetSelected
			});
			
			combo.select(0);
			combo.addModifyListener(projectValidator);

			solverPC = new SolverPropertyComposite(composite, 1, solvers, projectValidator);
	
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "org.eclipse.stem.doc.newscenario_contextid");
			
			return composite;
		} // createSpecificComposite
		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#getDCDescription()
		 */
		@Override
		protected String getDCDescription() {
			return MessageFormat.format(Messages
					.getString("NScenarioWiz.DC_DESCRIPTION"),
					new Object[] { serializationFileNameField.getText() });
		} // getDCDescription

		/**
		 * 
		 */
		
		private org.eclipse.stem.core.solver.Solver [] getSolvers() {
			final Preferences preferences = org.eclipse.stem.ui.Activator.getDefault().getPluginPreferences();
			String prefSolver = preferences.getString(org.eclipse.stem.ui.preferences.PreferenceConstants.DEFAULT_SOLVER);
			
			if (solvers == null) {
				final IExtensionRegistry registry = Platform.getExtensionRegistry();
				final IConfigurationElement[] solverConfigElements = registry
						.getConfigurationElementsFor(org.eclipse.stem.core.Constants.ID_SOLVER_EXTENSION_POINT);

				final List<Solver> temp = new ArrayList<Solver>();

				solvers = new Solver[solverConfigElements.length];

				for (int i = 0; i < solverConfigElements.length; i++) {
					final IConfigurationElement element = solverConfigElements[i];
					// Does the element specify the class of the disease model?
					if (element.getName().equals(Constants.SOLVER_ELEMENT)) {
						// Yes
						try {
							Solver s = (Solver) element.createExecutableExtension("class");
								
							if(s.getClass().getName().equals(prefSolver)&& i > 0) {
									// Set the preference one on top
									Solver tmp = temp.get(0);
									temp.set(0, s);
									temp.add(tmp);
							} else
							temp.add(s); //$NON-NLS-1$
						} catch (final CoreException e) {
							Activator.logError(
									"Can't create solver", e); //$NON-NLS-1$
						}
					} // if
				} // for each configuration element

				solvers = temp.toArray(new Solver[] {});
			} // if disesaeModels not created

			return solvers;
		}

		/**
		 * @return the names of the solvers
		 */
		private String[] getSolverNames(final Solver[] solvers) {
			final Preferences preferences = org.eclipse.stem.ui.Activator.getDefault().getPluginPreferences();
			String prefSolver = preferences.getString(org.eclipse.stem.ui.preferences.PreferenceConstants.DEFAULT_SOLVER);
			
			final String[] retValue = new String[solvers.length];
			String firstOne = null;
			for (int i = 0; i < solvers.length; i++) {
				String name = solvers[i].getDublinCore().getTitle();
				// Was a name specified?
				if ((name == null) || name.equals("")) { //$NON-NLS-1$
					// No
					name = solvers[i].getClass().getSimpleName();
				} // if
				if(solvers[i].getClass().getName().equals(prefSolver)&& i > 0) {
					// Set the preference one on top
					String tmp = retValue[0];
					retValue[0] = name;
					retValue[i] = tmp;
				}
				else retValue[i] = name;
			} // for i
			return retValue;
		} // getDiseaseModelNames
		
		void displaySolver(final Solver solver) {
			solverPC.displaySolver(solver);
		} // displaySolver
	} // NewScenarioPage

	/**
	 * This class is a {@link IHandler} for the command that creates a
	 * {@link NewScenarioWizard}
	 */
	public static class NewScenarioWizardCommandHandler extends AbstractHandler
			implements IHandler {

		/**
		 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
		 */
		public Object execute(final ExecutionEvent executionEvent)
				throws ExecutionException {
			final IWorkbenchWindow window = HandlerUtil
					.getActiveWorkbenchWindowChecked(executionEvent);
			final NewScenarioWizard wizard = new NewScenarioWizard();
			wizard.init(window.getWorkbench(), StructuredSelection.EMPTY);
			final WizardDialog wizardDialog = new WizardDialog(window
					.getShell(), wizard);
			wizardDialog.open();
			return null;
		} // execute
	} // NewScenarioWizardCommandHandler
} // NewScenarioWizard
