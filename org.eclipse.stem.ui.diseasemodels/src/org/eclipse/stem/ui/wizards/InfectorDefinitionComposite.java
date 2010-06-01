// InfectorDefinitionControl.java
package org.eclipse.stem.ui.wizards;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.data.geography.GeographicMapper;
import org.eclipse.stem.data.geography.GeographicNames;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.widgets.LocationPickerDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This class represents the SWT composite that provides the GUI for defining an
 * {@link org.eclipse.stem.diseasemodels.standard.Infector} in the
 * {@link NewInfectorWizard}.
 */
public class InfectorDefinitionComposite extends Composite {

	// private static final URI LEVEL_0_ISO_NAME_FILE_URI = URI
	// .createURI("platform:/plugin/org.eclipse.stem.geography/resources/data/country/ZZZ/level0ISONames.properties");

	private String isoKey = ""; //$NON-NLS-1$
	private URI targetURI = null;
	
	private Text numberOfInfectionsText;

	private final Text populationText;

	private final Text diseaseNameText;
	
	private Label numberOfInfectionsLabel;

	private Label logDirLabel;
	private Text logDirText;
	
	private String errorMessage;
	
	/**
	 * Radio buttons to specify if the wizard will create an infector
	 * or an inoculator.
	 */
	private Button[] infectorModeRadioButtons = new Button[2];
	private Button[] importRadioButtons = new Button[2];
	
	private Button useAbsoluteNumberButton = null;
	private Button usePercentageButton = null;
	private Button locationButton = null;
	
	private Button[] rowButtons = new Button[3];
	Composite rowComposite = null;
	
	private Button importFileButton = null;
	private boolean importFromFile = false;
	private boolean useFirstRow = true;
	private boolean useLastRow = false;
	private boolean useSelectedRow = false;
	
	Text rowtxt = null;
	
	Label isokeyValueLabel = null;
	
	/** 
	 * keep track of the mode.
	 * infector by default
	 */
	private boolean infectorMode = true;
	
	/**
	 * keep track of percentage or absolute number
	 */
	private boolean percentage = false;

	/**
	 * The project (for location picker)
	 */
	
	public IProject currentProject;
	

