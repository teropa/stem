package org.eclipse.stem.ui.views;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;

/**
 * The interface defines a listener that get notifications about newly generated context
 * menus. Usually the listener will be a <code>ViewPart</code> that needs to register
 * the context menu so that externally defined additions to the menu will be added.
 */
public interface IContextMenuUpdatesListener {
	
	/**
	 * The method is being called when new context menu has been created.
	 * @param menuManager The new MenuManager
	 * @param selectionProvider The ISelectionProvider for the MenuManager
	 */
	public void onContextMenuUpdate(MenuManager menuManager, ISelectionProvider selectionProvider);

}
