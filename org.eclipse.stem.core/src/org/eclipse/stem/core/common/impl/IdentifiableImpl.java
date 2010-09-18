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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
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
	 * The default value of the '{@link #getTypeURI() <em>Type URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTypeURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI TYPE_URI_EDEFAULT = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DublinCore getDublinCore() {
		return (DublinCore)eDynamicGet(CommonPackage.IDENTIFIABLE__DUBLIN_CORE, CommonPackage.Literals.IDENTIFIABLE__DUBLIN_CORE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetDublinCore(DublinCore newDublinCore, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newDublinCore, CommonPackage.IDENTIFIABLE__DUBLIN_CORE, msgs);
		// A new DublinCore instance?
		if (newDublinCore != null) {
			// Yes
			adoptDublinCore(newDublinCore);			
		} // if 
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDublinCore(DublinCore newDublinCore) {
		eDynamicSet(CommonPackage.IDENTIFIABLE__DUBLIN_CORE, CommonPackage.Literals.IDENTIFIABLE__DUBLIN_CORE, newDublinCore);
		// A new DublinCore instance?
		if (newDublinCore != null) {
			// Yes
			adoptDublinCore(newDublinCore);
		} // if
	}

	private void adoptDublinCore(DublinCore newDublinCore) {
		// Make sure the identifier and format URI's match the Identifiable's
		// Are they valid yet?
		if (getURI() != null && getTypeURI() != null) {
			// Yes
			newDublinCore.setIdentifier(getURI().toString());
			newDublinCore.setType(getTypeURI().toString());
		} // if 
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getTypeURI() {
		return (URI)eDynamicGet(CommonPackage.IDENTIFIABLE__TYPE_URI, CommonPackage.Literals.IDENTIFIABLE__TYPE_URI, true, true);
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
		eDynamicSet(CommonPackage.IDENTIFIABLE__TYPE_URI, CommonPackage.Literals.IDENTIFIABLE__TYPE_URI, newTypeURI);
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
		if (getDublinCore() != null) {
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
		return (URI)eDynamicGet(CommonPackage.IDENTIFIABLE__URI, CommonPackage.Literals.IDENTIFIABLE__URI, true, true);
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
		eDynamicSet(CommonPackage.IDENTIFIABLE__URI, CommonPackage.Literals.IDENTIFIABLE__URI, newURI);
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
				return URI_EDEFAULT == null ? getURI() != null : !URI_EDEFAULT.equals(getURI());
			case CommonPackage.IDENTIFIABLE__TYPE_URI:
				return TYPE_URI_EDEFAULT == null ? getTypeURI() != null : !TYPE_URI_EDEFAULT.equals(getTypeURI());
			case CommonPackage.IDENTIFIABLE__DUBLIN_CORE:
				return getDublinCore() != null;
		}
		return super.eIsSet(featureID);
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
