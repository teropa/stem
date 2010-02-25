// AutoExpControl.java
package org.eclipse.stem.analysis.automaticexperiment.views;

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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.stem.analysis.ErrorResult;
import org.eclipse.stem.analysis.automaticexperiment.ALGORITHM_STATUS;
import org.eclipse.stem.analysis.automaticexperiment.AutomaticExperimentManager;
import org.eclipse.stem.analysis.automaticexperiment.AutomaticExperimentManagerEvent;
import org.eclipse.stem.analysis.automaticexperiment.AutomaticExperimentManagerListener;
import org.eclipse.stem.analysis.automaticexperiment.ErrorAnalysisAlgorithm;
import org.eclipse.stem.analysis.automaticexperiment.ErrorAnalysisAlgorithmEvent;
import org.eclipse.stem.analysis.automaticexperiment.ErrorAnalysisAlgorithmListener;
import org.eclipse.stem.analysis.automaticexperiment.MANAGER_STATUS;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.jobs.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

/**
 * This class is a SWT GUI component that uses BIRT to plot
 */
public class AutoExpControl extends AnalysisControl {
	
	
	private static Display display = null;
	
	/**
	 * Input text field for the scenario folder of data to use in making the estimation
	 */
	public static Text text1;
	
	/**
	 * Folder to contain the data
	 * 
	 */
	static TabFolder tabFolder;
	
	/**
	 * Text displaying the currently selected parameter estimator
	 */
	
	
	/**
	 * A label to report status (not yet used)
	 */
	static Label statusLabel;
	
	
	/**
	 * Colors for the time series chart
	 */
	static final ColorDefinition foreGround = ColorDefinitionImpl.create(180, 0, 0);
	static final ColorDefinition backgroundGround = ColorDefinitionImpl.create(255, 255, 225);
	static final ColorDefinition frameColor = ColorDefinitionImpl.WHITE();
	
	/**
	 * For now we will always set Two charts
	 */
	//protected static TimeSeriesCanvas[] equationSeries = new TimeSeriesCanvas[4];
	
	protected static TimeSeriesCanvas errorConvergenceByRun = null;
	
	protected static TimeSeriesCanvas currentErrorByTime = null;
	
	protected static Composite chartComposite;
	protected static Composite valuesComposite;
	
	private static List<Double> latestTimeSeries = new ArrayList<Double>();
	private static double[] latestSeries;
	private static double[] errorHistory;
	
	/**
	 * The dialog for the wizard
	 */
	static WizardDialog wizardDialog;	
	
	//PropertySelector propertySelector;
	List<ItemPropertyDescriptor> selectedProperties;

	/**
	 * 
	 * @param parent
	 */
	public AutoExpControl(final Composite parent) {
		super(parent, SWT.None);
		createContents();
	} // AutoExpControl
	
	

