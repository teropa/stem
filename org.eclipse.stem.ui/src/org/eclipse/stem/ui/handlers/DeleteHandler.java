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

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.stem.adapters.file.File;
import org.eclipse.stem.adapters.file.FileAdapterFactory;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.views.explorer.IdentifiableTreeNode;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This class is the top-level {@link IHandler} for the STEM Delete command
 * handlers 
 */
public class DeleteHandler extends AbstractHandler
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
							"STEM Internal error delete command applied to \""
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

	/**
	 * Delete the identifiable
	 */
	protected void doit(File file) {
		try {
			file.delete();
		} catch(IOException ioe) {
			Activator.logError(ioe.getMessage(), ioe);
		}
	}
} //  DeleteHandler
