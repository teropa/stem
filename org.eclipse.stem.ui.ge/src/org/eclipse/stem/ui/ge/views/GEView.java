package org.eclipse.stem.ui.ge.views;
/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/ 
import java.io.File;
import java.io.FileFilter;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.ui.ge.Aspect;
import org.eclipse.stem.ui.ge.GEInterface;
import org.eclipse.stem.ui.ge.GELog;
import org.eclipse.stem.ui.ge.kml.StemKml;
import org.eclipse.stem.ui.ge.views.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.ViewPart;


/**
 * GEView: Opens a view of STEM that controls the 
 * interface to GoogleEarth. <p> 
 * The actual interface to GoogleEarth is handled by GEInterface class
 * This GUI view only handles the direct User interface.  
 * <p> 
 * It displays a window with a list of active simulations and 
 * supports a popup context window that allows a set of actions 
 * either global actions or actions on a specific simulation
 *   
 * 
 * <p>
 */

public class GEView extends ViewPart  {
	
	/**
	 * The identifier of the GoogleEarth View
	 */
	public static final String ID_GE_VIEW = Constants.ID_ROOT
			+ ".ui.views.ge"; //$NON-NLS-1$

	/**
	 * A ListViewer that will list simulations that we 
	 * can watch. 
	 */
	private ListViewer viewer = null;
	
	

	/**
	 * Activator for the ui project.
	 * This is here to make it clear which Activator we 
	 * are refering to.
	 */
	private org.eclipse.stem.ui.Activator uiActivator = null;
	/**
	 * The color registry manages SWT colors, creates them on-demand, and takes
	 * care of disposal.
	 */
	private static ColorRegistry colorRegistry = null;
	/**
	 * reference to contentprovider for the ListViewer
	 */
	private GEViewContentProvider contentProvider = null;
	/**
	 * reference to the interface class
	 */
	private GEInterface gei = null;

	

	
	/**
	 * set to true wen GoogleEarth view starts
	 * Used to prevent more than one instance.
	 */
	private static boolean active = false;
	
	/**
	 * Some constants we need to set preferred sizes of SWT controls and
	 * containers.
	 */

	private static final int STANDARD_LENGTH = 370;

	private static final int STANDARD_HEIGHT = 15;

	
	/* *************************************************** 
	 * Constructor
	 *****************************************************/
	/**
	 * The GEView constructor gets control when the user opens 
	 * the "View" in the current perspective.
	 * 
	 * In the GEView constructor we will create an
	 * instance of GEInterface which does all the work.
	 * 
	 * 
	 */
	public GEView() {
		if (active) {
			GELog.error("STEM - GoogleEarth interface already active",null);
			throw new RuntimeException("Duplicate");
		}
		active = true;
		gei = new GEInterface(this);			
		GELog.debug(GEView.class,"gei="+gei);	
//		 Set the color registry
		if (colorRegistry == null) {
			uiActivator = org.eclipse.stem.ui.Activator.getDefault();
			colorRegistry = uiActivator.getColorRegistry();
		}
		
					
	}


	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 * We also add some useful buttons to the view
	 * 
	 * @param parent Composite to work with
	 */
	public void createPartControl(Composite parent) {

		//	 get our preferences 
        
		boolean debug = GEPreferencePage.isDebug();
		if (debug) {
			GELog.DEBUG = true;
			GELog.debug(this,"Debug option turned on.");
		} else {
			GELog.debug(this,"Debug option being turned off.");
			GELog.DEBUG = false;
		}
		GELog.debug("GEView.createPartControl:");
		
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 1;
	    
        //	 setup the aspect display buttons  

		parent.setLayout(gridLayout);
		String aspect = Aspect.getDefaultCode();
		createControlButtons(parent,aspect);
		
		
        // setup the List of Simulations		
		GridData gridData = new GridData();
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.grabExcessHorizontalSpace = true;
	    Composite control = getScrollable(parent,gridData);
		control.setLayout(new FillLayout());

		viewer = new ListViewer(control);
		// we provide the ContentProvider and LabelProvider classes
		
		contentProvider = new GEViewContentProvider(gei); 
		viewer.setContentProvider(contentProvider);
		GEViewLabelProvider lp = new GEViewLabelProvider();
		viewer.setLabelProvider(lp );
		lp.setGEI(gei);
		// define the instance that will be the parent 
		// passed to the getElements method
		viewer.setInput(SimulationManager.getManager());
        //We also want to be able to have a user select a simluation from our
		// view and have that been seen by others. So we register the ListViewer
		// instance as the view's selection provider. When you click on the GUI
		// it finds the underlying Object (i.e., ISimulation) you selected and
		// passes it to the selection service.
		getSite().setSelectionProvider(viewer);
		
		
		// if we wanted to listen to all selection events 
		IWorkbenchWindow ww = getSite().getWorkbenchWindow();
		ISelectionService ss = ww.getSelectionService();
		ss.addSelectionListener(contentProvider);
		// (getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(contentProvider);
		
		
		boolean ok = gei.init(); 
		if ( ! ok ) {
			GELog.debug(this,gei.getErrorMessage());
			showMessage(gei.getErrorMessage());
		    gei.setErrorMessage(null);
		}
		// make the popup menu actions
		GEViewActions actions = new GEViewActions(this,gei);
		if (actions == null) {
			GELog.error("Unable to setup context menu",null);
		}
		
		boolean autoLaunch = GEPreferencePage.isAutoLaunch();
		if (autoLaunch) {
			StemKml.launchGE();
		}		
	}
	/**
	 * call the refresh method for the viewer
	 *
	 */
	public void refresh() {
		viewer.refresh();
	}
	/**
	 * Put up a dialog box with an informational msg
	 * 
	 * @param message
	 */
	public void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			Messages.getString("GEView.27"), //$NON-NLS-1$
			message);
	}
	/**
	 * Put up a dialog box with a warning msg
	 * 
	 * @param message
	 */
	
