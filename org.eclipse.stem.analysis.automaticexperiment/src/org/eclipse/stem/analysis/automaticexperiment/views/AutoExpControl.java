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
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * This class is a SWT GUI component that uses BIRT to plot
 */
public class AutoExpControl extends AnalysisControl {
	
	
	private static Display display = null;
	
	
	/**
	 * Folder to contain the data
	 * 
	 */
	static CTabFolder tabFolder;
	
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
	
	// some colors
	private static Color cyan;
	private static Color cyanDark;
	private static Color darkRed;
	private static Color white;
	private static Color black;
	
	
	
	protected static RunHistoryCanvas errorConvergenceByRun = null;
	static final int ERROR_CONVERGENCE_BY_RUN_ID = 0;
	
	protected static TimeSeriesCanvas currentErrorByTime = null;
	static final int CURRENT_ERROR_BY_TIME_ID = 1;


	private static final int NUMROWS = 10;
	
	//protected static Composite chartComposite;
	protected static Composite timeSeriesComposite;
	protected static Composite runHistoryComposite;
	protected static Composite valuesComposite;
	protected static Composite controlsComposite;
	
	private static List<Double> errorHistoryList = new ArrayList<Double>();
	private static double[] errorHistory;
	private static double[] bestSeries;
	private static double bestError = Double.MAX_VALUE;
	private static double[] newTimeSeries;
	
	protected static String[] runParamNames;
	protected static double[] bestParamValues;
	protected static double[][] recentParamValues;
	protected static double[] recentErrors;
	
	protected static CLabel[] attributeLabels;
	protected static Text[] bestValueLabels;
	protected static Text[][] recentValueLabels;
	
	protected static short row = 0; // which row are we updating
	
	protected static short numColumns = 0;
	protected static boolean firstShift = true;
	
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
				
		// Use form layout
		setLayout(new FormLayout());
		if(display==null) display = this.getDisplay();
		cyan = display.getSystemColor(SWT.COLOR_CYAN);
		cyanDark = new Color(display, 60, 240, 240);
		darkRed = display.getSystemColor(SWT.COLOR_DARK_RED);
		white = display.getSystemColor(SWT.COLOR_WHITE);
		black = display.getSystemColor(SWT.COLOR_BLACK);
		
		
		identifiableTitle = new Label(this, SWT.NONE);
		identifiableTitle.setText(Messages.getString("AUTO.TITLELABEL"));
		
		
		int bottom = 5;
		final FormData titleFormData = new FormData();
		identifiableTitle.setLayoutData(titleFormData);
		titleFormData.top = new FormAttachment(0, 0);
		titleFormData.bottom = new FormAttachment(bottom, 0);
		titleFormData.left = new FormAttachment(0, 0);
		titleFormData.right = new FormAttachment(100, 0);
		
		bottom += 1;
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		// set up the values composite
		valuesComposite = new Composite(tabFolder, SWT.BORDER);
		
		final FormData tabFormData = new FormData();
		tabFormData.top = new FormAttachment(bottom, 0);
		tabFormData.bottom = new FormAttachment(100, 0);
		tabFormData.left = new FormAttachment(0, 0);
		tabFormData.right = new FormAttachment(100, 0);
		tabFolder.setLayoutData(tabFormData);
		tabFolder.setSimple(false);
		
		
		tabFolder.setSelectionBackground(new Color[]{display.getSystemColor(SWT.COLOR_CYAN),
				display.getSystemColor(SWT.COLOR_WHITE),
				cyanDark,
				display.getSystemColor(SWT.COLOR_BLUE)},
				new int[] {25, 50, 100}); 
		
		tabFolder.setBackground(cyanDark);
		tabFolder.setForeground(darkRed);
		tabFolder.setBorderVisible(true);
		
        /////////////
		// RUN HISTORY
		CTabItem item0 = new CTabItem(tabFolder, SWT.BORDER);
		item0.setText ("  "+Messages.getString("AUTO.HISTORY")+" ");
		runHistoryComposite = new Composite(tabFolder, SWT.BORDER);
		runHistoryComposite.setLayout(new FormLayout());
 		item0.setControl(runHistoryComposite);
 		// set up the four data time series inside the chartComposite
 		getRunHistoryChart(runHistoryComposite); 
 		
