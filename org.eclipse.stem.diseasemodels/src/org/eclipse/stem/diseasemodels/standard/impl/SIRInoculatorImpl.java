package org.eclipse.stem.diseasemodels.standard.impl;

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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.InfectorInoculatorCollection;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SIRInoculator;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SIR Inoculator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRInoculatorImpl#getInoculatedPercentage <em>Inoculated Percentage</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRInoculatorImpl#isInoculatePercentage <em>Inoculate Percentage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SIRInoculatorImpl extends SIInfectorImpl implements SIRInoculator {
	/**
	 * The default value of the '{@link #getInoculatedPercentage() <em>Inoculated Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInoculatedPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double INOCULATED_PERCENTAGE_EDEFAULT = 1.0;

	/**
	 * The default value of the '{@link #isInoculatePercentage() <em>Inoculate Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInoculatePercentage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INOCULATE_PERCENTAGE_EDEFAULT = true;

	/**
	 * OverrideThe default value of the '{@link #getInfectiousCount() <em>Infectious Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInfectiousCount()
	 * @generated NOT
	 * @ordered
	 */
	protected static final double INFECTIOUS_COUNT_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SIRInoculatorImpl() {
		super();
		if (!eIsSet(StandardPackage.SIR_INOCULATOR__INFECTIOUS_COUNT)) {
			setInfectiousCount(INFECTIOUS_COUNT_EDEFAULT);
		}
	}
	
	
	/**
	 * For the innoculator, we not only innoculate the present node but every child underneath it
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph(org.eclipse.stem.core.graph.Graph)
	 */
	@Override
	public boolean decorateGraph(STEMTime time) {
		if(this.isGraphDecorated()) return true;
		Graph graph = getGraph();
		if(graph == null && this.eContainer() instanceof InfectorInoculatorCollection) // Might be part of a collection
			graph = ((NodeDecorator)eContainer()).getGraph();
	
		// Do we need to look up the disease model from its name?
		if (getDiseaseModel() == null) {
			// Yes
			// There's a disease model out there with our name on it
			// (maybe)...let's find it
			for (Iterator<Decorator> decoratorIter = graph.getDecorators().iterator(); decoratorIter
					.hasNext();) {
				final Decorator decorator = decoratorIter.next();
				// Disease Model?
				if (decorator instanceof StandardDiseaseModel) {
					final StandardDiseaseModel diseaseModel = (StandardDiseaseModel) decorator;
					// Is this the one we're looking for?
					if (diseaseModel.getDiseaseName().equalsIgnoreCase(
							getDiseaseName())) {
						// Yes
						this.setDiseaseModel(diseaseModel);
						break;
					}
				}
			} // for each decorator
		} // if look up disease model

		// Did we find the disease model we're suppose to work for?
		if (getDiseaseModel() != null) {
			// Yes
			// Now try to find the node to be infected
			final Node parent = graph.getNode(getTargetURI());
			Set<Node> allNodes = null;
			
			if(this.isInoculatePercentage()) {
				allNodes = getAllChildren(parent);	
				allNodes.add(parent);
			} else {
				allNodes = new HashSet<Node>();
				allNodes.add(parent);
			}			

			Iterator<Node> iter = allNodes.iterator();
			while(iter!=null && iter.hasNext()) {
				Node node = iter.next();
				// Did we find the Node?
				if (node != null) {
					// Yes
					for (final Iterator<NodeLabel> labelIter = node.getLabels().iterator(); labelIter
					.hasNext();) {
						final NodeLabel nodeLabel = labelIter.next();
						// Is this a disease label?
						if (nodeLabel instanceof DiseaseModelLabel) {
							final DiseaseModelLabel diseaseModelLabel = (DiseaseModelLabel) nodeLabel;
							// Yes
							// Is it updated by this disease model?
							if (diseaseModelLabel.getDecorator() == getDiseaseModel() &&
									diseaseModelLabel.getPopulationModelLabel().getPopulationIdentifier().equals(getDiseaseModel().getPopulationIdentifier())) {
								// Yes
								doInitialization(diseaseModelLabel);
								getLabelsToInfect().add(diseaseModelLabel);
								break;
							} // if
						}
					} // for
				} // if node to infect was found�
				else {
					// No
					// The target URI was probably bad
					Activator.logError("The node to infect specified by the URI \""
							+ getTargetURI()
							+ "\" was not found.  The URI is likely incorrect.",
							null);
				} // else node not found
			}// all NODES
			
		} // if disease model found
		else {
			// No
			// The disease name was probably wrong
			Activator.logError("The disease named \"" + getDiseaseName()
					+ "\" was not found.", null);
		} // else node not found

		this.setProgress(1.0); // we're done
		return true;
	} // decorateGraph

	/**
	 * @param diseaseModelLabel
	 *            the disease model label to have its infectious value
	 *            initialized
	 */
	@Override
	protected void doInitialization(final DiseaseModelLabel diseaseModelLabel) {
		// The disease model in question must have an R state
		// if it is not some type of SIR model then we can not inoculate
		if(diseaseModelLabel instanceof SIRLabel ||
				diseaseModelLabel instanceof SEIRLabel) {
//			double currentPopulation = diseaseModelLabel.getPopulationLabel().getCurrentPopulationValue().getCount();
			SIRLabelValue sirValue = null;
			IntegrationLabel iLabel = null;
			if(diseaseModelLabel instanceof SIRLabel) {
				iLabel = (SIRLabel) diseaseModelLabel;
				sirValue = (SIRLabelValue)iLabel.getCurrentValue();
			} else if(diseaseModelLabel instanceof SEIRLabel) {
				iLabel = (SEIRLabel) diseaseModelLabel;
				sirValue = (SIRLabelValue)iLabel.getCurrentValue();
			} else {
				Activator.logError("SIRInoculatorImpl: Unknown or invalid disease model class for innoculation. ClassName= "+diseaseModelLabel.getClass().getName(),null);
			}
		
			double currentSValue = sirValue.getS();
			double currentPop = sirValue.getPopulationCount();
			
			double treated = getInoculatedPercentage();
		
			if(isInoculatePercentage() && treated > 100.0) {
				Activator.logError("Inoculated Percentage must be <= 100%. Was "+treated+" Now resetting to 100%",null);
				treated = 100.0;
			}
			
			double inoculatedNumber = 0;
			if(isInoculatePercentage())
				inoculatedNumber = currentPop*(treated/100.0);
			else inoculatedNumber = treated;
			if(inoculatedNumber > currentSValue) inoculatedNumber = currentSValue;
			
			double newSValue = currentSValue - inoculatedNumber;
			// check for round off errors
			newSValue = newSValue < 0 ? 0 : newSValue;
			inoculatedNumber = inoculatedNumber < 0 ? 0 : inoculatedNumber;
			
			final double newRValue = sirValue.getR() + inoculatedNumber;
			
		    ((SIRLabelValue)iLabel.getCurrentValue()).setS(newSValue);
			((SIRLabelValue)iLabel.getNextValue()).setS(newSValue);
			
			((SIRLabelValue)iLabel.getCurrentValue()).setR(newRValue);
			((SIRLabelValue)iLabel.getNextValue()).setR(newRValue);
			
		}else {
			// log error
			Activator.logError("Can not Inoculated an SI diesase model. Disease Model must be SIR. Check compatibility of Innoculaor for Disease Model In scenario ",null);
		}
	
	} // doInitialization
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SIR_INOCULATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInoculatedPercentage() {
		return (Double)eDynamicGet(StandardPackage.SIR_INOCULATOR__INOCULATED_PERCENTAGE, StandardPackage.Literals.SIR_INOCULATOR__INOCULATED_PERCENTAGE, true, true);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInoculatedPercentage(double newInoculatedPercentage) {
		eDynamicSet(StandardPackage.SIR_INOCULATOR__INOCULATED_PERCENTAGE, StandardPackage.Literals.SIR_INOCULATOR__INOCULATED_PERCENTAGE, newInoculatedPercentage);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInoculatePercentage() {
		return (Boolean)eDynamicGet(StandardPackage.SIR_INOCULATOR__INOCULATE_PERCENTAGE, StandardPackage.Literals.SIR_INOCULATOR__INOCULATE_PERCENTAGE, true, true);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInoculatePercentage(boolean newInoculatePercentage) {
		eDynamicSet(StandardPackage.SIR_INOCULATOR__INOCULATE_PERCENTAGE, StandardPackage.Literals.SIR_INOCULATOR__INOCULATE_PERCENTAGE, newInoculatePercentage);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.SIR_INOCULATOR__INOCULATED_PERCENTAGE:
				return getInoculatedPercentage();
			case StandardPackage.SIR_INOCULATOR__INOCULATE_PERCENTAGE:
				return isInoculatePercentage();
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
			case StandardPackage.SIR_INOCULATOR__INOCULATED_PERCENTAGE:
				setInoculatedPercentage((Double)newValue);
				return;
			case StandardPackage.SIR_INOCULATOR__INOCULATE_PERCENTAGE:
				setInoculatePercentage((Boolean)newValue);
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
			case StandardPackage.SIR_INOCULATOR__INOCULATED_PERCENTAGE:
				setInoculatedPercentage(INOCULATED_PERCENTAGE_EDEFAULT);
				return;
			case StandardPackage.SIR_INOCULATOR__INOCULATE_PERCENTAGE:
				setInoculatePercentage(INOCULATE_PERCENTAGE_EDEFAULT);
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
			case StandardPackage.SIR_INOCULATOR__INOCULATED_PERCENTAGE:
				return getInoculatedPercentage() != INOCULATED_PERCENTAGE_EDEFAULT;
			case StandardPackage.SIR_INOCULATOR__INOCULATE_PERCENTAGE:
				return isInoculatePercentage() != INOCULATE_PERCENTAGE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //SIRInoculatorImpl
