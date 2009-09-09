package org.eclipse.stem.analysis.automaticexperiment.ui;

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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.stem.analysis.automaticexperiment.ui.NewAutomaticExperimentWizard.NewAutomaticExperimentPage2.ParameterDetails;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.STEMXMIResourceFactoryImpl;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.experiment.ExperimentPackage;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.ui.wizards.DublinCorePage;
import org.eclipse.stem.ui.wizards.NewIdentifiablePage;
import org.eclipse.stem.ui.wizards.NewIdentifiableWizard;
import org.eclipse.stem.ui.wizards.NewSTEMProjectWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import automaticexperiment.AutomaticExperiment;
import automaticexperiment.AutomaticexperimentFactory;
import automaticexperiment.AutomaticexperimentPackage;
import automaticexperiment.ModifiableParameter;

public class NewAutomaticExperimentWizard 
	extends NewIdentifiableWizard {
	
	protected NewAutomaticExperimentPage2 page2 = null;
	
	public NewAutomaticExperimentWizard() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#addPages()
	 */
	@Override
	public void addPages() {
		setForcePreviousAndNextButtons(false);
		newIdentifiablePage = createNewIdentifiablePage();
		// Were we successful in creating the page?
		if (newIdentifiablePage == null) {
			// No
			return;
		}
		page2 = createWizardPage2();
		// Were we successful in creating the page?
		if (page2 == null) {
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
		addPage(page2);
		addPage(newDublinCorePage);
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		final IWizardPage nextPage = super.getNextPage(page);
		if (nextPage instanceof NewAutomaticExperimentPage2) {
			NewAutomaticExperimentPage1 page1 = (NewAutomaticExperimentPage1)newIdentifiablePage;
			page2.setSelectedParameters(page1.parametersList.getSelection());
		}
		return nextPage;
	}

	@Override
	protected DublinCorePage createDublinCorePage() {
		return new DublinCorePage() {
			/**
			 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.DublinCorePage#initializeDCFields()
			 */
			@Override
			protected void initializeDCAttributes() {
				super.initializeDCAttributes();
				format.setText(ExperimentPackage.eNS_URI);
				format.setEnabled(false);
				type.setText(STEMURI.EXPERIMENT_TYPE_URI.toString());
				type.setEnabled(false);
			}
		};
	}

	@Override
	protected Identifiable createIdentifiable() {
		return createAutomaticExperiment();
	}

	@Override
	protected NewIdentifiablePage createNewIdentifiablePage() {
		NewAutomaticExperimentPage1 page1 = new NewAutomaticExperimentPage1(getShell(), "New Automatic Experiment Wizard"); //$NON-NLS-1$
		page1.setTitle("Title to externalize"); //$NON-NLS-1$
		page1.setDescription("Description to externalize"); //$NON-NLS-1$		
		return page1;
	}
	
	protected NewAutomaticExperimentPage2 createWizardPage2() {
		NewAutomaticExperimentPage2 page2 = new NewAutomaticExperimentPage2("New Automatic Experiment Wizard"); //$NON-NLS-1$
		page2.setTitle("Title to externalize"); //$NON-NLS-1$
		page2.setDescription("Description to externalize"); //$NON-NLS-1$		
		return page2;
	}

	@Override
	protected String getSerializationFileNameExtension() {
		return AutomaticexperimentPackage.eNAME;
	}

	@Override
	protected String getSerializationFolderName() {
		return NewSTEMProjectWizard.EXPERIMENTS_FOLDER_NAME;
	}

	@Override
	protected String getWizardTitle() {
		// TODO Externalise this string
		return "Automatic Experiment Wizard";
	}
	
	protected AutomaticExperiment createAutomaticExperiment() {
		AutomaticExperiment autoExperiment = AutomaticexperimentFactory.eINSTANCE.createAutomaticExperiment();
		autoExperiment.setDublinCore(newDublinCorePage.createDublinCore());
		final NewAutomaticExperimentPage1 page1 = (NewAutomaticExperimentPage1)newIdentifiablePage;
		String algorithmName = page1.algorithmCombo.getText();
		autoExperiment.setErrorAnalysisAlgorithm(algorithmName);
		String errorFunction = page1.errorFunctionCombo.getText();
		autoExperiment.setErrorFunction(errorFunction);
		if (!page1.numOfIterationsSpinner.getText().equals("")) {
			Long numOfIterations = new Long(page1.numOfIterationsSpinner.getText());
			autoExperiment.setMaximumNumberOfIterations(numOfIterations);
		}
		if (!page1.refDirText.getText().trim().equals("")) {
			autoExperiment.setReferanceDataDir(page1.refDirText.getText());
		}
		if (!page1.refDirText.getText().trim().equals("")) {
			Scenario scenario = createScenario(page1.scenarioText.getText());
			autoExperiment.setBaseScenario(scenario);
		}
		for (String param:page2.paramToDetailsObj.keySet()) {
			ParameterDetails details = page2.paramToDetailsObj.get(param);
			ModifiableParameter parameter = AutomaticexperimentFactory.eINSTANCE.createModifiableParameter();
			parameter.setFeatureName(param);
			parameter.setInitialValue(new Double(details.initialValueText.getText()));
			parameter.setStep(new Double(details.stepValueText.getText()));
			autoExperiment.getParameters().add(parameter);
		}
		return autoExperiment;
	}
	
	protected Scenario createScenario(final String scenarioFile) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",
				STEMXMIResourceFactoryImpl.INSTANCE);

		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put("platform",
				STEMXMIResourceFactoryImpl.INSTANCE);
		final Resource resource = resourceSet.getResource(URI.createFileURI(scenarioFile),
				true);
		try {			
			resource.load(null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scenario loadedScenario = (Scenario)resource.getContents().get(0);
		loadedScenario.initialize();
		return loadedScenario;
		//return ScenarioTest.createFixture();
	}
	
	protected static class NewAutomaticExperimentPage1 extends NewIdentifiablePage {
		
		public List parametersList = null;
		public Combo algorithmCombo = null;		
		public Combo errorFunctionCombo = null;
		public Spinner numOfIterationsSpinner = null;
		public Text refDirText = null;
		public Text scenarioText = null;
		protected Shell shell = null;
//		public NewAutomaticExperimentPage2 page2 = null;
		
		/**
		 * @param pageName
		 *            the name of the page
		 */
		protected NewAutomaticExperimentPage1(final Shell shell, final String pageName) {
			super(pageName);
			this.shell = shell;
//			page2 = new NewAutomaticExperimentPage2("Page 2");
//			page2.setPreviousPage(this);
		}

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiablePage#createSpecificComposite(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected Composite createSpecificComposite(Composite parent) {
			final Composite composite = new Composite(parent, SWT.NONE);
			final GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 3;
			composite.setLayout(gridLayout);
			
			final Label label01 = new Label(composite, SWT.NONE);
			label01.setText("Base scenario: ");
			scenarioText = new Text(composite, SWT.BORDER);
			scenarioText.setEditable(false);
			final Button button01 = new Button(composite, SWT.NONE);
			button01.setText("Select Scenario...");
			button01.addSelectionListener(new SelectionAdapter() {
				/**
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 */
				@Override
				public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {
					FileDialog fileDialog = new FileDialog(shell);
					fileDialog.setFilterExtensions(new String[] { "*." + ScenarioPackage.eNAME } );
					String workspaceDir = Platform.getInstanceLocation().getURL().getPath();
					if (workspaceDir.startsWith("/") || workspaceDir.startsWith("\\")) {
						workspaceDir = workspaceDir.substring(1);
					}
					fileDialog.setFilterPath(workspaceDir);
					String scenarioFile = fileDialog.open();
					scenarioText.setText(scenarioFile);
				}
				
			});
			
			final Label label11 = new Label(composite, SWT.NONE);
			label11.setText("Disease Model Parameters: ");
			parametersList = new List(composite, SWT.BORDER | SWT.MULTI);
			for (String name:getParametersNames()) {
				parametersList.add(name);
			}
			parametersList.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {
					setPageComplete(validatePage());
				}				
			}
			);	
			final Composite composite11 = new Composite(composite, SWT.NONE);
			composite11.setLayout(new RowLayout(SWT.VERTICAL));			
			final Button button11 = new Button(composite11, SWT.NONE);
			button11.setText("Select All");
			button11.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {
					parametersList.selectAll();
					setPageComplete(validatePage());
				}				
			}
			);			
			final Button button12 = new Button(composite11, SWT.NONE);
			button12.setText("Select None");
			button12.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {
					parametersList.deselectAll();
					setPageComplete(validatePage());
				}				
			}
			);
			
			final Label label21 = new Label(composite, SWT.NONE);
			label21.setText("Error analysis algorithm: ");			
			algorithmCombo = new Combo(composite, SWT.READ_ONLY);
			algorithmCombo.add("Nedler-Mead Algorithm");
			algorithmCombo.select(0);
			GridData gridData21 = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
			gridData21.horizontalSpan = 2;
			algorithmCombo.setLayoutData(gridData21);
			
			final Label label31 = new Label(composite, SWT.NONE);
			label31.setText("Error function: ");			
			errorFunctionCombo = new Combo(composite, SWT.READ_ONLY);
			errorFunctionCombo.add("Threshold error function");
			errorFunctionCombo.add("Simple error function");
			errorFunctionCombo.select(0);
			GridData gridData31 = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
			gridData31.horizontalSpan = 2;
			errorFunctionCombo.setLayoutData(gridData31);
			
			final Label label41 = new Label(composite, SWT.NONE);
			label41.setText("Maximum number of iterations: ");			
			numOfIterationsSpinner = new Spinner(composite, SWT.BORDER);
			GridData gridData41 = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
			gridData41.horizontalSpan = 2;
			numOfIterationsSpinner.setLayoutData(gridData41);
			
			final Label label51 = new Label(composite, SWT.NONE);
			label51.setText("Reference data directory: ");
			refDirText = new Text(composite, SWT.BORDER);
			refDirText.setEditable(false);
			final Button button51 = new Button(composite, SWT.NONE);
			button51.setText("Browse...");
			button51.addSelectionListener(new SelectionAdapter() {
				/**
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 */
				@Override
				public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {
					DirectoryDialog dirDialog = new DirectoryDialog(shell);
					String directory = dirDialog.open();
					refDirText.setText(directory);
				}
				
			});
			
			return composite;
		}
		
		private java.util.List<String> getParametersNames() {
			java.util.List<String> names = new ArrayList<String>();
			names.add("transmissionRate");
			names.add("modulationPhaseShift");
			names.add("seasonalModulationFloor");
			return names;
		}
		
		private Composite parameterValues(Composite parent, String name) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new RowLayout());
			final Label label = new Label(composite, SWT.NONE);
			label.setText("Initial value: ");
			 
			return composite;
		}

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiablePage#validatePage()
		 */
		@Override
		protected boolean validatePage() {
			setErrorMessage(null);
			if (parametersList.getSelectionCount() == 0) {
				setErrorMessage("Choose at least one parameter from the list");
				return false;
			}
			return super.validatePage();
		}

		@Override
		protected String getDCDescription() {
			return "Some description goes here";
		}
		
	}
	
	protected static class NewAutomaticExperimentPage2 
		extends WizardPage {
		
		private Map<String, ParameterDetails> paramToDetailsObj = new HashMap<String, ParameterDetails>();
		private Composite pageComposite = null; 
		
		/**
		 * @param pageName
		 *            the name of the page
		 */
		protected NewAutomaticExperimentPage2(final String pageName) {
			super(pageName);
		}

		public void createControl(Composite parent) {
			pageComposite = new Composite(parent, SWT.NONE);
			pageComposite.setLayout(new RowLayout(SWT.VERTICAL));
			
			setPageComplete(validatePage());
			parent.pack();
			setControl(pageComposite);
		}
		
		public void setSelectedParameters(final String[] selected) {
			java.util.List<String> paramsToRemove = new ArrayList<String>();
			for (final String existingParam:paramToDetailsObj.keySet()) {
				paramsToRemove.add(existingParam);
			}
			for (final String param:selected) {				
				if (!paramToDetailsObj.containsKey(param)) {
					addParamGroup(param);					
				}
				else {
					paramsToRemove.remove(param);
				}
			}
			for (final String toRemove:paramsToRemove) {
				removeParamGroup(toRemove);
			}
			pageComposite.pack(true);
		}
		
		private void addParamGroup(final String param) {
			Group group = new Group(pageComposite, SWT.NONE);
			final GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			group.setLayout(layout);
			final Label label1 = new Label(group, SWT.NONE);
			label1.setText("Initial value: ");
			final Text initialText = new Text(group, SWT.BORDER);
			final Label label2 = new Label(group, SWT.NONE);
			label2.setText("Step value: ");
			final Text stepText = new Text(group, SWT.BORDER);
			final Label label3 = new Label(group, SWT.NONE);
			label3.setText("Upperbound value: ");
			final Text upperboundText = new Text(group, SWT.BORDER);
			group.setText(param);
			
			ParameterDetails paramDetails = new ParameterDetails();
			paramDetails.group = group;
			paramDetails.initialValueText = initialText;
			paramDetails.stepValueText = stepText;
			paramDetails.upperboundValueText = upperboundText;			
			paramToDetailsObj.put(param, paramDetails);			
		}
		
		private void removeParamGroup(final String param) {
			ParameterDetails paramDetails = paramToDetailsObj.remove(param);
			Group group = paramDetails.group;
			group.dispose();
		}		
		
		protected boolean validatePage() {
			return true;
		}
		
		protected static class ParameterDetails {
			public Group group = null;
			public Text initialValueText = null;
			public Text stepValueText = null;
			public Text upperboundValueText = null;
		}
	}
	
	/**
	 * This class is a {@link IHandler} for the command that creates a
	 * {@link NewAutomaticExperimentWizard}
	 */
	public static class NewAutomaticExperimentWizardCommandHandler extends AbstractHandler
			implements IHandler {

		/**
		 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
		 */
		public Object execute(final ExecutionEvent executionEvent)
				throws ExecutionException {
			final IWorkbenchWindow window = HandlerUtil
					.getActiveWorkbenchWindowChecked(executionEvent);
			final NewAutomaticExperimentWizard wizard = new NewAutomaticExperimentWizard();
			wizard.init(window.getWorkbench(), StructuredSelection.EMPTY);
			final WizardDialog wizardDialog = new WizardDialog(window
					.getShell(), wizard);
			wizardDialog.open();
			return null;
		} // execute
	}
}
