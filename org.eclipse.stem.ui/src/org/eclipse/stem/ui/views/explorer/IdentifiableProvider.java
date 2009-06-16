package org.eclipse.stem.ui.views.explorer;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.Collection;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

/**
 * 
 */
public class IdentifiableProvider implements ILabelProvider,
		ITreeContentProvider {

	/**
	 * Default Constructor
	 */
	public IdentifiableProvider() {
		// Nothing
	}

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object object) {
		// Tree Selection?
		if (object instanceof ITreeSelection) {
			ITreeSelection selection = (ITreeSelection) object;
			object = selection.getFirstElement();
		}
		IItemLabelProvider  it = getLabelProvider(object);
		
		// Did we find the provider?
		if (it != null) {
			// Yes
			Object temp = it.getImage(object);
			return (temp instanceof Image) ? (Image)temp : getImageFromObject(temp);
		}
		return null;
		
	} // getImage

	 protected Image getImageFromObject(Object object)
	  {
	    return ExtendedImageRegistry.getInstance().getImage(object);
	  }
	 
	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		// Tree Selection?
		if (element instanceof ITreeSelection) {
			ITreeSelection selection = (ITreeSelection) element;
			element = selection.getFirstElement();
		}
		Object obj = getLabelProvider(element);
		String temp = ((IItemLabelProvider)obj).getText(element);
		return temp;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parentElement) {
		final Collection<?> children = getTreeContentProvider(parentElement).getChildren(parentElement);
		return children.toArray();
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		return getTreeContentProvider(element).getParent(element);
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		return getTreeContentProvider(element).hasChildren(element);
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		final Collection<?> elements = getTreeContentProvider(inputElement).getElements(inputElement);
		return elements.toArray();
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 *      .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@SuppressWarnings("unused")
	public void inputChanged(Viewer viewer, Object oldInput,  Object newInput) {
		// Nothing
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.
	 *      jface.viewers.ILabelProviderListener)
	 */
	@SuppressWarnings("unused")
	public void addListener(ILabelProviderListener listener) {
		// Nothing
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		// Nothing
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang
	 *      .Object, java.lang.String)
	 */
	@SuppressWarnings("unused")
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@SuppressWarnings("unused")
	public void removeListener(ILabelProviderListener listener) {
		// Nothing
	}

	private ComposedAdapterFactory getAdapterFactory() {
		ComposedAdapterFactory retValue = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		return retValue;
	}

	private IItemLabelProvider getLabelProvider(final Object element) {
		return (IItemLabelProvider) getAdapterFactory().adapt(element,
				IItemLabelProvider.class);
	}

	private ITreeItemContentProvider getTreeContentProvider(final Object element) {
		return (ITreeItemContentProvider) getAdapterFactory().adapt(element,
				ITreeItemContentProvider.class);
	}
} // IdentifiableProvider
