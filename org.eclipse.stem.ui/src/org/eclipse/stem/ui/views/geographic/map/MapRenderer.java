// MapRenderer.java
package org.eclipse.stem.ui.views.geographic.map;

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

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.stem.ui.adapters.color.ColorProviderAdapter;
import org.eclipse.stem.ui.views.geographic.GeographicRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * This class renders geographic data (lat/long) into a "flat map" visual
 * representation.
 */
public class MapRenderer extends GeographicRenderer implements ISelectionChangedListener {

	private MapCanvas mapCanvas;
	private MenuManager menuManager;

	/**
	 * @param parent
	 * @param style
	 */
	public MapRenderer(Composite parent, int style) {
		super(parent, style);
		setSize(SWT.DEFAULT, 100);
		
		final FillLayout layout = new FillLayout();
		layout.marginHeight = MARGIN_HEIGHT;
		layout.marginWidth = MARGIN_WIDTH;
		setLayout(layout);

		
		mapCanvas = new MapCanvas(this, SWT.NONE);
		mapCanvas.setGainFactor(gainFactor);
		mapCanvas.setDrawPolygonBorders(drawPolygonBorders);
//		mapCanvas.setPolygonStroke(polygonStroke);
		mapCanvas.setColorProvider(colorProviderAdapter);
		
		pack();

		mapCanvas.addSelectionChangedListener(this);

		menuManager = createContextMenuManager();
		mapCanvas.setMenu(menuManager.createContextMenu(this));
	} // MapRenderer

	/**
	 * @see org.eclipse.stem.ui.views.geographic.GeographicRenderer#render(org.eclipse.stem.ui.views.geographic.map.StemPolygonsList)
	 */
	@Override
	public void render(StemPolygonsList polygonsToRender) {
		mapCanvas.setGainFactor(this.gainFactor);
		mapCanvas.setUseLogScaling(this.useLogScaling);
		mapCanvas.render(polygonsToRender);
	}

	/**
	 * @see org.eclipse.stem.ui.views.geographic.GeographicRenderer#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		mapCanvas.reset();
		mapCanvas.setDrawPolygonBorders(drawPolygonBorders);
		mapCanvas.setGainFactor(gainFactor);
		mapCanvas.setUseLogScaling(useLogScaling);
	} // reset

	protected void toggleDrawPolygonBordersChoice() {
		super.toggleDrawPolygonBordersChoice();
		mapCanvas.setDrawPolygonBorders(drawPolygonBorders);
		redraw();
	} // toggleDrawPolygonBordersChoice

	protected void toggleUseLogScaling() {
		super.toggleUseLogScaling();
		mapCanvas.setUseLogScaling(useLogScaling);
	} // toggleUseLogScaling

	/**
	 * @return the MenuManager
	 */
	public MenuManager getMenuManager() {
		return menuManager;
	} // getMenuManager

	/**
	 * @see org.eclipse.stem.ui.views.geographic.GeographicRenderer#setColorProviderAdapter(org.eclipse.stem.ui.adapters.color.ColorProviderAdapter)
	 */
	@Override
	public void setColorProviderAdapter(ColorProviderAdapter colorProvider) {
		super.setColorProviderAdapter(colorProvider);
		mapCanvas.setColorProvider(colorProvider);
	}
	
	/**
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		fireSelection(event.getSelection());
	}

	/**
	 * @see org.eclipse.stem.ui.views.geographic.GeographicRenderer#dispose()
	 */
	@Override
	public void dispose() {		
		super.dispose();
		mapCanvas.removeSelectionChangedListener(this);
	}

} // MapRenderer
