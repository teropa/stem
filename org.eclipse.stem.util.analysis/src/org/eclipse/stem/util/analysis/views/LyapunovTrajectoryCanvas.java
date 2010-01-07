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
import java.util.List;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
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
import org.eclipse.birt.chart.model.type.LineSeries;
import org.eclipse.birt.chart.model.type.ScatterSeries;
import org.eclipse.birt.chart.model.type.impl.ScatterSeriesImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.stem.util.analysis.Activator;
import org.eclipse.stem.util.analysis.PhaseSpaceCoordinate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;

/**
 * LyapunovComparisonCanvas is a subclass of {@link Canvas} suitable for chart
 * drawings.
 */
public class LyapunovTrajectoryCanvas extends Canvas {

	protected IDeviceRenderer idr = null;

	/**
	 * This is the {@link Chart} that plots the relative values.
	 */
	protected Chart cm = null;

	/**
	 * The control for this canvas
	 */
	private LyapunovControl control = null;

	/**
	 * These are the values that will be plotted in X
	 * 
	 */
	private final List<List<Double>> relativeValuesX = new ArrayList<List<Double>>();

	/**
	 * These are the values that will be plotted in Y
	 * 
	 */
	private final List<List<Double>> relativeValuesY = new ArrayList<List<Double>>();

	/**
	 * Chart generator instance (reference to a singleton)
	 */
	Generator gr;

	private final List<LineSeries> lineSeriesList = new ArrayList<LineSeries>();
	Axis yAxisPrimary;
	Axis xAxisPrimary;
	double maxX = -1.0;
	double maxY = -1.0;

	ColorDefinition[] lineColors = { ColorDefinitionImpl.RED(),
			ColorDefinitionImpl.BLUE(), ColorDefinitionImpl.ORANGE(),
			ColorDefinitionImpl.YELLOW(), ColorDefinitionImpl.GREEN(),
			ColorDefinitionImpl.PINK(), ColorDefinitionImpl.BLACK() };

	/**
	 * TODO eventually this should not be hard coded but should be based on the
	 * number of files being read in in the GUI
	 */
	private static final int NUM_TRAJECTORIES = 2;

	/**
	 * Label for Time access (TODO need to nls this)
	 */
	public static final String TIME_LABEL = "time";

	/**
	 * Label for line series Identifier (legend)
	 */
	public static final String RMS_LABEL = "I[A] vs I[B]";

	Image imgChart = null;
	
	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the SWT parent of the {@link Widget}
	 */
	public LyapunovTrajectoryCanvas(final Composite parent) {
		super(parent, SWT.DOUBLE_BUFFERED | SWT.BORDER);
		while (relativeValuesX.size() < NUM_TRAJECTORIES) {
			relativeValuesX.add(new ArrayList<Double>());
		}
		while (relativeValuesY.size() < NUM_TRAJECTORIES) {
			relativeValuesY.add(new ArrayList<Double>());
		}
		resetData();
		gr = Generator.instance();

		try {
			idr = PluginSettings.instance().getDevice("dv.SWT"); //$NON-NLS-1$			
		} catch (final ChartException pex) {
			Activator.logError("Problem initializing chart", pex); //$NON-NLS-1$
			return;
		}

		control = (LyapunovControl) parent;

		cm = createLyapunovTrajectoryChart(relativeValuesX, relativeValuesY,
				Messages.getString("PH.title")); //$NON-NLS-1$
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

	} // LyapunovComparisonCanvas

	/**
	 * The method which gets the {@link LyapunovTrajectoryCanvas}' reports list,
	 * and draws it on the {@link LyapunovTrajectoryCanvas}.
	 * 
	 */
	public void draw() {
		// Has a relative value provider been provided?
		clearData();
		setColorDefs(lineSeriesList);

		// set up to autoscale
		maxX = -1.0;
		maxY = -1.0;

		for (int i = 0; i < NUM_TRAJECTORIES; i++) {

			final PhaseSpaceCoordinate[] trajectory = control.getPointValues(i);

			if (trajectory.length > 0) {

				for (int j = 0; j < trajectory.length; j++) {

					if (trajectory[j].getXValue() >= maxX) {
						maxX = trajectory[j].getXValue();
						xAxisPrimary.getScale().setMax(
								NumberDataElementImpl.create(maxX));
					}

					if (trajectory[j].getYValue() >= maxY) {
						maxY = trajectory[j].getYValue();
						yAxisPrimary.getScale().setMax(
								NumberDataElementImpl.create(maxY));
					}
				}

				for (int cycleNumber = 0; cycleNumber < trajectory.length; cycleNumber++) {
					this.relativeValuesX.get(i).add(
							new Double(trajectory[cycleNumber].getXValue()));
					this.relativeValuesY.get(i).add(
							new Double(trajectory[cycleNumber].getYValue()));
				} // for cycleNumber
			} else {
				resetData();
			}
		}// for NUM_TRAJECTORIES
		if (!this.isDisposed()) {
			redraw();
		}
	} // paintControl

