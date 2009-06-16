package org.eclipse.stem.util.analysis.views;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.Anchor;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.LineAttributes;
import org.eclipse.birt.chart.model.attribute.LineStyle;
import org.eclipse.birt.chart.model.attribute.Marker;
import org.eclipse.birt.chart.model.attribute.MarkerType;
import org.eclipse.birt.chart.model.attribute.Position;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.attribute.impl.MarkerImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.impl.NumberDataElementImpl;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.layout.Legend;
import org.eclipse.birt.chart.model.layout.Plot;
import org.eclipse.birt.chart.model.type.ScatterSeries;
import org.eclipse.birt.chart.model.type.impl.ScatterSeriesImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.stem.ui.preferences.VisualizationPreferencePage;
import org.eclipse.stem.util.analysis.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchActionConstants;

/**
 * TimeSeriesCanvas is a subclass of {@link Canvas} suitable for chart drawings.
 */
public class XYSeriesCanvas extends Canvas {

	protected IDeviceRenderer idr = null;

	/**
	 * This is the {@link Chart} that plots the relative values.
	 */
	protected Chart cm = null;

	/**
	 * The provider of relative values.
	 */
	//private RelativeValueHistoryProvider rvhp;

	private AnalysisControl control = null;
	
	/**
	 * the index of this Chart
	 */
	protected int chartIndex = 0;
	

	private static final String DEFAULT_KEY_PREFIX = "XY";
	
	private static String defaultKey = DEFAULT_KEY_PREFIX;

	/**
	 * some extra colors
	 */
	protected static final int[][] colorDefault = {
													{0, 0, 255}, 		//Blue
													{255, 0, 0}, 		//Red
													{0, 255, 0}, 		//Green
													{255, 255, 0}, 		//Yellow
													{0, 0, 0}, 			//Black 
													{127, 127, 127}, 	//Grey
													{255, 255, 255},	//Cyan
													{255, 197, 41}		//Orange 
													};
	
	/**
	 * used to index the line series so we can step through default colors
	 * when a user custom color is not yet assigned
	 */
	private int seriesCount  = 0;
	

	/**
	 * A context menu for this view
	 */
	Menu popUpMenu = null;
	
	/**
	 * set y axis to a linear scale
	 */
	private LinearScaleAction linearTimeAction;
	/**
	 * set y axis to a log scale
	 */
	private LogScaleAction logTimeAction;
	protected boolean useLinearTimeScale = true;
	

	/**
	 * show the legend (true by default)
	 */
	private LegendViewAction viewLegend;

	/**
	 * hide the legend 
	 */
	private LegendHideAction hideLegend;
	protected boolean showLegend = true;

	protected Legend legend = null;
	

	/**
	 * this is a map of the DataXYSeries object (keyed by property name)
	 */
	protected final Map<String,DataXYSeries> dataSeriesMap = new HashMap<String,DataXYSeries>();

	/**
	 * Chart generator instance (reference to a singleton)
	 */
	Generator gr;

	Axis yAxisPrimary;
	Axis xAxisPrimary;
	/**
	 * the maxY value for scaling
	 */
	double maxY = Double.MIN_VALUE;
	
	/**
	 * the maxY value for scaling
	 */
	double maxX = Double.MIN_VALUE;

	/**
	 * the minY value for scaling
	 */
	private double minY = Double.MAX_VALUE;
	
	/**
	 * the minX value for scaling
	 */
	private double minX = Double.MAX_VALUE;
	
	
	/**
	 * Label for line series LEGEND
	 */
	public String Ordinate_LEGEND = "Y";
	
	/**
	 * Label for line series Y axis label
	 **/
	public String Ordinate_AXIS = "Y";
	
	/** 
	 * customizable color definitions
	 */
	protected ColorDefinition foreGround = ColorDefinitionImpl.WHITE();
	private ColorDefinition backgroundGround = ColorDefinitionImpl.BLACK();
	private ColorDefinition frameColor = ColorDefinitionImpl.create(180, 180, 200);

	Image imgChart = null;
	
