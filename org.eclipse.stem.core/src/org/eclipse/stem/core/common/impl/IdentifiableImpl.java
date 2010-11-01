package org.eclipse.stem.core.common.impl;

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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Identifiable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.common.impl.IdentifiableImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.IdentifiableImpl#getTypeURI <em>Type URI</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.IdentifiableImpl#getDublinCore <em>Dublin Core</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IdentifiableImpl extends EObjectImpl implements
		Identifiable {


	/**
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected URI uRI = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeURI() <em>Type URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTypeURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI TYPE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeURI() <em>Type URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTypeURI()
	 * @generated
	 * @ordered
	 */
	protected URI typeURI = TYPE_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDublinCore() <em>Dublin Core</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDublinCore()
	 * @generated
	 * @ordered
	 */
	protected DublinCore dublinCore;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected IdentifiableImpl() {
		super();
		setDublinCore(CommonFactory.eINSTANCE.createDublinCore());
//		setURI(STEMURI.createURI("identifiable" + STEMURI.generateUniquePart()));
		setTypeURI(STEMURI.IDENTIFIABLE_TYPE_URI);
	} // IdentifiableImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.IDENTIFIABLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DublinCore getDublinCore() {
		return dublinCore;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetDublinCore(DublinCore newDublinCore, NotificationChain msgs) {
		DublinCore oldDublinCore = getDublinCore();
		dublinCore = newDublinCore;
		
		// A new DublinCore instance?
		if (getDublinCore() != null) {
			// Yes
			// Make sure the identifier and format URI's match the Identifiable's
			// Are they valid yet?
			if (getURI() != null && getTypeURI() != null) {
				// Yes
				getDublinCore().setIdentifier(getURI().toString());
				getDublinCore().setType(getTypeURI().toString());
			} // if 
			
		} // if 
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.IDENTIFIABLE__DUBLIN_CORE, oldDublinCore, newDublinCore);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDublinCore(DublinCore newDublinCore) {
		if (newDublinCore != dublinCore) {
			NotificationChain msgs = null;
			if (dublinCore != null)
				msgs = ((InternalEObject)dublinCore).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.IDENTIFIABLE__DUBLIN_CORE, null, msgs);
			if (newDublinCore != null)
				msgs = ((InternalEObject)newDublinCore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.IDENTIFIABLE__DUBLIN_CORE, null, msgs);
			msgs = basicSetDublinCore(newDublinCore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.IDENTIFIABLE__DUBLIN_CORE, newDublinCore, newDublinCore));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getTypeURI() {
		return typeURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * Set the type URI, but also update the DublinCore type.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setTypeURI(URI newTypeURI) {
		URI oldTypeURI = getTypeURI();
		typeURI = newTypeURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CommonPackage.IDENTIFIABLE__TYPE_URI, oldTypeURI, getTypeURI()));
		// Update DublinCore?
		if (getDublinCore() != null) {
			// Yes
			getDublinCore().setType(newTypeURI.toString());
		}
	} // setTypeURI

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean sane() {
		boolean retValue = true;

		//retValue = retValue && getURI().scheme().equals(Constants.STEM_SCHEME);
		//assert(retValue);
		
		retValue = retValue && getTypeURI().scheme().equals(Constants.STEM_TYPE_SCHEME);
		assert(retValue);
		
		// If there is dublin core then the URI's of the Identifiable and the
		// Dublin Core instance should agree.
		if (dublinCore != null) {
			final DublinCore dc = getDublinCore();
			retValue = retValue && getURI().toString().equals(dc.getIdentifier());
			assert(retValue);
		}

		// This test looks for duplicate adapters. This can occur if the
		// adapters are stateful
		// Any adapters?
		// if (retValue && eAdapters != null && eAdapters.size() > 0 ) {
		// // Yes
		// // The list of adapters shouldn't contain any duplicate adapters of
		// // the same type
		// final Set<Class> types = new HashSet<Class>();
		// for (Adapter adapter : eAdapters) {
		// types.add(adapter.getClass());
		// }
		// retValue = retValue && types.size() == eAdapters.size();
		// assert retValue;
		// } // if any adapters
		

		return retValue;
	} // sane

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getURI() {
		return uRI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * Set the URI and also update the Identifier in the dublin core instance
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setURI(URI newURI) {
		URI oldURI = getURI();
		uRI = newURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CommonPackage.IDENTIFIABLE__URI, oldURI, getURI()));
		// Update DublinCore?
		if (getDublinCore() != null) {
			// Yes
			getDublinCore().setIdentifier(newURI.toString());
		}
	} // setURI

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonPackage.IDENTIFIABLE__DUBLIN_CORE:
				return basicSetDublinCore(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.IDENTIFIABLE__URI:
				return getURI();
			case CommonPackage.IDENTIFIABLE__TYPE_URI:
				return getTypeURI();
			case CommonPackage.IDENTIFIABLE__DUBLIN_CORE:
				return getDublinCore();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonPackage.IDENTIFIABLE__URI:
				setURI((URI)newValue);
				return;
			case CommonPackage.IDENTIFIABLE__TYPE_URI:
				setTypeURI((URI)newValue);
				return;
			case CommonPackage.IDENTIFIABLE__DUBLIN_CORE:
				setDublinCore((DublinCore)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CommonPackage.IDENTIFIABLE__URI:
				setURI(URI_EDEFAULT);
				return;
			case CommonPackage.IDENTIFIABLE__TYPE_URI:
				setTypeURI(TYPE_URI_EDEFAULT);
				return;
			case CommonPackage.IDENTIFIABLE__DUBLIN_CORE:
				setDublinCore((DublinCore)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommonPackage.IDENTIFIABLE__URI:
				return URI_EDEFAULT == null ? uRI != null : !URI_EDEFAULT.equals(uRI);
			case CommonPackage.IDENTIFIABLE__TYPE_URI:
				return TYPE_URI_EDEFAULT == null ? typeURI != null : !TYPE_URI_EDEFAULT.equals(typeURI);
			case CommonPackage.IDENTIFIABLE__DUBLIN_CORE:
				return dublinCore != null;
		}
		return super.eIsSet(featureID);
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * Enforce identity semantics on equality to
	 * comply with the general EMF contract.
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public final boolean equals(Object obj) {
		return super.equals(obj);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Enforce identity semantics on hashCode to
	 * comply with the general EMF contract.
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public final int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer();
		result.append("(uRI: ");
		result.append(getURI());
		result.append(", typeURI: ");
		result.append(getTypeURI());
		result.append(')');
		return result.toString();
	}

	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Identifiable o) {
		final ComposedAdapterFactory itemProviderFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		final IItemLabelProvider lp1 = (IItemLabelProvider) itemProviderFactory.adapt(
				this, IItemLabelProvider.class);
		final IItemLabelProvider lp2 = (IItemLabelProvider) itemProviderFactory.adapt(o,
				IItemLabelProvider.class);
		return lp1.getText(this).compareTo(lp2.getText(o));
	} // compareTo

	
} // IdentifiableImpl
