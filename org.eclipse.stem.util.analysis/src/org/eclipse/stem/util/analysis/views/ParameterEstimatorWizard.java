package org.eclipse.stem.util.analysis.views;

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


import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.stem.analysis.DiseaseType;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl;
import org.eclipse.stem.analysis.util.CSVscenarioLoader;
import org.eclipse.stem.util.analysis.ParameterEstimatorMethod;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;

/**
 * A wizard for selecting a scenario folder and a parameter estimator
 * 
 */
public class ParameterEstimatorWizard extends Wizard {
	/**
	 * This page is for selecting scenario folder
	 */
	protected ParameterEstimatorWizardSelectFolderPage selectFolderPage;

	/**
	 * This page is for selecting which parameter estimator to apply
	 */
	protected ParameterEstimatorWizardSelectEstimatorPage selectEstimatorPage;

	/**
	 * Remember the workbench during initialization.
	 */
	protected IWorkbench workbench;
	
	/**
	 * Selection, i.e. the selected widget that opened the wizard
	 */
	
	IStructuredSelection selection;
	
	/**
	 * The Estimator Control. We use it to update fields indicating
	 * the current folder/estimator
	 * 
	 */
	
	EstimatorControl estimatorControl;
	
	/**
	 * When the wizard is complete, we have loaded data into
	 * this map 
	 */
	
	ReferenceScenarioDataMapImpl referenceScenarioDataMap;
	
	/**
	 * When the wizard is complete, we have selected a
	 * parameter estimator method
	 */
	
	public ParameterEstimatorMethod parameterEstimatorMethod;
	
	private String initDir = null;
	
	/**
	 * Constructor
	 * 
	 * @param ctrl EstimatorControl
	 * @param initDir Initial directory
	 */
	
	public ParameterEstimatorWizard(EstimatorControl ctrl, String initDir) {
		this.estimatorControl = ctrl;
		this.initDir = initDir;
		this.setForcePreviousAndNextButtons(true);
	}
	