	/**
	 * This Constructor is used when we want to place the time series in a container
	 * which is a sub component of the actual AnalysisControl
	 * @param analysisControl 
	 * 
	 * @param parent  the SWT parent of the {@link Widget}
	 * @param ordinateString 
	 * @param yAxisLabel 
	 * @param foreground 
	 * @param background 
	 * @param framecolor 
	 * @param chartIndex the index of this chart (0 if only one)
	 *  
	 */
	public XYSeriesCanvas(final AnalysisControl analysisControl, final Composite parent, 
			final String ordinateString, 
			final String yAxisLabel, 
			ColorDefinition foreground,
			ColorDefinition background,
			ColorDefinition framecolor,
			int chartIndex) {
		super(parent, SWT.DOUBLE_BUFFERED | SWT.BORDER);
		Ordinate_LEGEND = ordinateString;
		Ordinate_AXIS = yAxisLabel;
		defaultKey = DEFAULT_KEY_PREFIX+chartIndex;
		foreGround 			= foreground;
		backgroundGround 	= background;
		frameColor 			= framecolor;
		this.chartIndex = chartIndex;
		
		gr = Generator.instance();

		try {
			idr = PluginSettings.instance().getDevice("dv.SWT"); //$NON-NLS-1$			
		} catch (final ChartException pex) {
			Activator.logError("Problem initializing chart", pex); //$NON-NLS-1$
			return;
		}

		control = analysisControl;

		
		cm = createSimpleLineChart(dataSeriesMap, Messages.getString("CC.title")); //$NON-NLS-1$
		
		resetData();
		addPaintListener(new PaintListener() {
			public void paintControl(final PaintEvent pe) {

				final Composite source = (Composite) pe.getSource();
				final org.eclipse.swt.graphics.Rectangle d = source
						.getClientArea();

				if(imgChart != null) imgChart.dispose();
				imgChart = new Image(source.getDisplay(), d);
				idr.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, new GC(
						imgChart));
				final Bounds bounds = BoundsImpl.create(d.x, d.y, d.width,
						d.height);
				bounds.scale(72d / idr.getDisplayServer().getDpiResolution());
				// BOUNDS MUST BE SPECIFIED IN POINTS

				try {
					gr.render(idr, gr.build(idr.getDisplayServer(), cm, bounds,
							null, null, null));
					pe.gc.drawImage(imgChart, d.x, d.y);
				} catch (final ChartException ce) {
					Activator.logError("Problem rendering chart", ce); //$NON-NLS-1$
				}
			} // paintControl
		} // PaintListener
		);
		
