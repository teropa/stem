// STEMExecutionCommandHandler.java
package org.eclipse.stem.ui.handlers;

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

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.stem.adapters.file.File;
import org.eclipse.stem.adapters.file.FileAdapterFactory;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.views.explorer.IdentifiableTreeNode;
import org.eclipse.stem.ui.widgets.RenameDialog;
import org.eclipse.stem.ui.wizards.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This class is the top-level {@link IHandler} for the STEM Rename command
 * handlers 
 */
public abstract class RefactorHandler extends AbstractHandler
		implements IHandler {
	
	/**
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent executionEvent)
			throws ExecutionException {

		
		final ISelection selection = HandlerUtil
				.getCurrentSelectionChecked(executionEvent);
		
		// Structured Selection?
		if (selection instanceof StructuredSelection) {
			// Yes
			// Iterate through everything that's in the selection and put each
			// object into the appropriate collection.
			for (final Object obj : ((StructuredSelection) selection).toList()) {
				// IExecutable executable = (IExecutable) ExecutableAdapterFactory.INSTANCE
				// .adapt(obj, IExecutable.class);
				
				File file = (File) Platform
				.getAdapterManager().getAdapter(obj, File.class); 
		
				
				// Were we successful in adapting?
				if (file != null) {
					// Yes
					doit(file);
				} // if
				else {
					// Internal error
					Activator.logError(
							"STEM Internal error rename command applied to \""
									+ obj.getClass().getName() + "\"", null);
				}
			} // for each selection
		} // if StructuredSelection

		if(selection instanceof TreeSelection) {
			TreeSelection ts = (TreeSelection)selection;
			TreePath[] paths =  ts.getPaths();
			if(paths.length > 0) {
				TreePath parent = paths[0].getParentPath();
				Object parentSeg = parent.getLastSegment();
				if(parentSeg != null) {
					IProject project = null;
					if(parentSeg instanceof IdentifiableTreeNode) { 
						project =((IdentifiableTreeNode)parentSeg).getProject();
					} if(parentSeg instanceof IProject) project = (IProject)parentSeg;
					
					try {
						project.refreshLocal(IResource.DEPTH_INFINITE, null);
					} catch(Exception e) {
						Activator.logError(e.getMessage(), e);
					}
				}
			}
			
		}
		
		return null;
	} // execute

	
	abstract void doit(File file);
	
	public static class RenameHandler  extends RefactorHandler {
		protected void doit(File file) {
			Display display = Activator.getDefault().getWorkbench().getDisplay();
			Shell shell = new Shell(display);
			RenameDialog rd = new RenameDialog(shell, SWT.PUSH, file.getResource(), Messages.getString("rename"));
			String newname = rd.open();
			if(newname != null) {
				XMIResource resource = file.getResource();
				URI oldURI = resource.getURI();
				URI oldIdURI = file.getIdentifiable().getURI();
				String s_newURI = oldURI.toString().substring(0, oldURI.toString().indexOf(oldURI.lastSegment()));
				String s_newIdURI = oldIdURI.toString().substring(0, oldIdURI.toString().indexOf(oldIdURI.lastSegment()));
				
				
				URI newURI = URI.createURI(s_newURI+newname);
				URI newIDURI = URI.createURI(s_newIdURI+newname);
				
				try {
					//FileOutputStream fos = new FileOutputStream(newpath);
					ArrayList<Identifiable>newlist = new ArrayList<Identifiable>();
					Identifiable e = (Identifiable)EcoreUtil.copy(file.getIdentifiable());
					e.setURI(newIDURI);
					newlist.add(e);
					Utility.serializeIdentifiables(newlist, newURI);
//					resource.setURI(newURI);
//					resource.save(null);
					// Delete old resource
					resource.delete(null);
				} catch(Exception e) {
					Activator.logError(e.getMessage(), e);
				}
			}
		}
	}
} //  RefactorHandler
