// EstimatorControl.java
package org.eclipse.stem.util.analysis.views;

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

import java.util.List;
import java.util.Map;

import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl;
import org.eclipse.stem.analysis.util.CSVscenarioLoader;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.definitions.Activator;
import org.eclipse.stem.util.analysis.AggregateDataWriter;
import org.eclipse.stem.util.analysis.ModelParameters;
import org.eclipse.stem.util.analysis.ParameterEstimatorMethod;
import org.eclipse.stem.util.analysis.ScenarioAnalysisSuite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

/**
 * This class is a SWT GUI component that uses BIRT to plot
 */
public class EstimatorControl extends AnalysisControl {
	
	
	
	/**
	 * keep the recent folder name
	 */
	String recentFolder;
	
	/**
	 * used to identify user preferences for this class
	 */
	private static final String CONSUMER = "ESTIMATOR_CONTROL";

	
	/**
	 *  Label for current scenario folder
	 */
	static Label scenarioFolderLabel;
	
	/**
	 *  Label for current parameter estimator
	 */
	
	static Label estimatorFolderLabel;
	/**
	 * Input text field for the scenario folder of data to use in making the estimation
	 */
	public static Text text1;
	
	/**
	 * Text displaying the currently selected parameter estimator
	 */
	
	public static Text estimatorText;
	
	/**
	 * A label to report status (not yet used)
	 */
	static Label statusLabel;
	
	/**
	 * Radio buttons for fit then average or sum over location then
	 */
	public static Button[] dataAverageRadioButtons = new Button[2];
		
	/**
	 * Radio buttons for frequency vs density dependent beta
	 */
	public static Button[] betaModeRadioButtons = new Button[2];
	
	/**
	 * three decimal places
	 */
	private static final int SPINNER_RESOLUTION = 1000;
	
	/**
	 * 0.001
	 */
	private static final int SPINNER_INCREMENT = 1;
	
	
	/** min S threshold for analysis */
	protected static Spinner minThresholdSpinnerS;
	/** max S threshold for analysis */
	protected static Spinner maxThresholdSpinnerS;
	/** S spinner label */
	static Label minSpinnerLabelS;
	/** S spinner label */
	static Label maxSpinnerLabelS;
	
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String MIN_S_KEY = "MINS";
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String MIN_E_KEY = "MINE";
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String MIN_I_KEY = "MINI";
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String MIN_R_KEY = "MINR";
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String MAX_S_KEY = "MAXS";
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String MAX_E_KEY = "MAXE";
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String MAX_I_KEY = "MAXI";
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String MAX_R_KEY = "MAXR";
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String SUM_LOCATIONS_KEY = "SUM_LOCATIONS";
	/**
	 * keys for finding control parameters from the map
	 */
	public static final String FREQ_MODE_KEY = "FREQ_MODE";
	
	/** Region Selector Combo box **/
	protected static Combo displayRegionCombo;
	protected static String regionToDisplay = "";
	
	/** min E threshold for analysis */
	protected static Spinner minThresholdSpinnerE;
	/** max E threshold for analysis */
	protected static Spinner maxThresholdSpinnerE;
	/** E spinner label */
	static Label minSpinnerLabelE;
	/** E spinner label */
	static Label maxSpinnerLabelE;
	
	/** min I threshold for analysis */
	protected static Spinner minThresholdSpinnerI;
	/** max I threshold for analysis */
	protected static Spinner maxThresholdSpinnerI;
	/** I spinner label */
	static Label minSpinnerLabelI;
	/** ( spinner label */
	static Label maxSpinnerLabelI;
	
	/** min R threshold for analysis */
	protected static Spinner minThresholdSpinnerR;
	/** max R threshold for analysis */
	protected static Spinner maxThresholdSpinnerR;	
	/** R spinner label */
	static Label minSpinnerLabelR;
	/** R spinner label */
	static Label maxSpinnerLabelR;
	
	
	
	/**
	 * The results and data that go into making an estimate
	 */
	static ModelParameters averageParms;
	

	/**
	 * Folder to contain the analysis graphs
	 * 
	 */
	static TabFolder tabFolder;

	/**
	 * the chart of results
	 */
	static EstimatorCanvas estimatorCanvas;
	
	/**
	 * Colors for the time series chart
	 */
	static final ColorDefinition foreGround = ColorDefinitionImpl.create(180, 0, 0);
	static final ColorDefinition backgroundGround = ColorDefinitionImpl.create(255, 255, 225);
	static final ColorDefinition frameColor = ColorDefinitionImpl.WHITE();
	
	/**
	 * For now we will always set up for four of these
	 * we will use 2-4 depending on the type of model (SI,SIR, SEIR, etc).
	 */
	protected static TimeSeriesCanvas[] equationSeries = new TimeSeriesCanvas[4];
	
	/**
	 * For now we will always set up for four of these
	 * we will use 2-4 depending on the type of model (SI,SIR, SEIR, etc).
	 */
	protected static XYSeriesCanvas[] regressionSeries = new XYSeriesCanvas[4];
	
	/**
	 * Wizard for selecting a new parameter estimator
	 */
	
	static ParameterEstimatorWizard parameterEstimatorWizard;
	