	/**
	 * @param parent
	 * @param style
	 */
	public InfectorDefinitionComposite(final Composite parent, final int style,
			final ModifyListener projectValidator, final IProject project) {
		super(parent, style);
		
		this.currentProject = project;
		
		setLayout(new FormLayout());
		
		final int margin1 = 35;
		final int margin2 = 25;
		
		// radio buttons to set the mode
		Composite infectorModeComposite = createInfectorModeRadioButtonsComposite(this, projectValidator);
		final FormData fd_infectorMode = new FormData();
		fd_infectorMode.top = new FormAttachment(0, 0);
		fd_infectorMode.bottom = new FormAttachment(5, 0);
		fd_infectorMode.left = new FormAttachment(0, 0);
		fd_infectorMode.right = new FormAttachment(100, 0);
		infectorModeComposite.setLayoutData(fd_infectorMode);

		
		// Disease Name
		final Label diseaseNameLabel = new Label(this, SWT.NONE);
		final FormData fd_diseaseNameLabel = new FormData();
		fd_diseaseNameLabel.left = new FormAttachment(0, 0);
		fd_diseaseNameLabel.right = new FormAttachment(margin1, 0);
		fd_diseaseNameLabel.top = new FormAttachment(infectorModeComposite, 5, SWT.BOTTOM);
		diseaseNameLabel.setLayoutData(fd_diseaseNameLabel);
		diseaseNameLabel.setText(DiseaseWizardMessages.getString("NInfWizDN")); //$NON-NLS-1$

		
		diseaseNameText = new Text(this, SWT.BORDER);
		diseaseNameText.setToolTipText(DiseaseWizardMessages.getString("NInfWizDNTT")); //$NON-NLS-1$
		diseaseNameText.addModifyListener(projectValidator);
		
		final FormData fd_diseaseNameText = new FormData();
		fd_diseaseNameText.left = new FormAttachment(diseaseNameLabel, 0);
		fd_diseaseNameText.right = new FormAttachment(100, 0);
		fd_diseaseNameText.top = new FormAttachment(infectorModeComposite, 5, SWT.BOTTOM);
		diseaseNameText.setLayoutData(fd_diseaseNameText);
		

		// Population
		final Label populationLabel = new Label(this, SWT.NONE);
		final FormData fd_populationLabel = new FormData();
		fd_populationLabel.left = new FormAttachment(0, 0);
		fd_populationLabel.right = new FormAttachment(margin1, 0);
		fd_populationLabel.top = new FormAttachment(diseaseNameLabel, 5, SWT.BOTTOM);
		populationLabel.setLayoutData(fd_populationLabel);
		populationLabel.setText(DiseaseWizardMessages.getString("NInfWizPOP")); //$NON-NLS-1$

		populationText = new Text(this, SWT.BORDER);
		populationText.setText(StandardPackage.Literals.DISEASE_MODEL__POPULATION_IDENTIFIER.getDefaultValueLiteral());
		populationText.setToolTipText(DiseaseWizardMessages.getString("NInfWizPOPTT")); //$NON-NLS-1$
		populationText.addModifyListener(projectValidator);
		
		final FormData fd_populationText = new FormData();
		fd_populationText.top = new FormAttachment(diseaseNameLabel, 5, SWT.BOTTOM);
		fd_populationText.left = new FormAttachment(populationLabel, 0);
		fd_populationText.right = new FormAttachment(100, 0);
		populationText.setLayoutData(fd_populationText);
		
		// JK The Number to infect is now added inside the following composite 
		Composite numberPercentInputComposite = createNumberPercentInputComposite(this, projectValidator, margin1, margin2);
		final FormData fd_percentMode = new FormData();
		fd_percentMode.top = new FormAttachment(populationLabel, 10, SWT.BOTTOM);
		fd_percentMode.left = new FormAttachment(0, 0);
		fd_percentMode.right = new FormAttachment(100, 0);
		numberPercentInputComposite.setLayoutData(fd_percentMode);
		// TODO add it here
		
		
		
		
		
		
		// radio buttons to set the import 
		Composite importModeComposite = createImportRadioButtonsComposite(this, projectValidator);
		final FormData fd_importMode = new FormData();
		fd_importMode.top = new FormAttachment(numberPercentInputComposite, 10, SWT.BOTTOM);
		fd_importMode.left = new FormAttachment(0, 0);
		fd_importMode.right = new FormAttachment(100, 0);
		importModeComposite.setLayoutData(fd_importMode);
		
		importFileButton = new Button(this, SWT.BORDER);
		importFileButton.setText(DiseaseWizardMessages.getString("NInfWizImport"));
		final FormData fd_importButton= new FormData();
		fd_importButton.left = new FormAttachment(0, 0);
		fd_importButton.right = new FormAttachment(100, 0);
		fd_importButton.top = new FormAttachment(importModeComposite, 5, SWT.BOTTOM);
		importFileButton.setLayoutData(fd_importButton);
		importFileButton.setEnabled(false);
		
		// Log file location
		logDirLabel = new Label(this, SWT.NONE);
		logDirLabel.setText(DiseaseWizardMessages.getString("NInfWizLogDirLabel")); //$NON-NLS-1$

		final FormData fd_logDirLabel = new FormData();
		fd_logDirLabel.top = new FormAttachment(importFileButton,5, SWT.BOTTOM);
		fd_logDirLabel.left = new FormAttachment(0, 0);
		fd_logDirLabel.right = new FormAttachment(margin1, 0);
		logDirLabel.setLayoutData(fd_logDirLabel);
		
		logDirText = new Text(this, SWT.BORDER);
		logDirText.setText("");
		logDirText.setEditable(true);
		logDirText.setEnabled(false);
		logDirText.addModifyListener(projectValidator);
	
		final FormData fd_logDirText = new FormData();
		fd_logDirText.left = new FormAttachment(logDirLabel, 0);
		fd_logDirText.right = new FormAttachment(100, 0);
		fd_logDirText.top = new FormAttachment(importFileButton, 5, SWT.BOTTOM);
		logDirText.setLayoutData(fd_logDirText);
			
		// radio buttons to set the row
		rowComposite = createRowRadioButtonsComposite(this, projectValidator);
		final FormData fd_row = new FormData();
		fd_row.top = new FormAttachment(logDirLabel, 10, SWT.BOTTOM);
		fd_row.left = new FormAttachment(0, 0);
		fd_row.right = new FormAttachment(100, 0);
		rowComposite.setLayoutData(fd_row);
		rowComposite.setEnabled(false);
		
								
		final Shell shell = this.getShell();
		importFileButton
				.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(
							final SelectionEvent e) {
						final DirectoryDialog dd = new DirectoryDialog(
								shell, SWT.OPEN);
						dd
								.setText(DiseaseWizardMessages
										.getString("NInfWizLogDirDesc")); //$NON-NLS-1$
						final String selected = dd.open();
						logDirText.setText(selected);
						projectValidator.modifyText(null);
					} // widgetSelected
				} // SelectionAdapter
				);
	}// InfectorDefinitionControl

	
	/**
	 * creates a set of radio buttons and their composite container for the user to specify
	 * the creation of an infector OR an inoculator
	 * @param parent
	 * @return the composite
	 */
	Composite createInfectorModeRadioButtonsComposite(final Composite parent, final ModifyListener projectValidator) {
		Composite radioComposite = new Composite(parent, SWT.BORDER);
	    FillLayout fillLayout = new FillLayout();
	    fillLayout.type = SWT.VERTICAL;
	    radioComposite.setLayout(fillLayout);
	    
	    infectorModeRadioButtons[0] = new Button(radioComposite, SWT.RADIO);
	    infectorModeRadioButtons[0].setSelection(true);
	    infectorModeRadioButtons[0].setText(DiseaseWizardMessages.getString("NInfectorWiz.infect"));//$NON-NLS-1$
	    
	    infectorModeRadioButtons[1] = new Button(radioComposite, SWT.RADIO);
	    infectorModeRadioButtons[1].setText(DiseaseWizardMessages.getString("NInfectorWiz.inoculate"));//$NON-NLS-1$
	    	    
	    Listener listener = new Listener() {
	        public void handleEvent(Event event) {
	          if (event.widget == infectorModeRadioButtons[0]) {
	        	infectorMode = infectorModeRadioButtons[0].getSelection();
	          }
	          if(!isPercentage()) 
	        	  if(isInfectorMode()) numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizNIINF")); //$NON-NLS-1$
	        	  else numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizNIINO")); //$NON-NLS-1$
	          else if(isInfectorMode())
	        	  numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizPIINF")); //$NON-NLS-1$
	          else numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizPIINO")); //$NON-NLS-1$

	          projectValidator.modifyText(null);
	        }
	      };
	      // these are radio buttons so we only need to add the listener to one of them.
	      infectorModeRadioButtons[0].addListener(SWT.Selection, listener);
	      
	    return radioComposite;
	}//getinfectorModeRadioButtonsComposite
	
	/**
	 * Create radio buttons to determine whether to import from file or not
	 * 
	 * @param parent
	 * @return the composite
	 */
	Composite createImportRadioButtonsComposite(final Composite parent, final ModifyListener projectValidator) {
		Composite radioComposite = new Composite(parent, SWT.BORDER);
	    FillLayout fillLayout = new FillLayout();
	    fillLayout.type = SWT.VERTICAL;
	    radioComposite.setLayout(fillLayout);
	    
	    importRadioButtons[0] = new Button(radioComposite, SWT.RADIO);
	    importRadioButtons[0].setSelection(true);
	    importRadioButtons[0].setText(DiseaseWizardMessages.getString("NInfectorWiz.enter"));//$NON-NLS-1$
	    
	    importRadioButtons[1] = new Button(radioComposite, SWT.RADIO);
	    importRadioButtons[1].setText(DiseaseWizardMessages.getString("NInfectorWiz.import"));//$NON-NLS-1$
	    	    
	    Listener listener = new Listener() {
	        public void handleEvent(Event event) {
	          if (event.widget == importRadioButtons[0]) {
	        	importFromFile = !importRadioButtons[0].getSelection();
	        	if(importFromFile) {
	        		importFileButton.setEnabled(true);
	        		numberOfInfectionsText.setEnabled(false);
	        		logDirText.setEnabled(true);
	        		rowComposite.setEnabled(true);
	        		locationButton.setEnabled(false);
	        	} else {
	        		importFileButton.setEnabled(false);
	        		numberOfInfectionsText.setEnabled(true);
	        		logDirText.setEnabled(false);
	        		rowComposite.setEnabled(false);
	        		locationButton.setEnabled(true);
	        	}
	          }
	          projectValidator.modifyText(null);
	        }
	      };
	      // these are radio buttons so we only need to add the listener to one of them.
	      importRadioButtons[0].addListener(SWT.Selection, listener);
	      
	    return radioComposite;
	}//
	
	/**
	 * Create radio buttons to determine what row to use when importing
	 * 
	 * @param parent
	 * @return the composite
	 */
	Composite createRowRadioButtonsComposite(final Composite parent, final ModifyListener projectValidator) {
		Composite radioComposite = new Composite(parent, SWT.BORDER);
	    FillLayout fillLayout = new FillLayout();
	    fillLayout.type = SWT.HORIZONTAL;
	    radioComposite.setLayout(fillLayout);
	    
	    rowButtons[0] = new Button(radioComposite, SWT.RADIO);
	    rowButtons[0].setSelection(true);
	    rowButtons[0].setText(DiseaseWizardMessages.getString("NInfectorWiz.firstrow"));//$NON-NLS-1$
	    
	    rowButtons[1] = new Button(radioComposite, SWT.RADIO);
	    rowButtons[1].setText(DiseaseWizardMessages.getString("NInfectorWiz.lastrow"));//$NON-NLS-1$
	    	
	    rowButtons[2] = new Button(radioComposite, SWT.RADIO);
	    rowButtons[2].setText(DiseaseWizardMessages.getString("NInfectorWiz.selectedrow"));//$NON-NLS-1$
	    
	    rowtxt = new Text(radioComposite, SWT.NONE);
	    rowtxt.setText("0");
	    rowtxt.setEditable(false);
	    rowtxt.addModifyListener(projectValidator);
	    
	    Listener listener = new Listener() {
	        public void handleEvent(Event event) {
	        	useFirstRow = rowButtons[0].getSelection();
	        	useLastRow = rowButtons[1].getSelection();
	        	useSelectedRow = rowButtons[2].getSelection();
	        	if(useFirstRow || useLastRow) {
	        		rowtxt.setEditable(false);
	        	} else {
	        		rowtxt.setEditable(true);
	        	}
	        	 projectValidator.modifyText(null);
	        }
	      };
	      // these are radio buttons so we only need to add the listener to one of them.
	      rowButtons[0].addListener(SWT.Selection, listener);
	      rowButtons[1].addListener(SWT.Selection, listener);
	      rowButtons[2].addListener(SWT.Selection, listener);
	    return radioComposite;
	}//
	
	/**
	 * @param parent
	 * @return the composite
	 */
	Composite createNumberPercentInputComposite(final Composite parent, final ModifyListener projectValidator, final int margin1, final int margin2) {
	    Composite radio2Composite = new Composite(parent, SWT.BORDER);
	    
	    radio2Composite.setLayout(new FormLayout());
	    
	    
	    useAbsoluteNumberButton = new Button(radio2Composite, SWT.RADIO);
	    useAbsoluteNumberButton.setSelection(true);
	    useAbsoluteNumberButton.setText(DiseaseWizardMessages.getString("NInfWiz.absnumber"));
	    final FormData fd_numberButton = new FormData();
		fd_numberButton.top = new FormAttachment(0, 0);
		fd_numberButton.left = new FormAttachment(0, 0);
		fd_numberButton.right = new FormAttachment(margin1, 0);
		useAbsoluteNumberButton.setLayoutData(fd_numberButton);
	    
	    usePercentageButton = new Button(radio2Composite, SWT.RADIO);
	    usePercentageButton.setText(DiseaseWizardMessages.getString("NInfWiz.percentage"));
	    final FormData fd_percentButton = new FormData();
		fd_percentButton.top = new FormAttachment(useAbsoluteNumberButton, 0);
		fd_percentButton.left = new FormAttachment(0, 0);
		fd_percentButton.right = new FormAttachment(margin1, 0);
		usePercentageButton.setLayoutData(fd_percentButton);
	    
	    
	    // START adding Number of Infections
		numberOfInfectionsLabel = new Label(radio2Composite, SWT.NONE);
		numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizNIINF")); //$NON-NLS-1$

		final FormData fd_numberOfInfectionsLabel = new FormData();
		fd_numberOfInfectionsLabel.top = new FormAttachment(usePercentageButton, 0);
		fd_numberOfInfectionsLabel.left = new FormAttachment(0, 0);
		fd_numberOfInfectionsLabel.right = new FormAttachment(margin1, 0);
		numberOfInfectionsLabel.setLayoutData(fd_numberOfInfectionsLabel);
		
		numberOfInfectionsText = new Text(radio2Composite, SWT.BORDER);
		numberOfInfectionsText.setText(StandardPackage.Literals.SI_INFECTOR__INFECTIOUS_COUNT.getDefaultValueLiteral());
		numberOfInfectionsText.setToolTipText(DiseaseWizardMessages.getString("NInfWizNITT")); //$NON-NLS-1$
		numberOfInfectionsText.addModifyListener(projectValidator);
		
		final FormData fd_numberOfInfectionsText = new FormData();
		fd_numberOfInfectionsText.top = new FormAttachment(usePercentageButton, 0);
		fd_numberOfInfectionsText.left = new FormAttachment(numberOfInfectionsLabel, 0);
		fd_numberOfInfectionsText.right = new FormAttachment(100, 0);
		
		numberOfInfectionsText.setLayoutData(fd_numberOfInfectionsText);
		// End adding Number of Infections
		
		// Location Button
		locationButton = new Button(radio2Composite, SWT.NONE);
		locationButton.setText(DiseaseWizardMessages.getString("NInfWizPickLoc"));
		final FormData fd_locButton = new FormData();
		fd_locButton.top = new FormAttachment(numberOfInfectionsLabel, 0);
		fd_locButton.left = new FormAttachment(0,0);
		locationButton.setLayoutData(fd_locButton);
		
		// ISO Key
		final Label isoKeyLabel = new Label(radio2Composite, SWT.NONE);
		isoKeyLabel.setText(DiseaseWizardMessages.getString("NInfWizISOK")); //$NON-NLS-1$
		
		final FormData fd_isoKeyLabel = new FormData();
		fd_isoKeyLabel.top = new FormAttachment(locationButton, 0);
		fd_isoKeyLabel.left = new FormAttachment(0, 0);
		fd_isoKeyLabel.right = new FormAttachment(margin2, 0);
		isoKeyLabel.setLayoutData(fd_isoKeyLabel);
		
		isokeyValueLabel = new Label(radio2Composite, SWT.BORDER);
		isokeyValueLabel.setText(isoKey);
		final FormData fd_isokeyValueLabel = new FormData();
		fd_isokeyValueLabel.top = new FormAttachment(locationButton, 0);
		fd_isokeyValueLabel.left = new FormAttachment(isoKeyLabel, 0);
		fd_isokeyValueLabel.right = new FormAttachment(100, 0);
		isokeyValueLabel.setLayoutData(fd_isokeyValueLabel);
		
		// ISO Key
		final Label spacerLabel = new Label(radio2Composite, SWT.NONE);
		spacerLabel.setText(" "); //$NON-NLS-1$
		
		final FormData fd_spacerLabel = new FormData();
		fd_spacerLabel.top = new FormAttachment(isoKeyLabel, 0);
		fd_spacerLabel.left = new FormAttachment(0, 0);
		fd_spacerLabel.right = new FormAttachment(margin2, 0);
		spacerLabel.setLayoutData(fd_spacerLabel);

		
		
		////////////////
		//
		// Listeners
		//
		//
		locationButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				LocationPickerDialog lpDialog = new LocationPickerDialog(InfectorDefinitionComposite.this.getShell(), SWT.NONE, DiseaseWizardMessages.getString("NInfWizPickLocTitle"), InfectorDefinitionComposite.this.isoKey, currentProject);
				Object [] ret = lpDialog.open();
				if(ret != null) {
					isoKey = (String)ret[0];
					targetURI = (URI)ret[1];
					isokeyValueLabel.setText(isoKey);
					projectValidator.modifyText(null);
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		
		
	    
	    
	    
	    Listener listener = new Listener() {
	        public void handleEvent(Event event) {
	          if(event.widget == useAbsoluteNumberButton || event.widget == usePercentageButton) {
		          // toggle the wizard
	        	  percentage = usePercentageButton.getSelection();
		          if(!percentage) 
		        	  if(isInfectorMode()) numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizNIINF")); //$NON-NLS-1$
		        	  else numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizNIINO")); //$NON-NLS-1$
		          else if(isInfectorMode())
		        	  numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizPIINF")); //$NON-NLS-1$
		          else numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizPIINO")); //$NON-NLS-1$
		          // clear the text because we need to revalidate
	          }
	          projectValidator.modifyText(null);
	        }
	      };
	      // these are radio buttons so we only need to add the listener to one of them.
	      useAbsoluteNumberButton.addListener(SWT.Selection, listener);
	      
	    return radio2Composite;
	}//getinfectorModeRadioButtonsComposite


	/**
	 * @return <code>true</code> if the contents of the control are valid,
	 *         <code>false</code> otherwise.
	 */
	public boolean validate() {
		boolean retValue = true;
		// Disease Name?
		if (getDiseaseName() == null || getDiseaseName().equals("")) { //$NON-NLS-1$
			// Yes
			errorMessage = DiseaseWizardMessages.getString("NInfWizError.1"); //$NON-NLS-1$
			retValue = false;
		} // if

		// Population
		if (retValue) {
			// Yes
			if (getPopulation() == null || getPopulation().equals("")) { //$NON-NLS-1$
				// Yes
				errorMessage = DiseaseWizardMessages
						.getString("NInfWizError.2"); //$NON-NLS-1$
				retValue = false;
			} // if
		} // if

		// Number of infections
		if (this.importFromFile == false && retValue) {
			// Yes
			if (numberOfInfectionsText.getText() == null
					|| numberOfInfectionsText.getText().equals("")) { //$NON-NLS-1$
				// Yes
				errorMessage = DiseaseWizardMessages
						.getString("NInfWizError.3"); //$NON-NLS-1$
				retValue = false;
			} // if
		}
		if (this.importFromFile == false && retValue) {
			final double temp = Double
					.parseDouble(numberOfInfectionsText.getText());
				// > 0?
				if (temp <= 0.0) {
					// No
					errorMessage = DiseaseWizardMessages
							.getString("NInfWizError.4"); //$NON-NLS-1$
					retValue = false;
				} // if
		}
		if (this.importFromFile == false && retValue) {
			final double temp = Double
			.parseDouble(numberOfInfectionsText.getText());
				if(isPercentage()) {
					// yes, then this must be a percentage
						if(temp > 100.0) {
							errorMessage = DiseaseWizardMessages.getString("NInfWizError.8"); //$NON-NLS-1$
							retValue = false;
						}					
					}
		}
		

		// ISO Key
		if (retValue) {
			// Yes
			if (!this.isFromFile() && (getIsoKey() == null || getIsoKey().equals(""))) { //$NON-NLS-1$
				// Yes
				errorMessage = DiseaseWizardMessages
						.getString("NInfWizError.6"); //$NON-NLS-1$
				retValue = false;
			} // if
		} // if

		// Location
		if (retValue) {
			// Yes
			if (this.isFromFile() && (getImportFolder() == null || getImportFolder().equals(""))) { //$NON-NLS-1$
				// Yes
				errorMessage = DiseaseWizardMessages
						.getString("NInfWizError.9"); //$NON-NLS-1$
				retValue = false;
			} // if
		} // if
		// Location
		if (retValue) {
			// Yes
			if (this.isFromFile()) { //$NON-NLS-1$
				File f = new File(getImportFolder());
				if(!f.exists()) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NInfWizError.10"); //$NON-NLS-1$
					retValue = false;
				}
				
			} // if
		} // if
		if(retValue && this.isFromFile() && isSelectedRow()) {
			String val = rowtxt.getText();
			try {
				int v = Integer.parseInt(val);
				if(v < 0) {
					errorMessage = DiseaseWizardMessages
					.getString("NInfWizError.11"); //$NON-NLS-1$
					retValue = false;
				}
			} catch(Exception e) {
				errorMessage = DiseaseWizardMessages
				.getString("NInfWizError.11"); //$NON-NLS-1$
				retValue = false;
			}
		}
		return retValue;
	} // validate

	/**
	 * @return the error message set by {@link #validate()}
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	// private String getName(String isoKey, int level) {
	// return GeographicNames.getName(isoKey, level);
	// } // getName

	

	/**
	 * access the infectorMode
	 * if true create and infector
	 * if false creates and inoculator
	 */
	public boolean isInfectorMode() {
		return infectorMode;
	}
	
	/**
	 * Are we reading from a file
	 */
	
	public boolean isFromFile() {
		return importFromFile;
	}
	
	/**
	 * Are we reading from a file
	 */
	
	public String getImportFolder() {
		return logDirText.getText();
	}
	
	/**
	 * @return the isoKey that specifies the location to be infected.
	 */
	public final String getIsoKey() {
		return isoKey;
	}

	/**
	 * @return the isoKey that specifies the location to be infected.
	 */
	public final URI getTargetURI() {
		return targetURI;
	}
	
	/**
	 * @return the NLS'd name of the location selected as the point of infection
	 */
	public final String getLocationName() {
		// TODO need to return the NLS string here.
		return getIsoKey();
	}

	/**
	 * @return the name of the disease
	 */
	public final String getDiseaseName() {
		return diseaseNameText.getText();
	}

	/**
	 * @return the name of the population being infected
	 */
	public final String getPopulation() {
		return populationText.getText();
	}

	/**
	 * @return the number of infections
	 */
	public double getNumber() {
		try {
			return Double.parseDouble(numberOfInfectionsText.getText());
		} catch (final NumberFormatException e) {
			Activator.logError(DiseaseWizardMessages
					.getString("NInfWizError.7"), e); //$NON-NLS-1$
			return 0.0;
		} // catch NumberFormatException
	}
	


	public boolean isPercentage() {
		return percentage;
	}

	public boolean isFirstRow() {return useFirstRow;}
	public boolean isLastRow() {return useLastRow;}
	public boolean isSelectedRow() {return useSelectedRow;}
	public int getSelectecRow() {return Integer.parseInt(rowtxt.getText());}
	
	public void setProject(IProject p) {this.currentProject=p;}
	
} // InfectorDefinitionComposite
