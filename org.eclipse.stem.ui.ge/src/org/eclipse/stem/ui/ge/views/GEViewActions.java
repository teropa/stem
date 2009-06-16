package org.eclipse.stem.ui.ge.views;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.ui.ge.Aspect;
import org.eclipse.stem.ui.ge.GEInterface;
import org.eclipse.stem.ui.ge.GELog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;


/**
 * GEViewActions: Defines and handles the actions.
 *  
 * <p> 
 * It supports a popup context window that allows 
 * a set of actions 
 * either global actions or actions on a specific simulation
 *   
 * 
 */

public class GEViewActions  {
	
	/**
	 * reference to the caller GEView class
	 */
	private GEView geView = null;
	
	/**
	 * reference to the interface class
	 */
	private GEInterface gei = null;
	/**
	 * A ListViewer that will list simulations that we 
	 * can watch. 
	 */
	private ListViewer viewer = null;
	/**
	 * reference to contentprovider for the ListViewer
	 */
	private GEViewContentProvider contentProvider = null;
	/** 
	 * actions that we can take on selected
	 * elements in the list.
	 */
	
	private Action actionStop;
	private Action actionStart;
	private Action actionMap;
	private Action actionMapNode;
	private Action actionStatus;
	/**
	 * actions that are not for a selected
	 * simulation.
	 */
	private Action actionGEStart;
	private Action actionGERestart;
	private Action actionGERun;
	private Action actionGEStop;
	
	
	private Action actionDebug;
	/**
	 * action invoked on double click
	 */
	private Action doubleClickAction= null;

		
	/* *************************************************** 
	 * Constructor
	 *****************************************************/
	/**
	 * The GEView constructor gets control when the user opens 
	 * the "View" in the current perspective.
	 * 
	 * In the GEView constructor we will create an
	 * instance of GEInterface which does all the work.
	 * @param geView reference to caller
	 * @param gei reference to GE interface 
	 * 
	 * 
	 */
	public GEViewActions(GEView geView, GEInterface gei) {
		this.geView = geView;
		this.gei = gei;			
		this.viewer = geView.getViewer();		
	    this.contentProvider = geView.getContentProvider();
	
	
		// make the popup menu actions
		//makeActions();	
		// activate the context menu 
		hookContextMenu();
		// activate doubleclick action
		//hookDoubleClickAction();
		
		
	}

