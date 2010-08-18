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
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.Anchor;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.ChartDimension;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.Position;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.TextDataSet;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.data.impl.TextDataSetImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.layout.Legend;
import org.eclipse.birt.chart.model.layout.Plot;
import org.eclipse.birt.chart.model.type.BarSeries;
import org.eclipse.birt.chart.model.type.impl.BarSeriesImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.stem.util.analysis.Activator;
import org.eclipse.stem.util.analysis.Parameter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;

/**
 * TimeSeriesCanvas is a subclass of {@link Canvas} suitable for chart drawings.
 */
public class EstimatorCanvas extends Canvas {

	protected IDeviceRenderer idr = null;

	/**
	 * This is the {@link Chart} that plots the relative values.
	 */
	protected Chart cm = null;

	//private EstimatorControl control = null;

	static ColorDefinition[] barColors = {ColorDefinitionImpl.RED(),
		ColorDefinitionImpl.BLUE(),
		ColorDefinitionImpl.ORANGE(),
		ColorDefinitionImpl.YELLOW(),
		ColorDefinitionImpl.GREEN(),
		ColorDefinitionImpl.PINK(),
		ColorDefinitionImpl.BLACK() };


	/**
	 * the chart title
	 */
	private static final String TITLE = "Estimated Parameters";

	/**
	 * the legend
	 */
	private static final String VALUES = "Parameter Values";
	private static final String VALUES_LOWER = "Value - Std.Dev.";
	private static final String VALUES_HIGHER = "Value + Std.Dev.";

	private static final boolean SHOW_STD_DEV = false;


	/**
	 * Collection of values for the X-SERIES bar labels
	 **/
	private static Vector<String> xAxisParameterNames = new Vector<String>();

	/**
	 * Collection of values for the Y-SERIES bars
	 **/
	private static ArrayList<Double> barValues = new ArrayList<Double>();
	private static NumberDataSet barOrthoValues;


	/**
	 * Collection of values for the Y-SERIES2 standard deviation lower and higher bars
	 **/
	private static ArrayList<Double> barStdDevLower = new ArrayList<Double>();
	private static ArrayList<Double> barStdDevHigher = new ArrayList<Double>();
	private static NumberDataSet barOrthoStdDevLower;
	private static NumberDataSet barOrthoStdDevHigher
	;

	/**
	 * Chart generator instance (reference to a singleton)
	 */
	Generator gr;