	/**
	 * @param relativeValuesX
	 *            the <code>List</code> that will contain the relative X axis
	 *            values (0.0-1.0) to plot
	 * @param relativeValuesY
	 *            that will contain the relative Y axis values (0.0-1.0) to plot
	 * @param seriesIdentifier
	 *            the title of the graph
	 * @return a <code>Chart</code>
	 */
	@SuppressWarnings("deprecation")
	public final Chart createLyapunovTrajectoryChart(
			final List<List<Double>> relativeValuesX,
			final List<List<Double>> relativeValuesY,
			final String seriesIdentifier) {
		final ChartWithAxes retValue = ChartWithAxesImpl.create();

		// get the NLS default labels
		// defaultAxisLabel_X = Messages.getString("XAXISDEF.title");
		// defaultAxisLabel_Y = Messages.getString("YAXISDEF.title");
		String defaultAxisLabel_X = "S";
		String defaultAxisLabel_Y = "I";

		// Plot
		retValue.getBlock().setBackground(ColorDefinitionImpl.WHITE());
		final Plot p = retValue.getPlot();
		p.getClientArea().setBackground(
				ColorDefinitionImpl.create(255, 255, 225));

		// Title
		// cwaLine.getTitle( ).getLabel( ).getCaption( ).setValue( "Line Chart"
		// );//$NON-NLS-1$
		retValue.getTitle().setVisible(false);

		// Legend
		final Legend lg = retValue.getLegend();
		lg.setVisible(false);
		/*
		 * final LineAttributes lia = lg.getOutline();
		 * lg.getText().getFont().setSize(8);
		 * lia.setStyle(LineStyle.SOLID_LITERAL); lg.getInsets().set(10, 5, 0,
		 * 0); lg.getOutline().setVisible(false);
		 * lg.setAnchor(Anchor.NORTH_LITERAL);
		 * lg.setPosition(Position.BELOW_LITERAL);
		 */
		// cwaLine.getLegend( ).getText().getFont().setSize(16);;
		// cwaLine.getLegend( ).setVisible( true );
		// X-Axis
		xAxisPrimary = retValue.getPrimaryBaseAxes()[0];
		xAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		// Y-Axis
		yAxisPrimary = retValue.getPrimaryOrthogonalAxis(xAxisPrimary);

		// xAxisPrimary.setType(AxisType.TEXT_LITERAL);

		xAxisPrimary.getMajorGrid().setTickStyle(TickStyle.BELOW_LITERAL);
		yAxisPrimary.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);

		xAxisPrimary.getOrigin().setType(IntersectionType.VALUE_LITERAL);

		xAxisPrimary.getTitle().getCaption().getFont().setSize(8);
		String xAxisLabel = defaultAxisLabel_X;
		xAxisPrimary.getTitle().getCaption().setValue(xAxisLabel);
		xAxisPrimary.getTitle().setVisible(true);

		yAxisPrimary.getTitle().getCaption().getFont().setSize(8);
		String yAxisLabel = defaultAxisLabel_Y;
		yAxisPrimary.getTitle().getCaption().setValue(yAxisLabel);
		yAxisPrimary.getTitle().setVisible(true);

		final int MAXCOLORS = lineColors.length;
		// for all relative values lists
		// X must be same size as Y
		for (int i = 0; i < relativeValuesX.size(); i++) {
			final NumberDataSet orthoValuesX = NumberDataSetImpl
					.create(relativeValuesX.get(i));
			final NumberDataSet orthoValuesY = NumberDataSetImpl
					.create(relativeValuesY.get(i));

			// X-Series
			final Series lsx = SeriesImpl.create();
			// final LineSeries lsx = (ScatterSeries)
			// ScatterSeriesImpl.create();
			// seCategory.setDataSet(orthoValuesX);
			lsx.setDataSet(orthoValuesX);

			// Y-Series
			final ScatterSeries lsy = (ScatterSeries) ScatterSeriesImpl
					.create();
			lsy.setDataSet(orthoValuesY);
			lsy.getLineAttributes().setVisible(true);

			int colorIndex = i % MAXCOLORS;
			lsy.getLineAttributes().setColor(lineColors[colorIndex]);
			lsy.setSeriesIdentifier(seriesIdentifier);
			
			lsy.getMarkers().clear();

			final SeriesDefinition sdX = SeriesDefinitionImpl.create();
			final SeriesDefinition sdY = SeriesDefinitionImpl.create();

			sdY.getSeriesPalette().update(-2);

			xAxisPrimary.getSeriesDefinitions().add(sdX);
			yAxisPrimary.getSeriesDefinitions().add(sdY);

			// sdX.getSeries().add(seCategory);
			sdX.getSeries().add(lsx);
			sdY.getSeries().add(lsy);

		}// FOR ALL DATA SETS

		xAxisPrimary.getScale().setMin(NumberDataElementImpl.create(0.0));
		xAxisPrimary.getScale().setMax(NumberDataElementImpl.create(1.0));
		xAxisPrimary.getScale().setStep(0.25);
		xAxisPrimary.getLabel().getCaption().getFont().setSize(9);

		yAxisPrimary.getScale().setMin(NumberDataElementImpl.create(0.0));
		yAxisPrimary.getScale().setMax(NumberDataElementImpl.create(1.0));
		yAxisPrimary.getScale().setStep(0.25);
		yAxisPrimary.getLabel().getCaption().getFont().setSize(9);

		return retValue;
	} // createPhaseSpaceLineChart

	/**
	 * Sets the colors for a n array of LineSeries all to blue TODO: eventually
	 * we need to pick some better colors and connect to a legend...
	 * 
	 * @param lsList
	 */
	public static void setColorDefs(final List<LineSeries> lsList) {
		// the default line color
		for (int i = 0; i < lsList.size(); i++) {
			ColorDefinition color = ColorDefinitionImpl.BLUE();
			lsList.get(i).getLineAttributes().setColor(color);
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
		for (int i = 0; i < relativeValuesX.size(); i++) {
			relativeValuesX.get(i).add(new Double(1.0));
			relativeValuesY.get(i).add(new Double(0.0));
		}
	}

	private void clearData() {
		for (int i = 0; i < relativeValuesX.size(); i++) {
			relativeValuesX.get(i).clear();
			relativeValuesY.get(i).clear();
		}
	}
} // LyapunovComparisonCanvas
