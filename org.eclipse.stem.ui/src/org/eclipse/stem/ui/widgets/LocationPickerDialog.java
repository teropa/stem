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



import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.stem.data.geography.GeographicMapper;
import org.eclipse.stem.data.geography.GeographicNames;
import org.eclipse.stem.definitions.LocationUtility;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.wizards.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class LocationPickerDialog extends Dialog {

	private String title;
	
	private ISOKeyPicker isoKeyPicker2;
	private ISOKeyPicker isoKeyPicker1;
	private ISOKeyPicker isoKeyPicker0;
	private ISOKeyPicker isoKeyPicker3;
	String isoKey = ""; //$NON-NLS-1$
	URI targetURI = null;
	String tempISOKey = null;
	//String prevLoc = null;
	IProject project;
	private boolean selectGlobal = true;
	
	boolean cancelPressed = false;
	protected Shell shell;
	Composite mainComposite;
	public LocationPickerDialog (Shell parent, int style, String title, String prevLoc, IProject p) {
		super (parent, style);
		//setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX | SWT.APPLICATION_MODAL);
		this.title = title;
		//this.prevLoc = prevLoc;
		this.project = p;
		
	}
	
	/**
	 * open the modal window. 
	 * @return The String[] with results, or null if cancel was pressed.
	 */
	public Object []  open () {
		Shell parent = getParent();
		shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.MAX | SWT.APPLICATION_MODAL);
		//shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX | SWT.APPLICATION_MODAL);
		
		
		final Point minS = new Point(677, 410);
		shell.setMinimumSize(minS);
	
		GridLayout gl1 = new GridLayout();
		gl1.numColumns = 1;
		shell.setLayout(gl1);
		shell.setText(title);
		
		mainComposite = new Composite(shell, SWT.MAX);
		//mainComposite = new Composite(shell, SWT.RESIZE | SWT.MAX);
		
		
		shell.addListener(SWT.Resize, new Listener() {
		      public void handleEvent(Event e) {
		        
//		    	  Rectangle b = shell.getBounds();
//		    	  mainComposite.setBounds(b);
		    	//  System.out.println("***  SHELL *** bounds h= "+b.height+"  w= "+b.width+" : x0 = "+b.x+" y0 = "+b.y);
		    	  
//		    	  int w = b.width/3;
//		    	  int h = b.height/4;
//		    	  Rectangle r0 = isoKeyPicker0.getRegionListBounds();
//		    	  int x0 = r0.x;
//		    	  int y0 = r0.y;
//		    	  
//		    	  reSetKeyPickerSize(w,h);
		    	  shell.pack(); // resets the size back to the original !!
		    	  
//		    	  System.out.println("*** bounds h= "+b.height+"  w= "+b.width+" : x0 = "+x0+" y0 = "+y0);
//		    	  Rectangle b0 = isoKeyPicker0.getRegionListBounds();
//		    	  System.out.println("keypicker0 h= "+b0.height+"  w= "+b0.width);
//		    	  Rectangle b1 = isoKeyPicker1.getRegionListBounds();
//		    	  System.out.println("keypicker1 h= "+b1.height+"  w= "+b1.width);
//		    	  Rectangle b2 = isoKeyPicker2.getRegionListBounds();
//		    	  System.out.println("keypicker2 h= "+b2.height+"  w= "+b2.width);
//		    	  Rectangle b3 = isoKeyPicker3.getRegionListBounds();
//		    	  System.out.println("keypicker3 h= "+b3.height+"  w= "+b3.width);
		      }
		    });
		
		
		 
		GridLayout mainLayout = new GridLayout();
		mainLayout.numColumns = 2;
		mainLayout.makeColumnsEqualWidth = true;
		
		mainComposite.setLayout(mainLayout);
		final GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		//final GridData gridData = new GridData(SWT.CENTER);
		gridData.heightHint = 378;
		gridData.widthHint = 667;

		mainComposite.setLayoutData(gridData);
		
		// Radio buttons
		Composite radioComposite = new Composite(mainComposite, SWT.BORDER);
	    FillLayout fillLayout = new FillLayout();
	    fillLayout.type = SWT.HORIZONTAL;
	    radioComposite.setLayout(fillLayout);
	    
	    final Button [] radioButtons = new Button[2];
	    radioButtons[0] = new Button(radioComposite, SWT.RADIO);
	    radioButtons[0].setSelection(true);
	    radioButtons[0].setText(Messages.getString("NLocPickerWiz.global"));//$NON-NLS-1$
	    
	    radioButtons[1] = new Button(radioComposite, SWT.RADIO);
	    radioButtons[1].setText(Messages.getString("NLocPickerWiz.inproject"));//$NON-NLS-1$
	    	    
	    Listener listener = new Listener() {
	        public void handleEvent(Event event) {
	          if (event.widget == radioButtons[0]) {
	        	  if(radioButtons[0].getSelection()) {
	        		  selectGlobal = true;
	        		  reinit();
	        	  } else {
	        		  selectGlobal = false;
	        		  reinit();
	        	  }
	          }
	        }
	    };
	    radioButtons[0].addListener(SWT.Selection,listener);
	    
	    GridData gd_radio = new GridData(SWT.FILL, SWT.CENTER, true, false);
	    gd_radio.horizontalSpan = 2;
	    radioComposite.setLayoutData(gd_radio);
		
	    LocationUtility.reset();
	    // Location picker
		// ISO Key
		final Label isoKeyLabel = new Label(mainComposite, SWT.NONE);
		isoKeyLabel.setText(Messages.getString("NLocWizISOK")); //$NON-NLS-1$
		final GridData gd_isoKeyLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
		isoKeyLabel.setLayoutData(gd_isoKeyLabel);
		
		final Label isokeyValueLabel = new Label(mainComposite, SWT.NONE);
		isokeyValueLabel.setText(isoKey);

		final GridData gd_isoKeyLabelValue = new GridData(SWT.FILL, SWT.CENTER, true, false);
		isokeyValueLabel.setLayoutData(gd_isoKeyLabelValue);
		
		
		// ISOKeyPicker 0
		isoKeyPicker0 = new ISOKeyPicker(mainComposite, SWT.NONE, 0);
		isoKeyPicker0.setISOKeyLevel(0);
		isoKeyPicker0.setISOKeyLevelDescription(Messages.getString("NLocWizCNTRY"));
		isoKeyPicker0.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				Object[] isoKeys = null;
					if(selectGlobal) isoKeys= GeographicNames.getSubISOKeys(
						GeographicNames.getAlpha2(ikpe.getIsoKey()),
						isoKeyPicker1.getISOKeyLevel());
					else isoKeys = LocationUtility.getKeys(project, isoKeyPicker1.getISOKeyLevel(), ikpe.getIsoKey()).toArray();
				isoKeyPicker1.setISOKeys(isoKeys);
				isoKeyPicker2.setISOKeys(new Object[] {});
				isoKeyPicker3.setISOKeys(new Object[] {});
				isoKey = ikpe.getIsoKey();
				if(!selectGlobal) targetURI = LocationUtility.getURIFromISOKey(isoKey);
				tempISOKey = isoKey;
				isokeyValueLabel.setText(isoKey);
			}
		});
		
		// ISOKeyPicker 1
		isoKeyPicker1 = new ISOKeyPicker(mainComposite, SWT.NONE, 1);
		isoKeyPicker1.setISOKeyLevelDescription(Messages
				.getString("NLocWizL1"));
		isoKeyPicker1.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				Object[] isoKeys = null;
				if(selectGlobal) isoKeys = GeographicNames.getSubISOKeys(ikpe
						.getIsoKey(), isoKeyPicker2.getISOKeyLevel());
				else isoKeys = LocationUtility.getKeys(project, isoKeyPicker2.getISOKeyLevel(), ikpe.getIsoKey()).toArray();
				
				isoKeyPicker2.setISOKeys(isoKeys);
				isoKey = ikpe.getIsoKey();
				if(!selectGlobal) targetURI = LocationUtility.getURIFromISOKey(isoKey);
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
		isoKeyPicker2 = new ISOKeyPicker(mainComposite, SWT.NONE, 2);
		isoKeyPicker2.setISOKeyLevelDescription(Messages
				.getString("NLocWizL2"));
		isoKeyPicker2.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				Object[] isoKeys = null;
				if(selectGlobal) isoKeys = GeographicNames.getSubISOKeys(ikpe
						.getIsoKey(), isoKeyPicker3.getISOKeyLevel());
				else isoKeys = LocationUtility.getKeys(project, isoKeyPicker3.getISOKeyLevel(), ikpe.getIsoKey()).toArray();
				isoKeyPicker3.setISOKeys(isoKeys);
				isoKey = ikpe.getIsoKey();
				if(!selectGlobal) targetURI = LocationUtility.getURIFromISOKey(isoKey);
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
		isoKeyPicker3 = new ISOKeyPicker(mainComposite, SWT.NONE, 3);
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
		setKeyPickerLayouts();
		
		
		final Button okayButton = new Button(mainComposite, SWT.NONE);
		GridData gd = new GridData();
		okayButton.setText(Messages.getString("NLocWizOk"));
		okayButton.setLayoutData(gd);
		
		Button cancelButton = new Button(mainComposite, SWT.NONE);
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
		if(cancelPressed) return null;
		Object [] ret = new Object[2];
		ret[0] = this.isoKey;
		ret[1] = this.targetURI;
		return ret;
	}// open()
	
	
	
	/**
	 * 
	 */
	public void setKeyPickerLayouts() {
		// ISO Picker0
		//final GridData gd_isoKeyPicker0 = new GridData(SWT.CENTER, SWT.CENTER, true, true);
		final GridData gd_isoKeyPicker0 = new GridData(GridData.FILL_BOTH);
		gd_isoKeyPicker0.verticalSpan=1;
		gd_isoKeyPicker0.horizontalSpan=1;
		//gd_isoKeyPicker0. Upper left
		//final GridData gd_isoKeyPicker0 = new GridData(SWT.CENTER_HORIZONTAL);
		isoKeyPicker0.setLayoutData(gd_isoKeyPicker0);
		isoKeyPicker0.setISOKeys(GeographicNames.getSubISOKeys(
				GeographicMapper.EARTH_ALPHA3_ISO_KEY, -1));

		// ISOKeyPicker 1		Upper right
		final GridData gd_isoKeyPicker1 = new GridData(GridData.FILL_BOTH);
		gd_isoKeyPicker1.verticalSpan=1;
		gd_isoKeyPicker1.horizontalSpan=1;
		isoKeyPicker1.setLayoutData(gd_isoKeyPicker1);
		
		// ISOKeyPicker 2 lower left
		final GridData gd_isoKeyPicker2 = new GridData(GridData.FILL_BOTH);
		gd_isoKeyPicker2.verticalSpan=1;
		gd_isoKeyPicker2.horizontalSpan=1;
		isoKeyPicker2.setLayoutData(gd_isoKeyPicker2);
	
		// ISOKeyPicker 3 lower right
		final GridData gd_isoKeyPicker3 = new GridData(GridData.FILL_BOTH);
		gd_isoKeyPicker3.verticalSpan=1;
		gd_isoKeyPicker3.horizontalSpan=1;
		//fd_isoKeyPicker3.bottom = new FormAttachment(100, -5);
		isoKeyPicker3.setLayoutData(gd_isoKeyPicker3);
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public void reSetKeyPickerBounds(int width, int height,int x0, int y0) {
		isoKeyPicker0.setRegionListSize(width, height);
		isoKeyPicker1.setRegionListSize(width, height);
		isoKeyPicker2.setRegionListSize(width, height);
		isoKeyPicker3.setRegionListSize(width, height);
		isoKeyPicker0.setRegionListBounds(x0,y0,width, height);
		isoKeyPicker1.setRegionListBounds(x0+width, y0, width, height);
		isoKeyPicker2.setRegionListBounds(x0, y0+height, width, height);
		isoKeyPicker3.setRegionListBounds(x0+width, y0+height, width, height);
		
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public void reSetKeyPickerSize(int width, int height) {
		isoKeyPicker0.setRegionListSize(width, height);
		isoKeyPicker1.setRegionListSize(width, height);
		isoKeyPicker2.setRegionListSize(width, height);
		isoKeyPicker3.setRegionListSize(width, height);
		
	}
	
	
	/**
	 * 
	 */
	public void reinit() {
		
		if(selectGlobal)
			isoKeyPicker0.setISOKeys(GeographicNames.getSubISOKeys(
				GeographicMapper.EARTH_ALPHA3_ISO_KEY, -1));
		else {
			IRunnableWithProgress getKeys = new IRunnableWithProgress() {
	            public void run(IProgressMonitor progress) {
	            	progress.beginTask(Messages.getString("NLocPickerWiz.gettingLocations"), 100);   	
	        		isoKeyPicker0.setISOKeys(LocationUtility.getKeys(project, 0, null).toArray());
	            	progress.worked(100);
	            	progress.done();
	            }
			};
			
			IRunnableContext context = new ProgressMonitorDialog(shell);
			try {
				context.run(true, true, getKeys);
			} catch(Exception e) {
				Activator.logError(e.getMessage(), e);
			}
			
		}
		isoKeyPicker1.setISOKeys(new Object[] {});
		isoKeyPicker2.setISOKeys(new Object[] {});
		isoKeyPicker3.setISOKeys(new Object[] {});

	}
	
	/**
	 * 
	 * @return
	 */
	public String getISOKey() {
		return isoKey;
	}
	
//	public static void main(String [] args) {
//		Display display = new Display();
//	    Shell shell = new Shell(display);
//	    		
//		LocationPickerDialog2 dialog  = new LocationPickerDialog2(shell, SWT.RESIZE|SWT.PUSH, "Pick location", "", null);		 
//	    dialog.open();
//	    while (!shell.isDisposed()) {
//	      if (!display.readAndDispatch()) {
//	        display.sleep();
//	      }
//	    }
//	    System.out.println("Picked location:"+dialog.getISOKey());
//	    display.dispose();
//	}
	
}
