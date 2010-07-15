/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.LatticeGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lattice Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl#isUseNearestNeighbors <em>Use Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl#isUseNextNearestNeighbors <em>Use Next Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.impl.LatticeGraphGeneratorImpl#isPeriodicBoundaries <em>Periodic Boundaries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LatticeGraphGeneratorImpl extends GraphGeneratorImpl implements LatticeGraphGenerator {
	/**
	 * The default value of the '{@link #isUseNearestNeighbors() <em>Use Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseNearestNeighbors()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_NEAREST_NEIGHBORS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUseNearestNeighbors() <em>Use Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseNearestNeighbors()
	 * @generated
	 * @ordered
	 */
	protected boolean useNearestNeighbors = USE_NEAREST_NEIGHBORS_EDEFAULT;

	/**
	 * The default value of the '{@link #isUseNextNearestNeighbors() <em>Use Next Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseNextNearestNeighbors()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_NEXT_NEAREST_NEIGHBORS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseNextNearestNeighbors() <em>Use Next Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseNextNearestNeighbors()
	 * @generated
	 * @ordered
	 */
	protected boolean useNextNearestNeighbors = USE_NEXT_NEAREST_NEIGHBORS_EDEFAULT;

	/**
	 * The default value of the '{@link #isPeriodicBoundaries() <em>Periodic Boundaries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPeriodicBoundaries()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PERIODIC_BOUNDARIES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isPeriodicBoundaries() <em>Periodic Boundaries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPeriodicBoundaries()
	 * @generated
	 * @ordered
	 */
	protected boolean periodicBoundaries = PERIODIC_BOUNDARIES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LatticeGraphGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphgeneratorsPackage.Literals.LATTICE_GRAPH_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseNearestNeighbors() {
		return useNearestNeighbors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseNearestNeighbors(boolean newUseNearestNeighbors) {
		boolean oldUseNearestNeighbors = useNearestNeighbors;
		useNearestNeighbors = newUseNearestNeighbors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS, oldUseNearestNeighbors, useNearestNeighbors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseNextNearestNeighbors() {
		return useNextNearestNeighbors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseNextNearestNeighbors(boolean newUseNextNearestNeighbors) {
		boolean oldUseNextNearestNeighbors = useNextNearestNeighbors;
		useNextNearestNeighbors = newUseNextNearestNeighbors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS, oldUseNextNearestNeighbors, useNextNearestNeighbors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPeriodicBoundaries() {
		return periodicBoundaries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriodicBoundaries(boolean newPeriodicBoundaries) {
		boolean oldPeriodicBoundaries = periodicBoundaries;
		periodicBoundaries = newPeriodicBoundaries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES, oldPeriodicBoundaries, periodicBoundaries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				return isUseNearestNeighbors();
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				return isUseNextNearestNeighbors();
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				return isPeriodicBoundaries();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				setUseNearestNeighbors((Boolean)newValue);
				return;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				setUseNextNearestNeighbors((Boolean)newValue);
				return;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				setPeriodicBoundaries((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				setUseNearestNeighbors(USE_NEAREST_NEIGHBORS_EDEFAULT);
				return;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				setUseNextNearestNeighbors(USE_NEXT_NEAREST_NEIGHBORS_EDEFAULT);
				return;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				setPeriodicBoundaries(PERIODIC_BOUNDARIES_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				return useNearestNeighbors != USE_NEAREST_NEIGHBORS_EDEFAULT;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				return useNextNearestNeighbors != USE_NEXT_NEAREST_NEIGHBORS_EDEFAULT;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				return periodicBoundaries != PERIODIC_BOUNDARIES_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (useNearestNeighbors: ");
		result.append(useNearestNeighbors);
		result.append(", useNextNearestNeighbors: ");
		result.append(useNextNearestNeighbors);
		result.append(", periodicBoundaries: ");
		result.append(periodicBoundaries);
		result.append(')');
		return result.toString();
	}

} //LatticeGraphGeneratorImpl