	/**
	 * Create the contents of the plotter
	 */
	void createContents() {
		
		AutomaticExperimentManager manager = AutomaticExperimentManager.getInstance();
		manager.addListener(new AutomaticExperimentManagerListener() {
			
			@Override
			public void eventReceived(AutomaticExperimentManagerEvent evt) {
				if(evt.status == MANAGER_STATUS.SCHEDULED) {
					ErrorAnalysisAlgorithm alg = evt.algorithm;
					
					alg.addListener(new ErrorAnalysisAlgorithmListener() {
						
						@Override
						public void eventReceived(ErrorAnalysisAlgorithmEvent evt) {
							if(evt.status == ALGORITHM_STATUS.FINISHED_ALGORITHM) {
								// The algorithm has finished. Smallest value in 
								//evt.result
								/////////////////
								
							} else if(evt.status == ALGORITHM_STATUS.FINISHED_SIMULATION) {
								// One simulation is done. The result is READY and stored in evt.result
								System.out.println("Event result is ready !!! ");
								ErrorResult result = evt.result;
								if(result != null) {
									// Plot 1 from result.getError() (keep appending)
									appendLatestSeriesData(result.getError());
									// Plot 2 from result.getErrorByTimestep() (same as we show in scenario comparison view)
									setErrorHistory(result.getErrorByTimeStep() );
									
									////////////////////////////////////////////////////////////////////////
									// The event notification doesn't come from the UI thread so we need to
									// add a Runnable to the UI thread's execution queue to give the new
									// source to the chart
									final Display display = Display.getDefault();
									if (!display.isDisposed()) {
										// Yes
										try {
											display.asyncExec(new Runnable() {
												public void run() {
													
													updateCharts();
													
												} // run
											}); // display.asyncExec
										} // try
										catch (final Exception e) {
											// Ignore there could be a race condition with the display being
											// disposed when the system is shut down with a running
											// simulation.
										} // catch Exception
									} // if (!display.isDisposed()) 
								}// if(result != null)
							} else if(evt.status == ALGORITHM_STATUS.RESTARTED_ALGORITHM) {
								// The algorithm has restarted. Smallest value in 
								// evt.result
							}
						}
					});
				}
			}
		});
		
		// Use form layout
		setLayout(new FormLayout());
		if(display==null) display = this.getDisplay();
		
		identifiableTitle = new Label(this, SWT.NONE);
		identifiableTitle.setText(Messages.getString("AUTO.TITLELABEL"));
		
		
		int bottom = 5;
		final FormData titleFormData = new FormData();
		identifiableTitle.setLayoutData(titleFormData);
		titleFormData.top = new FormAttachment(0, 0);
		titleFormData.bottom = new FormAttachment(bottom, 0);
		titleFormData.left = new FormAttachment(0, 0);
		titleFormData.right = new FormAttachment(100, 0);
		
		Color labelBackground = new Color(display, new RGB(180, 180, 200));
		
		bottom += 1;
		
		
		tabFolder = new TabFolder (this, SWT.NONE);
		final FormData tabFormData = new FormData();
		tabFormData.top = new FormAttachment(bottom, 0);
		tabFormData.bottom = new FormAttachment(100, 0);
		tabFormData.left = new FormAttachment(0, 0);
		tabFormData.right = new FormAttachment(100, 0);
		tabFolder.setLayoutData(tabFormData);
		
        /////////////
		// charts
		TabItem item0 = new TabItem (tabFolder, SWT.NULL);
		item0.setText (Messages.getString("AUTO.CHARTS"));
		chartComposite = new Composite(tabFolder, SWT.BORDER);
    	GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
 		chartComposite.setLayout(new FormLayout());
 		item0.setControl(chartComposite);
 		// set up the four data time series inside the chartComposite
 		getEquationSeriesCharts(chartComposite); 
 		
 		
 		//////////////
 		// values
		TabItem item1 = new TabItem(tabFolder, SWT.BORDER);
		item1.setText(Messages.getString("AUTO.VALUES"));
		
		valuesComposite = new Composite(tabFolder, SWT.BORDER);
//		valuesComposite.setLayout(new FormLayout());
//		
//		Label valueLabel = new Label(valuesComposite, SWT.NONE);
//		valueLabel.setText("...testing");
//		final FormData valuesFormData = new FormData();
//		valuesFormData.top = new FormAttachment(0, 0);
//		valuesFormData.bottom = new FormAttachment(6, 0);
//		valuesFormData.left = new FormAttachment(40, 0);
//		valuesFormData.right = new FormAttachment(100, 0);
//		valueLabel.setLayoutData(valuesFormData);
//		
// 		item1.setControl(valuesComposite);
 		 
		List<String> testNames = makeTestLabels("Name", 13);
		List<String> testValues = makeTestLabels("Value", 13);
 		updateValueLabels(testNames, testValues);
		
		item1.setControl(valuesComposite);
		
		
		//mainComposite.setControl(estimatorCanvas);
		updateCharts();
		
		
		
		
		
		
	} // createContents
	
	


	

	
	
	/**
	 * update the graphs
	 */
	public static void updateCharts() {
		//statusLabel.setText(Messages.getString("AUTO.COMPLETE"));
		//estimatorCanvas.draw();
		
		errorConvergenceByRun.draw();
		currentErrorByTime.draw();
		
	}
	
	
	

	
	
	
	/**
	 * set up the four data time series charts
	 * @param dataComposite
	 */
	private void getEquationSeriesCharts(Composite dataComposite) {
		
		// errorConvergenceByRun
		errorConvergenceByRun = new TimeSeriesCanvas(this,dataComposite,
				Messages.getString("AUTO.TITLE1"),
				Messages.getString("AUTO.ERROR"), // yaxis
				Messages.getString("AUTO.RUN"),// x axis
				foreGround,
				backgroundGround,
				frameColor, 0, true);
		final FormData TimeSeries1FormData = new FormData();
		errorConvergenceByRun.setLayoutData(TimeSeries1FormData);
		TimeSeries1FormData.top = new FormAttachment(dataComposite, 0);
		TimeSeries1FormData.bottom = new FormAttachment(100, 0);
		TimeSeries1FormData.left = new FormAttachment(0, 0);
		TimeSeries1FormData.right = new FormAttachment(50, 0);
		
		// currentErrorByTime
		currentErrorByTime = new TimeSeriesCanvas(this,dataComposite,
				Messages.getString("AUTO.TITLE2"),
				Messages.getString("AUTO.ERROR"),// y axis
				Messages.getString("AUTO.TIME"),// x axis
				foreGround,
				backgroundGround,
				frameColor, 1, true);
		final FormData TimeSeries2FormData = new FormData();
		currentErrorByTime.setLayoutData(TimeSeries2FormData);
		TimeSeries2FormData.top = new FormAttachment(dataComposite, 0);
		TimeSeries2FormData.bottom = new FormAttachment(100, 0);
		TimeSeries2FormData.left = new FormAttachment(50, 0);
		TimeSeries2FormData.right = new FormAttachment(100, 0);
		
	
	}// getEquationSeries
	
	
	