	/**
	 * Initialize
	 * 
	 * @param workbench
	 * @param selection Selection 
	 */
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("Create Parameter Estimator"); //$NON-NLS-1$
	}

	/**
	 * Done selecting parameter estimator
	 * 
	 * @return boolean
	 */

	public boolean performFinish() {
		EstimatorControl.text1.setText(selectFolderPage.getDirName());
		EstimatorControl.estimatorText.setText(this.parameterEstimatorMethod.getName());
		estimatorControl.enableAnalysis(true);
		return true;
	}

	/**
	 * getReferenceScenarioDataMap. Return the reference scenario data map
	 *  
	 * @return ReferenceScenarioDataMap
	 */
	
	public ReferenceScenarioDataMapImpl getReferenceScenarioDataMap() {return this.referenceScenarioDataMap;}
	
	/**
	 * getParameterEstimator. Return the parameter estimator method selected
	 *  
	 * @return ParameterEstimator
	 */
	
	public ParameterEstimatorMethod getParameterEstimatorMethod() {return this.parameterEstimatorMethod;}
	
	
	/**
     * We override createPageControls to avoid creating the controls
     * for the second page until we are ready.
     * 
     * @param pageContainer
     */
    public void createPageControls(Composite pageContainer) {
    	//IWizardPage page = selectFolderPage;
        //page.createControl(pageContainer);
    }
    
	/**
	 * Page for selecting scenario folder
	 */
	public class ParameterEstimatorWizardSelectFolderPage extends WizardPage {
		Text folderText = null;
		private String directory;
		
		/**
		 * Pass in the selection.
		 * 
		 * @param pageId
		 */
		public ParameterEstimatorWizardSelectFolderPage(String pageId) {
			super(pageId);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 */
		protected boolean validatePage() {
			return true;
		}

		/**
		 * Create layout
		 * 
		 * @param parent
		 */
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}
			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText(Messages.getString("EST.SCFOLDER")); //$NON-NLS-1$

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				containerLabel.setLayoutData(data);
			}
			folderText = new Text(composite, SWT.LEFT);
			{
				folderText.setText(this.getDirName());
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				data.minimumWidth = 100;
				folderText.setLayoutData(data);
			}
			Button selectFolderButton = new Button(composite, SWT.LEFT);
			{
				selectFolderButton.setText(Messages.getString("EST.SELECTFOLDEBUTTON"));
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				selectFolderButton.setLayoutData(data);
			}
			
			final Shell shell = this.getShell();
			
			selectFolderButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(@SuppressWarnings("unused")
						final SelectionEvent e) {
					final DirectoryDialog dd = new DirectoryDialog(
						shell, SWT.OPEN);
					dd.setText(Messages.getString("EST.SELECTFOLDEDIALOGTITLE")); //$NON-NLS-1$
					dd.setFilterPath(folderText.getText());
					final String selected = dd.open();
					folderText.setText(selected);
				}
			});
			setPageComplete(validatePage());
			setControl(composite);
		}
		
		/**
		 * Set the current directory name
		 * 
		 * @param dir Directory
		 */
		
		public void setDirName(String dir) {
			this.directory = dir;
		}

		/**
		 * Get the directory
		 * 
		 * @return String Directory
		 */
		public String getDirName() {
			return this.directory;
		}
		
		/**
		 * canFlipToNextPage. Figure out whether folder is set. 
		 * 
		 * @return boolean True if page is valid
		 */
		
		public boolean canFlipToNextPage(){
			  return this.validatePage();
		}
		
		/**
		 * isPageComplete.
		 * 
		 * @return boolean True if complete
		 */
		public boolean isPageComplete() {
			return this.validatePage();
		}
		
		/**
		 * Override to load folder data and validate
		 * 
		 * @return IWizardPage
		 */
		
		public IWizardPage getNextPage() {
			try {
				selectEstimatorPage = new ParameterEstimatorWizardSelectEstimatorPage("Estimator"); //$NON-NLS-1$
				selectEstimatorPage.setTitle(Messages.getString("EST.PARAMESTTITLE"));
				selectEstimatorPage.setDescription(""); //$NON-NLS-1$
				selectEstimatorPage.setWizard(this.getWizard());
				CSVscenarioLoader loader = new CSVscenarioLoader(this.folderText.getText());
				// Pick the highest resolution available
				int maxResolution = loader.getMaxResolution();
				ReferenceScenarioDataMapImpl map = loader.parseAllFiles(maxResolution);
				((ParameterEstimatorWizard)this.getWizard()).referenceScenarioDataMap = map;
				this.setDirName(this.folderText.getText());
			} catch(Exception e) {
				this.setErrorMessage(e.getMessage());
				return this;
			}
	        return selectEstimatorPage;
		}
	}

	/**
	 * Page for selecting estimator
	 */
	public class ParameterEstimatorWizardSelectEstimatorPage extends WizardPage {

		/**
		 * Pass in the selection.
		 * 
		 * @param pageId
		 */
		public ParameterEstimatorWizardSelectEstimatorPage(String pageId) {
			super(pageId);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 */
		protected boolean validatePage() {
			return (((ParameterEstimatorWizard)this.getWizard()).parameterEstimatorMethod != null);
		}

		/**
		 * Create layout
		 * 
		 * @param parent
		 */
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 1;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}

			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText(Messages.getString("EST.PARAMESTLABEL")); //$NON-NLS-1$

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				containerLabel.setLayoutData(data);
			}
			
			Label descriptionLabel = new Label(composite, SWT.LEFT);
			{
				descriptionLabel.setText(""); //$NON-NLS-1$

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				descriptionLabel.setLayoutData(data);
			}
			
			boolean first = true;
			for(ParameterEstimatorMethod method : ParameterEstimatorMethod.values()) {
				DiseaseType dataType = ((ParameterEstimatorWizard)this.getWizard()).referenceScenarioDataMap.getType();
				if(method.getType() != dataType) continue;
				Button button = new Button(composite, SWT.RADIO);
			    button.setText(method.getName());
			    if(first) {
			    	button.setSelection(true);
			    	((ParameterEstimatorWizard)this.getWizard()).parameterEstimatorMethod = method;
			    	descriptionLabel.setText(method.getDescription());
			    	first = false;
			    }
			    final ParameterEstimatorWizard wizard = (ParameterEstimatorWizard)this.getWizard();
			    final ParameterEstimatorMethod currentMethod = method;
			    final Label descLabel = descriptionLabel;
			    button.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(@SuppressWarnings("unused")
							final SelectionEvent e) {
						wizard.parameterEstimatorMethod = currentMethod;
						descLabel.setText(currentMethod.getDescription());
						wizard.getContainer().updateButtons();
					}
			    });
			}
			
			setPageComplete(validatePage());
			setControl(composite);
			
		}
		
		/**
		 * canFlipToNextPage. False since there is no next page
		 * 
		 * @return boolean True if can flip
		 */
		
		public boolean canFlipToNextPage(){
			  return false; // There is no next pager
		}
	
		/**
		 * isPageComplete.
		 * 
		 * @return boolean True if complete
		 */
		public boolean isPageComplete() {
			return this.validatePage();
		}
	}

	/**
	 * The framework calls this to create the contents of the wizard.
	 */
	public void addPages() {
		selectFolderPage = new ParameterEstimatorWizardSelectFolderPage("Folder"); //$NON-NLS-1$
		selectFolderPage.setTitle(Messages.getString("EST.WIZARDPAGE1TITLE"));
		selectFolderPage.setDescription(""); //$NON-NLS-1$
		selectFolderPage.setDirName(this.initDir);
		addPage(selectFolderPage);
	}
}
