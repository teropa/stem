/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.graphgenerator.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage;
import org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lattice Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.impl.LatticeGraphGeneratorImpl#getXSize <em>XSize</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.impl.LatticeGraphGeneratorImpl#getYSize <em>YSize</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.impl.LatticeGraphGeneratorImpl#getUseNearestNeighbors <em>Use Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.impl.LatticeGraphGeneratorImpl#isUseNextNearestNeighbors <em>Use Next Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.impl.LatticeGraphGeneratorImpl#isPeriodicBoundaries <em>Periodic Boundaries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LatticeGraphGeneratorImpl extends GraphGeneratorImpl implements LatticeGraphGenerator {
	/**
	 * The default value of the '{@link #getXSize() <em>XSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSize()
	 * @generated
	 * @ordered
	 */
	protected static final int XSIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getXSize() <em>XSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSize()
	 * @generated
	 * @ordered
	 */
	protected int xSize = XSIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getYSize() <em>YSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYSize()
	 * @generated
	 * @ordered
	 */
	protected static final int YSIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getYSize() <em>YSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYSize()
	 * @generated
	 * @ordered
	 */
	protected int ySize = YSIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUseNearestNeighbors() <em>Use Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseNearestNeighbors()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean USE_NEAREST_NEIGHBORS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUseNearestNeighbors() <em>Use Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseNearestNeighbors()
	 * @generated
	 * @ordered
	 */
	protected Boolean useNearestNeighbors = USE_NEAREST_NEIGHBORS_EDEFAULT;

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
	protected static final boolean PERIODIC_BOUNDARIES_EDEFAULT = false;

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
		return GraphgeneratorPackage.Literals.LATTICE_GRAPH_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getXSize() {
		return xSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXSize(int newXSize) {
		int oldXSize = xSize;
		xSize = newXSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__XSIZE, oldXSize, xSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getYSize() {
		return ySize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYSize(int newYSize) {
		int oldYSize = ySize;
		ySize = newYSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__YSIZE, oldYSize, ySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getUseNearestNeighbors() {
		return useNearestNeighbors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseNearestNeighbors(Boolean newUseNearestNeighbors) {
		Boolean oldUseNearestNeighbors = useNearestNeighbors;
		useNearestNeighbors = newUseNearestNeighbors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS, oldUseNearestNeighbors, useNearestNeighbors));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS, oldUseNextNearestNeighbors, useNextNearestNeighbors));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES, oldPeriodicBoundaries, periodicBoundaries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__XSIZE:
				return getXSize();
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__YSIZE:
				return getYSize();
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				return getUseNearestNeighbors();
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				return isUseNextNearestNeighbors();
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
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
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__XSIZE:
				setXSize((Integer)newValue);
				return;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__YSIZE:
				setYSize((Integer)newValue);
				return;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				setUseNearestNeighbors((Boolean)newValue);
				return;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				setUseNextNearestNeighbors((Boolean)newValue);
				return;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
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
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__XSIZE:
				setXSize(XSIZE_EDEFAULT);
				return;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__YSIZE:
				setYSize(YSIZE_EDEFAULT);
				return;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				setUseNearestNeighbors(USE_NEAREST_NEIGHBORS_EDEFAULT);
				return;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				setUseNextNearestNeighbors(USE_NEXT_NEAREST_NEIGHBORS_EDEFAULT);
				return;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
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
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__XSIZE:
				return xSize != XSIZE_EDEFAULT;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__YSIZE:
				return ySize != YSIZE_EDEFAULT;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				return USE_NEAREST_NEIGHBORS_EDEFAULT == null ? useNearestNeighbors != null : !USE_NEAREST_NEIGHBORS_EDEFAULT.equals(useNearestNeighbors);
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				return useNextNearestNeighbors != USE_NEXT_NEAREST_NEIGHBORS_EDEFAULT;
			case GraphgeneratorPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
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
		result.append(" (xSize: "); //$NON-NLS-1$
		result.append(xSize);
		result.append(", ySize: "); //$NON-NLS-1$
		result.append(ySize);
		result.append(", useNearestNeighbors: "); //$NON-NLS-1$
		result.append(useNearestNeighbors);
		result.append(", useNextNearestNeighbors: "); //$NON-NLS-1$
		result.append(useNextNearestNeighbors);
		result.append(", periodicBoundaries: "); //$NON-NLS-1$
		result.append(periodicBoundaries);
		result.append(')');
		return result.toString();
	}

} //LatticeGraphGeneratorImpl
