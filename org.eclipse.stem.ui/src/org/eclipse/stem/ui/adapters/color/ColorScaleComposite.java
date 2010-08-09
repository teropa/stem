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

import java.text.DecimalFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * This class is used to display a "legend" that maps colors to values.
 */
public class ColorScaleComposite extends Composite {

	Group scaleGroup = new Group(this, SWT.NONE);
	CLabel colorScale;
	
	static final int NUM_AXIS_LABELS = 5;
	Label[] valueScale = new Label[NUM_AXIS_LABELS]; // 5 values;
	static final int SCALE_HEIGHT=20;
	static final int SCALE_WIDTH=100;
	DecimalFormat bigFormat = new DecimalFormat("#0.0");
	DecimalFormat sciFormat = new DecimalFormat("0.#E0");
	
	boolean useLogScale = false;
	
	static final int NUM_STEPS=5;
	
	/**
	 * 
	 * @param parent
	 * @param saturatedColor
	 * @param axis
	 * @param logScale
	 * @param style
	 * @param backGround
	 * @param textColor
	 */
	public ColorScaleComposite(final Composite parent, Color saturatedColor, double[] axis, boolean logScale, final int style, Color backGround, Color textColor) {
		super(parent, style);
		scaleGroup.setText("Scale");
		final FormLayout scaleLayout = new FormLayout();
		scaleGroup.setLayout(scaleLayout);
		
		colorScale = new CLabel(scaleGroup, SWT.LEFT);
		
		colorScale.setBackground(backGround);
		colorScale.setForeground(textColor);
		colorScale.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		final FormData scaleData = new FormData();
		scaleData.top = new FormAttachment(0, 0);
		scaleData.bottom = new FormAttachment(50, 0);
		scaleData.left = new FormAttachment(0, 0);
		scaleData.right = new FormAttachment(100, 0);
		colorScale.setLayoutData(scaleData);
		//Point sSize = new Point(SCALE_WIDTH, SCALE_HEIGHT);
		//colorScale.setSize(sSize);
		
		  
	    int leftMargin = 0;
	    int step = 100/NUM_AXIS_LABELS;
	    for (int i = 0; i < NUM_AXIS_LABELS; i ++) {
	    	valueScale[i] = new Label(scaleGroup, SWT.LEFT);
	    	final FormData valueData = new FormData();
			valueData.top = new FormAttachment(50, 0);
			valueData.bottom = new FormAttachment(100, 0);
			valueData.left = new FormAttachment(leftMargin, 0);
			valueData.right = new FormAttachment(leftMargin+step, 0);
			valueScale[i].setLayoutData(valueData);
			valueScale[i].setText(" "); // TESTING
			leftMargin += step;
			valueScale[i].setBackground(backGround);
			valueScale[i].setForeground(textColor);
	    }
	    
	    updateColorScale(saturatedColor, axis, logScale, backGround, textColor);
		
		scaleGroup.setVisible(true);
		scaleGroup.pack();
		
		this.layout();
		this.pack();
		this.setVisible(true);
		
	}

	/**
	 * 
	 * @param saturatedColor
	 * @param axis
	 * @param logScale
	 * @param textBackGround
	 * @param textForeground
	 */
    public void updateColorScale(Color saturatedColor, double[] axis, boolean logScale, Color textBackGround, Color textForeground) {
    	
    	Color[] scaleColors = new Color[5];
    	
    	int size = NUM_STEPS-1;
    	
    	double r = saturatedColor.getRed();
		double g = saturatedColor.getGreen();
		double b = saturatedColor.getBlue();
				
		// TODO this is IF LINEAR
		for(int i = 0; i < 5; i ++) {
			double alphaF = ((double) i)/4.0; // this is 0=>1 not 0-255
			int ir = (int) (alphaF*r);
			int ig = (int) (alphaF*g);
			int ib = (int) (alphaF*b);
			scaleColors[i] = new Color(getDisplay(), ir,ig,ib);
		}
    	
    	int[] spacing = new int[size];
    	if(size<=0) size = 1;
    	int delta = 100/size;
    	for(int i = 0; i < size; i ++) {
    		spacing[i] = delta*(i+1);
    	}
    	
    	// Set the background gradient
	    colorScale.setBackground(scaleColors, spacing);
	    
	    for (int i = 0; i < NUM_AXIS_LABELS; i ++) {
			valueScale[i].setBackground(textBackGround);
			valueScale[i].setForeground(textForeground);
	    }
	    
	    int last = NUM_AXIS_LABELS-1;
	    valueScale[0].setAlignment(SWT.RIGHT);
	    valueScale[last].setAlignment(SWT.LEFT);
	    
	    if(axis[1]==1.0) {
	    	valueScale[last].setText("1.0");
	    } else {
	    	valueScale[last].setText(""+sciFormat.format(axis[1]));
	    }
	    
	    
	    if(logScale) {
	    	//double gain = 1.0/axis[1]; // the gain
	    	// TODO CHECK THIS CODE
	    	double min = (Math.exp(2) -1.0) / (axis[1]*100.0);   // this is the min
	    	valueScale[0].setText("< "+sciFormat.format(min));
	    } else {
	    	valueScale[0].setText(""+axis[0]);
	    }
	    
	    
	    
    }// updateColorScale
	

	public boolean isUseLogScale() {
		return useLogScale;
	}



	public void setUseLogScale(boolean useLogScale) {
		this.useLogScale = useLogScale;
	}



} // ColorsLegendComposite