 		/////////////
		// TIME SERIES
 		CTabItem item1 = new CTabItem(tabFolder, SWT.BORDER);
		item1.setText ("  "+Messages.getString("AUTO.TIMESERIES")+" ");
		timeSeriesComposite = new Composite(tabFolder, SWT.BORDER);
		timeSeriesComposite.setLayout(new FormLayout());
 		item1.setControl(timeSeriesComposite);
 		// set up the four data time series inside the chartComposite
 		getTimeSeriesChart(timeSeriesComposite); 
 		
 		//////////////
 		// VALUES
		CTabItem item2 = new CTabItem(tabFolder, SWT.BORDER);
		item2.setText(Messages.getString("AUTO.VALUES"));
		item2.setControl(valuesComposite);
		
		//////////////
 		// RESTART
		controlsComposite = new Composite(tabFolder, SWT.BORDER);
		controlsComposite.setLayout(new FormLayout());
		CTabItem item3 = new CTabItem(tabFolder, SWT.BORDER);
		item3.setText(Messages.getString("AUTO.RESTART"));
		item3.setControl(controlsComposite);
		Label restartLabel = new Label(controlsComposite, SWT.BORDER);
		restartLabel.setText("Restart Controls Will Go HERE");
		
		
		
		tabFolder.setSelection(item0);
		