	Image imgChart = null;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the SWT parent of the {@link Widget}
	 */
	public EstimatorCanvas(final Composite parent) {
		super(parent, SWT.DOUBLE_BUFFERED | SWT.BORDER);

		gr = Generator.instance();

		try {
			idr = PluginSettings.instance().getDevice("dv.SWT"); //$NON-NLS-1$			
		} catch (final ChartException pex) {
			Activator.logError("Problem initializing chart", pex); //$NON-NLS-1$
			return;
		}

		//control = (EstimatorControl) parent;

		Vector<String> xAxisParameters = new Vector<String>();
		xAxisParameters.add("beta");
		xAxisParameters.add("alpha");
		xAxisParameters.add("epsilon");
		xAxisParameters.add("gamma");

		//Map<String,Double> initMap = ModelParameters;
		//cm = createBarChart(initMap); 

		addPaintListener(new PaintListener() {
			public void paintControl(final PaintEvent pe) {
				if(cm == null) return;
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

	} // EstimatorCanvas constructor

	/**
	 * * creates the chart
	 * @param barDataMap
	 * @return a bar chart
	 */
	@SuppressWarnings("deprecation")
	public static Chart createBarChart(Map<String,Parameter> barDataMap) {
		// Reset everything
		xAxisParameterNames.clear();
		barValues.clear();
		barStdDevLower.clear();
		barStdDevHigher.clear();

		// BAR CHARTS ARE BASED ON CHARTS THAT CONTAIN AXES
		ChartWithAxes cwaBar = ChartWithAxesImpl.create();
		cwaBar.getBlock().setBackground(ColorDefinitionImpl.WHITE());
		cwaBar.getBlock().getOutline().setVisible(true);
		cwaBar.setDimension(ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH_LITERAL);

		// CUSTOMIZE THE PLOT
		Plot p = cwaBar.getPlot();
		p.getClientArea().setBackground(ColorDefinitionImpl.create(255, 255, 225));
		p.getOutline().setVisible(false);
		cwaBar.getTitle().getLabel().getCaption().setValue(TITLE);

		// CUSTOMIZE THE LEGEND
		Legend lg = cwaBar.getLegend();
		lg.getText().getFont().setSize(16);
		lg.getInsets().set(10, 5, 0, 0);
		lg.setAnchor(Anchor.NORTH_LITERAL);

		// CUSTOMIZE THE X-AXIS
		Axis xAxisPrimary = cwaBar.getPrimaryBaseAxes()[0];
		xAxisPrimary.setType(AxisType.TEXT_LITERAL);
		xAxisPrimary.getMajorGrid().setTickStyle(TickStyle.BELOW_LITERAL);
		xAxisPrimary.getOrigin().setType(IntersectionType.VALUE_LITERAL);
		xAxisPrimary.getTitle().setVisible(false);

		// CUSTOMIZE THE Y-AXIS
		Axis yAxisPrimary = cwaBar.getPrimaryOrthogonalAxis(xAxisPrimary);
		yAxisPrimary.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);
		yAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		yAxisPrimary.getLabel().getCaption().getFont().setRotation(90);


		// populate from the map
		Set<String> keySet = barDataMap.keySet();
		String[] keys = new String[keySet.size()];
		Iterator<String> iter = keySet.iterator();
		int icount = 0;
		while(iter.hasNext()) {
			keys[icount] = iter.next();
			icount ++;
		}
		Arrays.sort(keys);
		for (int i = 0; i < keys.length; i++) {
			String paramName = keys[i];
			xAxisParameterNames.add(paramName);
			Double dValue = new Double(barDataMap.get(paramName).value);

			barStdDevLower.add(dValue);
			barValues.add(dValue);
			barStdDevHigher.add(dValue);
		}

		TextDataSet categoryValues = TextDataSetImpl.create(xAxisParameterNames);

		barOrthoValues = NumberDataSetImpl.create(barValues);
		barOrthoStdDevLower = NumberDataSetImpl.create(barStdDevLower);
		barOrthoStdDevHigher = NumberDataSetImpl.create(barStdDevHigher);

		// CREATE THE CATEGORY BASE SERIES
		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(categoryValues);

		// Create the first series of dataValues the ORTHOGONAL Value-Statndard deviations LOWER SERIES
		BarSeries bsLower = (BarSeries) BarSeriesImpl.create();
		bsLower.setSeriesIdentifier(VALUES_LOWER);
		bsLower.setDataSet(barOrthoStdDevLower);
		bsLower.setRiserOutline(null);
		bsLower.getLabel().setVisible(true);
		bsLower.setLabelPosition(Position.INSIDE_LITERAL);

		// Create the Values series of dataValues the ORTHOGONAL SERIES
		BarSeries bsValues = (BarSeries) BarSeriesImpl.create();
		bsValues.setSeriesIdentifier(VALUES);
		bsValues.setDataSet(barOrthoValues);
		bsValues.setRiserOutline(null);
		bsValues.getLabel().setVisible(true);
		bsValues.setLabelPosition(Position.INSIDE_LITERAL);

		// Create the THIRD series of dataValues the ORTHOGONAL Value+StdDev HIGHER SERIES
		BarSeries bsHigher = (BarSeries) BarSeriesImpl.create();
		bsHigher.setSeriesIdentifier(VALUES_HIGHER);
		bsHigher.setDataSet(barOrthoStdDevHigher);
		bsHigher.setRiserOutline(null);
		bsHigher.getLabel().setVisible(true);
		bsHigher.setLabelPosition(Position.INSIDE_LITERAL);

		// WRAP THE BASE SERIES IN THE X-AXIS SERIES DEFINITION
		SeriesDefinition sdX = SeriesDefinitionImpl.create();
		sdX.getSeriesPalette().update(0); // SET THE COLORS IN THE PALETTE
		xAxisPrimary.getSeriesDefinitions().add(sdX);
		sdX.getSeries().add(seCategory);

		if (SHOW_STD_DEV) {
			// One THE ORTHOGONAL VALUES-STD-DEV lower SERIES For the Y-AXIS SERIES DEFINITION
			SeriesDefinition sdYlower = SeriesDefinitionImpl.create();
			sdYlower.getSeriesPalette().update(1); // SET THE COLOR IN THE PALETTE
			yAxisPrimary.getSeriesDefinitions().add(sdYlower);
			sdYlower.getSeries().add(bsLower);
		}


		// Two THE ORTHOGONAL VALUES SERIES For the Y-AXIS SERIES DEFINITION
		SeriesDefinition sdY1 = SeriesDefinitionImpl.create();
		sdY1.getSeriesPalette().update(1); // SET THE COLOR IN THE PALETTE
		yAxisPrimary.getSeriesDefinitions().add(sdY1);
		sdY1.getSeries().add(bsValues);

		if (SHOW_STD_DEV) {
			// Three THE ORTHOGONAL VALUES+STDDEV Higher SERIES For the Y-AXIS SERIES DEFINITION
			SeriesDefinition sdYHigher = SeriesDefinitionImpl.create();
			sdYHigher.getSeriesPalette().update(1); // SET THE COLOR IN THE PALETTE
			yAxisPrimary.getSeriesDefinitions().add(sdYHigher);
			sdYHigher.getSeries().add(bsHigher);
		}


		return cwaBar;

	}// createBarChart

	/**
	 * refreshes (some of) the data in the bar chart by key values
	 * @param barDataMap All parameters
	 */
	public static void refresh(Map<String,Parameter> barDataMap) {
		//Iterator<String> iter = barDataMap.keySet().iterator();
		//while(iter.hasNext()) {


		for (Entry<String,Parameter> entry : barDataMap.entrySet()) {
			int icount = xAxisParameterNames.indexOf(entry.getKey());
			if (icount >= 0) {
				double value = entry.getValue().value;
				// and the higher/lower values
				double deviation = entry.getValue().stddev;
				Double lower = new Double(value-deviation);
				Double higher = new Double(value + deviation);

				barValues.set(icount,new Double(value));
				barStdDevLower.set(icount,lower);
				barStdDevHigher.set(icount,higher);
			}

		}// while have keys
	}// refresh

	/**
	 * The method which gets the {@link EstimatorCanvas}' reports list, and
	 * draws it on the {@link EstimatorCanvas}.
	 * @param barDataMap Parameter map
	 * 
	 */
	public void draw(Map<String,Parameter> barDataMap) {
		cm = EstimatorCanvas.createBarChart(barDataMap);
		//refresh(barDataMap);

		if (!this.isDisposed()) {
			redraw();
		}
	} // paintControl

	/**
	 * Disposes the Color objects
	 */
	@Override
	public void dispose() {
		super.dispose();
	}


} // TimeSeriesCanvas
