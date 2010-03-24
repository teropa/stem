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

import org.eclipse.stem.data.geography.GeographicMapper;
import org.eclipse.stem.data.geography.GeographicNames;
import org.eclipse.stem.ui.widgets.MatrixEditorWidget.MatrixEditorValidator;
import org.eclipse.stem.ui.wizards.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LocationPickerDialog extends Dialog {

	private String title;
	
	private ISOKeyPicker isoKeyPicker2;
	private ISOKeyPicker isoKeyPicker1;
	private ISOKeyPicker isoKeyPicker0;
	private ISOKeyPicker isoKeyPicker3;
	String isoKey = ""; //$NON-NLS-1$
	String tempISOKey = null;
	String prevLoc = null;
	
	boolean cancelPressed = false;
	
	public LocationPickerDialog (Shell parent, int style, String title, String prevLoc) {
		super (parent, style);
		this.title = title;
		this.prevLoc = prevLoc;
	}
	
	/**
	 * open the modal window. 
	 * @return The String[] with results, or null if cancel was pressed.
	 */
	public String  open () {
		Shell parent = getParent();
		final Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(title);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		shell.setLayout(gl);
		
		// Location picker
		// ISO Key
		final Label isoKeyLabel = new Label(shell, SWT.NONE);
		isoKeyLabel.setText(Messages.getString("NLocWizISOK")); //$NON-NLS-1$
		final GridData gd_isoKeyLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
		isoKeyLabel.setLayoutData(gd_isoKeyLabel);
		
		final Label isokeyValueLabel = new Label(shell, SWT.NONE);
		isokeyValueLabel.setText(isoKey);

		final GridData gd_isoKeyLabelValue = new GridData(SWT.FILL, SWT.CENTER, true, false);
		isokeyValueLabel.setLayoutData(gd_isoKeyLabelValue);
		
		
		// ISOKeyPicker 0
		isoKeyPicker0 = new ISOKeyPicker(shell, SWT.NONE, 0);
		isoKeyPicker0.setISOKeyLevel(0);
		isoKeyPicker0.setISOKeyLevelDescription(Messages.getString("NLocWizCNTRY"));
		isoKeyPicker0.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				final Object[] isoKeys = GeographicNames.getSubISOKeys(
						GeographicNames.getAlpha2(ikpe.getIsoKey()),
						isoKeyPicker1.getISOKeyLevel());
				isoKeyPicker1.setISOKeys(isoKeys);
				isoKeyPicker2.setISOKeys(new Object[] {});
				isoKeyPicker3.setISOKeys(new Object[] {});
				isoKey = ikpe.getIsoKey();
				tempISOKey = isoKey;
				isokeyValueLabel.setText(isoKey);
			}
		});
		
		// ISOKeyPicker 1
		isoKeyPicker1 = new ISOKeyPicker(shell, SWT.NONE, 1);
		isoKeyPicker1.setISOKeyLevelDescription(Messages
				.getString("NLocWizL1"));
		isoKeyPicker1.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				final Object[] isoKeys = GeographicNames.getSubISOKeys(ikpe
						.getIsoKey(), isoKeyPicker2.getISOKeyLevel());
				isoKeyPicker2.setISOKeys(isoKeys);
				isoKey = ikpe.getIsoKey();
				tempISOKey = tempISOKey == null ? isoKey : tempISOKey;
				// Were there any ISO keys to set?
				if (isoKeys.length == 0) {
					// No
					isoKey = tempISOKey;
					isokeyValueLabel.setText(isoKey);
					tempISOKey = null;
				} // if
			}
		});
		
		// ISOKeyPicker 2
		isoKeyPicker2 = new ISOKeyPicker(shell, SWT.NONE, 2);
		isoKeyPicker2.setISOKeyLevelDescription(Messages
				.getString("NLocWizL2"));
		isoKeyPicker2.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				final Object[] isoKeys = GeographicNames.getSubISOKeys(ikpe
						.getIsoKey(), isoKeyPicker3.getISOKeyLevel());
				isoKeyPicker3.setISOKeys(isoKeys);
				isoKey = ikpe.getIsoKey();
				tempISOKey = tempISOKey == null ? isoKey : tempISOKey;
				// Were there any ISO keys to set?
				if (isoKeys.length == 0) {
					// No
					isoKey = tempISOKey;
					isokeyValueLabel.setText(isoKey);
					tempISOKey = null;
				} // if
			}
		});
		
		// ISOKeyPicker 3
		isoKeyPicker3 = new ISOKeyPicker(shell, SWT.NONE, 3);
		isoKeyPicker3.setISOKeyLevelDescription(Messages
				.getString("NLocWizL3"));
		isoKeyPicker3.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				isoKey = tempISOKey == null ? ikpe.getIsoKey() : tempISOKey;
				isokeyValueLabel.setText(isoKey);
				tempISOKey = null;
			}
		});
		
		
		//   FORM DATA   //
		
		// ISO Picker0
		final GridData gd_isoKeyPicker0 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		isoKeyPicker0.setLayoutData(gd_isoKeyPicker0);
		isoKeyPicker0.setISOKeys(GeographicNames.getSubISOKeys(
				GeographicMapper.EARTH_ALPHA3_ISO_KEY, -1));

		// ISOKeyPicker 1		
		final GridData gd_isoKeyPicker1 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		isoKeyPicker1.setLayoutData(gd_isoKeyPicker1);
		
		// ISOKeyPicker 2
		final GridData gd_isoKeyPicker2 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		isoKeyPicker2.setLayoutData(gd_isoKeyPicker2);
	
		// ISOKeyPicker 3
		final GridData gd_isoKeyPicker3 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		//fd_isoKeyPicker3.bottom = new FormAttachment(100, -5);
		isoKeyPicker3.setLayoutData(gd_isoKeyPicker3);
		
		final Button okayButton = new Button(shell, SWT.NONE);
		GridData gd = new GridData();
		okayButton.setText(Messages.getString("NLocWizOk"));
		okayButton.setLayoutData(gd);
		
		Button cancelButton = new Button(shell, SWT.NONE);
		gd = new GridData();
		cancelButton.setText(Messages.getString("NLocWizCancel"));
		cancelButton.setLayoutData(gd);
		// getShell().pack();
		shell.pack();
		shell.open();
		
		
		okayButton.addSelectionListener( new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				cancelPressed=false;
				shell.dispose();
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cancelButton.addSelectionListener( new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				cancelPressed=true;
				shell.dispose();
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
		if (!display.readAndDispatch()) display.sleep();
		}
		if(cancelPressed) return this.prevLoc;
		return this.isoKey;
	}
	
	public String getISOKey() {
		return isoKey;
	}
	public static void main(String [] args) {
		Display display = new Display();
	    Shell shell = new Shell(display);
	    		
		LocationPickerDialog dialog  = new LocationPickerDialog(shell, SWT.PUSH, "Pick location", "");		 
	    dialog.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    System.out.println("Picked location:"+dialog.getISOKey());
	    display.dispose();
	}
	
}
