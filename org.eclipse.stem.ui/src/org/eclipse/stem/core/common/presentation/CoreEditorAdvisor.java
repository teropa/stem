package org.eclipse.stem.core.common.presentation;

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
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.perspectives.Simulation;
import org.eclipse.stem.ui.preferences.STEMPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.IDEInternalWorkbenchImages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.model.WorkbenchAdapterBuilder;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.osgi.framework.Bundle;


/**
 * Customized {@link WorkbenchAdvisor} for the RCP application.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public final class CoreEditorAdvisor extends WorkbenchAdvisor {
	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key) {
		return CoreEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key, Object s1) {
		return org.eclipse.stem.core.common.presentation.CoreEditorPlugin.INSTANCE.getString(key, new Object [] { s1 });
	}

	/**
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#initialize(org.eclipse.ui.application.IWorkbenchConfigurer)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);
		configurer.setSaveAndRestore(true);
		declareWorkbenchImages();
	}

	/**
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#getDefaultPageInput()
	 * 	See <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=145233">bug
	 * 	145233</a>
	 */
	@Override
	public IAdaptable getDefaultPageInput() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		return root;
	}

	
	/**
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#preStartup()
	 */
	@Override
	public void preStartup() {
		WorkbenchAdapterBuilder.registerAdapters();
	}


