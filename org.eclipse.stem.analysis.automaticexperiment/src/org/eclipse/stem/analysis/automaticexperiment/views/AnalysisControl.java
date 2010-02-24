// AnalysisControl
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * AnalysisControl is a subclass of Canvas suitable for chart drawings.
 */
abstract public class AnalysisControl extends Composite  {


	protected static final String CLEAR_TEXT = "clear monitors";

	protected Label simulationNameLabel;
	
	/**
	 * Status text
	 */
	public static final String STATUS_TEXT = "status";
	
	protected static Map<String,Object> controlParametersMap = new HashMap<String,Object>();
	
	/** 
	 * a string for setting user feedback messages
	 */
	protected String userMessage = "";
	
	/**
	 * a label to display messages
	 */
	protected Label userMessageLabel = null;
	


	/**
	 * button to trigger the analysis
	 */
	protected Button analyzeButton = null;

	protected Button selectEstimatorButton = null;

	
	/**
	 * The collection of ISelectionChangedListener waiting to be told about
	 * selections.
	 */
	protected final List<ISelectionChangedListener> listeners = new CopyOnWriteArrayList<ISelectionChangedListener>();

	

	protected Label identifiableTitle;

	/**
	 * The width of the layout margin.
	 */
	protected static final int MARGIN_WIDTH = 5;

	/**
	 * The height of the layout margin.
	 */
	protected static final int MARGIN_HEIGHT = 5;

	/**
	 * @param parent
	 * @param style
	 */
	public AnalysisControl(final Composite parent, final int style) {
		super(parent, style);

		this.addDisposeListener(new DisposeListener() {
			/**
			 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
			 */
			public void widgetDisposed(@SuppressWarnings("unused")
			final DisposeEvent e) {
				dispose();
			}
		});

		final FormLayout layout = new FormLayout();
		layout.marginHeight = MARGIN_HEIGHT;
		layout.marginWidth = MARGIN_WIDTH;
		setLayout(layout);

	} // AnalysisControl

	/**
	 * @param parent
	 *            the parent SWT control that this composite will be a child of
	 * @return the SWT Composite to be displayed above the MapCanvas in the
	 *         control
	 */
	protected Composite createTopComposite(final Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);

		final FillLayout topCompositeLayout = new FillLayout(SWT.VERTICAL);
		topComposite.setLayout(topCompositeLayout);

		simulationNameLabel = new Label(topComposite, SWT.CENTER);
		simulationNameLabel.setText("");

		return topComposite;
	} // createTopComposite
	
	/**
	 * creates the AnalyzeButtonComposite and its composite container
	 * @param control
	 * @param the button label
	 * @return the composite
	 */
	Composite getAnalyzeButtonComposite(AnalysisControl control, String label) {
		Composite analyzeComposite = new Composite(control, SWT.BORDER);
	    FillLayout fillLayout = new FillLayout();
	    fillLayout.type = SWT.HORIZONTAL;
	    analyzeComposite.setLayout(fillLayout);
	    Label leftLabel = new Label(analyzeComposite, SWT.NONE);
	    leftLabel.setText(" ");// just a spacer
	    analyzeButton = new Button(analyzeComposite, SWT.NONE);
		analyzeButton.setText(label);
		Label rightLabel = new Label(analyzeComposite, SWT.NONE);
		rightLabel.setText(" ");// just a spacer
	   
	    return analyzeComposite;
	}//getAnalyzeButtonComposite
	


	/**
	 * 
	 * @param folderName
	 */
	protected abstract void initializeHeader(String folderName);

	
	/**
	 * All controllers must implement this 
	 * to remove the control e.g. by a remove button event
	 */
	public abstract void remove() ;
	
	
	
	
	
	
	/**
	 * get values for graphs as double array
	 * @param chartIndex allows multiple charts in a view. Default is index=0 (one chart)
	 * @param state
	 * @return value array
	 */
	public abstract double[] getValues(int chartIndex, int state);
	
	/**
	 * update the message text
	 */
	public void updateMessage() {
		if(userMessageLabel!=null)	userMessageLabel.setText(userMessage);
	}
	
	/**
	 * update the message text
	 * @param message 
	 */
	public void updateMessage(String message) {
		userMessage = message;
		if(userMessageLabel!=null)	userMessageLabel.setText(userMessage);
	}
	
	/**
	 * get the name of the time series for a given state
	 * @param chartIndex  allows multiple charts in a view. Default is index=0 (one chart)
	 * @param state
	 * @return property name
	 */
    public abstract String getProperty(int chartIndex, int state);
    

    /**
     * 
     * @param chartIndex  allows multiple charts in a view. Default is index=0 (one chart)
     * @return number of properties to plot
     */
    public abstract int getNumProperties(int chartIndex);
    
    
	


} // AnalysisControl
