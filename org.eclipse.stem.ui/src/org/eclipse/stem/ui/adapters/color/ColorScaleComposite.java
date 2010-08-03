package org.eclipse.stem.ui.adapters.color;

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

import java.awt.FlowLayout;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.stem.ui.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * This class is used to display a "legend" that maps colors to values.
 */
public class ColorScaleComposite extends Composite {

	Composite parent;
	Group scaleGroup = new Group(this, SWT.NONE);
	CLabel colorScale;
	CLabel[] valueScale = new CLabel[5]; // 5 values;
	
	AbstractRelativeValueColorProviderAdapter colorProviderAdapter;
	

	boolean useLogScale = false;
	double scaleFactor = 1.0;
	

	/**
	 * @param parent
	 * @param style
	 */
	public ColorScaleComposite(final Composite parent, AbstractRelativeValueColorProviderAdapter colorProviderAdapter, final int style) {
		super(parent, style);
		this.parent = parent;
		scaleGroup.setText("Scale");
		final FormLayout scaleLayout = new FormLayout();
		scaleGroup.setLayout(scaleLayout);
		
		colorScale = new CLabel(scaleGroup, SWT.LEFT);
		colorScale.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		final FormData scaleData = new FormData();
		scaleData.top = new FormAttachment(0, 0);
		scaleData.bottom = new FormAttachment(50, 0);
		scaleData.left = new FormAttachment(0, 0);
		scaleData.right = new FormAttachment(100, 0);
		colorScale.setLayoutData(scaleData);
		
		updateColorScale();
		  
	    int leftMargin = 0;
	   
	    for (int i = 0; i < 5; i ++) {
	    	valueScale[i] = new CLabel(scaleGroup, SWT.LEFT);
	    	final FormData valueData = new FormData();
			valueData.top = new FormAttachment(50, 0);
			valueData.bottom = new FormAttachment(100, 0);
			valueData.left = new FormAttachment(leftMargin, 0);
			valueData.right = new FormAttachment(leftMargin+20, 0);
			valueScale[i].setLayoutData(valueData);
			valueScale[i].setText(""+i); // TESTING
	    	leftMargin += 20;
	    }
		
		

		
		scaleGroup.setVisible(true);
		scaleGroup.pack();
		
		this.layout();
		this.pack();
		this.setVisible(true);
	}

	/**
	 * 
	 */
    public void updateColorScale() {
    	if(colorProviderAdapter==null) {
    		System.out.println("I'm null :-(");
    		return;
    	}
    	// if not log scaling
    	double v0 = 0;
    	double v1 = 0.25/scaleFactor;
    	double v2 = 0.5/scaleFactor;
    	double v3 =0.75/scaleFactor;
    	double v4 =1.0/scaleFactor;
    	if(useLogScale) {
    		// code goes here for log
    	}
    	
    	Color c1 = colorProviderAdapter.getColorForRelativeValue(v0);
    	Color c2 = colorProviderAdapter.getColorForRelativeValue(v1);
    	Color c3 = colorProviderAdapter.getColorForRelativeValue(v2);
    	Color c4 = colorProviderAdapter.getColorForRelativeValue(v3);
    	Color c5 = colorProviderAdapter.getColorForRelativeValue(v4);
    	
    	// Set the background gradient
	    colorScale.setBackground(new Color[] {
		        c1,c2,c3,c4,c5}, new int[] { 25, 50, 75, 100});
    }
	
	public ColorProviderAdapter getColorProviderAdapter() {
		return colorProviderAdapter;
	}



	public void setColorProviderAdapter(AbstractRelativeValueColorProviderAdapter colorProviderAdapter) {
		this.colorProviderAdapter = colorProviderAdapter;
	}



	public boolean isUseLogScale() {
		return useLogScale;
	}



	public void setUseLogScale(boolean useLogScale) {
		this.useLogScale = useLogScale;
	}



} // ColorsLegendComposite