		AutomaticExperimentManager manager = AutomaticExperimentManager.getInstance();
		manager.addListener(new AutomaticExperimentManagerListener() {
			
			@Override
			public void eventReceived(AutomaticExperimentManagerEvent evt) {
				if(evt.status == MANAGER_STATUS.SCHEDULED) {
					ErrorAnalysisAlgorithm alg = evt.algorithm;
					alg.addListener(new ErrorAnalysisAlgorithmListener() {
						@Override
						public void eventReceived(ErrorAnalysisAlgorithmEvent evt) {
							
							System.out.println("Event is "+evt.status);
							
							if(evt.status == ALGORITHM_STATUS.STARTING_SIMULATION) {
								// set the label info
								runParamNames = evt.parameterNames;
								if(recentParamValues == null) {
									numColumns = (short)runParamNames.length;
									recentParamValues = new double[NUMROWS][runParamNames.length+1];
									recentErrors = new double[NUMROWS];
								}
								if(row < NUMROWS) {
									recentParamValues[row] = copyDoubleArray(evt.parameterValues);
									recentErrors[row++] = -1; // not known yet
								}
								else {
									// We need to shift up
									for(int i=0;i<NUMROWS-1;++i) {
										for(int j=0;j<runParamNames.length;++j) recentParamValues[i][j] = recentParamValues[i+1][j];
										recentErrors[i]=recentErrors[i+1];
									}
									recentParamValues[row-1] = copyDoubleArray(evt.parameterValues);
									recentErrors[row-1] = -1; // not known yet
								}
								// Add a Runnable to the UI thread's execution queue 
								final Display display = Display.getDefault();
								if (!display.isDisposed()) {
									// Yes
									try {
										display.asyncExec(new Runnable() {
											public void run() {
												if(!valuesInitialized) initializeValueLabels(runParamNames);
												updateValueLabels();
											} // run
										}); // display.asyncExec
									} // try
									catch (final Exception e) {
										// Ignore there could be a race condition with the display being disposed
									} // catch Exception
								} // if (!display.isDisposed()) 
							//////////////////////////////////////
							} else if(evt.status == ALGORITHM_STATUS.FINISHED_ALGORITHM) {
								// The algorithm has finished. Smallest value in 
								//evt.result
								/////////////////
								
							} else if(evt.status == ALGORITHM_STATUS.FINISHED_SIMULATION) {
								// One simulation is done. The result is READY and stored in evt.result
								ErrorResult result = evt.result;
								recentErrors[row-1] = evt.result.getError();
								if(result != null) {
									// Plot 1 from result.getError() (keep appending)
									appendLatestErrorData(result.getError());
									// Plot 2 from result.getErrorByTimestep() (same as we show in scenario comparison view)
									setRecentTimeSeries(result.getError(), result.getErrorByTimeStep() );
									
									if(bestParamValues == null) {
										bestParamValues = copyDoubleArray(recentParamValues[row-1]);
										bestError = result.getError();
									}
									
									////////////////////////////////////////////////////////////////////////
									// Add a Runnable to the UI thread's execution queue 
									final Display display = Display.getDefault();
									if (!display.isDisposed()) {
										// Yes
										try {
											display.asyncExec(new Runnable() {
												public void run() {
													updateCharts();
													updateValueLabels();
												} // run
											}); // display.asyncExec
										} // try
										catch (final Exception e) {
											// Ignore there could be a race condition with the display being disposed
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
		
		updateCharts();
		
	} // createContents
	
	/**
	 * update the graphs
	 */
	public static void updateCharts() {
		errorConvergenceByRun.draw();
		currentErrorByTime.draw();
	}
	
	/**
	 * redraw the graphs
	 */
	public static void redrawCharts() {
		errorConvergenceByRun.redraw();
		currentErrorByTime.redraw();
	}
	
	
	
	/**
	 * set up the time series chart
	 * @param dataComposite
	 */
	private void getTimeSeriesChart(Composite dataComposite) {
				
		// currentErrorByTime
		currentErrorByTime = new TimeSeriesCanvas(this,dataComposite,
				Messages.getString("AUTO.TITLE2"),
				Messages.getString("AUTO.ERROR"),// y axis
				Messages.getString("AUTO.TIME"),// x axis
				Messages.getString("AUTO.TITLE2"), //first property (line series name)
				foreGround,
				backgroundGround,
				frameColor, CURRENT_ERROR_BY_TIME_ID, true);
		final FormData TimeSeries2FormData = new FormData();
		currentErrorByTime.setLayoutData(TimeSeries2FormData);
		TimeSeries2FormData.top = new FormAttachment(dataComposite, 0);
		TimeSeries2FormData.bottom = new FormAttachment(100, 0);
		TimeSeries2FormData.left = new FormAttachment(0, 0);
		TimeSeries2FormData.right = new FormAttachment(100, 0);
		
		currentErrorByTime.redraw();
		
	}// getEquationSeries
	
	
	/**
	 * set up the run history charts
	 * @param dataComposite
	 */
	private void getRunHistoryChart(Composite dataComposite) {
		// errorConvergenceByRun
		errorConvergenceByRun = new RunHistoryCanvas(this,dataComposite,
				Messages.getString("AUTO.TITLE1"),
				Messages.getString("AUTO.ERROR"), // yaxis
				Messages.getString("AUTO.RUN"),// x axis
				Messages.getString("AUTO.TITLE1"), // first propery (line series name)
				foreGround,
				backgroundGround,
				frameColor, ERROR_CONVERGENCE_BY_RUN_ID, true);
		final FormData TimeSeries1FormData = new FormData();
		errorConvergenceByRun.setLayoutData(TimeSeries1FormData);
		TimeSeries1FormData.top = new FormAttachment(dataComposite, 0);
		TimeSeries1FormData.bottom = new FormAttachment(100, 0);
		TimeSeries1FormData.left = new FormAttachment(0, 0);
		TimeSeries1FormData.right = new FormAttachment(100, 0);
		
		errorConvergenceByRun.redraw();
	
	}// getEquationSeries
	
	
	
	/**
	 * set up the four data time series charts
	 * @param dataComposite
	 */
	protected static void updateValueLabels() {
		if(bestParamValues != null) {
			for(int i=0;i<numColumns;++i)
				bestValueLabels[i].setText(bestParamValues[i]+"");
			
			bestValueLabels[numColumns].setText(bestError+"");
		}
		for(int i = 0; i < NUMROWS; ++i) 
			for(int j=0;j<numColumns+1;++j) {
				if(j< numColumns)
					recentValueLabels[i][j].setText(recentParamValues[i][j]+"");
				else if(recentErrors[i]!=-1)
					recentValueLabels[i][j].setText(recentErrors[i]+"");			
				else recentValueLabels[i][j].setText("...");
		}
		
		valuesComposite.redraw();
		valuesComposite.update();
	
	}// updateValueLabels
	
	
	static boolean valuesInitialized = false;
	/**
	 * 
	 * @param attributes
	 * @param initialValues
	 */
	protected static void initializeValueLabels(String[] attributes) {
		
		int numAttrEntries = attributes.length;
		int numColumns = numAttrEntries;

		// Use form layout
		GridLayout gl = new GridLayout();
		gl.numColumns = numColumns+1;
		valuesComposite.setLayout(gl);
		int width = 800/numColumns;
		
		attributeLabels = new CLabel[numColumns+1];
		bestValueLabels = new Text[numColumns+1];
		recentValueLabels = new Text[NUMROWS][numColumns+1];
		
			for(int i = 0; i < numColumns; i ++) {
				attributeLabels[i] = new CLabel(valuesComposite, SWT.BORDER);
				attributeLabels[i].setText(attributes[i]);
				attributeLabels[i].setBackground(cyan);
				final GridData titleGridData = new GridData();
				attributeLabels[i].setLayoutData(titleGridData);
			    titleGridData.grabExcessHorizontalSpace=true;
			    titleGridData.minimumWidth=width;
			}
			attributeLabels[numColumns] = new CLabel(valuesComposite, SWT.BORDER);
			attributeLabels[numColumns].setText("Error");
			attributeLabels[numColumns].setBackground(cyan);
			final GridData titleGridData = new GridData();
			attributeLabels[numColumns].setLayoutData(titleGridData);
		    titleGridData.grabExcessHorizontalSpace=true;
		    titleGridData.minimumWidth=width;
		    titleGridData.horizontalAlignment = GridData.FILL;
			
			for(int i = 0; i < numColumns+1; i ++) {
				bestValueLabels[i] = new Text(valuesComposite, SWT.BORDER);
				bestValueLabels[i].setText(""); // nothing yet
				bestValueLabels[i].setBackground(new Color(null, 255, 128, 128)); //red
				final GridData textGridData = new GridData();
				bestValueLabels[i].setLayoutData(textGridData);
			    textGridData.grabExcessHorizontalSpace=true;
			    textGridData.minimumWidth=width;
			    textGridData.horizontalAlignment = GridData.FILL;
			}
			
			for(int i=0;i<NUMROWS;++i)
				for(int j=0;j<numColumns+1;++j) {
					recentValueLabels[i][j] = new Text(valuesComposite, SWT.BORDER);
					recentValueLabels[i][j].setText(""); // nothing yet
					recentValueLabels[i][j].setBackground(white);
					final GridData textGridData = new GridData();
					recentValueLabels[i][j].setLayoutData(textGridData);
				    textGridData.grabExcessHorizontalSpace=true;
				    textGridData.minimumWidth=width;
				    textGridData.horizontalAlignment = GridData.FILL;
				}	
		 
		valuesComposite.layout();
		//valuesComposite.pack();
		//valuesComposite.setVisible(true);
		valuesComposite.redraw();
		valuesInitialized = true;
	
	}// updateValueLabels
	
	
	
	
	

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
		
		if(chartIndex == 0) return errorHistory;
		if(chartIndex == 1) {
			if(state==0) return newTimeSeries;
			return bestSeries;
		}
		// should never happen
		return null;
	}
	
	/**
	 * Not used
	 * @param chartIndex not used (only one chart)
	 * @param state
	 * @return property name
	 */
	public String getProperty(int chartIndex, int state) {
		if(chartIndex==0) return Messages.getString("AUTO.TITLE1");
		if(chartIndex==1) {
			if(state==0) return Messages.getString("AUTO.TITLE2");
			return Messages.getString("AUTO.TITLE3");
		}
		return  Messages.getString("AUTO.NOTFOUNDERROR");
	}
	
	
	
	
	
	/**
	 * Not used
	 * @param chartIndex not used (only one chart)
	 * @return the number of properties, only one
	 * @see org.eclipse.stem.util.analysis.views.AnalysisControl#getNumProperties(int chartIndex)
	 */
	public int getNumProperties(int chartIndex) {
		if(chartIndex==ERROR_CONVERGENCE_BY_RUN_ID) return 1; // one thing to chart
		if(chartIndex==CURRENT_ERROR_BY_TIME_ID) return 2; // two things to chart
		return 0; // should never happen
	}

	/**
	 * 
	 * @param error
	 */
	public static void appendLatestErrorData(double error) {
		errorHistoryList.add(new Double(error));
		errorHistory = new double[errorHistoryList.size()];
		for(int i = 0; i < errorHistoryList.size(); i ++) {
			errorHistory[i] = errorHistoryList.get(i).doubleValue();
		}
	}

	/**
	 * 
	 * @param errorByTimeStep
	 */
	public static void setRecentTimeSeries(double error, EList<Double> errorByTimeStep) {
		newTimeSeries = new double[errorByTimeStep.size()];
		for(int i = 0; i < errorByTimeStep.size(); i ++) {
			newTimeSeries[i] = errorByTimeStep.get(i).doubleValue();
		}
		if(bestSeries==null) bestSeries = newTimeSeries;
		if(error <= bestError) {
			bestError = error;
			bestSeries = newTimeSeries;
			bestParamValues = copyDoubleArray(recentParamValues[row-1]);
		}
		
		
	}



	@Override
	protected void initializeHeader(String folderName) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}
		
	protected static double [] copyDoubleArray(double []s) {
		double []t = new double[s.length];
		int i=0;
		for(double d:s)t[i++]=d;
		return t;
	}
	
	

} // AutoExpControl