	/**
	 * The dialog for the wizard
	 */
	static WizardDialog wizardDialog;	
	protected static ScenarioAnalysisSuite analyzer;
	
	//PropertySelector propertySelector;
	//List<ItemPropertyDescriptor> selectedProperties;

	/**
	 * 
	 * @param parent
	 */
	public EstimatorControl(final Composite parent) {
		super(parent, SWT.None);
		createContents();
	} // EstimatorControl

	/**
	 * Create the contents of the plotter
	 */
	void createContents() {
		
		analyzer = new ScenarioAnalysisSuite(this);
		
		setLayout(new FormLayout());

		identifiableTitle = new Label(this, SWT.NONE);
		identifiableTitle.setText(Messages.getString("EST.TITLE"));
		//propertySelector = new PropertySelector(this, SWT.NONE);
		Display display = this.getDisplay();
		
		Color labelBackground = new Color(display, new RGB(180, 180, 200));
		
		statusLabel = new Label(this, SWT.BORDER);
		statusLabel.setBackground(labelBackground);
		statusLabel.setText("");
		
		scenarioFolderLabel = new Label(this, SWT.BORDER);
		scenarioFolderLabel.setBackground(labelBackground);
		scenarioFolderLabel.setText(Messages.getString("EST.SCFOLDER"));
		
		estimatorFolderLabel = new Label(this, SWT.BORDER);
		estimatorFolderLabel.setBackground(labelBackground);
		estimatorFolderLabel.setText(Messages.getString("EST.PARAMESTIMATOR"));
		
		text1 = new Text(this, SWT.BORDER);
	    text1.setBounds(10, 10, 100, 20);
	    
	    recentFolder = prefs.getRecentFolder(CONSUMER);
	    if(recentFolder== null) {
	    	recentFolder = ScenarioAnalysisSuite.REFERENCE_TESTING_DIRECTORY;
	    }
	    text1.setText(recentFolder);
		  
	    String estimatorMethod = prefs.getRecentEstimatorMethod();
	    estimatorText = new Text(this, SWT.BORDER);
	    estimatorText.setBounds(10, 10, 100, 20);
	    if(estimatorMethod != null) estimatorText.setText(estimatorMethod);
	    else estimatorText.setText("");
	    
	    selectEstimatorButton = new Button(this, SWT.NONE);
	    selectEstimatorButton.setText(Messages.getString("EST.SELECTESTIMATOR"));
	    
	    ///////////////////////////////////////////////////////////////
	    //
	    //  components for user interaction with fitting algorithm
	    //
	    //////////////////////////////////////////////////////////////
	    Composite displayComposite = getRegionSelectorComboComposite(this);
	    Composite radioComposite = getDataAvgRadioButtonsComposite(this);
	    Composite spinnerComposite = getSpinnerComposite(this);
	    Composite betaModeComposite = getbetaModeRadioButtonsComposite(this);
	    Composite doEstimationComposite = getAnalyzeButtonComposite(this,Messages.getString("EST.ESTIMATE"));
		
		
		tabFolder = new TabFolder (this, SWT.NONE);
		// results	
		TabItem item0 = new TabItem(tabFolder, SWT.BORDER);
		item0.setText(Messages.getString("EST.RESULTS"));
		estimatorCanvas = new EstimatorCanvas(tabFolder);
		item0.setControl(estimatorCanvas);
		
		// data
		TabItem item1 = new TabItem (tabFolder, SWT.NULL);
		item1.setText (Messages.getString("EST.INPUTDATA"));
		Composite dataComposite = new Composite(tabFolder, SWT.BORDER);
    	GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
 		dataComposite.setLayout(new FormLayout());
 		item1.setControl(dataComposite);
 		// set up the four data time series inside the dataComposite
 		getEquationSeriesCharts(dataComposite); 
 		
		// regression Charts go *** here ***
		TabItem item2 = new TabItem (tabFolder, SWT.NULL);
		item2.setText (Messages.getString("EST.REGRESSION"));
		Composite regressionComposite = new Composite(tabFolder, SWT.BORDER);
    	regressionComposite.setLayout(new FormLayout());
 		item2.setControl(regressionComposite);
 	    // set up the four regression XY series plots inside the dataComposite
 		getRegressionSeriesCharts(regressionComposite); 
		
		
		// FOrm data
		int bottom = 5;
		final FormData titleFormData = new FormData();
		identifiableTitle.setLayoutData(titleFormData);
		titleFormData.top = new FormAttachment(0, 0);
		titleFormData.bottom = new FormAttachment(bottom, 0);
		titleFormData.left = new FormAttachment(0, 0);
		titleFormData.right = new FormAttachment(100, 0);

		// TextField folder label
		bottom += 5;
		final FormData scenarioFolderLabelFormData = new FormData();
		scenarioFolderLabelFormData.top = new FormAttachment(identifiableTitle, 0);
		scenarioFolderLabelFormData.bottom = new FormAttachment(bottom, 0);
		scenarioFolderLabelFormData.left = new FormAttachment(0, 0);
		scenarioFolderLabelFormData.right = new FormAttachment(15, 0);
		scenarioFolderLabel.setLayoutData(scenarioFolderLabelFormData);
		
		
		// first text field for parameter Estimator
		final FormData text1FormData = new FormData();
		text1FormData.top = new FormAttachment(identifiableTitle, 0);
		text1FormData.bottom = new FormAttachment(bottom, 0);
		text1FormData.left = new FormAttachment(scenarioFolderLabel, 0);
		text1FormData.right = new FormAttachment(80, 0);
		text1.setLayoutData(text1FormData);
		text1.setEditable(false); // Can only be selected through wizard
			
		final FormData selectEstimatorButtonFormData = new FormData();		
		selectEstimatorButtonFormData.top = new FormAttachment(identifiableTitle, 0);
		selectEstimatorButtonFormData.bottom = new FormAttachment(bottom, 0);
		selectEstimatorButtonFormData.left = new FormAttachment(text1, 0);
		selectEstimatorButtonFormData.right = new FormAttachment(100, 0);
		selectEstimatorButton.setLayoutData(selectEstimatorButtonFormData);

		bottom += 5;
		final FormData estimatorLabelFormData = new FormData();
		estimatorLabelFormData.top = new FormAttachment(scenarioFolderLabel, 0);
		estimatorLabelFormData.bottom = new FormAttachment(bottom, 0);
		estimatorLabelFormData.left = new FormAttachment(0, 0);
		estimatorLabelFormData.right = new FormAttachment(15, 0);
		estimatorFolderLabel.setLayoutData(estimatorLabelFormData);
		
		
		// first text field for parameter Estimator
		final FormData estimatorTextFormData = new FormData();
		estimatorTextFormData.top = new FormAttachment(scenarioFolderLabel, 0);
		estimatorTextFormData.bottom = new FormAttachment(bottom, 0);
		estimatorTextFormData.left = new FormAttachment(scenarioFolderLabel, 0);
		estimatorTextFormData.right = new FormAttachment(100, 0);
		estimatorText.setLayoutData(estimatorTextFormData);
		estimatorText.setEditable(false); // Can only be selected through wizard
		
		int top = bottom;
		bottom += 10;
		
		// Display regionSelectorCombo
		final FormData displayComboCompositeFormData = new FormData();
		displayComboCompositeFormData.top = new FormAttachment(estimatorText, 0);
		displayComboCompositeFormData.bottom = new FormAttachment(bottom, 0);
		displayComboCompositeFormData.left = new FormAttachment(5,0);
		displayComboCompositeFormData.right = new FormAttachment(24, 0);
		displayComposite.setLayoutData(displayComboCompositeFormData);
		
		
		// beta mode Composite
		final FormData betaModeRadioCompositeFormData = new FormData();
		betaModeRadioCompositeFormData.top = new FormAttachment(estimatorText, 0);
		betaModeRadioCompositeFormData.bottom = new FormAttachment(bottom, 0);
		betaModeRadioCompositeFormData.left = new FormAttachment(25,0);
		betaModeRadioCompositeFormData.right = new FormAttachment(39, 0);
		betaModeComposite.setLayoutData(betaModeRadioCompositeFormData);
		
		// radio buttons Composite
		final FormData radioCompositeFormData = new FormData();
		radioCompositeFormData.top = new FormAttachment(estimatorText, 0);
		radioCompositeFormData.bottom = new FormAttachment(bottom, 0);
		radioCompositeFormData.left = new FormAttachment(40, 0);
		radioCompositeFormData.right = new FormAttachment(61,0);
		radioComposite.setLayoutData(radioCompositeFormData);
		
		// Spinner Composite 
		final FormData spinnerFormData = new FormData();
		spinnerFormData.top = new FormAttachment(top, 0);
		spinnerFormData.bottom = new FormAttachment(bottom, 0);
		spinnerFormData.left = new FormAttachment(62, 0);
		spinnerFormData.right = new FormAttachment(100, 0);
		spinnerComposite.setLayoutData(spinnerFormData);
		
		//top = bottom;
		
		
		// Analyze button
		bottom += 5;
		final FormData analysisButtonFormData = new FormData();
		analysisButtonFormData.top = new FormAttachment(radioComposite, 0);
		analysisButtonFormData.bottom = new FormAttachment(bottom, 0);
		analysisButtonFormData.left = new FormAttachment(0, 0);
		analysisButtonFormData.right = new FormAttachment(100, 0);
		doEstimationComposite.setLayoutData(analysisButtonFormData);
		if(recentFolder != null && estimatorMethod != null)
			analyzeButton.setEnabled(true);
		else analyzeButton.setEnabled(false);
		
		// Results Graph
		bottom += 40;
		
		final FormData tabFormData = new FormData();
		tabFolder.setLayoutData(tabFormData);
		tabFormData.top = new FormAttachment(doEstimationComposite, 0);
		tabFormData.bottom = new FormAttachment(100, 0);
		tabFormData.left = new FormAttachment(0, 0);
		tabFormData.right = new FormAttachment(100, 0);
		
		final Shell shell = this.getShell();
		final EstimatorControl eControl = this;
		selectEstimatorButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(@SuppressWarnings("unused")
					final SelectionEvent e) {
				String dir = null;
				if(parameterEstimatorWizard != null)
					dir = parameterEstimatorWizard.selectFolderPage.getDirName();
				else dir = recentFolder;
				
				if((dir==null)||(dir.length()<1)) dir = ROOT_PATH;
				
				parameterEstimatorWizard = new ParameterEstimatorWizard(eControl, dir);
				
				//parameterEstimatorWizard.init(selectEstimatorButton.);
			    //this.
				// Instantiates the wizard container with the wizard and opens it
				wizardDialog = new WizardDialog(shell, parameterEstimatorWizard);
				wizardDialog.create();
				eControl.analyzeButton.setEnabled(false);
				EstimatorControl.estimatorText.setText("");
			    wizardDialog.open();				
			}
		});
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(this.getShell());
		
		analyzeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			final SelectionEvent e) {

				recentFolder = text1.getText();
				String methodtxt = estimatorText.getText();
				identifiableTitle.setText(Messages.getString("EST.TITLE"));
				
				/*
				 * VALIDATE the text input Fields
				 */
				if(!analyzer.validate(recentFolder)) {
					identifiableTitle.setText(ScenarioAnalysisSuite.NOT_FOUND_MSG);
					text1.setText("");
					return;
				} 
				// else valid so remember the preferences
				prefs.setRecentFolder(CONSUMER,recentFolder);
				prefs.setEstimatorMethod(methodtxt);
				
				ReferenceScenarioDataMapImpl dataMap;
				ParameterEstimatorMethod method;
			
				if(parameterEstimatorWizard != null) {
					dataMap = parameterEstimatorWizard.getReferenceScenarioDataMap();
					method = parameterEstimatorWizard.getParameterEstimatorMethod();
				} else {
					// We haven't gone through the wizard and loaded data yet, but
					// assuming the folder and the method is set we can load the data here
					try {
						CSVscenarioLoader loader = new CSVscenarioLoader(recentFolder);
						// Pick the highest resolution available
						int maxResolution = loader.getMaxResolution();
						dataMap = loader.parseAllFiles(maxResolution);
						method = ParameterEstimatorMethod.valueOf(methodtxt);
					} catch(Exception ex) {
						Activator.logError(ex.getMessage(), ex);
						return;
					}
				}
				
				//String comparisonDirectory = ScenarioAnalysisSuite.COMPARISON_TESTING_DIRECTORY;
				averageParms = analyzer.estimateParameters(
						dataMap,
						method, 
						progressDialog
						);
				
				String[] displayableRegions = averageParms.getDataLocations();
				
				displayRegionCombo.setItems (displayableRegions);
				displayRegionCombo.select(0);
				regionToDisplay = displayableRegions[0];
						
				
			
				updateCharts();
			
			}
		});
		
		
		maxThresholdSpinnerS.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {
		        int max = maxThresholdSpinnerS.getSelection();
		        int min = minThresholdSpinnerS.getSelection();
		        int minThresh = max-SPINNER_INCREMENT;
		        int maxThresh = min+SPINNER_INCREMENT;
		       
		        maxThresholdSpinnerS.setMinimum(maxThresh);
		        minThresholdSpinnerS.setMaximum(minThresh);  
		      }
		    });// maxThresholdSpinnerS
		
		minThresholdSpinnerS.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {  
		        int max = maxThresholdSpinnerS.getSelection();
		        int min = minThresholdSpinnerS.getSelection();
		        int minThresh = max-SPINNER_INCREMENT;
		        int maxThresh = min+SPINNER_INCREMENT;
		      
		        maxThresholdSpinnerS.setMinimum(maxThresh);
		        minThresholdSpinnerS.setMaximum(minThresh);  
		      }
		    });// maxThresholdSpinnerS
		
	} // createContents
	
	/**
	 * creates the dataAverageRadioButtons and their composite container
	 * @param control
	 * @return the composite
	 */
	Composite getDataAvgRadioButtonsComposite(EstimatorControl control) {
		Composite radioComposite = new Composite(control, SWT.BORDER);
	    FillLayout fillLayout = new FillLayout();
	    fillLayout.type = SWT.VERTICAL;
	    radioComposite.setLayout(fillLayout);
	    
	    dataAverageRadioButtons[0] = new Button(radioComposite, SWT.RADIO);
	    dataAverageRadioButtons[0].setSelection(true);
	    dataAverageRadioButtons[0].setText(Messages.getString("EST.CHOICE1"));
	    dataAverageRadioButtons[0].setBounds(10, 5, 75, 30);

	    dataAverageRadioButtons[1] = new Button(radioComposite, SWT.RADIO);
	    dataAverageRadioButtons[1].setText(Messages.getString("EST.CHOICE2"));
	    dataAverageRadioButtons[1].setBounds(10, 30, 75, 30);
	    	    
	    return radioComposite;
	}//getDataAvgRadioButtonsComposite
	

	/**
	 * creates the betaModeRadioButtons and their composite container
	 * @param control
	 * @return the composite
	 */
	Composite getbetaModeRadioButtonsComposite(EstimatorControl control) {
		Composite radioComposite = new Composite(control, SWT.BORDER);
	    FillLayout fillLayout = new FillLayout();
	    fillLayout.type = SWT.VERTICAL;
	    radioComposite.setLayout(fillLayout);
	    
	    betaModeRadioButtons[0] = new Button(radioComposite, SWT.RADIO);
	    betaModeRadioButtons[0].setSelection(true);
	    betaModeRadioButtons[0].setText(Messages.getString("EST.FREQBETA"));
	    betaModeRadioButtons[0].setBounds(10, 5, 75, 30);

	    betaModeRadioButtons[1] = new Button(radioComposite, SWT.RADIO);
	    betaModeRadioButtons[1].setText(Messages.getString("EST.DENSITYBETA"));
	    betaModeRadioButtons[1].setBounds(10, 30, 75, 30);
	    return radioComposite;
	}//getbetaModeRadioButtonsComposite
	
	
	
	/**
	 * creates the regionSelector combo box and its composite container
	 * @param control
	 * @return the composite
	 */
	Composite getRegionSelectorComboComposite(EstimatorControl control) {
		Composite comboComposite = new Composite(control, SWT.BORDER);
	    FillLayout fillLayout = new FillLayout();
	    fillLayout.type = SWT.VERTICAL;
	    comboComposite.setLayout(fillLayout);
	    
		displayRegionCombo = new Combo (comboComposite, SWT.READ_ONLY);
		displayRegionCombo.setItems (new String [] { Messages.getString("EST.AVERAGE") });
		displayRegionCombo.setSize (200, 200);
		displayRegionCombo.pack();
	   
		Label comboLabel = new Label(comboComposite, SWT.NONE);
	    comboLabel.setText(Messages.getString("EST.DISPLAY"));
	    
	    displayRegionCombo.addSelectionListener(new SelectionAdapter() {
	    	      public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {
	    	    	  regionToDisplay = displayRegionCombo.getText();
	    	    	  updateCharts();
	    	      }
	    	    });
	

		
	    return comboComposite;
	}//getbetaModeRadioButtonsComposite
	
	
	/**
	 * update the graphs
	 */
	protected static void updateCharts() {
		statusLabel.setText(Messages.getString("EST.COMPLETE"));
		estimatorCanvas.draw(averageParms.getParameters());
		
		int numDataCharts = analyzer.getEstimator().getNumProperties();
		for (int i = 0; i < numDataCharts; i++) {
			// tell the canvas to the the data from this control
			// the control gets it from the analyzer which gets it form the
			// estimators
			equationSeries[i].draw();
			regressionSeries[i].draw();
		}
		
	}
	
	
	

	
	/**
	 * creates the spinners for the min and max threshold settings and their composite container
	 * @param control
	 * @return the composite
	 */
	Composite getSpinnerComposite(EstimatorControl control) {
		Composite spinnerComposite = new Composite(control, SWT.BORDER);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 8;
	    spinnerComposite.setLayout(gridLayout);
	    
	    // max S
	    maxThresholdSpinnerS = new Spinner(spinnerComposite, SWT.NONE);
	    maxThresholdSpinnerS.setDigits(3); 		// allow 3 decimal places
	    maxThresholdSpinnerS.setMinimum(1);		// set the minimum value to 0.001
	    maxThresholdSpinnerS.setMaximum(SPINNER_RESOLUTION);	// set the maximum value to 1.0
	    maxThresholdSpinnerS.setIncrement(1);	// set the increment value to 0.001
	    maxThresholdSpinnerS.setSelection(990);	// set the initial value 0.990
	    maxSpinnerLabelS = new Label(spinnerComposite, SWT.NONE);
	    maxSpinnerLabelS.setText(Messages.getString("EST.MAXTHRESHOLDS"));
	    // max E
	    maxThresholdSpinnerE = new Spinner(spinnerComposite, SWT.NONE);
	    maxThresholdSpinnerE.setDigits(3); 		// allow 3 decimal places
	    maxThresholdSpinnerE.setMinimum(1);		// set the minimum value to 0.001
	    maxThresholdSpinnerE.setMaximum(SPINNER_RESOLUTION);	// set the maximum value to 1.0
	    maxThresholdSpinnerE.setIncrement(1);	// set the increment value to 0.001
	    maxThresholdSpinnerE.setSelection(SPINNER_RESOLUTION);	// set the initial value 0.990
	    maxSpinnerLabelE = new Label(spinnerComposite, SWT.NONE);
	    maxSpinnerLabelE.setText(Messages.getString("EST.MAXTHRESHOLDE"));
	    // max I
	    maxThresholdSpinnerI = new Spinner(spinnerComposite, SWT.NONE);
	    maxThresholdSpinnerI.setDigits(3); 		// allow 3 decimal places
	    maxThresholdSpinnerI.setMinimum(1);		// set the minimum value to 0.001
	    maxThresholdSpinnerI.setMaximum(SPINNER_RESOLUTION);	// set the maximum value to 1.0
	    maxThresholdSpinnerI.setIncrement(1);	// set the increment value to 0.001
	    maxThresholdSpinnerI.setSelection(SPINNER_RESOLUTION);	// set the initial value 0.990
	    maxSpinnerLabelI = new Label(spinnerComposite, SWT.NONE);
	    maxSpinnerLabelI.setText(Messages.getString("EST.MAXTHRESHOLDI"));
	    // max R
	    maxThresholdSpinnerR = new Spinner(spinnerComposite, SWT.NONE);
	    maxThresholdSpinnerR.setDigits(3); 		// allow 3 decimal places
	    maxThresholdSpinnerR.setMinimum(1);		// set the minimum value to 0.001
	    maxThresholdSpinnerR.setMaximum(SPINNER_RESOLUTION);	// set the maximum value to 1.0
	    maxThresholdSpinnerR.setIncrement(1);	// set the increment value to 0.001
	    maxThresholdSpinnerR.setSelection(990);	// set the initial value 0.990
	    maxSpinnerLabelR = new Label(spinnerComposite, SWT.NONE);
	    maxSpinnerLabelR.setText(Messages.getString("EST.MAXTHRESHOLDR"));
	    
	    // min S
	    minThresholdSpinnerS = new Spinner(spinnerComposite, SWT.NONE);
	    minThresholdSpinnerS.setDigits(3); 		// allow 3 decimal places
	    minThresholdSpinnerS.setMinimum(1);		// set the minimum value to 0.001
	    minThresholdSpinnerS.setMaximum(SPINNER_RESOLUTION);	// set the maximum value to 1.0
	    minThresholdSpinnerS.setIncrement(SPINNER_INCREMENT);	// set the increment value to 0.001
	    minThresholdSpinnerS.setSelection(10);	// set the initial value 0.001
	    minSpinnerLabelS = new Label(spinnerComposite, SWT.NONE);
	    minSpinnerLabelS.setText(Messages.getString("EST.MINTHRESHOLDS"));
	    // min E
	    minThresholdSpinnerE = new Spinner(spinnerComposite, SWT.NONE);
	    minThresholdSpinnerE.setDigits(3); 		// allow 3 decimal places
	    minThresholdSpinnerE.setMinimum(1);		// set the minimum value to 0.001
	    minThresholdSpinnerE.setMaximum(SPINNER_RESOLUTION);	// set the maximum value to 1.0
	    minThresholdSpinnerE.setIncrement(SPINNER_INCREMENT);	// set the increment value to 0.001
	    minThresholdSpinnerE.setSelection(100);	// set the initial value 0.001
	    minSpinnerLabelE = new Label(spinnerComposite, SWT.NONE);
	    minSpinnerLabelE.setText(Messages.getString("EST.MINTHRESHOLDE"));  
	    // min I
	    minThresholdSpinnerI = new Spinner(spinnerComposite, SWT.NONE);
	    minThresholdSpinnerI.setDigits(3); 		// allow 3 decimal places
	    minThresholdSpinnerI.setMinimum(1);		// set the minimum value to 0.001
	    minThresholdSpinnerI.setMaximum(SPINNER_RESOLUTION);	// set the maximum value to 1.0
	    minThresholdSpinnerI.setIncrement(SPINNER_INCREMENT);	// set the increment value to 0.001
	    minThresholdSpinnerI.setSelection(100);	// set the initial value 0.001
	    minSpinnerLabelI = new Label(spinnerComposite, SWT.NONE);
	    minSpinnerLabelI.setText(Messages.getString("EST.MINTHRESHOLDI"));
	    // min R
	    minThresholdSpinnerR = new Spinner(spinnerComposite, SWT.NONE);
	    minThresholdSpinnerR.setDigits(3); 		// allow 3 decimal places
	    minThresholdSpinnerR.setMinimum(1);		// set the minimum value to 0.001
	    minThresholdSpinnerR.setMaximum(SPINNER_RESOLUTION);	// set the maximum value to 1.0
	    minThresholdSpinnerR.setIncrement(SPINNER_INCREMENT);	// set the increment value to 0.001
	    minThresholdSpinnerR.setSelection(1);	// set the initial value 0.001
	    minSpinnerLabelR = new Label(spinnerComposite, SWT.NONE);
	    minSpinnerLabelR.setText(Messages.getString("EST.MINTHRESHOLDR"));
	    
	    spinnerComposite.pack();
	    
	    return spinnerComposite;
	}//getSpinnerCompositer
	
	
	/**
	 * set up the four data time series charts
	 * @param dataComposite
	 */
	private void getEquationSeriesCharts(Composite dataComposite) {
		// S
 		equationSeries[0] = new TimeSeriesCanvas(this,dataComposite,
				Messages.getString("EST.EQUATION1"),
				Messages.getString("EST.AXISLABEL1"),
				AggregateDataWriter.getKeyS(),// equation 1 always has S
				foreGround,
				backgroundGround,
				frameColor, 0, true);
		final FormData eqOneFormData = new FormData();
		equationSeries[0].setLayoutData(eqOneFormData);
		eqOneFormData.top = new FormAttachment(dataComposite, 0);
		eqOneFormData.bottom = new FormAttachment(50, 0);
		eqOneFormData.left = new FormAttachment(0, 0);
		eqOneFormData.right = new FormAttachment(50, 0);
		
		// I
		equationSeries[1] = new TimeSeriesCanvas(this,dataComposite,
				Messages.getString("EST.EQUATION3"),
				Messages.getString("EST.AXISLABEL3"),
				AggregateDataWriter.getKeyI(),// equation 3 always has I
				foreGround,
				backgroundGround,
				frameColor, 1, true);
		final FormData eqThreeFormData = new FormData();
		equationSeries[1].setLayoutData(eqThreeFormData);
		eqThreeFormData.top = new FormAttachment(51, 0);
		eqThreeFormData.bottom = new FormAttachment(100, 0);
		eqThreeFormData.left = new FormAttachment(0, 0);
		eqThreeFormData.right = new FormAttachment(50, 0);
		
		// R
		equationSeries[2] = new TimeSeriesCanvas(this,dataComposite,
				Messages.getString("EST.EQUATION4"),
				Messages.getString("EST.AXISLABEL4"),
				AggregateDataWriter.getKeyR(),// equation 4 always has R
				foreGround,
				backgroundGround,
				frameColor, 2, true);
		final FormData eqFourFormData = new FormData();
		equationSeries[2].setLayoutData(eqFourFormData);
		eqFourFormData.top = new FormAttachment(51, 0);
		eqFourFormData.bottom = new FormAttachment(100, 0);
		eqFourFormData.left = new FormAttachment(51, 0);
		eqFourFormData.right = new FormAttachment(100, 0);
		
		// E
		equationSeries[3] = new TimeSeriesCanvas(this,dataComposite,
				Messages.getString("EST.EQUATION2"),
				Messages.getString("EST.AXISLABEL2"),
				AggregateDataWriter.getKeyE(),// equation 2 always has E
				foreGround,
				backgroundGround,
				frameColor, 3, true);
		final FormData eqTwoFormData = new FormData();
		equationSeries[3].setLayoutData(eqTwoFormData);
		eqTwoFormData.top = new FormAttachment(dataComposite, 0);
		eqTwoFormData.bottom = new FormAttachment(50, 0);
		eqTwoFormData.left = new FormAttachment(51, 0);
		eqTwoFormData.right = new FormAttachment(100, 0);
	}// getEquationSeries
	
	
	
	
	
	/**
	 * set up the four regression XYseries charts
	 * @param regressionComposite
	 */
	private void getRegressionSeriesCharts(Composite regressionComposite) {
		// Equation 1 from dS/dT
 		regressionSeries[0] = new XYSeriesCanvas(this,regressionComposite,
				Messages.getString("EST.EQUATION1"),
				Messages.getString("EST.RAXISLABEL1"),
				foreGround,
				backgroundGround,
				frameColor, 0);
		final FormData eqOneFormData = new FormData();
		regressionSeries[0].setLayoutData(eqOneFormData);
		eqOneFormData.top = new FormAttachment(regressionComposite, 0);
		eqOneFormData.bottom = new FormAttachment(50, 0);
		eqOneFormData.left = new FormAttachment(0, 0);
		eqOneFormData.right = new FormAttachment(50, 0);
		
		// Equation 2 from dI/dT
		regressionSeries[1] = new XYSeriesCanvas(this,regressionComposite,
				Messages.getString("EST.EQUATION3"),
				Messages.getString("EST.RAXISLABEL3"),
				foreGround,
				backgroundGround,
				frameColor, 1);
		final FormData eqThreeFormData = new FormData();
		regressionSeries[1].setLayoutData(eqThreeFormData);
		eqThreeFormData.top = new FormAttachment(51, 0);
		eqThreeFormData.bottom = new FormAttachment(100, 0);
		eqThreeFormData.left = new FormAttachment(0, 0);
		eqThreeFormData.right = new FormAttachment(50, 0);
		
		// Equation 3 from dR/dT
		regressionSeries[2] = new XYSeriesCanvas(this,regressionComposite,
				Messages.getString("EST.EQUATION4"),
				Messages.getString("EST.RAXISLABEL4"),
				foreGround,
				backgroundGround,
				frameColor, 2);
		final FormData eqFourFormData = new FormData();
		regressionSeries[2].setLayoutData(eqFourFormData);
		eqFourFormData.top = new FormAttachment(51, 0);
		eqFourFormData.bottom = new FormAttachment(100, 0);
		eqFourFormData.left = new FormAttachment(51, 0);
		eqFourFormData.right = new FormAttachment(100, 0);
		
		// Equation 4 from dE/dT
		regressionSeries[3] = new XYSeriesCanvas(this,regressionComposite,
				Messages.getString("EST.EQUATION2"),
				Messages.getString("EST.RAXISLABEL2"),
				foreGround,
				backgroundGround,
				frameColor, 3);
		final FormData eqTwoFormData = new FormData();
		regressionSeries[3].setLayoutData(eqTwoFormData);
		eqTwoFormData.top = new FormAttachment(regressionComposite, 0);
		eqTwoFormData.bottom = new FormAttachment(50, 0);
		eqTwoFormData.left = new FormAttachment(51, 0);
		eqTwoFormData.right = new FormAttachment(100, 0);
	}// get regression series composite
	
	
	/**
	 * Enable or disable the analysis button
	 * 
	 * @param b
	 */
	public void enableAnalysis(boolean b) {
		if(b) this.analyzeButton.setEnabled(true);
		else this.analyzeButton.setEnabled(false);
	}
	
	
	/**
	 * to remove the control e.g. by a remove button event
	 */
	public void remove() {
		
		updateStatusLabel();
	}

	
	

	protected void updateStatusLabel() {
		statusLabel.setText(AnalysisControl.STATUS_TEXT);
	}
	

	/**
	 * Initialize the header label
	 * 
	 * @param folderName
	 */
	protected void initializeHeader(String folderName) {
		simulationNameLabel.setText("analyzing "+folderName);

	} // initializeFromSimulation


	
	
	

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
						
		super.dispose();
		
	} // dispose

	
	/**
	 * not used
	 * @return null
	 */
	public Identifiable getIdentifiable() {
		return null;
	}

	

	/**
	 * get the value for plotting
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#getValues(int, int)
	 */
	public double[] getValues(int chartIndex, int state) {
		if (state <= 1) {
			return averageParms.getDataValues(regionToDisplay, chartIndex, state);
		} else if (state <=3) {
			return averageParms.getRegressionValues(regionToDisplay, chartIndex, state-2);
		} else {
			return averageParms.getFittedValues(regionToDisplay, chartIndex, state-4);
		}
		
		
		//return analyzer.getEstimator().getValues(chartIndex, state);
	}
	
	/**
	 * Not used
	 * @param chartIndex not used (only one chart)
	 * @param state
	 * @return property name
	 */
	public String getProperty(int chartIndex, int state) {
		return analyzer.getEstimator().getProperty(chartIndex, state);
	}
	
	/**
	 * @return the max  S value threshold from the spinner as a double
	 */
	public double getMaxThresholdS() {
		double selection = maxThresholdSpinnerS.getSelection();// really an int
		double res = SPINNER_RESOLUTION; // 1000 means 3 decimal places
		return selection/res;
	}
	/**
	 * @return the min S value threshold from the spinner as a double
	 */
	public double getMinThresholdS() {
		double selection = minThresholdSpinnerS.getSelection();// really an int
		double res = SPINNER_RESOLUTION; // 1000 means 3 decimal places
		return selection/res;
	}
	
	/**
	 * @return the max  E value threshold from the spinner as a double
	 */
	public double getMaxThresholdE() {
		double selection = maxThresholdSpinnerE.getSelection();// really an int
		double res = SPINNER_RESOLUTION; // 1000 means 3 decimal places
		return selection/res;
	}
	/**
	 * @return the min E value threshold from the spinner as a double
	 */
	public double getMinThresholdE() {
		double selection = minThresholdSpinnerE.getSelection();// really an int
		double res = SPINNER_RESOLUTION; // 1000 means 3 decimal places
		return selection/res;
	}
	
	/**
	 * @return the max  I value threshold from the spinner as a double
	 */
	public double getMaxThresholdI() {
		double selection = maxThresholdSpinnerI.getSelection();// really an int
		double res = SPINNER_RESOLUTION; // 1000 means 3 decimal places
		return selection/res;
	}
	/**
	 * @return the min I value threshold from the spinner as a double
	 */
	public double getMinThresholdI() {
		double selection = minThresholdSpinnerI.getSelection();// really an int
		double res = SPINNER_RESOLUTION; // 1000 means 3 decimal places
		return selection/res;
	}
	
	/**
	 * @return the max  R value threshold from the spinner as a double
	 */
	public double getMaxThresholdR() {
		double selection = maxThresholdSpinnerR.getSelection();// really an int
		double res = SPINNER_RESOLUTION; // 1000 means 3 decimal places
		return selection/res;
	}
	/**
	 * @return the min R value threshold from the spinner as a double
	 */
	public double getMinThresholdR() {
		double selection = minThresholdSpinnerR.getSelection();// really an int
		double res = SPINNER_RESOLUTION; // 1000 means 3 decimal places
		return selection/res;
	}
	
	/**
	 * Not used
	 * @param chartIndex not used (only one chart)
	 * @return the number of properties, only one
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#getNumProperties(int chartIndex)
	 */
	public int getNumProperties(int chartIndex) {
		if(analyzer!=null) {
			// we always return 2 because we chart the variable along with the selected range...
			// so 2 per chart S, Sselected, or I, Iselected, etc.
			return 2;
		}
		return 0;
	}
	
	/**
	 * Each Control class may add objects to this map
	 * @return the control parameters maps
	 */
	public Map<String, Object> getControlParametersMap() {
		// add nothing for now
		controlParametersMap.put(MIN_S_KEY, new Double(getMinThresholdS()));
		controlParametersMap.put(MIN_E_KEY, new Double(getMinThresholdE()));
		controlParametersMap.put(MIN_I_KEY, new Double(getMinThresholdI()));
		controlParametersMap.put(MIN_R_KEY, new Double(getMinThresholdR()));
		
		controlParametersMap.put(MAX_S_KEY, new Double(getMaxThresholdS()));
		controlParametersMap.put(MAX_E_KEY, new Double(getMaxThresholdE()));
		controlParametersMap.put(MAX_I_KEY, new Double(getMaxThresholdI()));
		controlParametersMap.put(MAX_R_KEY, new Double(getMaxThresholdR()));
		
		boolean sumAllLocations = dataAverageRadioButtons[1].getSelection();
		boolean freqDependantBetaMode = betaModeRadioButtons[0].getSelection();
		
		controlParametersMap.put(SUM_LOCATIONS_KEY, Boolean.valueOf(sumAllLocations));
		controlParametersMap.put(FREQ_MODE_KEY, Boolean.valueOf(freqDependantBetaMode));
		
		
		
		return controlParametersMap;
	}

	

} // EstimatorControl
