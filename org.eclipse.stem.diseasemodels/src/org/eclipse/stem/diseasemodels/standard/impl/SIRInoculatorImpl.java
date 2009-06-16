/**
 * <copyright>
 * </copyright>
 *
 * $Id: SIRInoculatorImpl.java,v 1.3 2008/12/16 23:48:30 jkaufman Exp $
 */
package org.eclipse.stem.diseasemodels.standard.impl;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
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
	 * OverrideThe default value of the '{@link #getInfectiousCount() <em>Infectious Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInfectiousCount()
	 * @generated NOT
	 * @ordered
	 */
	protected static final double INFECTIOUS_COUNT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInoculatedPercentage() <em>Inoculated Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInoculatedPercentage()
	 * @generated
	 * @ordered
	 */
	protected double inoculatedPercentage = INOCULATED_PERCENTAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SIRInoculatorImpl() {
		super();
	}
	
	
	/**
	 * For the innoculator, we not only innoculate the present node but every child underneath it
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph(org.eclipse.stem.core.graph.Graph)
	 */
	@Override
	public void decorateGraph() {

		final Graph graph = getGraph();

		// Do we need to look up the disease model from its name?
		if (diseaseModel == null) {
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
						this.diseaseModel = diseaseModel;
						break;
					}
				}
			} // for each decorator
		} // if look up disease model

		// Did we find the disease model we're suppose to work for?
		if (diseaseModel != null) {
			// Yes
			// Now try to find the node to be infected
			final Node parent = getGraph().getNode(getTargetURI());
			Set<Node> allNodes = getAllChildren(parent);
			
			allNodes.add(parent);
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
							if (diseaseModelLabel.getDecorator() == diseaseModel) {
								// Yes
								doInitialization(diseaseModelLabel);
								getLabelsToInfect().add(diseaseModelLabel);
								break;
							} // if
						}
					} // for
				} // if node to infect was found
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
			Activator.logError("The disease named \"" + diseaseName
					+ "\" was not found.", null);
		} // else node not found

		this.setProgress(1.0); // we're done
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
		if(diseaseModelLabel instanceof SIRLabel) {
			double currentPopulation = diseaseModelLabel.getPopulationLabel().getCurrentPopulationValue().getCount();
			final SIRLabel sirLabel = (SIRLabel) diseaseModelLabel;
			final SIRLabelValue sirValue = sirLabel.getCurrentSIRValue();
			double currentSValue = sirValue.getS();
			double percentTreated = getInoculatedPercentage();
			if(percentTreated > 100.0) {
				Activator.logError("InoculatedPercentage must be <= 100%. Was "+percentTreated+" Now resetting to 100%",null);
				percentTreated = 100.0;
			}
			
			double inoculatedNumber = currentSValue*(percentTreated/100.0);
			
			double newSValue = currentSValue - inoculatedNumber;
			// check for round off errors
			newSValue = newSValue < 0 ? 0 : newSValue;
			inoculatedNumber = inoculatedNumber < 0 ? 0 : inoculatedNumber;
			
			final double newRValue = sirValue.getR() + inoculatedNumber;
			
		    sirLabel.getCurrentSIRValue().setS(newSValue);
			sirLabel.getNextSIRValue().setS(newSValue);
			
			sirLabel.getCurrentSIRValue().setR(newRValue);
			sirLabel.getNextSIRValue().setR(newRValue);
			
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
		return inoculatedPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInoculatedPercentage(double newInoculatedPercentage) {
		double oldInoculatedPercentage = inoculatedPercentage;
		inoculatedPercentage = newInoculatedPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SIR_INOCULATOR__INOCULATED_PERCENTAGE, oldInoculatedPercentage, inoculatedPercentage));
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
				return new Double(getInoculatedPercentage());
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
				setInoculatedPercentage(((Double)newValue).doubleValue());
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
				return inoculatedPercentage != INOCULATED_PERCENTAGE_EDEFAULT;
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
		result.append(" (inoculatedPercentage: "); //$NON-NLS-1$
		result.append(inoculatedPercentage);
		result.append(')');
		return result.toString();
	}

} //SIRInoculatorImpl