//	private void showWarning(String message) {
//		MessageDialog.openWarning(
//			viewer.getControl().getShell(),
//			"GEView: GoogleEarth View",
//			message);
//	}
	
	
	/**
	 * Verify that we can use the folder to store KML
	 * @param folder
	 * @return verified folder
	 */
	public String verifyFolder(String folder) {
		folder = folderDialog(folder);
		GELog.debug(this,"verifyFolder="+folder);
		if (folder != null)
		    GEPreferencePage.setFolder(folder);
		return folder;
	}
	


	
	
	/**
	 * dialog to choose a folder to store files into.
	 * 
	 * If Default folder exist, it will be used.
	 * if default folder is null or does not exist,
	 * then system temporary folder will be used as default
	 * and a dialog will be shown.
	 * <p>
	 * If there are existing KML files in the folder
	 * a prompt will be produced asking if they should be removed.
	 * 
	 * @param deflt Default folder.
	 * @return folder path.
	 */
	private String folderDialog(String deflt) {
		String folder = null;
		try {
			if (deflt != null) {
				File defaultf = new File(deflt);
				if (defaultf.exists() && defaultf.isDirectory()) {
					folder = deflt;
				} else {
					folder = null;
				}
			}
			while (true) {
				if (folder == null) {
					// get tmp file folder
					File tmpFile = File.createTempFile("XXX","tmp"); //$NON-NLS-1$ //$NON-NLS-2$
					folder = tmpFile.getParent();
					Shell shell = viewer.getControl().getShell();
					int style = SWT.APPLICATION_MODAL;
					DirectoryDialog fd = new DirectoryDialog(shell,style);
					fd.setFilterPath(folder);
					fd.setText(Messages.getString("GEView.30")); //$NON-NLS-1$
					fd.setMessage(Messages.getString("GEView.31")); //$NON-NLS-1$

					while (true) {
						folder = fd.open();
						if (folder == null) {
							// user pressed cancel
							return null;
						} else {		    
							File dir = new File(folder);
							if (dir.exists() && dir.isDirectory()) {
								boolean ok = checkContents(folder);
								if (ok) 
									break;
							} if (!dir.exists()) {
								dir.mkdirs();
							}
						}
					}  // while(true)
					break;
				} else { 
					// using the specified folder.  
					// check if KML filies to be deleted.
					boolean ok = checkContents(folder);
					if (ok) 
						break;
					else 
						folder = null;
				}
			}
			
		} catch (Exception t) {
			
			GELog.error("Folder Dialog", t);
		}
		return folder;
	}


	/**
	 * dialog to choose a folder to display files from.
	 * 
	 * It is expected to have KML files in it already
	 * 
	 * @param folder Default folder.
	 * @return folder path or null if no display desired
	 */
	public String displayFolderDialog(String folder) {
		String displayFolder = null;
		try {
			if (folder != null) {
				File defaultf = new File(folder);
				if (defaultf.exists() && defaultf.isDirectory()) {
					displayFolder = folder;
				} else {
					displayFolder = null;
				}
			}
			while (true) {

				Shell shell = viewer.getControl().getShell();
				int style = SWT.APPLICATION_MODAL;
				DirectoryDialog fd = new DirectoryDialog(shell,style);
				fd.setFilterPath(displayFolder);
				fd.setText(Messages.getString("GEView.30")); //$NON-NLS-1$
				fd.setMessage(Messages.getString("GEView.34")); //$NON-NLS-1$

				displayFolder = fd.open();
				if (displayFolder !=  null) {
					if (validFolder(displayFolder)) {
						break;
					}
				} else {
					// user canceled  out
					displayFolder = null;
					break;
				}
			}  // while(true)
		} catch (Exception t) {
			GELog.error("GEView: displayFolderDialog", t);
			displayFolder = null;
		}
		return displayFolder;
	}

	
	/**
	 * Verify if folder contains KML files
	 * 
	 * @param folder
	 * @return true if contains KML files or user oks it
	 */
	private boolean validFolder(String folder) {
		boolean ok = false;
		File dir = new File(folder);
		if (dir.exists() && dir.isDirectory()) {

			File[] contents = fileList(dir);
			if (contents.length > 0) {
				ok =true;
			} else {
				// if no existing files ask
				Shell shell = viewer.getControl().getShell();
				int style = SWT.APPLICATION_MODAL|
				SWT.ICON_QUESTION|SWT.YES|SWT.NO;
				MessageBox question = new MessageBox(shell,style);

				String template = Messages.getString("GEView.33");	  //$NON-NLS-1$
				String output = String.format(template,dir.getAbsolutePath());
				question.setMessage(output);

				int ans = question.open();
				if (ans==SWT.YES) {
					ok = true;				
				}
			}							
		}

		return ok;
	}
    
	/**
	 * Check the specified folder for existing KML files
	 * and if so ask if they should be removed.
	 * 
	 * @param folder
	 * @return true if the folder can be used.
	 *   false if a new folder should be chosen.
	 */
	private boolean checkContents(String folder) {
		boolean ok = false;
		File dir = new File(folder);
		File[] contents = fileList(dir);
		if (contents.length == 0) {
			ok =true;
		} else {
			// if existing files ask
			Shell shell = viewer.getControl().getShell();
			int style = SWT.APPLICATION_MODAL|
			SWT.ICON_QUESTION|SWT.YES|SWT.NO|SWT.CANCEL;
			MessageBox question = new MessageBox(shell,style);

			String template = Messages.getString("GEView.32");					   //$NON-NLS-1$
			String output = String.format(template,dir.getAbsolutePath());
			question.setMessage(output);

			int ans = question.open();
			if (ans==SWT.YES) {

				try {
					for (File f:contents) {							
						f.delete();
					}
					ok = true;;
				} catch (Exception e) {
					GELog.error("Unable to delete KML files", e);

				}
			} else if (ans==SWT.NO) {
				// user said it was ok to not delete files
				ok = true;
			} 
		}		
		return ok;
	}
		
	/**
	 * get the list of files in the specified folder.
	 * The files will only be files with the .kml 
	 * extension and will be sorted by filename.
	 * Also netlink files will be filtered out
	 * 
	 * @param folder Directory that contains KML files to display
	 * @return array of filenames
	 */

	private File[] fileList(File folder) {

		FileFilter ff = new FileFilter() {
			public boolean accept(File f){
				if (f.getName().toLowerCase().startsWith("net")) { //$NON-NLS-1$
					return false;
				}
				if (f.getName().toLowerCase().endsWith(".kml")) { //$NON-NLS-1$
					return true;
				}
				return false;
			}
		};			

		try {						
			File[] files = folder.listFiles(ff);
			if (files == null) {
				return new File[0];
			}			
			return files;
		} catch (Exception e) {		
			GELog.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		//log("setFocus(): ");
		viewer.getControl().setFocus();
	}

	/**
	 * @return the viewer
	 */
	public ListViewer getViewer() {
		return viewer;
	}

	public void dispose() {
		GELog.debug(this,"Dispose()");
		gei.dispose();
		active = false;
	}



	/**
	 * @return the contentProvider
	 */
	public GEViewContentProvider getContentProvider() {
		return contentProvider;
	}
	
 /**
   * setup the Composite that will allow scrolling 
   * 
   * @param parent  Composite to use as parent
   * @return the composite that holds scrollable stuff.
   */
	private Composite getScrollable(Composite parent,GridData gridData) {
		
		/**
		 * Some constants we need to set preferred sizes of SWT controls
		 */	 
		final int SCROLL_MIN_LENGTH = 3000;

		final int SCROLL_MIN_HEIGTH = 10000;
		
		ScrolledComposite scrollComposite =
			new ScrolledComposite(parent, SWT.V_SCROLL
				| SWT.H_SCROLL);
		scrollComposite.setExpandHorizontal(true);
		scrollComposite.setExpandVertical(true);
		scrollComposite.setLayoutData(gridData);
		scrollComposite.setMinSize(SCROLL_MIN_LENGTH, SCROLL_MIN_HEIGTH);
		Composite control = new Composite(scrollComposite, SWT.NONE);
		
		scrollComposite.setContent(control);
		return control;
		
	}
			
	// TODO modify this to create puttons based on Aspect class
	// instead of hardcoding SEIR   
	/**
	 * Creates the array of SWT push buttons for choosing 
	 * the aspect to display. 
	 * 
	 * @param parent Parent Composite
	 * @param current  current value of Aspect
	 * @return Composit that holds the buttons.
	 */
	protected Composite createControlButtons(Composite parent, String current) {
        
		Button display = new Button(parent,SWT.PUSH);
        display.setText("Display");
        display.setToolTipText("Display current map");
        display.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					ISimulation sim = contentProvider.getCurrentSimulation();
					if (sim != null) {
						boolean ok = gei.displayMap(sim);
						if (!ok) {
							showMessage(Messages.getString("GEView.15")); //$NON-NLS-1$
						}
					} else {
						showMessage("No active Simulation");
					}
					break;
				}
			}
		});
        
		Group btnContainer = null;
		final int OFFSET = 16;
		btnContainer = new Group(parent, SWT.SHADOW_IN);
        btnContainer.setText("Select Aspect to be displayed");
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		gridLayout.makeColumnsEqualWidth = true;
		btnContainer.setLayout(gridLayout);

		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.grabExcessVerticalSpace = false;
		gridData.heightHint = STANDARD_HEIGHT + OFFSET;
		gridData.minimumHeight = STANDARD_HEIGHT + OFFSET;
		gridData.widthHint = STANDARD_LENGTH;
		gridData.minimumWidth = STANDARD_LENGTH;
		btnContainer.setLayoutData(gridData);

		// create the simulation control buttons
		// Note: these are Radio buttons even thou Push Buttons would be better
		// but stupid eclipse does not allow setting of background color 
		// for pushbuttons.
		Button b_s = new Button(btnContainer, SWT.RADIO);
		Button b_e = new Button(btnContainer, SWT.RADIO);
		Button b_i = new Button(btnContainer, SWT.RADIO);
		Button b_r = new Button(btnContainer, SWT.RADIO);
		
		
		// set alignment and background color
        b_s.setText("S");        
        b_s.setSelection( "S".equals(current) );
        b_s.setBackground(parent.getDisplay().getSystemColor(
				SWT.COLOR_BLUE));
        b_s.setForeground(parent.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));				
		b_s.setToolTipText("Suceptiple"); //$NON-NLS-1$
		b_s.setLayoutData(getButtonGridData());

		b_e.setText("E");
		b_e.setSelection( "E".equals(current) );
		b_e.setBackground(parent.getDisplay().getSystemColor(
						SWT.COLOR_YELLOW));	
		b_e.setToolTipText("Exposed"); //$NON-NLS-1$
		b_e.setLayoutData(getButtonGridData());

		b_i.setText("I");
		b_i.setSelection( "I".equals(current) );
		b_i.setBackground(parent.getDisplay().getSystemColor(
						SWT.COLOR_RED));
		b_i.setToolTipText("Infectious"); //$NON-NLS-1$
		b_i.setLayoutData(getButtonGridData());

		b_r.setText("R");
		b_r.setSelection( "R".equals(current) );
		b_r.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
		b_r.setToolTipText("Recovered"); //$NON-NLS-1$
		b_r.setLayoutData(getButtonGridData());
        
		
		
		// set event listeners for buttons
		b_s.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:					
					GEView.this.setAspect("S");					
					break;
				}
			}
		});
		b_e.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					GEView.this.setAspect("E");	
					break;
				}
			}
		});
		b_i.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					GEView.this.setAspect("I");	
					break;
				}
			}
		});
		b_r.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					GEView.this.setAspect("R");	
					break;
				}
			}
		});
		GridData btngridData = new GridData();
		btngridData.horizontalAlignment = GridData.FILL;
		btngridData.grabExcessHorizontalSpace = true;
	    btnContainer.setLayoutData(btngridData);
		return btnContainer;
	}
	/**
	 * User selected an Aspect radio button
	 * 
	 * @param aspectCode
	 */
	private void setAspect(String aspectCode) {
		GELog.debug(this,aspectCode);
		Aspect aspect = Aspect.getAspect(aspectCode);
		ISimulation sim = contentProvider.getCurrentSimulation();
		// OK if sim is null
		gei.setAspectToDisplay(sim,aspect);
		
	}
	
	/**
	 * Create a new grid data customized for the push buttons.
	 * 
	 * @return gridData the new grid data object
	 */
	protected GridData getButtonGridData() {
		GridData gridData = new GridData();
		gridData.grabExcessVerticalSpace = false;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.CENTER;
		return gridData;
	}
}