		//Create a context menu for the canvas
		createContextMenu(this);
		

	} // TimeSeriesCanvas
	/**
	 * Constructor.
	 * 
	 * @param parent  the SWT parent of the {@link Widget}
	 * @param ordinateString 
	 * @param yAxisLabel 
	 * @param foreground 
	 * @param background 
	 * @param framecolor 
	 * @param chartIndex the index of this chart (0 if only one)
	 *  
	 */
	public XYSeriesCanvas(final Composite parent, 
			final String ordinateString, 
			final String yAxisLabel, 
			ColorDefinition foreground,
			ColorDefinition background,
			ColorDefinition framecolor,
			int chartIndex) {
		super(parent, SWT.DOUBLE_BUFFERED | SWT.BORDER);
		Ordinate_LEGEND = ordinateString;
		Ordinate_AXIS = yAxisLabel;
		defaultKey = DEFAULT_KEY_PREFIX+chartIndex;
		foreGround 			= foreground;
		backgroundGround 	= background;
		frameColor 			= framecolor;
		this.chartIndex = chartIndex;
		
		gr = Generator.instance();

		try {
			idr = PluginSettings.instance().getDevice("dv.SWT"); //$NON-NLS-1$			
		} catch (final ChartException pex) {
			Activator.logError("Problem initializing chart", pex); //$NON-NLS-1$
			return;
		}

		control = (AnalysisControl) parent;

		
		cm = createSimpleLineChart(dataSeriesMap, Messages
				.getString("CC.title")); //$NON-NLS-1$
		
		resetData();
		addPaintListener(new PaintListener() {
			public void paintControl(final PaintEvent pe) {

				final Composite source = (Composite) pe.getSource();
				final org.eclipse.swt.graphics.Rectangle d = source
						.getClientArea();

				if(imgChart != null) imgChart.dispose();
				imgChart = new Image(source.getDisplay(), d);
				idr.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, new GC(
						imgChart));
				final Bounds bounds = BoundsImpl.create(d.x, d.y, d.width,
						d.height);
				bounds.scale(72d / idr.getDisplayServer().getDpiResolution());
				// BOUNDS MUST BE SPECIFIED IN POINTS

				try {
					gr.render(idr, gr.build(idr.getDisplayServer(), cm, bounds,
							null, null, null));
					pe.gc.drawImage(imgChart, d.x, d.y);
				} catch (final ChartException ce) {
					Activator.logError("Problem rendering chart", ce); //$NON-NLS-1$
				}
			} // paintControl
		} // PaintListener
		);
		
		//Create a context menu for the canvas
		createContextMenu(this);
		

	} // TimeSeriesCanvas

	
	
	/**
	 * The method which gets the {@link XYSeriesCanvas}' reports list, and
	 * draws it on the {@link XYSeriesCanvas}.
	 * 
	 */
	public void draw() {

		
		
		
		resetData();
		
		maxY = -1.0;
		minY = 0.0;
		maxX = -1.0;
		minX = 0.0;
		double adjustedMaxY = 0.0;
		double adjustedMaxX = 0.0;
		
		// get the x,y data (i=0)
		// and the x, fitY data (i=1)
		for(int i = 0; i <= 1; i ++) {
			
			// one XY data set per chart
			//for (int i = 0; i < maxLines; i ++) {
			String property = "XY"+chartIndex;
			if(i==1) property = "FIT"+chartIndex;
			
			if(!dataSeriesMap.containsKey(property)) {
				// new property
				DataXYSeries series = new DataXYSeries(property);
				seriesCount ++;
				dataSeriesMap.put(property, series);
			}
			DataXYSeries series = dataSeriesMap.get(property);
			if(series.isVisible()) {
				series.show();
			} else {
				series.hide();
			}
			
			// Get the values for the property to be plotted
			int maxPoints = 0;
			
			final double[] doubleValuesX = control.getValues(chartIndex,(2*i)+2);
			final double[] doubleValuesY = control.getValues(chartIndex,(2*i)+3);
			
			// update the min max scales
			for (int j = 0; j < doubleValuesX.length; j++) {	
				if(doubleValuesY[j] <= minY) {
					minY = doubleValuesY[j];
					minY = Math.round(minY);
				}
				if(doubleValuesX[j] <= minX) {
					minX = doubleValuesX[j];
					minX = Math.round(minX);
				}
				
				if(doubleValuesY[j] >= maxY) {
					maxY = doubleValuesY[j];
					double log = Math.floor(Math.log10(maxY));
					adjustedMaxY = (Math.ceil(maxY/Math.pow(10, log)))*Math.pow(10, log);
				  //  if(adjustedMaxY <= 1.0) adjustedMaxY = 1.0;
				}// maxY
				if(doubleValuesX[j] >= maxX) {
					maxX = 1.02*doubleValuesX[j];
					double log = Math.floor(Math.log10(maxX));
					adjustedMaxX = (Math.ceil(maxX/Math.pow(10, log)))*Math.pow(10, log);
				    //if(adjustedMaxX <= 1.0) adjustedMaxX = 1.0;
				}// maxX
			}// for all points
			
			
			
			//System.out.println("adjustedMaxX = "+adjustedMaxX);
			xAxisPrimary.getScale().setMin(NumberDataElementImpl.create(0.0));
			xAxisPrimary.getScale().setMax(NumberDataElementImpl.create(adjustedMaxX));
			double stepX = adjustedMaxX / 10.0;
			//System.out.println("step = "+stepX);
			xAxisPrimary.getScale().setStep(stepX);
			xAxisPrimary.setType(AxisType.LINEAR_LITERAL);


			yAxisPrimary.getScale().setMin(NumberDataElementImpl.create(minY));
			yAxisPrimary.getScale().setMax(NumberDataElementImpl.create(adjustedMaxY));
			double stepY = adjustedMaxY / 10.0;
			yAxisPrimary.getScale().setStep(stepY);
			yAxisPrimary.setType(AxisType.LINEAR_LITERAL);

			// Any values?
			if (doubleValuesX.length > 0) {
				if (maxPoints < doubleValuesX.length) {
					maxPoints = doubleValuesX.length;
				}
			
				for (int cycleNumber = 0; cycleNumber < doubleValuesX.length; cycleNumber++) {
					Double valueX = new Double(doubleValuesX[cycleNumber]);
					Double valueY = new Double(doubleValuesY[cycleNumber]);
					series.addValue(valueX,valueY);
				} // for cycleNumber
				
			} else {
				//resetData();
			}
			
		}// xy data and fit
		

		if (!this.isDisposed()) {
			redraw();
		}
		
		
		
		return;
	} // paintControl

	/**
	 * @param dataXYSeriesMap
	 *            the {@link List} that will contain the relative values
	 *            (0.0-1.0) to plot
	 * @param seriesIdentifier
	 *            the title of the chart
	 * @return a <code>Chart</code>
	 */
	public final Chart createSimpleLineChart(
			final Map<String, DataXYSeries> dataXYSeriesMap, final String seriesIdentifier) {
		
		final ChartWithAxes retValue = ChartWithAxesImpl.create();

		
		// Plot
		retValue.getBlock().setBackground(frameColor);
		final Plot p = retValue.getPlot();
		p.getClientArea().setBackground(backgroundGround);

		// Title
		// cwaLine.getTitle( ).getLabel( ).getCaption( ).setValue( "Line Chart"
		// );//$NON-NLS-1$
		retValue.getTitle().setVisible(false);

		// Legend
		legend = retValue.getLegend();
		final LineAttributes lia = legend.getOutline();
		legend.getText().getFont().setSize(8);
		lia.setStyle(LineStyle.SOLID_LITERAL);
		legend.getInsets().set(10, 5, 0, 0);
		legend.getOutline().setVisible(false);
		legend.setAnchor(Anchor.NORTH_LITERAL);
		legend.setPosition(Position.BELOW_LITERAL);
		legend.getText().setColor(foreGround);
		legend.getOutline().setColor(foreGround);
		
		// cwaLine.getLegend( ).getText().getFont().setSize(16);;
		// cwaLine.getLegend( ).setVisible( true );

		// /////////
		// X-Axis
		xAxisPrimary = retValue.getPrimaryBaseAxes()[0];
		xAxisPrimary.setType(AxisType.TEXT_LITERAL);
		xAxisPrimary.getMajorGrid().setTickStyle(TickStyle.BELOW_LITERAL);
		xAxisPrimary.getOrigin().setType(IntersectionType.VALUE_LITERAL);
		xAxisPrimary.getTitle().setVisible(false);
		xAxisPrimary.getTitle().getCaption().getFont().setSize(9);
		xAxisPrimary.getTitle().getCaption().setColor(foreGround);
		xAxisPrimary.getLabel().getCaption().setColor(foreGround);

		// ////////
		// Y-Axis
		yAxisPrimary = retValue.getPrimaryOrthogonalAxis(xAxisPrimary);
		yAxisPrimary.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);

		// NumberDataSet[] orthoValues = new NumberDataSet[MAX_LINES];
		// SeriesDefinition[] sdY = new SeriesDefinition[MAX_LINES];

		// end Y-Series

		// xAxis
		xAxisPrimary.getScale().setMin(NumberDataElementImpl.create(0.0));
		xAxisPrimary.getScale().setMax(NumberDataElementImpl.create(1.0));
		xAxisPrimary.getScale().setStep(0.1);
		xAxisPrimary.getLabel().getCaption().getFont().setSize(9);
		xAxisPrimary.getLabel().getCaption().setColor(foreGround);
		xAxisPrimary.getTitle().setVisible(true);
		xAxisPrimary.getTitle().getCaption().setValue(Messages.getString("TS.TIMELABEL"));

		yAxisPrimary.getScale().setMin(NumberDataElementImpl.create(0.0));
		yAxisPrimary.getScale().setMax(NumberDataElementImpl.create(1.0));
		yAxisPrimary.getScale().setStep(0.1);
		yAxisPrimary.getLabel().getCaption().getFont().setSize(9);
		yAxisPrimary.getLabel().getCaption().setColor(foreGround);
		yAxisPrimary.getTitle( ).getCaption( ).setValue( Ordinate_AXIS );
		yAxisPrimary.getTitle( ).setVisible(true);
		// yAxisPrimary.getMajorGrid().getLineAttributes().setColor(foreGround);
		
		// for now get ready to create only one line - we have no data yet.
		// we will add more lines as we need them
		// handle null
		if(!dataXYSeriesMap.containsKey(defaultKey)) {
			DataXYSeries series = new DataXYSeries(defaultKey);
			seriesCount ++;
			dataXYSeriesMap.put(defaultKey, series);
		}

		return retValue;
	} // createSimpleLineChart

	
	/**
	 * Create the view's context menu and add the action handlers to it.
	 */
	protected void createContextMenu(final Composite parent) {

		// Init a Context Menu Manager
		final MenuManager contextMenuManager = new MenuManager();

		// ---------------------------------------------------------------------

		linearTimeAction = new LinearScaleAction();
		logTimeAction = new LogScaleAction();
		contextMenuManager.add(linearTimeAction);
		contextMenuManager.add(logTimeAction);


		
		// Place Holder for Menu Additions
		contextMenuManager.add(new Separator(
				IWorkbenchActionConstants.MB_ADDITIONS));

		// ---------------------------------------------------------------------
		
		viewLegend = new LegendViewAction();
		hideLegend = new LegendHideAction();
		contextMenuManager.add(viewLegend);
		contextMenuManager.add(hideLegend);
		
		// ---------------------------------------------------------------------
		
		
		// Place Holder for Menu Additions
		contextMenuManager.add(new Separator(
				IWorkbenchActionConstants.MB_ADDITIONS));

		popUpMenu = contextMenuManager.createContextMenu(parent);

		// Set the context menu for the viewer
		parent.setMenu(popUpMenu);

	} // createContextMenu
	
	/**
	 * Update the view's context menu and add the action handlers to it.
	 */
	@SuppressWarnings("unused")
	private void updateContextMenu(final Composite parent) {

		popUpMenu.dispose();

		// Init a Context Menu Manager
		final MenuManager contextMenuManager = new MenuManager();

		// ---------------------------------------------------------------------

		linearTimeAction = new LinearScaleAction();
		logTimeAction = new LogScaleAction();
		contextMenuManager.add(linearTimeAction);
		contextMenuManager.add(logTimeAction);
		
		// ---------------------------------------------------------------------


		// Place Holder for Menu Additions
		contextMenuManager.add(new Separator(
				IWorkbenchActionConstants.MB_ADDITIONS));

		// ---------------------------------------------------------------------
		
		viewLegend = new LegendViewAction();
		hideLegend = new LegendHideAction();
		contextMenuManager.add(viewLegend);
		contextMenuManager.add(hideLegend);
		
		// ---------------------------------------------------------------------
		
		
		// Place Holder for Menu Additions
		contextMenuManager.add(new Separator(
				IWorkbenchActionConstants.MB_ADDITIONS));

		
		// ---------------------------------------------------------------------
		// add the displayable properties
		for (int i = 0; i < control.getNumProperties(chartIndex); i ++) {
			
			String nextProp = control.getProperty(chartIndex,i);
			DataXYSeries series = dataSeriesMap.get(nextProp);
			DisplayableProperty property = new DisplayableProperty(nextProp, series.isVisible());
			contextMenuManager.add(property);
		}

		// ---------------------------------------------------------------------

		// Place Holder for Menu Additions
		contextMenuManager.add(new Separator(
				IWorkbenchActionConstants.MB_ADDITIONS));

		// ---------------------------------------------------------------------

		final Menu popUpMenu = contextMenuManager.createContextMenu(parent);

		// Set the context menu for the viewer
		parent.setMenu(popUpMenu);


	} // updateContextMenu


	
	/**
	 * Sets the colors for a n array of ScatterSeries given the property to Plot
	 * for each. Try to set color from the preferences (if specified for that
	 * property) otherwise sets line color to blue.
	 * 
	 * @param propertiesToPlot
	 * @param lsList
	 */
	public static void setColorDefs(
			final List<String> propertiesToPlot,
			final List<ScatterSeries> lsList) {
		// the default line color

		// if possible get color from preferences
		final Map<String, Color> colorMap = VisualizationPreferencePage
				.getColorMapping();
		for (int i = 0; i < lsList.size(); i++) {
			ColorDefinition color = ColorDefinitionImpl.BLUE();

			if ((propertiesToPlot != null) && (propertiesToPlot.size() > i)) {
				final String key = propertiesToPlot.get(i);
				// look or the preference color by name
				if (colorMap.containsKey(key)) {
					final Color c = colorMap.get(key);
					color = ColorDefinitionImpl.create(c.getRed(),
							c.getGreen(), c.getBlue());
				}
				lsList.get(i).setSeriesIdentifier(key);
				lsList.get(i).getLineAttributes().setColor(color);
			} else {

				if (lsList.get(i) != null) {
					lsList.get(i).setSeriesIdentifier(" ");
					lsList.get(i).getLineAttributes().setColor(color);
				}
			}
		}
		return;
	}// getColorDef


	

	/**
	 * Disposes the Color objects
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * reset
	 */
	public void reset() {
		resetData();
		redraw();
	}

	protected void resetData() {
		clearData();
	}

	private void clearData() {
		
		Iterator<String> iter = dataSeriesMap.keySet().iterator();
		while((iter!=null)&&(iter.hasNext())) {
			String key = iter.next();
			DataXYSeries series = dataSeriesMap.get(key);
			series.yValues.clear();
			series.xValues.clear();
			series.addValue(new Double(0.0), new Double(0.0));
		}
		
	}

	
	/**
	 * toggle the scale from logarithmic to linear
	 */
	void toggleAxisScale() {
//		if (useLinearTimeScale) { //Switch to logarithmic scale
//			logTimeAction.setChecked(true);
//			linearTimeAction.setChecked(false);
//			//Just using the following axis type, to move to log scale, didn't work
//			//yAxisPrimary.setType(AxisType.LOGARITHMIC_LITERAL);
//			yAxisPrimary.getScale().setMin(null);
//			yAxisPrimary.getScale().setMax(null);
//			yAxisPrimary.getScale().unsetStep();
//			yAxisPrimary.getScale().unsetStepNumber();
//		}
//		else { //Switch to linear scale
//			logTimeAction.setChecked(false);
//			linearTimeAction.setChecked(true);
//			//yAxisPrimary.setType(AxisType.LINEAR_LITERAL);
//			yAxisPrimary.getScale().setMin(NumberDataElementImpl.create(0.0));
//			yAxisPrimary.getScale().setMax(NumberDataElementImpl.create(1.0));
//			yAxisPrimary.getScale().setStep(0.25);
//		}
//		useLinearTimeScale = !useLinearTimeScale;
//		draw();
	}
	

	/**
	 * toggle the scale from logarithmic to linear
	 */
	void toggleLegend() {
		if (showLegend) { //Switch to hide
			viewLegend.setChecked(false);
			hideLegend.setChecked(true);
			legend.setVisible(false);
		}
		else { //Switch to view
			viewLegend.setChecked(true);
			hideLegend.setChecked(false);
			legend.setVisible(true);
		}
		showLegend = !showLegend;
		draw();
	}


	/**
	 * Action to show the legend
	 */
	protected class LegendViewAction extends Action {
		public LegendViewAction()
		{
			super(Messages.getString("ContextMenu.ShowLegend"), IAction.AS_CHECK_BOX);
			setChecked(showLegend);
		}

		/**
		 * @see org.eclipse.jface.action.Action#getText()
		 */
		@Override
		public String getText() {
			return Messages.getString("ContextMenu.ShowLegend");
		}

		/**
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
			if (showLegend) {
				setChecked(true);
				//Nothing to do. It's already linear-time.
			}
			else {
				toggleLegend();
			}
			draw();
		}
	} //LegendViewAction
	
	/**
	 * Action to hide the legend
	 */
	class LegendHideAction extends Action 	{
		public LegendHideAction()
		{
			super(Messages.getString("ContextMenu.HideLegend"), IAction.AS_CHECK_BOX);
			setChecked(!showLegend);
		}

		/**
		 * @see org.eclipse.jface.action.Action#getText()
		 */
		@Override
		public String getText() {
			return Messages.getString("ContextMenu.HideLegend");
		}

		/**
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
			if (!showLegend) {
				setChecked(true);
				//Nothing to do. It's already log-time.
			}
			else {
				toggleLegend();
			}
			draw();
		}
	}//LegendHideAction

	
	/**
	 * switch to linear plot 
	 * 
	 */
	protected class LinearScaleAction extends Action {
		public LinearScaleAction()
		{
			super(Messages.getString("ContextMenu.LinearTimeScale"), IAction.AS_CHECK_BOX);
			setChecked(useLinearTimeScale);
		}

		/**
		 * @see org.eclipse.jface.action.Action#getText()
		 */
		@Override
		public String getText() {
			return Messages.getString("ContextMenu.LinearTimeScale");
		}

		/**
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
			if (useLinearTimeScale) {
				setChecked(true);
				//Nothing to do. It's already linear-time.
			}
			else {
				toggleAxisScale();
			}
			draw();
		}
	} //LinearScaleAction

	/**
	 * switch to semi-log plot (log scale on y axis)
	 * 
	 */
	class LogScaleAction extends Action 	{
		public LogScaleAction()
		{
			super(Messages.getString("ContextMenu.LogTimeScale"), IAction.AS_CHECK_BOX);
			setChecked(!useLinearTimeScale);
		}

		/**
		 * @see org.eclipse.jface.action.Action#getText()
		 */
		@Override
		public String getText() {
			return Messages.getString("ContextMenu.LogTimeScale");
		}

		/**
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
			if (!useLinearTimeScale) {
				setChecked(true);
				//Nothing to do. It's already log-time.
			}
			else {
				toggleAxisScale();
			}
			draw();
		}
	}//LogScaleAction
	
	/**
	 * DisplayableProperty
	 *
	 */
	protected class DisplayableProperty extends Action
	{
		String property = null;
		public DisplayableProperty(String property, boolean visibility)
		{
					super(property, IAction.AS_CHECK_BOX);
					this.property = property;
					setChecked(visibility);
		}
		
	

		/**
		 * @see org.eclipse.jface.action.Action#getText()
		 */
		@Override
		public String getText() {
			return property;
		}

		/**
		 * Toggle the state
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
				DataXYSeries series = dataSeriesMap.get(property);
				series.toggleVisible();
				dataSeriesMap.put(property,series);
				setChecked(series.isVisible());
				draw();
		}
	}// DisplayableProperty
	
	
	/**
	 * Inner class DataXYSeries
	 * all the data objects for a plot
	 *
	 */
	protected class DataXYSeries 
	{
		public String propertyName = "";
		
		public List<Double> yValues = new ArrayList<Double>();
		public List<Double> xValues = new ArrayList<Double>();
		
		public Series seriesX = null;
		public ScatterSeries scatterSeriesY = null;
		private boolean visible = true;
		private SeriesDefinition sdY = null;
		private SeriesDefinition sdX = null;
		
		
		public boolean isVisible() {
			return visible;
		}
		public void setVisible(boolean state) {
			visible = state;
		}
		
		public void toggleVisible() {
			visible = !visible;
		}

		/**
		 * 
		 * @param propertyName
		 */
		public DataXYSeries(String propertyName) {
			this.propertyName = propertyName;
			yValues = new ArrayList<Double>();
			yValues.add(new Double(0.0));
			
			xValues = new ArrayList<Double>();
			xValues.add(new Double(0.0));
			
			addScatterSeries(propertyName);
		}
		
		/**
		 * add an XY value pair
		 * @param valX
		 * @param valY
		 */
		public void addValue(Double valX, Double valY) {
			if(yValues==null) yValues = new ArrayList<Double>();
			if(xValues==null) xValues = new ArrayList<Double>();
			xValues.add(valX);
			yValues.add(valY);
		}
		
		/**
		 * @param propertyName
		 * 
		 */
		public void addScatterSeries(final String propertyName) {
			
			final NumberDataSet orthoValues = NumberDataSetImpl.create(yValues);
			final NumberDataSet xAxisValues = NumberDataSetImpl.create(xValues);
			
			sdX = SeriesDefinitionImpl.create();
			//FractionNumberFormatSpecifier sf = FractionNumberFormatSpecifierImpl.create();
			//sf.setPrecise(true);
			//sdX.setFormatSpecifier(sf);
			xAxisPrimary.getSeriesDefinitions().add(sdX);
			
			
			if(scatterSeriesY == null) {
				sdY = SeriesDefinitionImpl.create();
				
				scatterSeriesY = (ScatterSeries)ScatterSeriesImpl.create();
				seriesX = SeriesImpl.create();
			} // if scatterSeriesY==null
			// new colors
			seriesX.getLabel().getCaption().setColor(foreGround);
			seriesX.getLabel().getOutline().setColor(foreGround);
			seriesX.setDataSet(xAxisValues);
			sdX.getSeries().add(seriesX);
		
			scatterSeriesY.setDataSet(orthoValues);
			
			// Assign the line color
			// based on selected property. Default is Blue
			setColorDefs(propertyName);
			// If this is the "selected" region of a graph set the marker type
			
			// the series def
			ColorDefinition color = ColorDefinitionImpl.create(
					colorDefault[chartIndex][0], 
					colorDefault[chartIndex][1], 
					colorDefault[chartIndex][2]);
			sdY.getSeriesPalette().update(color);
			sdY.getSeries().add(scatterSeriesY);
			yAxisPrimary.getSeriesDefinitions().add(sdY);
			
			return;
		}// addScatterSeries
		
		/** 
		 * in response to user action temporarily remove the line series from the graph
		 */
		public void hide() {
			scatterSeriesY.setVisible(false);
			visible = false;
		}// hide
		
		/** 
		 * in response to user action add back the line series to the graph
		 */
		public void show() {
			scatterSeriesY.setVisible(true);
			visible = true;
		}// show
		

		/**
		 * Sets the colors for a n array of ScatterSeries given the property to Plot
		 * for each. Try to set color from the preferences (if specified for that
		 * property) otherwise sets line color to blue.
		 * @param propertyName 
		 *
		 */
		public void setColorDefs(String propertyName) {
			this.scatterSeriesY.setSeriesIdentifier(propertyName);
			if(propertyName.indexOf("XY")>=0) {
				// the data
				scatterSeriesY.setPaletteLineColor(true);				
				//scatterSeriesY.getLineAttributes().setColor(color);
				//scatterSeriesY.getLineAttributes().setStyle(LineStyle.SOLID_LITERAL);
				Marker marker = MarkerImpl.create(MarkerType.CIRCLE_LITERAL, 2);
				scatterSeriesY.getMarkers().clear();
				scatterSeriesY.getMarkers().add(marker);
				scatterSeriesY.getLineAttributes().setVisible(false);
			} else {
				// the fit
				scatterSeriesY.getLineAttributes().setColor(ColorDefinitionImpl.BLACK());
				scatterSeriesY.getLineAttributes().setStyle(LineStyle.DOTTED_LITERAL);
				scatterSeriesY.getLineAttributes().setVisible(true);
				if (!scatterSeriesY.getMarkers().isEmpty()) {
					Marker marker = (Marker)scatterSeriesY.getMarkers().get(0);
					marker.setVisible(false);
				}
			}
			
		}// getColorDefs

		/**
		 * length of the series
		 * @return number of data points
		 */
		public int getDataSize() {
			return yValues.size();
		}
		// Accessors
		public String getPropertyName() {
			return propertyName;
		}

		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}

		public List<Double> getyValues() {
			return yValues;
		}

		public void setyValues(List<Double> yValues) {
			this.yValues = yValues;
		}

		

		public void setScatterSeries(ScatterSeries lineSeries) {
			this.scatterSeriesY = lineSeries;
		}
	}// DataXYSeries
	////////////////////////////////////////////////////////
	
} // XYSeriesCanvas