	/**
	 * set up the four data time series charts
	 * @param dataComposite
	 */
	protected static void updateValueLabels(List<String> attributes, List<String> values) {
		
		Color bg = display.getSystemColor(SWT.COLOR_WHITE);
		final int maxColumns = 10;
		int numColumns = maxColumns;
		
		int numAttrEntries = attributes.size();
		int numValEntries = values.size();
		if(numValEntries != numAttrEntries) {
			if(numAttrEntries<numValEntries) numAttrEntries = numValEntries;
			Activator.logError("Error, num attributes != num values in AutoExpControl.java", null);
		}
		if(numAttrEntries < numColumns) numColumns = numAttrEntries;
		int numRows = ((numAttrEntries/numColumns) + 1);
				
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = numColumns;
		gridLayout.makeColumnsEqualWidth = true;
		valuesComposite.setLayout(gridLayout); 
		
		int vcount = 0;
		int acount = 0;
		for(int j = 0; j < numRows; j ++) {
			for(int i = 0; i < numColumns; i ++) {
				CLabel lblName = new CLabel(valuesComposite, SWT.BORDER);
				if(acount < numAttrEntries) {
					lblName.setText(attributes.get(acount));
				} else {
					lblName.setText("");
				}
				acount ++;
			}
			for(int i = 0; i < numColumns; i ++) {
				CLabel lblValue = new CLabel(valuesComposite, SWT.BORDER);
				
				if(vcount < numValEntries) {
					lblValue.setText(values.get(vcount));
					lblValue.setBackground(bg);
				} else {
					lblValue.setText("");
				}
				vcount ++;
			}
		}
		
		 
		valuesComposite.layout();
		valuesComposite.pack();
		
	
	}// updateValueLabels
	
	protected static List<String> makeTestLabels(String prefix, int number) {
		List<String> retVal = new ArrayList<String>();
		for(int i = 0; i < number; i ++) {
			String val = prefix+"_"+i;
			retVal.add(val);
		}
		return retVal;
	}
	
	
	
	
	
	/**
	 * to remove the control e.g. by a remove button event
	 */
	public void remove() {
		
		updateStatusLabel();
	}

	
	

	protected void updateStatusLabel() {
		//
	}
	

	/**
	 * Initialize the header label
	 * 
	 * @param folderName
	 */
	protected void initializeHeader(String folderName) {
		//

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
		//System.out.println("chart index = "+chartIndex+"  state= "+state);
		// testing
		int numPoints = 100;
		double[] retVal = new double[numPoints];
		for(int i = 0; i < numPoints; i ++) {
			double dbl = i/100.0;
			retVal[i] = Math.pow(dbl,chartIndex+1); 
		}
		
		if(chartIndex == 0) return latestSeries;
		if(chartIndex == 1) return errorHistory;
		
		// should never happen
		return retVal;
	}
	
	/**
	 * Not used
	 * @param chartIndex not used (only one chart)
	 * @param state
	 * @return property name
	 */
	public String getProperty(int chartIndex, int state) {
		if(chartIndex==0) return Messages.getString("AUTO.TITLE1");
		if(chartIndex==1) return Messages.getString("AUTO.TITLE2");
		return  Messages.getString("AUTO.NOTFOUNDERROR");
	}
	
	
	
	
	
	/**
	 * Not used
	 * @param chartIndex not used (only one chart)
	 * @return the number of properties, only one
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#getNumProperties(int chartIndex)
	 */
	public int getNumProperties(int chartIndex) {
		
		return 0;
	}

	/**
	 * 
	 * @param error
	 */
	public static void appendLatestSeriesData(double error) {
		latestTimeSeries.add(new Double(error));
		latestSeries = new double[latestTimeSeries.size()];
		for(int i = 0; i < latestTimeSeries.size(); i ++) {
			latestSeries[i] = latestTimeSeries.get(i).doubleValue();
		}
	}

	/**
	 * 
	 * @param errorByTimeStep
	 */
	public static void setErrorHistory(EList<Double> errorByTimeStep) {
		errorHistory = new double[errorByTimeStep.size()];
		for(int i = 0; i < errorByTimeStep.size(); i ++) {
			errorHistory[i] = errorByTimeStep.get(i).doubleValue();
		}
		
	}
	
	
	

} // AutoExpControl
