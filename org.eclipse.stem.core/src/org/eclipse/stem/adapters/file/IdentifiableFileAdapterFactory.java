package org.eclipse.stem.adapters.file;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.stem.core.common.util.CommonAdapterFactory;

public class IdentifiableFileAdapterFactory extends CommonAdapterFactory implements FileAdapterFactory {

	/**
	 * This keeps track of the root adapter factory that delegates to this
	 * adapter factory.
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link
	 * org.eclipse.emf.edit.provider.IChangeNotifier}.
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * Default Constructor
	 */
	public IdentifiableFileAdapterFactory() {
		super();
		FileAdapterFactory.INSTANCE.addAdapterFactory((AdapterFactory)this);
	}

	/**
	 * @see org.eclipse.stem.core.graph.util.GraphAdapterFactory#
	 * 	createGraphAdapter()
	 */
	@Override
	public Adapter createIdentifiableAdapter() {
		return new IdentifiableFileAdapter();
	}

	/**
	 * @see
	 * 	org.eclipse.emf.edit.provider.IChangeNotifier#addListener(org.eclipse
	 * 	.emf.edit.provider.INotifyChangedListener)
	 */
	public void addListener(final INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * @see
	 * 	org.eclipse.emf.edit.provider.IChangeNotifier#removeListener(org.eclipse
	 * 	.emf.edit.provider.INotifyChangedListener)
	 */
	public void removeListener(
			final INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#fireNotifyChanged(org.
	 * 	eclipse.emf.common.notify.Notification)
	 */
	public void fireNotifyChanged(final Notification notification) {
		changeNotifier.fireNotifyChanged(notification);
		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ComposeableAdapterFactory#
	 * 	getRootAdapterFactory()
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory
				.getRootAdapterFactory();
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ComposeableAdapterFactory#
	 * 	setParentAdapterFactory
	 * 	(org.eclipse.emf.edit.provider.ComposedAdapterFactory)
	 */
	public void setParentAdapterFactory(
			final ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * @see
	 * 	org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory
	 * 	#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == File.class || super.isFactoryForType(type);
	} // isFactoryForType

	/**
	 * @see org.eclipse.emf.edit.provider.IDisposable#dispose()
	 */
	public void dispose() {
		// Nothing
	}
	


}