	 /**
     * Make all of the popup actions.
     * 
     * actionStop - turn off logging for current simulation
     * actionStart - turn off logging for current simulation
     * actionMap - Send the KML to display the map for the
     *           current simulation.
     * actionStatus - display status
     */
	private void makeActions() {
		// ------------------------------------
		// actionStop - turn OFF logging
        // ------------------------------------
		actionStop = new Action() {
			public void run() {				
				gei.setActive(contentProvider.getCurrentSimulation(),false);
				geView.showMessage(Messages.getString("GEView.4")); //$NON-NLS-1$
			}
		};
		actionStop.setText(Messages.getString("GEView.5")); //$NON-NLS-1$
		actionStop.setToolTipText(Messages.getString("GEView.6")); //$NON-NLS-1$
		actionStop.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		 ------------------------------------
        //	actionStart - turn ON logging
//		 ------------------------------------
		actionStart = new Action() {
			public void run() {								
				String logFolder = geView.verifyFolder(GEPreferencePage.getFolder());
				if (logFolder  == null) 
					return;
				else 
					GEPreferencePage.setFolder(logFolder);
				
				//showMessage(String.format("GoogleEarth logging ON. To: %s",fn);
				boolean ok = gei.setActive(contentProvider.getCurrentSimulation(),true);
				if (!ok) {
					geView.showMessage(gei.getErrorMessage());
				} else {
					geView.showMessage(String.format("GoogleEarth logging ON. To: %s",logFolder));
				}
			}
		};
		actionStart.setText(Messages.getString("GEView.7")); //$NON-NLS-1$
		actionStart.setToolTipText(Messages.getString("GEView.8")); //$NON-NLS-1$
		actionStart.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
// **************************************************************************
//		 ------------------------------------
//		actionGEStart - launch an empty control.kml to start GE
//		 ------------------------------------
		actionGEStart = new Action() {
			public void run() {
				gei.startGE();
				
			}
		};
		actionGEStart.setText(Messages.getString("GEView.9")); //$NON-NLS-1$
		actionGEStart.setToolTipText(Messages.getString("GEView.10")); //$NON-NLS-1$
		actionGEStart.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		 ------------------------------------
//		actionGERestart - process a restart of the GE app
//		 ------------------------------------
		actionGERestart = new Action() {
			public void run() {
				gei.restartGE();
				
			}
		};
		actionGERestart.setText(Messages.getString("GEView.9a")); //$NON-NLS-1$
		actionGERestart.setToolTipText(Messages.getString("GEView.10a")); //$NON-NLS-1$
		actionGERestart.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

//		 ------------------------------------
//		actionGERun - launch control.kml to start GE reading KML
//		 ------------------------------------
		actionGERun = new Action() {
			public void run() {
				String folder = GEPreferencePage.getFolder();
				folder = geView.displayFolderDialog(folder);
				if (folder != null) {
					boolean ok = gei.runGE(folder);
					if (!ok) {						
						geView.showMessage(gei.getErrorMessage());
					}
				}
				
			}
		};
		actionGERun.setText(Messages.getString("GEView.11")); //$NON-NLS-1$
		actionGERun.setToolTipText(Messages.getString("GEView.12")); //$NON-NLS-1$
		actionGERun.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		 ------------------------------------
        //	actionGEStop - stop any active GoogleEarth networklink
		//  It will not actually stop GE 
//		 ------------------------------------
		actionGEStop = new Action() {
			public void run() {
				gei.stopGE();
				
			}
		};
		actionGEStop.setText(Messages.getString("GEView.13")); //$NON-NLS-1$
		actionGEStop.setToolTipText(Messages.getString("GEView.14")); //$NON-NLS-1$
		actionGEStop.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));		
		
        //------------------------------------
		// actionMap - display current map in GoogleEarth 
        //------------------------------------
		actionMap = new Action() {
			public void run() {

				boolean ok = gei.displayMap(contentProvider.getCurrentSimulation());
				if (!ok) {
					geView.showMessage(Messages.getString("GEView.15")); //$NON-NLS-1$
				}
			}
		};
		
		actionMap.setText(Messages.getString("GEView.16")); //$NON-NLS-1$
		actionMap.setToolTipText(Messages.getString("GEView.17")); //$NON-NLS-1$
		actionMap.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

//		 ------------------------------------
//		 actionMapNode - display Node in current map in GoogleEarth
//		 ------------------------------------
		actionMapNode = new Action() {
			public void run() {
				String area = null;
				String adminFile = null;
				String search = null;

				DisplayAreaDialog input = new DisplayAreaDialog(
						Display.getCurrent().getActiveShell());
                
				
                boolean done = false;
                while (!done) {
                	int rc = input.open();
                	if (rc == IDialogConstants.OK_ID ||
                		  rc == IDialogConstants.PROCEED_ID	) {
                		adminFile = input.getAdminFile();
                		search = input.getSearch().trim();
                		boolean clear = input.isClear();
                		Aspect a = gei.getAspectToDisplay(contentProvider.getCurrentSimulation());
        				GELog.debug(this,"Display: "+area+ " aspect: "+a.toString());
        				boolean ok = gei.displayArea(adminFile,search,clear);
        				if (!ok) {
        					geView.showMessage(Messages.getString("GEView.15n")+"\n"+
        							gei.getErrorMessage()); 
        					
        				} else if (rc == IDialogConstants.OK_ID) {                 		
                    		done = true;
                    	}
                	} else if (rc == IDialogConstants.CANCEL_ID) {
                		done = true;
                    }
                }
				
			}
		};
			
		actionMapNode.setText(Messages.getString("GEView.16n")); //$NON-NLS-1$
		actionMapNode.setToolTipText(Messages.getString("GEView.17n")); //$NON-NLS-1$
		actionMapNode.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
//		 ------------------------------------
//		 actionStatus - display status
//		 ------------------------------------
		actionStatus = new Action() {
			public void run() {
				boolean save = GELog.DEBUG;
				GELog.DEBUG = true;
				gei.displayStatus();
				GELog.DEBUG = save;
			}
		};
		actionStatus.setText(Messages.getString("GEView.18")); //$NON-NLS-1$
		actionStatus.setToolTipText(Messages.getString("GEView.19") ); //$NON-NLS-1$
		actionStatus.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		 ------------------------------------
		//		 actionDebug - Flip DEBUG status 
