package org.eclipse.stem.adapters.file;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;


public interface FileAdapterFactory extends ComposeableAdapterFactory,
IChangeNotifier, IDisposable{

	FileProviderAdapterFactoryImpl INSTANCE = new FileProviderAdapterFactoryImpl();

	/**
	 * This class is extended by classes that provide time values of {@link
	 * Identifiables}.
	 */ 
	public class FileProviderAdapterFactoryImpl extends ComposedAdapterFactory implements FileAdapterFactory {
		/**
		 * @see org.eclipse.emf.edit.provider.ComposedAdapterFactory#
		 * 	isFactoryForType(java.lang.Object)
		 */
		@Override
		public boolean isFactoryForType(Object type) {
			return type == File.class;
		} // isFactoryForType
	} 

}
