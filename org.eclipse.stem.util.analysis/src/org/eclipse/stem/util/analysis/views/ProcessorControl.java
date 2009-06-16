// ProcessorControl.java
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

import java.io.BufferedReader;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.stem.analysis.ScenarioInitializationException;
import org.eclipse.stem.util.analysis.DataProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * GUI for processing data - reading incidence data from files (file names 
 * keyed by location) and creating the new format CSV files for STEM 
 */
public class ProcessorControl extends AnalysisControl {

	/**
	 * The format of the time in the input files
	 */
	private static final String TIME_FORMAT = "yyyy-MM-dd";
	
	/**
	 * Input text field for the source folder of the raw data
	 */
	protected static Text sourceFolder;

	/**
	 * Input text field for the target folder of the processed data
	 */
	protected static Text targetFolder;

	/**
	 * Input text field for the population data file
	 */
	protected static Text populationDataFile;

	/**
	 * Recovery rate
	 */
	protected static Spinner recoveryRate; 

	/**
	 * Susceptible rate
	 */
	protected static Spinner susceptibleRate;

	/**
	 * Immunity loss rate
	 */
	protected static Spinner immunityLossRate;

	/**
	 * Population size in the start year
	 */
	protected static Spinner populationSizeStartYear;

	/**
	 * Population size in the end year
	 */
	protected static Spinner populationSizeEndYear;
	
	/**
	 * Button to trigger the data processing
	 */
	protected Button processButton;
	
	/**
	 * A label to report status
	 */
	protected static Label statusLabel;

	/**
	 * Start date of the data
	 */
	protected static Date startDate; 

	/**
	 * End date of the data
	 */
	protected static Date endDate;

	/**
	 * @param parent
	 */
	public ProcessorControl(final Composite parent) {

		super(parent, SWT.None);
		createContents();
	
	} // ProcessorControl