//	/**
//	 * This class is used to enable using the Common Navigator Framework in an
//	 * RCP application. See <a
//	 * href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=145233">bug
//	 * 145233</a>
//	 */
//	public static class NavigatorRoot implements IAdaptable,
//			IPersistableElement, IElementFactory {
//	
//		/**
//		 * Constructor
//		 */
//		public NavigatorRoot() {
//		}
//
//		/**
//		 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
//		 */
//		public Object getAdapter(Class adapter) {
//			Object retValue = null;
//			if (adapter == IPersistableElement.class) {
//				// Yes
//				retValue = this;
//			} // if 
//			else if (adapter == IWorkbenchAdapter.class) {
//				retValue = ResourcesPlugin.getWorkspace().getRoot().getAdapter(adapter);
//			} // if 
//			return retValue;
//		} // getAdapter
//	
//		/**
//		 * @see org.eclipse.ui.IPersistableElement#getFactoryId()
//		 */
//		public String getFactoryId() {
//			return "org.eclipse.stem.ui.commonNavigatorFactory";
////			return this.getClass().getCanonicalName();
//		}
//	
//		/**
//		 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
//		 */
//		public void saveState(IMemento memento) {
//			// I think what is happening here is that we don't actually save the
//			// state that the "createElement" method (below) would read, instead
//			// in createElement we just return the root of the workspace which
//			// is what we want anyway.
//			return;
//		}
//	
//		/**
//		 * @see org.eclipse.ui.IElementFactory#createElement(org.eclipse.ui.IMemento)
//		 */
//		public IAdaptable createElement(IMemento memento) {
//			return ResourcesPlugin.getWorkspace().getRoot();
//		}
//	
//	} // NavigatorRoot

	
	/**
	 * Declares all IDE-specific workbench images. This includes both "shared"
	 * images (named in {@link IDE.SharedImages}) and internal images (named in
	 * {@link org.eclipse.ui.internal.ide.IDEInternalWorkbenchImages}).
	 * 
	 * @see IWorkbenchConfigurer#declareImage
	 */
	private void declareWorkbenchImages() {

		final String ICONS_PATH = "$nl$/icons/full/";//$NON-NLS-1$
		final String PATH_ELOCALTOOL = ICONS_PATH + "elcl16/"; // Enabled //$NON-NLS-1$

		// toolbar
		// icons.
		final String PATH_DLOCALTOOL = ICONS_PATH + "dlcl16/"; // Disabled //$NON-NLS-1$
		// //$NON-NLS-1$
		// toolbar
		// icons.
		final String PATH_ETOOL = ICONS_PATH + "etool16/"; // Enabled toolbar //$NON-NLS-1$
		// //$NON-NLS-1$
		// icons.
		final String PATH_DTOOL = ICONS_PATH + "dtool16/"; // Disabled toolbar //$NON-NLS-1$
		// //$NON-NLS-1$
		// icons.
		final String PATH_OBJECT = ICONS_PATH + "obj16/"; // Model object //$NON-NLS-1$
		// //$NON-NLS-1$
		// icons
		final String PATH_WIZBAN = ICONS_PATH + "wizban/"; // Wizard //$NON-NLS-1$
		// //$NON-NLS-1$
		// icons

		Bundle ideBundle = Platform.getBundle(IDEWorkbenchPlugin.IDE_WORKBENCH);

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ETOOL_BUILD_EXEC, PATH_ETOOL
						+ "build_exec.gif", false); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ETOOL_BUILD_EXEC_HOVER,
				PATH_ETOOL + "build_exec.gif", false); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ETOOL_BUILD_EXEC_DISABLED,
				PATH_DTOOL + "build_exec.gif", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ETOOL_SEARCH_SRC, PATH_ETOOL
						+ "search_src.gif", false); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ETOOL_SEARCH_SRC_HOVER,
				PATH_ETOOL + "search_src.gif", false); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ETOOL_SEARCH_SRC_DISABLED,
				PATH_DTOOL + "search_src.gif", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ETOOL_NEXT_NAV, PATH_ETOOL
						+ "next_nav.gif", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ETOOL_PREVIOUS_NAV, PATH_ETOOL
						+ "prev_nav.gif", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_WIZBAN_NEWPRJ_WIZ, PATH_WIZBAN
						+ "newprj_wiz.png", false); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_WIZBAN_NEWFOLDER_WIZ,
				PATH_WIZBAN + "newfolder_wiz.png", false); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_WIZBAN_NEWFILE_WIZ, PATH_WIZBAN
						+ "newfile_wiz.png", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_WIZBAN_IMPORTDIR_WIZ,
				PATH_WIZBAN + "importdir_wiz.png", false); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_WIZBAN_IMPORTZIP_WIZ,
				PATH_WIZBAN + "importzip_wiz.png", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_WIZBAN_EXPORTDIR_WIZ,
				PATH_WIZBAN + "exportdir_wiz.png", false); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_WIZBAN_EXPORTZIP_WIZ,
				PATH_WIZBAN + "exportzip_wiz.png", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_WIZBAN_RESOURCEWORKINGSET_WIZ,
				PATH_WIZBAN + "workset_wiz.png", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_DLGBAN_SAVEAS_DLG, PATH_WIZBAN
						+ "saveas_wiz.png", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_DLGBAN_QUICKFIX_DLG, PATH_WIZBAN
						+ "quick_fix.png", false); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle, IDE.SharedImages.IMG_OBJ_PROJECT,
				PATH_OBJECT + "prj_obj.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, PATH_OBJECT
						+ "cprj_obj.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle, IDE.SharedImages.IMG_OPEN_MARKER,
				PATH_ELOCALTOOL + "gotoobj_tsk.gif", true); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ELCL_QUICK_FIX_ENABLED,
				PATH_ELOCALTOOL + "smartmode_co.gif", true); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_DLCL_QUICK_FIX_DISABLED,
				PATH_DLOCALTOOL + "smartmode_co.gif", true); //$NON-NLS-1$

		// task objects
		// declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_HPRIO_TSK,
		// PATH_OBJECT+"hprio_tsk.gif");
		// declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_MPRIO_TSK,
		// PATH_OBJECT+"mprio_tsk.gif");
		// declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_LPRIO_TSK,
		// PATH_OBJECT+"lprio_tsk.gif");

		declareWorkbenchImage(ideBundle, IDE.SharedImages.IMG_OBJS_TASK_TSK,
				PATH_OBJECT + "taskmrk_tsk.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle, IDE.SharedImages.IMG_OBJS_BKMRK_TSK,
				PATH_OBJECT + "bkmrk_tsk.gif", true); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_OBJS_COMPLETE_TSK, PATH_OBJECT
						+ "complete_tsk.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_OBJS_INCOMPLETE_TSK, PATH_OBJECT
						+ "incomplete_tsk.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_OBJS_WELCOME_ITEM, PATH_OBJECT
						+ "welcome_item.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_OBJS_WELCOME_BANNER, PATH_OBJECT
						+ "welcome_banner.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_OBJS_ERROR_PATH, PATH_OBJECT
						+ "error_tsk.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_OBJS_WARNING_PATH, PATH_OBJECT
						+ "warn_tsk.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_OBJS_INFO_PATH, PATH_OBJECT
						+ "info_tsk.gif", true); //$NON-NLS-1$

		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_LCL_FLAT_LAYOUT, PATH_ELOCALTOOL
						+ "flatLayout.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_LCL_HIERARCHICAL_LAYOUT,
				PATH_ELOCALTOOL + "hierarchicalLayout.gif", true); //$NON-NLS-1$
		declareWorkbenchImage(ideBundle,
				IDEInternalWorkbenchImages.IMG_ETOOL_PROBLEM_CATEGORY,
				PATH_ETOOL + "problem_category.gif", true); //$NON-NLS-1$
	
		// synchronization indicator objects
		// declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_WBET_STAT,
		// PATH_OVERLAY+"wbet_stat.gif");
		// declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_SBET_STAT,
		// PATH_OVERLAY+"sbet_stat.gif");
		// declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_CONFLICT_STAT,
		// PATH_OVERLAY+"conflict_stat.gif");

		// content locality indicator objects
		// declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_NOTLOCAL_STAT,
		// PATH_STAT+"notlocal_stat.gif");
		// declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_LOCAL_STAT,
		// PATH_STAT+"local_stat.gif");
		// declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_FILLLOCAL_STAT,
		// PATH_STAT+"filllocal_stat.gif");
	}

	/**
	 * Declares an IDE-specific workbench image.
	 * 
	 * @param symbolicName
	 *            the symbolic name of the image
	 * @param path
	 *            the path of the image file; this path is relative to the base
	 *            of the IDE plug-in
	 * @param shared
	 *            <code>true</code> if this is a shared image, and
	 *            <code>false</code> if this is not a shared image
	 * @see IWorkbenchConfigurer#declareImage
	 */
	private void declareWorkbenchImage(Bundle ideBundle, String symbolicName,
			String path, boolean shared) {
		URL url = FileLocator.find(ideBundle, new Path(path), null);
		ImageDescriptor desc = ImageDescriptor.createFromURL(url);
		getWorkbenchConfigurer().declareImage(symbolicName, desc, shared);
	}
	
	
	/**
	 * RCP's application
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Application implements IApplication {
		/**
		 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Object start(IApplicationContext context) throws Exception {
			WorkbenchAdvisor workbenchAdvisor = new CoreEditorAdvisor();
			Display display = PlatformUI.createDisplay();
			try {
				int returnCode = PlatformUI.createAndRunWorkbench(display, workbenchAdvisor);
				if (returnCode == PlatformUI.RETURN_RESTART) {
					return IApplication.EXIT_RESTART;
				}
				else {
					return IApplication.EXIT_OK;
				}
			}
			finally {
				display.dispose();
			}
		}

		/**
		 * @see org.eclipse.equinox.app.IApplication#stop()
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void stop() {
			// Do nothing.
		}
	}

	/**
	 * RCP's perspective
	 * <!-- begin-user-doc -->
	 * NOT USED
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Perspective implements IPerspectiveFactory {
		/**
		 * Perspective ID
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final String ID_PERSPECTIVE = "org.eclipse.stem.core.common.presentation.CoreEditorAdvisorPerspective"; //$NON-NLS-1$

		/**
		 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void createInitialLayout(IPageLayout layout) {
			layout.setEditorAreaVisible(true);
			layout.addPerspectiveShortcut(ID_PERSPECTIVE);

			IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, (float)0.66, layout.getEditorArea()); //$NON-NLS-1$
			right.addView(IPageLayout.ID_OUTLINE);

			IFolderLayout bottonRight = layout.createFolder("bottonRight", IPageLayout.BOTTOM, (float)0.60, "right"); //$NON-NLS-1$ //$NON-NLS-2$
			bottonRight.addView(IPageLayout.ID_PROP_SHEET);
		}
	}
	
	/**
	 * RCP's window advisor
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class WindowAdvisor extends WorkbenchWindowAdvisor {
		/**
		 * @see WorkbenchWindowAdvisor#WorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchWindowConfigurer)
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public WindowAdvisor(IWorkbenchWindowConfigurer configurer) {
			super(configurer);
		}
		
		/**
		 * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#preWindowOpen()
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		public void preWindowOpen() {
			IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
			configurer.setInitialSize(new Point(1024, 768));
			configurer.setShowCoolBar(true);
			configurer.setShowStatusLine(true);
			configurer.setShowFastViewBars(true);
			configurer.setShowProgressIndicator(true);
			configurer.setShowPerspectiveBar(true);
		} // preWindowOpen
		
		/**
		 * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#preWindowShellClose()
		 */
		@Override
		public boolean preWindowShellClose() {
			try {
				//save the full workspace before quit
				ResourcesPlugin.getWorkspace().save(true, null);
			} catch (final CoreException e) {
				Activator.logError("Failed to save workspace before quitting", e);
			}
			return true;
		}

		/**
		 * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#createActionBarAdvisor(org.eclipse.ui.application.IActionBarConfigurer)
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
			return new WindowActionBarAdvisor(configurer);
		}
	}

	/**
	 * RCP's action bar advisor
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class WindowActionBarAdvisor extends ActionBarAdvisor {
		/**
		 * @see ActionBarAdvisor#ActionBarAdvisor(org.eclipse.ui.application.IActionBarConfigurer)
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public WindowActionBarAdvisor(IActionBarConfigurer configurer) {
			super(configurer);
		}
		
		/**
		 * @see org.eclipse.ui.application.ActionBarAdvisor#fillMenuBar(org.eclipse.jface.action.IMenuManager)
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		protected void fillMenuBar(IMenuManager menuBar) {
			IWorkbenchWindow window = getActionBarConfigurer().getWindowConfigurer().getWindow();
			menuBar.add(createFileMenu(window));
			menuBar.add(createEditMenu(window));
			menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			menuBar.add(createWindowMenu(window));
			menuBar.add(createHelpMenu(window));					
		}
		
		/**
		 * Creates the 'File' menu.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		protected IMenuManager createFileMenu(IWorkbenchWindow window) {
			IMenuManager menu = new MenuManager(getString("_UI_Menu_File_label"), //$NON-NLS-1$
			IWorkbenchActionConstants.M_FILE);    
			menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));
	
			IMenuManager newMenu = new MenuManager(getString("_UI_Menu_New_label"), "new"); //$NON-NLS-1$  //$NON-NLS-2$
			newMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
	
			menu.add(newMenu);
			menu.add(new Separator());
			menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			menu.add(new Separator());
			addToMenuAndRegister(menu, ActionFactory.CLOSE.create(window));
			addToMenuAndRegister(menu, ActionFactory.CLOSE_ALL.create(window));
			menu.add(new Separator());
			addToMenuAndRegister(menu, ActionFactory.SAVE.create(window));
			addToMenuAndRegister(menu, ActionFactory.SAVE_AS.create(window));
			addToMenuAndRegister(menu, ActionFactory.SAVE_ALL.create(window));
			menu.add(new Separator());
			addToMenuAndRegister(menu, ActionFactory.IMPORT.create(window));
			addToMenuAndRegister(menu, ActionFactory.EXPORT.create(window));
			menu.add(new Separator());
			addToMenuAndRegister(menu, ActionFactory.QUIT.create(window));
			menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
			return menu;
		}

		/**
		 * Creates the 'Edit' menu.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected IMenuManager createEditMenu(IWorkbenchWindow window) {
			IMenuManager menu = new MenuManager(getString("_UI_Menu_Edit_label"), //$NON-NLS-1$
			IWorkbenchActionConstants.M_EDIT);
			menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));
	
			addToMenuAndRegister(menu, ActionFactory.UNDO.create(window));
			addToMenuAndRegister(menu, ActionFactory.REDO.create(window));
			menu.add(new GroupMarker(IWorkbenchActionConstants.UNDO_EXT));
			menu.add(new Separator());
	
			addToMenuAndRegister(menu, ActionFactory.CUT.create(window));
			addToMenuAndRegister(menu, ActionFactory.COPY.create(window));
			addToMenuAndRegister(menu, ActionFactory.PASTE.create(window));
			menu.add(new GroupMarker(IWorkbenchActionConstants.CUT_EXT));
			menu.add(new Separator());
	
			addToMenuAndRegister(menu, ActionFactory.DELETE.create(window));
			addToMenuAndRegister(menu, ActionFactory.SELECT_ALL.create(window));
			menu.add(new Separator());
	
			menu.add(new GroupMarker(IWorkbenchActionConstants.ADD_EXT));
	
			menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
			menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			return menu;
		}
	
		/**
		 * Creates the 'Window' menu.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		protected IMenuManager createWindowMenu(IWorkbenchWindow window) {
			IMenuManager menu = new MenuManager(getString("_UI_Menu_Window_label"), //$NON-NLS-1$
			IWorkbenchActionConstants.M_WINDOW);
			addToMenuAndRegister(menu, ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window));
			addToMenuAndRegister(menu, ActionFactory.OPEN_NEW_WINDOW.create(window));
		
			menu.add(ContributionItemFactory.OPEN_WINDOWS.create(window));
			menu.add(ContributionItemFactory.VIEWS_SHORTLIST.create(window));
			addToMenuAndRegister(menu, ActionFactory.PREFERENCES.create(window));
			
			menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			
			IWorkbenchAction resetPerspective = ActionFactory.RESET_PERSPECTIVE.create(window);
			addToMenuAndRegister(menu,resetPerspective);
			
			menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			
			return menu;
		} // createWindowMenu
	
		/**
		 * Creates the 'Help' menu.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		protected IMenuManager createHelpMenu(IWorkbenchWindow window) {
			IMenuManager menu = new MenuManager(getString("_UI_Menu_Help_label"), IWorkbenchActionConstants.M_HELP); //$NON-NLS-1$
			// Welcome or intro page would go here
			// Help contents would go here
			// Tips and tricks page would go here
			IWorkbenchAction helpIntro = ActionFactory.INTRO.create(window);
			IWorkbenchAction aboutAction = ActionFactory.ABOUT.create(window);			
			IWorkbenchAction contentsAction = ActionFactory.HELP_CONTENTS.create(window);
			
			menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));
			addToMenuAndRegister(menu,helpIntro);
			addToMenuAndRegister(menu,contentsAction);
			addToMenuAndRegister(menu,aboutAction);
			menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));
			menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			return menu;
		}
		
		/**
		 * Adds the specified action to the given menu and also registers the action with the
		 * action bar configurer, in order to activate its key binding.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected void addToMenuAndRegister(IMenuManager menuManager, IAction action) {
			menuManager.add(action);
			getActionBarConfigurer().registerGlobalAction(action);
		}		
	}

	/**
	 * About action for the RCP application.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class AboutAction extends WorkbenchWindowActionDelegate {
		/**
		 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void run(IAction action) {
			MessageDialog.openInformation(getWindow().getShell(), getString("_UI_About_title"), //$NON-NLS-1$
			getString("_UI_About_text")); //$NON-NLS-1$
		}
	}

	/**
	 * Open action for the objects from the Core model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class OpenAction extends WorkbenchWindowActionDelegate {
		/**
		 * Opens the editors for the files selected using the file dialog.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void run(IAction action) {
			String filePath = openFilePathDialog(getWindow().getShell(), null, SWT.OPEN);
			if (filePath != null) {
				openEditor(getWindow().getWorkbench(), URI.createFileURI(filePath));
			}
		}
	}

	/**
	 * Open URI action for the objects from the Core model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class OpenURIAction extends WorkbenchWindowActionDelegate {
		/**
		 * Opens the editors for the files selected using the LoadResourceDialog.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void run(IAction action) {
			LoadResourceAction.LoadResourceDialog loadResourceDialog = new LoadResourceAction.LoadResourceDialog(getWindow().getShell());
			if (Dialog.OK == loadResourceDialog.open()) {
				for (URI uri : loadResourceDialog.getURIs()) {
					openEditor(getWindow().getWorkbench(), uri);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static String openFilePathDialog(Shell shell, String fileExtensionFilter, int style) {
		FileDialog fileDialog = new FileDialog(shell, style);
		if (fileExtensionFilter == null) {
			fileExtensionFilter =
				"*." + getString("_UI_CommonEditorFilenameExtension") + ";" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"*." + getString("_UI_GraphEditorFilenameExtension") + ";" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"*." + getString("_UI_ModelEditorFilenameExtension") + ";" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"*." + getString("_UI_ScenarioEditorFilenameExtension") + ";" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"*." + getString("_UI_SequencerEditorFilenameExtension"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		fileDialog.setFilterExtensions(new String[]{fileExtensionFilter});
	
		fileDialog.open();
		if (fileDialog.getFileName() != null && fileDialog.getFileName().length() > 0) {
			return fileDialog.getFilterPath() + File.separator + fileDialog.getFileName();
		}
		else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static boolean openEditor(IWorkbench workbench, URI fileURI) {
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = workbenchWindow.getActivePage();
	
//		IEditorDescriptor editorDescriptor = workbench.getEditorRegistry().getDefaultEditor(fileURI.toFileString());
//		if (editorDescriptor == null) {
//			MessageDialog.openError(
//			workbenchWindow.getShell(),
//			getString("_UI_Error_title"),  //$NON-NLS-1$
//			getString("_WARN_No_Editor", fileURI.toFileString()));  //$NON-NLS-1$
//			return false;
//		}
//		else {
			try {
				final IPath path = new Path(fileURI.toPlatformString(true));
				
				IFile f = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				
				IDE.openEditor(page, f, true);
				//page.openEditor(f, editorDescriptor.getId(), true);
			}
			catch (PartInitException exception) {
				MessageDialog.openError(
				workbenchWindow.getShell(),
				getString("_UI_OpenEditorError_label"),  //$NON-NLS-1$
				exception.getMessage());
				return false;
			}
	//	}
	
		return true;
	}

	/**
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId()
	 * <!-- begin-user-doc -->
	 * set the initial Perspective 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getInitialWindowPerspectiveId() {
		//return Designer.ID_STEM_DESIGNER_PERSPECTIVE;
		return Simulation.ID_STEM_SIMULATION_PERSPECTIVE;
	}

	
	/**
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#getMainPreferencePageId()
	 */
	@Override
	public String getMainPreferencePageId() {
		return STEMPreferencePage.ID_STEM_PREFERENCE_PAGE;
	} // getMainPreferencePageId
	

	/**
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#createWorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchConfigurer)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new WindowAdvisor(configurer);
	}	
}