//		 ------------------------------------
		actionDebug = new Action() {
			public void run() {
		      if (GELog.DEBUG) {				
				  GELog.debug(this, "Turning DEBUG off");
				  GELog.DEBUG = false; // flip status
		      } else {
		    	  GELog.DEBUG = true; // flip status  
		    	  GELog.debug(this, "Turned DEBUG on");
		      }
			}
		};
		// show what it will be changed to.
		if (GELog.DEBUG) {
		    actionDebug.setText(Messages.getString("GEView.20Off")); //$NON-NLS-1$
		} else {
			actionDebug.setText(Messages.getString("GEView.20On")); //$NON-NLS-1$
		}
		actionDebug.setToolTipText(Messages.getString("GEView.21") ); //$NON-NLS-1$
		actionDebug.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
        // actionDisplay* - specify if we should display S E I R
        //        (susceptible , Exposed, Infectious, Recovered  

	}
	
	
	
	/**
	 * The following sets up a popup menu that can 
	 * be used to turn on and off the generation of
	 * KML files and display the status  
	 * In the future, other commands could be implemented.
	 * 
	 *
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("GoogleEarth"); //$NON-NLS-1$
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				makeActions();
				fillContextMenu(manager);
			}
		});
		//Shell shell = viewer.getControl().getShell();
		
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		menuMgr.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		viewer.getControl().setMenu(menu);
		geView.getSite().registerContextMenu(menuMgr, viewer);
	}


    /**
     * setup the Popup actions 
     * This is called at the time the popup is requested
     * so the resulting popup is customized based on the status. 
     * For example, if the Logging option is ON then the 
     * action generated will turn it OFF. 
     * 
     * @param manager
     */
	private void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		ISimulation sim = contentProvider.getCurrentSimulation();
		if ( sim != null) {
			if (gei.isActive(sim)) {
				actionStop.setEnabled(true);
		        manager.add(actionStop);  // stop
		        actionStart.setEnabled(false);
		        manager.add(actionStart);
		        
		       
			} else { 
				actionStop.setEnabled(false);
		        manager.add(actionStop);  // stop
		        actionStart.setEnabled(true);
		        manager.add(actionStart);  // start
			}
			manager.add(actionMap);  // map
			
		}
		manager.add(actionMapNode);  // map
		manager.add(actionStatus);  // status
		manager.add(new Separator());
		manager.add(actionDebug);  // Display Debug
		manager.add(new Separator());
		manager.add(actionGEStart);  // Start GE
		manager.add(actionGERestart);  // ReStart GE
		manager.add(actionGERun);  // Display KML in GE
		manager.add(actionGEStop);  // Stop GE display
//		manager.add(new Separator());
//		MenuManager displayMenu = new MenuManager(Messages.getString("GEView.2"),
//				Messages.getString("GEView.3")); //$NON-NLS-1$ //$NON-NLS-2$
//		Map<String,Aspect> mapAspects = Aspect.getMap();
//		for (Map.Entry<String,Aspect> entry : mapAspects.entrySet() ) {
//			displayMenu.add(actionAspectDisplay(sim,entry.getValue()) );
//		}
//
//
//		manager.add(displayMenu);
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
//	/**
//	 * 
//	 * @param aspect
//	 * @return Action to be added to popup menu
//	 */
//private Action actionAspectDisplay(ISimulation sim,final Aspect aspect) {
//	 
//	  Action action = new Action() {
//			public void run() {								
//				gei.setAspectToDisplay(contentProvider.getCurrentSimulation(),aspect);				
//			}
//		};
//		String template = Messages.getString("GEView.22");//$NON-NLS-1$
//		action.setText(String.format(template, aspect.getName() )); 
//		action.setChecked(false);
//		if (sim != null) {
//			if ( gei.getAspectToDisplay(sim)==aspect)
//				action.setChecked(true);
//		} else {
//			if (gei.getDefaultAspect()==aspect) 		
//				action.setChecked(true);
//		}
//			
//	  return action;
//	}	
   
	
	@SuppressWarnings("unused") //$NON-NLS-1$
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	




}