	/**
	 * Create the contents of the plotter
	 */
	void createContents() {
	
		final Shell shell = this.getShell();

		setLayout(new FormLayout());

		identifiableTitle = new Label(this, SWT.NONE);
		identifiableTitle.setText(Messages.getString("PROCESSOR.TITLE"));
		Display display = this.getDisplay();
		
		Color labelBackground = new Color(display, new RGB(180, 180, 200));

		// status label
		statusLabel = new Label(this, SWT.BORDER);
		statusLabel.setText("");
		
		// source folder
		Label sourceFolderLabel = new Label(this, SWT.BORDER);
		sourceFolderLabel.setBackground(labelBackground);
		sourceFolderLabel.setText(Messages.getString("PROCESSOR.SOURCEFOLDER"));

		sourceFolder = new Text(this, SWT.BORDER);
		sourceFolder.setBounds(10, 10, 100, 20);
		sourceFolder.setText("");
		sourceFolder.setEditable(false); // can only be selected through dialog
		
	    Button selectSourceFolderButton = new Button(this, SWT.NONE);
	    selectSourceFolderButton.setText(Messages.getString("PROCESSOR.SELECTSOURCEFOLDER"));
		selectSourceFolderButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(@SuppressWarnings("unused") final SelectionEvent e) {
				final DirectoryDialog dd = new DirectoryDialog(shell, SWT.OPEN);
				dd.setText(Messages.getString("PROCESSOR.SELECTSOURCEFOLDEDIALOGTITLE"));
				dd.setFilterPath(sourceFolder.getText());
				final String selected = dd.open();
				sourceFolder.setText(selected);
				if(selected != null && selected.length() != 0) {
					statusLabel.setText(Messages.getString("PROCESSOR.READINGDATA"));
					populationSizeStartYear.setEnabled(false);
					populationSizeEndYear.setEnabled(false);
					initializeDates();
					if(startDate != null && endDate != null) {
						DateFormat format = new SimpleDateFormat(TIME_FORMAT);
						statusLabel.setText("Processing data from " + format.format(startDate) + " to " + format.format(endDate));
						
						// initialize target folder to the source folder
						if (targetFolder.getText() == null || targetFolder.getText().length() == 0) {
							targetFolder.setText(selected);
						}
						
						Calendar startCal = Calendar.getInstance();
						startCal.setTime(startDate);
						Calendar endCal = Calendar.getInstance();
						endCal.setTime(endDate);
						populationSizeStartYear.setEnabled(true);
						if(startCal.get(Calendar.YEAR) < endCal.get(Calendar.YEAR)) {
							populationSizeEndYear.setEnabled(true);
						}
					} else {
						// failed to read data - invalid data
						statusLabel.setText(Messages.getString("PROCESSOR.FAILEDREADDATA"));
						sourceFolder.setText("");
					}
				}
				enableProcessButton();
			}
		});

	    // target folder
		Label targetFolderLabel = new Label(this, SWT.BORDER);
		targetFolderLabel.setBackground(labelBackground);
		targetFolderLabel.setText(Messages.getString("PROCESSOR.TARGETFOLDER"));

		targetFolder = new Text(this, SWT.BORDER);
		targetFolder.setBounds(10, 10, 100, 20);
		targetFolder.setText("");
		targetFolder.setEditable(false); // can only be selected through dialog

		Button selectTargetFolderButton = new Button(this, SWT.NONE);
	    selectTargetFolderButton.setText(Messages.getString("PROCESSOR.SELECTTARGETFOLDER"));
		selectTargetFolderButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(@SuppressWarnings("unused") final SelectionEvent e) {
				final DirectoryDialog dd = new DirectoryDialog(shell, SWT.OPEN);
				dd.setText(Messages.getString("PROCESSOR.SELECTTARGETFOLDEDIALOGTITLE"));
				dd.setFilterPath(targetFolder.getText());
				final String selected = dd.open();
				targetFolder.setText(selected);
				enableProcessButton();
			}
		});

	    // population data file
		Label populationDataFileLabel = new Label(this, SWT.BORDER);
		populationDataFileLabel.setBackground(labelBackground);
		populationDataFileLabel.setText(Messages.getString("PROCESSOR.POPULATIONDATAFILE"));

		populationDataFile = new Text(this, SWT.BORDER);
		populationDataFile.setBounds(10, 10, 100, 20);
		populationDataFile.setText("");
		populationDataFile.setEditable(false); // can only be selected through dialog

		Button selectPopulationDataFileButton = new Button(this, SWT.NONE);
		selectPopulationDataFileButton.setText(Messages.getString("PROCESSOR.SELECTPOPULATIONDATAFILE"));
		selectPopulationDataFileButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(@SuppressWarnings("unused") final SelectionEvent e) {
				final FileDialog fd = new FileDialog(shell, SWT.OPEN);
				fd.setText(Messages.getString("PROCESSOR.SELECTPOPULATIONDATAFILEDIALOGTITLE"));
				fd.setFilterPath(populationDataFile.getText());
				final String selected = fd.open();
				populationDataFile.setText(selected);
				enableProcessButton();
			}
		});

		// parameters
		Label parametersLabel = new Label(this, SWT.BORDER);
		parametersLabel.setBackground(labelBackground);
		parametersLabel.setText(Messages.getString("PROCESSOR.PARAMETERS"));

		Composite spinnerComposite = new Composite(this, SWT.BORDER);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 6;
	    spinnerComposite.setLayout(gridLayout);
		
		// recovery rate
		Label recoveryRateLabel = new Label(spinnerComposite, SWT.NONE);
		recoveryRateLabel.setText(Messages.getString("PROCESSOR.RECOVERYRATE"));

		recoveryRate = new Spinner(spinnerComposite, SWT.NONE);
		recoveryRate.setDigits(2); // allow 2 decimal places
		recoveryRate.setMinimum(0);	// set the minimum value to 0
		recoveryRate.setMaximum(100); // set the maximum value to 1.0
		recoveryRate.setIncrement(1); // set the increment value to 0.01
		recoveryRate.setSelection(20);	// set the initial value 0.2
		recoveryRate.addModifyListener(new ModifyListener() {
			public void modifyText(@SuppressWarnings("unused") final ModifyEvent e) {
				enableProcessButton();
			}
		});

		// susceptible rate
		Label susceptibleRateLabel = new Label(spinnerComposite, SWT.NONE);
		susceptibleRateLabel.setText(Messages.getString("PROCESSOR.SUSCEPTIBLERATE"));

		susceptibleRate = new Spinner(spinnerComposite, SWT.NONE);
		susceptibleRate.setDigits(3); // allow 3 decimal places
		susceptibleRate.setMinimum(0);	// set the minimum value to 0
		susceptibleRate.setMaximum(1000); // set the maximum value to 1.0
		susceptibleRate.setIncrement(1); // set the increment value to 0.001
		susceptibleRate.setSelection(333);	// set the initial value 0.001
		susceptibleRate.addModifyListener(new ModifyListener() {
			public void modifyText(@SuppressWarnings("unused") final ModifyEvent e) {
				enableProcessButton();
			}
		});

		// immunity loss rate
		Label immunityLossRateLabel = new Label(spinnerComposite, SWT.NONE);
		immunityLossRateLabel.setText(Messages.getString("PROCESSOR.IMMUNITYLOSSRATE"));

		immunityLossRate = new Spinner(spinnerComposite, SWT.NONE);
		immunityLossRate.setDigits(4); // allow 4 decimal places
		immunityLossRate.setMinimum(0);	// set the minimum value to 0
		immunityLossRate.setMaximum(10000); // set the maximum value to 1.0
		immunityLossRate.setIncrement(1); // set the increment value to 0.0001
		immunityLossRate.setSelection(9);	// set the initial value 0.0009
		immunityLossRate.addModifyListener(new ModifyListener() {
			public void modifyText(@SuppressWarnings("unused") final ModifyEvent e) {
				enableProcessButton();
			}
		});

		spinnerComposite.pack();

		// population size
		Label populationSizeLabel = new Label(this, SWT.BORDER);
		populationSizeLabel.setBackground(labelBackground);
		populationSizeLabel.setText(Messages.getString("PROCESSOR.POPULATIONSIZE"));

		Composite sizeComposite = new Composite(this, SWT.BORDER);
		gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
	    sizeComposite.setLayout(gridLayout);

		// start year
		Label populationSizeStartYearLabel = new Label(sizeComposite, SWT.NONE);
		populationSizeStartYearLabel.setText(Messages.getString("PROCESSOR.STARTYEAR"));

		populationSizeStartYear = new Spinner(sizeComposite, SWT.NONE);
		populationSizeStartYear.setDigits(0); // allow 0 decimal places
		populationSizeStartYear.setMinimum(0);	// set the minimum value to 0
		populationSizeStartYear.setMaximum(100000000); // set the maximum value to 100,000,000
		populationSizeStartYear.setIncrement(1000); // set the increment value to 1000
		populationSizeStartYear.setSelection(10000000);	// set the initial value 10,000,000
		populationSizeStartYear.setEnabled(false);
		populationSizeStartYear.addModifyListener(new ModifyListener() {
			public void modifyText(@SuppressWarnings("unused") final ModifyEvent e) {
				enableProcessButton();
			}
		});

		// end year
		Label populationSizeEndYearLabel = new Label(sizeComposite, SWT.NONE);
		populationSizeEndYearLabel.setText(Messages.getString("PROCESSOR.ENDYEAR"));

		populationSizeEndYear = new Spinner(sizeComposite, SWT.NONE);
		populationSizeEndYear.setDigits(0); // allow 0 decimal places
		populationSizeEndYear.setMinimum(0);	// set the minimum value to 0
		populationSizeEndYear.setMaximum(100000000); // set the maximum value to 100,000,000
		populationSizeEndYear.setIncrement(1000); // set the increment value to 1000
		populationSizeEndYear.setSelection(10000000);	// set the initial value 10,000,000
		populationSizeEndYear.setEnabled(false);
		populationSizeEndYear.addModifyListener(new ModifyListener() {
			public void modifyText(@SuppressWarnings("unused") final ModifyEvent e) {
				enableProcessButton();
			}
		});

		sizeComposite.pack();
	    
		// process button
		processButton = new Button(this, SWT.NONE);
		processButton.setText(Messages.getString("PROCESSOR.PROCESS"));
		processButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(@SuppressWarnings("unused") final SelectionEvent e) {
				try {
					DataProcessor processor = new DataProcessor();
					processor.process(
							sourceFolder.getText(), 
							targetFolder.getText(), 
							startDate, 
							endDate, 
							populationDataFile.getText(), 
							Long.parseLong(populationSizeStartYear.getText()), 
							Long.parseLong(populationSizeEndYear.getText()),
							Double.parseDouble(recoveryRate.getText()), 
							Double.parseDouble(susceptibleRate.getText()),
							Double.parseDouble(immunityLossRate.getText()));
					statusLabel.setText(Messages.getString("COMMON.DONE"));
				} catch(ScenarioInitializationException ex) {
					statusLabel.setText(ex.getMessage());
				}
			}
		});
		enableProcessButton();

		createFormData(null, identifiableTitle, null, null, 5);
		createFormData(identifiableTitle, sourceFolderLabel, sourceFolder, selectSourceFolderButton, 10);
		createFormData(sourceFolderLabel, targetFolderLabel, targetFolder, selectTargetFolderButton, 15);
		createFormData(targetFolderLabel, populationDataFileLabel, populationDataFile, selectPopulationDataFileButton, 20);
		createFormData(populationDataFileLabel, parametersLabel, spinnerComposite, null, 25);
		createFormData(parametersLabel, populationSizeLabel, sizeComposite, null, 30);
		createFormData(populationSizeLabel, null, null, processButton, 35);
		createFormData(processButton, statusLabel, null, null, 100);

	} // createContents
	
	/**
	 * Enable or disable the process button
	 */
	void enableProcessButton() {
		
		boolean enabled = true;
		if (enabled && (sourceFolder.getText() == null || sourceFolder.getText().length() == 0))
			enabled = false;
		if (enabled && (targetFolder.getText() == null || targetFolder.getText().length() == 0))
			enabled = false;
		if (enabled && (populationDataFile.getText() == null || populationDataFile.getText().length() == 0))
			enabled = false;
		if (enabled && (recoveryRate.getText() == null || recoveryRate.getText().length() == 0))
			enabled = false;
		if (enabled && (susceptibleRate.getText() == null || susceptibleRate.getText().length() == 0))
			enabled = false;
		if (enabled && (immunityLossRate.getText() == null || immunityLossRate.getText().length() == 0))
			enabled = false;
		if (enabled && (populationSizeStartYear.getText() == null || populationSizeStartYear.getText().length() == 0))
			enabled = false;
		if (enabled && (populationSizeEndYear.getText() == null || populationSizeEndYear.getText().length() == 0))
			enabled = false;
		this.processButton.setEnabled(enabled);
	
	} // enableProcessButton
	
	/**
	 * Initializes the start and end dates of the data.
	 */
	protected void initializeDates() {
	
		startDate = null;
		endDate = null;

		File file = new File(sourceFolder.getText());
		
		File[] allFiles = file.listFiles();
		for (int i = 0; i < allFiles.length; i++) {
			String fileName = allFiles[i].getName();
			if (fileName.indexOf(".txt") >= 0) {
				BufferedReader fileReader = DataProcessor.openReader(allFiles[i]);
				if (fileReader != null) {
					try {
						String buffer = null;
						fileReader.readLine(); // skip the header
						while (DataProcessor.EOF(buffer = fileReader.readLine()) != true) {
							StringTokenizer tokenizer = new StringTokenizer(buffer, ","); //$NON-NLS-1$
							if(tokenizer.countTokens() == 3) {
								tokenizer.nextToken(","); // iteration
								String time = tokenizer.nextToken(",");
								tokenizer.nextToken(","); // incidence
								
								if(time!= null) {
									DateFormat format = new SimpleDateFormat(TIME_FORMAT);
									Date date = format.parse(time);
									if(startDate == null || date.before(startDate)) {
										startDate = date;
									}
									if(endDate == null || date.after(endDate)) {
										endDate = date;
									}
								}
							}
						}
					} catch(Exception ex) {
						// ignore
					}
				} // if ! null
			} // if valid filename
		} // for
		
	} // initializeDates

	/**
	 * Constructs a new instance of FormData which contains Label, Control and Button.
	 * 
	 * @param topControl The control at the top of this FormData
	 * @param label The label of this FormData
	 * @param text The control of this FormData
	 * @param button The button of this FormData
	 * @param bottom The percentage of the position of this FormData
	 */
	private void createFormData(Control topControl, Label label, Control text, Button button, int bottom) { 

		// label
		if (label != null) {
			final FormData labelFormData = new FormData();
			if (topControl != null)
				labelFormData.top = new FormAttachment(topControl, 0);
			else
				labelFormData.top = new FormAttachment(0, 0);
			labelFormData.bottom = new FormAttachment(bottom, 0);
			labelFormData.left = new FormAttachment(0, 0);
			int numerator = 15;
			if (text == null && button == null)
				numerator = 100;
			labelFormData.right = new FormAttachment(numerator, 0);
			label.setLayoutData(labelFormData);
		}
		
		// text field
		if (text != null) {
			final FormData textFieldFormData = new FormData();
			if (topControl != null)
				textFieldFormData.top = new FormAttachment(topControl, 0);
			else
				textFieldFormData.top = new FormAttachment(0, 0);
			textFieldFormData.bottom = new FormAttachment(bottom, 0);
			if (label != null)
				textFieldFormData.left = new FormAttachment(label, 0);
			else
				textFieldFormData.left = new FormAttachment(0, 0);
			int numerator = 80;
			if (button == null)
				numerator = 100;
			textFieldFormData.right = new FormAttachment(numerator, 0);
			text.setLayoutData(textFieldFormData);
		}
		
		// selection button
		if (button != null) {
			final FormData buttonFormData = new FormData();		
			if (topControl != null)
				buttonFormData.top = new FormAttachment(topControl, 0);
			else
				buttonFormData.top = new FormAttachment(0, 0);
			buttonFormData.bottom = new FormAttachment(bottom, 0);
			if (text != null)
				buttonFormData.left = new FormAttachment(text, 0);
			else if (label != null)
				buttonFormData.left = new FormAttachment(label, 0);
			else
				buttonFormData.left = new FormAttachment(0, 0);
			buttonFormData.right = new FormAttachment(100, 0);
			button.setLayoutData(buttonFormData);
		}

	} // createFormData
	
	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	} // dispose

	/**
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#remove()
	 */
	public void remove() {
		// do nothing for now
	} // remove

	/**
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#initializeHeader(String)
	 */
	protected void initializeHeader(@SuppressWarnings("unused") String folderName) {
		// do nothing for now
	} // initializeHeader

	/**
	 * Not used
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#getValues(int, int)
	 */
	@Override
	public double[] getValues(@SuppressWarnings("unused")int chartIndex, @SuppressWarnings("unused")int trajectory) {
		return null;
	} // getValues
	
	/**
	 * Not used
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#getProperty(int, int)
	 */
	public String getProperty(@SuppressWarnings("unused") int chartIndex, @SuppressWarnings("unused") int state) {
		return null;
	} // getProperty
	
	/**
	 * Not used
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#getNumProperties(int chartIndex)
	 */
	public int getNumProperties(@SuppressWarnings("unused") int chartIndex) {
		return 0;
	} // getNumProperties

	/**
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#getControlParametersMap()
	 */
	public Map<String, Object> getControlParametersMap() {

		// add nothing for now
		return controlParametersMap;
	} // getControlParametersMap
	
} // ProcessorControl
