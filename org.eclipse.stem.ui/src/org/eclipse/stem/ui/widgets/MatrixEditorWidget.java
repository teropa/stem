package org.eclipse.stem.ui.widgets;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.stem.ui.wizards.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MatrixEditorWidget extends Composite {

	public enum STATUS {
		OKAY,
		INVALID_VALUE;
	}
	
	private short rows;
	short dynrows;
	short columns;
	private String [] rowNames, colNames;
	private boolean fixedSize;
	private Color colRowHeaderColumns = new Color(null, 200, 200, 200);
	private Color textBackgroundColumns = new Color(null, 255, 255, 255);
	private Color textBorderColor =  new Color(null, 0, 0, 0);
	
	ArrayList<Text> textWidgets = new ArrayList<Text>();
	ArrayList<String> textValues = new ArrayList<String>();
	
	MatrixEditorValidator validator = null;
	private ArrayList<MatrixEditorListener> listeners = new  ArrayList<MatrixEditorListener>();
	
	Label status = null;
	Button currentPlusButton;
	Button currentMinusButton;
	ArrayList<Label>emptyLabels = new ArrayList<Label>();
	
	
	/**
	 * Create a new Matrix Editor Widget
	 * 
	 * @param parent
	 * @param rows
	 * @param columns
	 * @param rownames
	 * @param columnNames
	 */
	
	public MatrixEditorWidget(Composite parent, int style, short rows, short columns, String[] rownames, String [] columnNames, String []existingVals,boolean fixedSize, MatrixEditorValidator validator) {
		super(parent, style);
		this.rows = rows;
		this.dynrows = rows; // dynamically adjusted number of rows
		this.columns = columns;
		this.rowNames = rownames;
		this.colNames = columnNames;
		this.validator = validator;
		this.fixedSize = fixedSize;
		createContents(existingVals);
		
	}

	protected void createContents(String []existingVals) {
		setBackground(new Color(null, 255, 255, 255));
		
		GridLayout layout = new GridLayout();
		layout.numColumns = columns+1;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginBottom = 0;
		layout.marginLeft = 0;
		layout.marginRight = 0;
		layout.marginTop = 0;
		
		this.setLayout(layout);
		
		// The status row for error messages etc.
		status = new Label(this, SWT.NONE);
		status.setForeground(new Color(null, 255, 0, 0));
		GridData sgd = new GridData();
		if((rowNames != null && rowNames.length > 0) || fixedSize == false)
			sgd.horizontalSpan = columns+1;
		else
			sgd.horizontalSpan = columns;
		
		status.setLayoutData(sgd);
		status.setText("");
		
		if((rowNames != null && rowNames.length > 0) || fixedSize == false) { 
			Label lab = new Label(this, SWT.NONE);
			lab.setText("");
			GridData gd = new GridData();
			//gd.horizontalAlignment = GridData.FILL;
			//gd.grabExcessHorizontalSpace = true;
			lab.setLayoutData(gd);
		}
		// Create column headers
		if(colNames!=null) for(int c=0;c<colNames.length;++c) {
			Label lab = new Label(this, SWT.BORDER);
			lab.setText(colNames[c]);
			GridData gd = new GridData();
			gd.horizontalAlignment = GridData.FILL;
			gd.grabExcessHorizontalSpace = true;
			gd.grabExcessVerticalSpace = false;
			gd.horizontalIndent = 1;
			gd.verticalIndent = 1;
			gd.minimumWidth = 128;
			lab.setLayoutData(gd);
			lab.setBackground(colRowHeaderColumns);
			addBorder(lab);
		}
		// Create the text
		
		for(int r=0;r<rows;++r) {
			if((rowNames != null && rowNames.length > r) || fixedSize == false) {
				Label lab = new Label(this, SWT.BORDER);
				if(fixedSize)
					lab.setText(rowNames[r]);
				else
					lab.setText("");
				GridData gd = new GridData();
				gd.horizontalAlignment = GridData.FILL;
				//gd.grabExcessHorizontalSpace = true;
				lab.setLayoutData(gd);
				if(fixedSize)lab.setBackground(colRowHeaderColumns);
				else lab.setBackground(new Color(null, 255, 255, 255));
				if(fixedSize)addBorder(lab);
				emptyLabels.add(lab);
			}
			
			for(int c=0;c<columns;++c) {
				Text t = addTextField();
				int index = r*columns+c;
				if(existingVals != null && existingVals.length > index)
					t.setText(existingVals[index]);
			}
		} // for each row
	
		if(fixedSize == false) {
			currentPlusButton = addPlusButton();
			currentMinusButton = addMinusButton();
			if(rows < 2)currentMinusButton.setEnabled(false);
		}
	}
	
	Text addTextField() {
		final Text text = new Text(this, SWT.NONE);
		text.setBackground(textBackgroundColumns);
		text.setForeground(textBorderColor);
	
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = false;
		gd.grabExcessVerticalSpace = false;
		gd.horizontalIndent = 1;
		gd.verticalIndent = 1;
		
		text.setLayoutData(gd);
		addBorder(text);
		textWidgets.add(text);
		textValues.add("");
		
		text.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				boolean problem = false;
				for(Text t:MatrixEditorWidget.this.textWidgets) {
					String val = t.getText().trim();
					if(!validator.validateValue(val)) {
						problem = true;
						status.setText(MessageFormat.format(org.eclipse.stem.ui.wizards.Messages.getString("Matrix.invalid.value"), val));
						status.pack(true);
						break;
					}
				}
				if(!problem) {
					status.setText("");
					status.pack(true);
					fireEvent(new MatrixEditorEvent(STATUS.OKAY));
				} else fireEvent(new MatrixEditorEvent(STATUS.INVALID_VALUE));
				
				int index = textWidgets.indexOf(text);
				textValues.set(index, text.getText());
			}
		});
		return text;
	}
	
	Button addPlusButton() {
		Button plusButton = new Button(this, SWT.NONE);
		GridData gd = new GridData();
		plusButton.setText(Messages.getString("Matrix.dialog.plus"));
		plusButton.setLayoutData(gd);
	
		plusButton.addSelectionListener(new SelectionListener() {		
			public void widgetSelected(SelectionEvent arg0) {
				currentMinusButton.setEnabled(true);
				++dynrows;
				
				Label lab = new Label(MatrixEditorWidget.this, SWT.BORDER);
				lab.setText("");
				GridData gd = new GridData();
				gd.horizontalAlignment = GridData.FILL;
				lab.setLayoutData(gd);
				lab.setBackground(new Color(null, 255, 255, 255));
				emptyLabels.add(lab);
				Text lastText = null;
				for(int i=0;i<columns;++i) lastText = addTextField();
				
				currentPlusButton.moveBelow(lastText);
				currentMinusButton.moveBelow(currentPlusButton);
				lastText.setText(lastText.getText()); // Invoke validator
				MatrixEditorWidget.this.layout(true);
				MatrixEditorWidget.this.pack(true);
				MatrixEditorWidget.this.getParent().pack(true);
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		return plusButton;
	}
	
	Button addMinusButton() {
		Button minusButton = new Button(this, SWT.NONE);
		GridData gd = new GridData();
		minusButton.setText(Messages.getString("Matrix.dialog.minus"));
		minusButton.setLayoutData(gd);
	
		minusButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				for(int i=(dynrows-1)*columns;i<(dynrows-1)*columns+columns;++i) textWidgets.get(i).dispose();
				for(int i=0;i<columns;++i) {textWidgets.remove((dynrows-1)*columns);textValues.remove((dynrows-1)*columns);}
				Label elab = emptyLabels.get(dynrows-1);
				Text lastText = textWidgets.get((dynrows-2)*columns+columns-1);
				currentPlusButton.moveBelow(lastText);
				currentMinusButton.moveBelow(currentPlusButton);
				elab.dispose();
				emptyLabels.remove(elab);
				--dynrows;
				if(dynrows == 1)
					currentMinusButton.setEnabled(false);
				
				lastText.setText(lastText.getText()); // Invoke validator
				
				MatrixEditorWidget.this.layout(true);
				MatrixEditorWidget.this.pack(true);
				MatrixEditorWidget.this.getParent().pack(true);
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		return minusButton;
	}
	
	private void addBorder(final Control t) {
		// Add a border around the text box
		t.addPaintListener( new PaintListener() {
			
			public void paintControl(PaintEvent evt) {
				Point s = t.getSize();
				Color c = evt.gc.getForeground();

				evt.gc.setForeground(t.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			       evt.gc.drawRectangle(0,0,s.x-1,s.y-1);
			       evt.gc.setForeground(c);
			   }

			} );
	}
	
	public void addListener(MatrixEditorListener listener) {this.listeners.add(listener);}
	
	void fireEvent(MatrixEditorEvent evt) {for(MatrixEditorListener l:listeners) l.eventReceived(evt);}
	
	public ArrayList<String> getTextValues() {
		return this.textValues;
	}
	
	public static void main(String [] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		FillLayout fl = new FillLayout();
		fl.type = SWT.VERTICAL;
		shell.setLayout(fl);
		
//		String [] rn = {"AGE0-10", "AGE11-35","AGE36-100"};
//		String [] cn = {"AGE0-10", "AGE11-35","AGE36-100"};
		
//		MatrixEditorWidget m = new MatrixEditorWidget(shell, SWT.PUSH, (short)3, (short)3, rn, cn, true, new MatrixEditorValidator() {
	
		String [] cn = {"Population Group"};
			
		MatrixEditorWidget m = new MatrixEditorWidget(shell, SWT.PUSH, (short)1, (short)1, null, cn, null, false, new MatrixEditorValidator() {
		
			public boolean validateValue(String val) {
				if(val == null || val.trim().equals("")) return true;
				try {
					Double.parseDouble(val.trim());
				} catch(NumberFormatException nfe) {
					return false;
				}
				return true;
			}
		});
		
		m.addListener(new MatrixEditorWidget.MatrixEditorListener() {
			
			public void eventReceived(MatrixEditorEvent event) {
				if(event.status == MatrixEditorWidget.STATUS.OKAY) System.out.println("okay");
				else System.out.println("invalid");
			}
		});
		shell.pack();
		shell.open();
		
		 while (!shell.isDisposed()) {
	            if (!display.readAndDispatch()) display.sleep();
	        }
	}
	
	public static class MatrixEditorEvent {
		public STATUS status;
		
		public MatrixEditorEvent(STATUS s) {this.status = s;}
	}
	
	public interface MatrixEditorListener {
		public void eventReceived(MatrixEditorEvent event);
	}
	
	public interface MatrixEditorValidator {

		/**
		 * Validate. Return false if the value is invalid
		 * @param val
		 * @return False if invalid
		 */
		public boolean validateValue(String val);
	}
}
