package org.eclipse.stem.adapters.file;

import org.eclipse.core.runtime.IAdapterFactory;


abstract public class FileAdapterFactory implements IAdapterFactory {
	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@SuppressWarnings("unchecked")
	public Class[] getAdapterList() {
		return new Class[] { File.class };
	}
}
