package org.eclipse.stem.core.solver.impl;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.impl.IdentifiableImpl;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.core.graph.SimpleDataExchangeLabelValue;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.solver.Solver;
import org.eclipse.stem.core.solver.SolverPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.solver.impl.SolverImpl#getDecorators <em>Decorators</em>}</li>
 *   <li>{@link org.eclipse.stem.core.solver.impl.SolverImpl#isInitialized <em>Initialized</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SolverImpl extends IdentifiableImpl implements Solver {
	/**
	 * The default value of the '{@link #isInitialized() <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitialized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIALIZED_EDEFAULT = false;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SolverImpl() {
		super();
		this.setTypeURI(STEMURI.SOLVER_TYPE_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolverPackage.Literals.SOLVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Decorator> getDecorators() {
		return (EList<Decorator>)eDynamicGet(SolverPackage.SOLVER__DECORATORS, SolverPackage.Literals.SOLVER__DECORATORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecorators(EList<Decorator> newDecorators) {
		eDynamicSet(SolverPackage.SOLVER__DECORATORS, SolverPackage.Literals.SOLVER__DECORATORS, newDecorators);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInitialized() {
		return (Boolean)eDynamicGet(SolverPackage.SOLVER__INITIALIZED, SolverPackage.Literals.SOLVER__INITIALIZED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialized(boolean newInitialized) {
		eDynamicSet(SolverPackage.SOLVER__INITIALIZED, SolverPackage.Literals.SOLVER__INITIALIZED, newInitialized);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean step(STEMTime time, long timeDelta, int cycle) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void reset() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * initialize before simulation begins. Rewind/forward any population model
	 * values to the start time of the sequencer
	 * @param time
	 */
	public void initialize(STEMTime time) {
		EList<Decorator> redoList = new BasicEList<Decorator>();
		
		boolean redo = false;
		for(Decorator d:this.getDecorators()) {
			if(d instanceof IntegrationDecorator) {
				EList<DynamicLabel> labels = d.getLabelsToUpdate();
				for(DynamicLabel l:labels) {
					if(l instanceof IntegrationLabel) {
						IntegrationLabel il = (IntegrationLabel)l;
						il.reset(time);
						if(((SimpleDataExchangeLabelValue)il.getDeltaValue()).getArrivals().size() > 0 ||
								((SimpleDataExchangeLabelValue)il.getDeltaValue()).getDepartures().size() > 0)
							redo = true;
					}
				}
			}
			if(!redo)redoList.add(d);
		}
		// Fix decorators with unapplied deltas
		if(redo) {
			for(Decorator d:redoList) {
				if(d instanceof IntegrationDecorator) {
					EList<DynamicLabel> labels = d.getLabelsToUpdate();
					for(DynamicLabel l:labels) {
						if(l instanceof IntegrationLabel) {
							IntegrationLabel il = (IntegrationLabel)l;
							il.reset(time);
						}
					}
				}
			}
		}
		this.setInitialized(true);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SolverPackage.SOLVER__DECORATORS:
				return getDecorators();
			case SolverPackage.SOLVER__INITIALIZED:
				return isInitialized();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SolverPackage.SOLVER__DECORATORS:
				setDecorators((EList<Decorator>)newValue);
				return;
			case SolverPackage.SOLVER__INITIALIZED:
				setInitialized((Boolean)newValue);
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
			case SolverPackage.SOLVER__DECORATORS:
				setDecorators((EList<Decorator>)null);
				return;
			case SolverPackage.SOLVER__INITIALIZED:
				setInitialized(INITIALIZED_EDEFAULT);
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
			case SolverPackage.SOLVER__DECORATORS:
				return getDecorators() != null;
			case SolverPackage.SOLVER__INITIALIZED:
				return isInitialized() != INITIALIZED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //SolverImpl
